package by.epam.tr.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import by.epam.tr.utils.composite.TextComponent;

public class Paragraph implements Serializable, TextComponent {
  private static final long serialVersionUID = -4232844137020748672L;
  private Paragraph paragraph;
  private ArrayList<TextComponent> textComponentList;

  public Paragraph(ArrayList<TextComponent> textComponentList) {
    this.textComponentList = textComponentList;
  }

  public Paragraph getParagraph() {
    return paragraph;
  }

  public void setParagraph(Paragraph paragraph) {
    this.paragraph = paragraph;
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
    return Objects.hash(paragraph, textComponentList);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Paragraph other = (Paragraph) obj;
    return Objects.equals(paragraph, other.paragraph)
        && Objects.equals(textComponentList, other.textComponentList);
  }

  @Override
  public String toString() {
    return "Paragraph [paragraph=" + paragraph + ", textComponentList=" + textComponentList + "]";
  }
}
