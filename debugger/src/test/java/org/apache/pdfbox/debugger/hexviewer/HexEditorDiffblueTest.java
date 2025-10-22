package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HexEditorDiffblueTest {
  /**
   * Test {@link HexEditor#HexEditor(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize {@link Dimension#height} is ninety-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#HexEditor(HexModel)}
   */
  @Test
  @DisplayName("Test new HexEditor(HexModel); then return PreferredSize height is ninety-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexEditor.<init>(HexModel)"})
  void testNewHexEditor_thenReturnPreferredSizeHeightIsNinetyTwo() throws UnsupportedEncodingException {
    // Arrange and Act
    HexEditor actualHexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    ColorModel colorModel = actualHexEditor.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Dimension preferredSize = actualHexEditor.getPreferredSize();
    assertEquals(92, preferredSize.height);
    assertEquals(92.0d, preferredSize.getHeight());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link HexEditor#HexEditor(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize {@link Dimension#height} is seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#HexEditor(HexModel)}
   */
  @Test
  @DisplayName("Test new HexEditor(HexModel); then return PreferredSize height is seventy-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexEditor.<init>(HexModel)"})
  void testNewHexEditor_thenReturnPreferredSizeHeightIsSeventyTwo() {
    // Arrange and Act
    HexEditor actualHexEditor = new HexEditor(new HexModel(new byte[]{}));

    // Assert
    ColorModel colorModel = actualHexEditor.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Dimension preferredSize = actualHexEditor.getPreferredSize();
    assertEquals(72, preferredSize.height);
    assertEquals(72.0d, preferredSize.getHeight());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); given HexModel(byte[]) with bytes is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_givenHexModelWithBytesIsEmptyArrayOfByte() {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel(new byte[]{}));

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert that nothing has changed
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(170, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(170, size2.getSize().width);
    assertEquals(170, size2.width);
    assertEquals(170, size.width);
    assertEquals(170, minimumSize.width);
    assertEquals(170.0d, size2.getWidth());
    assertEquals(170.0d, size.getWidth());
    assertEquals(170.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(370, component.getPreferredSize().width);
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>Then third element MinimumSize {@link Dimension#width} is one hundred ninety-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); then third element MinimumSize width is one hundred ninety-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_thenThirdElementMinimumSizeWidthIsOneHundredNinetyFour()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(194, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(194, size2.getSize().width);
    assertEquals(194, size2.width);
    assertEquals(194, size.width);
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, size2.getWidth());
    assertEquals(194.0d, size.getWidth());
    assertEquals(194.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(378, component.getPreferredSize().width);
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is minus one and nav is {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is minus one and nav is '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsMinusOneAndNavIs0123456789abcdef()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(-1, "0123456789ABCDEF"));

    // Assert that nothing has changed
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(170, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(170, size2.getSize().width);
    assertEquals(170, size2.width);
    assertEquals(170, size.width);
    assertEquals(170, minimumSize.width);
    assertEquals(170.0d, size2.getWidth());
    assertEquals(170.0d, size.getWidth());
    assertEquals(170.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(370, component.getPreferredSize().width);
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is zero and nav is {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is zero and nav is '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsZeroAndNavIs0123456789abcdef() throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(0, "0123456789ABCDEF"));

    // Assert
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(194, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(194, size2.getSize().width);
    assertEquals(194, size2.width);
    assertEquals(194, size.width);
    assertEquals(194, minimumSize.width);
    assertEquals(194.0d, size2.getWidth());
    assertEquals(194.0d, size.getWidth());
    assertEquals(194.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(378, component.getPreferredSize().width);
  }
}
