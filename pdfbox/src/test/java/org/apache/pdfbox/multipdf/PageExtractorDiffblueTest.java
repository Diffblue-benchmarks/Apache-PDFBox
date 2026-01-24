package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PageExtractorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageExtractor#PageExtractor(PDDocument, int, int)}
   *   <li>{@link PageExtractor#setEndPage(int)}
   *   <li>{@link PageExtractor#setStartPage(int)}
   *   <li>{@link PageExtractor#getEndPage()}
   *   <li>{@link PageExtractor#getStartPage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageExtractor.<init>(PDDocument, int, int)",
    "int PageExtractor.getEndPage()",
    "int PageExtractor.getStartPage()",
    "void PageExtractor.setEndPage(int)",
    "void PageExtractor.setStartPage(int)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument(), 1, 3);
    actualPageExtractor.setEndPage(3);
    actualPageExtractor.setStartPage(1);
    int actualEndPage = actualPageExtractor.getEndPage();

    // Assert
    assertEquals(1, actualPageExtractor.getStartPage());
    assertEquals(3, actualEndPage);
  }

  /**
   * Test {@link PageExtractor#PageExtractor(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return EndPage is one.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  @DisplayName("Test new PageExtractor(PDDocument); given PDPage(); then return EndPage is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageExtractor.<init>(PDDocument)"})
  void testNewPageExtractor_givenPDPage_thenReturnEndPageIsOne() {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());

    // Act
    PageExtractor actualPageExtractor = new PageExtractor(sourceDocument);

    // Assert
    assertEquals(1, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }

  /**
   * Test {@link PageExtractor#PageExtractor(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return EndPage is zero.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  @DisplayName("Test new PageExtractor(PDDocument); when PDDocument(); then return EndPage is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageExtractor.<init>(PDDocument)"})
  void testNewPageExtractor_whenPDDocument_thenReturnEndPageIsZero() {
    // Arrange and Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument());

    // Assert
    assertEquals(0, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());
    sourceDocument.addPage(new PDPage());

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 2, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract2() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());
    sourceDocument.addPage(new PDPage());

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 1).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract3() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());
    sourceDocument.addPage(new PDPage());
    sourceDocument.addPage(new PDPage());

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 1).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName(
      "Test extract(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(key);
    sourceDocument.addPage(new PDPage(pageDictionary));

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage(COSDictionary)} with
   *       pageDictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName(
      "Test extract(); given PDDocument() addPage PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenPDDocumentAddPagePDPageWithPageDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());
    sourceDocument.addPage(new PDPage(new COSDictionary()));

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} DocumentInformation is {@link
   *       PDDocumentInformation#PDDocumentInformation()}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); given PDDocument() DocumentInformation is PDDocumentInformation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenPDDocumentDocumentInformationIsPDDocumentInformation() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.setDocumentInformation(new PDDocumentInformation());
    sourceDocument.addPage(new PDPage());

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Annotations is {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName(
      "Test extract(); given PDPage() Annotations is ArrayList(); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenPDPageAnnotationsIsArrayList_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(page);

    // Act and Assert
    Iterator<PDPage> iteratorResult =
        new PageExtractor(sourceDocument, 1, 3).extract().getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); given PDPage() Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenPDPageContentsIsArrayList() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();

    PDPage page = new PDPage();
    page.setContents(new ArrayList<>());
    sourceDocument.addPage(page);

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); given PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);
    sourceDocument.addPage(page);

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is one.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); given PDPage() Rotation is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenPDPageRotationIsOne() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();

    PDPage page = new PDPage();
    page.setRotation(1);
    sourceDocument.addPage(page);

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} ThreadBeads is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); given PDPage() ThreadBeads is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_givenPDPageThreadBeadsIsArrayList() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();

    PDPage page = new PDPage();
    page.setThreadBeads(new ArrayList<>());
    sourceDocument.addPage(page);

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Then return DocumentCatalog Pages iterator next is Pages iterator next.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName(
      "Test extract(); then return DocumentCatalog Pages iterator next is Pages iterator next")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_thenReturnDocumentCatalogPagesIteratorNextIsPagesIteratorNext()
      throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDPageTree pages = actualExtractResult.getDocumentCatalog().getPages();
    COSDictionary actualCOSObject = pages.getCOSObject();
    Iterator<PDPage> iteratorResult = pages.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    PDPageTree pages2 = actualExtractResult.getPages();
    COSDictionary expectedCOSObject = pages2.getCOSObject();
    Iterator<PDPage> iteratorResult2 = pages2.iterator();
    PDPage expectedNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(expectedCOSObject, actualCOSObject);
    assertEquals(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Then return DocumentInformation Title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); then return DocumentInformation Title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_thenReturnDocumentInformationTitleIsDr() throws IOException {
    // Arrange
    PDDocumentInformation info = new PDDocumentInformation();
    info.setTitle("Dr");

    PDDocument sourceDocument = new PDDocument();
    sourceDocument.setDocumentInformation(info);
    sourceDocument.addPage(new PDPage());

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    PDDocumentInformation documentInformation = actualExtractResult.getDocumentInformation();
    assertEquals("Dr", documentInformation.getTitle());
    COSDictionary cOSObject = documentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = documentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    Iterator<PDPage> iteratorResult = actualExtractResult.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertTrue(metadataKeys.contains("Title"));
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Then return Document Version is {@code 1.6}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); then return Document Version is '1.6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_thenReturnDocumentVersionIs16() throws IOException {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    sourceDocument.addPage(new PDPage());

    // Act
    PDDocument actualExtractResult = new PageExtractor(sourceDocument, 1, 3).extract();

    // Assert
    assertEquals(1.6f, actualExtractResult.getDocument().getVersion());
    assertEquals(1.6f, actualExtractResult.getVersion());
    Iterator<PDPage> iteratorResult = actualExtractResult.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
