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

class MaximumProfileTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MaximumProfileTable}
   *   <li>{@link MaximumProfileTable#setMaxComponentDepth(int)}
   *   <li>{@link MaximumProfileTable#setMaxComponentElements(int)}
   *   <li>{@link MaximumProfileTable#setMaxCompositeContours(int)}
   *   <li>{@link MaximumProfileTable#setMaxCompositePoints(int)}
   *   <li>{@link MaximumProfileTable#setMaxContours(int)}
   *   <li>{@link MaximumProfileTable#setMaxFunctionDefs(int)}
   *   <li>{@link MaximumProfileTable#setMaxInstructionDefs(int)}
   *   <li>{@link MaximumProfileTable#setMaxPoints(int)}
   *   <li>{@link MaximumProfileTable#setMaxSizeOfInstructions(int)}
   *   <li>{@link MaximumProfileTable#setMaxStackElements(int)}
   *   <li>{@link MaximumProfileTable#setMaxStorage(int)}
   *   <li>{@link MaximumProfileTable#setMaxTwilightPoints(int)}
   *   <li>{@link MaximumProfileTable#setMaxZones(int)}
   *   <li>{@link MaximumProfileTable#setNumGlyphs(int)}
   *   <li>{@link MaximumProfileTable#setVersion(float)}
   *   <li>{@link MaximumProfileTable#getMaxComponentDepth()}
   *   <li>{@link MaximumProfileTable#getMaxComponentElements()}
   *   <li>{@link MaximumProfileTable#getMaxCompositeContours()}
   *   <li>{@link MaximumProfileTable#getMaxCompositePoints()}
   *   <li>{@link MaximumProfileTable#getMaxContours()}
   *   <li>{@link MaximumProfileTable#getMaxFunctionDefs()}
   *   <li>{@link MaximumProfileTable#getMaxInstructionDefs()}
   *   <li>{@link MaximumProfileTable#getMaxPoints()}
   *   <li>{@link MaximumProfileTable#getMaxSizeOfInstructions()}
   *   <li>{@link MaximumProfileTable#getMaxStackElements()}
   *   <li>{@link MaximumProfileTable#getMaxStorage()}
   *   <li>{@link MaximumProfileTable#getMaxTwilightPoints()}
   *   <li>{@link MaximumProfileTable#getMaxZones()}
   *   <li>{@link MaximumProfileTable#getNumGlyphs()}
   *   <li>{@link MaximumProfileTable#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MaximumProfileTable.<init>()",
    "int MaximumProfileTable.getMaxComponentDepth()",
    "int MaximumProfileTable.getMaxComponentElements()",
    "int MaximumProfileTable.getMaxCompositeContours()",
    "int MaximumProfileTable.getMaxCompositePoints()",
    "int MaximumProfileTable.getMaxContours()",
    "int MaximumProfileTable.getMaxFunctionDefs()",
    "int MaximumProfileTable.getMaxInstructionDefs()",
    "int MaximumProfileTable.getMaxPoints()",
    "int MaximumProfileTable.getMaxSizeOfInstructions()",
    "int MaximumProfileTable.getMaxStackElements()",
    "int MaximumProfileTable.getMaxStorage()",
    "int MaximumProfileTable.getMaxTwilightPoints()",
    "int MaximumProfileTable.getMaxZones()",
    "int MaximumProfileTable.getNumGlyphs()",
    "float MaximumProfileTable.getVersion()",
    "void MaximumProfileTable.setMaxComponentDepth(int)",
    "void MaximumProfileTable.setMaxComponentElements(int)",
    "void MaximumProfileTable.setMaxCompositeContours(int)",
    "void MaximumProfileTable.setMaxCompositePoints(int)",
    "void MaximumProfileTable.setMaxContours(int)",
    "void MaximumProfileTable.setMaxFunctionDefs(int)",
    "void MaximumProfileTable.setMaxInstructionDefs(int)",
    "void MaximumProfileTable.setMaxPoints(int)",
    "void MaximumProfileTable.setMaxSizeOfInstructions(int)",
    "void MaximumProfileTable.setMaxStackElements(int)",
    "void MaximumProfileTable.setMaxStorage(int)",
    "void MaximumProfileTable.setMaxTwilightPoints(int)",
    "void MaximumProfileTable.setMaxZones(int)",
    "void MaximumProfileTable.setNumGlyphs(int)",
    "void MaximumProfileTable.setVersion(float)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MaximumProfileTable actualMaximumProfileTable = new MaximumProfileTable();
    actualMaximumProfileTable.setMaxComponentDepth(2);
    actualMaximumProfileTable.setMaxComponentElements(3);
    actualMaximumProfileTable.setMaxCompositeContours(3);
    actualMaximumProfileTable.setMaxCompositePoints(3);
    actualMaximumProfileTable.setMaxContours(3);
    actualMaximumProfileTable.setMaxFunctionDefs(3);
    actualMaximumProfileTable.setMaxInstructionDefs(3);
    actualMaximumProfileTable.setMaxPoints(3);
    actualMaximumProfileTable.setMaxSizeOfInstructions(3);
    actualMaximumProfileTable.setMaxStackElements(3);
    actualMaximumProfileTable.setMaxStorage(3);
    actualMaximumProfileTable.setMaxTwilightPoints(3);
    actualMaximumProfileTable.setMaxZones(3);
    actualMaximumProfileTable.setNumGlyphs(CmapTable.ENCODING_WIN_UNICODE_FULL);
    actualMaximumProfileTable.setVersion(10.0f);
    int actualMaxComponentDepth = actualMaximumProfileTable.getMaxComponentDepth();
    int actualMaxComponentElements = actualMaximumProfileTable.getMaxComponentElements();
    int actualMaxCompositeContours = actualMaximumProfileTable.getMaxCompositeContours();
    int actualMaxCompositePoints = actualMaximumProfileTable.getMaxCompositePoints();
    int actualMaxContours = actualMaximumProfileTable.getMaxContours();
    int actualMaxFunctionDefs = actualMaximumProfileTable.getMaxFunctionDefs();
    int actualMaxInstructionDefs = actualMaximumProfileTable.getMaxInstructionDefs();
    int actualMaxPoints = actualMaximumProfileTable.getMaxPoints();
    int actualMaxSizeOfInstructions = actualMaximumProfileTable.getMaxSizeOfInstructions();
    int actualMaxStackElements = actualMaximumProfileTable.getMaxStackElements();
    int actualMaxStorage = actualMaximumProfileTable.getMaxStorage();
    int actualMaxTwilightPoints = actualMaximumProfileTable.getMaxTwilightPoints();
    int actualMaxZones = actualMaximumProfileTable.getMaxZones();
    int actualNumGlyphs = actualMaximumProfileTable.getNumGlyphs();
    float actualVersion = actualMaximumProfileTable.getVersion();

    // Assert
    assertNull(actualMaximumProfileTable.getTag());
    assertEquals(0L, actualMaximumProfileTable.getCheckSum());
    assertEquals(0L, actualMaximumProfileTable.getLength());
    assertEquals(0L, actualMaximumProfileTable.getOffset());
    assertEquals(10.0f, actualVersion);
    assertEquals(2, actualMaxComponentDepth);
    assertEquals(3, actualMaxComponentElements);
    assertEquals(3, actualMaxCompositeContours);
    assertEquals(3, actualMaxCompositePoints);
    assertEquals(3, actualMaxContours);
    assertEquals(3, actualMaxFunctionDefs);
    assertEquals(3, actualMaxInstructionDefs);
    assertEquals(3, actualMaxPoints);
    assertEquals(3, actualMaxSizeOfInstructions);
    assertEquals(3, actualMaxStackElements);
    assertEquals(3, actualMaxStorage);
    assertEquals(3, actualMaxTwilightPoints);
    assertEquals(3, actualMaxZones);
    assertFalse(actualMaximumProfileTable.getInitialized());
    assertEquals(CmapTable.ENCODING_WIN_UNICODE_FULL, actualNumGlyphs);
  }

  /**
   * Test {@link MaximumProfileTable#read(TrueTypeFont, TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then {@link MaximumProfileTable#MaximumProfileTable()} Version is {@code -167.74475}.
   * </ul>
   *
   * <p>Method under test: {@link MaximumProfileTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test read(TrueTypeFont, TTFDataStream); when 'A'; then MaximumProfileTable() Version is '-167.74475'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaximumProfileTable.read(TrueTypeFont, TTFDataStream)"})
  void testRead_whenA_thenMaximumProfileTableVersionIs16774475() throws IOException {
    // Arrange
    MaximumProfileTable maximumProfileTable = new MaximumProfileTable();
    RandomAccessReadDataStream fontData =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TrueTypeFont ttf = new TrueTypeFont(fontData);
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    maximumProfileTable.read(ttf, new RandomAccessReadDataStream(inputStream));

    // Assert
    assertEquals(-167.74475f, maximumProfileTable.getVersion());
    assertEquals(16728, maximumProfileTable.getNumGlyphs());
    assertTrue(maximumProfileTable.getInitialized());
  }
}
