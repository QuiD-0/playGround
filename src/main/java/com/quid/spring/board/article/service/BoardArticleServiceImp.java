package com.quid.spring.board.article.service;


import com.quid.spring.board.article.domain.ArticleDto;
import com.quid.spring.board.article.domain.SearchType;
import com.quid.spring.board.article.repository.BoardArticleRepository;
import com.quid.spring.board.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardArticleServiceImp implements BoardArticleService {

    private final BoardArticleRepository boardArticleRepository;

    private final UserRepository userRepository;

    @Override
    public Page<ArticleDto> searchArticlesPage(SearchType searchType, String key,
        Pageable pageable) {
        if (key == null || key.isBlank()) {
            return boardArticleRepository.findAll(pageable).map(ArticleDto::toArticleDto);
        }
        return switch (searchType) {
            case TITLE -> boardArticleRepository.findByTitleContaining(key, pageable)
                .map(ArticleDto::toArticleDto);
            case CONTENT -> boardArticleRepository.findByContentContaining(key, pageable)
                .map(ArticleDto::toArticleDto);
            case HASHTAG ->
                boardArticleRepository.findByHashtag(key, pageable).map(ArticleDto::toArticleDto);
            default -> throw new IllegalStateException("Unexpected value: " + searchType);
        };
    }

    @Override
    public List<String> findAllHashtag() {
        return boardArticleRepository.findAllHashtag();
    }

    @Override
    public List<ArticleDto> searchHashtag(String key) {
        return boardArticleRepository.findSearchtag(key).stream().map(ArticleDto::toArticleDto)
            .toList();
    }

    @Override
    public ArticleDto getArticle(Long id, String name) {
        userRepository.findById(name).orElseThrow(() -> new NotFoundException("User Not Found"));
        return boardArticleRepository.findById(id).map(ArticleDto::toArticleDto)
            .orElseThrow(() -> new NotFoundException("Article Not Found"));
    }
}
