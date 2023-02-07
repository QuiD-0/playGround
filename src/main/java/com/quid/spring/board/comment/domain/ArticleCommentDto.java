package com.quid.spring.board.comment.domain;

import java.io.Serializable;

public record ArticleCommentDto(Long articleId, String content) implements Serializable {

}
