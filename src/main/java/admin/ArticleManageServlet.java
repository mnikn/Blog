package admin;

import db.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/22
 */
@WebServlet(
        name = "articleManageServlet",
        urlPatterns = "/admin/article-manage"
)
public class ArticleManageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("articles", ArticleDao.getAllArticles());
        req.getRequestDispatcher("/WEB-INF/jsp/admin/articleManage.jsp")
                .forward(req,resp);
    }
}
