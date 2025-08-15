package com.simac.service;

import com.simac.entity.SparePart;

import java.util.List;
import java.util.Optional;

public interface SparePartService {
    List<SparePart> findAll();
    Optional<SparePart> findById(String id);
    Repuesto save(SparePart sparePart);
    void deleteById(String id);
}
