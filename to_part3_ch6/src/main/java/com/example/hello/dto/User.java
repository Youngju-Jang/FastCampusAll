package com.example.hello.dto;

import lombok.*;

@Data   // getter + setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;
}
