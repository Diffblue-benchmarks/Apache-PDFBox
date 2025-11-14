package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyfDescriptDiffblueTest {
  /**
   * Test {@link GlyfDescript#getContourCount()}.
   *
   * <p>Method under test: {@link GlyfDescript#getContourCount()}
   */
  @Test
  @DisplayName("Test getContourCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfDescript.getContourCount()"})
  void testGetContourCount() {
    // Arrange, Act and Assert
    assertEquals(0, new GlyfSimpleDescript().getContourCount());
  }

  /**
   * Test {@link GlyfDescript#getInstructions()}.
   *
   * <p>Method under test: {@link GlyfDescript#getInstructions()}
   */
  @Test
  @DisplayName("Test getInstructions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] GlyfDescript.getInstructions()"})
  void testGetInstructions() {
    // Arrange, Act and Assert
    assertNull(new GlyfSimpleDescript().getInstructions());
  }

  /**
   * Test {@link GlyfDescript#readInstructions(TTFDataStream, int)}.
   *
   * <p>Method under test: {@link GlyfDescript#readInstructions(TTFDataStream, int)}
   */
  @Test
  @DisplayName("Test readInstructions(TTFDataStream, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfDescript.readInstructions(TTFDataStream, int)"})
  void testReadInstructions() throws IOException {
    // Arrange
    GlyfSimpleDescript glyfSimpleDescript = new GlyfSimpleDescript();

    // Act
    glyfSimpleDescript.readInstructions(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 3);

    // Assert
    assertArrayEquals(new int[] {65, 88, 65}, glyfSimpleDescript.getInstructions());
  }
}
