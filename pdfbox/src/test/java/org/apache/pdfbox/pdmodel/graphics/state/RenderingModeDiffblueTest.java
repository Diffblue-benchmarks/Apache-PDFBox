package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RenderingModeDiffblueTest {
  /**
   * Test {@link RenderingMode#fromInt(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code STROKE}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#fromInt(int)}
   */
  @Test
  @DisplayName("Test fromInt(int); when one; then return 'STROKE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderingMode RenderingMode.fromInt(int)"})
  void testFromInt_whenOne_thenReturnStroke() {
    // Arrange, Act and Assert
    assertEquals(RenderingMode.STROKE, RenderingMode.fromInt(1));
  }

  /**
   * Test {@link RenderingMode#intValue()}.
   *
   * <p>Method under test: {@link RenderingMode#intValue()}
   */
  @Test
  @DisplayName("Test intValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RenderingMode.intValue()"})
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, RenderingMode.FILL.intValue());
  }

  /**
   * Test {@link RenderingMode#isFill()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#FILL_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isFill()}
   */
  @Test
  @DisplayName("Test isFill(); given FILL_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isFill()"})
  void testIsFill_givenFill_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL_CLIP.isFill());
  }

  /**
   * Test {@link RenderingMode#isFill()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#FILL_STROKE_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isFill()}
   */
  @Test
  @DisplayName("Test isFill(); given FILL_STROKE_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isFill()"})
  void testIsFill_givenFill_stroke_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL_STROKE_CLIP.isFill());
  }

  /**
   * Test {@link RenderingMode#isFill()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#FILL_STROKE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isFill()}
   */
  @Test
  @DisplayName("Test isFill(); given FILL_STROKE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isFill()"})
  void testIsFill_givenFill_stroke_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL_STROKE.isFill());
  }

  /**
   * Test {@link RenderingMode#isFill()}.
   *
   * <ul>
   *   <li>Given {@code FILL}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isFill()}
   */
  @Test
  @DisplayName("Test isFill(); given 'FILL'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isFill()"})
  void testIsFill_givenFill_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL.isFill());
  }

  /**
   * Test {@link RenderingMode#isFill()}.
   *
   * <ul>
   *   <li>Given {@code STROKE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isFill()}
   */
  @Test
  @DisplayName("Test isFill(); given 'STROKE'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isFill()"})
  void testIsFill_givenStroke_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RenderingMode.STROKE.isFill());
  }

  /**
   * Test {@link RenderingMode#isStroke()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#FILL_STROKE_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isStroke()}
   */
  @Test
  @DisplayName("Test isStroke(); given FILL_STROKE_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isStroke()"})
  void testIsStroke_givenFill_stroke_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL_STROKE_CLIP.isStroke());
  }

  /**
   * Test {@link RenderingMode#isStroke()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#FILL_STROKE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isStroke()}
   */
  @Test
  @DisplayName("Test isStroke(); given FILL_STROKE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isStroke()"})
  void testIsStroke_givenFill_stroke_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL_STROKE.isStroke());
  }

  /**
   * Test {@link RenderingMode#isStroke()}.
   *
   * <ul>
   *   <li>Given {@code FILL}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isStroke()}
   */
  @Test
  @DisplayName("Test isStroke(); given 'FILL'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isStroke()"})
  void testIsStroke_givenFill_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RenderingMode.FILL.isStroke());
  }

  /**
   * Test {@link RenderingMode#isStroke()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#STROKE_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isStroke()}
   */
  @Test
  @DisplayName("Test isStroke(); given STROKE_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isStroke()"})
  void testIsStroke_givenStroke_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.STROKE_CLIP.isStroke());
  }

  /**
   * Test {@link RenderingMode#isStroke()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#STROKE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isStroke()}
   */
  @Test
  @DisplayName("Test isStroke(); given STROKE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isStroke()"})
  void testIsStroke_givenStroke_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.STROKE.isStroke());
  }

  /**
   * Test {@link RenderingMode#isClip()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#FILL_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isClip()}
   */
  @Test
  @DisplayName("Test isClip(); given FILL_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isClip()"})
  void testIsClip_givenFill_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL_CLIP.isClip());
  }

  /**
   * Test {@link RenderingMode#isClip()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#FILL_STROKE_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isClip()}
   */
  @Test
  @DisplayName("Test isClip(); given FILL_STROKE_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isClip()"})
  void testIsClip_givenFill_stroke_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL_STROKE_CLIP.isClip());
  }

  /**
   * Test {@link RenderingMode#isClip()}.
   *
   * <ul>
   *   <li>Given {@code FILL}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isClip()}
   */
  @Test
  @DisplayName("Test isClip(); given 'FILL'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isClip()"})
  void testIsClip_givenFill_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RenderingMode.FILL.isClip());
  }

  /**
   * Test {@link RenderingMode#isClip()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#NEITHER_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isClip()}
   */
  @Test
  @DisplayName("Test isClip(); given NEITHER_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isClip()"})
  void testIsClip_givenNeither_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.NEITHER_CLIP.isClip());
  }

  /**
   * Test {@link RenderingMode#isClip()}.
   *
   * <ul>
   *   <li>Given {@link RenderingMode#STROKE_CLIP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderingMode#isClip()}
   */
  @Test
  @DisplayName("Test isClip(); given STROKE_CLIP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderingMode.isClip()"})
  void testIsClip_givenStroke_clip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.STROKE_CLIP.isClip());
  }
}
