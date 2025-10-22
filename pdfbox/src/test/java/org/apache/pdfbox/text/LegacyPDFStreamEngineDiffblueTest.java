package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LegacyPDFStreamEngineDiffblueTest {
  /**
   * Test new {@link LegacyPDFStreamEngine} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link LegacyPDFStreamEngine}
   */
  @Test
  @DisplayName("Test new LegacyPDFStreamEngine (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.<init>()"})
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

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    legacyPDFStreamEngine.processPage(new PDPage());

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getFrame() instanceof Double);
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage2() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage3() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage4() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDStream contents = new PDStream(new COSDocument());
    ArrayList<COSName> filters = new ArrayList<>();
    contents.setFilters(filters);

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(792, size.height);
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(filters, ((COSArray) getResult).toList());
    assertArrayEquals(new float[]{}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage5() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getFrame() instanceof Double);
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given A0; when PDPage() CropBox is A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenA0_whenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    assertTrue(lineDashPattern.getCOSObject() instanceof COSArray);
    assertArrayEquals(new float[]{}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenArrayList() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    ArrayList<PDStream> contents = new ArrayList<>();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    assertTrue(graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getFrame() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(contents, ((COSArray) getResult).toList());
    assertArrayEquals(new float[]{}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenArrayListAddNull() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream contents = new PDStream(new COSDocument());
    contents.setFilters(filters);

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(792, size.height);
    assertEquals(792.0d, bounds.getMaxY());
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getX());
    assertEquals(612.0d, bounds.getWidth());
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getX());
    assertEquals(612.0d, bounds.getWidth());
    assertArrayEquals(new float[]{}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#showGlyph(Matrix, PDFont, int, Vector)}
   */
  @Test
  @DisplayName("Test showGlyph(Matrix, PDFont, int, Vector); given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegacyPDFStreamEngine.showGlyph(Matrix, PDFont, int, Vector)"})
  void testShowGlyph_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_thenReturnZero() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.0f, legacyPDFStreamEngine.computeFontHeight(new PDType3Font(new COSDictionary())));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.642334f, legacyPDFStreamEngine.computeFontHeight(new PDMMType1Font(new COSDictionary())));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act and Assert
    assertEquals(0.642334f, legacyPDFStreamEngine.computeFontHeight(new PDTrueTypeFont(new COSDictionary())));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code SYMBOL}.</li>
   *   <li>Then return {@code 0.6515}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDType1Font(FontName) with baseFont is 'SYMBOL'; then return '0.6515'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDType1FontWithBaseFontIsSymbol_thenReturn06515() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    // Act and Assert
    assertEquals(0.6515f, legacyPDFStreamEngine.computeFontHeight(new PDType1Font(FontName.SYMBOL)));
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   *   <li>Then return {@code 0.558}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); when PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return '0.558'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDType1FontWithBaseFontIsTimesRoman_thenReturn0558() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    legacyPDFStreamEngine.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    // Act and Assert
    assertEquals(0.558f, legacyPDFStreamEngine.computeFontHeight(new PDType1Font(FontName.TIMES_ROMAN)));
  }
}
