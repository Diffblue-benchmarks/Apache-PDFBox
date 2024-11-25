package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDSignatureDiffblueTest {
  /**
   * Test {@link PDSignature#PDSignature(COSDictionary)}.
   * <p>
   * Method under test: {@link PDSignature#PDSignature(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDSignature(COSDictionary)")
  void testNewPDSignature() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDSignature(dict)).getCOSObject());
  }

  /**
   * Test {@link PDSignature#PDSignature()}.
   * <p>
   * Method under test: {@link PDSignature#PDSignature()}
   */
  @Test
  @DisplayName("Test new PDSignature()")
  void testNewPDSignature2() {
    // Arrange and Act
    PDSignature actualPdSignature = new PDSignature();

    // Assert
    assertNull(actualPdSignature.getContactInfo());
    assertNull(actualPdSignature.getFilter());
    assertNull(actualPdSignature.getLocation());
    assertNull(actualPdSignature.getName());
    assertNull(actualPdSignature.getReason());
    assertNull(actualPdSignature.getSubFilter());
    assertNull(actualPdSignature.getSignDate());
    COSDictionary cOSObject = actualPdSignature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdSignature.getPropBuild());
    assertEquals(0, actualPdSignature.getByteRange().length);
    assertEquals(0, actualPdSignature.getContents().length);
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDSignature#getCOSObject()}.
   * <p>
   * Method under test: {@link PDSignature#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDSignature()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDSignature#setType(COSName)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setType(COSName)}
   */
  @Test
  @DisplayName("Test setType(COSName); given PDSignature(); then PDSignature() COSObject Values size is one")
  void testSetType_givenPDSignature_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setType(PDSignature.FILTER_ADOBE_PPKLITE);

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setType(COSName)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setType(COSName)}
   */
  @Test
  @DisplayName("Test setType(COSName); given PDSignature(); when 'null'; then PDSignature() COSObject size is zero")
  void testSetType_givenPDSignature_whenNull_thenPDSignatureCOSObjectSizeIsZero() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setType(null);

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDSignature#setFilter(COSName)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} Filter is
   * {@code Adobe.PPKLite}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setFilter(COSName)}
   */
  @Test
  @DisplayName("Test setFilter(COSName); given PDSignature(); then PDSignature() Filter is 'Adobe.PPKLite'")
  void testSetFilter_givenPDSignature_thenPDSignatureFilterIsAdobePPKLite() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Assert
    assertEquals("Adobe.PPKLite", pdSignature.getFilter());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setFilter(COSName)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} Filter is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setFilter(COSName)}
   */
  @Test
  @DisplayName("Test setFilter(COSName); given PDSignature(); when 'null'; then PDSignature() Filter is 'null'")
  void testSetFilter_givenPDSignature_whenNull_thenPDSignatureFilterIsNull() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setFilter(null);

    // Assert
    assertNull(pdSignature.getFilter());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setSubFilter(COSName)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} SubFilter is
   * {@code Adobe.PPKLite}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setSubFilter(COSName)}
   */
  @Test
  @DisplayName("Test setSubFilter(COSName); given PDSignature(); then PDSignature() SubFilter is 'Adobe.PPKLite'")
  void testSetSubFilter_givenPDSignature_thenPDSignatureSubFilterIsAdobePPKLite() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setSubFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Assert
    assertEquals("Adobe.PPKLite", pdSignature.getSubFilter());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setSubFilter(COSName)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} SubFilter is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setSubFilter(COSName)}
   */
  @Test
  @DisplayName("Test setSubFilter(COSName); given PDSignature(); when 'null'; then PDSignature() SubFilter is 'null'")
  void testSetSubFilter_givenPDSignature_whenNull_thenPDSignatureSubFilterIsNull() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setSubFilter(null);

    // Assert
    assertNull(pdSignature.getSubFilter());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setName(String)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); given PDSignature(); then PDSignature() Name is 'Name'")
  void testSetName_givenPDSignature_thenPDSignatureNameIsName() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setName("Name");

    // Assert
    assertEquals("Name", pdSignature.getName());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setLocation(String)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} Location is {@code Location}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setLocation(String)}
   */
  @Test
  @DisplayName("Test setLocation(String); given PDSignature(); then PDSignature() Location is 'Location'")
  void testSetLocation_givenPDSignature_thenPDSignatureLocationIsLocation() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setLocation("Location");

    // Assert
    assertEquals("Location", pdSignature.getLocation());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setReason(String)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} Reason is {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setReason(String)}
   */
  @Test
  @DisplayName("Test setReason(String); given PDSignature(); then PDSignature() Reason is 'Just cause'")
  void testSetReason_givenPDSignature_thenPDSignatureReasonIsJustCause() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setReason("Just cause");

    // Assert
    assertEquals("Just cause", pdSignature.getReason());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setContactInfo(String)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} ContactInfo is
   * {@code Contact Info}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setContactInfo(String)}
   */
  @Test
  @DisplayName("Test setContactInfo(String); given PDSignature(); then PDSignature() ContactInfo is 'Contact Info'")
  void testSetContactInfo_givenPDSignature_thenPDSignatureContactInfoIsContactInfo() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setContactInfo("Contact Info");

    // Assert
    assertEquals("Contact Info", pdSignature.getContactInfo());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setSignDate(Calendar)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} SignDate
   * {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setSignDate(Calendar)}
   */
  @Test
  @DisplayName("Test setSignDate(Calendar); given PDSignature(); then PDSignature() SignDate GregorianCalendar")
  void testSetSignDate_givenPDSignature_thenPDSignatureSignDateGregorianCalendar() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setSignDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar signDate = pdSignature.getSignDate();
    assertTrue(signDate instanceof GregorianCalendar);
    assertEquals("gregory", signDate.getCalendarType());
    assertEquals(0, signDate.getTimeZone().getDSTSavings());
    assertEquals(1, signDate.getFirstDayOfWeek());
    assertEquals(1, signDate.getMinimalDaysInFirstWeek());
    assertEquals(1, signDate.getWeekYear());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(53, signDate.getWeeksInWeekYear());
    assertFalse(signDate.isLenient());
    assertTrue(signDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDSignature#setSignDate(Calendar)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} SignDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setSignDate(Calendar)}
   */
  @Test
  @DisplayName("Test setSignDate(Calendar); given PDSignature(); when 'null'; then PDSignature() SignDate is 'null'")
  void testSetSignDate_givenPDSignature_whenNull_thenPDSignatureSignDateIsNull() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setSignDate(null);

    // Assert
    assertNull(pdSignature.getSignDate());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#getFilter()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetFilter_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getFilter());
  }

  /**
   * Test {@link PDSignature#getFilter()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); given PDSignature(); then return 'null'")
  void testGetFilter_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getFilter());
  }

  /**
   * Test {@link PDSignature#getFilter()}.
   * <ul>
   *   <li>Then return {@code Adobe.PPKLite}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); then return 'Adobe.PPKLite'")
  void testGetFilter_thenReturnAdobePPKLite() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSignature.getFilter());
  }

  /**
   * Test {@link PDSignature#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetSubFilter_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getSubFilter());
  }

  /**
   * Test {@link PDSignature#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDSignature(); then return 'null'")
  void testGetSubFilter_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getSubFilter());
  }

  /**
   * Test {@link PDSignature#getSubFilter()}.
   * <ul>
   *   <li>Then return {@code Adobe.PPKLite}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); then return 'Adobe.PPKLite'")
  void testGetSubFilter_thenReturnAdobePPKLite() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setSubFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSignature.getSubFilter());
  }

  /**
   * Test {@link PDSignature#getName()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Name is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDSignature() Name is empty string; then return empty string")
  void testGetName_givenPDSignatureNameIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setName("");

    // Act and Assert
    assertEquals("", pdSignature.getName());
  }

  /**
   * Test {@link PDSignature#getName()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Name is {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDSignature() Name is 'Name'; then return 'Name'")
  void testGetName_givenPDSignatureNameIsName_thenReturnName() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setName("Name");

    // Act and Assert
    assertEquals("Name", pdSignature.getName());
  }

  /**
   * Test {@link PDSignature#getName()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetName_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getName());
  }

  /**
   * Test {@link PDSignature#getName()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDSignature(); then return 'null'")
  void testGetName_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getName());
  }

  /**
   * Test {@link PDSignature#getLocation()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Location is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation(); given PDSignature() Location is empty string; then return empty string")
  void testGetLocation_givenPDSignatureLocationIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setLocation("");

    // Act and Assert
    assertEquals("", pdSignature.getLocation());
  }

  /**
   * Test {@link PDSignature#getLocation()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Location is
   * {@code Location}.</li>
   *   <li>Then return {@code Location}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation(); given PDSignature() Location is 'Location'; then return 'Location'")
  void testGetLocation_givenPDSignatureLocationIsLocation_thenReturnLocation() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setLocation("Location");

    // Act and Assert
    assertEquals("Location", pdSignature.getLocation());
  }

  /**
   * Test {@link PDSignature#getLocation()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetLocation_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getLocation());
  }

  /**
   * Test {@link PDSignature#getLocation()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation(); given PDSignature(); then return 'null'")
  void testGetLocation_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getLocation());
  }

  /**
   * Test {@link PDSignature#getReason()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Reason is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getReason()}
   */
  @Test
  @DisplayName("Test getReason(); given PDSignature() Reason is empty string; then return empty string")
  void testGetReason_givenPDSignatureReasonIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setReason("");

    // Act and Assert
    assertEquals("", pdSignature.getReason());
  }

  /**
   * Test {@link PDSignature#getReason()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Reason is
   * {@code Just cause}.</li>
   *   <li>Then return {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getReason()}
   */
  @Test
  @DisplayName("Test getReason(); given PDSignature() Reason is 'Just cause'; then return 'Just cause'")
  void testGetReason_givenPDSignatureReasonIsJustCause_thenReturnJustCause() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setReason("Just cause");

    // Act and Assert
    assertEquals("Just cause", pdSignature.getReason());
  }

  /**
   * Test {@link PDSignature#getReason()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getReason()}
   */
  @Test
  @DisplayName("Test getReason(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetReason_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getReason());
  }

  /**
   * Test {@link PDSignature#getReason()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getReason()}
   */
  @Test
  @DisplayName("Test getReason(); given PDSignature(); then return 'null'")
  void testGetReason_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getReason());
  }

  /**
   * Test {@link PDSignature#getContactInfo()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  @DisplayName("Test getContactInfo(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetContactInfo_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getContactInfo());
  }

  /**
   * Test {@link PDSignature#getContactInfo()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  @DisplayName("Test getContactInfo(); given PDSignature(); then return 'null'")
  void testGetContactInfo_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getContactInfo());
  }

  /**
   * Test {@link PDSignature#getContactInfo()}.
   * <ul>
   *   <li>Then return {@code Contact Info}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  @DisplayName("Test getContactInfo(); then return 'Contact Info'")
  void testGetContactInfo_thenReturnContactInfo() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContactInfo("Contact Info");

    // Act and Assert
    assertEquals("Contact Info", pdSignature.getContactInfo());
  }

  /**
   * Test {@link PDSignature#getContactInfo()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  @DisplayName("Test getContactInfo(); then return empty string")
  void testGetContactInfo_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContactInfo("");

    // Act and Assert
    assertEquals("", pdSignature.getContactInfo());
  }

  /**
   * Test {@link PDSignature#getSignDate()}.
   * <p>
   * Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  @DisplayName("Test getSignDate()")
  void testGetSignDate() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setSignDate(new GregorianCalendar(Integer.MIN_VALUE, 1, 1));

    // Act and Assert
    assertNull(pdSignature.getSignDate());
  }

  /**
   * Test {@link PDSignature#getSignDate()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  @DisplayName("Test getSignDate(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetSignDate_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getSignDate());
  }

  /**
   * Test {@link PDSignature#getSignDate()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  @DisplayName("Test getSignDate(); given PDSignature(); then return 'null'")
  void testGetSignDate_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getSignDate());
  }

  /**
   * Test {@link PDSignature#getSignDate()}.
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  @DisplayName("Test getSignDate(); then return GregorianCalendar")
  void testGetSignDate_thenReturnGregorianCalendar() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setSignDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualSignDate = pdSignature.getSignDate();

    // Assert
    assertTrue(actualSignDate instanceof GregorianCalendar);
    assertEquals("gregory", actualSignDate.getCalendarType());
    assertEquals(0, actualSignDate.getTimeZone().getDSTSavings());
    assertEquals(1, actualSignDate.getFirstDayOfWeek());
    assertEquals(1, actualSignDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualSignDate.getWeekYear());
    assertEquals(53, actualSignDate.getWeeksInWeekYear());
    assertFalse(actualSignDate.isLenient());
    assertTrue(actualSignDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>When empty array of {@code int}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName("Test setByteRange(int[]); given PDSignature(); when empty array of int; then array length is zero")
  void testSetByteRange_givenPDSignature_whenEmptyArrayOfInt_thenArrayLengthIsZero() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[]{});

    // Assert that nothing has changed
    assertEquals(0, pdSignature.getByteRange().length);
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   * <ul>
   *   <li>Then {@link PDSignature#PDSignature()} ByteRange is array of {@code int}
   * with {@code 1024} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName("Test setByteRange(int[]); then PDSignature() ByteRange is array of int with '1024' and minus one")
  void testSetByteRange_thenPDSignatureByteRangeIsArrayOfIntWith1024AndMinusOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[]{1024, -1, 1, -1});

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new int[]{1024, -1, 1, -1}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   * <ul>
   *   <li>Then {@link PDSignature#PDSignature()} ByteRange is array of {@code int}
   * with {@link Integer#MIN_VALUE} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName("Test setByteRange(int[]); then PDSignature() ByteRange is array of int with MIN_VALUE and minus one")
  void testSetByteRange_thenPDSignatureByteRangeIsArrayOfIntWithMin_valueAndMinusOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[]{Integer.MIN_VALUE, -1, 1, -1});

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new int[]{Integer.MIN_VALUE, -1, 1, -1}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   * <ul>
   *   <li>Then {@link PDSignature#PDSignature()} ByteRange is array of {@code int}
   * with one and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName("Test setByteRange(int[]); then PDSignature() ByteRange is array of int with one and minus one")
  void testSetByteRange_thenPDSignatureByteRangeIsArrayOfIntWithOneAndMinusOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[]{1, -1, 1, -1});

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new int[]{1, -1, 1, -1}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#getByteRange()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getByteRange()}
   */
  @Test
  @DisplayName("Test getByteRange(); given PDSignature(COSDictionary) with dict is COSDictionary()")
  void testGetByteRange_givenPDSignatureWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDSignature(new COSDictionary())).getByteRange().length);
  }

  /**
   * Test {@link PDSignature#getByteRange()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getByteRange()}
   */
  @Test
  @DisplayName("Test getByteRange(); given PDSignature(); then return array length is zero")
  void testGetByteRange_givenPDSignature_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDSignature()).getByteRange().length);
  }

  /**
   * Test {@link PDSignature#getByteRange()}.
   * <ul>
   *   <li>Then return array of {@code int} with one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getByteRange()}
   */
  @Test
  @DisplayName("Test getByteRange(); then return array of int with one and zero")
  void testGetByteRange_thenReturnArrayOfIntWithOneAndZero() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 1, 0});

    // Act and Assert
    assertArrayEquals(new int[]{1, 0, 1, 0}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName("Test getContents(byte[]) with 'byte[]'; then return array length is zero")
  void testGetContentsWithByte_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 1, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus ninety-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName("Test getContents(byte[]) with 'byte[]'; then return array of byte with minus ninety-six")
  void testGetContentsWithByte_thenReturnArrayOfByteWithMinusNinetySix() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertArrayEquals(new byte[]{-96}, pdSignature.getContents("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AX(XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName("Test getContents(byte[]) with 'byte[]'; when 'AX(XAXAX' Bytes is 'UTF-8'; then return array length is zero")
  void testGetContentsWithByte_whenAxXaxaxBytesIsUtf8_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AX(XAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AX)XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName("Test getContents(byte[]) with 'byte[]'; when 'AX)XAXAX' Bytes is 'UTF-8'; then return array length is zero")
  void testGetContentsWithByte_whenAxXaxaxBytesIsUtf8_thenReturnArrayLengthIsZero2() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AX)XAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AX<XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName("Test getContents(byte[]) with 'byte[]'; when 'AX<XAXAX' Bytes is 'UTF-8'; then return array length is zero")
  void testGetContentsWithByte_whenAxXaxaxBytesIsUtf8_thenReturnArrayLengthIsZero3() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AX<XAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Test {@link PDSignature#getContents(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PDSignature#getContents(InputStream)}
   */
  @Test
  @DisplayName("Test getContents(InputStream) with 'InputStream'")
  void testGetContentsWithInputStream() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{-1, 0, 1, 0});
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualContents = pdSignature.getContents(pdfFile);

    // Assert
    byte[] byteArray = new byte[7];
    assertEquals(7, pdfFile.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new byte[]{-96}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDSignature(COSDictionary) with dict is COSDictionary()")
  void testGetContents_givenPDSignatureWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDSignature(new COSDictionary())).getContents().length);
  }

  /**
   * Test {@link PDSignature#getContents()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDSignature(); then return array length is zero")
  void testGetContents_givenPDSignature_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDSignature()).getContents().length);
  }

  /**
   * Test {@link PDSignature#getContents()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetContents_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContents("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualContents = pdSignature.getContents();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualContents);
  }

  /**
   * Test {@link PDSignature#setContents(byte[])}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setContents(byte[])}
   */
  @Test
  @DisplayName("Test setContents(byte[]); given PDSignature(); then PDSignature() COSObject Values size is two")
  void testSetContents_givenPDSignature_thenPDSignatureCOSObjectValuesSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setContents("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    byte[] expectedContents = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedContents, pdSignature.getContents());
  }

  /**
   * Test {@link PDSignature#getSignedContent(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  @DisplayName("Test getSignedContent(byte[]) with 'byte[]'; given PDSignature(COSDictionary) with dict is COSDictionary()")
  void testGetSignedContentWithByte_givenPDSignatureWithDictIsCOSDictionary() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature(new COSDictionary());

    // Act and Assert
    assertEquals(0, pdSignature.getSignedContent("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Test {@link PDSignature#getSignedContent(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  @DisplayName("Test getSignedContent(byte[]) with 'byte[]'; given PDSignature(); then return array length is zero")
  void testGetSignedContentWithByte_givenPDSignature_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act and Assert
    assertEquals(0, pdSignature.getSignedContent("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Test {@link PDSignature#getSignedContent(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  @DisplayName("Test getSignedContent(byte[]) with 'byte[]'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetSignedContentWithByte_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{Integer.MIN_VALUE, -1, 2, -1});

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getSignedContent(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  @DisplayName("Test getSignedContent(InputStream) with 'InputStream'")
  void testGetSignedContentWithInputStream() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{Integer.MIN_VALUE, -1, 2, -1});
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent(pdfFile);

    // Assert
    assertEquals(-1, pdfFile.read(new byte[]{}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getSignedContent(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  @DisplayName("Test getSignedContent(InputStream) with 'InputStream'; given PDSignature(COSDictionary) with dict is COSDictionary()")
  void testGetSignedContentWithInputStream_givenPDSignatureWithDictIsCOSDictionary() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature(new COSDictionary());
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(0, pdSignature.getSignedContent(pdfFile).length);
    byte[] byteArray = new byte[8];
    assertEquals(8, pdfFile.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDSignature#getSignedContent(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  @DisplayName("Test getSignedContent(InputStream) with 'InputStream'; given PDSignature(); then return array length is zero")
  void testGetSignedContentWithInputStream_givenPDSignature_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(0, pdSignature.getSignedContent(pdfFile).length);
    byte[] byteArray = new byte[8];
    assertEquals(8, pdfFile.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDSignature#getPropBuild()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getPropBuild()}
   */
  @Test
  @DisplayName("Test getPropBuild(); given PDSignature(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetPropBuild_givenPDSignatureWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature(new COSDictionary())).getPropBuild());
  }

  /**
   * Test {@link PDSignature#getPropBuild()}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getPropBuild()}
   */
  @Test
  @DisplayName("Test getPropBuild(); given PDSignature(); then return 'null'")
  void testGetPropBuild_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getPropBuild());
  }

  /**
   * Test {@link PDSignature#getPropBuild()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#getPropBuild()}
   */
  @Test
  @DisplayName("Test getPropBuild(); then return COSObject UpdateState OriginDocumentState is 'null'")
  void testGetPropBuild_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setPropBuild(new PDPropBuild());

    // Act
    PDPropBuild actualPropBuild = pdSignature.getPropBuild();

    // Assert
    COSDictionary cOSObject = actualPropBuild.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPropBuild.getApp());
    assertNull(actualPropBuild.getFilter());
    assertNull(actualPropBuild.getPubSec());
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
   * Test {@link PDSignature#setPropBuild(PDPropBuild)}.
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} PropBuild App is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setPropBuild(PDPropBuild)}
   */
  @Test
  @DisplayName("Test setPropBuild(PDPropBuild); given PDSignature(); then PDSignature() PropBuild App is 'null'")
  void testSetPropBuild_givenPDSignature_thenPDSignaturePropBuildAppIsNull() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setPropBuild(new PDPropBuild());

    // Assert
    PDPropBuild propBuild = pdSignature.getPropBuild();
    assertNull(propBuild.getApp());
    assertNull(propBuild.getFilter());
    assertNull(propBuild.getPubSec());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setPropBuild(PDPropBuild)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignature#setPropBuild(PDPropBuild)}
   */
  @Test
  @DisplayName("Test setPropBuild(PDPropBuild); when 'null'; then PDSignature() COSObject Values size is one")
  void testSetPropBuild_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setPropBuild(null);

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
