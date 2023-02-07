package com.quid.spring.board.article.repository;

import static com.quid.spring.board.article.domain.QBoardArticle.boardArticle;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.quid.spring.board.article.domain.BoardArticle;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardBoardArticleRepositoryImpl implements BoardArticleRepository {

    private final BoardArticleRestRepository boardArticleRestRepository;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<String> findAllHashtag() {
        return jpaQueryFactory.select(boardArticle.hashtag).from(boardArticle).distinct()
            .where(boardArticle.hashtag.isNotNull()).fetch();
    }


    @Override
    public Page<BoardArticle> findByTitleContaining(String title, Pageable pageable) {
        return boardArticleRestRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<BoardArticle> findByContentContaining(String key, Pageable pageable) {
        return boardArticleRestRepository.findByContentContaining(key, pageable);
    }

    @Override
    public Page<BoardArticle> findByHashtag(String key, Pageable pageable) {
        return boardArticleRestRepository.findByHashtag(key, pageable);
    }

    @Override
    public Optional<BoardArticle> findById(Long id) {
        return boardArticleRestRepository.findById(id);
    }

    @Override
    public Page<BoardArticle> findAll(Pageable pageable) {
        return boardArticleRestRepository.findAll(pageable);
    }

    @Override
    public List<BoardArticle> findSearchtag(String key) {
        return jpaQueryFactory.selectFrom(boardArticle).where(boardArticle.hashtag.contains(key))
            .distinct()
            .fetch();
    }
}
