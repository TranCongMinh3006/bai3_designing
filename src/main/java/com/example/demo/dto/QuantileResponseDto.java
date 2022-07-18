package com.example.demo.dto;

public class QuantileResponseDto {
    private Long calculatedQuantile;
    private Long totalElements;

    public QuantileResponseDto(Long calculatedQuantile, Long totalElements) {
        this.calculatedQuantile = calculatedQuantile;
        this.totalElements = totalElements;
    }

    public Long getCalculatedQuantile() {
        return calculatedQuantile;
    }

    public void setCalculatedQuantile(Long calculatedQuantile) {
        this.calculatedQuantile = calculatedQuantile;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
