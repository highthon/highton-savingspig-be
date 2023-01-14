package com.example.highton.domain.item.presentation.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ItemDto {

    private Long id;

    private String title;

    private String firstImagePath;

    private LocalDateTime createdAt;

}
