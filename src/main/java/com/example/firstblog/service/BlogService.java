package com.example.firstblog.service;

import com.example.firstblog.domain.Article;
import com.example.firstblog.dto.AddArticleRequest;
import com.example.firstblog.dto.UpdateArticleRequest;
import com.example.firstblog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @Notnull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity()); // dto --> entity로 바꿔서 저장
    }

    // 블로그 글 모두 가져오기
    public List<Article> findAll() {
        return blogRepository.findAll();
    }
    
    // 블로그 글 하나 가져오기
    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found" + id));
    }
    
    // 블로그 글 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found" + id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
