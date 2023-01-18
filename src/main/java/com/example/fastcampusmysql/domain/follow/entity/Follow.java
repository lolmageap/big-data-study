package com.example.fastcampusmysql.domain.follow.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Follow {
    final private Long id;
    final private Long fromMemberId;
    final private Long toMemberId;
    final private LocalDateTime createAt;

    @Builder
    public Follow(Long id, Long fromMemberId, Long toMemberId, LocalDateTime createAt) {
        this.id = id;
        this.fromMemberId = Objects.requireNonNull(fromMemberId);
        this.toMemberId = Objects.requireNonNull(toMemberId);
        this.createAt = createAt == null ? LocalDateTime.now() : createAt;
    }
}
