package cn.project.dao.impl;

import cn.project.dao.UserDao;
import cn.project.domain.Admin;
import cn.project.domain.PageBean;
import cn.project.domain.User;
import cn.project.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }


    public Admin login(Admin admin) {
        try {
            String sql = "select * from admin where username = ? and password = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(Admin.class),
                    admin.getUsername(),admin.getPassword());
        } catch (DataAccessException e) {
            System.out.println("用户名或密码错误！！！");
            return null;
        }
    }

    @Override
    public int add(User user) {
        String sql = "insert into user values (null,?,?,?,?,?,?)";
        Object[] args = {user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail()};

        return template.update(sql, args);
    }

    @Override
    public void delete(int index) {
        String sql = "delete from user where id = ?";
        template.update(sql,index);
    }

    @Override
    public User find(int index) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),index);
    }

    @Override
    public void update(User user) {
        String sql = "update user set  name = ? , gender = ? , age = ? ," +
                "address = ? , qq = ? , email = ? where id =?";

        Object[] args = {user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail(),user.getId()};

        template.update(sql, args);
    }



    @Override
    public int getCount(User user, int start, PageBean<User> pageBean) {

        StringBuilder sql = new StringBuilder("select count(*) from user where 1 = 1 ");

        if(user.getName() != null &&  !"".equals(user.getName())){
            sql.append(" and name like '%").append(user.getName()).append("%'");
        }
        if (user.getAddress() != null && !"".equals(user.getAddress())){
            sql.append(" and address like '%").append(user.getAddress()).append("%'");
        }
        if (user.getEmail() != null && !"".equals(user.getEmail())){
            sql.append(" and email like '%").append(user.getEmail()).append("%'");
        }

        if(user.getName() != null && !"".equals(user.getName())
        && user.getAddress() != null && !"".equals(user.getAddress())
        && user.getEmail() != null && !"".equals(user.getEmail())){
            String l = " limit ? , ?";
            String s = sql.append(l).toString();
            return template.queryForObject(s,Integer.class,start,pageBean.getRows());
        }else{
            return template.queryForObject(sql.toString(),Integer.class);
        }

    }








    @Override
    public List<User> getPageList(User user,int start , int rows) {
        StringBuilder sql = new StringBuilder("select * from user where 1 = 1  ");

        if(user.getName() != null &&  !"".equals(user.getName())){
            sql.append(" and name like '%").append(user.getName()).append("%'");
        }
        if (user.getAddress() != null && !"".equals(user.getAddress())){
            sql.append(" and address like '%").append(user.getAddress()).append("%'");
        }
        if (user.getEmail() != null && !"".equals(user.getEmail())){
            sql.append(" and email like '%").append(user.getEmail()).append("%'");
        }

        if(user.getName() != null && !"".equals(user.getName())
                && user.getAddress() != null && !"".equals(user.getAddress())
                && user.getEmail() != null && !"".equals(user.getEmail())){
            String s = sql.append(" limit ? , ?").toString();

            System.out.println(s);

            return template.query(s,new BeanPropertyRowMapper<>(User.class),start,rows);
        }else{
            String s = sql.append(" limit ? , ?").toString();
            return template.query(s,new BeanPropertyRowMapper<>(User.class),start,rows);
        }

    }

}
