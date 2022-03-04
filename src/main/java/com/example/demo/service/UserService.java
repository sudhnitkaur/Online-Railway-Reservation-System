package com.example.demo.service;

import java.util.List;
import com.example.demo.model.user.Ticket;
import com.example.demo.model.user.User;



public interface UserService {

	public String getEmailAddress(long id);

	public String addUser(User user);

	public String addAllUser(List<User> users);

	public List<User> getAllUser();

//	public String createUser(UserForm1 userForm1);

	public boolean userExistById(Long user_id);

	public String updateUser(User user);

	public User getUser(long user_id);
	
	public String deleteUser(User user);
	
	public String saveTicket(long account_no , long pnr, Ticket ticket);

//	public String changePassword(ChangePassword changePassword);

//	public String saveTicket(Long account_no, long pnr, Ticket ticket);

//	public String getCredentials(long user_id);

}
