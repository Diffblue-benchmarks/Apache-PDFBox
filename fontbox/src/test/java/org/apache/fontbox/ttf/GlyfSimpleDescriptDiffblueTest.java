package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyfSimpleDescriptDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GlyfSimpleDescript#GlyfSimpleDescript()}
   *   <li>{@link GlyfSimpleDescript#getPointCount()}
   *   <li>{@link GlyfSimpleDescript#isComposite()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>()", "int GlyfSimpleDescript.getPointCount()",
      "boolean GlyfSimpleDescript.isComposite()"})
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
   * Test {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Instructions is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfSimpleDescript#GlyfSimpleDescript(short, TTFDataStream, short)}
   */
  @Test
  @DisplayName("Test new GlyfSimpleDescript(short, TTFDataStream, short); when zero; then return Instructions is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyfSimpleDescript.<init>(short, TTFDataStream, short)"})
  void testNewGlyfSimpleDescript_whenZero_thenReturnInstructionsIsNull() throws IOException {
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
