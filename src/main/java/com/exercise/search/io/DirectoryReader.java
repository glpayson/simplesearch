package com.exercise.search.io;

import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DirectoryReader {
	public Map<String, String> read(String directoryPath) {
		File dir = new File(directoryPath);
		List<File> files = Arrays.asList(Objects.requireNonNull(dir.listFiles()));
		return files.stream()
				.collect(toMap(File::getName, this::parseFile));
	}

	private String parseFile(File file) {
		try {
			return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
