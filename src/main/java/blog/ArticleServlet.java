package blog;

import db.ArticleDao;
import model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/16
 */
@WebServlet(
        urlPatterns = "/home/article"
)

public class ArticleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article =
                ArticleDao.getArticle(Long.parseLong(req.getParameter("id")));
        req.setAttribute("article",article);
        req.getRequestDispatcher("/WEB-INF/jsp/blog/article.jsp")
                .forward(req,resp);
    }
}
