package com.hackerrank.stocktrades.repository;

import com.hackerrank.stocktrades.model.StockTrade;
import org.hibernate.annotations.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Integer> {

    List<StockTrade> findByTypeAndUserId(String type, Integer userId);

    List<StockTrade> findByType(String type);

    List<StockTrade> findByUserId(Integer userId);

}
