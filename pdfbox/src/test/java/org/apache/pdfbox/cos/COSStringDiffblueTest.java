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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSStringDiffblueTest {
  /**
   * Test {@link COSString#COSString(String)}.
   *
   * <p>Method under test: {@link COSString#COSString(String)}
   */
  @Test
  @DisplayName("Test new COSString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSString.<init>(String)"})
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
    assertArrayEquals("Text".getBytes("UTF-8"), actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#COSString(String, boolean)}.
   *
   * <p>Method under test: {@link COSString#COSString(String, boolean)}
   */
  @Test
  @DisplayName("Test new COSString(String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSString.<init>(String, boolean)"})
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
    assertArrayEquals("Text".getBytes("UTF-8"), actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#COSString(byte[])}.
   *
   * <p>Method under test: {@link COSString#COSString(byte[])}
   */
  @Test
  @DisplayName("Test new COSString(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSString.<init>(byte[])"})
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#COSString(byte[], boolean)}.
   *
   * <p>Method under test: {@link COSString#COSString(byte[], boolean)}
   */
  @Test
  @DisplayName("Test new COSString(byte[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSString.<init>(byte[], boolean)"})
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCosString.getBytes());
  }

  /**
   * Test {@link COSString#parseHex(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return toHexString is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link COSString#parseHex(String)}
   */
  @Test
  @DisplayName(
      "Test parseHex(String); when '0123456789ABCDEF'; then return toHexString is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSString COSString.parseHex(String)"})
  void testParseHex_when0123456789abcdef_thenReturnToHexStringIs0123456789abcdef()
      throws IOException {
    // Arrange and Act
    COSString actualParseHexResult = COSString.parseHex("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualParseHexResult.toHexString());
    assertEquals("\u0001#Eg›«Íï", actualParseHexResult.getString());
    assertEquals("\u0001#Eg����", actualParseHexResult.getASCII());
    assertNull(actualParseHexResult.getKey());
    assertFalse(actualParseHexResult.isDirect());
    assertFalse(actualParseHexResult.getForceHexForm());
    assertArrayEquals(
        new byte[] {1, '#', 'E', 'g', -119, -85, -51, -17}, actualParseHexResult.getBytes());
  }

  /**
   * Test {@link COSString#parseHex(String)}.
   *
   * <ul>
   *   <li>When {@code Hex}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSString#parseHex(String)}
   */
  @Test
  @DisplayName("Test parseHex(String); when 'Hex'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSString COSString.parseHex(String)"})
  void testParseHex_whenHex_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> COSString.parseHex("Hex"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSString#toString()}
   *   <li>{@link COSString#getForceHexForm()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSString.getForceHexForm()", "String COSString.toString()"})
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");

    // Act
    String actualToStringResult = parseHexResult.toString();

    // Assert
    assertEquals("COSString{\u0001#Eg›«Íï}", actualToStringResult);
    assertFalse(parseHexResult.getForceHexForm());
  }

  /**
   * Test {@link COSString#getString()}.
   *
   * <ul>
   *   <li>Given parseHex {@code 42} Direct is {@code true}.
   *   <li>Then return {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link COSString#getString()}
   */
  @Test
  @DisplayName("Test getString(); given parseHex '42' Direct is 'true'; then return 'B'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSString.getString()"})
  void testGetString_givenParseHex42DirectIsTrue_thenReturnB() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("42");
    parseHexResult.setDirect(true);

    // Act and Assert
    assertEquals("B", parseHexResult.getString());
  }

  /**
   * Test {@link COSString#getString()}.
   *
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.
   *   <li>Then return {@code #Eg›«Íï}.
   * </ul>
   *
   * <p>Method under test: {@link COSString#getString()}
   */
  @Test
  @DisplayName("Test getString(); given parseHex '0123456789ABCDEF'; then return '#Eg›«Íï'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSString.getString()"})
  void testGetString_givenParseHex0123456789abcdef_thenReturnEg() throws IOException {
    // Arrange, Act and Assert
    assertEquals("\u0001#Eg›«Íï", COSString.parseHex("0123456789ABCDEF").getString());
  }

  /**
   * Test {@link COSString#getASCII()}.
   *
   * <p>Method under test: {@link COSString#getASCII()}
   */
  @Test
  @DisplayName("Test getASCII()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSString.getASCII()"})
  void testGetASCII() throws IOException {
    // Arrange, Act and Assert
    assertEquals("\u0001#Eg����", COSString.parseHex("0123456789ABCDEF").getASCII());
  }

  /**
   * Test {@link COSString#getBytes()}.
   *
   * <p>Method under test: {@link COSString#getBytes()}
   */
  @Test
  @DisplayName("Test getBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] COSString.getBytes()"})
  void testGetBytes() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {1, '#', 'E', 'g', -119, -85, -51, -17},
        COSString.parseHex("0123456789ABCDEF").getBytes());
  }

  /**
   * Test {@link COSString#toHexString()}.
   *
   * <p>Method under test: {@link COSString#toHexString()}
   */
  @Test
  @DisplayName("Test toHexString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSString.toHexString()"})
  void testToHexString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("0123456789ABCDEF", COSString.parseHex("0123456789ABCDEF").toHexString());
  }

  /**
   * Test {@link COSString#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromString(COSString)} does nothing.
   *   <li>Then calls {@link COSWriter#visitFromString(COSString)}.
   * </ul>
   *
   * <p>Method under test: {@link COSString#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); when COSWriter visitFromString(COSString) does nothing; then calls visitFromString(COSString)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSString.accept(ICOSVisitor)"})
  void testAccept_whenCOSWriterVisitFromStringDoesNothing_thenCallsVisitFromString()
      throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");

    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromString(Mockito.<COSString>any());

    // Act
    parseHexResult.accept(visitor);

    // Assert
    verify(visitor).visitFromString(isA(COSString.class));
  }

  /**
   * Test {@link COSString#equals(Object)}, and {@link COSString#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSString#equals(Object)}
   *   <li>{@link COSString#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSString.equals(Object)", "int COSString.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");
    COSString parseHexResult2 = COSString.parseHex("0123456789ABCDEF");

    // Act and Assert
    assertEquals(parseHexResult, parseHexResult2);
    assertEquals(parseHexResult.hashCode(), parseHexResult2.hashCode());
  }

  /**
   * Test {@link COSString#equals(Object)}, and {@link COSString#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSString#equals(Object)}
   *   <li>{@link COSString#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSString.equals(Object)", "int COSString.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSString#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSString.equals(Object)", "int COSString.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws IOException {
    // Arrange
    COSString cosString = new COSString("\u0001#Eg›«Íï", true);

    // Act and Assert
    assertNotEquals(cosString, COSString.parseHex("0123456789ABCDEF"));
  }

  /**
   * Test {@link COSString#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSString#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSString.equals(Object)", "int COSString.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws IOException {
    // Arrange
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");

    // Act and Assert
    assertNotEquals(parseHexResult, COSString.parseHex("42"));
  }

  /**
   * Test {@link COSString#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSString#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSString.equals(Object)", "int COSString.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(COSString.parseHex("0123456789ABCDEF"), null);
  }

  /**
   * Test {@link COSString#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSString#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSString.equals(Object)", "int COSString.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(COSString.parseHex("0123456789ABCDEF"), "Different type to COSString");
  }
}
