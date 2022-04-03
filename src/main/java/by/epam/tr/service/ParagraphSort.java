package by.epam.tr.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import by.epam.tr.dao.ReadSource;

public class ParagraphSort {
  private ReadSource readSource = new ReadSource();
  private ArrayList<String> paragraphs = new ArrayList<String>();
  private ArrayList<Integer> paragraphsLengths = new ArrayList<Integer>();
  private final String endSymbols = "[.?!]";
  private final String afterEndSymbols = "[ \t]+";
  private final String paragraphStartSymbols = "\t";

  public String sortParagrahs() throws FileNotFoundException, IOException {
    String text = readSource.readSource();

    defineParagraphs(text);
    defineParagraphsLength();

    sortParagraphs();

    StringBuffer sortParagraphs = new StringBuffer();
    for (String paragraph : paragraphs) {
      sortParagraphs.append(paragraph + "\n");
    }

    return sortParagraphs.toString();
  }

  public void defineParagraphs(String text) {
    String paragraphString;
    boolean isParagraph = false;
    int beginParagraph = 0;
    int endParagraph = 0;

    for (int i = 0; i < text.length(); i++) {
      if (isParagraph == false) {
        beginParagraph = i;
        isParagraph = true;
        continue;
      } else if (isParagraph && String.valueOf(text.charAt(i)).matches(paragraphStartSymbols)) {
        endParagraph = i;
        isParagraph = false;
      } else if (isParagraph && i == text.length() - 1) {
        endParagraph = i + 1;
        isParagraph = false;
      } else {
        continue;
      }
      paragraphString = text.substring(beginParagraph, endParagraph);
      paragraphs.add(paragraphString);
      isParagraph = false;
    }
  }

  public void sortParagraphs() {
    String temp;
    for (int i = 0; i < paragraphs.size(); i++) {
      for (int j = i + 1; j < paragraphs.size(); j++) {
        if (paragraphsLengths.get(i) < paragraphsLengths.get(j)) {
          temp = paragraphs.get(j);
          paragraphs.set(j, paragraphs.get(i));
          paragraphs.set(i, temp);
        }
      }
    }
  }

  public void defineParagraphsLength() {
    int paragraphLength = 0;
    boolean isSentence = false;
    int beginSentence = 0;
    int endSentence;
    String sentenceString;

    for (String paragraph : paragraphs) {
      paragraphLength = 0;
      for (int i = 0; i < paragraph.length(); i++) {
        if (isSentence == false && Character.isUpperCase(paragraph.charAt(i))) {
          beginSentence = i;
          isSentence = true;
          continue;
        } else if (i == paragraph.length() - 1 && isSentence) {
          endSentence = i + 1;
          isSentence = false;
        } else if (isSentence && String.valueOf(paragraph.charAt(i + 1)).matches(afterEndSymbols)
            && String.valueOf(paragraph.charAt(i)).matches(endSymbols)) {
          endSentence = i + 1;
          isSentence = false;
        } else {
          continue;
        }
        sentenceString = paragraph.substring(beginSentence, endSentence);
        paragraphLength++;
        isSentence = false;
      }
      paragraphsLengths.add(paragraphLength);
    }
  }
}
