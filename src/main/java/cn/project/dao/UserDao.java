package cn.project.dao;

import cn.project.domain.PageBean;
import cn.project.domain.User;

import java.util.List;

/**
 * 用户连接数据库的接口
 */
public interface UserDao {
    List<User> findAll();

    int add(User user);

    void delete(int index);

    User find(int index);

    void update(User user);

    int getCount(User user, int start, PageBean<User> pageBean);


    List<User> getPageList(User user, int start, int rows);

}
