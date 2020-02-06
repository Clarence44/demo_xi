package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ：44356
 * @date ：2020/02/03  19:09
 * @blame ：44356
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询（使用注解）
     * @param userId
     * @return User
     */
    @Select("SELECT * FROM user WHERE id =#{uid}")
    User findOne(Integer userId);

    /**
     * 插入(使用注解)
     * @param user
     */
    @Insert("INSERT INTO user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void insertUser(User user);

    /**
     * 更新(使用注解)
     * @param user
     */
    @Update("UPDATE user SET username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} WHERE id = #{id}")
    void updateU(User user);

    /**
     * 删除(使用注解)
     * @param userId
     */
    @Delete("DELETE FROM user WHERE id = #{uid}")
    void deleteU(Integer userId);

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return User
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return List<User>
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return int
     */
    int findTotal();
}
