package com.example.sewer_robot_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sewer_robot_system.model.SewerInspection;
import com.example.sewer_robot_system.repository.SewerInspectionRepository;

@Service
public class SewerInspectionService {

    private final SewerInspectionRepository repository;

    public SewerInspectionService(SewerInspectionRepository repository) {
        this.repository = repository;
    }

    public SewerInspection createInspection(SewerInspection inspection) {
        return repository.save(inspection);
    }

    public List<SewerInspection> getAllInspections() {
        return repository.findAll();
    }

    public SewerInspection getInspectionById(int id) {
        return repository.findById(id).orElse(null);
    }

    public SewerInspection updateInspection(int id, SewerInspection inspection) {

        SewerInspection existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setLocation(inspection.getLocation());
            existing.setIssue(inspection.getIssue());
            existing.setStatus(inspection.getStatus());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteInspection(int id) {
        repository.deleteById(id);
    }
}

