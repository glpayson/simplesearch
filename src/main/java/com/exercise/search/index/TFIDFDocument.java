package com.exercise.search.index;

import java.util.Map;

public class TFIDFDocument {
	private String fileName;
	private Map<String, Double> tfIdf;

	TFIDFDocument(String fileName, Map<String, Double> tfIdf) {
		this.fileName = fileName;
		this.tfIdf = tfIdf;
	}

	public String fileName() {
		return fileName;
	}

	public Double tfIdf(String word) {
		return tfIdf.getOrDefault(word, 0.0);
	}
}
