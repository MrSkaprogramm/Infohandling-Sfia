package by.epam.tr.controller.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import by.epam.tr.controller.Command;
import by.epam.tr.service.CountVowelsConsonants;

public class CountVowelsConsonantsCommand implements Command {

  CountVowelsConsonants countVowelsAndConsonants = new CountVowelsConsonants();

  @Override
  public String execute(String[] requestParts) {
    String response = null;
    try {
      int[] numOfLetters = countVowelsAndConsonants.count();
      response = "The number of vowel letters in a sentence: " + numOfLetters[0] + "\n"
          + "The number of consonant letters in a sentence: " + numOfLetters[1];
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }

}
