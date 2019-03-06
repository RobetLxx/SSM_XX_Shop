package com.shop.dao;

import com.shop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户实体类 User 访问接口
 * @author LXX
 */

@Repository
public interface UserDao {
    /*登录*/
    public void addLogin(@Param("id") String id,
                         @Param("ip") String ip,
                         @Param("userid") String userid,
                         @Param("loginTime") String loginTime);

    public void updateEmail(@Param("id") String id,
                            @Param("email") String email);

    public void updatePhoneNum(@Param("id") String id,
                               @Param("phoneNum") String phoneNum);


    /**
     * 添加用户
     * @param user 用户的实体类的对象
     */
    public void addUser(User user);


    /**
    * 得到所有用户
    * @return 含有所有用户的集合
    */
    public List<User> getAllUser();


    /**
     * 通过用户名和密码得到用户
     * @param name 用户名
     * @oaram password 密码
    * @return 返回用户的实体类对象
    */
    public User getUserByNameAndPwd(@Param("name") String name,
                                    @Param("password") String password);


    /**
    	 *修改用户头像
    	 * @param id 用户id
     * @param user_img 图片
    	 */
    public void updateUserImg(@Param("id") String id,
                              @Param("user_img") String user_img);

    
    /**
    * 通过名字查询当前在数据库的数量
    * @param name 查询到的名字
    * @return 查询到的数量
    */
    public int getNumByName(@Param("name") String name);

    /**
    	 * 实现更新某一位用户的money
    	 * @param id 当前需要更新的用户id
    	 * @param money 更新后的money
    	 */
    public void updateMoney(@Param("id") String id,
                            @Param("money") float money);

    /**
    	 * 通过user的id来删除用户
    	 * @param id
    	 */

    public void deleteUser(String id);
    
    /**
    	 * 通过user的id来获取用户
    	 * @param id
    	 */
    public User getUser(String id);


    /**
    	 * 实现更新某一位用户的status
    	 * @param id 当前需要更新的id
    	 * @param status 更新后的status
    	 */
    public void updateStatus(@Param("id") String id,
                             @Param("status") int status);

    /**
    	 * 实现更新用户的password
    	 * @param id 当前需要更新的id
    	 * @param password 更新后的password
    	 */
    public void updatePassword(@Param("id") String id,
                               @Param("password") String password);
    
    /**
    	 * 实现更新用户的role
    	 * @param id 当前需要更新的用户id
    	 * @param role 更新后的role
    	 */
    public void updateRole(@Param("id") String id,
                           @Param("role") String role);





}
