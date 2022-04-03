package by.epam.tr.controller.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import by.epam.tr.controller.Command;
import by.epam.tr.service.ParagraphSort;

public class ParagraphSortCommand implements Command {

  ParagraphSort sortParagraphsByNumberOfSentences =
      new ParagraphSort();

  @Override
  public String execute(String[] requestParts) {
    String response = null;
    try {
      response = sortParagraphsByNumberOfSentences.sortParagrahs();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }

}
