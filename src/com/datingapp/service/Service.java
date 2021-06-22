package com.datingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.datingapp.entity.User;
import com.datingapp.repository.UserRepository;

public class Service {
	
	public static UserRepository userRepository= new UserRepository();
	
	public void addUser(User user) {
		userRepository.addUser(user);
	}
	
	public List<User> showProfiles(Integer userId, String filter){
		
		User user1 = userRepository.getUser(userId);
		
		
		List<User> listUser = new ArrayList<User>();
		
		if(filter =="VERY NEAR") {
			
			listUser= userRepository.getProfilesUser(user1, 0, 25);
				
		}
		else if (filter=="NEAR") {
			
			listUser = userRepository.getProfilesUser(user1, 25, 50);
			
		}
		else if(filter =="DOESN'T MATTER") {
			
			listUser =userRepository.getProfilesUser(user1, -1000, 1000);
			
		}
		return listUser;	
	}
	
	public void likeProfile(Integer user1Id, Integer user2Id ) {
		
		User user1 = userRepository.getUser(user1Id);
		Set<Integer> liked=user1.getLikedProfiles();
		liked.add(user2Id);
		user1.setLikedProfiles(liked);
	
	}
	
	public List<Integer> getLikedProfiles(Integer userId) {
		
		User user1 = userRepository.getUser(userId);
		
		List<Integer> res= new ArrayList<Integer>(user1.getLikedProfiles());
		 
		return res;
	}
	
	
	public List<User> getMutualLiked(Integer user1Id) {
		
		userRepository.getAllUsers();
		
		List<User> mutualres = new ArrayList<User>();
		
		User user1 = userRepository.getUser(user1Id);
		
		Set<Integer> liked= user1.getLikedProfiles();
		
		for( Integer id : liked) {
			
			User b = userRepository.getUser(id);
			if(b.getLikedProfiles().contains(user1Id))
				mutualres.add(b);
		
		}
		return mutualres;
				
	}

	
	

}
