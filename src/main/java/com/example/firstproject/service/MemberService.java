package com.example.firstproject.service;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;


    public List<Member> index() {
        return memberRepository.findAll();
    }

    public Member show(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member create(MemberForm dto) {
        Member created = dto.toEntity();
        // created 에는 id가 자동으로 생성되기 때문에 null값이 아니라면 이미 그 id를 쓰고 있는게 있는거임
        if(created.getId() != null)
            return null;
        return memberRepository.save(created);
    }

    public Member update(Long id, MemberForm dto) {
        Member member = dto.toEntity();
        Member target = memberRepository.findById(id).orElse(null);
        if(target == null || id != member.getId())
            return null;
        target.patch(member);
        Member updated = memberRepository.save(target);
        return updated;
    }

    public Member delete(Long id) {
        Member target = memberRepository.findById(id).orElse(null);
        if(target == null)
            return null;
        memberRepository.delete(target);
        return target;
    }

    public List<Member> createMembers(List<MemberForm> dtos) {
        List<Member> memberList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        memberList.stream()
                .forEach(member -> memberRepository.save(member));
        return memberList;
    }
}
