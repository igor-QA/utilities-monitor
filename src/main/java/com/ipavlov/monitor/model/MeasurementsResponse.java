package com.ipavlov.monitor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MeasurementsResponse {

    private Integer id;
    private Integer userId;
    private Double gas;
    private Double coldWater;
    private Double hotWater;
    private String dateTime;

    @Override
    public String toString() {
        return "MeasurementsResponse{" +
                "id=" + id +
                ", userId=" + userId +
                ", gas=" + gas +
                ", coldWater=" + coldWater +
                ", hotWater=" + hotWater +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }

}
