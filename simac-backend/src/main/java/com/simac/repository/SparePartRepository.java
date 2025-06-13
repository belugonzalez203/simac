package com.simac.repository;

import com.simac.entity.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartRepository extends JpaRepository<SparePart, String> {
}
