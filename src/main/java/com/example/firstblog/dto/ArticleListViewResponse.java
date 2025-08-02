package com.example.firstblog.dto;

import com.example.firstblog.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;


    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();

    }
}
