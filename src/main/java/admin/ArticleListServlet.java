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
 *         Created at 2016/12/30
 */
@WebServlet(
        name = "articleListServlet",
        urlPatterns = "/admin/article/list"
)
public class ArticleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("delete_id") != null){
            ArticleDao.deleteArticle(Long.parseLong(req.getParameter("delete_id")));
        }

        req.setAttribute("articles", ArticleDao.getAllArticles());
        req.getRequestDispatcher("/WEB-INF/jsp/admin/articleList.jsp")
                .forward(req,resp);
    }
}
