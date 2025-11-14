package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontHeadersDiffblueTest {
  /**
   * Test {@link FontHeaders#setFontFamily(String, String)}.
   *
   * <p>Method under test: {@link FontHeaders#setFontFamily(String, String)}
   */
  @Test
  @DisplayName("Test setFontFamily(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontHeaders.setFontFamily(String, String)"})
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
   * Test {@link FontHeaders#setOtfROS(String, String, int)}.
   *
   * <p>Method under test: {@link FontHeaders#setOtfROS(String, String, int)}
   */
  @Test
  @DisplayName("Test setOtfROS(String, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontHeaders.setOtfROS(String, String, int)"})
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

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FontHeaders.<init>()",
    "String FontHeaders.getError()",
    "String FontHeaders.getFontFamily()",
    "String FontHeaders.getFontSubFamily()",
    "Integer FontHeaders.getHeaderMacStyle()",
    "String FontHeaders.getName()",
    "byte[] FontHeaders.getNonOtfTableGCID142()",
    "OS2WindowsMetricsTable FontHeaders.getOS2Windows()",
    "String FontHeaders.getOtfOrdering()",
    "String FontHeaders.getOtfRegistry()",
    "int FontHeaders.getOtfSupplement()",
    "boolean FontHeaders.isOpenTypePostScript()",
    "void FontHeaders.setError(String)",
    "void FontHeaders.setHeaderMacStyle(Integer)",
    "void FontHeaders.setIsOTFAndPostScript(boolean)",
    "void FontHeaders.setName(String)",
    "void FontHeaders.setNonOtfGcid142(byte[])",
    "void FontHeaders.setOs2Windows(OS2WindowsMetricsTable)"
  })
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
    String actualFontFamily = actualFontHeaders.getFontFamily();
    String actualFontSubFamily = actualFontHeaders.getFontSubFamily();
    Integer actualHeaderMacStyle = actualFontHeaders.getHeaderMacStyle();
    String actualName = actualFontHeaders.getName();
    byte[] actualNonOtfTableGCID142 = actualFontHeaders.getNonOtfTableGCID142();
    OS2WindowsMetricsTable actualOS2Windows = actualFontHeaders.getOS2Windows();
    String actualOtfOrdering = actualFontHeaders.getOtfOrdering();
    String actualOtfRegistry = actualFontHeaders.getOtfRegistry();
    int actualOtfSupplement = actualFontHeaders.getOtfSupplement();
    boolean actualIsOpenTypePostScriptResult = actualFontHeaders.isOpenTypePostScript();

    // Assert
    assertEquals("Exception", actualError);
    assertEquals("Name", actualName);
    assertNull(actualFontFamily);
    assertNull(actualFontSubFamily);
    assertNull(actualOtfOrdering);
    assertNull(actualOtfRegistry);
    assertEquals(0, actualOtfSupplement);
    assertEquals(1, actualHeaderMacStyle.intValue());
    assertTrue(actualIsOpenTypePostScriptResult);
    assertSame(os2Windows, actualOS2Windows);
    assertSame(nonOtfGcid142, actualNonOtfTableGCID142);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNonOtfTableGCID142);
  }
}
