package com.example.Project_Test.purchased_item;

import com.example.Project_Test.stock.StockRepository;
import com.example.Project_Test.user_authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class PurchasedItemService {

    private final PurchasedItemRepository purchasedItemRepository;
    private final StockRepository stockRepository;
    private final UserRepository userRepository;

    @Autowired
    public PurchasedItemService(PurchasedItemRepository purchasedItemRepository, StockRepository stockRepository, UserRepository userRepository){
        this.purchasedItemRepository = purchasedItemRepository;
        this.stockRepository = stockRepository;
        this.userRepository = userRepository;
    }

    public List<PurchasedItem> getPurchasedItems() {
        return purchasedItemRepository.findAll();
    }

    public List<PurchasedItem> addNewPurchasedItem(PurchasedItem purchasedItem){
        PurchasedItem savedPurchasedItem = purchasedItemRepository.save(purchasedItem);
        purchasedItemRepository.save(purchasedItem);
        return List.of(savedPurchasedItem);
    }

    public void deletePurchasedItem(Long purchasedItemId){
        boolean exists = purchasedItemRepository.existsById(purchasedItemId);
        if (!exists) {
            throw new IllegalStateException(
                    "purchased_item with Id " + purchasedItemId + " does not exists");
        }
        purchasedItemRepository.deleteById(purchasedItemId);
    }



}
