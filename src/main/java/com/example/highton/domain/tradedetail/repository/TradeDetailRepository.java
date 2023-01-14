package com.example.highton.domain.tradedetail.repository;

import com.example.highton.domain.tradedetail.TradeDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TradeDetailRepository extends CrudRepository<TradeDetail, Long> {
    Optional<TradeDetail> findByItemId(Long itemId);
}
