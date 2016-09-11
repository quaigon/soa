package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "BrowserFilter")
public class BrowserFilter implements Filter {

    String[] DISALLOWED_BROWSERS = new String[]{"Firefox"};

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");

        for(String browser: DISALLOWED_BROWSERS){
            if(userAgent.contains(browser)){
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect("/login/wrongBrowser");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}