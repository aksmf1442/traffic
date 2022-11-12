package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMemberCommand {

    String email;
    String nickname;
    LocalDate birthday;

}
