# 📚 BookMarker-Back-End
Spring Boot 기반의 독서 관리 서비스 (개인 프로젝트)  
사용자가 도서를 검색하고 별점을 남기며, 자신만의 독서 목록을 관리할 수 있는 간단한 웹앱입니다.

## 기술 스택
- Java
- Spring Boot
- MyBatis
- PostgreSQL

## 주요 기능
**도서 검색 API**
- 네이버 도서 검색 API 연동
- 키워드 기반 도서 검색 및 상세 정보 제공
- 페이징 처리로 효율적인 데이터 전송

**사용자 평점 관리**
- 개인별 도서 평점 CRUD 기능
- 사용자별 독서 목록 관리
- 중복 평점 방지 로직

**API 보안**
- CORS 설정으로 안전한 크로스 도메인 통신
- JWT를 활용한 토큰 기반 로그인 기능 구현

## 배포 주소  
- Backend API: Render에서 운영 중
- Frontend: https://bkmk-front.vercel.app
