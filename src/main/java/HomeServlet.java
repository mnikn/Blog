import db.AccountManager;
import db.ArticleDao;
import model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/25
 */
@WebServlet(
        name = "homeServlet",
        urlPatterns = ""
)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = ArticleDao.getAllArticles();

        ArticleDao.updateTypes();
        ArticleDao.updateLabelTypes();
        req.setAttribute("articles",articles);
        req.setAttribute("types", AccountManager.getTypes());
        req.setAttribute("labels", AccountManager.getLabelTypes());
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
