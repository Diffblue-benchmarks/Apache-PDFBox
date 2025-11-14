package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CSArrayBasedDiffblueTest {
  @Mock private COSArray cOSArray;

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased() {
    // Arrange
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    when(cOSArray.get(anyInt())).thenReturn(cosObject);
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.INDEXED);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).get(1);
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
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
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased2() {
    // Arrange
    when(cOSArray.get(anyInt())).thenReturn(new COSDictionary());
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.INDEXED);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).get(1);
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(
        "Expected a name or array but got: COSDictionary{}", ((JLabel) component).getText());
    assertEquals(0.4988662f, panel.getAlignmentX());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(441, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(441, size.width);
    assertEquals(441.0d, maximumSize.getWidth());
    assertEquals(441.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased3() {
    // Arrange
    when(cOSArray.size()).thenReturn(1);
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.ICCBASED);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    verify(cOSArray).size();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(
        "ICCBased colorspace array must have two elements", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(432, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(432, size.width);
    assertEquals(432.0d, maximumSize.getWidth());
    assertEquals(432.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased4() {
    // Arrange
    when(cOSArray.size()).thenReturn(3);
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.ICCBASED);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray, atLeast(1)).getObject(anyInt());
    verify(cOSArray).isEmpty();
    verify(cOSArray).size();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(
        "ICCBased colorspace array must have a stream as second element",
        ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(558, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(558, size.width);
    assertEquals(558.0d, maximumSize.getWidth());
    assertEquals(558.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSName}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new CSArrayBased(COSArray); given COSArray getObject(int) return COSName; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_givenCOSArrayGetObjectReturnCOSName_thenCallsGetObject() {
    // Arrange
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(mock(COSName.class));

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    assertTrue(components[0] instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(1, components.length);
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#get(int)} return {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); given COSArray get(int) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_givenCOSArrayGetReturnCOSArray() {
    // Arrange
    when(cOSArray.get(anyInt())).thenReturn(new COSArray());
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.INDEXED);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).get(1);
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
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
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); given COSArray size() return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_givenCOSArraySizeReturnThree() {
    // Arrange
    when(cOSArray.size()).thenReturn(3);
    when(cOSArray.get(anyInt())).thenReturn(new COSArray());
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.PATTERN);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).get(1);
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    verify(cOSArray).size();
    Component panel = actualCsArrayBased.getPanel();
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
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSArray#COSArray()} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new CSArrayBased(COSArray); given COSObject(COSBase, COSObjectKey) with object is COSArray() and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_givenCOSObjectWithObjectIsCOSArrayAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSArray array = new COSArray();
    COSArray object = new COSArray();
    COSObject object2 = new COSObject(object, new COSObjectKey(1L, 1));
    array.add((COSBase) object2);

    // Act and Assert
    Component panel = new CSArrayBased(array).getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(
        "First element in colorspace array must be a name", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(432, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(432, size.width);
    assertEquals(432.0d, maximumSize.getWidth());
    assertEquals(432.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Then return first element Text is a string.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); then return first element Text is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_thenReturnFirstElementTextIsAString() {
    // Arrange
    when(cOSArray.get(anyInt())).thenReturn(new COSStream());
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.INDEXED);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).get(1);
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(
        "Expected a name or array but got: COSDictionary{Create InputStream called without data being written"
            + " before to stream.}",
        ((JLabel) component).getText());
    assertEquals(0.49953315f, panel.getAlignmentX());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(1071, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(1071, size.width);
    assertEquals(1071.0d, maximumSize.getWidth());
    assertEquals(1071.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Then return first element Text is {@code Unknown color space: DeviceN}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new CSArrayBased(COSArray); then return first element Text is 'Unknown color space: DeviceN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_thenReturnFirstElementTextIsUnknownColorSpaceDeviceN() {
    // Arrange
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.DEVICEN);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray, atLeast(1)).getObject(anyInt());
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("Unknown color space: DeviceN", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(252, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(252, size.width);
    assertEquals(252.0d, maximumSize.getWidth());
    assertEquals(252.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Then return first element Text is {@code Unknown color space: Separation}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new CSArrayBased(COSArray); then return first element Text is 'Unknown color space: Separation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_thenReturnFirstElementTextIsUnknownColorSpaceSeparation() {
    // Arrange
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.SEPARATION);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray, atLeast(1)).getObject(anyInt());
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals("Unknown color space: Separation", ((JLabel) component).getText());
    assertEquals(0.4982079f, panel.getAlignmentX());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(279, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(279, size.width);
    assertEquals(279.0d, maximumSize.getWidth());
    assertEquals(279.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>Then second element return {@link JLabel}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); then second element return JLabel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_thenSecondElementReturnJLabel() {
    // Arrange
    when(cOSArray.isEmpty()).thenReturn(false);
    when(cOSArray.getObject(anyInt())).thenReturn(COSName.DEVICECMYK);

    // Act
    CSArrayBased actualCsArrayBased = new CSArrayBased(cOSArray);

    // Assert
    verify(cOSArray).getObject(0);
    verify(cOSArray).isEmpty();
    Component panel = actualCsArrayBased.getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    assertTrue(components[1] instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(2, ((JPanel) panel).getComponentCount());
    assertEquals(2, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(378, maximumSize.width);
    assertEquals(378.0d, maximumSize.getWidth());
    assertEquals(60, maximumSize.height);
    assertEquals(60.0d, maximumSize.getHeight());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_whenCOSArray() {
    // Arrange, Act and Assert
    Component panel = new CSArrayBased(new COSArray()).getPanel();
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
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); when COSArray() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_whenCOSArrayAddCOSArray() {
    // Arrange
    COSArray array = new COSArray();
    array.add((COSBase) new COSArray());

    // Act and Assert
    Component panel = new CSArrayBased(array).getPanel();
    ColorModel colorModel = panel.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Component[] components = ((JPanel) panel).getComponents();
    Component component = components[0];
    assertTrue(component instanceof JLabel);
    assertTrue(panel instanceof JPanel);
    assertEquals(
        "First element in colorspace array must be a name", ((JLabel) component).getText());
    assertEquals(1, components.length);
    Dimension maximumSize = panel.getMaximumSize();
    assertEquals(432, maximumSize.width);
    Dimension size = maximumSize.getSize();
    assertEquals(432, size.width);
    assertEquals(432.0d, maximumSize.getWidth());
    assertEquals(432.0d, size.getWidth());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link CSArrayBased#CSArrayBased(COSArray)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Panel Layout return {@link BoxLayout}.
   * </ul>
   *
   * <p>Method under test: {@link CSArrayBased#CSArrayBased(COSArray)}
   */
  @Test
  @DisplayName("Test new CSArrayBased(COSArray); when 'null'; then Panel Layout return BoxLayout")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSArrayBased.<init>(COSArray)"})
  void testNewCSArrayBased_whenNull_thenPanelLayoutReturnBoxLayout() {
    // Arrange, Act and Assert
    Component panel = new CSArrayBased(null).getPanel();
    assertTrue(((JPanel) panel).getLayout() instanceof BoxLayout);
    assertTrue(panel instanceof JPanel);
  }

  /**
   * Test {@link CSArrayBased#getPanel()}.
   *
   * <p>Method under test: {@link CSArrayBased#getPanel()}
   */
  @Test
  @DisplayName("Test getPanel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component CSArrayBased.getPanel()"})
  void testGetPanel() {
    // Arrange, Act and Assert
    assertTrue(new CSArrayBased(new COSArray()).getPanel() instanceof JPanel);
  }
}
