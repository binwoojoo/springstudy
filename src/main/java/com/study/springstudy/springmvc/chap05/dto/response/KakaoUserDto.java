package com.study.springstudy.springmvc.chap05.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class KakaoUserDto {

    private Long id;

    @JsonProperty("connected_at")
    private LocalDate connectedAt;

    private Properties properties;

    @Getter @ToString
    public static class Properties {
        private String nickname;
        @JsonProperty("profile_image")
        private String profileImage;
    }


}
