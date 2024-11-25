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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDStructureNodeDiffblueTest {
  /**
   * Test {@link PDStructureNode#create(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return ActualText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary(); then return ActualText is 'null'")
  void testCreate_whenCOSDictionary_thenReturnActualTextIsNull() {
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
   * Test {@link PDStructureNode#create(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  void testCreate_whenCOSStream_thenReturnCOSObjectIsCOSStream() {
    // Arrange
    COSStream node = new COSStream();

    // Act
    PDStructureNode actualCreateResult = PDStructureNode.create(node);

    // Assert
    assertTrue(actualCreateResult instanceof PDStructureElement);
    assertSame(node, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#getCOSObject()}.
   * <p>
   * Method under test: {@link PDStructureNode#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
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
   * Test {@link PDStructureNode#getType()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetType_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDStructureNode#getType()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return {@code StructTreeRoot}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDStructureTreeRoot(); then return 'StructTreeRoot'")
  void testGetType_givenPDStructureTreeRoot_thenReturnStructTreeRoot() {
    // Arrange, Act and Assert
    assertEquals("StructTreeRoot", (new PDStructureTreeRoot()).getType());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return Empty")
  void testGetKids_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot(new COSDictionary())).getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDStructureTreeRoot(); then return Empty")
  void testGetKids_givenPDStructureTreeRoot_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot()).getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Then return first Parent K toList first is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first Parent K toList first is COSDictionary()")
  void testGetKids_thenReturnFirstParentKToListFirstIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

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
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertSame(dic, toListResult.get(0));
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Then return first StandardStructureType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first StandardStructureType is 'null'")
  void testGetKids_thenReturnFirstStandardStructureTypeIsNull() {
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
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getType());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Then return first StandardStructureType is {@code Structure Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first StandardStructureType is 'Structure Type'")
  void testGetKids_thenReturnFirstStandardStructureTypeIsStructureType() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement("Structure Type", new PDStructureTreeRoot()));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualKids.size());
    Object getResult = actualKids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertEquals("Structure Type", ((PDStructureElement) getResult).getStandardStructureType());
    assertEquals("Structure Type", ((PDStructureElement) getResult).getStructureType());
    COSDictionary cOSObject = ((PDStructureElement) getResult).getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDStructureElement.TYPE, ((PDStructureElement) getResult).getType());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Then second Parent K return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then second Parent K return COSArray")
  void testGetKids_thenSecondParentKReturnCOSArray() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(2, actualKids.size());
    Object getResult = actualKids.get(1);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    COSBase k = ((PDStructureTreeRoot) parent).getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = parent.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((COSInteger) getResult2).isValid());
    assertSame(dic, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  void testSetKids() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    kids.add(cosObject);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(cosObject, toListResult.get(0));
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first
   * {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given '42'; then PDStructureTreeRoot() K toList first COSString")
  void testSetKids_given42_thenPDStructureTreeRootKToListFirstCOSString() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given '42'; when ArrayList() add '42'; then PDStructureTreeRoot() K toList size is two")
  void testSetKids_given42_whenArrayListAdd42_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    kids.add("42");

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
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
    assertFalse(((COSString) getResult).getForceHexForm());
    assertEquals(getResult, getResult2);
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray(); then PDStructureTreeRoot() K toList first is COSArray()")
  void testSetKids_givenCOSArray_thenPDStructureTreeRootKToListFirstIsCOSArray() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSArray cosArray = new COSArray();
    kids.add(cosArray);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(cosArray, toListResult.get(0));
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given MAX_VALUE; when ArrayList() add MAX_VALUE")
  void testSetKids_givenMax_value_whenArrayListAddMax_value() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(Long.MAX_VALUE);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(1, pdStructureTreeRoot.getKids().size());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given MIN_VALUE; when ArrayList() add MIN_VALUE")
  void testSetKids_givenMin_value_whenArrayListAddMin_value() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(Integer.MIN_VALUE);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(kids, pdStructureTreeRoot.getKids());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given minus one hundred.</li>
   *   <li>When {@link ArrayList#ArrayList()} add minus one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given minus one hundred; when ArrayList() add minus one hundred")
  void testSetKids_givenMinusOneHundred_whenArrayListAddMinusOneHundred() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(-100);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(kids, pdStructureTreeRoot.getKids());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first
   * {@link COSNull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given 'null'; then PDStructureTreeRoot() K toList first COSNull")
  void testSetKids_givenNull_thenPDStructureTreeRootKToListFirstCOSNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(null);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given one; when ArrayList() add one; then PDStructureTreeRoot() Kids size is one")
  void testSetKids_givenOne_whenArrayListAddOne_thenPDStructureTreeRootKidsSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(1L);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(1, pdStructureTreeRoot.getKids().size());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given PDDictionaryWrapper(); when ArrayList() add PDDictionaryWrapper()")
  void testSetKids_givenPDDictionaryWrapper_whenArrayListAddPDDictionaryWrapper() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(new PDDictionaryWrapper());

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    Object getResult = kids2.get(0);
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
    assertEquals(1, ((COSArray) k).toList().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first
   * {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given ten; then PDStructureTreeRoot() K toList first COSFloat")
  void testSetKids_givenTen_thenPDStructureTreeRootKToListFirstCOSFloat() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(10.0d);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first
   * {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given ten; then PDStructureTreeRoot() K toList first COSFloat")
  void testSetKids_givenTen_thenPDStructureTreeRootKToListFirstCOSFloat2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(10.0f);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given two; when ArrayList() add two; then PDStructureTreeRoot() Kids is ArrayList()")
  void testSetKids_givenTwo_whenArrayListAddTwo_thenPDStructureTreeRootKidsIsArrayList() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(2);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(kids, pdStructureTreeRoot.getKids());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDStructureTreeRoot() K toList first is COSDictionary()")
  void testSetKids_thenPDStructureTreeRootKToListFirstIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    kids.add(cosDictionary);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    Object getResult = kids2.get(0);
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
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(cosDictionary, toListResult.get(0));
    assertSame(cosDictionary, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); when ArrayList(); then PDStructureTreeRoot() COSObject Values size is two")
  void testSetKids_whenArrayList_thenPDStructureTreeRootCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'")
  void testAppendKidWithObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(new COSDictionary());
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSBoolean expectedK = object.FALSE;
    assertSame(expectedK, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() K is FALSE FALSE")
  void testAppendKidWithObject_thenPDStructureTreeRootKIsFalseFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSBoolean expectedK = object.FALSE;
    assertSame(expectedK, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() K toList size is three")
  void testAppendKidWithObject_thenPDStructureTreeRootKToListSizeIsThree() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(object.FALSE, toListResult.get(2));
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first
   * ActualText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first ActualText is 'null'")
  void testAppendKidWithObject_thenPDStructureTreeRootKidsFirstActualTextIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary object = new COSDictionary();

    // Act
    pdStructureTreeRoot.appendKid(object);

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
    assertSame(object, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first Parent
   * Kids size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first Parent Kids size is one")
  void testAppendKidWithObject_thenPDStructureTreeRootKidsFirstParentKidsSizeIsOne() {
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
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult4 = toListResult.get(0);
    assertSame(dic, getResult4);
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(getResult4, ((PDStructureElement) getResult).getCOSObject());
    assertSame(object.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; when COSObjectKey(long, int) with num is one and gen is one")
  void testAppendKidWithObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.appendKid(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  void testAppendKidWithObject_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.appendKid((COSBase) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test appendKid(PDStructureElement) with 'structureElement'")
  void testAppendKidWithStructureElement() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(dic);
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());

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
    assertTrue(parent instanceof PDStructureElement);
    assertTrue(parent2 instanceof PDStructureElement);
    assertTrue(parent3 instanceof PDStructureElement);
    assertTrue(parent4 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult4).getParent();
    assertTrue(parent5 instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult5).getParent() instanceof PDStructureElement);
    assertNull(((PDStructureElement) parent).getActualText());
    assertNull(((PDStructureElement) parent2).getActualText());
    assertNull(((PDStructureElement) parent3).getActualText());
    assertNull(((PDStructureElement) parent4).getActualText());
    assertNull(((PDStructureElement) parent5).getActualText());
    assertNull(((PDStructureElement) parent).getAlternateDescription());
    assertNull(((PDStructureElement) parent2).getAlternateDescription());
    assertNull(((PDStructureElement) parent3).getAlternateDescription());
    assertNull(((PDStructureElement) parent4).getAlternateDescription());
    assertNull(((PDStructureElement) parent5).getAlternateDescription());
    assertNull(((PDStructureElement) parent).getElementIdentifier());
    assertNull(((PDStructureElement) parent2).getElementIdentifier());
    assertNull(((PDStructureElement) parent3).getElementIdentifier());
    assertNull(((PDStructureElement) parent4).getElementIdentifier());
    assertNull(((PDStructureElement) parent5).getElementIdentifier());
    assertNull(((PDStructureElement) parent).getExpandedForm());
    assertNull(((PDStructureElement) parent2).getExpandedForm());
    assertNull(((PDStructureElement) parent3).getExpandedForm());
    assertNull(((PDStructureElement) parent4).getExpandedForm());
    assertNull(((PDStructureElement) parent5).getExpandedForm());
    assertNull(((PDStructureElement) parent).getLanguage());
    assertNull(((PDStructureElement) parent2).getLanguage());
    assertNull(((PDStructureElement) parent3).getLanguage());
    assertNull(((PDStructureElement) parent4).getLanguage());
    assertNull(((PDStructureElement) parent5).getLanguage());
    assertNull(((PDStructureElement) parent).getStandardStructureType());
    assertNull(((PDStructureElement) parent2).getStandardStructureType());
    assertNull(((PDStructureElement) parent3).getStandardStructureType());
    assertNull(((PDStructureElement) parent4).getStandardStructureType());
    assertNull(((PDStructureElement) parent5).getStandardStructureType());
    assertNull(((PDStructureElement) parent).getStructureType());
    assertNull(((PDStructureElement) parent2).getStructureType());
    assertNull(((PDStructureElement) parent3).getStructureType());
    assertNull(((PDStructureElement) parent4).getStructureType());
    assertNull(((PDStructureElement) parent5).getStructureType());
    assertNull(((PDStructureElement) parent).getTitle());
    assertNull(((PDStructureElement) parent2).getTitle());
    assertNull(((PDStructureElement) parent3).getTitle());
    assertNull(((PDStructureElement) parent4).getTitle());
    assertNull(((PDStructureElement) parent5).getTitle());
    assertNull(parent.getType());
    assertNull(parent2.getType());
    assertNull(parent3.getType());
    assertNull(parent4.getType());
    assertNull(parent5.getType());
    assertNull(((PDStructureElement) parent).getPage());
    assertNull(((PDStructureElement) parent2).getPage());
    assertNull(((PDStructureElement) parent3).getPage());
    assertNull(((PDStructureElement) parent4).getPage());
    assertNull(((PDStructureElement) parent5).getPage());
    assertNull(((PDStructureElement) parent).getParent());
    assertNull(((PDStructureElement) parent2).getParent());
    assertNull(((PDStructureElement) parent3).getParent());
    assertNull(((PDStructureElement) parent4).getParent());
    assertNull(((PDStructureElement) parent5).getParent());
    assertEquals(0, ((PDStructureElement) parent).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) parent2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) parent3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) parent4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) parent5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) parent).getAttributes().size());
    assertEquals(0, ((PDStructureElement) parent2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) parent3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) parent4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) parent5).getAttributes().size());
    assertEquals(0, ((PDStructureElement) parent).getClassNames().size());
    assertEquals(0, ((PDStructureElement) parent2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) parent3).getClassNames().size());
    assertEquals(0, ((PDStructureElement) parent4).getClassNames().size());
    assertEquals(0, ((PDStructureElement) parent5).getClassNames().size());
    assertSame(dic, parent.getCOSObject());
    assertSame(dic, parent2.getCOSObject());
    assertSame(dic, parent3.getCOSObject());
    assertSame(dic, parent4.getCOSObject());
    assertSame(dic, parent5.getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test appendKid(PDStructureElement) with 'structureElement'")
  void testAppendKidWithStructureElement2() {
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
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    Object getResult3 = kids.get(1);
    assertTrue(getResult3 instanceof PDStructureElement);
    Object getResult4 = kids.get(2);
    assertTrue(getResult4 instanceof PDStructureElement);
    List<Object> kids2 = parent.getKids();
    assertEquals(3, kids2.size());
    Object getResult5 = kids2.get(0);
    assertTrue(getResult5 instanceof PDStructureElement);
    Object getResult6 = kids2.get(1);
    assertTrue(getResult6 instanceof PDStructureElement);
    Object getResult7 = kids2.get(2);
    assertTrue(getResult7 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(3, kids3.size());
    Object getResult8 = kids3.get(0);
    assertTrue(getResult8 instanceof PDStructureElement);
    Object getResult9 = kids3.get(1);
    assertTrue(getResult9 instanceof PDStructureElement);
    Object getResult10 = kids3.get(2);
    assertTrue(getResult10 instanceof PDStructureElement);
    PDStructureNode parent3 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids4 = parent3.getKids();
    assertEquals(3, kids4.size());
    Object getResult11 = kids4.get(0);
    assertTrue(getResult11 instanceof PDStructureElement);
    Object getResult12 = kids4.get(1);
    assertTrue(getResult12 instanceof PDStructureElement);
    Object getResult13 = kids4.get(2);
    assertTrue(getResult13 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult4).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(3, kids5.size());
    Object getResult14 = kids5.get(0);
    assertTrue(getResult14 instanceof PDStructureElement);
    Object getResult15 = kids5.get(1);
    assertTrue(getResult15 instanceof PDStructureElement);
    Object getResult16 = kids5.get(2);
    assertTrue(getResult16 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult5).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(3, kids6.size());
    Object getResult17 = kids6.get(0);
    assertTrue(getResult17 instanceof PDStructureElement);
    Object getResult18 = kids6.get(1);
    assertTrue(getResult18 instanceof PDStructureElement);
    Object getResult19 = kids6.get(2);
    assertTrue(getResult19 instanceof PDStructureElement);
    PDStructureNode parent6 = ((PDStructureElement) getResult6).getParent();
    List<Object> kids7 = parent6.getKids();
    assertEquals(3, kids7.size());
    Object getResult20 = kids7.get(0);
    assertTrue(getResult20 instanceof PDStructureElement);
    Object getResult21 = kids7.get(1);
    assertTrue(getResult21 instanceof PDStructureElement);
    Object getResult22 = kids7.get(2);
    assertTrue(getResult22 instanceof PDStructureElement);
    PDStructureNode parent7 = ((PDStructureElement) getResult7).getParent();
    List<Object> kids8 = parent7.getKids();
    assertEquals(3, kids8.size());
    Object getResult23 = kids8.get(0);
    assertTrue(getResult23 instanceof PDStructureElement);
    Object getResult24 = kids8.get(1);
    assertTrue(getResult24 instanceof PDStructureElement);
    Object getResult25 = kids8.get(2);
    assertTrue(getResult25 instanceof PDStructureElement);
    PDStructureNode parent8 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids9 = parent8.getKids();
    assertEquals(3, kids9.size());
    Object getResult26 = kids9.get(1);
    assertTrue(getResult26 instanceof PDStructureElement);
    Object getResult27 = kids9.get(2);
    assertTrue(getResult27 instanceof PDStructureElement);
    PDStructureNode parent9 = ((PDStructureElement) getResult9).getParent();
    List<Object> kids10 = parent9.getKids();
    assertEquals(3, kids10.size());
    Object getResult28 = kids10.get(1);
    assertTrue(getResult28 instanceof PDStructureElement);
    Object getResult29 = kids10.get(2);
    assertTrue(getResult29 instanceof PDStructureElement);
    PDStructureNode parent10 = ((PDStructureElement) getResult10).getParent();
    List<Object> kids11 = parent10.getKids();
    assertEquals(3, kids11.size());
    Object getResult30 = kids11.get(0);
    assertTrue(getResult30 instanceof PDStructureElement);
    Object getResult31 = kids11.get(1);
    assertTrue(getResult31 instanceof PDStructureElement);
    Object getResult32 = kids11.get(2);
    assertTrue(getResult32 instanceof PDStructureElement);
    PDStructureNode parent11 = ((PDStructureElement) getResult11).getParent();
    List<Object> kids12 = parent11.getKids();
    assertEquals(3, kids12.size());
    Object getResult33 = kids12.get(1);
    assertTrue(getResult33 instanceof PDStructureElement);
    assertTrue(kids12.get(2) instanceof PDStructureElement);
    PDStructureNode parent12 = ((PDStructureElement) getResult12).getParent();
    List<Object> kids13 = parent12.getKids();
    assertEquals(3, kids13.size());
    assertTrue(kids13.get(2) instanceof PDStructureElement);
    PDStructureNode parent13 = ((PDStructureElement) getResult13).getParent();
    List<Object> kids14 = parent13.getKids();
    assertEquals(3, kids14.size());
    assertTrue(kids14.get(0) instanceof PDStructureElement);
    assertTrue(kids14.get(1) instanceof PDStructureElement);
    assertTrue(kids14.get(2) instanceof PDStructureElement);
    PDStructureNode parent14 = ((PDStructureElement) getResult14).getParent();
    List<Object> kids15 = parent14.getKids();
    assertEquals(3, kids15.size());
    assertTrue(kids15.get(0) instanceof PDStructureElement);
    assertTrue(kids15.get(1) instanceof PDStructureElement);
    assertTrue(kids15.get(2) instanceof PDStructureElement);
    PDStructureNode parent15 = ((PDStructureElement) getResult15).getParent();
    List<Object> kids16 = parent15.getKids();
    assertEquals(3, kids16.size());
    assertTrue(kids16.get(0) instanceof PDStructureElement);
    assertTrue(kids16.get(1) instanceof PDStructureElement);
    assertTrue(kids16.get(2) instanceof PDStructureElement);
    PDStructureNode parent16 = ((PDStructureElement) getResult16).getParent();
    List<Object> kids17 = parent16.getKids();
    assertEquals(3, kids17.size());
    assertTrue(kids17.get(0) instanceof PDStructureElement);
    assertTrue(kids17.get(1) instanceof PDStructureElement);
    assertTrue(kids17.get(2) instanceof PDStructureElement);
    PDStructureNode parent17 = ((PDStructureElement) getResult17).getParent();
    List<Object> kids18 = parent17.getKids();
    assertEquals(3, kids18.size());
    assertTrue(kids18.get(2) instanceof PDStructureElement);
    PDStructureNode parent18 = ((PDStructureElement) getResult18).getParent();
    List<Object> kids19 = parent18.getKids();
    assertEquals(3, kids19.size());
    assertTrue(kids19.get(2) instanceof PDStructureElement);
    PDStructureNode parent19 = ((PDStructureElement) getResult19).getParent();
    List<Object> kids20 = parent19.getKids();
    assertEquals(3, kids20.size());
    assertTrue(kids20.get(0) instanceof PDStructureElement);
    assertTrue(kids20.get(1) instanceof PDStructureElement);
    assertTrue(kids20.get(2) instanceof PDStructureElement);
    PDStructureNode parent20 = ((PDStructureElement) getResult20).getParent();
    List<Object> kids21 = parent20.getKids();
    assertEquals(3, kids21.size());
    assertTrue(kids21.get(2) instanceof PDStructureElement);
    PDStructureNode parent21 = ((PDStructureElement) getResult21).getParent();
    List<Object> kids22 = parent21.getKids();
    assertEquals(3, kids22.size());
    assertTrue(kids22.get(2) instanceof PDStructureElement);
    PDStructureNode parent22 = ((PDStructureElement) getResult22).getParent();
    List<Object> kids23 = parent22.getKids();
    assertEquals(3, kids23.size());
    assertTrue(kids23.get(0) instanceof PDStructureElement);
    assertTrue(kids23.get(1) instanceof PDStructureElement);
    assertTrue(kids23.get(2) instanceof PDStructureElement);
    PDStructureNode parent23 = ((PDStructureElement) getResult23).getParent();
    List<Object> kids24 = parent23.getKids();
    assertEquals(3, kids24.size());
    assertTrue(kids24.get(0) instanceof PDStructureElement);
    assertTrue(kids24.get(1) instanceof PDStructureElement);
    assertTrue(kids24.get(2) instanceof PDStructureElement);
    PDStructureNode parent24 = ((PDStructureElement) getResult24).getParent();
    List<Object> kids25 = parent24.getKids();
    assertEquals(3, kids25.size());
    assertTrue(kids25.get(0) instanceof PDStructureElement);
    assertTrue(kids25.get(1) instanceof PDStructureElement);
    assertTrue(kids25.get(2) instanceof PDStructureElement);
    PDStructureNode parent25 = ((PDStructureElement) getResult25).getParent();
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
    assertTrue(((PDStructureElement) getResult27).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult29).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult30).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult31).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult32).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent4.getType());
    assertEquals("StructTreeRoot", parent7.getType());
    assertEquals("StructTreeRoot", parent10.getType());
    assertEquals("StructTreeRoot", parent13.getType());
    assertEquals("StructTreeRoot", parent14.getType());
    assertEquals("StructTreeRoot", parent15.getType());
    assertEquals("StructTreeRoot", parent16.getType());
    assertEquals("StructTreeRoot", parent19.getType());
    assertEquals("StructTreeRoot", parent22.getType());
    assertEquals("StructTreeRoot", parent23.getType());
    assertEquals("StructTreeRoot", parent24.getType());
    assertEquals("StructTreeRoot", parent25.getType());
    assertNull(((PDStructureElement) getResult4).getActualText());
    assertNull(((PDStructureElement) getResult7).getActualText());
    assertNull(((PDStructureElement) getResult10).getActualText());
    assertNull(((PDStructureElement) getResult13).getActualText());
    assertNull(((PDStructureElement) getResult14).getActualText());
    assertNull(((PDStructureElement) getResult15).getActualText());
    assertNull(((PDStructureElement) getResult16).getActualText());
    assertNull(((PDStructureElement) getResult19).getActualText());
    assertNull(((PDStructureElement) getResult22).getActualText());
    assertNull(((PDStructureElement) getResult23).getActualText());
    assertNull(((PDStructureElement) getResult24).getActualText());
    assertNull(((PDStructureElement) getResult25).getActualText());
    assertNull(((PDStructureElement) getResult27).getActualText());
    assertNull(((PDStructureElement) getResult29).getActualText());
    assertNull(((PDStructureElement) getResult30).getActualText());
    assertNull(((PDStructureElement) getResult31).getActualText());
    assertNull(((PDStructureElement) getResult32).getActualText());
    assertNull(((PDStructureElement) getResult4).getAlternateDescription());
    assertNull(((PDStructureElement) getResult7).getAlternateDescription());
    assertNull(((PDStructureElement) getResult10).getAlternateDescription());
    assertNull(((PDStructureElement) getResult13).getAlternateDescription());
    assertNull(((PDStructureElement) getResult14).getAlternateDescription());
    assertNull(((PDStructureElement) getResult15).getAlternateDescription());
    assertNull(((PDStructureElement) getResult16).getAlternateDescription());
    assertNull(((PDStructureElement) getResult19).getAlternateDescription());
    assertNull(((PDStructureElement) getResult22).getAlternateDescription());
    assertNull(((PDStructureElement) getResult23).getAlternateDescription());
    assertNull(((PDStructureElement) getResult24).getAlternateDescription());
    assertNull(((PDStructureElement) getResult25).getAlternateDescription());
    assertNull(((PDStructureElement) getResult27).getAlternateDescription());
    assertNull(((PDStructureElement) getResult29).getAlternateDescription());
    assertNull(((PDStructureElement) getResult30).getAlternateDescription());
    assertNull(((PDStructureElement) getResult31).getAlternateDescription());
    assertNull(((PDStructureElement) getResult32).getAlternateDescription());
    assertNull(((PDStructureElement) getResult4).getElementIdentifier());
    assertNull(((PDStructureElement) getResult7).getElementIdentifier());
    assertNull(((PDStructureElement) getResult10).getElementIdentifier());
    assertNull(((PDStructureElement) getResult13).getElementIdentifier());
    assertNull(((PDStructureElement) getResult14).getElementIdentifier());
    assertNull(((PDStructureElement) getResult15).getElementIdentifier());
    assertNull(((PDStructureElement) getResult16).getElementIdentifier());
    assertNull(((PDStructureElement) getResult19).getElementIdentifier());
    assertNull(((PDStructureElement) getResult22).getElementIdentifier());
    assertNull(((PDStructureElement) getResult23).getElementIdentifier());
    assertNull(((PDStructureElement) getResult24).getElementIdentifier());
    assertNull(((PDStructureElement) getResult25).getElementIdentifier());
    assertNull(((PDStructureElement) getResult27).getElementIdentifier());
    assertNull(((PDStructureElement) getResult29).getElementIdentifier());
    assertNull(((PDStructureElement) getResult30).getElementIdentifier());
    assertNull(((PDStructureElement) getResult31).getElementIdentifier());
    assertNull(((PDStructureElement) getResult32).getElementIdentifier());
    assertNull(((PDStructureElement) getResult4).getExpandedForm());
    assertNull(((PDStructureElement) getResult7).getExpandedForm());
    assertNull(((PDStructureElement) getResult10).getExpandedForm());
    assertNull(((PDStructureElement) getResult13).getExpandedForm());
    assertNull(((PDStructureElement) getResult14).getExpandedForm());
    assertNull(((PDStructureElement) getResult15).getExpandedForm());
    assertNull(((PDStructureElement) getResult16).getExpandedForm());
    assertNull(((PDStructureElement) getResult19).getExpandedForm());
    assertNull(((PDStructureElement) getResult22).getExpandedForm());
    assertNull(((PDStructureElement) getResult23).getExpandedForm());
    assertNull(((PDStructureElement) getResult24).getExpandedForm());
    assertNull(((PDStructureElement) getResult25).getExpandedForm());
    assertNull(((PDStructureElement) getResult27).getExpandedForm());
    assertNull(((PDStructureElement) getResult29).getExpandedForm());
    assertNull(((PDStructureElement) getResult30).getExpandedForm());
    assertNull(((PDStructureElement) getResult31).getExpandedForm());
    assertNull(((PDStructureElement) getResult32).getExpandedForm());
    assertNull(((PDStructureElement) getResult4).getLanguage());
    assertNull(((PDStructureElement) getResult7).getLanguage());
    assertNull(((PDStructureElement) getResult10).getLanguage());
    assertNull(((PDStructureElement) getResult13).getLanguage());
    assertNull(((PDStructureElement) getResult14).getLanguage());
    assertNull(((PDStructureElement) getResult15).getLanguage());
    assertNull(((PDStructureElement) getResult16).getLanguage());
    assertNull(((PDStructureElement) getResult19).getLanguage());
    assertNull(((PDStructureElement) getResult22).getLanguage());
    assertNull(((PDStructureElement) getResult23).getLanguage());
    assertNull(((PDStructureElement) getResult24).getLanguage());
    assertNull(((PDStructureElement) getResult25).getLanguage());
    assertNull(((PDStructureElement) getResult27).getLanguage());
    assertNull(((PDStructureElement) getResult29).getLanguage());
    assertNull(((PDStructureElement) getResult30).getLanguage());
    assertNull(((PDStructureElement) getResult31).getLanguage());
    assertNull(((PDStructureElement) getResult32).getLanguage());
    assertNull(((PDStructureElement) getResult4).getStandardStructureType());
    assertNull(((PDStructureElement) getResult7).getStandardStructureType());
    assertNull(((PDStructureElement) getResult10).getStandardStructureType());
    assertNull(((PDStructureElement) getResult13).getStandardStructureType());
    assertNull(((PDStructureElement) getResult14).getStandardStructureType());
    assertNull(((PDStructureElement) getResult15).getStandardStructureType());
    assertNull(((PDStructureElement) getResult16).getStandardStructureType());
    assertNull(((PDStructureElement) getResult19).getStandardStructureType());
    assertNull(((PDStructureElement) getResult22).getStandardStructureType());
    assertNull(((PDStructureElement) getResult23).getStandardStructureType());
    assertNull(((PDStructureElement) getResult24).getStandardStructureType());
    assertNull(((PDStructureElement) getResult25).getStandardStructureType());
    assertNull(((PDStructureElement) getResult27).getStandardStructureType());
    assertNull(((PDStructureElement) getResult29).getStandardStructureType());
    assertNull(((PDStructureElement) getResult30).getStandardStructureType());
    assertNull(((PDStructureElement) getResult31).getStandardStructureType());
    assertNull(((PDStructureElement) getResult32).getStandardStructureType());
    assertNull(((PDStructureElement) getResult4).getStructureType());
    assertNull(((PDStructureElement) getResult7).getStructureType());
    assertNull(((PDStructureElement) getResult10).getStructureType());
    assertNull(((PDStructureElement) getResult13).getStructureType());
    assertNull(((PDStructureElement) getResult14).getStructureType());
    assertNull(((PDStructureElement) getResult15).getStructureType());
    assertNull(((PDStructureElement) getResult16).getStructureType());
    assertNull(((PDStructureElement) getResult19).getStructureType());
    assertNull(((PDStructureElement) getResult22).getStructureType());
    assertNull(((PDStructureElement) getResult23).getStructureType());
    assertNull(((PDStructureElement) getResult24).getStructureType());
    assertNull(((PDStructureElement) getResult25).getStructureType());
    assertNull(((PDStructureElement) getResult27).getStructureType());
    assertNull(((PDStructureElement) getResult29).getStructureType());
    assertNull(((PDStructureElement) getResult30).getStructureType());
    assertNull(((PDStructureElement) getResult31).getStructureType());
    assertNull(((PDStructureElement) getResult32).getStructureType());
    assertNull(((PDStructureElement) getResult4).getTitle());
    assertNull(((PDStructureElement) getResult7).getTitle());
    assertNull(((PDStructureElement) getResult10).getTitle());
    assertNull(((PDStructureElement) getResult13).getTitle());
    assertNull(((PDStructureElement) getResult14).getTitle());
    assertNull(((PDStructureElement) getResult15).getTitle());
    assertNull(((PDStructureElement) getResult16).getTitle());
    assertNull(((PDStructureElement) getResult19).getTitle());
    assertNull(((PDStructureElement) getResult22).getTitle());
    assertNull(((PDStructureElement) getResult23).getTitle());
    assertNull(((PDStructureElement) getResult24).getTitle());
    assertNull(((PDStructureElement) getResult25).getTitle());
    assertNull(((PDStructureElement) getResult27).getTitle());
    assertNull(((PDStructureElement) getResult29).getTitle());
    assertNull(((PDStructureElement) getResult30).getTitle());
    assertNull(((PDStructureElement) getResult31).getTitle());
    assertNull(((PDStructureElement) getResult32).getTitle());
    assertNull(((PDStructureElement) getResult4).getType());
    assertNull(((PDStructureElement) getResult7).getType());
    assertNull(((PDStructureElement) getResult10).getType());
    assertNull(((PDStructureElement) getResult13).getType());
    assertNull(((PDStructureElement) getResult14).getType());
    assertNull(((PDStructureElement) getResult15).getType());
    assertNull(((PDStructureElement) getResult16).getType());
    assertNull(((PDStructureElement) getResult19).getType());
    assertNull(((PDStructureElement) getResult22).getType());
    assertNull(((PDStructureElement) getResult23).getType());
    assertNull(((PDStructureElement) getResult24).getType());
    assertNull(((PDStructureElement) getResult25).getType());
    assertNull(((PDStructureElement) getResult27).getType());
    assertNull(((PDStructureElement) getResult29).getType());
    assertNull(((PDStructureElement) getResult30).getType());
    assertNull(((PDStructureElement) getResult31).getType());
    assertNull(((PDStructureElement) getResult32).getType());
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult7).getPage());
    assertNull(((PDStructureElement) getResult10).getPage());
    assertNull(((PDStructureElement) getResult13).getPage());
    assertNull(((PDStructureElement) getResult14).getPage());
    assertNull(((PDStructureElement) getResult15).getPage());
    assertNull(((PDStructureElement) getResult16).getPage());
    assertNull(((PDStructureElement) getResult19).getPage());
    assertNull(((PDStructureElement) getResult22).getPage());
    assertNull(((PDStructureElement) getResult23).getPage());
    assertNull(((PDStructureElement) getResult24).getPage());
    assertNull(((PDStructureElement) getResult25).getPage());
    assertNull(((PDStructureElement) getResult27).getPage());
    assertNull(((PDStructureElement) getResult29).getPage());
    assertNull(((PDStructureElement) getResult30).getPage());
    assertNull(((PDStructureElement) getResult31).getPage());
    assertNull(((PDStructureElement) getResult32).getPage());
    assertNull(((PDStructureTreeRoot) parent4).getIDTree());
    assertNull(((PDStructureTreeRoot) parent7).getIDTree());
    assertNull(((PDStructureTreeRoot) parent10).getIDTree());
    assertNull(((PDStructureTreeRoot) parent13).getIDTree());
    assertNull(((PDStructureTreeRoot) parent14).getIDTree());
    assertNull(((PDStructureTreeRoot) parent15).getIDTree());
    assertNull(((PDStructureTreeRoot) parent16).getIDTree());
    assertNull(((PDStructureTreeRoot) parent19).getIDTree());
    assertNull(((PDStructureTreeRoot) parent22).getIDTree());
    assertNull(((PDStructureTreeRoot) parent23).getIDTree());
    assertNull(((PDStructureTreeRoot) parent24).getIDTree());
    assertNull(((PDStructureTreeRoot) parent25).getIDTree());
    assertNull(((PDStructureTreeRoot) parent4).getParentTree());
    assertNull(((PDStructureTreeRoot) parent7).getParentTree());
    assertNull(((PDStructureTreeRoot) parent10).getParentTree());
    assertNull(((PDStructureTreeRoot) parent13).getParentTree());
    assertNull(((PDStructureTreeRoot) parent14).getParentTree());
    assertNull(((PDStructureTreeRoot) parent15).getParentTree());
    assertNull(((PDStructureTreeRoot) parent16).getParentTree());
    assertNull(((PDStructureTreeRoot) parent19).getParentTree());
    assertNull(((PDStructureTreeRoot) parent22).getParentTree());
    assertNull(((PDStructureTreeRoot) parent23).getParentTree());
    assertNull(((PDStructureTreeRoot) parent24).getParentTree());
    assertNull(((PDStructureTreeRoot) parent25).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent4).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent7).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent10).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent13).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent14).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent15).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent16).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent19).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent22).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent23).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent24).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent25).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult7).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult10).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult13).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult14).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult15).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult16).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult19).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult22).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult23).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult24).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult25).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult27).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult29).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult30).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult31).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult32).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult7).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult10).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult13).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult14).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult15).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult16).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult19).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult22).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult23).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult24).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult25).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult4).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult7).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult10).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult13).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult14).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult15).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult16).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult19).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult22).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult23).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult24).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult25).getClassNames().size());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).size());
    assertFalse(getResult.isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((PDStructureElement) getResult4).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult7).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult10).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult13).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult14).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult15).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult16).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult19).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult22).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult23).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult24).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult25).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent10).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent13).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent14).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent15).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent16).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent19).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent22).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent23).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent24).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent25).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent10).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent13).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent14).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent15).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent16).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent19).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent22).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent23).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent24).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent25).getRoleMap().isEmpty());
    assertSame(dic3, toListResult.get(2));
    assertSame(dic3, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult7).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult10).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult13).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult14).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult15).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult16).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult19).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult22).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult23).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult24).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult25).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult27).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult29).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult30).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult31).getCOSObject());
    assertSame(dic3, ((PDStructureElement) getResult32).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent4).getK());
    assertSame(k, ((PDStructureTreeRoot) parent7).getK());
    assertSame(k, ((PDStructureTreeRoot) parent10).getK());
    assertSame(k, ((PDStructureTreeRoot) parent13).getK());
    assertSame(k, ((PDStructureTreeRoot) parent14).getK());
    assertSame(k, ((PDStructureTreeRoot) parent15).getK());
    assertSame(k, ((PDStructureTreeRoot) parent16).getK());
    assertSame(k, ((PDStructureTreeRoot) parent19).getK());
    assertSame(k, ((PDStructureTreeRoot) parent22).getK());
    assertSame(k, ((PDStructureTreeRoot) parent23).getK());
    assertSame(k, ((PDStructureTreeRoot) parent24).getK());
    assertSame(k, ((PDStructureTreeRoot) parent25).getK());
    assertSame(getResult, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult9).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult12).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult18).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult21).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult26).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult28).getCOSObject());
    assertSame(getResult, ((PDStructureElement) getResult33).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is one")
  void testAppendKidWithStructureElement_thenPDStructureTreeRootKidsSizeIsOne() {
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
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    PDStructureNode parent5 = ((PDStructureElement) getResult4).getParent();
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult5).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent2.getType());
    assertEquals("StructTreeRoot", parent4.getType());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent4).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertNull(((PDStructureTreeRoot) parent4).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent4).getParentTreeNextKey());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent4).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent3).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent4).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent5).getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is two")
  void testAppendKidWithStructureElement_thenPDStructureTreeRootKidsSizeIsTwo() {
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
    Object getResult13 = kids7.get(1);
    assertTrue(getResult13 instanceof PDStructureElement);
    PDStructureNode parent7 = ((PDStructureElement) getResult6).getParent();
    List<Object> kids8 = parent7.getKids();
    assertEquals(2, kids8.size());
    Object getResult14 = kids8.get(0);
    assertTrue(getResult14 instanceof PDStructureElement);
    Object getResult15 = kids8.get(1);
    assertTrue(getResult15 instanceof PDStructureElement);
    PDStructureNode parent8 = ((PDStructureElement) getResult7).getParent();
    List<Object> kids9 = parent8.getKids();
    assertEquals(2, kids9.size());
    Object getResult16 = kids9.get(0);
    assertTrue(getResult16 instanceof PDStructureElement);
    Object getResult17 = kids9.get(1);
    assertTrue(getResult17 instanceof PDStructureElement);
    PDStructureNode parent9 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids10 = parent9.getKids();
    assertEquals(2, kids10.size());
    Object getResult18 = kids10.get(0);
    assertTrue(getResult18 instanceof PDStructureElement);
    Object getResult19 = kids10.get(1);
    assertTrue(getResult19 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(parent6 instanceof PDStructureTreeRoot);
    assertTrue(parent7 instanceof PDStructureTreeRoot);
    assertTrue(parent8 instanceof PDStructureTreeRoot);
    assertTrue(parent9 instanceof PDStructureTreeRoot);
    PDStructureNode parent10 = ((PDStructureElement) getResult9).getParent();
    assertTrue(parent10 instanceof PDStructureTreeRoot);
    PDStructureNode parent11 = ((PDStructureElement) getResult10).getParent();
    assertTrue(parent11 instanceof PDStructureTreeRoot);
    PDStructureNode parent12 = ((PDStructureElement) getResult11).getParent();
    assertTrue(parent12 instanceof PDStructureTreeRoot);
    PDStructureNode parent13 = ((PDStructureElement) getResult12).getParent();
    assertTrue(parent13 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult13).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult14).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult15).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult16).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult17).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult18).getParent() instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult19).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent3.getType());
    assertEquals("StructTreeRoot", parent7.getType());
    assertEquals("StructTreeRoot", parent8.getType());
    assertEquals("StructTreeRoot", parent9.getType());
    assertNull(((PDStructureElement) getResult2).getActualText());
    assertNull(((PDStructureElement) getResult6).getActualText());
    assertNull(((PDStructureElement) getResult7).getActualText());
    assertNull(((PDStructureElement) getResult8).getActualText());
    assertNull(((PDStructureElement) getResult13).getActualText());
    assertNull(((PDStructureElement) getResult14).getActualText());
    assertNull(((PDStructureElement) getResult15).getActualText());
    assertNull(((PDStructureElement) getResult16).getActualText());
    assertNull(((PDStructureElement) getResult17).getActualText());
    assertNull(((PDStructureElement) getResult18).getActualText());
    assertNull(((PDStructureElement) getResult19).getActualText());
    assertNull(((PDStructureElement) getResult2).getAlternateDescription());
    assertNull(((PDStructureElement) getResult6).getAlternateDescription());
    assertNull(((PDStructureElement) getResult7).getAlternateDescription());
    assertNull(((PDStructureElement) getResult8).getAlternateDescription());
    assertNull(((PDStructureElement) getResult13).getAlternateDescription());
    assertNull(((PDStructureElement) getResult14).getAlternateDescription());
    assertNull(((PDStructureElement) getResult15).getAlternateDescription());
    assertNull(((PDStructureElement) getResult16).getAlternateDescription());
    assertNull(((PDStructureElement) getResult17).getAlternateDescription());
    assertNull(((PDStructureElement) getResult18).getAlternateDescription());
    assertNull(((PDStructureElement) getResult19).getAlternateDescription());
    assertNull(((PDStructureElement) getResult2).getElementIdentifier());
    assertNull(((PDStructureElement) getResult6).getElementIdentifier());
    assertNull(((PDStructureElement) getResult7).getElementIdentifier());
    assertNull(((PDStructureElement) getResult8).getElementIdentifier());
    assertNull(((PDStructureElement) getResult13).getElementIdentifier());
    assertNull(((PDStructureElement) getResult14).getElementIdentifier());
    assertNull(((PDStructureElement) getResult15).getElementIdentifier());
    assertNull(((PDStructureElement) getResult16).getElementIdentifier());
    assertNull(((PDStructureElement) getResult17).getElementIdentifier());
    assertNull(((PDStructureElement) getResult18).getElementIdentifier());
    assertNull(((PDStructureElement) getResult19).getElementIdentifier());
    assertNull(((PDStructureElement) getResult2).getExpandedForm());
    assertNull(((PDStructureElement) getResult6).getExpandedForm());
    assertNull(((PDStructureElement) getResult7).getExpandedForm());
    assertNull(((PDStructureElement) getResult8).getExpandedForm());
    assertNull(((PDStructureElement) getResult13).getExpandedForm());
    assertNull(((PDStructureElement) getResult14).getExpandedForm());
    assertNull(((PDStructureElement) getResult15).getExpandedForm());
    assertNull(((PDStructureElement) getResult16).getExpandedForm());
    assertNull(((PDStructureElement) getResult17).getExpandedForm());
    assertNull(((PDStructureElement) getResult18).getExpandedForm());
    assertNull(((PDStructureElement) getResult19).getExpandedForm());
    assertNull(((PDStructureElement) getResult2).getLanguage());
    assertNull(((PDStructureElement) getResult6).getLanguage());
    assertNull(((PDStructureElement) getResult7).getLanguage());
    assertNull(((PDStructureElement) getResult8).getLanguage());
    assertNull(((PDStructureElement) getResult13).getLanguage());
    assertNull(((PDStructureElement) getResult14).getLanguage());
    assertNull(((PDStructureElement) getResult15).getLanguage());
    assertNull(((PDStructureElement) getResult16).getLanguage());
    assertNull(((PDStructureElement) getResult17).getLanguage());
    assertNull(((PDStructureElement) getResult18).getLanguage());
    assertNull(((PDStructureElement) getResult19).getLanguage());
    assertNull(((PDStructureElement) getResult2).getStandardStructureType());
    assertNull(((PDStructureElement) getResult6).getStandardStructureType());
    assertNull(((PDStructureElement) getResult7).getStandardStructureType());
    assertNull(((PDStructureElement) getResult8).getStandardStructureType());
    assertNull(((PDStructureElement) getResult13).getStandardStructureType());
    assertNull(((PDStructureElement) getResult14).getStandardStructureType());
    assertNull(((PDStructureElement) getResult15).getStandardStructureType());
    assertNull(((PDStructureElement) getResult16).getStandardStructureType());
    assertNull(((PDStructureElement) getResult17).getStandardStructureType());
    assertNull(((PDStructureElement) getResult18).getStandardStructureType());
    assertNull(((PDStructureElement) getResult19).getStandardStructureType());
    assertNull(((PDStructureElement) getResult2).getStructureType());
    assertNull(((PDStructureElement) getResult6).getStructureType());
    assertNull(((PDStructureElement) getResult7).getStructureType());
    assertNull(((PDStructureElement) getResult8).getStructureType());
    assertNull(((PDStructureElement) getResult13).getStructureType());
    assertNull(((PDStructureElement) getResult14).getStructureType());
    assertNull(((PDStructureElement) getResult15).getStructureType());
    assertNull(((PDStructureElement) getResult16).getStructureType());
    assertNull(((PDStructureElement) getResult17).getStructureType());
    assertNull(((PDStructureElement) getResult18).getStructureType());
    assertNull(((PDStructureElement) getResult19).getStructureType());
    assertNull(((PDStructureElement) getResult2).getTitle());
    assertNull(((PDStructureElement) getResult6).getTitle());
    assertNull(((PDStructureElement) getResult7).getTitle());
    assertNull(((PDStructureElement) getResult8).getTitle());
    assertNull(((PDStructureElement) getResult13).getTitle());
    assertNull(((PDStructureElement) getResult14).getTitle());
    assertNull(((PDStructureElement) getResult15).getTitle());
    assertNull(((PDStructureElement) getResult16).getTitle());
    assertNull(((PDStructureElement) getResult17).getTitle());
    assertNull(((PDStructureElement) getResult18).getTitle());
    assertNull(((PDStructureElement) getResult19).getTitle());
    assertNull(((PDStructureElement) getResult2).getType());
    assertNull(((PDStructureElement) getResult6).getType());
    assertNull(((PDStructureElement) getResult7).getType());
    assertNull(((PDStructureElement) getResult8).getType());
    assertNull(((PDStructureElement) getResult13).getType());
    assertNull(((PDStructureElement) getResult14).getType());
    assertNull(((PDStructureElement) getResult15).getType());
    assertNull(((PDStructureElement) getResult16).getType());
    assertNull(((PDStructureElement) getResult17).getType());
    assertNull(((PDStructureElement) getResult18).getType());
    assertNull(((PDStructureElement) getResult19).getType());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult6).getPage());
    assertNull(((PDStructureElement) getResult7).getPage());
    assertNull(((PDStructureElement) getResult8).getPage());
    assertNull(((PDStructureElement) getResult13).getPage());
    assertNull(((PDStructureElement) getResult14).getPage());
    assertNull(((PDStructureElement) getResult15).getPage());
    assertNull(((PDStructureElement) getResult16).getPage());
    assertNull(((PDStructureElement) getResult17).getPage());
    assertNull(((PDStructureElement) getResult18).getPage());
    assertNull(((PDStructureElement) getResult19).getPage());
    assertNull(((PDStructureTreeRoot) parent3).getIDTree());
    assertNull(((PDStructureTreeRoot) parent7).getIDTree());
    assertNull(((PDStructureTreeRoot) parent8).getIDTree());
    assertNull(((PDStructureTreeRoot) parent9).getIDTree());
    assertNull(((PDStructureTreeRoot) parent3).getParentTree());
    assertNull(((PDStructureTreeRoot) parent7).getParentTree());
    assertNull(((PDStructureTreeRoot) parent8).getParentTree());
    assertNull(((PDStructureTreeRoot) parent9).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent3).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent7).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent8).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent9).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult6).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult7).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult8).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult13).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult14).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult15).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult16).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult17).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult18).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult19).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult6).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult7).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult8).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult6).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult7).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult8).getClassNames().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, parent10.getKids().size());
    assertEquals(2, parent11.getKids().size());
    assertEquals(2, parent12.getKids().size());
    assertEquals(2, parent13.getKids().size());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult6).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult7).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult8).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent8).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent9).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent3).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent7).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent8).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent9).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult18).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult19).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with
   * {@code COSBase}, {@code Object}.
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  void testInsertBeforeWithCOSBaseObject() {
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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with
   * {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first
   * {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList first COSBoolean")
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListFirstCOSBoolean() {
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
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with
   * {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList first is COSArray()")
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListFirstIsCOSArray() {
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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with
   * {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList size is two")
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListSizeIsTwo() {
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
    assertSame(dic, getResult);
    assertSame(newKid.FALSE, toListResult.get(0));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with
   * {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() Kids size is one")
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKidsSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, "Ref Kid");

    // Assert that nothing has changed
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
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with
   * {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; when ONE; then PDStructureTreeRoot() Kids size is two")
  void testInsertBeforeWithCOSBaseObject_whenOne_thenPDStructureTreeRootKidsSizeIsTwo() {
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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(newKid.FALSE, toListResult.get(0));
    assertSame(cosInteger.ONE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  void testInsertBeforeWithPDStructureElementObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(new COSDictionary());

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  void testInsertBeforeWithPDStructureElementObject2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  void testInsertBeforeWithPDStructureElementObject3() {
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
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    Object getResult3 = kids2.get(1);
    assertTrue(getResult3 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult3).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(2, kids3.size());
    Object getResult4 = kids3.get(0);
    assertTrue(getResult4 instanceof PDStructureElement);
    Object getResult5 = kids3.get(1);
    assertTrue(getResult5 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(((PDStructureElement) getResult5).getParent() instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("StructTreeRoot", parent2.getType());
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
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult2).getPage());
    assertNull(((PDStructureElement) getResult3).getPage());
    assertNull(((PDStructureElement) getResult4).getPage());
    assertNull(((PDStructureElement) getResult5).getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent2).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertNull(((PDStructureTreeRoot) parent2).getParentTree());
    assertNull(((PDStructureElement) getResult2).getParent());
    assertNull(((PDStructureElement) getResult4).getParent());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(-1, ((PDStructureTreeRoot) parent2).getParentTreeNextKey());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult2).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult3).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult4).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult5).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) getResult).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult2).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult3).getAttributes().size());
    assertEquals(0, ((PDStructureElement) getResult).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult2).getClassNames().size());
    assertEquals(0, ((PDStructureElement) getResult3).getClassNames().size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult2).getKids().isEmpty());
    assertTrue(((PDStructureElement) getResult3).getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent2).getRoleMap().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic2, ((PDStructureElement) getResult4).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult5).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  void testInsertBeforeWithPDStructureElementObject4() {
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
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; then PDStructureTreeRoot() Kids Empty")
  void testInsertBeforeWithPDStructureElementObject_thenPDStructureTreeRootKidsEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when 'null'")
  void testInsertBeforeWithPDStructureElementObject_whenNull() {
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
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when 'null'")
  void testInsertBeforeWithPDStructureElementObject_whenNull2() {
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
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with
   * {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>When {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when PDStructureElement(COSDictionary) with dic is 'null'")
  void testInsertBeforeWithPDStructureElementObject_whenPDStructureElementWithDicIsNull() {
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
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'")
  void testRemoveKidWithObject() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    COSIncrement toIncrementResult = pdStructureTreeRoot.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = ((COSDictionary) k).toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'")
  void testRemoveKidWithObject2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.removeKid(COSInteger.ONE);

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
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSDictionary() Direct is 'true'; when FALSE; then return 'true'")
  void testRemoveKidWithObject_givenCOSDictionaryDirectIsTrue_whenFalse_thenReturnTrue() {
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
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#A}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return A; then return 'true'")
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnA_thenReturnTrue() {
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
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#AA}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return AA; when A")
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnAa_whenA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.AA);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSName.A);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return COSArray()")
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnCOSArray() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    COSIncrement toIncrementResult = ((COSDictionary) k).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return FALSE; then return 'true'")
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnFalse_thenReturnTrue() {
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
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return 'null'")
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnNull() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(null);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
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
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSInteger#THREE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return THREE")
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnThree() {
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
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given PDStructureTreeRoot(); then PDStructureTreeRoot() K is 'null'")
  void testRemoveKidWithObject_givenPDStructureTreeRoot_thenPDStructureTreeRootKIsNull() {
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
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first Parent
   * Kids size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first Parent Kids size is two")
  void testRemoveKidWithObject_thenPDStructureTreeRootKidsFirstParentKidsSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} K is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; then PDStructureTreeRoot(COSDictionary) with dic is COSDictionary() K is 'null'")
  void testRemoveKidWithObject_thenPDStructureTreeRootWithDicIsCOSDictionaryKIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(new COSDictionary());

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
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when A")
  void testRemoveKidWithObject_whenA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSName.A);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K Key is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when FALSE; then PDStructureTreeRoot() K Key is 'null'")
  void testRemoveKidWithObject_whenFalse_thenPDStructureTreeRootKKeyIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
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
    assertNull(k.getKey());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, k);
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when 'null'")
  void testRemoveKidWithObject_whenNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid((COSBase) null);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when ONE")
  void testRemoveKidWithObject_whenOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSFloat.ONE);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when ONE")
  void testRemoveKidWithObject_whenOne2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSInteger.ONE);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when parseHex '0123456789ABCDEF'")
  void testRemoveKidWithObject_whenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSString.parseHex("0123456789ABCDEF"));

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(k, ((PDStructureTreeRoot) parent).getK());
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertFalse(pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary())));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertFalse(pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary())));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement4() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSName.A, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement11() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  void testRemoveKidWithStructureElement12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSName.A, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return A")
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return FALSE")
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnFalse() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return ONE")
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary()")
  void testRemoveKidWithStructureElement_givenPDStructureTreeRootWithDicIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(new COSDictionary());

    // Act and Assert
    assertFalse(pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary())));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given PDStructureTreeRoot(); then return 'false'")
  void testRemoveKidWithStructureElement_givenPDStructureTreeRoot_thenReturnFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act and Assert
    assertFalse(pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary())));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; when 'null'")
  void testRemoveKidWithStructureElement_whenNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid((PDStructureElement) null);

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with
   * {@code structureElement}.
   * <ul>
   *   <li>When {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; when PDStructureElement(COSDictionary) with dic is 'null'")
  void testRemoveKidWithStructureElement_whenPDStructureElementWithDicIsNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(null));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given A; when COSObjectable getCOSObject() return A")
  void testRemoveObjectableKid_givenA_whenCOSObjectableGetCOSObjectReturnA() {
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
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given COSObjectable getCOSObject() return 'null'")
  void testRemoveObjectableKid_givenCOSObjectableGetCOSObjectReturnNull() {
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
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given FALSE; then PDStructureTreeRoot() K is 'null'")
  void testRemoveObjectableKid_givenFalse_thenPDStructureTreeRootKIsNull() {
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
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given 'null'; when COSObjectable getCOSObject() return 'null'")
  void testRemoveObjectableKid_givenNull_whenCOSObjectableGetCOSObjectReturnNull() {
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
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given ONE; when COSObjectable getCOSObject() return ONE")
  void testRemoveObjectableKid_givenOne_whenCOSObjectableGetCOSObjectReturnOne() {
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
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given ONE; when COSObjectable getCOSObject() return ONE")
  void testRemoveObjectableKid_givenOne_whenCOSObjectableGetCOSObjectReturnOne2() {
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
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given PDStructureTreeRoot(); then PDStructureTreeRoot() K is 'null'")
  void testRemoveObjectableKid_givenPDStructureTreeRoot_thenPDStructureTreeRootKIsNull() {
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
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given parseHex '0123456789ABCDEF'")
  void testRemoveObjectableKid_givenParseHex0123456789abcdef() throws IOException {
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
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSBoolean#TRUE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given TRUE; when COSObjectable getCOSObject() return TRUE")
  void testRemoveObjectableKid_givenTrue_whenCOSObjectableGetCOSObjectReturnTrue() {
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
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSBoolean#TRUE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given TRUE; when COSObjectable getCOSObject() return TRUE")
  void testRemoveObjectableKid_givenTrue_whenCOSObjectableGetCOSObjectReturnTrue2() {
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
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K COSDictionary")
  void testRemoveObjectableKid_thenPDStructureTreeRootKCOSDictionary() {
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
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, k);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K Key is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K Key is 'null'")
  void testRemoveObjectableKid_thenPDStructureTreeRootKKeyIsNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.TRUE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSBoolean);
    assertNull(k.getKey());
    assertTrue(((COSBoolean) k).getValue());
    assertTrue(((COSBoolean) k).getValueAsObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList Empty")
  void testRemoveObjectableKid_thenPDStructureTreeRootKToListEmpty() {
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
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    assertTrue(((COSArray) k).toList().isEmpty());
    assertTrue(actualRemoveObjectableKidResult);
    assertSame(cosArray, k);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList size is two")
  void testRemoveObjectableKid_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
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
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() Kids size is one")
  void testRemoveObjectableKid_thenPDStructureTreeRootKidsSizeIsOne() {
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
    pdStructureTreeRoot.removeObjectableKid(objectable2);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
    assertSame(dic, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} K is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot(COSDictionary) with dic is COSDictionary() K is 'null'")
  void testRemoveObjectableKid_thenPDStructureTreeRootWithDicIsCOSDictionaryKIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(new COSDictionary());
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object)")
  void testInsertObjectableBefore() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); given 'null'; when COSObjectable getCOSObject() return 'null'")
  void testInsertObjectableBefore_givenNull_whenCOSObjectableGetCOSObjectReturnNull() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary()")
  void testInsertObjectableBefore_givenPDStructureTreeRootWithDicIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(new COSDictionary());
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(newKid).getCOSObject();
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then calls {@link COSObjectable#getCOSObject()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); given PDStructureTreeRoot(); then calls getCOSObject()")
  void testInsertObjectableBefore_givenPDStructureTreeRoot_thenCallsGetCOSObject() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSBoolean")
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSBoolean() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSDictionary")
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSDictionary() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSInteger")
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSInteger() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSName")
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSName() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSObject}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSObject")
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSObject() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSString")
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSString() throws IOException {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is
   * {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K toList first is FALSE FALSE")
  void testInsertObjectableBefore_thenPDStructureTreeRootKToListFirstIsFalseFalse() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when FALSE; then PDStructureTreeRoot() K toList size is three")
  void testInsertObjectableBefore_whenFalse_thenPDStructureTreeRootKToListSizeIsThree() {
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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSDictionary);
    assertSame(dic, getResult);
    COSBoolean cosBoolean2 = cosBoolean.FALSE;
    assertSame(cosBoolean2, toListResult.get(1));
    assertSame(cosBoolean2, toListResult.get(2));
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when 'null'; then PDStructureTreeRoot() K COSBoolean")
  void testInsertObjectableBefore_whenNull_thenPDStructureTreeRootKCOSBoolean() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when PDDictionaryWrapper()")
  void testInsertObjectableBefore_whenPDDictionaryWrapper() {
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
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@link COSInteger#THREE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is
   * {@link COSInteger#THREE} {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when THREE; then PDStructureTreeRoot() K is THREE ONE")
  void testInsertObjectableBefore_whenThree_thenPDStructureTreeRootKIsThreeOne() {
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
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase)")
  void testCreateObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary object = new COSDictionary();

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(new COSObject(object, new COSObjectKey(1L, 1)));

    // Assert
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
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return ActualText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when COSDictionary(); then return ActualText is 'null'")
  void testCreateObject_whenCOSDictionary_thenReturnActualTextIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary kid = new COSDictionary();

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(kid);

    // Assert
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
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSBoolean#FALSE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  void testCreateObject_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act and Assert
    assertNull(pdStructureTreeRoot.createObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when COSStream(); then return COSObject is COSStream()")
  void testCreateObject_whenCOSStream_thenReturnCOSObjectIsCOSStream() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSStream kid = new COSStream();

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(kid);

    // Assert
    assertTrue(actualCreateObjectResult instanceof PDStructureElement);
    assertSame(kid, ((PDStructureElement) actualCreateObjectResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when FALSE; then return 'null'")
  void testCreateObject_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).createObject(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() COSObject Values size is one")
  void testAppendObjectableKid_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K
   * {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K COSDictionary")
  void testAppendObjectableKid_thenPDStructureTreeRootKCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first
   * {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList first COSDictionary")
  void testAppendObjectableKid_thenPDStructureTreeRootKToListFirstCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(structureElement);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSDictionary);
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList third
   * {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList third COSArray")
  void testAppendObjectableKid_thenPDStructureTreeRootKToListThirdCOSArray() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(objectable.getCOSObject()).thenReturn(cosArray);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSArray);
    assertTrue(k instanceof COSArray);
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertSame(cosArray, getResult);
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList third
   * {@link COSObject}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList third COSObject")
  void testAppendObjectableKid_thenPDStructureTreeRootKToListThirdCOSObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

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
    Object getResult11 = kids4.get(2);
    assertTrue(getResult11 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult6).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(3, kids5.size());
    Object getResult12 = kids5.get(2);
    assertTrue(getResult12 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(3, kids6.size());
    Object getResult13 = kids6.get(2);
    assertTrue(getResult13 instanceof PDStructureElement);
    PDStructureNode parent6 = ((PDStructureElement) getResult9).getParent();
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
    COSDictionary cOSObject = ((PDStructureElement) getResult4).getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = ((COSObject) getResult).getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(cosDictionary, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
    assertSame(key, cOSObject.getKey());
    assertSame(cOSObject, ((PDStructureElement) getResult7).getCOSObject());
    assertSame(cOSObject, ((PDStructureElement) getResult10).getCOSObject());
    assertSame(cOSObject, ((PDStructureElement) getResult11).getCOSObject());
    assertSame(cOSObject, ((PDStructureElement) getResult12).getCOSObject());
    assertSame(cOSObject, ((PDStructureElement) getResult13).getCOSObject());
    assertSame(cOSObject, ((PDStructureElement) getResult14).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList third is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList third is COSDictionary()")
  void testAppendObjectableKid_thenPDStructureTreeRootKToListThirdIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
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
    Object getResult10 = kids4.get(2);
    assertTrue(getResult10 instanceof PDStructureElement);
    PDStructureNode parent4 = ((PDStructureElement) getResult5).getParent();
    List<Object> kids5 = parent4.getKids();
    assertEquals(3, kids5.size());
    Object getResult11 = kids5.get(2);
    assertTrue(getResult11 instanceof PDStructureElement);
    PDStructureNode parent5 = ((PDStructureElement) getResult7).getParent();
    List<Object> kids6 = parent5.getKids();
    assertEquals(3, kids6.size());
    Object getResult12 = kids6.get(2);
    assertTrue(getResult12 instanceof PDStructureElement);
    PDStructureNode parent6 = ((PDStructureElement) getResult8).getParent();
    List<Object> kids7 = parent6.getKids();
    assertEquals(3, kids7.size());
    Object getResult13 = kids7.get(2);
    assertTrue(getResult13 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertTrue(parent3 instanceof PDStructureTreeRoot);
    assertTrue(parent4 instanceof PDStructureTreeRoot);
    assertTrue(parent5 instanceof PDStructureTreeRoot);
    assertTrue(parent6 instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult14 = toListResult.get(2);
    assertSame(cosDictionary, getResult14);
    assertSame(getResult14, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(getResult14, ((PDStructureElement) getResult6).getCOSObject());
    assertSame(getResult14, ((PDStructureElement) getResult9).getCOSObject());
    assertSame(getResult14, ((PDStructureElement) getResult10).getCOSObject());
    assertSame(getResult14, ((PDStructureElement) getResult11).getCOSObject());
    assertSame(getResult14, ((PDStructureElement) getResult12).getCOSObject());
    assertSame(getResult14, ((PDStructureElement) getResult13).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first
   * ActualText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() Kids first ActualText is 'null'")
  void testAppendObjectableKid_thenPDStructureTreeRootKidsFirstActualTextIsNull() {
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
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    COSBase k = pdStructureTreeRoot.getK();
    assertSame(cosDictionary, k);
    assertSame(k, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} K {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot(COSDictionary) with dic is COSDictionary() K COSBoolean")
  void testAppendObjectableKid_thenPDStructureTreeRootWithDicIsCOSDictionaryKCOSBoolean() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot(new COSDictionary());
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSBoolean);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(((COSBoolean) k).getValue());
    assertFalse(((COSBoolean) k).getValueAsObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then throw IllegalArgumentException")
  void testAppendObjectableKid_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureTreeRoot.appendObjectableKid(objectable));
    verify(objectable).getCOSObject();
  }
}
