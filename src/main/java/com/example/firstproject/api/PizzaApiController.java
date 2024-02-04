package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    PizzaService pizzaService;

    // 1. 조회
    @GetMapping("/api/members/{memberId}/pizzas")
    public ResponseEntity<List<PizzaDto>> pizzas(@PathVariable Long memberId) {
        List<PizzaDto> dtos = pizzaService.pizzas(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    // 2. 생성
    @PostMapping("/api/members/{memberId}/pizzas")
    public ResponseEntity<PizzaDto> create(@PathVariable Long memberId,
                                           @RequestBody PizzaDto dto) {
        PizzaDto createdDto = pizzaService.create(memberId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
    // 3. 수정
    @PatchMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDto> update(@PathVariable Long id,
                                           @RequestBody PizzaDto dto) {
        PizzaDto updatedDto = pizzaService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
    // 4. 삭제
    @DeleteMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDto> delete(@PathVariable Long id) {
        PizzaDto deletedDto = pizzaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }
}
