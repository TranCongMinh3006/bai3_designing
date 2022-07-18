package com.example.demo.dto;

import java.util.List;

public class PoolDto {
    private Long poolId;
    private List<Long> poolValues;

    public PoolDto(Long poolId, List<Long> poolValues) {
        this.poolId = poolId;
        this.poolValues = poolValues;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public List<Long> getPoolValues() {
        return poolValues;
    }

    public void setPoolValues(List<Long> poolValues) {
        this.poolValues = poolValues;
    }
}
