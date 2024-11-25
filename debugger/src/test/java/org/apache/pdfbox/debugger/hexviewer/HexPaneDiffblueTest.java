package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HexPaneDiffblueTest {
  /**
   * Test {@link HexPane#HexPane(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize Size Size Size {@link Dimension#height} is
   * forty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#HexPane(HexModel)}
   */
  @Test
  @DisplayName("Test new HexPane(HexModel); then return PreferredSize Size Size Size height is forty")
  void testNewHexPane_thenReturnPreferredSizeSizeSizeSizeHeightIsForty() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Dimension preferredSize = (new HexPane(new HexModel("AXAXAXAX".getBytes("UTF-8")))).getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(40, size2.getSize().height);
    assertEquals(40, size2.height);
    assertEquals(40, size.height);
    assertEquals(40, preferredSize.height);
    assertEquals(40.0d, size2.getHeight());
    assertEquals(40.0d, size.getHeight());
    assertEquals(40.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link HexPane#HexPane(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize Size Size Size {@link Dimension#height} is
   * twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#HexPane(HexModel)}
   */
  @Test
  @DisplayName("Test new HexPane(HexModel); then return PreferredSize Size Size Size height is twenty")
  void testNewHexPane_thenReturnPreferredSizeSizeSizeSizeHeightIsTwenty() {
    // Arrange, Act and Assert
    Dimension preferredSize = (new HexPane(new HexModel(new byte[]{}))).getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    assertEquals(20, size2.getSize().height);
    assertEquals(20, size2.height);
    assertEquals(20, size.height);
    assertEquals(20, preferredSize.height);
    assertEquals(20.0d, size2.getHeight());
    assertEquals(20.0d, size.getHeight());
    assertEquals(20.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link HexPane#mouseClicked(MouseEvent)}.
   * <ul>
   *   <li>Then calls
   * {@link SelectionChangeListener#selectionChanged(SelectEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#mouseClicked(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseClicked(MouseEvent); then calls selectionChanged(SelectEvent)")
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
   *   <li>Then calls
   * {@link SelectionChangeListener#selectionChanged(SelectEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexPane#mouseClicked(MouseEvent)}
   */
  @Test
  @DisplayName("Test mouseClicked(MouseEvent); then calls selectionChanged(SelectEvent)")
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
