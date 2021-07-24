package cn.project.service;

import cn.project.domain.PageBean;
import cn.project.domain.User;

import java.util.List;

public interface UserService {
     List<User> findAll();
    int add(User user);

    void delete(int index);

    User find(int index);

    void update(User user);

    void delSelected(String[] values);

    PageBean<User> findByPage(PageBean<User> pageBean, User user);
}
