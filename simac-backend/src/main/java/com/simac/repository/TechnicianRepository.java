package com.simac.repository;

import com.simac.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, String> {
}
