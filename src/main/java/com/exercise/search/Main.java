package com.exercise.search;

import com.exercise.search.corpus.CorpusParser;
import com.exercise.search.index.Index;
import com.exercise.search.index.IndexFactory;
import com.exercise.search.index.TFIDFCalculator;
import com.exercise.search.io.DirectoryReader;

public class Main {
	public static void main(String[] args) {
		DirectoryReader dirReader = new DirectoryReader();
		CorpusParser corpusParser = new CorpusParser();
		TFIDFCalculator tfidfCalculator = new TFIDFCalculator();

		Index index = new IndexFactory(dirReader, corpusParser, tfidfCalculator)
				.createIndex("src/main/resources/documents");
		System.out.println(index.documents().size());
	}
}
