package com.subject.board;

import com.subject.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;

  // list page
  public List<BoardEntity> readAll() {
    return boardRepository.findAll();
  }

  // boardRead
  public BoardEntity readBoard(Long boardId) {
    return boardRepository.findById(boardId)
      .orElse(null);
  }
}
