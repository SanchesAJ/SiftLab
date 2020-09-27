package com.shiftlab.yakobson.testTask.controller;


import com.google.gson.Gson;
import com.shiftlab.yakobson.testTask.models.Hdd;
import com.shiftlab.yakobson.testTask.services.HddService;
import com.shiftlab.yakobson.testTask.utils.PATH;
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
    ResponseEntity<Hdd> editHdd(@RequestHeader Long modelId, @RequestBody String json) {
        Hdd model = gson.fromJson(json, Hdd.class);

        Hdd oldModel = hddService.getById(modelId);
        oldModel.editHdd(
                model.getProductName(),
                model.getPrice(),
                model.getSerialNumber(),
                model.getManufacturer(),
                model.getUnitsInStock(),
                model.getVolume()
        );
        hddService.update(oldModel);

        return ResponseEntity.ok(oldModel);
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
