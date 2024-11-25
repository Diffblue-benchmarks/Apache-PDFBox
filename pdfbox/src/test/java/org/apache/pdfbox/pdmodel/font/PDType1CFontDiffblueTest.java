package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cff.CFFType1Font;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDType1CFontDiffblueTest {
  /**
   * Test {@link PDType1CFont#PDType1CFont(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#PDType1CFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType1CFont(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewPDType1CFont_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType1CFont actualPdType1CFont = new PDType1CFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdType1CFont.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(fontDictionary, actualPdType1CFont.getCOSObject());
  }

  /**
   * Test {@link PDType1CFont#PDType1CFont(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#PDType1CFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType1CFont(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  void testNewPDType1CFont_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDType1CFont actualPdType1CFont = new PDType1CFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdType1CFont.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(fontDictionary, actualPdType1CFont.getCOSObject());
  }

  /**
   * Test {@link PDType1CFont#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetBaseFont_givenPDType1CFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1CFont(new COSDictionary())).getBaseFont());
  }

  /**
   * Test {@link PDType1CFont#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDType1CFont(COSDictionary) with fontDictionary is COSStream()")
  void testGetBaseFont_givenPDType1CFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1CFont(new COSStream())).getBaseFont());
  }

  /**
   * Test {@link PDType1CFont#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary(); when one")
  void testGetPathWithCode_givenPDType1CFontWithFontDictionaryIsCOSDictionary_whenOne() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
   * Test {@link PDType1CFont#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); when one")
  void testGetPathWithCode_givenPDType1CFontWithFontDictionaryIsCOSStream_whenOne() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSStream())).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
   * Test {@link PDType1CFont#getPath(int)} with {@code code}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then CurrentPoint return {@link Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when forty-six; then CurrentPoint return Float")
  void testGetPathWithCode_whenFortySix_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath(46);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary(); when 'Name'")
  void testGetPathWithName_givenPDType1CFontWithFontDictionaryIsCOSDictionary_whenName() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>When {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); when '.notdef'")
  void testGetPathWithName_givenPDType1CFontWithFontDictionaryIsCOSStream_whenNotdef() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSStream())).getPath(".notdef");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then CurrentPoint return {@link Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g9'; then CurrentPoint return Float")
  void testGetPathWithName_whenG9_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("g9");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-31, location.y);
    assertEquals(-31, bounds.y);
    assertEquals(-31.0d, location.getY());
    assertEquals(-31.0d, bounds.getY());
    assertEquals(-31.0d, bounds.getMinY());
    assertEquals(1387.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(1418, size.height);
    assertEquals(1418, bounds.height);
    assertEquals(1418.0d, size.getHeight());
    assertEquals(1418.0d, bounds.getHeight());
    assertEquals(1456, size.width);
    assertEquals(1456, bounds.width);
    assertEquals(1456.0d, size.getWidth());
    assertEquals(1456.0d, bounds.getWidth());
    assertEquals(1531.0d, bounds.getMaxX());
    assertEquals(222.0d, currentPoint.getY());
    assertEquals(222.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(678.0d, bounds.getCenterY());
    assertEquals(75, location.x);
    assertEquals(75, bounds.x);
    assertEquals(75.0d, location.getX());
    assertEquals(75.0d, bounds.getX());
    assertEquals(75.0d, bounds.getMinX());
    assertEquals(803.0d, bounds.getCenterX());
    assertEquals(818.0d, currentPoint.getX());
    assertEquals(818.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code nbspace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'nbspace'")
  void testGetPathWithName_whenNbspace() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("nbspace");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when '.notdef'")
  void testGetPathWithName_whenNotdef() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath(".notdef");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code sfthyphen}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'sfthyphen'")
  void testGetPathWithName_whenSfthyphen() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1CFont(new COSDictionary())).getPath("sfthyphen");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
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
   * Test {@link PDType1CFont#hasGlyph(int)} with {@code code}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when forty-six; then return 'true'")
  void testHasGlyphWithCode_whenFortySix_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1CFont(new COSDictionary())).hasGlyph(46));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(int)} with {@code code}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when one; then return 'false'")
  void testHasGlyphWithCode_whenOne_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1CFont(new COSDictionary())).hasGlyph(1));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g9'; then return 'true'")
  void testHasGlyphWithName_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1CFont(new COSDictionary())).hasGlyph("g9"));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g942'; then return 'true'")
  void testHasGlyphWithName_whenG942_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1CFont(new COSDictionary())).hasGlyph("g942"));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'Name'; then return 'false'")
  void testHasGlyphWithName_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1CFont(new COSDictionary())).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType1CFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary(); when one")
  void testGetNormalizedPath_givenPDType1CFontWithFontDictionaryIsCOSDictionary_whenOne() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1CFont(new COSDictionary())).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
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
   * Test {@link PDType1CFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); when one")
  void testGetNormalizedPath_givenPDType1CFontWithFontDictionaryIsCOSStream_whenOne() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1CFont(new COSStream())).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
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
   * Test {@link PDType1CFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then CurrentPoint return {@link Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when forty-six; then CurrentPoint return Float")
  void testGetNormalizedPath_whenFortySix_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1CFont(new COSDictionary())).getNormalizedPath(46);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualNormalizedPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
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
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getName()}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetName_givenPDType1CFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1CFont(new COSDictionary())).getName());
  }

  /**
   * Test {@link PDType1CFont#getName()}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType1CFont(COSDictionary) with fontDictionary is COSStream()")
  void testGetName_givenPDType1CFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1CFont(new COSStream())).getName());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox is
   * {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDFontDescriptor() FontBoundingBox is PDRectangle()")
  void testGetBoundingBox_givenPDFontDescriptorFontBoundingBoxIsPDRectangle() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle());

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetBoundingBox_givenPDType1CFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType1CFont(new COSDictionary())).getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftX is {@code 2.14748365E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '2.14748365E9'")
  void testGetBoundingBox_thenReturnLowerLeftXIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightX());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftY is {@code -306.64062}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is '-306.64062'")
  void testGetBoundingBox_thenReturnLowerLeftYIs30664062() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(new PDFontDescriptor());

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftY is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is zero")
  void testGetBoundingBox_thenReturnLowerLeftYIsZero() throws IOException {
    // Arrange
    PDRectangle rect = new PDRectangle();
    rect.setLowerLeftY(2.14748365E9f);

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(rect);

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualBoundingBox.getHeight());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return UpperRightX is {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return UpperRightX is '2383.937'")
  void testGetBoundingBox_thenReturnUpperRightXIs2383937() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(PDRectangle.A0);

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(2383.937f, actualBoundingBox.getUpperRightX());
    assertEquals(2383.937f, actualBoundingBox.getWidth());
    assertEquals(3370.3938f, actualBoundingBox.getHeight());
    assertEquals(3370.3938f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return Width is {@code 2.14748365E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return Width is '2.14748365E9'")
  void testGetBoundingBox_thenReturnWidthIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType1CFont#codeToName(int)}.
   * <p>
   * Method under test: {@link PDType1CFont#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int)")
  void testCodeToName() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".notdef", (new PDType1CFont(new COSDictionary())).codeToName(1));
  }

  /**
   * Test {@link PDType1CFont#readEncodingFromFont()}.
   * <p>
   * Method under test: {@link PDType1CFont#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont()")
  void testReadEncodingFromFont() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());

    // Act
    Encoding actualReadEncodingFromFontResult = pdType1CFont.readEncodingFromFont();

    // Assert
    StandardEncoding standardEncoding = ((StandardEncoding) actualReadEncodingFromFontResult).INSTANCE;
    assertSame(standardEncoding, pdType1CFont.getEncoding());
    assertSame(standardEncoding, actualReadEncodingFromFontResult);
  }

  /**
   * Test {@link PDType1CFont#readCode(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  void testReadCode_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(65, pdType1CFont.readCode(in));
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDType1CFont#getFontMatrix()}.
   * <p>
   * Method under test: {@link PDType1CFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  void testGetFontMatrix() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDType1CFont(new COSDictionary())).getFontMatrix();

    // Assert
    assertEquals(0.0f, actualFontMatrix.getShearX());
    assertEquals(0.0f, actualFontMatrix.getShearY());
    assertEquals(0.0f, actualFontMatrix.getTranslateX());
    assertEquals(0.0f, actualFontMatrix.getTranslateY());
    float[][] values = actualFontMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleY());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorY());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDType1CFont#getWidthFromFont(int)}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return two hundred fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when forty-six; then return two hundred fifty")
  void testGetWidthFromFont_whenFortySix_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDType1CFont(new COSDictionary())).getWidthFromFont(46));
  }

  /**
   * Test {@link PDType1CFont#getWidthFromFont(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 777.83203}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when one; then return '777.83203'")
  void testGetWidthFromFont_whenOne_thenReturn77783203() throws IOException {
    // Arrange, Act and Assert
    assertEquals(777.83203f, (new PDType1CFont(new COSDictionary())).getWidthFromFont(1));
  }

  /**
   * Test {@link PDType1CFont#getHeight(int)}.
   * <p>
   * Method under test: {@link PDType1CFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int)")
  void testGetHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1CFont(new COSDictionary())).getHeight(1));
  }

  /**
   * Test {@link PDType1CFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); when one")
  void testEncodeWithUnicode_givenPDType1CFontWithFontDictionaryIsCOSStream_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1CFont(new COSStream())).encode(1));
  }

  /**
   * Test {@link PDType1CFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when one; then throw IllegalArgumentException")
  void testEncodeWithUnicode_whenOne_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1CFont(new COSDictionary())).encode(1));
  }

  /**
   * Test {@link PDType1CFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1CFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when zero; then throw IllegalArgumentException")
  void testEncodeWithUnicode_whenZero_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1CFont(new COSDictionary())).encode(0));
  }

  /**
   * Test {@link PDType1CFont#getStringWidth(String)}.
   * <p>
   * Method under test: {@link PDType1CFont#getStringWidth(String)}
   */
  @Test
  @DisplayName("Test getStringWidth(String)")
  void testGetStringWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1CFont(new COSDictionary())).getStringWidth("String"));
  }

  /**
   * Test {@link PDType1CFont#getAverageFontWidth()}.
   * <p>
   * Method under test: {@link PDType1CFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth()")
  void testGetAverageFontWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(500.0f, (new PDType1CFont(new COSDictionary())).getAverageFontWidth());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDType1CFont#getCFFType1Font()}
   *   <li>{@link PDType1CFont#getFontBoxFont()}
   *   <li>{@link PDType1CFont#isDamaged()}
   *   <li>{@link PDType1CFont#isEmbedded()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());

    // Act
    CFFType1Font actualCFFType1Font = pdType1CFont.getCFFType1Font();
    FontBoxFont actualFontBoxFont = pdType1CFont.getFontBoxFont();
    boolean actualIsDamagedResult = pdType1CFont.isDamaged();

    // Assert
    assertTrue(actualFontBoxFont instanceof TrueTypeFont);
    assertNull(actualCFFType1Font);
    assertFalse(actualIsDamagedResult);
    assertFalse(pdType1CFont.isEmbedded());
  }
}
