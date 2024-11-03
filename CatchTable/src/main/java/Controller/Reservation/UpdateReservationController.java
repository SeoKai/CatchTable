package Controller.Reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.SubController;
import Model.Dto.Reservation;
import Service.ReservationServiceImpl;

public class UpdateReservationController implements SubController {

    private ReservationServiceImpl reservationService;

    public UpdateReservationController() {
        reservationService = ReservationServiceImpl.getInstance();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String method = req.getMethod();
            if ("GET".equalsIgnoreCase(method)) {
                // GET 요청 시 ID로 예약 정보 수정 폼 페이지로 이동
                req.getRequestDispatcher("/WEB-INF/view/reservation/editReservation.jsp").forward(req, resp);
            } else if ("POST".equalsIgnoreCase(method)) {
                // POST 요청 시 수정할 예약 정보를 받아 업데이트 처리
                int reservationId = Integer.parseInt(req.getParameter("reservationId"));
                String restaurantName = req.getParameter("restaurantName");
                String customerName = req.getParameter("customerName");
                int numberOfPeople = Integer.parseInt(req.getParameter("numberOfPeople"));
                java.sql.Date reservationDate = java.sql.Date.valueOf(req.getParameter("reservationDate"));

                // 예약 시간 형식 변환
                String reservationTimeString = req.getParameter("reservationTime");
                if (reservationTimeString != null && reservationTimeString.length() == 5) {
                    reservationTimeString += ":00";
                }
                java.sql.Time reservationTime = java.sql.Time.valueOf(reservationTimeString);

                Reservation reservation = new Reservation(reservationId, restaurantName, reservationDate, reservationTime, customerName, numberOfPeople);

                // 예약 수정 서비스 호출
                reservationService.updateReservation(reservation);

                // 예약 수정 정보를 request에 저장 후, 성공 페이지로 forward
                req.setAttribute("reservation", reservation);
                req.getRequestDispatcher("/WEB-INF/view/reservation/reservationSuccess.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                req.setAttribute("errorMessage", "예약 수정 중 오류가 발생했습니다.");
                req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
