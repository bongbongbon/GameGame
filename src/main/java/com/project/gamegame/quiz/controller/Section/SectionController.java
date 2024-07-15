package com.project.gamegame.quiz.controller.Section;

import com.project.gamegame.quiz.controller.Section.request.SectionRequest;
import com.project.gamegame.quiz.controller.Section.response.SectionResponse;
import com.project.gamegame.quiz.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService sectionService;

    @PostMapping
    public ResponseEntity<SectionResponse> createSection(@RequestBody SectionRequest sectionRequest) {

        return ResponseEntity.ok(sectionService.createSection(sectionRequest));
    }


    @GetMapping
    public ResponseEntity<List<SectionResponse>> getAllSections() {
        return ResponseEntity.ok(sectionService.getAllSections());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionResponse> getSection(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(sectionService.getSection(id));
    }



}
