package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GlyphCacheDiffblueTest {
  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetPathForCharacterCode_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDMMType1Font(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetPathForCharacterCode_givenPDMMType1FontWithFontDictionaryIsCOSDictionary2() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDMMType1Font(new COSDictionary())))
        .getPathForCharacterCode(10);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetPathForCharacterCode_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDMMType1Font(new COSStream())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetPathForCharacterCode_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDTrueTypeFont(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetPathForCharacterCode_givenPDType1CFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1CFont(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one")
  void testGetPathForCharacterCode_givenPDType1FontWithBaseFontIsTimesRoman_whenOne() {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when ten")
  void testGetPathForCharacterCode_givenPDType1FontWithBaseFontIsTimesRoman_whenTen() {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)))
        .getPathForCharacterCode(10);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is minus twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); then return Bounds Location y is minus twenty-eight")
  void testGetPathForCharacterCode_thenReturnBoundsLocationYIsMinusTwentyEight() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1CFont(new COSDictionary())))
        .getPathForCharacterCode(46);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPathForCharacterCode.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-28, location.y);
    assertEquals(-28, bounds.y);
    assertEquals(-28.0d, location.getY());
    assertEquals(-28.0d, bounds.getY());
    assertEquals(-28.0d, bounds.getMinY());
    assertEquals(145, location.x);
    assertEquals(145, bounds.x);
    assertEquals(145.0d, location.getX());
    assertEquals(145.0d, bounds.getX());
    assertEquals(145.0d, bounds.getMinX());
    assertEquals(194.0d, currentPoint.getY());
    assertEquals(194.0d, bounds.getMaxY());
    assertEquals(194.0f, ((Point2D.Float) currentPoint).y);
    Dimension size = bounds.getSize();
    assertEquals(222, size.height);
    assertEquals(222, size.width);
    assertEquals(222, bounds.height);
    assertEquals(222, bounds.width);
    assertEquals(222.0d, size.getHeight());
    assertEquals(222.0d, size.getWidth());
    assertEquals(222.0d, bounds.getHeight());
    assertEquals(222.0d, bounds.getWidth());
    assertEquals(256.0d, currentPoint.getX());
    assertEquals(256.0d, bounds.getCenterX());
    assertEquals(256.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(367.0d, bounds.getMaxX());
    assertEquals(83.0d, bounds.getCenterY());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphCache#getPathForCharacterCode(int)}.
   * <ul>
   *   <li>When three hundred.</li>
   *   <li>Then Bounds2D Frame return {@link Double}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  @DisplayName("Test getPathForCharacterCode(int); when three hundred; then Bounds2D Frame return Double")
  void testGetPathForCharacterCode_whenThreeHundred_thenBounds2DFrameReturnDouble() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDTrueTypeFont(new COSDictionary())))
        .getPathForCharacterCode(300);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPathForCharacterCode.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Float);
    assertEquals(166.5d, bounds.getCenterX());
    assertEquals(166.748046875d, bounds2D2.getCenterX());
    Point location = bounds.getLocation();
    assertEquals(24, location.x);
    assertEquals(24, bounds.x);
    assertEquals(24.0d, location.getX());
    assertEquals(24.0d, bounds.getX());
    assertEquals(24.0d, bounds.getMinX());
    assertEquals(24.90234375d, bounds2D2.getMinX());
    assertEquals(24.90234375d, bounds2D2.getX());
    assertEquals(24.902344f, ((Rectangle2D.Float) bounds2D2).x);
    assertEquals(26.3671875d, currentPoint.getX());
    assertEquals(26.367188f, ((Point2D.Float) currentPoint).x);
    assertEquals(283.69140625d, bounds2D2.getWidth());
    assertEquals(283.6914f, ((Rectangle2D.Float) bounds2D2).width);
    Dimension size = bounds.getSize();
    assertEquals(285, size.width);
    assertEquals(285, bounds.width);
    assertEquals(285.0d, size.getWidth());
    assertEquals(285.0d, bounds.getWidth());
    assertEquals(308.59375d, bounds2D2.getMaxX());
    assertEquals(309.0d, bounds.getMaxX());
    assertEquals(432.12890625d, bounds2D2.getCenterY());
    assertEquals(432.5d, bounds.getCenterY());
    assertEquals(864.2578125d, currentPoint.getY());
    assertEquals(864.2578125d, bounds2D2.getHeight());
    assertEquals(864.2578125d, bounds2D2.getMaxY());
    assertEquals(864.2578f, ((Point2D.Float) currentPoint).y);
    assertEquals(864.2578f, ((Rectangle2D.Float) bounds2D2).height);
    assertEquals(865, size.height);
    assertEquals(865, bounds.height);
    assertEquals(865.0d, size.getHeight());
    assertEquals(865.0d, bounds.getHeight());
    assertEquals(865.0d, bounds.getMaxY());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
  }
}
