//package cn.project.web.servlet;
//
//import cn.project.domain.PageBean;
//import cn.project.domain.User;
//import cn.project.service.UserService;
//import cn.project.service.impl.UserServiceImpl;
//import org.apache.commons.beanutils.BeanUtils;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Map;
//
//@WebServlet("/retrieveServlet")
//public class RetrieveServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置编码
//        request.setCharacterEncoding("utf-8");
//
//        //获取UserService对象
//        UserService service = new UserServiceImpl();
//
//        //根据键获取值,并将值封装成user对象
//        String rows = request.getParameter("rows");
//        String currentPage = request.getParameter("currentPage");
//
//        if(currentPage == null || "".equalsIgnoreCase(currentPage) ||
//                Integer.parseInt(currentPage) <= 0){
//            currentPage = "1";
//        }
//        if(rows == null || "".equalsIgnoreCase(rows)){
//            rows = "5";
//        }
//
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        User user = new User();
//        try {
//            BeanUtils.populate(user,parameterMap);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        //调用UserService的retrieve方法
//        PageBean<User> retrievePb = service.retrieve(user,Integer.parseInt(rows),Integer.parseInt(currentPage));
//
//        //将retrievePb传给展示
//        request.setAttribute("up",retrievePb);
//        request.setAttribute("us",user);
//        request.getRequestDispatcher("/list.jsp").forward(request,response);
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request, response);
//    }
//}
