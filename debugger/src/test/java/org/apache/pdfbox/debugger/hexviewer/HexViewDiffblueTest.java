package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Component;
import java.awt.Dimension;
import java.io.UnsupportedEncodingException;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HexViewDiffblueTest {
  /**
   * Test {@link HexView#HexView(byte[])}.
   * <ul>
   *   <li>Then return first element PreferredSize {@link Dimension#height} is
   * ninety-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexView#HexView(byte[])}
   */
  @Test
  @DisplayName("Test new HexView(byte[]); then return first element PreferredSize height is ninety-two")
  void testNewHexView_thenReturnFirstElementPreferredSizeHeightIsNinetyTwo() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    JComponent pane = (new HexView("AXAXAXAX".getBytes("UTF-8"))).getPane();
    assertTrue(pane instanceof JPanel);
    Component[] components = pane.getComponents();
    Component component = components[0];
    assertTrue(component instanceof HexEditor);
    assertEquals(1, components.length);
    assertEquals(92, component.getPreferredSize().height);
    Dimension preferredSize = pane.getPreferredSize();
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
   * Test {@link HexView#HexView(byte[])}.
   * <ul>
   *   <li>Then return first element PreferredSize {@link Dimension#height} is
   * seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexView#HexView(byte[])}
   */
  @Test
  @DisplayName("Test new HexView(byte[]); then return first element PreferredSize height is seventy-two")
  void testNewHexView_thenReturnFirstElementPreferredSizeHeightIsSeventyTwo() {
    // Arrange, Act and Assert
    JComponent pane = (new HexView(new byte[]{})).getPane();
    assertTrue(pane instanceof JPanel);
    Component[] components = pane.getComponents();
    Component component = components[0];
    assertTrue(component instanceof HexEditor);
    assertEquals(1, components.length);
    assertEquals(72, component.getPreferredSize().height);
    Dimension preferredSize = pane.getPreferredSize();
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
   * Test {@link HexView#changeData(byte[])}.
   * <p>
   * Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  @DisplayName("Test changeData(byte[])")
  void testChangeData() throws UnsupportedEncodingException {
    // Arrange
    HexView hexView = new HexView("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    hexView.changeData("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    JComponent pane = hexView.getPane();
    assertTrue(pane instanceof JPanel);
    Component[] components = pane.getComponents();
    Component component = components[0];
    assertTrue(component instanceof HexEditor);
    assertEquals(1, components.length);
    assertEquals(92, component.getPreferredSize().height);
    Dimension preferredSize = pane.getPreferredSize();
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
   * Test {@link HexView#changeData(byte[])}.
   * <ul>
   *   <li>Then first element PreferredSize {@link Dimension#height} is
   * seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  @DisplayName("Test changeData(byte[]); then first element PreferredSize height is seventy-two")
  void testChangeData_thenFirstElementPreferredSizeHeightIsSeventyTwo() {
    // Arrange
    HexView hexView = new HexView();

    // Act
    hexView.changeData(new byte[]{});

    // Assert
    JComponent pane = hexView.getPane();
    assertTrue(pane instanceof JPanel);
    Component[] components = pane.getComponents();
    Component component = components[0];
    assertTrue(component instanceof HexEditor);
    assertEquals(1, components.length);
    assertEquals(72, component.getPreferredSize().height);
    Dimension preferredSize = pane.getPreferredSize();
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
   * Test {@link HexView#changeData(byte[])}.
   * <ul>
   *   <li>Then {@link HexView#HexView()} Pane PreferredSize Size Size Size
   * {@link Dimension#height} is ninety-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexView#changeData(byte[])}
   */
  @Test
  @DisplayName("Test changeData(byte[]); then HexView() Pane PreferredSize Size Size Size height is ninety-two")
  void testChangeData_thenHexViewPanePreferredSizeSizeSizeSizeHeightIsNinetyTwo() throws UnsupportedEncodingException {
    // Arrange
    HexView hexView = new HexView();

    // Act
    hexView.changeData("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    JComponent pane = hexView.getPane();
    assertTrue(pane instanceof JPanel);
    Component[] components = pane.getComponents();
    Component component = components[0];
    assertTrue(component instanceof HexEditor);
    assertEquals(1, components.length);
    assertEquals(92, component.getPreferredSize().height);
    Dimension preferredSize = pane.getPreferredSize();
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
   * Test {@link HexView#getPane()}.
   * <p>
   * Method under test: {@link HexView#getPane()}
   */
  @Test
  @DisplayName("Test getPane()")
  void testGetPane() {
    // Arrange, Act and Assert
    assertTrue((new HexView()).getPane() instanceof JPanel);
  }
}
