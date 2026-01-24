package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HexEditorDiffblueTest {
  @InjectMocks private HexEditor hexEditor;

  @Mock private HexModel hexModel;

  /**
   * Test {@link HexEditor#HexEditor(HexModel)}.
   *
   * <ul>
   *   <li>Given {@link HexModel} {@link HexModel#totalLine()} return two.
   *   <li>Then return UIClassID is {@code PanelUI}.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#HexEditor(HexModel)}
   */
  @Test
  @DisplayName(
      "Test new HexEditor(HexModel); given HexModel totalLine() return two; then return UIClassID is 'PanelUI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.<init>(HexModel)"})
  void testNewHexEditor_givenHexModelTotalLineReturnTwo_thenReturnUIClassIDIsPanelUI() {
    // Arrange
    when(hexModel.totalLine()).thenReturn(2);
    doNothing().when(hexModel).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());

    // Act
    HexEditor actualHexEditor = new HexEditor(hexModel);

    // Assert
    verify(hexModel, atLeast(1)).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());
    verify(hexModel, atLeast(1)).totalLine();
    assertTrue(actualHexEditor.getLayout() instanceof GridBagLayout);
    assertTrue(actualHexEditor.getColorModel() instanceof DirectColorModel);
    assertEquals("PanelUI", actualHexEditor.getUIClassID());
    assertNull(actualHexEditor.getNextFocusableComponent());
    assertNull(actualHexEditor.getFocusCycleRootAncestor());
    assertNull(actualHexEditor.getParent());
    assertNull(actualHexEditor.getTopLevelAncestor());
    assertNull(actualHexEditor.getFocusTraversalPolicy());
    assertNull(actualHexEditor.getGraphics());
    assertNull(actualHexEditor.getGraphicsConfiguration());
    assertNull(actualHexEditor.getDropTarget());
    assertNull(actualHexEditor.getInputContext());
    assertNull(actualHexEditor.getInputMethodRequests());
    assertNull(actualHexEditor.getName());
    assertNull(actualHexEditor.getToolTipText());
    assertNull(actualHexEditor.getInputVerifier());
    assertNull(actualHexEditor.getComponentPopupMenu());
    assertNull(actualHexEditor.getRootPane());
    assertNull(actualHexEditor.getTransferHandler());
    assertNull(actualHexEditor.getBorder());
    assertEquals(0, actualHexEditor.getDebugGraphicsOptions());
    assertEquals(0, actualHexEditor.getHeight());
    assertEquals(0, actualHexEditor.getWidth());
    assertEquals(0, actualHexEditor.getX());
    assertEquals(0, actualHexEditor.getY());
    assertEquals(0, actualHexEditor.getComponentListeners().length);
    assertEquals(0, actualHexEditor.getFocusListeners().length);
    assertEquals(0, actualHexEditor.getHierarchyBoundsListeners().length);
    assertEquals(0, actualHexEditor.getHierarchyListeners().length);
    assertEquals(0, actualHexEditor.getInputMethodListeners().length);
    assertEquals(0, actualHexEditor.getKeyListeners().length);
    assertEquals(0, actualHexEditor.getMouseListeners().length);
    assertEquals(0, actualHexEditor.getMouseMotionListeners().length);
    assertEquals(0, actualHexEditor.getMouseWheelListeners().length);
    assertEquals(0, actualHexEditor.getPropertyChangeListeners().length);
    assertEquals(0, actualHexEditor.getContainerListeners().length);
    assertEquals(0, actualHexEditor.getAncestorListeners().length);
    assertEquals(0, actualHexEditor.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualHexEditor.getAlignmentX());
    assertEquals(0.5f, actualHexEditor.getAlignmentY());
    assertEquals(1, actualHexEditor.getRegisteredKeyStrokes().length);
    assertEquals(3, actualHexEditor.getComponentCount());
    assertEquals(3, actualHexEditor.getComponents().length);
    assertEquals(BaselineResizeBehavior.OTHER, actualHexEditor.getBaselineResizeBehavior());
    assertFalse(actualHexEditor.getIgnoreRepaint());
    assertFalse(actualHexEditor.hasFocus());
    assertFalse(actualHexEditor.isCursorSet());
    assertFalse(actualHexEditor.isDisplayable());
    assertFalse(actualHexEditor.isFocusOwner());
    assertFalse(actualHexEditor.isLightweight());
    assertFalse(actualHexEditor.isMaximumSizeSet());
    assertFalse(actualHexEditor.isMinimumSizeSet());
    assertFalse(actualHexEditor.isPreferredSizeSet());
    assertFalse(actualHexEditor.isShowing());
    assertFalse(actualHexEditor.isValid());
    assertFalse(actualHexEditor.isFocusCycleRoot());
    assertFalse(actualHexEditor.isFocusTraversalPolicyProvider());
    assertFalse(actualHexEditor.isFocusTraversalPolicySet());
    assertFalse(actualHexEditor.getAutoscrolls());
    assertFalse(actualHexEditor.getInheritsPopupMenu());
    assertFalse(actualHexEditor.isManagingFocus());
    assertFalse(actualHexEditor.isPaintingForPrint());
    assertFalse(actualHexEditor.isPaintingTile());
    assertFalse(actualHexEditor.isValidateRoot());
    assertTrue(actualHexEditor.getFocusTraversalKeysEnabled());
    assertTrue(actualHexEditor.isBackgroundSet());
    assertTrue(actualHexEditor.isEnabled());
    assertTrue(actualHexEditor.isFocusable());
    assertTrue(actualHexEditor.isFontSet());
    assertTrue(actualHexEditor.isForegroundSet());
    assertTrue(actualHexEditor.isVisible());
    assertTrue(actualHexEditor.getVerifyInputWhenFocusTarget());
    assertTrue(actualHexEditor.isDoubleBuffered());
    assertTrue(actualHexEditor.isOpaque());
    assertTrue(actualHexEditor.isOptimizedDrawingEnabled());
    assertTrue(actualHexEditor.isRequestFocusEnabled());
  }

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
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName("Test selectionChanged(SelectEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged() {
    // Arrange
    when(hexModel.size()).thenReturn(3);

    // Act
    hexEditor.selectionChanged(new SelectEvent(1, "0123456789ABCDEF"));

    // Assert
    verify(hexModel).size();
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
   *   <li>Then third element MinimumSize {@link Dimension#width} is two hundred ten.
   * </ul>
   *
   * <p>Method under test: {@link HexEditor#selectionChanged(SelectEvent)}
   */
  @Test
  @DisplayName(
      "Test selectionChanged(SelectEvent); then third element MinimumSize width is two hundred ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexEditor.selectionChanged(SelectEvent)"})
  void testSelectionChanged_thenThirdElementMinimumSizeWidthIsTwoHundredTen() {
    // Arrange
    when(hexModel.size()).thenReturn(3739);

    // Act
    hexEditor.selectionChanged(new SelectEvent(-1, "down"));

    // Assert
    verify(hexModel).size();
    Component[] components = hexEditor.getComponents();
    Component component = components[2];
    assertTrue(component instanceof StatusPane);
    assertEquals(210, component.getMinimumSize().width);
    Dimension minimumSize = hexEditor.getMinimumSize();
    Dimension size = minimumSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(210, size2.getSize().width);
    assertEquals(210, size2.width);
    assertEquals(210, size.width);
    assertEquals(210, minimumSize.width);
    assertEquals(210.0d, size2.getWidth());
    assertEquals(210.0d, size.getWidth());
    assertEquals(210.0d, minimumSize.getWidth());
    assertEquals(3, components.length);
    assertEquals(386, component.getPreferredSize().width);
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
