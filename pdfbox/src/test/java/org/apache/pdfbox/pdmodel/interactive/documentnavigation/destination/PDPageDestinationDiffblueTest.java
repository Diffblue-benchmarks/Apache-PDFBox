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
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageDestinationDiffblueTest {
  /**
   * Test {@link PDPageDestination#getPage()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#getPage()}
   */
  @Test
  @DisplayName(
      "Test getPage(); given COSArray(List) with cosObjectables is ArrayList(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDPageDestination.getPage()"})
  void testGetPage_givenCOSArrayWithCosObjectablesIsArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPageFitDestination(new COSArray(new ArrayList<>())).getPage());
  }

  /**
   * Test {@link PDPageDestination#getPage()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} Page is {@link
   *       PDPage#PDPage()}.
   *   <li>Then return {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#getPage()}
   */
  @Test
  @DisplayName(
      "Test getPage(); given PDPageFitDestination() Page is PDPage(); then return PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDPageDestination.getPage()"})
  void testGetPage_givenPDPageFitDestinationPageIsPDPage_thenReturnPDPage() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    PDPage page = new PDPage();
    pdPageFitDestination.setPage(page);

    // Act and Assert
    assertEquals(page, pdPageFitDestination.getPage());
  }

  /**
   * Test {@link PDPageDestination#getPage()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDPageFitDestination(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDPageDestination.getPage()"})
  void testGetPage_givenPDPageFitDestination_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPageFitDestination().getPage());
  }

  /**
   * Test {@link PDPageDestination#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} Page is {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); given PDPageFitDestination(); then PDPageFitDestination() Page is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageDestination.setPage(PDPage)"})
  void testSetPage_givenPDPageFitDestination_thenPDPageFitDestinationPageIsPDPage() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    PDPage page = new PDPage();

    // Act
    pdPageFitDestination.setPage(page);

    // Assert
    assertEquals(page, pdPageFitDestination.getPage());
  }

  /**
   * Test {@link PDPageDestination#setPage(PDPage)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} Page is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); when 'null'; then PDPageFitDestination() Page is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageDestination.setPage(PDPage)"})
  void testSetPage_whenNull_thenPDPageFitDestinationPageIsNull() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setPage(null);

    // Assert that nothing has changed
    assertNull(pdPageFitDestination.getPage());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName(
      "Test getPageNumber(); given COSArray(List) with cosObjectables is ArrayList(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageDestination.getPageNumber()"})
  void testGetPageNumber_givenCOSArrayWithCosObjectablesIsArrayList_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitDestination(new COSArray(new ArrayList<>())).getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName(
      "Test getPageNumber(); given PDPageFitDestination() PageNumber is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageDestination.getPageNumber()"})
  void testGetPageNumber_givenPDPageFitDestinationPageNumberIsTen_thenReturnTen() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setPageNumber(10);

    // Act and Assert
    assertEquals(10, pdPageFitDestination.getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given PDPageFitDestination(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageDestination.getPageNumber()"})
  void testGetPageNumber_givenPDPageFitDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitDestination().getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} Page is {@link
   *       PDPage#PDPage()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName(
      "Test retrievePageNumber(); given PDPageFitDestination() Page is PDPage(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageDestination.retrievePageNumber()"})
  void testRetrievePageNumber_givenPDPageFitDestinationPageIsPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setPage(new PDPage());

    // Act and Assert
    assertEquals(-1, pdPageFitDestination.retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName(
      "Test retrievePageNumber(); given PDPageFitDestination() PageNumber is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageDestination.retrievePageNumber()"})
  void testRetrievePageNumber_givenPDPageFitDestinationPageNumberIsTen_thenReturnTen() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setPageNumber(10);

    // Act and Assert
    assertEquals(10, pdPageFitDestination.retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with arr is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName(
      "Test retrievePageNumber(); given PDPageFitDestination(COSArray) with arr is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageDestination.retrievePageNumber()"})
  void testRetrievePageNumber_givenPDPageFitDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitDestination(new COSArray()).retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber(); given PDPageFitDestination(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageDestination.retrievePageNumber()"})
  void testRetrievePageNumber_givenPDPageFitDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDPageFitDestination().retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#setPageNumber(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageDestination#setPageNumber(int)}
   */
  @Test
  @DisplayName(
      "Test setPageNumber(int); when MIN_VALUE; then PDPageFitDestination() PageNumber is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageDestination.setPageNumber(int)"})
  void testSetPageNumber_whenMin_value_thenPDPageFitDestinationPageNumberIsMin_value() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setPageNumber(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitDestination.getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#getCOSObject()}.
   *
   * <p>Method under test: {@link PDPageDestination#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDPageDestination.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    COSArray actualCOSObject = pdPageFitDestination.getCOSObject();

    // Assert
    assertSame(pdPageFitDestination.array, actualCOSObject);
  }
}
