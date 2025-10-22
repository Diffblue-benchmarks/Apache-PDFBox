package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymbolEncodingDiffblueTest {
  /**
   * Test {@link SymbolEncoding#getCOSObject()}.
   * <p>
   * Method under test: {@link SymbolEncoding#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase SymbolEncoding.getCOSObject()"})
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
   * Test {@link SymbolEncoding#getEncodingName()}.
   * <p>
   * Method under test: {@link SymbolEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String SymbolEncoding.getEncodingName()"})
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("SymbolEncoding", SymbolEncoding.INSTANCE.getEncodingName());
  }
}
