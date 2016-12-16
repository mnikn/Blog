package blog;

import model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/16
 */
@WebServlet(
        urlPatterns = "/home/article/*"
)

public class ArticleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article = new Article();
        article.setTitle("易中天中华史-1-祖国");
        article.setType("reading");
        article.setCreatedAt(GregorianCalendar.getInstance().getTime());
        article.setContent("从前，盘古开天辟地，从混沌中创造出了世界。盘古死后，他的身体化成了世界的一部分。此后便是我们熟知的女娲造人的故事，不过接下来说的事情可能和我们所听到的不同，可以姑且听之，姑且信之。\n" +
                "\n" +
                "我们要先说亚当和夏娃的故事。上帝造出了亚当以后，从亚当中拿出了一根肋骨，造出了夏娃。然后夏娃在蛇的诱惑下，偷吃禁果，从而人类有了羞耻心，也因此有了生育繁衍活动。我们把夏娃认为是人类最早的女人，是原始群。\n" +
                "\n" +
                "女娲是夏娃的成熟阶段，即代表母亲。女娲的诞生意味着母系社会的到来，这时候有生殖崇拜，因此女人占着主导地位，一个女人可以有多位性伴侣。女娲的形象是蛙，这也是为什么”娲”读作”wa”，因为这实际上是”蛙”的变形，同时蛙也是母亲的象征，因为蛙的肚子大，这个和女人怀孕时的情景一样。这可能和我们的印象不同，因为我们认为女娲是人面蛇身，其中缘故会接下来再说。\n" +
                "\n" +
                "随着人类的繁衍，出现了一位我们很熟悉的人物————伏羲。伏羲实际上是牧羊人，因此他主导着祭奠，掌管食物的任务。因此他的地位也越来越高，这也代表着男人的地位越来越高，经过一些事件，我们就从母系社会过渡到父系社会。同时刚得到权力的男人为了让自己得到的权力名正言顺，把男人的象征————蛇强加到女娲上。\n" +
                "\n" +
                "在父系社会的发展中，部落时代的象征炎帝出现了。他是一位部落的首领，他的部落的图腾原本是羊，但是作为图腾来说羊太和善了，因此部落的图腾便从羊改为牛。随后黄帝和蚩尤出现了。这三位老祖先不停争斗，最后黄帝取得了胜利。\n" +
                "\n" +
                "随后，大部落分解为一个个小部落，但他们各自联合在一起，因此称为部落联盟。尧和舜通过选举相继做了首领，最后因为大禹的治水功绩，禅让给禹。禹过后首领位置为禹的儿子启，最后启废除了禅让制，成立了中国第一个国家，夏。");
        req.setAttribute("article",article);
        req.getRequestDispatcher("/WEB-INF/jsp/blog/article.jsp")
                .forward(req,resp);
    }
}
