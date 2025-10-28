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
import org.junit.jupiter.api.Test;

class PDNumberTreeNodeDiffblueTest {
  /**
   * Method under test: {@link PDNumberTreeNode#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link PDNumberTreeNode#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    COSDictionary actualCOSObject = pdNumberTreeNode.getCOSObject();

    // Assert
    verify(cosObjectable).getCOSObject();
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
   * Method under test: {@link PDNumberTreeNode#getKids()}
   */
  @Test
  void testGetKids() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getKids());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getKids()}
   */
  @Test
  void testGetKids2() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getKids()}
   */
  @Test
  void testGetKids3() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    List<PDNumberTreeNode> actualKids = pdNumberTreeNode.getKids();

    // Assert
    verify(cosObjectable).getCOSObject();
    assertNull(actualKids);
  }

  /**
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids() {
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
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids2() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;
    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    Class<COSObjectable> valueClass2 = COSObjectable.class;
    kids.add(new PDNumberTreeNode(valueClass2));

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    assertNull(pdNumberTreeNode.getLowerLimit());
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getLowerLimit());
    assertNull(pdNumberTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult.getNumbers());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids3() throws IOException {
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
    assertNull(pdNumberTreeNode.getLowerLimit());
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(2, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getLowerLimit());
    PDNumberTreeNode getResult2 = kids2.get(1);
    assertNull(getResult2.getLowerLimit());
    assertNull(pdNumberTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult2.getKids());
    assertNull(getResult.getNumbers());
    assertNull(getResult2.getNumbers());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids4() {
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
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids5() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    // Act
    pdNumberTreeNode.setKids(new ArrayList<>());

    // Assert that nothing has changed
    verify(cosObjectable).getCOSObject();
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids6() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    Class<COSObjectable> valueClass2 = COSObjectable.class;
    kids.add(new PDNumberTreeNode(valueClass2));

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertNull(pdNumberTreeNode.getLowerLimit());
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getLowerLimit());
    assertNull(pdNumberTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult.getNumbers());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids7() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);
    Class<COSObjectable> valueClass2 = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode2 = new PDNumberTreeNode(valueClass2);
    pdNumberTreeNode2.setNumbers(new HashMap<>());

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    kids.add(pdNumberTreeNode2);

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertNull(pdNumberTreeNode.getLowerLimit());
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getLowerLimit());
    assertNull(pdNumberTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(getResult.getNumbers().isEmpty());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids8() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);
    COSObjectable cosObjectable2 = mock(COSObjectable.class);
    when(cosObjectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers2 = new HashMap<>();
    numbers2.put(1, cosObjectable2);
    Class<COSObjectable> valueClass2 = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode2 = new PDNumberTreeNode(valueClass2);
    pdNumberTreeNode2.setNumbers(numbers2);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    kids.add(pdNumberTreeNode2);

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    verify(cosObjectable).getCOSObject();
    verify(cosObjectable2).getCOSObject();
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getKids());
    assertEquals(1, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(1, getResult.getLowerLimit().intValue());
    assertEquals(1, pdNumberTreeNode.getUpperLimit().intValue());
    assertEquals(1, getResult.getUpperLimit().intValue());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#setKids(List)}
   */
  @Test
  void testSetKids9() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers = new HashMap<>();
    numbers.put(1, cosObjectable);
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(numbers);
    COSObjectable cosObjectable2 = mock(COSObjectable.class);
    when(cosObjectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    HashMap<Integer, COSObjectable> numbers2 = new HashMap<>();
    numbers2.put(Integer.MIN_VALUE, cosObjectable2);
    Class<COSObjectable> valueClass2 = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode2 = new PDNumberTreeNode(valueClass2);
    pdNumberTreeNode2.setNumbers(numbers2);

    ArrayList<PDNumberTreeNode> kids = new ArrayList<>();
    kids.add(pdNumberTreeNode2);

    // Act
    pdNumberTreeNode.setKids(kids);

    // Assert
    verify(cosObjectable).getCOSObject();
    verify(cosObjectable2).getCOSObject();
    List<PDNumberTreeNode> kids2 = pdNumberTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNumberTreeNode getResult = kids2.get(0);
    assertNull(getResult.getKids());
    COSDictionary cOSObject = pdNumberTreeNode.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdNumberTreeNode.getLowerLimit().intValue());
    assertEquals(Integer.MIN_VALUE, getResult.getLowerLimit().intValue());
    assertEquals(Integer.MIN_VALUE, pdNumberTreeNode.getUpperLimit().intValue());
    assertEquals(Integer.MIN_VALUE, getResult.getUpperLimit().intValue());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  void testGetValue() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getValue(1));
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  void testGetValue2() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertNull(pdNumberTreeNode.getValue(1));
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  void testGetValue3() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  void testGetValue4() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  void testGetValue5() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getValue(Integer)}
   */
  @Test
  void testGetValue6() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  void testGetNumbers() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getNumbers());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  void testGetNumbers2() throws IOException {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertTrue(pdNumberTreeNode.getNumbers().isEmpty());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  void testGetNumbers3() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  void testGetNumbers4() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  void testGetNumbers5() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#getNumbers()}
   */
  @Test
  void testGetNumbers6() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#createChildNode(COSDictionary)}
   */
  @Test
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
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  void testSetNumbers() throws IOException {
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
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  void testSetNumbers2() {
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
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  void testSetNumbers3() {
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
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  void testSetNumbers4() {
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
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  void testSetNumbers5() {
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
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  void testSetNumbers6() {
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
   * Method under test: {@link PDNumberTreeNode#setNumbers(Map)}
   */
  @Test
  void testSetNumbers7() {
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
   * Method under test: {@link PDNumberTreeNode#getUpperLimit()}
   */
  @Test
  void testGetUpperLimit() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getUpperLimit());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getUpperLimit()}
   */
  @Test
  void testGetUpperLimit2() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertNull(pdNumberTreeNode.getUpperLimit());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getUpperLimit()}
   */
  @Test
  void testGetUpperLimit3() {
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
   * Method under test: {@link PDNumberTreeNode#getLowerLimit()}
   */
  @Test
  void testGetLowerLimit() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertNull((new PDNumberTreeNode(valueClass)).getLowerLimit());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getLowerLimit()}
   */
  @Test
  void testGetLowerLimit2() {
    // Arrange
    Class<COSObjectable> valueClass = COSObjectable.class;

    PDNumberTreeNode pdNumberTreeNode = new PDNumberTreeNode(valueClass);
    pdNumberTreeNode.setNumbers(new HashMap<>());

    // Act and Assert
    assertNull(pdNumberTreeNode.getLowerLimit());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#getLowerLimit()}
   */
  @Test
  void testGetLowerLimit3() {
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
   * Method under test:
   * {@link PDNumberTreeNode#PDNumberTreeNode(COSDictionary, Class)}
   */
  @Test
  void testNewPDNumberTreeNode() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    Class<COSObjectable> valueClass = COSObjectable.class;

    // Act and Assert
    assertSame(dict, (new PDNumberTreeNode(dict, valueClass)).getCOSObject());
  }

  /**
   * Method under test: {@link PDNumberTreeNode#PDNumberTreeNode(Class)}
   */
  @Test
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
}
