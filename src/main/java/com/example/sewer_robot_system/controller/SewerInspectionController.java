package com.example.sewer_robot_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sewer_robot_system.model.SewerInspection;
import com.example.sewer_robot_system.service.SewerInspectionService;

@RestController
@RequestMapping("/inspections")
public class SewerInspectionController {

    private final SewerInspectionService service;

    public SewerInspectionController(SewerInspectionService service) {
        this.service = service;
    }

    @PostMapping
    public SewerInspection createInspection(
            @RequestBody SewerInspection inspection) {

        return service.createInspection(inspection);
    }

    @GetMapping
    public List<SewerInspection> getAllInspections() {
        return service.getAllInspections();
    }

    @GetMapping("/{id}")
    public SewerInspection getInspectionById(@PathVariable int id) {
        return service.getInspectionById(id);
    }

    @PutMapping("/{id}")
    public SewerInspection updateInspection(
            @PathVariable int id,
            @RequestBody SewerInspection inspection) {

        return service.updateInspection(id, inspection);
    }

    @DeleteMapping("/{id}")
    public String deleteInspection(@PathVariable int id) {

        service.deleteInspection(id);

        return "Inspection deleted successfully";
    }
}