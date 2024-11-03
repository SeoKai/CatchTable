package Controller.Reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Model.Dto.Reservation;
import Service.ReservationServiceImpl;

public class SelectReservationController implements SubController {

    private ReservationServiceImpl reservationService;

    public SelectReservationController() {
        // 예약 서비스 인스턴스 초기화
        reservationService = ReservationServiceImpl.getInstance();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 요청 방식이 GET일 때 조회 폼을 표시
            if (req.getMethod().equalsIgnoreCase("GET")) {
                req.getRequestDispatcher("/WEB-INF/view/reservation/selectReservation.jsp").forward(req, resp);
                return;
            }

            // POST 요청으로 예약 ID를 받아서 조회
            int reservationId = Integer.parseInt(req.getParameter("reservationId"));

            // 서비스 호출을 통해 예약 정보 조회
            Reservation reservation = reservationService.getReservation(reservationId);

            if (reservation == null) {
                // 예약 정보를 찾을 수 없는 경우, 에러 메시지를 설정하고 에러 페이지로 포워딩
                req.setAttribute("errorMessage", "예약 정보를 찾을 수 없습니다.");
                req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
            } else {
                // 조회한 예약 정보를 request 객체에 설정하여 JSP로 전달
                req.setAttribute("reservation", reservation);
                req.getRequestDispatcher("/WEB-INF/view/reservation/viewReservation.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "유효한 예약 ID를 입력해 주세요.");
            try {
                req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                // 예외가 발생하면 에러 메시지를 설정하고 에러 페이지로 포워딩
                req.setAttribute("errorMessage", "예약 조회 중 오류가 발생했습니다.");
                req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
