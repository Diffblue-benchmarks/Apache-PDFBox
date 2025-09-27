package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IndexToLocationTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexToLocationTable}
   *   <li>{@link IndexToLocationTable#setOffsets(long[])}
   *   <li>{@link IndexToLocationTable#getOffsets()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IndexToLocationTable.<init>()",
    "long[] IndexToLocationTable.getOffsets()",
    "void IndexToLocationTable.setOffsets(long[])"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    IndexToLocationTable actualIndexToLocationTable = new IndexToLocationTable();
    long[] offsetsValue = new long[] {42L, 1L, 42L, 1L};
    actualIndexToLocationTable.setOffsets(offsetsValue);
    long[] actualOffsets = actualIndexToLocationTable.getOffsets();

    // Assert
    assertNull(actualIndexToLocationTable.getTag());
    assertEquals(0L, actualIndexToLocationTable.getCheckSum());
    assertEquals(0L, actualIndexToLocationTable.getLength());
    assertEquals(0L, actualIndexToLocationTable.getOffset());
    assertFalse(actualIndexToLocationTable.getInitialized());
    assertSame(offsetsValue, actualOffsets);
    assertArrayEquals(new long[] {42L, 1L, 42L, 1L}, actualOffsets);
  }

  /**
   * Test {@link IndexToLocationTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link IndexToLocationTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexToLocationTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenThrowIOException() throws IOException {
    // Arrange
    IndexToLocationTable indexToLocationTable = new IndexToLocationTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            indexToLocationTable.read(
                ttf,
                new RandomAccessReadDataStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }
}
