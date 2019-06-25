package com.exercise.search.index;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Map;

import com.exercise.search.corpus.Corpus;
import com.exercise.search.corpus.CorpusParser;
import com.exercise.search.io.DirectoryReader;

public class IndexFactory {
	private final DirectoryReader directoryReader;
	private final CorpusParser corpusParser;
	private final TFIDFCalculator tfidfCalculator;

	public IndexFactory(DirectoryReader directoryReader, CorpusParser corpusParser,
			TFIDFCalculator tfidfCalculator) {
		this.directoryReader = directoryReader;
		this.corpusParser = corpusParser;
		this.tfidfCalculator = tfidfCalculator;
	}

	public Index createIndex(String directoryPath) {
		Map<String, String> fileNameToText = directoryReader.read(directoryPath);
		Corpus corpus = corpusParser.parse(fileNameToText);
		return createIndexFromCorpus(corpus);
	}

	private Index createIndexFromCorpus(Corpus corpus) {
		return corpus.documents().stream()
				.map(x -> tfidfCalculator.calculate(x, corpus))
				.collect(collectingAndThen(toList(), Index::new));
	}
}
