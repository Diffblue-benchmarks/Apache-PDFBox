package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageContentStreamDiffblueTest {
  /**
   * Test AppendMode {@link AppendMode#isOverwrite()}.
   * <ul>
   *   <li>Given {@code APPEND}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppendMode#isOverwrite()}
   */
  @Test
  @DisplayName("Test AppendMode isOverwrite(); given 'APPEND'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AppendMode.isOverwrite()"})
  void testAppendModeIsOverwrite_givenAppend_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AppendMode.APPEND.isOverwrite());
  }

  /**
   * Test AppendMode {@link AppendMode#isOverwrite()}.
   * <ul>
   *   <li>Given {@code OVERWRITE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppendMode#isOverwrite()}
   */
  @Test
  @DisplayName("Test AppendMode isOverwrite(); given 'OVERWRITE'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AppendMode.isOverwrite()"})
  void testAppendModeIsOverwrite_givenOverwrite_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AppendMode.OVERWRITE.isOverwrite());
  }

  /**
   * Test AppendMode {@link AppendMode#isPrepend()}.
   * <ul>
   *   <li>Given {@code OVERWRITE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppendMode#isPrepend()}
   */
  @Test
  @DisplayName("Test AppendMode isPrepend(); given 'OVERWRITE'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AppendMode.isPrepend()"})
  void testAppendModeIsPrepend_givenOverwrite_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AppendMode.OVERWRITE.isPrepend());
  }

  /**
   * Test AppendMode {@link AppendMode#isPrepend()}.
   * <ul>
   *   <li>Given {@link AppendMode#PREPEND}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppendMode#isPrepend()}
   */
  @Test
  @DisplayName("Test AppendMode isPrepend(); given PREPEND; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AppendMode.isPrepend()"})
  void testAppendModeIsPrepend_givenPrepend_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AppendMode.PREPEND.isPrepend());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   * <p>
   * Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage)"})
  void testNewPDPageContentStream() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(document, sourcePage);

    // Assert
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    PDResources expectedResources = actualPdPageContentStream.resources;
    assertSame(expectedResources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDAppearanceStream)}.
   * <ul>
   *   <li>When {@link PDAppearanceStream#PDAppearanceStream(COSStream)} with stream is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDAppearanceStream); when PDAppearanceStream(COSStream) with stream is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDAppearanceStream)"})
  void testNewPDPageContentStream_whenPDAppearanceStreamWithStreamIsCOSStream() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    PDDocument pdDocument = (new PDPageContentStream(doc, new PDAppearanceStream(new COSStream()))).document;
    COSDictionary expectedCOSObject = pdDocument.getPages().getCOSObject();
    assertSame(expectedCOSObject, pdDocument.getDocumentCatalog().getPages().getCOSObject());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); when PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean)"})
  void testNewPDPageContentStream_whenPDDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE,
        true);

    // Assert
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    PDResources expectedResources = actualPdPageContentStream.resources;
    assertSame(expectedResources, sourcePage.getResources());
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); when PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageContentStream.<init>(PDDocument, PDPage, AppendMode, boolean, boolean)"})
  void testNewPDPageContentStream_whenPDDocument2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDPage sourcePage = new PDPage();

    // Act
    PDPageContentStream actualPdPageContentStream = new PDPageContentStream(document, sourcePage, AppendMode.OVERWRITE,
        true, true);

    // Assert
    PDResources pdResources = actualPdPageContentStream.resources;
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
    PDResources expectedResources = actualPdPageContentStream.resources;
    assertSame(expectedResources, sourcePage.getResources());
  }
}
