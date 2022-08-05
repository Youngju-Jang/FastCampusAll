package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ch5_User2 {
    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ch5_User2(){
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    public ch5_User2(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // object로 활용되는 객체의 경우 >> method명에 get~~들어가는거 쓰면 안댐
    public ch5_User2 DefaultUser(){ //>>objectMapper.writeValueAsString() 쓸때 get잘못잡고 에러뜸
        return new ch5_User2("default", 0, "010-1111-2222");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
