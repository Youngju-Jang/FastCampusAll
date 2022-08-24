package com.example.restaurant.db;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.db.WishList;
import com.example.restaurant.db.WishListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;

    public WishListDto search(String query){

        // 지역검색
        var searchLocalReq =  new SearchLocalReq();
        searchLocalReq.setQuery(query);
        log.info("@@@@@@@ WishListService >>>>>>> {}, Sort:: {}", searchLocalReq, searchLocalReq.getSort());

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if(searchLocalRes.getTotal() >0){
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            // 그걸로 이미지검색
            var searchImageRes = naverClient.searchImage(searchImageReq);

            if(searchImageRes.getTotal() >0){
                // 결과리턴
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                var result = new WishListDto();
                result.setTitle(imageQuery);
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());
                return result;
            }
        }
        return new WishListDto();
    }

    @Transactional
    public WishListDto add(WishListDto wishListDto) {
        return wishListRepository.save(wishListDto.toEntity()).toDto();
    }

    public List<WishListDto> findAll() {
        return wishListRepository.findAll()
                .stream()
                .map(it->it.toDto())
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        wishListRepository.deleteById(id);
    }

    @Transactional
    public void addVisit(Long id){
        var wishItem = wishListRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

         wishItem.addVisit();
         //wishListRepository.save(wishItem);
        }
}