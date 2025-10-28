package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RenderingModeDiffblueTest {
  /**
   * Method under test: {@link RenderingMode#fromInt(int)}
   */
  @Test
  void testFromInt() {
    // Arrange, Act and Assert
    assertEquals(RenderingMode.STROKE, RenderingMode.fromInt(1));
  }

  /**
   * Method under test: {@link RenderingMode#intValue()}
   */
  @Test
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, RenderingMode.FILL.intValue());
  }

  /**
   * Method under test: {@link RenderingMode#isClip()}
   */
  @Test
  void testIsClip() {
    // Arrange, Act and Assert
    assertFalse(RenderingMode.FILL.isClip());
    assertTrue(RenderingMode.FILL_CLIP.isClip());
    assertTrue(RenderingMode.STROKE_CLIP.isClip());
    assertTrue(RenderingMode.FILL_STROKE_CLIP.isClip());
    assertTrue(RenderingMode.NEITHER_CLIP.isClip());
  }

  /**
   * Method under test: {@link RenderingMode#isFill()}
   */
  @Test
  void testIsFill() {
    // Arrange, Act and Assert
    assertTrue(RenderingMode.FILL.isFill());
    assertTrue(RenderingMode.FILL_STROKE.isFill());
    assertTrue(RenderingMode.FILL_CLIP.isFill());
    assertTrue(RenderingMode.FILL_STROKE_CLIP.isFill());
    assertFalse(RenderingMode.STROKE.isFill());
  }

  /**
   * Method under test: {@link RenderingMode#isStroke()}
   */
  @Test
  void testIsStroke() {
    // Arrange, Act and Assert
    assertFalse(RenderingMode.FILL.isStroke());
    assertTrue(RenderingMode.STROKE.isStroke());
    assertTrue(RenderingMode.FILL_STROKE.isStroke());
    assertTrue(RenderingMode.STROKE_CLIP.isStroke());
    assertTrue(RenderingMode.FILL_STROKE_CLIP.isStroke());
  }
}
