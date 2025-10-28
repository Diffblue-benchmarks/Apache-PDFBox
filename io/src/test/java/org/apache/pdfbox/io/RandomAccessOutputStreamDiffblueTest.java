package org.apache.pdfbox.io;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomAccessOutputStreamDiffblueTest {
  /**
   * Method under test: {@link RandomAccessOutputStream#write(int)}
   */
  @Test
  void testWrite() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer writer = mock(RandomAccessReadWriteBuffer.class);
    doNothing().when(writer).write(anyInt());

    // Act
    (new RandomAccessOutputStream(writer)).write(19088743);

    // Assert that nothing has changed
    verify(writer).write(eq(19088743));
  }

  /**
   * Method under test: {@link RandomAccessOutputStream#write(byte[])}
   */
  @Test
  void testWrite2() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer writer = mock(RandomAccessReadWriteBuffer.class);
    doNothing().when(writer).write(Mockito.<byte[]>any());
    RandomAccessOutputStream randomAccessOutputStream = new RandomAccessOutputStream(writer);

    // Act
    randomAccessOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(writer).write(isA(byte[].class));
  }

  /**
   * Method under test: {@link RandomAccessOutputStream#write(byte[], int, int)}
   */
  @Test
  void testWrite3() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer writer = mock(RandomAccessReadWriteBuffer.class);
    doNothing().when(writer).write(Mockito.<byte[]>any(), anyInt(), anyInt());
    RandomAccessOutputStream randomAccessOutputStream = new RandomAccessOutputStream(writer);

    // Act
    randomAccessOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert that nothing has changed
    verify(writer).write(isA(byte[].class), eq(2), eq(3));
  }
}
