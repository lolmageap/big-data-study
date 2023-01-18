package com.example.fastcampusmysql.domain.follow.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FollowDto(Long fromMemberId, Long toMemberId, LocalDateTime createAt) {}
