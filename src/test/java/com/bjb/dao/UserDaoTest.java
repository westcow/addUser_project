package com.bjb.dao;

import com.bjb.entity.User;
import com.bjb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.queryUser(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setUserName("王大锤");
        u.setPassword("54454354");
        Integer num = userDao.addUser(u);
        System.out.println(num);
        sqlSession.close();
    }

}
