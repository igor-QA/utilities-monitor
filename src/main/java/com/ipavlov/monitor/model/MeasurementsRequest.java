package com.ipavlov.monitor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MeasurementsRequest {

        private Integer userId;
        private Double gas;
        private Double coldWater;
        private Double hotWater;

        public MeasurementsRequest(Integer userId, Double gas, Double coldWater, Double hotWater) {
                this.userId = userId;
                this.gas = gas;
                this.coldWater = coldWater;
                this.hotWater = hotWater;
        }

        @Override
        public String toString() {
                return "Measurements{" +
                        "userId=" + userId +
                        ", gas=" + gas +
                        ", coldWater=" + coldWater +
                        ", hotWater=" + hotWater +
                        '}';
        }
}