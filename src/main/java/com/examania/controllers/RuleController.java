package com.examania.controllers;

import com.examania.entities.RuleEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "web/api/v1/rules")
public class RuleController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping
    public List<RuleEntity> getAllRules() {
        return examaniaService.getAllRules();
    }

    @PostMapping
    public RuleEntity addRule(@RequestBody RuleEntity ruleEntity) {
        return examaniaService.addRule(ruleEntity);
    }

    @PutMapping("/{ruleGuid}")
    public RuleEntity updateRule(@PathVariable String ruleGuid, @RequestBody RuleEntity ruleEntity) {
        return examaniaService.updateRule(ruleGuid, ruleEntity);
    }

    @DeleteMapping("/{ruleGuid}")
    public ResponseEntity<?> deleteRule(@PathVariable String ruleGuid) {
        return examaniaService.deleteRule(ruleGuid);
    }

    @GetMapping("/activeList")
    public List<RuleEntity> getAllActiveRules() {
        return examaniaService.getAllActiveRules();
    }
}
