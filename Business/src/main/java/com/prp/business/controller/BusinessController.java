package com.prp.business.controller;

import com.prp.business.model.dto.BusinessListCreateCommandDto;
import com.prp.business.model.dto.BusinessListCreateRequestDto;
import com.prp.business.model.service.BusinessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("business")
@CrossOrigin
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping
    public ResponseEntity<?> setBusinessList(@Valid @RequestBody BusinessListCreateRequestDto businessListCreateRequestDto) {
        return ResponseEntity.ok(businessService.setBusinessList(BusinessListCreateCommandDto.from(businessListCreateRequestDto)));
    }
    @GetMapping
    public ResponseEntity<?> getBusinessList() {
        return ResponseEntity.ok(businessService.getBusinessList());
    }
}
