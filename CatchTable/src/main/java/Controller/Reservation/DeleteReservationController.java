package Controller.Reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Service.ReservationServiceImpl;

public class DeleteReservationController implements SubController {

    private ReservationServiceImpl reservationService;

    public DeleteReservationController() {
        reservationService = ReservationServiceImpl.getInstance();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 요청 방식 확인
            if (req.getMethod().equalsIgnoreCase("GET")) {
                // GET 요청 시 삭제할 예약 ID를 입력받는 폼 페이지로 이동
                req.getRequestDispatcher("/WEB-INF/view/reservation/deleteReservation.jsp").forward(req, resp);
            } else if (req.getMethod().equalsIgnoreCase("POST")) {
                // POST 요청 시 삭제 처리
                String reservationIdStr = req.getParameter("reservationId");

                if (reservationIdStr == null || reservationIdStr.isEmpty()) {
                    req.setAttribute("errorMessage", "예약 ID가 유효하지 않습니다.");
                    req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
                    return;
                }

                // 예약 ID 파싱 및 삭제 처리
                int reservationId = Integer.parseInt(reservationIdStr);
                boolean isDeleted = reservationService.deleteReservation(reservationId);

                if (isDeleted) {
                    resp.sendRedirect(req.getContextPath() + "/deleteSuccess.jsp");
                } else {
                    req.setAttribute("errorMessage", "삭제할 예약을 찾을 수 없습니다.");
                    req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                req.setAttribute("errorMessage", "예약 삭제 중 오류가 발생했습니다.");
                req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
