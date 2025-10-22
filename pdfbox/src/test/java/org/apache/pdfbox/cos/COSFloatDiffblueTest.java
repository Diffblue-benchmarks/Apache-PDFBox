package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSFloatDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSFloat#COSFloat(float)}
   *   <li>{@link COSFloat#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(float)", "String COSFloat.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat(10.0f);

    // Assert
    assertEquals("COSFloat{10.0}", actualCosFloat.toString());
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code 0.0}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '0.0'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_when00_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code 0.0-9}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '0.0-9'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_when009_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0-9");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '42'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_when42_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("42");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code -9.-9}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '-9.-9'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_when99_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("-9.-9");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code 0.0-942}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '0.0-942'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_when00942_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0-942");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code -9.-942}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '-9.-942'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_when9942_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("-9.-942");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code 0.0-94242}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '0.0-94242'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_when0094242_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSFloat actualCosFloat = new COSFloat("0.0-94242");

    // Assert
    assertNull(actualCosFloat.getKey());
    assertFalse(actualCosFloat.isDirect());
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code A Float}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when 'A Float'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_whenAFloat_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new COSFloat("A Float"));
  }

  /**
   * Test {@link COSFloat#COSFloat(String)}.
   * <ul>
   *   <li>When {@code --}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#COSFloat(String)}
   */
  @Test
  @DisplayName("Test new COSFloat(String); when '--'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.<init>(String)"})
  void testNewCOSFloat_whenDashDash_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new COSFloat("--"));
  }

  /**
   * Test {@link COSFloat#floatValue()}.
   * <p>
   * Method under test: {@link COSFloat#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float COSFloat.floatValue()"})
  void testFloatValue() {
    // Arrange, Act and Assert
    assertEquals(1.0f, COSFloat.ONE.floatValue());
  }

  /**
   * Test {@link COSFloat#longValue()}.
   * <p>
   * Method under test: {@link COSFloat#longValue()}
   */
  @Test
  @DisplayName("Test longValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long COSFloat.longValue()"})
  void testLongValue() {
    // Arrange, Act and Assert
    assertEquals(1L, COSFloat.ONE.longValue());
  }

  /**
   * Test {@link COSFloat#intValue()}.
   * <p>
   * Method under test: {@link COSFloat#intValue()}
   */
  @Test
  @DisplayName("Test intValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int COSFloat.intValue()"})
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(1, COSFloat.ONE.intValue());
  }

  /**
   * Test {@link COSFloat#equals(Object)}, and {@link COSFloat#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSFloat#equals(Object)}
   *   <li>{@link COSFloat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSFloat.equals(Object)", "int COSFloat.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSFloat cosFloat = COSFloat.ONE;
    COSFloat cosFloat2 = COSFloat.ONE;

    // Act and Assert
    assertEquals(cosFloat, cosFloat2);
    int expectedHashCodeResult = cosFloat.hashCode();
    assertEquals(expectedHashCodeResult, cosFloat2.hashCode());
  }

  /**
   * Test {@link COSFloat#equals(Object)}, and {@link COSFloat#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSFloat#equals(Object)}
   *   <li>{@link COSFloat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSFloat.equals(Object)", "int COSFloat.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSFloat cosFloat = COSFloat.ONE;

    // Act and Assert
    assertEquals(cosFloat, cosFloat);
    int expectedHashCodeResult = cosFloat.hashCode();
    assertEquals(expectedHashCodeResult, cosFloat.hashCode());
  }

  /**
   * Test {@link COSFloat#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSFloat.equals(Object)", "int COSFloat.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSFloat.ZERO, COSFloat.ONE);
  }

  /**
   * Test {@link COSFloat#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSFloat.equals(Object)", "int COSFloat.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSFloat.ONE, null);
  }

  /**
   * Test {@link COSFloat#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSFloat.equals(Object)", "int COSFloat.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSFloat.ONE, "Different type to COSFloat");
  }

  /**
   * Test {@link COSFloat#accept(ICOSVisitor)}.
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromFloat(COSFloat)} does nothing.</li>
   *   <li>Then calls {@link COSWriter#visitFromFloat(COSFloat)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); when COSWriter visitFromFloat(COSFloat) does nothing; then calls visitFromFloat(COSFloat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.accept(ICOSVisitor)"})
  void testAccept_whenCOSWriterVisitFromFloatDoesNothing_thenCallsVisitFromFloat() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromFloat(Mockito.<COSFloat>any());

    // Act
    COSFloat.ONE.accept(visitor);

    // Assert
    verify(visitor).visitFromFloat(isA(COSFloat.class));
  }

  /**
   * Test {@link COSFloat#writePDF(OutputStream)}.
   * <p>
   * Method under test: {@link COSFloat#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.writePDF(OutputStream)"})
  void testWritePDF() throws IOException {
    // Arrange
    COSFloat cosFloat = new COSFloat(-3.4028235E38f);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    cosFloat.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "-340282350000000000000000000000000000000".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSFloat#writePDF(OutputStream)}.
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one toByteArray is {@code 1.0} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); given ONE; then ByteArrayOutputStream(int) with one toByteArray is '1.0' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.writePDF(OutputStream)"})
  void testWritePDF_givenOne_thenByteArrayOutputStreamWithOneToByteArrayIs10BytesIsUtf8() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSFloat.ONE.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "1.0".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSFloat#writePDF(OutputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one toByteArray is {@code 10.0} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSFloat#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); then ByteArrayOutputStream(int) with one toByteArray is '10.0' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSFloat.writePDF(OutputStream)"})
  void testWritePDF_thenByteArrayOutputStreamWithOneToByteArrayIs100BytesIsUtf8() throws IOException {
    // Arrange
    COSFloat cosFloat = new COSFloat(10.0f);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    cosFloat.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "10.0".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }
}
