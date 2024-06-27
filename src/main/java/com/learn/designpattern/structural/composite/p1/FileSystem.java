package com.learn.designpattern.structural.composite.p1;

public abstract class FileSystem {
	
	private String fileName;
	
	public FileSystem(final String fileName) {
		this.fileName = fileName;
	}
	
	protected String getFileName() {
		return fileName;
	}
	
	abstract void ls();
}
