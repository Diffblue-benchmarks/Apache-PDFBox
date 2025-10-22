package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDStructureElementNameTreeNodeDiffblueTest {
  /**
   * Test {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode(COSDictionary)}.
   * <p>
   * Method under test: {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDStructureElementNameTreeNode(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureElementNameTreeNode.<init>(COSDictionary)"})
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
   * Test {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode()}.
   * <p>
   * Method under test: {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode()}
   */
  @Test
  @DisplayName("Test new PDStructureElementNameTreeNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureElementNameTreeNode.<init>()"})
  void testNewPDStructureElementNameTreeNode2() throws IOException {
    // Arrange and Act
    PDStructureElementNameTreeNode actualPdStructureElementNameTreeNode = new PDStructureElementNameTreeNode();

    // Assert
    assertNull(actualPdStructureElementNameTreeNode.getLowerLimit());
    assertNull(actualPdStructureElementNameTreeNode.getUpperLimit());
    assertNull(actualPdStructureElementNameTreeNode.getKids());
    assertNull(actualPdStructureElementNameTreeNode.getNames());
    COSDictionary cOSObject = actualPdStructureElementNameTreeNode.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdStructureElementNameTreeNode.getParent());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualPdStructureElementNameTreeNode.isRootNode());
  }

  /**
   * Test {@link PDStructureElementNameTreeNode#convertCOSToPD(COSBase)}.
   * <p>
   * Method under test: {@link PDStructureElementNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDStructureElement PDStructureElementNameTreeNode.convertCOSToPD(COSBase)"})
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
    assertTrue(actualConvertCOSToPDResult.getKids().isEmpty());
    assertSame(base, actualConvertCOSToPDResult.getCOSObject());
  }

  /**
   * Test {@link PDStructureElementNameTreeNode#createChildNode(COSDictionary)}.
   * <p>
   * Method under test: {@link PDStructureElementNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test createChildNode(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDNameTreeNode PDStructureElementNameTreeNode.createChildNode(COSDictionary)"})
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
}
