INSERT INTO article(title, content) VALUES('가가가가', '1111')
INSERT INTO article(title, content) VALUES('나나나나', '2222')
INSERT INTO article(title, content) VALUES('다다다다', '3333')


INSERT INTO article(title, content) VALUES('마젤토브', '댓글을 써줘요')
INSERT INTO article(title, content) VALUES('셜록', '댓글 고')
INSERT INTO article(title, content) VALUES('클루노트', '이게 뭐게')


INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', '웃어부앙')
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '튜스데이웬스데이')
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', '세븐')

INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', '예')
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '순간 미소지어')
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', '암소큐리어스예')

INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '이건 셜록')
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '인정')
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', '그러니까')

INSERT INTO member(email, password) VALUES('hi@email.com', '1111')
INSERT INTO member(email, password) VALUES('hello@email.com', '2222')
INSERT INTO member(email, password) VALUES('happy@email.com', '3333')

INSERT INTO pizza(member_id, name, price, cook) VALUES(1, '페페로니 피자', 25900, 'Kwak')
INSERT INTO pizza(member_id, name, price, cook) VALUES(1, '불고기 피자', 29900, 'Kang')
INSERT INTO pizza(member_id, name, price, cook) VALUES(2, '고구마 피자', 30900, 'Kwak')
INSERT INTO pizza(member_id, name, price, cook) VALUES(2, '포테이토 피자', 27900, 'Kang')
INSERT INTO pizza(member_id, name, price, cook) VALUES(3, '치즈 피자', 23900, 'Kwak')
INSERT INTO pizza(member_id, name, price, cook) VALUES(3, '베이컨 피자', 24900, 'Kang')


INSERT INTO coffee(name, price) VALUES('아메리카노', '4500')
INSERT INTO coffee(name, price) VALUES('라떼', '5000')
INSERT INTO coffee(name, price) VALUES('카페 모카', '5500')