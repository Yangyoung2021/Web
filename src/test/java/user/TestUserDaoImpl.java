package user;

import cn.project.dao.impl.UserDaoImpl;
import cn.project.domain.PageBean;
import cn.project.domain.User;
import cn.project.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

public class TestUserDaoImpl {

    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void testGetCount(){
        User user = new User();
        int start = 0;
        PageBean<User> pageBean = new PageBean<>();

        int count = userDao.getCount(user, start, pageBean);
        System.out.println(count);
    }

    @Test
    public void testFindByPage(){
        User user = new User();
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(5);
        pageBean.setCurrentPage(1);

        UserServiceImpl service = new UserServiceImpl();
        PageBean<User> page = service.findByPage(pageBean,user);
        System.out.println(page.getList());

    }
}
