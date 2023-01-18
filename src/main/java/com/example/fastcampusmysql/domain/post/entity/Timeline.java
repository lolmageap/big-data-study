package com.example.fastcampusmysql.domain.post.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Timeline {
    final private Long id;

    final private Long memberId;

    final private Long postId;

    final private LocalDateTime createAt;

    @Builder
    public Timeline(Long id, Long memberId, Long postId, LocalDateTime createAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.postId = Objects.requireNonNull(postId);
        this.createAt = createAt == null ? LocalDateTime.now() : createAt;
    }
}
