package com.example.Project_Test.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/stock")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getStocks() {
        return stockService.getStocks();
    }

    @PostMapping
    public List<Stock> registerNewStock(@RequestBody Stock stock)
    {
        return stockService.addNewStock(stock);
    }

    @DeleteMapping(path = "{stockId}")
    public void deleteStock(@PathVariable("stockId") Long stockId)
    {
        stockService.deleteStock(stockId);
    }

    @PutMapping(path = "{stockId}")
    public List<Stock> updateStock(
            @PathVariable("stockId") Long stockId,
            @RequestBody Stock StockReqBody) {
        return stockService.updateStock(stockId, StockReqBody);
    }


}
