<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp" %>
    <meta charset="UTF-8">
    <title>예약 삭제</title>
</head>
<body>
    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp" %>
            <%@include file="/resources/static/jsp/nav.jsp" %>
        </header>

        <main class="layout container mt-5">
            <h2 class="text-center mb-4">예약 삭제</h2>
            <form action="${pageContext.request.contextPath}/delete" method="post" class="mx-auto" style="max-width: 600px;">
                <div class="mb-3">
                    <label for="reservationId" class="form-label">삭제할 예약 ID:</label>
                    <input type="number" id="reservationId" name="reservationId" class="form-control" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">예약 삭제</button>
                </div>
            </form>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp" %>
    </div>
</body>
</html>
