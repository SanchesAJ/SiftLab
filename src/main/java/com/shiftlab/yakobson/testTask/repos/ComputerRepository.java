package com.shiftlab.yakobson.testTask.repos;


import com.shiftlab.yakobson.testTask.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ComputerRepository  extends JpaRepository<Computer,Long> {

}
