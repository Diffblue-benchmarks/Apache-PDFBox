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
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
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
  void testNewPDEncryption() throws IOException {
    // Arrange and Act
    PDEncryption actualPdEncryption = new PDEncryption();

    // Assert
    COSName streamFilterName = actualPdEncryption.getStreamFilterName();
    assertEquals("Identity", streamFilterName.getName());
    assertNull(actualPdEncryption.getOwnerEncryptionKey());
    assertNull(actualPdEncryption.getOwnerKey());
    assertNull(actualPdEncryption.getPerms());
    assertNull(actualPdEncryption.getUserEncryptionKey());
    assertNull(actualPdEncryption.getUserKey());
    assertNull(actualPdEncryption.getFilter());
    assertNull(actualPdEncryption.getSubFilter());
    COSDictionary cOSObject = actualPdEncryption.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(streamFilterName.getKey());
    assertNull(actualPdEncryption.getDefaultCryptFilterDictionary());
    assertNull(actualPdEncryption.getStdCryptFilterDictionary());
    assertEquals(0, cOSObject.size());
    assertEquals(0, actualPdEncryption.getPermissions());
    assertEquals(0, actualPdEncryption.getRevision());
    assertEquals(0, actualPdEncryption.getVersion());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(streamFilterName.isDirect());
    assertFalse(streamFilterName.isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdEncryption.hasSecurityHandler());
    assertTrue(actualPdEncryption.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPdEncryption.getLength());
    assertSame(streamFilterName, actualPdEncryption.getStringFilterName());
  }

  /**
   * Test {@link PDEncryption#PDEncryption(COSDictionary)}.
   * <ul>
   *   <li>Then return COSObject is
   * {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#PDEncryption(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDEncryption(COSDictionary); then return COSObject is COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testNewPDEncryption_thenReturnCOSObjectIsCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary(new COSDictionary());

    // Act
    PDEncryption actualPdEncryption = new PDEncryption(dictionary);

    // Assert
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
  void testNewPDEncryption_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDEncryption actualPdEncryption = new PDEncryption(dictionary);

    // Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPdEncryption.getLength());
    assertSame(dictionary, actualPdEncryption.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#PDEncryption(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#PDEncryption(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDEncryption(COSDictionary); when COSStream(); then return Length is zero")
  void testNewPDEncryption_whenCOSStream_thenReturnLengthIsZero() {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act
    PDEncryption actualPdEncryption = new PDEncryption(dictionary);

    // Assert
    assertEquals(0, actualPdEncryption.getLength());
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
   *   <li>When {@code FilterFilter}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Filter is
   * {@code FilterFilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setFilter(String)}
   */
  @Test
  @DisplayName("Test setFilter(String); when 'FilterFilter'; then PDEncryption() Filter is 'FilterFilter'")
  void testSetFilter_whenFilterFilter_thenPDEncryptionFilterIsFilterFilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setFilter("FilterFilter");

    // Assert
    assertEquals("FilterFilter", pdEncryption.getFilter());
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
  void testGetFilter_givenPDEncryption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getFilter());
  }

  /**
   * Test {@link PDEncryption#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDEncryption() Filter is 'Filter'; then return 'null'")
  void testGetSubFilter_givenPDEncryptionFilterIsFilter_thenReturnNull() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getSubFilter());
  }

  /**
   * Test {@link PDEncryption#getSubFilter()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} SubFilter is
   * {@code Subfilter}.</li>
   *   <li>Then return {@code Subfilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getSubFilter()}
   */
  @Test
  @DisplayName("Test getSubFilter(); given PDEncryption() SubFilter is 'Subfilter'; then return 'Subfilter'")
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
  void testGetSubFilter_givenPDEncryption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getSubFilter());
  }

  /**
   * Test {@link PDEncryption#setSubFilter(String)}.
   * <ul>
   *   <li>Then {@link PDEncryption#PDEncryption()} SubFilter is
   * {@code SubfilterSubfilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setSubFilter(String)}
   */
  @Test
  @DisplayName("Test setSubFilter(String); then PDEncryption() SubFilter is 'SubfilterSubfilter'")
  void testSetSubFilter_thenPDEncryptionSubFilterIsSubfilterSubfilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setSubFilter("SubfilterSubfilter");

    // Assert
    assertEquals("SubfilterSubfilter", pdEncryption.getSubFilter());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEncryption#setSubFilter(String)}.
   * <ul>
   *   <li>When {@code Subfilter}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} SubFilter is
   * {@code Subfilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setSubFilter(String)}
   */
  @Test
  @DisplayName("Test setSubFilter(String); when 'Subfilter'; then PDEncryption() SubFilter is 'Subfilter'")
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
   *   <li>Then {@link PDEncryption#PDEncryption()} Version is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setVersion(int)}
   */
  @Test
  @DisplayName("Test setVersion(int); when MIN_VALUE; then PDEncryption() Version is MIN_VALUE")
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given PDEncryption() Filter is 'Filter'; then return zero")
  void testGetVersion_givenPDEncryptionFilterIsFilter_thenReturnZero() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertEquals(0, pdEncryption.getVersion());
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
  void testGetVersion_givenPDEncryption_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getVersion());
  }

  /**
   * Test {@link PDEncryption#setLength(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Length is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setLength(int)}
   */
  @Test
  @DisplayName("Test setLength(int); when MIN_VALUE; then PDEncryption() Length is MIN_VALUE")
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@link PDEncryption#DEFAULT_LENGTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getLength()}
   */
  @Test
  @DisplayName("Test getLength(); given PDEncryption() Filter is 'Filter'; then return DEFAULT_LENGTH")
  void testGetLength_givenPDEncryptionFilterIsFilter_thenReturnDefault_length() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, pdEncryption.getLength());
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
  void testGetLength_givenPDEncryption_thenReturnDefault_length() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, (new PDEncryption()).getLength());
  }

  /**
   * Test {@link PDEncryption#setRevision(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} Revision is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setRevision(int)}
   */
  @Test
  @DisplayName("Test setRevision(int); when MIN_VALUE; then PDEncryption() Revision is MIN_VALUE")
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getRevision()}
   */
  @Test
  @DisplayName("Test getRevision(); given PDEncryption() Filter is 'Filter'; then return zero")
  void testGetRevision_givenPDEncryptionFilterIsFilter_thenReturnZero() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertEquals(0, pdEncryption.getRevision());
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Filter is 'Filter'; then return 'null'")
  void testGetOwnerKey_givenPDEncryptionFilterIsFilter_thenReturnNull() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is five")
  void testGetOwnerKey_givenPDEncryptionRevisionIsFive() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(5);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualOwnerKey = pdEncryption.getOwnerKey();

    // Assert
    assertEquals((byte) 0, actualOwnerKey[33]);
    assertEquals((byte) 0, actualOwnerKey[34]);
    assertEquals((byte) 0, actualOwnerKey[35]);
    assertEquals((byte) 0, actualOwnerKey[36]);
    assertEquals((byte) 0, actualOwnerKey[37]);
    assertEquals((byte) 0, actualOwnerKey[38]);
    assertEquals((byte) 0, actualOwnerKey[39]);
    assertEquals((byte) 0, actualOwnerKey[41]);
    assertEquals((byte) 0, actualOwnerKey[42]);
    assertEquals((byte) 0, actualOwnerKey[43]);
    assertEquals((byte) 0, actualOwnerKey[44]);
    assertEquals((byte) 0, actualOwnerKey[45]);
    assertEquals((byte) 0, actualOwnerKey[46]);
    assertEquals((byte) 0, actualOwnerKey[47]);
    assertEquals((byte) 0, actualOwnerKey[Integer.SIZE]);
    assertEquals((byte) 0, actualOwnerKey[PDEncryption.DEFAULT_LENGTH]);
    assertEquals(48, actualOwnerKey.length);
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is four.</li>
   *   <li>Then return eleventh element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is four; then return eleventh element is zero")
  void testGetOwnerKey_givenPDEncryptionRevisionIsFour_thenReturnEleventhElementIsZero() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(4);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualOwnerKey = pdEncryption.getOwnerKey();

    // Assert
    assertEquals((byte) 0, actualOwnerKey[10]);
    assertEquals((byte) 0, actualOwnerKey[11]);
    assertEquals((byte) 0, actualOwnerKey[12]);
    assertEquals((byte) 0, actualOwnerKey[13]);
    assertEquals((byte) 0, actualOwnerKey[14]);
    assertEquals((byte) 0, actualOwnerKey[15]);
    assertEquals((byte) 0, actualOwnerKey[17]);
    assertEquals((byte) 0, actualOwnerKey[18]);
    assertEquals((byte) 0, actualOwnerKey[19]);
    assertEquals((byte) 0, actualOwnerKey[20]);
    assertEquals((byte) 0, actualOwnerKey[21]);
    assertEquals((byte) 0, actualOwnerKey[22]);
    assertEquals((byte) 0, actualOwnerKey[23]);
    assertEquals((byte) 0, actualOwnerKey[24]);
    assertEquals((byte) 0, actualOwnerKey[25]);
    assertEquals((byte) 0, actualOwnerKey[26]);
    assertEquals((byte) 0, actualOwnerKey[27]);
    assertEquals((byte) 0, actualOwnerKey[28]);
    assertEquals((byte) 0, actualOwnerKey[29]);
    assertEquals((byte) 0, actualOwnerKey[30]);
    assertEquals((byte) 0, actualOwnerKey[31]);
    assertEquals((byte) 0, actualOwnerKey[8]);
    assertEquals((byte) 0, actualOwnerKey[9]);
    assertEquals((byte) 0, actualOwnerKey[Short.SIZE]);
    assertEquals(Integer.SIZE, actualOwnerKey.length);
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is six")
  void testGetOwnerKey_givenPDEncryptionRevisionIsSix() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(6);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualOwnerKey = pdEncryption.getOwnerKey();

    // Assert
    assertEquals((byte) 0, actualOwnerKey[33]);
    assertEquals((byte) 0, actualOwnerKey[34]);
    assertEquals((byte) 0, actualOwnerKey[35]);
    assertEquals((byte) 0, actualOwnerKey[36]);
    assertEquals((byte) 0, actualOwnerKey[37]);
    assertEquals((byte) 0, actualOwnerKey[38]);
    assertEquals((byte) 0, actualOwnerKey[39]);
    assertEquals((byte) 0, actualOwnerKey[41]);
    assertEquals((byte) 0, actualOwnerKey[42]);
    assertEquals((byte) 0, actualOwnerKey[43]);
    assertEquals((byte) 0, actualOwnerKey[44]);
    assertEquals((byte) 0, actualOwnerKey[45]);
    assertEquals((byte) 0, actualOwnerKey[46]);
    assertEquals((byte) 0, actualOwnerKey[47]);
    assertEquals((byte) 0, actualOwnerKey[Integer.SIZE]);
    assertEquals((byte) 0, actualOwnerKey[PDEncryption.DEFAULT_LENGTH]);
    assertEquals(48, actualOwnerKey.length);
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is
   * {@link Integer#SIZE}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); given PDEncryption() Revision is SIZE; then return 'AXAXAXAX' Bytes is 'UTF-8'")
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
  void testGetOwnerKey_givenPDEncryption_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getOwnerKey());
  }

  /**
   * Test {@link PDEncryption#getOwnerKey()}.
   * <ul>
   *   <li>Then return eleventh element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  @DisplayName("Test getOwnerKey(); then return eleventh element is zero")
  void testGetOwnerKey_thenReturnEleventhElementIsZero() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualOwnerKey = pdEncryption.getOwnerKey();

    // Assert
    assertEquals((byte) 0, actualOwnerKey[10]);
    assertEquals((byte) 0, actualOwnerKey[11]);
    assertEquals((byte) 0, actualOwnerKey[12]);
    assertEquals((byte) 0, actualOwnerKey[13]);
    assertEquals((byte) 0, actualOwnerKey[14]);
    assertEquals((byte) 0, actualOwnerKey[15]);
    assertEquals((byte) 0, actualOwnerKey[17]);
    assertEquals((byte) 0, actualOwnerKey[18]);
    assertEquals((byte) 0, actualOwnerKey[19]);
    assertEquals((byte) 0, actualOwnerKey[20]);
    assertEquals((byte) 0, actualOwnerKey[21]);
    assertEquals((byte) 0, actualOwnerKey[22]);
    assertEquals((byte) 0, actualOwnerKey[23]);
    assertEquals((byte) 0, actualOwnerKey[24]);
    assertEquals((byte) 0, actualOwnerKey[25]);
    assertEquals((byte) 0, actualOwnerKey[26]);
    assertEquals((byte) 0, actualOwnerKey[27]);
    assertEquals((byte) 0, actualOwnerKey[28]);
    assertEquals((byte) 0, actualOwnerKey[29]);
    assertEquals((byte) 0, actualOwnerKey[30]);
    assertEquals((byte) 0, actualOwnerKey[31]);
    assertEquals((byte) 0, actualOwnerKey[8]);
    assertEquals((byte) 0, actualOwnerKey[9]);
    assertEquals((byte) 0, actualOwnerKey[Short.SIZE]);
    assertEquals(Integer.SIZE, actualOwnerKey.length);
  }

  /**
   * Test {@link PDEncryption#setUserKey(byte[])}.
   * <p>
   * Method under test: {@link PDEncryption#setUserKey(byte[])}
   */
  @Test
  @DisplayName("Test setUserKey(byte[])")
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Filter is 'Filter'; then return 'null'")
  void testGetUserKey_givenPDEncryptionFilterIsFilter_thenReturnNull() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getUserKey());
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is five")
  void testGetUserKey_givenPDEncryptionRevisionIsFive() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(5);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualUserKey = pdEncryption.getUserKey();

    // Assert
    assertEquals((byte) 0, actualUserKey[33]);
    assertEquals((byte) 0, actualUserKey[34]);
    assertEquals((byte) 0, actualUserKey[35]);
    assertEquals((byte) 0, actualUserKey[36]);
    assertEquals((byte) 0, actualUserKey[37]);
    assertEquals((byte) 0, actualUserKey[38]);
    assertEquals((byte) 0, actualUserKey[39]);
    assertEquals((byte) 0, actualUserKey[41]);
    assertEquals((byte) 0, actualUserKey[42]);
    assertEquals((byte) 0, actualUserKey[43]);
    assertEquals((byte) 0, actualUserKey[44]);
    assertEquals((byte) 0, actualUserKey[45]);
    assertEquals((byte) 0, actualUserKey[46]);
    assertEquals((byte) 0, actualUserKey[47]);
    assertEquals((byte) 0, actualUserKey[Integer.SIZE]);
    assertEquals((byte) 0, actualUserKey[PDEncryption.DEFAULT_LENGTH]);
    assertEquals(48, actualUserKey.length);
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is four.</li>
   *   <li>Then return eleventh element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is four; then return eleventh element is zero")
  void testGetUserKey_givenPDEncryptionRevisionIsFour_thenReturnEleventhElementIsZero() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(4);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualUserKey = pdEncryption.getUserKey();

    // Assert
    assertEquals((byte) 0, actualUserKey[10]);
    assertEquals((byte) 0, actualUserKey[11]);
    assertEquals((byte) 0, actualUserKey[12]);
    assertEquals((byte) 0, actualUserKey[13]);
    assertEquals((byte) 0, actualUserKey[14]);
    assertEquals((byte) 0, actualUserKey[15]);
    assertEquals((byte) 0, actualUserKey[17]);
    assertEquals((byte) 0, actualUserKey[18]);
    assertEquals((byte) 0, actualUserKey[19]);
    assertEquals((byte) 0, actualUserKey[20]);
    assertEquals((byte) 0, actualUserKey[21]);
    assertEquals((byte) 0, actualUserKey[22]);
    assertEquals((byte) 0, actualUserKey[23]);
    assertEquals((byte) 0, actualUserKey[24]);
    assertEquals((byte) 0, actualUserKey[25]);
    assertEquals((byte) 0, actualUserKey[26]);
    assertEquals((byte) 0, actualUserKey[27]);
    assertEquals((byte) 0, actualUserKey[28]);
    assertEquals((byte) 0, actualUserKey[29]);
    assertEquals((byte) 0, actualUserKey[30]);
    assertEquals((byte) 0, actualUserKey[31]);
    assertEquals((byte) 0, actualUserKey[8]);
    assertEquals((byte) 0, actualUserKey[9]);
    assertEquals((byte) 0, actualUserKey[Short.SIZE]);
    assertEquals(Integer.SIZE, actualUserKey.length);
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is six")
  void testGetUserKey_givenPDEncryptionRevisionIsSix() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(6);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualUserKey = pdEncryption.getUserKey();

    // Assert
    assertEquals((byte) 0, actualUserKey[33]);
    assertEquals((byte) 0, actualUserKey[34]);
    assertEquals((byte) 0, actualUserKey[35]);
    assertEquals((byte) 0, actualUserKey[36]);
    assertEquals((byte) 0, actualUserKey[37]);
    assertEquals((byte) 0, actualUserKey[38]);
    assertEquals((byte) 0, actualUserKey[39]);
    assertEquals((byte) 0, actualUserKey[41]);
    assertEquals((byte) 0, actualUserKey[42]);
    assertEquals((byte) 0, actualUserKey[43]);
    assertEquals((byte) 0, actualUserKey[44]);
    assertEquals((byte) 0, actualUserKey[45]);
    assertEquals((byte) 0, actualUserKey[46]);
    assertEquals((byte) 0, actualUserKey[47]);
    assertEquals((byte) 0, actualUserKey[Integer.SIZE]);
    assertEquals((byte) 0, actualUserKey[PDEncryption.DEFAULT_LENGTH]);
    assertEquals(48, actualUserKey.length);
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Revision is
   * {@link Integer#SIZE}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); given PDEncryption() Revision is SIZE; then return 'AXAXAXAX' Bytes is 'UTF-8'")
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
  void testGetUserKey_givenPDEncryption_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getUserKey());
  }

  /**
   * Test {@link PDEncryption#getUserKey()}.
   * <ul>
   *   <li>Then return eleventh element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  @DisplayName("Test getUserKey(); then return eleventh element is zero")
  void testGetUserKey_thenReturnEleventhElementIsZero() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualUserKey = pdEncryption.getUserKey();

    // Assert
    assertEquals((byte) 0, actualUserKey[10]);
    assertEquals((byte) 0, actualUserKey[11]);
    assertEquals((byte) 0, actualUserKey[12]);
    assertEquals((byte) 0, actualUserKey[13]);
    assertEquals((byte) 0, actualUserKey[14]);
    assertEquals((byte) 0, actualUserKey[15]);
    assertEquals((byte) 0, actualUserKey[17]);
    assertEquals((byte) 0, actualUserKey[18]);
    assertEquals((byte) 0, actualUserKey[19]);
    assertEquals((byte) 0, actualUserKey[20]);
    assertEquals((byte) 0, actualUserKey[21]);
    assertEquals((byte) 0, actualUserKey[22]);
    assertEquals((byte) 0, actualUserKey[23]);
    assertEquals((byte) 0, actualUserKey[24]);
    assertEquals((byte) 0, actualUserKey[25]);
    assertEquals((byte) 0, actualUserKey[26]);
    assertEquals((byte) 0, actualUserKey[27]);
    assertEquals((byte) 0, actualUserKey[28]);
    assertEquals((byte) 0, actualUserKey[29]);
    assertEquals((byte) 0, actualUserKey[30]);
    assertEquals((byte) 0, actualUserKey[31]);
    assertEquals((byte) 0, actualUserKey[8]);
    assertEquals((byte) 0, actualUserKey[9]);
    assertEquals((byte) 0, actualUserKey[Short.SIZE]);
    assertEquals(Integer.SIZE, actualUserKey.length);
  }

  /**
   * Test {@link PDEncryption#setOwnerEncryptionKey(byte[])}.
   * <p>
   * Method under test: {@link PDEncryption#setOwnerEncryptionKey(byte[])}
   */
  @Test
  @DisplayName("Test setOwnerEncryptionKey(byte[])")
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getOwnerEncryptionKey()}
   */
  @Test
  @DisplayName("Test getOwnerEncryptionKey(); given PDEncryption() Filter is 'Filter'; then return 'null'")
  void testGetOwnerEncryptionKey_givenPDEncryptionFilterIsFilter_thenReturnNull() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getOwnerEncryptionKey());
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getUserEncryptionKey()}
   */
  @Test
  @DisplayName("Test getUserEncryptionKey(); given PDEncryption() Filter is 'Filter'; then return 'null'")
  void testGetUserEncryptionKey_givenPDEncryptionFilterIsFilter_thenReturnNull() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getUserEncryptionKey());
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
   *   <li>Then {@link PDEncryption#PDEncryption()} Permissions is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setPermissions(int)}
   */
  @Test
  @DisplayName("Test setPermissions(int); when MIN_VALUE; then PDEncryption() Permissions is MIN_VALUE")
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getPermissions()}
   */
  @Test
  @DisplayName("Test getPermissions(); given PDEncryption() Filter is 'Filter'; then return zero")
  void testGetPermissions_givenPDEncryptionFilterIsFilter_thenReturnZero() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertEquals(0, pdEncryption.getPermissions());
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
  void testGetPermissions_givenPDEncryption_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getPermissions());
  }

  /**
   * Test {@link PDEncryption#isEncryptMetaData()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#isEncryptMetaData()}
   */
  @Test
  @DisplayName("Test isEncryptMetaData(); given PDEncryption()")
  void testIsEncryptMetaData_givenPDEncryption() {
    // Arrange, Act and Assert
    assertTrue((new PDEncryption()).isEncryptMetaData());
  }

  /**
   * Test {@link PDEncryption#isEncryptMetaData()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#isEncryptMetaData()}
   */
  @Test
  @DisplayName("Test isEncryptMetaData(); given PDEncryption() Filter is 'Filter'")
  void testIsEncryptMetaData_givenPDEncryptionFilterIsFilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertTrue(pdEncryption.isEncryptMetaData());
  }

  /**
   * Test {@link PDEncryption#setRecipients(byte[][])}.
   * <p>
   * Method under test: {@link PDEncryption#setRecipients(byte[][])}
   */
  @Test
  @DisplayName("Test setRecipients(byte[][])")
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
  void testGetStdCryptFilterDictionary_givenPDEncryption() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getStdCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getStdCryptFilterDictionary()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStdCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test getStdCryptFilterDictionary(); given PDEncryption() Filter is 'Filter'")
  void testGetStdCryptFilterDictionary_givenPDEncryptionFilterIsFilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getStdCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getDefaultCryptFilterDictionary()}.
   * <p>
   * Method under test: {@link PDEncryption#getDefaultCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test getDefaultCryptFilterDictionary()")
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
  void testGetDefaultCryptFilterDictionary_givenPDEncryption() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getDefaultCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getDefaultCryptFilterDictionary()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getDefaultCryptFilterDictionary()}
   */
  @Test
  @DisplayName("Test getDefaultCryptFilterDictionary(); given PDEncryption() Filter is 'Filter'")
  void testGetDefaultCryptFilterDictionary_givenPDEncryptionFilterIsFilter() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getDefaultCryptFilterDictionary());
  }

  /**
   * Test {@link PDEncryption#getCryptFilterDictionary(COSName)}.
   * <p>
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCryptFilterDictionary(COSName)")
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCryptFilterDictionary(COSName); given PDEncryption() Filter is 'Filter'; then return 'null'")
  void testGetCryptFilterDictionary_givenPDEncryptionFilterIsFilter_thenReturnNull() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getCryptFilterDictionary(COSName.A));
  }

  /**
   * Test {@link PDEncryption#getCryptFilterDictionary(COSName)}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCryptFilterDictionary(COSName); given PDEncryption(); then return 'null'")
  void testGetCryptFilterDictionary_givenPDEncryption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getCryptFilterDictionary(COSName.A));
  }

  /**
   * Test
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); then PDEncryption() COSObject Values size is two")
  void testSetCryptFilterDictionary_thenPDEncryptionCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when 'null'; then PDEncryption() COSObject Values size is one")
  void testSetCryptFilterDictionary_whenNull_thenPDEncryptionCOSObjectValuesSizeIsOne() {
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
   * Test
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when PDCryptFilterDictionary()")
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
   * Test
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When
   * {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)} with d
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when PDCryptFilterDictionary(COSDictionary) with d is 'null'")
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
   * Test
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}.
   * <ul>
   *   <li>When
   * {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)} with d
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setCryptFilterDictionary(COSName, PDCryptFilterDictionary); when PDCryptFilterDictionary(COSDictionary) with d is 'null'")
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
   * Test
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <p>
   * Method under test:
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setStdCryptFilterDictionary(PDCryptFilterDictionary)")
  void testSetStdCryptFilterDictionary() {
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
   * Test
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <ul>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setStdCryptFilterDictionary(PDCryptFilterDictionary); then PDEncryption() COSObject Values size is one")
  void testSetStdCryptFilterDictionary_thenPDEncryptionCOSObjectValuesSizeIsOne() {
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
   * Test
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <ul>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setStdCryptFilterDictionary(PDCryptFilterDictionary); then PDEncryption() COSObject Values size is two")
  void testSetStdCryptFilterDictionary_thenPDEncryptionCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");
    PDCryptFilterDictionary cryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdEncryption.setStdCryptFilterDictionary(cryptFilterDictionary);

    // Assert
    PDCryptFilterDictionary stdCryptFilterDictionary = pdEncryption.getStdCryptFilterDictionary();
    assertNull(stdCryptFilterDictionary.getCryptFilterMethod());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = cryptFilterDictionary.getCOSObject();
    assertTrue(cOSObject2.isDirect());
    assertTrue(stdCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, stdCryptFilterDictionary.getLength());
    assertSame(cOSObject2, stdCryptFilterDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <p>
   * Method under test:
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setDefaultCryptFilterDictionary(PDCryptFilterDictionary)")
  void testSetDefaultCryptFilterDictionary() {
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
   * Test
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <ul>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setDefaultCryptFilterDictionary(PDCryptFilterDictionary); then PDEncryption() COSObject Values size is one")
  void testSetDefaultCryptFilterDictionary_thenPDEncryptionCOSObjectValuesSizeIsOne() {
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
   * Test
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}.
   * <ul>
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  @DisplayName("Test setDefaultCryptFilterDictionary(PDCryptFilterDictionary); then PDEncryption() COSObject Values size is two")
  void testSetDefaultCryptFilterDictionary_thenPDEncryptionCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");
    PDCryptFilterDictionary defaultFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdEncryption.setDefaultCryptFilterDictionary(defaultFilterDictionary);

    // Assert
    PDCryptFilterDictionary defaultCryptFilterDictionary = pdEncryption.getDefaultCryptFilterDictionary();
    assertNull(defaultCryptFilterDictionary.getCryptFilterMethod());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = defaultFilterDictionary.getCOSObject();
    assertTrue(cOSObject2.isDirect());
    assertTrue(defaultCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, defaultCryptFilterDictionary.getLength());
    assertSame(cOSObject2, defaultCryptFilterDictionary.getCOSObject());
  }

  /**
   * Test {@link PDEncryption#getStreamFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@link COSName#IDENTITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStreamFilterName()}
   */
  @Test
  @DisplayName("Test getStreamFilterName(); given PDEncryption() Filter is 'Filter'; then return IDENTITY")
  void testGetStreamFilterName_givenPDEncryptionFilterIsFilter_thenReturnIdentity() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act
    COSName actualStreamFilterName = pdEncryption.getStreamFilterName();

    // Assert
    COSName cosName = actualStreamFilterName.IDENTITY;
    assertSame(cosName, actualStreamFilterName);
    assertSame(cosName, pdEncryption.getStringFilterName());
  }

  /**
   * Test {@link PDEncryption#getStreamFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} StreamFilterName is
   * {@link COSName#A}.</li>
   *   <li>Then return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStreamFilterName()}
   */
  @Test
  @DisplayName("Test getStreamFilterName(); given PDEncryption() StreamFilterName is A; then return A")
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
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link PDEncryption#PDEncryption()} StringFilterName Name is
   * {@code Identity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setStreamFilterName(COSName)}
   */
  @Test
  @DisplayName("Test setStreamFilterName(COSName); when A; then PDEncryption() StringFilterName Name is 'Identity'")
  void testSetStreamFilterName_whenA_thenPDEncryptionStringFilterNameNameIsIdentity() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    COSName streamFilterName = COSName.A;

    // Act
    pdEncryption.setStreamFilterName(streamFilterName);

    // Assert
    COSName stringFilterName = pdEncryption.getStringFilterName();
    assertEquals("Identity", stringFilterName.getName());
    assertNull(stringFilterName.getKey());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(stringFilterName.isDirect());
    assertFalse(stringFilterName.isEmpty());
    COSName expectedStreamFilterName = streamFilterName.A;
    assertSame(expectedStreamFilterName, pdEncryption.getStreamFilterName());
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
  void testSetStreamFilterName_whenNull_thenPDEncryptionCOSObjectSizeIsZero() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setStreamFilterName(null);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDEncryption#getStringFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@link COSName#IDENTITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStringFilterName()}
   */
  @Test
  @DisplayName("Test getStringFilterName(); given PDEncryption() Filter is 'Filter'; then return IDENTITY")
  void testGetStringFilterName_givenPDEncryptionFilterIsFilter_thenReturnIdentity() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act
    COSName actualStringFilterName = pdEncryption.getStringFilterName();

    // Assert
    COSName cosName = actualStringFilterName.IDENTITY;
    assertSame(cosName, pdEncryption.getStreamFilterName());
    assertSame(cosName, actualStringFilterName);
  }

  /**
   * Test {@link PDEncryption#getStringFilterName()}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()} StringFilterName is
   * {@link COSName#A}.</li>
   *   <li>Then return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getStringFilterName()}
   */
  @Test
  @DisplayName("Test getStringFilterName(); given PDEncryption() StringFilterName is A; then return A")
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
   *   <li>Then {@link PDEncryption#PDEncryption()} COSObject Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#setStringFilterName(COSName)}
   */
  @Test
  @DisplayName("Test setStringFilterName(COSName); when A; then PDEncryption() COSObject Values size is one")
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
  void testSetStringFilterName_whenNull_thenPDEncryptionCOSObjectSizeIsZero() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();

    // Act
    pdEncryption.setStringFilterName(null);

    // Assert
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
   *   <li>Given {@link PDEncryption#PDEncryption()} Filter is {@code Filter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEncryption#getPerms()}
   */
  @Test
  @DisplayName("Test getPerms(); given PDEncryption() Filter is 'Filter'; then return 'null'")
  void testGetPerms_givenPDEncryptionFilterIsFilter_thenReturnNull() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertNull(pdEncryption.getPerms());
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
  void testRemoveV45filters_thenCallsGetNameAsString() {
    // Arrange
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(dictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    (new PDEncryption(dictionary)).removeV45filters();

    // Assert that nothing has changed
    verify(dictionary).getNameAsString(isA(COSName.class));
    verify(dictionary, atLeast(1)).setItem(Mockito.<COSName>any(), (COSBase) isNull());
  }
}
