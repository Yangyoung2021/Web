package cn.project.web.servlet;

import cn.project.service.UserService;
import cn.project.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delServlet")
public class DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserServiceImpl();

        //获取选中的id
        String id = request.getParameter("id");
        int index = Integer.parseInt(id);

        //调用Service里的del方法
        service.delete(index);

        //跳转至list.jsp
        response.sendRedirect(request.getContextPath()+"/FindByPageServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
