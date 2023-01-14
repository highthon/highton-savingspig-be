package com.example.highton.domain.item.presentation.response;

import com.example.highton.domain.item.presentation.response.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FindItemListResponse {

    private List<ItemDto> itemDtoList;

}
