package com.demo.example.grpc.dal.vo;

import com.demo.example.grpc.dal.entity.User;

/**
 * 用户信息表 扩展
 * @author: wangcanyi
 * @date: 2018-08-01 11:09
 **/
public class UserVO extends User {
	private String codeName;

	/**
	 * 编号与姓名
	 *
	 * @return
	 */
	public String getCodeName() {
		return codeName;
	}

	/**
	 * @param codeName 编号与姓名
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
