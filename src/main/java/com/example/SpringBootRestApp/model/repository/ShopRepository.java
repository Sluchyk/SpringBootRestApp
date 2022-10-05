package com.example.SpringBootRestApp.model.repository;

import com.example.SpringBootRestApp.model.entity.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
