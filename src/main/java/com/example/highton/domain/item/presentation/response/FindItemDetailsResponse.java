package com.example.highton.domain.item.presentation.response;

import com.example.highton.domain.item.enums.Category;
import com.example.highton.domain.item.enums.SellType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class FindItemDetailsResponse {

    private String title;

    private String description;

    private Category category;

    private SellType sellType;

    private List<String> imagePathList;

    private LocalDateTime createdAt;

    private Seller seller;

    @Getter
    @AllArgsConstructor
    public static class Seller {

        private String name;

        private String imagePath;

    }

}
