package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CompoundCharacterTokenizerDiffblueTest {
  /**
   * Test {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}.
   *
   * <ul>
   *   <li>Given {@code Compound words cannot be null or empty}.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  @DisplayName(
      "Test new CompoundCharacterTokenizer(Set); given 'Compound words cannot be null or empty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompoundCharacterTokenizer.<init>(Set)"})
  void testNewCompoundCharacterTokenizer_givenCompoundWordsCannotBeNullOrEmpty() {
    // Arrange
    HashSet<String> compoundWords = new HashSet<>();
    compoundWords.add("Compound words cannot be null or empty");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new CompoundCharacterTokenizer(compoundWords));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}.
   *
   * <ul>
   *   <li>Given {@code Compound words should start and end with _}.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  @DisplayName(
      "Test new CompoundCharacterTokenizer(Set); given 'Compound words should start and end with _'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompoundCharacterTokenizer.<init>(Set)"})
  void testNewCompoundCharacterTokenizer_givenCompoundWordsShouldStartAndEndWith() {
    // Arrange
    HashSet<String> compoundWords = new HashSet<>();
    compoundWords.add("Compound words should start and end with _");
    compoundWords.add("Compound words cannot be null or empty");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new CompoundCharacterTokenizer(compoundWords));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}.
   *
   * <ul>
   *   <li>Then return tokenize {@code Text} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  @DisplayName("Test new CompoundCharacterTokenizer(Set); then return tokenize 'Text' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompoundCharacterTokenizer.<init>(Set)"})
  void testNewCompoundCharacterTokenizer_thenReturnTokenizeTextSizeIsOne() {
    // Arrange
    HashSet<String> compoundWords = new HashSet<>();
    compoundWords.add("_");

    // Act and Assert
    List<String> tokenizeResult = new CompoundCharacterTokenizer(compoundWords).tokenize("Text");
    assertEquals(1, tokenizeResult.size());
    assertEquals("Text", tokenizeResult.get(0));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  @DisplayName(
      "Test new CompoundCharacterTokenizer(Set); when HashSet(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompoundCharacterTokenizer.<init>(Set)"})
  void testNewCompoundCharacterTokenizer_whenHashSet_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new CompoundCharacterTokenizer(new HashSet<>()));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#CompoundCharacterTokenizer(Set)}
   */
  @Test
  @DisplayName(
      "Test new CompoundCharacterTokenizer(Set); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompoundCharacterTokenizer.<init>(Set)"})
  void testNewCompoundCharacterTokenizer_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new CompoundCharacterTokenizer((Set<String>) null));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#tokenize(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#tokenize(String)}
   */
  @Test
  @DisplayName("Test tokenize(String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CompoundCharacterTokenizer.tokenize(String)"})
  void testTokenize_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTokenizeResult =
        new CompoundCharacterTokenizer(Pattern.compile(".*\\.txt")).tokenize("Text");

    // Assert
    assertEquals(1, actualTokenizeResult.size());
    assertEquals("Text", actualTokenizeResult.get(0));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#tokenize(String)}.
   *
   * <ul>
   *   <li>When {@code 42_}.
   *   <li>Then return first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#tokenize(String)}
   */
  @Test
  @DisplayName("Test tokenize(String); when '42_'; then return first is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CompoundCharacterTokenizer.tokenize(String)"})
  void testTokenize_when42_thenReturnFirstIs42() {
    // Arrange and Act
    List<String> actualTokenizeResult =
        new CompoundCharacterTokenizer(Pattern.compile("42")).tokenize("42_");

    // Assert
    assertEquals(2, actualTokenizeResult.size());
    assertEquals("42", actualTokenizeResult.get(0));
    assertEquals("_", actualTokenizeResult.get(1));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#tokenize(String)}.
   *
   * <ul>
   *   <li>When {@code Text42}.
   *   <li>Then return second is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#tokenize(String)}
   */
  @Test
  @DisplayName("Test tokenize(String); when 'Text42'; then return second is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CompoundCharacterTokenizer.tokenize(String)"})
  void testTokenize_whenText42_thenReturnSecondIs42() {
    // Arrange and Act
    List<String> actualTokenizeResult =
        new CompoundCharacterTokenizer(Pattern.compile("42")).tokenize("Text42");

    // Assert
    assertEquals(2, actualTokenizeResult.size());
    assertEquals("42", actualTokenizeResult.get(1));
    assertEquals("Text", actualTokenizeResult.get(0));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#tokenize(String)}.
   *
   * <ul>
   *   <li>When {@code U.txtText}.
   *   <li>Then return second is {@code tText}.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#tokenize(String)}
   */
  @Test
  @DisplayName("Test tokenize(String); when 'U.txtText'; then return second is 'tText'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CompoundCharacterTokenizer.tokenize(String)"})
  void testTokenize_whenUTxtText_thenReturnSecondIsTText() {
    // Arrange and Act
    List<String> actualTokenizeResult =
        new CompoundCharacterTokenizer(Pattern.compile(".*\\.txt")).tokenize("U.txtText");

    // Assert
    assertEquals(2, actualTokenizeResult.size());
    assertEquals("U.txt", actualTokenizeResult.get(0));
    assertEquals("tText", actualTokenizeResult.get(1));
  }

  /**
   * Test {@link CompoundCharacterTokenizer#tokenize(String)}.
   *
   * <ul>
   *   <li>When {@code U.txt}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CompoundCharacterTokenizer#tokenize(String)}
   */
  @Test
  @DisplayName("Test tokenize(String); when 'U.txt'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CompoundCharacterTokenizer.tokenize(String)"})
  void testTokenize_whenUTxt_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTokenizeResult =
        new CompoundCharacterTokenizer(Pattern.compile(".*\\.txt")).tokenize("U.txt");

    // Assert
    assertEquals(1, actualTokenizeResult.size());
    assertEquals("U.txt", actualTokenizeResult.get(0));
  }
}
