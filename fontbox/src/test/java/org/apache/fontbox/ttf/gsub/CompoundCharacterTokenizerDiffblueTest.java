package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class CompoundCharacterTokenizerDiffblueTest {
  /**
   * Method under test:
   * {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  void testNewCompoundCharacterTokenizer() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CompoundCharacterTokenizer(new HashSet<>()));
    assertThrows(IllegalArgumentException.class, () -> new CompoundCharacterTokenizer((Set<String>) null));
  }

  /**
   * Method under test:
   * {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  void testNewCompoundCharacterTokenizer4() {
    // Arrange
    HashSet<String> compoundWords = new HashSet<>();
    compoundWords.add("_");

    // Act and Assert
    List<String> tokenizeResult = (new CompoundCharacterTokenizer(compoundWords)).tokenize("Text");
    assertEquals(1, tokenizeResult.size());
    assertEquals("Text", tokenizeResult.get(0));
  }

  /**
   * Method under test: {@link CompoundCharacterTokenizer#tokenize(String)}
   */
  @Test
  void testTokenize() {
    // Arrange and Act
    List<String> actualTokenizeResult = (new CompoundCharacterTokenizer(Pattern.compile(".*\\.txt"))).tokenize("Text");

    // Assert
    assertEquals(1, actualTokenizeResult.size());
    assertEquals("Text", actualTokenizeResult.get(0));
  }

  /**
   * Method under test: {@link CompoundCharacterTokenizer#tokenize(String)}
   */
  @Test
  void testTokenize2() {
    // Arrange and Act
    List<String> actualTokenizeResult = (new CompoundCharacterTokenizer(Pattern.compile(".*\\.txt"))).tokenize("U.txt");

    // Assert
    assertEquals(1, actualTokenizeResult.size());
    assertEquals("U.txt", actualTokenizeResult.get(0));
  }

  /**
   * Method under test:
   * {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  void testNewCompoundCharacterTokenizer2() {
    // Arrange
    HashSet<String> compoundWords = new HashSet<>();
    compoundWords.add("Compound words cannot be null or empty");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CompoundCharacterTokenizer(compoundWords));
  }

  /**
   * Method under test:
   * {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  void testNewCompoundCharacterTokenizer3() {
    // Arrange
    HashSet<String> compoundWords = new HashSet<>();
    compoundWords.add("Compound words should start and end with _");
    compoundWords.add("Compound words cannot be null or empty");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CompoundCharacterTokenizer(compoundWords));
  }
}
