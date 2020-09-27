package com.shiftlab.yakobson.testTask.services;

import com.shiftlab.yakobson.testTask.models.Computer;
import com.shiftlab.yakobson.testTask.repos.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService implements BaseService<Computer> {
    @Autowired
    private ComputerRepository computerRepository;


    @Override
    public Computer getById(Long id) {
        Optional<Computer> computer = computerRepository.findById(id);
        return computer.orElse(null);
    }

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computer add(Computer model) {
        return computerRepository.saveAndFlush(model);
    }

    @Override
    public void update(Computer model) {
        computerRepository.save(model);
    }

    @Override
    public void delete(Computer model) {
        computerRepository.delete(model);
    }

    @Override
    public void deleteAll() {
        computerRepository.deleteAll();
    }
}
