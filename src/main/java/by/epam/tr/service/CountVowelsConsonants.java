package by.epam.tr.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import by.epam.tr.dao.ReadSource;

public class CountVowelsConsonants {
  private ReadSource readSource = new ReadSource();
  private String vowels = "[aeiouyаоуэиыеёяюAEIOUYAOУЭИЫЕЁЯЮ]";
  private String conconstants =
      "[qwrtplkjhgfdszxcvbnmйцкнгшщзхфвпрлджбтмсчQWRTPLKJHGFDSZXCVBNMЙЦКНГШЩЗХФВПРЛДЖБТМСЧ]";

  public int[] count() throws FileNotFoundException, IOException {
    String text = readSource.readSource();
    int vowelsNum = countVowels(text);
    int conconstantsNum = countConsonants(text);

    int[] countLetters = new int[2];
    countLetters[0] = vowelsNum;
    countLetters[1] = conconstantsNum;

    return countLetters;
  }

  public int countVowels(String text) {
    int vowelsNum = 0;
    for (int i = 0; i < text.length(); i++) {
      if (String.valueOf(text.charAt(i)).matches(vowels)) {
        vowelsNum++;
      }
    }
    return vowelsNum;
  }

  public int countConsonants(String text) {
    int conconstantsNum = 0;
    for (int i = 0; i < text.length(); i++) {
      if (String.valueOf(text.charAt(i)).matches(conconstants)) {
        conconstantsNum++;
      }
    }
    return conconstantsNum;
  }
}
