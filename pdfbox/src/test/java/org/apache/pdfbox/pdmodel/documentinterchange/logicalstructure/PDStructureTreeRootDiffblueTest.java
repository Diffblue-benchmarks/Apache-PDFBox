package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;

class PDStructureTreeRootDiffblueTest {
  /**
   * Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  void testGetK() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).getK());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  void testGetK2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    COSBase actualK = pdStructureTreeRoot.getK();

    // Assert
    verify(objectable).getCOSObject();
    assertSame(((COSBoolean) actualK).FALSE, actualK);
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getK()}
   */
  @Test
  void testGetK3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    COSBase actualK = pdStructureTreeRoot.getK();

    // Assert
    verify(objectable).getCOSObject();
    assertSame(((COSBoolean) actualK).FALSE, actualK);
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  void testSetK() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSBoolean k = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    COSBoolean expectedK = k.FALSE;
    assertSame(expectedK, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  void testSetK2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSBoolean k = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    COSBoolean expectedK = k.FALSE;
    assertSame(expectedK, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  void testSetK3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary k = new COSDictionary();

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    verify(objectable).getCOSObject();
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
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(k, ((PDStructureElement) getResult).getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  void testSetK4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSArray k = new COSArray();

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  void testSetK5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setK(null);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  void testSetK6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setK(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setK(COSBase)}
   */
  @Test
  void testSetK7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    COSDictionary k = new COSDictionary();
    k.setKey(new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.setK(k);

    // Assert
    verify(objectable).getCOSObject();
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
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(k, ((PDStructureElement) getResult).getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getIDTree()}
   */
  @Test
  void testGetIDTree() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).getIDTree());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getIDTree()}
   */
  @Test
  void testGetIDTree2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    PDNameTreeNode<PDStructureElement> actualIDTree = pdStructureTreeRoot.getIDTree();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualIDTree);
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  void testSetIDTree() throws IOException {
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
   * Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  void testSetIDTree2() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setIDTree(new PDStructureElementNameTreeNode());

    // Assert
    verify(objectable).getCOSObject();
    PDNameTreeNode<PDStructureElement> iDTree = pdStructureTreeRoot.getIDTree();
    assertTrue(iDTree instanceof PDStructureElementNameTreeNode);
    assertNull(iDTree.getLowerLimit());
    assertNull(iDTree.getUpperLimit());
    assertNull(iDTree.getKids());
    assertNull(iDTree.getNames());
    assertNull(iDTree.getParent());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(iDTree.isRootNode());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setIDTree(PDNameTreeNode)}
   */
  @Test
  void testSetIDTree3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setIDTree(null);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureTreeRoot.getIDTree());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getParentTree()}
   */
  @Test
  void testGetParentTree() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).getParentTree());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getParentTree()}
   */
  @Test
  void testGetParentTree2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    PDNumberTreeNode actualParentTree = pdStructureTreeRoot.getParentTree();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualParentTree);
  }

  /**
   * Method under test:
   * {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  void testSetParentTree() throws IOException {
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
   * Method under test:
   * {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  void testSetParentTree2() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    pdStructureTreeRoot.setParentTree(new PDNumberTreeNode(valueClass));

    // Assert
    verify(objectable).getCOSObject();
    PDNumberTreeNode parentTree = pdStructureTreeRoot.getParentTree();
    assertNull(parentTree.getLowerLimit());
    assertNull(parentTree.getUpperLimit());
    assertNull(parentTree.getKids());
    assertNull(parentTree.getNumbers());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDStructureTreeRoot#setParentTree(PDNumberTreeNode)}
   */
  @Test
  void testSetParentTree3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setParentTree(null);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureTreeRoot.getParentTree());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getParentTreeNextKey()}
   */
  @Test
  void testGetParentTreeNextKey() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDStructureTreeRoot()).getParentTreeNextKey());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getParentTreeNextKey()}
   */
  @Test
  void testGetParentTreeNextKey2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    int actualParentTreeNextKey = pdStructureTreeRoot.getParentTreeNextKey();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(-1, actualParentTreeNextKey);
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  void testSetParentTreeNextKey() {
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
   * Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  void testSetParentTreeNextKey2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setParentTreeNextKey(1);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureTreeRoot.getParentTreeNextKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  void testSetParentTreeNextKey3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setParentTreeNextKey(-100);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(-100, pdStructureTreeRoot.getParentTreeNextKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setParentTreeNextKey(int)}
   */
  @Test
  void testSetParentTreeNextKey4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setParentTreeNextKey(Integer.MIN_VALUE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdStructureTreeRoot.getParentTreeNextKey());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getRoleMap()}
   */
  @Test
  void testGetRoleMap() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot()).getRoleMap().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getRoleMap()}
   */
  @Test
  void testGetRoleMap2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    Map<String, Object> actualRoleMap = pdStructureTreeRoot.getRoleMap();

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(actualRoleMap.isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  void testSetRoleMap() {
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
   * Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  void testSetRoleMap2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setRoleMap(new HashMap<>());

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getRoleMap().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  void testSetRoleMap3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    HashMap<String, String> roleMap = new HashMap<>();
    roleMap.put("foo", "foo");

    // Act
    pdStructureTreeRoot.setRoleMap(roleMap);

    // Assert
    verify(objectable).getCOSObject();
    Map<String, Object> roleMap2 = pdStructureTreeRoot.getRoleMap();
    assertEquals(1, roleMap2.size());
    assertEquals("foo", roleMap2.get("foo"));
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setRoleMap(Map)}
   */
  @Test
  void testSetRoleMap4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    HashMap<String, String> roleMap = new HashMap<>();
    roleMap.put("42", "42");
    roleMap.put("foo", "foo");

    // Act
    pdStructureTreeRoot.setRoleMap(roleMap);

    // Assert
    verify(objectable).getCOSObject();
    Map<String, Object> roleMap2 = pdStructureTreeRoot.getRoleMap();
    assertEquals(2, roleMap2.size());
    assertEquals("42", roleMap2.get("42"));
    assertEquals("foo", roleMap2.get("foo"));
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getClassMap()}
   */
  @Test
  void testGetClassMap() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot()).getClassMap().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#getClassMap()}
   */
  @Test
  void testGetClassMap2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    Map<String, Object> actualClassMap = pdStructureTreeRoot.getClassMap();

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(actualClassMap.isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  void testSetClassMap() {
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

  /**
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  void testSetClassMap2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setClassMap(new HashMap<>());

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  void testSetClassMap3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("foo", "42");

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  void testSetClassMap4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("42", "42");
    classMap.put("foo", "42");

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  void testSetClassMap5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("42", "42");
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    classMap.put("foo", pdDefaultAttributeObject);

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    verify(objectable).getCOSObject();
    Map<String, Object> classMap2 = pdStructureTreeRoot.getClassMap();
    assertEquals(1, classMap2.size());
    Object getResult = classMap2.get("foo");
    assertTrue(getResult instanceof PDDefaultAttributeObject);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(pdDefaultAttributeObject, getResult);
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#setClassMap(Map)}
   */
  @Test
  void testSetClassMap6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    HashMap<String, Object> classMap = new HashMap<>();
    classMap.put("42", "42");
    classMap.put("foo", new ArrayList<>());

    // Act
    pdStructureTreeRoot.setClassMap(classMap);

    // Assert
    verify(objectable).getCOSObject();
    Map<String, Object> classMap2 = pdStructureTreeRoot.getClassMap();
    assertEquals(1, classMap2.size());
    Object getResult = classMap2.get("foo");
    assertTrue(getResult instanceof List);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)}
   */
  @Test
  void testNewPDStructureTreeRoot() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDStructureTreeRoot(dic)).getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureTreeRoot#PDStructureTreeRoot()}
   */
  @Test
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
}
