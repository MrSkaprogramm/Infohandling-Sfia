package by.epam.tr.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import by.epam.tr.utils.composite.TextComponent;

public class Text implements Serializable, TextComponent {
  private static final long serialVersionUID = -6824956661058964988L;
  private Text text;
  private ArrayList<TextComponent> textComponentList;

  public Text(Word word, ArrayList<TextComponent> textComponentList) {
    this.textComponentList = textComponentList;
  }

  public Text getText() {
    return text;
  }

  public void setText(Text text) {
    this.text = text;
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
    return Objects.hash(text, textComponentList);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Text other = (Text) obj;
    return Objects.equals(text, other.text)
        && Objects.equals(textComponentList, other.textComponentList);
  }

  @Override
  public String toString() {
    return "Text [text=" + text + ", textComponentList=" + textComponentList + "]";
  }
}
