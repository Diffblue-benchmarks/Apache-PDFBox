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

class PDPageFitHeightDestinationDiffblueTest {
  /**
   * Test {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)}.
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageFitHeightDestination(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitHeightDestination.<init>(COSArray)"})
  void testNewPDPageFitHeightDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = new PDPageFitHeightDestination(arr).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}
   */
  @Test
  @DisplayName("Test new PDPageFitHeightDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  @DisplayName(
      "Test getLeft(); given COSArray(List) with cosObjectables is ArrayList() add FALSE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageFitHeightDestination.getLeft()"})
  void testGetLeft_givenCOSArrayWithCosObjectablesIsArrayListAddFalse_thenReturnOne() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);
    arr.add(COSFloat.ONE);

    // Act and Assert
    assertEquals(1, new PDPageFitHeightDestination(arr).getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#getLeft()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination()} Left is two.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitHeightDestination() Left is two; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)} with arr is
   *       {@link COSArray#COSArray()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  @DisplayName(
      "Test getLeft(); given PDPageFitHeightDestination(COSArray) with arr is COSArray(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageFitHeightDestination.getLeft()"})
  void testGetLeft_givenPDPageFitHeightDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitHeightDestination(new COSArray()).getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#getLeft()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  @DisplayName("Test getLeft(); given PDPageFitHeightDestination(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageFitHeightDestination.getLeft()"})
  void testGetLeft_givenPDPageFitHeightDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitHeightDestination().getLeft());
  }

  /**
   * Test {@link PDPageFitHeightDestination#setLeft(int)}.
   *
   * <ul>
   *   <li>Then {@link PDPageFitHeightDestination#PDPageFitHeightDestination()} COSObject toList
   *       second {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  @DisplayName(
      "Test setLeft(int); then PDPageFitHeightDestination() COSObject toList second COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link PDPageFitHeightDestination#PDPageFitHeightDestination()} COSObject toList
   *       third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  @DisplayName(
      "Test setLeft(int); then PDPageFitHeightDestination() COSObject toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitHeightDestination.setLeft(int)"})
  void testSetLeft_thenPDPageFitHeightDestinationCOSObjectToListThirdKeyIsNull() {
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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test fitBoundingBox(); given COSArray(List) with cosObjectables is ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitHeightDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenCOSArrayWithCosObjectablesIsArrayListAddFalse() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(new PDPageFitHeightDestination(arr).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitHeightDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test fitBoundingBox(); given COSArray(List) with cosObjectables is ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitHeightDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenCOSArrayWithCosObjectablesIsArrayListAddFalse2() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(new PDPageFitHeightDestination(arr).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitHeightDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitHeightDestination(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitHeightDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenPDPageFitHeightDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDPageFitHeightDestination().fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitHeightDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitHeightDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox2() {
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

  /**
   * Test {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}.
   *
   * <p>Method under test: {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitHeightDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox3() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination =
        new PDPageFitHeightDestination(new COSArray());

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
}
