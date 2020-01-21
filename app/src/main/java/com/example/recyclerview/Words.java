package com.example.recyclerview;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class Words {
    private static LinkedList<String> wordList = new LinkedList<>();

    public static LinkedList<String> getWordList() {
        if(wordList.isEmpty()){
            for (int x= 0; x <= 20; x++){
                wordList.add("Word "+ x);
            }
        }

        return wordList;
    }

    public static void addWordToList(String word){
        wordList.add(word);
    }


    public void setWordList(LinkedList<String> wordList) {
        for (int x= 0; x < 20; x++){
            wordList.add("Word"+ x);
        }
    }

}
