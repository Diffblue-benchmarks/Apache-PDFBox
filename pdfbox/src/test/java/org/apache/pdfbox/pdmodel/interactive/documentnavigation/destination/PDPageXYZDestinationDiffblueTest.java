package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageXYZDestinationDiffblueTest {
  /**
   * Test {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)}.
   *
   * <p>Method under test: {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageXYZDestination(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.<init>(COSArray)"})
  void testNewPDPageXYZDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = new PDPageXYZDestination(arr).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageXYZDestination#PDPageXYZDestination()}.
   *
   * <p>Method under test: {@link PDPageXYZDestination#PDPageXYZDestination()}
   */
  @Test
  @DisplayName("Test new PDPageXYZDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.<init>()"})
  void testNewPDPageXYZDestination2() {
    // Arrange and Act
    PDPageXYZDestination actualPdPageXYZDestination = new PDPageXYZDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(actualPdPageXYZDestination.getPage());
    assertEquals(-1, actualPdPageXYZDestination.getPageNumber());
    assertEquals(-1, actualPdPageXYZDestination.getLeft());
    assertEquals(-1, actualPdPageXYZDestination.getTop());
    assertEquals(-1.0f, actualPdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#getLeft()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  @DisplayName(
      "Test getLeft(); given COSArray(List) with cosObjectables is ArrayList() add FALSE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getLeft()"})
  void testGetLeft_givenCOSArrayWithCosObjectablesIsArrayListAddFalse_thenReturnOne() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    arr.add(COSFloat.ONE);

    // Act and Assert
    assertEquals(1, new PDPageXYZDestination(arr).getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#getLeft()}.
   *
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()} Left is two.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageXYZDestination() Left is two; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getLeft()"})
  void testGetLeft_givenPDPageXYZDestinationLeftIsTwo_thenReturnTwo() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();
    pdPageXYZDestination.setLeft(2);

    // Act and Assert
    assertEquals(2, pdPageXYZDestination.getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#getLeft()}.
   *
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  @DisplayName(
      "Test getLeft(); given PDPageXYZDestination(COSArray) with arr is COSArray(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getLeft()"})
  void testGetLeft_givenPDPageXYZDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageXYZDestination(new COSArray()).getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#getLeft()}.
   *
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageXYZDestination(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getLeft()"})
  void testGetLeft_givenPDPageXYZDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageXYZDestination().getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#setLeft(int)}.
   *
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()} COSObject toList size is five.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  @DisplayName(
      "Test setLeft(int); then PDPageXYZDestination(COSArray) with arr is COSArray() COSObject toList size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setLeft(int)"})
  void testSetLeft_thenPDPageXYZDestinationWithArrIsCOSArrayCOSObjectToListSizeIsFive() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(new COSArray());

    // Act
    pdPageXYZDestination.setLeft(2);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#setLeft(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList third Key is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  @DisplayName(
      "Test setLeft(int); when MIN_VALUE; then PDPageXYZDestination() COSObject toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setLeft(int)"})
  void testSetLeft_whenMin_value_thenPDPageXYZDestinationCOSObjectToListThirdKeyIsNull() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setLeft(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageXYZDestination.getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#setLeft(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList second {@link
   *       COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  @DisplayName(
      "Test setLeft(int); when minus one; then PDPageXYZDestination() COSObject toList second COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setLeft(int)"})
  void testSetLeft_whenMinusOne_thenPDPageXYZDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setLeft(-1);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertEquals(-1, pdPageXYZDestination.getLeft());
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#getTop()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  @DisplayName(
      "Test getTop(); given COSArray(List) with cosObjectables is ArrayList() add FALSE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getTop()"})
  void testGetTop_givenCOSArrayWithCosObjectablesIsArrayListAddFalse_thenReturnOne() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    arr.add(COSFloat.ONE);

    // Act and Assert
    assertEquals(1, new PDPageXYZDestination(arr).getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#getTop()}.
   *
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()} Top is three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageXYZDestination() Top is three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getTop()"})
  void testGetTop_givenPDPageXYZDestinationTopIsThree_thenReturnThree() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();
    pdPageXYZDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageXYZDestination.getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#getTop()}.
   *
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  @DisplayName(
      "Test getTop(); given PDPageXYZDestination(COSArray) with arr is COSArray(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getTop()"})
  void testGetTop_givenPDPageXYZDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageXYZDestination(new COSArray()).getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#getTop()}.
   *
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageXYZDestination(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageXYZDestination.getTop()"})
  void testGetTop_givenPDPageXYZDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageXYZDestination().getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#setTop(int)}.
   *
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()} COSObject toList size is five.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  @DisplayName(
      "Test setTop(int); then PDPageXYZDestination(COSArray) with arr is COSArray() COSObject toList size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setTop(int)"})
  void testSetTop_thenPDPageXYZDestinationWithArrIsCOSArrayCOSObjectToListSizeIsFive() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(new COSArray());

    // Act
    pdPageXYZDestination.setTop(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(4));
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#setTop(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList fourth Key is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  @DisplayName(
      "Test setTop(int); when MIN_VALUE; then PDPageXYZDestination() COSObject toList fourth Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setTop(int)"})
  void testSetTop_whenMin_value_thenPDPageXYZDestinationCOSObjectToListFourthKeyIsNull() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setTop(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageXYZDestination.getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#setTop(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList second {@link
   *       COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  @DisplayName(
      "Test setTop(int); when minus one; then PDPageXYZDestination() COSObject toList second COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setTop(int)"})
  void testSetTop_whenMinusOne_thenPDPageXYZDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setTop(-1);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertEquals(-1, pdPageXYZDestination.getTop());
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#getZoom()}.
   *
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#getZoom()}
   */
  @Test
  @DisplayName("Test getZoom(); given PDPageXYZDestination(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDPageXYZDestination.getZoom()"})
  void testGetZoom_givenPDPageXYZDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, new PDPageXYZDestination().getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#setZoom(float)}.
   *
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList fifth {@link
   *       COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  @DisplayName("Test setZoom(float); then PDPageXYZDestination() COSObject toList fifth COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setZoom(float)"})
  void testSetZoom_thenPDPageXYZDestinationCOSObjectToListFifthCOSFloat() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setZoom(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdPageXYZDestination.getZoom());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDPageXYZDestination#setZoom(float)}.
   *
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()} COSObject toList size is five.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  @DisplayName(
      "Test setZoom(float); then PDPageXYZDestination(COSArray) with arr is COSArray() COSObject toList size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setZoom(float)"})
  void testSetZoom_thenPDPageXYZDestinationWithArrIsCOSArrayCOSObjectToListSizeIsFive() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(new COSArray());

    // Act
    pdPageXYZDestination.setZoom(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
  }

  /**
   * Test {@link PDPageXYZDestination#setZoom(float)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList second {@link
   *       COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  @DisplayName(
      "Test setZoom(float); when minus one; then PDPageXYZDestination() COSObject toList second COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageXYZDestination.setZoom(float)"})
  void testSetZoom_whenMinusOne_thenPDPageXYZDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setZoom(-1.0f);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
  }
}
