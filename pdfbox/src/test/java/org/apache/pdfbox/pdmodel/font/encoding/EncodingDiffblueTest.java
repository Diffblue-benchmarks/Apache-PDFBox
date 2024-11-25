package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EncodingDiffblueTest {
  /**
   * Test {@link Encoding#getInstance(COSName)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Encoding#getInstance(COSName)}
   */
  @Test
  @DisplayName("Test getInstance(COSName); when A")
  void testGetInstance_whenA() {
    // Arrange, Act and Assert
    assertNull(Encoding.getInstance(COSName.A));
  }

  /**
   * Test {@link Encoding#getInstance(COSName)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Encoding#getInstance(COSName)}
   */
  @Test
  @DisplayName("Test getInstance(COSName); when 'null'")
  void testGetInstance_whenNull() {
    // Arrange, Act and Assert
    assertNull(Encoding.getInstance(null));
  }

  /**
   * Test {@link Encoding#getCodeToNameMap()}.
   * <p>
   * Method under test: {@link Encoding#getCodeToNameMap()}
   */
  @Test
  @DisplayName("Test getCodeToNameMap()")
  void testGetCodeToNameMap() {
    // Arrange
    MacExpertEncoding macExpertEncoding = MacExpertEncoding.INSTANCE;

    // Act and Assert
    assertEquals(macExpertEncoding.codeToName, macExpertEncoding.getCodeToNameMap());
  }

  /**
   * Test {@link Encoding#getNameToCodeMap()}.
   * <p>
   * Method under test: {@link Encoding#getNameToCodeMap()}
   */
  @Test
  @DisplayName("Test getNameToCodeMap()")
  void testGetNameToCodeMap() {
    // Arrange
    MacExpertEncoding macExpertEncoding = MacExpertEncoding.INSTANCE;

    // Act and Assert
    assertEquals(macExpertEncoding.inverted, macExpertEncoding.getNameToCodeMap());
  }

  /**
   * Test {@link Encoding#contains(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link MacExpertEncoding} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Encoding#contains(int)}
   */
  @Test
  @DisplayName("Test contains(int) with 'code'; given MacExpertEncoding (default constructor); then return 'false'")
  void testContainsWithCode_givenMacExpertEncoding_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MacExpertEncoding()).contains(1));
  }

  /**
   * Test {@link Encoding#contains(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link MacExpertEncoding#INSTANCE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Encoding#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String) with 'name'; given INSTANCE; then return 'true'")
  void testContainsWithName_givenInstance_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MacExpertEncoding.INSTANCE.contains("Name"));
  }

  /**
   * Test {@link Encoding#contains(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link MacExpertEncoding} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Encoding#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String) with 'name'; given MacExpertEncoding (default constructor); then return 'false'")
  void testContainsWithName_givenMacExpertEncoding_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MacExpertEncoding()).contains("Name"));
  }
}
