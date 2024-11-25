package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Component;
import java.awt.Dimension;
import java.io.UnsupportedEncodingException;
import javax.swing.JScrollPane;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HexEditorDiffblueTest {
  /**
   * Test {@link HexEditor#HexEditor(HexModel)}.
   * <ul>
   *   <li>Then return second element PreferredSize {@link Dimension#height} is
   * forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#HexEditor(HexModel)}
   */
  @Test
  @DisplayName("Test new HexEditor(HexModel); then return second element PreferredSize height is forty-two")
  void testNewHexEditor_thenReturnSecondElementPreferredSizeHeightIsFortyTwo() throws UnsupportedEncodingException {
    // Arrange and Act
    HexEditor actualHexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    Component[] components = actualHexEditor.getComponents();
    Component component = components[1];
    assertTrue(component instanceof JScrollPane);
    assertEquals(3, components.length);
    assertEquals(42, component.getPreferredSize().height);
    Dimension preferredSize = actualHexEditor.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(92, size2.getSize().height);
    assertEquals(92, size2.height);
    assertEquals(92, size.height);
    assertEquals(92, preferredSize.height);
    assertEquals(92.0d, size2.getHeight());
    assertEquals(92.0d, size.getHeight());
    assertEquals(92.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link HexEditor#HexEditor(HexModel)}.
   * <ul>
   *   <li>Then return second element PreferredSize {@link Dimension#height} is
   * twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#HexEditor(HexModel)}
   */
  @Test
  @DisplayName("Test new HexEditor(HexModel); then return second element PreferredSize height is twenty-two")
  void testNewHexEditor_thenReturnSecondElementPreferredSizeHeightIsTwentyTwo() {
    // Arrange and Act
    HexEditor actualHexEditor = new HexEditor(new HexModel(new byte[]{}));

    // Assert
    Component[] components = actualHexEditor.getComponents();
    Component component = components[1];
    assertTrue(component instanceof JScrollPane);
    assertEquals(22, component.getPreferredSize().height);
    assertEquals(3, components.length);
    Dimension preferredSize = actualHexEditor.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(72, size2.getSize().height);
    assertEquals(72, size2.height);
    assertEquals(72, size.height);
    assertEquals(72, preferredSize.height);
    assertEquals(72.0d, size2.getHeight());
    assertEquals(72.0d, size.getHeight());
    assertEquals(72.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is empty array of
   * {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); given HexModel(byte[]) with bytes is empty array of byte")
  void testSelectionChanged_givenHexModelWithBytesIsEmptyArrayOfByte() {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel(new byte[]{}));

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert that nothing has changed
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(142, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(142, size2.getSize().width);
    assertEquals(142, size2.width);
    assertEquals(142, size.width);
    assertEquals(142, minimumSize.width);
    assertEquals(142.0d, size2.getWidth());
    assertEquals(142.0d, size.getWidth());
    assertEquals(142.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(342, component.getPreferredSize().width);
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>Then third element MinimumSize {@link Dimension#width} is one hundred
   * sixty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); then third element MinimumSize width is one hundred sixty-three")
  void testSelectionChanged_thenThirdElementMinimumSizeWidthIsOneHundredSixtyThree()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(163, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(163, size2.getSize().width);
    assertEquals(163, size2.width);
    assertEquals(163, size.width);
    assertEquals(163, minimumSize.width);
    assertEquals(163.0d, size2.getWidth());
    assertEquals(163.0d, size.getWidth());
    assertEquals(163.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(349, component.getPreferredSize().width);
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is minus one
   * and nav is {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is minus one and nav is '0123456789ABCDEF'")
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
    assertEquals(142, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(142, size2.getSize().width);
    assertEquals(142, size2.width);
    assertEquals(142, size.width);
    assertEquals(142, minimumSize.width);
    assertEquals(142.0d, size2.getWidth());
    assertEquals(142.0d, size.getWidth());
    assertEquals(142.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(342, component.getPreferredSize().width);
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is zero and
   * nav is {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is zero and nav is '0123456789ABCDEF'")
  void testSelectionChanged_whenSelectEventWithIndIsZeroAndNavIs0123456789abcdef() throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(0, "0123456789ABCDEF"));

    // Assert
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(163, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(163, size2.getSize().width);
    assertEquals(163, size2.width);
    assertEquals(163, size.width);
    assertEquals(163, minimumSize.width);
    assertEquals(163.0d, size2.getWidth());
    assertEquals(163.0d, size.getWidth());
    assertEquals(163.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(349, component.getPreferredSize().width);
  }
}
