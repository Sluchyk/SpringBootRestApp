package com.example.SpringBootRestApp.service;

import com.example.SpringBootRestApp.exeptions.ShopNotFoundException;
import com.example.SpringBootRestApp.model.repository.ShopRepository;
import com.example.SpringBootRestApp.model.entity.Shop;
import com.example.SpringBootRestApp.model.entity.ShopDTO;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    public Iterable<Shop> findAll() {
        return shopRepository.findAll();
    }

    public ShopDTO findById(Long id) throws ShopNotFoundException {
        isExists(id);
        return parseToShopDTO(Objects.requireNonNull(shopRepository.findById(id).orElse(null)));
    }

    private void isExists(Long id) throws ShopNotFoundException {
        boolean isExists = shopRepository.existsById(id);
        if (!isExists) {
            throw new ShopNotFoundException("Shop with id: " + id + " not found");
        }
    }

    private ShopDTO parseToShopDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setShopId(shop.getShopId());
        shopDTO.setName(shop.getName());
        shopDTO.setLocationCity(shop.getLocationCity());
        shopDTO.setLocationStreet(shop.getLocationStreet());
        shopDTO.setWebSiteAvailable(shop.isWebSiteAvailable());
        return shopDTO;
    }
}
