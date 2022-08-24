package com.example.restaurant.db;

import com.example.restaurant.BaseTimeEntity;
import com.example.restaurant.wishlist.dto.WishListDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@NoArgsConstructor
@Getter
@Entity
public class WishList extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;                   //음식명, 장소명

    @Column(columnDefinition = "TEXT", nullable = false)
    private String category;                //카테고리
    @Column(columnDefinition = "TEXT")
    private String address;                 // 주소
    @Column(columnDefinition = "TEXT")
    private String roadAddress;             // 도로명
    @Column(columnDefinition = "TEXT")
    private String homePageLink;            //홈페이지 주소
    @Column(columnDefinition = "TEXT")
    private String imageLink;               // 음식, 가게 이미지 주소
    @Column
    private boolean isVisit;                // 방문여부
    @Column
    private int visitCount;                 // 방문 카운트
    @Column
    private LocalDateTime lastVisitDate;    // 마지막 방문 일자

    @Builder
    public WishList(Long id, String title, String category,String address,String roadAddress,String homePageLink,String imageLink,boolean isVisit, int visitCount, LocalDateTime lastVisitDate){
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

    public WishListDto toDto(){
        return WishListDto.builder()
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

    public void addVisit(){
        this.isVisit = true;
        this.visitCount += 1;
    }

}