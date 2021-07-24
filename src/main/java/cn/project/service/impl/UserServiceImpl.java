package cn.project.service.impl;

import cn.project.dao.UserDao;
import cn.project.dao.impl.UserDaoImpl;
import cn.project.domain.PageBean;
import cn.project.domain.User;
import cn.project.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public void delete(int index) {
        userDao.delete(index);
    }

    @Override
    public User find(int index) {
        return userDao.find(index);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelected(String[] values) {
        for (String value : values) {
            int index = Integer.parseInt(value);
            userDao.delete(index);
        }
    }


    @Override
    public PageBean<User> findByPage(PageBean<User> pageBean, User user) {
        // 将pageBean里参数全部完善,
        // 已有参数：rows、currentPage
        // 剩余未获取参数：pageCount、List集合、totalCount

        //1.调用userDao获取totalCount
        /*
         int start = (pageBean.getCurrentPage() - 1)* pageBean.getRows();
        pageBean.setRows(rows);
        pageBean.setCurrentPage(currentPage);

        int totalCount = userDao.retrieveCount(user ,start,rows);
        pageBean.setTotalCount(userDao.retrieveCount(user,start,rows));

        //2.计算pageCount
        int pageCount = totalCount % pageBean.getRows() == 0 ?
                totalCount / pageBean.getRows() : totalCount / pageBean.getRows()+1;

        pageBean.setPageCount(pageCount);

        //3.调用userDao获取list集合


        List<User> list = userDao.retrieveList(user , start , pageBean.getRows());

        pageBean.setList(list);


        return pageBean;
         */
        int start = (pageBean.getCurrentPage() - 1)* pageBean.getRows();
        int totalCount = userDao.getCount(user,start,pageBean);
        pageBean.setTotalCount(totalCount);

        //2.计算pageCount
        int pageCount = totalCount % pageBean.getRows() == 0 ?
                totalCount / pageBean.getRows() : totalCount / pageBean.getRows()+1;
        pageBean.setPageCount(pageCount);

        //3.调用userDao获取list集合

        List<User> list = userDao.getPageList(user,start,pageBean.getRows());
        pageBean.setList(list);

        return pageBean;
    }


}
