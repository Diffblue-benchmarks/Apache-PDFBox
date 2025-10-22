package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDJavascriptNameTreeNodeDiffblueTest {
  /**
   * Test {@link PDJavascriptNameTreeNode#PDJavascriptNameTreeNode(COSDictionary)}.
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#PDJavascriptNameTreeNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDJavascriptNameTreeNode(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDJavascriptNameTreeNode.<init>(COSDictionary)"})
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
   * Test {@link PDJavascriptNameTreeNode#PDJavascriptNameTreeNode()}.
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#PDJavascriptNameTreeNode()}
   */
  @Test
  @DisplayName("Test new PDJavascriptNameTreeNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDJavascriptNameTreeNode.<init>()"})
  void testNewPDJavascriptNameTreeNode2() throws IOException {
    // Arrange and Act
    PDJavascriptNameTreeNode actualPdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Assert
    assertNull(actualPdJavascriptNameTreeNode.getLowerLimit());
    assertNull(actualPdJavascriptNameTreeNode.getUpperLimit());
    assertNull(actualPdJavascriptNameTreeNode.getKids());
    assertNull(actualPdJavascriptNameTreeNode.getNames());
    COSDictionary cOSObject = actualPdJavascriptNameTreeNode.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdJavascriptNameTreeNode.getParent());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualPdJavascriptNameTreeNode.isRootNode());
  }

  /**
   * Test {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when COSArray(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDActionJavaScript PDJavascriptNameTreeNode.convertCOSToPD(COSBase)"})
  void testConvertCOSToPD_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Act and Assert
    assertThrows(IOException.class, () -> pdJavascriptNameTreeNode.convertCOSToPD(new COSArray()));
  }

  /**
   * Test {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDActionJavaScript PDJavascriptNameTreeNode.convertCOSToPD(COSBase)"})
  void testConvertCOSToPD_whenCOSDictionary_thenReturnNull() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Act and Assert
    assertNull(pdJavascriptNameTreeNode.convertCOSToPD(new COSDictionary()));
  }

  /**
   * Test {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when FALSE; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDActionJavaScript PDJavascriptNameTreeNode.convertCOSToPD(COSBase)"})
  void testConvertCOSToPD_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDJavascriptNameTreeNode()).convertCOSToPD(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when parseHex '42'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDActionJavaScript PDJavascriptNameTreeNode.convertCOSToPD(COSBase)"})
  void testConvertCOSToPD_whenParseHex42_thenThrowIOException() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Act and Assert
    assertThrows(IOException.class, () -> pdJavascriptNameTreeNode.convertCOSToPD(COSString.parseHex("42")));
  }

  /**
   * Test {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#convertCOSToPD(COSBase)}
   */
  @Test
  @DisplayName("Test convertCOSToPD(COSBase); when parseHex '0123456789ABCDEF'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDActionJavaScript PDJavascriptNameTreeNode.convertCOSToPD(COSBase)"})
  void testConvertCOSToPD_whenParseHex0123456789abcdef_thenThrowIOException() throws IOException {
    // Arrange
    PDJavascriptNameTreeNode pdJavascriptNameTreeNode = new PDJavascriptNameTreeNode();

    // Act and Assert
    assertThrows(IOException.class,
        () -> pdJavascriptNameTreeNode.convertCOSToPD(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Test {@link PDJavascriptNameTreeNode#createChildNode(COSDictionary)}.
   * <p>
   * Method under test: {@link PDJavascriptNameTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test createChildNode(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDNameTreeNode PDJavascriptNameTreeNode.createChildNode(COSDictionary)"})
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
}
