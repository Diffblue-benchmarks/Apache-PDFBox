package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDType3CharProcDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDType3CharProc#PDType3CharProc(PDType3Font, COSStream)}
   *   <li>{@link PDType3CharProc#getFont()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDType3CharProc.<init>(PDType3Font, COSStream)", "PDType3Font PDType3CharProc.getFont()"})
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act
    PDType3CharProc actualPdType3CharProc = new PDType3CharProc(font, charStream);
    PDType3Font actualFont = actualPdType3CharProc.getFont();

    // Assert
    assertSame(charStream, actualPdType3CharProc.getCOSObject());
    assertSame(font, actualFont);
  }

  /**
   * Test {@link PDType3CharProc#getCOSObject()}.
   * <p>
   * Method under test: {@link PDType3CharProc#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream PDType3CharProc.getCOSObject()"})
  void testGetCOSObject() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act and Assert
    assertSame(charStream, (new PDType3CharProc(font, charStream)).getCOSObject());
  }

  /**
   * Test {@link PDType3CharProc#getContentStream()}.
   * <p>
   * Method under test: {@link PDType3CharProc#getContentStream()}
   */
  @Test
  @DisplayName("Test getContentStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDStream PDType3CharProc.getContentStream()"})
  void testGetContentStream() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act
    PDStream actualContentStream = (new PDType3CharProc(font, charStream)).getContentStream();

    // Assert
    assertNull(actualContentStream.getDecodeParms());
    assertNull(actualContentStream.getFileDecodeParams());
    assertNull(actualContentStream.getMetadata());
    assertNull(actualContentStream.getFile());
    assertEquals(-1, actualContentStream.getDecodedStreamLength());
    assertEquals(0, actualContentStream.getLength());
    List<String> fileFilters = actualContentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(charStream, actualContentStream.getCOSObject());
    assertSame(fileFilters, actualContentStream.getFilters());
  }

  /**
   * Test {@link PDType3CharProc#getResources()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.PDResources PDType3CharProc.getResources()"})
  void testGetResources_thenReturnNull() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getResources());
  }

  /**
   * Test {@link PDType3CharProc#getBBox()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getBBox()"})
  void testGetBBox_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getBBox());
  }

  /**
   * Test {@link PDType3CharProc#getMatrix()}.
   * <p>
   * Method under test: {@link PDType3CharProc#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.util.Matrix PDType3CharProc.getMatrix()"})
  void testGetMatrix() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertSame(font.DEFAULT_FONT_MATRIX, (new PDType3CharProc(font, new COSStream())).getMatrix());
  }
}
