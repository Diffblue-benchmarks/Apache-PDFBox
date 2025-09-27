package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VerticalOriginTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link VerticalOriginTable}
   *   <li>{@link VerticalOriginTable#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VerticalOriginTable.<init>()", "float VerticalOriginTable.getVersion()"})
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
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShort()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link VerticalOriginTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); given zero; when RandomAccessReadDataStream readUnsignedShort() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VerticalOriginTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_givenZero_whenRandomAccessReadDataStreamReadUnsignedShortReturnZero()
      throws IOException {
    // Arrange
    VerticalOriginTable verticalOriginTable = new VerticalOriginTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(0);
    when(data.read32Fixed()).thenReturn(10.0f);
    when(data.readSignedShort()).thenReturn((short) 1);

    // Act
    verticalOriginTable.read(ttf, data);

    // Assert
    verify(data).read32Fixed();
    verify(data).readSignedShort();
    verify(data).readUnsignedShort();
    assertEquals(10.0f, verticalOriginTable.getVersion());
    assertTrue(verticalOriginTable.getInitialized());
  }

  /**
   * Test {@link VerticalOriginTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link
   *       RandomAccessReadDataStream#readUnsignedShort()} return one.
   * </ul>
   *
   * <p>Method under test: {@link VerticalOriginTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when RandomAccessReadDataStream readUnsignedShort() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VerticalOriginTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenRandomAccessReadDataStreamReadUnsignedShortReturnOne() throws IOException {
    // Arrange
    VerticalOriginTable verticalOriginTable = new VerticalOriginTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);
    when(data.read32Fixed()).thenReturn(10.0f);
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
