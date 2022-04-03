package by.epam.tr.controller;

public class InfoController implements Controller {
  public String doAction(String request) {
    String[] requestParts;
    requestParts = request.split(" ");
    String commandName = requestParts[0];

    CommandProvider commandProvider = new CommandProvider();
    Command command = commandProvider.getCommand(commandName);

    return command.execute(requestParts);
  }
}
