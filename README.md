# CatchTable

![image](https://github.com/user-attachments/assets/24b61b4e-b352-4497-a2bb-eef4d4ac1cc5)
### 노션 링크
https://seong-kai.notion.site/Catch-Table-133fcab0377c802a8647d89c8c9a9845?pvs=4

### 프로젝트 개요
- **프로젝트 이름**: CatchTable
- **목적**: 사용자가 주변 음식점의 예약을 손쉽게 관리하고 확인할 수 있는 웹 애플리케이션입니다. 이 프로젝트는 음식점 예약을 효율적으로 관리할 수 있도록 도와줍니다.

### 주요 기능
1. **예약 추가**
   - 음식점 이름, 예약자 이름, 인원수, 날짜와 시간을 입력하여 새로운 예약을 추가할 수 있습니다.
   
2. **예약 조회**
   - 예약 ID를 입력하여 특정 예약을 조회하고 확인할 수 있습니다.
   
3. **예약 수정**
   - 기존 예약 정보를 수정하여 변경 사항을 반영합니다.
   
4. **예약 삭제**
   - 예약 ID를 통해 예약을 삭제하고, 더 이상 필요 없는 예약을 정리할 수 있습니다.
   
5. **데이터베이스 연동**
   - 예약 정보는 MySQL 데이터베이스에 저장되며, 이를 통해 빠르고 효율적인 관리가 가능합니다.

---

### 기술 스택

#### 프론트엔드
- **HTML**: 웹 페이지의 구조 정의
- **CSS 및 Bootstrap**: 테이블과 폼 스타일링을 통해 UI 디자인 및 사용자 경험을 개선

#### 백엔드
- **JSP & Servlets**: 프론트엔드와 백엔드를 연결하고 데이터 처리 로직을 구현
- **Java**: 예약 데이터의 처리와 검증 등 웹 애플리케이션의 비즈니스 로직을 담당

#### 데이터베이스
- **MySQL**: 예약 정보를 저장하고 관리합니다. 예약 ID 자동 생성, CRUD 기능 수행, 효율적인 데이터 검색을 지원

#### 서버
- **Apache Tomcat**: JSP와 Servlet 기반의 Java 웹 애플리케이션을 실행하기 위한 웹 서버

#### 도구
- **Eclipse**: Java 및 JSP 개발 환경
- **GitHub**: 버전 관리를 통해 소스 코드 추적 및 협업
- **Notion**: 프로젝트 관리와 진행 상황을 기록

---

### 주요 기능 설명

1. **예약 추가**
   - 사용자가 음식점, 예약자 이름, 예약 날짜와 시간을 입력하여 새로운 예약을 추가할 수 있습니다.
   - 입력된 예약 정보는 POST 요청으로 서버에 전달되고, MySQL 데이터베이스에 저장됩니다.

2. **예약 조회**
   - 예약 ID를 통해 개별 예약 정보를 조회합니다.
   - 데이터베이스에서 ID를 기준으로 검색하여 특정 예약을 쉽게 찾을 수 있도록 합니다.

3. **예약 수정**
   - 기존 예약 정보를 불러와 수정한 후 데이터베이스에 반영합니다.
   - GET 요청으로 수정할 예약 정보를 불러오고, POST 요청으로 수정된 정보를 전송합니다.

4. **예약 삭제**
   - 예약 ID를 입력받아 해당 예약을 삭제합니다.
   - 불필요한 예약을 제거하여 데이터베이스 관리를 효율적으로 할 수 있습니다.

5. **예약 성공 및 실패 페이지**
   - 예약 추가, 수정, 삭제 성공 시 알림 페이지로 이동합니다.
   - 오류 발생 시 에러 메시지를 표시하여 문제 해결을 돕는 페이지를 제공합니다.

---
