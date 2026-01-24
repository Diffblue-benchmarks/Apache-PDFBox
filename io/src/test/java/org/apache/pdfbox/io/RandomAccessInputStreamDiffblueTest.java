package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessInputStreamDiffblueTest {
  /**
   * Test {@link RandomAccessInputStream#RandomAccessInputStream(RandomAccessRead)}.
   *
   * <p>Method under test: {@link RandomAccessInputStream#RandomAccessInputStream(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new RandomAccessInputStream(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessInputStream.<init>(RandomAccessRead)"})
  void testNewRandomAccessInputStream() throws IOException {
    // Arrange, Act and Assert
    int actualReadResult =
        new RandomAccessInputStream(new RandomAccessReadBuffer()).read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link RandomAccessInputStream#available()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessInputStream#available()}
   */
  @Test
  @DisplayName("Test available(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessInputStream.available()"})
  void testAvailable_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, new RandomAccessInputStream(new RandomAccessReadBuffer()).available());
  }

  /**
   * Test {@link RandomAccessInputStream#read()}.
   *
   * <p>Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessInputStream.read()"})
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, new RandomAccessInputStream(new RandomAccessReadBuffer()).read());
  }

  /**
   * Test {@link RandomAccessInputStream#read()}.
   *
   * <p>Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessInputStream.read()"})
  void testRead2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        new RandomAccessInputStream(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L))
            .read());
  }

  /**
   * Test {@link RandomAccessInputStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given 'A'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessInputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenA_whenAxaxaxaxBytesIsUtf8_thenReturnThree() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead =
        RandomAccessReadBuffer.createBufferFromStream(inputStream);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, new RandomAccessInputStream(randomAccessRead).read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 'A', 1, 'A', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link RandomAccessInputStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then array of {@code byte} with one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then array of byte with one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessInputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenArrayOfByteWithOneAndX() throws IOException {
    // Arrange
    byte[] b = new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        -1,
        new RandomAccessInputStream(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L))
            .read(b, 1, 3));
    assertArrayEquals(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link RandomAccessInputStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessInputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, new RandomAccessInputStream(new RandomAccessReadBuffer()).read(b, 1, 3));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given 'A'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessInputStream.read()"})
  void testRead_givenA_thenReturnSixtyFive() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead =
        RandomAccessReadBuffer.createBufferFromStream(inputStream);

    // Act and Assert
    assertEquals(65, new RandomAccessInputStream(randomAccessRead).read());
  }

  /**
   * Test {@link RandomAccessInputStream#skip(long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessInputStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessInputStream.skip(long)"})
  void testSkip_thenReturnOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1L, new RandomAccessInputStream(new RandomAccessReadBuffer()).skip(1L));
  }

  /**
   * Test {@link RandomAccessInputStream#skip(long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessInputStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessInputStream.skip(long)"})
  void testSkip_whenZero_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, new RandomAccessInputStream(new RandomAccessReadBuffer()).skip(0L));
  }
}
