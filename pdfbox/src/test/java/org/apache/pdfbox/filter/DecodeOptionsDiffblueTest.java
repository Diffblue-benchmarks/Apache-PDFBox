package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DecodeOptionsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DecodeOptions#DecodeOptions()}
   *   <li>{@link DecodeOptions#setFilterSubsampled(boolean)}
   *   <li>{@link DecodeOptions#setSourceRegion(Rectangle)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetY(int)}
   *   <li>{@link DecodeOptions#setSubsamplingX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingY(int)}
   *   <li>{@link DecodeOptions#getSourceRegion()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetX()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetY()}
   *   <li>{@link DecodeOptions#getSubsamplingX()}
   *   <li>{@link DecodeOptions#getSubsamplingY()}
   *   <li>{@link DecodeOptions#isFilterSubsampled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecodeOptions.<init>()",
    "void DecodeOptions.<init>(int)",
    "void DecodeOptions.<init>(Rectangle)",
    "Rectangle DecodeOptions.getSourceRegion()",
    "int DecodeOptions.getSubsamplingOffsetX()",
    "int DecodeOptions.getSubsamplingOffsetY()",
    "int DecodeOptions.getSubsamplingX()",
    "int DecodeOptions.getSubsamplingY()",
    "boolean DecodeOptions.isFilterSubsampled()",
    "void DecodeOptions.setFilterSubsampled(boolean)",
    "void DecodeOptions.setSourceRegion(Rectangle)",
    "void DecodeOptions.setSubsamplingOffsetX(int)",
    "void DecodeOptions.setSubsamplingOffsetY(int)",
    "void DecodeOptions.setSubsamplingX(int)",
    "void DecodeOptions.setSubsamplingY(int)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions();
    actualDecodeOptions.setFilterSubsampled(true);
    Rectangle sourceRegion = new Rectangle();
    actualDecodeOptions.setSourceRegion(sourceRegion);
    actualDecodeOptions.setSubsamplingOffsetX(1);
    actualDecodeOptions.setSubsamplingOffsetY(1);
    actualDecodeOptions.setSubsamplingX(1);
    actualDecodeOptions.setSubsamplingY(1);
    Rectangle actualSourceRegion = actualDecodeOptions.getSourceRegion();
    int actualSubsamplingOffsetX = actualDecodeOptions.getSubsamplingOffsetX();
    int actualSubsamplingOffsetY = actualDecodeOptions.getSubsamplingOffsetY();
    int actualSubsamplingX = actualDecodeOptions.getSubsamplingX();
    int actualSubsamplingY = actualDecodeOptions.getSubsamplingY();

    // Assert
    assertEquals(1, actualSubsamplingOffsetX);
    assertEquals(1, actualSubsamplingOffsetY);
    assertEquals(1, actualSubsamplingX);
    assertEquals(1, actualSubsamplingY);
    assertTrue(actualDecodeOptions.isFilterSubsampled());
    assertSame(sourceRegion, actualSourceRegion);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DecodeOptions#DecodeOptions(int)}
   *   <li>{@link DecodeOptions#setFilterSubsampled(boolean)}
   *   <li>{@link DecodeOptions#setSourceRegion(Rectangle)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetY(int)}
   *   <li>{@link DecodeOptions#setSubsamplingX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingY(int)}
   *   <li>{@link DecodeOptions#getSourceRegion()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetX()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetY()}
   *   <li>{@link DecodeOptions#getSubsamplingX()}
   *   <li>{@link DecodeOptions#getSubsamplingY()}
   *   <li>{@link DecodeOptions#isFilterSubsampled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecodeOptions.<init>()",
    "void DecodeOptions.<init>(int)",
    "void DecodeOptions.<init>(Rectangle)",
    "Rectangle DecodeOptions.getSourceRegion()",
    "int DecodeOptions.getSubsamplingOffsetX()",
    "int DecodeOptions.getSubsamplingOffsetY()",
    "int DecodeOptions.getSubsamplingX()",
    "int DecodeOptions.getSubsamplingY()",
    "boolean DecodeOptions.isFilterSubsampled()",
    "void DecodeOptions.setFilterSubsampled(boolean)",
    "void DecodeOptions.setSourceRegion(Rectangle)",
    "void DecodeOptions.setSubsamplingOffsetX(int)",
    "void DecodeOptions.setSubsamplingOffsetY(int)",
    "void DecodeOptions.setSubsamplingX(int)",
    "void DecodeOptions.setSubsamplingY(int)"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions(1);
    actualDecodeOptions.setFilterSubsampled(true);
    Rectangle sourceRegion = new Rectangle();
    actualDecodeOptions.setSourceRegion(sourceRegion);
    actualDecodeOptions.setSubsamplingOffsetX(1);
    actualDecodeOptions.setSubsamplingOffsetY(1);
    actualDecodeOptions.setSubsamplingX(1);
    actualDecodeOptions.setSubsamplingY(1);
    Rectangle actualSourceRegion = actualDecodeOptions.getSourceRegion();
    int actualSubsamplingOffsetX = actualDecodeOptions.getSubsamplingOffsetX();
    int actualSubsamplingOffsetY = actualDecodeOptions.getSubsamplingOffsetY();
    int actualSubsamplingX = actualDecodeOptions.getSubsamplingX();
    int actualSubsamplingY = actualDecodeOptions.getSubsamplingY();

    // Assert
    assertEquals(1, actualSubsamplingOffsetX);
    assertEquals(1, actualSubsamplingOffsetY);
    assertEquals(1, actualSubsamplingX);
    assertEquals(1, actualSubsamplingY);
    assertTrue(actualDecodeOptions.isFilterSubsampled());
    assertSame(sourceRegion, actualSourceRegion);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Rectangle#Rectangle()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DecodeOptions#DecodeOptions(Rectangle)}
   *   <li>{@link DecodeOptions#setFilterSubsampled(boolean)}
   *   <li>{@link DecodeOptions#setSourceRegion(Rectangle)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetY(int)}
   *   <li>{@link DecodeOptions#setSubsamplingX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingY(int)}
   *   <li>{@link DecodeOptions#getSourceRegion()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetX()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetY()}
   *   <li>{@link DecodeOptions#getSubsamplingX()}
   *   <li>{@link DecodeOptions#getSubsamplingY()}
   *   <li>{@link DecodeOptions#isFilterSubsampled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Rectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecodeOptions.<init>()",
    "void DecodeOptions.<init>(int)",
    "void DecodeOptions.<init>(Rectangle)",
    "Rectangle DecodeOptions.getSourceRegion()",
    "int DecodeOptions.getSubsamplingOffsetX()",
    "int DecodeOptions.getSubsamplingOffsetY()",
    "int DecodeOptions.getSubsamplingX()",
    "int DecodeOptions.getSubsamplingY()",
    "boolean DecodeOptions.isFilterSubsampled()",
    "void DecodeOptions.setFilterSubsampled(boolean)",
    "void DecodeOptions.setSourceRegion(Rectangle)",
    "void DecodeOptions.setSubsamplingOffsetX(int)",
    "void DecodeOptions.setSubsamplingOffsetY(int)",
    "void DecodeOptions.setSubsamplingX(int)",
    "void DecodeOptions.setSubsamplingY(int)"
  })
  void testGettersAndSetters_whenRectangle() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions(new Rectangle());
    actualDecodeOptions.setFilterSubsampled(true);
    Rectangle sourceRegion = new Rectangle();
    actualDecodeOptions.setSourceRegion(sourceRegion);
    actualDecodeOptions.setSubsamplingOffsetX(1);
    actualDecodeOptions.setSubsamplingOffsetY(1);
    actualDecodeOptions.setSubsamplingX(1);
    actualDecodeOptions.setSubsamplingY(1);
    Rectangle actualSourceRegion = actualDecodeOptions.getSourceRegion();
    int actualSubsamplingOffsetX = actualDecodeOptions.getSubsamplingOffsetX();
    int actualSubsamplingOffsetY = actualDecodeOptions.getSubsamplingOffsetY();
    int actualSubsamplingX = actualDecodeOptions.getSubsamplingX();
    int actualSubsamplingY = actualDecodeOptions.getSubsamplingY();

    // Assert
    assertEquals(1, actualSubsamplingOffsetX);
    assertEquals(1, actualSubsamplingOffsetY);
    assertEquals(1, actualSubsamplingX);
    assertEquals(1, actualSubsamplingY);
    assertTrue(actualDecodeOptions.isFilterSubsampled());
    assertSame(sourceRegion, actualSourceRegion);
  }

  /**
   * Test {@link DecodeOptions#DecodeOptions(int, int, int, int)}.
   *
   * <p>Method under test: {@link DecodeOptions#DecodeOptions(int, int, int, int)}
   */
  @Test
  @DisplayName("Test new DecodeOptions(int, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DecodeOptions.<init>(int, int, int, int)"})
  void testNewDecodeOptions() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions(2, 3, 1, 1);

    // Assert
    assertEquals(0, actualDecodeOptions.getSubsamplingOffsetX());
    assertEquals(0, actualDecodeOptions.getSubsamplingOffsetY());
    assertEquals(1, actualDecodeOptions.getSubsamplingX());
    assertEquals(1, actualDecodeOptions.getSubsamplingY());
    assertFalse(actualDecodeOptions.isFilterSubsampled());
  }
}
