package by.epam.tr.controller.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import by.epam.tr.controller.Command;
import by.epam.tr.service.DeleteSentences;

public class DeleteSentencesCommand implements Command {
  private static final String NUM_OF_WORDS_REGEXP = "[0-9]+";

  DeleteSentences deleteAllSentencesWithLessWordsNumber =
      new DeleteSentences();
  @Override
  public String execute(String[] requestParts) {
    String response = null;
    int numOfWords;

    if (requestParts[1].matches(NUM_OF_WORDS_REGEXP)) {
      numOfWords = Integer.valueOf(requestParts[1]);
    } else {
      return "You entered incorrect data. Check it and try again";
    }
    try {
      response = deleteAllSentencesWithLessWordsNumber.deleteByWordsNumber(numOfWords);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (response.isBlank()) {
      return "There are no sentences in the text that fit the specified criteria";
    } else {
    return response;
    }
  }
}
