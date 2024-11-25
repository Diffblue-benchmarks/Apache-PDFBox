package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TTFTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TTFTable}
   *   <li>{@link TTFTable#setCheckSum(long)}
   *   <li>{@link TTFTable#setLength(long)}
   *   <li>{@link TTFTable#setOffset(long)}
   *   <li>{@link TTFTable#setTag(String)}
   *   <li>{@link TTFTable#read(TrueTypeFont, TTFDataStream)}
   *   <li>{@link TTFTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}
   *   <li>{@link TTFTable#getCheckSum()}
   *   <li>{@link TTFTable#getInitialized()}
   *   <li>{@link TTFTable#getLength()}
   *   <li>{@link TTFTable#getOffset()}
   *   <li>{@link TTFTable#getTag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange and Act
    TTFTable actualTtfTable = new TTFTable();
    actualTtfTable.setCheckSum(42L);
    actualTtfTable.setLength(3L);
    actualTtfTable.setOffset(42L);
    actualTtfTable.setTag("42");
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    actualTtfTable.read(ttf, new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    TrueTypeFont ttf2 = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");
    outHeaders.setHeaderMacStyle(1);
    outHeaders.setIsOTFAndPostScript(true);
    outHeaders.setName("Name");
    outHeaders.setNonOtfGcid142("AXAXAXAX".getBytes("UTF-8"));
    outHeaders.setOs2Windows(new OS2WindowsMetricsTable());
    actualTtfTable.readHeaders(ttf2, data, outHeaders);
    long actualCheckSum = actualTtfTable.getCheckSum();
    boolean actualInitialized = actualTtfTable.getInitialized();
    long actualLength = actualTtfTable.getLength();
    long actualOffset = actualTtfTable.getOffset();

    // Assert that nothing has changed
    assertEquals("42", actualTtfTable.getTag());
    assertEquals(3L, actualLength);
    assertEquals(42L, actualCheckSum);
    assertEquals(42L, actualOffset);
    assertFalse(actualInitialized);
  }
}
