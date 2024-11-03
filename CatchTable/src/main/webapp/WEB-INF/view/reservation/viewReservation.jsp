<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp" %>
    <meta charset="UTF-8">
    <title>예약 상세 정보</title>
</head>
<body>
    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp" %>
            <%@include file="/resources/static/jsp/nav.jsp" %>
        </header>

        <main class="layout container mt-5">
            <h2 class="text-center mb-4">예약 상세 정보</h2>
            <table class="table table-bordered table-hover mx-auto" style="max-width: 600px;">
                <tr>
                    <th>음식점 이름</th>
                    <td>${reservation.restaurantName}</td>
                </tr>
                <tr>
                    <th>예약자 이름</th>
                    <td>${reservation.customerName}</td>
                </tr>
                <tr>
                    <th>예약 날짜</th>
                    <td>${reservation.reservationDate}</td>
                </tr>
                <tr>
                    <th>예약 시간</th>
                    <td>${reservation.reservationTime}</td>
                </tr>
                <tr>
                    <th>인원수</th>
                    <td>${reservation.numberOfPeople}</td>
                </tr>
            </table>
            <div class="text-center mt-4">
                <a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로 돌아가기</a>
            </div>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp" %>
    </div>
</body>
</html>
