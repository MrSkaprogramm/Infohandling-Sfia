package by.epam.tr.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import by.epam.tr.dao.ReadSource;

public class SameWordsFind {
  private ReadSource readSource = new ReadSource();
  private String afterEndSymbols = "[ \t]+";
  private ArrayList<String> words = new ArrayList<String>();
  private Map<String, Integer> wordsCount = new HashMap<String, Integer>();
  private final String punctuationMarks = "[\"\\!'(),;:.?-]";

  public String countWordsInText() throws FileNotFoundException, IOException {
    String text = readSource.readSource();

    findWords(text);
    countAllWords();
    defineAllSameWords();

    StringBuffer allSameWords = new StringBuffer();
    for (Map.Entry<String, Integer> entryMap : wordsCount.entrySet()) {
      allSameWords.append("word: " + entryMap.getKey() + " count: " + entryMap.getValue() + "\n");
    }

    return allSameWords.toString();
  }

  public void findWords(String text) {
    String wordString;
    boolean isWord = false;
    int beginWord = 0;
    int endWord = 0;

    text = text.replaceAll(punctuationMarks, "");
    text = text.replaceAll(afterEndSymbols, " ");
    for (int i = 0; i < text.length(); i++) {
      if (isWord == false) {
        beginWord = i;
        isWord = true;
        continue;
      } else if (isWord && String.valueOf(text.charAt(i)).matches("[ \t]")) {
        endWord = i;
        isWord = false;
      } else if (isWord && i == text.length() - 1) {
        endWord = i + 1;
        isWord = false;
      } else {
        continue;
      }
      wordString = text.substring(beginWord, endWord);
      wordString = wordString.replaceAll(afterEndSymbols, "");
      words.add(wordString);
      isWord = false;
    }
  }

  public void countAllWords() {
    int count;
    String firstWord;
    String secondWord;

    for (int i = 0; i < words.size(); i++) {
      Iterator<String> iterator = words.iterator();
      firstWord = words.get(i);
      count = 1;
      for (int j = i + 1; j < words.size(); j++) {
        secondWord = words.get(j);
        if (firstWord.equalsIgnoreCase(secondWord)) {
          count++;
        }
      }

      while (iterator.hasNext()) {
        if (iterator.next().equalsIgnoreCase(firstWord)) {
          iterator.remove();
        }
      }
      wordsCount.put(firstWord, count);
      i--;
    }
  }

  public void defineAllSameWords() {
    Set<Entry<String, Integer>> wordsCountEntry = new HashSet<>();
    wordsCountEntry.addAll(wordsCount.entrySet());
    
    for (Map.Entry<String, Integer> entryMap : wordsCountEntry) {
        if(entryMap.getValue() < 2) {
          wordsCount.remove(entryMap.getKey());
        }
    }
  }
}