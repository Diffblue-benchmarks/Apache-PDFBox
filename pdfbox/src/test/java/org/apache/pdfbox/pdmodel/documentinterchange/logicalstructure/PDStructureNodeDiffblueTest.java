package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.junit.jupiter.api.Test;

class PDStructureNodeDiffblueTest {
  /**
   * Method under test: {@link PDStructureNode#create(COSDictionary)}
   */
  @Test
  void testCreate() {
    // Arrange
    COSDictionary node = new COSDictionary();

    // Act
    PDStructureNode actualCreateResult = PDStructureNode.create(node);

    // Assert
    assertTrue(actualCreateResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) actualCreateResult).getActualText());
    assertNull(((PDStructureElement) actualCreateResult).getAlternateDescription());
    assertNull(((PDStructureElement) actualCreateResult).getElementIdentifier());
    assertNull(((PDStructureElement) actualCreateResult).getExpandedForm());
    assertNull(((PDStructureElement) actualCreateResult).getLanguage());
    assertNull(((PDStructureElement) actualCreateResult).getStandardStructureType());
    assertNull(((PDStructureElement) actualCreateResult).getStructureType());
    assertNull(((PDStructureElement) actualCreateResult).getTitle());
    assertNull(actualCreateResult.getType());
    assertNull(((PDStructureElement) actualCreateResult).getPage());
    assertNull(((PDStructureElement) actualCreateResult).getParent());
    assertEquals(0, ((PDStructureElement) actualCreateResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) actualCreateResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) actualCreateResult).getClassNames().size());
    assertTrue(actualCreateResult.getKids().isEmpty());
    assertSame(node, actualCreateResult.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDStructureTreeRoot()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    COSDictionary actualCOSObject = pdStructureTreeRoot.getCOSObject();

    // Assert
    verify(objectable).getCOSObject();
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("StructTreeRoot", (new PDStructureTreeRoot()).getType());
    assertNull((new PDStructureTreeRoot(new COSDictionary())).getType());
  }

  /**
   * Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  void testGetType2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    String actualType = pdStructureTreeRoot.getType();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("StructTreeRoot", actualType);
  }

  /**
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  void testGetKids() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot()).getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  void testGetKids2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    assertEquals(1, actualKids.size());
    Object getResult = actualKids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    COSDictionary cOSObject = parent.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  void testGetKids3() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic2));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    assertEquals(2, actualKids.size());
    Object getResult = actualKids.get(0);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    COSBase k = ((PDStructureTreeRoot) parent).getK();
    assertTrue(k instanceof COSArray);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = actualKids.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    COSDictionary cOSObject = parent.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(2, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, toListResult.get(0));
    assertSame(dic2, toListResult.get(1));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(cOSObject, parent2.getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setKids(new ArrayList<>());

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) k).toList().isEmpty());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.setKids(new ArrayList<>());

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) k).toList().isEmpty());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    kids.add("42");

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertEquals(getResult, getResult2);
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    COSDictionary cosDictionary = new COSDictionary();
    kids.add(cosDictionary);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(getResult.getKey());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult2).getParent());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertSame(cosDictionary, toListResult.get(1));
    assertSame(cosDictionary, ((PDStructureElement) getResult2).getCOSObject());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    COSArray cosArray = new COSArray();
    kids.add(cosArray);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(cosArray, toListResult.get(1));
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    kids.add(null);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSNull);
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSString);
    assertEquals("3432", ((COSString) getResult2).toHexString());
    assertEquals("42", ((COSString) getResult2).getASCII());
    assertEquals("42", ((COSString) getResult2).getString());
    assertNull(getResult2.getKey());
    assertNull(getResult.getKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult2).getForceHexForm());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult2).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    kids.add(-1);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSString);
    assertEquals("3432", ((COSString) getResult2).toHexString());
    assertEquals("42", ((COSString) getResult2).getASCII());
    assertEquals("42", ((COSString) getResult2).getString());
    assertNull(getResult2.getKey());
    assertNull(getResult.getKey());
    assertEquals(1, pdStructureTreeRoot.getKids().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult2).getForceHexForm());
    assertTrue(((COSInteger) getResult).isValid());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult2).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    kids.add(Integer.MIN_VALUE);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSString);
    assertEquals("3432", ((COSString) getResult2).toHexString());
    assertEquals("42", ((COSString) getResult2).getASCII());
    assertEquals("42", ((COSString) getResult2).getString());
    assertNull(getResult2.getKey());
    assertNull(getResult.getKey());
    assertEquals(1, pdStructureTreeRoot.getKids().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult2).getForceHexForm());
    assertTrue(((COSInteger) getResult).isValid());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult2).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  void testSetKids10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    kids.add(cosObject);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(cosObject, toListResult.get(1));
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  void testAppendKid() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    COSBoolean expectedK = object.FALSE;
    assertSame(expectedK, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  void testAppendKid2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertEquals(2, cOSObject.size());
    assertSame(dic, toListResult.get(0));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(object.FALSE, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  void testAppendKid3() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic2));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    Object getResult3 = kids.get(1);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult4 = kids2.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    Object getResult5 = kids2.get(1);
    assertTrue(getResult5 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult6 = kids3.get(0);
    assertTrue(getResult6 instanceof PDStructureElement);
    Object getResult7 = kids3.get(1);
    assertTrue(getResult7 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult5).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult7).getParent() instanceof PDStructureTreeRoot);
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult5).getActualText());
    assertNull(((PDStructureElement) getResult7).getActualText());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult5).getAlternateDescription());
    assertNull(((PDStructureElement) getResult7).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult5).getElementIdentifier());
    assertNull(((PDStructureElement) getResult7).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult5).getExpandedForm());
    assertNull(((PDStructureElement) getResult7).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult5).getLanguage());
    assertNull(((PDStructureElement) getResult7).getLanguage());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult5).getStandardStructureType());
    assertNull(((PDStructureElement) getResult7).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult5).getStructureType());
    assertNull(((PDStructureElement) getResult7).getStructureType());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult5).getTitle());
    assertNull(((PDStructureElement) getResult7).getTitle());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult5).getType());
    assertNull(((PDStructureElement) getResult7).getType());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult5).getPage());
    assertNull(((PDStructureElement) getResult7).getPage());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult7).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult5).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult5).getClassNames().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult5).getKids().isEmpty());
    assertSame(dic, toListResult.get(0));
    assertSame(dic2, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult7).getCOSObject());
    assertSame(object.FALSE, toListResult.get(2));
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  void testAppendKid4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult4 = kids3.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(dic, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    COSBoolean cosBoolean = object.FALSE;
    assertSame(cosBoolean, toListResult.get(0));
    assertSame(cosBoolean, toListResult.get(2));
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  void testAppendKid5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult4 = kids3.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(dic, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(object, toListResult.get(2));
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  void testAppendKid6() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    PDStructureElement structureElement = new PDStructureElement(dic);

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = structureElement.getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent3 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids4 = parent3.getKids();
    assertEquals(1, kids4.size());
    Object getResult4 = kids4.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(1, kids5.size());
    Object getResult5 = kids5.get(0);
    assertTrue(getResult5 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(1, kids6.size());
    assertTrue(kids6.get(0) instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult5).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertEquals("StructTreeRoot", parent3.getType());
    assertEquals("StructTreeRoot", parent4.getType());
    assertEquals("StructTreeRoot", parent5.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult4).getActualText());
    assertNull(((PDStructureElement) getResult5).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult4).getAlternateDescription());
    assertNull(((PDStructureElement) getResult5).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult4).getElementIdentifier());
    assertNull(((PDStructureElement) getResult5).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult4).getExpandedForm());
    assertNull(((PDStructureElement) getResult5).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult4).getLanguage());
    assertNull(((PDStructureElement) getResult5).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult4).getStandardStructureType());
    assertNull(((PDStructureElement) getResult5).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult4).getStructureType());
    assertNull(((PDStructureElement) getResult5).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult4).getTitle());
    assertNull(((PDStructureElement) getResult5).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult4).getType());
    assertNull(((PDStructureElement) getResult5).getType());
    COSDictionary cOSObject = parent.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult5).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent3).getIDTree());
    assertNull(((PDStructureTreeRoot) parent4).getIDTree());
    assertNull(((PDStructureTreeRoot) parent5).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertNull(((PDStructureTreeRoot) parent3).getParentTree());
    assertNull(((PDStructureTreeRoot) parent4).getParentTree());
    assertNull(((PDStructureTreeRoot) parent5).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent3).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent4).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent5).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult4).getClassNames().size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult4).getKids().isEmpty());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent5).getClassMap().isEmpty());
    assertTrue(pdStructureTreeRoot.getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent5).getRoleMap().isEmpty());
    assertSame(dic, structureElement.getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent3).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent4).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent5).getK());
    assertSame(cOSObject, pdStructureTreeRoot.getCOSObject());
    assertSame(cOSObject, parent2.getCOSObject());
    assertSame(cOSObject, parent3.getCOSObject());
    assertSame(cOSObject, parent4.getCOSObject());
    assertSame(cOSObject, parent5.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  void testAppendKid7() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    PDStructureElement structureElement = new PDStructureElement(dic2);

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    PDStructureNode parent = structureElement.getParent();
    COSBase k = ((PDStructureTreeRoot) parent).getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = kids.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    Object getResult4 = kids2.get(1);
    assertTrue(getResult4 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult5 = kids3.get(0);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids3.get(1);
    assertTrue(getResult6 instanceof PDStructureElement);
    PDStructureNode parent3 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids4 = parent3.getKids();
    assertEquals(2, kids4.size());
    Object getResult7 = kids4.get(0);
    assertTrue(getResult7 instanceof PDStructureElement);
    Object getResult8 = kids4.get(1);
    assertTrue(getResult8 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(2, kids5.size());
    Object getResult9 = kids5.get(0);
    assertTrue(getResult9 instanceof PDStructureElement);
    Object getResult10 = kids5.get(1);
    assertTrue(getResult10 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(2, kids6.size());
    Object getResult11 = kids6.get(0);
    assertTrue(getResult11 instanceof PDStructureElement);
    Object getResult12 = kids6.get(1);
    assertTrue(getResult12 instanceof PDStructureElement);
    PDStructureNode parent6 = ((PDStructureElement) getResult5).getParent();
    List<Object> kids7 = parent6.getKids();
    assertEquals(2, kids7.size());
    Object getResult13 = kids7.get(0);
    assertTrue(getResult13 instanceof PDStructureElement);
    Object getResult14 = kids7.get(1);
    assertTrue(getResult14 instanceof PDStructureElement);
    PDStructureNode parent7 = ((PDStructureElement) getResult6).getParent();
    List<Object> kids8 = parent7.getKids();
    assertEquals(2, kids8.size());
    Object getResult15 = kids8.get(0);
    assertTrue(getResult15 instanceof PDStructureElement);
    Object getResult16 = kids8.get(1);
    assertTrue(getResult16 instanceof PDStructureElement);
    PDStructureNode parent8 = ((PDStructureElement) getResult7).getParent();
    List<Object> kids9 = parent8.getKids();
    assertEquals(2, kids9.size());
    Object getResult17 = kids9.get(0);
    assertTrue(getResult17 instanceof PDStructureElement);
    Object getResult18 = kids9.get(1);
    assertTrue(getResult18 instanceof PDStructureElement);
    PDStructureNode parent9 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids10 = parent9.getKids();
    assertEquals(2, kids10.size());
    Object getResult19 = kids10.get(0);
    assertTrue(getResult19 instanceof PDStructureElement);
    Object getResult20 = kids10.get(1);
    assertTrue(getResult20 instanceof PDStructureElement);
    PDStructureNode parent10 = ((PDStructureElement) getResult9).getParent();
    List<Object> kids11 = parent10.getKids();
    assertEquals(2, kids11.size());
    assertTrue(kids11.get(0) instanceof PDStructureElement);
    assertTrue(kids11.get(1) instanceof PDStructureElement);
    PDStructureNode parent11 = ((PDStructureElement) getResult10).getParent();
    List<Object> kids12 = parent11.getKids();
    assertEquals(2, kids12.size());
    assertTrue(kids12.get(0) instanceof PDStructureElement);
    assertTrue(kids12.get(1) instanceof PDStructureElement);
    PDStructureNode parent12 = ((PDStructureElement) getResult11).getParent();
    List<Object> kids13 = parent12.getKids();
    assertEquals(2, kids13.size());
    assertTrue(kids13.get(0) instanceof PDStructureElement);
    assertTrue(kids13.get(1) instanceof PDStructureElement);
    PDStructureNode parent13 = ((PDStructureElement) getResult12).getParent();
    List<Object> kids14 = parent13.getKids();
    assertEquals(2, kids14.size());
    assertTrue(kids14.get(0) instanceof PDStructureElement);
    assertTrue(kids14.get(1) instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(parent6 instanceof PDStructureTreeRoot);
    assertTrue(parent7 instanceof PDStructureTreeRoot);
    assertTrue(parent8 instanceof PDStructureTreeRoot);
    assertTrue(parent9 instanceof PDStructureTreeRoot);
    assertTrue(parent10 instanceof PDStructureTreeRoot);
    assertTrue(parent11 instanceof PDStructureTreeRoot);
    assertTrue(parent12 instanceof PDStructureTreeRoot);
    assertTrue(parent13 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult13).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult14).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult15).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult16).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult17).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult18).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult19).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult20).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertEquals("StructTreeRoot", parent3.getType());
    assertEquals("StructTreeRoot", parent4.getType());
    assertEquals("StructTreeRoot", parent5.getType());
    assertEquals("StructTreeRoot", parent6.getType());
    assertEquals("StructTreeRoot", parent7.getType());
    assertEquals("StructTreeRoot", parent8.getType());
    assertEquals("StructTreeRoot", parent9.getType());
    assertEquals("StructTreeRoot", parent10.getType());
    assertEquals("StructTreeRoot", parent11.getType());
    assertEquals("StructTreeRoot", parent12.getType());
    assertEquals("StructTreeRoot", parent13.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult4).getActualText());
    assertNull(((PDStructureElement) getResult5).getActualText());
    assertNull(((PDStructureElement) getResult6).getActualText());
    assertNull(((PDStructureElement) getResult7).getActualText());
    assertNull(((PDStructureElement) getResult8).getActualText());
    assertNull(((PDStructureElement) getResult9).getActualText());
    assertNull(((PDStructureElement) getResult10).getActualText());
    assertNull(((PDStructureElement) getResult11).getActualText());
    assertNull(((PDStructureElement) getResult12).getActualText());
    assertNull(((PDStructureElement) getResult13).getActualText());
    assertNull(((PDStructureElement) getResult14).getActualText());
    assertNull(((PDStructureElement) getResult15).getActualText());
    assertNull(((PDStructureElement) getResult16).getActualText());
    assertNull(((PDStructureElement) getResult17).getActualText());
    assertNull(((PDStructureElement) getResult18).getActualText());
    assertNull(((PDStructureElement) getResult19).getActualText());
    assertNull(((PDStructureElement) getResult20).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult4).getAlternateDescription());
    assertNull(((PDStructureElement) getResult5).getAlternateDescription());
    assertNull(((PDStructureElement) getResult6).getAlternateDescription());
    assertNull(((PDStructureElement) getResult7).getAlternateDescription());
    assertNull(((PDStructureElement) getResult8).getAlternateDescription());
    assertNull(((PDStructureElement) getResult9).getAlternateDescription());
    assertNull(((PDStructureElement) getResult10).getAlternateDescription());
    assertNull(((PDStructureElement) getResult11).getAlternateDescription());
    assertNull(((PDStructureElement) getResult12).getAlternateDescription());
    assertNull(((PDStructureElement) getResult13).getAlternateDescription());
    assertNull(((PDStructureElement) getResult14).getAlternateDescription());
    assertNull(((PDStructureElement) getResult15).getAlternateDescription());
    assertNull(((PDStructureElement) getResult16).getAlternateDescription());
    assertNull(((PDStructureElement) getResult17).getAlternateDescription());
    assertNull(((PDStructureElement) getResult18).getAlternateDescription());
    assertNull(((PDStructureElement) getResult19).getAlternateDescription());
    assertNull(((PDStructureElement) getResult20).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult4).getElementIdentifier());
    assertNull(((PDStructureElement) getResult5).getElementIdentifier());
    assertNull(((PDStructureElement) getResult6).getElementIdentifier());
    assertNull(((PDStructureElement) getResult7).getElementIdentifier());
    assertNull(((PDStructureElement) getResult8).getElementIdentifier());
    assertNull(((PDStructureElement) getResult9).getElementIdentifier());
    assertNull(((PDStructureElement) getResult10).getElementIdentifier());
    assertNull(((PDStructureElement) getResult11).getElementIdentifier());
    assertNull(((PDStructureElement) getResult12).getElementIdentifier());
    assertNull(((PDStructureElement) getResult13).getElementIdentifier());
    assertNull(((PDStructureElement) getResult14).getElementIdentifier());
    assertNull(((PDStructureElement) getResult15).getElementIdentifier());
    assertNull(((PDStructureElement) getResult16).getElementIdentifier());
    assertNull(((PDStructureElement) getResult17).getElementIdentifier());
    assertNull(((PDStructureElement) getResult18).getElementIdentifier());
    assertNull(((PDStructureElement) getResult19).getElementIdentifier());
    assertNull(((PDStructureElement) getResult20).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult4).getExpandedForm());
    assertNull(((PDStructureElement) getResult5).getExpandedForm());
    assertNull(((PDStructureElement) getResult6).getExpandedForm());
    assertNull(((PDStructureElement) getResult7).getExpandedForm());
    assertNull(((PDStructureElement) getResult8).getExpandedForm());
    assertNull(((PDStructureElement) getResult9).getExpandedForm());
    assertNull(((PDStructureElement) getResult10).getExpandedForm());
    assertNull(((PDStructureElement) getResult11).getExpandedForm());
    assertNull(((PDStructureElement) getResult12).getExpandedForm());
    assertNull(((PDStructureElement) getResult13).getExpandedForm());
    assertNull(((PDStructureElement) getResult14).getExpandedForm());
    assertNull(((PDStructureElement) getResult15).getExpandedForm());
    assertNull(((PDStructureElement) getResult16).getExpandedForm());
    assertNull(((PDStructureElement) getResult17).getExpandedForm());
    assertNull(((PDStructureElement) getResult18).getExpandedForm());
    assertNull(((PDStructureElement) getResult19).getExpandedForm());
    assertNull(((PDStructureElement) getResult20).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult4).getLanguage());
    assertNull(((PDStructureElement) getResult5).getLanguage());
    assertNull(((PDStructureElement) getResult6).getLanguage());
    assertNull(((PDStructureElement) getResult7).getLanguage());
    assertNull(((PDStructureElement) getResult8).getLanguage());
    assertNull(((PDStructureElement) getResult9).getLanguage());
    assertNull(((PDStructureElement) getResult10).getLanguage());
    assertNull(((PDStructureElement) getResult11).getLanguage());
    assertNull(((PDStructureElement) getResult12).getLanguage());
    assertNull(((PDStructureElement) getResult13).getLanguage());
    assertNull(((PDStructureElement) getResult14).getLanguage());
    assertNull(((PDStructureElement) getResult15).getLanguage());
    assertNull(((PDStructureElement) getResult16).getLanguage());
    assertNull(((PDStructureElement) getResult17).getLanguage());
    assertNull(((PDStructureElement) getResult18).getLanguage());
    assertNull(((PDStructureElement) getResult19).getLanguage());
    assertNull(((PDStructureElement) getResult20).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult4).getStandardStructureType());
    assertNull(((PDStructureElement) getResult5).getStandardStructureType());
    assertNull(((PDStructureElement) getResult6).getStandardStructureType());
    assertNull(((PDStructureElement) getResult7).getStandardStructureType());
    assertNull(((PDStructureElement) getResult8).getStandardStructureType());
    assertNull(((PDStructureElement) getResult9).getStandardStructureType());
    assertNull(((PDStructureElement) getResult10).getStandardStructureType());
    assertNull(((PDStructureElement) getResult11).getStandardStructureType());
    assertNull(((PDStructureElement) getResult12).getStandardStructureType());
    assertNull(((PDStructureElement) getResult13).getStandardStructureType());
    assertNull(((PDStructureElement) getResult14).getStandardStructureType());
    assertNull(((PDStructureElement) getResult15).getStandardStructureType());
    assertNull(((PDStructureElement) getResult16).getStandardStructureType());
    assertNull(((PDStructureElement) getResult17).getStandardStructureType());
    assertNull(((PDStructureElement) getResult18).getStandardStructureType());
    assertNull(((PDStructureElement) getResult19).getStandardStructureType());
    assertNull(((PDStructureElement) getResult20).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult4).getStructureType());
    assertNull(((PDStructureElement) getResult5).getStructureType());
    assertNull(((PDStructureElement) getResult6).getStructureType());
    assertNull(((PDStructureElement) getResult7).getStructureType());
    assertNull(((PDStructureElement) getResult8).getStructureType());
    assertNull(((PDStructureElement) getResult9).getStructureType());
    assertNull(((PDStructureElement) getResult10).getStructureType());
    assertNull(((PDStructureElement) getResult11).getStructureType());
    assertNull(((PDStructureElement) getResult12).getStructureType());
    assertNull(((PDStructureElement) getResult13).getStructureType());
    assertNull(((PDStructureElement) getResult14).getStructureType());
    assertNull(((PDStructureElement) getResult15).getStructureType());
    assertNull(((PDStructureElement) getResult16).getStructureType());
    assertNull(((PDStructureElement) getResult17).getStructureType());
    assertNull(((PDStructureElement) getResult18).getStructureType());
    assertNull(((PDStructureElement) getResult19).getStructureType());
    assertNull(((PDStructureElement) getResult20).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult4).getTitle());
    assertNull(((PDStructureElement) getResult5).getTitle());
    assertNull(((PDStructureElement) getResult6).getTitle());
    assertNull(((PDStructureElement) getResult7).getTitle());
    assertNull(((PDStructureElement) getResult8).getTitle());
    assertNull(((PDStructureElement) getResult9).getTitle());
    assertNull(((PDStructureElement) getResult10).getTitle());
    assertNull(((PDStructureElement) getResult11).getTitle());
    assertNull(((PDStructureElement) getResult12).getTitle());
    assertNull(((PDStructureElement) getResult13).getTitle());
    assertNull(((PDStructureElement) getResult14).getTitle());
    assertNull(((PDStructureElement) getResult15).getTitle());
    assertNull(((PDStructureElement) getResult16).getTitle());
    assertNull(((PDStructureElement) getResult17).getTitle());
    assertNull(((PDStructureElement) getResult18).getTitle());
    assertNull(((PDStructureElement) getResult19).getTitle());
    assertNull(((PDStructureElement) getResult20).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult4).getType());
    assertNull(((PDStructureElement) getResult5).getType());
    assertNull(((PDStructureElement) getResult6).getType());
    assertNull(((PDStructureElement) getResult7).getType());
    assertNull(((PDStructureElement) getResult8).getType());
    assertNull(((PDStructureElement) getResult9).getType());
    assertNull(((PDStructureElement) getResult10).getType());
    assertNull(((PDStructureElement) getResult11).getType());
    assertNull(((PDStructureElement) getResult12).getType());
    assertNull(((PDStructureElement) getResult13).getType());
    assertNull(((PDStructureElement) getResult14).getType());
    assertNull(((PDStructureElement) getResult15).getType());
    assertNull(((PDStructureElement) getResult16).getType());
    assertNull(((PDStructureElement) getResult17).getType());
    assertNull(((PDStructureElement) getResult18).getType());
    assertNull(((PDStructureElement) getResult19).getType());
    assertNull(((PDStructureElement) getResult20).getType());
    COSDictionary cOSObject = parent.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult5).getPage());
    assertNull(((PDStructureElement) getResult6).getPage());
    assertNull(((PDStructureElement) getResult7).getPage());
    assertNull(((PDStructureElement) getResult8).getPage());
    assertNull(((PDStructureElement) getResult9).getPage());
    assertNull(((PDStructureElement) getResult10).getPage());
    assertNull(((PDStructureElement) getResult11).getPage());
    assertNull(((PDStructureElement) getResult12).getPage());
    assertNull(((PDStructureElement) getResult13).getPage());
    assertNull(((PDStructureElement) getResult14).getPage());
    assertNull(((PDStructureElement) getResult15).getPage());
    assertNull(((PDStructureElement) getResult16).getPage());
    assertNull(((PDStructureElement) getResult17).getPage());
    assertNull(((PDStructureElement) getResult18).getPage());
    assertNull(((PDStructureElement) getResult19).getPage());
    assertNull(((PDStructureElement) getResult20).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent3).getIDTree());
    assertNull(((PDStructureTreeRoot) parent4).getIDTree());
    assertNull(((PDStructureTreeRoot) parent5).getIDTree());
    assertNull(((PDStructureTreeRoot) parent6).getIDTree());
    assertNull(((PDStructureTreeRoot) parent7).getIDTree());
    assertNull(((PDStructureTreeRoot) parent8).getIDTree());
    assertNull(((PDStructureTreeRoot) parent9).getIDTree());
    assertNull(((PDStructureTreeRoot) parent10).getIDTree());
    assertNull(((PDStructureTreeRoot) parent11).getIDTree());
    assertNull(((PDStructureTreeRoot) parent12).getIDTree());
    assertNull(((PDStructureTreeRoot) parent13).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertNull(((PDStructureTreeRoot) parent3).getParentTree());
    assertNull(((PDStructureTreeRoot) parent4).getParentTree());
    assertNull(((PDStructureTreeRoot) parent5).getParentTree());
    assertNull(((PDStructureTreeRoot) parent6).getParentTree());
    assertNull(((PDStructureTreeRoot) parent7).getParentTree());
    assertNull(((PDStructureTreeRoot) parent8).getParentTree());
    assertNull(((PDStructureTreeRoot) parent9).getParentTree());
    assertNull(((PDStructureTreeRoot) parent10).getParentTree());
    assertNull(((PDStructureTreeRoot) parent11).getParentTree());
    assertNull(((PDStructureTreeRoot) parent12).getParentTree());
    assertNull(((PDStructureTreeRoot) parent13).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent3).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent4).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent5).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent6).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent7).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent8).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent9).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent10).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent11).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent12).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent13).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult6).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult7).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult8).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult9).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult10).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult11).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult12).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult13).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult14).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult15).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult16).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult17).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult18).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult19).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult20).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult5).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult6).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult7).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult8).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult9).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult10).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult11).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult12).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult4).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult5).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult6).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult7).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult8).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult9).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult10).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult11).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult12).getClassNames().size());
    assertEquals(2, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult4).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult5).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult6).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult7).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult8).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult9).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult10).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult11).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult12).getKids().isEmpty());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent5).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent6).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent8).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent9).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent10).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent11).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent12).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent13).getClassMap().isEmpty());
    assertTrue(pdStructureTreeRoot.getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent5).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent6).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent8).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent9).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent10).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent11).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent12).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent13).getRoleMap().isEmpty());
    assertSame(dic, toListResult.get(0));
    assertSame(dic2, toListResult.get(1));
    assertSame(dic2, structureElement.getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult7).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult8).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult9).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult10).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult11).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult12).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult13).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult14).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult15).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult16).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult17).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult18).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult19).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult20).getCOSObject());
    assertSame(cOSObject, pdStructureTreeRoot.getCOSObject());
    assertSame(cOSObject, parent2.getCOSObject());
    assertSame(cOSObject, parent3.getCOSObject());
    assertSame(cOSObject, parent4.getCOSObject());
    assertSame(cOSObject, parent5.getCOSObject());
    assertSame(cOSObject, parent6.getCOSObject());
    assertSame(cOSObject, parent7.getCOSObject());
    assertSame(cOSObject, parent8.getCOSObject());
    assertSame(cOSObject, parent9.getCOSObject());
    assertSame(cOSObject, parent10.getCOSObject());
    assertSame(cOSObject, parent11.getCOSObject());
    assertSame(cOSObject, parent12.getCOSObject());
    assertSame(cOSObject, parent13.getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
    assertSame(k, ((PDStructureTreeRoot) parent3).getK());
    assertSame(k, ((PDStructureTreeRoot) parent4).getK());
    assertSame(k, ((PDStructureTreeRoot) parent5).getK());
    assertSame(k, ((PDStructureTreeRoot) parent6).getK());
    assertSame(k, ((PDStructureTreeRoot) parent7).getK());
    assertSame(k, ((PDStructureTreeRoot) parent8).getK());
    assertSame(k, ((PDStructureTreeRoot) parent9).getK());
    assertSame(k, ((PDStructureTreeRoot) parent10).getK());
    assertSame(k, ((PDStructureTreeRoot) parent11).getK());
    assertSame(k, ((PDStructureTreeRoot) parent12).getK());
    assertSame(k, ((PDStructureTreeRoot) parent13).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  void testAppendKid8() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic2));
    COSDictionary dic3 = new COSDictionary();
    PDStructureElement structureElement = new PDStructureElement(dic3);

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    PDStructureNode parent = structureElement.getParent();
    COSBase k = ((PDStructureTreeRoot) parent).getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = kids.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    Object getResult3 = kids.get(2);
    assertTrue(getResult3 instanceof PDStructureElement);
    List<Object> kids2 = parent.getKids();
    assertEquals(3, kids2.size());
    Object getResult4 = kids2.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    Object getResult5 = kids2.get(1);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids2.get(2);
    assertTrue(getResult6 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(3, kids3.size());
    Object getResult7 = kids3.get(0);
    assertTrue(getResult7 instanceof PDStructureElement);
    Object getResult8 = kids3.get(1);
    assertTrue(getResult8 instanceof PDStructureElement);
    Object getResult9 = kids3.get(2);
    assertTrue(getResult9 instanceof PDStructureElement);
    PDStructureNode parent3 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids4 = parent3.getKids();
    assertEquals(3, kids4.size());
    Object getResult10 = kids4.get(0);
    assertTrue(getResult10 instanceof PDStructureElement);
    Object getResult11 = kids4.get(1);
    assertTrue(getResult11 instanceof PDStructureElement);
    Object getResult12 = kids4.get(2);
    assertTrue(getResult12 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(3, kids5.size());
    Object getResult13 = kids5.get(0);
    assertTrue(getResult13 instanceof PDStructureElement);
    Object getResult14 = kids5.get(1);
    assertTrue(getResult14 instanceof PDStructureElement);
    Object getResult15 = kids5.get(2);
    assertTrue(getResult15 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(3, kids6.size());
    Object getResult16 = kids6.get(0);
    assertTrue(getResult16 instanceof PDStructureElement);
    Object getResult17 = kids6.get(1);
    assertTrue(getResult17 instanceof PDStructureElement);
    Object getResult18 = kids6.get(2);
    assertTrue(getResult18 instanceof PDStructureElement);
    PDStructureNode parent6 = ((PDStructureElement) getResult5).getParent();
    List<Object> kids7 = parent6.getKids();
    assertEquals(3, kids7.size());
    Object getResult19 = kids7.get(0);
    assertTrue(getResult19 instanceof PDStructureElement);
    Object getResult20 = kids7.get(1);
    assertTrue(getResult20 instanceof PDStructureElement);
    Object getResult21 = kids7.get(2);
    assertTrue(getResult21 instanceof PDStructureElement);
    PDStructureNode parent7 = ((PDStructureElement) getResult6).getParent();
    List<Object> kids8 = parent7.getKids();
    assertEquals(3, kids8.size());
    Object getResult22 = kids8.get(0);
    assertTrue(getResult22 instanceof PDStructureElement);
    Object getResult23 = kids8.get(1);
    assertTrue(getResult23 instanceof PDStructureElement);
    Object getResult24 = kids8.get(2);
    assertTrue(getResult24 instanceof PDStructureElement);
    PDStructureNode parent8 = ((PDStructureElement) getResult7).getParent();
    List<Object> kids9 = parent8.getKids();
    assertEquals(3, kids9.size());
    Object getResult25 = kids9.get(0);
    assertTrue(getResult25 instanceof PDStructureElement);
    Object getResult26 = kids9.get(1);
    assertTrue(getResult26 instanceof PDStructureElement);
    Object getResult27 = kids9.get(2);
    assertTrue(getResult27 instanceof PDStructureElement);
    PDStructureNode parent9 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids10 = parent9.getKids();
    assertEquals(3, kids10.size());
    Object getResult28 = kids10.get(0);
    assertTrue(getResult28 instanceof PDStructureElement);
    Object getResult29 = kids10.get(1);
    assertTrue(getResult29 instanceof PDStructureElement);
    Object getResult30 = kids10.get(2);
    assertTrue(getResult30 instanceof PDStructureElement);
    PDStructureNode parent10 = ((PDStructureElement) getResult9).getParent();
    List<Object> kids11 = parent10.getKids();
    assertEquals(3, kids11.size());
    Object getResult31 = kids11.get(0);
    assertTrue(getResult31 instanceof PDStructureElement);
    Object getResult32 = kids11.get(1);
    assertTrue(getResult32 instanceof PDStructureElement);
    Object getResult33 = kids11.get(2);
    assertTrue(getResult33 instanceof PDStructureElement);
    PDStructureNode parent11 = ((PDStructureElement) getResult10).getParent();
    List<Object> kids12 = parent11.getKids();
    assertEquals(3, kids12.size());
    Object getResult34 = kids12.get(0);
    assertTrue(getResult34 instanceof PDStructureElement);
    Object getResult35 = kids12.get(1);
    assertTrue(getResult35 instanceof PDStructureElement);
    assertTrue(kids12.get(2) instanceof PDStructureElement);
    PDStructureNode parent12 = ((PDStructureElement) getResult11).getParent();
    List<Object> kids13 = parent12.getKids();
    assertEquals(3, kids13.size());
    assertTrue(kids13.get(0) instanceof PDStructureElement);
    assertTrue(kids13.get(1) instanceof PDStructureElement);
    assertTrue(kids13.get(2) instanceof PDStructureElement);
    PDStructureNode parent13 = ((PDStructureElement) getResult12).getParent();
    List<Object> kids14 = parent13.getKids();
    assertEquals(3, kids14.size());
    assertTrue(kids14.get(0) instanceof PDStructureElement);
    assertTrue(kids14.get(1) instanceof PDStructureElement);
    assertTrue(kids14.get(2) instanceof PDStructureElement);
    PDStructureNode parent14 = ((PDStructureElement) getResult13).getParent();
    List<Object> kids15 = parent14.getKids();
    assertEquals(3, kids15.size());
    assertTrue(kids15.get(0) instanceof PDStructureElement);
    assertTrue(kids15.get(1) instanceof PDStructureElement);
    assertTrue(kids15.get(2) instanceof PDStructureElement);
    PDStructureNode parent15 = ((PDStructureElement) getResult14).getParent();
    List<Object> kids16 = parent15.getKids();
    assertEquals(3, kids16.size());
    assertTrue(kids16.get(0) instanceof PDStructureElement);
    assertTrue(kids16.get(1) instanceof PDStructureElement);
    assertTrue(kids16.get(2) instanceof PDStructureElement);
    PDStructureNode parent16 = ((PDStructureElement) getResult15).getParent();
    List<Object> kids17 = parent16.getKids();
    assertEquals(3, kids17.size());
    assertTrue(kids17.get(0) instanceof PDStructureElement);
    assertTrue(kids17.get(1) instanceof PDStructureElement);
    assertTrue(kids17.get(2) instanceof PDStructureElement);
    PDStructureNode parent17 = ((PDStructureElement) getResult16).getParent();
    List<Object> kids18 = parent17.getKids();
    assertEquals(3, kids18.size());
    assertTrue(kids18.get(0) instanceof PDStructureElement);
    assertTrue(kids18.get(1) instanceof PDStructureElement);
    assertTrue(kids18.get(2) instanceof PDStructureElement);
    PDStructureNode parent18 = ((PDStructureElement) getResult17).getParent();
    List<Object> kids19 = parent18.getKids();
    assertEquals(3, kids19.size());
    assertTrue(kids19.get(0) instanceof PDStructureElement);
    assertTrue(kids19.get(1) instanceof PDStructureElement);
    assertTrue(kids19.get(2) instanceof PDStructureElement);
    PDStructureNode parent19 = ((PDStructureElement) getResult18).getParent();
    List<Object> kids20 = parent19.getKids();
    assertEquals(3, kids20.size());
    assertTrue(kids20.get(0) instanceof PDStructureElement);
    assertTrue(kids20.get(1) instanceof PDStructureElement);
    assertTrue(kids20.get(2) instanceof PDStructureElement);
    PDStructureNode parent20 = ((PDStructureElement) getResult19).getParent();
    List<Object> kids21 = parent20.getKids();
    assertEquals(3, kids21.size());
    assertTrue(kids21.get(0) instanceof PDStructureElement);
    assertTrue(kids21.get(1) instanceof PDStructureElement);
    assertTrue(kids21.get(2) instanceof PDStructureElement);
    PDStructureNode parent21 = ((PDStructureElement) getResult20).getParent();
    List<Object> kids22 = parent21.getKids();
    assertEquals(3, kids22.size());
    assertTrue(kids22.get(0) instanceof PDStructureElement);
    assertTrue(kids22.get(1) instanceof PDStructureElement);
    assertTrue(kids22.get(2) instanceof PDStructureElement);
    PDStructureNode parent22 = ((PDStructureElement) getResult21).getParent();
    List<Object> kids23 = parent22.getKids();
    assertEquals(3, kids23.size());
    assertTrue(kids23.get(0) instanceof PDStructureElement);
    assertTrue(kids23.get(1) instanceof PDStructureElement);
    assertTrue(kids23.get(2) instanceof PDStructureElement);
    PDStructureNode parent23 = ((PDStructureElement) getResult22).getParent();
    List<Object> kids24 = parent23.getKids();
    assertEquals(3, kids24.size());
    assertTrue(kids24.get(0) instanceof PDStructureElement);
    assertTrue(kids24.get(1) instanceof PDStructureElement);
    assertTrue(kids24.get(2) instanceof PDStructureElement);
    PDStructureNode parent24 = ((PDStructureElement) getResult23).getParent();
    List<Object> kids25 = parent24.getKids();
    assertEquals(3, kids25.size());
    assertTrue(kids25.get(0) instanceof PDStructureElement);
    assertTrue(kids25.get(1) instanceof PDStructureElement);
    assertTrue(kids25.get(2) instanceof PDStructureElement);
    PDStructureNode parent25 = ((PDStructureElement) getResult24).getParent();
    List<Object> kids26 = parent25.getKids();
    assertEquals(3, kids26.size());
    assertTrue(kids26.get(0) instanceof PDStructureElement);
    assertTrue(kids26.get(1) instanceof PDStructureElement);
    assertTrue(kids26.get(2) instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(parent6 instanceof PDStructureTreeRoot);
    assertTrue(parent7 instanceof PDStructureTreeRoot);
    assertTrue(parent8 instanceof PDStructureTreeRoot);
    assertTrue(parent9 instanceof PDStructureTreeRoot);
    assertTrue(parent10 instanceof PDStructureTreeRoot);
    assertTrue(parent11 instanceof PDStructureTreeRoot);
    assertTrue(parent12 instanceof PDStructureTreeRoot);
    assertTrue(parent13 instanceof PDStructureTreeRoot);
    assertTrue(parent14 instanceof PDStructureTreeRoot);
    assertTrue(parent15 instanceof PDStructureTreeRoot);
    assertTrue(parent16 instanceof PDStructureTreeRoot);
    assertTrue(parent17 instanceof PDStructureTreeRoot);
    assertTrue(parent18 instanceof PDStructureTreeRoot);
    assertTrue(parent19 instanceof PDStructureTreeRoot);
    assertTrue(parent20 instanceof PDStructureTreeRoot);
    assertTrue(parent21 instanceof PDStructureTreeRoot);
    assertTrue(parent22 instanceof PDStructureTreeRoot);
    assertTrue(parent23 instanceof PDStructureTreeRoot);
    assertTrue(parent24 instanceof PDStructureTreeRoot);
    assertTrue(parent25 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult25).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult26).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult27).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult28).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult29).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult30).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult31).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult32).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult33).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult34).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertEquals("StructTreeRoot", parent3.getType());
    assertEquals("StructTreeRoot", parent4.getType());
    assertEquals("StructTreeRoot", parent5.getType());
    assertEquals("StructTreeRoot", parent6.getType());
    assertEquals("StructTreeRoot", parent7.getType());
    assertEquals("StructTreeRoot", parent8.getType());
    assertEquals("StructTreeRoot", parent9.getType());
    assertEquals("StructTreeRoot", parent10.getType());
    assertEquals("StructTreeRoot", parent11.getType());
    assertEquals("StructTreeRoot", parent12.getType());
    assertEquals("StructTreeRoot", parent13.getType());
    assertEquals("StructTreeRoot", parent14.getType());
    assertEquals("StructTreeRoot", parent15.getType());
    assertEquals("StructTreeRoot", parent16.getType());
    assertEquals("StructTreeRoot", parent17.getType());
    assertEquals("StructTreeRoot", parent18.getType());
    assertEquals("StructTreeRoot", parent19.getType());
    assertEquals("StructTreeRoot", parent20.getType());
    assertEquals("StructTreeRoot", parent21.getType());
    assertEquals("StructTreeRoot", parent22.getType());
    assertEquals("StructTreeRoot", parent23.getType());
    assertEquals("StructTreeRoot", parent24.getType());
    assertEquals("StructTreeRoot", parent25.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult4).getActualText());
    assertNull(((PDStructureElement) getResult5).getActualText());
    assertNull(((PDStructureElement) getResult6).getActualText());
    assertNull(((PDStructureElement) getResult7).getActualText());
    assertNull(((PDStructureElement) getResult8).getActualText());
    assertNull(((PDStructureElement) getResult9).getActualText());
    assertNull(((PDStructureElement) getResult10).getActualText());
    assertNull(((PDStructureElement) getResult11).getActualText());
    assertNull(((PDStructureElement) getResult12).getActualText());
    assertNull(((PDStructureElement) getResult13).getActualText());
    assertNull(((PDStructureElement) getResult14).getActualText());
    assertNull(((PDStructureElement) getResult15).getActualText());
    assertNull(((PDStructureElement) getResult16).getActualText());
    assertNull(((PDStructureElement) getResult17).getActualText());
    assertNull(((PDStructureElement) getResult18).getActualText());
    assertNull(((PDStructureElement) getResult19).getActualText());
    assertNull(((PDStructureElement) getResult20).getActualText());
    assertNull(((PDStructureElement) getResult21).getActualText());
    assertNull(((PDStructureElement) getResult22).getActualText());
    assertNull(((PDStructureElement) getResult23).getActualText());
    assertNull(((PDStructureElement) getResult24).getActualText());
    assertNull(((PDStructureElement) getResult25).getActualText());
    assertNull(((PDStructureElement) getResult26).getActualText());
    assertNull(((PDStructureElement) getResult27).getActualText());
    assertNull(((PDStructureElement) getResult28).getActualText());
    assertNull(((PDStructureElement) getResult29).getActualText());
    assertNull(((PDStructureElement) getResult30).getActualText());
    assertNull(((PDStructureElement) getResult31).getActualText());
    assertNull(((PDStructureElement) getResult32).getActualText());
    assertNull(((PDStructureElement) getResult33).getActualText());
    assertNull(((PDStructureElement) getResult34).getActualText());
    assertNull(((PDStructureElement) getResult35).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult4).getAlternateDescription());
    assertNull(((PDStructureElement) getResult5).getAlternateDescription());
    assertNull(((PDStructureElement) getResult6).getAlternateDescription());
    assertNull(((PDStructureElement) getResult7).getAlternateDescription());
    assertNull(((PDStructureElement) getResult8).getAlternateDescription());
    assertNull(((PDStructureElement) getResult9).getAlternateDescription());
    assertNull(((PDStructureElement) getResult10).getAlternateDescription());
    assertNull(((PDStructureElement) getResult11).getAlternateDescription());
    assertNull(((PDStructureElement) getResult12).getAlternateDescription());
    assertNull(((PDStructureElement) getResult13).getAlternateDescription());
    assertNull(((PDStructureElement) getResult14).getAlternateDescription());
    assertNull(((PDStructureElement) getResult15).getAlternateDescription());
    assertNull(((PDStructureElement) getResult16).getAlternateDescription());
    assertNull(((PDStructureElement) getResult17).getAlternateDescription());
    assertNull(((PDStructureElement) getResult18).getAlternateDescription());
    assertNull(((PDStructureElement) getResult19).getAlternateDescription());
    assertNull(((PDStructureElement) getResult20).getAlternateDescription());
    assertNull(((PDStructureElement) getResult21).getAlternateDescription());
    assertNull(((PDStructureElement) getResult22).getAlternateDescription());
    assertNull(((PDStructureElement) getResult23).getAlternateDescription());
    assertNull(((PDStructureElement) getResult24).getAlternateDescription());
    assertNull(((PDStructureElement) getResult25).getAlternateDescription());
    assertNull(((PDStructureElement) getResult26).getAlternateDescription());
    assertNull(((PDStructureElement) getResult27).getAlternateDescription());
    assertNull(((PDStructureElement) getResult28).getAlternateDescription());
    assertNull(((PDStructureElement) getResult29).getAlternateDescription());
    assertNull(((PDStructureElement) getResult30).getAlternateDescription());
    assertNull(((PDStructureElement) getResult31).getAlternateDescription());
    assertNull(((PDStructureElement) getResult32).getAlternateDescription());
    assertNull(((PDStructureElement) getResult33).getAlternateDescription());
    assertNull(((PDStructureElement) getResult34).getAlternateDescription());
    assertNull(((PDStructureElement) getResult35).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult4).getElementIdentifier());
    assertNull(((PDStructureElement) getResult5).getElementIdentifier());
    assertNull(((PDStructureElement) getResult6).getElementIdentifier());
    assertNull(((PDStructureElement) getResult7).getElementIdentifier());
    assertNull(((PDStructureElement) getResult8).getElementIdentifier());
    assertNull(((PDStructureElement) getResult9).getElementIdentifier());
    assertNull(((PDStructureElement) getResult10).getElementIdentifier());
    assertNull(((PDStructureElement) getResult11).getElementIdentifier());
    assertNull(((PDStructureElement) getResult12).getElementIdentifier());
    assertNull(((PDStructureElement) getResult13).getElementIdentifier());
    assertNull(((PDStructureElement) getResult14).getElementIdentifier());
    assertNull(((PDStructureElement) getResult15).getElementIdentifier());
    assertNull(((PDStructureElement) getResult16).getElementIdentifier());
    assertNull(((PDStructureElement) getResult17).getElementIdentifier());
    assertNull(((PDStructureElement) getResult18).getElementIdentifier());
    assertNull(((PDStructureElement) getResult19).getElementIdentifier());
    assertNull(((PDStructureElement) getResult20).getElementIdentifier());
    assertNull(((PDStructureElement) getResult21).getElementIdentifier());
    assertNull(((PDStructureElement) getResult22).getElementIdentifier());
    assertNull(((PDStructureElement) getResult23).getElementIdentifier());
    assertNull(((PDStructureElement) getResult24).getElementIdentifier());
    assertNull(((PDStructureElement) getResult25).getElementIdentifier());
    assertNull(((PDStructureElement) getResult26).getElementIdentifier());
    assertNull(((PDStructureElement) getResult27).getElementIdentifier());
    assertNull(((PDStructureElement) getResult28).getElementIdentifier());
    assertNull(((PDStructureElement) getResult29).getElementIdentifier());
    assertNull(((PDStructureElement) getResult30).getElementIdentifier());
    assertNull(((PDStructureElement) getResult31).getElementIdentifier());
    assertNull(((PDStructureElement) getResult32).getElementIdentifier());
    assertNull(((PDStructureElement) getResult33).getElementIdentifier());
    assertNull(((PDStructureElement) getResult34).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult4).getExpandedForm());
    assertNull(((PDStructureElement) getResult5).getExpandedForm());
    assertNull(((PDStructureElement) getResult6).getExpandedForm());
    assertNull(((PDStructureElement) getResult7).getExpandedForm());
    assertNull(((PDStructureElement) getResult8).getExpandedForm());
    assertNull(((PDStructureElement) getResult9).getExpandedForm());
    assertNull(((PDStructureElement) getResult10).getExpandedForm());
    assertNull(((PDStructureElement) getResult11).getExpandedForm());
    assertNull(((PDStructureElement) getResult12).getExpandedForm());
    assertNull(((PDStructureElement) getResult13).getExpandedForm());
    assertNull(((PDStructureElement) getResult14).getExpandedForm());
    assertNull(((PDStructureElement) getResult15).getExpandedForm());
    assertNull(((PDStructureElement) getResult16).getExpandedForm());
    assertNull(((PDStructureElement) getResult17).getExpandedForm());
    assertNull(((PDStructureElement) getResult18).getExpandedForm());
    assertNull(((PDStructureElement) getResult19).getExpandedForm());
    assertNull(((PDStructureElement) getResult20).getExpandedForm());
    assertNull(((PDStructureElement) getResult21).getExpandedForm());
    assertNull(((PDStructureElement) getResult22).getExpandedForm());
    assertNull(((PDStructureElement) getResult23).getExpandedForm());
    assertNull(((PDStructureElement) getResult24).getExpandedForm());
    assertNull(((PDStructureElement) getResult25).getExpandedForm());
    assertNull(((PDStructureElement) getResult26).getExpandedForm());
    assertNull(((PDStructureElement) getResult27).getExpandedForm());
    assertNull(((PDStructureElement) getResult28).getExpandedForm());
    assertNull(((PDStructureElement) getResult29).getExpandedForm());
    assertNull(((PDStructureElement) getResult30).getExpandedForm());
    assertNull(((PDStructureElement) getResult31).getExpandedForm());
    assertNull(((PDStructureElement) getResult32).getExpandedForm());
    assertNull(((PDStructureElement) getResult33).getExpandedForm());
    assertNull(((PDStructureElement) getResult34).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult4).getLanguage());
    assertNull(((PDStructureElement) getResult5).getLanguage());
    assertNull(((PDStructureElement) getResult6).getLanguage());
    assertNull(((PDStructureElement) getResult7).getLanguage());
    assertNull(((PDStructureElement) getResult8).getLanguage());
    assertNull(((PDStructureElement) getResult9).getLanguage());
    assertNull(((PDStructureElement) getResult10).getLanguage());
    assertNull(((PDStructureElement) getResult11).getLanguage());
    assertNull(((PDStructureElement) getResult12).getLanguage());
    assertNull(((PDStructureElement) getResult13).getLanguage());
    assertNull(((PDStructureElement) getResult14).getLanguage());
    assertNull(((PDStructureElement) getResult15).getLanguage());
    assertNull(((PDStructureElement) getResult16).getLanguage());
    assertNull(((PDStructureElement) getResult17).getLanguage());
    assertNull(((PDStructureElement) getResult18).getLanguage());
    assertNull(((PDStructureElement) getResult19).getLanguage());
    assertNull(((PDStructureElement) getResult20).getLanguage());
    assertNull(((PDStructureElement) getResult21).getLanguage());
    assertNull(((PDStructureElement) getResult22).getLanguage());
    assertNull(((PDStructureElement) getResult23).getLanguage());
    assertNull(((PDStructureElement) getResult24).getLanguage());
    assertNull(((PDStructureElement) getResult25).getLanguage());
    assertNull(((PDStructureElement) getResult26).getLanguage());
    assertNull(((PDStructureElement) getResult27).getLanguage());
    assertNull(((PDStructureElement) getResult28).getLanguage());
    assertNull(((PDStructureElement) getResult29).getLanguage());
    assertNull(((PDStructureElement) getResult30).getLanguage());
    assertNull(((PDStructureElement) getResult31).getLanguage());
    assertNull(((PDStructureElement) getResult32).getLanguage());
    assertNull(((PDStructureElement) getResult33).getLanguage());
    assertNull(((PDStructureElement) getResult34).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult4).getStandardStructureType());
    assertNull(((PDStructureElement) getResult5).getStandardStructureType());
    assertNull(((PDStructureElement) getResult6).getStandardStructureType());
    assertNull(((PDStructureElement) getResult7).getStandardStructureType());
    assertNull(((PDStructureElement) getResult8).getStandardStructureType());
    assertNull(((PDStructureElement) getResult9).getStandardStructureType());
    assertNull(((PDStructureElement) getResult10).getStandardStructureType());
    assertNull(((PDStructureElement) getResult11).getStandardStructureType());
    assertNull(((PDStructureElement) getResult12).getStandardStructureType());
    assertNull(((PDStructureElement) getResult13).getStandardStructureType());
    assertNull(((PDStructureElement) getResult14).getStandardStructureType());
    assertNull(((PDStructureElement) getResult15).getStandardStructureType());
    assertNull(((PDStructureElement) getResult16).getStandardStructureType());
    assertNull(((PDStructureElement) getResult17).getStandardStructureType());
    assertNull(((PDStructureElement) getResult18).getStandardStructureType());
    assertNull(((PDStructureElement) getResult19).getStandardStructureType());
    assertNull(((PDStructureElement) getResult20).getStandardStructureType());
    assertNull(((PDStructureElement) getResult21).getStandardStructureType());
    assertNull(((PDStructureElement) getResult22).getStandardStructureType());
    assertNull(((PDStructureElement) getResult23).getStandardStructureType());
    assertNull(((PDStructureElement) getResult24).getStandardStructureType());
    assertNull(((PDStructureElement) getResult25).getStandardStructureType());
    assertNull(((PDStructureElement) getResult26).getStandardStructureType());
    assertNull(((PDStructureElement) getResult27).getStandardStructureType());
    assertNull(((PDStructureElement) getResult28).getStandardStructureType());
    assertNull(((PDStructureElement) getResult29).getStandardStructureType());
    assertNull(((PDStructureElement) getResult30).getStandardStructureType());
    assertNull(((PDStructureElement) getResult31).getStandardStructureType());
    assertNull(((PDStructureElement) getResult32).getStandardStructureType());
    assertNull(((PDStructureElement) getResult33).getStandardStructureType());
    assertNull(((PDStructureElement) getResult34).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult4).getStructureType());
    assertNull(((PDStructureElement) getResult5).getStructureType());
    assertNull(((PDStructureElement) getResult6).getStructureType());
    assertNull(((PDStructureElement) getResult7).getStructureType());
    assertNull(((PDStructureElement) getResult8).getStructureType());
    assertNull(((PDStructureElement) getResult9).getStructureType());
    assertNull(((PDStructureElement) getResult10).getStructureType());
    assertNull(((PDStructureElement) getResult11).getStructureType());
    assertNull(((PDStructureElement) getResult12).getStructureType());
    assertNull(((PDStructureElement) getResult13).getStructureType());
    assertNull(((PDStructureElement) getResult14).getStructureType());
    assertNull(((PDStructureElement) getResult15).getStructureType());
    assertNull(((PDStructureElement) getResult16).getStructureType());
    assertNull(((PDStructureElement) getResult17).getStructureType());
    assertNull(((PDStructureElement) getResult18).getStructureType());
    assertNull(((PDStructureElement) getResult19).getStructureType());
    assertNull(((PDStructureElement) getResult20).getStructureType());
    assertNull(((PDStructureElement) getResult21).getStructureType());
    assertNull(((PDStructureElement) getResult22).getStructureType());
    assertNull(((PDStructureElement) getResult23).getStructureType());
    assertNull(((PDStructureElement) getResult24).getStructureType());
    assertNull(((PDStructureElement) getResult25).getStructureType());
    assertNull(((PDStructureElement) getResult26).getStructureType());
    assertNull(((PDStructureElement) getResult27).getStructureType());
    assertNull(((PDStructureElement) getResult28).getStructureType());
    assertNull(((PDStructureElement) getResult29).getStructureType());
    assertNull(((PDStructureElement) getResult30).getStructureType());
    assertNull(((PDStructureElement) getResult31).getStructureType());
    assertNull(((PDStructureElement) getResult32).getStructureType());
    assertNull(((PDStructureElement) getResult33).getStructureType());
    assertNull(((PDStructureElement) getResult34).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult4).getTitle());
    assertNull(((PDStructureElement) getResult5).getTitle());
    assertNull(((PDStructureElement) getResult6).getTitle());
    assertNull(((PDStructureElement) getResult7).getTitle());
    assertNull(((PDStructureElement) getResult8).getTitle());
    assertNull(((PDStructureElement) getResult9).getTitle());
    assertNull(((PDStructureElement) getResult10).getTitle());
    assertNull(((PDStructureElement) getResult11).getTitle());
    assertNull(((PDStructureElement) getResult12).getTitle());
    assertNull(((PDStructureElement) getResult13).getTitle());
    assertNull(((PDStructureElement) getResult14).getTitle());
    assertNull(((PDStructureElement) getResult15).getTitle());
    assertNull(((PDStructureElement) getResult16).getTitle());
    assertNull(((PDStructureElement) getResult17).getTitle());
    assertNull(((PDStructureElement) getResult18).getTitle());
    assertNull(((PDStructureElement) getResult19).getTitle());
    assertNull(((PDStructureElement) getResult20).getTitle());
    assertNull(((PDStructureElement) getResult21).getTitle());
    assertNull(((PDStructureElement) getResult22).getTitle());
    assertNull(((PDStructureElement) getResult23).getTitle());
    assertNull(((PDStructureElement) getResult24).getTitle());
    assertNull(((PDStructureElement) getResult25).getTitle());
    assertNull(((PDStructureElement) getResult26).getTitle());
    assertNull(((PDStructureElement) getResult27).getTitle());
    assertNull(((PDStructureElement) getResult28).getTitle());
    assertNull(((PDStructureElement) getResult29).getTitle());
    assertNull(((PDStructureElement) getResult30).getTitle());
    assertNull(((PDStructureElement) getResult31).getTitle());
    assertNull(((PDStructureElement) getResult32).getTitle());
    assertNull(((PDStructureElement) getResult33).getTitle());
    assertNull(((PDStructureElement) getResult34).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult4).getType());
    assertNull(((PDStructureElement) getResult5).getType());
    assertNull(((PDStructureElement) getResult6).getType());
    assertNull(((PDStructureElement) getResult7).getType());
    assertNull(((PDStructureElement) getResult8).getType());
    assertNull(((PDStructureElement) getResult9).getType());
    assertNull(((PDStructureElement) getResult10).getType());
    assertNull(((PDStructureElement) getResult11).getType());
    assertNull(((PDStructureElement) getResult12).getType());
    assertNull(((PDStructureElement) getResult13).getType());
    assertNull(((PDStructureElement) getResult14).getType());
    assertNull(((PDStructureElement) getResult15).getType());
    assertNull(((PDStructureElement) getResult16).getType());
    assertNull(((PDStructureElement) getResult17).getType());
    assertNull(((PDStructureElement) getResult18).getType());
    assertNull(((PDStructureElement) getResult19).getType());
    assertNull(((PDStructureElement) getResult20).getType());
    assertNull(((PDStructureElement) getResult21).getType());
    assertNull(((PDStructureElement) getResult22).getType());
    assertNull(((PDStructureElement) getResult23).getType());
    assertNull(((PDStructureElement) getResult24).getType());
    assertNull(((PDStructureElement) getResult25).getType());
    assertNull(((PDStructureElement) getResult26).getType());
    assertNull(((PDStructureElement) getResult27).getType());
    assertNull(((PDStructureElement) getResult28).getType());
    assertNull(((PDStructureElement) getResult29).getType());
    assertNull(((PDStructureElement) getResult30).getType());
    assertNull(((PDStructureElement) getResult31).getType());
    assertNull(((PDStructureElement) getResult32).getType());
    assertNull(((PDStructureElement) getResult33).getType());
    assertNull(((PDStructureElement) getResult34).getType());
    COSDictionary cOSObject = parent.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult5).getPage());
    assertNull(((PDStructureElement) getResult6).getPage());
    assertNull(((PDStructureElement) getResult7).getPage());
    assertNull(((PDStructureElement) getResult8).getPage());
    assertNull(((PDStructureElement) getResult9).getPage());
    assertNull(((PDStructureElement) getResult10).getPage());
    assertNull(((PDStructureElement) getResult11).getPage());
    assertNull(((PDStructureElement) getResult12).getPage());
    assertNull(((PDStructureElement) getResult13).getPage());
    assertNull(((PDStructureElement) getResult14).getPage());
    assertNull(((PDStructureElement) getResult15).getPage());
    assertNull(((PDStructureElement) getResult16).getPage());
    assertNull(((PDStructureElement) getResult17).getPage());
    assertNull(((PDStructureElement) getResult18).getPage());
    assertNull(((PDStructureElement) getResult19).getPage());
    assertNull(((PDStructureElement) getResult20).getPage());
    assertNull(((PDStructureElement) getResult21).getPage());
    assertNull(((PDStructureElement) getResult22).getPage());
    assertNull(((PDStructureElement) getResult23).getPage());
    assertNull(((PDStructureElement) getResult24).getPage());
    assertNull(((PDStructureElement) getResult25).getPage());
    assertNull(((PDStructureElement) getResult26).getPage());
    assertNull(((PDStructureElement) getResult27).getPage());
    assertNull(((PDStructureElement) getResult28).getPage());
    assertNull(((PDStructureElement) getResult29).getPage());
    assertNull(((PDStructureElement) getResult30).getPage());
    assertNull(((PDStructureElement) getResult31).getPage());
    assertNull(((PDStructureElement) getResult32).getPage());
    assertNull(((PDStructureElement) getResult33).getPage());
    assertNull(((PDStructureElement) getResult34).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent3).getIDTree());
    assertNull(((PDStructureTreeRoot) parent4).getIDTree());
    assertNull(((PDStructureTreeRoot) parent5).getIDTree());
    assertNull(((PDStructureTreeRoot) parent6).getIDTree());
    assertNull(((PDStructureTreeRoot) parent7).getIDTree());
    assertNull(((PDStructureTreeRoot) parent8).getIDTree());
    assertNull(((PDStructureTreeRoot) parent9).getIDTree());
    assertNull(((PDStructureTreeRoot) parent10).getIDTree());
    assertNull(((PDStructureTreeRoot) parent11).getIDTree());
    assertNull(((PDStructureTreeRoot) parent12).getIDTree());
    assertNull(((PDStructureTreeRoot) parent13).getIDTree());
    assertNull(((PDStructureTreeRoot) parent14).getIDTree());
    assertNull(((PDStructureTreeRoot) parent15).getIDTree());
    assertNull(((PDStructureTreeRoot) parent16).getIDTree());
    assertNull(((PDStructureTreeRoot) parent17).getIDTree());
    assertNull(((PDStructureTreeRoot) parent18).getIDTree());
    assertNull(((PDStructureTreeRoot) parent19).getIDTree());
    assertNull(((PDStructureTreeRoot) parent20).getIDTree());
    assertNull(((PDStructureTreeRoot) parent21).getIDTree());
    assertNull(((PDStructureTreeRoot) parent22).getIDTree());
    assertNull(((PDStructureTreeRoot) parent23).getIDTree());
    assertNull(((PDStructureTreeRoot) parent24).getIDTree());
    assertNull(((PDStructureTreeRoot) parent25).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertNull(((PDStructureTreeRoot) parent3).getParentTree());
    assertNull(((PDStructureTreeRoot) parent4).getParentTree());
    assertNull(((PDStructureTreeRoot) parent5).getParentTree());
    assertNull(((PDStructureTreeRoot) parent6).getParentTree());
    assertNull(((PDStructureTreeRoot) parent7).getParentTree());
    assertNull(((PDStructureTreeRoot) parent8).getParentTree());
    assertNull(((PDStructureTreeRoot) parent9).getParentTree());
    assertNull(((PDStructureTreeRoot) parent10).getParentTree());
    assertNull(((PDStructureTreeRoot) parent11).getParentTree());
    assertNull(((PDStructureTreeRoot) parent12).getParentTree());
    assertNull(((PDStructureTreeRoot) parent13).getParentTree());
    assertNull(((PDStructureTreeRoot) parent14).getParentTree());
    assertNull(((PDStructureTreeRoot) parent15).getParentTree());
    assertNull(((PDStructureTreeRoot) parent16).getParentTree());
    assertNull(((PDStructureTreeRoot) parent17).getParentTree());
    assertNull(((PDStructureTreeRoot) parent18).getParentTree());
    assertNull(((PDStructureTreeRoot) parent19).getParentTree());
    assertNull(((PDStructureTreeRoot) parent20).getParentTree());
    assertNull(((PDStructureTreeRoot) parent21).getParentTree());
    assertNull(((PDStructureTreeRoot) parent22).getParentTree());
    assertNull(((PDStructureTreeRoot) parent23).getParentTree());
    assertNull(((PDStructureTreeRoot) parent24).getParentTree());
    assertNull(((PDStructureTreeRoot) parent25).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent3).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent4).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent5).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent6).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent7).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent8).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent9).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent10).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent11).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent12).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent13).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent14).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent15).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent16).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent17).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent18).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent19).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent20).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent21).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent22).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent23).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent24).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent25).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult6).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult7).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult8).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult9).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult10).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult11).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult12).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult13).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult14).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult15).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult16).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult17).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult18).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult19).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult20).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult21).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult22).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult23).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult24).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult25).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult26).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult27).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult28).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult29).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult30).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult31).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult32).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult33).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult34).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult5).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult6).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult7).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult8).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult9).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult10).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult11).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult12).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult13).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult14).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult15).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult16).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult17).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult18).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult19).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult20).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult21).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult22).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult23).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult24).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult4).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult5).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult6).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult7).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult8).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult9).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult10).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult11).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult12).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult13).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult14).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult15).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult16).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult17).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult18).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult19).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult20).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult21).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult22).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult23).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult24).getClassNames().size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult4).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult5).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult6).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult7).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult8).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult9).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult10).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult11).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult12).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult13).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult14).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult15).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult16).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult17).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult18).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult19).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult20).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult21).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult22).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult23).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult24).getKids().isEmpty());
    assertTrue(pdStructureTreeRoot.getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent5).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent6).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent8).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent9).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent10).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent11).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent12).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent13).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent14).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent15).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent16).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent17).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent18).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent19).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent20).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent21).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent22).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent23).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent24).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent25).getClassMap().isEmpty());
    assertTrue(pdStructureTreeRoot.getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent5).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent6).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent8).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent9).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent10).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent11).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent12).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent13).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent14).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent15).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent16).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent17).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent18).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent19).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent20).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent21).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent22).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent23).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent24).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent25).getRoleMap().isEmpty());
    assertSame(dic, toListResult.get(0));
    assertSame(dic2, toListResult.get(1));
    assertSame(dic3, toListResult.get(2));
    assertSame(dic3, structureElement.getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult7).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult8).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult9).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult10).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult11).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult12).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult13).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult14).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult15).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult16).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult17).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult18).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult19).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult20).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult21).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult22).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult23).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult24).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult25).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult26).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult27).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult28).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult29).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult30).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult31).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult32).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult33).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult34).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult35).getCOSObject());
    assertSame(cOSObject, pdStructureTreeRoot.getCOSObject());
    assertSame(cOSObject, parent2.getCOSObject());
    assertSame(cOSObject, parent3.getCOSObject());
    assertSame(cOSObject, parent4.getCOSObject());
    assertSame(cOSObject, parent5.getCOSObject());
    assertSame(cOSObject, parent6.getCOSObject());
    assertSame(cOSObject, parent7.getCOSObject());
    assertSame(cOSObject, parent8.getCOSObject());
    assertSame(cOSObject, parent9.getCOSObject());
    assertSame(cOSObject, parent10.getCOSObject());
    assertSame(cOSObject, parent11.getCOSObject());
    assertSame(cOSObject, parent12.getCOSObject());
    assertSame(cOSObject, parent13.getCOSObject());
    assertSame(cOSObject, parent14.getCOSObject());
    assertSame(cOSObject, parent15.getCOSObject());
    assertSame(cOSObject, parent16.getCOSObject());
    assertSame(cOSObject, parent17.getCOSObject());
    assertSame(cOSObject, parent18.getCOSObject());
    assertSame(cOSObject, parent19.getCOSObject());
    assertSame(cOSObject, parent20.getCOSObject());
    assertSame(cOSObject, parent21.getCOSObject());
    assertSame(cOSObject, parent22.getCOSObject());
    assertSame(cOSObject, parent23.getCOSObject());
    assertSame(cOSObject, parent24.getCOSObject());
    assertSame(cOSObject, parent25.getCOSObject());
    assertSame(k, pdStructureTreeRoot.getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
    assertSame(k, ((PDStructureTreeRoot) parent3).getK());
    assertSame(k, ((PDStructureTreeRoot) parent4).getK());
    assertSame(k, ((PDStructureTreeRoot) parent5).getK());
    assertSame(k, ((PDStructureTreeRoot) parent6).getK());
    assertSame(k, ((PDStructureTreeRoot) parent7).getK());
    assertSame(k, ((PDStructureTreeRoot) parent8).getK());
    assertSame(k, ((PDStructureTreeRoot) parent9).getK());
    assertSame(k, ((PDStructureTreeRoot) parent10).getK());
    assertSame(k, ((PDStructureTreeRoot) parent11).getK());
    assertSame(k, ((PDStructureTreeRoot) parent12).getK());
    assertSame(k, ((PDStructureTreeRoot) parent13).getK());
    assertSame(k, ((PDStructureTreeRoot) parent14).getK());
    assertSame(k, ((PDStructureTreeRoot) parent15).getK());
    assertSame(k, ((PDStructureTreeRoot) parent16).getK());
    assertSame(k, ((PDStructureTreeRoot) parent17).getK());
    assertSame(k, ((PDStructureTreeRoot) parent18).getK());
    assertSame(k, ((PDStructureTreeRoot) parent19).getK());
    assertSame(k, ((PDStructureTreeRoot) parent20).getK());
    assertSame(k, ((PDStructureTreeRoot) parent21).getK());
    assertSame(k, ((PDStructureTreeRoot) parent22).getK());
    assertSame(k, ((PDStructureTreeRoot) parent23).getK());
    assertSame(k, ((PDStructureTreeRoot) parent24).getK());
    assertSame(k, ((PDStructureTreeRoot) parent25).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  void testInsertBefore() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  void testInsertBefore2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, "Ref Kid");

    // Assert that nothing has changed
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, k);
  }

  /**
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  void testInsertBefore3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore((COSBase) null, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult4 = kids3.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertSame(dic, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  void testInsertBefore4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(dic, toListResult.get(2));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    COSBoolean cosBoolean2 = cosBoolean.FALSE;
    assertSame(cosBoolean2, toListResult.get(0));
    assertSame(cosBoolean2, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  void testInsertBefore5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean newKid = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(newKid, null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult4 = kids3.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertSame(dic, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(newKid.FALSE, toListResult.get(0));
  }

  /**
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  void testInsertBefore6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean newKid = COSBoolean.FALSE;
    COSInteger cosInteger = COSInteger.ONE;

    // Act
    pdStructureTreeRoot.insertBefore(newKid, cosInteger);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult3 = kids3.get(1);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(dic, toListResult.get(2));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(newKid.FALSE, toListResult.get(0));
    assertSame(cosInteger.ONE, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  void testInsertBefore7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSArray newKid = new COSArray();
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(newKid, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(newKid, toListResult.get(0));
    assertSame(dic, toListResult.get(2));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  void testInsertBefore8() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  void testInsertBefore9() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, k);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  void testInsertBefore10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(null), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult2).getParent() instanceof PDStructureTreeRoot);
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertSame(dic, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  void testInsertBefore11() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore((PDStructureElement) null, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult2).getParent() instanceof PDStructureTreeRoot);
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertSame(dic, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  void testInsertBefore12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(dic2), cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = kids.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    Object getResult4 = kids2.get(1);
    assertTrue(getResult4 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult5 = kids3.get(0);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids3.get(1);
    assertTrue(getResult6 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult6).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult4).getActualText());
    assertNull(((PDStructureElement) getResult5).getActualText());
    assertNull(((PDStructureElement) getResult6).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult4).getAlternateDescription());
    assertNull(((PDStructureElement) getResult5).getAlternateDescription());
    assertNull(((PDStructureElement) getResult6).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult4).getElementIdentifier());
    assertNull(((PDStructureElement) getResult5).getElementIdentifier());
    assertNull(((PDStructureElement) getResult6).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult4).getExpandedForm());
    assertNull(((PDStructureElement) getResult5).getExpandedForm());
    assertNull(((PDStructureElement) getResult6).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult4).getLanguage());
    assertNull(((PDStructureElement) getResult5).getLanguage());
    assertNull(((PDStructureElement) getResult6).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult4).getStandardStructureType());
    assertNull(((PDStructureElement) getResult5).getStandardStructureType());
    assertNull(((PDStructureElement) getResult6).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult4).getStructureType());
    assertNull(((PDStructureElement) getResult5).getStructureType());
    assertNull(((PDStructureElement) getResult6).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult4).getTitle());
    assertNull(((PDStructureElement) getResult5).getTitle());
    assertNull(((PDStructureElement) getResult6).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult4).getType());
    assertNull(((PDStructureElement) getResult5).getType());
    assertNull(((PDStructureElement) getResult6).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult5).getPage());
    assertNull(((PDStructureElement) getResult6).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertNull(((PDStructureElement) getResult).getParent());
    assertNull(((PDStructureElement) getResult3).getParent());
    assertNull(((PDStructureElement) getResult5).getParent());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult6).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult4).getClassNames().size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult4).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic2, toListResult.get(0));
    assertSame(dic, toListResult.get(2));
    assertSame(dic2, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  void testInsertBefore13() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult2).getParent() instanceof PDStructureTreeRoot);
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertSame(dic, getResult);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  void testInsertBefore14() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    COSInteger cosInteger = COSInteger.ONE;

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(dic2), cosInteger);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = kids.get(2);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(3, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    Object getResult4 = kids2.get(2);
    assertTrue(getResult4 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(3, kids3.size());
    Object getResult5 = kids3.get(0);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids3.get(2);
    assertTrue(getResult6 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult6).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult4).getActualText());
    assertNull(((PDStructureElement) getResult5).getActualText());
    assertNull(((PDStructureElement) getResult6).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult4).getAlternateDescription());
    assertNull(((PDStructureElement) getResult5).getAlternateDescription());
    assertNull(((PDStructureElement) getResult6).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult4).getElementIdentifier());
    assertNull(((PDStructureElement) getResult5).getElementIdentifier());
    assertNull(((PDStructureElement) getResult6).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult4).getExpandedForm());
    assertNull(((PDStructureElement) getResult5).getExpandedForm());
    assertNull(((PDStructureElement) getResult6).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult4).getLanguage());
    assertNull(((PDStructureElement) getResult5).getLanguage());
    assertNull(((PDStructureElement) getResult6).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult4).getStandardStructureType());
    assertNull(((PDStructureElement) getResult5).getStandardStructureType());
    assertNull(((PDStructureElement) getResult6).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult4).getStructureType());
    assertNull(((PDStructureElement) getResult5).getStructureType());
    assertNull(((PDStructureElement) getResult6).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult4).getTitle());
    assertNull(((PDStructureElement) getResult5).getTitle());
    assertNull(((PDStructureElement) getResult6).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult4).getType());
    assertNull(((PDStructureElement) getResult5).getType());
    assertNull(((PDStructureElement) getResult6).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult5).getPage());
    assertNull(((PDStructureElement) getResult6).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertNull(((PDStructureElement) getResult).getParent());
    assertNull(((PDStructureElement) getResult3).getParent());
    assertNull(((PDStructureElement) getResult5).getParent());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult6).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult4).getClassNames().size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult4).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic2, toListResult.get(0));
    assertSame(dic, toListResult.get(2));
    assertSame(dic2, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(cosInteger.ONE, toListResult.get(1));
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    COSIncrement toIncrementResult = pdStructureTreeRoot.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualRemoveKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid3() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSFloat.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSName.A);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid((COSBase) null);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid9() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid10() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
    assertSame(cOSObject, parent.getCOSObject());
    assertSame(cOSObject, parent2.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid11() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid13() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.THREE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    assertEquals(2, pdStructureTreeRoot.getKids().size());
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid14() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSName.A);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  void testRemoveKid15() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.AA);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSName.A);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult3).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertFalse(actualRemoveKidResult);
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid16() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    assertFalse(actualRemoveKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid17() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid18() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid19() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid20() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid21() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(null));

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid22() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid((PDStructureElement) null);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid23() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid24() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  void testRemoveKid25() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(null);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertFalse(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(1, kids3.size());
    Object getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertTrue(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(objectable.getCOSObject()).thenReturn(cosArray);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertTrue(actualRemoveObjectableKidResult);
    assertSame(cosArray, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.TRUE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSFloat.ONE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSInteger.ONE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSName.A);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid11() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(null);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid12() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid13() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(null);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  void testRemoveObjectableKid14() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.TRUE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(newKid).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    assertSame(dic, k);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSInteger);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSName);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(null);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBoolean cosBoolean2 = cosBoolean.FALSE;
    assertSame(cosBoolean2, toListResult.get(0));
    assertSame(cosBoolean2, toListResult.get(1));
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, new PDDictionaryWrapper());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore11() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");
    when(objectable.getCOSObject()).thenReturn(parseHexResult);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSString);
    assertSame(parseHexResult, k);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(dic, toListResult.get(0));
    COSBoolean cosBoolean2 = cosBoolean.FALSE;
    assertSame(cosBoolean2, toListResult.get(1));
    assertSame(cosBoolean2, toListResult.get(2));
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore13() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSInteger cosInteger = COSInteger.THREE;

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, cosInteger);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSInteger);
    assertSame(cosInteger.ONE, k);
  }

  /**
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  void testInsertObjectableBefore14() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSObject);
    assertSame(object, k);
  }

  /**
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  void testCreateObject() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).createObject(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  void testCreateObject2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualCreateObjectResult);
  }

  /**
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  void testCreateObject3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    pdStructureTreeRoot.createObject(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  void testCreateObject4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary kid = new COSDictionary();

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(kid);

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(actualCreateObjectResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) actualCreateObjectResult).getActualText());
    assertNull(((PDStructureElement) actualCreateObjectResult).getAlternateDescription());
    assertNull(((PDStructureElement) actualCreateObjectResult).getElementIdentifier());
    assertNull(((PDStructureElement) actualCreateObjectResult).getExpandedForm());
    assertNull(((PDStructureElement) actualCreateObjectResult).getLanguage());
    assertNull(((PDStructureElement) actualCreateObjectResult).getStandardStructureType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getStructureType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getTitle());
    assertNull(((PDStructureElement) actualCreateObjectResult).getType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getPage());
    assertNull(((PDStructureElement) actualCreateObjectResult).getParent());
    assertEquals(0, ((PDStructureElement) actualCreateObjectResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) actualCreateObjectResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) actualCreateObjectResult).getClassNames().size());
    assertTrue(((PDStructureElement) actualCreateObjectResult).getKids().isEmpty());
    assertSame(kid, ((PDStructureElement) actualCreateObjectResult).getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  void testCreateObject5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot
        .createObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualCreateObjectResult);
  }

  /**
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  void testCreateObject6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary object = new COSDictionary();

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(new COSObject(object, new COSObjectKey(1L, 1)));

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(actualCreateObjectResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) actualCreateObjectResult).getActualText());
    assertNull(((PDStructureElement) actualCreateObjectResult).getAlternateDescription());
    assertNull(((PDStructureElement) actualCreateObjectResult).getElementIdentifier());
    assertNull(((PDStructureElement) actualCreateObjectResult).getExpandedForm());
    assertNull(((PDStructureElement) actualCreateObjectResult).getLanguage());
    assertNull(((PDStructureElement) actualCreateObjectResult).getStandardStructureType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getStructureType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getTitle());
    assertNull(((PDStructureElement) actualCreateObjectResult).getType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getPage());
    assertNull(((PDStructureElement) actualCreateObjectResult).getParent());
    assertEquals(0, ((PDStructureElement) actualCreateObjectResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) actualCreateObjectResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) actualCreateObjectResult).getClassNames().size());
    assertTrue(((PDStructureElement) actualCreateObjectResult).getKids().isEmpty());
    assertSame(object, ((PDStructureElement) actualCreateObjectResult).getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  void testAppendObjectableKid() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(null);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  void testAppendObjectableKid2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

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
    assertSame(cosDictionary, ((PDStructureElement) getResult).getCOSObject());
    assertSame(cosDictionary, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  void testAppendObjectableKid3() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureTreeRoot.appendObjectableKid(objectable));
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  void testAppendObjectableKid4() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic2));
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(objectable.getCOSObject()).thenReturn(cosArray);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = kids.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult3 = kids2.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    Object getResult4 = kids2.get(1);
    assertTrue(getResult4 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult5 = kids3.get(0);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids3.get(1);
    assertTrue(getResult6 instanceof PDStructureElement);
    PDStructureNode parent3 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids4 = parent3.getKids();
    assertEquals(2, kids4.size());
    Object getResult7 = kids4.get(0);
    assertTrue(getResult7 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    PDStructureNode parent4 = ((PDStructureElement) getResult4).getParent();
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    PDStructureNode parent5 = ((PDStructureElement) getResult5).getParent();
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    PDStructureNode parent6 = ((PDStructureElement) getResult6).getParent();
    assertTrue(parent6 instanceof PDStructureTreeRoot);
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
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, parent4.getKids().size());
    assertEquals(2, parent5.getKids().size());
    assertEquals(2, parent6.getKids().size());
    assertEquals(2, cOSObject.size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(cosArray, toListResult.get(2));
    assertSame(dic, toListResult.get(0));
    assertSame(dic2, toListResult.get(1));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult7).getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  void testAppendObjectableKid5() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic2));
    COSObjectable objectable = mock(COSObjectable.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = kids.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    Object getResult3 = kids.get(2);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(3, kids2.size());
    Object getResult4 = kids2.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    Object getResult5 = kids2.get(1);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids2.get(2);
    assertTrue(getResult6 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(3, kids3.size());
    Object getResult7 = kids3.get(0);
    assertTrue(getResult7 instanceof PDStructureElement);
    Object getResult8 = kids3.get(1);
    assertTrue(getResult8 instanceof PDStructureElement);
    Object getResult9 = kids3.get(2);
    assertTrue(getResult9 instanceof PDStructureElement);
    PDStructureNode parent3 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids4 = parent3.getKids();
    assertEquals(3, kids4.size());
    Object getResult10 = kids4.get(0);
    assertTrue(getResult10 instanceof PDStructureElement);
    Object getResult11 = kids4.get(2);
    assertTrue(getResult11 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult5).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(3, kids5.size());
    Object getResult12 = kids5.get(2);
    assertTrue(getResult12 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult7).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(3, kids6.size());
    Object getResult13 = kids6.get(2);
    assertTrue(getResult13 instanceof PDStructureElement);
    PDStructureNode parent6 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids7 = parent6.getKids();
    assertEquals(3, kids7.size());
    Object getResult14 = kids7.get(2);
    assertTrue(getResult14 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(parent6 instanceof PDStructureTreeRoot);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult3).getActualText());
    assertNull(((PDStructureElement) getResult6).getActualText());
    assertNull(((PDStructureElement) getResult9).getActualText());
    assertNull(((PDStructureElement) getResult11).getActualText());
    assertNull(((PDStructureElement) getResult12).getActualText());
    assertNull(((PDStructureElement) getResult13).getActualText());
    assertNull(((PDStructureElement) getResult14).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult3).getAlternateDescription());
    assertNull(((PDStructureElement) getResult6).getAlternateDescription());
    assertNull(((PDStructureElement) getResult9).getAlternateDescription());
    assertNull(((PDStructureElement) getResult11).getAlternateDescription());
    assertNull(((PDStructureElement) getResult12).getAlternateDescription());
    assertNull(((PDStructureElement) getResult13).getAlternateDescription());
    assertNull(((PDStructureElement) getResult14).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult3).getElementIdentifier());
    assertNull(((PDStructureElement) getResult6).getElementIdentifier());
    assertNull(((PDStructureElement) getResult9).getElementIdentifier());
    assertNull(((PDStructureElement) getResult11).getElementIdentifier());
    assertNull(((PDStructureElement) getResult12).getElementIdentifier());
    assertNull(((PDStructureElement) getResult13).getElementIdentifier());
    assertNull(((PDStructureElement) getResult14).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult3).getExpandedForm());
    assertNull(((PDStructureElement) getResult6).getExpandedForm());
    assertNull(((PDStructureElement) getResult9).getExpandedForm());
    assertNull(((PDStructureElement) getResult11).getExpandedForm());
    assertNull(((PDStructureElement) getResult12).getExpandedForm());
    assertNull(((PDStructureElement) getResult13).getExpandedForm());
    assertNull(((PDStructureElement) getResult14).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult3).getLanguage());
    assertNull(((PDStructureElement) getResult6).getLanguage());
    assertNull(((PDStructureElement) getResult9).getLanguage());
    assertNull(((PDStructureElement) getResult11).getLanguage());
    assertNull(((PDStructureElement) getResult12).getLanguage());
    assertNull(((PDStructureElement) getResult13).getLanguage());
    assertNull(((PDStructureElement) getResult14).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult3).getStandardStructureType());
    assertNull(((PDStructureElement) getResult6).getStandardStructureType());
    assertNull(((PDStructureElement) getResult9).getStandardStructureType());
    assertNull(((PDStructureElement) getResult11).getStandardStructureType());
    assertNull(((PDStructureElement) getResult12).getStandardStructureType());
    assertNull(((PDStructureElement) getResult13).getStandardStructureType());
    assertNull(((PDStructureElement) getResult14).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult3).getStructureType());
    assertNull(((PDStructureElement) getResult6).getStructureType());
    assertNull(((PDStructureElement) getResult9).getStructureType());
    assertNull(((PDStructureElement) getResult11).getStructureType());
    assertNull(((PDStructureElement) getResult12).getStructureType());
    assertNull(((PDStructureElement) getResult13).getStructureType());
    assertNull(((PDStructureElement) getResult14).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult3).getTitle());
    assertNull(((PDStructureElement) getResult6).getTitle());
    assertNull(((PDStructureElement) getResult9).getTitle());
    assertNull(((PDStructureElement) getResult11).getTitle());
    assertNull(((PDStructureElement) getResult12).getTitle());
    assertNull(((PDStructureElement) getResult13).getTitle());
    assertNull(((PDStructureElement) getResult14).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult3).getType());
    assertNull(((PDStructureElement) getResult6).getType());
    assertNull(((PDStructureElement) getResult9).getType());
    assertNull(((PDStructureElement) getResult11).getType());
    assertNull(((PDStructureElement) getResult12).getType());
    assertNull(((PDStructureElement) getResult13).getType());
    assertNull(((PDStructureElement) getResult14).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult6).getPage());
    assertNull(((PDStructureElement) getResult9).getPage());
    assertNull(((PDStructureElement) getResult11).getPage());
    assertNull(((PDStructureElement) getResult12).getPage());
    assertNull(((PDStructureElement) getResult13).getPage());
    assertNull(((PDStructureElement) getResult14).getPage());
    assertNull(((PDStructureElement) getResult3).getParent());
    assertNull(((PDStructureElement) getResult6).getParent());
    assertNull(((PDStructureElement) getResult9).getParent());
    assertNull(((PDStructureElement) getResult11).getParent());
    assertNull(((PDStructureElement) getResult12).getParent());
    assertNull(((PDStructureElement) getResult13).getParent());
    assertNull(((PDStructureElement) getResult14).getParent());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult6).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult9).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult11).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult12).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult13).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult14).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult6).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult9).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult6).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult9).getClassNames().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult6).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult9).getKids().isEmpty());
    assertSame(dic, toListResult.get(0));
    assertSame(dic2, toListResult.get(1));
    assertSame(cosDictionary, toListResult.get(2));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult9).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult10).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult11).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult12).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult13).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult14).getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  void testAppendObjectableKid6() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setKey(new COSObjectKey(2L, 2));
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

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
    assertSame(cosDictionary, ((PDStructureElement) getResult).getCOSObject());
    assertSame(cosDictionary, pdStructureTreeRoot.getK());
  }

  /**
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  void testAppendObjectableKid7() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSDictionary dic2 = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic2));

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(2L, 2);

    cosDictionary.setKey(key);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSObject);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    Object getResult3 = kids.get(1);
    assertTrue(getResult3 instanceof PDStructureElement);
    Object getResult4 = kids.get(2);
    assertTrue(getResult4 instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult2).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(3, kids2.size());
    Object getResult5 = kids2.get(0);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids2.get(1);
    assertTrue(getResult6 instanceof PDStructureElement);
    Object getResult7 = kids2.get(2);
    assertTrue(getResult7 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(3, kids3.size());
    Object getResult8 = kids3.get(0);
    assertTrue(getResult8 instanceof PDStructureElement);
    Object getResult9 = kids3.get(1);
    assertTrue(getResult9 instanceof PDStructureElement);
    Object getResult10 = kids3.get(2);
    assertTrue(getResult10 instanceof PDStructureElement);
    PDStructureNode parent3 = ((PDStructureElement) getResult5).getParent();
    List<Object> kids4 = parent3.getKids();
    assertEquals(3, kids4.size());
    Object getResult11 = kids4.get(0);
    assertTrue(getResult11 instanceof PDStructureElement);
    Object getResult12 = kids4.get(2);
    assertTrue(getResult12 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult6).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(3, kids5.size());
    Object getResult13 = kids5.get(2);
    assertTrue(getResult13 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(3, kids6.size());
    Object getResult14 = kids6.get(2);
    assertTrue(getResult14 instanceof PDStructureElement);
    PDStructureNode parent6 = ((PDStructureElement) getResult9).getParent();
    List<Object> kids7 = parent6.getKids();
    assertEquals(3, kids7.size());
    Object getResult15 = kids7.get(2);
    assertTrue(getResult15 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(parent6 instanceof PDStructureTreeRoot);
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult4).getActualText());
    assertNull(((PDStructureElement) getResult7).getActualText());
    assertNull(((PDStructureElement) getResult10).getActualText());
    assertNull(((PDStructureElement) getResult12).getActualText());
    assertNull(((PDStructureElement) getResult13).getActualText());
    assertNull(((PDStructureElement) getResult14).getActualText());
    assertNull(((PDStructureElement) getResult15).getActualText());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult4).getAlternateDescription());
    assertNull(((PDStructureElement) getResult7).getAlternateDescription());
    assertNull(((PDStructureElement) getResult10).getAlternateDescription());
    assertNull(((PDStructureElement) getResult12).getAlternateDescription());
    assertNull(((PDStructureElement) getResult13).getAlternateDescription());
    assertNull(((PDStructureElement) getResult14).getAlternateDescription());
    assertNull(((PDStructureElement) getResult15).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult4).getElementIdentifier());
    assertNull(((PDStructureElement) getResult7).getElementIdentifier());
    assertNull(((PDStructureElement) getResult10).getElementIdentifier());
    assertNull(((PDStructureElement) getResult12).getElementIdentifier());
    assertNull(((PDStructureElement) getResult13).getElementIdentifier());
    assertNull(((PDStructureElement) getResult14).getElementIdentifier());
    assertNull(((PDStructureElement) getResult15).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult4).getExpandedForm());
    assertNull(((PDStructureElement) getResult7).getExpandedForm());
    assertNull(((PDStructureElement) getResult10).getExpandedForm());
    assertNull(((PDStructureElement) getResult12).getExpandedForm());
    assertNull(((PDStructureElement) getResult13).getExpandedForm());
    assertNull(((PDStructureElement) getResult14).getExpandedForm());
    assertNull(((PDStructureElement) getResult15).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult4).getLanguage());
    assertNull(((PDStructureElement) getResult7).getLanguage());
    assertNull(((PDStructureElement) getResult10).getLanguage());
    assertNull(((PDStructureElement) getResult12).getLanguage());
    assertNull(((PDStructureElement) getResult13).getLanguage());
    assertNull(((PDStructureElement) getResult14).getLanguage());
    assertNull(((PDStructureElement) getResult15).getLanguage());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult4).getStandardStructureType());
    assertNull(((PDStructureElement) getResult7).getStandardStructureType());
    assertNull(((PDStructureElement) getResult10).getStandardStructureType());
    assertNull(((PDStructureElement) getResult12).getStandardStructureType());
    assertNull(((PDStructureElement) getResult13).getStandardStructureType());
    assertNull(((PDStructureElement) getResult14).getStandardStructureType());
    assertNull(((PDStructureElement) getResult15).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult4).getStructureType());
    assertNull(((PDStructureElement) getResult7).getStructureType());
    assertNull(((PDStructureElement) getResult10).getStructureType());
    assertNull(((PDStructureElement) getResult12).getStructureType());
    assertNull(((PDStructureElement) getResult13).getStructureType());
    assertNull(((PDStructureElement) getResult14).getStructureType());
    assertNull(((PDStructureElement) getResult15).getStructureType());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult4).getTitle());
    assertNull(((PDStructureElement) getResult7).getTitle());
    assertNull(((PDStructureElement) getResult10).getTitle());
    assertNull(((PDStructureElement) getResult12).getTitle());
    assertNull(((PDStructureElement) getResult13).getTitle());
    assertNull(((PDStructureElement) getResult14).getTitle());
    assertNull(((PDStructureElement) getResult15).getTitle());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult4).getType());
    assertNull(((PDStructureElement) getResult7).getType());
    assertNull(((PDStructureElement) getResult10).getType());
    assertNull(((PDStructureElement) getResult12).getType());
    assertNull(((PDStructureElement) getResult13).getType());
    assertNull(((PDStructureElement) getResult14).getType());
    assertNull(((PDStructureElement) getResult15).getType());
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult7).getPage());
    assertNull(((PDStructureElement) getResult10).getPage());
    assertNull(((PDStructureElement) getResult12).getPage());
    assertNull(((PDStructureElement) getResult13).getPage());
    assertNull(((PDStructureElement) getResult14).getPage());
    assertNull(((PDStructureElement) getResult15).getPage());
    assertNull(((PDStructureElement) getResult4).getParent());
    assertNull(((PDStructureElement) getResult7).getParent());
    assertNull(((PDStructureElement) getResult10).getParent());
    assertNull(((PDStructureElement) getResult12).getParent());
    assertNull(((PDStructureElement) getResult13).getParent());
    assertNull(((PDStructureElement) getResult14).getParent());
    assertNull(((PDStructureElement) getResult15).getParent());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult7).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult10).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult12).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult13).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult14).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult15).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult7).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult10).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult4).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult7).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult10).getClassNames().size());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult4).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult7).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult10).getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(dic, toListResult.get(0));
    assertSame(dic2, toListResult.get(1));
    assertSame(cosDictionary, ((COSObject) getResult).getObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult7).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult10).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult11).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult12).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult13).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult14).getCOSObject());
    assertSame(cosDictionary, ((PDStructureElement) getResult15).getCOSObject());
    assertSame(key, getResult.getKey());
  }
}
