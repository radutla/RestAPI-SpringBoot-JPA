package com.hackerrank.stocktrades.service;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockTradeService {

    @Autowired
    StockTradeRepository stockTradeRepository;

        public StockTrade create(StockTrade stockTrade){
            stockTrade.setId(find(1));
            stockTradeRepository.save(stockTrade);
            return stockTrade;
        }

        public Integer find(Integer id){
            if(!get(id).isPresent()){
               return id;
            }
            return find(id+1);
        }

        public Optional<StockTrade> get(Integer id){
            return  stockTradeRepository.findById(id);
        }

        public List<StockTrade> getBy(String type, Integer userId){

            if(isNotNullAndEmpty(type) && userId!=null){
                return stockTradeRepository.findByTypeAndUserId(type, userId);
            }

            if(isNotNullAndEmpty(type)){
                return stockTradeRepository.findByType(type);
            }
            if(userId!=null){
                return stockTradeRepository.findByUserId(userId);
            }

            return stockTradeRepository.findAll();
        }

        private boolean isNotNullAndEmpty(String type){
            return type !=null && !type.trim().isEmpty();
        }
}
