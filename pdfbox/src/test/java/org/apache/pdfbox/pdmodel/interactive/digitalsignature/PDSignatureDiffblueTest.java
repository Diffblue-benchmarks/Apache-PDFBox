package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSignatureDiffblueTest {
  /**
   * Test {@link PDSignature#PDSignature(COSDictionary)}.
   *
   * <p>Method under test: {@link PDSignature#PDSignature(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDSignature(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.<init>(COSDictionary)"})
  void testNewPDSignature() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDSignature(dict).getCOSObject());
  }

  /**
   * Test {@link PDSignature#PDSignature()}.
   *
   * <p>Method under test: {@link PDSignature#PDSignature()}
   */
  @Test
  @DisplayName("Test new PDSignature()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.<init>()"})
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
    assertNull(actualPdSignature.getPropBuild());
    assertArrayEquals(new byte[] {}, actualPdSignature.getContents());
    assertArrayEquals(new int[] {}, actualPdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#getCOSObject()}.
   *
   * <p>Method under test: {@link PDSignature#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDSignature.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDSignature().getCOSObject();

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
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setType(COSName)}
   */
  @Test
  @DisplayName(
      "Test setType(COSName); given PDSignature(); then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setType(COSName)"})
  void testSetType_givenPDSignature_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setType(PDSignature.FILTER_ADOBE_PPKLITE);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setType(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setType(COSName)}
   */
  @Test
  @DisplayName(
      "Test setType(COSName); given PDSignature(); when 'null'; then PDSignature() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setType(COSName)"})
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
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then {@link PDSignature#PDSignature()} Filter is {@code Adobe.PPKLite}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setFilter(COSName)}
   */
  @Test
  @DisplayName(
      "Test setFilter(COSName); given PDSignature(); then PDSignature() Filter is 'Adobe.PPKLite'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setFilter(COSName)"})
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
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setFilter(COSName)}
   */
  @Test
  @DisplayName(
      "Test setFilter(COSName); given PDSignature(); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setFilter(COSName)"})
  void testSetFilter_givenPDSignature_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setFilter(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setSubFilter(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then {@link PDSignature#PDSignature()} SubFilter is {@code Adobe.PPKLite}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setSubFilter(COSName)}
   */
  @Test
  @DisplayName(
      "Test setSubFilter(COSName); given PDSignature(); then PDSignature() SubFilter is 'Adobe.PPKLite'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setSubFilter(COSName)"})
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setSubFilter(COSName)}
   */
  @Test
  @DisplayName(
      "Test setSubFilter(COSName); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setSubFilter(COSName)"})
  void testSetSubFilter_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setSubFilter(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setName(String)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@code Name}.
   *   <li>Then {@link PDSignature#PDSignature()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); given PDSignature(); when 'Name'; then PDSignature() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setName(String)"})
  void testSetName_givenPDSignature_whenName_thenPDSignatureNameIsName() {
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
   * Test {@link PDSignature#setName(String)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); given PDSignature(); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setName(String)"})
  void testSetName_givenPDSignature_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setLocation(String)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@code Location}.
   *   <li>Then {@link PDSignature#PDSignature()} Location is {@code Location}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setLocation(String)}
   */
  @Test
  @DisplayName(
      "Test setLocation(String); given PDSignature(); when 'Location'; then PDSignature() Location is 'Location'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setLocation(String)"})
  void testSetLocation_givenPDSignature_whenLocation_thenPDSignatureLocationIsLocation() {
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
   * Test {@link PDSignature#setLocation(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setLocation(String)}
   */
  @Test
  @DisplayName(
      "Test setLocation(String); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setLocation(String)"})
  void testSetLocation_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setLocation(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setReason(String)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@code Just cause}.
   *   <li>Then {@link PDSignature#PDSignature()} Reason is {@code Just cause}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setReason(String)}
   */
  @Test
  @DisplayName(
      "Test setReason(String); given PDSignature(); when 'Just cause'; then PDSignature() Reason is 'Just cause'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setReason(String)"})
  void testSetReason_givenPDSignature_whenJustCause_thenPDSignatureReasonIsJustCause() {
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
   * Test {@link PDSignature#setReason(String)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setReason(String)}
   */
  @Test
  @DisplayName(
      "Test setReason(String); given PDSignature(); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setReason(String)"})
  void testSetReason_givenPDSignature_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setReason(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setContactInfo(String)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then {@link PDSignature#PDSignature()} ContactInfo is {@code Contact Info}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setContactInfo(String)}
   */
  @Test
  @DisplayName(
      "Test setContactInfo(String); given PDSignature(); then PDSignature() ContactInfo is 'Contact Info'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setContactInfo(String)"})
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
   * Test {@link PDSignature#setContactInfo(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setContactInfo(String)}
   */
  @Test
  @DisplayName(
      "Test setContactInfo(String); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setContactInfo(String)"})
  void testSetContactInfo_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setContactInfo(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#setSignDate(Calendar)}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then {@link PDSignature#PDSignature()} SignDate {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setSignDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setSignDate(Calendar); given PDSignature(); then PDSignature() SignDate GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setSignDate(Calendar)"})
  void testSetSignDate_givenPDSignature_thenPDSignatureSignDateGregorianCalendar() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setSignDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar signDate = pdSignature.getSignDate();
    assertTrue(signDate instanceof GregorianCalendar);
    assertEquals("gregory", signDate.getCalendarType());
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setSignDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setSignDate(Calendar); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setSignDate(Calendar)"})
  void testSetSignDate_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setSignDate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDSignature#getFilter()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getFilter()"})
  void testGetFilter_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getFilter());
  }

  /**
   * Test {@link PDSignature#getFilter()}.
   *
   * <ul>
   *   <li>Then return {@code Adobe.PPKLite}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); then return 'Adobe.PPKLite'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getFilter()"})
  void testGetFilter_thenReturnAdobePPKLite() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSignature.getFilter());
  }

  /**
   * Test {@link PDSignature#getSubFilter()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getSubFilter()"})
  void testGetSubFilter_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getSubFilter());
  }

  /**
   * Test {@link PDSignature#getSubFilter()}.
   *
   * <ul>
   *   <li>Then return {@code Adobe.PPKLite}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); then return 'Adobe.PPKLite'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getSubFilter()"})
  void testGetSubFilter_thenReturnAdobePPKLite() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setSubFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSignature.getSubFilter());
  }

  /**
   * Test {@link PDSignature#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Name is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDSignature() Name is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getName()"})
  void testGetName_givenPDSignatureNameIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setName("");

    // Act and Assert
    assertEquals("", pdSignature.getName());
  }

  /**
   * Test {@link PDSignature#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Name is {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDSignature() Name is 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getName()"})
  void testGetName_givenPDSignatureNameIsName_thenReturnName() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setName("Name");

    // Act and Assert
    assertEquals("Name", pdSignature.getName());
  }

  /**
   * Test {@link PDSignature#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getName()"})
  void testGetName_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getName());
  }

  /**
   * Test {@link PDSignature#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Location is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  @DisplayName(
      "Test getLocation(); given PDSignature() Location is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getLocation()"})
  void testGetLocation_givenPDSignatureLocationIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setLocation("");

    // Act and Assert
    assertEquals("", pdSignature.getLocation());
  }

  /**
   * Test {@link PDSignature#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Location is {@code Location}.
   *   <li>Then return {@code Location}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  @DisplayName(
      "Test getLocation(); given PDSignature() Location is 'Location'; then return 'Location'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getLocation()"})
  void testGetLocation_givenPDSignatureLocationIsLocation_thenReturnLocation() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setLocation("Location");

    // Act and Assert
    assertEquals("Location", pdSignature.getLocation());
  }

  /**
   * Test {@link PDSignature#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getLocation()"})
  void testGetLocation_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getLocation());
  }

  /**
   * Test {@link PDSignature#getReason()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Reason is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getReason()}
   */
  @Test
  @DisplayName(
      "Test getReason(); given PDSignature() Reason is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getReason()"})
  void testGetReason_givenPDSignatureReasonIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setReason("");

    // Act and Assert
    assertEquals("", pdSignature.getReason());
  }

  /**
   * Test {@link PDSignature#getReason()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()} Reason is {@code Just cause}.
   *   <li>Then return {@code Just cause}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getReason()}
   */
  @Test
  @DisplayName(
      "Test getReason(); given PDSignature() Reason is 'Just cause'; then return 'Just cause'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getReason()"})
  void testGetReason_givenPDSignatureReasonIsJustCause_thenReturnJustCause() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setReason("Just cause");

    // Act and Assert
    assertEquals("Just cause", pdSignature.getReason());
  }

  /**
   * Test {@link PDSignature#getReason()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getReason()}
   */
  @Test
  @DisplayName("Test getReason(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getReason()"})
  void testGetReason_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getReason());
  }

  /**
   * Test {@link PDSignature#getContactInfo()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  @DisplayName("Test getContactInfo(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getContactInfo()"})
  void testGetContactInfo_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getContactInfo());
  }

  /**
   * Test {@link PDSignature#getContactInfo()}.
   *
   * <ul>
   *   <li>Then return {@code Contact Info}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  @DisplayName("Test getContactInfo(); then return 'Contact Info'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getContactInfo()"})
  void testGetContactInfo_thenReturnContactInfo() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContactInfo("Contact Info");

    // Act and Assert
    assertEquals("Contact Info", pdSignature.getContactInfo());
  }

  /**
   * Test {@link PDSignature#getContactInfo()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  @DisplayName("Test getContactInfo(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSignature.getContactInfo()"})
  void testGetContactInfo_thenReturnEmptyString() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContactInfo("");

    // Act and Assert
    assertEquals("", pdSignature.getContactInfo());
  }

  /**
   * Test {@link PDSignature#getSignDate()}.
   *
   * <ul>
   *   <li>Given {@link GregorianCalendar#GregorianCalendar(int, int, int)} with one and one and one
   *       add two and {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  @DisplayName(
      "Test getSignDate(); given GregorianCalendar(int, int, int) with one and one and one add two and MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar PDSignature.getSignDate()"})
  void testGetSignDate_givenGregorianCalendarWithOneAndOneAndOneAddTwoAndMin_value() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
    cal.add(2, Integer.MIN_VALUE);

    PDSignature pdSignature = new PDSignature();
    pdSignature.setSignDate(cal);

    // Act and Assert
    assertNull(pdSignature.getSignDate());
  }

  /**
   * Test {@link PDSignature#getSignDate()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  @DisplayName("Test getSignDate(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar PDSignature.getSignDate()"})
  void testGetSignDate_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getSignDate());
  }

  /**
   * Test {@link PDSignature#getSignDate()}.
   *
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  @DisplayName("Test getSignDate(); then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar PDSignature.getSignDate()"})
  void testGetSignDate_thenReturnGregorianCalendar() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setSignDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualSignDate = pdSignature.getSignDate();

    // Assert
    assertTrue(actualSignDate instanceof GregorianCalendar);
    assertEquals("gregory", actualSignDate.getCalendarType());
    assertEquals(1, actualSignDate.getFirstDayOfWeek());
    assertEquals(1, actualSignDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualSignDate.getWeekYear());
    assertEquals(53, actualSignDate.getWeeksInWeekYear());
    assertFalse(actualSignDate.isLenient());
    assertTrue(actualSignDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   *
   * <ul>
   *   <li>Then {@link PDSignature#PDSignature()} ByteRange is array of {@code int} with {@code
   *       1024} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName(
      "Test setByteRange(int[]); then PDSignature() ByteRange is array of int with '1024' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setByteRange(int[])"})
  void testSetByteRange_thenPDSignatureByteRangeIsArrayOfIntWith1024AndMinusOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[] {1024, -1, 1, -1});

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new int[] {1024, -1, 1, -1}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   *
   * <ul>
   *   <li>Then {@link PDSignature#PDSignature()} ByteRange is array of {@code int} with {@link
   *       Integer#MIN_VALUE} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName(
      "Test setByteRange(int[]); then PDSignature() ByteRange is array of int with MIN_VALUE and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setByteRange(int[])"})
  void testSetByteRange_thenPDSignatureByteRangeIsArrayOfIntWithMin_valueAndMinusOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[] {Integer.MIN_VALUE, -1, 1, -1});

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new int[] {Integer.MIN_VALUE, -1, 1, -1}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   *
   * <ul>
   *   <li>Then {@link PDSignature#PDSignature()} ByteRange is array of {@code int} with one and
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName(
      "Test setByteRange(int[]); then PDSignature() ByteRange is array of int with one and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setByteRange(int[])"})
  void testSetByteRange_thenPDSignatureByteRangeIsArrayOfIntWithOneAndMinusOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[] {1, -1, 1, -1});

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new int[] {1, -1, 1, -1}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#setByteRange(int[])}.
   *
   * <ul>
   *   <li>When empty array of {@code int}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  @DisplayName(
      "Test setByteRange(int[]); when empty array of int; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setByteRange(int[])"})
  void testSetByteRange_whenEmptyArrayOfInt_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setByteRange(new int[] {});

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals(new int[] {}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#getByteRange()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getByteRange()}
   */
  @Test
  @DisplayName("Test getByteRange(); given PDSignature(); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDSignature.getByteRange()"})
  void testGetByteRange_givenPDSignature_thenReturnEmptyArrayOfInt() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[] {}, new PDSignature().getByteRange());
  }

  /**
   * Test {@link PDSignature#getByteRange()}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getByteRange()}
   */
  @Test
  @DisplayName("Test getByteRange(); then return array of int with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDSignature.getByteRange()"})
  void testGetByteRange_thenReturnArrayOfIntWithOneAndZero() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {1, 0, 1, 0});

    // Act and Assert
    assertArrayEquals(new int[] {1, 0, 1, 0}, pdSignature.getByteRange());
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus ninety-six.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName(
      "Test getContents(byte[]) with 'byte[]'; then return array of byte with minus ninety-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(byte[])"})
  void testGetContentsWithByte_thenReturnArrayOfByteWithMinusNinetySix() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {1, 0, 4, 0});

    // Act
    byte[] actualContents = pdSignature.getContents("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[] {-96}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AX(XAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName(
      "Test getContents(byte[]) with 'byte[]'; when 'AX(XAXAX' Bytes is 'UTF-8'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(byte[])"})
  void testGetContentsWithByte_whenAxXaxaxBytesIsUtf8_thenReturnEmptyArrayOfByte()
      throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {1, 0, 4, 0});

    // Act
    byte[] actualContents = pdSignature.getContents("AX(XAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[] {}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AX)XAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName(
      "Test getContents(byte[]) with 'byte[]'; when 'AX)XAXAX' Bytes is 'UTF-8'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(byte[])"})
  void testGetContentsWithByte_whenAxXaxaxBytesIsUtf8_thenReturnEmptyArrayOfByte2()
      throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {1, 0, 4, 0});

    // Act
    byte[] actualContents = pdSignature.getContents("AX)XAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[] {}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AX<XAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName(
      "Test getContents(byte[]) with 'byte[]'; when 'AX<XAXAX' Bytes is 'UTF-8'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(byte[])"})
  void testGetContentsWithByte_whenAxXaxaxBytesIsUtf8_thenReturnEmptyArrayOfByte3()
      throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {1, 0, 4, 0});

    // Act
    byte[] actualContents = pdSignature.getContents("AX<XAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[] {}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  @DisplayName(
      "Test getContents(byte[]) with 'byte[]'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(byte[])"})
  void testGetContentsWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnEmptyArrayOfByte()
      throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {1, 0, 1, 0});

    // Act
    byte[] actualContents = pdSignature.getContents("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[] {}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link PDSignature#getContents(InputStream)}
   */
  @Test
  @DisplayName("Test getContents(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(InputStream)"})
  void testGetContentsWithInputStream() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {-1, 0, 1, 0});
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualContents = pdSignature.getContents(pdfFile);

    // Assert
    byte[] byteArray = new byte[7];
    assertEquals(7, pdfFile.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new byte[] {-96}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link PDSignature#getContents(InputStream)}
   */
  @Test
  @DisplayName("Test getContents(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(InputStream)"})
  void testGetContentsWithInputStream2() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {1, 0, 3, 0});
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualContents = pdSignature.getContents(pdfFile);

    // Assert
    byte[] byteArray = new byte[5];
    assertEquals(5, pdfFile.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new byte[] {-96}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link PDSignature#getContents(InputStream)}
   */
  @Test
  @DisplayName("Test getContents(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents(InputStream)"})
  void testGetContentsWithInputStream3() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {-1, 0, 1, 0});
    ByteArrayInputStream pdfFile =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    byte[] actualContents = pdSignature.getContents(pdfFile);

    // Assert
    byte[] byteArray = new byte[7];
    assertEquals(7, pdfFile.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new byte[] {}, actualContents);
  }

  /**
   * Test {@link PDSignature#getContents()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDSignature(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents()"})
  void testGetContents_givenPDSignature_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new PDSignature().getContents());
  }

  /**
   * Test {@link PDSignature#getContents()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getContents()"})
  void testGetContents_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContents("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), pdSignature.getContents());
  }

  /**
   * Test {@link PDSignature#setContents(byte[])}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setContents(byte[])}
   */
  @Test
  @DisplayName(
      "Test setContents(byte[]); given PDSignature(); then PDSignature() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setContents(byte[])"})
  void testSetContents_givenPDSignature_thenPDSignatureCOSObjectValuesSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setContents("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), pdSignature.getContents());
  }

  /**
   * Test {@link PDSignature#getSignedContent(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  @DisplayName(
      "Test getSignedContent(byte[]) with 'byte[]'; given PDSignature(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getSignedContent(byte[])"})
  void testGetSignedContentWithByte_givenPDSignature_thenReturnEmptyArrayOfByte()
      throws IOException {
    // Arrange and Act
    byte[] actualSignedContent = new PDSignature().getSignedContent("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[] {}, actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getSignedContent(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  @DisplayName("Test getSignedContent(byte[]) with 'byte[]'; then return 'AXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getSignedContent(byte[])"})
  void testGetSignedContentWithByte_thenReturnAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {2, 1, Integer.MIN_VALUE, -1});

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAX".getBytes("UTF-8"), actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getSignedContent(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  @DisplayName(
      "Test getSignedContent(byte[]) with 'byte[]'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getSignedContent(byte[])"})
  void testGetSignedContentWithByte_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {Integer.MIN_VALUE, -1, 2, -1});

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getSignedContent(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  @DisplayName("Test getSignedContent(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getSignedContent(InputStream)"})
  void testGetSignedContentWithInputStream() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent(pdfFile);

    // Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdfFile.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new byte[] {}, actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getSignedContent(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  @DisplayName(
      "Test getSignedContent(InputStream) with 'InputStream'; then return 'AXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getSignedContent(InputStream)"})
  void testGetSignedContentWithInputStream_thenReturnAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {2, 1, Integer.MIN_VALUE, -1});
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent(pdfFile);

    // Assert
    int actualReadResult = pdfFile.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals("AXAXAX".getBytes("UTF-8"), actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getSignedContent(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  @DisplayName(
      "Test getSignedContent(InputStream) with 'InputStream'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDSignature.getSignedContent(InputStream)"})
  void testGetSignedContentWithInputStream_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[] {Integer.MIN_VALUE, -1, 2, -1});
    ByteArrayInputStream pdfFile = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent(pdfFile);

    // Assert
    int actualReadResult = pdfFile.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSignedContent);
  }

  /**
   * Test {@link PDSignature#getPropBuild()}.
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getPropBuild()}
   */
  @Test
  @DisplayName("Test getPropBuild(); given PDSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropBuild PDSignature.getPropBuild()"})
  void testGetPropBuild_givenPDSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSignature().getPropBuild());
  }

  /**
   * Test {@link PDSignature#getPropBuild()}.
   *
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#getPropBuild()}
   */
  @Test
  @DisplayName(
      "Test getPropBuild(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropBuild PDSignature.getPropBuild()"})
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
   *
   * <ul>
   *   <li>Given {@link PDSignature#PDSignature()}.
   *   <li>Then {@link PDSignature#PDSignature()} PropBuild App is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setPropBuild(PDPropBuild)}
   */
  @Test
  @DisplayName(
      "Test setPropBuild(PDPropBuild); given PDSignature(); then PDSignature() PropBuild App is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setPropBuild(PDPropBuild)"})
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDSignature#PDSignature()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSignature#setPropBuild(PDPropBuild)}
   */
  @Test
  @DisplayName(
      "Test setPropBuild(PDPropBuild); when 'null'; then PDSignature() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSignature.setPropBuild(PDPropBuild)"})
  void testSetPropBuild_whenNull_thenPDSignatureCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setPropBuild(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
