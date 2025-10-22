package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageFitHeightDestinationDiffblueTest {
  /**
   * Test {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)}.
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageFitHeightDestination(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.<init>(COSArray)"})
  void testNewPDPageFitHeightDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageFitHeightDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}
   */
  @Test
  @DisplayName("Test new PDPageFitHeightDestination()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.<init>()"})
  void testNewPDPageFitHeightDestination2() {
    // Arrange and Act
    PDPageFitHeightDestination actualPdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitV", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitHeightDestination.getPage());
    assertEquals(-1, actualPdPageFitHeightDestination.getPageNumber());
    assertEquals(-1, actualPdPageFitHeightDestination.getLeft());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitHeightDestination#getLeft()}.
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination()} Left is two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitHeightDestination() Left is two; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPageFitHeightDestination.getLeft()"})
  void testGetLeft_givenPDPageFitHeightDestinationLeftIsTwo_thenReturnTwo() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();
    pdPageFitHeightDestination.setLeft(2);

    // Act and Assert
    assertEquals(2, pdPageFitHeightDestination.getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#getLeft()}.
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)} with arr is {@link COSArray#COSArray()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitHeightDestination(COSArray) with arr is COSArray(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPageFitHeightDestination.getLeft()"})
  void testGetLeft_givenPDPageFitHeightDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitHeightDestination(new COSArray())).getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#getLeft()}.
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitHeightDestination(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPageFitHeightDestination.getLeft()"})
  void testGetLeft_givenPDPageFitHeightDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitHeightDestination()).getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#setLeft(int)}.
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.setLeft(int)"})
  void testSetLeft() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination(new COSArray());

    // Act
    pdPageFitHeightDestination.setLeft(2);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertEquals(2, pdPageFitHeightDestination.getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#setLeft(int)}.
   * <ul>
   *   <li>Then {@link PDPageFitHeightDestination#PDPageFitHeightDestination()} COSObject toList second {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); then PDPageFitHeightDestination() COSObject toList second COSName")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.setLeft(int)"})
  void testSetLeft_thenPDPageFitHeightDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setLeft(-1);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertEquals(-1, pdPageFitHeightDestination.getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#setLeft(int)}.
   * <ul>
   *   <li>Then {@link PDPageFitHeightDestination#PDPageFitHeightDestination()} Left is minus one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); then PDPageFitHeightDestination() Left is minus one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.setLeft(int)"})
  void testSetLeft_thenPDPageFitHeightDestinationLeftIsMinusOneHundred() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setLeft(-100);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(-100, pdPageFitHeightDestination.getLeft());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageFitHeightDestination#setLeft(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDPageFitHeightDestination#PDPageFitHeightDestination()} Left is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  @DisplayName("Test setLeft(int); when MIN_VALUE; then PDPageFitHeightDestination() Left is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.setLeft(int)"})
  void testSetLeft_whenMin_value_thenPDPageFitHeightDestinationLeftIsMin_value() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setLeft(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitHeightDestination.getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)} with arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitHeightDestination(COSArray) with arr is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPageFitHeightDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenPDPageFitHeightDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertFalse((new PDPageFitHeightDestination(new COSArray())).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitHeightDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)} with arr is {@link COSArray#COSArray()} Left is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitHeightDestination(COSArray) with arr is COSArray() Left is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPageFitHeightDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenPDPageFitHeightDestinationWithArrIsCOSArrayLeftIsTwo() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination(new COSArray());
    pdPageFitHeightDestination.setLeft(2);

    // Act and Assert
    assertFalse(pdPageFitHeightDestination.fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitHeightDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitHeightDestination(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPageFitHeightDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenPDPageFitHeightDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDPageFitHeightDestination()).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitHeightDestination#fitBoundingBox()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDPageFitHeightDestination.fitBoundingBox()"})
  void testFitBoundingBox_thenReturnTrue() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();
    pdPageFitHeightDestination.setFitBoundingBox(true);

    // Act and Assert
    assertTrue(pdPageFitHeightDestination.fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}.
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitBV", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}.
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox2() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination(new COSArray());

    // Act
    pdPageFitHeightDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
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
   * Test {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}.
   * <p>
   * Method under test: {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageFitHeightDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox3() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setFitBoundingBox(false);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitV", ((COSName) getResult).getName());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
