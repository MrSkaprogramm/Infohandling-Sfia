package by.epam.tr.controller;

import java.util.HashMap;
import java.util.Map;
import by.epam.tr.controller.impl.CountVowelsConsonantsCommand;
import by.epam.tr.controller.impl.DeleteSentencesCommand;
import by.epam.tr.controller.impl.SameWordsFindCommand;
import by.epam.tr.controller.impl.SentencesFindCommand;
import by.epam.tr.controller.impl.ParagraphSortCommand;

public class CommandProvider {
  private Map<String, Command> commands = new HashMap<String, Command>();

  public CommandProvider() {
    commands.put("countVowelsAndConsonants", new CountVowelsConsonantsCommand());
    commands.put("deleteAllSentencesWithLessWordsNumber",
        new DeleteSentencesCommand());
    commands.put("findAllSameWordsInText", new SameWordsFindCommand());
    commands.put("findSentencesWithTheLongestWord", new SentencesFindCommand());
    commands.put("sortParagraphsByNumberOfSentences",
        new ParagraphSortCommand());
  }

  public Command getCommand(String commandName) {
    Command command = commands.get(commandName);

    return command;
  }
}
