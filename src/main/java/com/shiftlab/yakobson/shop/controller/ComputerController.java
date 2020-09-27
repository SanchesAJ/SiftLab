package com.shiftlab.yakobson.shop.controller;


import com.google.gson.Gson;
import com.shiftlab.yakobson.shop.models.Computer;
import com.shiftlab.yakobson.shop.services.ComputerService;
import com.shiftlab.yakobson.shop.utils.PATH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PATH.COMPUTER)
public class ComputerController {

    @Autowired
    private ComputerService computerService;
    @Autowired
    private Gson gson;

    @RequestMapping(method = RequestMethod.POST, value = PATH.ADD)
    ResponseEntity<Computer> addComputer(@RequestBody String json) {
        Computer model = gson.fromJson(json, Computer.class);
        computerService.add(model);
        return ResponseEntity.ok(model);
    }


    @RequestMapping(method = RequestMethod.PATCH, value = PATH.UPDATE)
    ResponseEntity<Computer> editComputer( @RequestBody String json) {
        Computer model = gson.fromJson(json, Computer.class);
        computerService.update(model);
        return ResponseEntity.ok(model);
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETPRODUCT)
    ResponseEntity<Computer> getComputer(@RequestBody Long modelId) {
        return ResponseEntity.ok(computerService.getById(modelId));
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETALL)
    ResponseEntity<List<Computer>> getAllComputer() {
        return ResponseEntity.ok(computerService.findAll());
    }


}
