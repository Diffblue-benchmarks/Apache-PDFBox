package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSStringDiffblueTest {
  /**
   * Test {@link COSString#COSString(String)}.
   * <p>
   * Method under test: {@link COSString#COSString(String)}
   */
  @Test
  @DisplayName("Test new COSString(String)")
  void testNewCOSString() throws UnsupportedEncodingException {
    // Arrange and Act
    COSString actualCosString = new COSString("Text");

    // Assert
    assertEquals("54657874", actualCosString.toHexString());
    assertEquals("Text", actualCosString.getASCII());
    assertEquals("Text", actualCosString.getString());
    assertNull(actualCosString.getKey());
    assertFalse(actualCosString.isDirect());
    assertFalse(actualCosString.getForceHexForm());
    byte[] expectedBytes = "Text".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#COSString(String, boolean)}.
   * <p>
   * Method under test: {@link COSString#COSString(String, boolean)}
   */
  @Test
  @DisplayName("Test new COSString(String, boolean)")
  void testNewCOSString2() throws UnsupportedEncodingException {
    // Arrange and Act
    COSString actualCosString = new COSString("Text", true);

    // Assert
    assertEquals("54657874", actualCosString.toHexString());
    assertEquals("Text", actualCosString.getASCII());
    assertEquals("Text", actualCosString.getString());
    assertNull(actualCosString.getKey());
    assertFalse(actualCosString.isDirect());
    assertTrue(actualCosString.getForceHexForm());
    byte[] expectedBytes = "Text".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#COSString(byte[])}.
   * <p>
   * Method under test: {@link COSString#COSString(byte[])}
   */
  @Test
  @DisplayName("Test new COSString(byte[])")
  void testNewCOSString3() throws UnsupportedEncodingException {
    // Arrange and Act
    COSString actualCosString = new COSString("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", actualCosString.toHexString());
    assertEquals("AXAXAXAX", actualCosString.getASCII());
    assertEquals("AXAXAXAX", actualCosString.getString());
    assertNull(actualCosString.getKey());
    assertFalse(actualCosString.isDirect());
    assertFalse(actualCosString.getForceHexForm());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#COSString(byte[], boolean)}.
   * <p>
   * Method under test: {@link COSString#COSString(byte[], boolean)}
   */
  @Test
  @DisplayName("Test new COSString(byte[], boolean)")
  void testNewCOSString4() throws UnsupportedEncodingException {
    // Arrange and Act
    COSString actualCosString = new COSString("AXAXAXAX".getBytes("UTF-8"), true);

    // Assert
    assertEquals("4158415841584158", actualCosString.toHexString());
    assertEquals("AXAXAXAX", actualCosString.getASCII());
    assertEquals("AXAXAXAX", actualCosString.getString());
    assertNull(actualCosString.getKey());
    assertFalse(actualCosString.isDirect());
    assertTrue(actualCosString.getForceHexForm());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#parseHex(String)}.
   * <ul>
   *   <li>When {@code Hex}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSString#parseHex(String)}
   */
  @Test
  @DisplayName("Test parseHex(String); when 'Hex'; then throw IOException")
  void testParseHex_whenHex_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> COSString.parseHex("Hex"));
  }

  /**
   * Test {@link COSString#getString()}.
   * <ul>
   *   <li>Given parseHex {@code 42}.</li>
   *   <li>Then return {@code B}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSString#getString()}
   */
  @Test
  @DisplayName("Test getString(); given parseHex '42'; then return 'B'")
  void testGetString_givenParseHex42_thenReturnB() throws IOException {
    // Arrange, Act and Assert
    assertEquals("B", COSString.parseHex("42").getString());
  }

  /**
   * Test {@link COSString#getBytes()}.
   * <p>
   * Method under test: {@link COSString#getBytes()}
   */
  @Test
  @DisplayName("Test getBytes()")
  void testGetBytes() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17},
        COSString.parseHex("0123456789ABCDEF").getBytes());
  }

  /**
   * Test {@link COSString#toHexString()}.
   * <p>
   * Method under test: {@link COSString#toHexString()}
   */
  @Test
  @DisplayName("Test toHexString()")
  void testToHexString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("0123456789ABCDEF", COSString.parseHex("0123456789ABCDEF").toHexString());
  }

  /**
   * Test {@link COSString#accept(ICOSVisitor)}.
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromString(COSString)} does
   * nothing.</li>
   *   <li>Then calls {@link COSWriter#visitFromString(COSString)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSString#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); when COSWriter visitFromString(COSString) does nothing; then calls visitFromString(COSString)")
  void testAccept_whenCOSWriterVisitFromStringDoesNothing_thenCallsVisitFromString() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromString(Mockito.<COSString>any());

    // Act
    parseHexResult.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromString(isA(COSString.class));
  }

  /**
   * Test {@link COSString#equals(Object)}, and {@link COSString#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSString#equals(Object)}
   *   <li>{@link COSString#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");
    COSString parseHexResult2 = COSString.parseHex("0123456789ABCDEF");

    // Act and Assert
    assertEquals(parseHexResult, parseHexResult2);
    int expectedHashCodeResult = parseHexResult.hashCode();
    assertEquals(expectedHashCodeResult, parseHexResult2.hashCode());
  }

  /**
   * Test {@link COSString#equals(Object)}, and {@link COSString#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSString#equals(Object)}
   *   <li>{@link COSString#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");

    // Act and Assert
    assertEquals(parseHexResult, parseHexResult);
    int expectedHashCodeResult = parseHexResult.hashCode();
    assertEquals(expectedHashCodeResult, parseHexResult.hashCode());
  }

  /**
   * Test {@link COSString#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSString#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("42");

    // Act and Assert
    assertNotEquals(parseHexResult, COSString.parseHex("0123456789ABCDEF"));
  }

  /**
   * Test {@link COSString#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSString#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(COSString.parseHex("0123456789ABCDEF"), null);
  }

  /**
   * Test {@link COSString#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSString#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(COSString.parseHex("0123456789ABCDEF"), "Different type to COSString");
  }
}
