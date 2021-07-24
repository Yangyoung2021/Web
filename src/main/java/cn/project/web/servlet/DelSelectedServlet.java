package cn.project.web.servlet;

import cn.project.service.UserService;
import cn.project.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取UserService对象
        UserService service = new UserServiceImpl();

        //获取values数组
        String[] values = request.getParameterValues("delSel");

        //调用UserService的deleteSelected方法
        service.delSelected(values);

        //跳转到ListServlet
        response.sendRedirect(request.getContextPath()+"/FindByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
