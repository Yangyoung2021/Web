package cn.project.web.servlet;

import cn.project.domain.User;
import cn.project.service.UserService;
import cn.project.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        if(request.getParameter("name") == null || request.getParameter("name").length() <= 0){
            run(request,response);
        }else if (request.getParameter("gender") == null || request.getParameter("gender").length() <= 0){
            run(request,response);
        }else if (request.getParameter("age") == null || request.getParameter("age").length() <= 0){
            run(request,response);
        }else if (request.getParameter("address") == null || request.getParameter("address").length() <= 0){
            run(request,response);
        }else if (request.getParameter("qq") == null || request.getParameter("qq").length() <= 0){
            run(request,response);
        }else if (request.getParameter("email") == null || request.getParameter("email").length() <= 0){
            run(request,response);
        }else{
            //获取UserService对象
            UserService service = new UserServiceImpl();

            User find_user = (User) request.getSession().getAttribute("find_user");

            //获取之前页面的值,将数据包装成user对象
            User user = new User();
            Map<String, String[]> parameterMap = request.getParameterMap();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            user.setId(find_user.getId());

            //调用Service对象的update方法
            service.update(user);

            //跳转到ListServlet
            response.sendRedirect(request.getContextPath()+"/FindByPageServlet");
        }

    }
    private void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
