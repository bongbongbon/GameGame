# GameGame

게임 게시판, 퀴즈 관련 프로젝트

- Business
    - 로그인, 회원가입
        - 이메일 인증으로 회원가입이 가능합니다.
    - 유저 / 마이페이지
        - 휴대폰 인증으로 아이디 찾기가 가능합니다.
        - 이메일 인증 및 휴대폰 인증으로 비밀번호를 변경할 수 있습니다.
        - 닉네임 변경이 가능합니다.
        - 내가 만든 게시판 및 퀴즈확인
    - 게임 게시판
        - 게시판 만들기는 로그인을 한 유저만 가능합니다.
        - 게시판 수정과 삭제는 게시물을 만든 유저만 가능합니다.
    - 게시판 조회
        - 검색을 통해 제목별, 내용별, 작성자별, 댓글많은순, 좋아요 갯수순
    - 퀴즈
        - 퀴즈 만들기는 로그인을 한 유저만 가능합니다.
        - 퀴즈 수정과 삭제는 게시물을 만든 유저만 가능합니다.
        - 답을 쓰고 맞출 수 있는 기능
    - 게시판 조회
        - 검색을 통해 제목별, 내용별, 작성자별, 댓글많은순
    - 배포
        - 도메인을 이용해서 배포까지 이루어져 서비스 이용이 가능합니다.
    
- Tech
    - REST API로 구현하고 설명을 위해 Swagger를 작성합니다.
    - JWT 토큰 방식의 로그인 프로세스 구현
        - 새로고침을 하더라도 로그인 유지를 위해 LocalStorage에 토큰을 저장 후 토큰이 LocalStorage에 없을 때는 로그인된 유저가 아니기 때문에 권한으로 페이지 이동시 가능 불가능하게 처리
        - AuthenticationPrincipal 어노테이션을 통해 hostUser가 아닐경우 삭제와 수정이 불가능하게 개발
    - 게임 게시판 만들기
        - 제목, 내용으로 데이터 받고 처리
        - 레디스를 이용하여 빠르게 읽을 수 있게 처리
    - 퀴즈 만들기
        - 제목, 내용 답으로 데이터 받고 처리
    - 배포 관련
        - nginx사용하여 리버스 프록시 적용
        - AWS 프리티어 램 메모리 부족으로  디스크 용량을 이용해서 메모리를 대체하는 swap메모리 사용
        - RDS의 mysql 서비스를 이용해 데이터베이스 구축

## ERD
<img width="862" alt="스크린샷 2024-07-08 오후 9 12 41" src="https://github.com/bongbongbon/GameGame/assets/106155992/438a3a58-9350-4f29-84b2-b8536f8be6db">

## 출처
[1] 미상, 제로베이스+Intellij, “sample-95-100-solve”, 미상, 미상
[2]mtgv999, IntelliJ, “Ecommerce”, 미상, 2024.05.19(Board CRUD)
[3] ChatGPT, response to “클래스 NoticeController @PatchMapping("/api/board/{id}/hits") public void boardHits
(@PathVariable Long id) { Notice board = boardRepository.findById(id) .orElseThrow(() -> new BoardNotFundException
("공지사항의 글이 존재하지 않습니다.")); board.setHits(board.getHits() + 1); boardRepository.save(board);}를 기반으로 NoticeService,
NoticeRepository를 어떻게 작성해야 글을 1번 누를 때마다 조회수가 1씩 올라가나요?”, “위 코드의 BoardController 클래스에서 어떻게 해야
boardRepository 부분을 boardService로 고칠 수 있습니까?” , July 10, 2024, https:chat.openai.com