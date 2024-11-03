<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp" %>
    <meta charset="UTF-8">
    <title>Reservation Success</title>
</head>
<body>
    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp" %>
            <%@include file="/resources/static/jsp/nav.jsp" %>
        </header>

        <main class="layout container mt-5">
            <div class="text-center mb-5">
                <h2 class="mb-4 text-success">예약 성공</h2>
                <p class="lead">예약이 성공적으로 추가되었습니다!</p>
            </div>

            <div class="reservation-info card mx-auto p-4" style="max-width: 600px;">
                <h3 class="card-title mb-4">예약 정보</h3>
                <p><strong>예약 ID:</strong> ${reservationId}</p>
                <table class="table table-bordered">
                    <tbody>
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
                    </tbody>
                </table>
            </div>

            <div class="text-center mt-5">
                <a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로 돌아가기</a>
            </div>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp" %>
    </div>
</body>
</html>
