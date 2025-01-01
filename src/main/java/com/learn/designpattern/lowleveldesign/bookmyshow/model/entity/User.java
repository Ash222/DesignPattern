package com.learn.designpattern.lowleveldesign.bookmyshow.model.entity;

public record User(long userId, String userName) {
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("User{");
		sb.append("userId=").append(userId);
		sb.append(", userName='").append(userName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
