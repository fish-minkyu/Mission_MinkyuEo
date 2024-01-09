package com.subject.board.article;

import com.subject.board.entity.ArticleEntity;
import com.subject.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
