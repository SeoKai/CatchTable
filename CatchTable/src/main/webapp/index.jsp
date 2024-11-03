<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp" %>
    <meta charset="UTF-8">
    <title>CatchTable - 메인 페이지</title>
</head>
<body>
    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp" %>
            <%@include file="/resources/static/jsp/nav.jsp" %>
        </header>

        <main class="layout container text-center mt-5">
            <h1 class="mb-4">CatchTable에 오신 것을 환영합니다</h1>
            <p class="lead mb-5">주변 음식점 예약을 손쉽게 관리하고 확인하세요.</p>

            <div class="row justify-content-center">
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/add" class="btn btn-success btn-lg w-100 mb-3">예약 추가</a>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/select" class="btn btn-primary btn-lg w-100 mb-3">예약 조회</a>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/update" class="btn btn-warning btn-lg w-100 mb-3">예약 수정</a>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/delete" class="btn btn-danger btn-lg w-100 mb-3">예약 삭제</a>
                </div>
            </div>

            <div class="mt-5">
                <p>사용 중 문제가 발생하면 고객 지원 페이지를 참조하세요.</p>
            </div>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp" %>
    </div>
</body>
</html>
