package com.subject.board.comment;

import com.subject.board.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;
  private final ArticleService articleService;

  // 댓글 생성
  @PostMapping("/{articleId}/comment")
  public String createComment(
    @PathVariable("articleId") Long articleId,
    @RequestParam("content") String content,
    @RequestParam("password") String password
  ) {
    commentService.create(content, password, articleId);
    return String.format("redirect:/article/%d", articleId);
  }

  @GetMapping("/{articleId}/comment/{commentId}/password-view")
  public String passwordViewComment(
    @PathVariable("articleId") Long articleId,
    @PathVariable("commentId") Long commentId,
    Model model
  ) {
    model.addAttribute("article", articleService.readOne(articleId));
    model.addAttribute("comment", commentService.readOne(commentId));
    return "comment/checkPasswordDelete";
  }

  @PostMapping("/{articleId}/comment/{commentId}/delete")
  public String deleteComment(
    @PathVariable("articleId") Long articleId,
    @PathVariable("commentId") Long commentId,
    @RequestParam("input-password") String inputPassword,
    Model model
  ) {
    if (commentService.checkPassword(commentId, inputPassword)) {
      return String.format("redirect:/article/%d", articleId);
    } else {
      model.addAttribute("comment", commentService.readOne(commentId));
      model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
      return "comment/checkPasswordDelete";
    }
  }

}
