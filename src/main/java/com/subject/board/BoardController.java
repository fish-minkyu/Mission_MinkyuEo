package com.subject.board;

import com.subject.board.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
  private final ArticleService articleService;
  private final BoardService boardService;

  // 랜딩 페이지
  @GetMapping
  public String list(Model model) {
    model.addAttribute("boardList", boardService.readAll());

    return "boardList";
  }

  // 게시판 상세보기
  @GetMapping("/{boardId}")
  public String readBoardOne(
    @PathVariable("boardId") Long boardId,
    Model model
  ) {
    model.addAttribute("board", boardService.readBoard(boardId));

    return "boardRead";
  }

  @GetMapping("{boardId}/article")
  public String createArticle(Model model) {
    model.addAttribute("boards", boardService.readAll());
    return "article/create";
  }
}
