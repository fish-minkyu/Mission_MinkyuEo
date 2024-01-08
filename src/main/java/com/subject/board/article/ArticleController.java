package com.subject.board.article;

import com.subject.board.BoardService;
import com.subject.board.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
  private final ArticleService articleService;
  private final BoardService boardService;

  // Read, 전체 보기
  @GetMapping
  public String readAll(Model model) {
    model.addAttribute("articles", articleService.readAll());
    return "article/home";
  }

  // Create
  @PostMapping("/create")
  public String create(
    @RequestParam("board-id") Long boardId,
    @RequestParam("title") String title,
    @RequestParam("content") String content,
    @RequestParam("password") String password
  ) {
    articleService.create(boardId, title, content, password);
    return "redirect:/article";
  }

  // Read, 상세 보기(완료)
  @GetMapping("/{articleId}")
  public String readOne(
    @PathVariable("articleId") Long articleId,
    Model model
  ) {
    model.addAttribute("article", articleService.readOne(articleId));
    return "article/read";
  }

  @GetMapping("/{articleId}/password")
  public String checkPassword() {

    return "checkPassword";
  }

  // Update
  // update-view 보여주기(완료)
  @GetMapping("/{articleId}/update-view")
  public String updateView(
    @PathVariable("articleId") Long articleId,
    Model model
  ) {
    model.addAttribute("article", articleService.readOne(articleId));
    model.addAttribute("boards", boardService.readAll());
    return "article/update";
  }

  // update 실행
  @PostMapping("/{articleId}/update")
  public String update(
    @PathVariable("articleId") Long articleId,
    @RequestParam("board-id") Long boardId,
    @RequestParam("title") String title,
    @RequestParam("content") String content
  ) {
    articleService.update(articleId, boardId, title, content);
    return String.format("redirect:/article/%d", articleId);
  }

  // Delete(완료)
  @PostMapping("{articleId}/delete")
  public String deleteArticle(
    @PathVariable("articleId") Long articleId
  ) {
    articleService.delete(articleId);
    return "redirect:/article";
  }
}
