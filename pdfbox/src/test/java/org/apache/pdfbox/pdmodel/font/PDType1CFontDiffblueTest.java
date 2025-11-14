package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDType1CFontDiffblueTest {
  @Mock private COSDictionary cOSDictionary;

  @InjectMocks private PDType1CFont pDType1CFont;

  /**
   * Test {@link PDType1CFont#PDType1CFont(COSDictionary)}.
   *
   * <ul>
   *   <li>Then return FontBoxFont TableMap size is nineteen.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#PDType1CFont(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDType1CFont(COSDictionary); then return FontBoxFont TableMap size is nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDType1CFont.<init>(COSDictionary)"})
  void testNewPDType1CFont_thenReturnFontBoxFontTableMapSizeIsNineteen() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType1CFont actualPdType1CFont = new PDType1CFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdType1CFont.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    float[][] values = actualPdType1CFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertSame(fontDictionary, actualPdType1CFont.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDType1CFont#PDType1CFont(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#PDType1CFont(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDType1CFont(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDType1CFont.<init>(COSDictionary)"})
  void testNewPDType1CFont_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act and Assert
    assertSame(fontDictionary, new PDType1CFont(fontDictionary).getCOSObject());
  }

  /**
   * Test {@link PDType1CFont#getBaseFont()}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBaseFont()}
   */
  @Test
  @DisplayName(
      "Test getBaseFont(); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1CFont.getBaseFont()"})
  void testGetBaseFont_givenPDType1CFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType1CFont(new COSDictionary()).getBaseFont());
  }

  /**
   * Test {@link PDType1CFont#getBaseFont()}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBaseFont()}
   */
  @Test
  @DisplayName(
      "Test getBaseFont(); given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1CFont.getBaseFont()"})
  void testGetBaseFont_givenPDType1CFontWithFontDictionaryIsCOSStream_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType1CFont(new COSStream()).getBaseFont());
  }

  /**
   * Test {@link PDType1CFont#getPath(int)} with {@code code}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  @DisplayName(
      "Test getPath(int) with 'code'; given PDType1CFont(COSDictionary) with fontDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(int)"})
  void testGetPathWithCode_givenPDType1CFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSStream()).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(int)} with {@code code}.
   *
   * <ul>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(int)"})
  void testGetPathWithCode_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSDictionary()).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(int)} with {@code code}.
   *
   * <ul>
   *   <li>When forty-six.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when forty-six; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(int)"})
  void testGetPathWithCode_whenFortySix_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSDictionary()).getPath(46);

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary}.
   *   <li>When {@code g942}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given COSDictionary; when 'g942'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(String)"})
  void testGetPathWithName_givenCOSDictionary_whenG942() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = pDType1CFont.getPath("g942");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName(
      "Test getPath(String) with 'name'; given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary(); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(String)"})
  void testGetPathWithName_givenPDType1CFontWithFontDictionaryIsCOSDictionary_whenName()
      throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSDictionary()).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>When {@code .notdef}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName(
      "Test getPath(String) with 'name'; given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); when '.notdef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(String)"})
  void testGetPathWithName_givenPDType1CFontWithFontDictionaryIsCOSStream_whenNotdef()
      throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSStream()).getPath(".notdef");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code g9}.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g9'; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(String)"})
  void testGetPathWithName_whenG9_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSDictionary()).getPath("g9");

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code nbspace}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'nbspace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(String)"})
  void testGetPathWithName_whenNbspace() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSDictionary()).getPath("nbspace");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code .notdef}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when '.notdef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(String)"})
  void testGetPathWithName_whenNotdef() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSDictionary()).getPath(".notdef");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code sfthyphen}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'sfthyphen'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getPath(String)"})
  void testGetPathWithName_whenSfthyphen() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1CFont(new COSDictionary()).getPath("sfthyphen");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(int)} with {@code code}.
   *
   * <ul>
   *   <li>When forty-six.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when forty-six; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1CFont.hasGlyph(int)"})
  void testHasGlyphWithCode_whenFortySix_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDType1CFont(new COSDictionary()).hasGlyph(46));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(int)} with {@code code}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1CFont.hasGlyph(int)"})
  void testHasGlyphWithCode_whenOne_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType1CFont(new COSDictionary()).hasGlyph(1));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code g9}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g9'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1CFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDType1CFont(new COSDictionary()).hasGlyph("g9"));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code g942}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g942'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1CFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenG942_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDType1CFont(new COSDictionary()).hasGlyph("g942"));
  }

  /**
   * Test {@link PDType1CFont#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1CFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType1CFont(new COSDictionary()).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType1CFont#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName(
      "Test getNormalizedPath(int); given PDType1CFont(COSDictionary) with fontDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType1CFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = new PDType1CFont(new COSStream()).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getNormalizedPath(int)"})
  void testGetNormalizedPath_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = new PDType1CFont(new COSDictionary()).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1CFont#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>When forty-six.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when forty-six; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1CFont.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenFortySix_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = new PDType1CFont(new COSDictionary()).getNormalizedPath(46);

    // Assert
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1CFont#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1CFont.getName()"})
  void testGetName_givenPDType1CFontWithFontDictionaryIsCOSDictionary_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType1CFont(new COSDictionary()).getName());
  }

  /**
   * Test {@link PDType1CFont#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1CFont.getName()"})
  void testGetName_givenPDType1CFontWithFontDictionaryIsCOSStream_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType1CFont(new COSStream()).getName());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox is {@link
   *       PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDFontDescriptor() FontBoundingBox is PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1CFont.getBoundingBox()"})
  void testGetBoundingBox_givenPDFontDescriptorFontBoundingBoxIsPDRectangle() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle());

    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test getBoundingBox(); given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1CFont.getBoundingBox()"})
  void testGetBoundingBox_givenPDType1CFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = new PDType1CFont(new COSDictionary()).getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   *
   * <ul>
   *   <li>Then return LowerLeftX is {@code -176.75781}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '-176.75781'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1CFont.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIs17675781() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    pdType1CFont.setFontDescriptor(new PDFontDescriptor());

    // Act
    BoundingBox actualBoundingBox = pdType1CFont.getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1CFont#getBoundingBox()}.
   *
   * <ul>
   *   <li>Then return LowerLeftX is {@code 2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1CFont.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDRectangle rect = new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fontDescriptor.setFontBoundingBox(rect);

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
   *
   * <ul>
   *   <li>Then return LowerLeftY is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1CFont.getBoundingBox()"})
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
   *
   * <ul>
   *   <li>Then return UpperRightX is {@code 2383.937}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return UpperRightX is '2383.937'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1CFont.getBoundingBox()"})
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
   *
   * <ul>
   *   <li>Then return Width is {@code 2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return Width is '2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1CFont.getBoundingBox()"})
  void testGetBoundingBox_thenReturnWidthIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDRectangle rect = new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fontDescriptor.setFontBoundingBox(rect);

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
   *
   * <p>Method under test: {@link PDType1CFont#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1CFont.codeToName(int)"})
  void testCodeToName() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".notdef", new PDType1CFont(new COSDictionary()).codeToName(1));
  }

  /**
   * Test {@link PDType1CFont#readEncodingFromFont()}.
   *
   * <p>Method under test: {@link PDType1CFont#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Encoding PDType1CFont.readEncodingFromFont()"})
  void testReadEncodingFromFont() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());

    // Act
    Encoding actualReadEncodingFromFontResult = pdType1CFont.readEncodingFromFont();

    // Assert
    StandardEncoding standardEncoding =
        ((StandardEncoding) actualReadEncodingFromFontResult).INSTANCE;
    assertSame(standardEncoding, pdType1CFont.getEncoding());
    assertSame(standardEncoding, actualReadEncodingFromFontResult);
  }

  /**
   * Test {@link PDType1CFont#readCode(InputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDType1CFont.readCode(InputStream)"})
  void testReadCode_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());

    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> pdType1CFont.readCode(in));
    verify(in).read();
  }

  /**
   * Test {@link PDType1CFont#readCode(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#readCode(InputStream)}
   */
  @Test
  @DisplayName(
      "Test readCode(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDType1CFont.readCode(InputStream)"})
  void testReadCode_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws IOException {
    // Arrange
    PDType1CFont pdType1CFont = new PDType1CFont(new COSDictionary());
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadCodeResult = pdType1CFont.readCode(in);

    // Assert
    assertEquals(65, actualReadCodeResult);
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDType1CFont#getFontMatrix()}.
   *
   * <p>Method under test: {@link PDType1CFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType1CFont.getFontMatrix()"})
  void testGetFontMatrix() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = new PDType1CFont(new COSDictionary()).getFontMatrix();

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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDType1CFont#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>When forty-six.
   *   <li>Then return two hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when forty-six; then return two hundred fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1CFont.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenFortySix_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, new PDType1CFont(new COSDictionary()).getWidthFromFont(46));
  }

  /**
   * Test {@link PDType1CFont#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 365.23438}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when one; then return '365.23438'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1CFont.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenOne_thenReturn36523438() throws IOException {
    // Arrange, Act and Assert
    assertEquals(365.23438f, new PDType1CFont(new COSDictionary()).getWidthFromFont(1));
  }

  /**
   * Test {@link PDType1CFont#getHeight(int)}.
   *
   * <p>Method under test: {@link PDType1CFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1CFont.getHeight(int)"})
  void testGetHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType1CFont(new COSDictionary()).getHeight(1));
  }

  /**
   * Test {@link PDType1CFont#encode(int)} with {@code unicode}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#encode(int)}
   */
  @Test
  @DisplayName(
      "Test encode(int) with 'unicode'; given PDType1CFont(COSDictionary) with fontDictionary is COSDictionary(); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDType1CFont.encode(int)"})
  void testEncodeWithUnicode_givenPDType1CFontWithFontDictionaryIsCOSDictionary_whenOne()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDType1CFont(new COSDictionary()).encode(1));
  }

  /**
   * Test {@link PDType1CFont#encode(int)} with {@code unicode}.
   *
   * <ul>
   *   <li>Given {@link PDType1CFont#PDType1CFont(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#encode(int)}
   */
  @Test
  @DisplayName(
      "Test encode(int) with 'unicode'; given PDType1CFont(COSDictionary) with fontDictionary is COSStream(); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDType1CFont.encode(int)"})
  void testEncodeWithUnicode_givenPDType1CFontWithFontDictionaryIsCOSStream_whenOne()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDType1CFont(new COSStream()).encode(1));
  }

  /**
   * Test {@link PDType1CFont#encode(int)} with {@code unicode}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType1CFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDType1CFont.encode(int)"})
  void testEncodeWithUnicode_whenZero() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDType1CFont(new COSDictionary()).encode(0));
  }

  /**
   * Test {@link PDType1CFont#getStringWidth(String)}.
   *
   * <p>Method under test: {@link PDType1CFont#getStringWidth(String)}
   */
  @Test
  @DisplayName("Test getStringWidth(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1CFont.getStringWidth(String)"})
  void testGetStringWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType1CFont(new COSDictionary()).getStringWidth("String"));
  }

  /**
   * Test {@link PDType1CFont#getAverageFontWidth()}.
   *
   * <p>Method under test: {@link PDType1CFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1CFont.getAverageFontWidth()"})
  void testGetAverageFontWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(500.0f, new PDType1CFont(new COSDictionary()).getAverageFontWidth());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDType1CFont#getCFFType1Font()}
   *   <li>{@link PDType1CFont#getFontBoxFont()}
   *   <li>{@link PDType1CFont#isDamaged()}
   *   <li>{@link PDType1CFont#isEmbedded()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CFFType1Font PDType1CFont.getCFFType1Font()",
    "FontBoxFont PDType1CFont.getFontBoxFont()",
    "boolean PDType1CFont.isDamaged()",
    "boolean PDType1CFont.isEmbedded()"
  })
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
