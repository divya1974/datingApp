package com.datingapp.main;

import java.util.*;

import com.datingapp.entity.User;
import com.datingapp.service.Service;


public class MainDriver {

	public static void main(String[] args) {
		
		Service service = new Service();
	
		
		Set<String> hobbies1=new HashSet<String>();
		hobbies1.add("play");
		hobbies1.add("TV");
		hobbies1.add("chess");
		
		Set<String> hobbies2=new HashSet<String>();
		hobbies2.add("play");
		hobbies2.add("TV");
		
		Set<String> hobbies3=new HashSet<String>();
		hobbies3.add("dance");
		hobbies3.add("chess");
		
		User user1 = new User("user1","F",25,35,30,hobbies1);
		User user3 = new User("user3","F",200,35,30,hobbies2);
		User user4 = new User("user4","F",25,35,30,hobbies3);
			
		service.addUser(user1);
		service.addUser(user3);
		service.addUser(user4);
		
		//System.out.println(service.showProfiles(user1.getId(),"VERY NEAR"));
		
		List<User> list =service.showProfiles(user1.getId(),"VERY NEAR");
		
		for (User a : list) {
			System.out.println(a.getUId());
			}
		

	}

}
