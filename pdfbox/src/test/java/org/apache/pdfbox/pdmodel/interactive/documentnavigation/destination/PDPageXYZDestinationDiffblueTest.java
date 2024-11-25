package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPageXYZDestinationDiffblueTest {
  /**
   * Test {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)}.
   * <p>
   * Method under test:
   * {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageXYZDestination(COSArray)")
  void testNewPDPageXYZDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageXYZDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageXYZDestination#PDPageXYZDestination()}.
   * <p>
   * Method under test: {@link PDPageXYZDestination#PDPageXYZDestination()}
   */
  @Test
  @DisplayName("Test new PDPageXYZDestination()")
  void testNewPDPageXYZDestination2() {
    // Arrange and Act
    PDPageXYZDestination actualPdPageXYZDestination = new PDPageXYZDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("XYZ", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(getResult.getKey());
    assertNull(actualPdPageXYZDestination.getPage());
    assertEquals(-1, actualPdPageXYZDestination.getPageNumber());
    assertEquals(-1, actualPdPageXYZDestination.getLeft());
    assertEquals(-1, actualPdPageXYZDestination.getTop());
    assertEquals(-1.0f, actualPdPageXYZDestination.getZoom());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageXYZDestination#getLeft()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()} Left is
   * two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageXYZDestination() Left is two; then return two")
  void testGetLeft_givenPDPageXYZDestinationLeftIsTwo_thenReturnTwo() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();
    pdPageXYZDestination.setLeft(2);

    // Act and Assert
    assertEquals(2, pdPageXYZDestination.getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#getLeft()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageXYZDestination(COSArray) with arr is COSArray(); then return minus one")
  void testGetLeft_givenPDPageXYZDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageXYZDestination(new COSArray())).getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#getLeft()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageXYZDestination(); then return minus one")
  void testGetLeft_givenPDPageXYZDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageXYZDestination()).getLeft());
  }

  /**
   * Test {@link PDPageXYZDestination#setLeft(int)}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.</li>
   *   <li>When two.</li>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} Left is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); given PDPageXYZDestination(); when two; then PDPageXYZDestination() Left is two")
  void testSetLeft_givenPDPageXYZDestination_whenTwo_thenPDPageXYZDestinationLeftIsTwo() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setLeft(2);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(2, pdPageXYZDestination.getLeft());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageXYZDestination#setLeft(int)}.
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr
   * is {@link COSArray#COSArray()} COSObject toList size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); then PDPageXYZDestination(COSArray) with arr is COSArray() COSObject toList size is five")
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
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} Left is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); when MIN_VALUE; then PDPageXYZDestination() Left is MIN_VALUE")
  void testSetLeft_whenMin_value_thenPDPageXYZDestinationLeftIsMin_value() {
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
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList
   * second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); when minus one; then PDPageXYZDestination() COSObject toList second COSName")
  void testSetLeft_whenMinusOne_thenPDPageXYZDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setLeft(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertEquals(-1, pdPageXYZDestination.getLeft());
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#getTop()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()} Top is
   * three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageXYZDestination() Top is three; then return three")
  void testGetTop_givenPDPageXYZDestinationTopIsThree_thenReturnThree() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();
    pdPageXYZDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageXYZDestination.getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#getTop()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageXYZDestination(COSArray) with arr is COSArray(); then return minus one")
  void testGetTop_givenPDPageXYZDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageXYZDestination(new COSArray())).getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#getTop()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageXYZDestination(); then return minus one")
  void testGetTop_givenPDPageXYZDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageXYZDestination()).getTop());
  }

  /**
   * Test {@link PDPageXYZDestination#setTop(int)}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.</li>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} Top is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); given PDPageXYZDestination(); then PDPageXYZDestination() Top is three")
  void testSetTop_givenPDPageXYZDestination_thenPDPageXYZDestinationTopIsThree() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setTop(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(3, pdPageXYZDestination.getTop());
    assertTrue(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageXYZDestination#setTop(int)}.
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr
   * is {@link COSArray#COSArray()} COSObject toList size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then PDPageXYZDestination(COSArray) with arr is COSArray() COSObject toList size is five")
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
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then not {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject
   * toList fourth Direct.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); when MIN_VALUE; then not PDPageXYZDestination() COSObject toList fourth Direct")
  void testSetTop_whenMin_value_thenNotPDPageXYZDestinationCOSObjectToListFourthDirect() {
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
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList
   * second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); when minus one; then PDPageXYZDestination() COSObject toList second COSName")
  void testSetTop_whenMinusOne_thenPDPageXYZDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setTop(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(4));
    assertEquals(-1, pdPageXYZDestination.getTop());
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#getZoom()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()} Zoom is ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getZoom()}
   */
  @Test
  @DisplayName("Test getZoom(); given PDPageXYZDestination(COSArray) with arr is COSArray() Zoom is ten; then return ten")
  void testGetZoom_givenPDPageXYZDestinationWithArrIsCOSArrayZoomIsTen_thenReturnTen() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(new COSArray());
    pdPageXYZDestination.setZoom(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#getZoom()}.
   * <ul>
   *   <li>Given {@link PDPageXYZDestination#PDPageXYZDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#getZoom()}
   */
  @Test
  @DisplayName("Test getZoom(); given PDPageXYZDestination(); then return minus one")
  void testGetZoom_givenPDPageXYZDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDPageXYZDestination()).getZoom());
  }

  /**
   * Test {@link PDPageXYZDestination#setZoom(float)}.
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList
   * fifth {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  @DisplayName("Test setZoom(float); then PDPageXYZDestination() COSObject toList fifth COSFloat")
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
   * <ul>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)} with arr
   * is {@link COSArray#COSArray()} COSObject toList size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  @DisplayName("Test setZoom(float); then PDPageXYZDestination(COSArray) with arr is COSArray() COSObject toList size is five")
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
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then {@link PDPageXYZDestination#PDPageXYZDestination()} COSObject toList
   * second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  @DisplayName("Test setZoom(float); when minus one; then PDPageXYZDestination() COSObject toList second COSName")
  void testSetZoom_whenMinusOne_thenPDPageXYZDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setZoom(-1.0f);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
  }
}
