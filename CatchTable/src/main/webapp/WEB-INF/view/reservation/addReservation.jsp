<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- link -->
<%@include file="/resources/static/jsp/link.jsp"%>
<meta charset="UTF-8">
<title>예약 추가</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/static/jsp/topHeader.jsp"%>
			<!-- nav -->
			<%@include file="/resources/static/jsp/nav.jsp"%>
		</header>

		<main class="layout container mt-5">
			<h1 class="mb-4 text-center">예약 추가</h1>
			<form action="${pageContext.request.contextPath}/add"
				method="post" class="mx-auto" style="max-width: 600px;">
				<div class="mb-3">
					<label for="restaurantName" class="form-label">음식점 이름:</label> <input
						type="text" id="restaurantName" name="restaurantName"
						class="form-control" required>
				</div>

				<div class="mb-3">
					<label for="customerName" class="form-label">예약자 이름:</label> <input
						type="text" id="customerName" name="customerName"
						class="form-control" required>
				</div>

				<div class="mb-3">
					<label for="numberOfPeople" class="form-label">예약 인원수:</label> <input
						type="number" id="numberOfPeople" name="numberOfPeople"
						class="form-control" min="1" required>
				</div>

				<div class="mb-3">
					<label for="reservationDate" class="form-label">예약 날짜:</label> <input
						type="date" id="reservationDate" name="reservationDate"
						class="form-control" required>
				</div>

				<div class="mb-3">
					<label for="reservationTime" class="form-label">예약 시간:</label> <input
						type="time" id="reservationTime" name="reservationTime"
						class="form-control" required>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">예약 추가</button>
				</div>
			</form>
		</main>


		<!-- footer -->
		<%@include file="/resources/static/jsp/footer.jsp"%>
	</div>

</body>
</html>
