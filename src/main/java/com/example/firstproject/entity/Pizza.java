package com.example.firstproject.entity;

import com.example.firstproject.dto.PizzaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String cook;

    public static Pizza createPizza(PizzaDto dto, Member member) {
        if(dto.getId() != null)
            throw new IllegalArgumentException("피자 생성 실패! 피자의 id가 없어야 합니다.");
        if(dto.getMemberId() != member.getId())
            throw new IllegalArgumentException("피자 생성 실패! 피자의 id가 잘못되었습니다.");
        return new Pizza(
                dto.getId(),
                member,
                dto.getName(),
                dto.getPrice(),
                dto.getCook()
        );
    }

    public void patch(PizzaDto dto) {
        if(this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력되었습니다.");

        if(dto.getName() != null)
            this.name = dto.getName();
        if(dto.getPrice() != 0)
            this.price = dto.getPrice();
        if(dto.getCook() != null)
            this.cook = dto.getCook();
    }
}
