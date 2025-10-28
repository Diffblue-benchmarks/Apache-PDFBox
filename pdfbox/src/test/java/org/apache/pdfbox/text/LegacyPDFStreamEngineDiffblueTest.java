package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.Test;

class LegacyPDFStreamEngineDiffblueTest {
  /**
   * Method under test:
   * {@link LegacyPDFStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  void testShowGlyph() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.processPage(new PDPage());
    Matrix textRenderingMatrix = new Matrix();
    PDFont font = mock(PDFont.class);
    when(font.getWidth(anyInt())).thenThrow(new IOException("foo"));
    when(font.isVertical()).thenReturn(true);

    // Act and Assert
    assertThrows(IOException.class,
        () -> legacyPDFStreamEngine.showGlyph(textRenderingMatrix, font, 1, new Vector(10.0f, 10.0f)));
    verify(font).getWidth(eq(1));
    verify(font).isVertical();
  }

  /**
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  void testComputeFontHeight() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.642334f, legacyPDFStreamEngine.computeFontHeight(new PDMMType1Font(new COSDictionary())));
  }

  /**
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  void testComputeFontHeight2() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.0f, legacyPDFStreamEngine.computeFontHeight(new PDType3Font(new COSDictionary())));
  }

  /**
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  void testComputeFontHeight3() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.642334f, legacyPDFStreamEngine.computeFontHeight(new PDTrueTypeFont(new COSDictionary())));
  }

  /**
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  void testComputeFontHeight4() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    // Act and Assert
    assertEquals(0.558f,
        legacyPDFStreamEngine.computeFontHeight(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)));
  }

  /**
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  void testComputeFontHeight5() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    // Act and Assert
    assertEquals(0.6515f, legacyPDFStreamEngine.computeFontHeight(new PDType1Font(Standard14Fonts.FontName.SYMBOL)));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link LegacyPDFStreamEngine}
   */
  @Test
  void testNewLegacyPDFStreamEngine() {
    // Arrange and Act
    LegacyPDFStreamEngine actualLegacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Assert
    assertNull(actualLegacyPDFStreamEngine.getCurrentPage());
    assertNull(actualLegacyPDFStreamEngine.getResources());
    assertNull(actualLegacyPDFStreamEngine.getGraphicsState());
    assertNull(actualLegacyPDFStreamEngine.getInitialMatrix());
    assertEquals(0, actualLegacyPDFStreamEngine.getGraphicsStackSize());
    assertEquals(0, actualLegacyPDFStreamEngine.getLevel());
  }
}
