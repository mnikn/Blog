import model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
        ArrayList<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setIntro("Unix是一个多用户系统，如上图。但是由于多个用户使用一个系统，因此必须有一种机制防止用户之间操作不会受到干扰。同时，Unix必须为程序提供一系列的操作接口，我们以一个键盘输入为例。键盘的输入必须通过操作系统(也成为内核)的请求。 接下来我们来说一下用户登录到系统时的情况。在登录过程中，当用户登录时 ...");
        article.setTitle("Learn Linux by doing it -- Introduction");
        article.setType("Coding");
        article.setCreatedAt(GregorianCalendar.getInstance().getTime());
        articles.add(article);
        articles.add(article);
        articles.add(article);

        req.setAttribute("articles",articles);
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp")
                .forward(req,resp);
    }
}
