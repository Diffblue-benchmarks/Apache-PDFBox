package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionGoToDiffblueTest {
  /**
   * Test {@link PDActionGoTo#PDActionGoTo(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionGoTo#PDActionGoTo(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionGoTo(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionGoTo.<init>(COSDictionary)"})
  void testNewPDActionGoTo() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionGoTo(a).getCOSObject());
  }

  /**
   * Test {@link PDActionGoTo#PDActionGoTo()}.
   *
   * <p>Method under test: {@link PDActionGoTo#PDActionGoTo()}
   */
  @Test
  @DisplayName("Test new PDActionGoTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionGoTo.<init>()"})
  void testNewPDActionGoTo2() throws IOException {
    // Arrange and Act
    PDActionGoTo actualPdActionGoTo = new PDActionGoTo();

    // Assert
    assertNull(actualPdActionGoTo.getNext());
    COSDictionary cOSObject = actualPdActionGoTo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionGoTo.getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionGoTo.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualPdActionGoTo.getSubType());
  }

  /**
   * Test {@link PDActionGoTo#getDestination()}.
   *
   * <ul>
   *   <li>Given {@link PDActionGoTo#PDActionGoTo()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionGoTo#getDestination()}
   */
  @Test
  @DisplayName("Test getDestination(); given PDActionGoTo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDestination PDActionGoTo.getDestination()"})
  void testGetDestination_givenPDActionGoTo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDActionGoTo().getDestination());
  }

  /**
   * Test {@link PDActionGoTo#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then {@link PDActionGoTo#PDActionGoTo()} Destination {@link PDPageFitDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); given PDPage(); then PDActionGoTo() Destination PDPageFitDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionGoTo.setDestination(PDDestination)"})
  void testSetDestination_givenPDPage_thenPDActionGoToDestinationPDPageFitDestination()
      throws IOException {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    PDPageFitDestination d = new PDPageFitDestination();
    PDPage page = new PDPage();
    d.setPage(page);

    // Act
    pdActionGoTo.setDestination(d);

    // Assert
    PDDestination destination = pdActionGoTo.getDestination();
    assertTrue(destination instanceof PDPageFitDestination);
    assertEquals(-1, ((PDPageFitDestination) destination).getPageNumber());
    assertEquals(page, ((PDPageFitDestination) destination).getPage());
  }

  /**
   * Test {@link PDActionGoTo#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>Then {@link PDActionGoTo#PDActionGoTo()} Destination {@link PDNamedDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); then PDActionGoTo() Destination PDNamedDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionGoTo.setDestination(PDDestination)"})
  void testSetDestination_thenPDActionGoToDestinationPDNamedDestination() throws IOException {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act
    pdActionGoTo.setDestination(new PDNamedDestination("Dest"));

    // Assert
    PDDestination destination = pdActionGoTo.getDestination();
    assertTrue(destination instanceof PDNamedDestination);
    assertEquals("Dest", ((PDNamedDestination) destination).getNamedDestination());
    COSDictionary cOSObject = pdActionGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionGoTo#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); when COSArray(List) with cosObjectables is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionGoTo.setDestination(PDDestination)"})
  void testSetDestination_whenCOSArrayWithCosObjectablesIsArrayList() {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act
    pdActionGoTo.setDestination(new PDPageFitDestination(new COSArray(new ArrayList<>())));

    // Assert
    COSDictionary cOSObject = pdActionGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionGoTo#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionGoTo#PDActionGoTo()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); when 'null'; then PDActionGoTo() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionGoTo.setDestination(PDDestination)"})
  void testSetDestination_whenNull_thenPDActionGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act
    pdActionGoTo.setDestination(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionGoTo#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>When {@link PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); when PDPageFitDestination(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionGoTo.setDestination(PDDestination)"})
  void testSetDestination_whenPDPageFitDestination_thenThrowIllegalArgumentException() {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdActionGoTo.setDestination(new PDPageFitDestination()));
  }
}
