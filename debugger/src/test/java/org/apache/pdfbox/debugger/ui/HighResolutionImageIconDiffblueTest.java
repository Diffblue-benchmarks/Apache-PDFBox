package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HighResolutionImageIconDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HighResolutionImageIcon#HighResolutionImageIcon(Image, int, int)}
   *   <li>{@link HighResolutionImageIcon#getIconHeight()}
   *   <li>{@link HighResolutionImageIcon#getIconWidth()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HighResolutionImageIcon.<init>(Image, int, int)",
      "int HighResolutionImageIcon.getIconHeight()", "int HighResolutionImageIcon.getIconWidth()"})
  void testGettersAndSetters() {
    // Arrange and Act
    HighResolutionImageIcon actualHighResolutionImageIcon = new HighResolutionImageIcon(new BufferedImage(1, 1, 1), 1,
        1);
    int actualIconHeight = actualHighResolutionImageIcon.getIconHeight();

    // Assert
    assertEquals(1, actualIconHeight);
    assertEquals(1, actualHighResolutionImageIcon.getIconWidth());
  }
}
