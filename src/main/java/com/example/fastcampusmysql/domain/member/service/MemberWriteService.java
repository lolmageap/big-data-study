package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcampusmysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {

    final private MemberRepository memberRepository;
    final private MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    public Member createRegister(RegisterMemberCommand command){
        /*
         목표 - 회원정보(이메일, 닉네임, 생년월일)를 등록한다.
              - 닉네임은 10자를 넘길 수 없다.
         파라미터 - memberRegisterCommand
         val member = Member.of(memberRegisterCommand)
         memberRepository.save(member)
        */
        Member member = Member.builder()
                        .nickname(command.nickname())
                        .email(command.email())
                        .birthday(command.birthday())
                        .build();

        var saveMember = memberRepository.save(member);
        saveMemberNicknameHistory(saveMember);

        return saveMember;
    }
    public void changeNickname(Long memberId, String nickname){
        var member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickname(nickname);
        memberRepository.save(member);

        saveMemberNicknameHistory(member);
        //TODO : 변경내역 히스토리를 저장한다.
    }

    private void saveMemberNicknameHistory(Member member){
        var history = MemberNicknameHistory.builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .createAt(member.getCreateAt())
                .build();

        memberNicknameHistoryRepository.save(history);
    }


}
