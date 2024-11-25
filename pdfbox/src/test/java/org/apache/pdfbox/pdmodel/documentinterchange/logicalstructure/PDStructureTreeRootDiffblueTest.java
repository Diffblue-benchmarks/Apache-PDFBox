package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDStructureElementNameTreeNode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDStructureTreeRootDiffblueTest {
  /**
   * Test {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDStructureTreeRoot(COSDictionary)")
  void testNewPDStructureTreeRoot() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDStructureTreeRoot(dic)).getCOSObject());
  }

  /**
   * Test {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   * <p>
   * Method under test: {@link PDStructureTreeRoot#PDStructureTreeRoot()}
   */
  @Test
  @DisplayName("Test new PDStructureTreeRoot()")
  void testNewPDStructureTreeRoot2() {
    // Arrange and Act
    PDStructureTreeRoot actualPdStructureTreeRoot = new PDStructureTreeRoot();

    // Assert
    assertEquals("StructTreeRoot", actualPdStructureTreeRoot.getType());
    assertNull(actualPdStructureTreeRoot.getK());
    COSDictionary cOSObject = actualPdStructureTreeRoot.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStructureTreeRoot.getIDTree());
    assertNull(actualPdStructureTreeRoot.getParentTree());
    assertEquals(-1, actualPdStructureTreeRoot.getParentTreeNextKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdStructureTreeRoot.getKids().isEmpty());
    assertTrue(actualPdStructureTreeRoot.getClassMap().isEmpty());
    assertTrue(actualPdStructureTreeRoot.getRoleMap().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#getK()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  @DisplayName("Test getK(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  void testGetK_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualK = pdStructureTreeRoot.getK();

    // Assert
    assertSame(((COSBoolean) actualK).FALSE, actualK);
  }

  /**
   * Test {@link PDStructureTreeRoot#getK()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  @DisplayName("Test getK(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetK_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot(new COSDictionary())).getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#getK()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  @DisplayName("Test getK(); given PDStructureTreeRoot(); then return 'null'")
  void testGetK_givenPDStructureTreeRoot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
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
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(k, ((PDStructureElement) getResult).getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); when COSArray(); then PDStructureTreeRoot() K is COSArray()")
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); when COSDictionary(); then PDStructureTreeRoot() Kids size is one")
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
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(k, ((PDStructureElement) getResult).getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  void testSetK_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setK(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); when FALSE; then PDStructureTreeRoot() K is FALSE FALSE")
  void testSetK_whenFalse_thenPDStructureTreeRootKIsFalseFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSBoolean k = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSBoolean expectedK = k.FALSE;
    assertSame(expectedK, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureTreeRoot#setK(COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  @DisplayName("Test setK(COSBase); when 'null'; then PDStructureTreeRoot() K is 'null'")
  void testSetK_whenNull_thenPDStructureTreeRootKIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setK(null);

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#getIDTree()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getIDTree()}
   */
  @Test
  @DisplayName("Test getIDTree(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetIDTree_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot(new COSDictionary())).getIDTree());
  }

  /**
   * Test {@link PDStructureTreeRoot#getIDTree()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getIDTree()}
   */
  @Test
  @DisplayName("Test getIDTree(); given PDStructureTreeRoot(); then return 'null'")
  void testGetIDTree_givenPDStructureTreeRoot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).getIDTree());
  }

  /**
   * Test {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} IDTree
   * {@link PDStructureElementNameTreeNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test setIDTree(PDNameTreeNode); then PDStructureTreeRoot() IDTree PDStructureElementNameTreeNode")
  void testSetIDTree_thenPDStructureTreeRootIDTreePDStructureElementNameTreeNode() throws IOException {
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
   * Test {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} IDTree is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test setIDTree(PDNameTreeNode); when 'null'; then PDStructureTreeRoot() IDTree is 'null'")
  void testSetIDTree_whenNull_thenPDStructureTreeRootIDTreeIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setIDTree(null);

    // Assert
    assertNull(pdStructureTreeRoot.getIDTree());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureTreeRoot#getParentTree()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getParentTree()}
   */
  @Test
  @DisplayName("Test getParentTree(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetParentTree_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot(new COSDictionary())).getParentTree());
  }

  /**
   * Test {@link PDStructureTreeRoot#getParentTree()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getParentTree()}
   */
  @Test
  @DisplayName("Test getParentTree(); given PDStructureTreeRoot(); then return 'null'")
  void testGetParentTree_givenPDStructureTreeRoot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).getParentTree());
  }

  /**
   * Test {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ParentTree
   * LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test setParentTree(PDNumberTreeNode); then PDStructureTreeRoot() ParentTree LowerLimit is 'null'")
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  @DisplayName("Test setParentTree(PDNumberTreeNode); when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  void testSetParentTree_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setParentTree(null);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureTreeRoot#getParentTreeNextKey()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getParentTreeNextKey()}
   */
  @Test
  @DisplayName("Test getParentTreeNextKey(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary()")
  void testGetParentTreeNextKey_givenPDStructureTreeRootWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDStructureTreeRoot(new COSDictionary())).getParentTreeNextKey());
  }

  /**
   * Test {@link PDStructureTreeRoot#getParentTreeNextKey()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getParentTreeNextKey()}
   */
  @Test
  @DisplayName("Test getParentTreeNextKey(); given PDStructureTreeRoot(); then return minus one")
  void testGetParentTreeNextKey_givenPDStructureTreeRoot_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDStructureTreeRoot()).getParentTreeNextKey());
  }

  /**
   * Test {@link PDStructureTreeRoot#setParentTreeNextKey(int)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ParentTreeNextKey
   * is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  @DisplayName("Test setParentTreeNextKey(int); then PDStructureTreeRoot() ParentTreeNextKey is MIN_VALUE")
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
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ParentTreeNextKey
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  @DisplayName("Test setParentTreeNextKey(int); then PDStructureTreeRoot() ParentTreeNextKey is one")
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
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getRoleMap()}
   */
  @Test
  @DisplayName("Test getRoleMap(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return Empty")
  void testGetRoleMap_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot(new COSDictionary())).getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#getRoleMap()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getRoleMap()}
   */
  @Test
  @DisplayName("Test getRoleMap(); given PDStructureTreeRoot(); then return Empty")
  void testGetRoleMap_givenPDStructureTreeRoot_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot()).getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setRoleMap(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} RoleMap size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  @DisplayName("Test setRoleMap(Map); given '42'; when HashMap() '42' is '42'; then PDStructureTreeRoot() RoleMap size is two")
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
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} RoleMap size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  @DisplayName("Test setRoleMap(Map); given 'foo'; then PDStructureTreeRoot() RoleMap size is one")
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} RoleMap
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  @DisplayName("Test setRoleMap(Map); when HashMap(); then PDStructureTreeRoot() RoleMap Empty")
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
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getClassMap()}
   */
  @Test
  @DisplayName("Test getClassMap(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return Empty")
  void testGetClassMap_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot(new COSDictionary())).getClassMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#getClassMap()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#getClassMap()}
   */
  @Test
  @DisplayName("Test getClassMap(); given PDStructureTreeRoot(); then return Empty")
  void testGetClassMap_givenPDStructureTreeRoot_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot()).getClassMap().isEmpty());
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ClassMap
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName("Test setClassMap(Map); given '42'; when HashMap() '42' is '42'; then PDStructureTreeRoot() ClassMap Empty")
  void testSetClassMap_given42_whenHashMap42Is42_thenPDStructureTreeRootClassMapEmpty() {
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} ClassMap
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName("Test setClassMap(Map); given '42'; when HashMap() 'foo' is '42'; then PDStructureTreeRoot() ClassMap Empty")
  void testSetClassMap_given42_whenHashMapFooIs42_thenPDStructureTreeRootClassMapEmpty() {
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName("Test setClassMap(Map); when HashMap() 'foo' is ArrayList()")
  void testSetClassMap_whenHashMapFooIsArrayList() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("foo", new ArrayList<>());

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(classMap, pdStructureTreeRoot.getClassMap());
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is
   * {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName("Test setClassMap(Map); when HashMap() 'foo' is PDDefaultAttributeObject()")
  void testSetClassMap_whenHashMapFooIsPDDefaultAttributeObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("foo", new PDDefaultAttributeObject());

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(classMap, pdStructureTreeRoot.getClassMap());
  }

  /**
   * Test {@link PDStructureTreeRoot#setClassMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  @DisplayName("Test setClassMap(Map); when HashMap(); then PDStructureTreeRoot() COSObject Values size is one")
  void testSetClassMap_whenHashMap_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setClassMap(new HashMap<>());

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }
}
