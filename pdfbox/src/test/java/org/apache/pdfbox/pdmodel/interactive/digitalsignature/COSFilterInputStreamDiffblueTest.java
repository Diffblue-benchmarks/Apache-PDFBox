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
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSFilterInputStreamDiffblueTest {
  /**
   * Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(88,
        (new COSFilterInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), new int[]{1, -1, 1, -1}))
            .read());
    assertThrows(IOException.class,
        () -> (new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}), new int[]{1, -1, 1, -1})).read());
    assertEquals(-1, (new COSFilterInputStream(mock(DataInputStream.class), new int[]{})).read());
  }

  /**
   * Method under test: {@link COSFilterInputStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenReturn(1);
    when(in.skip(anyLong())).thenReturn(1L);

    // Act
    int actualReadResult = (new COSFilterInputStream(in, new int[]{1, -1, 1, -1})).read();

    // Assert
    verify(in).read();
    verify(in).skip(eq(1L));
    assertEquals(1, actualReadResult);
  }

  /**
   * Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}),
        new int[]{1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  void testRead4() throws IOException {
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
   * Method under test: {@link COSFilterInputStream#read(byte[])}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(mock(DataInputStream.class), new int[]{});

    // Act and Assert
    assertEquals(-1, cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}),
        new int[]{1, -1, 1, -1});

    // Act and Assert
    assertThrows(IOException.class, () -> cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead7() throws IOException {
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
   * Method under test: {@link COSFilterInputStream#read(byte[], int, int)}
   */
  @Test
  void testRead8() throws IOException {
    // Arrange
    COSFilterInputStream cosFilterInputStream = new COSFilterInputStream(mock(DataInputStream.class), new int[]{});

    // Act and Assert
    assertEquals(-1, cosFilterInputStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link COSFilterInputStream#toByteArray()}
   */
  @Test
  void testToByteArray() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new COSFilterInputStream(new ByteArrayInputStream(new byte[]{}), new int[]{1, -1, 1, -1}))
            .toByteArray());
  }

  /**
   * Method under test: {@link COSFilterInputStream#toByteArray()}
   */
  @Test
  void testToByteArray2() throws IOException {
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
}
