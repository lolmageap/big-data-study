package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.dto.MemberNicknameHistoryDto;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcampusmysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberReadService {
    private final MemberRepository memberRepository;
    private final MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    public List<MemberNicknameHistoryDto> getNicknameHistories(Long memberId){
        return memberNicknameHistoryRepository
                .findAllByMemberId(memberId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private MemberNicknameHistoryDto toDto(MemberNicknameHistory history){
        return new MemberNicknameHistoryDto(
                history.getId(),
                history.getMemberId(),
                history.getNickname(),
                history.getCreateAt()
        );
    }

    public MemberDto getMember(Long memberId){
        var member = memberRepository.findById(memberId).orElseThrow();
        return toDto(member);
    }
    public MemberDto toDto(Member member){
        return new MemberDto(member.getId(),member.getNickname(),member.getEmail(),member.getBirthday());
    }
    public List<MemberDto> getMembers(List<Long> memberIds) {
        var members = memberRepository.findAllByIdIn(memberIds);
        return members.stream()
                .map(this::toDto)
                .toList();
    }

}
