package com.example.demo;

import com.example.demo.dto.ConfirmDto;
import com.example.demo.dto.PoolDto;
import com.example.demo.dto.QuantileRequestDto;
import com.example.demo.dto.QuantileResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    ServiceApp serviceApp;


    @PostMapping("/save")
    public ResponseEntity<ConfirmDto> save(@RequestBody PoolDto poolDto){
        return ResponseEntity.ok(serviceApp.save(poolDto));
    }

    @PostMapping("/calculate-quantile")
    public ResponseEntity<QuantileResponseDto> calculateQuantile(@RequestBody QuantileRequestDto quantileRequestDto){
        return ResponseEntity.ok(serviceApp.calculateQuantile(quantileRequestDto));
    }
}
