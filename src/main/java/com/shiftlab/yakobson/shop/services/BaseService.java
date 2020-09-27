package com.shiftlab.yakobson.shop.services;

import java.util.List;

public interface BaseService<T> {
    T getById(Long id);

    List<T> findAll();

    void add(T model);
    //в update используется save для редактирования обьекта.
    // Искренне считаю, что на фронтенде используются те же id, что и на сервере.
    // Таким образом для БД не будет разницы, что обьект только что созадн - id будут одинаковыми.
    // save  сам может определить, что редактируют существующий обьект, а не добавляют новый
    void update(T model);

    void delete(T model);

    void deleteAll();

}