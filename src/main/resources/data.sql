INSERT INTO board_entity (board_name)
VALUES
  ('자유 게시판'),
  ('개발 게시판'),
  ('일상 게시판'),
  ('사건사고 게시판');

INSERT INTO article_entity (title, content, password, board_id)
VALUES
  ('test1', 'test1', '1234', 1),
  ('test1', 'test1', '1234', 1),
  ('test1', 'test1', '1234', 1),
  ('test1', 'test1', '1234', 1),
  ('test2', 'test2', '1234', 2),
  ('test2', 'test2', '1234', 2),
  ('test3', 'test3', '1234', 3),
  ('test4', 'test4', '1234', 4),
  ('test4', 'test4', '1234', 4);

INSERT INTO comment_entity(content, password, article_id)
VALUES
  ('comment_test', '1234', 1),
  ('comment_test', '1234', 1),
  ('comment_test', '1234', 2),
  ('comment_test', '1234', 3),
  ('comment_test', '1234', 3),
  ('comment_test', '1234', 3),
  ('comment_test', '1234', 4),
  ('comment_test', '1234', 4),
  ('comment_test', '1234', 5),
  ('comment_test', '1234', 6),
  ('comment_test', '1234', 7),
  ('comment_test', '1234', 7);
