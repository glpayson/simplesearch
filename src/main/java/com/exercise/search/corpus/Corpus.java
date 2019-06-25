package com.exercise.search.corpus;

import java.util.List;
import java.util.Map;

public class Corpus {
	private final List<Document> documents;
	private final Map<String, Integer> termDocumentFrequencies;

	public Corpus(List<Document> documents,
			Map<String, Integer> termDocumentFrequencies) {
		this.documents = documents;
		this.termDocumentFrequencies = termDocumentFrequencies;
	}

	public int numDocuments() {
		return documents.size();
	}

	public List<Document> documents() {
		return documents;
	}

	public double inverseDocumentFrequency(String word) {
		int numDocsWithTerm = termDocumentFrequencies.getOrDefault(word, 0);
		return numDocsWithTerm == 0 ? 0 : Math.log(numDocuments() / numDocsWithTerm);
	}
}
