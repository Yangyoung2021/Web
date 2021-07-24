package cn.project.web.filter;

import cn.project.domain.Admin;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1.强制向下转型
        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();

        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/js/") ||
         uri.contains("/css/") || uri.contains("/font/") || uri.contains("/checkCode")){
            //访问登录相关资源，应当放行
            chain.doFilter(request,response);
        }else{
            //检查是否携带证明，有则放行，没有就跳转到登录页面
            HttpSession session = req.getSession();
            Admin admin = (Admin) session.getAttribute("admin");
//            Admin admin = (Admin) request.getAttribute("admin");
            if(admin != null){
                //有相关证明，应当放行
                chain.doFilter(request,response);
            }else{
                request.setAttribute("login_msg","您还没有登录，请先登录！！！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }

    }
}
