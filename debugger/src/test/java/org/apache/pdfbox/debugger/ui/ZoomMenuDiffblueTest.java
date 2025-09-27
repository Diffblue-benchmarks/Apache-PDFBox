package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ZoomMenuDiffblueTest {
  /**
   * Test {@link ZoomMenu#changeZoomSelection(float)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ZoomMenu#changeZoomSelection(float)}
   */
  @Test
  @DisplayName(
      "Test changeZoomSelection(float); when one hundred; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZoomMenu.changeZoomSelection(float)"})
  void testChangeZoomSelection_whenOneHundred_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ZoomMenu.getInstance().changeZoomSelection(100.0f));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   *
   * <ul>
   *   <li>When {@code 9%}.
   * </ul>
   *
   * <p>Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when '9%'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_when9() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("9%"));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   *
   * <ul>
   *   <li>When {@code 429%}.
   * </ul>
   *
   * <p>Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when '429%'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_when429() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("429%"));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   *
   * <ul>
   *   <li>When {@code 42429%}.
   * </ul>
   *
   * <p>Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when '42429%'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_when42429() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("42429%"));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   *
   * <ul>
   *   <li>When {@code Action Command}.
   * </ul>
   *
   * <p>Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when 'Action Command'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_whenActionCommand() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("Action Command"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ZoomMenu#setImageZoomScale(float)}
   *   <li>{@link ZoomMenu#setPageZoomScale(float)}
   *   <li>{@link ZoomMenu#getImageZoomScale()}
   *   <li>{@link ZoomMenu#getPageZoomScale()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "float ZoomMenu.getImageZoomScale()",
    "float ZoomMenu.getPageZoomScale()",
    "void ZoomMenu.setImageZoomScale(float)",
    "void ZoomMenu.setPageZoomScale(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    ZoomMenu instance = ZoomMenu.getInstance();

    // Act
    instance.setImageZoomScale(10.0f);
    instance.setPageZoomScale(10.0f);
    float actualImageZoomScale = instance.getImageZoomScale();

    // Assert
    assertEquals(10.0f, actualImageZoomScale);
    assertEquals(10.0f, instance.getPageZoomScale());
  }
}
