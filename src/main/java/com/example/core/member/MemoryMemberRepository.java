package com.example.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // 동시성 문제가 있을 수 있음 -> 따라서 curncyHashMap 을 사용해야함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
        System.out.println("MemoryMemberRepository.save");
    }

    @Override
    public Member findById(Long memberId) {
        System.out.println("MemoryMemberRepository.findById");
        return store.get(memberId);
    }
}
