package com.itheima.mybatis.mapper;

import com.github.abel533.mapper.Mapper;
import com.itheima.mybatis.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper extends Mapper<User>{

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	User queryUserById(Long id);

	/**
	 * 新增
	 * 
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * 更新
	 * 
	 * @param user
	 */
	void updateUserById(User user);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	void deleteUserById(Long id);

}
