package com.learn.designpattern.lowleveldesign.bookmyshow.model.entity;

import java.util.ArrayList;
import java.util.List;

public record Auditorium(long auditoriumId, String auditoriumName,
                         List<Theatre> theatreList, double price) {
	
	public Auditorium {
		theatreList = new ArrayList<>(theatreList);
	}
	
	public List<Theatre> theatreList(){
		return new ArrayList<>(theatreList);
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Auditorium{");
		sb.append("auditoriumId=").append(auditoriumId);
		sb.append(", auditoriumName='").append(auditoriumName).append('\'');
		sb.append(", theatreList=").append(theatreList);
		sb.append(", price=").append(price);
		sb.append('}');
		return sb.toString();
	}
}
