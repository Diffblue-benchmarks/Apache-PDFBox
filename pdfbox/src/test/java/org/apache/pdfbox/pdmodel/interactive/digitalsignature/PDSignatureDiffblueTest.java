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
import org.junit.jupiter.api.Test;

class PDSignatureDiffblueTest {
  /**
   * Method under test: {@link PDSignature#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link PDSignature#setType(COSName)}
   */
  @Test
  void testSetType() {
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
   * Method under test: {@link PDSignature#setType(COSName)}
   */
  @Test
  void testSetType2() {
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
   * Method under test: {@link PDSignature#setFilter(COSName)}
   */
  @Test
  void testSetFilter() {
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
   * Method under test: {@link PDSignature#setFilter(COSName)}
   */
  @Test
  void testSetFilter2() {
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
   * Method under test: {@link PDSignature#setSubFilter(COSName)}
   */
  @Test
  void testSetSubFilter() {
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
   * Method under test: {@link PDSignature#setSubFilter(COSName)}
   */
  @Test
  void testSetSubFilter2() {
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
   * Method under test: {@link PDSignature#setName(String)}
   */
  @Test
  void testSetName() {
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
   * Method under test: {@link PDSignature#setLocation(String)}
   */
  @Test
  void testSetLocation() {
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
   * Method under test: {@link PDSignature#setReason(String)}
   */
  @Test
  void testSetReason() {
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
   * Method under test: {@link PDSignature#setContactInfo(String)}
   */
  @Test
  void testSetContactInfo() {
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
   * Method under test: {@link PDSignature#setSignDate(Calendar)}
   */
  @Test
  void testSetSignDate() {
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
   * Method under test: {@link PDSignature#setSignDate(Calendar)}
   */
  @Test
  void testSetSignDate2() {
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
   * Method under test: {@link PDSignature#getFilter()}
   */
  @Test
  void testGetFilter() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getFilter());
  }

  /**
   * Method under test: {@link PDSignature#getFilter()}
   */
  @Test
  void testGetFilter2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSignature.getFilter());
  }

  /**
   * Method under test: {@link PDSignature#getSubFilter()}
   */
  @Test
  void testGetSubFilter() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getSubFilter());
  }

  /**
   * Method under test: {@link PDSignature#getSubFilter()}
   */
  @Test
  void testGetSubFilter2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setSubFilter(PDSignature.FILTER_ADOBE_PPKLITE);

    // Act and Assert
    assertEquals("Adobe.PPKLite", pdSignature.getSubFilter());
  }

  /**
   * Method under test: {@link PDSignature#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getName());
  }

  /**
   * Method under test: {@link PDSignature#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setName("Name");

    // Act and Assert
    assertEquals("Name", pdSignature.getName());
  }

  /**
   * Method under test: {@link PDSignature#getName()}
   */
  @Test
  void testGetName3() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setName("");

    // Act and Assert
    assertEquals("", pdSignature.getName());
  }

  /**
   * Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  void testGetLocation() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getLocation());
  }

  /**
   * Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  void testGetLocation2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setLocation("Location");

    // Act and Assert
    assertEquals("Location", pdSignature.getLocation());
  }

  /**
   * Method under test: {@link PDSignature#getLocation()}
   */
  @Test
  void testGetLocation3() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setLocation("");

    // Act and Assert
    assertEquals("", pdSignature.getLocation());
  }

  /**
   * Method under test: {@link PDSignature#getReason()}
   */
  @Test
  void testGetReason() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getReason());
  }

  /**
   * Method under test: {@link PDSignature#getReason()}
   */
  @Test
  void testGetReason2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setReason("Just cause");

    // Act and Assert
    assertEquals("Just cause", pdSignature.getReason());
  }

  /**
   * Method under test: {@link PDSignature#getReason()}
   */
  @Test
  void testGetReason3() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setReason("");

    // Act and Assert
    assertEquals("", pdSignature.getReason());
  }

  /**
   * Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  void testGetContactInfo() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getContactInfo());
  }

  /**
   * Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  void testGetContactInfo2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContactInfo("Contact Info");

    // Act and Assert
    assertEquals("Contact Info", pdSignature.getContactInfo());
  }

  /**
   * Method under test: {@link PDSignature#getContactInfo()}
   */
  @Test
  void testGetContactInfo3() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContactInfo("");

    // Act and Assert
    assertEquals("", pdSignature.getContactInfo());
  }

  /**
   * Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  void testGetSignDate() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getSignDate());
  }

  /**
   * Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  void testGetSignDate2() {
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
   * Method under test: {@link PDSignature#getSignDate()}
   */
  @Test
  void testGetSignDate3() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setSignDate(new GregorianCalendar(Integer.MIN_VALUE, 1, 1));

    // Act and Assert
    assertNull(pdSignature.getSignDate());
  }

  /**
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  void testSetByteRange() {
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
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  void testSetByteRange2() {
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
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  void testSetByteRange3() {
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
   * Method under test: {@link PDSignature#setByteRange(int[])}
   */
  @Test
  void testSetByteRange4() {
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
   * Method under test: {@link PDSignature#getByteRange()}
   */
  @Test
  void testGetByteRange() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDSignature()).getByteRange().length);
  }

  /**
   * Method under test: {@link PDSignature#getByteRange()}
   */
  @Test
  void testGetByteRange2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 1, 0});

    // Act and Assert
    assertArrayEquals(new int[]{1, 0, 1, 0}, pdSignature.getByteRange());
  }

  /**
   * Method under test: {@link PDSignature#getContents()}
   */
  @Test
  void testGetContents() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDSignature()).getContents().length);
  }

  /**
   * Method under test: {@link PDSignature#getContents()}
   */
  @Test
  void testGetContents2() throws UnsupportedEncodingException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setContents("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualContents = pdSignature.getContents();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualContents);
  }

  /**
   * Method under test: {@link PDSignature#getContents(InputStream)}
   */
  @Test
  void testGetContents3() throws IOException {
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
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  void testGetContents4() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 1, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  void testGetContents5() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertArrayEquals(new byte[]{-96}, pdSignature.getContents("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  void testGetContents6() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AX(XAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  void testGetContents7() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AX)XAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  void testGetContents8() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AX<XAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link PDSignature#getContents(byte[])}
   */
  @Test
  void testGetContents9() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{1, 0, 4, 0});

    // Act and Assert
    assertEquals(0, pdSignature.getContents("AX>XAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link PDSignature#setContents(byte[])}
   */
  @Test
  void testSetContents() throws UnsupportedEncodingException {
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
   * Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  void testGetSignedContent() throws IOException {
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
   * Method under test: {@link PDSignature#getSignedContent(InputStream)}
   */
  @Test
  void testGetSignedContent2() throws IOException {
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
   * Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  void testGetSignedContent3() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act and Assert
    assertEquals(0, pdSignature.getSignedContent("AXAXAXAX".getBytes("UTF-8")).length);
  }

  /**
   * Method under test: {@link PDSignature#getSignedContent(byte[])}
   */
  @Test
  void testGetSignedContent4() throws IOException {
    // Arrange
    PDSignature pdSignature = new PDSignature();
    pdSignature.setByteRange(new int[]{Integer.MIN_VALUE, -1, 2, -1});

    // Act
    byte[] actualSignedContent = pdSignature.getSignedContent("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSignedContent);
  }

  /**
   * Method under test: {@link PDSignature#getPropBuild()}
   */
  @Test
  void testGetPropBuild() {
    // Arrange, Act and Assert
    assertNull((new PDSignature()).getPropBuild());
  }

  /**
   * Method under test: {@link PDSignature#getPropBuild()}
   */
  @Test
  void testGetPropBuild2() {
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
   * Method under test: {@link PDSignature#setPropBuild(PDPropBuild)}
   */
  @Test
  void testSetPropBuild() {
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
   * Method under test: {@link PDSignature#setPropBuild(PDPropBuild)}
   */
  @Test
  void testSetPropBuild2() {
    // Arrange
    PDSignature pdSignature = new PDSignature();

    // Act
    pdSignature.setPropBuild(null);

    // Assert
    assertNull(pdSignature.getPropBuild());
    COSDictionary cOSObject = pdSignature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignature#PDSignature(COSDictionary)}
   */
  @Test
  void testNewPDSignature() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDSignature(dict)).getCOSObject());
  }

  /**
   * Method under test: {@link PDSignature#PDSignature()}
   */
  @Test
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
}
