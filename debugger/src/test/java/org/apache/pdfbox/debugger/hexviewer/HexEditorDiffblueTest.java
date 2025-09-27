package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HexEditorDiffblueTest {
  /**
   * Test {@link HexEditor#HexEditor(HexModel)}.
   *
   * <ul>
   *   <li>When {@link HexModel#HexModel(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#HexEditor(HexModel)}
   */
  @Test
  @DisplayName(
      "Test new HexEditor(HexModel); when HexModel(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.<init>(HexModel)"})
  void testNewHexEditor_whenHexModelWithBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    HexEditor actualHexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertTrue(actualHexEditor.getLayout() instanceof GridBagLayout);
    assertTrue(actualHexEditor.getColorModel() instanceof DirectColorModel);
    assertEquals(3, actualHexEditor.getComponents().length);
  }

  /**
   * Test {@link HexEditor#HexEditor(HexModel)}.
   *
   * <ul>
   *   <li>When {@link HexModel#HexModel(byte[])} with bytes is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#HexEditor(HexModel)}
   */
  @Test
  @DisplayName(
      "Test new HexEditor(HexModel); when HexModel(byte[]) with bytes is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.<init>(HexModel)"})
  void testNewHexEditor_whenHexModelWithBytesIsEmptyArrayOfByte() {
    // Arrange
    HexModel model = new HexModel(new byte[] {});

    // Act
    HexEditor actualHexEditor = new HexEditor(model);

    // Assert
    assertTrue(actualHexEditor.getLayout() instanceof GridBagLayout);
    assertTrue(actualHexEditor.getColorModel() instanceof DirectColorModel);
    assertEquals(3, actualHexEditor.getComponents().length);
  }

  /**
   * Test {@link HexEditor#selectionChanged(SelectEvent)}.
   *
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is minus one and nav is {@code
   *       next}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName(
      "Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is minus one and nav is 'next'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsMinusOneAndNavIsNext()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(-1, "next"));

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
   *
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is one and nav is {@code
   *       0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName(
      "Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is one and nav is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsOneAndNavIs0123456789abcdef()
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
   *
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is zero and nav is {@code
   *       down}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName(
      "Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is zero and nav is 'down'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsZeroAndNavIsDown()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(0, "down"));

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
   *
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is zero and nav is {@code
   *       next}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName(
      "Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is zero and nav is 'next'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsZeroAndNavIsNext()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(0, "next"));

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
   *
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is zero and nav is {@code
   *       previous}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName(
      "Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is zero and nav is 'previous'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsZeroAndNavIsPrevious()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(0, "previous"));

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
   *
   * <ul>
   *   <li>When {@link SelectEvent#SelectEvent(int, String)} with ind is zero and nav is {@code up}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName(
      "Test selectionChanged(SelectEvent); when SelectEvent(int, String) with ind is zero and nav is 'up'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_whenSelectEventWithIndIsZeroAndNavIsUp()
      throws UnsupportedEncodingException {
    // Arrange
    HexEditor hexEditor = new HexEditor(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Act
    hexEditor.selectionChanged(new SelectEvent(0, "up"));

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
}
