package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class EncodingDiffblueTest {
  /**
   * Method under test: {@link Encoding#getInstance(COSName)}
   */
  @Test
  void testGetInstance() {
    // Arrange, Act and Assert
    assertNull(Encoding.getInstance(COSName.A));
    assertNull(Encoding.getInstance(null));
  }

  /**
   * Method under test: {@link Encoding#getCodeToNameMap()}
   */
  @Test
  void testGetCodeToNameMap() {
    // Arrange
    MacExpertEncoding macExpertEncoding = MacExpertEncoding.INSTANCE;

    // Act and Assert
    assertEquals(macExpertEncoding.codeToName, macExpertEncoding.getCodeToNameMap());
  }

  /**
   * Method under test: {@link Encoding#getNameToCodeMap()}
   */
  @Test
  void testGetNameToCodeMap() {
    // Arrange
    MacExpertEncoding macExpertEncoding = MacExpertEncoding.INSTANCE;

    // Act and Assert
    assertEquals(macExpertEncoding.inverted, macExpertEncoding.getNameToCodeMap());
  }

  /**
   * Method under test: {@link Encoding#contains(int)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertFalse((new MacExpertEncoding()).contains(1));
  }
}
