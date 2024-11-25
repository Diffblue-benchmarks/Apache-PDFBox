package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPageLabelRangeDiffblueTest {
  /**
   * Test {@link PDPageLabelRange#PDPageLabelRange(COSDictionary)}.
   * <p>
   * Method under test: {@link PDPageLabelRange#PDPageLabelRange(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPageLabelRange(COSDictionary)")
  void testNewPDPageLabelRange() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDPageLabelRange(dict)).getCOSObject());
  }

  /**
   * Test {@link PDPageLabelRange#PDPageLabelRange()}.
   * <p>
   * Method under test: {@link PDPageLabelRange#PDPageLabelRange()}
   */
  @Test
  @DisplayName("Test new PDPageLabelRange()")
  void testNewPDPageLabelRange2() {
    // Arrange and Act
    PDPageLabelRange actualPdPageLabelRange = new PDPageLabelRange();

    // Assert
    assertNull(actualPdPageLabelRange.getPrefix());
    assertNull(actualPdPageLabelRange.getStyle());
    COSDictionary cOSObject = actualPdPageLabelRange.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertEquals(1, actualPdPageLabelRange.getStart());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPageLabelRange#getCOSObject()}.
   * <p>
   * Method under test: {@link PDPageLabelRange#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDPageLabelRange()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPageLabelRange#getStyle()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()} Style is
   * {@code Style}.</li>
   *   <li>Then return {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDPageLabelRange() Style is 'Style'; then return 'Style'")
  void testGetStyle_givenPDPageLabelRangeStyleIsStyle_thenReturnStyle() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setStyle("Style");

    // Act and Assert
    assertEquals("Style", pdPageLabelRange.getStyle());
  }

  /**
   * Test {@link PDPageLabelRange#getStyle()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDPageLabelRange(); then return 'null'")
  void testGetStyle_givenPDPageLabelRange_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPageLabelRange()).getStyle());
  }

  /**
   * Test {@link PDPageLabelRange#setStyle(String)}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPageLabelRange#PDPageLabelRange()} Style is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#setStyle(String)}
   */
  @Test
  @DisplayName("Test setStyle(String); given PDPageLabelRange(); when 'null'; then PDPageLabelRange() Style is 'null'")
  void testSetStyle_givenPDPageLabelRange_whenNull_thenPDPageLabelRangeStyleIsNull() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setStyle(null);

    // Assert
    assertNull(pdPageLabelRange.getStyle());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPageLabelRange#setStyle(String)}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>When {@code Style}.</li>
   *   <li>Then {@link PDPageLabelRange#PDPageLabelRange()} Style is
   * {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#setStyle(String)}
   */
  @Test
  @DisplayName("Test setStyle(String); given PDPageLabelRange(); when 'Style'; then PDPageLabelRange() Style is 'Style'")
  void testSetStyle_givenPDPageLabelRange_whenStyle_thenPDPageLabelRangeStyleIsStyle() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setStyle("Style");

    // Assert
    assertEquals("Style", pdPageLabelRange.getStyle());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPageLabelRange#setStyle(String)}.
   * <ul>
   *   <li>When {@code Style42Style}.</li>
   *   <li>Then {@link PDPageLabelRange#PDPageLabelRange()} Style is
   * {@code Style42Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#setStyle(String)}
   */
  @Test
  @DisplayName("Test setStyle(String); when 'Style42Style'; then PDPageLabelRange() Style is 'Style42Style'")
  void testSetStyle_whenStyle42Style_thenPDPageLabelRangeStyleIsStyle42Style() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setStyle("Style42Style");

    // Assert
    assertEquals("Style42Style", pdPageLabelRange.getStyle());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPageLabelRange#getStart()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()} Start is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getStart()}
   */
  @Test
  @DisplayName("Test getStart(); given PDPageLabelRange() Start is one; then return one")
  void testGetStart_givenPDPageLabelRangeStartIsOne_thenReturnOne() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setStart(1);

    // Act and Assert
    assertEquals(1, pdPageLabelRange.getStart());
  }

  /**
   * Test {@link PDPageLabelRange#getStart()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()} Style is
   * {@code Style}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getStart()}
   */
  @Test
  @DisplayName("Test getStart(); given PDPageLabelRange() Style is 'Style'; then return one")
  void testGetStart_givenPDPageLabelRangeStyleIsStyle_thenReturnOne() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setStyle("Style");

    // Act and Assert
    assertEquals(1, pdPageLabelRange.getStart());
  }

  /**
   * Test {@link PDPageLabelRange#getStart()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getStart()}
   */
  @Test
  @DisplayName("Test getStart(); given PDPageLabelRange(); then return one")
  void testGetStart_givenPDPageLabelRange_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDPageLabelRange()).getStart());
  }

  /**
   * Test {@link PDPageLabelRange#setStart(int)}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>Then {@link PDPageLabelRange#PDPageLabelRange()} COSObject Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#setStart(int)}
   */
  @Test
  @DisplayName("Test setStart(int); given PDPageLabelRange(); then PDPageLabelRange() COSObject Values size is one")
  void testSetStart_givenPDPageLabelRange_thenPDPageLabelRangeCOSObjectValuesSizeIsOne() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setStart(1);

    // Assert
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPageLabelRange#setStart(int)}.
   * <ul>
   *   <li>When minus one hundred.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#setStart(int)}
   */
  @Test
  @DisplayName("Test setStart(int); when minus one hundred; then throw IllegalArgumentException")
  void testSetStart_whenMinusOneHundred_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDPageLabelRange()).setStart(-100));
  }

  /**
   * Test {@link PDPageLabelRange#getPrefix()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()} Prefix is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix(); given PDPageLabelRange() Prefix is empty string; then return empty string")
  void testGetPrefix_givenPDPageLabelRangePrefixIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setPrefix("");

    // Act and Assert
    assertEquals("", pdPageLabelRange.getPrefix());
  }

  /**
   * Test {@link PDPageLabelRange#getPrefix()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()} Prefix is
   * {@code Prefix}.</li>
   *   <li>Then return {@code Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix(); given PDPageLabelRange() Prefix is 'Prefix'; then return 'Prefix'")
  void testGetPrefix_givenPDPageLabelRangePrefixIsPrefix_thenReturnPrefix() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix", pdPageLabelRange.getPrefix());
  }

  /**
   * Test {@link PDPageLabelRange#getPrefix()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()} Style is
   * {@code Style}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix(); given PDPageLabelRange() Style is 'Style'; then return 'null'")
  void testGetPrefix_givenPDPageLabelRangeStyleIsStyle_thenReturnNull() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();
    pdPageLabelRange.setStyle("Style");

    // Act and Assert
    assertNull(pdPageLabelRange.getPrefix());
  }

  /**
   * Test {@link PDPageLabelRange#getPrefix()}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#getPrefix()}
   */
  @Test
  @DisplayName("Test getPrefix(); given PDPageLabelRange(); then return 'null'")
  void testGetPrefix_givenPDPageLabelRange_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDPageLabelRange()).getPrefix());
  }

  /**
   * Test {@link PDPageLabelRange#setPrefix(String)}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>Then {@link PDPageLabelRange#PDPageLabelRange()} Prefix is
   * {@code Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#setPrefix(String)}
   */
  @Test
  @DisplayName("Test setPrefix(String); given PDPageLabelRange(); then PDPageLabelRange() Prefix is 'Prefix'")
  void testSetPrefix_givenPDPageLabelRange_thenPDPageLabelRangePrefixIsPrefix() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setPrefix("Prefix");

    // Assert
    assertEquals("Prefix", pdPageLabelRange.getPrefix());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPageLabelRange#setPrefix(String)}.
   * <ul>
   *   <li>Given {@link PDPageLabelRange#PDPageLabelRange()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDPageLabelRange#PDPageLabelRange()} Prefix is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabelRange#setPrefix(String)}
   */
  @Test
  @DisplayName("Test setPrefix(String); given PDPageLabelRange(); when 'null'; then PDPageLabelRange() Prefix is 'null'")
  void testSetPrefix_givenPDPageLabelRange_whenNull_thenPDPageLabelRangePrefixIsNull() {
    // Arrange
    PDPageLabelRange pdPageLabelRange = new PDPageLabelRange();

    // Act
    pdPageLabelRange.setPrefix(null);

    // Assert
    assertNull(pdPageLabelRange.getPrefix());
    COSDictionary cOSObject = pdPageLabelRange.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}
