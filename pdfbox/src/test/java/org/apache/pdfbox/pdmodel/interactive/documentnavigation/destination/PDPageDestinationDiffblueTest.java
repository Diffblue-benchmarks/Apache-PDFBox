package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPageDestinationDiffblueTest {
  /**
   * Test {@link PDPageDestination#getPage()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given COSObjectKey(long, int) with num is one and gen is one; then return 'null'")
  void testGetPage_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnNull() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertNull((new PDPageFitDestination(arr)).getPage());
  }

  /**
   * Test {@link PDPageDestination#getPage()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} Page is
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDPageFitDestination() Page is PDPage(); then return PDPage()")
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
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDPageFitDestination(COSArray) with arr is COSArray(); then return 'null'")
  void testGetPage_givenPDPageFitDestinationWithArrIsCOSArray_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPageFitDestination(new COSArray())).getPage());
  }

  /**
   * Test {@link PDPageDestination#getPage()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDPageFitDestination(); then return 'null'")
  void testGetPage_givenPDPageFitDestination_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPageFitDestination()).getPage());
  }

  /**
   * Test {@link PDPageDestination#setPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} Page is
   * {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given PDPageFitDestination(); then PDPageFitDestination() Page is PDPage()")
  void testSetPage_givenPDPageFitDestination_thenPDPageFitDestinationPageIsPDPage() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    PDPage page = new PDPage();

    // Act
    pdPageFitDestination.setPage(page);

    // Assert
    assertEquals(2, pdPageFitDestination.getCOSObject().toList().size());
    assertEquals(page, pdPageFitDestination.getPage());
  }

  /**
   * Test {@link PDPageDestination#setPage(PDPage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} COSObject toList
   * first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); when 'null'; then PDPageFitDestination() COSObject toList first is 'null'")
  void testSetPage_whenNull_thenPDPageFitDestinationCOSObjectToListFirstIsNull() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setPage(null);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(pdPageFitDestination.getPage());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given COSArray() add ONE; then return one")
  void testGetPageNumber_givenCOSArrayAddOne_thenReturnOne() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSFloat.ONE);

    // Act and Assert
    assertEquals(1, (new PDPageFitDestination(arr)).getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given COSObjectKey(long, int) with num is one and gen is one; then return minus one")
  void testGetPageNumber_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnMinusOne() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertEquals(-1, (new PDPageFitDestination(arr)).getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is
   * ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given PDPageFitDestination() PageNumber is ten; then return ten")
  void testGetPageNumber_givenPDPageFitDestinationPageNumberIsTen_thenReturnTen() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setPageNumber(10);

    // Act and Assert
    assertEquals(10, pdPageFitDestination.getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given PDPageFitDestination(COSArray) with arr is COSArray(); then return minus one")
  void testGetPageNumber_givenPDPageFitDestinationWithArrIsCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitDestination(new COSArray())).getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#getPageNumber()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#getPageNumber()}
   */
  @Test
  @DisplayName("Test getPageNumber(); given PDPageFitDestination(); then return minus one")
  void testGetPageNumber_givenPDPageFitDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitDestination()).getPageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   * <p>
   * Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber()")
  void testRetrievePageNumber() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setPage(new PDPage(new COSDictionary()));

    // Act and Assert
    assertEquals(-1, pdPageFitDestination.retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber(); given COSArray() add ONE; then return one")
  void testRetrievePageNumber_givenCOSArrayAddOne_thenReturnOne() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add(COSFloat.ONE);

    // Act and Assert
    assertEquals(1, (new PDPageFitDestination(arr)).retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber(); given COSObjectKey(long, int) with num is one and gen is one")
  void testRetrievePageNumber_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArray arr = new COSArray();
    arr.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertEquals(-1, (new PDPageFitDestination(arr)).retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} Page is
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber(); given PDPageFitDestination() Page is PDPage(); then return minus one")
  void testRetrievePageNumber_givenPDPageFitDestinationPageIsPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setPage(new PDPage());

    // Act and Assert
    assertEquals(-1, pdPageFitDestination.retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is
   * ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber(); given PDPageFitDestination() PageNumber is ten; then return ten")
  void testRetrievePageNumber_givenPDPageFitDestinationPageNumberIsTen_thenReturnTen() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setPageNumber(10);

    // Act and Assert
    assertEquals(10, pdPageFitDestination.retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with
   * arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber(); given PDPageFitDestination(COSArray) with arr is COSArray()")
  void testRetrievePageNumber_givenPDPageFitDestinationWithArrIsCOSArray() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitDestination(new COSArray())).retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#retrievePageNumber()}.
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#retrievePageNumber()}
   */
  @Test
  @DisplayName("Test retrievePageNumber(); given PDPageFitDestination(); then return minus one")
  void testRetrievePageNumber_givenPDPageFitDestination_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitDestination()).retrievePageNumber());
  }

  /**
   * Test {@link PDPageDestination#setPageNumber(int)}.
   * <ul>
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is
   * two hundred fifty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#setPageNumber(int)}
   */
  @Test
  @DisplayName("Test setPageNumber(int); then PDPageFitDestination() PageNumber is two hundred fifty-six")
  void testSetPageNumber_thenPDPageFitDestinationPageNumberIsTwoHundredFiftySix() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setPageNumber(256);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(256, pdPageFitDestination.getPageNumber());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDPageDestination#setPageNumber(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageDestination#setPageNumber(int)}
   */
  @Test
  @DisplayName("Test setPageNumber(int); when MIN_VALUE; then PDPageFitDestination() PageNumber is MIN_VALUE")
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
   * <p>
   * Method under test: {@link PDPageDestination#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act and Assert
    assertSame(pdPageFitDestination.array, pdPageFitDestination.getCOSObject());
  }
}
