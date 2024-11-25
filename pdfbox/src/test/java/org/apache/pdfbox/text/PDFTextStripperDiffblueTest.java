package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFTextStripperDiffblueTest {
  /**
   * Test new {@link PDFTextStripper} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PDFTextStripper}
   */
  @Test
  @DisplayName("Test new PDFTextStripper (default constructor)")
  void testNewPDFTextStripper() {
    // Arrange and Act
    PDFTextStripper actualPdfTextStripper = new PDFTextStripper();

    // Assert
    assertEquals(" ", actualPdfTextStripper.getWordSeparator());
    assertEquals("", actualPdfTextStripper.getArticleEnd());
    assertEquals("", actualPdfTextStripper.getArticleStart());
    assertEquals("", actualPdfTextStripper.getPageStart());
    assertEquals("", actualPdfTextStripper.getParagraphEnd());
    assertEquals("", actualPdfTextStripper.getParagraphStart());
    List<Pattern> listItemPatterns = actualPdfTextStripper.getListItemPatterns();
    assertEquals(10, listItemPatterns.size());
    assertEquals("[IVXL]+\\.", listItemPatterns.get(8).pattern());
    assertEquals("[a-z]\\)", listItemPatterns.get(7).pattern());
    assertEquals("[ivxl]+\\.", listItemPatterns.get(9).pattern());
    assertEquals("\\.", listItemPatterns.get(0).pattern());
    assertEquals("\\[\\d+\\]", listItemPatterns.get(2).pattern());
    assertEquals("\\d+\\.", listItemPatterns.get(1).pattern());
    assertEquals("\r\n", actualPdfTextStripper.getLineSeparator());
    assertEquals("\r\n", actualPdfTextStripper.getPageEnd());
    assertNull(actualPdfTextStripper.getOutput());
    assertNull(actualPdfTextStripper.actualText);
    assertNull(actualPdfTextStripper.document);
    assertNull(actualPdfTextStripper.getCurrentPage());
    assertNull(actualPdfTextStripper.getResources());
    assertNull(actualPdfTextStripper.getGraphicsState());
    assertNull(actualPdfTextStripper.getEndBookmark());
    assertNull(actualPdfTextStripper.getStartBookmark());
    assertNull(actualPdfTextStripper.getInitialMatrix());
    assertEquals(0, actualPdfTextStripper.getGraphicsStackSize());
    assertEquals(0, actualPdfTextStripper.getLevel());
    assertEquals(0.3f, actualPdfTextStripper.getAverageCharTolerance());
    assertEquals(0.5f, actualPdfTextStripper.getSpacingTolerance());
    assertEquals(1, actualPdfTextStripper.getCurrentPageNo());
    assertEquals(1, actualPdfTextStripper.getStartPage());
    assertEquals(2.0f, actualPdfTextStripper.getIndentThreshold());
    assertEquals(2.5f, actualPdfTextStripper.getDropThreshold());
    assertFalse(actualPdfTextStripper.getAddMoreFormatting());
    assertFalse(actualPdfTextStripper.getSortByPosition());
    assertFalse(actualPdfTextStripper.firstActualTextPosition);
    assertTrue(actualPdfTextStripper.getCharactersByArticle().isEmpty());
    assertTrue(actualPdfTextStripper.getSeparateByBeads());
    assertTrue(actualPdfTextStripper.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPdfTextStripper.getEndPage());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument)")
  void testGetText() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    Rectangle bounds = pdfTextStripper.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Point location = bounds2.getLocation().getLocation();
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, frame.getY());
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792.0d, bounds2.getSize().getSize().getHeight());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument)")
  void testGetText2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<? extends COSBase> toListResult = nextResult.getArtBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.hasContents());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument)")
  void testGetText3() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setCropBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    page.setContents(contents);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripper.getGraphicsState();
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle2D bounds2D = bounds4.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds3.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    Rectangle bounds5 = getResult.getBounds();
    Rectangle2D bounds2D5 = bounds5.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = currentClippingPath.getBounds2D();
    Rectangle bounds6 = bounds2D6.getBounds();
    Rectangle2D bounds2D7 = bounds6.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D3.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds2D4.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(bounds2D6 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    PDRectangle artBox = nextResult.getArtBox();
    assertEquals(-2.14748288E9f, artBox.getHeight());
    PDPage currentPage = pdfTextStripper.getCurrentPage();
    PDRectangle artBox2 = currentPage.getArtBox();
    assertEquals(-2.14748288E9f, artBox2.getHeight());
    PDRectangle bBox = nextResult.getBBox();
    assertEquals(-2.14748288E9f, bBox.getHeight());
    PDRectangle bBox2 = currentPage.getBBox();
    assertEquals(-2.14748288E9f, bBox2.getHeight());
    PDRectangle bleedBox = nextResult.getBleedBox();
    assertEquals(-2.14748288E9f, bleedBox.getHeight());
    PDRectangle bleedBox2 = currentPage.getBleedBox();
    assertEquals(-2.14748288E9f, bleedBox2.getHeight());
    PDRectangle cropBox = nextResult.getCropBox();
    assertEquals(-2.14748288E9f, cropBox.getHeight());
    PDRectangle cropBox2 = currentPage.getCropBox();
    assertEquals(-2.14748288E9f, cropBox2.getHeight());
    assertEquals(-2.14748301E9f, artBox.getWidth());
    assertEquals(-2.14748301E9f, artBox2.getWidth());
    assertEquals(-2.14748301E9f, bBox.getWidth());
    assertEquals(-2.14748301E9f, bBox2.getWidth());
    assertEquals(-2.14748301E9f, bleedBox.getWidth());
    assertEquals(-2.14748301E9f, bleedBox2.getWidth());
    assertEquals(-2.14748301E9f, cropBox.getWidth());
    assertEquals(-2.14748301E9f, cropBox2.getWidth());
    assertEquals(1.07374213E9d, bounds4.getCenterX());
    assertEquals(1.07374213E9d, bounds3.getCenterX());
    assertEquals(1.07374213E9d, bounds2.getCenterX());
    assertEquals(1.07374213E9d, bounds2D3.getCenterX());
    assertEquals(1.07374213E9d, bounds2D4.getCenterX());
    assertEquals(1.07374213E9d, bounds.getCenterX());
    assertEquals(1.07374213E9d, bounds2D6.getCenterX());
    assertEquals(1.07374213E9d, bounds5.getCenterX());
    assertEquals(1.07374213E9d, bounds6.getCenterX());
    assertEquals(1.07374213E9d, frame.getCenterX());
    assertEquals(1.07374222E9d, bounds4.getCenterY());
    assertEquals(1.07374222E9d, bounds3.getCenterY());
    assertEquals(1.07374222E9d, bounds2.getCenterY());
    assertEquals(1.07374222E9d, bounds2D3.getCenterY());
    assertEquals(1.07374222E9d, bounds2D4.getCenterY());
    assertEquals(1.07374222E9d, bounds.getCenterY());
    assertEquals(1.07374222E9d, bounds2D6.getCenterY());
    assertEquals(1.07374222E9d, bounds5.getCenterY());
    assertEquals(1.07374222E9d, bounds6.getCenterY());
    assertEquals(1.07374222E9d, frame.getCenterY());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    assertEquals(2.147482856E9d, size2.getHeight());
    Dimension size3 = bounds3.getSize();
    assertEquals(2.147482856E9d, size3.getHeight());
    Dimension size4 = bounds2.getSize();
    assertEquals(2.147482856E9d, size4.getHeight());
    assertEquals(2.147482856E9d, size.getHeight());
    assertEquals(2.147482856E9d, bounds4.getHeight());
    assertEquals(2.147482856E9d, bounds3.getHeight());
    assertEquals(2.147482856E9d, bounds2.getHeight());
    assertEquals(2.147482856E9d, bounds.getHeight());
    assertEquals(2.147482856E9d, bounds5.getHeight());
    assertEquals(2.147482856E9d, bounds6.getHeight());
    assertEquals(2.147482856E9d, bounds2D4.getHeight());
    assertEquals(2.147482856E9d, bounds2D6.getHeight());
    assertEquals(2.147482856E9d, frame.getHeight());
    assertEquals(2.147483036E9d, size2.getWidth());
    assertEquals(2.147483036E9d, size3.getWidth());
    assertEquals(2.147483036E9d, size4.getWidth());
    assertEquals(2.147483036E9d, size.getWidth());
    assertEquals(2.147483036E9d, bounds4.getWidth());
    assertEquals(2.147483036E9d, bounds3.getWidth());
    assertEquals(2.147483036E9d, bounds2.getWidth());
    assertEquals(2.147483036E9d, bounds.getWidth());
    assertEquals(2.147483036E9d, bounds5.getWidth());
    assertEquals(2.147483036E9d, bounds6.getWidth());
    assertEquals(2.147483036E9d, bounds2D4.getWidth());
    assertEquals(2.147483036E9d, bounds2D6.getWidth());
    assertEquals(2.147483036E9d, frame.getWidth());
    assertEquals(2.147483648E9d, bounds4.getMaxX());
    assertEquals(2.147483648E9d, bounds3.getMaxX());
    assertEquals(2.147483648E9d, bounds2.getMaxX());
    assertEquals(2.147483648E9d, bounds2D4.getMaxX());
    assertEquals(2.147483648E9d, bounds.getMaxX());
    assertEquals(2.147483648E9d, bounds2D6.getMaxX());
    assertEquals(2.147483648E9d, bounds5.getMaxX());
    assertEquals(2.147483648E9d, bounds6.getMaxX());
    assertEquals(2.147483648E9d, frame.getMaxX());
    assertEquals(2.147483648E9d, bounds4.getMaxY());
    assertEquals(2.147483648E9d, bounds3.getMaxY());
    assertEquals(2.147483648E9d, bounds2.getMaxY());
    assertEquals(2.147483648E9d, bounds2D4.getMaxY());
    assertEquals(2.147483648E9d, bounds.getMaxY());
    assertEquals(2.147483648E9d, bounds2D6.getMaxY());
    assertEquals(2.147483648E9d, bounds5.getMaxY());
    assertEquals(2.147483648E9d, bounds6.getMaxY());
    assertEquals(2.147483648E9d, frame.getMaxY());
    assertEquals(2.14748365E9f, artBox.getLowerLeftX());
    assertEquals(2.14748365E9f, artBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bleedBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bleedBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, cropBox.getLowerLeftX());
    assertEquals(2.14748365E9f, cropBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, artBox.getLowerLeftY());
    assertEquals(2.14748365E9f, artBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bleedBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bleedBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, cropBox.getLowerLeftY());
    assertEquals(2.14748365E9f, cropBox2.getLowerLeftY());
    Dimension size5 = size2.getSize();
    assertEquals(2147482856, size5.height);
    Dimension size6 = size3.getSize();
    assertEquals(2147482856, size6.height);
    Dimension size7 = size4.getSize();
    assertEquals(2147482856, size7.height);
    assertEquals(2147482856, size2.height);
    Dimension size8 = bounds4.getSize();
    assertEquals(2147482856, size8.height);
    assertEquals(2147482856, size3.height);
    assertEquals(2147482856, size4.height);
    assertEquals(2147482856, size.height);
    Dimension size9 = bounds5.getSize();
    assertEquals(2147482856, size9.height);
    Dimension size10 = bounds6.getSize();
    assertEquals(2147482856, size10.height);
    Dimension size11 = ((Rectangle) bounds2D4).getSize();
    assertEquals(2147482856, size11.height);
    Rectangle bounds7 = bounds4.getBounds();
    assertEquals(2147482856, bounds7.height);
    assertEquals(2147482856, bounds4.height);
    assertEquals(2147482856, bounds3.height);
    assertEquals(2147482856, bounds2.height);
    Rectangle bounds8 = bounds5.getBounds();
    assertEquals(2147482856, bounds8.height);
    Rectangle bounds9 = bounds6.getBounds();
    assertEquals(2147482856, bounds9.height);
    assertEquals(2147482856, bounds.height);
    assertEquals(2147482856, bounds5.height);
    Rectangle bounds10 = bounds2D3.getBounds();
    assertEquals(2147482856, bounds10.height);
    Rectangle bounds11 = bounds2D4.getBounds();
    assertEquals(2147482856, bounds11.height);
    assertEquals(2147482856, bounds6.height);
    Rectangle bounds12 = frame.getBounds();
    assertEquals(2147482856, bounds12.height);
    assertEquals(2147482856, ((Rectangle) bounds2D).height);
    assertEquals(2147482856, ((Rectangle) bounds2D2).height);
    assertEquals(2147482856, ((Rectangle) bounds2D3).height);
    assertEquals(2147482856, ((Rectangle) bounds2D4).height);
    assertEquals(2147482856, ((Rectangle) bounds2D5).height);
    assertEquals(2147482856, ((Rectangle) bounds2D7).height);
    assertEquals(2147482856, ((Rectangle) bounds2D8).height);
    assertEquals(2147482856, ((Rectangle) bounds2D9).height);
    assertEquals(2147483036, size5.width);
    assertEquals(2147483036, size6.width);
    assertEquals(2147483036, size7.width);
    assertEquals(2147483036, size2.width);
    assertEquals(2147483036, size8.width);
    assertEquals(2147483036, size3.width);
    assertEquals(2147483036, size4.width);
    assertEquals(2147483036, size.width);
    assertEquals(2147483036, size9.width);
    assertEquals(2147483036, size10.width);
    assertEquals(2147483036, size11.width);
    assertEquals(2147483036, bounds7.width);
    assertEquals(2147483036, bounds4.width);
    assertEquals(2147483036, bounds3.width);
    assertEquals(2147483036, bounds2.width);
    assertEquals(2147483036, bounds8.width);
    assertEquals(2147483036, bounds9.width);
    assertEquals(2147483036, bounds.width);
    assertEquals(2147483036, bounds5.width);
    assertEquals(2147483036, bounds10.width);
    assertEquals(2147483036, bounds11.width);
    assertEquals(2147483036, bounds6.width);
    assertEquals(2147483036, bounds12.width);
    assertEquals(2147483036, ((Rectangle) bounds2D).width);
    assertEquals(2147483036, ((Rectangle) bounds2D2).width);
    assertEquals(2147483036, ((Rectangle) bounds2D3).width);
    assertEquals(2147483036, ((Rectangle) bounds2D4).width);
    assertEquals(2147483036, ((Rectangle) bounds2D5).width);
    assertEquals(2147483036, ((Rectangle) bounds2D7).width);
    assertEquals(2147483036, ((Rectangle) bounds2D8).width);
    assertEquals(2147483036, ((Rectangle) bounds2D9).width);
    Point location = bounds.getLocation();
    Point location2 = location.getLocation();
    Point location3 = location2.getLocation();
    assertEquals(612, location3.x);
    Point location4 = bounds3.getLocation();
    Point location5 = location4.getLocation();
    assertEquals(612, location5.x);
    Point location6 = bounds2.getLocation();
    Point location7 = location6.getLocation();
    assertEquals(612, location7.x);
    assertEquals(612, location2.x);
    Point location8 = bounds4.getLocation();
    assertEquals(612, location8.x);
    assertEquals(612, location4.x);
    assertEquals(612, location6.x);
    assertEquals(612, location.x);
    Point location9 = bounds5.getLocation();
    assertEquals(612, location9.x);
    Point location10 = bounds6.getLocation();
    assertEquals(612, location10.x);
    Point location11 = ((Rectangle) bounds2D4).getLocation();
    assertEquals(612, location11.x);
    assertEquals(612, bounds7.x);
    assertEquals(612, bounds4.x);
    assertEquals(612, bounds3.x);
    assertEquals(612, bounds2.x);
    assertEquals(612, bounds8.x);
    assertEquals(612, bounds9.x);
    assertEquals(612, bounds.x);
    assertEquals(612, bounds5.x);
    assertEquals(612, bounds10.x);
    assertEquals(612, bounds11.x);
    assertEquals(612, bounds6.x);
    assertEquals(612, bounds12.x);
    assertEquals(612, ((Rectangle) bounds2D).x);
    assertEquals(612, ((Rectangle) bounds2D2).x);
    assertEquals(612, ((Rectangle) bounds2D3).x);
    assertEquals(612, ((Rectangle) bounds2D4).x);
    assertEquals(612, ((Rectangle) bounds2D5).x);
    assertEquals(612, ((Rectangle) bounds2D7).x);
    assertEquals(612, ((Rectangle) bounds2D8).x);
    assertEquals(612, ((Rectangle) bounds2D9).x);
    assertEquals(612.0d, location2.getX());
    assertEquals(612.0d, location4.getX());
    assertEquals(612.0d, location6.getX());
    assertEquals(612.0d, location.getX());
    assertEquals(612.0d, bounds4.getX());
    assertEquals(612.0d, bounds3.getX());
    assertEquals(612.0d, bounds2.getX());
    assertEquals(612.0d, bounds.getX());
    assertEquals(612.0d, bounds5.getX());
    assertEquals(612.0d, bounds6.getX());
    assertEquals(612.0d, bounds4.getMinX());
    assertEquals(612.0d, bounds3.getMinX());
    assertEquals(612.0d, bounds2.getMinX());
    assertEquals(612.0d, bounds2D4.getMinX());
    assertEquals(612.0d, bounds.getMinX());
    assertEquals(612.0d, bounds2D6.getMinX());
    assertEquals(612.0d, bounds5.getMinX());
    assertEquals(612.0d, bounds6.getMinX());
    assertEquals(612.0d, frame.getMinX());
    assertEquals(612.0d, bounds2D4.getX());
    assertEquals(612.0d, bounds2D6.getX());
    assertEquals(612.0d, frame.getX());
    assertEquals(792, location3.y);
    assertEquals(792, location5.y);
    assertEquals(792, location7.y);
    assertEquals(792, location2.y);
    assertEquals(792, location8.y);
    assertEquals(792, location4.y);
    assertEquals(792, location6.y);
    assertEquals(792, location.y);
    assertEquals(792, location9.y);
    assertEquals(792, location10.y);
    assertEquals(792, location11.y);
    assertEquals(792, bounds7.y);
    assertEquals(792, bounds4.y);
    assertEquals(792, bounds3.y);
    assertEquals(792, bounds2.y);
    assertEquals(792, bounds8.y);
    assertEquals(792, bounds9.y);
    assertEquals(792, bounds.y);
    assertEquals(792, bounds5.y);
    assertEquals(792, bounds10.y);
    assertEquals(792, bounds11.y);
    assertEquals(792, bounds6.y);
    assertEquals(792, bounds12.y);
    assertEquals(792, ((Rectangle) bounds2D).y);
    assertEquals(792, ((Rectangle) bounds2D2).y);
    assertEquals(792, ((Rectangle) bounds2D3).y);
    assertEquals(792, ((Rectangle) bounds2D4).y);
    assertEquals(792, ((Rectangle) bounds2D5).y);
    assertEquals(792, ((Rectangle) bounds2D7).y);
    assertEquals(792, ((Rectangle) bounds2D8).y);
    assertEquals(792, ((Rectangle) bounds2D9).y);
    assertEquals(792.0d, location2.getY());
    assertEquals(792.0d, location4.getY());
    assertEquals(792.0d, location6.getY());
    assertEquals(792.0d, location.getY());
    assertEquals(792.0d, bounds4.getY());
    assertEquals(792.0d, bounds3.getY());
    assertEquals(792.0d, bounds2.getY());
    assertEquals(792.0d, bounds.getY());
    assertEquals(792.0d, bounds5.getY());
    assertEquals(792.0d, bounds6.getY());
    assertEquals(792.0d, bounds4.getMinY());
    assertEquals(792.0d, bounds3.getMinY());
    assertEquals(792.0d, bounds2.getMinY());
    assertEquals(792.0d, bounds2D4.getMinY());
    assertEquals(792.0d, bounds.getMinY());
    assertEquals(792.0d, bounds2D6.getMinY());
    assertEquals(792.0d, bounds5.getMinY());
    assertEquals(792.0d, bounds6.getMinY());
    assertEquals(792.0d, frame.getMinY());
    assertEquals(792.0d, bounds2D4.getY());
    assertEquals(792.0d, bounds2D6.getY());
    assertEquals(792.0d, frame.getY());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetText_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    String actualText = pdfTextStripper.getText(doc);

    // Assert
    assertEquals("", pdfTextStripper.getOutput().toString());
    assertEquals("", actualText);
    assertFalse(pdfTextStripper.document.getPages().iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem()")
  void testGetText_givenPDFTextStripperEndBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) SortByPosition is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDFTextStripper (default constructor) SortByPosition is 'true'")
  void testGetText_givenPDFTextStripperSortByPositionIsTrue() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setSortByPosition(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    Rectangle bounds = pdfTextStripper.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Point location = bounds2.getLocation().getLocation();
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, frame.getY());
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792.0d, bounds2.getSize().getSize().getHeight());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem()")
  void testGetText_givenPDFTextStripperStartBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); given PDPage()")
  void testGetText_givenPDPage() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<? extends COSBase> toListResult = nextResult.getArtBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.hasContents());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) ArticleEnd is cr
   * lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); then PDFTextStripper (default constructor) ArticleEnd is cr lf")
  void testGetText_thenPDFTextStripperArticleEndIsCrLf() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setAddMoreFormatting(true);

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    assertEquals("\r\n", pdfTextStripper.getArticleEnd());
    assertEquals("\r\n", pdfTextStripper.getArticleStart());
    assertEquals("\r\n", pdfTextStripper.getPageStart());
    assertEquals("\r\n", pdfTextStripper.getParagraphEnd());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPage Contents
   * read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); then PDFTextStripper (default constructor) CurrentPage Contents read is minus one")
  void testGetText_thenPDFTextStripperCurrentPageContentsReadIsMinusOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    PDPage currentPage = pdfTextStripper.getCurrentPage();
    RandomAccessRead contentsForRandomAccess2 = currentPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing2 = currentPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    assertEquals(-1, currentPage.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertEquals(0, contentsForStreamParsing2.available());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#document} Pages iterator next BBox LowerLeftX is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); then PDFTextStripper (default constructor) document Pages iterator next BBox LowerLeftX is zero")
  void testGetText_thenPDFTextStripperDocumentPagesIteratorNextBBoxLowerLeftXIsZero() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);
    page.setContents(contents);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    PDRectangle bBox = nextResult.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDPage currentPage = pdfTextStripper.getCurrentPage();
    PDRectangle bBox2 = currentPage.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bleedBox = nextResult.getBleedBox();
    assertEquals(0.0f, bleedBox.getLowerLeftX());
    PDRectangle bleedBox2 = currentPage.getBleedBox();
    assertEquals(0.0f, bleedBox2.getLowerLeftX());
    PDRectangle cropBox = nextResult.getCropBox();
    assertEquals(0.0f, cropBox.getLowerLeftX());
    PDRectangle cropBox2 = currentPage.getCropBox();
    assertEquals(0.0f, cropBox2.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bleedBox.getLowerLeftY());
    assertEquals(0.0f, bleedBox2.getLowerLeftY());
    assertEquals(0.0f, cropBox.getLowerLeftY());
    assertEquals(0.0f, cropBox2.getLowerLeftY());
    assertEquals(612.0f, bBox.getWidth());
    assertEquals(612.0f, bBox2.getWidth());
    assertEquals(612.0f, bleedBox.getWidth());
    assertEquals(612.0f, bleedBox2.getWidth());
    assertEquals(612.0f, cropBox.getWidth());
    assertEquals(612.0f, cropBox2.getWidth());
    assertEquals(792.0f, bBox.getHeight());
    assertEquals(792.0f, bBox2.getHeight());
    assertEquals(792.0f, bleedBox.getHeight());
    assertEquals(792.0f, bleedBox2.getHeight());
    assertEquals(792.0f, cropBox.getHeight());
    assertEquals(792.0f, cropBox2.getHeight());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#document} Pages iterator next Contents read is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); then PDFTextStripper (default constructor) document Pages iterator next Contents read is one")
  void testGetText_thenPDFTextStripperDocumentPagesIteratorNextContentsReadIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.save(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(page);

    // Act
    pdfTextStripper.getText(doc);

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    PDPage currentPage = pdfTextStripper.getCurrentPage();
    RandomAccessRead contentsForRandomAccess2 = currentPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing2 = currentPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    byte[] byteArray = new byte[1];
    assertEquals(1, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[1];
    assertEquals(1, currentPage.getContents().read(byteArray2));
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForRandomAccess2.available());
    assertEquals(1, contentsForStreamParsing.available());
    assertEquals(1, contentsForStreamParsing2.available());
    assertEquals(1.6f, pdDocument.getVersion());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{'\n'}, byteArray);
    assertArrayEquals(new byte[]{'\n'}, byteArray2);
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) Output toString is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); then PDFTextStripper (default constructor) Output toString is empty string")
  void testGetText_thenPDFTextStripperOutputToStringIsEmptyString() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage(new COSDictionary()));

    // Act
    String actualText = pdfTextStripper.getText(doc);

    // Assert
    assertEquals("", pdfTextStripper.getOutput().toString());
    assertEquals("", actualText);
    assertFalse(pdfTextStripper.document.getPages().iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#getText(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#document} NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getText(PDDocument)}
   */
  @Test
  @DisplayName("Test getText(PDDocument); when PDDocument(); then PDFTextStripper (default constructor) document NumberOfPages is zero")
  void testGetText_whenPDDocument_thenPDFTextStripperDocumentNumberOfPagesIsZero() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.getText(new PDDocument());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer)")
  void testWriteText() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    Rectangle bounds = pdfTextStripper.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Point location = bounds2.getLocation().getLocation();
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, frame.getY());
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792.0d, bounds2.getSize().getSize().getHeight());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer)")
  void testWriteText2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<? extends COSBase> toListResult = nextResult.getArtBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.hasContents());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testWriteText_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(1, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(1, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem()")
  void testWriteText_givenPDFTextStripperEndBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setEndBookmark(new PDOutlineItem());
    PDDocument doc = new PDDocument();

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) SortByPosition is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) SortByPosition is 'true'")
  void testWriteText_givenPDFTextStripperSortByPositionIsTrue() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setSortByPosition(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    Rectangle bounds = pdfTextStripper.getGraphicsState().getCurrentClippingPath().getBounds();
    Rectangle bounds2 = bounds.getBounds().getBounds();
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Point location = bounds2.getLocation().getLocation();
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, frame.getMinX());
    assertEquals(0.0d, frame.getMinY());
    assertEquals(0.0d, frame.getX());
    assertEquals(0.0d, frame.getY());
    assertEquals(396.0d, frame.getCenterY());
    assertEquals(612.0d, frame.getMaxX());
    assertEquals(612.0d, frame.getWidth());
    assertEquals(792.0d, bounds2.getSize().getSize().getHeight());
    assertEquals(792.0d, frame.getHeight());
    assertEquals(792.0d, frame.getMaxY());
    assertFalse(frame.isEmpty());
    assertEquals(bounds, frame2);
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem()")
  void testWriteText_givenPDFTextStripperStartBookmarkIsPDOutlineItem() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());
    PDDocument doc = new PDDocument();

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); given PDPage()")
  void testWriteText_givenPDPage() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    List<? extends COSBase> toListResult = nextResult.getArtBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertFalse(nextResult.getContentStreams().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.hasContents());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) ArticleEnd is cr
   * lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) ArticleEnd is cr lf")
  void testWriteText_thenPDFTextStripperArticleEndIsCrLf() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setAddMoreFormatting(true);
    PDDocument doc = new PDDocument();

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    assertEquals("\r\n", pdfTextStripper.getArticleEnd());
    assertEquals("\r\n", pdfTextStripper.getArticleStart());
    assertEquals("\r\n", pdfTextStripper.getPageStart());
    assertEquals("\r\n", pdfTextStripper.getParagraphEnd());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#document} NumberOfPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) document NumberOfPages is one")
  void testWriteText_thenPDFTextStripperDocumentNumberOfPagesIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage(new COSDictionary()));

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(1, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(1, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#document} Pages iterator next Contents read is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) document Pages iterator next Contents read is minus one")
  void testWriteText_thenPDFTextStripperDocumentPagesIteratorNextContentsReadIsMinusOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDDocument doc = new PDDocument();
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    Iterator<PDPage> iteratorResult = pdfTextStripper.document.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    PDPage currentPage = pdfTextStripper.getCurrentPage();
    RandomAccessRead contentsForRandomAccess2 = currentPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing2 = currentPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    assertEquals(-1, nextResult.getContents().read(new byte[]{}));
    assertEquals(-1, currentPage.getContents().read(new byte[]{}));
    assertEquals(0, contentsForRandomAccess.available());
    assertEquals(0, contentsForRandomAccess2.available());
    assertEquals(0, contentsForStreamParsing.available());
    assertEquals(0, contentsForStreamParsing2.available());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#document} Pages iterator next Contents read is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); then PDFTextStripper (default constructor) document Pages iterator next Contents read is one")
  void testWriteText_thenPDFTextStripperDocumentPagesIteratorNextContentsReadIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument doc = new PDDocument();
    doc.save(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION);
    doc.addPage(page);

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    Iterator<PDPage> iteratorResult = pdDocument.getPages().iterator();
    PDPage nextResult = iteratorResult.next();
    RandomAccessRead contentsForRandomAccess = nextResult.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    PDPage currentPage = pdfTextStripper.getCurrentPage();
    RandomAccessRead contentsForRandomAccess2 = currentPage.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing = nextResult.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForStreamParsing2 = currentPage.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    byte[] byteArray = new byte[1];
    assertEquals(1, nextResult.getContents().read(byteArray));
    byte[] byteArray2 = new byte[1];
    assertEquals(1, currentPage.getContents().read(byteArray2));
    assertEquals(1, contentsForRandomAccess.available());
    assertEquals(1, contentsForRandomAccess2.available());
    assertEquals(1, contentsForStreamParsing.available());
    assertEquals(1, contentsForStreamParsing2.available());
    assertEquals(1.6f, pdDocument.getVersion());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{'\n'}, byteArray);
    assertArrayEquals(new byte[]{'\n'}, byteArray2);
  }

  /**
   * Test {@link PDFTextStripper#writeText(PDDocument, Writer)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#document} NumberOfPages is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#writeText(PDDocument, Writer)}
   */
  @Test
  @DisplayName("Test writeText(PDDocument, Writer); when PDDocument(); then PDFTextStripper (default constructor) document NumberOfPages is zero")
  void testWriteText_whenPDDocument_thenPDFTextStripperDocumentNumberOfPagesIsZero() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    PDDocument doc = new PDDocument();

    // Act
    pdfTextStripper.writeText(doc, new StringWriter());

    // Assert
    PDDocument pdDocument = pdfTextStripper.document;
    assertEquals(0, pdDocument.getNumberOfPages());
    PDPageTree pages = pdDocument.getPages();
    assertEquals(0, pages.getCount());
    assertFalse(pages.iterator().hasNext());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree)")
  void testProcessPages() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDPageTree pages = new PDPageTree();
    pages.add(page);

    // Act
    pdfTextStripperByArea.processPages(pages);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    Point2D currentPoint = getResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertTrue(toListResult.get(1) instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(pdfTextStripperByArea.getTextLineMatrix());
    assertNull(pdfTextStripperByArea.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    assertEquals(1, getResult.getWindingRule());
    List<List<TextPosition>> charactersByArticle = pdfTextStripperByArea.getCharactersByArticle();
    assertEquals(1, charactersByArticle.size());
    assertEquals(1, pdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(charactersByArticle.get(0).isEmpty());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(page, pdfTextStripperByArea.getCurrentPage());
    assertEquals(location, location.getLocation());
    assertEquals(location, currentPoint);
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) EndBookmark is
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDFTextStripper (default constructor) EndBookmark is PDOutlineItem(); when PDPageTree()")
  void testProcessPages_givenPDFTextStripperEndBookmarkIsPDOutlineItem_whenPDPageTree() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem(); when PDPageTree()")
  void testProcessPages_givenPDFTextStripperStartBookmarkIsPDOutlineItem_whenPDPageTree() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor) StartBookmark is
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDFTextStripper (default constructor) StartBookmark is PDOutlineItem(); when PDPageTree()")
  void testProcessPages_givenPDFTextStripperStartBookmarkIsPDOutlineItem_whenPDPageTree2() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setStartBookmark(new PDOutlineItem());
    pdfTextStripper.setEndBookmark(new PDOutlineItem());

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); given PDPage(); then PDFTextStripper (default constructor) CurrentPageNo is two")
  void testProcessPages_givenPDPage_thenPDFTextStripperCurrentPageNoIsTwo() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPageTree pages = new PDPageTree();
    pages.add(new PDPage());

    // Act
    pdfTextStripper.processPages(pages);

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(2, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); then PDFTextStripper (default constructor) CurrentPageNo is two")
  void testProcessPages_thenPDFTextStripperCurrentPageNoIsTwo() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDPageTree pages = new PDPageTree();
    pages.add(page);

    // Act
    pdfTextStripper.processPages(pages);

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(2, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>When {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); when PDPageTree(COSDictionary) with root is COSDictionary()")
  void testProcessPages_whenPDPageTreeWithRootIsCOSDictionary() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.processPages(new PDPageTree(new COSDictionary()));

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#processPages(PDPageTree)}.
   * <ul>
   *   <li>When {@link PDPageTree#PDPageTree()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) CurrentPageNo is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#processPages(PDPageTree)}
   */
  @Test
  @DisplayName("Test processPages(PDPageTree); when PDPageTree(); then PDFTextStripper (default constructor) CurrentPageNo is one")
  void testProcessPages_whenPDPageTree_thenPDFTextStripperCurrentPageNoIsOne() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.processPages(new PDPageTree());

    // Assert
    assertNull(pdfTextStripper.getCurrentPage());
    assertNull(pdfTextStripper.getInitialMatrix());
    assertEquals(0, pdfTextStripper.getGraphicsStackSize());
    assertEquals(1, pdfTextStripper.getCurrentPageNo());
    assertTrue(pdfTextStripper.getCharactersByArticle().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDFTextStripper#setAddMoreFormatting(boolean)}
   *   <li>{@link PDFTextStripper#setArticleEnd(String)}
   *   <li>{@link PDFTextStripper#setArticleStart(String)}
   *   <li>{@link PDFTextStripper#setAverageCharTolerance(float)}
   *   <li>{@link PDFTextStripper#setDropThreshold(float)}
   *   <li>{@link PDFTextStripper#setEndBookmark(PDOutlineItem)}
   *   <li>{@link PDFTextStripper#setIndentThreshold(float)}
   *   <li>{@link PDFTextStripper#setLineSeparator(String)}
   *   <li>{@link PDFTextStripper#setListItemPatterns(List)}
   *   <li>{@link PDFTextStripper#setPageEnd(String)}
   *   <li>{@link PDFTextStripper#setPageStart(String)}
   *   <li>{@link PDFTextStripper#setParagraphEnd(String)}
   *   <li>{@link PDFTextStripper#setParagraphStart(String)}
   *   <li>{@link PDFTextStripper#setShouldSeparateByBeads(boolean)}
   *   <li>{@link PDFTextStripper#setSortByPosition(boolean)}
   *   <li>{@link PDFTextStripper#setSpacingTolerance(float)}
   *   <li>{@link PDFTextStripper#setStartBookmark(PDOutlineItem)}
   *   <li>{@link PDFTextStripper#setSuppressDuplicateOverlappingText(boolean)}
   *   <li>{@link PDFTextStripper#setWordSeparator(String)}
   *   <li>{@link PDFTextStripper#endDocument(PDDocument)}
   *   <li>{@link PDFTextStripper#endPage(PDPage)}
   *   <li>{@link PDFTextStripper#startDocument(PDDocument)}
   *   <li>{@link PDFTextStripper#startPage(PDPage)}
   *   <li>{@link PDFTextStripper#getAddMoreFormatting()}
   *   <li>{@link PDFTextStripper#getArticleEnd()}
   *   <li>{@link PDFTextStripper#getArticleStart()}
   *   <li>{@link PDFTextStripper#getAverageCharTolerance()}
   *   <li>{@link PDFTextStripper#getCharactersByArticle()}
   *   <li>{@link PDFTextStripper#getCurrentPageNo()}
   *   <li>{@link PDFTextStripper#getDropThreshold()}
   *   <li>{@link PDFTextStripper#getEndBookmark()}
   *   <li>{@link PDFTextStripper#getEndPage()}
   *   <li>{@link PDFTextStripper#getIndentThreshold()}
   *   <li>{@link PDFTextStripper#getLineSeparator()}
   *   <li>{@link PDFTextStripper#getOutput()}
   *   <li>{@link PDFTextStripper#getPageEnd()}
   *   <li>{@link PDFTextStripper#getPageStart()}
   *   <li>{@link PDFTextStripper#getParagraphEnd()}
   *   <li>{@link PDFTextStripper#getParagraphStart()}
   *   <li>{@link PDFTextStripper#getSeparateByBeads()}
   *   <li>{@link PDFTextStripper#getSortByPosition()}
   *   <li>{@link PDFTextStripper#getSpacingTolerance()}
   *   <li>{@link PDFTextStripper#getStartBookmark()}
   *   <li>{@link PDFTextStripper#getStartPage()}
   *   <li>{@link PDFTextStripper#getSuppressDuplicateOverlappingText()}
   *   <li>{@link PDFTextStripper#getWordSeparator()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.setAddMoreFormatting(true);
    pdfTextStripper.setArticleEnd("42");
    pdfTextStripper.setArticleStart("42");
    pdfTextStripper.setAverageCharTolerance(10.0f);
    pdfTextStripper.setDropThreshold(10.0f);
    PDOutlineItem aEndBookmark = new PDOutlineItem();
    pdfTextStripper.setEndBookmark(aEndBookmark);
    pdfTextStripper.setIndentThreshold(10.0f);
    pdfTextStripper.setLineSeparator("Separator");
    pdfTextStripper.setListItemPatterns(new ArrayList<>());
    pdfTextStripper.setPageEnd("42");
    pdfTextStripper.setPageStart("42");
    pdfTextStripper.setParagraphEnd("foo");
    pdfTextStripper.setParagraphStart("foo");
    pdfTextStripper.setShouldSeparateByBeads(true);
    pdfTextStripper.setSortByPosition(true);
    pdfTextStripper.setSpacingTolerance(10.0f);
    PDOutlineItem aStartBookmark = new PDOutlineItem();
    pdfTextStripper.setStartBookmark(aStartBookmark);
    pdfTextStripper.setSuppressDuplicateOverlappingText(true);
    pdfTextStripper.setWordSeparator("Separator");
    pdfTextStripper.endDocument(new PDDocument());
    pdfTextStripper.endPage(new PDPage());
    pdfTextStripper.startDocument(new PDDocument());
    pdfTextStripper.startPage(new PDPage());
    boolean actualAddMoreFormatting = pdfTextStripper.getAddMoreFormatting();
    String actualArticleEnd = pdfTextStripper.getArticleEnd();
    String actualArticleStart = pdfTextStripper.getArticleStart();
    float actualAverageCharTolerance = pdfTextStripper.getAverageCharTolerance();
    List<List<TextPosition>> actualCharactersByArticle = pdfTextStripper.getCharactersByArticle();
    int actualCurrentPageNo = pdfTextStripper.getCurrentPageNo();
    float actualDropThreshold = pdfTextStripper.getDropThreshold();
    PDOutlineItem actualEndBookmark = pdfTextStripper.getEndBookmark();
    int actualEndPage = pdfTextStripper.getEndPage();
    float actualIndentThreshold = pdfTextStripper.getIndentThreshold();
    String actualLineSeparator = pdfTextStripper.getLineSeparator();
    pdfTextStripper.getOutput();
    String actualPageEnd = pdfTextStripper.getPageEnd();
    String actualPageStart = pdfTextStripper.getPageStart();
    String actualParagraphEnd = pdfTextStripper.getParagraphEnd();
    String actualParagraphStart = pdfTextStripper.getParagraphStart();
    boolean actualSeparateByBeads = pdfTextStripper.getSeparateByBeads();
    boolean actualSortByPosition = pdfTextStripper.getSortByPosition();
    float actualSpacingTolerance = pdfTextStripper.getSpacingTolerance();
    PDOutlineItem actualStartBookmark = pdfTextStripper.getStartBookmark();
    int actualStartPage = pdfTextStripper.getStartPage();
    boolean actualSuppressDuplicateOverlappingText = pdfTextStripper.getSuppressDuplicateOverlappingText();

    // Assert that nothing has changed
    assertEquals("42", actualArticleEnd);
    assertEquals("42", actualArticleStart);
    assertEquals("42", actualPageEnd);
    assertEquals("42", actualPageStart);
    assertEquals("Separator", actualLineSeparator);
    assertEquals("Separator", pdfTextStripper.getWordSeparator());
    assertEquals("foo", actualParagraphEnd);
    assertEquals("foo", actualParagraphStart);
    assertEquals(1, actualCurrentPageNo);
    assertEquals(1, actualStartPage);
    assertEquals(10.0f, actualAverageCharTolerance);
    assertEquals(10.0f, actualDropThreshold);
    assertEquals(10.0f, actualIndentThreshold);
    assertEquals(10.0f, actualSpacingTolerance);
    assertTrue(actualCharactersByArticle.isEmpty());
    assertTrue(actualAddMoreFormatting);
    assertTrue(actualSeparateByBeads);
    assertTrue(actualSortByPosition);
    assertTrue(actualSuppressDuplicateOverlappingText);
    assertEquals(Integer.MAX_VALUE, actualEndPage);
    assertSame(aEndBookmark, actualEndBookmark);
    assertSame(aStartBookmark, actualStartBookmark);
  }

  /**
   * Test {@link PDFTextStripper#processPage(PDPage)}.
   * <p>
   * Method under test: {@link PDFTextStripper#processPage(PDPage)}
   */
  @Test
  @DisplayName("Test processPage(PDPage)")
  void testProcessPage() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addOperator(new DrawObject(new LegacyPDFStreamEngine()));
    PDPage page = new PDPage();

    // Act
    pdfTextStripperByArea.processPage(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    Composite nonStrokingJavaComposite = graphicsState.getNonStrokingJavaComposite();
    assertTrue(nonStrokingJavaComposite instanceof AlphaComposite);
    Area currentClippingPath = graphicsState.getCurrentClippingPath();
    Rectangle bounds = currentClippingPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    Point2D currentPoint = getResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Double);
    Rectangle2D bounds2D2 = getResult.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Double);
    Rectangle2D bounds2D3 = currentClippingPath.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Double);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    PDColorSpace nonStrokingColorSpace = graphicsState.getNonStrokingColorSpace();
    COSBase cOSObject2 = nonStrokingColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(nonStrokingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject2).getName());
    assertEquals("DeviceGray", nonStrokingColorSpace.getName());
    BlendMode blendMode = graphicsState.getBlendMode();
    COSName cOSName = blendMode.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(graphicsState.getTransfer());
    PDColor nonStrokingColor = graphicsState.getNonStrokingColor();
    assertNull(nonStrokingColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(cOSName.getKey());
    assertNull(cOSObject2.getKey());
    PDTextState textState = graphicsState.getTextState();
    assertNull(textState.getFont());
    assertNull(blendMode.getBlendFunction());
    assertNull(graphicsState.getSoftMask());
    assertNull(graphicsState.getRenderingIntent());
    assertNull(pdfTextStripperByArea.getTextLineMatrix());
    assertNull(pdfTextStripperByArea.getTextMatrix());
    assertNull(graphicsState.getTextLineMatrix());
    assertNull(graphicsState.getTextMatrix());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(0, graphicsState.getLineCap());
    assertEquals(0, graphicsState.getLineJoin());
    assertEquals(0, graphicsState.getOverprintMode());
    assertEquals(0, lineDashPattern.getDashArray().length);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, graphicsState.getSmoothness());
    assertEquals(0.0f, textState.getCharacterSpacing());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(0.0f, textState.getLeading());
    assertEquals(0.0f, textState.getRise());
    assertEquals(0.0f, textState.getWordSpacing());
    assertEquals(1, getResult.getWindingRule());
    List<List<TextPosition>> charactersByArticle = pdfTextStripperByArea.getCharactersByArticle();
    assertEquals(1, charactersByArticle.size());
    assertEquals(1, pdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(1, nonStrokingColorSpace.getNumberOfComponents());
    assertEquals(1.0d, graphicsState.getAlphaConstant());
    assertEquals(1.0d, graphicsState.getFlatness());
    assertEquals(1.0d, graphicsState.getNonStrokeAlphaConstant());
    assertEquals(1.0f, ((AlphaComposite) nonStrokingJavaComposite).getAlpha());
    assertEquals(1.0f, graphicsState.getLineWidth());
    assertEquals(10.0f, graphicsState.getMiterLimit());
    assertEquals(100.0f, textState.getHorizontalScaling());
    assertEquals(3, ((AlphaComposite) nonStrokingJavaComposite).getRule());
    assertEquals(306.0d, bounds.getCenterX());
    assertEquals(396.0d, bounds.getCenterY());
    Dimension size = bounds.getSize();
    assertEquals(612, size.width);
    assertEquals(612, bounds.width);
    assertEquals(612.0d, size.getWidth());
    assertEquals(612.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(792, size.height);
    assertEquals(792, bounds.height);
    assertEquals(792.0d, size.getHeight());
    assertEquals(792.0d, bounds.getHeight());
    assertEquals(792.0d, bounds.getMaxY());
    assertEquals(RenderingMode.FILL, textState.getRenderingMode());
    assertFalse(bounds.isEmpty());
    assertFalse(currentClippingPath.isEmpty());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSName.isEmpty());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(nonStrokingColor.isPattern());
    assertFalse(graphicsState.isAlphaSource());
    assertFalse(graphicsState.isNonStrokingOverprint());
    assertFalse(graphicsState.isOverprint());
    assertFalse(graphicsState.isStrokeAdjustment());
    assertTrue(currentClippingPath.isRectangular());
    assertTrue(charactersByArticle.get(0).isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(textState.getKnockoutFlag());
    assertEquals(location, location.getLocation());
    assertEquals(location, currentPoint);
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, getResult.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
    assertEquals(bounds, bounds2D3);
    assertEquals(bounds, frame);
    assertSame(page, pdfTextStripperByArea.getCurrentPage());
    assertSame(nonStrokingColor, nonStrokingColorSpace.getInitialColor());
    assertSame(nonStrokingColor, graphicsState.getStrokingColor());
    assertSame(nonStrokingJavaComposite, graphicsState.getStrokingJavaComposite());
    assertSame(nonStrokingColorSpace, nonStrokingColor.getColorSpace());
    assertSame(nonStrokingColorSpace, graphicsState.getStrokingColorSpace());
    assertArrayEquals(new float[]{0.0f}, nonStrokingColor.getComponents(), 0.0f);
  }

  /**
   * Test
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#actualText} is {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); given 'String'; then PDFTextStripper (default constructor) actualText is 'String'")
  void testBeginMarkedContentSequence_givenString_thenPDFTextStripperActualTextIsString() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    COSDictionary properties = mock(COSDictionary.class);
    when(properties.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, properties);

    // Assert
    verify(properties).getString(isA(COSName.class));
    assertEquals("String", pdfTextStripper.actualText);
    assertTrue(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); then throw IllegalArgumentException")
  void testBeginMarkedContentSequence_thenThrowIllegalArgumentException() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    COSDictionary properties = mock(COSDictionary.class);
    when(properties.getString(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("Artifact"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdfTextStripper.beginMarkedContentSequence(COSName.A, properties));
    verify(properties).getString(isA(COSName.class));
  }

  /**
   * Test
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when COSDictionary()")
  void testBeginMarkedContentSequence_whenCOSDictionary() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, new COSDictionary());

    // Assert
    assertNull(pdfTextStripper.actualText);
    assertFalse(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#actualText} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when COSStream(); then PDFTextStripper (default constructor) actualText is 'null'")
  void testBeginMarkedContentSequence_whenCOSStream_thenPDFTextStripperActualTextIsNull() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, new COSStream());

    // Assert
    assertNull(pdfTextStripper.actualText);
    assertFalse(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#actualText} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when 'null'; then PDFTextStripper (default constructor) actualText is 'null'")
  void testBeginMarkedContentSequence_whenNull_thenPDFTextStripperActualTextIsNull() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(null, new COSDictionary());

    // Assert
    assertNull(pdfTextStripper.actualText);
    assertFalse(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor)
   * {@link PDFTextStripper#actualText} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTextStripper#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary); when 'null'; then PDFTextStripper (default constructor) actualText is 'null'")
  void testBeginMarkedContentSequence_whenNull_thenPDFTextStripperActualTextIsNull2() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.beginMarkedContentSequence(COSName.A, null);

    // Assert
    assertNull(pdfTextStripper.actualText);
    assertFalse(pdfTextStripper.firstActualTextPosition);
  }

  /**
   * Test {@link PDFTextStripper#setStartPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when zero; then throw IllegalArgumentException")
  void testSetStartPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTextStripper()).setStartPage(0));
  }

  /**
   * Test {@link PDFTextStripper#setEndPage(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then {@link PDFTextStripper} (default constructor) EndPage is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when three; then PDFTextStripper (default constructor) EndPage is three")
  void testSetEndPage_whenThree_thenPDFTextStripperEndPageIsThree() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();

    // Act
    pdfTextStripper.setEndPage(3);

    // Assert
    assertEquals(3, pdfTextStripper.getEndPage());
  }

  /**
   * Test {@link PDFTextStripper#setEndPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when zero; then throw IllegalArgumentException")
  void testSetEndPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTextStripper()).setEndPage(0));
  }

  /**
   * Test {@link PDFTextStripper#getListItemPatterns()}.
   * <ul>
   *   <li>Given {@link PDFTextStripper} (default constructor).</li>
   *   <li>Then return size is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getListItemPatterns()}
   */
  @Test
  @DisplayName("Test getListItemPatterns(); given PDFTextStripper (default constructor); then return size is ten")
  void testGetListItemPatterns_givenPDFTextStripper_thenReturnSizeIsTen() {
    // Arrange and Act
    List<Pattern> actualListItemPatterns = (new PDFTextStripper()).getListItemPatterns();

    // Assert
    assertEquals(10, actualListItemPatterns.size());
    assertEquals("[A-Z]\\)", actualListItemPatterns.get(6).pattern());
    assertEquals("[A-Z]\\.", actualListItemPatterns.get(4).pattern());
    assertEquals("[IVXL]+\\.", actualListItemPatterns.get(8).pattern());
    assertEquals("[a-z]\\)", actualListItemPatterns.get(7).pattern());
    assertEquals("[a-z]\\.", actualListItemPatterns.get(5).pattern());
    assertEquals("[ivxl]+\\.", actualListItemPatterns.get(9).pattern());
    assertEquals("\\.", actualListItemPatterns.get(0).pattern());
    assertEquals("\\[\\d+\\]", actualListItemPatterns.get(2).pattern());
    assertEquals("\\d+\\)", actualListItemPatterns.get(3).pattern());
    assertEquals("\\d+\\.", actualListItemPatterns.get(1).pattern());
  }

  /**
   * Test {@link PDFTextStripper#getListItemPatterns()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#getListItemPatterns()}
   */
  @Test
  @DisplayName("Test getListItemPatterns(); then return Empty")
  void testGetListItemPatterns_thenReturnEmpty() {
    // Arrange
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    pdfTextStripper.setListItemPatterns(new ArrayList<>());

    // Act and Assert
    assertTrue(pdfTextStripper.getListItemPatterns().isEmpty());
  }

  /**
   * Test {@link PDFTextStripper#matchPattern(String, List)}.
   * <ul>
   *   <li>Given {@link StringUtil#PATTERN_SPACE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link StringUtil#PATTERN_SPACE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName("Test matchPattern(String, List); given PATTERN_SPACE; when ArrayList() add PATTERN_SPACE; then return 'null'")
  void testMatchPattern_givenPattern_space_whenArrayListAddPattern_space_thenReturnNull() {
    // Arrange
    ArrayList<Pattern> patterns = new ArrayList<>();
    patterns.add(StringUtil.PATTERN_SPACE);

    // Act and Assert
    assertNull(PDFTextStripper.matchPattern("String", patterns));
  }

  /**
   * Test {@link PDFTextStripper#matchPattern(String, List)}.
   * <ul>
   *   <li>Given {@link StringUtil#PATTERN_SPACE}.</li>
   *   <li>When space.</li>
   *   <li>Then return pattern is {@code \s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName("Test matchPattern(String, List); given PATTERN_SPACE; when space; then return pattern is '\\s'")
  void testMatchPattern_givenPattern_space_whenSpace_thenReturnPatternIsS() {
    // Arrange
    ArrayList<Pattern> patterns = new ArrayList<>();
    patterns.add(StringUtil.PATTERN_SPACE);

    // Act and Assert
    assertEquals("\\s", PDFTextStripper.matchPattern(" ", patterns).pattern());
  }

  /**
   * Test {@link PDFTextStripper#matchPattern(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTextStripper#matchPattern(String, List)}
   */
  @Test
  @DisplayName("Test matchPattern(String, List); when ArrayList(); then return 'null'")
  void testMatchPattern_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDFTextStripper.matchPattern("String", new ArrayList<>()));
  }
}
