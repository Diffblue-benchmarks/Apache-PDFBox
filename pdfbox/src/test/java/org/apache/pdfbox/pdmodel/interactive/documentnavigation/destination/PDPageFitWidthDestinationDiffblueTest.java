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

class PDPageFitWidthDestinationDiffblueTest {
  /**
   * Test {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)}.
   * <p>
   * Method under test:
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageFitWidthDestination(COSArray)")
  void testNewPDPageFitWidthDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageFitWidthDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.
   * <p>
   * Method under test:
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}
   */
  @Test
  @DisplayName("Test new PDPageFitWidthDestination()")
  void testNewPDPageFitWidthDestination2() {
    // Arrange and Act
    PDPageFitWidthDestination actualPdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitH", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitWidthDestination.getPage());
    assertEquals(-1, actualPdPageFitWidthDestination.getPageNumber());
    assertEquals(-1, actualPdPageFitWidthDestination.getTop());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitWidthDestination#getTop()}.
   * <ul>
   *   <li>Given {@link PDPageFitWidthDestination#PDPageFitWidthDestination()} Top
   * is three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitWidthDestination() Top is three; then return three")
  void testGetTop_givenPDPageFitWidthDestinationTopIsThree_thenReturnThree() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();
    pdPageFitWidthDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageFitWidthDestination.getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#getTop()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitWidthDestination(COSArray) with arr is COSArray(); then return minus one")
  void testGetTop_givenPDPageFitWidthDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitWidthDestination(new COSArray())).getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#getTop()}.
   * <ul>
   *   <li>Given {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitWidthDestination(); then return minus one")
  void testGetTop_givenPDPageFitWidthDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitWidthDestination()).getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setTop(int)}.
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int)")
  void testSetTop() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination(new COSArray());

    // Act
    pdPageFitWidthDestination.setTop(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertEquals(3, pdPageFitWidthDestination.getTop());
    assertTrue(getResult.isDirect());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setTop(int)}.
   * <ul>
   *   <li>Then not {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}
   * COSObject toList third Direct.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then not PDPageFitWidthDestination() COSObject toList third Direct")
  void testSetTop_thenNotPDPageFitWidthDestinationCOSObjectToListThirdDirect() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setTop(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitWidthDestination.getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setTop(int)}.
   * <ul>
   *   <li>Then {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}
   * COSObject toList second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then PDPageFitWidthDestination() COSObject toList second COSName")
  void testSetTop_thenPDPageFitWidthDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setTop(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertEquals(-1, pdPageFitWidthDestination.getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setTop(int)}.
   * <ul>
   *   <li>Then {@link PDPageFitWidthDestination#PDPageFitWidthDestination()} Top is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then PDPageFitWidthDestination() Top is three")
  void testSetTop_thenPDPageFitWidthDestinationTopIsThree() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setTop(3);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(3, pdPageFitWidthDestination.getTop());
    assertTrue(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitWidthDestination(COSArray) with arr is COSArray()")
  void testFitBoundingBox_givenPDPageFitWidthDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertFalse((new PDPageFitWidthDestination(new COSArray())).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Given
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()} Top is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitWidthDestination(COSArray) with arr is COSArray() Top is three")
  void testFitBoundingBox_givenPDPageFitWidthDestinationWithArrIsCOSArrayTopIsThree() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination(new COSArray());
    pdPageFitWidthDestination.setTop(3);

    // Act and Assert
    assertFalse(pdPageFitWidthDestination.fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitWidthDestination(); then return 'false'")
  void testFitBoundingBox_givenPDPageFitWidthDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDPageFitWidthDestination()).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); then return 'true'")
  void testFitBoundingBox_thenReturnTrue() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Act and Assert
    assertTrue(pdPageFitWidthDestination.fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  void testSetFitBoundingBox() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitBH", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  void testSetFitBoundingBox2() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination(new COSArray());

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  void testSetFitBoundingBox3() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(false);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitH", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
