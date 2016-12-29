package admin;

import db.AccountManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/26
 */
@WebServlet(
        name = "articlePostServlet",
        urlPatterns = "/admin/article/post"
)
public class ArticlePostServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("types", AccountManager.getTypes());
        req.setAttribute("labels", AccountManager.getLabelTypes());
        req.getRequestDispatcher("/WEB-INF/jsp/admin/articlePost.jsp")
                .forward(req,resp);
    }
}
