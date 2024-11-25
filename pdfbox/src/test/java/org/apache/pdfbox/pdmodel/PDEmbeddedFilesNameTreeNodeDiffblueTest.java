package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDEmbeddedFilesNameTreeNodeDiffblueTest {
  /**
   * Test
   * {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFilesNameTreeNode(COSDictionary)")
  void testNewPDEmbeddedFilesNameTreeNode() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act
    PDEmbeddedFilesNameTreeNode actualPdEmbeddedFilesNameTreeNode = new PDEmbeddedFilesNameTreeNode(dic);

    // Assert
    assertNull(actualPdEmbeddedFilesNameTreeNode.getParent());
    assertSame(dic, actualPdEmbeddedFilesNameTreeNode.getCOSObject());
  }

  /**
   * Test {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode()}.
   * <p>
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode()}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFilesNameTreeNode()")
  void testNewPDEmbeddedFilesNameTreeNode2() throws IOException {
    // Arrange and Act
    PDEmbeddedFilesNameTreeNode actualPdEmbeddedFilesNameTreeNode = new PDEmbeddedFilesNameTreeNode();

    // Assert
    assertNull(actualPdEmbeddedFilesNameTreeNode.getLowerLimit());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getUpperLimit());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getKids());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getNames());
    COSDictionary cOSObject = actualPdEmbeddedFilesNameTreeNode.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getParent());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdEmbeddedFilesNameTreeNode.isRootNode());
  }

  /**
   * Test {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); then return COSObject UpdateState OriginDocumentState is 'null'")
  void testConvertCOSToPD_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() throws IOException {
    // Arrange and Act
    PDComplexFileSpecification actualConvertCOSToPDResult = (new PDEmbeddedFilesNameTreeNode()).convertCOSToPD(null);

    // Assert
    assertNull(actualConvertCOSToPDResult.getFile());
    assertNull(actualConvertCOSToPDResult.getFileDescription());
    assertNull(actualConvertCOSToPDResult.getFileDos());
    assertNull(actualConvertCOSToPDResult.getFileMac());
    assertNull(actualConvertCOSToPDResult.getFileUnicode());
    assertNull(actualConvertCOSToPDResult.getFileUnix());
    assertNull(actualConvertCOSToPDResult.getFilename());
    COSDictionary cOSObject = actualConvertCOSToPDResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFile());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileDos());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileMac());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileUnicode());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileUnix());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualConvertCOSToPDResult.isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when COSDictionary(); then return COSObject is COSDictionary()")
  void testConvertCOSToPD_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    PDEmbeddedFilesNameTreeNode pdEmbeddedFilesNameTreeNode = new PDEmbeddedFilesNameTreeNode();
    COSDictionary base = new COSDictionary();

    // Act
    PDComplexFileSpecification actualConvertCOSToPDResult = pdEmbeddedFilesNameTreeNode.convertCOSToPD(base);

    // Assert
    assertNull(actualConvertCOSToPDResult.getFile());
    assertNull(actualConvertCOSToPDResult.getFileDescription());
    assertNull(actualConvertCOSToPDResult.getFileDos());
    assertNull(actualConvertCOSToPDResult.getFileMac());
    assertNull(actualConvertCOSToPDResult.getFileUnicode());
    assertNull(actualConvertCOSToPDResult.getFileUnix());
    assertNull(actualConvertCOSToPDResult.getFilename());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFile());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileDos());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileMac());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileUnicode());
    assertNull(actualConvertCOSToPDResult.getEmbeddedFileUnix());
    assertFalse(actualConvertCOSToPDResult.isVolatile());
    assertSame(base, actualConvertCOSToPDResult.getCOSObject());
  }

  /**
   * Test {@link PDEmbeddedFilesNameTreeNode#createChildNode(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test createChildNode(COSDictionary)")
  void testCreateChildNode() throws IOException {
    // Arrange
    PDEmbeddedFilesNameTreeNode pdEmbeddedFilesNameTreeNode = new PDEmbeddedFilesNameTreeNode();
    COSDictionary dic = new COSDictionary();

    // Act
    PDNameTreeNode<PDComplexFileSpecification> actualCreateChildNodeResult = pdEmbeddedFilesNameTreeNode
        .createChildNode(dic);

    // Assert
    assertTrue(actualCreateChildNodeResult instanceof PDEmbeddedFilesNameTreeNode);
    assertNull(actualCreateChildNodeResult.getLowerLimit());
    assertNull(actualCreateChildNodeResult.getUpperLimit());
    assertNull(actualCreateChildNodeResult.getKids());
    assertNull(actualCreateChildNodeResult.getNames());
    assertNull(actualCreateChildNodeResult.getParent());
    assertTrue(actualCreateChildNodeResult.isRootNode());
    assertSame(dic, actualCreateChildNodeResult.getCOSObject());
  }
}
