package com.datingapp.repository;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import com.datingapp.entity.User;

public class UserRepository {
	
	public static Map<Integer, User> userList = new HashMap<Integer, User>();
	
	
	public void addUser(User user) {
		userList.put(user.getUId(), user);
	}
	
	public User getUser(Integer userId) {
		
		return userList.get(userId);
	}
	
	public  Map<Integer, User> getAllUsers(){
		
		return userList;
		
	}
	
	 class Sortdesc implements Comparator<User> {
		    // Used for sorting in ascending order of
		    // name
		    public int compare(User a, User b)
		    {
		        return b.getRelScore().compareTo(a.getRelScore()); // or a-b
		    }
		    
		   }
	 

	public List<User> getProfilesUser(User user1, int dismin, int distmax) {
		
		 Iterator iterator = userList.entrySet().iterator();
		 
		 	PriorityQueue<User> showProfile = new PriorityQueue<User>(new Sortdesc());
		 
		 	
			Set<String> userainterest= user1.getInterests();
			
	
		 while (iterator.hasNext()) {
			 	
	            User user2 = ((Entry<Integer, User>) iterator.next()).getValue();
	            
	            int dis= findDistance(user1.getLat(), user1.getLon(), user2.getLat(), user2.getLon());
	            
	            if(dis >= dismin && dis<distmax) {
	            	
	
			    	Set<String> userbinterest= user2.getInterests();
			    	
			    	int count=0;
			    	
				    for(String s : userainterest) {
				    	
	            	if(userbinterest.contains(s))
	            		count++;
	            } 
				    
				    int max=Math.max(userainterest.size(), userbinterest.size());
				   
				    int score= count/max;
				   
				    user2.setRelScore(score);
				    	    
	               showProfile.add(user2);
	            
	            }
	            	
	        }
		
		 List<User> res= new ArrayList<User>(showProfile);
		
		return res;
		
	}
	
	private Integer findDistance(Integer x1, Integer y1, Integer x2, Integer y2) {
		
		return( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		
	}
	
	
	

}
