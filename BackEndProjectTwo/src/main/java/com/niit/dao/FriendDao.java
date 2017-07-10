package com.niit.dao;

import java.util.List;

import com.niit.model.Users;

public interface FriendDao {
List<Users> listOfSuggestedUsers(String username);
}
