package com.shtabco.meta.services;

import java.io.File;

public class FileTreeWalker {

	FileVisitor visitor = null;
	File root = null;

	@FunctionalInterface
	public interface FileVisitor {
		public void visit(File file);
	}

	public FileTreeWalker(File root, FileVisitor visitor) {
		this.root = root;
		this.visitor = visitor;
	}
	
	public void start() {
		processDir(root);
	}
	
	private void processDir(File dir) {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (file.isDirectory()) {
				processDir(file);
			}
			visitor.visit(file);
		}
	}

}
