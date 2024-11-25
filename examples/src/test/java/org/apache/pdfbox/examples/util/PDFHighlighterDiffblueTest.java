package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFHighlighterDiffblueTest {
  /**
   * Test {@link PDFHighlighter#PDFHighlighter()}.
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PDFHighlighter}
   */
  @Test
  @DisplayName("Test new PDFHighlighter()")
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
    assertEquals("\r\n", actualPdfHighlighter.getPageEnd());
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
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   * with {@code pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setEndBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   * with {@code pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput2() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setStartBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   * with {@code pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'")
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput3() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setAddMoreFormatting(true);
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   * with {@code pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   * <ul>
   *   <li>Given {@link PDFHighlighter#PDFHighlighter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'; given PDFHighlighter()")
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput_givenPDFHighlighter() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   * with {@code pdDocument}, {@code highlightWord}, {@code xmlOutput}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String, Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String, Writer) with 'pdDocument', 'highlightWord', 'xmlOutput'; given PDPage()")
  void testGenerateXMLHighlightWithPdDocumentHighlightWordXmlOutput_givenPDPage() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, "Highlight Word", xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   * with {@code pdDocument}, {@code sWords}, {@code xmlOutput}.
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setEndBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[]{"S Words"}, xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   * with {@code pdDocument}, {@code sWords}, {@code xmlOutput}.
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput2() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setStartBookmark(new PDOutlineItem());
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[]{"S Words"}, xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   * with {@code pdDocument}, {@code sWords}, {@code xmlOutput}.
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'")
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput3() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    pdfHighlighter.setAddMoreFormatting(true);
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[]{"S Words"}, xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   * with {@code pdDocument}, {@code sWords}, {@code xmlOutput}.
   * <ul>
   *   <li>Given {@link PDFHighlighter#PDFHighlighter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'; given PDFHighlighter()")
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput_givenPDFHighlighter() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();
    PDDocument pdDocument = new PDDocument();
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[]{"S Words"}, xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }

  /**
   * Test
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   * with {@code pdDocument}, {@code sWords}, {@code xmlOutput}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFHighlighter#generateXMLHighlight(PDDocument, String[], Writer)}
   */
  @Test
  @DisplayName("Test generateXMLHighlight(PDDocument, String[], Writer) with 'pdDocument', 'sWords', 'xmlOutput'; given PDPage()")
  void testGenerateXMLHighlightWithPdDocumentSWordsXmlOutput_givenPDPage() throws IOException {
    // Arrange
    PDFHighlighter pdfHighlighter = new PDFHighlighter();

    PDDocument pdDocument = new PDDocument();
    pdDocument.addPage(new PDPage());
    StringWriter xmlOutput = new StringWriter();

    // Act
    pdfHighlighter.generateXMLHighlight(pdDocument, new String[]{"S Words"}, xmlOutput);

    // Assert
    assertEquals("<XML>\n<Body units=characters  version=2>\n<Highlight>\n</Highlight>\n</Body>\n</XML>",
        xmlOutput.toString());
  }
}
