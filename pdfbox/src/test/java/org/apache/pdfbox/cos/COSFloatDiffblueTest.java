package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

class COSFloatDiffblueTest {
  /**
   * Method under test: {@link COSFloat#floatValue()}
   */
  @Test
  void testFloatValue() {
    // Arrange, Act and Assert
    assertEquals(1.0f, COSFloat.ONE.floatValue());
  }

  /**
   * Method under test: {@link COSFloat#longValue()}
   */
  @Test
  void testLongValue() {
    // Arrange, Act and Assert
    assertEquals(1L, COSFloat.ONE.longValue());
  }

  /**
   * Method under test: {@link COSFloat#intValue()}
   */
  @Test
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(1, COSFloat.ONE.intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSFloat#equals(Object)}
   *   <li>{@link COSFloat#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSFloat cosFloat = COSFloat.ONE;
    COSFloat cosFloat2 = COSFloat.ONE;

    // Act and Assert
    assertEquals(cosFloat, cosFloat2);
    int expectedHashCodeResult = cosFloat.hashCode();
    assertEquals(expectedHashCodeResult, cosFloat2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSFloat#equals(Object)}
   *   <li>{@link COSFloat#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSFloat cosFloat = COSFloat.ONE;

    // Act and Assert
    assertEquals(cosFloat, cosFloat);
    int expectedHashCodeResult = cosFloat.hashCode();
    assertEquals(expectedHashCodeResult, cosFloat.hashCode());
  }

  /**
   * Method under test: {@link COSFloat#accept(ICOSVisitor)}
   */
  @Test
  void testAccept() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromFloat(Mockito.<COSFloat>any());

    // Act
    COSFloat.ONE.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromFloat(isA(COSFloat.class));
  }

  /**
   * Method under test: {@link COSFloat#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSFloat.ONE.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "1.0".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSFloat#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF2() throws IOException {
    // Arrange
    COSFloat cosFloat = new COSFloat(10.0f);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    cosFloat.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "10.0".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSFloat#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF3() throws IOException {
    // Arrange
    COSFloat cosFloat = new COSFloat(-3.4028235E38f);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    cosFloat.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "-340282350000000000000000000000000000000".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSFloat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSFloat.ZERO, COSFloat.ONE);
  }

  /**
   * Method under test: {@link COSFloat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSFloat.ONE, null);
  }

  /**
   * Method under test: {@link COSFloat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSFloat.ONE, "Different type to COSFloat");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSFloat#COSFloat(float)}
   *   <li>{@link COSFloat#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat(10.0f);

    // Assert
    assertEquals("COSFloat{10.0}", actualCosFloat.toString());
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new COSFloat("A Float"));
    assertThrows(IOException.class, () -> new COSFloat("--"));
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat2() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0-9");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat3() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("-9.-9");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat4() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("42");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat5() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat6() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0-942");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat7() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("-9.-942");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  void testNewCOSFloat8() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0-94242");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }
}
