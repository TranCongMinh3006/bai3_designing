package com.example.demo.dto;

public class QuantileRequestDto {
    private Long poolId;
    private Double percentile;

    public QuantileRequestDto(Long poolId, Double percentile) {
        this.poolId = poolId;
        this.percentile = percentile;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Double getPercentile() {
        return percentile;
    }

    public void setPercentile(Double percentile) {
        this.percentile = percentile;
    }
}
