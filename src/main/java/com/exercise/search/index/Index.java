package com.exercise.search.index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Index {
	private final List<TFIDFDocument> documents;

	Index(List<TFIDFDocument> documents) {
		this.documents = documents == null ?
				Collections.emptyList() :
				documents;
	}

	public List<TFIDFDocument> documents() {
		return documents;
	}

	private double search(String query) {
		throw new NotImplementedException();
	}

	public TFIDFDocument document(String name) {
		return documents.stream()
				.filter(x -> name.equals(x.fileName()))
				.findFirst()
				.orElse(null);
	}

	public int numDocuments() {
		return documents.size();
	}
}
