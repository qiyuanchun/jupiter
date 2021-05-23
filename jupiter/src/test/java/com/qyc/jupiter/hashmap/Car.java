package com.qyc.jupiter.hashmap;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Builder
public class Car {

    private String bound;

    private BigDecimal price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(bound, car.bound) &&
                Objects.equals(price, car.price);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(bound, price);
//    }
}
