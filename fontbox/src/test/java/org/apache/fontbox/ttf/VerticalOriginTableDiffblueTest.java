package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class VerticalOriginTableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link VerticalOriginTable}
   *   <li>{@link VerticalOriginTable#getVersion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    VerticalOriginTable actualVerticalOriginTable = new VerticalOriginTable();
    float actualVersion = actualVerticalOriginTable.getVersion();

    // Assert
    assertNull(actualVerticalOriginTable.getTag());
    assertEquals(0.0f, actualVersion);
    assertEquals(0L, actualVerticalOriginTable.getCheckSum());
    assertEquals(0L, actualVerticalOriginTable.getLength());
    assertEquals(0L, actualVerticalOriginTable.getOffset());
    assertFalse(actualVerticalOriginTable.getInitialized());
  }

  /**
   * Method under test:
   * {@link VerticalOriginTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    VerticalOriginTable verticalOriginTable = new VerticalOriginTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    verticalOriginTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(10.0f, verticalOriginTable.getVersion());
    assertTrue(verticalOriginTable.getInitialized());
  }
}
