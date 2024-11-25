package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDTextStateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDTextState#setCharacterSpacing(float)}
   *   <li>{@link PDTextState#setFont(PDFont)}
   *   <li>{@link PDTextState#setFontSize(float)}
   *   <li>{@link PDTextState#setHorizontalScaling(float)}
   *   <li>{@link PDTextState#setKnockoutFlag(boolean)}
   *   <li>{@link PDTextState#setLeading(float)}
   *   <li>{@link PDTextState#setRenderingMode(RenderingMode)}
   *   <li>{@link PDTextState#setRise(float)}
   *   <li>{@link PDTextState#setWordSpacing(float)}
   *   <li>{@link PDTextState#getCharacterSpacing()}
   *   <li>{@link PDTextState#getFont()}
   *   <li>{@link PDTextState#getFontSize()}
   *   <li>{@link PDTextState#getHorizontalScaling()}
   *   <li>{@link PDTextState#getKnockoutFlag()}
   *   <li>{@link PDTextState#getLeading()}
   *   <li>{@link PDTextState#getRenderingMode()}
   *   <li>{@link PDTextState#getRise()}
   *   <li>{@link PDTextState#getWordSpacing()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDTextState pdTextState = new PDTextState();

    // Act
    pdTextState.setCharacterSpacing(10.0f);
    PDMMType1Font value = new PDMMType1Font(new COSDictionary());
    pdTextState.setFont(value);
    pdTextState.setFontSize(10.0f);
    pdTextState.setHorizontalScaling(10.0f);
    pdTextState.setKnockoutFlag(true);
    pdTextState.setLeading(10.0f);
    pdTextState.setRenderingMode(RenderingMode.FILL);
    pdTextState.setRise(10.0f);
    pdTextState.setWordSpacing(10.0f);
    float actualCharacterSpacing = pdTextState.getCharacterSpacing();
    PDFont actualFont = pdTextState.getFont();
    float actualFontSize = pdTextState.getFontSize();
    float actualHorizontalScaling = pdTextState.getHorizontalScaling();
    boolean actualKnockoutFlag = pdTextState.getKnockoutFlag();
    float actualLeading = pdTextState.getLeading();
    RenderingMode actualRenderingMode = pdTextState.getRenderingMode();
    float actualRise = pdTextState.getRise();

    // Assert that nothing has changed
    assertEquals(10.0f, actualCharacterSpacing);
    assertEquals(10.0f, actualFontSize);
    assertEquals(10.0f, actualHorizontalScaling);
    assertEquals(10.0f, actualLeading);
    assertEquals(10.0f, actualRise);
    assertEquals(10.0f, pdTextState.getWordSpacing());
    assertEquals(RenderingMode.FILL, actualRenderingMode);
    assertTrue(actualKnockoutFlag);
    assertSame(value, actualFont);
  }

  /**
   * Test {@link PDTextState#clone()}.
   * <p>
   * Method under test: {@link PDTextState#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  void testClone() {
    // Arrange and Act
    PDTextState actualCloneResult = (new PDTextState()).clone();

    // Assert
    assertNull(actualCloneResult.getFont());
    assertEquals(0.0f, actualCloneResult.getCharacterSpacing());
    assertEquals(0.0f, actualCloneResult.getFontSize());
    assertEquals(0.0f, actualCloneResult.getLeading());
    assertEquals(0.0f, actualCloneResult.getRise());
    assertEquals(0.0f, actualCloneResult.getWordSpacing());
    assertEquals(100.0f, actualCloneResult.getHorizontalScaling());
    assertEquals(RenderingMode.FILL, actualCloneResult.getRenderingMode());
    assertTrue(actualCloneResult.getKnockoutFlag());
  }

  /**
   * Test new {@link PDTextState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PDTextState}
   */
  @Test
  @DisplayName("Test new PDTextState (default constructor)")
  void testNewPDTextState() {
    // Arrange and Act
    PDTextState actualPdTextState = new PDTextState();

    // Assert
    assertNull(actualPdTextState.getFont());
    assertEquals(0.0f, actualPdTextState.getCharacterSpacing());
    assertEquals(0.0f, actualPdTextState.getFontSize());
    assertEquals(0.0f, actualPdTextState.getLeading());
    assertEquals(0.0f, actualPdTextState.getRise());
    assertEquals(0.0f, actualPdTextState.getWordSpacing());
    assertEquals(100.0f, actualPdTextState.getHorizontalScaling());
    assertEquals(RenderingMode.FILL, actualPdTextState.getRenderingMode());
    assertTrue(actualPdTextState.getKnockoutFlag());
  }
}
