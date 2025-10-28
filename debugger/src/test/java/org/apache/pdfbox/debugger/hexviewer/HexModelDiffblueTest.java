package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HexModelDiffblueTest {
  /**
   * Method under test: {@link HexModel#getByte(int)}
   */
  @Test
  void testGetByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals('X', (new HexModel("AXAXAXAX".getBytes("UTF-8"))).getByte(1));
  }

  /**
   * Method under test: {@link HexModel#getByte(int)}
   */
  @Test
  void testGetByte2() throws UnsupportedEncodingException {
    // Arrange
    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(mock(HexModelChangeListener.class));

    // Act and Assert
    assertEquals('X', hexModel.getByte(1));
  }

  /**
   * Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  void testGetLineChars() {
    // Arrange, Act and Assert
    assertEquals(0, (new HexModel(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
        .getLineChars(2).length);
  }

  /**
   * Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  void testGetLineChars2() {
    // Arrange and Act
    char[] actualLineChars = (new HexModel(
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
            .getLineChars(2);

    // Assert
    assertArrayEquals("A.A.A.A.".toCharArray(), actualLineChars);
  }

  /**
   * Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  void testGetLineChars3() {
    // Arrange and Act
    char[] actualLineChars = (new HexModel(
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, -1, 1, 'A', 1, 'A', 1, 'A', 1}))
            .getLineChars(2);

    // Assert
    assertArrayEquals("..A.A.A.".toCharArray(), actualLineChars);
  }

  /**
   * Method under test: {@link HexModel#getBytesForLine(int)}
   */
  @Test
  void testGetBytesForLine() {
    // Arrange, Act and Assert
    assertEquals(0, (new HexModel(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
        .getBytesForLine(2).length);
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        (new HexModel(
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
                .getBytesForLine(2));
  }

  /**
   * Method under test: {@link HexModel#size()}
   */
  @Test
  void testSize() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(8, (new HexModel("AXAXAXAX".getBytes("UTF-8"))).size());
  }

  /**
   * Method under test: {@link HexModel#size()}
   */
  @Test
  void testSize2() throws UnsupportedEncodingException {
    // Arrange
    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(mock(HexModelChangeListener.class));

    // Act and Assert
    assertEquals(8, hexModel.size());
  }

  /**
   * Method under test: {@link HexModel#totalLine()}
   */
  @Test
  void testTotalLine() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, (new HexModel("AXAXAXAX".getBytes("UTF-8"))).totalLine());
    assertEquals(0, (new HexModel(new byte[]{})).totalLine());
  }

  /**
   * Method under test: {@link HexModel#totalLine()}
   */
  @Test
  void testTotalLine2() throws UnsupportedEncodingException {
    // Arrange
    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(mock(HexModelChangeListener.class));

    // Act and Assert
    assertEquals(1, hexModel.totalLine());
  }

  /**
   * Method under test: {@link HexModel#lineNumber(int)}
   */
  @Test
  void testLineNumber() {
    // Arrange, Act and Assert
    assertEquals(1, HexModel.lineNumber(1));
    assertEquals(0, HexModel.lineNumber(-1));
  }

  /**
   * Method under test: {@link HexModel#elementIndexInLine(int)}
   */
  @Test
  void testElementIndexInLine() {
    // Arrange, Act and Assert
    assertEquals(1, HexModel.elementIndexInLine(1));
  }

  /**
   * Method under test: {@link HexModel#updateModel(int, byte)}
   */
  @Test
  void testUpdateModel() throws UnsupportedEncodingException {
    // Arrange
    HexModelChangeListener listener = mock(HexModelChangeListener.class);
    doNothing().when(listener).hexModelChanged(Mockito.<HexModelChangedEvent>any());

    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(listener);

    // Act
    hexModel.updateModel(1, (byte) 'A');

    // Assert
    verify(listener).hexModelChanged(isA(HexModelChangedEvent.class));
  }

  /**
   * Method under test: {@link HexModel#updateModel(int, byte)}
   */
  @Test
  void testUpdateModel2() throws UnsupportedEncodingException {
    // Arrange
    HexModelChangeListener listener = mock(HexModelChangeListener.class);
    doNothing().when(listener).hexModelChanged(Mockito.<HexModelChangedEvent>any());
    HexModelChangeListener listener2 = mock(HexModelChangeListener.class);
    doNothing().when(listener2).hexModelChanged(Mockito.<HexModelChangedEvent>any());

    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(listener2);
    hexModel.addHexModelChangeListener(listener);

    // Act
    hexModel.updateModel(1, (byte) 'A');

    // Assert
    verify(listener2).hexModelChanged(isA(HexModelChangedEvent.class));
    verify(listener).hexModelChanged(isA(HexModelChangedEvent.class));
  }

  /**
   * Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  void testHexChanged() throws UnsupportedEncodingException {
    // Arrange
    HexModelChangeListener listener = mock(HexModelChangeListener.class);
    doNothing().when(listener).hexModelChanged(Mockito.<HexModelChangedEvent>any());

    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(listener);

    // Act
    hexModel.hexChanged(new HexChangedEvent((byte) 'A', 1));

    // Assert
    verify(listener).hexModelChanged(isA(HexModelChangedEvent.class));
  }

  /**
   * Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  void testHexChanged2() throws UnsupportedEncodingException {
    // Arrange
    HexModelChangeListener listener = mock(HexModelChangeListener.class);
    doNothing().when(listener).hexModelChanged(Mockito.<HexModelChangedEvent>any());
    HexModelChangeListener listener2 = mock(HexModelChangeListener.class);
    doNothing().when(listener2).hexModelChanged(Mockito.<HexModelChangedEvent>any());

    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(listener2);
    hexModel.addHexModelChangeListener(listener);

    // Act
    hexModel.hexChanged(new HexChangedEvent((byte) 'A', 1));

    // Assert
    verify(listener2).hexModelChanged(isA(HexModelChangedEvent.class));
    verify(listener).hexModelChanged(isA(HexModelChangedEvent.class));
  }

  /**
   * Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  void testHexChanged3() throws UnsupportedEncodingException {
    // Arrange
    HexModelChangeListener listener = mock(HexModelChangeListener.class);
    doNothing().when(listener).hexModelChanged(Mockito.<HexModelChangedEvent>any());
    HexModelChangeListener listener2 = mock(HexModelChangeListener.class);
    doNothing().when(listener2).hexModelChanged(Mockito.<HexModelChangedEvent>any());

    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(listener2);
    hexModel.addHexModelChangeListener(listener);

    // Act
    hexModel.hexChanged(new HexChangedEvent((byte) 'A', -1));

    // Assert
    verify(listener2).hexModelChanged(isA(HexModelChangedEvent.class));
    verify(listener).hexModelChanged(isA(HexModelChangedEvent.class));
  }

  /**
   * Method under test: {@link HexModel#HexModel(byte[])}
   */
  @Test
  void testNewHexModel() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(8, (new HexModel("AXAXAXAX".getBytes("UTF-8"))).size());
  }
}
