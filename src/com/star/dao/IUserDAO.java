package com.star.dao;

import com.star.domain.User;

public interface IUserDAO extends IBaseDAO<User>{

	User getByUserCode(String usercode);

}
