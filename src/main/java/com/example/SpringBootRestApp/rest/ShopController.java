package com.example.SpringBootRestApp.rest;

import com.example.SpringBootRestApp.model.entity.Shop;
import com.example.SpringBootRestApp.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @SneakyThrows
    @PostMapping("/save")
    public Shop save(HttpServletRequest request) {
        BufferedReader reader = request.getReader();
        String shopJSON = reader.lines().collect(Collectors.joining());
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = objectMapper.readValue(shopJSON, Shop.class);
        return shopService.save(shop);
    }

    @SneakyThrows
    @GetMapping("/shop")
    public void getAll(HttpServletResponse response) {
        PrintWriter writer = response.getWriter();
        shopService.findAll().forEach(x -> writer.println(x.toString()));
        writer.flush();
    }
}
