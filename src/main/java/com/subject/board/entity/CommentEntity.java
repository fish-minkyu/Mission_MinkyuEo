package com.subject.board.entity;

import jakarta.persistence.*;

@Entity
public class CommentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long commentId;
  private String content;
  private String password;
  @ManyToOne
  private ArticleEntity article;
}
