package com.mayol.beans;

import java.util.List;

public class Teacher {
       private String teacherName;
       private String[] friendArray;
       private List<String> shcool;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String[] getFriendArray() {
		return friendArray;
	}

	public void setFriendArray(String[] friendArray) {
		this.friendArray = friendArray;
	}

	public List<String> getShcool() {
		return shcool;
	}

	public void setShcool(List<String> shcool) {
		this.shcool = shcool;
	}
}
