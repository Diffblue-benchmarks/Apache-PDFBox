package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCryptFilterDictionaryDiffblueTest {
  /**
   * Test {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDCryptFilterDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.<init>(COSDictionary)"})
  void testNewPDCryptFilterDictionary() {
    // Arrange
    COSDictionary d = new COSDictionary();

    // Act and Assert
    assertSame(d, new PDCryptFilterDictionary(d).getCOSObject());
  }

  /**
   * Test {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test new PDCryptFilterDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.<init>()"})
  void testNewPDCryptFilterDictionary2() {
    // Arrange and Act
    PDCryptFilterDictionary actualPdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Assert
    COSDictionary cOSObject = actualPdCryptFilterDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdCryptFilterDictionary.getCryptFilterMethod());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPdCryptFilterDictionary.getLength());
  }

  /**
   * Test {@link PDCryptFilterDictionary#getCOSObject()}.
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDCryptFilterDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    COSDictionary actualCOSObject = pdCryptFilterDictionary.getCOSObject();

    // Assert
    assertSame(pdCryptFilterDictionary.cryptFilterDictionary, actualCOSObject);
  }

  /**
   * Test {@link PDCryptFilterDictionary#setLength(int)}.
   *
   * <ul>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#setLength(int)}
   */
  @Test
  @DisplayName("Test setLength(int); then PDCryptFilterDictionary() Length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.setLength(int)"})
  void testSetLength_thenPDCryptFilterDictionaryLengthIsThree() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setLength(3);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, pdCryptFilterDictionary.getLength());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setLength(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#setLength(int)}
   */
  @Test
  @DisplayName(
      "Test setLength(int); when MIN_VALUE; then PDCryptFilterDictionary() Length is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.setLength(int)"})
  void testSetLength_whenMin_value_thenPDCryptFilterDictionaryLengthIsMin_value() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setLength(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdCryptFilterDictionary.getLength());
  }

  /**
   * Test {@link PDCryptFilterDictionary#getLength()}.
   *
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#getLength()}
   */
  @Test
  @DisplayName(
      "Test getLength(); given PDCryptFilterDictionary() Length is three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCryptFilterDictionary.getLength()"})
  void testGetLength_givenPDCryptFilterDictionaryLengthIsThree_thenReturnThree() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    pdCryptFilterDictionary.setLength(3);

    // Act and Assert
    assertEquals(3, pdCryptFilterDictionary.getLength());
  }

  /**
   * Test {@link PDCryptFilterDictionary#getLength()}.
   *
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.
   *   <li>Then return {@link PDEncryption#DEFAULT_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#getLength()}
   */
  @Test
  @DisplayName("Test getLength(); given PDCryptFilterDictionary(); then return DEFAULT_LENGTH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCryptFilterDictionary.getLength()"})
  void testGetLength_givenPDCryptFilterDictionary_thenReturnDefault_length() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, new PDCryptFilterDictionary().getLength());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}.
   *
   * <ul>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}
   */
  @Test
  @DisplayName(
      "Test setCryptFilterMethod(COSName); then PDCryptFilterDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.setCryptFilterMethod(COSName)"})
  void testSetCryptFilterMethod_thenPDCryptFilterDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setCryptFilterMethod(COSName.A);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(COSName.A, pdCryptFilterDictionary.getCryptFilterMethod());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}
   */
  @Test
  @DisplayName(
      "Test setCryptFilterMethod(COSName); when 'null'; then PDCryptFilterDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.setCryptFilterMethod(COSName)"})
  void testSetCryptFilterMethod_whenNull_thenPDCryptFilterDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setCryptFilterMethod(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDCryptFilterDictionary#getCryptFilterMethod()}.
   *
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#getCryptFilterMethod()}
   */
  @Test
  @DisplayName("Test getCryptFilterMethod(); given PDCryptFilterDictionary() Length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDCryptFilterDictionary.getCryptFilterMethod()"})
  void testGetCryptFilterMethod_givenPDCryptFilterDictionaryLengthIsThree() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    pdCryptFilterDictionary.setLength(3);

    // Act and Assert
    assertNull(pdCryptFilterDictionary.getCryptFilterMethod());
  }

  /**
   * Test {@link PDCryptFilterDictionary#getCryptFilterMethod()}.
   *
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#getCryptFilterMethod()}
   */
  @Test
  @DisplayName("Test getCryptFilterMethod(); given PDCryptFilterDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDCryptFilterDictionary.getCryptFilterMethod()"})
  void testGetCryptFilterMethod_givenPDCryptFilterDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCryptFilterDictionary().getCryptFilterMethod());
  }

  /**
   * Test {@link PDCryptFilterDictionary#getCryptFilterMethod()}.
   *
   * <ul>
   *   <li>Then return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#getCryptFilterMethod()}
   */
  @Test
  @DisplayName("Test getCryptFilterMethod(); then return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDCryptFilterDictionary.getCryptFilterMethod()"})
  void testGetCryptFilterMethod_thenReturnA() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    pdCryptFilterDictionary.setCryptFilterMethod(COSName.A);

    // Act and Assert
    assertSame(COSName.A, pdCryptFilterDictionary.getCryptFilterMethod());
  }

  /**
   * Test {@link PDCryptFilterDictionary#isEncryptMetaData()}.
   *
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#isEncryptMetaData()}
   */
  @Test
  @DisplayName(
      "Test isEncryptMetaData(); given PDCryptFilterDictionary() Length is three; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCryptFilterDictionary.isEncryptMetaData()"})
  void testIsEncryptMetaData_givenPDCryptFilterDictionaryLengthIsThree_thenReturnTrue() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    pdCryptFilterDictionary.setLength(3);

    // Act and Assert
    assertTrue(pdCryptFilterDictionary.isEncryptMetaData());
  }

  /**
   * Test {@link PDCryptFilterDictionary#isEncryptMetaData()}.
   *
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#isEncryptMetaData()}
   */
  @Test
  @DisplayName("Test isEncryptMetaData(); given PDCryptFilterDictionary(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCryptFilterDictionary.isEncryptMetaData()"})
  void testIsEncryptMetaData_givenPDCryptFilterDictionary_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDCryptFilterDictionary().isEncryptMetaData());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} EncryptMetaData.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}
   */
  @Test
  @DisplayName("Test setEncryptMetaData(boolean); then PDCryptFilterDictionary() EncryptMetaData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.setEncryptMetaData(boolean)"})
  void testSetEncryptMetaData_thenPDCryptFilterDictionaryEncryptMetaData() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setEncryptMetaData(true);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdCryptFilterDictionary.isEncryptMetaData());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} EncryptMetaData.
   * </ul>
   *
   * <p>Method under test: {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}
   */
  @Test
  @DisplayName(
      "Test setEncryptMetaData(boolean); when 'false'; then not PDCryptFilterDictionary() EncryptMetaData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCryptFilterDictionary.setEncryptMetaData(boolean)"})
  void testSetEncryptMetaData_whenFalse_thenNotPDCryptFilterDictionaryEncryptMetaData() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setEncryptMetaData(false);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdCryptFilterDictionary.isEncryptMetaData());
  }
}
