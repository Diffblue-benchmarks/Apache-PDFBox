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
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDEncryptionDiffblueTest {
  /**
   * Method under test: {@link PDEncryption#getSecurityHandler()}
   */
  @Test
  void testGetSecurityHandler() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDEncryption()).getSecurityHandler());
  }

  /**
   * Method under test: {@link PDEncryption#getSecurityHandler()}
   */
  @Test
  void testGetSecurityHandler2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertThrows(IOException.class, () -> pdEncryption.getSecurityHandler());
  }

  /**
   * Method under test: {@link PDEncryption#hasSecurityHandler()}
   */
  @Test
  void testHasSecurityHandler() {
    // Arrange, Act and Assert
    assertTrue((new PDEncryption()).hasSecurityHandler());
  }

  /**
   * Method under test: {@link PDEncryption#hasSecurityHandler()}
   */
  @Test
  void testHasSecurityHandler2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertFalse(pdEncryption.hasSecurityHandler());
  }

  /**
   * Method under test: {@link PDEncryption#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link PDEncryption#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    COSDictionary actualCOSObject = pdEncryption.getCOSObject();

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
   * Method under test: {@link PDEncryption#setFilter(String)}
   */
  @Test
  void testSetFilter() {
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
   * Method under test: {@link PDEncryption#setFilter(String)}
   */
  @Test
  void testSetFilter2() {
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
   * Method under test: {@link PDEncryption#setFilter(String)}
   */
  @Test
  void testSetFilter3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setFilter("Filter");

    // Assert
    assertEquals("Filter", pdEncryption.getFilter());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDEncryption#getFilter()}
   */
  @Test
  void testGetFilter() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getFilter());
  }

  /**
   * Method under test: {@link PDEncryption#getFilter()}
   */
  @Test
  void testGetFilter2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getFilter());
  }

  /**
   * Method under test: {@link PDEncryption#getFilter()}
   */
  @Test
  void testGetFilter3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setFilter("Filter");

    // Act and Assert
    assertEquals("Filter", pdEncryption.getFilter());
  }

  /**
   * Method under test: {@link PDEncryption#getSubFilter()}
   */
  @Test
  void testGetSubFilter() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getSubFilter());
  }

  /**
   * Method under test: {@link PDEncryption#getSubFilter()}
   */
  @Test
  void testGetSubFilter2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getSubFilter());
  }

  /**
   * Method under test: {@link PDEncryption#getSubFilter()}
   */
  @Test
  void testGetSubFilter3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSubFilter("Subfilter");

    // Act and Assert
    assertEquals("Subfilter", pdEncryption.getSubFilter());
  }

  /**
   * Method under test: {@link PDEncryption#setSubFilter(String)}
   */
  @Test
  void testSetSubFilter() {
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
   * Method under test: {@link PDEncryption#setSubFilter(String)}
   */
  @Test
  void testSetSubFilter2() {
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
   * Method under test: {@link PDEncryption#setSubFilter(String)}
   */
  @Test
  void testSetSubFilter3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setSubFilter("Subfilter");

    // Assert
    assertEquals("Subfilter", pdEncryption.getSubFilter());
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDEncryption#setVersion(int)}
   */
  @Test
  void testSetVersion() {
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
   * Method under test: {@link PDEncryption#setVersion(int)}
   */
  @Test
  void testSetVersion2() {
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
   * Method under test: {@link PDEncryption#setVersion(int)}
   */
  @Test
  void testSetVersion3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setVersion(1);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getVersion());
  }

  /**
   * Method under test: {@link PDEncryption#getVersion()}
   */
  @Test
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getVersion());
  }

  /**
   * Method under test: {@link PDEncryption#getVersion()}
   */
  @Test
  void testGetVersion2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertEquals(0, pdEncryption.getVersion());
  }

  /**
   * Method under test: {@link PDEncryption#getVersion()}
   */
  @Test
  void testGetVersion3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setVersion(1);

    // Act and Assert
    assertEquals(1, pdEncryption.getVersion());
  }

  /**
   * Method under test: {@link PDEncryption#setLength(int)}
   */
  @Test
  void testSetLength() {
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
   * Method under test: {@link PDEncryption#setLength(int)}
   */
  @Test
  void testSetLength2() {
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
   * Method under test: {@link PDEncryption#setLength(int)}
   */
  @Test
  void testSetLength3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setLength(3);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, pdEncryption.getLength());
  }

  /**
   * Method under test: {@link PDEncryption#getLength()}
   */
  @Test
  void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, (new PDEncryption()).getLength());
  }

  /**
   * Method under test: {@link PDEncryption#getLength()}
   */
  @Test
  void testGetLength2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, pdEncryption.getLength());
  }

  /**
   * Method under test: {@link PDEncryption#getLength()}
   */
  @Test
  void testGetLength3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setLength(3);

    // Act and Assert
    assertEquals(3, pdEncryption.getLength());
  }

  /**
   * Method under test: {@link PDEncryption#setRevision(int)}
   */
  @Test
  void testSetRevision() {
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
   * Method under test: {@link PDEncryption#setRevision(int)}
   */
  @Test
  void testSetRevision2() {
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
   * Method under test: {@link PDEncryption#setRevision(int)}
   */
  @Test
  void testSetRevision3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setRevision(1);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getRevision());
  }

  /**
   * Method under test: {@link PDEncryption#getRevision()}
   */
  @Test
  void testGetRevision() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getRevision());
  }

  /**
   * Method under test: {@link PDEncryption#getRevision()}
   */
  @Test
  void testGetRevision2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertEquals(0, pdEncryption.getRevision());
  }

  /**
   * Method under test: {@link PDEncryption#getRevision()}
   */
  @Test
  void testGetRevision3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(1);

    // Act and Assert
    assertEquals(1, pdEncryption.getRevision());
  }

  /**
   * Method under test: {@link PDEncryption#setOwnerKey(byte[])}
   */
  @Test
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
   * Method under test: {@link PDEncryption#setOwnerKey(byte[])}
   */
  @Test
  void testSetOwnerKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

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
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  void testGetOwnerKey() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getOwnerKey());
  }

  /**
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  void testGetOwnerKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getOwnerKey());
  }

  /**
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  void testGetOwnerKey3() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  void testGetOwnerKey4() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(4);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  void testGetOwnerKey5() throws IOException {
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
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  void testGetOwnerKey6() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(5);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Method under test: {@link PDEncryption#getOwnerKey()}
   */
  @Test
  void testGetOwnerKey7() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(6);
    pdEncryption.setOwnerKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerKey());
  }

  /**
   * Method under test: {@link PDEncryption#setUserKey(byte[])}
   */
  @Test
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
   * Method under test: {@link PDEncryption#setUserKey(byte[])}
   */
  @Test
  void testSetUserKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

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
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  void testGetUserKey() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getUserKey());
  }

  /**
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  void testGetUserKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getUserKey());
  }

  /**
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  void testGetUserKey3() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  void testGetUserKey4() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(4);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  void testGetUserKey5() throws IOException {
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
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  void testGetUserKey6() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(5);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Method under test: {@link PDEncryption#getUserKey()}
   */
  @Test
  void testGetUserKey7() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRevision(6);
    pdEncryption.setUserKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserKey());
  }

  /**
   * Method under test: {@link PDEncryption#setOwnerEncryptionKey(byte[])}
   */
  @Test
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
   * Method under test: {@link PDEncryption#setOwnerEncryptionKey(byte[])}
   */
  @Test
  void testSetOwnerEncryptionKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

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
   * Method under test: {@link PDEncryption#getOwnerEncryptionKey()}
   */
  @Test
  void testGetOwnerEncryptionKey() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getOwnerEncryptionKey());
  }

  /**
   * Method under test: {@link PDEncryption#getOwnerEncryptionKey()}
   */
  @Test
  void testGetOwnerEncryptionKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getOwnerEncryptionKey());
  }

  /**
   * Method under test: {@link PDEncryption#getOwnerEncryptionKey()}
   */
  @Test
  void testGetOwnerEncryptionKey3() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setOwnerEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getOwnerEncryptionKey());
  }

  /**
   * Method under test: {@link PDEncryption#setUserEncryptionKey(byte[])}
   */
  @Test
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
   * Method under test: {@link PDEncryption#setUserEncryptionKey(byte[])}
   */
  @Test
  void testSetUserEncryptionKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

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
   * Method under test: {@link PDEncryption#getUserEncryptionKey()}
   */
  @Test
  void testGetUserEncryptionKey() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getUserEncryptionKey());
  }

  /**
   * Method under test: {@link PDEncryption#getUserEncryptionKey()}
   */
  @Test
  void testGetUserEncryptionKey2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getUserEncryptionKey());
  }

  /**
   * Method under test: {@link PDEncryption#getUserEncryptionKey()}
   */
  @Test
  void testGetUserEncryptionKey3() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setUserEncryptionKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, pdEncryption.getUserEncryptionKey());
  }

  /**
   * Method under test: {@link PDEncryption#setPermissions(int)}
   */
  @Test
  void testSetPermissions() {
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
   * Method under test: {@link PDEncryption#setPermissions(int)}
   */
  @Test
  void testSetPermissions2() {
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
   * Method under test: {@link PDEncryption#setPermissions(int)}
   */
  @Test
  void testSetPermissions3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setPermissions(1);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getPermissions());
  }

  /**
   * Method under test: {@link PDEncryption#getPermissions()}
   */
  @Test
  void testGetPermissions() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDEncryption()).getPermissions());
  }

  /**
   * Method under test: {@link PDEncryption#getPermissions()}
   */
  @Test
  void testGetPermissions2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertEquals(0, pdEncryption.getPermissions());
  }

  /**
   * Method under test: {@link PDEncryption#getPermissions()}
   */
  @Test
  void testGetPermissions3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setPermissions(1);

    // Act and Assert
    assertEquals(1, pdEncryption.getPermissions());
  }

  /**
   * Method under test: {@link PDEncryption#isEncryptMetaData()}
   */
  @Test
  void testIsEncryptMetaData() {
    // Arrange, Act and Assert
    assertTrue((new PDEncryption()).isEncryptMetaData());
  }

  /**
   * Method under test: {@link PDEncryption#isEncryptMetaData()}
   */
  @Test
  void testIsEncryptMetaData2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertTrue(pdEncryption.isEncryptMetaData());
  }

  /**
   * Method under test: {@link PDEncryption#setRecipients(byte[][])}
   */
  @Test
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
   * Method under test: {@link PDEncryption#setRecipients(byte[][])}
   */
  @Test
  void testSetRecipients2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setRecipients(new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdEncryption.getRecipientsLength());
  }

  /**
   * Method under test: {@link PDEncryption#getRecipientsLength()}
   */
  @Test
  void testGetRecipientsLength() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setRecipients(new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Act and Assert
    assertEquals(1, pdEncryption.getRecipientsLength());
  }

  /**
   * Method under test: {@link PDEncryption#getRecipientStringAt(int)}
   */
  @Test
  void testGetRecipientStringAt() throws IOException {
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
   * Method under test: {@link PDEncryption#getStdCryptFilterDictionary()}
   */
  @Test
  void testGetStdCryptFilterDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getStdCryptFilterDictionary());
  }

  /**
   * Method under test: {@link PDEncryption#getStdCryptFilterDictionary()}
   */
  @Test
  void testGetStdCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getStdCryptFilterDictionary());
  }

  /**
   * Method under test: {@link PDEncryption#getStdCryptFilterDictionary()}
   */
  @Test
  void testGetStdCryptFilterDictionary3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getStdCryptFilterDictionary());
  }

  /**
   * Method under test: {@link PDEncryption#getDefaultCryptFilterDictionary()}
   */
  @Test
  void testGetDefaultCryptFilterDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getDefaultCryptFilterDictionary());
  }

  /**
   * Method under test: {@link PDEncryption#getDefaultCryptFilterDictionary()}
   */
  @Test
  void testGetDefaultCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getDefaultCryptFilterDictionary());
  }

  /**
   * Method under test: {@link PDEncryption#getDefaultCryptFilterDictionary()}
   */
  @Test
  void testGetDefaultCryptFilterDictionary3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getDefaultCryptFilterDictionary());
  }

  /**
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  void testGetCryptFilterDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getCryptFilterDictionary(COSName.A));
  }

  /**
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  void testGetCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getCryptFilterDictionary(COSName.A));
  }

  /**
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  void testGetCryptFilterDictionary3() {
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
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  void testGetCryptFilterDictionary4() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.AA, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getCryptFilterDictionary(COSName.A));
  }

  /**
   * Method under test: {@link PDEncryption#getCryptFilterDictionary(COSName)}
   */
  @Test
  void testGetCryptFilterDictionary5() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Act and Assert
    assertNull(pdEncryption.getCryptFilterDictionary(null));
  }

  /**
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  void testSetCryptFilterDictionary() {
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
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  void testSetCryptFilterDictionary2() {
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
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  void testSetCryptFilterDictionary3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    pdEncryption.setCryptFilterDictionary(COSName.A, new PDCryptFilterDictionary());

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  void testSetCryptFilterDictionary4() {
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
   * Method under test:
   * {@link PDEncryption#setCryptFilterDictionary(COSName, PDCryptFilterDictionary)}
   */
  @Test
  void testSetCryptFilterDictionary5() {
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
   * Method under test:
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
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
   * Method under test:
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  void testSetStdCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));
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
   * Method under test:
   * {@link PDEncryption#setStdCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  void testSetStdCryptFilterDictionary3() {
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
   * Method under test:
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
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
   * Method under test:
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  void testSetDefaultCryptFilterDictionary2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));
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
   * Method under test:
   * {@link PDEncryption#setDefaultCryptFilterDictionary(PDCryptFilterDictionary)}
   */
  @Test
  void testSetDefaultCryptFilterDictionary3() {
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
   * Method under test: {@link PDEncryption#getStreamFilterName()}
   */
  @Test
  void testGetStreamFilterName() {
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
   * Method under test: {@link PDEncryption#getStreamFilterName()}
   */
  @Test
  void testGetStreamFilterName2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    COSName actualStreamFilterName = pdEncryption.getStreamFilterName();

    // Assert
    COSName cosName = actualStreamFilterName.IDENTITY;
    assertSame(cosName, actualStreamFilterName);
    assertSame(cosName, pdEncryption.getStringFilterName());
  }

  /**
   * Method under test: {@link PDEncryption#getStreamFilterName()}
   */
  @Test
  void testGetStreamFilterName3() {
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
   * Method under test: {@link PDEncryption#setStreamFilterName(COSName)}
   */
  @Test
  void testSetStreamFilterName() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    COSName streamFilterName = COSName.A;

    // Act
    pdEncryption.setStreamFilterName(streamFilterName);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSName expectedStreamFilterName = streamFilterName.A;
    assertSame(expectedStreamFilterName, pdEncryption.getStreamFilterName());
    COSName expectedStringFilterName = streamFilterName.IDENTITY;
    assertSame(expectedStringFilterName, pdEncryption.getStringFilterName());
  }

  /**
   * Method under test: {@link PDEncryption#setStreamFilterName(COSName)}
   */
  @Test
  void testSetStreamFilterName2() {
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
   * Method under test: {@link PDEncryption#setStreamFilterName(COSName)}
   */
  @Test
  void testSetStreamFilterName3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));
    COSName streamFilterName = COSName.A;

    // Act
    pdEncryption.setStreamFilterName(streamFilterName);

    // Assert
    COSDictionary cOSObject = pdEncryption.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSName expectedStreamFilterName = streamFilterName.A;
    assertSame(expectedStreamFilterName, pdEncryption.getStreamFilterName());
    COSName expectedStringFilterName = streamFilterName.IDENTITY;
    assertSame(expectedStringFilterName, pdEncryption.getStringFilterName());
  }

  /**
   * Method under test: {@link PDEncryption#getStringFilterName()}
   */
  @Test
  void testGetStringFilterName() {
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
   * Method under test: {@link PDEncryption#getStringFilterName()}
   */
  @Test
  void testGetStringFilterName2() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act
    COSName actualStringFilterName = pdEncryption.getStringFilterName();

    // Assert
    COSName cosName = actualStringFilterName.IDENTITY;
    assertSame(cosName, pdEncryption.getStreamFilterName());
    assertSame(cosName, actualStringFilterName);
  }

  /**
   * Method under test: {@link PDEncryption#getStringFilterName()}
   */
  @Test
  void testGetStringFilterName3() {
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
   * Method under test: {@link PDEncryption#setStringFilterName(COSName)}
   */
  @Test
  void testSetStringFilterName() {
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
   * Method under test: {@link PDEncryption#setStringFilterName(COSName)}
   */
  @Test
  void testSetStringFilterName2() {
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
   * Method under test: {@link PDEncryption#setStringFilterName(COSName)}
   */
  @Test
  void testSetStringFilterName3() {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));
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
   * Method under test: {@link PDEncryption#setPerms(byte[])}
   */
  @Test
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
   * Method under test: {@link PDEncryption#setPerms(byte[])}
   */
  @Test
  void testSetPerms2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

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
   * Method under test: {@link PDEncryption#getPerms()}
   */
  @Test
  void testGetPerms() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEncryption()).getPerms());
  }

  /**
   * Method under test: {@link PDEncryption#getPerms()}
   */
  @Test
  void testGetPerms2() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setSecurityHandler(mock(SecurityHandler.class));

    // Act and Assert
    assertNull(pdEncryption.getPerms());
  }

  /**
   * Method under test: {@link PDEncryption#getPerms()}
   */
  @Test
  void testGetPerms3() throws IOException {
    // Arrange
    PDEncryption pdEncryption = new PDEncryption();
    pdEncryption.setPerms("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPerms = pdEncryption.getPerms();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPerms);
  }

  /**
   * Method under test: {@link PDEncryption#removeV45filters()}
   */
  @Test
  void testRemoveV45filters() {
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
