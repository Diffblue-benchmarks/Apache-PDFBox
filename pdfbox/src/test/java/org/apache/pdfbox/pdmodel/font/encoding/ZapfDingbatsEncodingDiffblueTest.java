package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ZapfDingbatsEncodingDiffblueTest {
  /**
   * Test {@link ZapfDingbatsEncoding#getCOSObject()}.
   *
   * <p>Method under test: {@link ZapfDingbatsEncoding#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase ZapfDingbatsEncoding.getCOSObject()"})
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
   * Test {@link ZapfDingbatsEncoding#getEncodingName()}.
   *
   * <p>Method under test: {@link ZapfDingbatsEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ZapfDingbatsEncoding.getEncodingName()"})
  void testGetEncodingName() {
    // Arrange, Act and Assert
    assertEquals("ZapfDingbatsEncoding", ZapfDingbatsEncoding.INSTANCE.getEncodingName());
  }
}
