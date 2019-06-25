package com.exercise.search.corpus;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Document {
	private String fileName;
	private double length;
	private Map<String, Integer> wordCounts;

	public Document(String fileName, Map<String, Integer> wordCounts) {
		this.fileName = fileName;
		this.length = wordCounts.values().stream().reduce(0, Integer::sum);
		this.wordCounts = wordCounts;
	}

	public String fileName() {
		return fileName;
	}

	public Map<String, Integer> wordCounts() {
		return wordCounts;
	}

	public Integer occurences(String word) {
		return wordCounts.getOrDefault(word, 0);
	}

	public Double termFrequency(String word) {
		return wordCounts().getOrDefault(word, 0) / length;
	}
}
