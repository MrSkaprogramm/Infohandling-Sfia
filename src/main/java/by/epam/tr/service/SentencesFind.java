package by.epam.tr.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import by.epam.tr.dao.ReadSource;

public class SentencesFind {
  private ReadSource readSource = new ReadSource();
  private final String endSymbols = "[.?!]";
  private final String afterEndSymbols = "[ \t]+";
  private final String punctuationMarks = "[\"\\!'(),;:.?-]";
  private ArrayList<String> sentences = new ArrayList<String>();
  private ArrayList<String> words = new ArrayList<String>();

  public String findByLongestWord() throws FileNotFoundException, IOException {
    String text = readSource.readSource();

    findTextSentences(text);
    findTextWords(text);
    String longestWord = findLongestWord(text);

    ArrayList<String> finalSentences = new ArrayList<String>();
    for (String sentence : sentences) {
      if (checkAvailabilityInSentence(sentence, longestWord)) {
        finalSentences.add(sentence);
      }
    }

    StringBuffer findLongestWord = new StringBuffer();
    for (String sentence : finalSentences) {
      findLongestWord.append(sentence + "\n");
    }

    return findLongestWord.toString();
  }

  public String findLongestWord(String text) {
    int longestWordLength = 0;
    String longestWord = null;

    for (String word : words) {
      if (word.length() > longestWordLength) {
        longestWordLength = word.length();
        longestWord = word;
      }
    }
    return longestWord;
  }

  public void findTextWords(String text) {
    String wordString;
    boolean isWord = false;
    int beginWord = 0;
    int endWord = 0;

    text = text.replaceAll(punctuationMarks, "");
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

  public void findTextSentences(String text) {
    boolean isSentence = false;
    int beginSentence = 0;
    int endSentence;
    String sentenceString;

    for (int i = 0; i < text.length(); i++) {
      if (isSentence == false && Character.isUpperCase(text.charAt(i))) {
        beginSentence = i;
        isSentence = true;
        continue;
      } else if (i == text.length() - 1 && isSentence) {
        endSentence = i + 1;
        isSentence = false;
      } else if (isSentence && String.valueOf(text.charAt(i + 1)).matches(afterEndSymbols)
          && String.valueOf(text.charAt(i)).matches(endSymbols)) {
        endSentence = i + 1;
        isSentence = false;
      } else {
        continue;
      }
      sentenceString = text.substring(beginSentence, endSentence);
      sentences.add(sentenceString);
      isSentence = false;
    }
  }

  public boolean checkAvailabilityInSentence(String sentence, String word) {
    String wordString;
    boolean isWord = false;
    int beginWord = 0;
    int endWord = 0;

    sentence = sentence.replaceAll(punctuationMarks, "");
    sentence = sentence.replaceAll(afterEndSymbols, " ");
    for (int i = 0; i < sentence.length(); i++) {
      if (isWord == false) {
        beginWord = i;
        isWord = true;
        continue;
      } else if (isWord && String.valueOf(sentence.charAt(i)).matches(" ")) {
        endWord = i;
        isWord = false;
      } else if (isWord && i == sentence.length() - 1) {
        endWord = i + 1;
        isWord = false;
      } else {
        continue;
      }
      wordString = sentence.substring(beginWord, endWord);
      if (wordString.equals(word)) {
        return true;
      }
      isWord = false;
    }
    return false;
  }
}
