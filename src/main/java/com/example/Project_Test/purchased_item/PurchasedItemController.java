package com.example.Project_Test.purchased_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/purchased_item")
public class PurchasedItemController {
    private final PurchasedItemService purchasedItemService;


    @Autowired
    public PurchasedItemController(PurchasedItemService purchasedItemService){
        this.purchasedItemService = purchasedItemService;
    }

    @GetMapping
    public List<PurchasedItem> getPurchasedItem(){
        return purchasedItemService.getPurchasedItems();
    }

    @PostMapping
    public List<PurchasedItem> registerNewPurchasedItem (@RequestBody PurchasedItem purchasedItem){
        return purchasedItemService.addNewPurchasedItem(purchasedItem);
    }

    @DeleteMapping(path = "{purchasedItemId}")
    public void deletePurchasedItem(@PathVariable("purchasedItemId") Long purchasedItemId){
        purchasedItemService.deletePurchasedItem(purchasedItemId);
    }
}
