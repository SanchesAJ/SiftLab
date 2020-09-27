package com.shiftlab.yakobson.shop.controllers;



import com.google.gson.Gson;
import com.shiftlab.yakobson.shop.models.*;
import com.shiftlab.yakobson.shop.services.*;
import com.shiftlab.yakobson.shop.utils.PATH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(PATH.API)
public class ProductController {

    @Autowired
    private ScreenService screenService;
    @Autowired
    private HddService hddService;
    @Autowired
    private ComputerService computerService;
    @Autowired
    private LaptopService laptopService;

    private Type current;


    @Autowired
    private Gson gson;

    //Помимо json-а с обьектом от фронтенда ожидается тип товара в path
    //Контроллер переключится с одного товара на другой.
    //Возможно такая схема будет проще в смысле добавления новых типов товара
    BaseService getService(String name){
        switch (name){
            case "hdd":{
                current = Hdd.class;
                return hddService;
            }
            case "screen":{
                current = Screen.class;
                return screenService;
            }
            case "computer":{
                current = Computer.class;
                return computerService;
            }
            case "laptop":{
                current = Laptop.class;
                return laptopService;
            }
        }
        return  null;
    }


    @RequestMapping(method = RequestMethod.POST, value = PATH.ADD+"{product}")
    ResponseEntity<Product> addProduct(@PathVariable(value="product")String productType, @RequestBody String json) {
        var service = getService(productType);
        Screen model = gson.fromJson(json, current);
        service.add(model);
        return ResponseEntity.ok(model);
    }


    @RequestMapping(method = RequestMethod.PATCH, value = PATH.UPDATE+"{product}")
    ResponseEntity<Product> editProduct( @PathVariable(value="product")String productType, @RequestBody String json) {
        var service = getService(productType);
        Screen model = gson.fromJson(json, current);
        service.update(model);
        return ResponseEntity.ok(model);
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETPRODUCT+"{product}")
    ResponseEntity<Object> getProduct(@PathVariable(value="product")String productType,@RequestBody Long modelId) {
        var service = getService(productType);
        return ResponseEntity.ok(service.getById(modelId));
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETALL+"{product}")
    ResponseEntity<List<Object>> getAllProductsByType(@PathVariable(value="product")String productType) {
        var service = getService(productType);
        return ResponseEntity.ok(service.findAll());
    }


}
