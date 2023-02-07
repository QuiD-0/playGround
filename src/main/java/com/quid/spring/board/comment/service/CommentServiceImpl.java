package com.quid.spring.board.comment.service;


import com.quid.spring.board.article.domain.BoardArticle;
import com.quid.spring.board.article.repository.BoardArticleRepository;
import com.quid.spring.board.comment.domain.ArticleComment;
import com.quid.spring.board.comment.domain.ArticleCommentDto;
import com.quid.spring.board.comment.repository.CommentRestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BoardArticleRepository boardArticleRepository;

    private final CommentRestRepository commentRestRepository;

    @Override
    public void save(ArticleCommentDto dto) {
        BoardArticle article = boardArticleRepository.findById(dto.articleId())
            .orElseThrow(() -> new NotFoundException("해당 게시글을 찾을 수 없습니다."));

        ArticleComment articleComment = ArticleComment.builder()
            .article(article).content(dto.content()).build();
        commentRestRepository.save(articleComment);

    }

}
