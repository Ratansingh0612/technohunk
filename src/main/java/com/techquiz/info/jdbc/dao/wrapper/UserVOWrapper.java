package com.techquiz.info.jdbc.dao.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.synergisitic.it.model.User;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class UserVOWrapper<T> implements RowMapper<User> {
	
	private String groupName;
	
	public UserVOWrapper(String groupName){
		this.groupName=groupName;
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setLoginid(rs.getString(1));
		user.setFirstName(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setMobile(rs.getString(4));
		user.setDescription(groupName);
		return user;
	}

}
