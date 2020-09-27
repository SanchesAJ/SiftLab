package com.shiftlab.yakobson.shop.controller;


import com.google.gson.Gson;
import com.shiftlab.yakobson.shop.models.Screen;
import com.shiftlab.yakobson.shop.services.ScreenService;
import com.shiftlab.yakobson.shop.utils.PATH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PATH.SCREEN)
public class ScreenController {

    @Autowired
    private ScreenService screenService;
    @Autowired
    private Gson gson;

    @RequestMapping(method = RequestMethod.POST, value = PATH.ADD)
    ResponseEntity<Screen> addScreen(@RequestBody String json) {
        Screen model = gson.fromJson(json, Screen.class);
        screenService.add(model);
        return ResponseEntity.ok(model);
    }


    @RequestMapping(method = RequestMethod.PATCH, value = PATH.UPDATE)
    ResponseEntity<Screen> editScreen( @RequestBody String json) {
        Screen model = gson.fromJson(json, Screen.class);
        screenService.update(model);
        return ResponseEntity.ok(model);
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETPRODUCT)
    ResponseEntity<Screen> getScreen(@RequestBody Long modelId) {
        return ResponseEntity.ok(screenService.getById(modelId));
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH.GETALL)
    ResponseEntity<List<Screen>> getAllScreen() {
        return ResponseEntity.ok(screenService.findAll());
    }


}
