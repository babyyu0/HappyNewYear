package com.prp.business.controller;

import com.prp.business.model.dto.BusinessListCreateCommandDto;
import com.prp.business.model.dto.BusinessListCreateRequestDto;
import com.prp.business.model.service.BusinessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("business")
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping
    public ResponseEntity<?> createBusiness(@Valid @RequestBody BusinessListCreateRequestDto businessListCreateRequestDto) {
        return ResponseEntity.ok(businessService.createBusiness(BusinessListCreateCommandDto.from(businessListCreateRequestDto)));
    }
}
