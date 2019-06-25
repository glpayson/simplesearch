package com.exercise.search.corpus;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CorpusParser {
	public Corpus parse(Map<String, String> fileNameToText) {
		List<Document> documents = createDocuments(fileNameToText);
		Map<String, Integer> termDocumentFrequency = createTermDocumentFrequency(documents);
		return new Corpus(documents, termDocumentFrequency);
	}

	private List<Document> createDocuments(Map<String, String> fileNameToText) {
		return fileNameToText.keySet().stream()
				.map(x -> createDocument(x, fileNameToText.get(x)))
				.collect(toList());
	}

	private Document createDocument(String fileName, String text) {
		Map<String, Integer> wordCount = Pattern.compile("\\W+")
				.splitAsStream(text)
				.collect(groupingBy(String::toLowerCase, summingInt(s -> 1)));
		return new Document(fileName, wordCount);
	}

	private Map<String, Integer> createTermDocumentFrequency(List<Document> documents) {
		return documents.stream()
				.map(Document::wordCounts)
				.map(Map::keySet)
				.flatMap(Collection::stream)
				.collect(groupingBy(Function.identity(), summingInt(x -> 1)));
	}


}
