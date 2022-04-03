package by.epam.tr.beans;

import java.io.Serializable;

public class Letter implements Serializable{
  private static final long serialVersionUID = 7041715351851942726L;
  private Character letter;

  public Letter(Character letter) {
    this.letter = letter;
  }

  public Character getLetter() {
    return letter;
  }

  public void setLetter(Character letter) {
    this.letter = letter;
  }
}
