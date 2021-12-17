package com.example.Project_Test.purchased_item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchasedItemRepository extends JpaRepository<PurchasedItem, Long> {

}
