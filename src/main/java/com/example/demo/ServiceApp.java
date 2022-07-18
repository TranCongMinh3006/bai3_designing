package com.example.demo;

import com.example.demo.dto.ConfirmDto;
import com.example.demo.dto.PoolDto;
import com.example.demo.dto.QuantileRequestDto;
import com.example.demo.dto.QuantileResponseDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ServiceApp {
    private static Map<Long, List<Long>> mapPools = new HashMap<>();

    public ConfirmDto save(PoolDto poolDto){
        Long poolDtoId = poolDto.getPoolId();
        boolean isExist =  this.mapPools.containsKey(poolDtoId);
        if (isExist){
            List<Long> listOne = this.mapPools.get(poolDtoId);
            List<Long> listTwo = poolDto.getPoolValues();
            List<Long> newList = Stream.concat(listOne.stream(), listTwo.stream()).collect(Collectors.toList());
            this.mapPools.put(poolDtoId, newList);
//            System.err.println("list after join" + newList);
            return new ConfirmDto("appended");
        } else {
            this.mapPools.put(poolDtoId, poolDto.getPoolValues());
//            System.err.println("map after add new item " + this.mapPools);
            return new ConfirmDto("inserted");
        }
    }

    public QuantileResponseDto calculateQuantile(QuantileRequestDto quantileRequestDto) {
        Long poolId = quantileRequestDto.getPoolId();
        List<Long> latencies = this.mapPools.get(poolId);
        Collections.sort(latencies);
        int index = (int) Math.ceil(quantileRequestDto.getPercentile() / 100.0 * latencies.size());
        Long totalElements = Long.valueOf(latencies.size());
        return new QuantileResponseDto(latencies.get(index-1), totalElements);
    }
}
