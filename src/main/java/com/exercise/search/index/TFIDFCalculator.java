package com.exercise.search.index;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

import com.exercise.search.corpus.Corpus;
import com.exercise.search.corpus.Document;

public class TFIDFCalculator {
	TFIDFDocument calculate(Document doc, Corpus corpus) {
		return doc.wordCounts().keySet()
				.stream()
				.collect(collectingAndThen(toMap(x -> x,
						x -> doc.termFrequency(x) * corpus.inverseDocumentFrequency(x)),
						tfidf -> new TFIDFDocument(doc.fileName(), tfidf)));
	}
}
