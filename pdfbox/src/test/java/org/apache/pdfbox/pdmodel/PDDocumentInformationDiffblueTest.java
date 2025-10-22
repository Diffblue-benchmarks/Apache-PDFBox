package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDocumentInformationDiffblueTest {
  /**
   * Test {@link PDDocumentInformation#PDDocumentInformation(COSDictionary)}.
   * <p>
   * Method under test: {@link PDDocumentInformation#PDDocumentInformation(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentInformation(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.<init>(COSDictionary)"})
  void testNewPDDocumentInformation() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDDocumentInformation(dic)).getCOSObject());
  }

  /**
   * Test {@link PDDocumentInformation#PDDocumentInformation()}.
   * <p>
   * Method under test: {@link PDDocumentInformation#PDDocumentInformation()}
   */
  @Test
  @DisplayName("Test new PDDocumentInformation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.<init>()"})
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
    assertTrue(actualPdDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDDocumentInformation#getCOSObject()}.
   * <p>
   * Method under test: {@link PDDocumentInformation#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDDocumentInformation.getCOSObject()"})
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
   * Test {@link PDDocumentInformation#getPropertyStringValue(String)}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation(COSDictionary)} with dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getPropertyStringValue(String)}
   */
  @Test
  @DisplayName("Test getPropertyStringValue(String); given PDDocumentInformation(COSDictionary) with dic is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDDocumentInformation.getPropertyStringValue(String)"})
  void testGetPropertyStringValue_givenPDDocumentInformationWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation(new COSDictionary())).getPropertyStringValue("Property Key"));
  }

  /**
   * Test {@link PDDocumentInformation#getPropertyStringValue(String)}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getPropertyStringValue(String)}
   */
  @Test
  @DisplayName("Test getPropertyStringValue(String); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDDocumentInformation.getPropertyStringValue(String)"})
  void testGetPropertyStringValue_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getPropertyStringValue("Property Key"));
  }

  /**
   * Test {@link PDDocumentInformation#getTitle()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Title is {@code Dr}.</li>
   *   <li>Then return {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDDocumentInformation() Title is 'Dr'; then return 'Dr'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getTitle()"})
  void testGetTitle_givenPDDocumentInformationTitleIsDr_thenReturnDr() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTitle("Dr");

    // Act and Assert
    assertEquals("Dr", pdDocumentInformation.getTitle());
  }

  /**
   * Test {@link PDDocumentInformation#getTitle()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Title is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDDocumentInformation() Title is empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getTitle()"})
  void testGetTitle_givenPDDocumentInformationTitleIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTitle("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getTitle());
  }

  /**
   * Test {@link PDDocumentInformation#getTitle()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getTitle()"})
  void testGetTitle_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getTitle());
  }

  /**
   * Test {@link PDDocumentInformation#setTitle(String)}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Title is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String); given PDDocumentInformation(); then PDDocumentInformation() Title is 'Dr'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setTitle(String)"})
  void testSetTitle_givenPDDocumentInformation_thenPDDocumentInformationTitleIsDr() {
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
   * Test {@link PDDocumentInformation#getAuthor()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Author is {@code JaneDoe}.</li>
   *   <li>Then return {@code JaneDoe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getAuthor()}
   */
  @Test
  @DisplayName("Test getAuthor(); given PDDocumentInformation() Author is 'JaneDoe'; then return 'JaneDoe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getAuthor()"})
  void testGetAuthor_givenPDDocumentInformationAuthorIsJaneDoe_thenReturnJaneDoe() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setAuthor("JaneDoe");

    // Act and Assert
    assertEquals("JaneDoe", pdDocumentInformation.getAuthor());
  }

  /**
   * Test {@link PDDocumentInformation#getAuthor()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getAuthor()}
   */
  @Test
  @DisplayName("Test getAuthor(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getAuthor()"})
  void testGetAuthor_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getAuthor());
  }

  /**
   * Test {@link PDDocumentInformation#getAuthor()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getAuthor()}
   */
  @Test
  @DisplayName("Test getAuthor(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getAuthor()"})
  void testGetAuthor_thenReturnEmptyString() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setAuthor("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getAuthor());
  }

  /**
   * Test {@link PDDocumentInformation#setAuthor(String)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Author is {@code JaneDoe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setAuthor(String)}
   */
  @Test
  @DisplayName("Test setAuthor(String); then PDDocumentInformation() Author is 'JaneDoe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setAuthor(String)"})
  void testSetAuthor_thenPDDocumentInformationAuthorIsJaneDoe() {
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
   * Test {@link PDDocumentInformation#getSubject()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getSubject()"})
  void testGetSubject_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getSubject());
  }

  /**
   * Test {@link PDDocumentInformation#getSubject()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getSubject()"})
  void testGetSubject_thenReturnEmptyString() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setSubject("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getSubject());
  }

  /**
   * Test {@link PDDocumentInformation#getSubject()}.
   * <ul>
   *   <li>Then return {@code Hello from the Dreaming Spires}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); then return 'Hello from the Dreaming Spires'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getSubject()"})
  void testGetSubject_thenReturnHelloFromTheDreamingSpires() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertEquals("Hello from the Dreaming Spires", pdDocumentInformation.getSubject());
  }

  /**
   * Test {@link PDDocumentInformation#setSubject(String)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Subject is {@code Hello from the Dreaming Spires}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setSubject(String)}
   */
  @Test
  @DisplayName("Test setSubject(String); then PDDocumentInformation() Subject is 'Hello from the Dreaming Spires'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setSubject(String)"})
  void testSetSubject_thenPDDocumentInformationSubjectIsHelloFromTheDreamingSpires() {
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
   * Test {@link PDDocumentInformation#getKeywords()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Keywords is {@code Keywords}.</li>
   *   <li>Then return {@code Keywords}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getKeywords()}
   */
  @Test
  @DisplayName("Test getKeywords(); given PDDocumentInformation() Keywords is 'Keywords'; then return 'Keywords'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getKeywords()"})
  void testGetKeywords_givenPDDocumentInformationKeywordsIsKeywords_thenReturnKeywords() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setKeywords("Keywords");

    // Act and Assert
    assertEquals("Keywords", pdDocumentInformation.getKeywords());
  }

  /**
   * Test {@link PDDocumentInformation#getKeywords()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getKeywords()}
   */
  @Test
  @DisplayName("Test getKeywords(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getKeywords()"})
  void testGetKeywords_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getKeywords());
  }

  /**
   * Test {@link PDDocumentInformation#getKeywords()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getKeywords()}
   */
  @Test
  @DisplayName("Test getKeywords(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getKeywords()"})
  void testGetKeywords_thenReturnEmptyString() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setKeywords("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getKeywords());
  }

  /**
   * Test {@link PDDocumentInformation#setKeywords(String)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Keywords is {@code Keywords}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setKeywords(String)}
   */
  @Test
  @DisplayName("Test setKeywords(String); then PDDocumentInformation() Keywords is 'Keywords'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setKeywords(String)"})
  void testSetKeywords_thenPDDocumentInformationKeywordsIsKeywords() {
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
   * Test {@link PDDocumentInformation#getCreator()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Creator is {@code Creator}.</li>
   *   <li>Then return {@code Creator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCreator()}
   */
  @Test
  @DisplayName("Test getCreator(); given PDDocumentInformation() Creator is 'Creator'; then return 'Creator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getCreator()"})
  void testGetCreator_givenPDDocumentInformationCreatorIsCreator_thenReturnCreator() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreator("Creator");

    // Act and Assert
    assertEquals("Creator", pdDocumentInformation.getCreator());
  }

  /**
   * Test {@link PDDocumentInformation#getCreator()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCreator()}
   */
  @Test
  @DisplayName("Test getCreator(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getCreator()"})
  void testGetCreator_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getCreator());
  }

  /**
   * Test {@link PDDocumentInformation#getCreator()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCreator()}
   */
  @Test
  @DisplayName("Test getCreator(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getCreator()"})
  void testGetCreator_thenReturnEmptyString() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreator("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getCreator());
  }

  /**
   * Test {@link PDDocumentInformation#setCreator(String)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Creator is {@code Creator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setCreator(String)}
   */
  @Test
  @DisplayName("Test setCreator(String); then PDDocumentInformation() Creator is 'Creator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setCreator(String)"})
  void testSetCreator_thenPDDocumentInformationCreatorIsCreator() {
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
   * Test {@link PDDocumentInformation#getProducer()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Producer is {@code Producer}.</li>
   *   <li>Then return {@code Producer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getProducer()}
   */
  @Test
  @DisplayName("Test getProducer(); given PDDocumentInformation() Producer is 'Producer'; then return 'Producer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getProducer()"})
  void testGetProducer_givenPDDocumentInformationProducerIsProducer_thenReturnProducer() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setProducer("Producer");

    // Act and Assert
    assertEquals("Producer", pdDocumentInformation.getProducer());
  }

  /**
   * Test {@link PDDocumentInformation#getProducer()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getProducer()}
   */
  @Test
  @DisplayName("Test getProducer(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getProducer()"})
  void testGetProducer_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getProducer());
  }

  /**
   * Test {@link PDDocumentInformation#getProducer()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getProducer()}
   */
  @Test
  @DisplayName("Test getProducer(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getProducer()"})
  void testGetProducer_thenReturnEmptyString() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setProducer("");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getProducer());
  }

  /**
   * Test {@link PDDocumentInformation#setProducer(String)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Producer is {@code Producer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setProducer(String)}
   */
  @Test
  @DisplayName("Test setProducer(String); then PDDocumentInformation() Producer is 'Producer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setProducer(String)"})
  void testSetProducer_thenPDDocumentInformationProducerIsProducer() {
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
   * Test {@link PDDocumentInformation#getCreationDate()}.
   * <p>
   * Method under test: {@link PDDocumentInformation#getCreationDate()}
   */
  @Test
  @DisplayName("Test getCreationDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar PDDocumentInformation.getCreationDate()"})
  void testGetCreationDate() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreationDate(new GregorianCalendar(Integer.MIN_VALUE, 1, 1));

    // Act and Assert
    assertNull(pdDocumentInformation.getCreationDate());
  }

  /**
   * Test {@link PDDocumentInformation#getCreationDate()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCreationDate()}
   */
  @Test
  @DisplayName("Test getCreationDate(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar PDDocumentInformation.getCreationDate()"})
  void testGetCreationDate_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getCreationDate());
  }

  /**
   * Test {@link PDDocumentInformation#getCreationDate()}.
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCreationDate()}
   */
  @Test
  @DisplayName("Test getCreationDate(); then return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar PDDocumentInformation.getCreationDate()"})
  void testGetCreationDate_thenReturnGregorianCalendar() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualCreationDate = pdDocumentInformation.getCreationDate();

    // Assert
    assertTrue(actualCreationDate instanceof GregorianCalendar);
    assertEquals("gregory", actualCreationDate.getCalendarType());
    assertEquals(1, actualCreationDate.getFirstDayOfWeek());
    assertEquals(1, actualCreationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualCreationDate.getWeekYear());
    assertEquals(53, actualCreationDate.getWeeksInWeekYear());
    assertFalse(actualCreationDate.isLenient());
    assertTrue(actualCreationDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDDocumentInformation#setCreationDate(Calendar)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} CreationDate {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreationDate(Calendar); then PDDocumentInformation() CreationDate GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setCreationDate(Calendar)"})
  void testSetCreationDate_thenPDDocumentInformationCreationDateGregorianCalendar() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = pdDocumentInformation.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
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
   * Test {@link PDDocumentInformation#setCreationDate(Calendar)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreationDate(Calendar); when 'null'; then PDDocumentInformation() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setCreationDate(Calendar)"})
  void testSetCreationDate_whenNull_thenPDDocumentInformationCOSObjectSizeIsZero() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setCreationDate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDDocumentInformation#getModificationDate()}.
   * <p>
   * Method under test: {@link PDDocumentInformation#getModificationDate()}
   */
  @Test
  @DisplayName("Test getModificationDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar PDDocumentInformation.getModificationDate()"})
  void testGetModificationDate() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setModificationDate(new GregorianCalendar(Integer.MIN_VALUE, 1, 1));

    // Act and Assert
    assertNull(pdDocumentInformation.getModificationDate());
  }

  /**
   * Test {@link PDDocumentInformation#getModificationDate()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getModificationDate()}
   */
  @Test
  @DisplayName("Test getModificationDate(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar PDDocumentInformation.getModificationDate()"})
  void testGetModificationDate_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getModificationDate());
  }

  /**
   * Test {@link PDDocumentInformation#getModificationDate()}.
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getModificationDate()}
   */
  @Test
  @DisplayName("Test getModificationDate(); then return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar PDDocumentInformation.getModificationDate()"})
  void testGetModificationDate_thenReturnGregorianCalendar() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setModificationDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualModificationDate = pdDocumentInformation.getModificationDate();

    // Assert
    assertTrue(actualModificationDate instanceof GregorianCalendar);
    assertEquals("gregory", actualModificationDate.getCalendarType());
    assertEquals(1, actualModificationDate.getFirstDayOfWeek());
    assertEquals(1, actualModificationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualModificationDate.getWeekYear());
    assertEquals(53, actualModificationDate.getWeeksInWeekYear());
    assertFalse(actualModificationDate.isLenient());
    assertTrue(actualModificationDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDDocumentInformation#setModificationDate(Calendar)}.
   * <p>
   * Method under test: {@link PDDocumentInformation#setModificationDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModificationDate(Calendar)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setModificationDate(Calendar)"})
  void testSetModificationDate() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setModificationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar modificationDate = pdDocumentInformation.getModificationDate();
    assertTrue(modificationDate instanceof GregorianCalendar);
    assertEquals("gregory", modificationDate.getCalendarType());
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
   * Test {@link PDDocumentInformation#setModificationDate(Calendar)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setModificationDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModificationDate(Calendar); when 'null'; then PDDocumentInformation() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setModificationDate(Calendar)"})
  void testSetModificationDate_whenNull_thenPDDocumentInformationCOSObjectSizeIsZero() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setModificationDate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDDocumentInformation#getTrapped()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Trapped is {@code False}.</li>
   *   <li>Then return {@code False}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getTrapped()}
   */
  @Test
  @DisplayName("Test getTrapped(); given PDDocumentInformation() Trapped is 'False'; then return 'False'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getTrapped()"})
  void testGetTrapped_givenPDDocumentInformationTrappedIsFalse_thenReturnFalse() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setTrapped("False");

    // Act and Assert
    assertEquals("False", pdDocumentInformation.getTrapped());
  }

  /**
   * Test {@link PDDocumentInformation#getTrapped()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getTrapped()}
   */
  @Test
  @DisplayName("Test getTrapped(); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getTrapped()"})
  void testGetTrapped_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getTrapped());
  }

  /**
   * Test {@link PDDocumentInformation#getMetadataKeys()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()} Title is {@code Dr}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getMetadataKeys()}
   */
  @Test
  @DisplayName("Test getMetadataKeys(); given PDDocumentInformation() Title is 'Dr'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set PDDocumentInformation.getMetadataKeys()"})
  void testGetMetadataKeys_givenPDDocumentInformationTitleIsDr_thenReturnSizeIsOne() {
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
   * Test {@link PDDocumentInformation#getMetadataKeys()}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getMetadataKeys()}
   */
  @Test
  @DisplayName("Test getMetadataKeys(); given PDDocumentInformation(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set PDDocumentInformation.getMetadataKeys()"})
  void testGetMetadataKeys_givenPDDocumentInformation_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDocumentInformation()).getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDDocumentInformation#getCustomMetadataValue(String)}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCustomMetadataValue(String)}
   */
  @Test
  @DisplayName("Test getCustomMetadataValue(String); given PDDocumentInformation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getCustomMetadataValue(String)"})
  void testGetCustomMetadataValue_givenPDDocumentInformation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getCustomMetadataValue("Field Name"));
  }

  /**
   * Test {@link PDDocumentInformation#getCustomMetadataValue(String)}.
   * <ul>
   *   <li>Given {@link PDDocumentInformation#PDDocumentInformation()}.</li>
   *   <li>When {@code False}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCustomMetadataValue(String)}
   */
  @Test
  @DisplayName("Test getCustomMetadataValue(String); given PDDocumentInformation(); when 'False'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getCustomMetadataValue(String)"})
  void testGetCustomMetadataValue_givenPDDocumentInformation_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentInformation()).getCustomMetadataValue("False"));
  }

  /**
   * Test {@link PDDocumentInformation#getCustomMetadataValue(String)}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCustomMetadataValue(String)}
   */
  @Test
  @DisplayName("Test getCustomMetadataValue(String); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getCustomMetadataValue(String)"})
  void testGetCustomMetadataValue_thenReturn42() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCustomMetadataValue("Field Name", "42");

    // Act and Assert
    assertEquals("42", pdDocumentInformation.getCustomMetadataValue("Field Name"));
  }

  /**
   * Test {@link PDDocumentInformation#getCustomMetadataValue(String)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#getCustomMetadataValue(String)}
   */
  @Test
  @DisplayName("Test getCustomMetadataValue(String); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDocumentInformation.getCustomMetadataValue(String)"})
  void testGetCustomMetadataValue_thenReturnEmptyString() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
    pdDocumentInformation.setCustomMetadataValue("Field Name", "");

    // Act and Assert
    assertEquals("", pdDocumentInformation.getCustomMetadataValue("Field Name"));
  }

  /**
   * Test {@link PDDocumentInformation#setCustomMetadataValue(String, String)}.
   * <p>
   * Method under test: {@link PDDocumentInformation#setCustomMetadataValue(String, String)}
   */
  @Test
  @DisplayName("Test setCustomMetadataValue(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setCustomMetadataValue(String, String)"})
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
   * Test {@link PDDocumentInformation#setCustomMetadataValue(String, String)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} MetadataKeys contains {@code False}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setCustomMetadataValue(String, String)}
   */
  @Test
  @DisplayName("Test setCustomMetadataValue(String, String); then PDDocumentInformation() MetadataKeys contains 'False'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setCustomMetadataValue(String, String)"})
  void testSetCustomMetadataValue_thenPDDocumentInformationMetadataKeysContainsFalse() {
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
   * Test {@link PDDocumentInformation#setTrapped(String)}.
   * <ul>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation(COSDictionary)} with dic is {@link COSDictionary#COSDictionary()} Trapped is {@code True}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  @DisplayName("Test setTrapped(String); then PDDocumentInformation(COSDictionary) with dic is COSDictionary() Trapped is 'True'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setTrapped(String)"})
  void testSetTrapped_thenPDDocumentInformationWithDicIsCOSDictionaryTrappedIsTrue() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation(new COSDictionary());

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
   * Test {@link PDDocumentInformation#setTrapped(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  @DisplayName("Test setTrapped(String); when '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setTrapped(String)"})
  void testSetTrapped_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDDocumentInformation()).setTrapped("42"));
  }

  /**
   * Test {@link PDDocumentInformation#setTrapped(String)}.
   * <ul>
   *   <li>When {@code False}.</li>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Trapped is {@code False}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  @DisplayName("Test setTrapped(String); when 'False'; then PDDocumentInformation() Trapped is 'False'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setTrapped(String)"})
  void testSetTrapped_whenFalse_thenPDDocumentInformationTrappedIsFalse() {
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
   * Test {@link PDDocumentInformation#setTrapped(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  @DisplayName("Test setTrapped(String); when 'null'; then PDDocumentInformation() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setTrapped(String)"})
  void testSetTrapped_whenNull_thenPDDocumentInformationCOSObjectSizeIsZero() {
    // Arrange
    PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();

    // Act
    pdDocumentInformation.setTrapped(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDocumentInformation.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDocumentInformation.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDDocumentInformation#setTrapped(String)}.
   * <ul>
   *   <li>When {@code True}.</li>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Trapped is {@code True}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  @DisplayName("Test setTrapped(String); when 'True'; then PDDocumentInformation() Trapped is 'True'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setTrapped(String)"})
  void testSetTrapped_whenTrue_thenPDDocumentInformationTrappedIsTrue() {
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
   * Test {@link PDDocumentInformation#setTrapped(String)}.
   * <ul>
   *   <li>When {@code Unknown}.</li>
   *   <li>Then {@link PDDocumentInformation#PDDocumentInformation()} Trapped is {@code Unknown}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentInformation#setTrapped(String)}
   */
  @Test
  @DisplayName("Test setTrapped(String); when 'Unknown'; then PDDocumentInformation() Trapped is 'Unknown'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentInformation.setTrapped(String)"})
  void testSetTrapped_whenUnknown_thenPDDocumentInformationTrappedIsUnknown() {
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
}
