package cn.project.web.servlet;

import cn.project.dao.impl.UserDaoImpl;
import cn.project.domain.Admin;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");

        //获得UserDaoImpl对象
        UserDaoImpl userDao = new UserDaoImpl();

        //获取session对象
        HttpSession session = req.getSession();


        //从request中获得提交的信息
        String vcode = req.getParameter("verifycode");

        //从session中获得提交的是验证码
        String checkCode = (String) req.getSession().getAttribute("CHECKCODE_SERVER");

        //校验验证码
        if(!checkCode.equalsIgnoreCase(vcode)){
            req.setAttribute("login_msg","验证码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        session.removeAttribute("CHECKCODE_SERVER");//确保session一次性使用
        //将信息封装到admin对象中
        Admin admin = new Admin();
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        admin.setPassword(password);
//        admin.setUsername(username);
//        admin.setId(1);
        Map<String, String[]> parameterMap = req.getParameterMap();

        try {
            BeanUtils.populate(admin,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用login方法
        Admin login = userDao.login(admin);

        if(login != null){

            session.setAttribute("admin",login);
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
//            req.getRequestDispatcher("/index.jsp");
        }else{
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
