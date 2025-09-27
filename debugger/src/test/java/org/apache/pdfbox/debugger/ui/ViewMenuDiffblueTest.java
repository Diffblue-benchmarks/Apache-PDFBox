package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ViewMenuDiffblueTest {
  /**
   * Test {@link ViewMenu#isRenderingOption(String)}.
   *
   * <ul>
   *   <li>When {@code Action Command}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRenderingOption(String)}
   */
  @Test
  @DisplayName("Test isRenderingOption(String); when 'Action Command'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRenderingOption(String)"})
  void testIsRenderingOption_whenActionCommand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isRenderingOption("Action Command"));
  }

  /**
   * Test {@link ViewMenu#isRenderingOption(String)}.
   *
   * <ul>
   *   <li>When {@code Allow subsampling}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRenderingOption(String)}
   */
  @Test
  @DisplayName("Test isRenderingOption(String); when 'Allow subsampling'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRenderingOption(String)"})
  void testIsRenderingOption_whenAllowSubsampling_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ViewMenu.isRenderingOption("Allow subsampling"));
  }

  /**
   * Test {@link ViewMenu#isRenderingOption(String)}.
   *
   * <ul>
   *   <li>When {@code Show Approximate Text Bounds}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRenderingOption(String)}
   */
  @Test
  @DisplayName(
      "Test isRenderingOption(String); when 'Show Approximate Text Bounds'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRenderingOption(String)"})
  void testIsRenderingOption_whenShowApproximateTextBounds_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ViewMenu.isRenderingOption("Show Approximate Text Bounds"));
  }

  /**
   * Test {@link ViewMenu#isRenderingOption(String)}.
   *
   * <ul>
   *   <li>When {@code Show Glyph Bounds}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRenderingOption(String)}
   */
  @Test
  @DisplayName("Test isRenderingOption(String); when 'Show Glyph Bounds'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRenderingOption(String)"})
  void testIsRenderingOption_whenShowGlyphBounds_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ViewMenu.isRenderingOption("Show Glyph Bounds"));
  }

  /**
   * Test {@link ViewMenu#isRenderingOption(String)}.
   *
   * <ul>
   *   <li>When {@code Show TextStripper Beads}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRenderingOption(String)}
   */
  @Test
  @DisplayName("Test isRenderingOption(String); when 'Show TextStripper Beads'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRenderingOption(String)"})
  void testIsRenderingOption_whenShowTextStripperBeads_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ViewMenu.isRenderingOption("Show TextStripper Beads"));
  }

  /**
   * Test {@link ViewMenu#isRenderingOption(String)}.
   *
   * <ul>
   *   <li>When {@code Show TextStripper TextPositions}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRenderingOption(String)}
   */
  @Test
  @DisplayName(
      "Test isRenderingOption(String); when 'Show TextStripper TextPositions'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRenderingOption(String)"})
  void testIsRenderingOption_whenShowTextStripperTextPositions_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ViewMenu.isRenderingOption("Show TextStripper TextPositions"));
  }

  /**
   * Test {@link ViewMenu#isShowTextStripper()}.
   *
   * <p>Method under test: {@link ViewMenu#isShowTextStripper()}
   */
  @Test
  @DisplayName("Test isShowTextStripper()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isShowTextStripper()"})
  void testIsShowTextStripper() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isShowTextStripper());
  }

  /**
   * Test {@link ViewMenu#isShowTextStripperBeads()}.
   *
   * <p>Method under test: {@link ViewMenu#isShowTextStripperBeads()}
   */
  @Test
  @DisplayName("Test isShowTextStripperBeads()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isShowTextStripperBeads()"})
  void testIsShowTextStripperBeads() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isShowTextStripperBeads());
  }

  /**
   * Test {@link ViewMenu#isShowFontBBox()}.
   *
   * <p>Method under test: {@link ViewMenu#isShowFontBBox()}
   */
  @Test
  @DisplayName("Test isShowFontBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isShowFontBBox()"})
  void testIsShowFontBBox() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isShowFontBBox());
  }

  /**
   * Test {@link ViewMenu#isShowGlyphBounds()}.
   *
   * <p>Method under test: {@link ViewMenu#isShowGlyphBounds()}
   */
  @Test
  @DisplayName("Test isShowGlyphBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isShowGlyphBounds()"})
  void testIsShowGlyphBounds() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isShowGlyphBounds());
  }

  /**
   * Test {@link ViewMenu#isExtractTextEvent(ActionEvent)}.
   *
   * <ul>
   *   <li>When {@link ActionEvent#ActionEvent(Object, int, String)} with {@code 42} and one and
   *       {@code Extract Text}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isExtractTextEvent(ActionEvent)}
   */
  @Test
  @DisplayName(
      "Test isExtractTextEvent(ActionEvent); when ActionEvent(Object, int, String) with '42' and one and 'Extract Text'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isExtractTextEvent(ActionEvent)"})
  void testIsExtractTextEvent_whenActionEventWith42AndOneAndExtractText_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ViewMenu.isExtractTextEvent(new ActionEvent("42", 1, "Extract Text")));
  }

  /**
   * Test {@link ViewMenu#isExtractTextEvent(ActionEvent)}.
   *
   * <ul>
   *   <li>When {@link ActionEvent#ActionEvent(Object, int, String)} with {@code 42} and one and
   *       {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isExtractTextEvent(ActionEvent)}
   */
  @Test
  @DisplayName(
      "Test isExtractTextEvent(ActionEvent); when ActionEvent(Object, int, String) with '42' and one and 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isExtractTextEvent(ActionEvent)"})
  void testIsExtractTextEvent_whenActionEventWith42AndOneAndFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isExtractTextEvent(new ActionEvent("42", 1, "foo")));
  }

  /**
   * Test {@link ViewMenu#isAllowSubsampling()}.
   *
   * <p>Method under test: {@link ViewMenu#isAllowSubsampling()}
   */
  @Test
  @DisplayName("Test isAllowSubsampling()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isAllowSubsampling()"})
  void testIsAllowSubsampling() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isAllowSubsampling());
  }

  /**
   * Test {@link ViewMenu#isRepairAcroformEvent(ActionEvent)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRepairAcroformEvent(ActionEvent)}
   */
  @Test
  @DisplayName("Test isRepairAcroformEvent(ActionEvent); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRepairAcroformEvent(ActionEvent)"})
  void testIsRepairAcroformEvent_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ViewMenu.isRepairAcroformEvent(new ActionEvent("42", 1, "Repair AcroForm")));
  }

  /**
   * Test {@link ViewMenu#isRepairAcroformEvent(ActionEvent)}.
   *
   * <ul>
   *   <li>When {@link ActionEvent#ActionEvent(Object, int, String)} with {@code 42} and one and
   *       {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMenu#isRepairAcroformEvent(ActionEvent)}
   */
  @Test
  @DisplayName(
      "Test isRepairAcroformEvent(ActionEvent); when ActionEvent(Object, int, String) with '42' and one and 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRepairAcroformEvent(ActionEvent)"})
  void testIsRepairAcroformEvent_whenActionEventWith42AndOneAndFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isRepairAcroformEvent(new ActionEvent("42", 1, "foo")));
  }

  /**
   * Test {@link ViewMenu#isRepairAcroformSelected()}.
   *
   * <p>Method under test: {@link ViewMenu#isRepairAcroformSelected()}
   */
  @Test
  @DisplayName("Test isRepairAcroformSelected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ViewMenu.isRepairAcroformSelected()"})
  void testIsRepairAcroformSelected() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isRepairAcroformSelected());
  }
}
