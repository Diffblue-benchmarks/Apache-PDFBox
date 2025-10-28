package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class XReferenceTypeDiffblueTest {
  /**
   * Method under test: {@link XReferenceType#getNumericValue()}
   */
  @Test
  void testGetNumericValue() {
    // Arrange, Act and Assert
    assertEquals(0, XReferenceType.valueOf("FREE").getNumericValue());
  }
}
