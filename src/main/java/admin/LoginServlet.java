package admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/25
 */
@WebServlet(
        name = "loginServlet",
        urlPatterns = "/login"
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("logout") != null){
            req.getSession().invalidate();
        }
        else if(req.getSession().getAttribute("username") != null){
            resp.sendRedirect("admin");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username != null
                && password != null
                && username.equals(Constants.loginUsername)
                && password.equals(Constants.loginPassword)){
            req.getSession().setAttribute("username",username);
            req.changeSessionId();
            resp.sendRedirect("admin");
        }
        else{
            req.setAttribute("loginFailed",true);
            req.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp")
                    .forward(req,resp);
        }
    }
}
