package com.learn.designpattern.lowleveldesign.bookmyshow.model.entity;

import com.learn.designpattern.lowleveldesign.bookmyshow.model
		.enums.Feature;

import java.util.ArrayList;
import java.util.List;

public record Movie(long movieId, String movieName, double moviePrice,
                    int movieRating, List<Feature> featureList) {
	
	public Movie {
		featureList = new ArrayList<>(featureList);
	}
	
	public List<Feature> featureList() {
		return new ArrayList<>(featureList);
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Movie{");
		sb.append("movieId=").append(movieId);
		sb.append(", movieName='").append(movieName).append('\'');
		sb.append(", moviePrice=").append(moviePrice);
		sb.append(", movieRating=").append(movieRating);
		sb.append(", featureList=").append(featureList);
		sb.append('}');
		return sb.toString();
	}
}
