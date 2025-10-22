package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HexPaneDiffblueTest {
  /**
   * Test {@link HexPane#HexPane(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize Size Size Size {@link Dimension#height} is forty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#HexPane(HexModel)}
   */
  @Test
  @DisplayName("Test new HexPane(HexModel); then return PreferredSize Size Size Size height is forty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexPane.<init>(HexModel)"})
  void testNewHexPane_thenReturnPreferredSizeSizeSizeSizeHeightIsForty() throws UnsupportedEncodingException {
    // Arrange and Act
    HexPane actualHexPane = new HexPane(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    ColorModel colorModel = actualHexPane.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Dimension preferredSize = actualHexPane.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(40, size2.getSize().height);
    assertEquals(40, size2.height);
    assertEquals(40, size.height);
    assertEquals(40, preferredSize.height);
    assertEquals(40.0d, size2.getHeight());
    assertEquals(40.0d, size.getHeight());
    assertEquals(40.0d, preferredSize.getHeight());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link HexPane#HexPane(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize Size Size Size {@link Dimension#height} is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#HexPane(HexModel)}
   */
  @Test
  @DisplayName("Test new HexPane(HexModel); then return PreferredSize Size Size Size height is twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexPane.<init>(HexModel)"})
  void testNewHexPane_thenReturnPreferredSizeSizeSizeSizeHeightIsTwenty() {
    // Arrange and Act
    HexPane actualHexPane = new HexPane(new HexModel(new byte[]{}));

    // Assert
    ColorModel colorModel = actualHexPane.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Dimension preferredSize = actualHexPane.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(20, size2.getSize().height);
    assertEquals(20, size2.height);
    assertEquals(20, size.height);
    assertEquals(20, preferredSize.height);
    assertEquals(20.0d, size2.getHeight());
    assertEquals(20.0d, size.getHeight());
    assertEquals(20.0d, preferredSize.getHeight());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link HexPane#mouseClicked(MouseEvent)}.
   * <ul>
   *   <li>Then calls {@link SelectionChangeListener#selectionChanged(SelectEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#mouseClicked(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseClicked(MouseEvent); then calls selectionChanged(SelectEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HexPane.mouseClicked(MouseEvent)"})
  void testMouseClicked_thenCallsSelectionChanged() throws UnsupportedEncodingException {
    // Arrange
    SelectionChangeListener listener = mock(SelectionChangeListener.class);
    doNothing().when(listener).selectionChanged(Mockito.<SelectEvent>any());

    HexPane hexPane = new HexPane(new HexModel("AXAXAXAX".getBytes("UTF-8")));
    hexPane.addSelectionChangeListener(listener);

    // Act
    hexPane.mouseClicked(new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true));

    // Assert
    verify(listener).selectionChanged(isA(SelectEvent.class));
  }

  /**
   * Test {@link HexPane#mouseClicked(MouseEvent)}.
   * <ul>
   *   <li>Then calls {@link SelectionChangeListener#selectionChanged(SelectEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#mouseClicked(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseClicked(MouseEvent); then calls selectionChanged(SelectEvent)")
  @Tag("MaintainedByDiffblue")
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

    // Act
    hexPane.mouseClicked(new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true));

    // Assert
    verify(listener2).selectionChanged(isA(SelectEvent.class));
    verify(listener).selectionChanged(isA(SelectEvent.class));
  }
}
