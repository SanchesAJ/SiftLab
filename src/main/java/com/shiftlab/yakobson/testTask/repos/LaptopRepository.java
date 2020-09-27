package com.shiftlab.yakobson.testTask.repos;

import com.shiftlab.yakobson.testTask.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
