package com.example.highton.domain.item.service;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.account.exception.CannotAccessException;
import com.example.highton.domain.account.service.AccountService;
import com.example.highton.domain.item.Image;
import com.example.highton.domain.item.Item;
import com.example.highton.domain.item.enums.Category;
import com.example.highton.domain.item.exception.CannotDeleteItemException;
import com.example.highton.domain.item.exception.ItemNotFoundException;
import com.example.highton.domain.item.presentation.request.CreateItemRequest;
import com.example.highton.domain.item.presentation.request.DeleteItemRequest;
import com.example.highton.domain.item.presentation.response.CreateItemResponse;
import com.example.highton.domain.item.presentation.response.FindItemDetailsResponse;
import com.example.highton.domain.item.presentation.response.FindItemListResponse;
import com.example.highton.domain.item.presentation.response.dto.ItemDto;
import com.example.highton.domain.item.repository.ItemRepository;
import com.example.highton.domain.tradedetail.repository.TradeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final TradeDetailRepository tradeDetailRepository;

    private final AccountService accountService;

    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Transactional
    public CreateItemResponse create(CreateItemRequest request) {
        Account account = accountService.getAccount();

        Item item = new Item(
                request.getPrice(),
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getSellType(),
                account
        );

        itemRepository.save(item);

        return new CreateItemResponse(item.getId());
    }

    @Transactional
    public void deleteItem(DeleteItemRequest request) {
        Account account = accountService.getAccount();
        Item item = getItem(request.getItemId());

        if (!account.getId().equals(item.getAccount().getId())) {
            throw new CannotAccessException();
        }

        if (tradeDetailRepository.findByItemId(item.getId()).isPresent()) {
            throw new CannotDeleteItemException();
        }

        itemRepository.delete(item);
    }

    public FindItemDetailsResponse findItemDetails(Long itemId) {
        Item item = getItem(itemId);
        Account account = item.getAccount();

        List<String> imageList = item.getImageList().stream()
                .map(Image::getImagePath)
                .collect(Collectors.toList());

        FindItemDetailsResponse.Seller seller = new FindItemDetailsResponse.Seller(
                account.getNickname(),
                account.getProfileImagePath()
        );

        return new FindItemDetailsResponse(
                item.getTitle(),
                item.getDescription(),
                item.getCategory(),
                item.getSellType(),
                imageList,
                item.getCreatedAt(),
                seller
        );
    }

    public FindItemListResponse findItemListByCategory(Category category) {
        List<Item> itemList = itemRepository.findAllByCategory(category);

        return getFindItemListResponse(itemList);
    }

    public FindItemListResponse findItemListByTitle(String title) {
        List<Item> itemList = itemRepository.findAllByTitleContains(title);

        return getFindItemListResponse(itemList);
    }

    private FindItemListResponse getFindItemListResponse(List<Item> itemList) {
        List<ItemDto> itemDtoList = itemList.stream()
                .map(item -> new ItemDto(
                        item.getId(),
                        item.getTitle(),
                        item.getDescription(),
                        item.getCreatedAt()
                ))
                .collect(Collectors.toList());

        return new FindItemListResponse(itemDtoList);
    }

}
