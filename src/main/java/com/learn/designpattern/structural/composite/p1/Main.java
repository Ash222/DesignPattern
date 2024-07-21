package com.learn.designpattern.structural.composite.p1;

public class Main {
	
	public static void main(String[] args) {
		
		Directory movieDirectory = new Directory("movie");
		Directory comedyMovieDirectory = new Directory("comedy");
		Directory normalDirectory = new Directory("normal");
		File textFile = new File("apple.txt");
		File hulchal = new File("hulchal.mp4");
		File dhol = new File("dhol.mp4");
		
		// adding files in directory
		normalDirectory.addFile(textFile);
		comedyMovieDirectory.addFile(hulchal);
		comedyMovieDirectory.addFile(dhol);
		movieDirectory.addFile(comedyMovieDirectory);
		
		// getting the contents of the library
		normalDirectory.ls();
		movieDirectory.ls();
	}
}
