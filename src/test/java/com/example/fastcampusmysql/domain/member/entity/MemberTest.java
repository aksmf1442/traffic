package com.example.fastcampusmysql.domain.member.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.fastcampusmysql.util.MemberFixtureFactory;
import java.util.stream.LongStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    void testChangeName() {
        Member member = MemberFixtureFactory.create(1L);
        String expectedName = "pnu";

        member.changeNickname(expectedName);

        assertThat(expectedName).isEqualTo(member.getNickname());
    }

    @DisplayName("회원은 닉네임은 10자를 초과할 수 없다.")
    @Test
    void testNicknameMaxLength() {
        Member member = MemberFixtureFactory.create();
        String overMaxLengthName = "pnupnupnupnupnupnu";

        assertThrows(IllegalArgumentException.class,
            () -> member.changeNickname(overMaxLengthName));
    }


}
