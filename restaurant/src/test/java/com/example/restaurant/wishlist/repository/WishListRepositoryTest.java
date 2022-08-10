package com.example.restaurant.wishlist.repository;

import com.example.restaurant.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishlistRepository;

    private WishListEntity create(){
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setReadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }

    @Test
    public void saveTest(){
        var wishListEntity = create();
        var expected = wishlistRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }
    @Test
    public void updateTest(){
        var wishListEntity = create();
        var expected = wishlistRepository.save(wishListEntity);

        expected.setTitle("update test");
        var saveEntity = wishlistRepository.save(expected);

        Assertions.assertEquals("update test", saveEntity.getTitle());
        Assertions.assertEquals(1, wishlistRepository.listAll().size());
    }

    @Test
    public void findByIdTest(){
        var wishListEntity = create();
        wishlistRepository.save(wishListEntity);

        var expected = wishlistRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());
    }

    @Test
    public void deleteTest(){
        var wishListEntity = create();
        wishlistRepository.save(wishListEntity);

        wishlistRepository.deleteById(1);

        int count = wishlistRepository.listAll().size();

        Assertions.assertEquals(0, count);

    }
    @Test
    public void listAllTest(){
        var wishListEntity1 = create();
        wishlistRepository.save(wishListEntity1);

        var wishListEntity2 = create();
        wishlistRepository.save(wishListEntity2);

        int count = wishlistRepository.listAll().size();

        Assertions.assertEquals(2, count);
    }
}
