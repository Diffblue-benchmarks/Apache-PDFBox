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
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.junit.jupiter.api.Test;

class PDStructureElementNameTreeNodeDiffblueTest {
  /**
   * Method under test:
   * {@link PDStructureElementNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  void testConvertCOSToPD() throws IOException {
    // Arrange
    PDStructureElementNameTreeNode pdStructureElementNameTreeNode = new PDStructureElementNameTreeNode();
    COSDictionary base = new COSDictionary();

    // Act
    PDStructureElement actualConvertCOSToPDResult = pdStructureElementNameTreeNode.convertCOSToPD(base);

    // Assert
    assertNull(actualConvertCOSToPDResult.getActualText());
    assertNull(actualConvertCOSToPDResult.getAlternateDescription());
    assertNull(actualConvertCOSToPDResult.getElementIdentifier());
    assertNull(actualConvertCOSToPDResult.getExpandedForm());
    assertNull(actualConvertCOSToPDResult.getLanguage());
    assertNull(actualConvertCOSToPDResult.getStandardStructureType());
    assertNull(actualConvertCOSToPDResult.getStructureType());
    assertNull(actualConvertCOSToPDResult.getTitle());
    assertNull(actualConvertCOSToPDResult.getType());
    assertNull(actualConvertCOSToPDResult.getPage());
    assertNull(actualConvertCOSToPDResult.getParent());
    assertEquals(0, actualConvertCOSToPDResult.getRevisionNumber());
    assertEquals(0, actualConvertCOSToPDResult.getAttributes().size());
    assertEquals(0, actualConvertCOSToPDResult.getClassNames().size());
    assertTrue(actualConvertCOSToPDResult.getKids().isEmpty());
    assertSame(base, actualConvertCOSToPDResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElementNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  void testCreateChildNode() throws IOException {
    // Arrange
    PDStructureElementNameTreeNode pdStructureElementNameTreeNode = new PDStructureElementNameTreeNode();
    COSDictionary dic = new COSDictionary();

    // Act
    PDNameTreeNode<PDStructureElement> actualCreateChildNodeResult = pdStructureElementNameTreeNode
        .createChildNode(dic);

    // Assert
    assertTrue(actualCreateChildNodeResult instanceof PDStructureElementNameTreeNode);
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
   * {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode(COSDictionary)}
   */
  @Test
  void testNewPDStructureElementNameTreeNode() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act
    PDStructureElementNameTreeNode actualPdStructureElementNameTreeNode = new PDStructureElementNameTreeNode(dic);

    // Assert
    assertNull(actualPdStructureElementNameTreeNode.getParent());
    assertSame(dic, actualPdStructureElementNameTreeNode.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode()}
   */
  @Test
  void testNewPDStructureElementNameTreeNode2() throws IOException {
    // Arrange and Act
    PDStructureElementNameTreeNode actualPdStructureElementNameTreeNode = new PDStructureElementNameTreeNode();

    // Assert
    assertNull(actualPdStructureElementNameTreeNode.getLowerLimit());
    assertNull(actualPdStructureElementNameTreeNode.getUpperLimit());
    assertNull(actualPdStructureElementNameTreeNode.getKids());
    assertNull(actualPdStructureElementNameTreeNode.getNames());
    COSDictionary cOSObject = actualPdStructureElementNameTreeNode.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStructureElementNameTreeNode.getParent());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdStructureElementNameTreeNode.isRootNode());
  }
}
