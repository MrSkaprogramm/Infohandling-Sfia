package by.epam.tr.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import by.epam.tr.dao.ReadSource;

@RunWith(MockitoJUnitRunner.class)
public class SentencesFindTest {
  @Mock
  private ReadSource readSource;

  @InjectMocks
  private SentencesFind sentencesFind;

  public SentencesFindTest() {
    MockitoAnnotations.openMocks(this);
    this.sentencesFind = new SentencesFind();
  }

  @Test
  public void testFindByLongestWord() {
    String text =
        "Italy is as beautiful as possible! Bonjorno Italy! Bonjorno to the most beautiful Italian views!";
    String italianResponse = "Italy is as beautiful as possible!" + "\n"
        + "Bonjorno to the most beautiful Italian views!" + "\n";
    String methodResponse = null;
    try {
      given(readSource.readSource()).willReturn(text);
      methodResponse = sentencesFind.findByLongestWord();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(methodResponse, italianResponse);
  }

}
