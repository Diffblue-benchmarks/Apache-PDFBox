package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class ZapfDingbatsEncodingDiffblueTest {
  /**
   * Method under test: {@link ZapfDingbatsEncoding#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSBase actualCOSObject = ZapfDingbatsEncoding.INSTANCE.getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSName);
    assertEquals("ZapfDingbatsEncoding", ((COSName) actualCOSObject).getName());
    assertNull(actualCOSObject.getKey());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(((COSName) actualCOSObject).isEmpty());
  }

  /**
   * Method under test: {@link ZapfDingbatsEncoding#getEncodingName()}
   */
  @Test
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("ZapfDingbatsEncoding", ZapfDingbatsEncoding.INSTANCE.getEncodingName());
  }
}
