package com.example.fastcampusmysql.domain.member.entity;

import java.time.LocalDate;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Member {

    private static final Long NAME_MAX_LENGTH = 10L;

    private final Long id;
    private final String email;
    private final LocalDate birthday;
    private final LocalDate createdAt;

    private String nickname;

    @Builder
    public Member(Long id, String email, LocalDate birthday, LocalDate createdAt,
        String nickname) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.birthday = Objects.requireNonNull(birthday);

        validateNickname(nickname);
        this.nickname = Objects.requireNonNull(nickname);

        this.createdAt = createdAt == null ? LocalDate.now() : createdAt;
    }

    void validateNickname(String nickname) {
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과했습니다.");
    }
}
