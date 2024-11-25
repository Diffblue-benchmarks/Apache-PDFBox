package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSStandardOutputStreamDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   *   <li>Then return Pos is zero.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSStandardOutputStream#COSStandardOutputStream(OutputStream)}
   *   <li>{@link COSStandardOutputStream#setOnNewLine(boolean)}
   *   <li>{@link COSStandardOutputStream#getPos()}
   *   <li>{@link COSStandardOutputStream#isOnNewLine()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ByteArrayOutputStream(int) with one; then return Pos is zero")
  void testGettersAndSetters_whenByteArrayOutputStreamWithOne_thenReturnPosIsZero() {
    // Arrange and Act
    COSStandardOutputStream actualCosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1));
    actualCosStandardOutputStream.setOnNewLine(true);
    long actualPos = actualCosStandardOutputStream.getPos();

    // Assert that nothing has changed
    assertEquals(0L, actualPos);
    assertTrue(actualCosStandardOutputStream.isOnNewLine());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Pos is one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link COSStandardOutputStream#COSStandardOutputStream(OutputStream, long)}
   *   <li>{@link COSStandardOutputStream#setOnNewLine(boolean)}
   *   <li>{@link COSStandardOutputStream#getPos()}
   *   <li>{@link COSStandardOutputStream#isOnNewLine()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return Pos is one")
  void testGettersAndSetters_whenOne_thenReturnPosIsOne() {
    // Arrange and Act
    COSStandardOutputStream actualCosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1),
        1L);
    actualCosStandardOutputStream.setOnNewLine(true);
    long actualPos = actualCosStandardOutputStream.getPos();

    // Assert that nothing has changed
    assertEquals(1L, actualPos);
    assertTrue(actualCosStandardOutputStream.isOnNewLine());
  }

  /**
   * Test {@link COSStandardOutputStream#write(int)} with {@code b}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#write(int)}
   */
  @Test
  @DisplayName("Test write(int) with 'b'")
  void testWriteWithB() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.write(19088743);

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }

  /**
   * Test {@link COSStandardOutputStream#write(int)} with {@code b}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#write(int)}
   */
  @Test
  @DisplayName("Test write(int) with 'b'")
  void testWriteWithB2() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(
        new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L), 1L);

    // Act
    cosStandardOutputStream.write(19088743);

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }

  /**
   * Test {@link COSStandardOutputStream#write(byte[], int, int)} with {@code b},
   * {@code off}, {@code len}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'b', 'off', 'len'")
  void testWriteWithBOffLen() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(4L, cosStandardOutputStream.getPos());
  }

  /**
   * Test {@link COSStandardOutputStream#writeCRLF()}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#writeCRLF()}
   */
  @Test
  @DisplayName("Test writeCRLF()")
  void testWriteCRLF() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.writeCRLF();

    // Assert
    assertEquals(3L, cosStandardOutputStream.getPos());
  }

  /**
   * Test {@link COSStandardOutputStream#writeEOL()}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#writeEOL()}
   */
  @Test
  @DisplayName("Test writeEOL()")
  void testWriteEOL() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.writeEOL();

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
    assertTrue(cosStandardOutputStream.isOnNewLine());
  }

  /**
   * Test {@link COSStandardOutputStream#writeEOL()}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#writeEOL()}
   */
  @Test
  @DisplayName("Test writeEOL()")
  void testWriteEOL2() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);
    cosStandardOutputStream.setOnNewLine(true);

    // Act
    cosStandardOutputStream.writeEOL();

    // Assert that nothing has changed
    assertEquals(1L, cosStandardOutputStream.getPos());
    assertTrue(cosStandardOutputStream.isOnNewLine());
  }

  /**
   * Test {@link COSStandardOutputStream#writeEOL()}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#writeEOL()}
   */
  @Test
  @DisplayName("Test writeEOL()")
  void testWriteEOL3() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(
        new COSStandardOutputStream(new ByteArrayOutputStream(3), 3L), 1L);

    // Act
    cosStandardOutputStream.writeEOL();

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
    assertTrue(cosStandardOutputStream.isOnNewLine());
  }

  /**
   * Test {@link COSStandardOutputStream#writeLF()}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#writeLF()}
   */
  @Test
  @DisplayName("Test writeLF()")
  void testWriteLF() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.writeLF();

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }

  /**
   * Test {@link COSStandardOutputStream#writeLF()}.
   * <p>
   * Method under test: {@link COSStandardOutputStream#writeLF()}
   */
  @Test
  @DisplayName("Test writeLF()")
  void testWriteLF2() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(
        new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L), 1L);

    // Act
    cosStandardOutputStream.writeLF();

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }
}
