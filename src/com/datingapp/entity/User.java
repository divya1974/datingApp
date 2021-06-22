package com.datingapp.entity;
import java.io.*;
import java.util.*;

public class User {
	
	static Integer Id=0;
	Integer UId;
	String name;
	String gender;
	Integer lon;
	Integer lat;
	Integer relScore;
	
	public Integer getRelScore() {
		return relScore;
	}

	public void setRelScore(Integer relScore) {
		this.relScore = relScore;
	}

	public Integer getLon() {
		return lon;
	}

	public void setLon(Integer lon) {
		this.lon = lon;
	}

	public Integer getLat() {
		return lat;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}

	
	Integer age;
	
	Set<String> interests;
	
//	List<Integer> mutualLiked;
	Set<Integer> likedProfiles; 
//	List<Integer> potentialMatches;
	
	
	public User(String name, String gender, Integer lat, Integer lon, Integer age, Set<String> interests) {
		super();
		this.UId =++Id;
		this.name = name;
		this.gender = gender;
		this.lat=lat;
	    this.lon=lon;
		this.age = age;
		this.interests = interests;
		
		likedProfiles= new HashSet<Integer>();
	//	mutualLiked= new ArrayList<Integer>();
	//	potentialMatches= new ArrayList<Integer>();
		
		
	}
	
	public static Integer getId() {
		return Id;
	}
	public static void setId(Integer id) {
		Id = id;
	}
	public Integer getUId() {
		return UId;
	}
	public void setUId(Integer uId) {
		UId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Set<String> getInterests() {
		return interests;
	}
	public void setInterests(Set<String> interests) {
		this.interests = interests;
	}
/*	public List<Integer> getMutualLiked() {
		return mutualLiked;
	}
	public void setMutualLiked(List<Integer> mutualLiked) {
		this.mutualLiked = mutualLiked; 
	} */
	public Set<Integer> getLikedProfiles() {
		return likedProfiles;
	}
	public void setLikedProfiles(Set<Integer> likedProfiles) {
		this.likedProfiles = likedProfiles;
	}
/*	public List<Integer> getPotentialMatches() {
		return potentialMatches;
	}
	public void setPotentialMatches(List<Integer> potentialMatches) {
		this.potentialMatches = potentialMatches;
	} */
	

}
