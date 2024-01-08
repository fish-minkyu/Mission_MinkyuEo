package com.subject.board.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class BoardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String boardName;
  @OneToMany(mappedBy = "board")
  private List<ArticleEntity> articles;
}
