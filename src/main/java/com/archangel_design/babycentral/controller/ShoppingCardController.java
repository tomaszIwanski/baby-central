package com.archangel_design.babycentral.controller;

import com.archangel_design.babycentral.entity.ShoppingCardEntity;
import com.archangel_design.babycentral.entity.ShoppingCardEntryEntity;
import com.archangel_design.babycentral.request.CreateShoppingCardEntryRequest;
import com.archangel_design.babycentral.request.CreateShoppingCardRequest;
import com.archangel_design.babycentral.service.ShoppingCardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-card")
@Api(tags = "Shopping card management")
public class ShoppingCardController {

    @Autowired
    ShoppingCardService shoppingCardService;

    @PostMapping("/create-shopping-card")
    public ShoppingCardEntity addShoppingCard(
            @RequestBody CreateShoppingCardRequest request
    ) {
        return shoppingCardService.createShoppingCard(
                request.getName()
        );
    }

    @GetMapping("/list")
    public List<ShoppingCardEntity> getList() {
        return shoppingCardService.getList();
    }

    @PostMapping("/entry/{shoppingCardId}")
    public ShoppingCardEntity createEntry(
            @PathVariable String shoppingCardId,
            @RequestBody CreateShoppingCardEntryRequest request
    ) {
        return shoppingCardService.createEntry(
                shoppingCardId,
                request.getArticleName(),
                request.getQuantity()
        );
    }

    @GetMapping("/fetch/{uuid}")
    public ShoppingCardEntity fetchShoppingCart(
            @PathVariable String uuid
    ) {
        return shoppingCardService.fetch(uuid);
    }

    @GetMapping("/toggle-purchased/{uuid}")
    public ShoppingCardEntryEntity toggleIsPurchased(
            @PathVariable String uuid
    ) {
        return shoppingCardService.toggleIsPurchased(uuid);
    }

    @PostMapping("/assign/{uuid}")
    public ShoppingCardEntity assignShoppingCard(
            @PathVariable String uuid,
            @RequestBody List<String> users
    ) {
        return shoppingCardService.assignShoppingCard(uuid, users);
    }

}
