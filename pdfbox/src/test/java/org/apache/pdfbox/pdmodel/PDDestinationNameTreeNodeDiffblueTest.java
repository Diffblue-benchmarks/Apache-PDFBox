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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDDestinationNameTreeNodeDiffblueTest {
  /**
   * Test
   * {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDestinationNameTreeNode(COSDictionary)")
  void testNewPDDestinationNameTreeNode() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act
    PDDestinationNameTreeNode actualPdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    // Assert
    assertNull(actualPdDestinationNameTreeNode.getParent());
    assertSame(dic, actualPdDestinationNameTreeNode.getCOSObject());
  }

  /**
   * Test {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   * <p>
   * Method under test:
   * {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}
   */
  @Test
  @DisplayName("Test new PDDestinationNameTreeNode()")
  void testNewPDDestinationNameTreeNode2() throws IOException {
    // Arrange and Act
    PDDestinationNameTreeNode actualPdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Assert
    assertNull(actualPdDestinationNameTreeNode.getLowerLimit());
    assertNull(actualPdDestinationNameTreeNode.getUpperLimit());
    assertNull(actualPdDestinationNameTreeNode.getKids());
    assertNull(actualPdDestinationNameTreeNode.getNames());
    COSDictionary cOSObject = actualPdDestinationNameTreeNode.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdDestinationNameTreeNode.getParent());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdDestinationNameTreeNode.isRootNode());
  }

  /**
   * Test {@link PDDestinationNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDestinationNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when COSDictionary(); then return 'null'")
  void testConvertCOSToPD_whenCOSDictionary_thenReturnNull() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.convertCOSToPD(new COSDictionary()));
  }

  /**
   * Test {@link PDDestinationNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDestinationNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when COSStream(); then return 'null'")
  void testConvertCOSToPD_whenCOSStream_thenReturnNull() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.convertCOSToPD(new COSStream()));
  }

  /**
   * Test {@link PDDestinationNameTreeNode#createChildNode(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDDestinationNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test createChildNode(COSDictionary)")
  void testCreateChildNode() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    COSDictionary dic = new COSDictionary();

    // Act
    PDNameTreeNode<PDPageDestination> actualCreateChildNodeResult = pdDestinationNameTreeNode.createChildNode(dic);

    // Assert
    assertTrue(actualCreateChildNodeResult instanceof PDDestinationNameTreeNode);
    assertNull(actualCreateChildNodeResult.getLowerLimit());
    assertNull(actualCreateChildNodeResult.getUpperLimit());
    assertNull(actualCreateChildNodeResult.getKids());
    assertNull(actualCreateChildNodeResult.getNames());
    assertNull(actualCreateChildNodeResult.getParent());
    assertTrue(actualCreateChildNodeResult.isRootNode());
    assertSame(dic, actualCreateChildNodeResult.getCOSObject());
  }
}
