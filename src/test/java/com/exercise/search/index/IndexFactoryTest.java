package com.exercise.search.index;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.exercise.search.corpus.CorpusParser;
import com.exercise.search.io.DirectoryReader;
import org.junit.jupiter.api.Test;

class IndexFactoryTest {
	@Test
	void createIndex() {
		DirectoryReader dirReader = new DirectoryReader();
		CorpusParser corpusParser = new CorpusParser();
		TFIDFCalculator tfidfCalculator = new TFIDFCalculator();

		Index actual = new IndexFactory(dirReader, corpusParser, tfidfCalculator)
				.createIndex("src/test/resources/documents");

		TFIDFDocument actualDoc = actual.document("a.txt");
		assertEquals(3, actual.numDocuments());
		assertEquals(5, actualDoc.uniqueWords());
		assertEquals(0.0, actualDoc.tfIdf("the"), 0.0000001);
		assertEquals(0.183102, actualDoc.tfIdf("mouse"), 0.0000001);
		assertEquals(0.183102, actualDoc.tfIdf("with"), 0.0000001);
		assertEquals(0.183102, actualDoc.tfIdf("cat"), 0.0000001);
		assertEquals(0.183102, actualDoc.tfIdf("played"), 0.0000001);

	}
}