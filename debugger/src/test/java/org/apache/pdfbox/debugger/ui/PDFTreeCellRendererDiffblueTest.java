package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.beans.VetoableChangeListener;
import java.io.IOException;
import javax.accessibility.AccessibleContext;
import javax.swing.Icon;
import javax.swing.JTree;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class PDFTreeCellRendererDiffblueTest {
  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(new JTree(), "Node Value", true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent2() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    pdfTreeCellRenderer.addVetoableChangeListener(mock(VetoableChangeListener.class));

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(new JTree(), "Node Value", true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent3() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(tree, arrayEntry, true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent4() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(tree, new ArrayEntry(), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent5() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(tree, COSBoolean.getBoolean(true), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent6() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(tree, new COSFloat(10.0f), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent7() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(tree, COSInteger.get(42L), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent8() throws IOException {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer, pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        COSString.parseHex("0123456789ABCDEF"), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent9() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(tree, new COSDictionary(), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent10() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer, pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        new DocumentEntry(new PDDocument(), "foo.txt"), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent11() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer, pdfTreeCellRenderer.getTreeCellRendererComponent(tree,
        new XrefEntries(new PDDocument()), true, true, true, 1, true));
  }

  /**
   * Method under test:
   * {@link PDFTreeCellRenderer#getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}
   */
  @Test
  void testGetTreeCellRendererComponent12() {
    // Arrange
    PDFTreeCellRenderer pdfTreeCellRenderer = new PDFTreeCellRenderer();
    JTree tree = new JTree();

    // Act and Assert
    assertSame(pdfTreeCellRenderer,
        pdfTreeCellRenderer.getTreeCellRendererComponent(tree, new COSString("Text"), true, true, true, 1, true));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PDFTreeCellRenderer}
   */
  @Test
  void testNewPDFTreeCellRenderer() {
    // Arrange and Act
    PDFTreeCellRenderer actualPdfTreeCellRenderer = new PDFTreeCellRenderer();

    // Assert
    Color backgroundNonSelectionColor = actualPdfTreeCellRenderer.getBackgroundNonSelectionColor();
    ColorSpace colorSpace = backgroundNonSelectionColor.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
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
    assertNull(actualPdfTreeCellRenderer.getBorder());
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
    assertEquals(1, darkerResult7.getTransparency());
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
