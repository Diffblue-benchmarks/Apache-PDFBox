package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StandardEncodingDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StandardEncoding#getCOSObject()}
   *   <li>{@link StandardEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    StandardEncoding standardEncoding = StandardEncoding.INSTANCE;

    // Act
    COSBase actualCOSObject = standardEncoding.getCOSObject();

    // Assert
    assertEquals("StandardEncoding", standardEncoding.getEncodingName());
    assertSame(((COSName) actualCOSObject).STANDARD_ENCODING, actualCOSObject);
  }
}
