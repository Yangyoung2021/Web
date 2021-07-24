package admin;

import cn.project.dao.impl.UserDaoImpl;
import cn.project.domain.Admin;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void testLogin(){
        Admin admin = new Admin();
        admin.setUsername("张三");
        admin.setPassword("12345");
        UserDaoImpl u = new UserDaoImpl();
        Admin login = u.login(admin);
        System.out.println(login);
    }
}
