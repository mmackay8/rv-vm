package com.example.recyclerview

import androidx.lifecycle.ViewModel
import java.util.*
import com.example.recyclerview.Words

class WordViewModel: ViewModel() {
    private var wordList: LinkedList<String>? = null

    fun getWordList(): LinkedList<String>? {
        return Words.getWordList()
    }

    fun setWordList(wordList: LinkedList<String>) {
        this.wordList = wordList
    }
    fun addWord(word: String){
        Words.addWordToList(word)
    }
}