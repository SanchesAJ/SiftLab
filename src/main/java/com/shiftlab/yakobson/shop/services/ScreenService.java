package com.shiftlab.yakobson.shop.services;

import com.shiftlab.yakobson.shop.models.Screen;
import com.shiftlab.yakobson.shop.repos.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenService implements BaseService<Screen> {
    @Autowired
    private ScreenRepository ScreenRepository;


    @Override
    public Screen getById(Long id) {
        Optional<Screen> Screen = ScreenRepository.findById(id);
        return Screen.orElse(null);
    }

    @Override
    public List<Screen> findAll() {
        return ScreenRepository.findAll();
    }

    @Override
    public void add(Screen model) {
        ScreenRepository.saveAndFlush(model);
    }

    @Override
    public void update(Screen model) {
        ScreenRepository.save(model);
    }

    @Override
    public void delete(Screen model) {
        ScreenRepository.delete(model);
    }

    @Override
    public void deleteAll() {
        ScreenRepository.deleteAll();
    }
}


