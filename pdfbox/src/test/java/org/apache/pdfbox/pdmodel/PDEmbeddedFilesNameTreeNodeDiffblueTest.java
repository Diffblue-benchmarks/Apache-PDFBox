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
import org.junit.jupiter.api.Test;

class PDEmbeddedFilesNameTreeNodeDiffblueTest {
  /**
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  void testConvertCOSToPD() throws IOException {
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
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  void testConvertCOSToPD2() throws IOException {
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
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
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

  /**
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode(COSDictionary)}
   */
  @Test
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
   * Method under test:
   * {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode()}
   */
  @Test
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
}
