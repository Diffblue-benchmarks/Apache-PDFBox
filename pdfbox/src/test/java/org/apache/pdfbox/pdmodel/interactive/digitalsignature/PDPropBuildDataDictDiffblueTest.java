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

class PDPropBuildDataDictDiffblueTest {
  /**
   * Test {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *
   * <p>Method under test: {@link PDPropBuildDataDict#PDPropBuildDataDict()}
   */
  @Test
  @DisplayName("Test new PDPropBuildDataDict()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.<init>()"})
  void testNewPDPropBuildDataDict() {
    // Arrange and Act
    PDPropBuildDataDict actualPdPropBuildDataDict = new PDPropBuildDataDict();

    // Assert
    assertNull(actualPdPropBuildDataDict.getDate());
    assertNull(actualPdPropBuildDataDict.getName());
    assertNull(actualPdPropBuildDataDict.getOS());
    assertNull(actualPdPropBuildDataDict.getVersion());
    COSDictionary cOSObject = actualPdPropBuildDataDict.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(-1L, actualPdPropBuildDataDict.getMinimumRevision());
    assertEquals(-1L, actualPdPropBuildDataDict.getRevision());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(actualPdPropBuildDataDict.getPreRelease());
    assertFalse(actualPdPropBuildDataDict.getTrustedMode());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(actualPdPropBuildDataDict.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuildDataDict#PDPropBuildDataDict(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Date is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#PDPropBuildDataDict(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDPropBuildDataDict(COSDictionary); when COSDictionary(); then return Date is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.<init>(COSDictionary)"})
  void testNewPDPropBuildDataDict_whenCOSDictionary_thenReturnDateIsNull() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDPropBuildDataDict actualPdPropBuildDataDict = new PDPropBuildDataDict(dict);

    // Assert
    assertNull(actualPdPropBuildDataDict.getDate());
    assertNull(actualPdPropBuildDataDict.getName());
    assertNull(actualPdPropBuildDataDict.getOS());
    assertNull(actualPdPropBuildDataDict.getVersion());
    assertEquals(-1L, actualPdPropBuildDataDict.getMinimumRevision());
    assertEquals(-1L, actualPdPropBuildDataDict.getRevision());
    assertFalse(actualPdPropBuildDataDict.getPreRelease());
    assertFalse(actualPdPropBuildDataDict.getTrustedMode());
    assertTrue(dict.isDirect());
    assertTrue(actualPdPropBuildDataDict.getNonEFontNoWarn());
    assertSame(dict, actualPdPropBuildDataDict.getCOSObject());
  }

  /**
   * Test {@link PDPropBuildDataDict#getCOSObject()}.
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDPropBuildDataDict.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDPropBuildDataDict().getCOSObject();

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
   * Test {@link PDPropBuildDataDict#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDPropBuildDataDict() Name is 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getName()"})
  void testGetName_givenPDPropBuildDataDictNameIsName_thenReturnName() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertEquals("Name", pdPropBuildDataDict.getName());
  }

  /**
   * Test {@link PDPropBuildDataDict#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDPropBuildDataDict(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getName()"})
  void testGetName_givenPDPropBuildDataDict_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPropBuildDataDict().getName());
  }

  /**
   * Test {@link PDPropBuildDataDict#setName(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when '42'; then PDPropBuildDataDict() Name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setName(String)"})
  void testSetName_when42_thenPDPropBuildDataDictNameIs42() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setName("42");

    // Assert
    assertEquals("42", pdPropBuildDataDict.getName());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then PDPropBuildDataDict() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setName(String)"})
  void testSetName_whenName_thenPDPropBuildDataDictNameIsName() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setName("Name");

    // Assert
    assertEquals("Name", pdPropBuildDataDict.getName());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when 'null'; then PDPropBuildDataDict() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setName(String)"})
  void testSetName_whenNull_thenPDPropBuildDataDictCOSObjectSizeIsZero() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPropBuildDataDict#getDate()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Date is {@code 2020-03-01}.
   *   <li>Then return {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getDate()}
   */
  @Test
  @DisplayName(
      "Test getDate(); given PDPropBuildDataDict() Date is '2020-03-01'; then return '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getDate()"})
  void testGetDate_givenPDPropBuildDataDictDateIs20200301_thenReturn20200301() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setDate("2020-03-01");

    // Act and Assert
    assertEquals("2020-03-01", pdPropBuildDataDict.getDate());
  }

  /**
   * Test {@link PDPropBuildDataDict#getDate()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Date is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getDate()}
   */
  @Test
  @DisplayName(
      "Test getDate(); given PDPropBuildDataDict() Date is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getDate()"})
  void testGetDate_givenPDPropBuildDataDictDateIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setDate("");

    // Act and Assert
    assertEquals("", pdPropBuildDataDict.getDate());
  }

  /**
   * Test {@link PDPropBuildDataDict#getDate()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getDate()}
   */
  @Test
  @DisplayName("Test getDate(); given PDPropBuildDataDict() Name is 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getDate()"})
  void testGetDate_givenPDPropBuildDataDictNameIsName_thenReturnNull() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertNull(pdPropBuildDataDict.getDate());
  }

  /**
   * Test {@link PDPropBuildDataDict#getDate()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getDate()}
   */
  @Test
  @DisplayName("Test getDate(); given PDPropBuildDataDict(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getDate()"})
  void testGetDate_givenPDPropBuildDataDict_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPropBuildDataDict().getDate());
  }

  /**
   * Test {@link PDPropBuildDataDict#setDate(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} Date is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setDate(String)}
   */
  @Test
  @DisplayName(
      "Test setDate(String); when '2020-03-01'; then PDPropBuildDataDict() Date is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setDate(String)"})
  void testSetDate_when20200301_thenPDPropBuildDataDictDateIs20200301() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setDate("2020-03-01");

    // Assert
    assertEquals("2020-03-01", pdPropBuildDataDict.getDate());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setDate(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setDate(String)}
   */
  @Test
  @DisplayName(
      "Test setDate(String); when 'null'; then PDPropBuildDataDict() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setDate(String)"})
  void testSetDate_whenNull_thenPDPropBuildDataDictCOSObjectSizeIsZero() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setDate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPropBuildDataDict#setVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} Version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setVersion(String)}
   */
  @Test
  @DisplayName(
      "Test setVersion(String); when '1.0.2'; then PDPropBuildDataDict() Version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setVersion(String)"})
  void testSetVersion_when102_thenPDPropBuildDataDictVersionIs102() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", pdPropBuildDataDict.getVersion());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setVersion(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setVersion(String)}
   */
  @Test
  @DisplayName(
      "Test setVersion(String); when 'null'; then PDPropBuildDataDict() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setVersion(String)"})
  void testSetVersion_whenNull_thenPDPropBuildDataDictCOSObjectSizeIsZero() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setVersion(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPropBuildDataDict#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code REx}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDPropBuildDataDict() Name is 'REx'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getVersion()"})
  void testGetVersion_givenPDPropBuildDataDictNameIsREx_thenReturnNull() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("REx");

    // Act and Assert
    assertNull(pdPropBuildDataDict.getVersion());
  }

  /**
   * Test {@link PDPropBuildDataDict#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Version is {@code 1.0.2}.
   *   <li>Then return {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getVersion()}
   */
  @Test
  @DisplayName(
      "Test getVersion(); given PDPropBuildDataDict() Version is '1.0.2'; then return '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getVersion()"})
  void testGetVersion_givenPDPropBuildDataDictVersionIs102_thenReturn102() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setVersion("1.0.2");

    // Act and Assert
    assertEquals("1.0.2", pdPropBuildDataDict.getVersion());
  }

  /**
   * Test {@link PDPropBuildDataDict#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDPropBuildDataDict(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getVersion()"})
  void testGetVersion_givenPDPropBuildDataDict_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPropBuildDataDict().getVersion());
  }

  /**
   * Test {@link PDPropBuildDataDict#getVersion()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getVersion()"})
  void testGetVersion_thenReturnEmptyString() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setVersion("");

    // Act and Assert
    assertEquals("", pdPropBuildDataDict.getVersion());
  }

  /**
   * Test {@link PDPropBuildDataDict#getRevision()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getRevision()}
   */
  @Test
  @DisplayName("Test getRevision(); given PDPropBuildDataDict()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PDPropBuildDataDict.getRevision()"})
  void testGetRevision_givenPDPropBuildDataDict() {
    // Arrange, Act and Assert
    assertEquals(-1L, new PDPropBuildDataDict().getRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#getRevision()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getRevision()}
   */
  @Test
  @DisplayName("Test getRevision(); given PDPropBuildDataDict() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PDPropBuildDataDict.getRevision()"})
  void testGetRevision_givenPDPropBuildDataDictNameIsName() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertEquals(-1L, pdPropBuildDataDict.getRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#getRevision()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Revision is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getRevision()}
   */
  @Test
  @DisplayName("Test getRevision(); given PDPropBuildDataDict() Revision is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PDPropBuildDataDict.getRevision()"})
  void testGetRevision_givenPDPropBuildDataDictRevisionIsMinusOne() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setRevision(-1L);

    // Act and Assert
    assertEquals(-1L, pdPropBuildDataDict.getRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#setRevision(long)}.
   *
   * <ul>
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} Revision is minus one hundred one.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setRevision(long)}
   */
  @Test
  @DisplayName(
      "Test setRevision(long); then PDPropBuildDataDict() Revision is minus one hundred one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setRevision(long)"})
  void testSetRevision_thenPDPropBuildDataDictRevisionIsMinusOneHundredOne() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setRevision(-101L);

    // Assert
    assertEquals(-101L, pdPropBuildDataDict.getRevision());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setRevision(long)}.
   *
   * <ul>
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} Revision is two hundred
   *       fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setRevision(long)}
   */
  @Test
  @DisplayName(
      "Test setRevision(long); then PDPropBuildDataDict() Revision is two hundred fifty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setRevision(long)"})
  void testSetRevision_thenPDPropBuildDataDictRevisionIsTwoHundredFiftySeven() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setRevision(257L);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(257L, pdPropBuildDataDict.getRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#setRevision(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} Revision is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setRevision(long)}
   */
  @Test
  @DisplayName("Test setRevision(long); when one; then PDPropBuildDataDict() Revision is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setRevision(long)"})
  void testSetRevision_whenOne_thenPDPropBuildDataDictRevisionIsOne() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setRevision(1L);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1L, pdPropBuildDataDict.getRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#getMinimumRevision()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getMinimumRevision()}
   */
  @Test
  @DisplayName("Test getMinimumRevision(); given PDPropBuildDataDict()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PDPropBuildDataDict.getMinimumRevision()"})
  void testGetMinimumRevision_givenPDPropBuildDataDict() {
    // Arrange, Act and Assert
    assertEquals(-1L, new PDPropBuildDataDict().getMinimumRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#getMinimumRevision()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} MinimumRevision is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getMinimumRevision()}
   */
  @Test
  @DisplayName(
      "Test getMinimumRevision(); given PDPropBuildDataDict() MinimumRevision is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PDPropBuildDataDict.getMinimumRevision()"})
  void testGetMinimumRevision_givenPDPropBuildDataDictMinimumRevisionIsMinusOne() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setMinimumRevision(-1L);

    // Act and Assert
    assertEquals(-1L, pdPropBuildDataDict.getMinimumRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#getMinimumRevision()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getMinimumRevision()}
   */
  @Test
  @DisplayName("Test getMinimumRevision(); given PDPropBuildDataDict() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PDPropBuildDataDict.getMinimumRevision()"})
  void testGetMinimumRevision_givenPDPropBuildDataDictNameIsName() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertEquals(-1L, pdPropBuildDataDict.getMinimumRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#setMinimumRevision(long)}.
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setMinimumRevision(long)}
   */
  @Test
  @DisplayName("Test setMinimumRevision(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setMinimumRevision(long)"})
  void testSetMinimumRevision() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setMinimumRevision(-101L);

    // Assert
    assertEquals(-101L, pdPropBuildDataDict.getMinimumRevision());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setMinimumRevision(long)}.
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setMinimumRevision(long)}
   */
  @Test
  @DisplayName("Test setMinimumRevision(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setMinimumRevision(long)"})
  void testSetMinimumRevision2() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setMinimumRevision(257L);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(257L, pdPropBuildDataDict.getMinimumRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#setMinimumRevision(long)}.
   *
   * <ul>
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} MinimumRevision is minus one
   *       hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setMinimumRevision(long)}
   */
  @Test
  @DisplayName(
      "Test setMinimumRevision(long); then PDPropBuildDataDict() MinimumRevision is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setMinimumRevision(long)"})
  void testSetMinimumRevision_thenPDPropBuildDataDictMinimumRevisionIsMinusOneHundred() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setMinimumRevision(-100L);

    // Assert
    assertEquals(-100L, pdPropBuildDataDict.getMinimumRevision());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setMinimumRevision(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} MinimumRevision is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setMinimumRevision(long)}
   */
  @Test
  @DisplayName(
      "Test setMinimumRevision(long); when one; then PDPropBuildDataDict() MinimumRevision is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setMinimumRevision(long)"})
  void testSetMinimumRevision_whenOne_thenPDPropBuildDataDictMinimumRevisionIsOne() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setMinimumRevision(1L);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1L, pdPropBuildDataDict.getMinimumRevision());
  }

  /**
   * Test {@link PDPropBuildDataDict#getPreRelease()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getPreRelease()}
   */
  @Test
  @DisplayName(
      "Test getPreRelease(); given PDPropBuildDataDict() Name is 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getPreRelease()"})
  void testGetPreRelease_givenPDPropBuildDataDictNameIsName_thenReturnFalse() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertFalse(pdPropBuildDataDict.getPreRelease());
  }

  /**
   * Test {@link PDPropBuildDataDict#getPreRelease()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} PreRelease is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getPreRelease()}
   */
  @Test
  @DisplayName(
      "Test getPreRelease(); given PDPropBuildDataDict() PreRelease is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getPreRelease()"})
  void testGetPreRelease_givenPDPropBuildDataDictPreReleaseIsFalse_thenReturnFalse() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setPreRelease(false);

    // Act and Assert
    assertFalse(pdPropBuildDataDict.getPreRelease());
  }

  /**
   * Test {@link PDPropBuildDataDict#getPreRelease()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} PreRelease is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getPreRelease()}
   */
  @Test
  @DisplayName(
      "Test getPreRelease(); given PDPropBuildDataDict() PreRelease is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getPreRelease()"})
  void testGetPreRelease_givenPDPropBuildDataDictPreReleaseIsTrue_thenReturnTrue() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setPreRelease(true);

    // Act and Assert
    assertTrue(pdPropBuildDataDict.getPreRelease());
  }

  /**
   * Test {@link PDPropBuildDataDict#getPreRelease()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getPreRelease()}
   */
  @Test
  @DisplayName("Test getPreRelease(); given PDPropBuildDataDict(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getPreRelease()"})
  void testGetPreRelease_givenPDPropBuildDataDict_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDPropBuildDataDict().getPreRelease());
  }

  /**
   * Test {@link PDPropBuildDataDict#setPreRelease(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDPropBuildDataDict#PDPropBuildDataDict()} PreRelease.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setPreRelease(boolean)}
   */
  @Test
  @DisplayName(
      "Test setPreRelease(boolean); when 'false'; then not PDPropBuildDataDict() PreRelease")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setPreRelease(boolean)"})
  void testSetPreRelease_whenFalse_thenNotPDPropBuildDataDictPreRelease() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setPreRelease(false);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdPropBuildDataDict.getPreRelease());
  }

  /**
   * Test {@link PDPropBuildDataDict#setPreRelease(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} PreRelease.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setPreRelease(boolean)}
   */
  @Test
  @DisplayName("Test setPreRelease(boolean); when 'true'; then PDPropBuildDataDict() PreRelease")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setPreRelease(boolean)"})
  void testSetPreRelease_whenTrue_thenPDPropBuildDataDictPreRelease() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setPreRelease(true);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdPropBuildDataDict.getPreRelease());
  }

  /**
   * Test {@link PDPropBuildDataDict#getOS()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getOS()}
   */
  @Test
  @DisplayName("Test getOS(); given PDPropBuildDataDict() Name is 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getOS()"})
  void testGetOS_givenPDPropBuildDataDictNameIsName_thenReturnNull() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertNull(pdPropBuildDataDict.getOS());
  }

  /**
   * Test {@link PDPropBuildDataDict#getOS()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} OS is {@code Os}.
   *   <li>Then return {@code Os}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getOS()}
   */
  @Test
  @DisplayName("Test getOS(); given PDPropBuildDataDict() OS is 'Os'; then return 'Os'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getOS()"})
  void testGetOS_givenPDPropBuildDataDictOsIsOs_thenReturnOs() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setOS("Os");

    // Act and Assert
    assertEquals("Os", pdPropBuildDataDict.getOS());
  }

  /**
   * Test {@link PDPropBuildDataDict#getOS()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getOS()}
   */
  @Test
  @DisplayName("Test getOS(); given PDPropBuildDataDict(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPropBuildDataDict.getOS()"})
  void testGetOS_givenPDPropBuildDataDict_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPropBuildDataDict().getOS());
  }

  /**
   * Test {@link PDPropBuildDataDict#setOS(String)}.
   *
   * <ul>
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setOS(String)}
   */
  @Test
  @DisplayName("Test setOS(String); then PDPropBuildDataDict() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setOS(String)"})
  void testSetOS_thenPDPropBuildDataDictCOSObjectValuesSizeIsOne() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setOS("Os");

    // Assert
    assertEquals("Os", pdPropBuildDataDict.getOS());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setOS(String)}.
   *
   * <ul>
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setOS(String)}
   */
  @Test
  @DisplayName("Test setOS(String); then PDPropBuildDataDict() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setOS(String)"})
  void testSetOS_thenPDPropBuildDataDictCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act
    pdPropBuildDataDict.setOS("Os");

    // Assert
    assertEquals("Os", pdPropBuildDataDict.getOS());
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDPropBuildDataDict#setOS(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setOS(String)}
   */
  @Test
  @DisplayName("Test setOS(String); when 'null'; then PDPropBuildDataDict() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setOS(String)"})
  void testSetOS_whenNull_thenPDPropBuildDataDictCOSObjectSizeIsZero() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setOS(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDPropBuildDataDict#getNonEFontNoWarn()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getNonEFontNoWarn()}
   */
  @Test
  @DisplayName(
      "Test getNonEFontNoWarn(); given PDPropBuildDataDict() Name is 'Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getNonEFontNoWarn()"})
  void testGetNonEFontNoWarn_givenPDPropBuildDataDictNameIsName_thenReturnTrue() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertTrue(pdPropBuildDataDict.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuildDataDict#getNonEFontNoWarn()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} NonEFontNoWarn is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getNonEFontNoWarn()}
   */
  @Test
  @DisplayName("Test getNonEFontNoWarn(); given PDPropBuildDataDict() NonEFontNoWarn is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getNonEFontNoWarn()"})
  void testGetNonEFontNoWarn_givenPDPropBuildDataDictNonEFontNoWarnIsTrue() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setNonEFontNoWarn(true);

    // Act and Assert
    assertTrue(pdPropBuildDataDict.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuildDataDict#getNonEFontNoWarn()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getNonEFontNoWarn()}
   */
  @Test
  @DisplayName("Test getNonEFontNoWarn(); given PDPropBuildDataDict(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getNonEFontNoWarn()"})
  void testGetNonEFontNoWarn_givenPDPropBuildDataDict_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDPropBuildDataDict().getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuildDataDict#getNonEFontNoWarn()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getNonEFontNoWarn()}
   */
  @Test
  @DisplayName("Test getNonEFontNoWarn(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getNonEFontNoWarn()"})
  void testGetNonEFontNoWarn_thenReturnFalse() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setNonEFontNoWarn(false);

    // Act and Assert
    assertFalse(pdPropBuildDataDict.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuildDataDict#setNonEFontNoWarn(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDPropBuildDataDict#PDPropBuildDataDict()} NonEFontNoWarn.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setNonEFontNoWarn(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNonEFontNoWarn(boolean); when 'false'; then not PDPropBuildDataDict() NonEFontNoWarn")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setNonEFontNoWarn(boolean)"})
  void testSetNonEFontNoWarn_whenFalse_thenNotPDPropBuildDataDictNonEFontNoWarn() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setNonEFontNoWarn(false);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdPropBuildDataDict.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuildDataDict#setNonEFontNoWarn(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} NonEFontNoWarn.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setNonEFontNoWarn(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNonEFontNoWarn(boolean); when 'true'; then PDPropBuildDataDict() NonEFontNoWarn")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setNonEFontNoWarn(boolean)"})
  void testSetNonEFontNoWarn_whenTrue_thenPDPropBuildDataDictNonEFontNoWarn() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setNonEFontNoWarn(true);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdPropBuildDataDict.getNonEFontNoWarn());
  }

  /**
   * Test {@link PDPropBuildDataDict#getTrustedMode()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} Name is {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getTrustedMode()}
   */
  @Test
  @DisplayName(
      "Test getTrustedMode(); given PDPropBuildDataDict() Name is 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getTrustedMode()"})
  void testGetTrustedMode_givenPDPropBuildDataDictNameIsName_thenReturnFalse() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setName("Name");

    // Act and Assert
    assertFalse(pdPropBuildDataDict.getTrustedMode());
  }

  /**
   * Test {@link PDPropBuildDataDict#getTrustedMode()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} TrustedMode is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getTrustedMode()}
   */
  @Test
  @DisplayName(
      "Test getTrustedMode(); given PDPropBuildDataDict() TrustedMode is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getTrustedMode()"})
  void testGetTrustedMode_givenPDPropBuildDataDictTrustedModeIsFalse_thenReturnFalse() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setTrustedMode(false);

    // Act and Assert
    assertFalse(pdPropBuildDataDict.getTrustedMode());
  }

  /**
   * Test {@link PDPropBuildDataDict#getTrustedMode()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()} TrustedMode is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getTrustedMode()}
   */
  @Test
  @DisplayName(
      "Test getTrustedMode(); given PDPropBuildDataDict() TrustedMode is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getTrustedMode()"})
  void testGetTrustedMode_givenPDPropBuildDataDictTrustedModeIsTrue_thenReturnTrue() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();
    pdPropBuildDataDict.setTrustedMode(true);

    // Act and Assert
    assertTrue(pdPropBuildDataDict.getTrustedMode());
  }

  /**
   * Test {@link PDPropBuildDataDict#getTrustedMode()}.
   *
   * <ul>
   *   <li>Given {@link PDPropBuildDataDict#PDPropBuildDataDict()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#getTrustedMode()}
   */
  @Test
  @DisplayName("Test getTrustedMode(); given PDPropBuildDataDict(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDPropBuildDataDict.getTrustedMode()"})
  void testGetTrustedMode_givenPDPropBuildDataDict_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDPropBuildDataDict().getTrustedMode());
  }

  /**
   * Test {@link PDPropBuildDataDict#setTrustedMode(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDPropBuildDataDict#PDPropBuildDataDict()} TrustedMode.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setTrustedMode(boolean)}
   */
  @Test
  @DisplayName(
      "Test setTrustedMode(boolean); when 'false'; then not PDPropBuildDataDict() TrustedMode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setTrustedMode(boolean)"})
  void testSetTrustedMode_whenFalse_thenNotPDPropBuildDataDictTrustedMode() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setTrustedMode(false);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdPropBuildDataDict.getTrustedMode());
  }

  /**
   * Test {@link PDPropBuildDataDict#setTrustedMode(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDPropBuildDataDict#PDPropBuildDataDict()} TrustedMode.
   * </ul>
   *
   * <p>Method under test: {@link PDPropBuildDataDict#setTrustedMode(boolean)}
   */
  @Test
  @DisplayName("Test setTrustedMode(boolean); when 'true'; then PDPropBuildDataDict() TrustedMode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPropBuildDataDict.setTrustedMode(boolean)"})
  void testSetTrustedMode_whenTrue_thenPDPropBuildDataDictTrustedMode() {
    // Arrange
    PDPropBuildDataDict pdPropBuildDataDict = new PDPropBuildDataDict();

    // Act
    pdPropBuildDataDict.setTrustedMode(true);

    // Assert
    COSDictionary cOSObject = pdPropBuildDataDict.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdPropBuildDataDict.getTrustedMode());
  }
}
