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
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageFitDestinationDiffblueTest {
  /**
   * Test {@link PDPageFitDestination#PDPageFitDestination(COSArray)}.
   *
   * <p>Method under test: {@link PDPageFitDestination#PDPageFitDestination(COSArray)}
   */
  @Test
  @DisplayName("Test new PDPageFitDestination(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitDestination.<init>(COSArray)"})
  void testNewPDPageFitDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = new PDPageFitDestination(arr).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Test {@link PDPageFitDestination#PDPageFitDestination()}.
   *
   * <p>Method under test: {@link PDPageFitDestination#PDPageFitDestination()}
   */
  @Test
  @DisplayName("Test new PDPageFitDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitDestination.<init>()"})
  void testNewPDPageFitDestination2() {
    // Arrange and Act
    PDPageFitDestination actualPdPageFitDestination = new PDPageFitDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("Fit", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitDestination.getPage());
    assertEquals(-1, actualPdPageFitDestination.getPageNumber());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test fitBoundingBox(); given COSArray(List) with cosObjectables is ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenCOSArrayWithCosObjectablesIsArrayListAddFalse() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(new PDPageFitDestination(arr).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test fitBoundingBox(); given COSArray(List) with cosObjectables is ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenCOSArrayWithCosObjectablesIsArrayListAddFalse2() {
    // Arrange
    COSArray arr = new COSArray(new ArrayList<>());
    arr.add(COSBoolean.FALSE);
    arr.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(new PDPageFitDestination(arr).fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} FitBoundingBox is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test fitBoundingBox(); given PDPageFitDestination() FitBoundingBox is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenPDPageFitDestinationFitBoundingBoxIsTrue_thenReturnTrue() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setFitBoundingBox(true);

    // Act and Assert
    assertTrue(pdPageFitDestination.fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitDestination#fitBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitDestination#fitBoundingBox()}
   */
  @Test
  @DisplayName("Test fitBoundingBox(); given PDPageFitDestination(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPageFitDestination.fitBoundingBox()"})
  void testFitBoundingBox_givenPDPageFitDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDPageFitDestination().fitBoundingBox());
  }

  /**
   * Test {@link PDPageFitDestination#setFitBoundingBox(boolean)}.
   *
   * <p>Method under test: {@link PDPageFitDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName("Test setFitBoundingBox(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(new COSArray());

    // Act
    pdPageFitDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertNull(toListResult.get(0));
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitDestination#setFitBoundingBox(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} COSObject toList second Name is
   *       {@code Fit}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName(
      "Test setFitBoundingBox(boolean); then PDPageFitDestination() COSObject toList second Name is 'Fit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox_thenPDPageFitDestinationCOSObjectToListSecondNameIsFit() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setFitBoundingBox(false);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("Fit", ((COSName) getResult).getName());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDPageFitDestination#setFitBoundingBox(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} COSObject toList second Name is
   *       {@code FitB}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageFitDestination#setFitBoundingBox(boolean)}
   */
  @Test
  @DisplayName(
      "Test setFitBoundingBox(boolean); then PDPageFitDestination() COSObject toList second Name is 'FitB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageFitDestination.setFitBoundingBox(boolean)"})
  void testSetFitBoundingBox_thenPDPageFitDestinationCOSObjectToListSecondNameIsFitB() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitB", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
