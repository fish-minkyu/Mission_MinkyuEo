package com.subject.board;

import com.subject.board.entity.ArticleEntity;
import com.subject.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;

  // list page
  public List<BoardEntity> readAll() {
//    List<BoardEntity> boards = boardRepository.findAll();
//    for (BoardEntity board: boards) {
//      System.out.println(board.toString());
//    }

    return boardRepository.findAll();
  }

  // boardRead
  public BoardEntity readBoard(Long boardId) {
    return boardRepository.findById(boardId)
      .orElse(null);
  }
}
