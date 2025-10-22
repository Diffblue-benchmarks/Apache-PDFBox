package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.io.IOException;
import java.util.Set;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Standard14FontsDiffblueTest {
  /**
   * Test FontName getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FontName#getName()}
   *   <li>{@link FontName#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test FontName getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FontName.getName()", "String FontName.toString()"})
  void testFontNameGettersAndSetters() {
    // Arrange
    FontName valueOfResult = FontName.valueOf("TIMES_ROMAN");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMetrics Standard14Fonts.getAFM(String)"})
  void testGetAFM_whenArialBoldItalicMT_thenReturnFontVersionIs002000() {
    // Arrange and Act
    FontMetrics actualAFM = Standard14Fonts.getAFM("Arial-BoldItalicMT");

    // Assert
    assertEquals("002.000", actualAFM.getFontVersion());
    assertEquals("AdobeStandardEncoding", actualAFM.getEncodingScheme());
    assertEquals("Bold", actualAFM.getWeight());
    assertEquals("Copyright (c) 1985, 1987, 1989, 1990, 1997 Adobe Systems Incorporated.  All Rights Reserved.Helvetica"
        + " is a trademark of Linotype-Hell AG and/or its subsidiaries.", actualAFM.getNotice());
    assertEquals("ExtendedRoman", actualAFM.getCharacterSet());
    assertEquals("Helvetica Bold Oblique", actualAFM.getFullName());
    assertEquals("Helvetica", actualAFM.getFamilyName());
    assertEquals("Helvetica-BoldOblique", actualAFM.getFontName());
    assertNull(actualAFM.getCharWidth());
    assertNull(actualAFM.getVVector());
    assertEquals(-100.0f, actualAFM.getUnderlinePosition());
    assertEquals(-12.0f, actualAFM.getItalicAngle());
    assertEquals(-207.0f, actualAFM.getDescender());
    assertEquals(0, actualAFM.getCharacters());
    assertEquals(0, actualAFM.getEscChar());
    assertEquals(0, actualAFM.getMappingScheme());
    assertEquals(0, actualAFM.getMetricSets());
    assertEquals(118.0f, actualAFM.getStandardHorizontalWidth());
    assertEquals(140.0f, actualAFM.getStandardVerticalWidth());
    assertEquals(315, actualAFM.getCharMetrics().size());
    assertEquals(4, actualAFM.getComments().size());
    assertEquals(4.1f, actualAFM.getAFMVersion());
    assertEquals(50.0f, actualAFM.getUnderlineThickness());
    assertEquals(532.0f, actualAFM.getXHeight());
    assertEquals(564.3619f, actualAFM.getAverageCharacterWidth());
    assertEquals(718.0f, actualAFM.getAscender());
    assertEquals(718.0f, actualAFM.getCapHeight());
    assertFalse(actualAFM.getIsFixedPitch());
    assertFalse(actualAFM.getIsFixedV());
    assertTrue(actualAFM.getComposites().isEmpty());
    assertTrue(actualAFM.getKernPairs().isEmpty());
    assertTrue(actualAFM.getKernPairs0().isEmpty());
    assertTrue(actualAFM.getKernPairs1().isEmpty());
    assertTrue(actualAFM.getTrackKern().isEmpty());
    assertTrue(actualAFM.getIsBaseFont());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMetrics Standard14Fonts.getAFM(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Standard14Fonts.containsName(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Standard14Fonts.containsName(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Standard14Fonts.getNames()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontName Standard14Fonts.getMappedFontName(String)"})
  void testGetMappedFontName() {
    // Arrange, Act and Assert
    assertNull(Standard14Fonts.getMappedFontName("Font Name"));
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'g9'; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenG9_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "g9");

    // Assert
    assertTrue(actualGlyphPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualGlyphPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code HELVETICA}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'HELVETICA'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenHelvetica_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.HELVETICA, "Glyph Name");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
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
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when '.notdef'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenNotdef_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.ZAPF_DINGBATS, ".notdef");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code Standard14Fonts$FontName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'org.apache.pdfbox.pdmodel.font.Standard14Fonts$FontName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenOrgApachePdfboxPdmodelFontStandard14FontsFontName() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN,
        "org.apache.pdfbox.pdmodel.font.Standard14Fonts$FontName");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
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
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'SYMBOL'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenSymbol_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.SYMBOL, "uni");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code TIMES_ROMAN}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'TIMES_ROMAN'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenTimesRoman_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code u}.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'u'; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenU_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.ZAPF_DINGBATS, "u");

    // Assert
    assertTrue(actualGlyphPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualGlyphPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link Standard14Fonts#getGlyphPath(FontName, String)}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Standard14Fonts#getGlyphPath(FontName, String)}
   */
  @Test
  @DisplayName("Test getGlyphPath(FontName, String); when 'uni'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Standard14Fonts.getGlyphPath(FontName, String)"})
  void testGetGlyphPath_whenUni_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualGlyphPath = Standard14Fonts.getGlyphPath(FontName.ZAPF_DINGBATS, "uni");

    // Assert
    Rectangle bounds = actualGlyphPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualGlyphPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }
}
