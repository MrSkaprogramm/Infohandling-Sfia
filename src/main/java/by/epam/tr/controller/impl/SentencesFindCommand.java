package by.epam.tr.controller.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import by.epam.tr.controller.Command;
import by.epam.tr.service.SentencesFind;

public class SentencesFindCommand implements Command {

  SentencesFind findSentencesWithTheLongestWord =
      new SentencesFind();
  @Override
  public String execute(String[] requestParts) {
    String response = null;
    try {
      response = findSentencesWithTheLongestWord.findByLongestWord();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }

}
