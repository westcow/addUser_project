package com.bjb.dao;

import com.bjb.entity.User;
import com.bjb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Calendar;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
public class UserDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession("dev");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.queryUser(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession("dev");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setUserName("王大锤");
        u.setPassword("54454354");
        Integer num = userDao.addUser(u);
        System.out.println(num);
        sqlSession.close();
    }

    @Test
    public void testGetYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
    }

}
