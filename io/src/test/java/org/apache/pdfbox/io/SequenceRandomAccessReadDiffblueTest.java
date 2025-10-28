package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SequenceRandomAccessReadDiffblueTest {
  /**
   * Method under test: {@link SequenceRandomAccessRead#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    sequenceRandomAccessRead.close();

    // Assert
    assertTrue(sequenceRandomAccessRead.isClosed());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#close()}
   */
  @Test
  void testClose2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(new RandomAccessReadBuffer());
    randomAccessReadList.add(createBufferFromStreamResult);
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    sequenceRandomAccessRead.close();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertTrue(sequenceRandomAccessRead.isClosed());
  }

  /**
   * Method under test:
   * {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}
   */
  @Test
  void testNewSequenceRandomAccessRead() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SequenceRandomAccessRead(new ArrayList<>()));
    assertThrows(IllegalArgumentException.class, () -> new SequenceRandomAccessRead(null));
  }

  /**
   * Method under test:
   * {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}
   */
  @Test
  void testNewSequenceRandomAccessRead3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(createBufferFromStreamResult);
    randomAccessReadList.add(new RandomAccessReadBuffer());

    // Act
    SequenceRandomAccessRead actualSequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0L, actualSequenceRandomAccessRead.getPosition());
    assertFalse(actualSequenceRandomAccessRead.isClosed());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualSequenceRandomAccessRead.available());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    int actualReadResult = sequenceRandomAccessRead.read();

    // Assert
    assertEquals(1L, sequenceRandomAccessRead.getPosition());
    assertEquals(65, actualReadResult);
    assertEquals(7, sequenceRandomAccessRead.available());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(createBufferFromStreamResult);
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    int actualReadResult = sequenceRandomAccessRead.read();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0, actualReadResult);
    assertEquals(1L, sequenceRandomAccessRead.getPosition());
    assertEquals(4095, sequenceRandomAccessRead.available());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#read()}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act and Assert
    assertEquals(-1, sequenceRandomAccessRead.read());
    assertEquals(0L, sequenceRandomAccessRead.getPosition());
    assertEquals(3, sequenceRandomAccessRead.available());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#read()}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);
    randomAccessReadView.seek(3L);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(randomAccessReadView);
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act and Assert
    assertEquals(-1, sequenceRandomAccessRead.read());
    assertEquals(0L, sequenceRandomAccessRead.getPosition());
    assertEquals(3, sequenceRandomAccessRead.available());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, sequenceRandomAccessRead.read(b, 2, 3));
    assertEquals(3L, sequenceRandomAccessRead.getPosition());
    assertEquals(5, sequenceRandomAccessRead.available());
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('A', b[4]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(createBufferFromStreamResult);
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = sequenceRandomAccessRead.read(b, 2, 3);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals((byte) 0, b[2]);
    assertEquals((byte) 0, b[3]);
    assertEquals((byte) 0, b[4]);
    assertEquals(3, actualReadResult);
    assertEquals(3L, sequenceRandomAccessRead.getPosition());
    assertEquals(4093, sequenceRandomAccessRead.available());
    assertEquals(8, b.length);
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#read(byte[], int, int)}
   */
  @Test
  void testRead7() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, sequenceRandomAccessRead.read(b, 2, 3));
    assertEquals(-1L, sequenceRandomAccessRead.getPosition());
    assertEquals(4, sequenceRandomAccessRead.available());
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('A', b[4]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#getPosition()}
   */
  @Test
  void testGetPosition() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertEquals(0L, (new SequenceRandomAccessRead(randomAccessReadList)).getPosition());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#getPosition()}
   */
  @Test
  void testGetPosition2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(createBufferFromStreamResult);

    // Act
    long actualPosition = (new SequenceRandomAccessRead(randomAccessReadList)).getPosition();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0L, actualPosition);
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    sequenceRandomAccessRead.seek(1L);

    // Assert
    assertEquals(1L, sequenceRandomAccessRead.getPosition());
    assertEquals(7, sequenceRandomAccessRead.available());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  void testSeek2() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    sequenceRandomAccessRead.seek(8L);

    // Assert
    assertEquals(0, sequenceRandomAccessRead.available());
    assertEquals(8L, sequenceRandomAccessRead.getPosition());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  void testSeek3() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> (new SequenceRandomAccessRead(randomAccessReadList)).seek(-1L));
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  void testSeek4() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);
    sequenceRandomAccessRead.read("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Act
    sequenceRandomAccessRead.seek(1L);

    // Assert
    assertEquals(1L, sequenceRandomAccessRead.getPosition());
    assertEquals(7, sequenceRandomAccessRead.available());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#length()}
   */
  @Test
  void testLength() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertEquals(8L, (new SequenceRandomAccessRead(randomAccessReadList)).length());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#length()}
   */
  @Test
  void testLength2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(createBufferFromStreamResult);

    // Act
    long actualLengthResult = (new SequenceRandomAccessRead(randomAccessReadList)).length();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(4096L, actualLengthResult);
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#isEOF()}
   */
  @Test
  void testIsEOF() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertFalse((new SequenceRandomAccessRead(randomAccessReadList)).isEOF());
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#isEOF()}
   */
  @Test
  void testIsEOF2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(createBufferFromStreamResult);

    // Act
    boolean actualIsEOFResult = (new SequenceRandomAccessRead(randomAccessReadList)).isEOF();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertFalse(actualIsEOFResult);
  }

  /**
   * Method under test: {@link SequenceRandomAccessRead#createView(long, long)}
   */
  @Test
  void testCreateView() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new SequenceRandomAccessRead(randomAccessReadList)).createView(1L, 3L));
  }

  /**
   * Method under test:
   * {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}
   */
  @Test
  void testNewSequenceRandomAccessRead2() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    SequenceRandomAccessRead actualSequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Assert
    assertEquals(0L, actualSequenceRandomAccessRead.getPosition());
    assertEquals(8, actualSequenceRandomAccessRead.available());
    assertFalse(actualSequenceRandomAccessRead.isClosed());
  }
}
