package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDStructureElementNameTreeNode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDStructureTreeRootDiffblueTest {
  /**
   * Test {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)}.
   *
   * <p>Method under test: {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDStructureTreeRoot(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.<init>(COSDictionary)"})
  void testNewPDStructureTreeRoot() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, new PDStructureTreeRoot(dic).getCOSObject());
  }

  /**
   * Test {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *
   * <p>Method under test: {@link PDStructureTreeRoot#PDStructureTreeRoot()}
   */
  @Test
  @DisplayName("Test new PDStructureTreeRoot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.<init>()"})
  void testNewPDStructureTreeRoot2() {
    // Arrange and Act
    PDStructureTreeRoot actualPdStructureTreeRoot = new PDStructureTreeRoot();

    // Assert
    assertEquals("StructTreeRoot", actualPdStructureTreeRoot.getType());
    assertNull(actualPdStructureTreeRoot.getK());
    COSDictionary cOSObject = actualPdStructureTreeRoot.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdStructureTreeRoot.getIDTree());
    assertNull(actualPdStructureTreeRoot.getParentTree());
    assertEquals(-1, actualPdStructureTreeRoot.getParentTreeNextKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(actualPdStructureTreeRoot.getKids().isEmpty());
    assertTrue(actualPdStructureTreeRoot.getClassMap().isEmpty());
    assertTrue(actualPdStructureTreeRoot.getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#getK()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  @DisplayName("Test getK(); given PDStructureTreeRoot(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDStructureTreeRoot.getK()"})
  void testGetK_givenPDStructureTreeRoot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureTreeRoot().getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#getK()}.
   *
   * <ul>
   *   <li>Then return {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  @DisplayName("Test getK(); then return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDStructureTreeRoot.getK()"})
  void testGetK_thenReturnCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(structureElement);

    // Act and Assert
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setK(COSBase)"})
  void testSetK_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary k = new COSDictionary();
    k.setKey(new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult).getParent());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(k, ((PDStructureElement) getResult).getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setK(COSBase); given PDStructureTreeRoot(); when FALSE; then PDStructureTreeRoot() K is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setK(COSBase)"})
  void testSetK_givenPDStructureTreeRoot_whenFalse_thenPDStructureTreeRootKIsFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setK(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(COSBoolean.FALSE, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); when COSArray(); then PDStructureTreeRoot() K is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setK(COSBase)"})
  void testSetK_whenCOSArray_thenPDStructureTreeRootKIsCOSArray() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSArray k = new COSArray();

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setK(COSBase); when COSDictionary(); then PDStructureTreeRoot() Kids size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setK(COSBase)"})
  void testSetK_whenCOSDictionary_thenPDStructureTreeRootKidsSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary k = new COSDictionary();

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult).getParent());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(k, ((PDStructureElement) getResult).getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setK(COSBase)"})
  void testSetK_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObject k = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setK(COSBase); when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setK(COSBase)"})
  void testSetK_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setK(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#getIDTree()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#getIDTree()}
   */
  @Test
  @DisplayName("Test getIDTree(); given PDStructureTreeRoot(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNameTreeNode PDStructureTreeRoot.getIDTree()"})
  void testGetIDTree_givenPDStructureTreeRoot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureTreeRoot().getIDTree());
  }

  /**
   * Test {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setIDTree(PDNameTreeNode); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setIDTree(PDNameTreeNode)"})
  void testSetIDTree_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.setIDTree(new PDStructureElementNameTreeNode(dic));

    // Assert
    PDNameTreeNode<PDStructureElement> iDTree = pdStructureTreeRoot.getIDTree();
    assertTrue(iDTree instanceof PDStructureElementNameTreeNode);
    assertNull(iDTree.getLowerLimit());
    assertNull(iDTree.getUpperLimit());
    assertNull(iDTree.getKids());
    assertNull(iDTree.getNames());
    assertNull(iDTree.getParent());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(iDTree.isRootNode());
    assertSame(dic, iDTree.getCOSObject());
  }

  /**
   * Test {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setIDTree(PDNameTreeNode); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setIDTree(PDNameTreeNode)"})
  void testSetIDTree_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);

    // Act
    pdStructureTreeRoot.setIDTree(new PDStructureElementNameTreeNode(dic));

    // Assert
    PDNameTreeNode<PDStructureElement> iDTree = pdStructureTreeRoot.getIDTree();
    assertTrue(iDTree instanceof PDStructureElementNameTreeNode);
    assertNull(iDTree.getLowerLimit());
    assertNull(iDTree.getUpperLimit());
    assertNull(iDTree.getKids());
    assertNull(iDTree.getNames());
    assertNull(iDTree.getParent());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(iDTree.isRootNode());
    assertSame(dic, iDTree.getCOSObject());
  }

  /**
   * Test {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setIDTree(PDNameTreeNode); when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setIDTree(PDNameTreeNode)"})
  void testSetIDTree_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setIDTree(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>When {@link PDStructureElementNameTreeNode#PDStructureElementNameTreeNode()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test setIDTree(PDNameTreeNode); when PDStructureElementNameTreeNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setIDTree(PDNameTreeNode)"})
  void testSetIDTree_whenPDStructureElementNameTreeNode() throws IOException {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setIDTree(new PDStructureElementNameTreeNode());

    // Assert
    PDNameTreeNode<PDStructureElement> iDTree = pdStructureTreeRoot.getIDTree();
    assertTrue(iDTree instanceof PDStructureElementNameTreeNode);
    assertNull(iDTree.getLowerLimit());
    assertNull(iDTree.getUpperLimit());
    assertNull(iDTree.getKids());
    assertNull(iDTree.getNames());
    assertNull(iDTree.getParent());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(iDTree.isRootNode());
  }

  /**
   * Test {@link PDStructureTreeRoot#getParentTree()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#getParentTree()}
   */
  @Test
  @DisplayName("Test getParentTree(); given PDStructureTreeRoot(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNumberTreeNode PDStructureTreeRoot.getParentTree()"})
  void testGetParentTree_givenPDStructureTreeRoot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureTreeRoot().getParentTree());
  }

  /**
   * Test {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ParentTree COSObject is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setParentTree(PDNumberTreeNode); then PDStructureTreeRoot() ParentTree COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setParentTree(PDNumberTreeNode)"})
  void testSetParentTree_thenPDStructureTreeRootParentTreeCOSObjectIsCOSDictionary()
      throws IOException {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    pdStructureTreeRoot.setParentTree(new PDNumberTreeNode(dict, valueClass));

    // Assert
    PDNumberTreeNode parentTree = pdStructureTreeRoot.getParentTree();
    assertNull(parentTree.getLowerLimit());
    assertNull(parentTree.getUpperLimit());
    assertNull(parentTree.getKids());
    assertNull(parentTree.getNumbers());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(dict, parentTree.getCOSObject());
  }

  /**
   * Test {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ParentTree LowerLimit is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setParentTree(PDNumberTreeNode); then PDStructureTreeRoot() ParentTree LowerLimit is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setParentTree(PDNumberTreeNode)"})
  void testSetParentTree_thenPDStructureTreeRootParentTreeLowerLimitIsNull() throws IOException {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    pdStructureTreeRoot.setParentTree(new PDNumberTreeNode(valueClass));

    // Assert
    PDNumberTreeNode parentTree = pdStructureTreeRoot.getParentTree();
    assertNull(parentTree.getLowerLimit());
    assertNull(parentTree.getUpperLimit());
    assertNull(parentTree.getKids());
    assertNull(parentTree.getNumbers());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setParentTree(PDNumberTreeNode); when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setParentTree(PDNumberTreeNode)"})
  void testSetParentTree_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setParentTree(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureTreeRoot#getParentTreeNextKey()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#getParentTreeNextKey()}
   */
  @Test
  @DisplayName("Test getParentTreeNextKey(); given PDStructureTreeRoot(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDStructureTreeRoot.getParentTreeNextKey()"})
  void testGetParentTreeNextKey_givenPDStructureTreeRoot_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDStructureTreeRoot().getParentTreeNextKey());
  }

  /**
   * Test {@link PDStructureTreeRoot#setParentTreeNextKey(int)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ParentTreeNextKey is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  @DisplayName(
      "Test setParentTreeNextKey(int); then PDStructureTreeRoot() ParentTreeNextKey is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setParentTreeNextKey(int)"})
  void testSetParentTreeNextKey_thenPDStructureTreeRootParentTreeNextKeyIsMin_value() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setParentTreeNextKey(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdStructureTreeRoot.getParentTreeNextKey());
  }

  /**
   * Test {@link PDStructureTreeRoot#setParentTreeNextKey(int)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ParentTreeNextKey is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  @DisplayName(
      "Test setParentTreeNextKey(int); then PDStructureTreeRoot() ParentTreeNextKey is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setParentTreeNextKey(int)"})
  void testSetParentTreeNextKey_thenPDStructureTreeRootParentTreeNextKeyIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setParentTreeNextKey(1);

    // Assert
    assertEquals(1, pdStructureTreeRoot.getParentTreeNextKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureTreeRoot#getRoleMap()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#getRoleMap()}
   */
  @Test
  @DisplayName("Test getRoleMap(); given PDStructureTreeRoot(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDStructureTreeRoot.getRoleMap()"})
  void testGetRoleMap_givenPDStructureTreeRoot_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDStructureTreeRoot().getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setRoleMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} RoleMap size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  @DisplayName(
      "Test setRoleMap(Map); given '42'; when HashMap() '42' is '42'; then PDStructureTreeRoot() RoleMap size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setRoleMap(Map)"})
  void testSetRoleMap_given42_whenHashMap42Is42_thenPDStructureTreeRootRoleMapSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, String> roleMap = new HashMap<>();
    roleMap.put("42", "42");
    roleMap.put("foo", "foo");

    // Act
    pdStructureTreeRoot.setRoleMap(roleMap);

    // Assert
    Map<String, Object> roleMap2 = pdStructureTreeRoot.getRoleMap();
    assertEquals(2, roleMap2.size());
    assertEquals("42", roleMap2.get("42"));
    assertEquals("foo", roleMap2.get("foo"));
  }

  /**
   * Test {@link PDStructureTreeRoot#setRoleMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} RoleMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  @DisplayName("Test setRoleMap(Map); given 'foo'; then PDStructureTreeRoot() RoleMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setRoleMap(Map)"})
  void testSetRoleMap_givenFoo_thenPDStructureTreeRootRoleMapSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, String> roleMap = new HashMap<>();
    roleMap.put("foo", "foo");

    // Act
    pdStructureTreeRoot.setRoleMap(roleMap);

    // Assert
    Map<String, Object> roleMap2 = pdStructureTreeRoot.getRoleMap();
    assertEquals(1, roleMap2.size());
    assertEquals("foo", roleMap2.get("foo"));
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureTreeRoot#setRoleMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} RoleMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  @DisplayName("Test setRoleMap(Map); when HashMap(); then PDStructureTreeRoot() RoleMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setRoleMap(Map)"})
  void testSetRoleMap_whenHashMap_thenPDStructureTreeRootRoleMapEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setRoleMap(new HashMap<>());

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#getClassMap()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#getClassMap()}
   */
  @Test
  @DisplayName("Test getClassMap(); given PDStructureTreeRoot(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDStructureTreeRoot.getClassMap()"})
  void testGetClassMap_givenPDStructureTreeRoot_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDStructureTreeRoot().getClassMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName("Test setClassMap(Map); given '42'; when HashMap() '42' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setClassMap(Map)"})
  void testSetClassMap_given42_whenHashMap42Is42() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("42", "42");
    classMap.put("foo", "42");

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName("Test setClassMap(Map); given '42'; when HashMap() 'foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setClassMap(Map)"})
  void testSetClassMap_given42_whenHashMapFooIs42() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("foo", "42");

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ClassMap {@code foo} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName(
      "Test setClassMap(Map); given ArrayList(); then PDStructureTreeRoot() ClassMap 'foo' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setClassMap(Map)"})
  void testSetClassMap_givenArrayList_thenPDStructureTreeRootClassMapFooIsArrayList() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, Object> classMap = new HashMap<>();
    ArrayList<Object> objectList = new ArrayList<>();
    classMap.put("foo", objectList);

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    Map<String, Object> classMap2 = pdStructureTreeRoot.getClassMap();
    assertEquals(1, classMap2.size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(objectList, classMap2.get("foo"));
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ClassMap {@code foo} {@link
   *       PDDefaultAttributeObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName(
      "Test setClassMap(Map); then PDStructureTreeRoot() ClassMap 'foo' PDDefaultAttributeObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setClassMap(Map)"})
  void testSetClassMap_thenPDStructureTreeRootClassMapFooPDDefaultAttributeObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, Object> classMap = new HashMap<>();
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    classMap.put("foo", pdDefaultAttributeObject);

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    Map<String, Object> classMap2 = pdStructureTreeRoot.getClassMap();
    assertEquals(1, classMap2.size());
    Object getResult = classMap2.get("foo");
    assertTrue(getResult instanceof PDDefaultAttributeObject);
    assertEquals(pdDefaultAttributeObject, getResult);
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName(
      "Test setClassMap(Map); when HashMap(); then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setClassMap(Map)"})
  void testSetClassMap_whenHashMap_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setClassMap(new HashMap<>());

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName(
      "Test setClassMap(Map); when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureTreeRoot.setClassMap(Map)"})
  void testSetClassMap_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setClassMap(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }
}
