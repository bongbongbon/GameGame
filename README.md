# gamegame
 
MSA를 통해서 만드는 게임 게시판 관련 프로젝트

- Business
    - 로그인, 회원가입
        - 이메일 인증으로 회원가입이 가능합니다.
        - 프로필 이미지 등록
        - 공개 비공개 처리(비공개시 닉네임과 기본이미지 프로필사진만)
    - 유저 / 마이페이지
        - 휴대폰 인증으로 아이디 찾기가 가능합니다.
        - 이메일 인증 및 휴대폰 인증으로 비밀번호를 변경할 수 있습니다.
        - 프로필 수정으로 이미지, 닉네임 변경이 가능합니다(단 닉네임변경은 한달에 한번만 가능)
        - 내가 만든 게시판 확인
    - 게임 게시판
        - 게시판 만들기는 로그인을 한 유저만 가능합니다.
        - 게시판 수정과 삭제는 게시물을 만든 유저만 가능합니다.
        - 댓글과 대댓글 기능은 로그인한 유저만 가능합니다.
        - 좋아요 기능 가능
    - 게시판 조회
        - 검색을 통해 제목별, 내용별, 작성자별, 댓글많은순, 좋아요 갯수순
    - 배포
        - 도메인을 이용해서 배포까지 이루어져 서비스 이용이 가능합니다.
    
- Tech
    - REST API로 구현하고 설명을 위해 Swagger를 작성합니다.
    - JWT 토큰 방식의 로그인 프로세스 구현
        - 새로고침을 하더라도 로그인 유지를 위해 LocalStorage에 토큰을 저장 후 토큰이 LocalStorage에 없을 때는 로그인된 유저가 아니기 때문에 권한으로 페이지 이동시 가능 불가능하게 처리
        - AuthenticationPrincipal 어노테이션을 통해 hostUser가 아닐경우 삭제와 수정이 불가능하게 개발
    - 게임 게시판 만들기
        - 제목, 내용으로 데이터 받고 처리
    - 배포 관련
        - MSA 적용
        - nginx사용하여 리버스 프록시 적용
        - AWS 프리티어 램 메모리 부족으로  디스크 용량을 이용해서 메모리를 대체하는 swap메모리 사용
        - RDS의 mysql 서비스를 이용해 데이터베이스 구축
        - S3로 이미지 저장
        - a
        - b
