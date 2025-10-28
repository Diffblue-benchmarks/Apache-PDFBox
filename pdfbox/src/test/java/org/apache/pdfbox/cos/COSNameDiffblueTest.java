package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSNameDiffblueTest {
  /**
   * Method under test: {@link COSName#getPDFName(String)}
   */
  @Test
  void testGetPDFName() {
    // Arrange and Act
    COSName actualPDFName = COSName.getPDFName("A Name");

    // Assert
    assertEquals("A Name", actualPDFName.getName());
    assertNull(actualPDFName.getKey());
    assertFalse(actualPDFName.isDirect());
    assertFalse(actualPDFName.isEmpty());
  }

  /**
   * Method under test: {@link COSName#getPDFName(String)}
   */
  @Test
  void testGetPDFName2() {
    // Arrange and Act
    COSName actualPDFName = COSName.getPDFName("Yes");

    // Assert
    assertEquals("Yes", actualPDFName.getName());
    assertNull(actualPDFName.getKey());
    assertFalse(actualPDFName.isDirect());
    assertFalse(actualPDFName.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#equals(Object)}
   *   <li>{@link COSName#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSName cosName = COSName.A;
    COSName cosName2 = COSName.A;

    // Act and Assert
    assertEquals(cosName, cosName2);
    int expectedHashCodeResult = cosName.hashCode();
    assertEquals(expectedHashCodeResult, cosName2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#equals(Object)}
   *   <li>{@link COSName#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSName cosName = COSName.A;

    // Act and Assert
    assertEquals(cosName, cosName);
    int expectedHashCodeResult = cosName.hashCode();
    assertEquals(expectedHashCodeResult, cosName.hashCode());
  }

  /**
   * Method under test: {@link COSName#compareTo(COSName)}
   */
  @Test
  void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, COSName.A.compareTo(COSName.A));
  }

  /**
   * Method under test: {@link COSName#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(COSName.A.isEmpty());
  }

  /**
   * Method under test: {@link COSName#accept(ICOSVisitor)}
   */
  @Test
  void testAccept() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromName(Mockito.<COSName>any());

    // Act
    COSName.A.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromName(isA(COSName.class));
  }

  /**
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.A.writePDF(output);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{'/', 'A'}, output.toByteArray());
  }

  /**
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF2() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ABSOLUTE_COLORIMETRIC.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "/AbsoluteColorimetric".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF3() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ADBE_PKCS7_DETACHED.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "/adbe.pkcs7.detached".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF4() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ADBE_X509_RSA_SHA1.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "/adbe.x509.rsa_sha1".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.AA, COSName.A);
  }

  /**
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.A, null);
  }

  /**
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.A, "Different type to COSName");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#toString()}
   *   <li>{@link COSName#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSName cosName = COSName.A;

    // Act
    String actualToStringResult = cosName.toString();

    // Assert
    assertEquals("A", cosName.getName());
    assertEquals("COSName{A}", actualToStringResult);
  }
}
