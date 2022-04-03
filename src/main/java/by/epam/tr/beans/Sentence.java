package by.epam.tr.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import by.epam.tr.utils.composite.TextComponent;

public class Sentence implements Serializable, TextComponent {
  private static final long serialVersionUID = -1163829223158841170L;
  private Sentence sentence;
  private ArrayList<TextComponent> textComponentList;

  public Sentence(ArrayList<TextComponent> textComponentList) {
    this.textComponentList = textComponentList;
  }

  public Sentence getSentence() {
    return sentence;
  }

  public void setSentence(Sentence sentence) {
    this.sentence = sentence;
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
    return Objects.hash(sentence, textComponentList);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Sentence other = (Sentence) obj;
    return Objects.equals(sentence, other.sentence)
        && Objects.equals(textComponentList, other.textComponentList);
  }

  @Override
  public String toString() {
    return "Sentence [sentence=" + sentence + ", textComponentList=" + textComponentList + "]";
  }
}
