# 스프링부트 블로그 V2

## 기획 끝

## 화면설계 끝

## 화면코드 끝

## 테이블설계

## 1단계 기능

- (특징 : 자바스크립트, 예외처리)
- 회원가입 (A)
- 로그인 (A)
- 회원정보 보기 (A)
- 회원정보 수정하기 (A)
- 게시글 작성하기 (B)
- 게시글 목록보기 (B)
- 게시글 상세보기 (C)
- 게시글 삭제하기 (C)
- 게시글 수정하기 (C)
- 댓글 작성하기 (C)
- 댓글 삭제하기 (C)
- 예외처리

## 2단계 기능

- 유저네임 중복체크 (AJAX) (A) (22일)
- 검색하기 (B) (22일)
- 회원가입시 사진등록 (파일등록 23일)

## 3단계 기능 (24일)
- 섬머노트
- 필터(Filter)
- 유효성검사 자동화

## dev 모드로 실행하는 법
java -jar -Dspring.profiles.active=dev blogv2-1.0.jar

## 빌드 테스트 없이 하는법
./gradlew clean build -x test

## 테이블 쿼리

```sql
create database blogdb;
use blogdb;

create table user_tb (
    id integer auto_increment,
    created_at timestamp,
    email varchar(20) not null,
    password varchar(60) not null,
    username varchar(20) not null unique,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

create table board_tb (
    id integer auto_increment,
    content varchar(10000),
    created_at timestamp,
    title varchar(100) not null,
    user_id integer,
    primary key (id),
    constraint fk_board_user_id foreign key (user_id) references user_tb (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

create table reply_tb (
    id integer auto_increment,
    comment varchar(100) not null,
    created_at timestamp,
    board_id integer,
    user_id integer,
    primary key (id),
    constraint fk_reply_board_id foreign key (board_id) references board_tb (id),
    constraint fk_reply_user_id foreign key (user_id) references user_tb (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```
