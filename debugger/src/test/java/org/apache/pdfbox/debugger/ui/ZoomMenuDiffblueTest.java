package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ZoomMenuDiffblueTest {
  /**
   * Test {@link ZoomMenu#getInstance()}.
   * <p>
   * Method under test: {@link ZoomMenu#getInstance()}
   */
  @Test
  @DisplayName("Test getInstance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ZoomMenu ZoomMenu.getInstance()"})
  void testGetInstance() {
    // Arrange and Act
    ZoomMenu actualInstance = ZoomMenu.getInstance();

    // Assert
    assertEquals(10.0f, actualInstance.getImageZoomScale());
    assertEquals(10.0f, actualInstance.getPageZoomScale());
  }

  /**
   * Test {@link ZoomMenu#changeZoomSelection(float)}.
   * <ul>
   *   <li>When one hundred.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZoomMenu#changeZoomSelection(float)}
   */
  @Test
  @DisplayName("Test changeZoomSelection(float); when one hundred; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ZoomMenu.changeZoomSelection(float)"})
  void testChangeZoomSelection_whenOneHundred_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ZoomMenu.getInstance().changeZoomSelection(100.0f));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   * <ul>
   *   <li>When {@code 9%}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when '9%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_when9() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("9%"));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   * <ul>
   *   <li>When {@code 429%}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when '429%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_when429() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("429%"));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   * <ul>
   *   <li>When {@code 42429%}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when '42429%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_when42429() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("42429%"));
  }

  /**
   * Test {@link ZoomMenu#isZoomMenu(String)}.
   * <ul>
   *   <li>When {@code Action Command}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  @DisplayName("Test isZoomMenu(String); when 'Action Command'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ZoomMenu.isZoomMenu(String)"})
  void testIsZoomMenu_whenActionCommand() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("Action Command"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ZoomMenu#setImageZoomScale(float)}
   *   <li>{@link ZoomMenu#setPageZoomScale(float)}
   *   <li>{@link ZoomMenu#getImageZoomScale()}
   *   <li>{@link ZoomMenu#getPageZoomScale()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float ZoomMenu.getImageZoomScale()", "float ZoomMenu.getPageZoomScale()",
      "void ZoomMenu.setImageZoomScale(float)", "void ZoomMenu.setPageZoomScale(float)"})
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
