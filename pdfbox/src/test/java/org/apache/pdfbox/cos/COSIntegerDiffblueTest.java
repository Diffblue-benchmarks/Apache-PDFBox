package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSIntegerDiffblueTest {
  /**
   * Test {@link COSInteger#get(long)} with {@code val}.
   *
   * <ul>
   *   <li>When minus one hundred one.
   *   <li>Then return Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSInteger#get(long)}
   */
  @Test
  @DisplayName("Test get(long) with 'val'; when minus one hundred one; then return Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSInteger COSInteger.get(long)"})
  void testGetWithVal_whenMinusOneHundredOne_thenReturnKeyIsNull() {
    // Arrange and Act
    COSInteger actualGetResult = COSInteger.get(-101L);

    // Assert
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(actualGetResult.isValid());
  }

  /**
   * Test {@link COSInteger#get(long)} with {@code val}.
   *
   * <ul>
   *   <li>When two hundred fifty-seven.
   *   <li>Then return Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSInteger#get(long)}
   */
  @Test
  @DisplayName("Test get(long) with 'val'; when two hundred fifty-seven; then return Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSInteger COSInteger.get(long)"})
  void testGetWithVal_whenTwoHundredFiftySeven_thenReturnKeyIsNull() {
    // Arrange and Act
    COSInteger actualGetResult = COSInteger.get(257L);

    // Assert
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(actualGetResult.isValid());
  }

  /**
   * Test {@link COSInteger#equals(Object)}, and {@link COSInteger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSInteger#equals(Object)}
   *   <li>{@link COSInteger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSInteger.equals(Object)", "int COSInteger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSInteger cosInteger = COSInteger.ONE;
    COSInteger cosInteger2 = COSInteger.ONE;

    // Act and Assert
    assertEquals(cosInteger, cosInteger2);
    assertEquals(cosInteger.hashCode(), cosInteger2.hashCode());
  }

  /**
   * Test {@link COSInteger#equals(Object)}, and {@link COSInteger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSInteger#equals(Object)}
   *   <li>{@link COSInteger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSInteger.equals(Object)", "int COSInteger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSInteger cosInteger = COSInteger.ONE;

    // Act and Assert
    assertEquals(cosInteger, cosInteger);
    int expectedHashCodeResult = cosInteger.hashCode();
    assertEquals(expectedHashCodeResult, cosInteger.hashCode());
  }

  /**
   * Test {@link COSInteger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSInteger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSInteger.equals(Object)", "int COSInteger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSInteger.OUT_OF_RANGE_MAX, COSInteger.ONE);
  }

  /**
   * Test {@link COSInteger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSInteger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSInteger.equals(Object)", "int COSInteger.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSInteger.ONE, null);
  }

  /**
   * Test {@link COSInteger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSInteger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSInteger.equals(Object)", "int COSInteger.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSInteger.ONE, "Different type to COSInteger");
  }

  /**
   * Test {@link COSInteger#floatValue()}.
   *
   * <p>Method under test: {@link COSInteger#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSInteger.floatValue()"})
  void testFloatValue() {
    // Arrange, Act and Assert
    assertEquals(1.0f, COSInteger.ONE.floatValue());
  }

  /**
   * Test {@link COSInteger#intValue()}.
   *
   * <p>Method under test: {@link COSInteger#intValue()}
   */
  @Test
  @DisplayName("Test intValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSInteger.intValue()"})
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(1, COSInteger.ONE.intValue());
  }

  /**
   * Test {@link COSInteger#longValue()}.
   *
   * <p>Method under test: {@link COSInteger#longValue()}
   */
  @Test
  @DisplayName("Test longValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSInteger.longValue()"})
  void testLongValue() {
    // Arrange, Act and Assert
    assertEquals(1L, COSInteger.ONE.longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSInteger#toString()}
   *   <li>{@link COSInteger#isValid()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSInteger.isValid()", "String COSInteger.toString()"})
  void testGettersAndSetters() {
    // Arrange
    COSInteger getResult = COSInteger.get(42L);

    // Act
    String actualToStringResult = getResult.toString();

    // Assert
    assertEquals("COSInt{42}", actualToStringResult);
    assertTrue(getResult.isValid());
  }

  /**
   * Test {@link COSInteger#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromInt(COSInteger)} does nothing.
   *   <li>Then calls {@link COSWriter#visitFromInt(COSInteger)}.
   * </ul>
   *
   * <p>Method under test: {@link COSInteger#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); when COSWriter visitFromInt(COSInteger) does nothing; then calls visitFromInt(COSInteger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSInteger.accept(ICOSVisitor)"})
  void testAccept_whenCOSWriterVisitFromIntDoesNothing_thenCallsVisitFromInt() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromInt(Mockito.<COSInteger>any());

    // Act
    COSInteger.ONE.accept(visitor);

    // Assert
    verify(visitor).visitFromInt(isA(COSInteger.class));
  }

  /**
   * Test {@link COSInteger#writePDF(OutputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream()} toByteArray is array of {@code
   *       byte} with {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link COSInteger#writePDF(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writePDF(OutputStream); then ByteArrayOutputStream() toByteArray is array of byte with '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSInteger.writePDF(OutputStream)"})
  void testWritePDF_thenByteArrayOutputStreamToByteArrayIsArrayOfByteWith1() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    COSInteger.ONE.writePDF(output);

    // Assert
    assertArrayEquals(new byte[] {'1'}, output.toByteArray());
  }
}
