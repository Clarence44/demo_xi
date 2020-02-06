package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author ：44356
 * @date ：2020/02/03  19:14
 * @blame ：44356
 */
public class MybatisTest {

    private MybatisTest mybatisTest;
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
//        1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        3.获取SqlSession对象
        sqlSession = factory.openSession();
//        4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
//        5.提交事务
        sqlSession.commit();
//        6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试单一查询操作（注解）
     */
    @Test
    public void testF() {
//        5.执行单一查询方法
        User user = userDao.findOne(52);
        System.out.println(user);
    }

    /**
     * 测试插入操作（注解）
     */
    @Test
    public void testI() {
//        5.执行插入方法
        User user = new User();
        user.setUsername("mybatis saveuser4");
        user.setAddress("佛山市南海区");
        user.setSex("男");
        user.setBirthday(LocalDateTime.now());
//        5.执行保存(插入)方法
        userDao.insertUser(user);
    }

    /**
     * 测试更新操作（注解）
     */
    @Test
    public void testU() {
        User user = new User();
        user.setId(52);
        user.setUsername("mybatis saveuser4");
        user.setAddress("广州市");
        user.setSex("男");
        user.setBirthday(LocalDateTime.of(2000, Month.DECEMBER, 3, 6, 30));
//        5.执行更新方法
        userDao.updateU(user);
    }

    /**
     * 测试删除操作（注解）
     */
    @Test
    public void testD() {
//        5.执行删除方法
        userDao.deleteU(51);
    }

    /**
     * 测试查询所有操作
     */
    @Test
    public void testFindAll() {
//        5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users
        ) {
            System.out.println(user);
        }
    }

    /**
     * 测试插入操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis last insert id");
        user.setAddress("廉江市");
        user.setSex("男");
        user.setBirthday(LocalDateTime.of(2000,Month.DECEMBER,3,6,6));
        System.out.println("保存操作之前"+user);
//        5.执行保存(插入)方法
        userDao.saveUser(user);

        System.out.println("保存操作之后"+user);

    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis saveuser");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(LocalDateTime.now());
//        5.执行更新方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
//        5.执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 测试单一查询操作
     */
    @Test
    public void testFindOne() {
//        5.执行单一查询方法
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName() {
//        5.执行模糊查询方法
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数操作
     */
    @Test
    public void testFindTotal() {
//        5.执行查询总记录条数方法
        int count = userDao.findTotal();
        System.out.println("总记录条数："+count);
    }
}
