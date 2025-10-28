package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDSeedValueDiffblueTest {
  /**
   * Method under test: {@link PDSeedValue#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDSeedValue()).getCOSObject();

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
   * Method under test: {@link PDSeedValue#isFilterRequired()}
   */
  @Test
  void testIsFilterRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isFilterRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setFilterRequired(boolean)}
   */
  @Test
  void testSetFilterRequired() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setFilterRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.isFilterRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setFilterRequired(boolean)}
   */
  @Test
  void testSetFilterRequired2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setFilterRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValue.isFilterRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#isSubFilterRequired()}
   */
  @Test
  void testIsSubFilterRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isSubFilterRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setSubFilterRequired(boolean)}
   */
  @Test
  void testSetSubFilterRequired() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setSubFilterRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.isSubFilterRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setSubFilterRequired(boolean)}
   */
  @Test
  void testSetSubFilterRequired2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setSubFilterRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValue.isSubFilterRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#isDigestMethodRequired()}
   */
  @Test
  void testIsDigestMethodRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isDigestMethodRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setDigestMethodRequired(boolean)}
   */
  @Test
  void testSetDigestMethodRequired() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setDigestMethodRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.isDigestMethodRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setDigestMethodRequired(boolean)}
   */
  @Test
  void testSetDigestMethodRequired2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setDigestMethodRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValue.isDigestMethodRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#isVRequired()}
   */
  @Test
  void testIsVRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isVRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setVRequired(boolean)}
   */
  @Test
  void testSetVRequired() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setVRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.isVRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setVRequired(boolean)}
   */
  @Test
  void testSetVRequired2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setVRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValue.isVRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#isReasonRequired()}
   */
  @Test
  void testIsReasonRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isReasonRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setReasonRequired(boolean)}
   */
  @Test
  void testSetReasonRequired() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setReasonRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.isReasonRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setReasonRequired(boolean)}
   */
  @Test
  void testSetReasonRequired2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setReasonRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValue.isReasonRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#isLegalAttestationRequired()}
   */
  @Test
  void testIsLegalAttestationRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isLegalAttestationRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setLegalAttestationRequired(boolean)}
   */
  @Test
  void testSetLegalAttestationRequired() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setLegalAttestationRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.isLegalAttestationRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setLegalAttestationRequired(boolean)}
   */
  @Test
  void testSetLegalAttestationRequired2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setLegalAttestationRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValue.isLegalAttestationRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#isAddRevInfoRequired()}
   */
  @Test
  void testIsAddRevInfoRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isAddRevInfoRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setAddRevInfoRequired(boolean)}
   */
  @Test
  void testSetAddRevInfoRequired() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setAddRevInfoRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.isAddRevInfoRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setAddRevInfoRequired(boolean)}
   */
  @Test
  void testSetAddRevInfoRequired2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setAddRevInfoRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValue.isAddRevInfoRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#getFilter()}
   */
  @Test
  void testGetFilter() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getFilter());
  }

  /**
   * Method under test: {@link PDSeedValue#getFilter()}
   */
  @Test
  void testGetFilter2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSeedValue.getFilter());
  }

  /**
   * Method under test: {@link PDSeedValue#setFilter(COSName)}
   */
  @Test
  void testSetFilter() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Assert
    assertEquals("Adobe.PPKLite", pdSeedValue.getFilter());
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#setFilter(COSName)}
   */
  @Test
  void testSetFilter2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setFilter(null);

    // Assert
    assertNull(pdSeedValue.getFilter());
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  void testGetSubFilter() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getSubFilter().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  void testGetSubFilter2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setSubFilter(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getSubFilter().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  void testGetSubFilter3() {
    // Arrange
    ArrayList<String> subfilter = new ArrayList<>();
    subfilter.add("foo");

    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setSubFilter(subfilter);

    // Act
    List<String> actualSubFilter = pdSeedValue.getSubFilter();

    // Assert
    assertEquals(1, actualSubFilter.size());
    assertEquals("foo", actualSubFilter.get(0));
  }

  /**
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  void testGetSubFilter4() {
    // Arrange
    ArrayList<String> subfilter = new ArrayList<>();
    subfilter.add("42");
    subfilter.add("foo");

    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setSubFilter(subfilter);

    // Act and Assert
    assertEquals(subfilter, pdSeedValue.getSubFilter());
  }

  /**
   * Method under test: {@link PDSeedValue#setSubFilter(List)}
   */
  @Test
  void testSetSubFilter() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setSubFilter(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.getSubFilter().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#setSubFilter(List)}
   */
  @Test
  void testSetSubFilter2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> subfilter = new ArrayList<>();
    subfilter.add("foo");

    // Act
    pdSeedValue.setSubFilter(subfilter);

    // Assert
    List<String> subFilter = pdSeedValue.getSubFilter();
    assertEquals(1, subFilter.size());
    assertEquals("foo", subFilter.get(0));
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#setSubFilter(List)}
   */
  @Test
  void testSetSubFilter3() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> subfilter = new ArrayList<>();
    subfilter.add("42");
    subfilter.add("foo");

    // Act
    pdSeedValue.setSubFilter(subfilter);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(subfilter, pdSeedValue.getSubFilter());
  }

  /**
   * Method under test: {@link PDSeedValue#getDigestMethod()}
   */
  @Test
  void testGetDigestMethod() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getDigestMethod().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#getDigestMethod()}
   */
  @Test
  void testGetDigestMethod2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setDigestMethod(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getDigestMethod().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#setDigestMethod(List)}
   */
  @Test
  void testSetDigestMethod() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setDigestMethod(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    List<String> legalAttestation = pdSeedValue.getLegalAttestation();
    assertTrue(legalAttestation.isEmpty());
    assertSame(legalAttestation, pdSeedValue.getReasons());
    assertSame(legalAttestation, pdSeedValue.getSubFilter());
  }

  /**
   * Method under test: {@link PDSeedValue#setDigestMethod(List)}
   */
  @Test
  void testSetDigestMethod2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> digestMethod = new ArrayList<>();
    digestMethod.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdSeedValue.setDigestMethod(digestMethod));
  }

  /**
   * Method under test: {@link PDSeedValue#setDigestMethod(List)}
   */
  @Test
  void testSetDigestMethod3() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> digestMethod = new ArrayList<>();
    digestMethod.add("42");
    digestMethod.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdSeedValue.setDigestMethod(digestMethod));
  }

  /**
   * Method under test: {@link PDSeedValue#getV()}
   */
  @Test
  void testGetV() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDSeedValue()).getV());
  }

  /**
   * Method under test: {@link PDSeedValue#getV()}
   */
  @Test
  void testGetV2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setV(-1.0f);

    // Act and Assert
    assertEquals(-1.0f, pdSeedValue.getV());
  }

  /**
   * Method under test: {@link PDSeedValue#setV(float)}
   */
  @Test
  void testSetV() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setV(10.0f);

    // Assert
    assertEquals(10.0f, pdSeedValue.getV());
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#getReasons()}
   */
  @Test
  void testGetReasons() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getReasons().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#getReasons()}
   */
  @Test
  void testGetReasons2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setReasons(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getReasons().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#setReasons(List)}
   */
  @Test
  void testSetReasons() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setReasons(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.getReasons().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#setReasons(List)}
   */
  @Test
  void testSetReasons2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> reasons = new ArrayList<>();
    reasons.add("foo");

    // Act
    pdSeedValue.setReasons(reasons);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#setReasons(List)}
   */
  @Test
  void testSetReasons3() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> reasons = new ArrayList<>();
    reasons.add("42");
    reasons.add("foo");

    // Act
    pdSeedValue.setReasons(reasons);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#getMDP()}
   */
  @Test
  void testGetMDP() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getMDP());
  }

  /**
   * Method under test: {@link PDSeedValue#getMDP()}
   */
  @Test
  void testGetMDP2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setMPD(new PDSeedValueMDP());

    // Act
    PDSeedValueMDP actualMDP = pdSeedValue.getMDP();

    // Assert
    COSDictionary cOSObject = actualMDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(-1, actualMDP.getP());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Method under test: {@link PDSeedValue#setMPD(PDSeedValueMDP)}
   */
  @Test
  void testSetMPD() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setMPD(new PDSeedValueMDP());

    // Assert
    assertEquals(-1, pdSeedValue.getMDP().getP());
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#setMPD(PDSeedValueMDP)}
   */
  @Test
  void testSetMPD2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setMPD(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#getSeedValueCertificate()}
   */
  @Test
  void testGetSeedValueCertificate() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getSeedValueCertificate());
  }

  /**
   * Method under test: {@link PDSeedValue#getSeedValueCertificate()}
   */
  @Test
  void testGetSeedValueCertificate2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setSeedValueCertificate(new PDSeedValueCertificate());

    // Act
    PDSeedValueCertificate actualSeedValueCertificate = pdSeedValue.getSeedValueCertificate();

    // Assert
    assertNull(actualSeedValueCertificate.getURL());
    assertNull(actualSeedValueCertificate.getURLType());
    assertNull(actualSeedValueCertificate.getIssuer());
    assertNull(actualSeedValueCertificate.getOID());
    assertNull(actualSeedValueCertificate.getSubject());
    assertNull(actualSeedValueCertificate.getKeyUsage());
    assertNull(actualSeedValueCertificate.getSubjectDN());
    COSDictionary cOSObject = actualSeedValueCertificate.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualSeedValueCertificate.isIssuerRequired());
    assertFalse(actualSeedValueCertificate.isKeyUsageRequired());
    assertFalse(actualSeedValueCertificate.isOIDRequired());
    assertFalse(actualSeedValueCertificate.isSubjectDNRequired());
    assertFalse(actualSeedValueCertificate.isSubjectRequired());
    assertFalse(actualSeedValueCertificate.isURLRequired());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Method under test:
   * {@link PDSeedValue#setSeedValueCertificate(PDSeedValueCertificate)}
   */
  @Test
  void testSetSeedValueCertificate() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setSeedValueCertificate(new PDSeedValueCertificate());

    // Assert
    PDSeedValueCertificate seedValueCertificate = pdSeedValue.getSeedValueCertificate();
    assertNull(seedValueCertificate.getURL());
    assertNull(seedValueCertificate.getURLType());
    assertNull(seedValueCertificate.getIssuer());
    assertNull(seedValueCertificate.getOID());
    assertNull(seedValueCertificate.getSubject());
    assertNull(seedValueCertificate.getKeyUsage());
    assertNull(seedValueCertificate.getSubjectDN());
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(seedValueCertificate.isIssuerRequired());
    assertFalse(seedValueCertificate.isKeyUsageRequired());
    assertFalse(seedValueCertificate.isOIDRequired());
    assertFalse(seedValueCertificate.isSubjectDNRequired());
    assertFalse(seedValueCertificate.isSubjectRequired());
    assertFalse(seedValueCertificate.isURLRequired());
  }

  /**
   * Method under test:
   * {@link PDSeedValue#setSeedValueCertificate(PDSeedValueCertificate)}
   */
  @Test
  void testSetSeedValueCertificate2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setSeedValueCertificate(null);

    // Assert
    assertNull(pdSeedValue.getSeedValueCertificate());
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#getTimeStamp()}
   */
  @Test
  void testGetTimeStamp() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getTimeStamp());
  }

  /**
   * Method under test: {@link PDSeedValue#getTimeStamp()}
   */
  @Test
  void testGetTimeStamp2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setTimeStamp(new PDSeedValueTimeStamp());

    // Act
    PDSeedValueTimeStamp actualTimeStamp = pdSeedValue.getTimeStamp();

    // Assert
    assertNull(actualTimeStamp.getURL());
    COSDictionary cOSObject = actualTimeStamp.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualTimeStamp.isTimestampRequired());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Method under test: {@link PDSeedValue#setTimeStamp(PDSeedValueTimeStamp)}
   */
  @Test
  void testSetTimeStamp() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setTimeStamp(new PDSeedValueTimeStamp());

    // Assert
    PDSeedValueTimeStamp timeStamp = pdSeedValue.getTimeStamp();
    assertNull(timeStamp.getURL());
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(timeStamp.isTimestampRequired());
  }

  /**
   * Method under test: {@link PDSeedValue#setTimeStamp(PDSeedValueTimeStamp)}
   */
  @Test
  void testSetTimeStamp2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setTimeStamp(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#getLegalAttestation()}
   */
  @Test
  void testGetLegalAttestation() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getLegalAttestation().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#getLegalAttestation()}
   */
  @Test
  void testGetLegalAttestation2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setLegalAttestation(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getLegalAttestation().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#setLegalAttestation(List)}
   */
  @Test
  void testSetLegalAttestation() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setLegalAttestation(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValue.getLegalAttestation().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValue#setLegalAttestation(List)}
   */
  @Test
  void testSetLegalAttestation2() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> legalAttestation = new ArrayList<>();
    legalAttestation.add("foo");

    // Act
    pdSeedValue.setLegalAttestation(legalAttestation);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#setLegalAttestation(List)}
   */
  @Test
  void testSetLegalAttestation3() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> legalAttestation = new ArrayList<>();
    legalAttestation.add("42");
    legalAttestation.add("foo");

    // Act
    pdSeedValue.setLegalAttestation(legalAttestation);

    // Assert
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValue#PDSeedValue()}
   */
  @Test
  void testNewPDSeedValue() {
    // Arrange and Act
    PDSeedValue actualPdSeedValue = new PDSeedValue();

    // Assert
    assertNull(actualPdSeedValue.getFilter());
    COSDictionary cOSObject = actualPdSeedValue.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdSeedValue.getSeedValueCertificate());
    assertNull(actualPdSeedValue.getMDP());
    assertNull(actualPdSeedValue.getTimeStamp());
    assertEquals(-1.0f, actualPdSeedValue.getV());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdSeedValue.isAddRevInfoRequired());
    assertFalse(actualPdSeedValue.isDigestMethodRequired());
    assertFalse(actualPdSeedValue.isFilterRequired());
    assertFalse(actualPdSeedValue.isLegalAttestationRequired());
    assertFalse(actualPdSeedValue.isReasonRequired());
    assertFalse(actualPdSeedValue.isSubFilterRequired());
    assertFalse(actualPdSeedValue.isVRequired());
    List<String> digestMethod = actualPdSeedValue.getDigestMethod();
    assertTrue(digestMethod.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertSame(digestMethod, actualPdSeedValue.getLegalAttestation());
    assertSame(digestMethod, actualPdSeedValue.getReasons());
    assertSame(digestMethod, actualPdSeedValue.getSubFilter());
  }

  /**
   * Method under test: {@link PDSeedValue#PDSeedValue(COSDictionary)}
   */
  @Test
  void testNewPDSeedValue2() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDSeedValue actualPdSeedValue = new PDSeedValue(dict);

    // Assert
    assertNull(actualPdSeedValue.getFilter());
    assertNull(actualPdSeedValue.getSeedValueCertificate());
    assertNull(actualPdSeedValue.getMDP());
    assertNull(actualPdSeedValue.getTimeStamp());
    assertEquals(-1.0f, actualPdSeedValue.getV());
    assertFalse(actualPdSeedValue.isAddRevInfoRequired());
    assertFalse(actualPdSeedValue.isDigestMethodRequired());
    assertFalse(actualPdSeedValue.isFilterRequired());
    assertFalse(actualPdSeedValue.isLegalAttestationRequired());
    assertFalse(actualPdSeedValue.isReasonRequired());
    assertFalse(actualPdSeedValue.isSubFilterRequired());
    assertFalse(actualPdSeedValue.isVRequired());
    List<String> digestMethod = actualPdSeedValue.getDigestMethod();
    assertTrue(digestMethod.isEmpty());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdSeedValue.getCOSObject());
    assertSame(digestMethod, actualPdSeedValue.getLegalAttestation());
    assertSame(digestMethod, actualPdSeedValue.getReasons());
    assertSame(digestMethod, actualPdSeedValue.getSubFilter());
  }
}
