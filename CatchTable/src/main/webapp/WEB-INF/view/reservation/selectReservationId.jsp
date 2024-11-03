<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp" %>
    <meta charset="UTF-8">
    <title>예약 ID 입력</title>
</head>
<body>
    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp" %>
            <%@include file="/resources/static/jsp/nav.jsp" %>
        </header>

        <main class="layout container text-center mt-5" style="max-width: 600px;">
            <h2 class="mb-4">수정할 예약 ID 입력</h2>
            <form action="${pageContext.request.contextPath}/select" method="post">
                <div class="mb-3">
                    <label for="reservationId" class="form-label">예약 ID:</label>
                    <input type="number" class="form-control" id="reservationId" name="reservationId" required>
                </div>
                <button type="submit" class="btn btn-primary">조회</button>
            </form>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp" %>
    </div>
</body>
</html> 
