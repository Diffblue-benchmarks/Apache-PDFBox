package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.util.Locale;
import javax.accessibility.AccessibleContext;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CSArrayBasedDiffblueTest {
  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); given COSArray(); when COSArray() add COSArray()")
  void testNewCSArrayBased_givenCOSArray_whenCOSArrayAddCOSArray() {
    // Arrange
    COSArray array = new COSArray();
    array.add((COSBase) new COSArray());

    // Act and Assert
    Component panel = (new CSArrayBased(array)).getPanel();
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("First element in colorspace array must be a name", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(432, maximumSize.width);
    assertEquals(432, component.getMaximumSize().width);
    assertEquals(432, component.getMinimumSize().width);
    assertEquals(432, component.getPreferredSize().width);
    Dimension size = maximumSize.getSize();
    assertEquals(432, size.width);
    Dimension size2 = size.getSize();
    assertEquals(432, size2.width);
    assertEquals(432, size2.getSize().width);
    assertEquals(432.0d, maximumSize.getWidth());
    assertEquals(432.0d, size.getWidth());
    assertEquals(432.0d, size2.getWidth());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  void testNewCSArrayBased_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArray array = new COSArray();
    COSArray object = new COSArray();
    array.add((COSBase) new COSObject(object, new COSObjectKey(1L, 1)));

    // Act and Assert
    Component panel = (new CSArrayBased(array)).getPanel();
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("First element in colorspace array must be a name", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(432, maximumSize.width);
    assertEquals(432, component.getMaximumSize().width);
    assertEquals(432, component.getMinimumSize().width);
    assertEquals(432, component.getPreferredSize().width);
    Dimension size = maximumSize.getSize();
    assertEquals(432, size.width);
    Dimension size2 = size.getSize();
    assertEquals(432, size2.width);
    assertEquals(432, size2.getSize().width);
    assertEquals(432.0d, maximumSize.getWidth());
    assertEquals(432.0d, size.getWidth());
    assertEquals(432.0d, size2.getWidth());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   * <ul>
   *   <li>Then return first element Text is {@code Colorspace array is empty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); then return first element Text is 'Colorspace array is empty'")
  void testNewCSArrayBased_thenReturnFirstElementTextIsColorspaceArrayIsEmpty() {
    // Arrange, Act and Assert
    Component panel = (new CSArrayBased(new COSArray())).getPanel();
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("Colorspace array is empty", ((JLabel) component).getText());
    assertEquals(0.4977778f, panel.getAlignmentX());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(225, maximumSize.width);
    assertEquals(225, component.getMaximumSize().width);
    assertEquals(225, component.getMinimumSize().width);
    assertEquals(225, component.getPreferredSize().width);
    Dimension size = maximumSize.getSize();
    assertEquals(225, size.width);
    Dimension size2 = size.getSize();
    assertEquals(225, size2.width);
    assertEquals(225, size2.getSize().width);
    assertEquals(225.0d, maximumSize.getWidth());
    assertEquals(225.0d, size.getWidth());
    assertEquals(225.0d, size2.getWidth());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then Panel bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); when 'null'; then Panel bounds Bounds2D return Rectangle")
  void testNewCSArrayBased_whenNull_thenPanelBoundsBounds2DReturnRectangle() {
    // Arrange, Act and Assert
    Component panel = (new CSArrayBased(null)).getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    LayoutManager layout = ((JPanel) panel).getLayout();
    assertTrue(layout instanceof BoxLayout);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("Expected a name or array but got: null", ((JLabel) component).getText());
    assertEquals(1, component.getPropertyChangeListeners().length);
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(342, maximumSize.width);
    assertEquals(342, component.getMaximumSize().width);
    assertEquals(342, component.getMinimumSize().width);
    assertEquals(342, component.getPreferredSize().width);
    assertEquals(342.0d, maximumSize.getWidth());
    Color background = panel.getBackground();
    Color brighterResult = background.brighter();
    Color brighterResult2 = brighterResult.brighter();
    assertEquals(brighterResult2, brighterResult.darker().brighter().brighter());
    assertEquals(brighterResult2, background.darker().brighter().brighter());
    assertEquals(brighterResult2, brighterResult2);
    assertEquals(boundsResult, component.bounds());
    assertEquals(boundsResult, panel.getBounds());
    assertEquals(boundsResult, component.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((JLabel) component).getVisibleRect());
    assertEquals(boundsResult, ((JPanel) panel).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Point location = panel.getLocation();
    assertEquals(location, component.getLocation());
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, panel.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    Dimension preferredSize = panel.getPreferredSize();
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = panel.getSize();
    assertEquals(size, component.getSize());
    assertEquals(size, panel.size());
    assertEquals(size, component.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    AccessibleContext accessibleContext = panel.getAccessibleContext();
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(background, component.getBackground());
    Color expectedForeground = panel.getForeground();
    assertSame(expectedForeground, component.getForeground());
    Locale expectedLocale = panel.getLocale();
    assertSame(expectedLocale, component.getLocale());
    assertSame(colorModel, component.getColorModel());
    assertSame(panel, component.getParent());
    assertSame(panel, ((BoxLayout) layout).getTarget());
  }

  /**
   * Test {@link CSArrayBased#getPanel()}.
   * <p>
   * Method under test: {@link CSArrayBased#getPanel()}
   */
  @Test
  @DisplayName("Test getPanel()")
  void testGetPanel() {
    // Arrange, Act and Assert
    assertTrue((new CSArrayBased(new COSArray())).getPanel() instanceof JPanel);
  }
}
