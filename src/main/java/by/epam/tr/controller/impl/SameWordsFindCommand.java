package by.epam.tr.controller.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import by.epam.tr.controller.Command;
import by.epam.tr.service.SameWordsFind;

public class SameWordsFindCommand implements Command {
  SameWordsFind FindAllSameWordsInText = new SameWordsFind();

  @Override
  public String execute(String[] requestParts) {
    String response = null;
    try {
      String number = FindAllSameWordsInText.countWordsInText();
      response = number;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }

}
