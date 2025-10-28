package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDSeedValueCertificateDiffblueTest {
  /**
   * Method under test: {@link PDSeedValueCertificate#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDSeedValueCertificate()).getCOSObject();

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
   * Method under test: {@link PDSeedValueCertificate#isSubjectRequired()}
   */
  @Test
  void testIsSubjectRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isSubjectRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isSubjectRequired()}
   */
  @Test
  void testIsSubjectRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectRequired(boolean)}
   */
  @Test
  void testSetSubjectRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectRequired(boolean)}
   */
  @Test
  void testSetSubjectRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectRequired(boolean)}
   */
  @Test
  void testSetSubjectRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setIssuerRequired(true);

    // Act
    pdSeedValueCertificate.setSubjectRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isIssuerRequired()}
   */
  @Test
  void testIsIssuerRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isIssuerRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isIssuerRequired()}
   */
  @Test
  void testIsIssuerRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isIssuerRequired()}
   */
  @Test
  void testIsIssuerRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setIssuerRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setIssuerRequired(boolean)}
   */
  @Test
  void testSetIssuerRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setIssuerRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setIssuerRequired(boolean)}
   */
  @Test
  void testSetIssuerRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setIssuerRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setIssuerRequired(boolean)}
   */
  @Test
  void testSetIssuerRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setIssuerRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isIssuerRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isOIDRequired()}
   */
  @Test
  void testIsOIDRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isOIDRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isOIDRequired()}
   */
  @Test
  void testIsOIDRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isOIDRequired()}
   */
  @Test
  void testIsOIDRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setOIDRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setOIDRequired(boolean)}
   */
  @Test
  void testSetOIDRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setOIDRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setOIDRequired(boolean)}
   */
  @Test
  void testSetOIDRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setOIDRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setOIDRequired(boolean)}
   */
  @Test
  void testSetOIDRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setOIDRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isOIDRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isSubjectDNRequired()}
   */
  @Test
  void testIsSubjectDNRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isSubjectDNRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isSubjectDNRequired()}
   */
  @Test
  void testIsSubjectDNRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isSubjectDNRequired()}
   */
  @Test
  void testIsSubjectDNRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDNRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}
   */
  @Test
  void testSetSubjectDNRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectDNRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}
   */
  @Test
  void testSetSubjectDNRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectDNRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#setSubjectDNRequired(boolean)}
   */
  @Test
  void testSetSubjectDNRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setSubjectDNRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isSubjectDNRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isKeyUsageRequired()}
   */
  @Test
  void testIsKeyUsageRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isKeyUsageRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isKeyUsageRequired()}
   */
  @Test
  void testIsKeyUsageRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isKeyUsageRequired()}
   */
  @Test
  void testIsKeyUsageRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setKeyUsageRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}
   */
  @Test
  void testSetKeyUsageRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setKeyUsageRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}
   */
  @Test
  void testSetKeyUsageRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setKeyUsageRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#setKeyUsageRequired(boolean)}
   */
  @Test
  void testSetKeyUsageRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setKeyUsageRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isKeyUsageRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isURLRequired()}
   */
  @Test
  void testIsURLRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueCertificate()).isURLRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isURLRequired()}
   */
  @Test
  void testIsURLRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act and Assert
    assertFalse(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#isURLRequired()}
   */
  @Test
  void testIsURLRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURLRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setURLRequired(boolean)}
   */
  @Test
  void testSetURLRequired() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setURLRequired(boolean)}
   */
  @Test
  void testSetURLRequired2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setURLRequired(boolean)}
   */
  @Test
  void testSetURLRequired3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectRequired(true);

    // Act
    pdSeedValueCertificate.setURLRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.isURLRequired());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubject()}
   */
  @Test
  void testGetSubject() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getSubject());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubject()}
   */
  @Test
  void testGetSubject2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<byte[]> actualSubject = pdSeedValueCertificate.getSubject();

    // Assert
    assertEquals(1, actualSubject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSubject.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubject(List)}
   */
  @Test
  void testSetSubject() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubject(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getSubject().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubject(List)}
   */
  @Test
  void testSetSubject2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> subjects = new ArrayList<>();
    subjects.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setSubject(subjects);

    // Assert
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(1, subject.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, subject.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubject(List)}
   */
  @Test
  void testSetSubject3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> subjects = new ArrayList<>();
    subjects.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    subjects.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setSubject(subjects);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(2, subject.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, subject.get(0));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, subject.get(1));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addSubject(byte[])}
   */
  @Test
  void testAddSubject() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(1, subject.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), subject.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addSubject(byte[])}
   */
  @Test
  void testAddSubject2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> subject = pdSeedValueCertificate.getSubject();
    assertEquals(2, subject.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), subject.get(1));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, subject.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  void testRemoveSubject() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getSubject());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  void testRemoveSubject2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(pdSeedValueCertificate.getSubject().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  void testRemoveSubject3() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    pdSeedValueCertificate.addSubject("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  void testRemoveSubject4() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  void testRemoveSubject5() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeSubject(byte[])}
   */
  @Test
  void testRemoveSubject6() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addSubject(new byte[]{-2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeSubject("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getSubject().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  void testGetSubjectDN() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  void testGetSubjectDN2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDN(new ArrayList<>());

    // Act and Assert
    assertTrue(pdSeedValueCertificate.getSubjectDN().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  void testGetSubjectDN3() {
    // Arrange
    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(new HashMap<>());

    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Act and Assert
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  void testGetSubjectDN4() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Act and Assert
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  void testGetSubjectDN5() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.computeIfPresent("foo", mock(BiFunction.class));
    stringStringMap.put("foo", "foo");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Act and Assert
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getSubjectDN()}
   */
  @Test
  void testGetSubjectDN6() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Act and Assert
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  void testSetSubjectDN() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setSubjectDN(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getSubjectDN().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  void testSetSubjectDN2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(new HashMap<>());

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  void testSetSubjectDN3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(new HashMap<>());
    subjectDN.add(new HashMap<>());

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  void testSetSubjectDN4() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  void testSetSubjectDN5() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "42");
    stringStringMap.put("foo", "foo");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setSubjectDN(List)}
   */
  @Test
  void testSetSubjectDN6() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.computeIfPresent("foo", mock(BiFunction.class));
    stringStringMap.put("foo", "foo");

    ArrayList<Map<String, String>> subjectDN = new ArrayList<>();
    subjectDN.add(stringStringMap);

    // Act
    pdSeedValueCertificate.setSubjectDN(subjectDN);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(subjectDN, pdSeedValueCertificate.getSubjectDN());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getKeyUsage()}
   */
  @Test
  void testGetKeyUsage() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getKeyUsage());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getKeyUsage()}
   */
  @Test
  void testGetKeyUsage2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addKeyUsage("");

    // Act
    List<String> actualKeyUsage = pdSeedValueCertificate.getKeyUsage();

    // Assert
    assertEquals(1, actualKeyUsage.size());
    assertEquals("", actualKeyUsage.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setKeyUsage(List)}
   */
  @Test
  void testSetKeyUsage() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setKeyUsage(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getKeyUsage().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setKeyUsage(List)}
   */
  @Test
  void testSetKeyUsage2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<String> keyUsageExtensions = new ArrayList<>();
    keyUsageExtensions.add("foo");

    // Act
    pdSeedValueCertificate.setKeyUsage(keyUsageExtensions);

    // Assert
    List<String> keyUsage = pdSeedValueCertificate.getKeyUsage();
    assertEquals(1, keyUsage.size());
    assertEquals("foo", keyUsage.get(0));
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setKeyUsage(List)}
   */
  @Test
  void testSetKeyUsage3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<String> keyUsageExtensions = new ArrayList<>();
    keyUsageExtensions.add("42");
    keyUsageExtensions.add("foo");

    // Act
    pdSeedValueCertificate.setKeyUsage(keyUsageExtensions);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(keyUsageExtensions, pdSeedValueCertificate.getKeyUsage());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#addKeyUsage(char, char, char, char, char, char, char, char, char)}
   */
  @Test
  void testAddKeyUsage() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDSeedValueCertificate()).addKeyUsage('A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'));
    assertThrows(IllegalArgumentException.class,
        () -> (new PDSeedValueCertificate()).addKeyUsage('1', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'));
    assertThrows(IllegalArgumentException.class,
        () -> (new PDSeedValueCertificate()).addKeyUsage("Key Usage Extension"));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addKeyUsage(String)}
   */
  @Test
  void testAddKeyUsage2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addKeyUsage("01X");

    // Assert
    List<String> keyUsage = pdSeedValueCertificate.getKeyUsage();
    assertEquals(1, keyUsage.size());
    assertEquals("01X", keyUsage.get(0));
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addKeyUsage(String)}
   */
  @Test
  void testAddKeyUsage3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addKeyUsage("");

    // Act
    pdSeedValueCertificate.addKeyUsage("01X");

    // Assert
    List<String> keyUsage = pdSeedValueCertificate.getKeyUsage();
    assertEquals(2, keyUsage.size());
    assertEquals("", keyUsage.get(0));
    assertEquals("01X", keyUsage.get(1));
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getIssuer()}
   */
  @Test
  void testGetIssuer() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getIssuer());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getIssuer()}
   */
  @Test
  void testGetIssuer2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<byte[]> actualIssuer = pdSeedValueCertificate.getIssuer();

    // Assert
    assertEquals(1, actualIssuer.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualIssuer.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setIssuer(List)}
   */
  @Test
  void testSetIssuer() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setIssuer(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getIssuer().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setIssuer(List)}
   */
  @Test
  void testSetIssuer2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> issuers = new ArrayList<>();
    issuers.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setIssuer(issuers);

    // Assert
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(1, issuer.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, issuer.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setIssuer(List)}
   */
  @Test
  void testSetIssuer3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> issuers = new ArrayList<>();
    issuers.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    issuers.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setIssuer(issuers);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(2, issuer.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, issuer.get(0));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, issuer.get(1));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addIssuer(byte[])}
   */
  @Test
  void testAddIssuer() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(1, issuer.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), issuer.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addIssuer(byte[])}
   */
  @Test
  void testAddIssuer2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> issuer = pdSeedValueCertificate.getIssuer();
    assertEquals(2, issuer.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), issuer.get(1));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, issuer.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  void testRemoveIssuer() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getIssuer());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  void testRemoveIssuer2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(pdSeedValueCertificate.getIssuer().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  void testRemoveIssuer3() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    pdSeedValueCertificate.addIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  void testRemoveIssuer4() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  void testRemoveIssuer5() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeIssuer(byte[])}
   */
  @Test
  void testRemoveIssuer6() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addIssuer(new byte[]{-2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeIssuer("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getIssuer().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getOID()}
   */
  @Test
  void testGetOID() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getOID());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getOID()}
   */
  @Test
  void testGetOID2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<byte[]> actualOID = pdSeedValueCertificate.getOID();

    // Assert
    assertEquals(1, actualOID.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOID.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setOID(List)}
   */
  @Test
  void testSetOID() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setOID(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdSeedValueCertificate.getOID().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setOID(List)}
   */
  @Test
  void testSetOID2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> oidByteStrings = new ArrayList<>();
    oidByteStrings.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setOID(oidByteStrings);

    // Assert
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(1, oID.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, oID.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setOID(List)}
   */
  @Test
  void testSetOID3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    ArrayList<byte[]> oidByteStrings = new ArrayList<>();
    oidByteStrings.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    oidByteStrings.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.setOID(oidByteStrings);

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(2, oID.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, oID.get(0));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, oID.get(1));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addOID(byte[])}
   */
  @Test
  void testAddOID() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(1, oID.size());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), oID.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#addOID(byte[])}
   */
  @Test
  void testAddOID2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    List<byte[]> oID = pdSeedValueCertificate.getOID();
    assertEquals(2, oID.size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), oID.get(1));
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, oID.get(0));
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  void testRemoveOID() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertNull(pdSeedValueCertificate.getOID());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  void testRemoveOID2() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(pdSeedValueCertificate.getOID().isEmpty());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  void testRemoveOID3() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    pdSeedValueCertificate.addOID("AXAXAXAX".getBytes("UTF-8"));

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  void testRemoveOID4() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  void testRemoveOID5() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#removeOID(byte[])}
   */
  @Test
  void testRemoveOID6() throws UnsupportedEncodingException {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.addOID(new byte[]{-2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    pdSeedValueCertificate.removeOID("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, pdSeedValueCertificate.getOID().size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getURL()}
   */
  @Test
  void testGetURL() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getURL());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getURL()}
   */
  @Test
  void testGetURL2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURL());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getURL()}
   */
  @Test
  void testGetURL3() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURL("");

    // Act and Assert
    assertEquals("", pdSeedValueCertificate.getURL());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setURL(String)}
   */
  @Test
  void testSetURL() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURL());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getURLType()}
   */
  @Test
  void testGetURLType() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueCertificate()).getURLType());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#getURLType()}
   */
  @Test
  void testGetURLType2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();
    pdSeedValueCertificate.setURLType("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURLType());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setURLType(String)}
   */
  @Test
  void testSetURLType() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLType("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", pdSeedValueCertificate.getURLType());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#setURLType(String)}
   */
  @Test
  void testSetURLType2() {
    // Arrange
    PDSeedValueCertificate pdSeedValueCertificate = new PDSeedValueCertificate();

    // Act
    pdSeedValueCertificate.setURLType("Url Type");

    // Assert
    assertEquals("Url Type", pdSeedValueCertificate.getURLType());
    COSDictionary cOSObject = pdSeedValueCertificate.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValueCertificate#PDSeedValueCertificate()}
   */
  @Test
  void testNewPDSeedValueCertificate() {
    // Arrange and Act
    PDSeedValueCertificate actualPdSeedValueCertificate = new PDSeedValueCertificate();

    // Assert
    assertNull(actualPdSeedValueCertificate.getURL());
    assertNull(actualPdSeedValueCertificate.getURLType());
    assertNull(actualPdSeedValueCertificate.getIssuer());
    assertNull(actualPdSeedValueCertificate.getOID());
    assertNull(actualPdSeedValueCertificate.getSubject());
    assertNull(actualPdSeedValueCertificate.getKeyUsage());
    assertNull(actualPdSeedValueCertificate.getSubjectDN());
    COSDictionary cOSObject = actualPdSeedValueCertificate.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdSeedValueCertificate.isIssuerRequired());
    assertFalse(actualPdSeedValueCertificate.isKeyUsageRequired());
    assertFalse(actualPdSeedValueCertificate.isOIDRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectDNRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectRequired());
    assertFalse(actualPdSeedValueCertificate.isURLRequired());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Method under test:
   * {@link PDSeedValueCertificate#PDSeedValueCertificate(COSDictionary)}
   */
  @Test
  void testNewPDSeedValueCertificate2() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDSeedValueCertificate actualPdSeedValueCertificate = new PDSeedValueCertificate(dict);

    // Assert
    assertNull(actualPdSeedValueCertificate.getURL());
    assertNull(actualPdSeedValueCertificate.getURLType());
    assertNull(actualPdSeedValueCertificate.getIssuer());
    assertNull(actualPdSeedValueCertificate.getOID());
    assertNull(actualPdSeedValueCertificate.getSubject());
    assertNull(actualPdSeedValueCertificate.getKeyUsage());
    assertNull(actualPdSeedValueCertificate.getSubjectDN());
    assertFalse(actualPdSeedValueCertificate.isIssuerRequired());
    assertFalse(actualPdSeedValueCertificate.isKeyUsageRequired());
    assertFalse(actualPdSeedValueCertificate.isOIDRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectDNRequired());
    assertFalse(actualPdSeedValueCertificate.isSubjectRequired());
    assertFalse(actualPdSeedValueCertificate.isURLRequired());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdSeedValueCertificate.getCOSObject());
  }
}
