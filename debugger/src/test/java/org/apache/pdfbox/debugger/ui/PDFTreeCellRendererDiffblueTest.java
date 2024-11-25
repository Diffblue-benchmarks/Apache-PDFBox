package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.geom.Rectangle2D;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import javax.accessibility.AccessibleContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.plaf.BorderUIResource;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFTreeCellRendererDiffblueTest {
  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)")
  void testGetTreeCellRendererComponent() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(new JTree(),
        "Node Value", true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("Node Value", accessibleContext.getAccessibleName());
    assertEquals("Node Value", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(64.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(67, preferredSize.width);
    assertEquals(67.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    assertEquals(Double.SIZE, maximumSize.width);
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)")
  void testGetTreeCellRendererComponent2() throws IOException {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        COSString.parseHex("0123456789ABCDEF"), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("<0123456789ABCDEF>", accessibleContext.getAccessibleName());
    assertEquals("<0123456789ABCDEF>", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(152, maximumSize.width);
    assertEquals(152.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(155, preferredSize.width);
    assertEquals(155.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/hex.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)")
  void testGetTreeCellRendererComponent3() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        new DocumentEntry(new PDDocument(), "foo.txt"), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("foo.txt", accessibleContext.getAccessibleName());
    assertEquals("foo.txt", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/pdf.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return AccessibleContext AccessibleName is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return AccessibleContext AccessibleName is '0'")
  void testGetTreeCellRendererComponent_thenReturnAccessibleContextAccessibleNameIs0() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree, new ArrayEntry(),
        true, true, true, 1, true);

    // Assert
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    assertEquals("0", actualTreeCellRendererComponent.getAccessibleContext().getAccessibleName());
    assertEquals("0", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(27, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(27, size.width);
    Dimension size2 = size.getSize();
    assertEquals(27, size2.width);
    assertEquals(27, size2.getSize().width);
    assertEquals(27.0d, maximumSize.getWidth());
    assertEquals(27.0d, size.getWidth());
    assertEquals(27.0d, size2.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(30, preferredSize.width);
    Dimension size3 = preferredSize.getSize();
    assertEquals(30, size3.width);
    Dimension size4 = size3.getSize();
    assertEquals(30, size4.width);
    assertEquals(30, size4.getSize().width);
    assertEquals(30.0d, preferredSize.getWidth());
    assertEquals(30.0d, size3.getWidth());
    assertEquals(30.0d, size4.getWidth());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/null.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return AccessibleContext AccessibleName is {@code (0)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return AccessibleContext AccessibleName is '(0)'")
  void testGetTreeCellRendererComponent_thenReturnAccessibleContextAccessibleNameIs02() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        new COSDictionary(), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("(0)", accessibleContext.getAccessibleName());
    assertEquals("(0)", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(35, maximumSize.width);
    assertEquals(35.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(38, preferredSize.width);
    assertEquals(38.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/dict.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return AccessibleContext AccessibleName is {@code 1: (0)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return AccessibleContext AccessibleName is '1: (0)'")
  void testGetTreeCellRendererComponent_thenReturnAccessibleContextAccessibleNameIs10() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree, arrayEntry, true,
        true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("1:  (0)", accessibleContext.getAccessibleName());
    assertEquals("1:  (0)", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(51, maximumSize.width);
    assertEquals(51.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(54, preferredSize.width);
    assertEquals(54.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/array.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return AccessibleContext AccessibleName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return AccessibleContext AccessibleName is '42'")
  void testGetTreeCellRendererComponent_thenReturnAccessibleContextAccessibleNameIs42() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        COSInteger.get(42L), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("42", accessibleContext.getAccessibleName());
    assertEquals("42", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(34, maximumSize.width);
    assertEquals(34.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(37, preferredSize.width);
    assertEquals(37.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/integer.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return AccessibleContext AccessibleName is {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return AccessibleContext AccessibleName is '10.0'")
  void testGetTreeCellRendererComponent_thenReturnAccessibleContextAccessibleNameIs100() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        new COSFloat(10.0f), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("10.0", accessibleContext.getAccessibleName());
    assertEquals("10.0", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(44, maximumSize.width);
    assertEquals(44.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(47, preferredSize.width);
    assertEquals(47.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/real.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return AccessibleContext AccessibleName is {@code Text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return AccessibleContext AccessibleName is 'Text'")
  void testGetTreeCellRendererComponent_thenReturnAccessibleContextAccessibleNameIsText() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        new COSString("Text"), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals("Text", accessibleContext.getAccessibleName());
    assertEquals("Text", ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(42, maximumSize.width);
    assertEquals(42.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(45, preferredSize.width);
    assertEquals(45.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/string.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return MaximumSize {@link Dimension#width} is forty-one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return MaximumSize width is forty-one")
  void testGetTreeCellRendererComponent_thenReturnMaximumSizeWidthIsFortyOne() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        COSBoolean.getBoolean(true), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    Icon icon = ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getIcon();
    assertTrue(icon instanceof ImageIcon);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(41, maximumSize.width);
    assertEquals(41.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(44, preferredSize.width);
    assertEquals(44.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    String expectedAccessibleName = Boolean.TRUE.toString();
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals(expectedAccessibleName, accessibleContext.getAccessibleName());
    String expectedText = Boolean.TRUE.toString();
    assertEquals(expectedText, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    String expectedDescription = String.join("", "file:/C:/Users/", System.getProperty("user.name"),
        "/IdeaProjects/Apache-PDFBox/debugger/target/classes/org/apache/pdfbox/debugger/boolean.png");
    assertEquals(expectedDescription, ((ImageIcon) icon).getDescription());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
   * <ul>
   *   <li>Then return MaximumSize {@link Dimension#width} is twenty-five.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  @DisplayName("Test getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean); then return MaximumSize width is twenty-five")
  void testGetTreeCellRendererComponent_thenReturnMaximumSizeWidthIsTwentyFive() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act
    Component actualTreeCellRendererComponent = pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        new XrefEntries(new PDDocument()), true, true, true, 1, true);

    // Assert
    Rectangle boundsResult = actualTreeCellRendererComponent.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(actualTreeCellRendererComponent.getColorModel() instanceof DirectColorModel);
    assertTrue(((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    assertTrue(actualTreeCellRendererComponent instanceof PDFTreeCellRenderer);
    assertEquals(1, actualTreeCellRendererComponent.getPropertyChangeListeners().length);
    Dimension maximumSize = actualTreeCellRendererComponent.getMaximumSize();
    assertEquals(25, maximumSize.width);
    assertEquals(25.0d, maximumSize.getWidth());
    Dimension preferredSize = actualTreeCellRendererComponent.getPreferredSize();
    assertEquals(28, preferredSize.width);
    assertEquals(28.0d, preferredSize.getWidth());
    assertEquals(boundsResult, actualTreeCellRendererComponent.getBounds());
    assertEquals(boundsResult, boundsResult.getBounds());
    assertEquals(boundsResult, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getVisibleRect());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    Color foreground = actualTreeCellRendererComponent.getForeground();
    assertEquals(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextNonSelectionColor());
    Point location = actualTreeCellRendererComponent.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(location, boundsResult.getLocation());
    assertEquals(maximumSize, actualTreeCellRendererComponent.getMinimumSize());
    assertEquals(maximumSize, maximumSize.getSize());
    assertEquals(preferredSize, preferredSize.getSize());
    Dimension size = actualTreeCellRendererComponent.getSize();
    assertEquals(size, actualTreeCellRendererComponent.size());
    assertEquals(size, size.getSize());
    assertEquals(size, boundsResult.getSize());
    Color backgroundNonSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundNonSelectionColor();
    assertEquals(backgroundNonSelectionColor,
        ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getBorderSelectionColor()
            .brighter()
            .brighter()
            .brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.darker().brighter().brighter());
    Color backgroundSelectionColor = ((PDFTreeCellRenderer) actualTreeCellRendererComponent)
        .getBackgroundSelectionColor();
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.darker().brighter().brighter());
    assertEquals(backgroundNonSelectionColor, backgroundNonSelectionColor.brighter());
    assertEquals(backgroundNonSelectionColor, backgroundSelectionColor.brighter());
    AccessibleContext accessibleContext = actualTreeCellRendererComponent.getAccessibleContext();
    assertEquals(XrefEntries.PATH, accessibleContext.getAccessibleName());
    assertEquals(XrefEntries.PATH, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getText());
    assertSame(accessibleContext, accessibleContext.getAccessibleComponent());
    assertSame(foreground, ((PDFTreeCellRenderer) actualTreeCellRendererComponent).getTextSelectionColor());
  }

  /**
   * Test new {@link PDFTreeCellRenderer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PDFTreeCellRenderer}
   */
  @Test
  @DisplayName("Test new PDFTreeCellRenderer (default constructor)")
  void testNewPDFTreeCellRenderer() {
    // Arrange and Act
    PDFTreeCellRenderer actualPdfTreeCellRenderer = new PDFTreeCellRenderer();

    // Assert
    Color backgroundNonSelectionColor = actualPdfTreeCellRenderer.getBackgroundNonSelectionColor();
    ColorSpace colorSpace = backgroundNonSelectionColor.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(actualPdfTreeCellRenderer.getBorder() instanceof BorderUIResource.EmptyBorderUIResource);
    AccessibleContext accessibleContext = actualPdfTreeCellRenderer.getAccessibleContext();
    assertEquals("", accessibleContext.getAccessibleName());
    assertEquals("", actualPdfTreeCellRenderer.getText());
    assertNull(accessibleContext.getAccessibleIcon());
    assertNull(actualPdfTreeCellRenderer.getLabelFor());
    assertNull(actualPdfTreeCellRenderer.getLayout());
    assertNull(actualPdfTreeCellRenderer.getDropTarget());
    assertNull(accessibleContext.getAccessibleDescription());
    assertNull(accessibleContext.getAccessibleParent());
    assertNull(accessibleContext.getAccessibleAction());
    assertNull(accessibleContext.getAccessibleEditableText());
    assertNull(accessibleContext.getAccessibleSelection());
    assertNull(accessibleContext.getAccessibleTable());
    assertNull(accessibleContext.getAccessibleText());
    assertNull(accessibleContext.getAccessibleValue());
    assertNull(actualPdfTreeCellRenderer.getIcon());
    assertEquals(-1, backgroundNonSelectionColor.getRGB());
    assertEquals(-1, actualPdfTreeCellRenderer.getDisplayedMnemonicIndex());
    Color borderSelectionColor = actualPdfTreeCellRenderer.getBorderSelectionColor();
    assertEquals(-10255681, borderSelectionColor.getRGB());
    Color darkerResult = borderSelectionColor.darker();
    Color brighterResult = darkerResult.brighter();
    assertEquals(-10321218, brighterResult.getRGB());
    Color brighterResult2 = borderSelectionColor.brighter();
    Color darkerResult2 = brighterResult2.darker();
    assertEquals(-10321486, darkerResult2.getRGB());
    Color backgroundSelectionColor = actualPdfTreeCellRenderer.getBackgroundSelectionColor();
    Color darkerResult3 = backgroundSelectionColor.darker();
    Color darkerResult4 = darkerResult3.darker();
    assertEquals(-10918800, darkerResult4.getRGB());
    assertEquals(-12231803, darkerResult.getRGB());
    Color darkerResult5 = darkerResult.darker();
    assertEquals(-13615267, darkerResult5.getRGB());
    Color brighterResult3 = brighterResult2.brighter();
    assertEquals(-3538945, brighterResult3.getRGB());
    assertEquals(-4665371, backgroundSelectionColor.getRGB());
    Color brighterResult4 = darkerResult3.brighter();
    assertEquals(-4796956, brighterResult4.getRGB());
    Color darkerResult6 = backgroundNonSelectionColor.darker();
    assertEquals(-5066062, darkerResult6.getRGB());
    Color brighterResult5 = darkerResult6.brighter();
    Color darkerResult7 = brighterResult5.darker();
    assertEquals(-5131855, darkerResult7.getRGB());
    assertEquals(-65794, brighterResult5.getRGB());
    assertEquals(-7489025, brighterResult2.getRGB());
    assertEquals(-8351584, darkerResult3.getRGB());
    Color darkerResult8 = darkerResult6.darker();
    assertEquals(-8618884, darkerResult8.getRGB());
    assertEquals(0, accessibleContext.getAccessibleRelationSet().size());
    assertEquals(0, actualPdfTreeCellRenderer.getHeight());
    assertEquals(0, actualPdfTreeCellRenderer.getWidth());
    assertEquals(0, actualPdfTreeCellRenderer.getX());
    assertEquals(0, actualPdfTreeCellRenderer.getY());
    assertEquals(0, actualPdfTreeCellRenderer.getDisplayedMnemonic());
    assertEquals(0, actualPdfTreeCellRenderer.getVerticalAlignment());
    assertEquals(0, actualPdfTreeCellRenderer.getVerticalTextPosition());
    assertEquals(1, brighterResult3.getTransparency());
    assertEquals(1, brighterResult5.getTransparency());
    assertEquals(1, brighterResult4.getTransparency());
    assertEquals(1, brighterResult.getTransparency());
    assertEquals(1, brighterResult2.getTransparency());
    assertEquals(1, darkerResult2.getTransparency());
    assertEquals(1, darkerResult8.getTransparency());
    assertEquals(1, darkerResult4.getTransparency());
    assertEquals(1, darkerResult5.getTransparency());
    assertEquals(1, darkerResult6.getTransparency());
    assertEquals(1, darkerResult3.getTransparency());
    assertEquals(1, darkerResult.getTransparency());
    assertEquals(1, backgroundNonSelectionColor.getTransparency());
    assertEquals(1, backgroundSelectionColor.getTransparency());
    assertEquals(1, borderSelectionColor.getTransparency());
    assertEquals(10, actualPdfTreeCellRenderer.getHorizontalAlignment());
    assertEquals(100, darkerResult4.getGreen());
    assertEquals(11, actualPdfTreeCellRenderer.getHorizontalTextPosition());
    assertEquals(112, darkerResult4.getBlue());
    assertEquals(124, darkerResult8.getBlue());
    assertEquals(124, darkerResult8.getGreen());
    assertEquals(124, darkerResult8.getRed());
    assertEquals(128, darkerResult3.getRed());
    assertEquals(129, darkerResult2.getGreen());
    assertEquals(130, brighterResult.getGreen());
    assertEquals(130, borderSelectionColor.getGreen());
    assertEquals(133, darkerResult.getBlue());
    assertEquals(141, brighterResult2.getRed());
    assertEquals(144, darkerResult3.getGreen());
    assertEquals(160, darkerResult3.getBlue());
    assertEquals(177, darkerResult7.getBlue());
    assertEquals(177, darkerResult7.getGreen());
    assertEquals(177, darkerResult7.getRed());
    assertEquals(178, darkerResult2.getBlue());
    assertEquals(178, darkerResult6.getBlue());
    assertEquals(178, darkerResult6.getGreen());
    assertEquals(178, darkerResult6.getRed());
    assertEquals(182, brighterResult4.getRed());
    assertEquals(184, backgroundSelectionColor.getRed());
    assertEquals(185, brighterResult2.getGreen());
    assertEquals(190, brighterResult.getBlue());
    assertEquals(191, borderSelectionColor.getBlue());
    assertEquals(201, brighterResult3.getRed());
    assertEquals(205, brighterResult4.getGreen());
    assertEquals(207, backgroundSelectionColor.getGreen());
    assertEquals(228, brighterResult4.getBlue());
    assertEquals(229, backgroundSelectionColor.getBlue());
    assertEquals(254, brighterResult5.getBlue());
    assertEquals(254, brighterResult5.getGreen());
    assertEquals(254, brighterResult5.getRed());
    assertEquals(255, brighterResult3.getAlpha());
    assertEquals(255, brighterResult5.getAlpha());
    assertEquals(255, brighterResult4.getAlpha());
    assertEquals(255, brighterResult.getAlpha());
    assertEquals(255, brighterResult2.getAlpha());
    assertEquals(255, darkerResult7.getAlpha());
    assertEquals(255, darkerResult2.getAlpha());
    assertEquals(255, darkerResult8.getAlpha());
    assertEquals(255, darkerResult4.getAlpha());
    assertEquals(255, darkerResult5.getAlpha());
    assertEquals(255, darkerResult6.getAlpha());
    assertEquals(255, darkerResult3.getAlpha());
    assertEquals(255, darkerResult.getAlpha());
    assertEquals(255, backgroundNonSelectionColor.getAlpha());
    assertEquals(255, backgroundSelectionColor.getAlpha());
    assertEquals(255, borderSelectionColor.getAlpha());
    assertEquals(255, brighterResult3.getBlue());
    assertEquals(255, brighterResult2.getBlue());
    assertEquals(255, backgroundNonSelectionColor.getBlue());
    assertEquals(255, brighterResult3.getGreen());
    assertEquals(255, backgroundNonSelectionColor.getGreen());
    assertEquals(255, backgroundNonSelectionColor.getRed());
    assertEquals(4, actualPdfTreeCellRenderer.getIconTextGap());
    assertEquals(48, darkerResult5.getRed());
    assertEquals(63, darkerResult5.getGreen());
    assertEquals(69, darkerResult.getRed());
    assertEquals(89, darkerResult4.getRed());
    assertEquals(91, darkerResult.getGreen());
    assertEquals(93, darkerResult5.getBlue());
    assertEquals(98, brighterResult.getRed());
    assertEquals(98, darkerResult2.getRed());
    assertEquals(99, borderSelectionColor.getRed());
    assertFalse(actualPdfTreeCellRenderer.getIgnoreRepaint());
    assertFalse(actualPdfTreeCellRenderer.isMaximumSizeSet());
    assertFalse(actualPdfTreeCellRenderer.isMinimumSizeSet());
    assertFalse(actualPdfTreeCellRenderer.isPreferredSizeSet());
    assertFalse(actualPdfTreeCellRenderer.isFocusCycleRoot());
    assertFalse(actualPdfTreeCellRenderer.isFocusTraversalPolicyProvider());
    assertFalse(actualPdfTreeCellRenderer.getAutoscrolls());
    assertTrue(actualPdfTreeCellRenderer.getFocusTraversalKeysEnabled());
    ComponentOrientation componentOrientation = actualPdfTreeCellRenderer.getComponentOrientation();
    assertTrue(componentOrientation.isHorizontal());
    assertTrue(componentOrientation.isLeftToRight());
    assertTrue(actualPdfTreeCellRenderer.getVerifyInputWhenFocusTarget());
    Color foreground = actualPdfTreeCellRenderer.getForeground();
    assertEquals(foreground, actualPdfTreeCellRenderer.getTextSelectionColor());
    assertSame(foreground, actualPdfTreeCellRenderer.getTextNonSelectionColor());
    Icon expectedLeafIcon = actualPdfTreeCellRenderer.getDefaultLeafIcon();
    assertSame(expectedLeafIcon, actualPdfTreeCellRenderer.getLeafIcon());
    Icon expectedOpenIcon = actualPdfTreeCellRenderer.getDefaultOpenIcon();
    assertSame(expectedOpenIcon, actualPdfTreeCellRenderer.getOpenIcon());
    assertSame(colorSpace, brighterResult3.getColorSpace());
    assertSame(colorSpace, brighterResult5.getColorSpace());
    assertSame(colorSpace, brighterResult4.getColorSpace());
    assertSame(colorSpace, brighterResult.getColorSpace());
    assertSame(colorSpace, brighterResult2.getColorSpace());
    assertSame(colorSpace, darkerResult7.getColorSpace());
    assertSame(colorSpace, darkerResult2.getColorSpace());
    assertSame(colorSpace, darkerResult8.getColorSpace());
    assertSame(colorSpace, darkerResult4.getColorSpace());
    assertSame(colorSpace, darkerResult5.getColorSpace());
    assertSame(colorSpace, darkerResult6.getColorSpace());
    assertSame(colorSpace, darkerResult3.getColorSpace());
    assertSame(colorSpace, darkerResult.getColorSpace());
    assertSame(colorSpace, backgroundSelectionColor.getColorSpace());
    assertSame(colorSpace, borderSelectionColor.getColorSpace());
  }
}
