package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class GlyfDescriptDiffblueTest {
  /**
   * Method under test: {@link GlyfDescript#getContourCount()}
   */
  @Test
  void testGetContourCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new GlyfSimpleDescript()).getContourCount());
  }

  /**
   * Method under test: {@link GlyfDescript#getContourCount()}
   */
  @Test
  void testGetContourCount2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualContourCount = (new GlyfSimpleDescript((short) 0, new RandomAccessReadDataStream(inputStream), (short) 1))
        .getContourCount();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualContourCount);
  }

  /**
   * Method under test: {@link GlyfDescript#getInstructions()}
   */
  @Test
  void testGetInstructions() {
    // Arrange, Act and Assert
    assertNull((new GlyfSimpleDescript()).getInstructions());
  }

  /**
   * Method under test: {@link GlyfDescript#readInstructions(TTFDataStream, int)}
   */
  @Test
  void testReadInstructions() throws IOException {
    // Arrange
    GlyfSimpleDescript glyfSimpleDescript = new GlyfSimpleDescript();

    // Act
    glyfSimpleDescript
        .readInstructions(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 3);

    // Assert
    assertArrayEquals(new int[]{65, 88, 65}, glyfSimpleDescript.getInstructions());
  }

  /**
   * Method under test: {@link GlyfDescript#readInstructions(TTFDataStream, int)}
   */
  @Test
  void testReadInstructions2() throws IOException {
    // Arrange
    GlyfSimpleDescript glyfSimpleDescript = new GlyfSimpleDescript();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    glyfSimpleDescript.readInstructions(new RandomAccessReadDataStream(inputStream), 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertArrayEquals(new int[]{65, 88, 65}, glyfSimpleDescript.getInstructions());
  }
}
