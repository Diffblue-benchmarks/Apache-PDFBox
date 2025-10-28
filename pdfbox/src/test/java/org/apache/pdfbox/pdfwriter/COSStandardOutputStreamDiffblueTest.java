package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;

class COSStandardOutputStreamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSStandardOutputStream#COSStandardOutputStream(OutputStream)}
   *   <li>{@link COSStandardOutputStream#setOnNewLine(boolean)}
   *   <li>{@link COSStandardOutputStream#getPos()}
   *   <li>{@link COSStandardOutputStream#isOnNewLine()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    COSStandardOutputStream actualCosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1));
    actualCosStandardOutputStream.setOnNewLine(true);
    long actualPos = actualCosStandardOutputStream.getPos();

    // Assert that nothing has changed
    assertEquals(0L, actualPos);
    assertTrue(actualCosStandardOutputStream.isOnNewLine());
  }

  /**
   * Method under test: {@link COSStandardOutputStream#write(int)}
   */
  @Test
  void testWrite() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.write(19088743);

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }

  /**
   * Method under test: {@link COSStandardOutputStream#write(int)}
   */
  @Test
  void testWrite2() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(
        new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L), 1L);

    // Act
    cosStandardOutputStream.write(19088743);

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }

  /**
   * Method under test: {@link COSStandardOutputStream#write(byte[], int, int)}
   */
  @Test
  void testWrite3() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(4L, cosStandardOutputStream.getPos());
  }

  /**
   * Method under test: {@link COSStandardOutputStream#writeCRLF()}
   */
  @Test
  void testWriteCRLF() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.writeCRLF();

    // Assert
    assertEquals(3L, cosStandardOutputStream.getPos());
  }

  /**
   * Method under test: {@link COSStandardOutputStream#writeEOL()}
   */
  @Test
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
   * Method under test: {@link COSStandardOutputStream#writeEOL()}
   */
  @Test
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
   * Method under test: {@link COSStandardOutputStream#writeEOL()}
   */
  @Test
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
   * Method under test: {@link COSStandardOutputStream#writeLF()}
   */
  @Test
  void testWriteLF() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L);

    // Act
    cosStandardOutputStream.writeLF();

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }

  /**
   * Method under test: {@link COSStandardOutputStream#writeLF()}
   */
  @Test
  void testWriteLF2() throws IOException {
    // Arrange
    COSStandardOutputStream cosStandardOutputStream = new COSStandardOutputStream(
        new COSStandardOutputStream(new ByteArrayOutputStream(1), 1L), 1L);

    // Act
    cosStandardOutputStream.writeLF();

    // Assert
    assertEquals(2L, cosStandardOutputStream.getPos());
  }

  /**
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
  void testGettersAndSetters2() {
    // Arrange and Act
    COSStandardOutputStream actualCosStandardOutputStream = new COSStandardOutputStream(new ByteArrayOutputStream(1),
        1L);
    actualCosStandardOutputStream.setOnNewLine(true);
    long actualPos = actualCosStandardOutputStream.getPos();

    // Assert that nothing has changed
    assertEquals(1L, actualPos);
    assertTrue(actualCosStandardOutputStream.isOnNewLine());
  }
}
