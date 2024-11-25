package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSFilterInputStreamDiffblueTest {
  /**
   * Test {@link COSFilterInputStream#read(byte[], int, int)} with {@code b},
   * {@code off}, {@code len}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#skip(long)} return
   * one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; given DataInputStream skip(long) return one; then return one")
  void testReadWithBOffLen_givenDataInputStreamSkipReturnOne_thenReturnOne() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    when(in.skip(anyLong())).thenReturn(1L);
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(in, new int[]{1, -1, 1, -1});

    // Act
    int actualReadResult = cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    verify(in).read(isA(byte[].class), eq(1), eq(-1));
    verify(in).skip(eq(1L));
    assertEquals(1, actualReadResult);
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[], int, int)} with {@code b},
   * {@code off}, {@code len}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return minus one")
  void testReadWithBOffLen_thenReturnMinusOne() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(mock(DataInputStream.class), new int[]{});

    // Act and Assert
    assertEquals(-1, cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[], int, int)} with {@code b},
   * {@code off}, {@code len}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then throw IOException")
  void testReadWithBOffLen_thenThrowIOException() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}),
        new int[]{1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[])} with {@code b}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'b'; given ByteArrayInputStream(byte[]) with empty array of byte; then throw IOException")
  void testReadWithB_givenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}),
        new int[]{1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[])} with {@code b}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#skip(long)} return
   * one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'b'; given DataInputStream skip(long) return one; then return one")
  void testReadWithB_givenDataInputStreamSkipReturnOne_thenReturnOne() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    when(in.skip(anyLong())).thenReturn(1L);
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(in, new int[]{1, -1, 1, -1});

    // Act
    int actualReadResult = cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(in).read(isA(byte[].class), eq(0), eq(-1));
    verify(in).skip(eq(1L));
    assertEquals(1, actualReadResult);
  }

  /**
   * Test {@link COSFilterInputStream#read(byte[])} with {@code b}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'b'; then return minus one")
  void testReadWithB_thenReturnMinusOne() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(mock(DataInputStream.class), new int[]{});

    // Act and Assert
    assertEquals(-1, cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return eighty-eight")
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnEightyEight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(88,
        (new COSFilterInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), new int[]{1, -1, 1, -1}))
            .read());
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with empty array of byte; then throw IOException")
  void testRead_givenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}), new int[]{1, -1, 1, -1})).read());
  }

  /**
   * Test {@link COSFilterInputStream#read()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return minus one")
  void testRead_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSFilterInputStream(mock(DataInputStream.class), new int[]{})).read());
  }

  /**
   * Test {@link COSFilterInputStream#toByteArray()}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#toByteArray()}
   */
  @Test
  @DisplayName("Test toByteArray(); then return array of byte with zero and zero")
  void testToByteArray_thenReturnArrayOfByteWithZeroAndZero() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    when(in.skip(anyLong())).thenReturn(1L);

    // Act
    byte[] actualToByteArrayResult = (new COSFilterInputStream(in, new int[]{1, -1, 1, -1})).toByteArray();

    // Assert
    verify(in, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(in).skip(eq(1L));
    assertArrayEquals(new byte[]{0, 0}, actualToByteArrayResult);
  }

  /**
   * Test {@link COSFilterInputStream#toByteArray()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFilterInputStream#toByteArray()}
   */
  @Test
  @DisplayName("Test toByteArray(); then throw IOException")
  void testToByteArray_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}), new int[]{1, -1, 1, -1}))
            .toByteArray());
  }
}
