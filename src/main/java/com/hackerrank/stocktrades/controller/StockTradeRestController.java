package com.hackerrank.stocktrades.controller;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.service.StockTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class StockTradeRestController {

    @Autowired
    StockTradeService stockTradeService;

    @PostMapping("/trades")
    public ResponseEntity createTrade(@RequestBody StockTrade stockTrade){

        StockTrade stockTradeCreated = stockTradeService.create(stockTrade);
        return new ResponseEntity<>(stockTrade,HttpStatus.CREATED);
    }


    @GetMapping(value = "/trades", produces = "application/json")
    public ResponseEntity getAll(@RequestParam(required = false) String type,
                                      @RequestParam(required = false) Integer userId){

        List<StockTrade> pastTrades = stockTradeService.getBy(type, userId);
        return new ResponseEntity<>(pastTrades,HttpStatus.OK);
    }


    @GetMapping(value="/trades/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        Optional<StockTrade> optionalStockTrade = stockTradeService.get(id);
        if(optionalStockTrade.isPresent()){
            return new ResponseEntity<>(optionalStockTrade.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>("No trade found" , HttpStatus.NOT_FOUND);

    }

    @PutMapping("/trades/")
    public HttpStatus put(@PathVariable String id){
        return HttpStatus.METHOD_NOT_ALLOWED;
    }

    @DeleteMapping("/trades/")
    public HttpStatus delete(@PathVariable String id){
        return HttpStatus.METHOD_NOT_ALLOWED;
    }

    @PatchMapping("/trades/")
    public HttpStatus patch(@PathVariable String id){
        return HttpStatus.METHOD_NOT_ALLOWED;
    }
}