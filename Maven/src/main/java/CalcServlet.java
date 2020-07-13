import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        int a = Integer.valueOf(aStr);
        int b = Integer.valueOf(bStr);
        int res = a+b;
        resp.getWriter().write(String.format("<h1> res=%d </h1>",res));

    }
}
