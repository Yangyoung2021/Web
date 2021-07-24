package cn.project.web.servlet;

import cn.project.domain.PageBean;
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

@WebServlet("/FindByPageServlet")
public class FindByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取UserService对象
        UserService service = new UserServiceImpl();
        request.setCharacterEncoding("utf-8");

        //2.通过request对象获取rows和currentPage,并将其封装到PageBean对象和User对象中
        PageBean<User> pageBean = new PageBean<>();
        String currentPages = request.getParameter("currentPage");
        String row = request.getParameter("rows");

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");


        if(currentPages == null || "".equalsIgnoreCase(currentPages) ||
                Integer.parseInt(currentPages) <= 0){
            currentPages = "1";
        }
        if(row == null || "".equalsIgnoreCase(row)){
            row = "5";
        }

        int currentPage = Integer.parseInt(currentPages);
        int rows = Integer.parseInt(row);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setEmail(email);

        //3.调用UserService里的findByPage方法
        PageBean<User> userPage = service.findByPage(pageBean,user);

        //4.将userPage传给list.jsp
        request.setAttribute("up",userPage);
        request.setAttribute("us",user);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
