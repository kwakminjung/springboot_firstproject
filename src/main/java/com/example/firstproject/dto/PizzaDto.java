package com.example.firstproject.dto;

import com.example.firstproject.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PizzaDto {
    private Long id;
    private Long memberId;
    private String name;
    private double price;
    private String cook;
    public static PizzaDto createPizzaDto(Pizza pizza) {
        return new PizzaDto(
                pizza.getId(),
                pizza.getMember().getId(),
                pizza.getName(),
                pizza.getPrice(),
                pizza.getCook()
        );
    }
}
