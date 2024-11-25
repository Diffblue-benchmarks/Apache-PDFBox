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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSNameDiffblueTest {
  /**
   * Test {@link COSName#getPDFName(String)}.
   * <ul>
   *   <li>When {@code A Name}.</li>
   *   <li>Then return Name is {@code A Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#getPDFName(String)}
   */
  @Test
  @DisplayName("Test getPDFName(String); when 'A Name'; then return Name is 'A Name'")
  void testGetPDFName_whenAName_thenReturnNameIsAName() {
    // Arrange and Act
    COSName actualPDFName = COSName.getPDFName("A Name");

    // Assert
    assertEquals("A Name", actualPDFName.getName());
    assertNull(actualPDFName.getKey());
    assertFalse(actualPDFName.isDirect());
    assertFalse(actualPDFName.isEmpty());
  }

  /**
   * Test {@link COSName#getPDFName(String)}.
   * <ul>
   *   <li>When {@code Yes}.</li>
   *   <li>Then return Name is {@code Yes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#getPDFName(String)}
   */
  @Test
  @DisplayName("Test getPDFName(String); when 'Yes'; then return Name is 'Yes'")
  void testGetPDFName_whenYes_thenReturnNameIsYes() {
    // Arrange and Act
    COSName actualPDFName = COSName.getPDFName("Yes");

    // Assert
    assertEquals("Yes", actualPDFName.getName());
    assertNull(actualPDFName.getKey());
    assertFalse(actualPDFName.isDirect());
    assertFalse(actualPDFName.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#toString()}
   *   <li>{@link COSName#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSName cosName = COSName.A;

    // Act
    String actualToStringResult = cosName.toString();

    // Assert
    assertEquals("A", cosName.getName());
    assertEquals("COSName{A}", actualToStringResult);
  }

  /**
   * Test {@link COSName#equals(Object)}, and {@link COSName#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#equals(Object)}
   *   <li>{@link COSName#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link COSName#equals(Object)}, and {@link COSName#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#equals(Object)}
   *   <li>{@link COSName#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSName cosName = COSName.A;

    // Act and Assert
    assertEquals(cosName, cosName);
    int expectedHashCodeResult = cosName.hashCode();
    assertEquals(expectedHashCodeResult, cosName.hashCode());
  }

  /**
   * Test {@link COSName#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.AA, COSName.A);
  }

  /**
   * Test {@link COSName#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.A, null);
  }

  /**
   * Test {@link COSName#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.A, "Different type to COSName");
  }

  /**
   * Test {@link COSName#compareTo(COSName)} with {@code COSName}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#compareTo(COSName)}
   */
  @Test
  @DisplayName("Test compareTo(COSName) with 'COSName'; when A; then return zero")
  void testCompareToWithCOSName_whenA_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, COSName.A.compareTo(COSName.A));
  }

  /**
   * Test {@link COSName#isEmpty()}.
   * <p>
   * Method under test: {@link COSName#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(COSName.A.isEmpty());
  }

  /**
   * Test {@link COSName#accept(ICOSVisitor)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromName(COSName)} does
   * nothing.</li>
   *   <li>Then calls {@link COSWriter#visitFromName(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); given A; when COSWriter visitFromName(COSName) does nothing; then calls visitFromName(COSName)")
  void testAccept_givenA_whenCOSWriterVisitFromNameDoesNothing_thenCallsVisitFromName() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromName(Mockito.<COSName>any());

    // Act
    COSName.A.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromName(isA(COSName.class));
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream)")
  void testWritePDF() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.A.writePDF(output);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{'/', 'A'}, output.toByteArray());
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <ul>
   *   <li>Given {@link COSName#ABSOLUTE_COLORIMETRIC}.</li>
   *   <li>Then array length is twenty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); given ABSOLUTE_COLORIMETRIC; then array length is twenty-one")
  void testWritePDF_givenAbsolute_colorimetric_thenArrayLengthIsTwentyOne() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ABSOLUTE_COLORIMETRIC.writePDF(output);

    // Assert that nothing has changed
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(21, toByteArrayResult.length);
    assertEquals('C', toByteArrayResult[9]);
    assertEquals('b', toByteArrayResult[2]);
    assertEquals('c', toByteArrayResult[20]);
    assertEquals('e', toByteArrayResult[8]);
    assertEquals('e', toByteArrayResult[Short.SIZE]);
    assertEquals('i', toByteArrayResult[14]);
    assertEquals('i', toByteArrayResult[19]);
    assertEquals('l', toByteArrayResult[11]);
    assertEquals('l', toByteArrayResult[5]);
    assertEquals('m', toByteArrayResult[15]);
    assertEquals('o', toByteArrayResult[10]);
    assertEquals('o', toByteArrayResult[12]);
    assertEquals('o', toByteArrayResult[4]);
    assertEquals('r', toByteArrayResult[13]);
    assertEquals('r', toByteArrayResult[18]);
    assertEquals('s', toByteArrayResult[3]);
    assertEquals('t', toByteArrayResult[17]);
    assertEquals('t', toByteArrayResult[7]);
    assertEquals('u', toByteArrayResult[6]);
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <ul>
   *   <li>Given {@link COSName#ADBE_PKCS7_DETACHED}.</li>
   *   <li>Then array length is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); given ADBE_PKCS7_DETACHED; then array length is twenty")
  void testWritePDF_givenAdbe_pkcs7_detached_thenArrayLengthIsTwenty() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ADBE_PKCS7_DETACHED.writePDF(output);

    // Assert that nothing has changed
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(20, toByteArrayResult.length);
    assertEquals('.', toByteArrayResult[11]);
    assertEquals('7', toByteArrayResult[10]);
    assertEquals('a', toByteArrayResult[15]);
    assertEquals('c', toByteArrayResult[8]);
    assertEquals('c', toByteArrayResult[Short.SIZE]);
    assertEquals('d', toByteArrayResult[12]);
    assertEquals('d', toByteArrayResult[19]);
    assertEquals('e', toByteArrayResult[13]);
    assertEquals('e', toByteArrayResult[18]);
    assertEquals('h', toByteArrayResult[17]);
    assertEquals('k', toByteArrayResult[7]);
    assertEquals('p', toByteArrayResult[6]);
    assertEquals('s', toByteArrayResult[9]);
    assertEquals('t', toByteArrayResult[14]);
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <ul>
   *   <li>Given {@link COSName#ADBE_X509_RSA_SHA1}.</li>
   *   <li>Then array length is nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); given ADBE_X509_RSA_SHA1; then array length is nineteen")
  void testWritePDF_givenAdbe_x509_rsa_sha1_thenArrayLengthIsNineteen() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ADBE_X509_RSA_SHA1.writePDF(output);

    // Assert that nothing has changed
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(19, toByteArrayResult.length);
    assertEquals('.', toByteArrayResult[10]);
    assertEquals('0', toByteArrayResult[8]);
    assertEquals('1', toByteArrayResult[18]);
    assertEquals('5', toByteArrayResult[7]);
    assertEquals('9', toByteArrayResult[9]);
    assertEquals('_', toByteArrayResult[14]);
    assertEquals('a', toByteArrayResult[13]);
    assertEquals('a', toByteArrayResult[17]);
    assertEquals('h', toByteArrayResult[Short.SIZE]);
    assertEquals('r', toByteArrayResult[11]);
    assertEquals('s', toByteArrayResult[12]);
    assertEquals('s', toByteArrayResult[15]);
    assertEquals('x', toByteArrayResult[6]);
  }
}
