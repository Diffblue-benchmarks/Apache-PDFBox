package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessReadViewDiffblueTest {
  /**
   * Test {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long, long)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long,
   * long)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadView(RandomAccessRead, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.<init>(RandomAccessRead, long, long)"})
  void testNewRandomAccessReadView() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualRandomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);

    // Assert
    assertEquals(0L, actualRandomAccessReadView.getPosition());
    assertEquals(3, actualRandomAccessReadView.available());
    assertFalse(actualRandomAccessReadView.isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long, long, boolean)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#RandomAccessReadView(RandomAccessRead, long,
   * long, boolean)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadView(RandomAccessRead, long, long, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.<init>(RandomAccessRead, long, long, boolean)"})
  void testNewRandomAccessReadView2() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualRandomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L, true);

    // Assert
    assertEquals(0L, actualRandomAccessReadView.getPosition());
    assertEquals(3, actualRandomAccessReadView.available());
    assertFalse(actualRandomAccessReadView.isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#getPosition()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.getPosition()"})
  void testGetPosition_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L).getPosition());
  }

  /**
   * Test {@link RandomAccessReadView#getPosition()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.getPosition()"})
  void testGetPosition_thenReturnZero2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0L,
        new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L)
            .getPosition());
  }

  /**
   * Test {@link RandomAccessReadView#getPosition()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.getPosition()"})
  void testGetPosition_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadView(null, 1L, 3L).getPosition());
  }

  /**
   * Test {@link RandomAccessReadView#getPosition()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.getPosition()"})
  void testGetPosition_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), 1L, 3L).getPosition());
  }

  /**
   * Test {@link RandomAccessReadView#seek(long)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.seek(long)"})
  void testSeek() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);

    // Act
    randomAccessReadView.seek(1L);

    // Assert
    assertEquals(1L, randomAccessReadView.getPosition());
    assertEquals(2, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#seek(long)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.seek(long)"})
  void testSeek2() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), Long.MAX_VALUE, 3L);

    // Act and Assert
    assertThrows(IOException.class, () -> randomAccessReadView.seek(1L));
  }

  /**
   * Test {@link RandomAccessReadView#seek(long)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.seek(long)"})
  void testSeek3() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), Long.MAX_VALUE, 3L);

    // Act and Assert
    assertThrows(IOException.class, () -> randomAccessReadView.seek(1L));
  }

  /**
   * Test {@link RandomAccessReadView#seek(long)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.seek(long)"})
  void testSeek4() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L);

    // Act
    randomAccessReadView.seek(1L);

    // Assert
    assertEquals(1L, randomAccessReadView.getPosition());
    assertEquals(2, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#seek(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); when minus one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.seek(long)"})
  void testSeek_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L).seek(-1L));
  }

  /**
   * Test {@link RandomAccessReadView#seek(long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.seek(long)"})
  void testSeek_whenZero() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadView(null, 1L, 3L).seek(0L));
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read());
    assertEquals(0L, randomAccessReadView.getPosition());
    assertEquals(3, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadView(null, 1L, 3L).read());
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead3() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead =
        RandomAccessReadBuffer.createBufferFromStream(inputStream);
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(randomAccessRead, 1L, 3L);

    // Act
    int actualReadResult = randomAccessReadView.read();

    // Assert
    assertEquals(1L, randomAccessReadView.getPosition());
    assertEquals(2, randomAccessReadView.available());
    assertEquals(3, actualReadResult);
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead4() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, -1L);

    // Act
    int actualReadResult = randomAccessReadView.read();

    // Assert
    assertEquals(-1, randomAccessReadView.available());
    assertEquals(-1, actualReadResult);
    assertEquals(0L, randomAccessReadView.getPosition());
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead5() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(
                    new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), -1L, 3L)
                .read());
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead6() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadView(new RandomAccessReadView(null, 3L, 3L), -1L, 3L).read());
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead7() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 3L, 3L);

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read());
    assertEquals(0L, randomAccessReadView.getPosition());
    assertEquals(3, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead8() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessRead =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), Long.MAX_VALUE, 3L);

    // Act and Assert
    assertThrows(
        IOException.class, () -> new RandomAccessReadView(randomAccessRead, 3L, 3L).read());
  }

  /**
   * Test {@link RandomAccessReadView#read()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read()"})
  void testRead9() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 3L, 3L),
            3L,
            3L);

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read());
    assertEquals(0L, randomAccessReadView.getPosition());
    assertEquals(3, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read(b, 1, 3));
    assertEquals(-1L, randomAccessReadView.getPosition());
    assertEquals(4, randomAccessReadView.available());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(null, 1L, 3L)
                .read(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen3() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead =
        RandomAccessReadBuffer.createBufferFromStream(inputStream);
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(randomAccessRead, 1L, 3L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = randomAccessReadView.read(b, 1, 3);

    // Assert
    assertEquals(0, randomAccessReadView.available());
    assertEquals(3, actualReadResult);
    assertEquals(3L, randomAccessReadView.getPosition());
    assertArrayEquals(new byte[] {'A', 3, 'A', 3, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen4() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, -1L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = randomAccessReadView.read(b, 1, 3);

    // Assert
    assertEquals(-1, randomAccessReadView.available());
    assertEquals(-1, actualReadResult);
    assertEquals(0L, randomAccessReadView.getPosition());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen5() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(
                    new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), -1L, 3L)
                .read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen6() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(new RandomAccessReadView(null, 3L, 3L), -1L, 3L)
                .read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen7() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 3L, 3L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read(b, 1, 3));
    assertEquals(-1L, randomAccessReadView.getPosition());
    assertEquals(4, randomAccessReadView.available());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen8() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessRead =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), Long.MAX_VALUE, 3L);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(randomAccessRead, 3L, 3L)
                .read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link RandomAccessReadView#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <p>Method under test: {@link RandomAccessReadView#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadView.read(byte[], int, int)"})
  void testReadWithBOffLen9() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 3L, 3L),
            3L,
            3L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadView.read(b, 1, 3));
    assertEquals(-1L, randomAccessReadView.getPosition());
    assertEquals(4, randomAccessReadView.available());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadView#length()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#length()}
   */
  @Test
  @DisplayName("Test length(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.length()"})
  void testLength_thenReturnThree() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3L, new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L).length());
  }

  /**
   * Test {@link RandomAccessReadView#length()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#length()}
   */
  @Test
  @DisplayName("Test length(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.length()"})
  void testLength_thenReturnThree2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        3L,
        new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L)
            .length());
  }

  /**
   * Test {@link RandomAccessReadView#length()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#length()}
   */
  @Test
  @DisplayName("Test length(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.length()"})
  void testLength_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadView(null, 1L, 3L).length());
  }

  /**
   * Test {@link RandomAccessReadView#length()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#length()}
   */
  @Test
  @DisplayName("Test length(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadView.length()"})
  void testLength_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), 1L, 3L).length());
  }

  /**
   * Test {@link RandomAccessReadView#close()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.close()"})
  void testClose() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);

    // Act
    randomAccessReadView.close();

    // Assert
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#close()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.close()"})
  void testClose2() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L, true);

    // Act
    randomAccessReadView.close();

    // Assert
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#close()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.close()"})
  void testClose3() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(null, 1L, 3L, true);

    // Act
    randomAccessReadView.close();

    // Assert that nothing has changed
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#close()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.close()"})
  void testClose4() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L, true);

    // Act
    randomAccessReadView.close();

    // Assert
    assertTrue(randomAccessReadView.isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#isClosed()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isClosed()"})
  void testIsClosed_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L).isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#isClosed()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isClosed()"})
  void testIsClosed_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(
        new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L), 1L, 3L)
            .isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#isClosed()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isClosed()"})
  void testIsClosed_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new RandomAccessReadView(null, 1L, 3L).isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#isClosed()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isClosed()"})
  void testIsClosed_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(new RandomAccessReadView(new RandomAccessReadView(null, 1L, 3L), 1L, 3L).isClosed());
  }

  /**
   * Test {@link RandomAccessReadView#rewind(int)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.rewind(int)"})
  void testRewind() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadView(null, 1L, 3L).rewind(1));
  }

  /**
   * Test {@link RandomAccessReadView#rewind(int)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.rewind(int)"})
  void testRewind2() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead =
        RandomAccessReadBuffer.createBufferFromStream(inputStream);
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(randomAccessRead, 1L, 3L);

    // Act
    randomAccessReadView.rewind(1);

    // Assert
    assertEquals(-1L, randomAccessReadView.getPosition());
    assertEquals(4, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#rewind(int)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.rewind(int)"})
  void testRewind3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(
                    new RandomAccessReadView(new RandomAccessReadBuffer(), -1L, 3L), -1L, 3L)
                .rewind(1));
  }

  /**
   * Test {@link RandomAccessReadView#rewind(int)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.rewind(int)"})
  void testRewind4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadView(new RandomAccessReadView(null, -1L, 3L), -1L, 3L).rewind(1));
  }

  /**
   * Test {@link RandomAccessReadView#rewind(int)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.rewind(int)"})
  void testRewind5() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadBuffer(), -1L, 3L), 1L, 3L);

    // Act
    randomAccessReadView.rewind(0);

    // Assert that nothing has changed
    assertEquals(0L, randomAccessReadView.getPosition());
    assertEquals(3, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#rewind(int)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.rewind(int)"})
  void testRewind6() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadView(
                    new RandomAccessReadView(
                        new RandomAccessReadView(new RandomAccessReadBuffer(), -1L, 3L), -1L, 3L),
                    0L,
                    3L)
                .rewind(1));
  }

  /**
   * Test {@link RandomAccessReadView#rewind(int)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadView.rewind(int)"})
  void testRewind7() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadBuffer(), -1L, 3L), 1L, 3L),
            0L,
            3L);

    // Act
    randomAccessReadView.rewind(0);

    // Assert that nothing has changed
    assertEquals(0L, randomAccessReadView.getPosition());
    assertEquals(3, randomAccessReadView.available());
  }

  /**
   * Test {@link RandomAccessReadView#isEOF()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isEOF()"})
  void testIsEOF() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L).isEOF());
  }

  /**
   * Test {@link RandomAccessReadView#isEOF()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isEOF()"})
  void testIsEOF2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadView(null, 1L, 3L).isEOF());
  }

  /**
   * Test {@link RandomAccessReadView#isEOF()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isEOF()"})
  void testIsEOF3() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadBuffer(), 3L, 3L), 1L, 3L)
            .isEOF());
  }

  /**
   * Test {@link RandomAccessReadView#isEOF()}.
   *
   * <p>Method under test: {@link RandomAccessReadView#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isEOF()"})
  void testIsEOF4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadView(new RandomAccessReadView(null, 3L, 3L), 1L, 3L).isEOF());
  }

  /**
   * Test {@link RandomAccessReadView#isEOF()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadView#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomAccessReadView.isEOF()"})
  void testIsEOF_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, -1L).isEOF());
  }

  /**
   * Test {@link RandomAccessReadView#createView(long, long)}.
   *
   * <p>Method under test: {@link RandomAccessReadView#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessReadView RandomAccessReadView.createView(long, long)"})
  void testCreateView() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L).createView(1L, 3L));
  }
}
