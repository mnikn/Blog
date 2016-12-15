import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/15
 */
@WebFilter(
        urlPatterns = {"/admin"}
)
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if(session == null || session.getAttribute("username") == null){
            ((HttpServletResponse) servletResponse).sendRedirect("login");
        }
        else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
     }

    @Override
    public void destroy() {

    }
}
