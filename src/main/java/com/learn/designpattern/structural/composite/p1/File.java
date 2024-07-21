package com.learn.designpattern.structural.composite.p1;

public class File extends FileSystem {
	
	public File(String fileName) {
		super(fileName);
	}
	
	@Override
	public void ls() {
		System.out.println("file name ::: " + this.getFileName());
	}
}
