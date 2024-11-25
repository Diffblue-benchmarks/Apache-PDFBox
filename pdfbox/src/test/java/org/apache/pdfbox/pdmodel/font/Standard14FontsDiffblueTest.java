package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.fontbox.afm.CharMetric;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Standard14FontsDiffblueTest {
  /**
   * Test FontName getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Standard14Fonts.FontName#getName()}
   *   <li>{@link Standard14Fonts.FontName#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test FontName getters and setters")
  void testFontNameGettersAndSetters() {
    // Arrange
    Standard14Fonts.FontName valueOfResult = Standard14Fonts.FontName.valueOf("TIMES_ROMAN");

    // Act
    String actualName = valueOfResult.getName();

    // Assert
    assertEquals("Times-Roman", actualName);
    assertEquals("Times-Roman", valueOfResult.toString());
  }

  /**
   * Test {@link Standard14Fonts#getAFM(String)}.
   * <ul>
   *   <li>When {@code Arial-BoldItalicMT}.</li>
   *   <li>Then return FontVersion is {@code 002.000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getAFM(String)}
   */
  @Test
  @DisplayName("Test getAFM(String); when 'Arial-BoldItalicMT'; then return FontVersion is '002.000'")
  void testGetAFM_whenArialBoldItalicMT_thenReturnFontVersionIs002000() {
    // Arrange and Act
    FontMetrics actualAFM = Standard14Fonts.getAFM("Arial-BoldItalicMT");

    // Assert
    assertEquals("002.000", actualAFM.getFontVersion());
    assertEquals("AdobeStandardEncoding", actualAFM.getEncodingScheme());
    assertEquals("Bold", actualAFM.getWeight());
    List<String> comments = actualAFM.getComments();
    assertEquals(4, comments.size());
    assertEquals("Copyright (c) 1985, 1987, 1989, 1990, 1997 Adobe Systems Incorporated.  All Rights Reserved.",
        comments.get(0));
    assertEquals("Copyright (c) 1985, 1987, 1989, 1990, 1997 Adobe Systems Incorporated.  All Rights Reserved.Helvetica"
        + " is a trademark of Linotype-Hell AG and/or its subsidiaries.", actualAFM.getNotice());
    assertEquals("Creation Date: Thu May  1 12:45:12 1997", comments.get(1));
    List<CharMetric> charMetrics = actualAFM.getCharMetrics();
    assertEquals(315, charMetrics.size());
    CharMetric getResult = charMetrics.get(314);
    assertEquals("Euro", getResult.getName());
    assertEquals("ExtendedRoman", actualAFM.getCharacterSet());
    assertEquals("Helvetica Bold Oblique", actualAFM.getFullName());
    assertEquals("Helvetica", actualAFM.getFamilyName());
    assertEquals("Helvetica-BoldOblique", actualAFM.getFontName());
    assertEquals("UniqueID 43053", comments.get(2));
    assertEquals("VMusage 14482 68586", comments.get(3));
    CharMetric getResult2 = charMetrics.get(1);
    assertEquals("exclam", getResult2.getName());
    CharMetric getResult3 = charMetrics.get(313);
    assertEquals("imacron", getResult3.getName());
    CharMetric getResult4 = charMetrics.get(312);
    assertEquals("onesuperior", getResult4.getName());
    CharMetric getResult5 = charMetrics.get(2);
    assertEquals("quotedbl", getResult5.getName());
    CharMetric getResult6 = charMetrics.get(0);
    assertEquals("space", getResult6.getName());
    assertNull(getResult6.getVv());
    assertNull(getResult2.getVv());
    assertNull(getResult5.getVv());
    assertNull(getResult4.getVv());
    assertNull(getResult3.getVv());
    assertNull(getResult.getVv());
    assertNull(getResult6.getW());
    assertNull(getResult2.getW());
    assertNull(getResult5.getW());
    assertNull(getResult4.getW());
    assertNull(getResult3.getW());
    assertNull(getResult.getW());
    assertNull(getResult6.getW0());
    assertNull(getResult2.getW0());
    assertNull(getResult5.getW0());
    assertNull(getResult4.getW0());
    assertNull(getResult3.getW0());
    assertNull(getResult.getW0());
    assertNull(getResult6.getW1());
    assertNull(getResult2.getW1());
    assertNull(getResult5.getW1());
    assertNull(getResult4.getW1());
    assertNull(getResult3.getW1());
    assertNull(getResult.getW1());
    assertNull(actualAFM.getCharWidth());
    assertNull(actualAFM.getVVector());
    assertEquals(-1, getResult4.getCharacterCode());
    assertEquals(-1, getResult3.getCharacterCode());
    assertEquals(-1, getResult.getCharacterCode());
    assertEquals(-100.0f, actualAFM.getUnderlinePosition());
    assertEquals(-12.0f, actualAFM.getItalicAngle());
    BoundingBox fontBBox = actualAFM.getFontBBox();
    assertEquals(-174.0f, fontBBox.getLowerLeftX());
    assertEquals(-207.0f, actualAFM.getDescender());
    assertEquals(-228.0f, fontBBox.getLowerLeftY());
    assertEquals(0, actualAFM.getCharacters());
    assertEquals(0, actualAFM.getEscChar());
    assertEquals(0, actualAFM.getMappingScheme());
    assertEquals(0, actualAFM.getMetricSets());
    assertEquals(0.0f, getResult6.getW0x());
    assertEquals(0.0f, getResult2.getW0x());
    assertEquals(0.0f, getResult5.getW0x());
    assertEquals(0.0f, getResult4.getW0x());
    assertEquals(0.0f, getResult3.getW0x());
    assertEquals(0.0f, getResult.getW0x());
    assertEquals(0.0f, getResult6.getW0y());
    assertEquals(0.0f, getResult2.getW0y());
    assertEquals(0.0f, getResult5.getW0y());
    assertEquals(0.0f, getResult4.getW0y());
    assertEquals(0.0f, getResult3.getW0y());
    assertEquals(0.0f, getResult.getW0y());
    assertEquals(0.0f, getResult6.getW1x());
    assertEquals(0.0f, getResult2.getW1x());
    assertEquals(0.0f, getResult5.getW1x());
    assertEquals(0.0f, getResult4.getW1x());
    assertEquals(0.0f, getResult3.getW1x());
    assertEquals(0.0f, getResult.getW1x());
    assertEquals(0.0f, getResult6.getW1y());
    assertEquals(0.0f, getResult2.getW1y());
    assertEquals(0.0f, getResult5.getW1y());
    assertEquals(0.0f, getResult4.getW1y());
    assertEquals(0.0f, getResult3.getW1y());
    assertEquals(0.0f, getResult.getW1y());
    assertEquals(0.0f, getResult6.getWy());
    assertEquals(0.0f, getResult2.getWy());
    assertEquals(0.0f, getResult5.getWy());
    assertEquals(0.0f, getResult4.getWy());
    assertEquals(0.0f, getResult3.getWy());
    assertEquals(0.0f, getResult.getWy());
    BoundingBox boundingBox = getResult6.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    BoundingBox boundingBox2 = getResult.getBoundingBox();
    assertEquals(0.0f, boundingBox2.getHeight());
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox2.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    BoundingBox boundingBox3 = getResult2.getBoundingBox();
    assertEquals(0.0f, boundingBox3.getLowerLeftY());
    BoundingBox boundingBox4 = getResult3.getBoundingBox();
    assertEquals(0.0f, boundingBox4.getLowerLeftY());
    assertEquals(0.0f, boundingBox2.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox2.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals(0.0f, boundingBox2.getUpperRightY());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, boundingBox2.getWidth());
    assertEquals(1114.0f, fontBBox.getUpperRightX());
    assertEquals(118.0f, actualAFM.getStandardHorizontalWidth());
    assertEquals(1190.0f, fontBBox.getHeight());
    assertEquals(1288.0f, fontBBox.getWidth());
    assertEquals(140.0f, actualAFM.getStandardVerticalWidth());
    BoundingBox boundingBox5 = getResult4.getBoundingBox();
    assertEquals(148.0f, boundingBox5.getLowerLeftX());
    BoundingBox boundingBox6 = getResult5.getBoundingBox();
    assertEquals(193.0f, boundingBox6.getLowerLeftX());
    assertEquals(240.0f, boundingBox5.getWidth());
    assertEquals(271.0f, boundingBox6.getHeight());
    assertEquals(278.0f, getResult6.getWx());
    assertEquals(278.0f, getResult3.getWx());
    assertEquals(283.0f, boundingBox5.getLowerLeftY());
    assertEquals(303.0f, boundingBox3.getWidth());
    assertEquals(33, getResult2.getCharacterCode());
    assertEquals(333.0f, getResult2.getWx());
    assertEquals(333.0f, getResult4.getWx());
    assertEquals(336.0f, boundingBox6.getWidth());
    assertEquals(34, getResult5.getCharacterCode());
    assertEquals(360.0f, boundingBox4.getWidth());
    assertEquals(388.0f, boundingBox5.getUpperRightX());
    assertEquals(397.0f, boundingBox3.getUpperRightX());
    assertEquals(4.1f, actualAFM.getAFMVersion());
    assertEquals(427.0f, boundingBox5.getHeight());
    assertEquals(429.0f, boundingBox4.getUpperRightX());
    assertEquals(447.0f, boundingBox6.getLowerLeftY());
    assertEquals(474.0f, getResult5.getWx());
    assertEquals(50.0f, actualAFM.getUnderlineThickness());
    assertEquals(529.0f, boundingBox6.getUpperRightX());
    assertEquals(532.0f, actualAFM.getXHeight());
    assertEquals(556.0f, getResult.getWx());
    assertEquals(564.3619f, actualAFM.getAverageCharacterWidth());
    assertEquals(678.0f, boundingBox4.getHeight());
    assertEquals(678.0f, boundingBox4.getUpperRightY());
    assertEquals(69.0f, boundingBox4.getLowerLeftX());
    assertEquals(710.0f, boundingBox5.getUpperRightY());
    assertEquals(718.0f, actualAFM.getAscender());
    assertEquals(718.0f, actualAFM.getCapHeight());
    assertEquals(718.0f, boundingBox3.getHeight());
    assertEquals(718.0f, boundingBox3.getUpperRightY());
    assertEquals(718.0f, boundingBox6.getUpperRightY());
    assertEquals(94.0f, boundingBox3.getLowerLeftX());
    assertEquals(962.0f, fontBBox.getUpperRightY());
    assertFalse(actualAFM.getIsFixedPitch());
    assertFalse(actualAFM.getIsFixedV());
    assertTrue(getResult6.getLigatures().isEmpty());
    assertTrue(getResult2.getLigatures().isEmpty());
    assertTrue(getResult5.getLigatures().isEmpty());
    assertTrue(getResult4.getLigatures().isEmpty());
    assertTrue(getResult3.getLigatures().isEmpty());
    assertTrue(getResult.getLigatures().isEmpty());
    assertTrue(actualAFM.getComposites().isEmpty());
    assertTrue(actualAFM.getKernPairs().isEmpty());
    assertTrue(actualAFM.getKernPairs0().isEmpty());
    assertTrue(actualAFM.getKernPairs1().isEmpty());
    assertTrue(actualAFM.getTrackKern().isEmpty());
    assertTrue(actualAFM.getIsBaseFont());
    assertEquals(Integer.SIZE, getResult6.getCharacterCode());
  }

  /**
   * Test {@link Standard14Fonts#getAFM(String)}.
   * <ul>
   *   <li>When {@code Font Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getAFM(String)}
   */
  @Test
  @DisplayName("Test getAFM(String); when 'Font Name'; then return 'null'")
  void testGetAFM_whenFontName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Standard14Fonts.getAFM("Font Name"));
  }

  /**
   * Test {@link Standard14Fonts#containsName(String)}.
   * <ul>
   *   <li>When {@code Arial-BoldItalicMT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#containsName(String)}
   */
  @Test
  @DisplayName("Test containsName(String); when 'Arial-BoldItalicMT'; then return 'true'")
  void testContainsName_whenArialBoldItalicMT_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Standard14Fonts.containsName("Arial-BoldItalicMT"));
  }

  /**
   * Test {@link Standard14Fonts#containsName(String)}.
   * <ul>
   *   <li>When {@code Font Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#containsName(String)}
   */
  @Test
  @DisplayName("Test containsName(String); when 'Font Name'; then return 'false'")
  void testContainsName_whenFontName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Standard14Fonts.containsName("Font Name"));
  }

  /**
   * Test {@link Standard14Fonts#getNames()}.
   * <p>
   * Method under test: {@link Standard14Fonts#getNames()}
   */
  @Test
  @DisplayName("Test getNames()")
  void testGetNames() {
    // Arrange and Act
    Set<String> actualNames = Standard14Fonts.getNames();

    // Assert
    assertEquals(38, actualNames.size());
    assertTrue(actualNames.contains("Arial,Bold"));
    assertTrue(actualNames.contains("Arial,Italic"));
    assertTrue(actualNames.contains("Arial-ItalicMT"));
    assertTrue(actualNames.contains("Courier-BoldOblique"));
    assertTrue(actualNames.contains("Courier-Oblique"));
    assertTrue(actualNames.contains("Helvetica-Oblique"));
    assertTrue(actualNames.contains("Symbol"));
    assertTrue(actualNames.contains("Symbol,Bold"));
    assertTrue(actualNames.contains("Symbol,Italic"));
    assertTrue(actualNames.contains("Times,Bold"));
    assertTrue(actualNames.contains("Times-Italic"));
  }

  /**
   * Test {@link Standard14Fonts#getMappedFontName(String)}.
   * <p>
   * Method under test: {@link Standard14Fonts#getMappedFontName(String)}
   */
  @Test
  @DisplayName("Test getMappedFontName(String)")
  void testGetMappedFontName() {
    // Arrange, Act and Assert
    assertNull(Standard14Fonts.getMappedFontName("Font Name"));
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return Bounds Location {@link Point#y} is minus thirty-one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'g9'; then return Bounds Location y is minus thirty-one")
  void testGetGlyphPath_whenG9_thenReturnBoundsLocationYIsMinusThirtyOne() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "g9");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualGlyphPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code Glyph Name}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'Glyph Name'; then Bounds Bounds2D return Rectangle")
  void testGetGlyphPath_whenGlyphName_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code HELVETICA}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'HELVETICA'; then Bounds Bounds2D return Rectangle")
  void testGetGlyphPath_whenHelvetica_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.HELVETICA, "Glyph Name");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code .notdef}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when '.notdef'; then Bounds Bounds2D return Rectangle")
  void testGetGlyphPath_whenNotdef_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.ZAPF_DINGBATS, ".notdef");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When
   * {@code org.apache.pdfbox.pdmodel.font.Standard14Fonts$FontName}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'org.apache.pdfbox.pdmodel.font.Standard14Fonts$FontName'")
  void testGetGlyphPath_whenOrgApachePdfboxPdmodelFontStandard14FontsFontName() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN,
        "org.apache.pdfbox.pdmodel.font.Standard14Fonts$FontName");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code SYMBOL}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'SYMBOL'; then Bounds Bounds2D return Rectangle")
  void testGetGlyphPath_whenSymbol_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.SYMBOL, "uni");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code SYMBOL}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'SYMBOL'; then Bounds Bounds2D return Rectangle")
  void testGetGlyphPath_whenSymbol_thenBoundsBounds2DReturnRectangle2() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.SYMBOL, "u");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code u}.</li>
   *   <li>Then return Bounds Location {@link Point#y} is minus twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'u'; then return Bounds Location y is minus twenty-eight")
  void testGetGlyphPath_whenU_thenReturnBoundsLocationYIsMinusTwentyEight() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "u");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualGlyphPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-28, location.y);
    assertEquals(-28, bounds.y);
    assertEquals(-28.0d, location.getY());
    assertEquals(-28.0d, bounds.getY());
    assertEquals(-28.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(1019, size.width);
    assertEquals(1019, bounds.width);
    assertEquals(1019.0d, size.getWidth());
    assertEquals(1019.0d, bounds.getWidth());
    assertEquals(1021.0d, bounds.getMaxX());
    assertEquals(2, location.x);
    assertEquals(2, bounds.x);
    assertEquals(2.0d, location.getX());
    assertEquals(2.0d, bounds.getX());
    assertEquals(2.0d, bounds.getMinX());
    assertEquals(444.0d, bounds.getCenterY());
    assertEquals(511.5d, bounds.getCenterX());
    assertEquals(867.0d, currentPoint.getX());
    assertEquals(867.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(916.0d, currentPoint.getY());
    assertEquals(916.0d, bounds.getMaxY());
    assertEquals(916.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(944, size.height);
    assertEquals(944, bounds.height);
    assertEquals(944.0d, size.getHeight());
    assertEquals(944.0d, bounds.getHeight());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Standard14Fonts#getGlyphPath(Standard14Fonts.FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'uni'; then Bounds Bounds2D return Rectangle")
  void testGetGlyphPath_whenUni_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.ZAPF_DINGBATS, "uni");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
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
}
