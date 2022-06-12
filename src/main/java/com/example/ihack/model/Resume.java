package com.example.ihack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resume {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String user;
	private String obj;
	private String proj;
	private String skill;
	private String location;
	private String regards;
	
	public Resume() {
		super();
	}
	
	public Resume(int id,String user,String obj,String proj,String skill,String location,String regards,String name)
	{
	this.id=id;
	this.user=user;
	this.obj=obj;
	this.proj=proj;
	this.skill=skill;
	this.location=location;
	this.name=name;
	this.regards=regards;	
	}
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getProj() {
		return proj;
	}

	public void setProj(String proj) {
		this.proj = proj;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegards() {
		return regards;
	}

	public void setRegards(String regards) {
		this.regards = regards;
	}
	
	   @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + id;
	        return result;
	    }
	   
	   @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        Resume other = (Resume) obj;
	        if (id != other.id) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	                "Resume [id=%s, user=%s,name=%s, obj=%s, proj=%s, skill=%s, location=%s,regards=%s]", id,
	                user,name,obj,proj,skill,location,regards);
	    }
	
}
