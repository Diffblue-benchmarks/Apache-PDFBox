package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class WinAnsiEncodingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WinAnsiEncoding#getCOSObject()}
   *   <li>{@link WinAnsiEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    WinAnsiEncoding winAnsiEncoding = WinAnsiEncoding.INSTANCE;

    // Act
    COSBase actualCOSObject = winAnsiEncoding.getCOSObject();

    // Assert
    assertEquals("WinAnsiEncoding", winAnsiEncoding.getEncodingName());
    assertSame(((COSName) actualCOSObject).WIN_ANSI_ENCODING, actualCOSObject);
  }
}
