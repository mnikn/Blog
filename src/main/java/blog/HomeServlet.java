package blog;

import model.Article;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/16
 */
@WebServlet(
        name = "homeServlet",
        urlPatterns = "/home"
)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("articles",readArticles());
        req.getRequestDispatcher("/WEB-INF/jsp/blog/home.jsp")
                .forward(req,resp);
    }

    private List<Article> readArticles() throws IOException {
        File dir = new File(getServletContext().getRealPath("/resources/article"));
        File[] files = dir.listFiles();

        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        List<Article> articles = new ArrayList<>();
        if(files != null){
            for(File file : files){
                FileInputStream inputStream = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                inputStream.read(data);
                inputStream.close();

                String fileStr = new String(data,"utf-8");
                Article article = new Article();
                article.setCreatedAt(GregorianCalendar.getInstance().getTime());
                article.setType("Coding");
                article.setTitle("Programming");
                article.setContent(renderer.render(parser.parse(fileStr)));
                articles.add(article);
            }
        }

        return articles;
    }
}
