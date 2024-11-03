<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/static/jsp/link.jsp" %>
    <meta charset="UTF-8">
    <title>오류 발생</title>
</head>
<body>

    <div class="wrapper">
        <header>
            <%@include file="/resources/static/jsp/topHeader.jsp" %>
            <%@include file="/resources/static/jsp/nav.jsp" %>
        </header>
        
        <main class="layout container mt-5 text-center">
            <h2 class="text-danger">오류 발생</h2>
            <p class="mb-4">요청을 처리하는 중 오류가 발생했습니다. 아래의 메시지를 확인하세요.</p>

            <div class="alert alert-danger" role="alert" style="display: inline-block; max-width: 600px; margin: auto;">
                <p><strong>오류 메시지:</strong></p>
                <p>
                <!-- 조건문 간소화 -->
                    <c:choose>
                        <c:when test="${not empty errorMessage}">
                            ${errorMessage}
                        </c:when>
                        <c:otherwise>
                            알 수 없는 오류가 발생했습니다.
                        </c:otherwise>
                    </c:choose>
                </p>
            </div>

            <div class="mt-4">
                <a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로 돌아가기</a>
            </div>
        </main>

        <%@include file="/resources/static/jsp/footer.jsp" %>
    </div>
    
</body>
</html>
