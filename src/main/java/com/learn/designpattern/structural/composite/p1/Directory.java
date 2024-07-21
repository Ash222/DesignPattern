package com.learn.designpattern.structural.composite.p1;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystem {
	
	private final List<FileSystem> fileSystemList;
	
	public Directory(String fileName) {
		super(fileName);
		this.fileSystemList = new ArrayList<>();
	}
	
	public void addFile(final FileSystem fileSystem) {
		this.fileSystemList.add(fileSystem);
	}
	
	@Override
	public void ls() {
		
		System.out.println("directory name ::: " + this.getFileName());
		
		for (FileSystem fileSystem : this.fileSystemList) {
			fileSystem.ls();
		}
	}
}
