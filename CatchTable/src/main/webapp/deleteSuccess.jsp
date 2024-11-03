<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp"%>
    <meta charset="UTF-8">
    <title>예약 삭제</title>
</head>
<body>
    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp"%>
            <%@include file="/resources/static/jsp/nav.jsp"%>
        </header>

        <main class="layout container text-center mt-5" style="max-width: 600px;">
            <h2 class="text-success">예약 삭제 성공</h2>
            <p class="mb-4">예약이 성공적으로 삭제되었습니다!</p>

            <div class="mt-4">
                <a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로 돌아가기</a>
            </div>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp"%>
    </div>
</body>
</html>
