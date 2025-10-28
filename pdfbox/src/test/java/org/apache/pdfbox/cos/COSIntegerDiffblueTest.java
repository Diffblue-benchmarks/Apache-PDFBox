package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class COSIntegerDiffblueTest {
  /**
   * Method under test: {@link COSInteger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSInteger.OUT_OF_RANGE_MAX, COSInteger.ONE);
  }

  /**
   * Method under test: {@link COSInteger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSInteger.ONE, null);
  }

  /**
   * Method under test: {@link COSInteger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSInteger.ONE, "Different type to COSInteger");
  }

  /**
   * Method under test: {@link COSInteger#get(long)}
   */
  @Test
  void testGet() {
    // Arrange and Act
    COSInteger actualGetResult = COSInteger.get(-101L);

    // Assert
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(actualGetResult.isValid());
  }

  /**
   * Method under test: {@link COSInteger#get(long)}
   */
  @Test
  void testGet2() {
    // Arrange and Act
    COSInteger actualGetResult = COSInteger.get(257L);

    // Assert
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(actualGetResult.isValid());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSInteger#toString()}
   *   <li>{@link COSInteger#isValid()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSInteger getResult = COSInteger.get(42L);

    // Act
    String actualToStringResult = getResult.toString();

    // Assert
    assertEquals("COSInt{42}", actualToStringResult);
    assertTrue(getResult.isValid());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSInteger#equals(Object)}
   *   <li>{@link COSInteger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSInteger cosInteger = COSInteger.ONE;
    COSInteger cosInteger2 = COSInteger.ONE;

    // Act and Assert
    assertEquals(cosInteger, cosInteger2);
    int expectedHashCodeResult = cosInteger.hashCode();
    assertEquals(expectedHashCodeResult, cosInteger2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSInteger#equals(Object)}
   *   <li>{@link COSInteger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSInteger cosInteger = COSInteger.ONE;

    // Act and Assert
    assertEquals(cosInteger, cosInteger);
    int expectedHashCodeResult = cosInteger.hashCode();
    assertEquals(expectedHashCodeResult, cosInteger.hashCode());
  }

  /**
   * Method under test: {@link COSInteger#floatValue()}
   */
  @Test
  void testFloatValue() {
    // Arrange, Act and Assert
    assertEquals(1.0f, COSInteger.ONE.floatValue());
  }

  /**
   * Method under test: {@link COSInteger#intValue()}
   */
  @Test
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(1, COSInteger.ONE.intValue());
  }

  /**
   * Method under test: {@link COSInteger#longValue()}
   */
  @Test
  void testLongValue() {
    // Arrange, Act and Assert
    assertEquals(1L, COSInteger.ONE.longValue());
  }

  /**
   * Method under test: {@link COSInteger#accept(ICOSVisitor)}
   */
  @Test
  void testAccept() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromInt(Mockito.<COSInteger>any());

    // Act
    COSInteger.ONE.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromInt(isA(COSInteger.class));
  }

  /**
   * Method under test: {@link COSInteger#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSInteger.ONE.writePDF(output);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{'1'}, output.toByteArray());
  }
}
