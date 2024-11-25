package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDSeedValueCertificateDiffblueTest {
  /**
   * Test {@link PDSeedValueCertificate#PDSeedValueCertificate()}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   */
  @Test
  @DisplayName("Test new PDSeedValueCertificate()")
  void testNewPDSeedValueCertificate() {
    // Arrange and Act
    PDSeedValueCertificate actualPdSeedValueCertificate = new PDSeedValueCertificate();

    // Assert
    assertNull(actualPdSeedValueCertificate.getURL());
    assertNull(actualPdSeedValueCertificate.getURLType());
    assertNull(actualPdSeedValueCertificate.getIssuer());
    assertNull(actualPdSeedValueCertificate.getOID());
    assertNull(actualPdSeedValueCertificate.getSubject());
    assertNull(actualPdSeedValueCertificate.getKeyUsage());
    assertNull(actualPdSeedValueCertificate.getSubjectDN());
    COSDictionary cOSObject = actualPdSeedValueCertificate.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdSeedValueCertificate.isIssuerRequired());
    assertFalse(actualPdSeedValueCertificate.isKeyUsageRequired());
    assertFalse(actualPdSeedValueCertificate.isOIDRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectDNRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectRequired());
    assertFalse(actualPdSeedValueCertificate.isURLRequired());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Test {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return URL is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDSeedValueCertificate(COSDictionary); when COSDictionary(); then return URL is 'null'")
  void testNewPDSeedValueCertificate_whenCOSDictionary_thenReturnUrlIsNull() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDSeedValueCertificate actualPdSeedValueCertificate = new PDSeedValueCertificate(dict);

    // Assert
    assertNull(actualPdSeedValueCertificate.getURL());
    assertNull(actualPdSeedValueCertificate.getURLType());
    assertNull(actualPdSeedValueCertificate.getIssuer());
    assertNull(actualPdSeedValueCertificate.getOID());
    assertNull(actualPdSeedValueCertificate.getSubject());
    assertNull(actualPdSeedValueCertificate.getKeyUsage());
    assertNull(actualPdSeedValueCertificate.getSubjectDN());
    assertFalse(actualPdSeedValueCertificate.isIssuerRequired());
    assertFalse(actualPdSeedValueCertificate.isKeyUsageRequired());
    assertFalse(actualPdSeedValueCertificate.isOIDRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectDNRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectRequired());
    assertFalse(actualPdSeedValueCertificate.isURLRequired());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdSeedValueCertificate.getCOSObject());
  }

  /**
   * Test {@link PDSeedValueCertificate#getCOSObject()}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDSeedValueCertificate()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCOSObject.isDirect());
  }

  /**
   * Test {@link PDSeedValueCertificate#isSubjectRequired()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isSubjectRequired()}
   */
  @Test
  @DisplayName("Test isSubjectRequired(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testIsSubjectRequired_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate(new COSDictionary())).isSubjectRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isSubjectRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isSubjectRequired()}
   */
  @Test
  @DisplayName("Test isSubjectRequired(); given PDSeedValueCertificate(); then return 'false'")
  void testIsSubjectRequired_givenPDSeedValueCertificate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isSubjectRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isSubjectRequired()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isSubjectRequired()}
   */
  @Test
  @DisplayName("Test isSubjectRequired(); then return 'true'")
  void testIsSubjectRequired_thenReturnTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectRequired(boolean)}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectRequired(boolean)")
  void testSetSubjectRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.setSubjectRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectRequired(boolean)}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * IssuerRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectRequired(boolean); given PDSeedValueCertificate() IssuerRequired is 'true'")
  void testSetSubjectRequired_givenPDSeedValueCertificateIssuerRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setIssuerRequired(true);

    // Act
    pdSeedValueCertificate.setSubjectRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectRequired(boolean)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectRequired(boolean); then PDSeedValueCertificate() SubjectRequired")
  void testSetSubjectRequired_thenPDSeedValueCertificateSubjectRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectRequired(boolean); when 'false'; then not PDSeedValueCertificate() SubjectRequired")
  void testSetSubjectRequired_whenFalse_thenNotPDSeedValueCertificateSubjectRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isIssuerRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isIssuerRequired()}
   */
  @Test
  @DisplayName("Test isIssuerRequired(); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testIsIssuerRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isIssuerRequired()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isIssuerRequired()}
   */
  @Test
  @DisplayName("Test isIssuerRequired(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testIsIssuerRequired_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate(new COSDictionary())).isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isIssuerRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isIssuerRequired()}
   */
  @Test
  @DisplayName("Test isIssuerRequired(); given PDSeedValueCertificate(); then return 'false'")
  void testIsIssuerRequired_givenPDSeedValueCertificate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isIssuerRequired()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isIssuerRequired()}
   */
  @Test
  @DisplayName("Test isIssuerRequired(); then return 'true'")
  void testIsIssuerRequired_thenReturnTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setIssuerRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setIssuerRequired(boolean)}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setIssuerRequired(boolean)}
   */
  @Test
  @DisplayName("Test setIssuerRequired(boolean)")
  void testSetIssuerRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.setIssuerRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setIssuerRequired(boolean)}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setIssuerRequired(boolean)}
   */
  @Test
  @DisplayName("Test setIssuerRequired(boolean); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testSetIssuerRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setIssuerRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setIssuerRequired(boolean)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * IssuerRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setIssuerRequired(boolean)}
   */
  @Test
  @DisplayName("Test setIssuerRequired(boolean); then PDSeedValueCertificate() IssuerRequired")
  void testSetIssuerRequired_thenPDSeedValueCertificateIssuerRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setIssuerRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setIssuerRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * IssuerRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setIssuerRequired(boolean)}
   */
  @Test
  @DisplayName("Test setIssuerRequired(boolean); when 'false'; then not PDSeedValueCertificate() IssuerRequired")
  void testSetIssuerRequired_whenFalse_thenNotPDSeedValueCertificateIssuerRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setIssuerRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isOIDRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} OIDRequired
   * is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isOIDRequired()}
   */
  @Test
  @DisplayName("Test isOIDRequired(); given PDSeedValueCertificate() OIDRequired is 'true'; then return 'true'")
  void testIsOIDRequired_givenPDSeedValueCertificateOIDRequiredIsTrue_thenReturnTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setOIDRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isOIDRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isOIDRequired()}
   */
  @Test
  @DisplayName("Test isOIDRequired(); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testIsOIDRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isOIDRequired()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isOIDRequired()}
   */
  @Test
  @DisplayName("Test isOIDRequired(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testIsOIDRequired_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate(new COSDictionary())).isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isOIDRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isOIDRequired()}
   */
  @Test
  @DisplayName("Test isOIDRequired(); given PDSeedValueCertificate(); then return 'false'")
  void testIsOIDRequired_givenPDSeedValueCertificate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setOIDRequired(boolean)}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setOIDRequired(boolean)}
   */
  @Test
  @DisplayName("Test setOIDRequired(boolean)")
  void testSetOIDRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.setOIDRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setOIDRequired(boolean)}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setOIDRequired(boolean)}
   */
  @Test
  @DisplayName("Test setOIDRequired(boolean); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testSetOIDRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setOIDRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setOIDRequired(boolean)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * OIDRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setOIDRequired(boolean)}
   */
  @Test
  @DisplayName("Test setOIDRequired(boolean); then PDSeedValueCertificate() OIDRequired")
  void testSetOIDRequired_thenPDSeedValueCertificateOIDRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setOIDRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setOIDRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * OIDRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setOIDRequired(boolean)}
   */
  @Test
  @DisplayName("Test setOIDRequired(boolean); when 'false'; then not PDSeedValueCertificate() OIDRequired")
  void testSetOIDRequired_whenFalse_thenNotPDSeedValueCertificateOIDRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setOIDRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isSubjectDNRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isSubjectDNRequired()}
   */
  @Test
  @DisplayName("Test isSubjectDNRequired(); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testIsSubjectDNRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isSubjectDNRequired()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isSubjectDNRequired()}
   */
  @Test
  @DisplayName("Test isSubjectDNRequired(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testIsSubjectDNRequired_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate(new COSDictionary())).isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isSubjectDNRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isSubjectDNRequired()}
   */
  @Test
  @DisplayName("Test isSubjectDNRequired(); given PDSeedValueCertificate(); then return 'false'")
  void testIsSubjectDNRequired_givenPDSeedValueCertificate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isSubjectDNRequired()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isSubjectDNRequired()}
   */
  @Test
  @DisplayName("Test isSubjectDNRequired(); then return 'true'")
  void testIsSubjectDNRequired_thenReturnTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDNRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}.
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectDNRequired(boolean)")
  void testSetSubjectDNRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.setSubjectDNRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectDNRequired(boolean); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testSetSubjectDNRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setSubjectDNRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}.
   * <ul>
   *   <li>Then not {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectDNRequired.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectDNRequired(boolean); then not PDSeedValueCertificate() SubjectDNRequired")
  void testSetSubjectDNRequired_thenNotPDSeedValueCertificateSubjectDNRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectDNRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectDNRequired.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubjectDNRequired(boolean); then PDSeedValueCertificate() SubjectDNRequired")
  void testSetSubjectDNRequired_thenPDSeedValueCertificateSubjectDNRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectDNRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isKeyUsageRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isKeyUsageRequired()}
   */
  @Test
  @DisplayName("Test isKeyUsageRequired(); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testIsKeyUsageRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isKeyUsageRequired()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isKeyUsageRequired()}
   */
  @Test
  @DisplayName("Test isKeyUsageRequired(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testIsKeyUsageRequired_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate(new COSDictionary())).isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isKeyUsageRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isKeyUsageRequired()}
   */
  @Test
  @DisplayName("Test isKeyUsageRequired(); given PDSeedValueCertificate(); then return 'false'")
  void testIsKeyUsageRequired_givenPDSeedValueCertificate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isKeyUsageRequired()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isKeyUsageRequired()}
   */
  @Test
  @DisplayName("Test isKeyUsageRequired(); then return 'true'")
  void testIsKeyUsageRequired_thenReturnTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setKeyUsageRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}.
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}
   */
  @Test
  @DisplayName("Test setKeyUsageRequired(boolean)")
  void testSetKeyUsageRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.setKeyUsageRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}
   */
  @Test
  @DisplayName("Test setKeyUsageRequired(boolean); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testSetKeyUsageRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setKeyUsageRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * KeyUsageRequired.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}
   */
  @Test
  @DisplayName("Test setKeyUsageRequired(boolean); then PDSeedValueCertificate() KeyUsageRequired")
  void testSetKeyUsageRequired_thenPDSeedValueCertificateKeyUsageRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setKeyUsageRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * KeyUsageRequired.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}
   */
  @Test
  @DisplayName("Test setKeyUsageRequired(boolean); when 'false'; then not PDSeedValueCertificate() KeyUsageRequired")
  void testSetKeyUsageRequired_whenFalse_thenNotPDSeedValueCertificateKeyUsageRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setKeyUsageRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isURLRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isURLRequired()}
   */
  @Test
  @DisplayName("Test isURLRequired(); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testIsURLRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isURLRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} URLRequired
   * is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isURLRequired()}
   */
  @Test
  @DisplayName("Test isURLRequired(); given PDSeedValueCertificate() URLRequired is 'true'; then return 'true'")
  void testIsURLRequired_givenPDSeedValueCertificateURLRequiredIsTrue_thenReturnTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURLRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isURLRequired()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isURLRequired()}
   */
  @Test
  @DisplayName("Test isURLRequired(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testIsURLRequired_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate(new COSDictionary())).isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#isURLRequired()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#isURLRequired()}
   */
  @Test
  @DisplayName("Test isURLRequired(); given PDSeedValueCertificate(); then return 'false'")
  void testIsURLRequired_givenPDSeedValueCertificate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setURLRequired(boolean)}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setURLRequired(boolean)}
   */
  @Test
  @DisplayName("Test setURLRequired(boolean)")
  void testSetURLRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.setURLRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setURLRequired(boolean)}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * SubjectRequired is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setURLRequired(boolean)}
   */
  @Test
  @DisplayName("Test setURLRequired(boolean); given PDSeedValueCertificate() SubjectRequired is 'true'")
  void testSetURLRequired_givenPDSeedValueCertificateSubjectRequiredIsTrue() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setURLRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setURLRequired(boolean)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * URLRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setURLRequired(boolean)}
   */
  @Test
  @DisplayName("Test setURLRequired(boolean); then PDSeedValueCertificate() URLRequired")
  void testSetURLRequired_thenPDSeedValueCertificateURLRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#setURLRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   * URLRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setURLRequired(boolean)}
   */
  @Test
  @DisplayName("Test setURLRequired(boolean); when 'false'; then not PDSeedValueCertificate() URLRequired")
  void testSetURLRequired_whenFalse_thenNotPDSeedValueCertificateURLRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Test {@link PDSeedValueCertificate#getSubject()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetSubject_givenPDSeedValueCertificateWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate(new COSDictionary())).getSubject());
  }

  /**
   * Test {@link PDSeedValueCertificate#getSubject()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); given PDSeedValueCertificate(); then return 'null'")
  void testGetSubject_givenPDSeedValueCertificate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getSubject());
  }

  /**
   * Test {@link PDSeedValueCertificate#getSubject()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); then return size is one")
  void testGetSubject_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<byte[]> actualSubject = pdSeedValueCertificate.getSubject();

    // Assert
    assertEquals(1, actualSubject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSubject.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubject(List)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Subject size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubject(List)}
   */
  @Test
  @DisplayName("Test setSubject(List); given 'A'; then PDSeedValueCertificate() Subject size is one")
  void testSetSubject_givenA_thenPDSeedValueCertificateSubjectSizeIsOne() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> subjects = new ArrayList<>();
    subjects.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setSubject(subjects);

    // Assert
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(1, subject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, subject.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubject(List)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Subject size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubject(List)}
   */
  @Test
  @DisplayName("Test setSubject(List); given 'A'; then PDSeedValueCertificate() Subject size is two")
  void testSetSubject_givenA_thenPDSeedValueCertificateSubjectSizeIsTwo() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> subjects = new ArrayList<>();
    subjects.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    subjects.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setSubject(subjects);

    // Assert
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(2, subject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, subject.get(1));
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubject(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubject(List)}
   */
  @Test
  @DisplayName("Test setSubject(List); when ArrayList(); then PDSeedValueCertificate() COSObject Values size is two")
  void testSetSubject_whenArrayList_thenPDSeedValueCertificateCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubject(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getSubject().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#addSubject(byte[])}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addSubject(byte[])}
   */
  @Test
  @DisplayName("Test addSubject(byte[])")
  void testAddSubject() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(1, subject.size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), subject.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#addSubject(byte[])}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Subject size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addSubject(byte[])}
   */
  @Test
  @DisplayName("Test addSubject(byte[]); given 'A'; then PDSeedValueCertificate() Subject size is two")
  void testAddSubject_givenA_thenPDSeedValueCertificateSubjectSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(2, subject.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), subject.get(1));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, subject.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#addSubject(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Subject size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addSubject(byte[])}
   */
  @Test
  @DisplayName("Test addSubject(byte[]); then PDSeedValueCertificate() Subject size is one")
  void testAddSubject_thenPDSeedValueCertificateSubjectSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(1, subject.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), subject.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#removeSubject(byte[])}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  @DisplayName("Test removeSubject(byte[])")
  void testRemoveSubject() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeSubject(byte[])}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  @DisplayName("Test removeSubject(byte[])")
  void testRemoveSubject2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{-2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeSubject(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addSubject
   * array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  @DisplayName("Test removeSubject(byte[]); given PDSeedValueCertificate() addSubject array of byte with 'A' and one")
  void testRemoveSubject_givenPDSeedValueCertificateAddSubjectArrayOfByteWithAAndOne()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeSubject(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addSubject
   * array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  @DisplayName("Test removeSubject(byte[]); given PDSeedValueCertificate() addSubject array of byte with one and 'X'")
  void testRemoveSubject_givenPDSeedValueCertificateAddSubjectArrayOfByteWithOneAndX()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeSubject(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Subject
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  @DisplayName("Test removeSubject(byte[]); then PDSeedValueCertificate() Subject Empty")
  void testRemoveSubject_thenPDSeedValueCertificateSubjectEmpty() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(pdSeedValueCertificate.getSubject().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeSubject(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Subject is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  @DisplayName("Test removeSubject(byte[]); then PDSeedValueCertificate() Subject is 'null'")
  void testRemoveSubject_thenPDSeedValueCertificateSubjectIsNull() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getSubject());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeSubject(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()} Subject is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  @DisplayName("Test removeSubject(byte[]); then PDSeedValueCertificate(COSDictionary) with dict is COSDictionary() Subject is 'null'")
  void testRemoveSubject_thenPDSeedValueCertificateWithDictIsCOSDictionarySubjectIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getSubject());
  }

  /**
   * Test {@link PDSeedValueCertificate#getSubjectDN()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link HashMap#HashMap()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  @DisplayName("Test getSubjectDN(); given ArrayList() add HashMap(); then return size is one")
  void testGetSubjectDN_givenArrayListAddHashMap_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(new HashMap<>());

    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Act
    List<Map<String, String>> actualSubjectDN = pdSeedValueCertificate.getSubjectDN();

    // Assert
    assertEquals(1, actualSubjectDN.size());
    assertTrue(actualSubjectDN.get(0).isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#getSubjectDN()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} SubjectDN
   * is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  @DisplayName("Test getSubjectDN(); given PDSeedValueCertificate() SubjectDN is ArrayList(); then return Empty")
  void testGetSubjectDN_givenPDSeedValueCertificateSubjectDNIsArrayList_thenReturnEmpty() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDN(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValueCertificate.getSubjectDN().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#getSubjectDN()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  @DisplayName("Test getSubjectDN(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testGetSubjectDN_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate(new COSDictionary())).getSubjectDN());
  }

  /**
   * Test {@link PDSeedValueCertificate#getSubjectDN()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  @DisplayName("Test getSubjectDN(); given PDSeedValueCertificate(); then return 'null'")
  void testGetSubjectDN_givenPDSeedValueCertificate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getSubjectDN());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDN(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} SubjectDN
   * first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  @DisplayName("Test setSubjectDN(List); given HashMap(); then PDSeedValueCertificate() SubjectDN first Empty")
  void testSetSubjectDN_givenHashMap_thenPDSeedValueCertificateSubjectDNFirstEmpty() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(new HashMap<>());

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    List<Map<String, String>> subjectDN2 = pdSeedValueCertificate.getSubjectDN();
    assertEquals(1, subjectDN2.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(subjectDN2.get(0).isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDN(List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} SubjectDN is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  @DisplayName("Test setSubjectDN(List); given HashMap(); then PDSeedValueCertificate() SubjectDN is ArrayList()")
  void testSetSubjectDN_givenHashMap_thenPDSeedValueCertificateSubjectDNIsArrayList() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(new HashMap<>());
    subjectDN.add(new HashMap<>());

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDN(List)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} SubjectDN
   * first is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  @DisplayName("Test setSubjectDN(List); then PDSeedValueCertificate() SubjectDN first is HashMap()")
  void testSetSubjectDN_thenPDSeedValueCertificateSubjectDNFirstIsHashMap() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "42");
    stringStringMap.put("foo", "foo");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    List<Map<String, String>> subjectDN2 = pdSeedValueCertificate.getSubjectDN();
    assertEquals(1, subjectDN2.size());
    assertEquals(stringStringMap, subjectDN2.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDN(List)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} SubjectDN
   * first size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  @DisplayName("Test setSubjectDN(List); then PDSeedValueCertificate() SubjectDN first size is one")
  void testSetSubjectDN_thenPDSeedValueCertificateSubjectDNFirstSizeIsOne() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    List<Map<String, String>> subjectDN2 = pdSeedValueCertificate.getSubjectDN();
    assertEquals(1, subjectDN2.size());
    Map<String, String> getResult = subjectDN2.get(0);
    assertEquals(1, getResult.size());
    assertEquals("foo", getResult.get("foo"));
  }

  /**
   * Test {@link PDSeedValueCertificate#setSubjectDN(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} SubjectDN
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  @DisplayName("Test setSubjectDN(List); when ArrayList(); then PDSeedValueCertificate() SubjectDN Empty")
  void testSetSubjectDN_whenArrayList_thenPDSeedValueCertificateSubjectDNEmpty() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectDN(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getSubjectDN().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#getKeyUsage()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getKeyUsage()}
   */
  @Test
  @DisplayName("Test getKeyUsage(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary()")
  void testGetKeyUsage_givenPDSeedValueCertificateWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate(new COSDictionary())).getKeyUsage());
  }

  /**
   * Test {@link PDSeedValueCertificate#getKeyUsage()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getKeyUsage()}
   */
  @Test
  @DisplayName("Test getKeyUsage(); given PDSeedValueCertificate(); then return 'null'")
  void testGetKeyUsage_givenPDSeedValueCertificate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getKeyUsage());
  }

  /**
   * Test {@link PDSeedValueCertificate#getKeyUsage()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getKeyUsage()}
   */
  @Test
  @DisplayName("Test getKeyUsage(); then return size is one")
  void testGetKeyUsage_thenReturnSizeIsOne() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addKeyUsage("");

    // Act
    List<String> actualKeyUsage = pdSeedValueCertificate.getKeyUsage();

    // Assert
    assertEquals(1, actualKeyUsage.size());
    assertEquals("", actualKeyUsage.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setKeyUsage(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setKeyUsage(List)}
   */
  @Test
  @DisplayName("Test setKeyUsage(List); given '42'; when ArrayList() add '42'")
  void testSetKeyUsage_given42_whenArrayListAdd42() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<String> keyUsageExtensions = new ArrayList<>();
    keyUsageExtensions.add("42");
    keyUsageExtensions.add("foo");

    // Act
    pdSeedValueCertificate.setKeyUsage(keyUsageExtensions);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(keyUsageExtensions, pdSeedValueCertificate.getKeyUsage());
  }

  /**
   * Test {@link PDSeedValueCertificate#setKeyUsage(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} KeyUsage is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setKeyUsage(List)}
   */
  @Test
  @DisplayName("Test setKeyUsage(List); given 'foo'; then PDSeedValueCertificate() KeyUsage is ArrayList()")
  void testSetKeyUsage_givenFoo_thenPDSeedValueCertificateKeyUsageIsArrayList() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<String> keyUsageExtensions = new ArrayList<>();
    keyUsageExtensions.add("foo");

    // Act
    pdSeedValueCertificate.setKeyUsage(keyUsageExtensions);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(keyUsageExtensions, pdSeedValueCertificate.getKeyUsage());
  }

  /**
   * Test {@link PDSeedValueCertificate#setKeyUsage(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} KeyUsage
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setKeyUsage(List)}
   */
  @Test
  @DisplayName("Test setKeyUsage(List); when ArrayList(); then PDSeedValueCertificate() KeyUsage Empty")
  void testSetKeyUsage_whenArrayList_thenPDSeedValueCertificateKeyUsageEmpty() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setKeyUsage(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getKeyUsage().isEmpty());
  }

  /**
   * Test
   * {@link PDSeedValueCertificate#addKeyUsage(char, char, char, char, char, char, char, char, char)}
   * with {@code digitalSignature}, {@code nonRepudiation},
   * {@code keyEncipherment}, {@code dataEncipherment}, {@code keyAgreement},
   * {@code keyCertSign}, {@code cRLSign}, {@code encipherOnly},
   * {@code decipherOnly}.
   * <p>
   * Method under test:
   * {@link PDSeedValueCertificate#addKeyUsage(char, char, char, char, char, char, char, char, char)}
   */
  @Test
  @DisplayName("Test addKeyUsage(char, char, char, char, char, char, char, char, char) with 'digitalSignature', 'nonRepudiation', 'keyEncipherment', 'dataEncipherment', 'keyAgreement', 'keyCertSign', 'cRLSign', 'encipherOnly', 'decipherOnly'")
  void testAddKeyUsageWithDigitalSignatureNonRepudiationKeyEnciphermentDataEnciphermentKeyAgreementKeyCertSignCRLSignEncipherOnlyDecipherOnly() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDSeedValueCertificate()).addKeyUsage('A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'));
    assertThrows(IllegalArgumentException.class,
        () -> (new PDSeedValueCertificate()).addKeyUsage('1', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'));
  }

  /**
   * Test {@link PDSeedValueCertificate#addKeyUsage(String)} with
   * {@code keyUsageExtension}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addKeyUsage(String)}
   */
  @Test
  @DisplayName("Test addKeyUsage(String) with 'keyUsageExtension'")
  void testAddKeyUsageWithKeyUsageExtension() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.addKeyUsage("01X");

    // Assert
    List<String> keyUsage = pdSeedValueCertificate.getKeyUsage();
    assertEquals(1, keyUsage.size());
    assertEquals("01X", keyUsage.get(0));
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValueCertificate#addKeyUsage(String)} with
   * {@code keyUsageExtension}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} KeyUsage
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addKeyUsage(String)}
   */
  @Test
  @DisplayName("Test addKeyUsage(String) with 'keyUsageExtension'; then PDSeedValueCertificate() KeyUsage size is one")
  void testAddKeyUsageWithKeyUsageExtension_thenPDSeedValueCertificateKeyUsageSizeIsOne() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addKeyUsage("01X");

    // Assert
    List<String> keyUsage = pdSeedValueCertificate.getKeyUsage();
    assertEquals(1, keyUsage.size());
    assertEquals("01X", keyUsage.get(0));
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValueCertificate#addKeyUsage(String)} with
   * {@code keyUsageExtension}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} KeyUsage
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addKeyUsage(String)}
   */
  @Test
  @DisplayName("Test addKeyUsage(String) with 'keyUsageExtension'; then PDSeedValueCertificate() KeyUsage size is two")
  void testAddKeyUsageWithKeyUsageExtension_thenPDSeedValueCertificateKeyUsageSizeIsTwo() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addKeyUsage("");

    // Act
    pdSeedValueCertificate.addKeyUsage("01X");

    // Assert
    List<String> keyUsage = pdSeedValueCertificate.getKeyUsage();
    assertEquals(2, keyUsage.size());
    assertEquals("01X", keyUsage.get(1));
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValueCertificate#addKeyUsage(String)} with
   * {@code keyUsageExtension}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addKeyUsage(String)}
   */
  @Test
  @DisplayName("Test addKeyUsage(String) with 'keyUsageExtension'; then throw IllegalArgumentException")
  void testAddKeyUsageWithKeyUsageExtension_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDSeedValueCertificate()).addKeyUsage("Key Usage Extension"));
  }

  /**
   * Test {@link PDSeedValueCertificate#removeKeyUsage(String)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add
   * {@link PDSignature#FILTER_ADOBE_PPKLITE}.</li>
   *   <li>Then calls {@link COSBase#setDirect(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeKeyUsage(String)}
   */
  @Test
  @DisplayName("Test removeKeyUsage(String); given COSArray() add FILTER_ADOBE_PPKLITE; then calls setDirect(boolean)")
  void testRemoveKeyUsage_givenCOSArrayAddFilter_adobe_ppklite_thenCallsSetDirect() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(PDSignature.FILTER_ADOBE_PPKLITE);
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(dict).setDirect(anyBoolean());

    // Act
    (new PDSeedValueCertificate(dict)).removeKeyUsage("Key Usage Extension");

    // Assert
    verify(dict).setDirect(eq(true));
    verify(dict).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDSeedValueCertificate#removeKeyUsage(String)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#remove(COSBase)} return
   * {@code true}.</li>
   *   <li>Then calls {@link COSArray#remove(COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeKeyUsage(String)}
   */
  @Test
  @DisplayName("Test removeKeyUsage(String); given COSArray remove(COSBase) return 'true'; then calls remove(COSBase)")
  void testRemoveKeyUsage_givenCOSArrayRemoveReturnTrue_thenCallsRemove() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(dict).setDirect(anyBoolean());

    // Act
    (new PDSeedValueCertificate(dict)).removeKeyUsage("Key Usage Extension");

    // Assert
    verify(cosArray).remove(isA(COSBase.class));
    verify(dict).setDirect(eq(true));
    verify(dict).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDSeedValueCertificate#removeKeyUsage(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeKeyUsage(String)}
   */
  @Test
  @DisplayName("Test removeKeyUsage(String); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testRemoveKeyUsage_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(dict).setDirect(anyBoolean());

    // Act
    (new PDSeedValueCertificate(dict)).removeKeyUsage("Key Usage Extension");

    // Assert
    verify(dict).setDirect(eq(true));
    verify(dict).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDSeedValueCertificate#removeKeyUsage(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeKeyUsage(String)}
   */
  @Test
  @DisplayName("Test removeKeyUsage(String); then throw IllegalArgumentException")
  void testRemoveKeyUsage_thenThrowIllegalArgumentException() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenThrow(new IllegalArgumentException("foo"));
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(dict).setDirect(anyBoolean());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDSeedValueCertificate(dict)).removeKeyUsage("Key Usage Extension"));
    verify(cosArray).remove(isA(COSBase.class));
    verify(dict).setDirect(eq(true));
    verify(dict).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDSeedValueCertificate#getIssuer()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getIssuer()}
   */
  @Test
  @DisplayName("Test getIssuer(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetIssuer_givenPDSeedValueCertificateWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate(new COSDictionary())).getIssuer());
  }

  /**
   * Test {@link PDSeedValueCertificate#getIssuer()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getIssuer()}
   */
  @Test
  @DisplayName("Test getIssuer(); given PDSeedValueCertificate(); then return 'null'")
  void testGetIssuer_givenPDSeedValueCertificate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getIssuer());
  }

  /**
   * Test {@link PDSeedValueCertificate#getIssuer()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getIssuer()}
   */
  @Test
  @DisplayName("Test getIssuer(); then return size is one")
  void testGetIssuer_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<byte[]> actualIssuer = pdSeedValueCertificate.getIssuer();

    // Assert
    assertEquals(1, actualIssuer.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualIssuer.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setIssuer(List)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Issuer size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setIssuer(List)}
   */
  @Test
  @DisplayName("Test setIssuer(List); given 'A'; then PDSeedValueCertificate() Issuer size is one")
  void testSetIssuer_givenA_thenPDSeedValueCertificateIssuerSizeIsOne() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> issuers = new ArrayList<>();
    issuers.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setIssuer(issuers);

    // Assert
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(1, issuer.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, issuer.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setIssuer(List)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Issuer size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setIssuer(List)}
   */
  @Test
  @DisplayName("Test setIssuer(List); given 'A'; then PDSeedValueCertificate() Issuer size is two")
  void testSetIssuer_givenA_thenPDSeedValueCertificateIssuerSizeIsTwo() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> issuers = new ArrayList<>();
    issuers.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    issuers.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setIssuer(issuers);

    // Assert
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(2, issuer.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, issuer.get(1));
  }

  /**
   * Test {@link PDSeedValueCertificate#setIssuer(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setIssuer(List)}
   */
  @Test
  @DisplayName("Test setIssuer(List); when ArrayList(); then PDSeedValueCertificate() COSObject Values size is two")
  void testSetIssuer_whenArrayList_thenPDSeedValueCertificateCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setIssuer(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getIssuer().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#addIssuer(byte[])}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addIssuer(byte[])}
   */
  @Test
  @DisplayName("Test addIssuer(byte[])")
  void testAddIssuer() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(1, issuer.size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), issuer.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#addIssuer(byte[])}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Issuer size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addIssuer(byte[])}
   */
  @Test
  @DisplayName("Test addIssuer(byte[]); given 'A'; then PDSeedValueCertificate() Issuer size is two")
  void testAddIssuer_givenA_thenPDSeedValueCertificateIssuerSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(2, issuer.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), issuer.get(1));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, issuer.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#addIssuer(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Issuer size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addIssuer(byte[])}
   */
  @Test
  @DisplayName("Test addIssuer(byte[]); then PDSeedValueCertificate() Issuer size is one")
  void testAddIssuer_thenPDSeedValueCertificateIssuerSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(1, issuer.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), issuer.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#removeIssuer(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addIssuer
   * array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  @DisplayName("Test removeIssuer(byte[]); given PDSeedValueCertificate() addIssuer array of byte with 'A' and one")
  void testRemoveIssuer_givenPDSeedValueCertificateAddIssuerArrayOfByteWithAAndOne()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeIssuer(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addIssuer
   * array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  @DisplayName("Test removeIssuer(byte[]); given PDSeedValueCertificate() addIssuer array of byte with minus one and 'X'")
  void testRemoveIssuer_givenPDSeedValueCertificateAddIssuerArrayOfByteWithMinusOneAndX()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeIssuer(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addIssuer
   * array of {@code byte} with minus two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  @DisplayName("Test removeIssuer(byte[]); given PDSeedValueCertificate() addIssuer array of byte with minus two and 'X'")
  void testRemoveIssuer_givenPDSeedValueCertificateAddIssuerArrayOfByteWithMinusTwoAndX()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{-2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeIssuer(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addIssuer
   * array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  @DisplayName("Test removeIssuer(byte[]); given PDSeedValueCertificate() addIssuer array of byte with one and 'X'")
  void testRemoveIssuer_givenPDSeedValueCertificateAddIssuerArrayOfByteWithOneAndX()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeIssuer(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Issuer
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  @DisplayName("Test removeIssuer(byte[]); then PDSeedValueCertificate() Issuer Empty")
  void testRemoveIssuer_thenPDSeedValueCertificateIssuerEmpty() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(pdSeedValueCertificate.getIssuer().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeIssuer(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} Issuer is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  @DisplayName("Test removeIssuer(byte[]); then PDSeedValueCertificate() Issuer is 'null'")
  void testRemoveIssuer_thenPDSeedValueCertificateIssuerIsNull() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getIssuer());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeIssuer(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()} Issuer is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  @DisplayName("Test removeIssuer(byte[]); then PDSeedValueCertificate(COSDictionary) with dict is COSDictionary() Issuer is 'null'")
  void testRemoveIssuer_thenPDSeedValueCertificateWithDictIsCOSDictionaryIssuerIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getIssuer());
  }

  /**
   * Test {@link PDSeedValueCertificate#getOID()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getOID()}
   */
  @Test
  @DisplayName("Test getOID(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetOID_givenPDSeedValueCertificateWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate(new COSDictionary())).getOID());
  }

  /**
   * Test {@link PDSeedValueCertificate#getOID()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getOID()}
   */
  @Test
  @DisplayName("Test getOID(); given PDSeedValueCertificate(); then return 'null'")
  void testGetOID_givenPDSeedValueCertificate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getOID());
  }

  /**
   * Test {@link PDSeedValueCertificate#getOID()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getOID()}
   */
  @Test
  @DisplayName("Test getOID(); then return size is one")
  void testGetOID_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<byte[]> actualOID = pdSeedValueCertificate.getOID();

    // Assert
    assertEquals(1, actualOID.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOID.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setOID(List)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} OID size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setOID(List)}
   */
  @Test
  @DisplayName("Test setOID(List); given 'A'; then PDSeedValueCertificate() OID size is one")
  void testSetOID_givenA_thenPDSeedValueCertificateOidSizeIsOne() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> oidByteStrings = new ArrayList<>();
    oidByteStrings.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setOID(oidByteStrings);

    // Assert
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(1, oID.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, oID.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#setOID(List)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} OID size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setOID(List)}
   */
  @Test
  @DisplayName("Test setOID(List); given 'A'; then PDSeedValueCertificate() OID size is two")
  void testSetOID_givenA_thenPDSeedValueCertificateOidSizeIsTwo() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> oidByteStrings = new ArrayList<>();
    oidByteStrings.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    oidByteStrings.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setOID(oidByteStrings);

    // Assert
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(2, oID.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, oID.get(1));
  }

  /**
   * Test {@link PDSeedValueCertificate#setOID(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setOID(List)}
   */
  @Test
  @DisplayName("Test setOID(List); when ArrayList(); then PDSeedValueCertificate() COSObject Values size is two")
  void testSetOID_whenArrayList_thenPDSeedValueCertificateCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setOID(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getOID().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#addOID(byte[])}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addOID(byte[])}
   */
  @Test
  @DisplayName("Test addOID(byte[])")
  void testAddOID() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(1, oID.size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), oID.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#addOID(byte[])}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} OID size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addOID(byte[])}
   */
  @Test
  @DisplayName("Test addOID(byte[]); given 'A'; then PDSeedValueCertificate() OID size is two")
  void testAddOID_givenA_thenPDSeedValueCertificateOidSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(2, oID.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), oID.get(1));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, oID.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#addOID(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} OID size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#addOID(byte[])}
   */
  @Test
  @DisplayName("Test addOID(byte[]); given PDSeedValueCertificate(); then PDSeedValueCertificate() OID size is one")
  void testAddOID_givenPDSeedValueCertificate_thenPDSeedValueCertificateOidSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(1, oID.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), oID.get(0));
  }

  /**
   * Test {@link PDSeedValueCertificate#removeOID(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addOID
   * array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  @DisplayName("Test removeOID(byte[]); given PDSeedValueCertificate() addOID array of byte with 'A' and one")
  void testRemoveOID_givenPDSeedValueCertificateAddOIDArrayOfByteWithAAndOne() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeOID(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addOID
   * array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  @DisplayName("Test removeOID(byte[]); given PDSeedValueCertificate() addOID array of byte with minus one and 'X'")
  void testRemoveOID_givenPDSeedValueCertificateAddOIDArrayOfByteWithMinusOneAndX()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeOID(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addOID
   * array of {@code byte} with minus two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  @DisplayName("Test removeOID(byte[]); given PDSeedValueCertificate() addOID array of byte with minus two and 'X'")
  void testRemoveOID_givenPDSeedValueCertificateAddOIDArrayOfByteWithMinusTwoAndX()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{-2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeOID(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} addOID
   * array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  @DisplayName("Test removeOID(byte[]); given PDSeedValueCertificate() addOID array of byte with one and 'X'")
  void testRemoveOID_givenPDSeedValueCertificateAddOIDArrayOfByteWithOneAndX() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeOID(byte[])}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} OID is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  @DisplayName("Test removeOID(byte[]); given PDSeedValueCertificate(); then PDSeedValueCertificate() OID is 'null'")
  void testRemoveOID_givenPDSeedValueCertificate_thenPDSeedValueCertificateOidIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getOID());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeOID(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} OID
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  @DisplayName("Test removeOID(byte[]); then PDSeedValueCertificate() OID Empty")
  void testRemoveOID_thenPDSeedValueCertificateOidEmpty() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(pdSeedValueCertificate.getOID().isEmpty());
  }

  /**
   * Test {@link PDSeedValueCertificate#removeOID(byte[])}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()} OID is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  @DisplayName("Test removeOID(byte[]); then PDSeedValueCertificate(COSDictionary) with dict is COSDictionary() OID is 'null'")
  void testRemoveOID_thenPDSeedValueCertificateWithDictIsCOSDictionaryOidIsNull() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate(new COSDictionary());

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getOID());
  }

  /**
   * Test {@link PDSeedValueCertificate#getURL()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()} URL is
   * empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); given PDSeedValueCertificate() URL is empty string; then return empty string")
  void testGetURL_givenPDSeedValueCertificateUrlIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURL("");

    // Act and Assert
    assertEquals("", pdSeedValueCertificate.getURL());
  }

  /**
   * Test {@link PDSeedValueCertificate#getURL()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetURL_givenPDSeedValueCertificateWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate(new COSDictionary())).getURL());
  }

  /**
   * Test {@link PDSeedValueCertificate#getURL()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); given PDSeedValueCertificate(); then return 'null'")
  void testGetURL_givenPDSeedValueCertificate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getURL());
  }

  /**
   * Test {@link PDSeedValueCertificate#getURL()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getURL()}
   */
  @Test
  @DisplayName("Test getURL(); then return 'https://example.org/example'")
  void testGetURL_thenReturnHttpsExampleOrgExample() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURL());
  }

  /**
   * Test {@link PDSeedValueCertificate#setURL(String)}.
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setURL(String)}
   */
  @Test
  @DisplayName("Test setURL(String)")
  void testSetURL() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURL());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValueCertificate#getURLType()}.
   * <ul>
   *   <li>Given
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)} with
   * dict is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getURLType()}
   */
  @Test
  @DisplayName("Test getURLType(); given PDSeedValueCertificate(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetURLType_givenPDSeedValueCertificateWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate(new COSDictionary())).getURLType());
  }

  /**
   * Test {@link PDSeedValueCertificate#getURLType()}.
   * <ul>
   *   <li>Given {@link PDSeedValueCertificate#PDSeedValueCertificate()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getURLType()}
   */
  @Test
  @DisplayName("Test getURLType(); given PDSeedValueCertificate(); then return 'null'")
  void testGetURLType_givenPDSeedValueCertificate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getURLType());
  }

  /**
   * Test {@link PDSeedValueCertificate#getURLType()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#getURLType()}
   */
  @Test
  @DisplayName("Test getURLType(); then return 'https://example.org/example'")
  void testGetURLType_thenReturnHttpsExampleOrgExample() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURLType("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURLType());
  }

  /**
   * Test {@link PDSeedValueCertificate#setURLType(String)}.
   * <ul>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} URLType is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setURLType(String)}
   */
  @Test
  @DisplayName("Test setURLType(String); then PDSeedValueCertificate() URLType is 'https://example.org/example'")
  void testSetURLType_thenPDSeedValueCertificateURLTypeIsHttpsExampleOrgExample() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLType("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURLType());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValueCertificate#setURLType(String)}.
   * <ul>
   *   <li>When {@code Url Type}.</li>
   *   <li>Then {@link PDSeedValueCertificate#PDSeedValueCertificate()} URLType is
   * {@code Url Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValueCertificate#setURLType(String)}
   */
  @Test
  @DisplayName("Test setURLType(String); when 'Url Type'; then PDSeedValueCertificate() URLType is 'Url Type'")
  void testSetURLType_whenUrlType_thenPDSeedValueCertificateURLTypeIsUrlType() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLType("Url Type");

    // Assert
    assertEquals("Url Type", pdSeedValueCertificate.getURLType());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
