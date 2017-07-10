package com.niit.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Users;

@Repository
public class FriendDaoImpl implements FriendDao {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Users> listOfSuggestedUsers(String username) {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("(select username from Users where username!=? minus (select fromid from Friend where toid=? union select toid from Friend where fromid=? ))");
		query.setString(0, username);
		query.setString(1, username);
		query.setString(2, username);
		List<Users> suggestedUsers=query.list();
		session.close();
		return suggestedUsers;
	}

}
