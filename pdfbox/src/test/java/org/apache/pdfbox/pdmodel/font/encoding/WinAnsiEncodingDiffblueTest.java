package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WinAnsiEncodingDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WinAnsiEncoding#getCOSObject()}
   *   <li>{@link WinAnsiEncoding#getEncodingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSBase WinAnsiEncoding.getCOSObject()",
    "java.lang.String WinAnsiEncoding.getEncodingName()"
  })
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
