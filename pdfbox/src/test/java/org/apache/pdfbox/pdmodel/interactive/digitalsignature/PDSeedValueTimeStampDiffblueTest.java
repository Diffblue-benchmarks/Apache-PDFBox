package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDSeedValueTimeStampDiffblueTest {
  /**
   * Test {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}.
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}
   */
  @Test
  @DisplayName("Test new PDSeedValueTimeStamp()")
  void testNewPDSeedValueTimeStamp() {
    // Arrange and Act
    PDSeedValueTimeStamp actualPdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Assert
    assertNull(actualPdSeedValueTimeStamp.getURL());
    COSDictionary cOSObject = actualPdSeedValueTimeStamp.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdSeedValueTimeStamp.isTimestampRequired());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return URL is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDSeedValueTimeStamp(COSDictionary); when COSDictionary(); then return URL is 'null'")
  void testNewPDSeedValueTimeStamp_whenCOSDictionary_thenReturnUrlIsNull() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDSeedValueTimeStamp actualPdSeedValueTimeStamp = new PDSeedValueTimeStamp(dict);

    // Assert
    assertNull(actualPdSeedValueTimeStamp.getURL());
    assertFalse(actualPdSeedValueTimeStamp.isTimestampRequired());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdSeedValueTimeStamp.getCOSObject());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#getCOSObject()}.
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDSeedValueTimeStamp()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCOSObject.isDirect());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#getURL()}.
   * <ul>
   *   <li>Given {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()} URL is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); given PDSeedValueTimeStamp() URL is empty string; then return empty string")
  void testGetURL_givenPDSeedValueTimeStampUrlIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setURL("");

    // Act and Assert
    assertEquals("", pdSeedValueTimeStamp.getURL());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#getURL()}.
   * <ul>
   *   <li>Given {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); given PDSeedValueTimeStamp(); then return 'null'")
  void testGetURL_givenPDSeedValueTimeStamp_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueTimeStamp()).getURL());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#getURL()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); then return 'https://example.org/example'")
  void testGetURL_thenReturnHttpsExampleOrgExample() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", pdSeedValueTimeStamp.getURL());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#setURL(String)}.
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#setURL(String)}
   */
  @Test
  @DisplayName("Test setURL(String)")
  void testSetURL() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Act
    pdSeedValueTimeStamp.setURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", pdSeedValueTimeStamp.getURL());
    COSDictionary cOSObject = pdSeedValueTimeStamp.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#isTimestampRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()} URL is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#isTimestampRequired()}
   */
  @Test
  @DisplayName("Test isTimestampRequired(); given PDSeedValueTimeStamp() URL is 'https://example.org/example'")
  void testIsTimestampRequired_givenPDSeedValueTimeStampUrlIsHttpsExampleOrgExample() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setURL("https://example.org/example");

    // Act and Assert
    assertFalse(pdSeedValueTimeStamp.isTimestampRequired());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#isTimestampRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#isTimestampRequired()}
   */
  @Test
  @DisplayName("Test isTimestampRequired(); given PDSeedValueTimeStamp(); then return 'false'")
  void testIsTimestampRequired_givenPDSeedValueTimeStamp_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueTimeStamp()).isTimestampRequired());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#isTimestampRequired()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#isTimestampRequired()}
   */
  @Test
  @DisplayName("Test isTimestampRequired(); then return 'true'")
  void testIsTimestampRequired_thenReturnTrue() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setTimestampRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueTimeStamp.isTimestampRequired());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}
   * TimestampRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}
   */
  @Test
  @DisplayName("Test setTimestampRequired(boolean); when 'false'; then not PDSeedValueTimeStamp() TimestampRequired")
  void testSetTimestampRequired_whenFalse_thenNotPDSeedValueTimeStampTimestampRequired() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Act
    pdSeedValueTimeStamp.setTimestampRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueTimeStamp.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdSeedValueTimeStamp.isTimestampRequired());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}
   * TimestampRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}
   */
  @Test
  @DisplayName("Test setTimestampRequired(boolean); when 'true'; then PDSeedValueTimeStamp() TimestampRequired")
  void testSetTimestampRequired_whenTrue_thenPDSeedValueTimeStampTimestampRequired() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Act
    pdSeedValueTimeStamp.setTimestampRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueTimeStamp.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueTimeStamp.isTimestampRequired());
  }
}
