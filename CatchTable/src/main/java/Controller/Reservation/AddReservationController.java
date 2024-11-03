package Controller.Reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.SubController;
import Model.Dto.Reservation;
import Service.ReservationServiceImpl;

public class AddReservationController implements SubController {

    private ReservationServiceImpl reservationService;

    public AddReservationController() {
        reservationService = ReservationServiceImpl.getInstance();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getMethod().equalsIgnoreCase("GET")) {
                req.getRequestDispatcher("/WEB-INF/view/reservation/addReservation.jsp").forward(req, resp);
                return;
            }

            String restaurantName = req.getParameter("restaurantName");
            String customerName = req.getParameter("customerName");
            int numberOfPeople = Integer.parseInt(req.getParameter("numberOfPeople"));
            java.sql.Date reservationDate = java.sql.Date.valueOf(req.getParameter("reservationDate"));
            String reservationTimeString = req.getParameter("reservationTime");

            if (reservationTimeString != null && reservationTimeString.length() == 5) {
                reservationTimeString += ":00";
            }
            java.sql.Time reservationTime = java.sql.Time.valueOf(reservationTimeString);

            Reservation reservation = new Reservation(restaurantName, reservationDate, reservationTime, customerName, numberOfPeople);

            int reservationId = reservationService.addReservation(reservation);

            req.setAttribute("reservationId", reservationId);
            req.setAttribute("reservation", reservation);
            req.getRequestDispatcher("/WEB-INF/view/reservation/reservationSuccess.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                req.setAttribute("errorMessage", "예약 추가 중 오류가 발생했습니다.");
                req.getRequestDispatcher("/WEB-INF/view/reservation/error.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
