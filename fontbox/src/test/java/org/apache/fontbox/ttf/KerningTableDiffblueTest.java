package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KerningTableDiffblueTest {
  /**
   * Test {@link KerningTable#KerningTable()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link KerningTable}
   */
  @Test
  @DisplayName("Test new KerningTable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KerningTable.<init>()"})
  void testNewKerningTable() {
    // Arrange and Act
    KerningTable actualKerningTable = new KerningTable();

    // Assert
    assertNull(actualKerningTable.getTag());
    assertEquals(0L, actualKerningTable.getCheckSum());
    assertEquals(0L, actualKerningTable.getLength());
    assertEquals(0L, actualKerningTable.getOffset());
    assertFalse(actualKerningTable.getInitialized());
  }

  /**
   * Test {@link KerningTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>Then {@link KerningTable#KerningTable()} Initialized.
   * </ul>
   *
   * <p>Method under test: {@link KerningTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream); then KerningTable() Initialized")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KerningTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_thenKerningTableInitialized() throws IOException {
    // Arrange
    KerningTable kerningTable = new KerningTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);

    // Act
    kerningTable.read(
        ttf,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertTrue(kerningTable.getInitialized());
  }

  /**
   * Test {@link KerningTable#getHorizontalKerningSubtable()}.
   *
   * <p>Method under test: {@link KerningTable#getHorizontalKerningSubtable()}
   */
  @Test
  @DisplayName("Test getHorizontalKerningSubtable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.KerningSubtable KerningTable.getHorizontalKerningSubtable()"
  })
  void testGetHorizontalKerningSubtable() {
    // Arrange, Act and Assert
    assertNull(new KerningTable().getHorizontalKerningSubtable());
  }

  /**
   * Test {@link KerningTable#getHorizontalKerningSubtable(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link KerningTable#getHorizontalKerningSubtable(boolean)}
   */
  @Test
  @DisplayName("Test getHorizontalKerningSubtable(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.ttf.KerningSubtable KerningTable.getHorizontalKerningSubtable(boolean)"
  })
  void testGetHorizontalKerningSubtableWithBoolean() {
    // Arrange, Act and Assert
    assertNull(new KerningTable().getHorizontalKerningSubtable(true));
  }
}
