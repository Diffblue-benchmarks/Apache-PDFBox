package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class SymbolEncodingDiffblueTest {
  /**
   * Method under test: {@link SymbolEncoding#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSBase actualCOSObject = SymbolEncoding.INSTANCE.getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSName);
    assertEquals("SymbolEncoding", ((COSName) actualCOSObject).getName());
    assertNull(actualCOSObject.getKey());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(((COSName) actualCOSObject).isEmpty());
  }

  /**
   * Method under test: {@link SymbolEncoding#getEncodingName()}
   */
  @Test
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("SymbolEncoding", SymbolEncoding.INSTANCE.getEncodingName());
  }
}
