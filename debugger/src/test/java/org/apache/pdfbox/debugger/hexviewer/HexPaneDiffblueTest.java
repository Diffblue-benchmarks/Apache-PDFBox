package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HexPaneDiffblueTest {
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
    MouseEvent mouseEvent = new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true);

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
    MouseEvent mouseEvent = new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true);

    // Act
    hexPane.mouseClicked(mouseEvent);

    // Assert
    verify(listener2).selectionChanged(isA(SelectEvent.class));
    verify(listener).selectionChanged(isA(SelectEvent.class));
  }
}
