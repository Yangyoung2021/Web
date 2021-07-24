package cn.project.web.servlet;

import cn.project.domain.User;
import cn.project.service.UserService;
import cn.project.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/findModifyServlet")
public class FindModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserServiceImpl();

        //获取当前user的ID
        String id = request.getParameter("id");
        int index = Integer.parseInt(id);

        //调用find方法
        User user = service.find(index);

        //将user对象转发给显示页面
        HttpSession session = request.getSession();
        session.setAttribute("find_user",user);

//        request.setAttribute("find_user",user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
