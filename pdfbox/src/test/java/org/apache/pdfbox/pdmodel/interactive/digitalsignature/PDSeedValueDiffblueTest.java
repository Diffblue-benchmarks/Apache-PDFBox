package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSeedValueDiffblueTest {
  /**
   * Test {@link PDSeedValue#PDSeedValue()}.
   * <p>
   * Method under test: {@link PDSeedValue#PDSeedValue()}
   */
  @Test
  @DisplayName("Test new PDSeedValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.<init>()"})
  void testNewPDSeedValue() {
    // Arrange and Act
    PDSeedValue actualPdSeedValue = new PDSeedValue();

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
    assertSame(digestMethod, actualPdSeedValue.getLegalAttestation());
    assertSame(digestMethod, actualPdSeedValue.getReasons());
    assertSame(digestMethod, actualPdSeedValue.getSubFilter());
  }

  /**
   * Test {@link PDSeedValue#PDSeedValue(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Filter is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#PDSeedValue(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDSeedValue(COSDictionary); when COSDictionary(); then return Filter is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.<init>(COSDictionary)"})
  void testNewPDSeedValue_whenCOSDictionary_thenReturnFilterIsNull() {
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

  /**
   * Test {@link PDSeedValue#getCOSObject()}.
   * <p>
   * Method under test: {@link PDSeedValue#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDSeedValue.getCOSObject()"})
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
   * Test {@link PDSeedValue#isFilterRequired()}.
   * <p>
   * Method under test: {@link PDSeedValue#isFilterRequired()}
   */
  @Test
  @DisplayName("Test isFilterRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDSeedValue.isFilterRequired()"})
  void testIsFilterRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isFilterRequired());
  }

  /**
   * Test {@link PDSeedValue#setFilterRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValue#PDSeedValue()} FilterRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setFilterRequired(boolean)}
   */
  @Test
  @DisplayName("Test setFilterRequired(boolean); when 'false'; then not PDSeedValue() FilterRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setFilterRequired(boolean)"})
  void testSetFilterRequired_whenFalse_thenNotPDSeedValueFilterRequired() {
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
   * Test {@link PDSeedValue#setFilterRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} FilterRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setFilterRequired(boolean)}
   */
  @Test
  @DisplayName("Test setFilterRequired(boolean); when 'true'; then PDSeedValue() FilterRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setFilterRequired(boolean)"})
  void testSetFilterRequired_whenTrue_thenPDSeedValueFilterRequired() {
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
   * Test {@link PDSeedValue#isSubFilterRequired()}.
   * <p>
   * Method under test: {@link PDSeedValue#isSubFilterRequired()}
   */
  @Test
  @DisplayName("Test isSubFilterRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDSeedValue.isSubFilterRequired()"})
  void testIsSubFilterRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isSubFilterRequired());
  }

  /**
   * Test {@link PDSeedValue#setSubFilterRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValue#PDSeedValue()} SubFilterRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setSubFilterRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubFilterRequired(boolean); when 'false'; then not PDSeedValue() SubFilterRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setSubFilterRequired(boolean)"})
  void testSetSubFilterRequired_whenFalse_thenNotPDSeedValueSubFilterRequired() {
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
   * Test {@link PDSeedValue#setSubFilterRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} SubFilterRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setSubFilterRequired(boolean)}
   */
  @Test
  @DisplayName("Test setSubFilterRequired(boolean); when 'true'; then PDSeedValue() SubFilterRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setSubFilterRequired(boolean)"})
  void testSetSubFilterRequired_whenTrue_thenPDSeedValueSubFilterRequired() {
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
   * Test {@link PDSeedValue#isDigestMethodRequired()}.
   * <p>
   * Method under test: {@link PDSeedValue#isDigestMethodRequired()}
   */
  @Test
  @DisplayName("Test isDigestMethodRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDSeedValue.isDigestMethodRequired()"})
  void testIsDigestMethodRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isDigestMethodRequired());
  }

  /**
   * Test {@link PDSeedValue#setDigestMethodRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValue#PDSeedValue()} DigestMethodRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setDigestMethodRequired(boolean)}
   */
  @Test
  @DisplayName("Test setDigestMethodRequired(boolean); when 'false'; then not PDSeedValue() DigestMethodRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setDigestMethodRequired(boolean)"})
  void testSetDigestMethodRequired_whenFalse_thenNotPDSeedValueDigestMethodRequired() {
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
   * Test {@link PDSeedValue#setDigestMethodRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} DigestMethodRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setDigestMethodRequired(boolean)}
   */
  @Test
  @DisplayName("Test setDigestMethodRequired(boolean); when 'true'; then PDSeedValue() DigestMethodRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setDigestMethodRequired(boolean)"})
  void testSetDigestMethodRequired_whenTrue_thenPDSeedValueDigestMethodRequired() {
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
   * Test {@link PDSeedValue#isVRequired()}.
   * <p>
   * Method under test: {@link PDSeedValue#isVRequired()}
   */
  @Test
  @DisplayName("Test isVRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDSeedValue.isVRequired()"})
  void testIsVRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isVRequired());
  }

  /**
   * Test {@link PDSeedValue#setVRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValue#PDSeedValue()} VRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setVRequired(boolean)}
   */
  @Test
  @DisplayName("Test setVRequired(boolean); when 'false'; then not PDSeedValue() VRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setVRequired(boolean)"})
  void testSetVRequired_whenFalse_thenNotPDSeedValueVRequired() {
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
   * Test {@link PDSeedValue#setVRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} VRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setVRequired(boolean)}
   */
  @Test
  @DisplayName("Test setVRequired(boolean); when 'true'; then PDSeedValue() VRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setVRequired(boolean)"})
  void testSetVRequired_whenTrue_thenPDSeedValueVRequired() {
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
   * Test {@link PDSeedValue#isReasonRequired()}.
   * <p>
   * Method under test: {@link PDSeedValue#isReasonRequired()}
   */
  @Test
  @DisplayName("Test isReasonRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDSeedValue.isReasonRequired()"})
  void testIsReasonRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isReasonRequired());
  }

  /**
   * Test {@link PDSeedValue#setReasonRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValue#PDSeedValue()} ReasonRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setReasonRequired(boolean)}
   */
  @Test
  @DisplayName("Test setReasonRequired(boolean); when 'false'; then not PDSeedValue() ReasonRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setReasonRequired(boolean)"})
  void testSetReasonRequired_whenFalse_thenNotPDSeedValueReasonRequired() {
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
   * Test {@link PDSeedValue#setReasonRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} ReasonRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setReasonRequired(boolean)}
   */
  @Test
  @DisplayName("Test setReasonRequired(boolean); when 'true'; then PDSeedValue() ReasonRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setReasonRequired(boolean)"})
  void testSetReasonRequired_whenTrue_thenPDSeedValueReasonRequired() {
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
   * Test {@link PDSeedValue#isLegalAttestationRequired()}.
   * <p>
   * Method under test: {@link PDSeedValue#isLegalAttestationRequired()}
   */
  @Test
  @DisplayName("Test isLegalAttestationRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDSeedValue.isLegalAttestationRequired()"})
  void testIsLegalAttestationRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isLegalAttestationRequired());
  }

  /**
   * Test {@link PDSeedValue#setLegalAttestationRequired(boolean)}.
   * <ul>
   *   <li>Then not {@link PDSeedValue#PDSeedValue()} LegalAttestationRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setLegalAttestationRequired(boolean)}
   */
  @Test
  @DisplayName("Test setLegalAttestationRequired(boolean); then not PDSeedValue() LegalAttestationRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setLegalAttestationRequired(boolean)"})
  void testSetLegalAttestationRequired_thenNotPDSeedValueLegalAttestationRequired() {
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
   * Test {@link PDSeedValue#setLegalAttestationRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} LegalAttestationRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setLegalAttestationRequired(boolean)}
   */
  @Test
  @DisplayName("Test setLegalAttestationRequired(boolean); when 'true'; then PDSeedValue() LegalAttestationRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setLegalAttestationRequired(boolean)"})
  void testSetLegalAttestationRequired_whenTrue_thenPDSeedValueLegalAttestationRequired() {
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
   * Test {@link PDSeedValue#isAddRevInfoRequired()}.
   * <p>
   * Method under test: {@link PDSeedValue#isAddRevInfoRequired()}
   */
  @Test
  @DisplayName("Test isAddRevInfoRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDSeedValue.isAddRevInfoRequired()"})
  void testIsAddRevInfoRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValue()).isAddRevInfoRequired());
  }

  /**
   * Test {@link PDSeedValue#setAddRevInfoRequired(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDSeedValue#PDSeedValue()} AddRevInfoRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setAddRevInfoRequired(boolean)}
   */
  @Test
  @DisplayName("Test setAddRevInfoRequired(boolean); when 'false'; then not PDSeedValue() AddRevInfoRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setAddRevInfoRequired(boolean)"})
  void testSetAddRevInfoRequired_whenFalse_thenNotPDSeedValueAddRevInfoRequired() {
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
   * Test {@link PDSeedValue#setAddRevInfoRequired(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} AddRevInfoRequired.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setAddRevInfoRequired(boolean)}
   */
  @Test
  @DisplayName("Test setAddRevInfoRequired(boolean); when 'true'; then PDSeedValue() AddRevInfoRequired")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setAddRevInfoRequired(boolean)"})
  void testSetAddRevInfoRequired_whenTrue_thenPDSeedValueAddRevInfoRequired() {
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
   * Test {@link PDSeedValue#getFilter()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); given PDSeedValue(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDSeedValue.getFilter()"})
  void testGetFilter_givenPDSeedValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getFilter());
  }

  /**
   * Test {@link PDSeedValue#getFilter()}.
   * <ul>
   *   <li>Then return {@code Adobe.PPKLite}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); then return 'Adobe.PPKLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDSeedValue.getFilter()"})
  void testGetFilter_thenReturnAdobePPKLite() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSeedValue.getFilter());
  }

  /**
   * Test {@link PDSeedValue#setFilter(COSName)}.
   * <ul>
   *   <li>When {@link PDSignature#FILTER_ADOBE_PPKLITE}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} Filter is {@code Adobe.PPKLite}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setFilter(COSName)}
   */
  @Test
  @DisplayName("Test setFilter(COSName); when FILTER_ADOBE_PPKLITE; then PDSeedValue() Filter is 'Adobe.PPKLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setFilter(COSName)"})
  void testSetFilter_whenFilter_adobe_ppklite_thenPDSeedValueFilterIsAdobePPKLite() {
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
   * Test {@link PDSeedValue#setFilter(COSName)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setFilter(COSName)}
   */
  @Test
  @DisplayName("Test setFilter(COSName); when 'null'; then PDSeedValue() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setFilter(COSName)"})
  void testSetFilter_whenNull_thenPDSeedValueCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setFilter(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValue#getSubFilter()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given ArrayList() add '42'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getSubFilter()"})
  void testGetSubFilter_givenArrayListAdd42_thenReturnArrayList() {
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
   * Test {@link PDSeedValue#getSubFilter()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given ArrayList() add 'foo'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getSubFilter()"})
  void testGetSubFilter_givenArrayListAddFoo_thenReturnSizeIsOne() {
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
   * Test {@link PDSeedValue#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()} SubFilter is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDSeedValue() SubFilter is ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getSubFilter()"})
  void testGetSubFilter_givenPDSeedValueSubFilterIsArrayList_thenReturnEmpty() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setSubFilter(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getSubFilter().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDSeedValue(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getSubFilter()"})
  void testGetSubFilter_givenPDSeedValue_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getSubFilter().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#setSubFilter(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} SubFilter is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setSubFilter(List)}
   */
  @Test
  @DisplayName("Test setSubFilter(List); given '42'; when ArrayList() add '42'; then PDSeedValue() SubFilter is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setSubFilter(List)"})
  void testSetSubFilter_given42_whenArrayListAdd42_thenPDSeedValueSubFilterIsArrayList() {
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
   * Test {@link PDSeedValue#setSubFilter(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} SubFilter is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setSubFilter(List)}
   */
  @Test
  @DisplayName("Test setSubFilter(List); given 'foo'; then PDSeedValue() SubFilter is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setSubFilter(List)"})
  void testSetSubFilter_givenFoo_thenPDSeedValueSubFilterIsArrayList() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> subfilter = new ArrayList<>();
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
   * Test {@link PDSeedValue#setSubFilter(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} SubFilter Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setSubFilter(List)}
   */
  @Test
  @DisplayName("Test setSubFilter(List); when ArrayList(); then PDSeedValue() SubFilter Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setSubFilter(List)"})
  void testSetSubFilter_whenArrayList_thenPDSeedValueSubFilterEmpty() {
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
   * Test {@link PDSeedValue#getDigestMethod()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getDigestMethod()}
   */
  @Test
  @DisplayName("Test getDigestMethod(); given PDSeedValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getDigestMethod()"})
  void testGetDigestMethod_givenPDSeedValue() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getDigestMethod().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#getDigestMethod()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()} DigestMethod is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getDigestMethod()}
   */
  @Test
  @DisplayName("Test getDigestMethod(); given PDSeedValue() DigestMethod is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getDigestMethod()"})
  void testGetDigestMethod_givenPDSeedValueDigestMethodIsArrayList() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setDigestMethod(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getDigestMethod().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#setDigestMethod(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setDigestMethod(List)}
   */
  @Test
  @DisplayName("Test setDigestMethod(List); given '42'; when ArrayList() add '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setDigestMethod(List)"})
  void testSetDigestMethod_given42_whenArrayListAdd42_thenThrowIllegalArgumentException() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> digestMethod = new ArrayList<>();
    digestMethod.add("42");
    digestMethod.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdSeedValue.setDigestMethod(digestMethod));
  }

  /**
   * Test {@link PDSeedValue#setDigestMethod(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setDigestMethod(List)}
   */
  @Test
  @DisplayName("Test setDigestMethod(List); given 'foo'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setDigestMethod(List)"})
  void testSetDigestMethod_givenFoo_thenThrowIllegalArgumentException() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    ArrayList<String> digestMethod = new ArrayList<>();
    digestMethod.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdSeedValue.setDigestMethod(digestMethod));
  }

  /**
   * Test {@link PDSeedValue#setDigestMethod(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setDigestMethod(List)}
   */
  @Test
  @DisplayName("Test setDigestMethod(List); when ArrayList(); then PDSeedValue() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setDigestMethod(List)"})
  void testSetDigestMethod_whenArrayList_thenPDSeedValueCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDSeedValue#getV()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getV()}
   */
  @Test
  @DisplayName("Test getV(); given PDSeedValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDSeedValue.getV()"})
  void testGetV_givenPDSeedValue() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDSeedValue()).getV());
  }

  /**
   * Test {@link PDSeedValue#getV()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()} V is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getV()}
   */
  @Test
  @DisplayName("Test getV(); given PDSeedValue() V is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDSeedValue.getV()"})
  void testGetV_givenPDSeedValueVIsMinusOne() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setV(-1.0f);

    // Act and Assert
    assertEquals(-1.0f, pdSeedValue.getV());
  }

  /**
   * Test {@link PDSeedValue#setV(float)}.
   * <p>
   * Method under test: {@link PDSeedValue#setV(float)}
   */
  @Test
  @DisplayName("Test setV(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setV(float)"})
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
   * Test {@link PDSeedValue#getReasons()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getReasons()}
   */
  @Test
  @DisplayName("Test getReasons(); given PDSeedValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getReasons()"})
  void testGetReasons_givenPDSeedValue() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getReasons().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#getReasons()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()} Reasons is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getReasons()}
   */
  @Test
  @DisplayName("Test getReasons(); given PDSeedValue() Reasons is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getReasons()"})
  void testGetReasons_givenPDSeedValueReasonsIsArrayList() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setReasons(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getReasons().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#setReasons(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setReasons(List)}
   */
  @Test
  @DisplayName("Test setReasons(List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setReasons(List)"})
  void testSetReasons_given42_whenArrayListAdd42() {
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
   * Test {@link PDSeedValue#setReasons(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setReasons(List)}
   */
  @Test
  @DisplayName("Test setReasons(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setReasons(List)"})
  void testSetReasons_givenFoo_whenArrayListAddFoo() {
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
   * Test {@link PDSeedValue#setReasons(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} Reasons Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setReasons(List)}
   */
  @Test
  @DisplayName("Test setReasons(List); when ArrayList(); then PDSeedValue() Reasons Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setReasons(List)"})
  void testSetReasons_whenArrayList_thenPDSeedValueReasonsEmpty() {
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
   * Test {@link PDSeedValue#getMDP()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getMDP()}
   */
  @Test
  @DisplayName("Test getMDP(); given PDSeedValue(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSeedValueMDP PDSeedValue.getMDP()"})
  void testGetMDP_givenPDSeedValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getMDP());
  }

  /**
   * Test {@link PDSeedValue#getMDP()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getMDP()}
   */
  @Test
  @DisplayName("Test getMDP(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSeedValueMDP PDSeedValue.getMDP()"})
  void testGetMDP_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
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
   * Test {@link PDSeedValue#setMPD(PDSeedValueMDP)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setMPD(PDSeedValueMDP)}
   */
  @Test
  @DisplayName("Test setMPD(PDSeedValueMDP); when 'null'; then PDSeedValue() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setMPD(PDSeedValueMDP)"})
  void testSetMPD_whenNull_thenPDSeedValueCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDSeedValue#setMPD(PDSeedValueMDP)}.
   * <ul>
   *   <li>When {@link PDSeedValueMDP#PDSeedValueMDP()}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} MDP P is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setMPD(PDSeedValueMDP)}
   */
  @Test
  @DisplayName("Test setMPD(PDSeedValueMDP); when PDSeedValueMDP(); then PDSeedValue() MDP P is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setMPD(PDSeedValueMDP)"})
  void testSetMPD_whenPDSeedValueMDP_thenPDSeedValueMdpPIsMinusOne() {
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
   * Test {@link PDSeedValue#getSeedValueCertificate()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getSeedValueCertificate()}
   */
  @Test
  @DisplayName("Test getSeedValueCertificate(); given PDSeedValue(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSeedValueCertificate PDSeedValue.getSeedValueCertificate()"})
  void testGetSeedValueCertificate_givenPDSeedValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getSeedValueCertificate());
  }

  /**
   * Test {@link PDSeedValue#getSeedValueCertificate()}.
   * <ul>
   *   <li>Then return URL is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getSeedValueCertificate()}
   */
  @Test
  @DisplayName("Test getSeedValueCertificate(); then return URL is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSeedValueCertificate PDSeedValue.getSeedValueCertificate()"})
  void testGetSeedValueCertificate_thenReturnUrlIsNull() {
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
    assertFalse(actualSeedValueCertificate.isIssuerRequired());
    assertFalse(actualSeedValueCertificate.isKeyUsageRequired());
    assertFalse(actualSeedValueCertificate.isOIDRequired());
    assertFalse(actualSeedValueCertificate.isSubjectDNRequired());
    assertFalse(actualSeedValueCertificate.isSubjectRequired());
    assertFalse(actualSeedValueCertificate.isURLRequired());
  }

  /**
   * Test {@link PDSeedValue#setSeedValueCertificate(PDSeedValueCertificate)}.
   * <ul>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} SeedValueCertificate URL is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setSeedValueCertificate(PDSeedValueCertificate)}
   */
  @Test
  @DisplayName("Test setSeedValueCertificate(PDSeedValueCertificate); then PDSeedValue() SeedValueCertificate URL is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setSeedValueCertificate(PDSeedValueCertificate)"})
  void testSetSeedValueCertificate_thenPDSeedValueSeedValueCertificateUrlIsNull() {
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
   * Test {@link PDSeedValue#setSeedValueCertificate(PDSeedValueCertificate)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setSeedValueCertificate(PDSeedValueCertificate)}
   */
  @Test
  @DisplayName("Test setSeedValueCertificate(PDSeedValueCertificate); when 'null'; then PDSeedValue() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setSeedValueCertificate(PDSeedValueCertificate)"})
  void testSetSeedValueCertificate_whenNull_thenPDSeedValueCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();

    // Act
    pdSeedValue.setSeedValueCertificate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSeedValue.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSeedValue#getTimeStamp()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getTimeStamp()}
   */
  @Test
  @DisplayName("Test getTimeStamp(); given PDSeedValue(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSeedValueTimeStamp PDSeedValue.getTimeStamp()"})
  void testGetTimeStamp_givenPDSeedValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValue()).getTimeStamp());
  }

  /**
   * Test {@link PDSeedValue#getTimeStamp()}.
   * <ul>
   *   <li>Then return URL is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getTimeStamp()}
   */
  @Test
  @DisplayName("Test getTimeStamp(); then return URL is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSeedValueTimeStamp PDSeedValue.getTimeStamp()"})
  void testGetTimeStamp_thenReturnUrlIsNull() {
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
   * Test {@link PDSeedValue#setTimeStamp(PDSeedValueTimeStamp)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setTimeStamp(PDSeedValueTimeStamp)}
   */
  @Test
  @DisplayName("Test setTimeStamp(PDSeedValueTimeStamp); when 'null'; then PDSeedValue() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setTimeStamp(PDSeedValueTimeStamp)"})
  void testSetTimeStamp_whenNull_thenPDSeedValueCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDSeedValue#setTimeStamp(PDSeedValueTimeStamp)}.
   * <ul>
   *   <li>When {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} TimeStamp URL is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setTimeStamp(PDSeedValueTimeStamp)}
   */
  @Test
  @DisplayName("Test setTimeStamp(PDSeedValueTimeStamp); when PDSeedValueTimeStamp(); then PDSeedValue() TimeStamp URL is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setTimeStamp(PDSeedValueTimeStamp)"})
  void testSetTimeStamp_whenPDSeedValueTimeStamp_thenPDSeedValueTimeStampUrlIsNull() {
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
   * Test {@link PDSeedValue#getLegalAttestation()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getLegalAttestation()}
   */
  @Test
  @DisplayName("Test getLegalAttestation(); given PDSeedValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getLegalAttestation()"})
  void testGetLegalAttestation_givenPDSeedValue() {
    // Arrange, Act and Assert
    assertTrue((new PDSeedValue()).getLegalAttestation().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#getLegalAttestation()}.
   * <ul>
   *   <li>Given {@link PDSeedValue#PDSeedValue()} LegalAttestation is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#getLegalAttestation()}
   */
  @Test
  @DisplayName("Test getLegalAttestation(); given PDSeedValue() LegalAttestation is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDSeedValue.getLegalAttestation()"})
  void testGetLegalAttestation_givenPDSeedValueLegalAttestationIsArrayList() {
    // Arrange
    PDSeedValue pdSeedValue = new PDSeedValue();
    pdSeedValue.setLegalAttestation(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValue.getLegalAttestation().isEmpty());
  }

  /**
   * Test {@link PDSeedValue#setLegalAttestation(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setLegalAttestation(List)}
   */
  @Test
  @DisplayName("Test setLegalAttestation(List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setLegalAttestation(List)"})
  void testSetLegalAttestation_given42_whenArrayListAdd42() {
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
   * Test {@link PDSeedValue#setLegalAttestation(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setLegalAttestation(List)}
   */
  @Test
  @DisplayName("Test setLegalAttestation(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setLegalAttestation(List)"})
  void testSetLegalAttestation_givenFoo_whenArrayListAddFoo() {
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
   * Test {@link PDSeedValue#setLegalAttestation(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDSeedValue#PDSeedValue()} LegalAttestation Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSeedValue#setLegalAttestation(List)}
   */
  @Test
  @DisplayName("Test setLegalAttestation(List); when ArrayList(); then PDSeedValue() LegalAttestation Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeedValue.setLegalAttestation(List)"})
  void testSetLegalAttestation_whenArrayList_thenPDSeedValueLegalAttestationEmpty() {
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
}
