package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HexModelDiffblueTest {
  /**
   * Test {@link HexModel#HexModel(byte[])}.
   * <p>
   * Method under test: {@link HexModel#HexModel(byte[])}
   */
  @Test
  @DisplayName("Test new HexModel(byte[])")
  void testNewHexModel() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(8, (new HexModel("AXAXAXAX".getBytes("UTF-8"))).size());
  }

  /**
   * Test {@link HexModel#getByte(int)}.
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is {@code AXAXAXAX}
   * Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#getByte(int)}
   */
  @Test
  @DisplayName("Test getByte(int); given HexModel(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'; then return 'X'")
  void testGetByte_givenHexModelWithBytesIsAxaxaxaxBytesIsUtf8_thenReturnX() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals('X', (new HexModel("AXAXAXAX".getBytes("UTF-8"))).getByte(1));
  }

  /**
   * Test {@link HexModel#getLineChars(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When two.</li>
   *   <li>Then return {@code A.A.A.A.} toCharArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  @DisplayName("Test getLineChars(int); given 'A'; when two; then return 'A.A.A.A.' toCharArray")
  void testGetLineChars_givenA_whenTwo_thenReturnAAAAToCharArray() {
    // Arrange and Act
    char[] actualLineChars = (new HexModel(
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
        .getLineChars(2);

    // Assert
    assertArrayEquals("A.A.A.A.".toCharArray(), actualLineChars);
  }

  /**
   * Test {@link HexModel#getLineChars(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When two.</li>
   *   <li>Then return {@code ..A.A.A.} toCharArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  @DisplayName("Test getLineChars(int); given 'A'; when two; then return '..A.A.A.' toCharArray")
  void testGetLineChars_givenA_whenTwo_thenReturnAAAToCharArray() {
    // Arrange and Act
    char[] actualLineChars = (new HexModel(
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, -1, 1, 'A', 1, 'A', 1, 'A', 1}))
        .getLineChars(2);

    // Assert
    assertArrayEquals("..A.A.A.".toCharArray(), actualLineChars);
  }

  /**
   * Test {@link HexModel#getLineChars(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When two.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  @DisplayName("Test getLineChars(int); given 'A'; when two; then return array length is zero")
  void testGetLineChars_givenA_whenTwo_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new HexModel(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
        .getLineChars(2).length);
  }

  /**
   * Test {@link HexModel#getBytesForLine(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When two.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#getBytesForLine(int)}
   */
  @Test
  @DisplayName("Test getBytesForLine(int); given 'A'; when two; then return array length is zero")
  void testGetBytesForLine_givenA_whenTwo_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new HexModel(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
        .getBytesForLine(2).length);
  }

  /**
   * Test {@link HexModel#getBytesForLine(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When two.</li>
   *   <li>Then return array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#getBytesForLine(int)}
   */
  @Test
  @DisplayName("Test getBytesForLine(int); given 'A'; when two; then return array of byte with 'A' and one")
  void testGetBytesForLine_givenA_whenTwo_thenReturnArrayOfByteWithAAndOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        (new HexModel(
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}))
            .getBytesForLine(2));
  }

  /**
   * Test {@link HexModel#size()}.
   * <p>
   * Method under test: {@link HexModel#size()}
   */
  @Test
  @DisplayName("Test size()")
  void testSize() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(8, (new HexModel("AXAXAXAX".getBytes("UTF-8"))).size());
  }

  /**
   * Test {@link HexModel#totalLine()}.
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is {@code AXAXAXAX}
   * Bytes is {@code UTF-8}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#totalLine()}
   */
  @Test
  @DisplayName("Test totalLine(); given HexModel(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'; then return one")
  void testTotalLine_givenHexModelWithBytesIsAxaxaxaxBytesIsUtf8_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, (new HexModel("AXAXAXAX".getBytes("UTF-8"))).totalLine());
  }

  /**
   * Test {@link HexModel#totalLine()}.
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is empty array of
   * {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#totalLine()}
   */
  @Test
  @DisplayName("Test totalLine(); given HexModel(byte[]) with bytes is empty array of byte; then return zero")
  void testTotalLine_givenHexModelWithBytesIsEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new HexModel(new byte[]{})).totalLine());
  }

  /**
   * Test {@link HexModel#lineNumber(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#lineNumber(int)}
   */
  @Test
  @DisplayName("Test lineNumber(int); when minus one; then return zero")
  void testLineNumber_whenMinusOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, HexModel.lineNumber(-1));
  }

  /**
   * Test {@link HexModel#lineNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#lineNumber(int)}
   */
  @Test
  @DisplayName("Test lineNumber(int); when one; then return one")
  void testLineNumber_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, HexModel.lineNumber(1));
  }

  /**
   * Test {@link HexModel#elementIndexInLine(int)}.
   * <p>
   * Method under test: {@link HexModel#elementIndexInLine(int)}
   */
  @Test
  @DisplayName("Test elementIndexInLine(int)")
  void testElementIndexInLine() {
    // Arrange, Act and Assert
    assertEquals(1, HexModel.elementIndexInLine(1));
  }

  /**
   * Test {@link HexModel#updateModel(int, byte)}.
   * <ul>
   *   <li>Then calls
   * {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#updateModel(int, byte)}
   */
  @Test
  @DisplayName("Test updateModel(int, byte); then calls hexModelChanged(HexModelChangedEvent)")
  void testUpdateModel_thenCallsHexModelChanged() throws UnsupportedEncodingException {
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
   * Test {@link HexModel#updateModel(int, byte)}.
   * <ul>
   *   <li>Then calls
   * {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#updateModel(int, byte)}
   */
  @Test
  @DisplayName("Test updateModel(int, byte); then calls hexModelChanged(HexModelChangedEvent)")
  void testUpdateModel_thenCallsHexModelChanged2() throws UnsupportedEncodingException {
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
   * Test {@link HexModel#hexChanged(HexChangedEvent)}.
   * <ul>
   *   <li>Then calls
   * {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  @DisplayName("Test hexChanged(HexChangedEvent); then calls hexModelChanged(HexModelChangedEvent)")
  void testHexChanged_thenCallsHexModelChanged() throws UnsupportedEncodingException {
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
   * Test {@link HexModel#hexChanged(HexChangedEvent)}.
   * <ul>
   *   <li>Then calls
   * {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  @DisplayName("Test hexChanged(HexChangedEvent); then calls hexModelChanged(HexModelChangedEvent)")
  void testHexChanged_thenCallsHexModelChanged2() throws UnsupportedEncodingException {
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
   * Test {@link HexModel#hexChanged(HexChangedEvent)}.
   * <ul>
   *   <li>When {@link HexChangedEvent#HexChangedEvent(byte, int)} with newValue is
   * {@code A} and byteIndex is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  @DisplayName("Test hexChanged(HexChangedEvent); when HexChangedEvent(byte, int) with newValue is 'A' and byteIndex is minus one")
  void testHexChanged_whenHexChangedEventWithNewValueIsAAndByteIndexIsMinusOne() throws UnsupportedEncodingException {
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
}
