package com.learn.designpattern.structural.flyweight.p2;

import java.util.HashMap;
import java.util.Map;

public final class TreeFactory {
	
	private static final Map<String, Tree> treeTypeMap = new HashMap<>();
	
	private TreeFactory() {
	}
	
	public static Tree getTree(final String treeName, final String treeColor,
			final String treeTexture) {
		
		final String key = treeName + "_" + treeColor + "_" + treeTexture;
		
		if (!treeTypeMap.containsKey(key)) {
			treeTypeMap.put(key, new Tree(treeName, treeColor, treeTexture));
		}
		
		return treeTypeMap.get(key);
	}
}
