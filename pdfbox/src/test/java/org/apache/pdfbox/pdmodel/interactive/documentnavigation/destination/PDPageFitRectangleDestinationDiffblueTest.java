package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPageFitRectangleDestinationDiffblueTest {
  /**
   * Test
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination(COSArray)}.
   * <p>
   * Method under test:
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageFitRectangleDestination(COSArray)")
  void testNewPDPageFitRectangleDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageFitRectangleDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}.
   * <p>
   * Method under test:
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   */
  @Test
  @DisplayName("Test new PDPageFitRectangleDestination()")
  void testNewPDPageFitRectangleDestination2() {
    // Arrange and Act
    PDPageFitRectangleDestination actualPdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitR", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(toListResult.get(5));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitRectangleDestination.getPage());
    assertEquals(-1, actualPdPageFitRectangleDestination.getPageNumber());
    assertEquals(-1, actualPdPageFitRectangleDestination.getBottom());
    assertEquals(-1, actualPdPageFitRectangleDestination.getLeft());
    assertEquals(-1, actualPdPageFitRectangleDestination.getRight());
    assertEquals(-1, actualPdPageFitRectangleDestination.getTop());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getLeft()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Left is
   * two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitRectangleDestination() Left is two; then return two")
  void testGetLeft_givenPDPageFitRectangleDestinationLeftIsTwo_thenReturnTwo() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setLeft(2);

    // Act and Assert
    assertEquals(2, pdPageFitRectangleDestination.getLeft());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getLeft()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination(COSArray)}
   * with arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitRectangleDestination(COSArray) with arr is COSArray()")
  void testGetLeft_givenPDPageFitRectangleDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getLeft());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getLeft()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitRectangleDestination(); then return minus one")
  void testGetLeft_givenPDPageFitRectangleDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getLeft());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setLeft(int)}.
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int)")
  void testSetLeft() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(new COSArray());

    // Act
    pdPageFitRectangleDestination.setLeft(2);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(toListResult.get(5));
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setLeft(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   * COSObject toList second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); then PDPageFitRectangleDestination() COSObject toList second COSName")
  void testSetLeft_thenPDPageFitRectangleDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setLeft(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(toListResult.get(5));
    assertEquals(-1, pdPageFitRectangleDestination.getLeft());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setLeft(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Left is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); then PDPageFitRectangleDestination() Left is two")
  void testSetLeft_thenPDPageFitRectangleDestinationLeftIsTwo() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setLeft(2);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(2, pdPageFitRectangleDestination.getLeft());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setLeft(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Left is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); when MIN_VALUE; then PDPageFitRectangleDestination() Left is MIN_VALUE")
  void testSetLeft_whenMin_value_thenPDPageFitRectangleDestinationLeftIsMin_value() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setLeft(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getLeft());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getBottom()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Bottom
   * is three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getBottom()}
   */
  @Test
  @DisplayName("Test getBottom(); given PDPageFitRectangleDestination() Bottom is three; then return three")
  void testGetBottom_givenPDPageFitRectangleDestinationBottomIsThree_thenReturnThree() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setBottom(3);

    // Act and Assert
    assertEquals(3, pdPageFitRectangleDestination.getBottom());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getBottom()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination(COSArray)}
   * with arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getBottom()}
   */
  @Test
  @DisplayName("Test getBottom(); given PDPageFitRectangleDestination(COSArray) with arr is COSArray()")
  void testGetBottom_givenPDPageFitRectangleDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getBottom());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getBottom()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getBottom()}
   */
  @Test
  @DisplayName("Test getBottom(); given PDPageFitRectangleDestination(); then return minus one")
  void testGetBottom_givenPDPageFitRectangleDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getBottom());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setBottom(int)}.
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  @DisplayName("Test setBottom(int)")
  void testSetBottom() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(new COSArray());

    // Act
    pdPageFitRectangleDestination.setBottom(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(4));
    assertNull(toListResult.get(5));
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setBottom(int)}.
   * <ul>
   *   <li>Then not
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   * COSObject toList fourth Direct.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  @DisplayName("Test setBottom(int); then not PDPageFitRectangleDestination() COSObject toList fourth Direct")
  void testSetBottom_thenNotPDPageFitRectangleDestinationCOSObjectToListFourthDirect() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setBottom(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getBottom());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setBottom(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Bottom
   * is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  @DisplayName("Test setBottom(int); then PDPageFitRectangleDestination() Bottom is three")
  void testSetBottom_thenPDPageFitRectangleDestinationBottomIsThree() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setBottom(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(3, pdPageFitRectangleDestination.getBottom());
    assertTrue(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setBottom(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   * COSObject toList second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  @DisplayName("Test setBottom(int); then PDPageFitRectangleDestination() COSObject toList second COSName")
  void testSetBottom_thenPDPageFitRectangleDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setBottom(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(4));
    assertNull(toListResult.get(5));
    assertEquals(-1, pdPageFitRectangleDestination.getBottom());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getRight()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Right
   * is two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getRight()}
   */
  @Test
  @DisplayName("Test getRight(); given PDPageFitRectangleDestination() Right is two; then return two")
  void testGetRight_givenPDPageFitRectangleDestinationRightIsTwo_thenReturnTwo() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setRight(2);

    // Act and Assert
    assertEquals(2, pdPageFitRectangleDestination.getRight());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getRight()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination(COSArray)}
   * with arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getRight()}
   */
  @Test
  @DisplayName("Test getRight(); given PDPageFitRectangleDestination(COSArray) with arr is COSArray()")
  void testGetRight_givenPDPageFitRectangleDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getRight());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getRight()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getRight()}
   */
  @Test
  @DisplayName("Test getRight(); given PDPageFitRectangleDestination(); then return minus one")
  void testGetRight_givenPDPageFitRectangleDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getRight());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setRight(int)}.
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  @DisplayName("Test setRight(int)")
  void testSetRight() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(new COSArray());

    // Act
    pdPageFitRectangleDestination.setRight(2);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(5));
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setRight(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   * COSObject toList second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  @DisplayName("Test setRight(int); then PDPageFitRectangleDestination() COSObject toList second COSName")
  void testSetRight_thenPDPageFitRectangleDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setRight(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(5));
    assertEquals(-1, pdPageFitRectangleDestination.getRight());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setRight(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Right
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  @DisplayName("Test setRight(int); then PDPageFitRectangleDestination() Right is two")
  void testSetRight_thenPDPageFitRectangleDestinationRightIsTwo() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setRight(2);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(2, pdPageFitRectangleDestination.getRight());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setRight(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Right
   * is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  @DisplayName("Test setRight(int); when MIN_VALUE; then PDPageFitRectangleDestination() Right is MIN_VALUE")
  void testSetRight_whenMin_value_thenPDPageFitRectangleDestinationRightIsMin_value() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setRight(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getRight());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getTop()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Top is
   * three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitRectangleDestination() Top is three; then return three")
  void testGetTop_givenPDPageFitRectangleDestinationTopIsThree_thenReturnThree() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageFitRectangleDestination.getTop());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getTop()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination(COSArray)}
   * with arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitRectangleDestination(COSArray) with arr is COSArray()")
  void testGetTop_givenPDPageFitRectangleDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getTop());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#getTop()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitRectangleDestination(); then return minus one")
  void testGetTop_givenPDPageFitRectangleDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getTop());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setTop(int)}.
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int)")
  void testSetTop() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(new COSArray());

    // Act
    pdPageFitRectangleDestination.setTop(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setTop(int)}.
   * <ul>
   *   <li>Then not
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   * COSObject toList sixth Direct.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then not PDPageFitRectangleDestination() COSObject toList sixth Direct")
  void testSetTop_thenNotPDPageFitRectangleDestinationCOSObjectToListSixthDirect() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setTop(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(5);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getTop());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setTop(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   * COSObject toList second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then PDPageFitRectangleDestination() COSObject toList second COSName")
  void testSetTop_thenPDPageFitRectangleDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setTop(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertEquals(-1, pdPageFitRectangleDestination.getTop());
  }

  /**
   * Test {@link PDPageFitRectangleDestination#setTop(int)}.
   * <ul>
   *   <li>Then
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()} Top is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then PDPageFitRectangleDestination() Top is three")
  void testSetTop_thenPDPageFitRectangleDestinationTopIsThree() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setTop(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(5);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(3, pdPageFitRectangleDestination.getTop());
    assertTrue(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }
}
