package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.multipdf.PDFMergerUtility.AcroFormMergeMode;
import org.apache.pdfbox.multipdf.PDFMergerUtility.DocumentMergeMode;
import org.apache.pdfbox.pdmodel.PDStructureElementNameTreeNode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFMergerUtilityDiffblueTest {
  /**
   * Test new {@link PDFMergerUtility} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PDFMergerUtility}
   */
  @Test
  @DisplayName("Test new PDFMergerUtility (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFMergerUtility.<init>()"})
  void testNewPDFMergerUtility() {
    // Arrange and Act
    PDFMergerUtility actualPdfMergerUtility = new PDFMergerUtility();

    // Assert
    assertNull(actualPdfMergerUtility.getDestinationStream());
    assertNull(actualPdfMergerUtility.getDestinationFileName());
    assertNull(actualPdfMergerUtility.getDestinationDocumentInformation());
    assertNull(actualPdfMergerUtility.getDestinationMetadata());
    assertEquals(AcroFormMergeMode.PDFBOX_LEGACY_MODE, actualPdfMergerUtility.getAcroFormMergeMode());
    assertEquals(DocumentMergeMode.PDFBOX_LEGACY_MODE, actualPdfMergerUtility.getDocumentMergeMode());
    assertFalse(actualPdfMergerUtility.isIgnoreAcroFormErrors());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode()} Names is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); given HashMap(); when PDStructureElementNameTreeNode() Names is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_givenHashMap_whenPDStructureElementNameTreeNodeNamesIsHashMap() throws IOException {
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
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_thenReturnSizeIsOne() throws IOException {
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
    assertTrue(getResult.getKids().isEmpty());
    assertSame(dic, getResult.getCOSObject());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_whenNull_thenReturnEmpty() throws IOException {
    // Arrange and Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility.getIDTreeAsMap(null);

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}.
   * <ul>
   *   <li>When {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getIDTreeAsMap(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test getIDTreeAsMap(PDNameTreeNode); when PDStructureElementNameTreeNode(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDFMergerUtility.getIDTreeAsMap(PDNameTreeNode)"})
  void testGetIDTreeAsMap_whenPDStructureElementNameTreeNode_thenReturnEmpty() throws IOException {
    // Arrange and Act
    Map<String, PDStructureElement> actualIDTreeAsMap = PDFMergerUtility
        .getIDTreeAsMap(new PDStructureElementNameTreeNode());

    // Assert
    assertTrue(actualIDTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode); given HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_thenReturnSizeIsOne() throws IOException {
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_whenNull_thenReturnEmpty() throws IOException {
    // Arrange and Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(null);

    // Assert
    assertTrue(actualNumberTreeAsMap.isEmpty());
  }

  /**
   * Test {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}.
   * <ul>
   *   <li>When {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is {@link COSObjectable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerUtility#getNumberTreeAsMap(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test getNumberTreeAsMap(PDNumberTreeNode); when PDNumberTreeNode(Class) with valueClass is COSObjectable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDFMergerUtility.getNumberTreeAsMap(PDNumberTreeNode)"})
  void testGetNumberTreeAsMap_whenPDNumberTreeNodeWithValueClassIsCOSObjectable() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    Map<Integer, COSObjectable> actualNumberTreeAsMap = PDFMergerUtility
        .getNumberTreeAsMap(new PDNumberTreeNode(valueClass));

    // Assert
    assertTrue(actualNumberTreeAsMap.isEmpty());
  }
}
