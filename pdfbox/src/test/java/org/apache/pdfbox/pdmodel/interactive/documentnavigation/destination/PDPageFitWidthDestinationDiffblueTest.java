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

class PDPageFitWidthDestinationDiffblueTest {
  /**
   * Test {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)}.
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageFitWidthDestination(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitWidthDestination.<init>(COSArray)"})
  void testNewPDPageFitWidthDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = new PDPageFitWidthDestination(arr).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}
   */
  @Test
  @DisplayName("Test new PDPageFitWidthDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitWidthDestination.<init>()"})
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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  @DisplayName(
      "Test getTop(); given COSArray(List) with cosObjectables is ArrayList() add FALSE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageFitWidthDestination.getTop()"})
  void testGetTop_givenCOSArrayWithCosObjectablesIsArrayListAddFalse_thenReturnOne() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    arr.add(COSFloat.ONE);

    // Act and Assert
    assertEquals(1, new PDPageFitWidthDestination(arr).getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#getTop()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitWidthDestination#PDPageFitWidthDestination()} Top is three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitWidthDestination() Top is three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageFitWidthDestination.getTop()"})
  void testGetTop_givenPDPageFitWidthDestinationTopIsThree_thenReturnThree() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();
    pdPageFitWidthDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageFitWidthDestination.getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#getTop()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)} with arr is
   *       {@link COSArray#COSArray()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  @DisplayName(
      "Test getTop(); given PDPageFitWidthDestination(COSArray) with arr is COSArray(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageFitWidthDestination.getTop()"})
  void testGetTop_givenPDPageFitWidthDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitWidthDestination(new COSArray()).getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#getTop()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  @DisplayName("Test getTop(); given PDPageFitWidthDestination(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageFitWidthDestination.getTop()"})
  void testGetTop_givenPDPageFitWidthDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitWidthDestination().getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setTop(int)}.
   *
   * <ul>
   *   <li>Then {@link PDPageFitWidthDestination#PDPageFitWidthDestination()} COSObject toList
   *       second {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  @DisplayName("Test setTop(int); then PDPageFitWidthDestination() COSObject toList second COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitWidthDestination.setTop(int)"})
  void testSetTop_thenPDPageFitWidthDestinationCOSObjectToListSecondCOSName() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setTop(-1);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSName);
    assertEquals(-1, pdPageFitWidthDestination.getTop());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setTop(int)}.
   *
   * <ul>
   *   <li>Then {@link PDPageFitWidthDestination#PDPageFitWidthDestination()} COSObject toList third
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  @DisplayName(
      "Test setTop(int); then PDPageFitWidthDestination() COSObject toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitWidthDestination.setTop(int)"})
  void testSetTop_thenPDPageFitWidthDestinationCOSObjectToListThirdKeyIsNull() {
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
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test fitBoundingBox(); given COSArray(List) with cosObjectables is ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitWidthDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenCOSArrayWithCosObjectablesIsArrayListAddFalse() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(new PDPageFitWidthDestination(arr).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test fitBoundingBox(); given COSArray(List) with cosObjectables is ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitWidthDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenCOSArrayWithCosObjectablesIsArrayListAddFalse2() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(new PDPageFitWidthDestination(arr).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitWidthDestination(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitWidthDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenPDPageFitWidthDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDPageFitWidthDestination().fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitWidthDestination.fitBoundingBox()"})
  void testFitBoundingBox_thenReturnTrue() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Act and Assert
    assertTrue(pdPageFitWidthDestination.fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}.
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitWidthDestination.setFitBoundingBox(boolean)"})
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
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitWidthDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox2() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(false);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitH", ((COSName) getResult).getName());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}.
   *
   * <p>Method under test: {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitWidthDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox3() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination =
        new PDPageFitWidthDestination(new COSArray());

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
}
