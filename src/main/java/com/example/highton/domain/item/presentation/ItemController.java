package com.example.highton.domain.item.presentation;

import com.example.highton.domain.item.enums.Category;
import com.example.highton.domain.item.presentation.request.CreateItemRequest;
import com.example.highton.domain.item.presentation.request.DeleteItemRequest;
import com.example.highton.domain.item.presentation.response.CreateItemResponse;
import com.example.highton.domain.item.presentation.response.FindItemDetailsResponse;
import com.example.highton.domain.item.presentation.response.FindItemListResponse;
import com.example.highton.domain.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"물건 관련 API"})
@RequiredArgsConstructor
@RequestMapping("/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "판매 물품 등록")
    @PostMapping
    public CreateItemResponse create(@RequestBody @Valid CreateItemRequest request) {
        return itemService.create(request);
    }

    @Operation(summary = "판매 물품 삭제")
    @DeleteMapping
    public void deleteItem(@RequestBody @Valid DeleteItemRequest request) {
        itemService.deleteItem(request);
    }

    @Operation(summary = "판매 물품 상세 조회")
    @GetMapping("/{item-id}")
    public FindItemDetailsResponse findItemDetails(@PathVariable("item-id") Long itemId) {
        return itemService.findItemDetails(itemId);
    }

    @Operation(summary = "판매 물품 리스트 조회")
    @GetMapping("/list")
    public FindItemListResponse findItemListByCategory(@RequestParam(required = false) Category category) {
        return itemService.findItemListByCategory(category);
    }

    @Operation(summary = "판매 물품 리스트 검색")
    @GetMapping("/search")
    public FindItemListResponse findItemListByTitle(@RequestParam(required = false) String title) {
        return itemService.findItemListByTitle(title);
    }

}
