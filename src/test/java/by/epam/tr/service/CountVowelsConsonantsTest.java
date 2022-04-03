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
public class CountVowelsConsonantsTest {
  @Mock
  private ReadSource readSource;

  @InjectMocks
  private CountVowelsConsonants countVowelsConsonants;



  public CountVowelsConsonantsTest() {
    MockitoAnnotations.openMocks(this);
    this.countVowelsConsonants = new CountVowelsConsonants();
  }

  @Test
  public void testCount() {
    int italianVowels = 6;
    int italianConsonants = 5;
    int vowels = 0;
    int consonants = 0;

    try {
      given(readSource.readSource()).willReturn("Italy is good!");
      int[] count = countVowelsConsonants.count();
      vowels = count[0];
      consonants = count[1];
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(italianVowels, vowels);
    assertEquals(italianConsonants, consonants);
  }

  @Test
  public void testCountVowels() {
    int italianVowels = 6;
    int vowels = 0;

    try {
      given(readSource.readSource()).willReturn("Italy is good!");
      int[] count = countVowelsConsonants.count();
      vowels = count[0];
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(italianVowels, vowels);
  }

  @Test
  public void testCountConsonants() {
    int italianConsonants = 5;
    int consonants = 0;

    try {
      given(readSource.readSource()).willReturn("Italy is good!");
      int[] count = countVowelsConsonants.count();
      consonants = count[1];
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(italianConsonants, consonants);
  }

}
