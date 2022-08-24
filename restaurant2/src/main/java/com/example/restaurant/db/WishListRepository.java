package com.example.restaurant.db;

import com.example.restaurant.db.WishList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WishListRepository extends JpaRepository<WishList, Long> {
}