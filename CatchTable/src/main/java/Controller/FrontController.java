package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Reservation.AddReservationController;
import Controller.Reservation.DeleteReservationController;
import Controller.Reservation.SelectReservationController;
import Controller.Reservation.UpdateReservationController;

public class FrontController extends HttpServlet {

    private Map<String, SubController> map = new HashMap<>();

    @Override
    public void init() throws ServletException {
        System.out.println("[프론트 컨트롤러] init 구동");

        // HOME
        map.put("/", new HomeController());

        // Reservation 관련 요청 매핑
        map.put("/add", new AddReservationController());
        map.put("/select", new SelectReservationController());
        map.put("/update", new UpdateReservationController());
        map.put("/delete", new DeleteReservationController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 URI에서 Context Path를 제외한 상대 경로로 요청을 처리
        String endPoint = req.getRequestURI().substring(req.getContextPath().length());
        System.out.println("요청된 엔드포인트: " + endPoint);

        SubController controller = map.get(endPoint);

        if (controller != null) {
            // 적절한 서브 컨트롤러로 요청을 전달
            controller.execute(req, resp);
        } else {
            // 매핑되지 않은 엔드포인트 처리
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "페이지를 찾을 수 없습니다.");
        }
    }
}
