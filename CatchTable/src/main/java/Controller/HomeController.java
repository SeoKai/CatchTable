package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			System.out.println("[홈 컨트롤러] GET /");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (Exception e) {
			// 에러 발생시 error.jsp로 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
		
	}

}
