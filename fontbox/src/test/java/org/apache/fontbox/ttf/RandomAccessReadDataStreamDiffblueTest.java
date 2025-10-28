package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

class RandomAccessReadDataStreamDiffblueTest {
  /**
   * Method under test: {@link RandomAccessReadDataStream#getCurrentPosition()}
   */
  @Test
  void testGetCurrentPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).getCurrentPosition());
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#getCurrentPosition()}
   */
  @Test
  void testGetCurrentPosition2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualCurrentPosition = (new RandomAccessReadDataStream(inputStream)).getCurrentPosition();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0L, actualCurrentPosition);
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read());
    assertEquals(-1, (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).read());
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadResult = (new RandomAccessReadDataStream(inputStream)).read();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(65, actualReadResult);
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, randomAccessReadDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream(new byte[]{}));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(inputStream);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = randomAccessReadDataStream.read(b, 1, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(3, actualReadResult);
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#readLong()}
   */
  @Test
  void testReadLong() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readLong());
    assertEquals(-72340168543109377L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readLong());
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#readLong()}
   */
  @Test
  void testReadLong2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualReadLongResult = (new RandomAccessReadDataStream(inputStream)).readLong();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(4708585257725083992L, actualReadLongResult);
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).seek(-1L));
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#seek(long)}
   */
  @Test
  void testSeek2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new RandomAccessReadDataStream(inputStream)).seek(1L);

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#createSubView(long)}
   */
  @Test
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#createSubView(long)}
   */
  @Test
  void testCreateSubView2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RandomAccessRead actualCreateSubViewResult = (new RandomAccessReadDataStream(inputStream)).createSubView(3L);

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#getOriginalData()}
   */
  @Test
  void testGetOriginalData() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).getOriginalData()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link RandomAccessReadDataStream#getOriginalData()}
   */
  @Test
  void testGetOriginalData2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    InputStream actualOriginalData = (new RandomAccessReadDataStream(inputStream)).getOriginalData();

    // Assert
    verify(inputStream).readAllBytes();
    byte[] byteArray = new byte[8];
    assertEquals(8, actualOriginalData.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RandomAccessReadDataStream#close()}
   *   <li>{@link RandomAccessReadDataStream#getOriginalDataSize()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    randomAccessReadDataStream.close();

    // Assert that nothing has changed
    assertEquals(8L, randomAccessReadDataStream.getOriginalDataSize());
  }
}
