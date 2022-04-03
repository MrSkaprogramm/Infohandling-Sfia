package by.epam.tr.view;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.controller.Controller;
import by.epam.tr.controller.InfoController;

public class ApplicationView {
  private static final String CHOISE_REGEXP = "[0-9]+";
  private Scanner sc = new Scanner(System.in);
  private Controller controller = new InfoController();
  private String request;
  private String menuAnswer;
  private Logger logger = LogManager.getLogger(ApplicationView.class);

  public void applicationMenu() {
    logger.info("Welcome to information handling application!" + "\n"
        + "Select the action you want to do with the text:" + "\n"
        + "Press 1 to sort paragraphs by the number of sentences" + "\n"
        + "Press 2 to find sentences with the longest word" + "\n"
        + "Press 3 to delete from the text all sentences with a number of words less than the specified one"
        + "\n"
        + "Press 4 to find all the same case-insensitive words in the text and count their number"
        + "\n" + "Press 5 to count the number of vowels and consonants in a sentence" + "\n"
        + "Press any other number to exit");
    String choise = sc.nextLine();

    if (choise.matches(CHOISE_REGEXP) && Integer.valueOf(choise) == 1) {
      request = "sortParagraphsByNumberOfSentences";
      menuAnswer = controller.doAction(request);
      logger.info(menuAnswer);
      applicationMenu();
    } else if (choise.matches(CHOISE_REGEXP) && Integer.valueOf(choise) == 2) {
      request = "findSentencesWithTheLongestWord";
      menuAnswer = controller.doAction(request);
      logger.info(menuAnswer);
      applicationMenu();
    } else if (choise.matches(CHOISE_REGEXP) && Integer.valueOf(choise) == 3) {
      logger.info("Enter the number of words you want to see in the text sentences");
      String numOfWords = sc.nextLine();

      request = "deleteAllSentencesWithLessWordsNumber" + " " + numOfWords;
      menuAnswer = controller.doAction(request);
      logger.info(menuAnswer);
      applicationMenu();
    } else if (choise.matches(CHOISE_REGEXP) && Integer.valueOf(choise) == 4) {
      request = "findAllSameWordsInText";
      menuAnswer = controller.doAction(request);
      logger.info(menuAnswer);
      applicationMenu();
    } else if (choise.matches(CHOISE_REGEXP) && Integer.valueOf(choise) == 5) {
      request = "countVowelsAndConsonants";
      menuAnswer = controller.doAction(request);
      logger.info(menuAnswer);
      applicationMenu();
    } else if (!choise.matches(CHOISE_REGEXP)) {
      applicationMenu();
    } else {
      logger.info("Have a nice day!");
      return;
    }
  }
}
