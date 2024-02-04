package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.MemberRepository;
import com.example.firstproject.repository.PizzaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    MemberRepository memberRepository;

    public List<PizzaDto> pizzas(Long memberId) {
        return pizzaRepository.findByMemberId(memberId)
                .stream()
                .map(pizza -> PizzaDto.createPizzaDto(pizza))
                .collect(Collectors.toList());
    }

    @Transactional
    public PizzaDto create(Long memberId, PizzaDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("대상 피자 생성 실패!" +
                        "대상 멤버가 없습니다."));
        Pizza pizza = Pizza.createPizza(dto, member);
        Pizza created = pizzaRepository.save(pizza);
        return PizzaDto.createPizzaDto(created);
    }

    @Transactional
    public PizzaDto update(Long id, PizzaDto dto) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("대상 피자 생성 실패!" +
                        "대상 피자가 없습니다."));
        target.patch(dto);
        Pizza updated = pizzaRepository.save(target);
        return PizzaDto.createPizzaDto(updated);
    }

    public PizzaDto delete(Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("대상 피자 생성 실패!" +
                        "대상 피자가 없습니다."));
        pizzaRepository.delete(target);
        return PizzaDto.createPizzaDto(target);
    }
}
