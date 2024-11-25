package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VerticalOriginTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link VerticalOriginTable}
   *   <li>{@link VerticalOriginTable#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test {@link VerticalOriginTable#read(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Then {@link VerticalOriginTable#VerticalOriginTable()} Version is
   * ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link VerticalOriginTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then VerticalOriginTable() Version is ten")
  void testRead_thenVerticalOriginTableVersionIsTen() throws IOException {
    // Arrange
    VerticalOriginTable verticalOriginTable = new VerticalOriginTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    verticalOriginTable.read(ttf, data);

    // Assert
    verify(data).read32Fixed();
    verify(data, atLeast(1)).readSignedShort();
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(10.0f, verticalOriginTable.getVersion());
    assertTrue(verticalOriginTable.getInitialized());
  }
}
