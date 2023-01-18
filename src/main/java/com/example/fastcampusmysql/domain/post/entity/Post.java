package com.example.fastcampusmysql.domain.post.entity;

import com.example.fastcampusmysql.domain.post.dto.PostDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Post {
    final private Long id;
    final private Long memberId;
    final private String contents;
    final private LocalDate createDate;
    final private LocalDateTime createAt;
    private Long likeCount;
    private Long version;

    @Builder //빌더 패턴 생성자
    public Post(Long id, Long memberId, String contents, LocalDate createDate, LocalDateTime createAt, Long likeCount, Long version) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.contents = Objects.requireNonNull(contents);
        this.createDate = createDate == null ? LocalDate.now() : createDate;
        this.createAt = createAt == null ? LocalDateTime.now() : createAt;
        this.likeCount = likeCount == null ? 0 : likeCount;
        this.version = version == null ? 0 : version;
    }

    public void incrementLikeCount() {
        likeCount += 1;
    }
}
