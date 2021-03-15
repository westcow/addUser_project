package com.bjb.mainMethod;

import com.bjb.dao.AreaDao;
import com.bjb.dao.UserDao;
import com.bjb.dao.VolunteerDao;
import com.bjb.entity.Area;
import com.bjb.entity.User;
import com.bjb.entity.Volunteer;
import com.bjb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
public class addUser {
//    public static void main(String[] args) {
    public static void add() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUserCode(UUID.randomUUID().toString().replaceAll("-",""));
        String userName = getUserName();
        user.setUserName(userName);
        user.setRoleId(10);
        user.setCreatDate(new Date());
        user.setPassword(IDMd5("a123456789"));
        String mobile = getPhone();
        user.setMobilePhone(mobile);
        user.setProvinceCode(52);
        user.setCityCode(getAreaBySuper(user.getProvinceCode()).getAreaCode());
        user.setCountyCode(getAreaBySuper(user.getCityCode()).getAreaCode());
        user.setProvinceName(getAreaByCode(user.getProvinceCode()).getAreaName());
        user.setCityName(getAreaBySuper(user.getProvinceCode()).getAreaName());
        user.setCountyName(getAreaBySuper(user.getCityCode()).getAreaName());
        String IDNum = getIdentification(user.getCityName());
        user.setIdentification(IDNum);
        user.setGender(gender(IDNum));
        user.setStatus(1);
        user.setAuditStatus(1);
        user.setIdMd5(IDMd5(IDNum));
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

    private static String IDMd5(String IDNum) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    IDNum.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
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
        String userName;
        String surname = null;
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(199, "李");
        map.put(389 ,"王");
        map.put(569 ,"张");
        map.put(739 ,"刘");
        map.put(899 ,"陈");
        map.put(1049 ,"杨");
        map.put(1189 ,"赵");
        map.put(1319 ,"黄");
        map.put(1439 ,"周");
        map.put(1549 ,"吴");
        map.put(1639 ,"徐");
        map.put(1739 ,"孙");
        map.put(1819 ,"胡");
        map.put(1889 ,"朱");
        map.put(1949 ,"高");
        map.put(1999 ,"林");
        map.put(2039 ,"何");
        map.put(2069 ,"郭");
        map.put(2089 ,"马");
        map.put(2099 ,"罗");
        map.put(2109 ,"梁");
        map.put(2119 ,"宋");
        map.put(2129 ,"郑");
        Random random = new Random();
        int num = random.nextInt(2130);
        if (num <= 199) {
            surname = map.get(199);
        } else if (num <= 389) {
            surname = map.get(389);
        } else if (num <= 569) {
            surname = map.get(569);
        } else if (num <= 739) {
            surname = map.get(739);
        } else if (num <= 899) {
            surname = map.get(899);
        } else if (num <= 1049) {
            surname = map.get(1049);
        } else if (num <= 1189) {
            surname = map.get(1189);
        } else if (num <= 1319) {
            surname = map.get(1319);
        } else if (num <= 1439) {
            surname = map.get(1439);
        } else if (num <= 1549) {
            surname = map.get(1549);
        } else if (num <= 1639) {
            surname = map.get(1639);
        } else if (num <= 1739) {
            surname = map.get(1739);
        } else if (num <= 1819) {
            surname = map.get(1819);
        } else if (num <= 1889) {
            surname = map.get(1889);
        } else if (num <= 1949) {
            surname = map.get(1949);
        } else if (num <= 1999) {
            surname = map.get(1999);
        } else if (num <= 2039) {
            surname = map.get(2039);
        } else if (num <= 2069) {
            surname = map.get(2069);
        } else if (num <= 2089) {
            surname = map.get(2089);
        } else if (num <= 2099) {
            surname = map.get(2099);
        } else if (num <= 2109) {
            surname = map.get(2109);
        } else if (num <= 2119) {
            surname = map.get(2119);
        } else if (num <= 2129) {
            surname = map.get(2129);
        }
        boolean flag = random.nextBoolean();//随机标识
        if (flag) {//true,则名2个汉字
            userName = surname + getGivenName() + getGivenName();
        } else {//false,则名1个汉字
            userName = surname + getGivenName();
        }
        return userName;
    }

    /**
     * 生成 名字
     */
    private static String getGivenName() {
        String str = null;
        int highPos, lowPos;
        Random random = new Random();
        highPos = (176 + Math.abs(random.nextInt(71)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
        random = new Random();
        lowPos = 161 + Math.abs(random.nextInt(94));//位码，0xA0打头，范围第1~94列
        byte[] bArr = new byte[2];
        bArr[0] = (new Integer(highPos)).byteValue();
        bArr[1] = (new Integer(lowPos)).byteValue();
        try {
            str = new String(bArr, "GB2312");//区位码组合成汉字(仿宋体)
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    private static String getPhone() {
        String ChinaMobile[] = {"134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159", "187", "188"}; //中国移动
        String ChinaUnicom[] = {"130", "131", "132", "155", "156", "185", "186", "145"}; //中国联通
        String ChinaTelecom[] = {"133", "153", "180", "181", "189"}; //中国电信
        String tel[][] = {ChinaMobile, ChinaUnicom, ChinaTelecom};
        Random rd = new Random();
        int index = rd.nextInt(tel.length); //随机选择一个运营商
        int size = rd.nextInt(tel[index].length); //随机选择一个号码抬头
        return tel[index][size] + "" + rd.nextInt(10) + "" + rd.nextInt(10) + "" + rd.nextInt(10) + "" + rd.nextInt(10) + "" + rd.nextInt(10) + "" + rd.nextInt(10) + "" + rd.nextInt(10) + "" + rd.nextInt(10);
    }

    private static String getIdentification(String cityName) {
        Map<String, HashMap<Integer, String>> map = new HashMap<String, HashMap<Integer, String>>();
        HashMap<Integer, String> areaMap1 = new HashMap<Integer, String>(); //贵阳市
        areaMap1.put(1, "520101");
        areaMap1.put(2, "520102");
        areaMap1.put(3, "520103");
        areaMap1.put(4, "520111");
        areaMap1.put(5, "520112");
        areaMap1.put(6, "520113");
        areaMap1.put(7, "520114");
        areaMap1.put(8, "520121");
        areaMap1.put(9, "520122");
        areaMap1.put(10, "520123");
        areaMap1.put(11, "520181");
        map.put("贵阳市", areaMap1);

        HashMap<Integer, String> areaMap2 = new HashMap<Integer, String>(); //六盘水市
        areaMap2.put(1, "520201");
        areaMap2.put(2, "520203");
        areaMap2.put(3, "520221");
        areaMap2.put(4, "520222");
        map.put("六盘水市", areaMap2);

        HashMap<Integer, String> areaMap3 = new HashMap<Integer, String>(); //遵义市
        areaMap3.put(1, "520301");
        areaMap3.put(2, "520302");
        areaMap3.put(3, "520303");
        areaMap3.put(4, "520321");
        areaMap3.put(5, "520322");
        areaMap3.put(6, "520323");
        areaMap3.put(7, "520324");
        areaMap3.put(8, "520325");
        areaMap3.put(9, "520326");
        areaMap3.put(10, "520327");
        areaMap3.put(11, "520328");
        areaMap3.put(12, "520329");
        areaMap3.put(13, "520330");
        areaMap3.put(14, "520381");
        areaMap3.put(15, "520382");
        map.put("遵义市", areaMap3);

        HashMap<Integer, String> areaMap4 = new HashMap<Integer, String>(); //安顺市
        areaMap4.put(1, "520401");
        areaMap4.put(2, "520402");
        areaMap4.put(3, "520421");
        areaMap4.put(4, "520422");
        areaMap4.put(5, "520423");
        areaMap4.put(6, "520424");
        areaMap4.put(7, "520425");
        map.put("安顺市", areaMap4);

        HashMap<Integer, String> areaMap5 = new HashMap<Integer, String>(); //铜仁市
        areaMap5.put(1, "522201");
        areaMap5.put(2, "522222");
        areaMap5.put(3, "522223");
        areaMap5.put(4, "522224");
        areaMap5.put(5, "522225");
        areaMap5.put(6, "522226");
        areaMap5.put(7, "522227");
        areaMap5.put(8, "522228");
        areaMap5.put(9, "522229");
        areaMap5.put(10, "522230");
        map.put("铜仁市", areaMap5);

        HashMap<Integer, String> areaMap6 = new HashMap<Integer, String>(); //黔南布依族苗族自治州
        areaMap6.put(1, "522701");
        areaMap6.put(2, "522702");
        areaMap6.put(3, "522722");
        areaMap6.put(4, "522723");
        areaMap6.put(5, "522725");
        areaMap6.put(6, "522726");
        areaMap6.put(7, "522727");
        areaMap6.put(8, "522728");
        areaMap6.put(9, "522729");
        areaMap6.put(10, "522730");
        areaMap6.put(11, "522731");
        areaMap6.put(12, "522732");
        map.put("黔南布依族苗族自治州", areaMap6);

        HashMap<Integer, String> areaMap7 = new HashMap<Integer, String>(); //毕节市
        areaMap7.put(1, "522401");
        areaMap7.put(2, "522422");
        areaMap7.put(3, "522423");
        areaMap7.put(4, "522424");
        areaMap7.put(5, "522425");
        areaMap7.put(6, "522426");
        areaMap7.put(7, "522427");
        areaMap7.put(8, "522428");
        map.put("毕节市", areaMap7);

        HashMap<Integer, String> areaMap8 = new HashMap<Integer, String>(); //黔东南苗族侗族自治州
        areaMap8.put(1, "522601");
        areaMap8.put(2, "522622");
        areaMap8.put(3, "522623");
        areaMap8.put(4, "522624");
        areaMap8.put(5, "522625");
        areaMap8.put(6, "522626");
        areaMap8.put(7, "522627");
        areaMap8.put(8, "522628");
        areaMap8.put(9, "522629");
        areaMap8.put(10, "522630");
        areaMap8.put(11, "522631");
        areaMap8.put(12, "522632");
        areaMap8.put(13, "522633");
        areaMap8.put(14, "522634");
        areaMap8.put(15, "522635");
        areaMap8.put(16, "522636");
        map.put("黔东南苗族侗族自治州", areaMap8);

        HashMap<Integer, String> areaMap9 = new HashMap<Integer, String>(); //黔西南州
        areaMap9.put(1, "522301");
        areaMap9.put(2, "522322");
        areaMap9.put(3, "522323");
        areaMap9.put(4, "522324");
        areaMap9.put(5, "522325");
        areaMap9.put(6, "522326");
        areaMap9.put(7, "522327");
        areaMap9.put(8, "522328");
        map.put("黔西南州", areaMap9);

        HashMap<Integer, String> areaHash = map.get(cityName);
        Random random = new Random();
        String IDHead = areaHash.get(random.nextInt(areaHash.size()) + 1);
        String IDNum = IDHead + "19" + random.nextInt(10) + random.nextInt(10) //身份证地区码　＋　出生年份
                        + supplyZero() + supplyZero() //出生月份和日期
                        + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10); //身份证后四位
        return IDNum;
    }

    /**
     * 身份证月份和日期补0处理
     */
    private static String supplyZero() {
        Random random = new Random();
        int num = random.nextInt(12) + 1;
        if (num/10 > 0) {
            return String.valueOf(num);
        } else {
            return "0" + num;
        }
    }

    /**
     * 判断性别
     */
    private static String gender(String IDNum) {
        String gender = null;
        int num = IDNum.charAt(16);
        if (num%2 == 0) {
            gender = "女";
        } else {
            gender = "男";
        }
        return gender;
    }

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            add();
        }
    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
        System.out.println(supplyZero());
        }
    }

    @Test
    public void test3() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getIdentification("遵义市"));
        }
    }


















//    private static String getUserName() {
//        /*
//        李 王 张 刘 陈 杨 赵 黄
//        周 吴 徐 孙 胡 朱 高 林
//        何 郭 马 罗 梁 宋 郑
//         */
//        Map<HashMap<Integer, Integer>, Object> map = new HashMap<HashMap<Integer, Integer>, Object>();
//        HashMap<Integer, Integer> chanceMap1 = new HashMap<Integer, Integer>();
//        chanceMap1.put(0, 199); //200
//        HashMap<Integer, Integer> chanceMap2 = new HashMap<Integer, Integer>();
//        chanceMap2.put(200, 389); //190
//        HashMap<Integer, Integer> chanceMap3 = new HashMap<Integer, Integer>();
//        chanceMap3.put(390, 569); //180
//        HashMap<Integer, Integer> chanceMap4 = new HashMap<Integer, Integer>();
//        chanceMap4.put(570, 739); //170
//        HashMap<Integer, Integer> chanceMap5 = new HashMap<Integer, Integer>();
//        chanceMap5.put(740, 899); //160
//        HashMap<Integer, Integer> chanceMap6 = new HashMap<Integer, Integer>();
//        chanceMap6.put(900, 1049); //150
//        HashMap<Integer, Integer> chanceMap7 = new HashMap<Integer, Integer>();
//        chanceMap7.put(1050, 1189); //140
//        HashMap<Integer, Integer> chanceMap8 = new HashMap<Integer, Integer>();
//        chanceMap8.put(1190, 1319); //130
//        HashMap<Integer, Integer> chanceMap9 = new HashMap<Integer, Integer>();
//        chanceMap9.put(1320, 1439); //120
//        HashMap<Integer, Integer> chanceMap10 = new HashMap<Integer, Integer>();
//        chanceMap10.put(1440, 1549); //110
//        HashMap<Integer, Integer> chanceMap11 = new HashMap<Integer, Integer>();
//        chanceMap11.put(1550, 1639); //100
//        HashMap<Integer, Integer> chanceMap12 = new HashMap<Integer, Integer>();
//        chanceMap12.put(1650, 1739); //90
//        HashMap<Integer, Integer> chanceMap13 = new HashMap<Integer, Integer>();
//        chanceMap13.put(1740, 1819); //80
//        HashMap<Integer, Integer> chanceMap14 = new HashMap<Integer, Integer>();
//        chanceMap14.put(1820, 1889); //70
//        HashMap<Integer, Integer> chanceMap15 = new HashMap<Integer, Integer>();
//        chanceMap15.put(1890, 1949); //60
//        HashMap<Integer, Integer> chanceMap16 = new HashMap<Integer, Integer>();
//        chanceMap16.put(1950, 1999); //50
//        HashMap<Integer, Integer> chanceMap17 = new HashMap<Integer, Integer>();
//        chanceMap17.put(2000, 2039); //40
//        HashMap<Integer, Integer> chanceMap18 = new HashMap<Integer, Integer>();
//        chanceMap18.put(2040, 2069); //30
//        HashMap<Integer, Integer> chanceMap19 = new HashMap<Integer, Integer>();
//        chanceMap19.put(2070, 2089); //20
//        HashMap<Integer, Integer> chanceMap20 = new HashMap<Integer, Integer>();
//        chanceMap20.put(2090, 2099); //10
//        HashMap<Integer, Integer> chanceMap21 = new HashMap<Integer, Integer>();
//        chanceMap21.put(2100, 2109); //10
//        HashMap<Integer, Integer> chanceMap22 = new HashMap<Integer, Integer>();
//        chanceMap22.put(2110, 2119); //10
//        HashMap<Integer, Integer> chanceMap23 = new HashMap<Integer, Integer>();
//        chanceMap23.put(2120, 2129); //   共23
//        map.put(chanceMap1, "李");
//        map.put(chanceMap2 ,"王");
//        map.put(chanceMap3 ,"张");
//        map.put(chanceMap4 ,"刘");
//        map.put(chanceMap5 ,"陈");
//        map.put(chanceMap6 ,"杨");
//        map.put(chanceMap7 ,"赵");
//        map.put(chanceMap8 ,"黄");
//        map.put(chanceMap9 ,"周");
//        map.put(chanceMap10 ,"吴");
//        map.put(chanceMap11 ,"徐");
//        map.put(chanceMap12 ,"孙");
//        map.put(chanceMap13 ,"胡");
//        map.put(chanceMap14 ,"朱");
//        map.put(chanceMap15 ,"高");
//        map.put(chanceMap16 ,"林");
//        map.put(chanceMap17 ,"何");
//        map.put(chanceMap18 ,"郭");
//        map.put(chanceMap19 ,"马");
//        map.put(chanceMap20 ,"罗");
//        map.put(chanceMap21 ,"梁");
//        map.put(chanceMap22 ,"宋");
//        map.put(chanceMap23 ,"郑");
//
//    }

}
