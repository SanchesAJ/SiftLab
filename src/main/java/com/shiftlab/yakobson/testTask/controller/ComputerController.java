package com.shiftlab.yakobson.testTask.controller;


import com.google.gson.Gson;
import com.shiftlab.yakobson.testTask.models.Computer;
import com.shiftlab.yakobson.testTask.services.ComputerService;
import com.shiftlab.yakobson.testTask.utils.PATH;
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
    ResponseEntity<Computer> editComputer(@RequestHeader Long modelId, @RequestBody String json) {
        Computer model = gson.fromJson(json, Computer.class);

        Computer oldModel = computerService.getById(modelId);
        oldModel.editComputer(
                model.getProductName(),
                model.getPrice(),
                model.getSerialNumber(),
                model.getManufacturer(),
                model.getUnitsInStock(),
                model.getComputerType()
        );
        computerService.update(oldModel);

        return ResponseEntity.ok(oldModel);
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
