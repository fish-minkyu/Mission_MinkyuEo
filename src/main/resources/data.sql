INSERT INTO board_entity (board_name)
VALUES
  ('자유 게시판'),
  ('개발 게시판'),
  ('일상 게시판'),
  ('사건사고 게시판');

INSERT INTO article_entity (title, content, password, board_id)
VALUES
  ('숙대입구역 맛집 추천', '숙대입구역 근처에 있는 평화남영 식당이 맛있어요!', '1234', 1),
  ('JDD 실사용 후기', '유명한 JDD를 회사에서 실천해보았습니다. 1주 후 왕따가 되었습니다. 하지마세요..', '1234', 1),
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
