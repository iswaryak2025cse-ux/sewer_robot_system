package com.example.sewer_robot_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sewer_robot_system.model.SewerInspection;

public interface SewerInspectionRepository
        extends JpaRepository<SewerInspection, Integer> {

}
