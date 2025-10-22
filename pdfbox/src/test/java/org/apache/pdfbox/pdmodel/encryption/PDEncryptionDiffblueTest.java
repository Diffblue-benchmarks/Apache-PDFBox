package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDEncryptionDiffblueTest {
  /**
   * Test {@link PDEncryption#PDEncryption()}.
   * <p>
   * Method under test: {@link PDEncryption#PDEncryption()}
   */
  @Test
  @DisplayName("Test new PDEncryption()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.<init>()"})
  void testNewPDEncryption() throws IOException {
    // Arrange and Act
    PDEncryption actualPdEncryption = new PDEncryption();

    // Assert
    assertNull(actualPdEncryption.getOwnerEncryptionKey());
    assertNull(actualPdEncryption.getOwnerKey());
    assertNull(actualPdEncryption.getPerms());
    assertNull(actualPdEncryption.getUserEncryptionKey());
    assertNull(actualPdEncryption.getUserKey());
    assertNull(actualPdEncryption.getFilter());
    assertNull(actualPdEncryption.getSubFilter());
    assertNull(actualPdEncryption.getDefaultCryptFilterDictionary());
    assertNull(actualPdEncryption.getStdCryptFilterDictionary());
    assertEquals(0, actualPdEncryption.getPermissions());
    assertEquals(0, actualPdEncryption.getRevision());
    assertEquals(0, actualPdEncryption.getVersion());
    assertTrue(actualPdEncryption.hasSecurityHandler());
    assertTrue(actualPdEncryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPdEncryption.getLength());
  }

  /**
   * Test {@link PDEncryption#PDEncryption(COSDictionary)}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#PDEncryption(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDEncryption(COSDictionary); then return COSObject is COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.<init>(COSDictionary)"})
  void testNewPDEncryption_thenReturnCOSObjectIsCOSDictionaryWithDictIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary(new COSDictionary());

    // Act
    PDEncryption actualPdEncryption = new PDEncryption(dictionary);

    // Assert
    assertNull(actualPdEncryption.getOwnerEncryptionKey());
    assertNull(actualPdEncryption.getOwnerKey());
    assertNull(actualPdEncryption.getPerms());
    assertNull(actualPdEncryption.getUserEncryptionKey());
    assertNull(actualPdEncryption.getUserKey());
    assertNull(actualPdEncryption.getFilter());
    assertNull(actualPdEncryption.getSubFilter());
    assertNull(actualPdEncryption.getDefaultCryptFilterDictionary());
    assertNull(actualPdEncryption.getStdCryptFilterDictionary());
    assertEquals(0, actualPdEncryption.getPermissions());
    assertEquals(0, actualPdEncryption.getRevision());
    assertEquals(0, actualPdEncryption.getVersion());
    assertTrue(actualPdEncryption.hasSecurityHandler());
    assertTrue(actualPdEncryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPdEncryption.getLength());
    assertSame(dictionary, actualPdEncryption.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#PDEncryption(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#PDEncryption(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDEncryption(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.<init>(COSDictionary)"})
  void testNewPDEncryption_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDEncryption actualPdEncryption = new PDEncryption(dictionary);

    // Assert
    assertNull(actualPdEncryption.getOwnerEncryptionKey());
    assertNull(actualPdEncryption.getOwnerKey());
    assertNull(actualPdEncryption.getPerms());
    assertNull(actualPdEncryption.getUserEncryptionKey());
    assertNull(actualPdEncryption.getUserKey());
    assertNull(actualPdEncryption.getFilter());
    assertNull(actualPdEncryption.getSubFilter());
    assertNull(actualPdEncryption.getDefaultCryptFilterDictionary());
    assertNull(actualPdEncryption.getStdCryptFilterDictionary());
    assertEquals(0, actualPdEncryption.getPermissions());
    assertEquals(0, actualPdEncryption.getRevision());
    assertEquals(0, actualPdEncryption.getVersion());
    assertTrue(actualPdEncryption.hasSecurityHandler());
    assertTrue(actualPdEncryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPdEncryption.getLength());
    assertSame(dictionary, actualPdEncryption.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#getSecurityHandler()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getSecurityHandler()}
   */
  @Test
  @DisplayName("Test getSecurityHandler(); given PDEncryption() Filter is 'Filter'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityHandler PDEncryption.getSecurityHandler()"})
  void testGetSecurityHandler_givenPDEncryptionFilterIsFilter_thenThrowIOException() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertThrows(IOException.class, () -> pdEncryption.getSecurityHandler());
  }

  /**
   * Test {@link PDEncryption#getSecurityHandler()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getSecurityHandler()}
   */
  @Test
  @DisplayName("Test getSecurityHandler(); given PDEncryption(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityHandler PDEncryption.getSecurityHandler()"})
  void testGetSecurityHandler_givenPDEncryption_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDEncryption()).getSecurityHandler());
  }

  /**
   * Test {@link PDEncryption#hasSecurityHandler()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#hasSecurityHandler()}
   */
  @Test
  @DisplayName("Test hasSecurityHandler(); given PDEncryption(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDEncryption.hasSecurityHandler()"})
  void testHasSecurityHandler_givenPDEncryption_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDEncryption()).hasSecurityHandler());
  }

  /**
   * Test {@link PDEncryption#hasSecurityHandler()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#hasSecurityHandler()}
   */
  @Test
  @DisplayName("Test hasSecurityHandler(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDEncryption.hasSecurityHandler()"})
  void testHasSecurityHandler_thenReturnFalse() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertFalse(pdEncryption.hasSecurityHandler());
  }

  /**
   * Test {@link PDEncryption#getCOSObject()}.
   * <p>
   * Method under test: {@link PDEncryption#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDEncryption.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDEncryption()).getCOSObject();

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
   * Test {@link PDEncryption#setFilter(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Filter is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setFilter(String)}
   */
  @Test
  @DisplayName("Test setFilter(String); when '42'; then PDEncryption() Filter is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setFilter(String)"})
  void testSetFilter_when42_thenPDEncryptionFilterIs42() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setFilter("42");

    // Assert
    assertEquals("42", pdEncryption.getFilter());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setFilter(String)}.
   * <ul>
   *   <li>When {@code Filter}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setFilter(String)}
   */
  @Test
  @DisplayName("Test setFilter(String); when 'Filter'; then PDEncryption() Filter is 'Filter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setFilter(String)"})
  void testSetFilter_whenFilter_thenPDEncryptionFilterIsFilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setFilter("Filter");

    // Assert
    assertEquals("Filter", pdEncryption.getFilter());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#getFilter()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code Filter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); given PDEncryption() Filter is 'Filter'; then return 'Filter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDEncryption.getFilter()"})
  void testGetFilter_givenPDEncryptionFilterIsFilter_thenReturnFilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertEquals("Filter", pdEncryption.getFilter());
  }

  /**
   * Test {@link PDEncryption#getFilter()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getFilter()}
   */
  @Test
  @DisplayName("Test getFilter(); given PDEncryption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDEncryption.getFilter()"})
  void testGetFilter_givenPDEncryption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getFilter());
  }

  /**
   * Test {@link PDEncryption#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} SubFilter is {@code Subfilter}.</li>
   *   <li>Then return {@code Subfilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDEncryption() SubFilter is 'Subfilter'; then return 'Subfilter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDEncryption.getSubFilter()"})
  void testGetSubFilter_givenPDEncryptionSubFilterIsSubfilter_thenReturnSubfilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSubFilter("Subfilter");

    // Act and Assert
    assertEquals("Subfilter", pdEncryption.getSubFilter());
  }

  /**
   * Test {@link PDEncryption#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDEncryption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDEncryption.getSubFilter()"})
  void testGetSubFilter_givenPDEncryption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getSubFilter());
  }

  /**
   * Test {@link PDEncryption#setSubFilter(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} SubFilter is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setSubFilter(String)}
   */
  @Test
  @DisplayName("Test setSubFilter(String); when '42'; then PDEncryption() SubFilter is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setSubFilter(String)"})
  void testSetSubFilter_when42_thenPDEncryptionSubFilterIs42() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setSubFilter("42");

    // Assert
    assertEquals("42", pdEncryption.getSubFilter());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setSubFilter(String)}.
   * <ul>
   *   <li>When {@code Subfilter}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} SubFilter is {@code Subfilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setSubFilter(String)}
   */
  @Test
  @DisplayName("Test setSubFilter(String); when 'Subfilter'; then PDEncryption() SubFilter is 'Subfilter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setSubFilter(String)"})
  void testSetSubFilter_whenSubfilter_thenPDEncryptionSubFilterIsSubfilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setSubFilter("Subfilter");

    // Assert
    assertEquals("Subfilter", pdEncryption.getSubFilter());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setVersion(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Version is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setVersion(int)}
   */
  @Test
  @DisplayName("Test setVersion(int); when MIN_VALUE; then PDEncryption() Version is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setVersion(int)"})
  void testSetVersion_whenMin_value_thenPDEncryptionVersionIsMin_value() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setVersion(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdEncryption.getVersion());
  }

  /**
   * Test {@link PDEncryption#setVersion(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Version is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setVersion(int)}
   */
  @Test
  @DisplayName("Test setVersion(int); when one; then PDEncryption() Version is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setVersion(int)"})
  void testSetVersion_whenOne_thenPDEncryptionVersionIsOne() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setVersion(1);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getVersion());
  }

  /**
   * Test {@link PDEncryption#getVersion()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Version is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDEncryption() Version is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getVersion()"})
  void testGetVersion_givenPDEncryptionVersionIsOne_thenReturnOne() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setVersion(1);

    // Act and Assert
    assertEquals(1, pdEncryption.getVersion());
  }

  /**
   * Test {@link PDEncryption#getVersion()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDEncryption(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getVersion()"})
  void testGetVersion_givenPDEncryption_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getVersion());
  }

  /**
   * Test {@link PDEncryption#setLength(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Length is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setLength(int)}
   */
  @Test
  @DisplayName("Test setLength(int); when MIN_VALUE; then PDEncryption() Length is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setLength(int)"})
  void testSetLength_whenMin_value_thenPDEncryptionLengthIsMin_value() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setLength(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdEncryption.getLength());
  }

  /**
   * Test {@link PDEncryption#setLength(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setLength(int)}
   */
  @Test
  @DisplayName("Test setLength(int); when three; then PDEncryption() Length is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setLength(int)"})
  void testSetLength_whenThree_thenPDEncryptionLengthIsThree() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setLength(3);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, pdEncryption.getLength());
  }

  /**
   * Test {@link PDEncryption#getLength()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Length is three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getLength()}
   */
  @Test
  @DisplayName("Test getLength(); given PDEncryption() Length is three; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getLength()"})
  void testGetLength_givenPDEncryptionLengthIsThree_thenReturnThree() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setLength(3);

    // Act and Assert
    assertEquals(3, pdEncryption.getLength());
  }

  /**
   * Test {@link PDEncryption#getLength()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@link PDEncryption#DEFAULT_LENGTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getLength()}
   */
  @Test
  @DisplayName("Test getLength(); given PDEncryption(); then return DEFAULT_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getLength()"})
  void testGetLength_givenPDEncryption_thenReturnDefault_length() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, (new PDEncryption()).getLength());
  }

  /**
   * Test {@link PDEncryption#setRevision(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Revision is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setRevision(int)}
   */
  @Test
  @DisplayName("Test setRevision(int); when MIN_VALUE; then PDEncryption() Revision is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setRevision(int)"})
  void testSetRevision_whenMin_value_thenPDEncryptionRevisionIsMin_value() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setRevision(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdEncryption.getRevision());
  }

  /**
   * Test {@link PDEncryption#setRevision(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Revision is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setRevision(int)}
   */
  @Test
  @DisplayName("Test setRevision(int); when one; then PDEncryption() Revision is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setRevision(int)"})
  void testSetRevision_whenOne_thenPDEncryptionRevisionIsOne() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setRevision(1);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getRevision());
  }

  /**
   * Test {@link PDEncryption#getRevision()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getRevision()}
   */
  @Test
  @DisplayName("Test getRevision(); given PDEncryption() Revision is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getRevision()"})
  void testGetRevision_givenPDEncryptionRevisionIsOne_thenReturnOne() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(1);

    // Act and Assert
    assertEquals(1, pdEncryption.getRevision());
  }

  /**
   * Test {@link PDEncryption#getRevision()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getRevision()}
   */
  @Test
  @DisplayName("Test getRevision(); given PDEncryption(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getRevision()"})
  void testGetRevision_givenPDEncryption_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getRevision());
  }

  /**
   * Test {@link PDEncryption#setOwnerKey(byte[])}.
   * <p>
   * Method under test: {@link PDEncryption#setOwnerKey(byte[])}
   */
  @Test
  @DisplayName("Test setOwnerKey(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setOwnerKey(byte[])"})
  void testSetOwnerKey() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is five.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is five; then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerKey()"})
  void testGetOwnerKey_givenPDEncryptionRevisionIsFive_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(5);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is four.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is four; then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerKey()"})
  void testGetOwnerKey_givenPDEncryptionRevisionIsFour_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(4);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is six.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is six; then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerKey()"})
  void testGetOwnerKey_givenPDEncryptionRevisionIsSix_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(6);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is {@link Integer#SIZE}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is SIZE; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerKey()"})
  void testGetOwnerKey_givenPDEncryptionRevisionIsSize_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(Integer.SIZE);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualOwnerKey = pdEncryption.getOwnerKey();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOwnerKey);
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerKey()"})
  void testGetOwnerKey_givenPDEncryption_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerKey()"})
  void testGetOwnerKey_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#setUserKey(byte[])}.
   * <p>
   * Method under test: {@link PDEncryption#setUserKey(byte[])}
   */
  @Test
  @DisplayName("Test setUserKey(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setUserKey(byte[])"})
  void testSetUserKey() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is five.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is five; then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserKey()"})
  void testGetUserKey_givenPDEncryptionRevisionIsFive_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(5);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is four.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is four; then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserKey()"})
  void testGetUserKey_givenPDEncryptionRevisionIsFour_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(4);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is six.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is six; then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserKey()"})
  void testGetUserKey_givenPDEncryptionRevisionIsSix_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(6);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is {@link Integer#SIZE}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is SIZE; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserKey()"})
  void testGetUserKey_givenPDEncryptionRevisionIsSize_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(Integer.SIZE);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualUserKey = pdEncryption.getUserKey();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualUserKey);
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserKey()"})
  void testGetUserKey_givenPDEncryption_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getUserKey());
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserKey()"})
  void testGetUserKey_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Test {@link PDEncryption#setOwnerEncryptionKey(byte[])}.
   * <p>
   * Method under test: {@link PDEncryption#setOwnerEncryptionKey(byte[])}
   */
  @Test
  @DisplayName("Test setOwnerEncryptionKey(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setOwnerEncryptionKey(byte[])"})
  void testSetOwnerEncryptionKey() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setOwnerEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerEncryptionKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerEncryptionKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerEncryptionKey()}
   */
  @Test
  @DisplayName("Test getOwnerEncryptionKey(); given PDEncryption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerEncryptionKey()"})
  void testGetOwnerEncryptionKey_givenPDEncryption_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getOwnerEncryptionKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerEncryptionKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerEncryptionKey()}
   */
  @Test
  @DisplayName("Test getOwnerEncryptionKey(); then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getOwnerEncryptionKey()"})
  void testGetOwnerEncryptionKey_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setOwnerEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerEncryptionKey());
  }

  /**
   * Test {@link PDEncryption#setUserEncryptionKey(byte[])}.
   * <p>
   * Method under test: {@link PDEncryption#setUserEncryptionKey(byte[])}
   */
  @Test
  @DisplayName("Test setUserEncryptionKey(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setUserEncryptionKey(byte[])"})
  void testSetUserEncryptionKey() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setUserEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserEncryptionKey());
  }

  /**
   * Test {@link PDEncryption#getUserEncryptionKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserEncryptionKey()}
   */
  @Test
  @DisplayName("Test getUserEncryptionKey(); given PDEncryption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserEncryptionKey()"})
  void testGetUserEncryptionKey_givenPDEncryption_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getUserEncryptionKey());
  }

  /**
   * Test {@link PDEncryption#getUserEncryptionKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserEncryptionKey()}
   */
  @Test
  @DisplayName("Test getUserEncryptionKey(); then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getUserEncryptionKey()"})
  void testGetUserEncryptionKey_thenReturnArrayOfByteWithAAndX() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setUserEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserEncryptionKey());
  }

  /**
   * Test {@link PDEncryption#setPermissions(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Permissions is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setPermissions(int)}
   */
  @Test
  @DisplayName("Test setPermissions(int); when MIN_VALUE; then PDEncryption() Permissions is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setPermissions(int)"})
  void testSetPermissions_whenMin_value_thenPDEncryptionPermissionsIsMin_value() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setPermissions(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdEncryption.getPermissions());
  }

  /**
   * Test {@link PDEncryption#setPermissions(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Permissions is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setPermissions(int)}
   */
  @Test
  @DisplayName("Test setPermissions(int); when one; then PDEncryption() Permissions is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setPermissions(int)"})
  void testSetPermissions_whenOne_thenPDEncryptionPermissionsIsOne() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setPermissions(1);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getPermissions());
  }

  /**
   * Test {@link PDEncryption#getPermissions()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Permissions is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getPermissions()}
   */
  @Test
  @DisplayName("Test getPermissions(); given PDEncryption() Permissions is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getPermissions()"})
  void testGetPermissions_givenPDEncryptionPermissionsIsOne_thenReturnOne() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setPermissions(1);

    // Act and Assert
    assertEquals(1, pdEncryption.getPermissions());
  }

  /**
   * Test {@link PDEncryption#getPermissions()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getPermissions()}
   */
  @Test
  @DisplayName("Test getPermissions(); given PDEncryption(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getPermissions()"})
  void testGetPermissions_givenPDEncryption_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getPermissions());
  }

  /**
   * Test {@link PDEncryption#isEncryptMetaData()}.
   * <p>
   * Method under test: {@link PDEncryption#isEncryptMetaData()}
   */
  @Test
  @DisplayName("Test isEncryptMetaData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDEncryption.isEncryptMetaData()"})
  void testIsEncryptMetaData() {
    // Arrange, Act and Assert
    assertTrue((new PDEncryption()).isEncryptMetaData());
  }

  /**
   * Test {@link PDEncryption#setRecipients(byte[][])}.
   * <p>
   * Method under test: {@link PDEncryption#setRecipients(byte[][])}
   */
  @Test
  @DisplayName("Test setRecipients(byte[][])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setRecipients(byte[][])"})
  void testSetRecipients() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setRecipients(new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getRecipientsLength());
  }

  /**
   * Test {@link PDEncryption#getRecipientsLength()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getRecipientsLength()}
   */
  @Test
  @DisplayName("Test getRecipientsLength(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDEncryption.getRecipientsLength()"})
  void testGetRecipientsLength_thenReturnOne() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRecipients(new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Act and Assert
    assertEquals(1, pdEncryption.getRecipientsLength());
  }

  /**
   * Test {@link PDEncryption#getRecipientStringAt(int)}.
   * <ul>
   *   <li>Then return toHexString is {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getRecipientStringAt(int)}
   */
  @Test
  @DisplayName("Test getRecipientStringAt(int); then return toHexString is '4158415841584158'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSString PDEncryption.getRecipientStringAt(int)"})
  void testGetRecipientStringAt_thenReturnToHexStringIs4158415841584158() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    pdEncryption.setRecipients(new byte[][]{bytes, "AXAXAXAX".getBytes("UTF-8")});

    // Act
    COSString actualRecipientStringAt = pdEncryption.getRecipientStringAt(1);

    // Assert
    assertEquals("4158415841584158", actualRecipientStringAt.toHexString());
    assertEquals("AXAXAXAX", actualRecipientStringAt.getASCII());
    assertEquals("AXAXAXAX", actualRecipientStringAt.getString());
    assertNull(actualRecipientStringAt.getKey());
    assertFalse(actualRecipientStringAt.isDirect());
    assertFalse(actualRecipientStringAt.getForceHexForm());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualRecipientStringAt.getBytes());
  }

  /**
   * Test {@link PDEncryption#getStdCryptFilterDictionary()}.
   * <p>
   * Method under test: {@link PDEncryption#getStdCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test getStdCryptFilterDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getStdCryptFilterDictionary()"})
  void testGetStdCryptFilterDictionary() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getStdCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getStdCryptFilterDictionary()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStdCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test getStdCryptFilterDictionary(); given PDEncryption()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getStdCryptFilterDictionary()"})
  void testGetStdCryptFilterDictionary_givenPDEncryption() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getStdCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getDefaultCryptFilterDictionary()}.
   * <p>
   * Method under test: {@link PDEncryption#getDefaultCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test getDefaultCryptFilterDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getDefaultCryptFilterDictionary()"})
  void testGetDefaultCryptFilterDictionary() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getDefaultCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getDefaultCryptFilterDictionary()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getDefaultCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test getDefaultCryptFilterDictionary(); given PDEncryption()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getDefaultCryptFilterDictionary()"})
  void testGetDefaultCryptFilterDictionary_givenPDEncryption() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getDefaultCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getCryptFilterDictionary(COSName)}.
   * <p>
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCryptFilterDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getCryptFilterDictionary(COSName)"})
  void testGetCryptFilterDictionary() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Act
    PDCryptFilterDictionary actualCryptFilterDictionary = pdEncryption.getCryptFilterDictionary(COSName.A);

    // Assert
    COSDictionary cOSObject = actualCryptFilterDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCryptFilterDictionary.getCryptFilterMethod());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualCryptFilterDictionary.getLength());
  }

  /**
   * Test {@link PDEncryption#getCryptFilterDictionary(COSName)}.
   * <p>
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCryptFilterDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getCryptFilterDictionary(COSName)"})
  void testGetCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.AA, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getCryptFilterDictionary(COSName.A));
  }

  /**
   * Test {@link PDEncryption#getCryptFilterDictionary(COSName)}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCryptFilterDictionary(COSName); given PDEncryption(); when A; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getCryptFilterDictionary(COSName)"})
  void testGetCryptFilterDictionary_givenPDEncryption_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getCryptFilterDictionary(COSName.A));
  }

  /**
   * Test {@link PDEncryption#getCryptFilterDictionary(COSName)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCryptFilterDictionary(COSName); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDCryptFilterDictionary PDEncryption.getCryptFilterDictionary(COSName)"})
  void testGetCryptFilterDictionary_whenNull() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getCryptFilterDictionary(null));
  }

  /**
   * Test {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when PDCryptFilterDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setCryptFilterDictionary(COSName, PDCryptFilterDictionary)"})
  void testSetCryptFilterDictionary_whenPDCryptFilterDictionary() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when PDCryptFilterDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setCryptFilterDictionary(COSName, PDCryptFilterDictionary)"})
  void testSetCryptFilterDictionary_whenPDCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setCryptFilterDictionary(null, new PDCryptFilterDictionary());

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)} with d is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when PDCryptFilterDictionary(COSDictionary) with d is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setCryptFilterDictionary(COSName, PDCryptFilterDictionary)"})
  void testSetCryptFilterDictionary_whenPDCryptFilterDictionaryWithDIsNull() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary(null));

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)} with d is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when PDCryptFilterDictionary(COSDictionary) with d is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setCryptFilterDictionary(COSName, PDCryptFilterDictionary)"})
  void testSetCryptFilterDictionary_whenPDCryptFilterDictionaryWithDIsNull2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setCryptFilterDictionary(null, new PDCryptFilterDictionary(null));

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <p>
   * Method under test: {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setStdCryptFilterDictionary(PDCryptFilterDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setStdCryptFilterDictionary(PDCryptFilterDictionary)"})
  void testSetStdCryptFilterDictionary() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    PDCryptFilterDictionary cryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdEncryption.setStdCryptFilterDictionary(cryptFilterDictionary);

    // Assert
    PDCryptFilterDictionary stdCryptFilterDictionary = pdEncryption.getStdCryptFilterDictionary();
    assertNull(stdCryptFilterDictionary.getCryptFilterMethod());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSDictionary cOSObject2 = cryptFilterDictionary.getCOSObject();
    assertTrue(cOSObject2.isDirect());
    assertTrue(stdCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, stdCryptFilterDictionary.getLength());
    assertSame(cOSObject2, stdCryptFilterDictionary.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <p>
   * Method under test: {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setStdCryptFilterDictionary(PDCryptFilterDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setStdCryptFilterDictionary(PDCryptFilterDictionary)"})
  void testSetStdCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());
    PDCryptFilterDictionary cryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdEncryption.setStdCryptFilterDictionary(cryptFilterDictionary);

    // Assert
    PDCryptFilterDictionary stdCryptFilterDictionary = pdEncryption.getStdCryptFilterDictionary();
    assertNull(stdCryptFilterDictionary.getCryptFilterMethod());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSDictionary cOSObject2 = cryptFilterDictionary.getCOSObject();
    assertTrue(cOSObject2.isDirect());
    assertTrue(stdCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, stdCryptFilterDictionary.getLength());
    assertSame(cOSObject2, stdCryptFilterDictionary.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <p>
   * Method under test: {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setDefaultCryptFilterDictionary(PDCryptFilterDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setDefaultCryptFilterDictionary(PDCryptFilterDictionary)"})
  void testSetDefaultCryptFilterDictionary() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    PDCryptFilterDictionary defaultFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdEncryption.setDefaultCryptFilterDictionary(defaultFilterDictionary);

    // Assert
    PDCryptFilterDictionary defaultCryptFilterDictionary = pdEncryption.getDefaultCryptFilterDictionary();
    assertNull(defaultCryptFilterDictionary.getCryptFilterMethod());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSDictionary cOSObject2 = defaultFilterDictionary.getCOSObject();
    assertTrue(cOSObject2.isDirect());
    assertTrue(defaultCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, defaultCryptFilterDictionary.getLength());
    assertSame(cOSObject2, defaultCryptFilterDictionary.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <p>
   * Method under test: {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setDefaultCryptFilterDictionary(PDCryptFilterDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setDefaultCryptFilterDictionary(PDCryptFilterDictionary)"})
  void testSetDefaultCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());
    PDCryptFilterDictionary defaultFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdEncryption.setDefaultCryptFilterDictionary(defaultFilterDictionary);

    // Assert
    PDCryptFilterDictionary defaultCryptFilterDictionary = pdEncryption.getDefaultCryptFilterDictionary();
    assertNull(defaultCryptFilterDictionary.getCryptFilterMethod());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSDictionary cOSObject2 = defaultFilterDictionary.getCOSObject();
    assertTrue(cOSObject2.isDirect());
    assertTrue(defaultCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, defaultCryptFilterDictionary.getLength());
    assertSame(cOSObject2, defaultCryptFilterDictionary.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#getStreamFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} StreamFilterName is {@link COSName#A}.</li>
   *   <li>Then return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStreamFilterName()}
   */
  @Test
  @DisplayName("Test getStreamFilterName(); given PDEncryption() StreamFilterName is A; then return A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PDEncryption.getStreamFilterName()"})
  void testGetStreamFilterName_givenPDEncryptionStreamFilterNameIsA_thenReturnA() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setStreamFilterName(COSName.A);

    // Act
    COSName actualStreamFilterName = pdEncryption.getStreamFilterName();

    // Assert
    assertSame(actualStreamFilterName.A, actualStreamFilterName);
    COSName expectedStringFilterName = actualStreamFilterName.IDENTITY;
    assertSame(expectedStringFilterName, pdEncryption.getStringFilterName());
  }

  /**
   * Test {@link PDEncryption#getStreamFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@link COSName#IDENTITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStreamFilterName()}
   */
  @Test
  @DisplayName("Test getStreamFilterName(); given PDEncryption(); then return IDENTITY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PDEncryption.getStreamFilterName()"})
  void testGetStreamFilterName_givenPDEncryption_thenReturnIdentity() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    COSName actualStreamFilterName = pdEncryption.getStreamFilterName();

    // Assert
    COSName cosName = actualStreamFilterName.IDENTITY;
    assertSame(cosName, actualStreamFilterName);
    assertSame(cosName, pdEncryption.getStringFilterName());
  }

  /**
   * Test {@link PDEncryption#setStreamFilterName(COSName)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setStreamFilterName(COSName)}
   */
  @Test
  @DisplayName("Test setStreamFilterName(COSName); when 'null'; then PDEncryption() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setStreamFilterName(COSName)"})
  void testSetStreamFilterName_whenNull_thenPDEncryptionCOSObjectSizeIsZero() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setStreamFilterName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDEncryption#getStringFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} StringFilterName is {@link COSName#A}.</li>
   *   <li>Then return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStringFilterName()}
   */
  @Test
  @DisplayName("Test getStringFilterName(); given PDEncryption() StringFilterName is A; then return A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PDEncryption.getStringFilterName()"})
  void testGetStringFilterName_givenPDEncryptionStringFilterNameIsA_thenReturnA() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setStringFilterName(COSName.A);

    // Act
    COSName actualStringFilterName = pdEncryption.getStringFilterName();

    // Assert
    assertSame(actualStringFilterName.A, actualStringFilterName);
    COSName expectedStreamFilterName = actualStringFilterName.IDENTITY;
    assertSame(expectedStreamFilterName, pdEncryption.getStreamFilterName());
  }

  /**
   * Test {@link PDEncryption#getStringFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@link COSName#IDENTITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStringFilterName()}
   */
  @Test
  @DisplayName("Test getStringFilterName(); given PDEncryption(); then return IDENTITY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName PDEncryption.getStringFilterName()"})
  void testGetStringFilterName_givenPDEncryption_thenReturnIdentity() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    COSName actualStringFilterName = pdEncryption.getStringFilterName();

    // Assert
    COSName cosName = actualStringFilterName.IDENTITY;
    assertSame(cosName, pdEncryption.getStreamFilterName());
    assertSame(cosName, actualStringFilterName);
  }

  /**
   * Test {@link PDEncryption#setStringFilterName(COSName)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setStringFilterName(COSName)}
   */
  @Test
  @DisplayName("Test setStringFilterName(COSName); when A; then PDEncryption() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setStringFilterName(COSName)"})
  void testSetStringFilterName_whenA_thenPDEncryptionCOSObjectValuesSizeIsOne() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    COSName stringFilterName = COSName.A;

    // Act
    pdEncryption.setStringFilterName(stringFilterName);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSName expectedStringFilterName = stringFilterName.A;
    assertSame(expectedStringFilterName, pdEncryption.getStringFilterName());
  }

  /**
   * Test {@link PDEncryption#setStringFilterName(COSName)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setStringFilterName(COSName)}
   */
  @Test
  @DisplayName("Test setStringFilterName(COSName); when 'null'; then PDEncryption() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setStringFilterName(COSName)"})
  void testSetStringFilterName_whenNull_thenPDEncryptionCOSObjectSizeIsZero() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setStringFilterName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDEncryption#setPerms(byte[])}.
   * <p>
   * Method under test: {@link PDEncryption#setPerms(byte[])}
   */
  @Test
  @DisplayName("Test setPerms(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.setPerms(byte[])"})
  void testSetPerms() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setPerms("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    byte[] expectedPerms = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPerms, pdEncryption.getPerms());
  }

  /**
   * Test {@link PDEncryption#getPerms()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getPerms()}
   */
  @Test
  @DisplayName("Test getPerms(); given PDEncryption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getPerms()"})
  void testGetPerms_givenPDEncryption_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getPerms());
  }

  /**
   * Test {@link PDEncryption#getPerms()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getPerms()}
   */
  @Test
  @DisplayName("Test getPerms(); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDEncryption.getPerms()"})
  void testGetPerms_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setPerms("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPerms = pdEncryption.getPerms();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPerms);
  }

  /**
   * Test {@link PDEncryption#removeV45filters()}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getNameAsString(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#removeV45filters()}
   */
  @Test
  @DisplayName("Test removeV45filters(); then calls getNameAsString(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDEncryption.removeV45filters()"})
  void testRemoveV45filters_thenCallsGetNameAsString() {
    // Arrange
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(dictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    (new PDEncryption(dictionary)).removeV45filters();

    // Assert
    verify(dictionary).getNameAsString(isA(COSName.class));
    verify(dictionary, atLeast(1)).setItem(Mockito.<COSName>any(), (COSBase) isNull());
  }
}
