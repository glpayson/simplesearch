package com.exercise.search;

import com.exercise.search.io.DirectoryReader;

public class Main {
	public static void main(String[] args) {
		String testDir = "src/test/resources/documents";
		DirectoryReader dirReader = new DirectoryReader();

		// Expected TF-IDF scores for src/test/resources/documents/a.txt
		//	the, 0.0
		//	mouse, 0.183102
		//	with, 0.183102
		//	cat, 0.183102
		//	played, 0.183102
	}
}
