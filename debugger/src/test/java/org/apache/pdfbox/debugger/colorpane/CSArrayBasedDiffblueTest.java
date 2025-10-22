package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_givenCOSArray_whenCOSArrayAddCOSArray() {
    // Arrange
    COSArray array = new COSArray();
    array.add((COSBase) new COSArray());

    // Act and Assert
    Component panel = (new CSArrayBased(array)).getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("First element in colorspace array must be a name", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(432, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(432, size.width);
    assertEquals(432.0d, maximumSize.getWidth());
    assertEquals(432.0d, size.getWidth());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArray array = new COSArray();
    COSArray object = new COSArray();
    array.add((COSBase) new COSObject(object, new COSObjectKey(1L, 1)));

    // Act and Assert
    Component panel = (new CSArrayBased(array)).getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("First element in colorspace array must be a name", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(432, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(432, size.width);
    assertEquals(432.0d, maximumSize.getWidth());
    assertEquals(432.0d, size.getWidth());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_thenReturnFirstElementTextIsColorspaceArrayIsEmpty() {
    // Arrange, Act and Assert
    Component panel = (new CSArrayBased(new COSArray())).getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("Colorspace array is empty", ((JLabel) component).getText());
    assertEquals(0.4977778f, panel.getAlignmentX());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(225, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(225, size.width);
    assertEquals(225.0d, maximumSize.getWidth());
    assertEquals(225.0d, size.getWidth());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then Panel Layout return {@link BoxLayout}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); when 'null'; then Panel Layout return BoxLayout")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_whenNull_thenPanelLayoutReturnBoxLayout() {
    // Arrange, Act and Assert
    Component panel = (new CSArrayBased(null)).getPanel();
    assertTrue(((JPanel) panel).getLayout() instanceof BoxLayout);
    assertTrue(panel instanceof JPanel);
  }

  /**
   * Test {@link CSArrayBased#getPanel()}.
   * <p>
   * Method under test: {@link CSArrayBased#getPanel()}
   */
  @Test
  @DisplayName("Test getPanel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Component CSArrayBased.getPanel()"})
  void testGetPanel() {
    // Arrange, Act and Assert
    assertTrue((new CSArrayBased(new COSArray())).getPanel() instanceof JPanel);
  }
}
