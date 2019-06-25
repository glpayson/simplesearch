package com.exercise.search.index;

import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Index {
	private final List<TFIDFDocument> documents;

	Index(List<TFIDFDocument> documents) {
		this.documents = documents;
	}

	public List<TFIDFDocument> documents() {
		return documents;
	}

	private double search(String query) {
		throw new NotImplementedException();
	}
}
