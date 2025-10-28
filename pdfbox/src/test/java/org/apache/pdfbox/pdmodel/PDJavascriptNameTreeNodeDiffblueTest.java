package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.junit.jupiter.api.Test;

class PDJavascriptNameTreeNodeDiffblueTest {
  /**
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  void testConvertCOSToPD() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDJavascriptNameTreeNode()).convertCOSToPD(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  void testConvertCOSToPD2() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Act and Assert
    assertNull(pdJavascriptNameTreeNode.convertCOSToPD(new COSDictionary()));
  }

  /**
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  void testConvertCOSToPD3() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Act and Assert
    assertThrows(IOException.class, () -> pdJavascriptNameTreeNode.convertCOSToPD(new COSArray()));
  }

  /**
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  void testConvertCOSToPD4() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Act and Assert
    assertThrows(IOException.class,
        () -> pdJavascriptNameTreeNode.convertCOSToPD(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Method under test:
   * {@link PDJavascriptNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  void testCreateChildNode() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();
    COSDictionary dic = new COSDictionary();

    // Act
    PDNameTreeNode<PDActionJavaScript> actualCreateChildNodeResult = pdJavascriptNameTreeNode.createChildNode(dic);

    // Assert
    assertTrue(actualCreateChildNodeResult instanceof PDJavascriptNameTreeNode);
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
   * {@link PDJavascriptNameTreeNode#PDJavascriptNameTreeNode(COSDictionary)}
   */
  @Test
  void testNewPDJavascriptNameTreeNode() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act
    PDJavascriptNameTreeNode actualPdJavascriptNameTreeNode = new PDJavascriptNameTreeNode(dic);

    // Assert
    assertNull(actualPdJavascriptNameTreeNode.getParent());
    assertSame(dic, actualPdJavascriptNameTreeNode.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDJavascriptNameTreeNode#PDJavascriptNameTreeNode()}
   */
  @Test
  void testNewPDJavascriptNameTreeNode2() throws IOException {
    // Arrange and Act
    PDJavascriptNameTreeNode actualPdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Assert
    assertNull(actualPdJavascriptNameTreeNode.getLowerLimit());
    assertNull(actualPdJavascriptNameTreeNode.getUpperLimit());
    assertNull(actualPdJavascriptNameTreeNode.getKids());
    assertNull(actualPdJavascriptNameTreeNode.getNames());
    COSDictionary cOSObject = actualPdJavascriptNameTreeNode.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdJavascriptNameTreeNode.getParent());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdJavascriptNameTreeNode.isRootNode());
  }
}
