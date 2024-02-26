package com.prp.business.controller;

import com.prp.business.model.dto.BusinessCreateCommandDto;
import com.prp.business.model.dto.BusinessCreateRequestDto;
import com.prp.business.model.service.BusinessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("business")
public class BusinessController {

    private BusinessService businessService;

    @PostMapping
    public ResponseEntity<?> createBusiness(@Valid BusinessCreateRequestDto businessCreateRequestDto) {
        businessService.createBusiness(BusinessCreateCommandDto.from(businessCreateRequestDto));
        return ResponseEntity.ok(true);
    }
}
