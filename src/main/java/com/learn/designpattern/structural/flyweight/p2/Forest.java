package com.learn.designpattern.structural.flyweight.p2;

import java.util.ArrayList;
import java.util.List;

public final class Forest implements TreeDisplay {
	
	private final List<Tree> treeList;
	private final List<Double> treeX;
	private final List<Double> treeY;
	
	public Forest() {
		this.treeList = new ArrayList<>();
		this.treeX = new ArrayList<>();
		this.treeY = new ArrayList<>();
	}
	
	public void plantTree(final double x, final double y, final String treeName,
			final String treeColor, final String treeTexture) {
		treeList.add(TreeFactory.getTree(treeName, treeColor, treeTexture));
		treeX.add(x);
		treeY.add(y);
	}
	
	@Override
	public void displayTree() {
		
		final long numberOfTrees = treeList.size();
		
		for (long i = 0; i < numberOfTrees; i++) {
			System.out.println(treeList.get((int) i) + " at (" + treeX.get((int) i) + ","
					                   + treeY.get((int) i) + ").");
		}
	}
}
