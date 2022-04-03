package by.epam.tr.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import by.epam.tr.utils.composite.TextComponent;

public class Word implements Serializable, TextComponent {
  private static final long serialVersionUID = -1570303236416847722L;
  private Word word;
  private ArrayList<TextComponent> textComponentList;

  public Word(ArrayList<TextComponent> textComponentList) {
    this.textComponentList = textComponentList;
  }

  public Word getWord() {
    return word;
  }

  public void setWord(Word word) {
    this.word = word;
  }

  public ArrayList<TextComponent> getTextComponentList() {
    return textComponentList;
  }

  public void setTextComponentList(ArrayList<TextComponent> textComponentList) {
    this.textComponentList = textComponentList;
  }

  @Override
  public String getContent() {
    String content = "";
    for (TextComponent textComponent : textComponentList) {
      content += textComponent.getContent();
    }
    return content;
  }

  @Override
  public int hashCode() {
    return Objects.hash(textComponentList, word);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Word other = (Word) obj;
    return Objects.equals(textComponentList, other.textComponentList)
        && Objects.equals(word, other.word);
  }

  @Override
  public String toString() {
    return "Word [word=" + word + ", textComponentList=" + textComponentList + "]";
  }
}
