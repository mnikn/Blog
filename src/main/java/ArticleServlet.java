import db.AccountManager;
import db.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/28
 */
@WebServlet(
        name = "articleServlet",
        urlPatterns = "/article/*"
)
public class ArticleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        long id = Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
        req.setAttribute("article", ArticleDao.getArticle(id));
        req.setAttribute("types", AccountManager.getTypes());
        req.setAttribute("labels", AccountManager.getLabelTypes());
        req.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(req,resp);
    }
}
