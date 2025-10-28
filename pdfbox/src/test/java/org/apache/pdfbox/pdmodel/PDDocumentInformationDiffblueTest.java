package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDDocumentInformationDiffblueTest {
  /**
   * Method under test: {@link PDDocumentInformation#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDDocumentInformation()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#getPropertyStringValue(String)}
   */
  @Test
  void testGetPropertyStringValue() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getPropertyStringValue("Property Key"));
    assertNull((new PDDocumentInformation(new COSDictionary())).getPropertyStringValue("Property Key"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getTitle());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getTitle()}
   */
  @Test
  void testGetTitle2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTitle("Dr");

    // Act and Assert
    assertEquals("Dr", pdDocumentInformation.getTitle());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getTitle()}
   */
  @Test
  void testGetTitle3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTitle("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getTitle());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setTitle(String)}
   */
  @Test
  void testSetTitle() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setTitle("Dr");

    // Assert
    assertEquals("Dr", pdDocumentInformation.getTitle());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Title"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#getAuthor()}
   */
  @Test
  void testGetAuthor() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getAuthor());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getAuthor()}
   */
  @Test
  void testGetAuthor2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setAuthor("JaneDoe");

    // Act and Assert
    assertEquals("JaneDoe", pdDocumentInformation.getAuthor());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getAuthor()}
   */
  @Test
  void testGetAuthor3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setAuthor("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getAuthor());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setAuthor(String)}
   */
  @Test
  void testSetAuthor() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setAuthor("JaneDoe");

    // Assert
    assertEquals("JaneDoe", pdDocumentInformation.getAuthor());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Author"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#getSubject()}
   */
  @Test
  void testGetSubject() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getSubject());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getSubject()}
   */
  @Test
  void testGetSubject2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertEquals("Hello from the Dreaming Spires", pdDocumentInformation.getSubject());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getSubject()}
   */
  @Test
  void testGetSubject3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setSubject("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getSubject());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setSubject(String)}
   */
  @Test
  void testSetSubject() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setSubject("Hello from the Dreaming Spires");

    // Assert
    assertEquals("Hello from the Dreaming Spires", pdDocumentInformation.getSubject());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Subject"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#getKeywords()}
   */
  @Test
  void testGetKeywords() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getKeywords());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getKeywords()}
   */
  @Test
  void testGetKeywords2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setKeywords("Keywords");

    // Act and Assert
    assertEquals("Keywords", pdDocumentInformation.getKeywords());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getKeywords()}
   */
  @Test
  void testGetKeywords3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setKeywords("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getKeywords());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setKeywords(String)}
   */
  @Test
  void testSetKeywords() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setKeywords("Keywords");

    // Assert
    assertEquals("Keywords", pdDocumentInformation.getKeywords());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Keywords"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#getCreator()}
   */
  @Test
  void testGetCreator() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getCreator());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getCreator()}
   */
  @Test
  void testGetCreator2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreator("Creator");

    // Act and Assert
    assertEquals("Creator", pdDocumentInformation.getCreator());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getCreator()}
   */
  @Test
  void testGetCreator3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreator("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getCreator());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setCreator(String)}
   */
  @Test
  void testSetCreator() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setCreator("Creator");

    // Assert
    assertEquals("Creator", pdDocumentInformation.getCreator());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Creator"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#getProducer()}
   */
  @Test
  void testGetProducer() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getProducer());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getProducer()}
   */
  @Test
  void testGetProducer2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setProducer("Producer");

    // Act and Assert
    assertEquals("Producer", pdDocumentInformation.getProducer());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getProducer()}
   */
  @Test
  void testGetProducer3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setProducer("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getProducer());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setProducer(String)}
   */
  @Test
  void testSetProducer() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setProducer("Producer");

    // Assert
    assertEquals("Producer", pdDocumentInformation.getProducer());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Producer"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#getCreationDate()}
   */
  @Test
  void testGetCreationDate() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getCreationDate());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getCreationDate()}
   */
  @Test
  void testGetCreationDate2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualCreationDate = pdDocumentInformation.getCreationDate();

    // Assert
    assertTrue(actualCreationDate instanceof GregorianCalendar);
    assertEquals("gregory", actualCreationDate.getCalendarType());
    assertEquals(0, actualCreationDate.getTimeZone().getDSTSavings());
    assertEquals(1, actualCreationDate.getFirstDayOfWeek());
    assertEquals(1, actualCreationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualCreationDate.getWeekYear());
    assertEquals(53, actualCreationDate.getWeeksInWeekYear());
    assertFalse(actualCreationDate.isLenient());
    assertTrue(actualCreationDate.isWeekDateSupported());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getCreationDate()}
   */
  @Test
  void testGetCreationDate3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreationDate(new GregorianCalendar(Integer.MIN_VALUE, 1, 1));

    // Act and Assert
    assertNull(pdDocumentInformation.getCreationDate());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = pdDocumentInformation.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
    assertEquals(0, creationDate.getTimeZone().getDSTSavings());
    assertEquals(1, creationDate.getFirstDayOfWeek());
    assertEquals(1, creationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, creationDate.getWeekYear());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertEquals(53, creationDate.getWeeksInWeekYear());
    assertFalse(creationDate.isLenient());
    assertTrue(creationDate.isWeekDateSupported());
    assertTrue(metadataKeys.contains("CreationDate"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setCreationDate(null);

    // Assert
    assertNull(pdDocumentInformation.getCreationDate());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getModificationDate()}
   */
  @Test
  void testGetModificationDate() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getModificationDate());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getModificationDate()}
   */
  @Test
  void testGetModificationDate2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setModificationDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualModificationDate = pdDocumentInformation.getModificationDate();

    // Assert
    assertTrue(actualModificationDate instanceof GregorianCalendar);
    assertEquals("gregory", actualModificationDate.getCalendarType());
    assertEquals(0, actualModificationDate.getTimeZone().getDSTSavings());
    assertEquals(1, actualModificationDate.getFirstDayOfWeek());
    assertEquals(1, actualModificationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualModificationDate.getWeekYear());
    assertEquals(53, actualModificationDate.getWeeksInWeekYear());
    assertFalse(actualModificationDate.isLenient());
    assertTrue(actualModificationDate.isWeekDateSupported());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getModificationDate()}
   */
  @Test
  void testGetModificationDate3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setModificationDate(new GregorianCalendar(Integer.MIN_VALUE, 1, 1));

    // Act and Assert
    assertNull(pdDocumentInformation.getModificationDate());
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#setModificationDate(Calendar)}
   */
  @Test
  void testSetModificationDate() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setModificationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar modificationDate = pdDocumentInformation.getModificationDate();
    assertTrue(modificationDate instanceof GregorianCalendar);
    assertEquals("gregory", modificationDate.getCalendarType());
    assertEquals(0, modificationDate.getTimeZone().getDSTSavings());
    assertEquals(1, modificationDate.getFirstDayOfWeek());
    assertEquals(1, modificationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, modificationDate.getWeekYear());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertEquals(53, modificationDate.getWeeksInWeekYear());
    assertFalse(modificationDate.isLenient());
    assertTrue(modificationDate.isWeekDateSupported());
    assertTrue(metadataKeys.contains("ModDate"));
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#setModificationDate(Calendar)}
   */
  @Test
  void testSetModificationDate2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setModificationDate(null);

    // Assert
    assertNull(pdDocumentInformation.getModificationDate());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getTrapped()}
   */
  @Test
  void testGetTrapped() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getTrapped());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getTrapped()}
   */
  @Test
  void testGetTrapped2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTrapped("False");

    // Act and Assert
    assertEquals("False", pdDocumentInformation.getTrapped());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getMetadataKeys()}
   */
  @Test
  void testGetMetadataKeys() {
    // Arrange, Act and Assert
    assertTrue((new PDDocumentInformation()).getMetadataKeys().isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentInformation#getMetadataKeys()}
   */
  @Test
  void testGetMetadataKeys2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTitle("Dr");

    // Act
    Set<String> actualMetadataKeys = pdDocumentInformation.getMetadataKeys();

    // Assert
    assertEquals(1, actualMetadataKeys.size());
    assertTrue(actualMetadataKeys.contains("Title"));
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#getCustomMetadataValue(String)}
   */
  @Test
  void testGetCustomMetadataValue() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getCustomMetadataValue("Field Name"));
    assertNull((new PDDocumentInformation()).getCustomMetadataValue("org.apache.pdfbox.cos.COSName"));
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#getCustomMetadataValue(String)}
   */
  @Test
  void testGetCustomMetadataValue2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCustomMetadataValue("Field Name", "42");

    // Act and Assert
    assertEquals("42", pdDocumentInformation.getCustomMetadataValue("Field Name"));
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#getCustomMetadataValue(String)}
   */
  @Test
  void testGetCustomMetadataValue3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCustomMetadataValue("Field Name", "");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getCustomMetadataValue("Field Name"));
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#setCustomMetadataValue(String, String)}
   */
  @Test
  void testSetCustomMetadataValue() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setCustomMetadataValue("Field Name", "42");

    // Assert
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Field Name"));
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#setCustomMetadataValue(String, String)}
   */
  @Test
  void testSetCustomMetadataValue2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setCustomMetadataValue("False", "42");

    // Assert
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("False"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  void testSetTrapped() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDDocumentInformation()).setTrapped("42"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  void testSetTrapped2() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setTrapped("True");

    // Assert
    assertEquals("True", pdDocumentInformation.getTrapped());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Trapped"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  void testSetTrapped3() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setTrapped("False");

    // Assert
    assertEquals("False", pdDocumentInformation.getTrapped());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Trapped"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  void testSetTrapped4() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setTrapped("Unknown");

    // Assert
    assertEquals("Unknown", pdDocumentInformation.getTrapped());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertEquals(1, cOSObject.size());
    assertTrue(metadataKeys.contains("Trapped"));
  }

  /**
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  void testSetTrapped5() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setTrapped(null);

    // Assert
    assertNull(pdDocumentInformation.getTrapped());
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  void testSetTrapped6() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation(dic);

    // Act
    pdDocumentInformation.setTrapped("True");

    // Assert
    assertEquals("True", pdDocumentInformation.getTrapped());
    Set<String> metadataKeys = pdDocumentInformation.getMetadataKeys();
    assertEquals(1, metadataKeys.size());
    assertTrue(metadataKeys.contains("Trapped"));
    assertSame(dic, pdDocumentInformation.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentInformation#PDDocumentInformation(COSDictionary)}
   */
  @Test
  void testNewPDDocumentInformation() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDDocumentInformation(dic)).getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentInformation#PDDocumentInformation()}
   */
  @Test
  void testNewPDDocumentInformation2() {
    // Arrange and Act
    PDDocumentInformation actualPdDocumentInformation = new PDDocumentInformation();

    // Assert
    assertNull(actualPdDocumentInformation.getAuthor());
    assertNull(actualPdDocumentInformation.getCreator());
    assertNull(actualPdDocumentInformation.getKeywords());
    assertNull(actualPdDocumentInformation.getProducer());
    assertNull(actualPdDocumentInformation.getSubject());
    assertNull(actualPdDocumentInformation.getTitle());
    assertNull(actualPdDocumentInformation.getTrapped());
    assertNull(actualPdDocumentInformation.getCreationDate());
    assertNull(actualPdDocumentInformation.getModificationDate());
    COSDictionary cOSObject = actualPdDocumentInformation.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdDocumentInformation.getMetadataKeys().isEmpty());
  }
}
