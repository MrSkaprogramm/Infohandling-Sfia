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
public class SameWordsFindTest {
  @Mock
  private ReadSource readSource;

  @InjectMocks
  private SameWordsFind sameWordsFind;



  public SameWordsFindTest() {
    MockitoAnnotations.openMocks(this);
    this.sameWordsFind = new SameWordsFind();
  }



  @Test
  public void testCountWordsInText() {
    String text = "Hello hello Italy!";
    String italianResponse = "word: " + "Hello" + " count: " + "2" + "\n";
    String methodResponse = null;
    try {
      given(readSource.readSource()).willReturn(text);
      methodResponse = sameWordsFind.countWordsInText();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(methodResponse, italianResponse);
  }

}
