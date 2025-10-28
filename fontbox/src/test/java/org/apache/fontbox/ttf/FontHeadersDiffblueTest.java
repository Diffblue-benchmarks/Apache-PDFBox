package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class FontHeadersDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FontHeaders}
   *   <li>{@link FontHeaders#setError(String)}
   *   <li>{@link FontHeaders#setHeaderMacStyle(Integer)}
   *   <li>{@link FontHeaders#setIsOTFAndPostScript(boolean)}
   *   <li>{@link FontHeaders#setName(String)}
   *   <li>{@link FontHeaders#setNonOtfGcid142(byte[])}
   *   <li>{@link FontHeaders#setOs2Windows(OS2WindowsMetricsTable)}
   *   <li>{@link FontHeaders#getError()}
   *   <li>{@link FontHeaders#getFontFamily()}
   *   <li>{@link FontHeaders#getFontSubFamily()}
   *   <li>{@link FontHeaders#getHeaderMacStyle()}
   *   <li>{@link FontHeaders#getName()}
   *   <li>{@link FontHeaders#getNonOtfTableGCID142()}
   *   <li>{@link FontHeaders#getOS2Windows()}
   *   <li>{@link FontHeaders#getOtfOrdering()}
   *   <li>{@link FontHeaders#getOtfRegistry()}
   *   <li>{@link FontHeaders#getOtfSupplement()}
   *   <li>{@link FontHeaders#isOpenTypePostScript()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    FontHeaders actualFontHeaders = new FontHeaders();
    actualFontHeaders.setError("Exception");
    actualFontHeaders.setHeaderMacStyle(1);
    actualFontHeaders.setIsOTFAndPostScript(true);
    actualFontHeaders.setName("Name");
    byte[] nonOtfGcid142 = "AXAXAXAX".getBytes("UTF-8");
    actualFontHeaders.setNonOtfGcid142(nonOtfGcid142);
    OS2WindowsMetricsTable os2Windows = new OS2WindowsMetricsTable();
    actualFontHeaders.setOs2Windows(os2Windows);
    String actualError = actualFontHeaders.getError();
    actualFontHeaders.getFontFamily();
    actualFontHeaders.getFontSubFamily();
    Integer actualHeaderMacStyle = actualFontHeaders.getHeaderMacStyle();
    String actualName = actualFontHeaders.getName();
    byte[] actualNonOtfTableGCID142 = actualFontHeaders.getNonOtfTableGCID142();
    OS2WindowsMetricsTable actualOS2Windows = actualFontHeaders.getOS2Windows();
    actualFontHeaders.getOtfOrdering();
    actualFontHeaders.getOtfRegistry();
    int actualOtfSupplement = actualFontHeaders.getOtfSupplement();
    boolean actualIsOpenTypePostScriptResult = actualFontHeaders.isOpenTypePostScript();

    // Assert that nothing has changed
    assertEquals("Exception", actualError);
    assertEquals("Name", actualName);
    assertEquals(0, actualOtfSupplement);
    assertEquals(1, actualHeaderMacStyle.intValue());
    assertTrue(actualIsOpenTypePostScriptResult);
    assertSame(os2Windows, actualOS2Windows);
    assertSame(nonOtfGcid142, actualNonOtfTableGCID142);
  }

  /**
   * Method under test: {@link FontHeaders#setFontFamily(String, String)}
   */
  @Test
  void testSetFontFamily() {
    // Arrange
    FontHeaders fontHeaders = new FontHeaders();

    // Act
    fontHeaders.setFontFamily("Font Family", "Font Sub Family");

    // Assert
    assertEquals("Font Family", fontHeaders.getFontFamily());
    assertEquals("Font Sub Family", fontHeaders.getFontSubFamily());
  }

  /**
   * Method under test: {@link FontHeaders#setOtfROS(String, String, int)}
   */
  @Test
  void testSetOtfROS() {
    // Arrange
    FontHeaders fontHeaders = new FontHeaders();

    // Act
    fontHeaders.setOtfROS("Otf Registry", "Otf Ordering", 1);

    // Assert
    assertEquals("Otf Ordering", fontHeaders.getOtfOrdering());
    assertEquals("Otf Registry", fontHeaders.getOtfRegistry());
    assertEquals(1, fontHeaders.getOtfSupplement());
  }
}
