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
import java.util.Set;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService service = new UserServiceImpl();
        if(request.getParameter("name") == null || request.getParameter("name").length() <= 0){
            request.setAttribute("error","姓名不能为空！！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }else if (request.getParameter("gender") == null || request.getParameter("gender").length() <= 0){
            request.setAttribute("error","性别不能为空！！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }else if (request.getParameter("age") == null || request.getParameter("age").length() <= 0){
            request.setAttribute("error","年龄不能为空！！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }else if (request.getParameter("address") == null || request.getParameter("address").length() <= 0){
            request.setAttribute("error","地址不能为空！！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }else if (request.getParameter("qq") == null || request.getParameter("qq").length() <= 0){
            request.setAttribute("error","qq不能为空！！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }else if (request.getParameter("email") == null || request.getParameter("email").length() <= 0){
            request.setAttribute("error","邮箱不能为空！！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }else{
            Map<String, String[]> parameterMap = request.getParameterMap();

//            Set<String> strings = parameterMap.keySet();
//            for (String string : strings) {
//                String strings1 = parameterMap.get(string)[0];
//                if ("".equals(strings1) || parameterMap.size() != 6 ){
//                    request.setAttribute("error","请补全用户信息");
//                    request.getRequestDispatcher("/add.jsp").forward(request,response);
//                }
//            }


//            String name = request.getParameter("name");
//            System.out.println(name);

            User user = new User();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            service.add(user);

            response.sendRedirect(request.getContextPath()+"/FindByPageServlet");

        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
