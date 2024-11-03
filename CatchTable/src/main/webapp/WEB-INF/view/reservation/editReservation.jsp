<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp" %>
    <meta charset="UTF-8">
    <title>예약 정보 수정</title>
</head>
<body>
    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp" %>
            <%@include file="/resources/static/jsp/nav.jsp" %>
        </header>

        <main class="layout container mt-5" style="max-width: 600px;">
            <div class="text-center mb-5">
                <h2 class="text-primary">예약 정보 수정</h2>
            </div>
            <form action="${pageContext.request.contextPath}/update" method="post" class="card p-4 shadow-sm">
                <div class="mb-3">
                    <label for="reservationId" class="form-label">예약 ID</label>
                    <input type="number" class="form-control" id="reservationId" name="reservationId" required>
                </div>

                <div class="mb-3">
                    <label for="restaurantName" class="form-label">음식점 이름</label>
                    <input type="text" class="form-control" id="restaurantName" name="restaurantName" required>
                </div>

                <div class="mb-3">
                    <label for="customerName" class="form-label">예약자 이름</label>
                    <input type="text" class="form-control" id="customerName" name="customerName" required>
                </div>

                <div class="mb-3">
                    <label for="numberOfPeople" class="form-label">예약 인원수</label>
                    <input type="number" class="form-control" id="numberOfPeople" name="numberOfPeople" min="1" required>
                </div>

                <div class="mb-3">
                    <label for="reservationDate" class="form-label">예약 날짜</label>
                    <input type="date" class="form-control" id="reservationDate" name="reservationDate" required>
                </div>

                <div class="mb-3">
                    <label for="reservationTime" class="form-label">예약 시간</label>
                    <input type="time" class="form-control" id="reservationTime" name="reservationTime" required>
                </div>

                <button type="submit" class="btn btn-primary w-100">예약 수정</button>
            </form>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp" %>
    </div>
</body>
</html>
