package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LegacyPDFStreamEngineDiffblueTest {
  @InjectMocks private LegacyPDFStreamEngine legacyPDFStreamEngine;

  @Mock private PDFont pDFont;

  @Mock private PDRectangle pDRectangle;

  /**
   * Test new {@link LegacyPDFStreamEngine} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LegacyPDFStreamEngine}
   */
  @Test
  @DisplayName("Test new LegacyPDFStreamEngine (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();
    PDPage page = new PDPage(new COSDictionary());

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(page, legacyPDFStreamEngine.getCurrentPage());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage2() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage3() throws IOException {
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
    Rectangle2D bounds2D =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
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
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage4() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    PDPage page = new PDPage();
    PDRectangle cropBox = new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Rectangle bounds =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getFrame() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given A0; when PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertTrue(
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getFrame()
            instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(contents, ((COSArray) getResult).toList());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Rectangle2D bounds2D =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(792, size.height);
    assertEquals(792.0d, bounds.getMaxY());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDStream#PDStream(COSDocument)} with
   *       document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test processPage(PDPage); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Rectangle2D bounds2D =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getX());
    assertEquals(612.0d, bounds.getWidth());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenCOSArrayAddFalse() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState
            .getCurrentClippingPath()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertEquals(0.0d, bounds2D.getCenterX());
    assertEquals(0.0d, bounds2D.getCenterY());
    assertEquals(0.0d, bounds2D.getHeight());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test processPage(PDPage); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);
    when(pDRectangle.getCOSArray()).thenReturn(cosArray);

    PDPage page = new PDPage();
    page.setCropBox(pDRectangle);

    // Act
    legacyPDFStreamEngine.processPage(page);

    // Assert
    verify(pDRectangle).getCOSArray();
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle2D bounds2D =
        graphicsState
            .getCurrentClippingPath()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds()
            .getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertEquals(0.0d, bounds2D.getCenterX());
    assertEquals(0.0d, bounds2D.getCenterY());
    assertEquals(0.0d, bounds2D.getHeight());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test processPage(PDPage); given PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Rectangle2D bounds2D =
        graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = bounds2D.getBounds();
    assertEquals(0.0d, bounds.getX());
    assertEquals(612.0d, bounds.getWidth());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#processPage(PDPage)}.
   *
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage); when PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPDFStreamEngine.processPage(PDPage)"})
  void testProcessPage_whenPDPage() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    legacyPDFStreamEngine.processPage(new PDPage());

    // Assert
    PDGraphicsState graphicsState = legacyPDFStreamEngine.getGraphicsState();
    Rectangle bounds = graphicsState.getCurrentClippingPath().getBounds().getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor(COSDictionary)} with desc is {@link
   *       COSDictionary#COSDictionary()} Ascent is {@code -32768.0}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName(
      "Test computeFontHeight(PDFont); given PDFontDescriptor(COSDictionary) with desc is COSDictionary() Ascent is '-32768.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_givenPDFontDescriptorWithDescIsCOSDictionaryAscentIs327680()
      throws IOException {
    // Arrange
    when(pDFont.getFontDescriptor()).thenReturn(new PDFontDescriptor(new COSDictionary()));
    when(pDFont.getBoundingBox()).thenReturn(new BoundingBox());

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor(new COSDictionary());
    pdFontDescriptor.setAscent(-32768.0f);
    when(pDFont.getFontDescriptor()).thenReturn(pdFontDescriptor);

    // Act
    float actualComputeFontHeightResult = legacyPDFStreamEngine.computeFontHeight(pDFont);

    // Assert
    verify(pDFont, atLeast(1)).getFontDescriptor();
    verify(pDFont).getBoundingBox();
    assertEquals(0.0f, actualComputeFontHeightResult);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>Then calls {@link PDFont#getFontDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); then calls getFontDescriptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_thenCallsGetFontDescriptor() throws IOException {
    // Arrange
    when(pDFont.getFontDescriptor()).thenReturn(new PDFontDescriptor(new COSDictionary()));
    when(pDFont.getBoundingBox()).thenReturn(new BoundingBox());

    // Act
    float actualComputeFontHeightResult = legacyPDFStreamEngine.computeFontHeight(pDFont);

    // Assert
    verify(pDFont).getFontDescriptor();
    verify(pDFont).getBoundingBox();
    assertEquals(0.0f, actualComputeFontHeightResult);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_thenThrowIOException() throws IOException {
    // Arrange
    when(pDFont.getBoundingBox()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> legacyPDFStreamEngine.computeFontHeight(pDFont));
    verify(pDFont).getBoundingBox();
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName("Test computeFontHeight(PDFont); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_thenThrowRuntimeException() throws IOException {
    // Arrange
    when(pDFont.getFontDescriptor()).thenThrow(new RuntimeException());
    when(pDFont.getBoundingBox()).thenReturn(new BoundingBox());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> legacyPDFStreamEngine.computeFontHeight(pDFont));
    verify(pDFont).getFontDescriptor();
    verify(pDFont).getBoundingBox();
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>When {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName(
      "Test computeFontHeight(PDFont); when PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDMMType1FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    float actualComputeFontHeightResult =
        legacyPDFStreamEngine.computeFontHeight(new PDMMType1Font(new COSDictionary()));

    // Assert
    assertEquals(0.642334f, actualComputeFontHeightResult);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>When {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName(
      "Test computeFontHeight(PDFont); when PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDTrueTypeFontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    float actualComputeFontHeightResult =
        legacyPDFStreamEngine.computeFontHeight(new PDTrueTypeFont(new COSDictionary()));

    // Assert
    assertEquals(0.642334f, actualComputeFontHeightResult);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code SYMBOL}.
   *   <li>Then return {@code 0.6515}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName(
      "Test computeFontHeight(PDFont); when PDType1Font(FontName) with baseFont is 'SYMBOL'; then return '0.6515'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDType1FontWithBaseFontIsSymbol_thenReturn06515()
      throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    float actualComputeFontHeightResult =
        legacyPDFStreamEngine.computeFontHeight(new PDType1Font(FontName.SYMBOL));

    // Assert
    assertEquals(0.6515f, actualComputeFontHeightResult);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>When {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.
   *   <li>Then return {@code 0.558}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName(
      "Test computeFontHeight(PDFont); when PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return '0.558'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDType1FontWithBaseFontIsTimesRoman_thenReturn0558()
      throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    float actualComputeFontHeightResult =
        legacyPDFStreamEngine.computeFontHeight(new PDType1Font(FontName.TIMES_ROMAN));

    // Assert
    assertEquals(0.558f, actualComputeFontHeightResult);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName(
      "Test computeFontHeight(PDFont); when PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    float actualComputeFontHeightResult =
        legacyPDFStreamEngine.computeFontHeight(new PDType3Font(new COSDictionary()));

    // Assert
    assertEquals(0.0f, actualComputeFontHeightResult);
  }

  /**
   * Test {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}.
   *
   * <ul>
   *   <li>When {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPDFStreamEngine#computeFontHeight(PDFont)}
   */
  @Test
  @DisplayName(
      "Test computeFontHeight(PDFont); when PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float LegacyPDFStreamEngine.computeFontHeight(PDFont)"})
  void testComputeFontHeight_whenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange
    LegacyPDFStreamEngine legacyPDFStreamEngine = new LegacyPDFStreamEngine();

    // Act
    float actualComputeFontHeightResult =
        legacyPDFStreamEngine.computeFontHeight(new PDType3Font(new COSStream()));

    // Assert
    assertEquals(0.0f, actualComputeFontHeightResult);
  }
}
