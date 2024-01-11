package com.subject.board.board;

import com.subject.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;

  // 전체 게시판 보기
  public List<BoardEntity> readAll() {
    return boardRepository.findAll();
  }

  // 게시판 상세보기
  public BoardEntity readBoard(Long boardId) {
    return boardRepository.findById(boardId)
      .orElse(null);
  }
}
