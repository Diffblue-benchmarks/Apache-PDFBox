package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDCryptFilterDictionary(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCryptFilterDictionary.<init>(COSDictionary)"})
  void testNewPDCryptFilterDictionary() {
    // Arrange
    COSDictionary d = new COSDictionary();

    // Act and Assert
    assertSame(d, (new PDCryptFilterDictionary(d)).getCOSObject());
  }

  /**
   * Test {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test new PDCryptFilterDictionary()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDCryptFilterDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act and Assert
    assertSame(pdCryptFilterDictionary.cryptFilterDictionary, pdCryptFilterDictionary.getCOSObject());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setLength(int)}.
   * <ul>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#setLength(int)}
   */
  @Test
  @DisplayName("Test setLength(int); then PDCryptFilterDictionary() Length is three")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#setLength(int)}
   */
  @Test
  @DisplayName("Test setLength(int); when MIN_VALUE; then PDCryptFilterDictionary() Length is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} Length is three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#getLength()}
   */
  @Test
  @DisplayName("Test getLength(); given PDCryptFilterDictionary() Length is three; then return three")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.</li>
   *   <li>Then return {@link PDEncryption#DEFAULT_LENGTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#getLength()}
   */
  @Test
  @DisplayName("Test getLength(); given PDCryptFilterDictionary(); then return DEFAULT_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDCryptFilterDictionary.getLength()"})
  void testGetLength_givenPDCryptFilterDictionary_thenReturnDefault_length() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, (new PDCryptFilterDictionary()).getLength());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}.
   * <ul>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}
   */
  @Test
  @DisplayName("Test setCryptFilterMethod(COSName); then PDCryptFilterDictionary() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCryptFilterDictionary.setCryptFilterMethod(COSName)"})
  void testSetCryptFilterMethod_thenPDCryptFilterDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    COSName cfm = COSName.A;

    // Act
    pdCryptFilterDictionary.setCryptFilterMethod(cfm);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSName expectedCryptFilterMethod = cfm.A;
    assertSame(expectedCryptFilterMethod, pdCryptFilterDictionary.getCryptFilterMethod());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}
   */
  @Test
  @DisplayName("Test setCryptFilterMethod(COSName); when 'null'; then PDCryptFilterDictionary() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#getCryptFilterMethod()}
   */
  @Test
  @DisplayName("Test getCryptFilterMethod(); given PDCryptFilterDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PDCryptFilterDictionary.getCryptFilterMethod()"})
  void testGetCryptFilterMethod_givenPDCryptFilterDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCryptFilterDictionary()).getCryptFilterMethod());
  }

  /**
   * Test {@link PDCryptFilterDictionary#getCryptFilterMethod()}.
   * <ul>
   *   <li>Then return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#getCryptFilterMethod()}
   */
  @Test
  @DisplayName("Test getCryptFilterMethod(); then return A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PDCryptFilterDictionary.getCryptFilterMethod()"})
  void testGetCryptFilterMethod_thenReturnA() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    pdCryptFilterDictionary.setCryptFilterMethod(COSName.A);

    // Act
    COSName actualCryptFilterMethod = pdCryptFilterDictionary.getCryptFilterMethod();

    // Assert
    assertSame(actualCryptFilterMethod.A, actualCryptFilterMethod);
  }

  /**
   * Test {@link PDCryptFilterDictionary#isEncryptMetaData()}.
   * <ul>
   *   <li>Given {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#isEncryptMetaData()}
   */
  @Test
  @DisplayName("Test isEncryptMetaData(); given PDCryptFilterDictionary(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDCryptFilterDictionary.isEncryptMetaData()"})
  void testIsEncryptMetaData_givenPDCryptFilterDictionary_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDCryptFilterDictionary()).isEncryptMetaData());
  }

  /**
   * Test {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}.
   * <ul>
   *   <li>Then {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} EncryptMetaData.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}
   */
  @Test
  @DisplayName("Test setEncryptMetaData(boolean); then PDCryptFilterDictionary() EncryptMetaData")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDCryptFilterDictionary#PDCryptFilterDictionary()} EncryptMetaData.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}
   */
  @Test
  @DisplayName("Test setEncryptMetaData(boolean); when 'false'; then not PDCryptFilterDictionary() EncryptMetaData")
  @Tag("MaintainedByDiffblue")
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
