package com.example.firstproject.repository;

import com.example.firstproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    // 특정 멤버의 모든 피자 조회
    @Query(value = "SELECT * " +
            "FROM pizza " +
            "WHERE member_id = :memberId" , nativeQuery = true)
    List<Pizza> findByMemberId(Long memberId);

    // 특정 요리사의 모든 피자 조회
    List<Pizza> findByCook(String cook);
}
