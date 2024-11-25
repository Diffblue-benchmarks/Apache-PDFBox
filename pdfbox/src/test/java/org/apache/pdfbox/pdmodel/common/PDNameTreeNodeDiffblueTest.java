package org.apache.pdfbox.pdmodel.common;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDNameTreeNodeDiffblueTest {
  /**
   * Test {@link PDNameTreeNode#getCOSObject()}.
   * <p>
   * Method under test: {@link PDNameTreeNode#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
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
   * Test {@link PDNameTreeNode#getParent()}.
   * <p>
   * Method under test: {@link PDNameTreeNode#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getParent());
  }

  /**
   * Test {@link PDNameTreeNode#setParent(PDNameTreeNode)}.
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSObject#getObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test setParent(PDNameTreeNode); given COSObject getObject() return FALSE; then calls getObject()")
  void testSetParent_givenCOSObjectGetObjectReturnFalse_thenCallsGetObject() {
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

    // Act
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    // Assert
    verify(object).getObject();
    verify(object).getUpdateState();
  }

  /**
   * Test {@link PDNameTreeNode#setParent(PDNameTreeNode)}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()} Page is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  @DisplayName("Test setParent(PDNameTreeNode); given PDPageFitDestination(COSArray) with arr is COSArray() Page is PDPage()")
  void testSetParent_givenPDPageFitDestinationWithArrIsCOSArrayPageIsPDPage() {
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

    // Act
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    // Assert
    verify(object).getObject();
    verify(object).getUpdateState();
  }

  /**
   * Test {@link PDNameTreeNode#isRootNode()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#isRootNode()}
   */
  @Test
  @DisplayName("Test isRootNode(); given PDDestinationNameTreeNode(); then return 'true'")
  void testIsRootNode_givenPDDestinationNameTreeNode_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDDestinationNameTreeNode()).isRootNode());
  }

  /**
   * Test {@link PDNameTreeNode#isRootNode()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#isRootNode()}
   */
  @Test
  @DisplayName("Test isRootNode(); then return 'false'")
  void testIsRootNode_thenReturnFalse() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    // Act and Assert
    assertFalse(pdDestinationNameTreeNode.isRootNode());
  }

  /**
   * Test {@link PDNameTreeNode#getKids()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given ArrayList() add PDDestinationNameTreeNode(); then return size is one")
  void testGetKids_givenArrayListAddPDDestinationNameTreeNode_thenReturnSizeIsOne() throws IOException {
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
   * Test {@link PDNameTreeNode#getKids()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDDestinationNameTreeNode() Names is HashMap(); then return 'null'")
  void testGetKids_givenPDDestinationNameTreeNodeNamesIsHashMap_thenReturnNull() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getKids());
  }

  /**
   * Test {@link PDNameTreeNode#getKids()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDDestinationNameTreeNode(); then return 'null'")
  void testGetKids_givenPDDestinationNameTreeNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getKids());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  void testSetKids() throws IOException {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult2.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult4 = names2.get("");
    assertTrue(getResult4 instanceof PDPageFitDestination);
    Map<String, PDPageDestination> names3 = getResult3.getNames();
    assertEquals(1, names3.size());
    PDPageDestination getResult5 = names3.get("");
    assertTrue(getResult5 instanceof PDPageFitDestination);
    assertEquals("", getResult.getLowerLimit());
    assertEquals("", getResult2.getLowerLimit());
    assertEquals("", getResult3.getLowerLimit());
    assertEquals("", getResult.getUpperLimit());
    assertEquals("", getResult2.getUpperLimit());
    assertEquals("", getResult3.getUpperLimit());
    assertNull(getResult4.getPage());
    assertNull(getResult5.getPage());
    assertEquals(-1, getResult4.getPageNumber());
    assertEquals(-1, getResult5.getPageNumber());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add A")
  void testSetKids_givenCOSArrayAddA() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add COSArray()")
  void testSetKids_givenCOSArrayAddCOSArray() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add COSDictionary()")
  void testSetKids_givenCOSArrayAddCOSDictionary() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add COSDictionary()")
  void testSetKids_givenCOSArrayAddCOSDictionary2() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add COSStream()")
  void testSetKids_givenCOSArrayAddCOSStream() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add FALSE")
  void testSetKids_givenCOSArrayAddFalse() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add FALSE")
  void testSetKids_givenCOSArrayAddFalse2() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add ONE")
  void testSetKids_givenCOSArrayAddOne() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add ONE")
  void testSetKids_givenCOSArrayAddOne2() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add parseHex
   * {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add parseHex '0123456789ABCDEF'")
  void testSetKids_givenCOSArrayAddParseHex0123456789abcdef() throws IOException {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add parseHex
   * {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add parseHex '0123456789ABCDEF'")
  void testSetKids_givenCOSArrayAddParseHex0123456789abcdef2() throws IOException {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetKids_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetKids_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with arr is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given HashMap() 'foo' is PDPageFitDestination(COSArray) with arr is COSArray()")
  void testSetKids_givenHashMapFooIsPDPageFitDestinationWithArrIsCOSArray() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Parent COSObject Values size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then ArrayList() first Parent COSObject Values size is two")
  void testSetKids_thenArrayListFirstParentCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(parentNode);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(new PDDestinationNameTreeNode());

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    COSDictionary cOSObject = parent.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(parent.isRootNode());
    assertSame(parentNode, parent.getParent());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Parent is
   * {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then ArrayList() first Parent is PDDestinationNameTreeNode()")
  void testSetKids_thenArrayListFirstParentIsPDDestinationNameTreeNode() {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertSame(pdDestinationNameTreeNode, getResult.getParent());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids
   * first Names Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() Kids first Names Empty")
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstNamesEmpty() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(new HashMap<>());

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
    assertTrue(getResult2.getNames().isEmpty());
    assertTrue(getResult3.getNames().isEmpty());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids
   * first Names {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() Kids first Names 'foo' is 'null'")
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstNamesFooIsNull() throws IOException {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult2.getNames();
    assertEquals(1, names2.size());
    assertNull(names2.get("foo"));
    Map<String, PDPageDestination> names3 = getResult3.getNames();
    assertEquals(1, names3.size());
    assertNull(names3.get("foo"));
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids
   * first Names {@code foo} {@link PDPageFitDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() Kids first Names 'foo' PDPageFitDestination")
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstNamesFooPDPageFitDestination() throws IOException {
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
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult2.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult4 = names2.get("foo");
    assertTrue(getResult4 instanceof PDPageFitDestination);
    Map<String, PDPageDestination> names3 = getResult3.getNames();
    assertEquals(1, names3.size());
    PDPageDestination getResult5 = names3.get("foo");
    assertTrue(getResult5 instanceof PDPageFitDestination);
    assertEquals("foo", getResult.getLowerLimit());
    assertEquals("foo", getResult.getUpperLimit());
    assertNull(getResult4.getPage());
    assertNull(getResult5.getPage());
    assertEquals(-1, getResult4.getPageNumber());
    assertEquals(-1, getResult5.getPageNumber());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids
   * first Names is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() Kids first Names is 'null'")
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstNamesIsNull() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(new PDDestinationNameTreeNode());

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult2.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult2.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
    assertNull(getResult2.getNames());
    assertNull(getResult3.getNames());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}
   * LowerLimit is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() LowerLimit is 'foo'")
  void testSetKids_thenPDDestinationNameTreeNodeLowerLimitIsFoo() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertEquals("foo", pdDestinationNameTreeNode.getLowerLimit());
    assertEquals("foo", parent.getLowerLimit());
    assertEquals("foo", pdDestinationNameTreeNode.getUpperLimit());
    assertEquals("foo", parent.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); when ArrayList() add PDDestinationNameTreeNode(); then ArrayList() size is two")
  void testSetKids_whenArrayListAddPDDestinationNameTreeNode_thenArrayListSizeIsTwo() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    ArrayList<PDNameTreeNode<PDPageDestination>> kids = new ArrayList<>();
    kids.add(new PDDestinationNameTreeNode());
    kids.add(new PDDestinationNameTreeNode());

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    assertEquals(2, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(1);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(2, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids2.get(1);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    PDNameTreeNode<PDPageDestination> parent = getResult.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(2, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult4 = kids3.get(1);
    assertTrue(getResult4 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult4.getLowerLimit());
    assertNull(getResult3.getUpperLimit());
    assertNull(getResult4.getUpperLimit());
    assertNull(getResult3.getKids());
    assertNull(getResult4.getKids());
    assertNull(getResult3.getNames());
    assertNull(getResult4.getNames());
    assertNull(getResult3.getParent());
    assertNull(getResult4.getParent());
    assertFalse(getResult2.isRootNode());
    assertTrue(getResult3.isRootNode());
    assertTrue(getResult4.isRootNode());
    assertSame(pdDestinationNameTreeNode, getResult2.getParent());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}
   * LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); when ArrayList(); then PDDestinationNameTreeNode() LowerLimit is 'null'")
  void testSetKids_whenArrayList_thenPDDestinationNameTreeNodeLowerLimitIsNull() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setKids(new ArrayList<>());

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getKids());
  }

  /**
   * Test {@link PDNameTreeNode#getValue(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is
   * {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given HashMap() empty string is PDPageFitDestination(); then return 'null'")
  void testGetValue_givenHashMapEmptyStringIsPDPageFitDestination_thenReturnNull() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Test {@link PDNameTreeNode#getValue(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given HashMap() 'foo' is 'null'; then return 'null'")
  void testGetValue_givenHashMapFooIsNull_thenReturnNull() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Test {@link PDNameTreeNode#getValue(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given HashMap() 'foo' is PDPageFitDestination(); then return 'null'")
  void testGetValue_givenHashMapFooIsPDPageFitDestination_thenReturnNull() throws IOException {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Test {@link PDNameTreeNode#getValue(String)}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given PDDestinationNameTreeNode() Names is HashMap(); then return 'null'")
  void testGetValue_givenPDDestinationNameTreeNodeNamesIsHashMap_thenReturnNull() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Test {@link PDNameTreeNode#getValue(String)}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given PDDestinationNameTreeNode(); then return 'null'")
  void testGetValue_givenPDDestinationNameTreeNode_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getValue("Name"));
  }

  /**
   * Test {@link PDNameTreeNode#getNames()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   *   <li>Then return {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); given HashMap() 'foo' is 'null'; then return 'foo' is 'null'")
  void testGetNames_givenHashMapFooIsNull_thenReturnFooIsNull() throws IOException {
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
   * Test {@link PDNameTreeNode#getNames()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); given PDDestinationNameTreeNode() Names is HashMap(); then return Empty")
  void testGetNames_givenPDDestinationNameTreeNodeNamesIsHashMap_thenReturnEmpty() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertTrue(pdDestinationNameTreeNode.getNames().isEmpty());
  }

  /**
   * Test {@link PDNameTreeNode#getNames()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); given PDDestinationNameTreeNode(); then return 'null'")
  void testGetNames_givenPDDestinationNameTreeNode_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getNames());
  }

  /**
   * Test {@link PDNameTreeNode#getNames()}.
   * <ul>
   *   <li>Then return empty string COSObject toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); then return empty string COSObject toList size is two")
  void testGetNames_thenReturnEmptyStringCOSObjectToListSizeIsTwo() throws IOException {
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
   * Test {@link PDNameTreeNode#getNames()}.
   * <ul>
   *   <li>Then return {@code foo} COSObject toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); then return 'foo' COSObject toList size is two")
  void testGetNames_thenReturnFooCOSObjectToListSizeIsTwo() throws IOException {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add A")
  void testSetNames_givenCOSArrayAddA() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add COSArray()")
  void testSetNames_givenCOSArrayAddCOSArray() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add COSDictionary()")
  void testSetNames_givenCOSArrayAddCOSDictionary() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add COSDictionary()")
  void testSetNames_givenCOSArrayAddCOSDictionary2() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add COSStream()")
  void testSetNames_givenCOSArrayAddCOSStream() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add FALSE")
  void testSetNames_givenCOSArrayAddFalse() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add FALSE")
  void testSetNames_givenCOSArrayAddFalse2() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add ONE")
  void testSetNames_givenCOSArrayAddOne() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add ONE")
  void testSetNames_givenCOSArrayAddOne2() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add parseHex
   * {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add parseHex '0123456789ABCDEF'")
  void testSetNames_givenCOSArrayAddParseHex0123456789abcdef() throws IOException {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add parseHex
   * {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add parseHex '0123456789ABCDEF'")
  void testSetNames_givenCOSArrayAddParseHex0123456789abcdef2() throws IOException {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetNames_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetNames_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given PDPageFitDestination(COSArray) with arr is COSArray()")
  void testSetNames_givenPDPageFitDestinationWithArrIsCOSArray() {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * {@code 42} {@link PDPageFitDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); then PDDestinationNameTreeNode() Names '42' PDPageFitDestination")
  void testSetNames_thenPDDestinationNameTreeNodeNames42PDPageFitDestination() throws IOException {
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
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * empty string {@link PDPageFitDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); then PDDestinationNameTreeNode() Names empty string PDPageFitDestination")
  void testSetNames_thenPDDestinationNameTreeNodeNamesEmptyStringPDPageFitDestination() throws IOException {
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
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * {@code foo} {@link PDPageFitDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); then PDDestinationNameTreeNode() Names 'foo' PDPageFitDestination")
  void testSetNames_thenPDDestinationNameTreeNodeNamesFooPDPageFitDestination() throws IOException {
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
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code null}.</li>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}
   * LowerLimit is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); when HashMap() '42' is 'null'; then PDDestinationNameTreeNode() LowerLimit is '42'")
  void testSetNames_whenHashMap42IsNull_thenPDDestinationNameTreeNodeLowerLimitIs42() throws IOException {
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
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); when HashMap() 'foo' is 'null'; then PDDestinationNameTreeNode() Names 'foo' is 'null'")
  void testSetNames_whenHashMapFooIsNull_thenPDDestinationNameTreeNodeNamesFooIsNull() throws IOException {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); when HashMap(); then PDDestinationNameTreeNode() Names Empty")
  void testSetNames_whenHashMap_thenPDDestinationNameTreeNodeNamesEmpty() throws IOException {
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); when HashMap(); then PDDestinationNameTreeNode() Names Empty")
  void testSetNames_whenHashMap_thenPDDestinationNameTreeNodeNamesEmpty2() throws IOException {
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
   * Test {@link PDNameTreeNode#getUpperLimit()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); given HashMap() 'foo' is PDPageFitDestination(); then return 'foo'")
  void testGetUpperLimit_givenHashMapFooIsPDPageFitDestination_thenReturnFoo() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertEquals("foo", pdDestinationNameTreeNode.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getUpperLimit()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); given PDDestinationNameTreeNode() Names is HashMap(); then return 'null'")
  void testGetUpperLimit_givenPDDestinationNameTreeNodeNamesIsHashMap_thenReturnNull() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getUpperLimit()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); given PDDestinationNameTreeNode(); then return 'null'")
  void testGetUpperLimit_givenPDDestinationNameTreeNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getUpperLimit()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); then return empty string")
  void testGetUpperLimit_thenReturnEmptyString() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertEquals("", pdDestinationNameTreeNode.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getLowerLimit()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); given HashMap() 'foo' is PDPageFitDestination(); then return 'foo'")
  void testGetLowerLimit_givenHashMapFooIsPDPageFitDestination_thenReturnFoo() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertEquals("foo", pdDestinationNameTreeNode.getLowerLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getLowerLimit()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names
   * is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); given PDDestinationNameTreeNode() Names is HashMap(); then return 'null'")
  void testGetLowerLimit_givenPDDestinationNameTreeNodeNamesIsHashMap_thenReturnNull() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getLowerLimit()}.
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); given PDDestinationNameTreeNode(); then return 'null'")
  void testGetLowerLimit_givenPDDestinationNameTreeNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDestinationNameTreeNode()).getLowerLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getLowerLimit()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); then return empty string")
  void testGetLowerLimit_thenReturnEmptyString() {
    // Arrange
    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode.setNames(names);

    // Act and Assert
    assertEquals("", pdDestinationNameTreeNode.getLowerLimit());
  }
}
