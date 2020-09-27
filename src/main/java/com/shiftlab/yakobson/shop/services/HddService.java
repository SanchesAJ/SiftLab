package com.shiftlab.yakobson.shop.services;

import com.shiftlab.yakobson.shop.models.Hdd;
import com.shiftlab.yakobson.shop.repos.HddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HddService implements BaseService<Hdd> {
    @Autowired
    private HddRepository hddRepository;


    @Override
    public Hdd getById(Long id) {
        Optional<Hdd> Hdd = hddRepository.findById(id);
        return Hdd.orElse(null);
    }

    @Override
    public List<Hdd> findAll() {
        return hddRepository.findAll();
    }

    @Override
    public void add(Hdd model) {
        hddRepository.saveAndFlush(model);
    }

    @Override
    public void update(Hdd model) {
        hddRepository.save(model);
    }

    @Override
    public void delete(Hdd model) {
        hddRepository.delete(model);
    }

    @Override
    public void deleteAll() {
        hddRepository.deleteAll();
    }
}
