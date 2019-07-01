package com.exercise.search;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testifidf(){
       IndexCalculator myIndex = new IndexCalculator();
       Map<String,String> documents = new HashMap<String, String>();
       documents.put("c.txt", "dog 1 and dog 2 ate the hot dog");
       documents.put("a.txt","the mouse played with the cat");
       documents.put("b.txt","the quick brown fox jumped over the lazy dog");
       //{c.txt=dog 1 and dog 2 ate the hot dog, a.txt=the mouse played with the cat, b.txt=the quick brown fox jumped over the lazy dog}
       Double mouseDocA = myIndex.TfidfScore("mouse", documents, "a.txt");
       assertEquals(0.183102D,mouseDocA,0.1);


       Double theDocA = myIndex.TfidfScore("the",documents,"a.txt");
       assertEquals(0.0,theDocA,0.001);
    }
}
