package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test(){
        User user = new User();
        user.setEmail("joj@nate.com");
        user.setName("joj1043");

        User user1 = new User(null, "joj10@sss", "joj22", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("joj1111@ss", "2334");

        User user3 = User.builder()
                .name("joj11")
                .email("joj10110@sd")
                .build();
    }
}