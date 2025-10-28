package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class GlyfSimpleDescriptDiffblueTest {
  /**
   * Method under test: {@link GlyfSimpleDescript#getEndPtOfContours(int)}
   */
  @Test
  void testGetEndPtOfContours() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(1);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});

    // Act
    int actualEndPtOfContours = (new GlyfSimpleDescript((short) 1, bais, (short) 1)).getEndPtOfContours(1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(eq(1));
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(eq(1));
    assertEquals(-1, actualEndPtOfContours);
  }

  /**
   * Method under test: {@link GlyfSimpleDescript#getFlags(int)}
   */
  @Test
  void testGetFlags() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(1);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});

    // Act
    byte actualFlags = (new GlyfSimpleDescript((short) 1, bais, (short) 1)).getFlags(1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(eq(1));
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(eq(1));
    assertEquals(GlyfDescript.ON_CURVE, actualFlags);
  }

  /**
   * Method under test: {@link GlyfSimpleDescript#getXCoordinate(int)}
   */
  @Test
  void testGetXCoordinate() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(1);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});

    // Act
    short actualXCoordinate = (new GlyfSimpleDescript((short) 1, bais, (short) 1)).getXCoordinate(1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(eq(1));
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(eq(1));
    assertEquals((short) 3, actualXCoordinate);
  }

  /**
   * Method under test: {@link GlyfSimpleDescript#getYCoordinate(int)}
   */
  @Test
  void testGetYCoordinate() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = mock(RandomAccessReadDataStream.class);
    when(bais.readUnsignedByte()).thenReturn(1);
    when(bais.readUnsignedShort()).thenReturn(1);
    when(bais.readUnsignedByteArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});
    when(bais.readSignedShort()).thenReturn((short) 1);
    when(bais.readUnsignedShortArray(anyInt())).thenReturn(new int[]{1, -1, 1, -1});

    // Act
    short actualYCoordinate = (new GlyfSimpleDescript((short) 1, bais, (short) 1)).getYCoordinate(1);

    // Assert
    verify(bais, atLeast(1)).readSignedShort();
    verify(bais, atLeast(1)).readUnsignedByte();
    verify(bais).readUnsignedByteArray(eq(1));
    verify(bais).readUnsignedShort();
    verify(bais).readUnsignedShortArray(eq(1));
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, actualYCoordinate);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GlyfSimpleDescript#GlyfSimpleDescript()}
   *   <li>{@link GlyfSimpleDescript#getPointCount()}
   *   <li>{@link GlyfSimpleDescript#isComposite()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GlyfSimpleDescript actualGlyfSimpleDescript = new GlyfSimpleDescript();
    int actualPointCount = actualGlyfSimpleDescript.getPointCount();
    boolean actualIsCompositeResult = actualGlyfSimpleDescript.isComposite();

    // Assert
    assertNull(actualGlyfSimpleDescript.getInstructions());
    assertEquals(0, actualGlyfSimpleDescript.getContourCount());
    assertEquals(0, actualPointCount);
    assertFalse(actualIsCompositeResult);
  }

  /**
   * Method under test:
   * {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}
   */
  @Test
  void testNewGlyfSimpleDescript() throws IOException {
    // Arrange and Act
    GlyfSimpleDescript actualGlyfSimpleDescript = new GlyfSimpleDescript((short) 0,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), (short) 1);

    // Assert
    assertNull(actualGlyfSimpleDescript.getInstructions());
    assertEquals(0, actualGlyfSimpleDescript.getContourCount());
    assertEquals(0, actualGlyfSimpleDescript.getPointCount());
    assertFalse(actualGlyfSimpleDescript.isComposite());
  }
}
