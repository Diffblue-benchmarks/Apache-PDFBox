package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphCacheDiffblueTest {
  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDMMType1Font(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_givenPDMMType1FontWithFontDictionaryIsCOSDictionary2() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDMMType1Font(new COSDictionary())))
        .getPathForCharacterCode(10);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDTrueTypeFont(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_givenPDType1CFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1CFont(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_givenPDType1FontWithBaseFontIsTimesRoman_whenOne() {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1Font(FontName.TIMES_ROMAN)))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_givenPDType1FontWithBaseFontIsTimesRoman_whenTen() {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1Font(FontName.TIMES_ROMAN)))
        .getPathForCharacterCode(10);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); when forty-six; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_whenFortySix_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1CFont(new COSDictionary())))
        .getPathForCharacterCode(46);

    // Assert
    assertTrue(actualPathForCharacterCode.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPathForCharacterCode.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>When three hundred.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); when three hundred; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath GlyphCache.getPathForCharacterCode(int)"})
  void testGetPathForCharacterCode_whenThreeHundred_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDTrueTypeFont(new COSDictionary())))
        .getPathForCharacterCode(300);

    // Assert
    assertTrue(actualPathForCharacterCode.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPathForCharacterCode.getBounds2D() instanceof Float);
  }
}
