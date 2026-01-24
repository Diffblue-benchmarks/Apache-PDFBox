package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFHighlighterDiffblueTest {
  /**
   * Test {@link PDFHighlighter#PDFHighlighter()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PDFHighlighter}
   */
  @Test
  @DisplayName("Test new PDFHighlighter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.<init>()"})
  void testNewPDFHighlighter() throws IOException {
    // Arrange and Act
    PDFHighlighter actualPdfHighlighter = new PDFHighlighter();

    // Assert
    assertEquals("", actualPdfHighlighter.getArticleEnd());
    assertEquals("", actualPdfHighlighter.getArticleStart());
    assertEquals("", actualPdfHighlighter.getLineSeparator());
    assertEquals("", actualPdfHighlighter.getPageStart());
    assertEquals("", actualPdfHighlighter.getParagraphEnd());
    assertEquals("", actualPdfHighlighter.getParagraphStart());
    assertEquals("", actualPdfHighlighter.getWordSeparator());
    assertEquals("\n", actualPdfHighlighter.getPageEnd());
    assertNull(actualPdfHighlighter.getCurrentPage());
    assertNull(actualPdfHighlighter.getResources());
    assertNull(actualPdfHighlighter.getGraphicsState());
    assertNull(actualPdfHighlighter.getEndBookmark());
    assertNull(actualPdfHighlighter.getStartBookmark());
    assertNull(actualPdfHighlighter.getInitialMatrix());
    assertEquals(0, actualPdfHighlighter.getGraphicsStackSize());
    assertEquals(0, actualPdfHighlighter.getLevel());
    assertEquals(0.3f, actualPdfHighlighter.getAverageCharTolerance());
    assertEquals(0.5f, actualPdfHighlighter.getSpacingTolerance());
    assertEquals(1, actualPdfHighlighter.getStartPage());
    assertEquals(2.0f, actualPdfHighlighter.getIndentThreshold());
    assertEquals(2.5f, actualPdfHighlighter.getDropThreshold());
    assertFalse(actualPdfHighlighter.getAddMoreFormatting());
    assertFalse(actualPdfHighlighter.getSeparateByBeads());
    assertFalse(actualPdfHighlighter.getSortByPosition());
    assertFalse(actualPdfHighlighter.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPdfHighlighter.getEndPage());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setEndBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput2() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setStartBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput3() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setAddMoreFormatting(true);
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput4() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage(new COSDictionary()));
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput5() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput6() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput7() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setShouldSeparateByBeads(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput8() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setSortByPosition(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput9() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    pdDocument.save(output, new CompressParameters());
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", new StringWriter());

    // Assert
    assertNull(pdfHighlighter.getTextLineMatrix());
    assertNull(pdfHighlighter.getTextMatrix());
    assertEquals(1, pdfHighlighter.getGraphicsStackSize());
    assertEquals(page, pdfHighlighter.getCurrentPage());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput10() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput11() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setStartBookmark(new PDOutlineItem());
    pdfHighlighter.setEndBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput12() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "", xmlOutput);

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertEquals(
        "<XML>\n"
            + "<Body units=characters  version=2>\n"
            + "<Highlight>\n"
            + "    <loc pg=0 pos=0 len=0>\n"
            + "    <loc pg=0 pos=1 len=0>\n"
            + "</Highlight>\n"
            + "</Body>\n"
            + "</XML>",
        xmlOutput.toString());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'; given PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput_givenPDPage()
      throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)} with {@code
   * pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'; when PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String, Writer)"})
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput_whenPDDocument()
      throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setEndBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput2() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setStartBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput3() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setAddMoreFormatting(true);
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput4() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage(new COSDictionary()));
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput5() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput6() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput7() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setShouldSeparateByBeads(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput8() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setSortByPosition(true);

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, new StringWriter());

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput9() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    pdDocument.save(output, new CompressParameters());
    pdDocument.addPage(page);

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, new StringWriter());

    // Assert
    assertNull(pdfHighlighter.getTextLineMatrix());
    assertNull(pdfHighlighter.getTextMatrix());
    assertEquals(1, pdfHighlighter.getGraphicsStackSize());
    assertEquals(page, pdfHighlighter.getCurrentPage());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput10() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput11() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setStartBookmark(new PDOutlineItem());
    pdfHighlighter.setEndBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput12() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(page);
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {""}, xmlOutput);

    // Assert
    PDGraphicsState graphicsState = pdfHighlighter.getGraphicsState();
    Rectangle2D bounds2D = graphicsState.getCurrentClippingPath().getBounds().getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertEquals(
        "<XML>\n"
            + "<Body units=characters  version=2>\n"
            + "<Highlight>\n"
            + "    <loc pg=0 pos=0 len=0>\n"
            + "    <loc pg=0 pos=1 len=0>\n"
            + "</Highlight>\n"
            + "</Body>\n"
            + "</XML>",
        xmlOutput.toString());
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'; given PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput_givenPDPage() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)} with {@code
   * pdDocument}, {@code sWords}, {@code xmlOutput}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName(
      "Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'; when PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFHighlighter.generateXMLHighlight(PDDocument, String[], Writer)"})
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput_whenPDDocument() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[] {"S Words"}, xmlOutput);

    // Assert
    assertEquals(
        "<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
    assertNull(pdfHighlighter.getCurrentPage());
    assertNull(pdfHighlighter.getInitialMatrix());
    assertEquals(0, pdfHighlighter.getGraphicsStackSize());
  }
}
