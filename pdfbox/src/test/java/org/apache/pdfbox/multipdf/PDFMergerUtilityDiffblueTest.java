package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDStructureElementNameTreeNode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.Test;

class PDFMergerUtilityDiffblueTest {
  /**
   * Method under test:
   * {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  void testAppendDocument() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    PDDocument destination = new PDDocument();

    // Act
    pdfMergerUtility.appendDocument(destination, new PDDocument());

    // Assert
    assertFalse(destination.getPages().iterator().hasNext());
    assertFalse(destination.getDocumentCatalog().getPages().iterator().hasNext());
  }

  /**
   * Method under test:
   * {@link PDFMergerUtility#appendDocument(PDDocument, PDDocument)}
   */
  @Test
  void testAppendDocument2() throws IOException {
    // Arrange
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument destination = new PDDocument(streamCacheCreateFunction);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction2 = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction2.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument source = new PDDocument(streamCacheCreateFunction2);
    source.addPage(new PDPage());
    source.addSignature(new PDSignature());

    // Act and Assert
    assertThrows(IOException.class, () -> pdfMergerUtility.appendDocument(destination, source));
    verify(streamCacheCreateFunction).create();
    verify(streamCacheCreateFunction2).create();
  }

  /**
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  void testGetIDTreeAsMap() throws IOException {
    // Arrange and Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility
        .getIDTreeAsMap(new PDStructureElementNameTreeNode());

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  void testGetIDTreeAsMap2() throws IOException {
    // Arrange and Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(null);

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  void testGetIDTreeAsMap3() throws IOException {
    // Arrange
    PDStructureElementNameTreeNode idTree = new PDStructureElementNameTreeNode();
    idTree.setNames(new HashMap<>());

    // Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(idTree);

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  void testGetIDTreeAsMap4() throws IOException {
    // Arrange
    HashMap<String, PDStructureElement> names = new HashMap<>();
    COSDictionary dic = new COSDictionary();
    names.put("foo", new PDStructureElement(dic));

    PDStructureElementNameTreeNode idTree = new PDStructureElementNameTreeNode();
    idTree.setNames(names);

    // Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(idTree);

    // Assert
    assertEquals(1, actualIDTreeAsMap.size());
    PDStructureElement getResult = actualIDTreeAsMap.get("foo");
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
    assertEquals(0, getResult.getAttributes().size());
    assertEquals(0, getResult.getClassNames().size());
    assertTrue(getResult.getKids().isEmpty());
    assertSame(dic, getResult.getCOSObject());
  }

  /**
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  void testGetIDTreeAsMap5() throws IOException {
    // Arrange
    HashMap<String, PDStructureElement> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));
    COSDictionary dic = new COSDictionary();
    names.put("foo", new PDStructureElement(dic));

    PDStructureElementNameTreeNode idTree = new PDStructureElementNameTreeNode();
    idTree.setNames(names);

    // Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(idTree);

    // Assert
    assertEquals(1, actualIDTreeAsMap.size());
    PDStructureElement getResult = actualIDTreeAsMap.get("foo");
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
    assertEquals(0, getResult.getAttributes().size());
    assertEquals(0, getResult.getClassNames().size());
    assertTrue(getResult.getKids().isEmpty());
    assertSame(dic, getResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  void testGetNumberTreeAsMap() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility
        .getNumberTreeAsMap(new PDNumberTreeNode(valueClass));

    // Assert
    assertTrue(actualNumberTreeAsMap.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  void testGetNumberTreeAsMap2() throws IOException {
    // Arrange and Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(null);

    // Assert
    assertTrue(actualNumberTreeAsMap.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  void testGetNumberTreeAsMap3() throws IOException {
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
   * Method under test:
   * {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  void testGetNumberTreeAsMap4() throws IOException {
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
   * Method under test: default or parameterless constructor of
   * {@link PDFMergerUtility}
   */
  @Test
  void testNewPDFMergerUtility() {
    // Arrange and Act
    PDFMergerUtility actualPdfMergerUtility = new PDFMergerUtility();

    // Assert
    assertNull(actualPdfMergerUtility.getDestinationStream());
    assertNull(actualPdfMergerUtility.getDestinationFileName());
    assertNull(actualPdfMergerUtility.getDestinationDocumentInformation());
    assertNull(actualPdfMergerUtility.getDestinationMetadata());
    assertEquals(PDFMergerUtility.AcroFormMergeMode.PDFBOX_LEGACY_MODE, actualPdfMergerUtility.getAcroFormMergeMode());
    assertEquals(PDFMergerUtility.DocumentMergeMode.PDFBOX_LEGACY_MODE, actualPdfMergerUtility.getDocumentMergeMode());
    assertFalse(actualPdfMergerUtility.isIgnoreAcroFormErrors());
  }
}
