package admin;

import db.AccountManager;
import db.ArticleDao;
import model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;

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

        req.setCharacterEncoding("GBK");
        req.getRequestDispatcher("/WEB-INF/jsp/admin/articlePost.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article = new Article();
        article.setTitle(new String(req.getParameter("article-title").getBytes("ISO8859_1"),"GB2312"));
        article.setType(req.getParameter("article-type"));
        article.setMdContent(req.getParameter("article-content"));
        article.setMdContent(req.getParameter("article-content"));
        article.setLabels(Arrays.asList(req.getParameter("article-labels").split(",")));
        article.setCreatedAt(GregorianCalendar.getInstance().getTime());
        ArticleDao.insertArticle(article);
        doGet(req,resp);
    }
}
