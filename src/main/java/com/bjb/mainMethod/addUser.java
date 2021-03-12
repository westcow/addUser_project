package com.bjb.mainMethod;

import com.bjb.dao.AreaDao;
import com.bjb.dao.UserDao;
import com.bjb.dao.VolunteerDao;
import com.bjb.entity.Area;
import com.bjb.entity.User;
import com.bjb.entity.Volunteer;
import com.bjb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
public class addUser {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUserCode(UUID.randomUUID().toString().replaceAll("-",""));
        user.setUserName("王大锤");
        user.setRoleId(10);
        user.setCreatDate(new Date());
        user.setPassword("54454354");
        user.setMobilePhone("1445431314");
        user.setIdentification("43746743434837484354");
        user.setProvinceCode(52);
        user.setCityCode(getAreaBySuper(user.getProvinceCode()).getAreaCode());
        user.setCountyCode(getAreaBySuper(user.getCityCode()).getAreaCode());
        user.setProvinceName(getAreaByCode(user.getProvinceCode()).getAreaName());
        user.setCityName(getAreaBySuper(user.getProvinceCode()).getAreaName());
        user.setCountyName(getAreaBySuper(user.getCityCode()).getAreaName());
        user.setGender("男");
        user.setStatus(1);
        user.setAuditStatus(1);
        user.setIdMd5(UUID.randomUUID().toString().replaceAll("-",""));
        user.setActiveStatus(1);
        user.setIdentity(2);
        userDao.addUser(user);

        VolunteerDao volunteerDao = sqlSession.getMapper(VolunteerDao.class);
        Volunteer volunteer = new Volunteer();
        volunteer.setUserId(user.getUserId());
        volunteer.setServiceProvinceCode(user.getProvinceCode());
        volunteer.setServiceCityCode(user.getCityCode());
        volunteer.setServiceCountyCode(user.getCountyCode());
        volunteer.setServiceProvinceName(user.getProvinceName());
        volunteer.setServiceCityName(user.getCityName());
        volunteer.setServiceCountyName(user.getCountyName());
        volunteerDao.insertVolunteer(volunteer);
        sqlSession.close();
    }

    private static Area getAreaBySuper(Integer areaCode) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AreaDao areaDao = sqlSession.getMapper(AreaDao.class);
        List<Area> areaList = areaDao.getAreaListBySuperiorCode(areaCode);
        Random random = new Random();
        return areaList.get(random.nextInt(areaList.size()));
    }

    private static Area getAreaByCode(Integer areaCode) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AreaDao areaDao = sqlSession.getMapper(AreaDao.class);
        return areaDao.getAreaByAreaCode(areaCode);
    }

    private static String getUserName() {
        /*
        李 王 张 刘 陈 杨 赵 黄
        周 吴 徐 孙 胡 朱 高 林
        何 郭 马 罗 梁 宋 郑
         */
        Map<HashMap<Integer, Integer>, Object> map = new HashMap<HashMap<Integer, Integer>, Object>();
        HashMap<Integer, Integer> chanceMap = new HashMap<Integer, Integer>();
        chanceMap.
        map.put(1, "李");
        map.put(2, "王");
        map.put(3, "张");
        map.put(4, "刘");
        map.put(5, "陈");
        map.put(6, "杨");
        map.put(7, "赵");
        map.put(8, "黄");
        map.put(9, "周");
        map.put(10, "吴");
        map.put(11, "徐");
        map.put(12, "孙");
        map.put(13, "胡");
        map.put(14, "朱");
        map.put(15, "高");
        map.put(16, "林");
        map.put(17, "何");
        map.put(18, "郭");
        map.put(19, "马");
        map.put(20, "罗");
        map.put(21, "梁");
        map.put(22, "宋");
        map.put(23, "郑");

    }

}
