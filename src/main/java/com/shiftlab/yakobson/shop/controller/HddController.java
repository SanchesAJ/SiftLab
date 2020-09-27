package com.shiftlab.yakobson.shop.controller;


import com.google.gson.Gson;
import com.shiftlab.yakobson.shop.models.Hdd;
import com.shiftlab.yakobson.shop.services.HddService;
import com.shiftlab.yakobson.shop.utils.PATH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PATH.HDD)
public class HddController {

    @Autowired
    private HddService hddService;
    @Autowired
    private Gson gson;

    @RequestMapping(method = RequestMethod.POST, value = PATH.ADD)
    ResponseEntity<Hdd> addHdd(@RequestBody String json) {
        Hdd model = gson.fromJson(json, Hdd.class);
        hddService.add(model);
        return ResponseEntity.ok(model);
    }


    @RequestMapping(method = RequestMethod.PATCH, value = PATH.UPDATE)
    ResponseEntity<Hdd> editHdd(@RequestBody String json) {
        Hdd model = gson.fromJson(json, Hdd.class);
        hddService.update(model);
        return ResponseEntity.ok(model);
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETPRODUCT)
    ResponseEntity<Hdd> getHdd(@RequestBody Long modelId) {
        return ResponseEntity.ok(hddService.getById(modelId));
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETALL)
    ResponseEntity<List<Hdd>> getAllHdd() {
        return ResponseEntity.ok(hddService.findAll());
    }


}
