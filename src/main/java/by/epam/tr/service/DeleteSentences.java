package by.epam.tr.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import by.epam.tr.dao.ReadSource;

public class DeleteSentences {
  private ReadSource readSource = new ReadSource();
  private String endSymbols = "[.?!]";
  private String afterEndSymbols = "[ \t]+";
  private ArrayList<String> sentences = new ArrayList<String>();
  private Map<String, Integer> sentencesLengthes = new HashMap<>();
  private ArrayList<Integer> sentencesWordNum = new ArrayList<Integer>();

  public String deleteByWordsNumber(int numOfWords) throws FileNotFoundException, IOException {
    String text = readSource.readSource();

    findSentences(text);
    defineSentencesWordNum();

    for (int i = 0; i < sentences.size(); i++) {
      sentencesLengthes.put(sentences.get(i), sentencesWordNum.get(i));
    }

    removeSentences(numOfWords);

    StringBuffer modifiedText = new StringBuffer();
    for (String sentence : sentencesLengthes.keySet()) {
      modifiedText.append(sentence + "\n");
    }

    return modifiedText.toString();
  }

  public void findSentences(String text) {
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

  public void removeSentences(int numOfWords) {
    Set<Entry<String, Integer>> entryMap = new HashSet<>();
    entryMap.addAll(sentencesLengthes.entrySet());
    for (Map.Entry<String, Integer> entry : entryMap) {
      if (entry.getValue() < numOfWords) {
        sentencesLengthes.remove(entry.getKey());
      }
    }
  }

  public void defineSentencesWordNum() {
    int sentenceWordNum = 0;

    for (String sentence : sentences) {
      sentenceWordNum = 0;
      for (int i = 0; i < sentence.length(); i++) {
        if (String.valueOf(sentence.charAt(i)).matches(" +")) {
          sentenceWordNum++;
        }
      }
      sentencesWordNum.add(sentenceWordNum + 1);
    }
  }
}
