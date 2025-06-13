package com.simac.repository;

import com.simac.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {
}
