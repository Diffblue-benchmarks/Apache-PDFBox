package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDEmbeddedFilesNameTreeNodeDiffblueTest {
  /**
   * Test {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode()}.
   *
   * <p>Method under test: {@link PDEmbeddedFilesNameTreeNode#PDEmbeddedFilesNameTreeNode()}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFilesNameTreeNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDEmbeddedFilesNameTreeNode.<init>()"})
  void testNewPDEmbeddedFilesNameTreeNode() throws IOException {
    // Arrange and Act
    PDEmbeddedFilesNameTreeNode actualPdEmbeddedFilesNameTreeNode =
        new PDEmbeddedFilesNameTreeNode();

    // Assert
    assertNull(actualPdEmbeddedFilesNameTreeNode.getLowerLimit());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getUpperLimit());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getKids());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getNames());
    COSDictionary cOSObject = actualPdEmbeddedFilesNameTreeNode.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdEmbeddedFilesNameTreeNode.getParent());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualPdEmbeddedFilesNameTreeNode.isRootNode());
  }

  /**
   * Test {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test convertCOSToPD(COSBase); when COSDictionary(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDComplexFileSpecification PDEmbeddedFilesNameTreeNode.convertCOSToPD(COSBase)"
  })
  void testConvertCOSToPD_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary()
      throws IOException {
    // Arrange
    PDEmbeddedFilesNameTreeNode pdEmbeddedFilesNameTreeNode = new PDEmbeddedFilesNameTreeNode();
    COSDictionary base = new COSDictionary();

    // Act
    PDComplexFileSpecification actualConvertCOSToPDResult =
        pdEmbeddedFilesNameTreeNode.convertCOSToPD(base);

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
   * Test {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDEmbeddedFilesNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDComplexFileSpecification PDEmbeddedFilesNameTreeNode.convertCOSToPD(COSBase)"
  })
  void testConvertCOSToPD_whenNull() throws IOException {
    // Arrange and Act
    PDComplexFileSpecification actualConvertCOSToPDResult =
        new PDEmbeddedFilesNameTreeNode().convertCOSToPD(null);

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
  }

  /**
   * Test {@link PDEmbeddedFilesNameTreeNode#createChildNode(COSDictionary)}.
   *
   * <p>Method under test: {@link PDEmbeddedFilesNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test createChildNode(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNameTreeNode PDEmbeddedFilesNameTreeNode.createChildNode(COSDictionary)"})
  void testCreateChildNode() throws IOException {
    // Arrange
    PDEmbeddedFilesNameTreeNode pdEmbeddedFilesNameTreeNode = new PDEmbeddedFilesNameTreeNode();
    COSDictionary dic = new COSDictionary();

    // Act
    PDNameTreeNode<PDComplexFileSpecification> actualCreateChildNodeResult =
        pdEmbeddedFilesNameTreeNode.createChildNode(dic);

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
