package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.Test;

class TTCDataStreamDiffblueTest {
  /**
   * Method under test: {@link TTCDataStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .read());
    assertEquals(65, (new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8"))))))
            .read());
  }

  /**
   * Method under test: {@link TTCDataStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadResult = (new TTCDataStream(new RandomAccessReadDataStream(inputStream))).read();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(65, actualReadResult);
  }

  /**
   * Method under test: {@link TTCDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    TTCDataStream ttcDataStream = new TTCDataStream(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ttcDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
  }

  /**
   * Method under test: {@link TTCDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TTCDataStream ttcDataStream = new TTCDataStream(new RandomAccessReadDataStream(inputStream));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ttcDataStream.read(b, 1, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(3, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
  }

  /**
   * Method under test: {@link TTCDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    TTCDataStream ttcDataStream = new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ttcDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('\b', b[2]);
  }

  /**
   * Method under test: {@link TTCDataStream#readLong()}
   */
  @Test
  void testReadLong() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readLong());
    assertEquals(4686066915985604872L, (new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8"))))))
            .readLong());
  }

  /**
   * Method under test: {@link TTCDataStream#readLong()}
   */
  @Test
  void testReadLong2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualReadLongResult = (new TTCDataStream(new RandomAccessReadDataStream(inputStream))).readLong();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(4708585257725083992L, actualReadLongResult);
  }

  /**
   * Method under test: {@link TTCDataStream#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new TTCDataStream(new RandomAccessReadDataStream(inputStream))).seek(1L);

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link TTCDataStream#getCurrentPosition()}
   */
  @Test
  void testGetCurrentPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getCurrentPosition());
    assertEquals(0L,
        (new TTCDataStream(
            new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
                .getCurrentPosition());
  }

  /**
   * Method under test: {@link TTCDataStream#getCurrentPosition()}
   */
  @Test
  void testGetCurrentPosition2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualCurrentPosition = (new TTCDataStream(new RandomAccessReadDataStream(inputStream))).getCurrentPosition();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0L, actualCurrentPosition);
  }

  /**
   * Method under test: {@link TTCDataStream#getOriginalData()}
   */
  @Test
  void testGetOriginalData() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalData()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link TTCDataStream#getOriginalData()}
   */
  @Test
  void testGetOriginalData2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    InputStream actualOriginalData = (new TTCDataStream(new RandomAccessReadDataStream(inputStream))).getOriginalData();

    // Assert
    verify(inputStream).readAllBytes();
    byte[] byteArray = new byte[8];
    assertEquals(8, actualOriginalData.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link TTCDataStream#getOriginalData()}
   */
  @Test
  void testGetOriginalData3() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new TTCDataStream(
            new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
                .getOriginalData()
                .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link TTCDataStream#getOriginalDataSize()}
   */
  @Test
  void testGetOriginalDataSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalDataSize());
    assertEquals(8L,
        (new TTCDataStream(
            new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
                .getOriginalDataSize());
  }

  /**
   * Method under test: {@link TTCDataStream#getOriginalDataSize()}
   */
  @Test
  void testGetOriginalDataSize2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualOriginalDataSize = (new TTCDataStream(new RandomAccessReadDataStream(inputStream)))
        .getOriginalDataSize();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(8L, actualOriginalDataSize);
  }

  /**
   * Method under test: {@link TTCDataStream#createSubView(long)}
   */
  @Test
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new TTCDataStream(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }

  /**
   * Method under test: {@link TTCDataStream#createSubView(long)}
   */
  @Test
  void testCreateSubView2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RandomAccessRead actualCreateSubViewResult = (new TTCDataStream(new RandomAccessReadDataStream(inputStream)))
        .createSubView(3L);

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }

  /**
   * Method under test: {@link TTCDataStream#createSubView(long)}
   */
  @Test
  void testCreateSubView3() throws IOException {
    // Arrange
    new IOException("foo");

    // Act
    RandomAccessRead actualCreateSubViewResult = (new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{'A', GlyfDescript.ON_CURVE,
            'A', GlyfDescript.ON_CURVE, 'A', GlyfDescript.ON_CURVE, 'A', GlyfDescript.ON_CURVE}))))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
