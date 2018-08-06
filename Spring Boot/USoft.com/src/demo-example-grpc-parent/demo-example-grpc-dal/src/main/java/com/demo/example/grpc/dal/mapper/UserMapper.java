package com.demo.example.grpc.dal.mapper;

import com.demo.example.grpc.dal.entity.User;
import com.demo.example.grpc.dal.vo.UserVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public interface UserMapper {
	/**
	 * deleteByPrimaryKey
	 *
	 * @param id
	 * @return int
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * insert
	 *
	 * @param record
	 * @return int
	 */
	int insert(User record);

	/**
	 * insertSelective
	 *
	 * @param record
	 * @return int
	 */
	int insertSelective(User record);

	/**
	 * selectByPrimaryKey
	 *
	 * @param id
	 * @return User
	 */
	User selectByPrimaryKey(Integer id);

	/**
	 * updateByPrimaryKeySelective
	 *
	 * @param record
	 * @return int
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * updateByPrimaryKey
	 *
	 * @param record
	 * @return int
	 */
	int updateByPrimaryKey(User record);

	/**
	 * 获取用户信息
	 *
	 * @param userCode 用户编号
	 * @return
	 */
	User findByUserCode(@Param("userCode") String userCode);

	/**
	 * 获取用户信息扩展
	 *
	 * @param userCode 用户编号
	 * @return
	 */
	UserVO findVOByUserCode(@Param("userCode") String userCode);
}