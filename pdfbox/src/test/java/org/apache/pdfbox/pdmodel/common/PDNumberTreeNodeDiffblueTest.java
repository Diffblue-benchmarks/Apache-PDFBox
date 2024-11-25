package org.apache.pdfbox.pdmodel.common;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDNumberTreeNodeDiffblueTest {
  /**
   * Test {@link PDNumberTreeNode#PDNumberTreeNode(COSDictionary, Class)}.
   * <p>
   * Method under test:
   * {@link PDNumberTreeNode#PDNumberTreeNode(COSDictionary, Class)}
   */
  @Test
  @DisplayName("Test new PDNumberTreeNode(COSDictionary, Class)")
  void testNewPDNumberTreeNode() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertSame(dict, (new PDNumberTreeNode(dict, valueClass)).getCOSObject());
  }

  /**
   * Test {@link PDNumberTreeNode#PDNumberTreeNode(Class)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#PDNumberTreeNode(Class)}
   */
  @Test
  @DisplayName("Test new PDNumberTreeNode(Class)")
  void testNewPDNumberTreeNode2() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    PDNumberTreeNode actualPdNumberTreeNode = new PDNumberTreeNode(valueClass);

    // Assert
    assertNull(actualPdNumberTreeNode.getLowerLimit());
    assertNull(actualPdNumberTreeNode.getUpperLimit());
    assertNull(actualPdNumberTreeNode.getKids());
    assertNull(actualPdNumberTreeNode.getNumbers());
    COSDictionary cOSObject = actualPdNumberTreeNode.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#getCOSObject()}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act
    COSDictionary actualCOSObject = (new PDNumberTreeNode(valueClass)).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#getKids()}.
   * <ul>
   *   <li>Given {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable} Numbers is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDNumberTreeNode(Class) with valueClass is COSObjectable Numbers is HashMap()")
  void testGetKids_givenPDNumberTreeNodeWithValueClassIsCOSObjectableNumbersIsHashMap() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertNull(pdNumberTreeNode.getKids());
  }

  /**
   * Test {@link PDNumberTreeNode#getKids()}.
   * <ul>
   *   <li>Given {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDNumberTreeNode(Class) with valueClass is COSObjectable; then return 'null'")
  void testGetKids_givenPDNumberTreeNodeWithValueClassIsCOSObjectable_thenReturnNull() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getKids());
  }

  /**
   * Test {@link PDNumberTreeNode#getKids()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return size is one")
  void testGetKids_thenReturnSizeIsOne() throws IOException {
    // Arrange
    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    Class<COSObjectable> valueClass = COSObjectable.class;
    kids.add(new PDNumberTreeNode(valueClass));
    Class<COSObjectable> valueClass2 = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass2);
    pdNumberTreeNode.setKids(kids);

    // Act
    List<PDNumberTreeNode> actualKids = pdNumberTreeNode.getKids();

    // Assert
    assertEquals(1, actualKids.size());
    PDNumberTreeNode getResult = actualKids.get(0);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getNumbers());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  void testSetKids() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    Class<COSObjectable> valueClass2 = COSObjectable.class;
    kids.add(new PDNumberTreeNode(valueClass2));

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getNumbers());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  void testSetKids2() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    Class<COSObjectable> valueClass2 = COSObjectable.class;
    kids.add(new PDNumberTreeNode(valueClass2));

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getNumbers());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  void testSetKids3() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    Class<COSObjectable> valueClass2 = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode2 = new PDNumberTreeNode(valueClass2);
    pdNumberTreeNode2.setNumbers(new HashMap<>());

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    kids.add(pdNumberTreeNode2);

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(getResult.getNumbers().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  void testSetKids4() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass2 = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode2 = new PDNumberTreeNode(valueClass2);
    pdNumberTreeNode2.setNumbers(numbers);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    kids.add(pdNumberTreeNode2);

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertEquals(1, getResult.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    assertEquals(1, getResult.getUpperLimit().intValue());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  void testSetKids5() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(Integer.MIN_VALUE, cosObjectable);
    Class<COSObjectable> valueClass2 = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode2 = new PDNumberTreeNode(valueClass2);
    pdNumberTreeNode2.setNumbers(numbers);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    kids.add(pdNumberTreeNode2);

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    verify(cosObjectable).getCOSObject();
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    assertEquals(Integer.MIN_VALUE, pdNumberTreeNode.getLowerLimit().intValue());
    PDNumberTreeNode getResult = kids2.get(0);
    assertEquals(Integer.MIN_VALUE, getResult.getLowerLimit().intValue());
    assertEquals(Integer.MIN_VALUE, pdNumberTreeNode.getUpperLimit().intValue());
    assertEquals(Integer.MIN_VALUE, getResult.getUpperLimit().intValue());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable} Kids size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDNumberTreeNode(Class) with valueClass is COSObjectable Kids size is two")
  void testSetKids_thenPDNumberTreeNodeWithValueClassIsCOSObjectableKidsSizeIsTwo() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    Class<COSObjectable> valueClass2 = COSObjectable.class;
    kids.add(new PDNumberTreeNode(valueClass2));
    Class<COSObjectable> valueClass3 = COSObjectable.class;
    kids.add(new PDNumberTreeNode(valueClass3));

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(2, kids2.size());
    PDNumberTreeNode getResult = kids2.get(1);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult.getNumbers());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable} LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDNumberTreeNode(Class) with valueClass is COSObjectable LowerLimit is 'null'")
  void testSetKids_thenPDNumberTreeNodeWithValueClassIsCOSObjectableLowerLimitIsNull() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);

    // Act
    pdNumberTreeNode.setKids(new ArrayList<>());

    // Assert
    assertNull(pdNumberTreeNode.getLowerLimit());
    assertNull(pdNumberTreeNode.getUpperLimit());
    assertNull(pdNumberTreeNode.getKids());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#setKids(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); when ArrayList()")
  void testSetKids_whenArrayList() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act
    pdNumberTreeNode.setKids(new ArrayList<>());

    // Assert that nothing has changed
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#getValue(Integer)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  @DisplayName("Test getValue(Integer); given COSObjectKey(long, int) with num is one and gen is one; then throw IOException")
  void testGetValue_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenThrowIOException() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act and Assert
    assertThrows(IOException.class, () -> pdNumberTreeNode.getValue(1));
    verify(cosObjectable).getCOSObject();
  }

  /**
   * Test {@link PDNumberTreeNode#getValue(Integer)}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  @DisplayName("Test getValue(Integer); given COSObjectable getCOSObject() return FALSE; then throw IOException")
  void testGetValue_givenCOSObjectableGetCOSObjectReturnFalse_thenThrowIOException() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act and Assert
    assertThrows(IOException.class, () -> pdNumberTreeNode.getValue(1));
    verify(cosObjectable).getCOSObject();
  }

  /**
   * Test {@link PDNumberTreeNode#getValue(Integer)}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  @DisplayName("Test getValue(Integer); given COSObjectable getCOSObject() return 'null'; then return 'null'")
  void testGetValue_givenCOSObjectableGetCOSObjectReturnNull_thenReturnNull() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(null);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    Object actualValue = pdNumberTreeNode.getValue(1);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertNull(actualValue);
  }

  /**
   * Test {@link PDNumberTreeNode#getValue(Integer)}.
   * <ul>
   *   <li>Given {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  @DisplayName("Test getValue(Integer); given PDNumberTreeNode(Class) with valueClass is COSObjectable; then return 'null'")
  void testGetValue_givenPDNumberTreeNodeWithValueClassIsCOSObjectable_thenReturnNull() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getValue(1));
  }

  /**
   * Test {@link PDNumberTreeNode#getValue(Integer)}.
   * <ul>
   *   <li>Then return {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  @DisplayName("Test getValue(Integer); then return COSDictionary")
  void testGetValue_thenReturnCOSDictionary() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(new COSDictionary());

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSDictionary> valueClass = COSDictionary.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    Object actualValue = pdNumberTreeNode.getValue(1);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertTrue(actualValue instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) actualValue).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(((COSDictionary) actualValue).getKey());
    assertEquals(0, ((COSDictionary) actualValue).size());
    COSIncrement toIncrementResult = ((COSDictionary) actualValue).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSDictionary) actualValue).isDirect());
    assertFalse(((COSDictionary) actualValue).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((COSDictionary) actualValue).getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#getValue(Integer)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  @DisplayName("Test getValue(Integer); then return 'null'")
  void testGetValue_thenReturnNull() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertNull(pdNumberTreeNode.getValue(1));
  }

  /**
   * Test {@link PDNumberTreeNode#getNumbers()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  @DisplayName("Test getNumbers(); given COSObjectKey(long, int) with num is one and gen is one; then throw IOException")
  void testGetNumbers_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenThrowIOException() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act and Assert
    assertThrows(IOException.class, () -> pdNumberTreeNode.getNumbers());
    verify(cosObjectable).getCOSObject();
  }

  /**
   * Test {@link PDNumberTreeNode#getNumbers()}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  @DisplayName("Test getNumbers(); given COSObjectable getCOSObject() return FALSE; then throw IOException")
  void testGetNumbers_givenCOSObjectableGetCOSObjectReturnFalse_thenThrowIOException() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act and Assert
    assertThrows(IOException.class, () -> pdNumberTreeNode.getNumbers());
    verify(cosObjectable).getCOSObject();
  }

  /**
   * Test {@link PDNumberTreeNode#getNumbers()}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@code null}.</li>
   *   <li>Then return one is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  @DisplayName("Test getNumbers(); given COSObjectable getCOSObject() return 'null'; then return one is 'null'")
  void testGetNumbers_givenCOSObjectableGetCOSObjectReturnNull_thenReturnOneIsNull() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(null);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    Map<Integer, COSObjectable> actualNumbers = pdNumberTreeNode.getNumbers();

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualNumbers.size());
    assertNull(actualNumbers.get(1));
  }

  /**
   * Test {@link PDNumberTreeNode#getNumbers()}.
   * <ul>
   *   <li>Given {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  @DisplayName("Test getNumbers(); given PDNumberTreeNode(Class) with valueClass is COSObjectable; then return 'null'")
  void testGetNumbers_givenPDNumberTreeNodeWithValueClassIsCOSObjectable_thenReturnNull() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getNumbers());
  }

  /**
   * Test {@link PDNumberTreeNode#getNumbers()}.
   * <ul>
   *   <li>Then one return {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  @DisplayName("Test getNumbers(); then one return COSDictionary")
  void testGetNumbers_thenOneReturnCOSDictionary() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(new COSDictionary());

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSDictionary> valueClass = COSDictionary.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    Map<Integer, COSObjectable> actualNumbers = pdNumberTreeNode.getNumbers();

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualNumbers.size());
    COSObjectable getResult = actualNumbers.get(1);
    assertTrue(getResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(((COSDictionary) getResult).getKey());
    assertEquals(0, ((COSDictionary) getResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSDictionary) getResult).isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((COSDictionary) getResult).getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#getNumbers()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  @DisplayName("Test getNumbers(); then return Empty")
  void testGetNumbers_thenReturnEmpty() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertTrue(pdNumberTreeNode.getNumbers().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#createChildNode(COSDictionary)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#createChildNode(COSDictionary)}
   */
  @Test
  @DisplayName("Test createChildNode(COSDictionary)")
  void testCreateChildNode() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSDictionary dic = new COSDictionary();

    // Act
    PDNumberTreeNode actualCreateChildNodeResult = pdNumberTreeNode.createChildNode(dic);

    // Assert
    assertNull(actualCreateChildNodeResult.getLowerLimit());
    assertNull(actualCreateChildNodeResult.getUpperLimit());
    assertNull(actualCreateChildNodeResult.getKids());
    assertNull(actualCreateChildNodeResult.getNumbers());
    assertSame(dic, actualCreateChildNodeResult.getCOSObject());
  }

  /**
   * Test {@link PDNumberTreeNode#setNumbers(Map)}.
   * <p>
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  @DisplayName("Test setNumbers(Map)")
  void testSetNumbers() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(Integer.MIN_VALUE, cosObjectable);

    // Act
    pdNumberTreeNode.setNumbers(numbers);

    // Assert
    verify(cosObjectable).getCOSObject();
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(Integer.MIN_VALUE, pdNumberTreeNode.getUpperLimit().intValue());
  }

  /**
   * Test {@link PDNumberTreeNode#setNumbers(Map)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  @DisplayName("Test setNumbers(Map); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testSetNumbers_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setKey(new COSObjectKey(1L, 1));
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(cosDictionary);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);

    // Act
    pdNumberTreeNode.setNumbers(numbers);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#setNumbers(Map)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  @DisplayName("Test setNumbers(Map); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetNumbers_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);

    // Act
    pdNumberTreeNode.setNumbers(numbers);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#setNumbers(Map)}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  @DisplayName("Test setNumbers(Map); given COSObjectable getCOSObject() return COSArray()")
  void testSetNumbers_givenCOSObjectableGetCOSObjectReturnCOSArray() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(new COSArray());

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);

    // Act
    pdNumberTreeNode.setNumbers(numbers);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#setNumbers(Map)}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  @DisplayName("Test setNumbers(Map); given COSObjectable getCOSObject() return COSDictionary()")
  void testSetNumbers_givenCOSObjectableGetCOSObjectReturnCOSDictionary() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(new COSDictionary());

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);

    // Act
    pdNumberTreeNode.setNumbers(numbers);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#setNumbers(Map)}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  @DisplayName("Test setNumbers(Map); given COSObjectable getCOSObject() return FALSE")
  void testSetNumbers_givenCOSObjectableGetCOSObjectReturnFalse() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);

    // Act
    pdNumberTreeNode.setNumbers(numbers);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberTreeNode#setNumbers(Map)}.
   * <ul>
   *   <li>Then {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable} LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  @DisplayName("Test setNumbers(Map); then PDNumberTreeNode(Class) with valueClass is COSObjectable LowerLimit is 'null'")
  void testSetNumbers_thenPDNumberTreeNodeWithValueClassIsCOSObjectableLowerLimitIsNull() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);

    // Act
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Assert
    assertNull(pdNumberTreeNode.getLowerLimit());
    assertNull(pdNumberTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdNumberTreeNode.getNumbers().isEmpty());
  }

  /**
   * Test {@link PDNumberTreeNode#getUpperLimit()}.
   * <ul>
   *   <li>Given {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); given PDNumberTreeNode(Class) with valueClass is COSObjectable")
  void testGetUpperLimit_givenPDNumberTreeNodeWithValueClassIsCOSObjectable() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getUpperLimit());
  }

  /**
   * Test {@link PDNumberTreeNode#getUpperLimit()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); then return intValue is one")
  void testGetUpperLimit_thenReturnIntValueIsOne() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    Integer actualUpperLimit = pdNumberTreeNode.getUpperLimit();

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualUpperLimit.intValue());
  }

  /**
   * Test {@link PDNumberTreeNode#getUpperLimit()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); then return 'null'")
  void testGetUpperLimit_thenReturnNull() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertNull(pdNumberTreeNode.getUpperLimit());
  }

  /**
   * Test {@link PDNumberTreeNode#getLowerLimit()}.
   * <ul>
   *   <li>Given {@link PDNumberTreeNode#PDNumberTreeNode(Class)} with valueClass is
   * {@link COSObjectable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); given PDNumberTreeNode(Class) with valueClass is COSObjectable")
  void testGetLowerLimit_givenPDNumberTreeNodeWithValueClassIsCOSObjectable() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getLowerLimit());
  }

  /**
   * Test {@link PDNumberTreeNode#getLowerLimit()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); then return intValue is one")
  void testGetLowerLimit_thenReturnIntValueIsOne() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    Integer actualLowerLimit = pdNumberTreeNode.getLowerLimit();

    // Assert
    verify(cosObjectable).getCOSObject();
    assertEquals(1, actualLowerLimit.intValue());
  }

  /**
   * Test {@link PDNumberTreeNode#getLowerLimit()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNumberTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); then return 'null'")
  void testGetLowerLimit_thenReturnNull() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertNull(pdNumberTreeNode.getLowerLimit());
  }
}
