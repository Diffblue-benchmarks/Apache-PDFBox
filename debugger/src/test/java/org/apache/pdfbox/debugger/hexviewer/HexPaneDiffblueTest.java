package org.apache.pdfbox.debugger.hexviewer;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HexPaneDiffblueTest {
  /**
   * Method under test: {@link HexPane#keyTyped(KeyEvent)}
   */
  @Test
  void testKeyTyped() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());
    HexPane hexPane = new HexPane(model);

    // Act
    hexPane.keyTyped(new KeyEvent(new Canvas(), 1, 1L, 1, 1));

    // Assert that nothing has changed
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }

  /**
   * Method under test: {@link HexPane#keyPressed(KeyEvent)}
   */
  @Test
  void testKeyPressed() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());
    HexPane hexPane = new HexPane(model);

    // Act
    hexPane.keyPressed(new KeyEvent(new Canvas(), 1, 1L, 1, 1));

    // Assert that nothing has changed
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }

  /**
   * Method under test: {@link HexPane#mouseClicked(MouseEvent)}
   */
  @Test
  void testMouseClicked() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());
    HexPane hexPane = new HexPane(model);

    // Act
    hexPane.mouseClicked(new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true));

    // Assert
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }

  /**
   * Method under test: {@link HexPane#setSelected(int)}
   */
  @Test
  void testSetSelected() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());

    // Act
    (new HexPane(model)).setSelected(1);

    // Assert
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }

  /**
   * Method under test: {@link HexPane#setSelected(int)}
   */
  @Test
  void testSetSelected2() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());

    // Act
    (new HexPane(model)).setSelected(-1);

    // Assert that nothing has changed
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }

  /**
   * Method under test: {@link HexPane#setSelected(int)}
   */
  @Test
  void testSetSelected3() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());

    // Act
    (new HexPane(model)).setSelected(Short.SIZE);

    // Assert
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }

  /**
   * Method under test: {@link HexPane#hexModelChanged(HexModelChangedEvent)}
   */
  @Test
  void testHexModelChanged() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());
    HexPane hexPane = new HexPane(model);

    // Act
    hexPane.hexModelChanged(new HexModelChangedEvent(1, 1));

    // Assert that nothing has changed
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }
}
