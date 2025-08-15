package com.simac.service;

import com.simac.entity.SparePart;
import com.simac.repository.SparePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparePartServiceImpl implements SparePartService {

    private final SparePartRepository sparePartRepository;

    public SparePartServiceImpl(SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }

    @Override
    public List<SparePart> findAll() {
        return sparePartRepository.findAll();
    }

    @Override
    public Optional<SparePart> findById(String id) {
        return sparePartRepository.findById(id);
    }

    @Override
    public SparePart save(SparePart sparePart) {
        return sparePartRepository.save(sparePart);
    }

    @Override
    public void deleteById(String id) {
        sparePartRepository.deleteById(id);
    }
}
