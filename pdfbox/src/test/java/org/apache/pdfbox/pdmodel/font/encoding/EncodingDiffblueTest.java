package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EncodingDiffblueTest {
  /**
   * Test {@link Encoding#getInstance(COSName)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link Encoding#getInstance(COSName)}
   */
  @Test
  @DisplayName("Test getInstance(COSName); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Encoding Encoding.getInstance(COSName)"})
  void testGetInstance_whenA() {
    // Arrange, Act and Assert
    assertNull(Encoding.getInstance(COSName.A));
  }

  /**
   * Test {@link Encoding#getInstance(COSName)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Encoding#getInstance(COSName)}
   */
  @Test
  @DisplayName("Test getInstance(COSName); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Encoding Encoding.getInstance(COSName)"})
  void testGetInstance_whenNull() {
    // Arrange, Act and Assert
    assertNull(Encoding.getInstance(null));
  }

  /**
   * Test {@link Encoding#getCodeToNameMap()}.
   *
   * <p>Method under test: {@link Encoding#getCodeToNameMap()}
   */
  @Test
  @DisplayName("Test getCodeToNameMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Encoding.getCodeToNameMap()"})
  void testGetCodeToNameMap() {
    // Arrange
    MacExpertEncoding macExpertEncoding = MacExpertEncoding.INSTANCE;

    // Act
    Map<Integer, String> actualCodeToNameMap = macExpertEncoding.getCodeToNameMap();

    // Assert
    assertEquals(macExpertEncoding.codeToName, actualCodeToNameMap);
  }

  /**
   * Test {@link Encoding#getNameToCodeMap()}.
   *
   * <p>Method under test: {@link Encoding#getNameToCodeMap()}
   */
  @Test
  @DisplayName("Test getNameToCodeMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Encoding.getNameToCodeMap()"})
  void testGetNameToCodeMap() {
    // Arrange
    MacExpertEncoding macExpertEncoding = MacExpertEncoding.INSTANCE;

    // Act
    Map<String, Integer> actualNameToCodeMap = macExpertEncoding.getNameToCodeMap();

    // Assert
    assertEquals(macExpertEncoding.inverted, actualNameToCodeMap);
  }

  /**
   * Test {@link Encoding#contains(int)} with {@code code}.
   *
   * <ul>
   *   <li>Given {@link MacExpertEncoding} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Encoding#contains(int)}
   */
  @Test
  @DisplayName(
      "Test contains(int) with 'code'; given MacExpertEncoding (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Encoding.contains(int)"})
  void testContainsWithCode_givenMacExpertEncoding_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MacExpertEncoding().contains(1));
  }

  /**
   * Test {@link Encoding#contains(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link MacExpertEncoding} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Encoding#contains(String)}
   */
  @Test
  @DisplayName(
      "Test contains(String) with 'name'; given MacExpertEncoding (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Encoding.contains(String)"})
  void testContainsWithName_givenMacExpertEncoding_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MacExpertEncoding().contains("Name"));
  }
}
