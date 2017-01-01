package admin;

import db.AccountManager;
import db.ArticleDao;
import model.Article;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

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

        if(req.getParameter("id") != null){
           req.setAttribute("article",
                   ArticleDao.getArticle(Long.parseLong(req.getParameter("id"))));
        }

        req.setAttribute("types", AccountManager.getTypes());
        req.setAttribute("labels", AccountManager.getLabelTypes());

        req.setCharacterEncoding("GBK");
        req.getRequestDispatcher("/WEB-INF/jsp/admin/articlePost.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article = new Article();
        article.setTitle(new String(req.getParameter("article-title").getBytes("ISO8859-1"),
                "UTF-8"));
        article.setType(new String(req.getParameter("article-type").getBytes("ISO8859-1"),
                "UTF-8"));
        article.setMdContent(new String(req.getParameter("article-content").getBytes("ISO8859-1"),
                "UTF-8"));

        Parser parser = Parser.builder().build();
        HtmlRenderer render = new HtmlRenderer.Builder().build();
        article.setHtmlContent(render.render(parser.parse(article.getMdContent())));

        Scanner scanner = new Scanner(article.getHtmlContent());
        String intro = "";
        int i = 0;
        while (scanner.hasNext() && i++ != 3){
            intro += scanner.nextLine();
        }
        article.setIntro(intro);


        List<String> labels = new ArrayList<>();
        for(String str : req.getParameter("article-labels").split(",")){
            labels.add(new String(str.getBytes("ISO8859-1"),
                    "UTF-8"));
        }
        article.setLabels(labels);
        article.setCreatedAt(GregorianCalendar.getInstance().getTime());


        if(req.getParameter("id") != null){
            article.setId(Long.parseLong(req.getParameter("id")));
            ArticleDao.updateArticle(article);
        }
        else{
            ArticleDao.insertArticle(article);
        }
        doGet(req,resp);
    }
}
