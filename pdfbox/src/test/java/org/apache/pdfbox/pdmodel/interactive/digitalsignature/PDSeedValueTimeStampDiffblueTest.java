package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSeedValueTimeStampDiffblueTest {
  /**
   * Test {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}.
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}
   */
  @Test
  @DisplayName("Test new PDSeedValueTimeStamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueTimeStamp.<init>()"})
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
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return URL is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDSeedValueTimeStamp(COSDictionary); when COSDictionary(); then return URL is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueTimeStamp.<init>(COSDictionary)"})
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
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDSeedValueTimeStamp.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDSeedValueTimeStamp().getCOSObject();

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
   *
   * <ul>
   *   <li>Given {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()} URL is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  @DisplayName(
      "Test getURL(); given PDSeedValueTimeStamp() URL is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSeedValueTimeStamp.getURL()"})
  void testGetURL_givenPDSeedValueTimeStampUrlIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setURL("");

    // Act and Assert
    assertEquals("", pdSeedValueTimeStamp.getURL());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#getURL()}.
   *
   * <ul>
   *   <li>Given {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); given PDSeedValueTimeStamp(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSeedValueTimeStamp.getURL()"})
  void testGetURL_givenPDSeedValueTimeStamp_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSeedValueTimeStamp().getURL());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#getURL()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); then return 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSeedValueTimeStamp.getURL()"})
  void testGetURL_thenReturnHttpsExampleOrgExample() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", pdSeedValueTimeStamp.getURL());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#setURL(String)}.
   *
   * <ul>
   *   <li>Then {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()} URL is {@code
   *       https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#setURL(String)}
   */
  @Test
  @DisplayName(
      "Test setURL(String); then PDSeedValueTimeStamp() URL is 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueTimeStamp.setURL(String)"})
  void testSetURL_thenPDSeedValueTimeStampUrlIsHttpsExampleOrgExample() {
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
   * Test {@link PDSeedValueTimeStamp#setURL(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#setURL(String)}
   */
  @Test
  @DisplayName(
      "Test setURL(String); when 'null'; then PDSeedValueTimeStamp() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueTimeStamp.setURL(String)"})
  void testSetURL_whenNull_thenPDSeedValueTimeStampCOSObjectSizeIsZero() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Act
    pdSeedValueTimeStamp.setURL(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSeedValueTimeStamp.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#isTimestampRequired()}.
   *
   * <ul>
   *   <li>Given {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#isTimestampRequired()}
   */
  @Test
  @DisplayName("Test isTimestampRequired(); given PDSeedValueTimeStamp(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDSeedValueTimeStamp.isTimestampRequired()"})
  void testIsTimestampRequired_givenPDSeedValueTimeStamp_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDSeedValueTimeStamp().isTimestampRequired());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#isTimestampRequired()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#isTimestampRequired()}
   */
  @Test
  @DisplayName("Test isTimestampRequired(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDSeedValueTimeStamp.isTimestampRequired()"})
  void testIsTimestampRequired_thenReturnTrue() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setTimestampRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueTimeStamp.isTimestampRequired());
  }

  /**
   * Test {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()} TimestampRequired.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}
   */
  @Test
  @DisplayName(
      "Test setTimestampRequired(boolean); when 'false'; then not PDSeedValueTimeStamp() TimestampRequired")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueTimeStamp.setTimestampRequired(boolean)"})
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
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()} TimestampRequired.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}
   */
  @Test
  @DisplayName(
      "Test setTimestampRequired(boolean); when 'true'; then PDSeedValueTimeStamp() TimestampRequired")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueTimeStamp.setTimestampRequired(boolean)"})
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
