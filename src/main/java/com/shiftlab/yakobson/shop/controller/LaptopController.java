package com.shiftlab.yakobson.shop.controller;


import com.google.gson.Gson;
import com.shiftlab.yakobson.shop.models.Laptop;
import com.shiftlab.yakobson.shop.services.LaptopService;
import com.shiftlab.yakobson.shop.utils.PATH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PATH.LAPTOP)
public class LaptopController {

    @Autowired
    private LaptopService laptopService;
    @Autowired
    private Gson gson;

    @RequestMapping(method = RequestMethod.POST, value = PATH.ADD)
    ResponseEntity<Laptop> addLaptop(@RequestBody String json) {
        Laptop model = gson.fromJson(json, Laptop.class);
        laptopService.add(model);
        return ResponseEntity.ok(model);
    }


    @RequestMapping(method = RequestMethod.PATCH, value = PATH.UPDATE)
    ResponseEntity<Laptop> editLaptop( @RequestBody String json) {
        Laptop model = gson.fromJson(json, Laptop.class);
        laptopService.update(model);
        return ResponseEntity.ok(model);
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETPRODUCT)
    ResponseEntity<Laptop> getLaptop(@RequestBody Long modelId) {
        return ResponseEntity.ok(laptopService.getById(modelId));
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETALL)
    ResponseEntity<List<Laptop>> getAllLaptop() {
        return ResponseEntity.ok(laptopService.findAll());
    }


}
