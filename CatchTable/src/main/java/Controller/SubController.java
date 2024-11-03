package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

public interface SubController {
    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
    
}
