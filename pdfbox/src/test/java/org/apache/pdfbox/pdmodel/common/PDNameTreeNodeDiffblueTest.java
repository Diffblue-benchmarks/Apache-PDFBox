package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDestinationNameTreeNode;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDNameTreeNodeDiffblueTest {
  /**
   * Method under test: {@link PDNameTreeNode#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDDestinationNameTreeNode()).getCOSObject();

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
   * Method under test: {@link PDNameTreeNode#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act
    COSDictionary actualCOSObject = pdDestinationNameTreeNode.getCOSObject();

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
   * Method under test: {@link PDNameTreeNode#getParent()}
   */
  @Test
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getParent());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getParent()}
   */
  @Test
  void testGetParent2() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getParent());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent2() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(null);

    // Assert
    assertNull(pdDestinationNameTreeNode.getParent());
    assertTrue(pdDestinationNameTreeNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent3() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    PDNameTreeNode<PDPageDestination> parentNode = mock(PDNameTreeNode.class);

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertFalse(pdDestinationNameTreeNode.isRootNode());
    assertSame(parentNode, pdDestinationNameTreeNode.getParent());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent4() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent5() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent6() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent7() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent8() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination(new COSArray()));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent9() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent10() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent11() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSInteger.ONE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent12() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSName.A);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent13() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add((COSBase) new COSArray());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent14() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent15() throws IOException {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSString.parseHex("0123456789ABCDEF"));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent16() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add((COSBase) new COSDictionary());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent17() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add((COSBase) new COSStream());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent18() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSInteger.ONE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent19() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent20() throws IOException {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSString.parseHex("0123456789ABCDEF"));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent21() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) new COSDictionary());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent22() {
    // Arrange
    COSObject object = mock(COSObject.class);
    when(object.getObject()).thenReturn(COSBoolean.FALSE);
    when(object.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) object);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    verify(object).getObject();
    verify(object).getUpdateState();
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  void testSetParent23() {
    // Arrange
    COSObject object = mock(COSObject.class);
    when(object.getObject()).thenReturn(COSBoolean.FALSE);
    when(object.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) object);

    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);
    pdPageFitDestination.setPage(new PDPage());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setParent(parentNode);

    // Assert
    verify(object).getObject();
    verify(object).getUpdateState();
    assertNull(parentNode.getParent());
    assertTrue(parentNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#isRootNode()}
   */
  @Test
  void testIsRootNode() {
    // Arrange, Act and Assert
    assertTrue((new PDDestinationNameTreeNode()).isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#isRootNode()}
   */
  @Test
  void testIsRootNode2() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    // Act and Assert
    assertFalse(pdDestinationNameTreeNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#isRootNode()}
   */
  @Test
  void testIsRootNode3() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertTrue(pdDestinationNameTreeNode.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  void testGetKids() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getKids());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  void testGetKids2() throws IOException {
    // Arrange
    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(new PDDestinationNameTreeNode());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setKids(kids);

    // Act
    List<PDNameTreeNode<PDPageDestination>> actualKids = pdDestinationNameTreeNode.getKids();

    // Assert
    assertEquals(1, actualKids.size());
    PDNameTreeNode<PDPageDestination> getResult = actualKids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getNames());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getParent());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(getResult.isRootNode());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  void testGetKids3() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getKids());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertTrue(kids.isEmpty());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids2() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult.getNames());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids3() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    kids.add(pdDestinationNameTreeNode2);
    PDDestinationNameTreeNode pdDestinationNameTreeNode3 = new PDDestinationNameTreeNode();
    kids.add(pdDestinationNameTreeNode3);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(2, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(getResult2.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult2.getKids());
    assertNull(getResult.getNames());
    assertNull(getResult2.getNames());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertNull(getResult2.getParent());
    assertEquals(2, kids.size());
    assertTrue(getResult.isRootNode());
    assertTrue(getResult2.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
    assertSame(pdDestinationNameTreeNode3, kids.get(1));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids4() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(parentNode);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult.getNames());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
    assertSame(parentNode, pdDestinationNameTreeNode.getParent());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids5() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(new HashMap<>());

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.getNames().isEmpty());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids6() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult2 = names2.get("foo");
    assertTrue(getResult2 instanceof PDPageFitDestination);
    assertEquals("foo", getResult.getLowerLimit());
    assertEquals("foo", getResult.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult2.getPage());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(-1, getResult2.getPageNumber());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids7() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("Fit", mock(BiFunction.class));
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult2 = names2.get("foo");
    assertTrue(getResult2 instanceof PDPageFitDestination);
    assertEquals("foo", getResult.getLowerLimit());
    assertEquals("foo", getResult.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult2.getPage());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(-1, getResult2.getPageNumber());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids8() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult2 = names2.get("");
    assertTrue(getResult2 instanceof PDPageFitDestination);
    assertEquals("", getResult.getLowerLimit());
    assertEquals("", getResult.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult2.getPage());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(-1, getResult2.getPageNumber());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids9() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals("foo", getResult.getLowerLimit());
    assertEquals("foo", getResult.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    assertNull(names2.get("foo"));
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids10() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination(new COSArray()));

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids11() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(parentNode);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult2 = names2.get("foo");
    assertTrue(getResult2 instanceof PDPageFitDestination);
    assertEquals("foo", pdDestinationNameTreeNode.getLowerLimit());
    assertEquals("foo", getResult.getLowerLimit());
    assertEquals("foo", pdDestinationNameTreeNode.getUpperLimit());
    assertEquals("foo", getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult2.getPage());
    assertNull(getResult.getParent());
    assertEquals(-1, getResult2.getPageNumber());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
    assertSame(parentNode, pdDestinationNameTreeNode.getParent());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids12() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult2 = names2.get("foo");
    assertTrue(getResult2 instanceof PDPageFitDestination);
    assertEquals("foo", getResult.getLowerLimit());
    assertEquals("foo", getResult.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(getResult2.getPage());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(-1, getResult2.getPageNumber());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids13() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids14() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids15() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSInteger.ONE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids16() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSName.A);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids17() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSArray());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids18() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids19() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSString.parseHex("0123456789ABCDEF"));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids20() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSDictionary());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids21() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSStream());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids22() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSInteger.ONE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids23() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids24() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSString.parseHex("0123456789ABCDEF"));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  void testSetKids25() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) new COSDictionary());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(getResult.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult.getKids());
    assertNull(pdDestinationNameTreeNode.getParent());
    assertNull(getResult.getParent());
    assertEquals(1, kids.size());
    assertTrue(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode2, kids.get(0));
  }

  /**
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  void testGetValue() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getValue("Name"));
  }

  /**
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  void testGetValue2() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  void testGetValue3() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  void testGetValue4() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("Fit", mock(BiFunction.class));
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  void testGetValue5() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  void testGetValue6() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  void testGetNames() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getNames());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  void testGetNames2() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertTrue(pdDestinationNameTreeNode.getNames().isEmpty());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  void testGetNames3() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act
    Map<String, PDPageDestination> actualNames = pdDestinationNameTreeNode.getNames();

    // Assert
    assertEquals(1, actualNames.size());
    PDPageDestination getResult = actualNames.get("foo");
    List<? extends COSBase> toListResult = getResult.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSName);
    assertTrue(getResult instanceof PDPageFitDestination);
    assertEquals("Fit", ((COSName) getResult2).getName());
    assertNull(toListResult.get(0));
    assertNull(getResult2.getKey());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSName) getResult2).isEmpty());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  void testGetNames4() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("Fit", mock(BiFunction.class));
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act
    Map<String, PDPageDestination> actualNames = pdDestinationNameTreeNode.getNames();

    // Assert
    assertEquals(1, actualNames.size());
    PDPageDestination getResult = actualNames.get("foo");
    List<? extends COSBase> toListResult = getResult.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSName);
    assertTrue(getResult instanceof PDPageFitDestination);
    assertEquals("Fit", ((COSName) getResult2).getName());
    assertNull(toListResult.get(0));
    assertNull(getResult2.getKey());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSName) getResult2).isEmpty());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  void testGetNames5() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act
    Map<String, PDPageDestination> actualNames = pdDestinationNameTreeNode.getNames();

    // Assert
    assertEquals(1, actualNames.size());
    PDPageDestination getResult = actualNames.get("");
    List<? extends COSBase> toListResult = getResult.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSName);
    assertTrue(getResult instanceof PDPageFitDestination);
    assertEquals("Fit", ((COSName) getResult2).getName());
    assertNull(toListResult.get(0));
    assertNull(getResult2.getKey());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSName) getResult2).isEmpty());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  void testGetNames6() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act
    Map<String, PDPageDestination> actualNames = pdDestinationNameTreeNode.getNames();

    // Assert
    assertEquals(1, actualNames.size());
    assertNull(actualNames.get("foo"));
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdDestinationNameTreeNode.getNames().isEmpty());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames2() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    Map<String, PDPageDestination> names2 = pdDestinationNameTreeNode.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult = names2.get("foo");
    assertTrue(getResult instanceof PDPageFitDestination);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames3() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));
    names.put("foo", new PDPageFitDestination());

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    Map<String, PDPageDestination> names2 = pdDestinationNameTreeNode.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult = names2.get("foo");
    assertTrue(getResult instanceof PDPageFitDestination);
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames4() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    // Act
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdDestinationNameTreeNode.getNames().isEmpty());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames5() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    Map<String, PDPageDestination> names2 = pdDestinationNameTreeNode.getNames();
    assertEquals(1, names2.size());
    assertNull(names2.get("foo"));
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames6() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", new PDPageFitDestination());

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    Map<String, PDPageDestination> names2 = pdDestinationNameTreeNode.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult = names2.get("42");
    assertTrue(getResult instanceof PDPageFitDestination);
    assertEquals("42", pdDestinationNameTreeNode.getLowerLimit());
    assertEquals("42", pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames7() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    Map<String, PDPageDestination> names2 = pdDestinationNameTreeNode.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult = names2.get("");
    assertTrue(getResult instanceof PDPageFitDestination);
    assertEquals("", pdDestinationNameTreeNode.getLowerLimit());
    assertEquals("", pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames8() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", null);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertEquals("42", pdDestinationNameTreeNode.getLowerLimit());
    assertEquals("42", pdDestinationNameTreeNode.getUpperLimit());
    Map<String, PDPageDestination> names2 = pdDestinationNameTreeNode.getNames();
    assertEquals(1, names2.size());
    assertNull(names2.get("42"));
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames9() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", new PDPageFitDestination(new COSArray()));

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames10() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames11() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames12() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSInteger.ONE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames13() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSName.A);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames14() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSDictionary());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames15() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSArray());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames16() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames17() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSString.parseHex("0123456789ABCDEF"));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames18() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSStream());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames19() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSInteger.ONE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames20() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) new COSDictionary());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames21() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  void testSetNames22() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSString.parseHex("0123456789ABCDEF"));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("42", pdPageFitDestination);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  void testGetUpperLimit() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getUpperLimit());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  void testGetUpperLimit2() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  void testGetUpperLimit3() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertEquals("", pdDestinationNameTreeNode.getUpperLimit());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  void testGetUpperLimit4() {
    // Arrange
    BiFunction<String, PDPageDestination, PDPageDestination> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<PDPageDestination>any()))
        .thenReturn(new PDPageFitDestination());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());
    names.put("", new PDPageFitDestination());
    names.computeIfPresent("foo", biFunction);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act
    String actualUpperLimit = pdDestinationNameTreeNode.getUpperLimit();

    // Assert
    verify(biFunction).apply(eq("foo"), isA(PDPageDestination.class));
    assertEquals("foo", actualUpperLimit);
  }

  /**
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  void testGetLowerLimit() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getLowerLimit());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  void testGetLowerLimit2() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  void testGetLowerLimit3() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());
    names.computeIfPresent("foo", mock(BiFunction.class));

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertEquals("", pdDestinationNameTreeNode.getLowerLimit());
  }

  /**
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  void testGetLowerLimit4() {
    // Arrange
    BiFunction<String, PDPageDestination, PDPageDestination> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<PDPageDestination>any()))
        .thenReturn(new PDPageFitDestination());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());
    names.computeIfPresent("foo", biFunction);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act
    String actualLowerLimit = pdDestinationNameTreeNode.getLowerLimit();

    // Assert
    verify(biFunction).apply(eq("foo"), isA(PDPageDestination.class));
    assertEquals("foo", actualLowerLimit);
  }
}
