package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

class COSBooleanDiffblueTest {
  /**
   * Method under test: {@link COSBoolean#getValueAsObject()}
   */
  @Test
  void testGetValueAsObject() {
    // Arrange, Act and Assert
    assertFalse(COSBoolean.FALSE.getValueAsObject());
    assertTrue(COSBoolean.TRUE.getValueAsObject());
  }

  /**
   * Method under test: {@link COSBoolean#accept(ICOSVisitor)}
   */
  @Test
  void testAccept() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromBoolean(Mockito.<COSBoolean>any());

    // Act
    COSBoolean.FALSE.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromBoolean(isA(COSBoolean.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSBoolean#equals(Object)}
   *   <li>{@link COSBoolean#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSBoolean cosBoolean = COSBoolean.FALSE;
    COSBoolean cosBoolean2 = COSBoolean.FALSE;

    // Act and Assert
    assertEquals(cosBoolean, cosBoolean2);
    int expectedHashCodeResult = cosBoolean.hashCode();
    assertEquals(expectedHashCodeResult, cosBoolean2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSBoolean#equals(Object)}
   *   <li>{@link COSBoolean#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act and Assert
    assertEquals(cosBoolean, cosBoolean);
    int expectedHashCodeResult = cosBoolean.hashCode();
    assertEquals(expectedHashCodeResult, cosBoolean.hashCode());
  }

  /**
   * Method under test: {@link COSBoolean#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSBoolean.FALSE.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "false".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSBoolean#writePDF(OutputStream)}
   */
  @Test
  void testWritePDF2() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSBoolean.TRUE.writePDF(output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "true".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSBoolean#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSBoolean.TRUE, COSBoolean.FALSE);
  }

  /**
   * Method under test: {@link COSBoolean#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSBoolean.FALSE, null);
  }

  /**
   * Method under test: {@link COSBoolean#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSBoolean.FALSE, "Different type to COSBoolean");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSBoolean#toString()}
   *   <li>{@link COSBoolean#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSBoolean resultBoolean = COSBoolean.getBoolean(true);

    // Act
    String actualToStringResult = resultBoolean.toString();

    // Assert
    assertTrue(resultBoolean.getValue());
    assertEquals(Boolean.TRUE.toString(), actualToStringResult);
  }
}
