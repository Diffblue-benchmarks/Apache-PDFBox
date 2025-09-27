package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDNameTreeNodeDiffblueTest {
  /**
   * Test {@link PDNameTreeNode#getCOSObject()}.
   *
   * <p>Method under test: {@link PDNameTreeNode#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDNameTreeNode.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDDestinationNameTreeNode().getCOSObject();

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
   *
   * <p>Method under test: {@link PDNameTreeNode#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDNameTreeNode PDNameTreeNode.getParent()"})
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull(new PDDestinationNameTreeNode().getParent());
  }

  /**
   * Test {@link PDNameTreeNode#setParent(PDNameTreeNode)}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSObject#getObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDNameTreeNode); given COSObject getObject() return FALSE; then calls getObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setParent(PDNameTreeNode)"})
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
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return {@link COSNull#NULL}.
   *   <li>Then calls {@link COSObject#getObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDNameTreeNode); given COSObject getObject() return NULL; then calls getObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setParent(PDNameTreeNode)"})
  void testSetParent_givenCOSObjectGetObjectReturnNull_thenCallsGetObject() {
    // Arrange
    COSObject object = mock(COSObject.class);
    when(object.getObject()).thenReturn(COSNull.NULL);
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
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()} Page is {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setParent(PDNameTreeNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDNameTreeNode); given PDPageFitDestination(COSArray) with arr is COSArray() Page is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setParent(PDNameTreeNode)"})
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
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#isRootNode()}
   */
  @Test
  @DisplayName("Test isRootNode(); given PDDestinationNameTreeNode(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDNameTreeNode.isRootNode()"})
  void testIsRootNode_givenPDDestinationNameTreeNode_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDDestinationNameTreeNode().isRootNode());
  }

  /**
   * Test {@link PDNameTreeNode#isRootNode()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#isRootNode()}
   */
  @Test
  @DisplayName("Test isRootNode(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDNameTreeNode.isRootNode()"})
  void testIsRootNode_thenReturnFalse() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    // Act and Assert
    assertFalse(pdDestinationNameTreeNode.isRootNode());
  }

  /**
   * Test {@link PDNameTreeNode#getKids()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  @DisplayName(
      "Test getKids(); given ArrayList() add PDDestinationNameTreeNode(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDNameTreeNode.getKids()"})
  void testGetKids_givenArrayListAddPDDestinationNameTreeNode_thenReturnSizeIsOne()
      throws IOException {
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
    assertNull(cOSObject.getKey());
    assertNull(getResult.getParent());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(getResult.isRootNode());
  }

  /**
   * Test {@link PDNameTreeNode#getKids()}.
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDDestinationNameTreeNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDNameTreeNode.getKids()"})
  void testGetKids_givenPDDestinationNameTreeNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDestinationNameTreeNode().getKids());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSObject#COSObject(COSBase, COSObjectKey)}
   *       with object is {@link COSBoolean#FALSE} and objectKey is {@link
   *       COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); given COSArray() add COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_givenCOSArrayAddCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArray arr = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(4L, 4));
    arr.add((COSBase) object);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", pdPageFitDestination);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray() add parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
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

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link
   *       PDPageFitDestination#PDPageFitDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); given HashMap() 'foo' is PDPageFitDestination(COSArray) with arr is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_givenHashMapFooIsPDPageFitDestinationWithArrIsCOSArray() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination(new COSArray()));

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link COSArrayList#COSArrayList()} first LowerLimit is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then COSArrayList() first LowerLimit is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenCOSArrayListFirstLowerLimitIsFoo() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    assertTrue(names2.get("foo") instanceof PDPageFitDestination);
    assertEquals("foo", getResult2.getLowerLimit());
    assertEquals("foo", getResult2.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link COSArrayList#COSArrayList()} first Parent COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then COSArrayList() first Parent COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenCOSArrayListFirstParentCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    PDDestinationNameTreeNode parentNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(parentNode);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
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
   *
   * <ul>
   *   <li>Then {@link COSArrayList#COSArrayList()} first Parent Kids first Names is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then COSArrayList() first Parent Kids first Names is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenCOSArrayListFirstParentKidsFirstNamesIsNull() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(new PDDestinationNameTreeNode());

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
    assertNull(getResult.getNames());
    assertNull(getResult3.getNames());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids first LowerLimit
   *       is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); then PDDestinationNameTreeNode() Kids first LowerLimit is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstLowerLimitIsEmptyString() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertEquals("", getResult.getLowerLimit());
    assertEquals("", getResult2.getLowerLimit());
    assertEquals("", getResult.getUpperLimit());
    assertEquals("", getResult2.getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids first Names
   *       Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() Kids first Names Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstNamesEmpty() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(new HashMap<>());

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    assertNull(getResult.getLowerLimit());
    assertNull(getResult3.getLowerLimit());
    assertNull(getResult.getUpperLimit());
    assertNull(getResult3.getUpperLimit());
    assertTrue(getResult.getNames().isEmpty());
    assertTrue(getResult3.getNames().isEmpty());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids first Names
   *       {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); then PDDestinationNameTreeNode() Kids first Names 'foo' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstNamesFooIsNull() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    assertNull(names2.get("foo"));
    Map<String, PDPageDestination> names3 = getResult3.getNames();
    assertEquals(1, names3.size());
    assertNull(names3.get("foo"));
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids first Names
   *       {@code foo} Page is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); then PDDestinationNameTreeNode() Kids first Names 'foo' Page is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenPDDestinationNameTreeNodeKidsFirstNamesFooPageIsNull() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setParent(new PDDestinationNameTreeNode());
    pdDestinationNameTreeNode2.setNames(names);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(pdDestinationNameTreeNode2);

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(1, kids2.size());
    PDNameTreeNode<PDPageDestination> getResult = kids2.get(0);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertEquals(1, kids.size());
    PDNameTreeNode<PDPageDestination> getResult2 = kids.get(0);
    PDNameTreeNode<PDPageDestination> parent = getResult2.getParent();
    List<PDNameTreeNode<PDPageDestination>> kids3 = parent.getKids();
    assertEquals(1, kids3.size());
    PDNameTreeNode<PDPageDestination> getResult3 = kids3.get(0);
    assertTrue(getResult3 instanceof PDDestinationNameTreeNode);
    assertTrue(getResult2 instanceof PDDestinationNameTreeNode);
    assertTrue(parent instanceof PDDestinationNameTreeNode);
    Map<String, PDPageDestination> names2 = getResult.getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult4 = names2.get("foo");
    assertTrue(getResult4 instanceof PDPageFitDestination);
    assertNull(getResult4.getPage());
    assertEquals(-1, getResult4.getPageNumber());
    Map<String, PDPageDestination> names3 = getResult3.getNames();
    assertEquals(1, names3.size());
    assertTrue(names3.containsKey("foo"));
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Kids size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() Kids size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenPDDestinationNameTreeNodeKidsSizeIsTwo() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
    kids.add(new PDDestinationNameTreeNode());
    kids.add(new PDDestinationNameTreeNode());

    // Act
    pdDestinationNameTreeNode.setKids(kids);

    // Assert
    List<PDNameTreeNode<PDPageDestination>> kids2 = pdDestinationNameTreeNode.getKids();
    assertEquals(2, kids2.size());
    assertTrue(kids2.get(1) instanceof PDDestinationNameTreeNode);
    assertEquals(2, kids.size());
    PDNameTreeNode<PDPageDestination> getResult = kids.get(1);
    assertTrue(getResult instanceof PDDestinationNameTreeNode);
    assertFalse(getResult.isRootNode());
    assertSame(pdDestinationNameTreeNode, getResult.getParent());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} LowerLimit is {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDDestinationNameTreeNode() LowerLimit is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_thenPDDestinationNameTreeNodeLowerLimitIsFoo() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode pdDestinationNameTreeNode2 = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode2.setNames(names);

    COSArrayList<PDNameTreeNode<PDPageDestination>> kids = new COSArrayList<>();
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} LowerLimit is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); when ArrayList(); then PDDestinationNameTreeNode() LowerLimit is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_whenArrayList_thenPDDestinationNameTreeNodeLowerLimitIsNull() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setKids(new ArrayList<>());

    // Assert that nothing has changed
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getKids());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>When {@link COSArrayList#COSArrayList()}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} LowerLimit is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); when COSArrayList(); then PDDestinationNameTreeNode() LowerLimit is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_whenCOSArrayList_thenPDDestinationNameTreeNodeLowerLimitIsNull() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setKids(new COSArrayList<>());

    // Assert that nothing has changed
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getKids());
  }

  /**
   * Test {@link PDNameTreeNode#setKids(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} LowerLimit is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); when 'null'; then PDDestinationNameTreeNode() LowerLimit is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setKids(List)"})
  void testSetKids_whenNull_thenPDDestinationNameTreeNodeLowerLimitIsNull() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setKids(null);

    // Assert that nothing has changed
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    assertNull(pdDestinationNameTreeNode.getKids());
  }

  /**
   * Test {@link PDNameTreeNode#getValue(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is {@link
   *       PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName(
      "Test getValue(String); given HashMap() empty string is PDPageFitDestination(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.COSObjectable PDNameTreeNode.getValue(String)"
  })
  void testGetValue_givenHashMapEmptyStringIsPDPageFitDestination_thenReturnNull()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given HashMap() 'foo' is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.COSObjectable PDNameTreeNode.getValue(String)"
  })
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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link
   *       PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName(
      "Test getValue(String); given HashMap() 'foo' is PDPageFitDestination(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.COSObjectable PDNameTreeNode.getValue(String)"
  })
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
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName(
      "Test getValue(String); given PDDestinationNameTreeNode() Names is HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.COSObjectable PDNameTreeNode.getValue(String)"
  })
  void testGetValue_givenPDDestinationNameTreeNodeNamesIsHashMap_thenReturnNull()
      throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertNull(pdDestinationNameTreeNode.getValue("Name"));
  }

  /**
   * Test {@link PDNameTreeNode#getValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given PDDestinationNameTreeNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.COSObjectable PDNameTreeNode.getValue(String)"
  })
  void testGetValue_givenPDDestinationNameTreeNode_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDDestinationNameTreeNode().getValue("Name"));
  }

  /**
   * Test {@link PDNameTreeNode#getNames()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code null}.
   *   <li>Then return {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); given HashMap() 'foo' is 'null'; then return 'foo' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDNameTreeNode.getNames()"})
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
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName(
      "Test getNames(); given PDDestinationNameTreeNode() Names is HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDNameTreeNode.getNames()"})
  void testGetNames_givenPDDestinationNameTreeNodeNamesIsHashMap_thenReturnEmpty()
      throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setNames(new HashMap<>());

    // Act and Assert
    assertTrue(pdDestinationNameTreeNode.getNames().isEmpty());
  }

  /**
   * Test {@link PDNameTreeNode#getNames()}.
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); given PDDestinationNameTreeNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDNameTreeNode.getNames()"})
  void testGetNames_givenPDDestinationNameTreeNode_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDDestinationNameTreeNode().getNames());
  }

  /**
   * Test {@link PDNameTreeNode#getNames()}.
   *
   * <ul>
   *   <li>Then return empty string COSObject toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); then return empty string COSObject toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDNameTreeNode.getNames()"})
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
   *
   * <ul>
   *   <li>Then return {@code foo} COSObject toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getNames()}
   */
  @Test
  @DisplayName("Test getNames(); then return 'foo' COSObject toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDNameTreeNode.getNames()"})
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
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    arr.add((COSBase) object);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddA() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSName.A);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddCOSArray() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSArray());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddCOSDictionary() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSDictionary());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddCOSStream() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add((COSBase) new COSStream());
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddFalse() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddFalse2() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddOne() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSInteger.ONE);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given COSArray() add parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenCOSArrayAddParseHex0123456789abcdef() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    COSArray arr = new COSArray();
    arr.add(COSString.parseHex("0123456789ABCDEF"));
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", pdPageFitDestination);

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
   *
   * <ul>
   *   <li>Given {@code Fit}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName(
      "Test setNames(Map); given 'Fit'; then PDDestinationNameTreeNode() Names size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenFit_thenPDDestinationNameTreeNodeNamesSizeIsTwo() throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("Fit", new PDPageFitDestination());
    names.put("", new PDPageFitDestination());

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    Map<String, PDPageDestination> names2 = pdDestinationNameTreeNode.getNames();
    assertEquals(2, names2.size());
    PDPageDestination getResult = names2.get("Fit");
    assertTrue(getResult instanceof PDPageFitDestination);
    assertEquals("Fit", pdDestinationNameTreeNode.getUpperLimit());
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
    assertTrue(names2.containsKey(""));
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); given PDPageFitDestination(COSArray) with arr is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_givenPDPageFitDestinationWithArrIsCOSArray() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", new PDPageFitDestination(new COSArray()));

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
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} LowerLimit is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); then PDDestinationNameTreeNode() LowerLimit is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_thenPDDestinationNameTreeNodeLowerLimitIsEmptyString() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();
    pdDestinationNameTreeNode.setParent(new PDDestinationNameTreeNode());

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("", null);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertEquals("", pdDestinationNameTreeNode.getLowerLimit());
    assertEquals("", pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names empty string
   *       {@link PDPageFitDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName(
      "Test setNames(Map); then PDDestinationNameTreeNode() Names empty string PDPageFitDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_thenPDDestinationNameTreeNodeNamesEmptyStringPDPageFitDestination()
      throws IOException {
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
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   *
   * <ul>
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names {@code foo}
   *       {@link PDPageFitDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName(
      "Test setNames(Map); then PDDestinationNameTreeNode() Names 'foo' PDPageFitDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
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
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName(
      "Test setNames(Map); when HashMap() 'foo' is 'null'; then PDDestinationNameTreeNode() Names is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_whenHashMapFooIsNull_thenPDDestinationNameTreeNodeNamesIsHashMap()
      throws IOException {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", null);

    // Act
    pdDestinationNameTreeNode.setNames(names);

    // Assert
    assertNull(pdDestinationNameTreeNode.getLowerLimit());
    assertNull(pdDestinationNameTreeNode.getUpperLimit());
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(names, pdDestinationNameTreeNode.getNames());
  }

  /**
   * Test {@link PDNameTreeNode#setNames(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); when HashMap(); then PDDestinationNameTreeNode() Names Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
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
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} Names Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName("Test setNames(Map); when HashMap(); then PDDestinationNameTreeNode() Names Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
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
   * Test {@link PDNameTreeNode#setNames(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()} COSObject size is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#setNames(Map)}
   */
  @Test
  @DisplayName(
      "Test setNames(Map); when 'null'; then PDDestinationNameTreeNode() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNameTreeNode.setNames(Map)"})
  void testSetNames_whenNull_thenPDDestinationNameTreeNodeCOSObjectSizeIsZero() {
    // Arrange
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode();

    // Act
    pdDestinationNameTreeNode.setNames(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDestinationNameTreeNode.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNameTreeNode#getUpperLimit()}.
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getUpperLimit()}
   */
  @Test
  @DisplayName("Test getUpperLimit(); given PDDestinationNameTreeNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNameTreeNode.getUpperLimit()"})
  void testGetUpperLimit_givenPDDestinationNameTreeNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDestinationNameTreeNode().getUpperLimit());
  }

  /**
   * Test {@link PDNameTreeNode#getLowerLimit()}.
   *
   * <ul>
   *   <li>Given {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNameTreeNode#getLowerLimit()}
   */
  @Test
  @DisplayName("Test getLowerLimit(); given PDDestinationNameTreeNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNameTreeNode.getLowerLimit()"})
  void testGetLowerLimit_givenPDDestinationNameTreeNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDestinationNameTreeNode().getLowerLimit());
  }
}
