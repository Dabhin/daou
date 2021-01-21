# daou
1. 주제 : 게시판 만들기

2. 기술 스펙
   - spring boot project 구성
     * 로그인 : spring security 적용
   - gradle 
   - Database : mariaDB
     * 사용자, 게시판 관련 테이블 2개 필수, 추가 설계는 선택
   - ORM : mybatis
   - view : thymeleaf
   - 화면 UI의 경우 디자인이 어려우니 bootstrap을 활용 추천

3. 기능 상세
   - 사용자 로그인 기능 ( 비밀번호 암호화 필수 )
     * 비밀번호 변경 기능 포함
   - 게시판 기능 명세
     * 글 등록, 조회, 검색, 수정, 삭제
     * 등록된 글에 대한 다른 사용자들의 Like, Unlike 기능
