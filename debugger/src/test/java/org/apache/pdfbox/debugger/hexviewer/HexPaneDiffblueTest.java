package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HexPaneDiffblueTest {
  @Mock private HexModel hexModel;

  /**
   * Test {@link HexPane#HexPane(HexModel)}.
   *
   * <ul>
   *   <li>Given {@link HexModel} {@link HexModel#totalLine()} return two.
   *   <li>Then Layout return {@link FlowLayout}.
   * </ul>
   *
   * <p>Method under test: {@link HexPane#HexPane(HexModel)}
   */
  @Test
  @DisplayName(
      "Test new HexPane(HexModel); given HexModel totalLine() return two; then Layout return FlowLayout")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexPane.<init>(HexModel)"})
  void testNewHexPane_givenHexModelTotalLineReturnTwo_thenLayoutReturnFlowLayout() {
    // Arrange
    when(hexModel.totalLine()).thenReturn(2);
    doNothing().when(hexModel).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());

    // Act
    HexPane actualHexPane = new HexPane(hexModel);

    // Assert
    verify(hexModel).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(hexModel).totalLine();
    assertTrue(actualHexPane.getLayout() instanceof FlowLayout);
    assertTrue(actualHexPane.getColorModel() instanceof DirectColorModel);
    assertEquals("PanelUI", actualHexPane.getUIClassID());
    assertNull(actualHexPane.getNextFocusableComponent());
    assertNull(actualHexPane.getFocusCycleRootAncestor());
    assertNull(actualHexPane.getParent());
    assertNull(actualHexPane.getTopLevelAncestor());
    assertNull(actualHexPane.getFocusTraversalPolicy());
    assertNull(actualHexPane.getGraphics());
    assertNull(actualHexPane.getGraphicsConfiguration());
    assertNull(actualHexPane.getDropTarget());
    assertNull(actualHexPane.getInputContext());
    assertNull(actualHexPane.getInputMethodRequests());
    assertNull(actualHexPane.getName());
    assertNull(actualHexPane.getToolTipText());
    assertNull(actualHexPane.getInputVerifier());
    assertNull(actualHexPane.getComponentPopupMenu());
    assertNull(actualHexPane.getRootPane());
    assertNull(actualHexPane.getTransferHandler());
    assertNull(actualHexPane.getBorder());
    assertEquals(0, actualHexPane.getComponentCount());
    assertEquals(0, actualHexPane.getDebugGraphicsOptions());
    assertEquals(0, actualHexPane.getHeight());
    assertEquals(0, actualHexPane.getWidth());
    assertEquals(0, actualHexPane.getX());
    assertEquals(0, actualHexPane.getY());
    assertEquals(0, actualHexPane.getComponentListeners().length);
    assertEquals(0, actualHexPane.getFocusListeners().length);
    assertEquals(0, actualHexPane.getHierarchyBoundsListeners().length);
    assertEquals(0, actualHexPane.getHierarchyListeners().length);
    assertEquals(0, actualHexPane.getInputMethodListeners().length);
    assertEquals(0, actualHexPane.getMouseWheelListeners().length);
    assertEquals(0, actualHexPane.getPropertyChangeListeners().length);
    assertEquals(0, actualHexPane.getComponents().length);
    assertEquals(0, actualHexPane.getContainerListeners().length);
    assertEquals(0, actualHexPane.getAncestorListeners().length);
    assertEquals(0, actualHexPane.getRegisteredKeyStrokes().length);
    assertEquals(0, actualHexPane.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualHexPane.getAlignmentX());
    assertEquals(0.5f, actualHexPane.getAlignmentY());
    assertEquals(1, actualHexPane.getKeyListeners().length);
    assertEquals(1, actualHexPane.getMouseListeners().length);
    assertEquals(1, actualHexPane.getMouseMotionListeners().length);
    assertEquals(BaselineResizeBehavior.OTHER, actualHexPane.getBaselineResizeBehavior());
    assertFalse(actualHexPane.getIgnoreRepaint());
    assertFalse(actualHexPane.hasFocus());
    assertFalse(actualHexPane.isCursorSet());
    assertFalse(actualHexPane.isDisplayable());
    assertFalse(actualHexPane.isFocusOwner());
    assertFalse(actualHexPane.isLightweight());
    assertFalse(actualHexPane.isMaximumSizeSet());
    assertFalse(actualHexPane.isMinimumSizeSet());
    assertFalse(actualHexPane.isShowing());
    assertFalse(actualHexPane.isValid());
    assertFalse(actualHexPane.isFocusCycleRoot());
    assertFalse(actualHexPane.isFocusTraversalPolicyProvider());
    assertFalse(actualHexPane.isFocusTraversalPolicySet());
    assertFalse(actualHexPane.getInheritsPopupMenu());
    assertFalse(actualHexPane.isManagingFocus());
    assertFalse(actualHexPane.isPaintingForPrint());
    assertFalse(actualHexPane.isPaintingTile());
    assertFalse(actualHexPane.isValidateRoot());
    assertTrue(actualHexPane.getFocusTraversalKeysEnabled());
    assertTrue(actualHexPane.isBackgroundSet());
    assertTrue(actualHexPane.isEnabled());
    assertTrue(actualHexPane.isFocusable());
    assertTrue(actualHexPane.isFontSet());
    assertTrue(actualHexPane.isForegroundSet());
    assertTrue(actualHexPane.isPreferredSizeSet());
    assertTrue(actualHexPane.isVisible());
    assertTrue(actualHexPane.getAutoscrolls());
    assertTrue(actualHexPane.getVerifyInputWhenFocusTarget());
    assertTrue(actualHexPane.isDoubleBuffered());
    assertTrue(actualHexPane.isOpaque());
    assertTrue(actualHexPane.isOptimizedDrawingEnabled());
    assertTrue(actualHexPane.isRequestFocusEnabled());
  }

  /**
   * Test {@link HexPane#HexPane(HexModel)}.
   *
   * <ul>
   *   <li>When {@link HexModel#HexModel(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link HexPane#HexPane(HexModel)}
   */
  @Test
  @DisplayName(
      "Test new HexPane(HexModel); when HexModel(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexPane.<init>(HexModel)"})
  void testNewHexPane_whenHexModelWithBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    HexPane actualHexPane = new HexPane(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertTrue(actualHexPane.getColorModel() instanceof DirectColorModel);
    assertEquals(1, actualHexPane.getKeyListeners().length);
    assertEquals(1, actualHexPane.getMouseListeners().length);
    assertEquals(1, actualHexPane.getMouseMotionListeners().length);
  }

  /**
   * Test {@link HexPane#HexPane(HexModel)}.
   *
   * <ul>
   *   <li>When {@link HexModel#HexModel(byte[])} with bytes is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link HexPane#HexPane(HexModel)}
   */
  @Test
  @DisplayName(
      "Test new HexPane(HexModel); when HexModel(byte[]) with bytes is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexPane.<init>(HexModel)"})
  void testNewHexPane_whenHexModelWithBytesIsEmptyArrayOfByte() {
    // Arrange
    HexModel model = new HexModel(new byte[] {});

    // Act
    HexPane actualHexPane = new HexPane(model);

    // Assert
    assertTrue(actualHexPane.getColorModel() instanceof DirectColorModel);
    assertEquals(1, actualHexPane.getKeyListeners().length);
    assertEquals(1, actualHexPane.getMouseListeners().length);
    assertEquals(1, actualHexPane.getMouseMotionListeners().length);
  }

  /**
   * Test {@link HexPane#mouseClicked(MouseEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectionChangeListener#selectionChanged(SelectEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link HexPane#mouseClicked(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseClicked(MouseEvent); then calls selectionChanged(SelectEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexPane.mouseClicked(MouseEvent)"})
  void testMouseClicked_thenCallsSelectionChanged() throws UnsupportedEncodingException {
    // Arrange
    SelectionChangeListener listener = mock(SelectionChangeListener.class);
    doNothing().when(listener).selectionChanged(Mockito.<SelectEvent>any());

    HexPane hexPane = new HexPane(new HexModel("AXAXAXAX".getBytes("UTF-8")));
    hexPane.addSelectionChangeListener(listener);
    MouseEvent mouseEvent = new MouseEvent(new Canvas(), 1, 1L, 1, 2, 3, 3, true);

    // Act
    hexPane.mouseClicked(mouseEvent);

    // Assert
    verify(listener).selectionChanged(isA(SelectEvent.class));
  }

  /**
   * Test {@link HexPane#mouseClicked(MouseEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectionChangeListener#selectionChanged(SelectEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link HexPane#mouseClicked(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseClicked(MouseEvent); then calls selectionChanged(SelectEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexPane.mouseClicked(MouseEvent)"})
  void testMouseClicked_thenCallsSelectionChanged2() throws UnsupportedEncodingException {
    // Arrange
    SelectionChangeListener listener = mock(SelectionChangeListener.class);
    doNothing().when(listener).selectionChanged(Mockito.<SelectEvent>any());

    SelectionChangeListener listener2 = mock(SelectionChangeListener.class);
    doNothing().when(listener2).selectionChanged(Mockito.<SelectEvent>any());

    HexPane hexPane = new HexPane(new HexModel("AXAXAXAX".getBytes("UTF-8")));
    hexPane.addSelectionChangeListener(listener2);
    hexPane.addSelectionChangeListener(listener);
    MouseEvent mouseEvent = new MouseEvent(new Canvas(), 1, 1L, 1, 2, 3, 3, true);

    // Act
    hexPane.mouseClicked(mouseEvent);

    // Assert
    verify(listener2).selectionChanged(isA(SelectEvent.class));
    verify(listener).selectionChanged(isA(SelectEvent.class));
  }
}
