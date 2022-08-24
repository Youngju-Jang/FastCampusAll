package com.example.restaurant.wishlist.dto;


import com.example.restaurant.db.WishList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class WishListDto{

    private Long id;
    private String title;                   //음식명, 장소명
    private String category;                //카테고리
    private String address;                 // 주소
    private String roadAddress;             // 도로명
    private String homePageLink;            //홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문여부
    private int visitCount;                 // 방문 카운트
    private LocalDateTime lastVisitDate;    // 마지막 방문 일자

    public WishListDto(WishList entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.category= entity.getCategory();
        this.address = entity.getAddress();
        this.roadAddress = entity.getRoadAddress();
        this.homePageLink = entity.getHomePageLink();
        this.imageLink = entity.getImageLink();
        this.isVisit = entity.isVisit();
        this.visitCount = entity.getVisitCount();
        this.lastVisitDate = entity.getLastVisitDate();
    }

    @Builder
    public WishListDto(Long id, String title, String category,String address,String roadAddress,String homePageLink,String imageLink,boolean isVisit, int visitCount, LocalDateTime lastVisitDate){
        this.id = id;
        this.title = title;
        this.category= category;
        this.address = address;
        this.roadAddress = roadAddress;
        this.homePageLink = homePageLink;
        this.imageLink = imageLink;
        this.isVisit = isVisit;
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
    }
    public WishList toEntity(){
        return WishList.builder()
                .id(id)
                .title(title)
                .category(category)
                .address(address)
                .roadAddress(roadAddress)
                .homePageLink(homePageLink)
                .imageLink(imageLink)
                .isVisit(isVisit)
                .visitCount(visitCount)
                .lastVisitDate(lastVisitDate)
                .build();
    }
}