package com.study.springstudy.springmvc.chap05.mapper;

import com.study.springstudy.springmvc.chap05.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("회원가입에 성공해야한다")
    void saveTest() {
        //given
        Member member = Member.builder()
                .account("zzz1234")
                .password("zzz1234")
                .name("최익현")
                .email("zzz1234@gmail.com")
                .build();
        //when
        boolean flag = memberMapper.save(member);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("아이디가 중복이면 가입에 실패한다")
    void existsByIdTest() {
        //given
//        Member member = Member.builder()
//                .account("zzz1234")
//                .password("zzz1234")
//                .name("최형배")
//                .email("zzz5678@gmail.com")
//                .build();
        //when
        boolean flag = memberMapper.existsById("account", "zzz1234");
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("아이디가 중복이면 가입에 실패한다")
    void existsByIdTest2() {
        //given
//        Member member = Member.builder()
//                .account("zzz1234")
//                .password("zzz1234")
//                .name("최형배")
//                .email("zzz5678@gmail.com")
//                .build();
        //when
        boolean flag = memberMapper.existsById("account", "zzz5678");
        //then
        assertFalse(flag);
    }

    @Test
    @DisplayName("회원 아이디를 입력하면 그 회원의 정보를 알수있다")
    void findOneTest() {
        //given

        //when
        Member member = memberMapper.findOne("zzz1234");
        //then
        assertEquals("최익현", member.getName());
    }

    @Test
    @DisplayName("평문의 암호를 인코딩하여야 한다.")
    void encodingTest() {
        //given
        String rawPassword = "abc1234";
        //when
        encoder.encode(rawPassword);
        //then
    }

}
