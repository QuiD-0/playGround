package com.quid.spring.board.comment.service;


import com.quid.spring.board.comment.domain.ArticleCommentDto;

public interface CommentService {

    void save(ArticleCommentDto dto);
}
