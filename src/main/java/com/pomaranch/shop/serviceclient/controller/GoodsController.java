package com.pomaranch.shop.serviceclient.controller;

import com.pomaranch.shop.serviceclient.model.Product;
import com.pomaranch.shop.serviceclient.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping
    public List<Product> getAll() {
        return goodsService.getAll();
    }
}
