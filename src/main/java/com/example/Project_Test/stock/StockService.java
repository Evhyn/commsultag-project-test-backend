package com.example.Project_Test.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public List<Stock> addNewStock(Stock stock){
        Optional<Stock> stockOptional = stockRepository
                .findStockByName(stock.getName());
        if (stockOptional.isPresent()) {
            throw new IllegalStateException("duplicate name");
        }
        stockRepository.save(stock);
        return List.of(stock);
    }
    public void deleteStock(Long stockId) {

        boolean exists = stockRepository.existsById(stockId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with Id " + stockId + " does not exists");
        }
        stockRepository.deleteById(stockId);
    }

    public List<Stock> updateStock(Long stockId, Stock StockReqBody) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalStateException(
                        "stock with id " + stockId + " does not exists"));

        String name = StockReqBody.getName();
        Integer quantity = StockReqBody.getQuantity();
        Integer price = StockReqBody.getPrice();

        if (name != null && name.length() > 0 && !Objects.equals(stock.getName(), name)) {
            stock.setName(name);
        }

        if (quantity != null && !Objects.equals(stock.getQuantity(), quantity)) {
            stock.setQuantity(quantity);
        }

        if (price != null && !Objects.equals(stock.getPrice(), price)) {
            stock.setPrice(price);
        }

        stockRepository.save(stock);
        return List.of(stock);
    }

}
