package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSFilterInputStreamDiffblueTest {
  /**
   * Test {@link COSFilterInputStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; given 'A'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[], int, int)"})
  void testReadWithBOffLen_givenA_thenReturnZero() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1}, new int[] {-1, 1, -1, 1});

    // Act and Assert
    assertEquals(0, cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'b', 'off', 'len'; given ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[], int, int)"})
  void testReadWithBOffLen_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream(new byte[] {});
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(in, new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(
        IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#skip(long)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#skip(long)}.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'b', 'off', 'len'; given DataInputStream skip(long) throw IOException(); then calls skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[], int, int)"})
  void testReadWithBOffLen_givenDataInputStreamSkipThrowIOException_thenCallsSkip()
      throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.skip(anyLong())).thenThrow(new IOException());
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(in, new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(
        IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    verify(in).skip(1L);
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenReturnMinusOne() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(mock(DataInputStream.class), new int[] {});

    // Act and Assert
    assertEquals(-1, cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[])} with {@code b}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'b'; given 'A'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[])"})
  void testReadWithB_givenA_thenReturnZero() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1}, new int[] {-1, 1, -1, 1});

    // Act
    int actualReadResult = cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, actualReadResult);
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[])} with {@code b}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of
   *       {@code byte}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  @DisplayName(
      "Test read(byte[]) with 'b'; given ByteArrayInputStream(byte[]) with empty array of byte; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[])"})
  void testReadWithB_givenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException()
      throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream(new byte[] {});
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(in, new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[])} with {@code b}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#skip(long)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#skip(long)}.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  @DisplayName(
      "Test read(byte[]) with 'b'; given DataInputStream skip(long) throw IOException(); then calls skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[])"})
  void testReadWithB_givenDataInputStreamSkipThrowIOException_thenCallsSkip() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.skip(anyLong())).thenThrow(new IOException());
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(in, new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8")));
    verify(in).skip(1L);
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[])} with {@code b}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'b'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read(byte[])"})
  void testReadWithB_thenReturnMinusOne() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(mock(DataInputStream.class), new int[] {});

    // Act
    int actualReadResult = cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return eighty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnEightyEight()
      throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), new int[] {1, -1, 1, -1});

    // Act and Assert
    assertEquals(88, cosFilterInputStream.read());
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of
   *       {@code byte}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with empty array of byte; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read()"})
  void testRead_givenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException()
      throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream(new byte[] {});
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(in, new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read());
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read()}.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given DataInputStream read() throw IOException(); then calls read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read()"})
  void testRead_givenDataInputStreamReadThrowIOException_thenCallsRead() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenThrow(new IOException());
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(in, new int[] {-1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read());
    verify(in).read();
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#skip(long)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#skip(long)}.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given DataInputStream skip(long) throw IOException(); then calls skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read()"})
  void testRead_givenDataInputStreamSkipThrowIOException_thenCallsSkip() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.skip(anyLong())).thenThrow(new IOException());
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(in, new int[] {1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read());
    verify(in).skip(1L);
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSFilterInputStream.read()"})
  void testRead_thenReturnMinusOne() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream =
        new COSFilterInputStream(mock(DataInputStream.class), new int[] {});

    // Act and Assert
    assertEquals(-1, cosFilterInputStream.read());
  }
}
