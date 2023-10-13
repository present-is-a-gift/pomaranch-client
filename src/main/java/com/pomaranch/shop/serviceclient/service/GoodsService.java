package com.pomaranch.shop.serviceclient.service;

import com.pomaranch.shop.Goods;
import com.pomaranch.shop.GoodsListRequest;
import com.pomaranch.shop.GoodsListResponse;
import com.pomaranch.shop.GoodsRequest;
import com.pomaranch.shop.GoodsServiceGrpc;
import com.pomaranch.shop.serviceclient.model.Product;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @GrpcClient("service-goods")
    private GoodsServiceGrpc.GoodsServiceBlockingStub serviceBlockingStub;

    public List<Product> getAll() {
        GoodsListResponse response = serviceBlockingStub.getGoodsList(
                GoodsListRequest.newBuilder()
                        .setPage(1)
                        .setSize(20)
                        .setSort("hello")
                        .setDirection("desc")
                        .build()
        );

        return response.getProductsList().stream()
                .map(goods -> Product.builder()
                        .id(goods.getId())
                        .name(goods.getName())
                        .build())
                .toList();
    }

    public Product getById(Integer id) {
        Goods goods = serviceBlockingStub.getGoodsById(
                GoodsRequest.newBuilder().setId(id).build()
        );
        return Product.builder()
                .id(goods.getId())
                .name(goods.getName())
                .build();
    }
}
