package com.exercise.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import com.exercise.search.io.DirectoryReader;
import org.junit.jupiter.api.Test;

import com.exercise.search.*;

class MainTest {
	@Test
	void tfIdf() {
		// Read files from disk
		String testDir = "src/test/resources/documents";
		DirectoryReader dirReader = new DirectoryReader();
		Map<String, String> fileNameToText = dirReader.read(testDir);
		System.out.println(fileNameToText);

		// Calculate tf-idf for "mouse" in document "a.txt"
		Index myIndex = new Index(fileNameToText);
		double actual = myIndex.tfidfScore("mouse", "a.txt");
		double expected = 0.183102;

		assertEquals(expected, actual, 0.00001);
	}
}