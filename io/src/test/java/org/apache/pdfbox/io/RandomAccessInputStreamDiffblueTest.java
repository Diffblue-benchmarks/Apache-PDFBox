package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomAccessInputStreamDiffblueTest {
  /**
   * Test
   * {@link RandomAccessInputStream#RandomAccessInputStream(RandomAccessRead)}.
   * <p>
   * Method under test:
   * {@link RandomAccessInputStream#RandomAccessInputStream(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new RandomAccessInputStream(RandomAccessRead)")
  void testNewRandomAccessInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessInputStream(new RandomAccessReadBuffer())).read(new byte[]{}));
  }

  /**
   * Test {@link RandomAccessInputStream#available()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessInputStream#available()}
   */
  @Test
  @DisplayName("Test available(); then return zero")
  void testAvailable_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new RandomAccessInputStream(new RandomAccessReadBuffer())).available());
  }

  /**
   * Test {@link RandomAccessInputStream#read()}.
   * <p>
   * Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  void testRead() throws IOException {
    // Arrange
    RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(new RandomAccessReadBuffer());

    // Act
    int actualReadResult = randomAccessInputStream.read();

    // Assert
    assertEquals(-1, randomAccessInputStream.read(new byte[]{}));
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link RandomAccessInputStream#read()}.
   * <p>
   * Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  void testRead2() throws IOException {
    // Arrange
    RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(
        new RandomAccessReadBufferedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    int actualReadResult = randomAccessInputStream.read();

    // Assert
    assertEquals(-1, randomAccessInputStream.read(new byte[]{}));
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link RandomAccessInputStream#read(byte[], int, int)} with
   * {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link RandomAccessInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  void testReadWithByteIntInt() throws IOException {
    // Arrange
    RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(new RandomAccessReadBuffer());
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = randomAccessInputStream.read(b, 1, 3);

    // Assert
    assertEquals(-1, randomAccessInputStream.read(new byte[]{}));
    assertEquals(-1, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Test {@link RandomAccessInputStream#read(byte[], int, int)} with
   * {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link RandomAccessInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  void testReadWithByteIntInt2() throws IOException {
    // Arrange
    RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(
        new RandomAccessReadBufferedFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    byte[] b = new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    int actualReadResult = randomAccessInputStream.read(b, 1, 3);

    // Assert
    assertEquals(-1, randomAccessInputStream.read(new byte[]{}));
    assertEquals(-1, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Test {@link RandomAccessInputStream#read(byte[], int, int)} with
   * {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Then array length is fifty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then array length is fifty-one")
  void testReadWithByteIntInt_thenArrayLengthIsFiftyOne() throws IOException {
    // Arrange
    byte[] b = new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1,
        (new RandomAccessInputStream(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L))).read(b, 1, 3));
    assertEquals(51, (new byte[51]).length);
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Test {@link RandomAccessInputStream#read()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given 'A'; then return sixty-five")
  void testRead_givenA_thenReturnSixtyFive() throws IOException {
    // Arrange
    RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})));

    // Act and Assert
    assertEquals(65, randomAccessInputStream.read());
    byte[] byteArray = new byte[7];
    assertEquals(7, randomAccessInputStream.read(byteArray));
    assertArrayEquals(new byte[]{1, 'A', 1, 'A', 1, 'A', 1}, byteArray);
  }

  /**
   * Test {@link RandomAccessInputStream#read()}.
   * <ul>
   *   <li>Then array length is fifty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then array length is fifty-one")
  void testRead_thenArrayLengthIsFiftyOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new RandomAccessInputStream(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L))).read());
    assertEquals(51, (new byte[51]).length);
  }

  /**
   * Test {@link RandomAccessInputStream#skip(long)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessInputStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); then return one")
  void testSkip_thenReturnOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1L, (new RandomAccessInputStream(new RandomAccessReadBuffer())).skip(1L));
  }

  /**
   * Test {@link RandomAccessInputStream#skip(long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessInputStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); when zero; then return zero")
  void testSkip_whenZero_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessInputStream(new RandomAccessReadBuffer())).skip(0L));
  }
}
