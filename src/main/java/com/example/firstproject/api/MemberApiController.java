package com.example.firstproject.api;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberApiController {
    @Autowired
    private MemberService memberService;

    // 1. 조회
    @GetMapping("api/members")
    public List<Member> index() {
        return memberService.index();
    }
    @GetMapping("api/members/{id}")
    public Member show(@PathVariable Long id) {
        return memberService.show(id);
    }
    // 2. 생성
    @PostMapping("/api/members")
    public ResponseEntity<Member> create(@RequestBody MemberForm dto) {
        Member created = memberService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // 3. 수정
    @PatchMapping("/api/members/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id,
                                          @RequestBody MemberForm dto) {
        Member updated = memberService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // 4. 삭제
    @DeleteMapping("api/members/{id}")
    public ResponseEntity<Member> delete(@PathVariable Long id) {
        Member deleted = memberService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // + 여러 데이터 생성
    @PostMapping("/api/members/create")
    public ResponseEntity<List<Member>> transaction
    (@RequestBody List<MemberForm> dtos) {
        List<Member> createdList = memberService.createMembers(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
