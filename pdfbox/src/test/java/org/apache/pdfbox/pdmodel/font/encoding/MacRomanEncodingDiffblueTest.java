package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class MacRomanEncodingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MacRomanEncoding#getCOSObject()}
   *   <li>{@link MacRomanEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MacRomanEncoding macRomanEncoding = new MacRomanEncoding();

    // Act
    COSBase actualCOSObject = macRomanEncoding.getCOSObject();

    // Assert
    assertEquals("MacRomanEncoding", macRomanEncoding.getEncodingName());
    assertSame(((COSName) actualCOSObject).MAC_ROMAN_ENCODING, actualCOSObject);
  }
}
