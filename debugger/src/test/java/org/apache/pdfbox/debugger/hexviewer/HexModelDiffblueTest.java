package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HexModelDiffblueTest {
  /**
   * Test {@link HexModel#HexModel(byte[])}.
   *
   * <p>Method under test: {@link HexModel#HexModel(byte[])}
   */
  @Test
  @DisplayName("Test new HexModel(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexModel.<init>(byte[])"})
  void testNewHexModel() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(8, new HexModel("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link HexModel#getByte(int)}.
   *
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#getByte(int)}
   */
  @Test
  @DisplayName(
      "Test getByte(int); given HexModel(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'; then return 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte HexModel.getByte(int)"})
  void testGetByte_givenHexModelWithBytesIsAxaxaxaxBytesIsUtf8_thenReturnX()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals('X', new HexModel("AXAXAXAX".getBytes("UTF-8")).getByte(1));
  }

  /**
   * Test {@link HexModel#getLineChars(int)}.
   *
   * <ul>
   *   <li>Given {@code X}.
   *   <li>When one.
   *   <li>Then return {@code .XAXAXAX} toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  @DisplayName("Test getLineChars(int); given 'X'; when one; then return '.XAXAXAX' toCharArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char[] HexModel.getLineChars(int)"})
  void testGetLineChars_givenX_whenOne_thenReturnXaxaxaxToCharArray() {
    // Arrange
    HexModel hexModel = new HexModel(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    char[] actualLineChars = hexModel.getLineChars(1);

    // Assert
    assertArrayEquals(".XAXAXAX".toCharArray(), actualLineChars);
  }

  /**
   * Test {@link HexModel#getLineChars(int)}.
   *
   * <ul>
   *   <li>Then return {@code A.A.A.A.} toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  @DisplayName("Test getLineChars(int); then return 'A.A.A.A.' toCharArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char[] HexModel.getLineChars(int)"})
  void testGetLineChars_thenReturnAAAAToCharArray() {
    // Arrange
    HexModel hexModel =
        new HexModel(
            new byte[] {
              'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A',
              1, 'A', 1
            });

    // Act
    char[] actualLineChars = hexModel.getLineChars(2);

    // Assert
    assertArrayEquals("A.A.A.A.".toCharArray(), actualLineChars);
  }

  /**
   * Test {@link HexModel#getLineChars(int)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code char}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  @DisplayName("Test getLineChars(int); then return empty array of char")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char[] HexModel.getLineChars(int)"})
  void testGetLineChars_thenReturnEmptyArrayOfChar() {
    // Arrange
    HexModel hexModel =
        new HexModel(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertArrayEquals(new char[] {}, hexModel.getLineChars(2));
  }

  /**
   * Test {@link HexModel#getLineChars(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code AXAXAXAX} toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#getLineChars(int)}
   */
  @Test
  @DisplayName("Test getLineChars(int); when one; then return 'AXAXAXAX' toCharArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char[] HexModel.getLineChars(int)"})
  void testGetLineChars_whenOne_thenReturnAxaxaxaxToCharArray()
      throws UnsupportedEncodingException {
    // Arrange and Act
    char[] actualLineChars = new HexModel("AXAXAXAX".getBytes("UTF-8")).getLineChars(1);

    // Assert
    assertArrayEquals("AXAXAXAX".toCharArray(), actualLineChars);
  }

  /**
   * Test {@link HexModel#getBytesForLine(int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When two.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#getBytesForLine(int)}
   */
  @Test
  @DisplayName("Test getBytesForLine(int); given 'A'; when two; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] HexModel.getBytesForLine(int)"})
  void testGetBytesForLine_givenA_whenTwo_thenReturnEmptyArrayOfByte() {
    // Arrange
    HexModel hexModel =
        new HexModel(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertArrayEquals(new byte[] {}, hexModel.getBytesForLine(2));
  }

  /**
   * Test {@link HexModel#getBytesForLine(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#getBytesForLine(int)}
   */
  @Test
  @DisplayName("Test getBytesForLine(int); when one; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] HexModel.getBytesForLine(int)"})
  void testGetBytesForLine_whenOne_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new HexModel("AXAXAXAX".getBytes("UTF-8")).getBytesForLine(1));
  }

  /**
   * Test {@link HexModel#size()}.
   *
   * <p>Method under test: {@link HexModel#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HexModel.size()"})
  void testSize() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(8, new HexModel("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link HexModel#totalLine()}.
   *
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#totalLine()}
   */
  @Test
  @DisplayName(
      "Test totalLine(); given HexModel(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HexModel.totalLine()"})
  void testTotalLine_givenHexModelWithBytesIsAxaxaxaxBytesIsUtf8_thenReturnOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, new HexModel("AXAXAXAX".getBytes("UTF-8")).totalLine());
  }

  /**
   * Test {@link HexModel#totalLine()}.
   *
   * <ul>
   *   <li>Given {@link HexModel#HexModel(byte[])} with bytes is empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#totalLine()}
   */
  @Test
  @DisplayName(
      "Test totalLine(); given HexModel(byte[]) with bytes is empty array of byte; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HexModel.totalLine()"})
  void testTotalLine_givenHexModelWithBytesIsEmptyArrayOfByte_thenReturnZero() {
    // Arrange
    HexModel hexModel = new HexModel(new byte[] {});

    // Act and Assert
    assertEquals(0, hexModel.totalLine());
  }

  /**
   * Test {@link HexModel#lineNumber(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#lineNumber(int)}
   */
  @Test
  @DisplayName("Test lineNumber(int); when minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HexModel.lineNumber(int)"})
  void testLineNumber_whenMinusOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, HexModel.lineNumber(-1));
  }

  /**
   * Test {@link HexModel#lineNumber(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#lineNumber(int)}
   */
  @Test
  @DisplayName("Test lineNumber(int); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HexModel.lineNumber(int)"})
  void testLineNumber_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, HexModel.lineNumber(1));
  }

  /**
   * Test {@link HexModel#elementIndexInLine(int)}.
   *
   * <p>Method under test: {@link HexModel#elementIndexInLine(int)}
   */
  @Test
  @DisplayName("Test elementIndexInLine(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HexModel.elementIndexInLine(int)"})
  void testElementIndexInLine() {
    // Arrange, Act and Assert
    assertEquals(1, HexModel.elementIndexInLine(1));
  }

  /**
   * Test {@link HexModel#updateModel(int, byte)}.
   *
   * <ul>
   *   <li>Then calls {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#updateModel(int, byte)}
   */
  @Test
  @DisplayName("Test updateModel(int, byte); then calls hexModelChanged(HexModelChangedEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexModel.updateModel(int, byte)"})
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
   *
   * <ul>
   *   <li>Then calls {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#updateModel(int, byte)}
   */
  @Test
  @DisplayName("Test updateModel(int, byte); then calls hexModelChanged(HexModelChangedEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexModel.updateModel(int, byte)"})
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
   *
   * <ul>
   *   <li>Then calls {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  @DisplayName("Test hexChanged(HexChangedEvent); then calls hexModelChanged(HexModelChangedEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexModel.hexChanged(HexChangedEvent)"})
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
   *
   * <ul>
   *   <li>Then calls {@link HexModelChangeListener#hexModelChanged(HexModelChangedEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  @DisplayName("Test hexChanged(HexChangedEvent); then calls hexModelChanged(HexModelChangedEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexModel.hexChanged(HexChangedEvent)"})
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
   *
   * <ul>
   *   <li>When {@link HexChangedEvent#HexChangedEvent(byte, int)} with newValue is {@code X} and
   *       byteIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link HexModel#hexChanged(HexChangedEvent)}
   */
  @Test
  @DisplayName(
      "Test hexChanged(HexChangedEvent); when HexChangedEvent(byte, int) with newValue is 'X' and byteIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HexModel.hexChanged(HexChangedEvent)"})
  void testHexChanged_whenHexChangedEventWithNewValueIsXAndByteIndexIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    HexModelChangeListener listener = mock(HexModelChangeListener.class);
    doNothing().when(listener).hexModelChanged(Mockito.<HexModelChangedEvent>any());

    HexModelChangeListener listener2 = mock(HexModelChangeListener.class);
    doNothing().when(listener2).hexModelChanged(Mockito.<HexModelChangedEvent>any());

    HexModel hexModel = new HexModel("AXAXAXAX".getBytes("UTF-8"));
    hexModel.addHexModelChangeListener(listener2);
    hexModel.addHexModelChangeListener(listener);

    // Act
    hexModel.hexChanged(new HexChangedEvent((byte) 'X', 1));

    // Assert
    verify(listener2).hexModelChanged(isA(HexModelChangedEvent.class));
    verify(listener).hexModelChanged(isA(HexModelChangedEvent.class));
  }
}
