package com.exercise.search;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IndexCalculator {

    public Double TfidfScore(String word, Map<String, String> documents, String documentName){
        double tf = tf(word,documents.get(documentName));
        double idf = idf(word,documents);
        return tf*idf;
    }

    private Double tf(String word, String document){
        List<String> words = Arrays.asList(document.split(" "));
        Long frequencyInDocument = words.stream().filter(w -> w.equals(word)).count();
        int totalWordsInDocument = words.size();
        return Double.valueOf(frequencyInDocument)/Double.valueOf(totalWordsInDocument);
    }

    private Double idf(String word, Map<String,String> documents){
        int totalDocuments = documents.entrySet().size();
        long documentsThatContainsWord = documents
                .entrySet()
                .stream()
                .filter( s -> s.getValue().contains(word))
                .count();
        if(documentsThatContainsWord == 0){
            return 0D;
        }else {
            return Math.log(Double.valueOf(totalDocuments/documentsThatContainsWord));
        }
    }
}

