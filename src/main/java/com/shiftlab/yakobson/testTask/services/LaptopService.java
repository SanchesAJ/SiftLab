package com.shiftlab.yakobson.testTask.services;

import com.shiftlab.yakobson.testTask.models.Laptop;
import com.shiftlab.yakobson.testTask.repos.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService implements BaseService<Laptop> {
    @Autowired
    private LaptopRepository laptopRepository;


    @Override
    public Laptop getById(Long id) {
        Optional<Laptop> Laptop = laptopRepository.findById(id);
        return Laptop.orElse(null);
    }

    @Override
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop add(Laptop model) {
        return laptopRepository.saveAndFlush(model);
    }

    @Override
    public void update(Laptop model) {
        laptopRepository.save(model);
    }

    @Override
    public void delete(Laptop model) {
        laptopRepository.delete(model);
    }

    @Override
    public void deleteAll() {
        laptopRepository.deleteAll();
    }
}
