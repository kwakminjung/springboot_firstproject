package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public static ArticleForm createArticleDto(Article article) {
        return new ArticleForm(
                article.getId(),
                article.getTitle(),
                article.getContent()
        );
    }

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
