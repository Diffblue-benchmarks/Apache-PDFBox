package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.Test;

class RandomAccessReadUnbufferedDataStreamDiffblueTest {
  /**
   * Method under test:
   * {@link RandomAccessReadUnbufferedDataStream#getCurrentPosition()}
   */
  @Test
  void testGetCurrentPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getCurrentPosition());
  }

  /**
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).read());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream randomAccessReadUnbufferedDataStream = new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, randomAccessReadUnbufferedDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
  }

  /**
   * Method under test:
   * {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream randomAccessReadUnbufferedDataStream = new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{})));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadUnbufferedDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#readLong()}
   */
  @Test
  void testReadLong() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readLong());
  }

  /**
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.length()).thenReturn(3L);
    doNothing().when(randomAccessRead).seek(anyLong());

    // Act
    (new RandomAccessReadUnbufferedDataStream(randomAccessRead)).seek(1L);

    // Assert
    verify(randomAccessRead).length();
    verify(randomAccessRead).seek(eq(1L));
  }

  /**
   * Method under test:
   * {@link RandomAccessReadUnbufferedDataStream#getOriginalData()}
   */
  @Test
  void testGetOriginalData() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessRead = mock(RandomAccessReadBuffer.class);
    when(randomAccessRead.length()).thenReturn(3L);
    when(randomAccessRead.createView(anyLong(), anyLong())).thenReturn(new RandomAccessReadView(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 1L, 3L));

    // Act
    (new RandomAccessReadUnbufferedDataStream(randomAccessRead)).getOriginalData();

    // Assert
    verify(randomAccessRead).createView(eq(0L), eq(3L));
    verify(randomAccessRead).length();
  }

  /**
   * Method under test:
   * {@link RandomAccessReadUnbufferedDataStream#getOriginalDataSize()}
   */
  @Test
  void testGetOriginalDataSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getOriginalDataSize());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadUnbufferedDataStream#createSubView(long)}
   */
  @Test
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
