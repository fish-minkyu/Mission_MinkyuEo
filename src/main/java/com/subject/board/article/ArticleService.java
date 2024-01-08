package com.subject.board.article;

import com.subject.board.BoardRepository;
import com.subject.board.entity.ArticleEntity;
import com.subject.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
  private final BoardRepository boardRepository;
  private final ArticleRepository articleRepository;

  // Create
  public void create(
    // board의 pk를 받아온다.
    Long boardId,
    String title,
    String content,
    String password
  ) {
    Optional<BoardEntity> board = boardRepository.findById(boardId);

    ArticleEntity article = new ArticleEntity();
    article.setBoard(board.orElse(null));
    article.setTitle(title);
    article.setContent(content);
    article.setPassword(password);
    articleRepository.save(article);
  }

  // Read
  public List<ArticleEntity> readAll() {
    return articleRepository.findAll();
  }

  public ArticleEntity readOne(Long articleId) {
    return articleRepository.findById(articleId)
      .orElse(null);
  }

  // Update
  public void update(
    Long articleId,
    Long boardId,
    String title,
    String content
  ) {
    Optional<BoardEntity> board = boardRepository.findById(boardId);

    ArticleEntity article = readOne(articleId);
    article.setTitle(title);
    article.setContent(content);
    article.setBoard(board.orElse(null));
    articleRepository.save(article);
  }

  // Delete
  public void delete(Long articleId) {
    articleRepository.deleteById(articleId);
  }
}
