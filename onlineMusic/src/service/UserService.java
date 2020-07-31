package service;

import dao.UserDao;
import entity.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 前期准备：
 * User: GAOBO
 * Date: 2020-07-27
 * Time: 19:48
 */
public class UserService {

    public User login(User loginUser) {
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }




}