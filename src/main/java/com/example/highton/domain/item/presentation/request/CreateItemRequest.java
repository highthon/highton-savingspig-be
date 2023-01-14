package com.example.highton.domain.item.presentation.request;

import com.example.highton.domain.item.enums.Category;
import com.example.highton.domain.item.enums.SellType;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class CreateItemRequest {

    @Size(min = 1, max = 100)
    private String title;

    @PositiveOrZero
    private Long price;

    @Size(max = 1000)
    private String description;

    @NotNull
    private List<String> imagePathList;

    @NotNull
    private Category category;

    @NotNull
    private SellType sellType;

}
