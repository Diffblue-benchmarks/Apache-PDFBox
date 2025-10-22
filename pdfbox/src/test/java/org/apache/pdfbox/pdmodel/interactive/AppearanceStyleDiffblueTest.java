package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AppearanceStyleDiffblueTest {
  /**
   * Test {@link AppearanceStyle#setFontSize(float)}.
   * <p>
   * Method under test: {@link AppearanceStyle#setFontSize(float)}
   */
  @Test
  @DisplayName("Test setFontSize(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceStyle.setFontSize(float)"})
  void testSetFontSize() {
    // Arrange
    AppearanceStyle appearanceStyle = new AppearanceStyle();

    // Act
    appearanceStyle.setFontSize(10.0f);

    // Assert
    assertEquals(10.0f, appearanceStyle.getFontSize());
    assertEquals(12.0f, appearanceStyle.getLeading());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AppearanceStyle}
   *   <li>{@link AppearanceStyle#setFont(PDFont)}
   *   <li>{@link AppearanceStyle#setLeading(float)}
   *   <li>{@link AppearanceStyle#getFont()}
   *   <li>{@link AppearanceStyle#getFontSize()}
   *   <li>{@link AppearanceStyle#getLeading()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceStyle.<init>()", "PDFont AppearanceStyle.getFont()",
      "float AppearanceStyle.getFontSize()", "float AppearanceStyle.getLeading()",
      "void AppearanceStyle.setFont(PDFont)", "void AppearanceStyle.setLeading(float)"})
  void testGettersAndSetters() throws IOException {
    // Arrange and Act
    AppearanceStyle actualAppearanceStyle = new AppearanceStyle();
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());
    actualAppearanceStyle.setFont(font);
    actualAppearanceStyle.setLeading(10.0f);
    PDFont actualFont = actualAppearanceStyle.getFont();
    float actualFontSize = actualAppearanceStyle.getFontSize();

    // Assert
    assertEquals(10.0f, actualAppearanceStyle.getLeading());
    assertEquals(12.0f, actualFontSize);
    assertSame(font, actualFont);
  }
}
