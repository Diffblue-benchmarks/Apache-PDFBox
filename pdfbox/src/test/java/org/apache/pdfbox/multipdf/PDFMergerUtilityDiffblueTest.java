package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.multipdf.PDFMergerUtility.AcroFormMergeMode;
import org.apache.pdfbox.multipdf.PDFMergerUtility.DocumentMergeMode;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDStructureElementNameTreeNode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFMergerUtilityDiffblueTest {
  /**
   * Test new {@link PDFMergerUtility} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PDFMergerUtility}
   */
  @Test
  @DisplayName("Test new PDFMergerUtility (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.<init>()"})
  void testNewPDFMergerUtility() {
    // Arrange and Act
    PDFMergerUtility actualPdfMergerUtility = new PDFMergerUtility();

    // Assert
    assertNull(actualPdfMergerUtility.getDestinationStream());
    assertNull(actualPdfMergerUtility.getDestinationFileName());
    assertNull(actualPdfMergerUtility.getDestinationDocumentInformation());
    assertNull(actualPdfMergerUtility.getDestinationMetadata());
    assertEquals(
        AcroFormMergeMode.PDFBOX_LEGACY_MODE, actualPdfMergerUtility.getAcroFormMergeMode());
    assertEquals(
        DocumentMergeMode.PDFBOX_LEGACY_MODE, actualPdfMergerUtility.getDocumentMergeMode());
    assertFalse(actualPdfMergerUtility.isIgnoreAcroFormErrors());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFMergerUtility#setAcroFormMergeMode(AcroFormMergeMode)}
   *   <li>{@link PDFMergerUtility#setDestinationDocumentInformation(PDDocumentInformation)}
   *   <li>{@link PDFMergerUtility#setDestinationFileName(String)}
   *   <li>{@link PDFMergerUtility#setDestinationMetadata(PDMetadata)}
   *   <li>{@link PDFMergerUtility#setDestinationStream(OutputStream)}
   *   <li>{@link PDFMergerUtility#setDocumentMergeMode(DocumentMergeMode)}
   *   <li>{@link PDFMergerUtility#setIgnoreAcroFormErrors(boolean)}
   *   <li>{@link PDFMergerUtility#getAcroFormMergeMode()}
   *   <li>{@link PDFMergerUtility#getDestinationDocumentInformation()}
   *   <li>{@link PDFMergerUtility#getDestinationFileName()}
   *   <li>{@link PDFMergerUtility#getDestinationMetadata()}
   *   <li>{@link PDFMergerUtility#getDestinationStream()}
   *   <li>{@link PDFMergerUtility#getDocumentMergeMode()}
   *   <li>{@link PDFMergerUtility#isIgnoreAcroFormErrors()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AcroFormMergeMode PDFMergerUtility.getAcroFormMergeMode()",
    "PDDocumentInformation PDFMergerUtility.getDestinationDocumentInformation()",
    "String PDFMergerUtility.getDestinationFileName()",
    "PDMetadata PDFMergerUtility.getDestinationMetadata()",
    "OutputStream PDFMergerUtility.getDestinationStream()",
    "DocumentMergeMode PDFMergerUtility.getDocumentMergeMode()",
    "boolean PDFMergerUtility.isIgnoreAcroFormErrors()",
    "void PDFMergerUtility.setAcroFormMergeMode(AcroFormMergeMode)",
    "void PDFMergerUtility.setDestinationDocumentInformation(PDDocumentInformation)",
    "void PDFMergerUtility.setDestinationFileName(String)",
    "void PDFMergerUtility.setDestinationMetadata(PDMetadata)",
    "void PDFMergerUtility.setDestinationStream(OutputStream)",
    "void PDFMergerUtility.setDocumentMergeMode(DocumentMergeMode)",
    "void PDFMergerUtility.setIgnoreAcroFormErrors(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();

    // Act
    pdfMergerUtility.setAcroFormMergeMode(AcroFormMergeMode.JOIN_FORM_FIELDS_MODE);
    PDDocumentInformation info = new PDDocumentInformation();
    pdfMergerUtility.setDestinationDocumentInformation(info);
    pdfMergerUtility.setDestinationFileName("Destination");
    PDMetadata meta = new PDMetadata(new COSStream());
    pdfMergerUtility.setDestinationMetadata(meta);
    ByteArrayOutputStream destStream = new ByteArrayOutputStream();
    pdfMergerUtility.setDestinationStream(destStream);
    pdfMergerUtility.setDocumentMergeMode(DocumentMergeMode.OPTIMIZE_RESOURCES_MODE);
    pdfMergerUtility.setIgnoreAcroFormErrors(true);
    AcroFormMergeMode actualAcroFormMergeMode = pdfMergerUtility.getAcroFormMergeMode();
    PDDocumentInformation actualDestinationDocumentInformation =
        pdfMergerUtility.getDestinationDocumentInformation();
    String actualDestinationFileName = pdfMergerUtility.getDestinationFileName();
    PDMetadata actualDestinationMetadata = pdfMergerUtility.getDestinationMetadata();
    OutputStream actualDestinationStream = pdfMergerUtility.getDestinationStream();
    DocumentMergeMode actualDocumentMergeMode = pdfMergerUtility.getDocumentMergeMode();

    // Assert
    assertEquals("Destination", actualDestinationFileName);
    assertEquals(AcroFormMergeMode.JOIN_FORM_FIELDS_MODE, actualAcroFormMergeMode);
    assertEquals(DocumentMergeMode.OPTIMIZE_RESOURCES_MODE, actualDocumentMergeMode);
    assertTrue(pdfMergerUtility.isIgnoreAcroFormErrors());
    assertSame(destStream, actualDestinationStream);
    assertSame(info, actualDestinationDocumentInformation);
    assertSame(meta, actualDestinationMetadata);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName("Test appendDocument(PDDocument, PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(3L, 3));
    PDPage page = new PDPage(pageDictionary);

    PDDocument source = new PDDocument();
    source.addPage(page);

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert that nothing has changed
    assertFalse(destination.getPages().iterator().hasNext());
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName("Test appendDocument(PDDocument, PDDocument); given ByteArrayOutputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_givenByteArrayOutputStream() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();

    PDDocument destination = new PDDocument();
    destination.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);

    PDDocument source = new PDDocument();
    source.addPage(new PDPage());

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert
    Iterator<PDPage> iteratorResult = destination.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName("Test appendDocument(PDDocument, PDDocument); given PDDocumentInformation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_givenPDDocumentInformation() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    PDDocument source = new PDDocument();
    source.setDocumentInformation(new PDDocumentInformation());
    source.addPage(new PDPage());

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert
    Iterator<PDPage> iteratorResult = destination.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test appendDocument(PDDocument, PDDocument); given PDPage() CropBox is A0; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_givenPDPageCropBoxIsA0_thenArrayLengthIsThree() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);

    PDDocument source = new PDDocument();
    source.addPage(page);

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert
    Iterator<PDPage> iteratorResult = destination.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Rotation is three.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test appendDocument(PDDocument, PDDocument); given PDPage() Rotation is three; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_givenPDPageRotationIsThree_thenArrayLengthIsThree() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    PDPage page = new PDPage();
    page.setRotation(3);

    PDDocument source = new PDDocument();
    source.addPage(page);

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert
    Iterator<PDPage> iteratorResult = destination.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage(COSDictionary)} with pageDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test appendDocument(PDDocument, PDDocument); given PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_givenPDPageWithPageDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    PDDocument source = new PDDocument();
    source.addPage(new PDPage(new COSDictionary()));

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert that nothing has changed
    assertFalse(destination.getPages().iterator().hasNext());
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test appendDocument(PDDocument, PDDocument); given PDPage(); then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_givenPDPage_thenArrayLengthIsThree() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    PDDocument source = new PDDocument();
    source.addPage(new PDPage());

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert
    Iterator<PDPage> iteratorResult = destination.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} DocumentCatalog Version is {@code 1.6}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test appendDocument(PDDocument, PDDocument); then PDDocument() DocumentCatalog Version is '1.6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_thenPDDocumentDocumentCatalogVersionIs16() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    PDDocument source = new PDDocument();
    source.save(new ByteArrayOutputStream(), CompressParameters.DEFAULT_COMPRESSION);
    source.addPage(new PDPage());

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert
    assertEquals("1.6", destination.getDocumentCatalog().getVersion());
    assertEquals(1.6f, destination.getVersion());
    Iterator<PDPage> iteratorResult = destination.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} DocumentInformation Title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test appendDocument(PDDocument, PDDocument); then PDDocument() DocumentInformation Title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_thenPDDocumentDocumentInformationTitleIsDr() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    PDDocumentInformation info = new PDDocumentInformation();
    info.setTitle("Dr");

    PDDocument source = new PDDocument();
    source.setDocumentInformation(info);
    source.addPage(new PDPage());

    // Act
    pdfMergerUtility.appendDocument(destination, source);

    // Assert
    PDDocumentInformation documentInformation = destination.getDocumentInformation();
    assertEquals("Dr", documentInformation.getTitle());
    COSDictionary cOSObject = documentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = documentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    Iterator<PDPage> iteratorResult = destination.getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertTrue(metadataKeys.contains("Title"));
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then not {@link PDDocument#PDDocument()} Pages iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test appendDocument(PDDocument, PDDocument); when PDDocument(); then not PDDocument() Pages iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMergerUtility.appendDocument(PDDocument, PDDocument)"})
  void testAppendDocument_whenPDDocument_thenNotPDDocumentPagesIteratorHasNext()
      throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    // Act
    pdfMergerUtility.appendDocument(destination, new PDDocument());

    // Assert that nothing has changed
    assertFalse(destination.getPages().iterator().hasNext());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   *
   * <p>Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap() throws IOException {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    HashMap<String, PDStructureElement> names = new HashMap<>();
    names.put("Key", pdStructureElement);

    PDStructureElementNameTreeNode idTree = new PDStructureElementNameTreeNode();
    idTree.setNames(names);

    // Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(idTree);

    // Assert
    assertEquals(1, actualIDTreeAsMap.size());
    assertSame(key, actualIDTreeAsMap.get("Key").getCOSObject().getKey());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); given HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_givenHashMap_thenReturnEmpty() throws IOException {
    // Arrange
    PDStructureElementNameTreeNode idTree = new PDStructureElementNameTreeNode();
    idTree.setNames(new HashMap<>());

    // Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(idTree);

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>Then return empty string ActualText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); then return empty string ActualText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_thenReturnEmptyStringActualTextIsNull() throws IOException {
    // Arrange
    HashMap<String, PDStructureElement> names = new HashMap<>();
    COSDictionary dic = new COSDictionary();
    names.put("", new PDStructureElement(dic));

    PDStructureElementNameTreeNode idTree = new PDStructureElementNameTreeNode();
    idTree.setNames(names);

    // Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(idTree);

    // Assert
    assertEquals(1, actualIDTreeAsMap.size());
    PDStructureElement getResult = actualIDTreeAsMap.get("");
    assertNull(getResult.getActualText());
    assertNull(getResult.getAlternateDescription());
    assertNull(getResult.getElementIdentifier());
    assertNull(getResult.getExpandedForm());
    assertNull(getResult.getLanguage());
    assertNull(getResult.getStandardStructureType());
    assertNull(getResult.getStructureType());
    assertNull(getResult.getTitle());
    assertNull(getResult.getType());
    assertNull(getResult.getPage());
    assertNull(getResult.getParent());
    assertEquals(0, getResult.getRevisionNumber());
    assertTrue(getResult.getKids().isEmpty());
    assertSame(dic, getResult.getCOSObject());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>Then return {@code Key} ActualText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); then return 'Key' ActualText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_thenReturnKeyActualTextIsNull() throws IOException {
    // Arrange
    HashMap<String, PDStructureElement> names = new HashMap<>();
    COSDictionary dic = new COSDictionary();
    names.put("Key", new PDStructureElement(dic));

    PDStructureElementNameTreeNode idTree = new PDStructureElementNameTreeNode();
    idTree.setNames(names);

    // Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(idTree);

    // Assert
    assertEquals(1, actualIDTreeAsMap.size());
    PDStructureElement getResult = actualIDTreeAsMap.get("Key");
    assertNull(getResult.getActualText());
    assertNull(getResult.getAlternateDescription());
    assertNull(getResult.getElementIdentifier());
    assertNull(getResult.getExpandedForm());
    assertNull(getResult.getLanguage());
    assertNull(getResult.getStandardStructureType());
    assertNull(getResult.getStructureType());
    assertNull(getResult.getTitle());
    assertNull(getResult.getType());
    assertNull(getResult.getPage());
    assertNull(getResult.getParent());
    assertEquals(0, getResult.getRevisionNumber());
    assertTrue(getResult.getKids().isEmpty());
    assertSame(dic, getResult.getCOSObject());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_whenNull_thenReturnEmpty() throws IOException {
    // Arrange and Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(null);

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>When {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName(
      "Test getIDTreeAsMap(PDNameTreeNode); when PDStructureElementNameTreeNode(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_whenPDStructureElementNameTreeNode_thenReturnEmpty() throws IOException {
    // Arrange and Act
    Map<String, PDStructureElement> actualIDTreeAsMap =
        PDFMergerUtility.getIDTreeAsMap(new PDStructureElementNameTreeNode());

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(null, new COSObjectKey(1L, 1));
    when(cosObjectable.getCOSObject()).thenReturn(cosObject);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode tree = new PDNumberTreeNode(valueClass);
    tree.setNumbers(numbers);

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(tree);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualNumberTreeAsMap.size());
    assertNull(actualNumberTreeAsMap.get(1));
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap2() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(new COSObjectKey(1L, 1), null);
    when(cosObjectable.getCOSObject()).thenReturn(cosObject);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode tree = new PDNumberTreeNode(valueClass);
    tree.setNumbers(numbers);

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(tree);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualNumberTreeAsMap.size());
    assertNull(actualNumberTreeAsMap.get(1));
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode); given 'A'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_givenA_thenReturnSizeIsOne() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    COSObjectKey key = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject cosObject = new COSObject(key, parser);
    when(cosObjectable.getCOSObject()).thenReturn(cosObject);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode tree = new PDNumberTreeNode(valueClass);
    tree.setNumbers(numbers);

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(tree);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualNumberTreeAsMap.size());
    assertNull(actualNumberTreeAsMap.get(1));
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName(
      "Test getNumberTreeAsMap(PDNumberTreeNode); given COSObjectable getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_givenCOSObjectableGetCOSObjectReturnNull() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(null);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode tree = new PDNumberTreeNode(valueClass);
    tree.setNumbers(numbers);

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(tree);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualNumberTreeAsMap.size());
    assertNull(actualNumberTreeAsMap.get(1));
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName(
      "Test getNumberTreeAsMap(PDNumberTreeNode); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    when(cosObjectable.getCOSObject()).thenReturn(cosObject);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode tree = new PDNumberTreeNode(valueClass);
    tree.setNumbers(numbers);

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(tree);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualNumberTreeAsMap.size());
    assertNull(actualNumberTreeAsMap.get(1));
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode); given HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_givenHashMap_thenReturnEmpty() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode tree = new PDNumberTreeNode(valueClass);
    tree.setNumbers(new HashMap<>());

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(tree);

    // Assert
    assertTrue(actualNumberTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_whenNull_thenReturnEmpty() throws IOException {
    // Arrange and Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(null);

    // Assert
    assertTrue(actualNumberTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>When {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is {@link
   *       COSObjectable}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName(
      "Test getNumberTreeAsMap(PDNumberTreeNode); when PDNumberTreeNode(Class) with valueClass is COSObjectable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_whenPDNumberTreeNodeWithValueClassIsCOSObjectable()
      throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap =
        PDFMergerUtility.getNumberTreeAsMap(new PDNumberTreeNode(valueClass));

    // Assert
    assertTrue(actualNumberTreeAsMap.isEmpty());
  }
}
