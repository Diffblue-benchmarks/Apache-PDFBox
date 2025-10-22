package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpenTypeFontDiffblueTest {
  /**
   * Test {@link OpenTypeFont#OpenTypeFont(TTFDataStream)}.
   * <p>
   * Method under test: {@link OpenTypeFont#OpenTypeFont(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new OpenTypeFont(TTFDataStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OpenTypeFont.<init>(TTFDataStream)"})
  void testNewOpenTypeFont() throws IOException {
    // Arrange and Act
    OpenTypeFont actualOpenTypeFont = new OpenTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertNull(actualOpenTypeFont.getName());
    assertNull(actualOpenTypeFont.getCmap());
    assertNull(actualOpenTypeFont.getGsub());
    assertNull(actualOpenTypeFont.getGlyph());
    assertNull(actualOpenTypeFont.getHeader());
    assertNull(actualOpenTypeFont.getHorizontalHeader());
    assertNull(actualOpenTypeFont.getHorizontalMetrics());
    assertNull(actualOpenTypeFont.getIndexToLocation());
    assertNull(actualOpenTypeFont.getKerning());
    assertNull(actualOpenTypeFont.getMaximumProfile());
    assertNull(actualOpenTypeFont.getNaming());
    assertNull(actualOpenTypeFont.getOS2Windows());
    assertNull(actualOpenTypeFont.getPostScript());
    assertNull(actualOpenTypeFont.getVerticalHeader());
    assertNull(actualOpenTypeFont.getVerticalMetrics());
    assertNull(actualOpenTypeFont.getVerticalOrigin());
    assertEquals(0, actualOpenTypeFont.getNumberOfGlyphs());
    assertEquals(0, actualOpenTypeFont.getUnitsPerEm());
    assertEquals(0.0f, actualOpenTypeFont.getVersion());
    assertEquals(6, actualOpenTypeFont.getFontMatrix().size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualOpenTypeFont.getOriginalData().read(byteArray));
    assertEquals(8L, actualOpenTypeFont.getOriginalDataSize());
    assertTrue(actualOpenTypeFont.getTables().isEmpty());
    assertTrue(actualOpenTypeFont.getTableMap().isEmpty());
    assertTrue(actualOpenTypeFont.isEnableGsub());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link OpenTypeFont#setVersion(float)}.
   * <p>
   * Method under test: {@link OpenTypeFont#setVersion(float)}
   */
  @Test
  @DisplayName("Test setVersion(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OpenTypeFont.setVersion(float)"})
  void testSetVersion() throws IOException {
    // Arrange
    OpenTypeFont openTypeFont = new OpenTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    openTypeFont.setVersion(10.0f);

    // Assert
    assertEquals(10.0f, openTypeFont.getVersion());
  }

  /**
   * Test {@link OpenTypeFont#getCFF()}.
   * <p>
   * Method under test: {@link OpenTypeFont#getCFF()}
   */
  @Test
  @DisplayName("Test getCFF()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.CFFTable OpenTypeFont.getCFF()"})
  void testGetCFF() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getCFF());
  }

  /**
   * Test {@link OpenTypeFont#getGlyph()}.
   * <p>
   * Method under test: {@link OpenTypeFont#getGlyph()}
   */
  @Test
  @DisplayName("Test getGlyph()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.ttf.GlyphTable OpenTypeFont.getGlyph()"})
  void testGetGlyph() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getGlyph());
  }

  /**
   * Test {@link OpenTypeFont#isPostScript()}.
   * <p>
   * Method under test: {@link OpenTypeFont#isPostScript()}
   */
  @Test
  @DisplayName("Test isPostScript()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OpenTypeFont.isPostScript()"})
  void testIsPostScript() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .isPostScript());
  }

  /**
   * Test {@link OpenTypeFont#isSupportedOTF()}.
   * <p>
   * Method under test: {@link OpenTypeFont#isSupportedOTF()}
   */
  @Test
  @DisplayName("Test isSupportedOTF()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OpenTypeFont.isSupportedOTF()"})
  void testIsSupportedOTF() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .isSupportedOTF());
  }

  /**
   * Test {@link OpenTypeFont#hasLayoutTables()}.
   * <p>
   * Method under test: {@link OpenTypeFont#hasLayoutTables()}
   */
  @Test
  @DisplayName("Test hasLayoutTables()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OpenTypeFont.hasLayoutTables()"})
  void testHasLayoutTables() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasLayoutTables());
  }
}
