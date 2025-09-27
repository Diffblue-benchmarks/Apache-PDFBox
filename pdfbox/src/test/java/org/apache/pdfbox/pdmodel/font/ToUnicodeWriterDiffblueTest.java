package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToUnicodeWriterDiffblueTest {
  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   *
   * <ul>
   *   <li>When {@code 65536}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when '65536'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.add(int, String)"})
  void testAdd_when65536_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ToUnicodeWriter().add(65536, null));
  }

  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.add(int, String)"})
  void testAdd_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ToUnicodeWriter().add(0, ""));
  }

  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.add(int, String)"})
  void testAdd_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ToUnicodeWriter().add(-1, null));
  }

  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.add(int, String)"})
  void testAdd_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ToUnicodeWriter().add(0, null));
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor) add three and {@code 9,9}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeTo(OutputStream); given ToUnicodeWriter (default constructor) add three and '9,9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.writeTo(OutputStream)"})
  void testWriteTo_givenToUnicodeWriterAddThreeAnd99() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(3, "9,9 ");
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    assertEquals(525, out.toByteArray().length);
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor) add two and {@code 9,9}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeTo(OutputStream); given ToUnicodeWriter (default constructor) add two and '9,9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.writeTo(OutputStream)"})
  void testWriteTo_givenToUnicodeWriterAddTwoAnd99() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(2, "9,9 ");
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    assertEquals(525, out.toByteArray().length);
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor) WMode is {@link
   *       PDPanoseClassification#LENGTH}.
   *   <li>Then array length is five hundred seven.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeTo(OutputStream); given ToUnicodeWriter (default constructor) WMode is LENGTH; then array length is five hundred seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.writeTo(OutputStream)"})
  void testWriteTo_givenToUnicodeWriterWModeIsLength_thenArrayLengthIsFiveHundredSeven()
      throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.setWMode(PDPanoseClassification.LENGTH);
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    assertEquals(507, out.toByteArray().length);
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor).
   *   <li>Then array length is three hundred four.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeTo(OutputStream); given ToUnicodeWriter (default constructor); then array length is three hundred four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToUnicodeWriter.writeTo(OutputStream)"})
  void testWriteTo_givenToUnicodeWriter_thenArrayLengthIsThreeHundredFour() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    assertEquals(304, out.toByteArray().length);
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCIDToUnicodeRange(Entry, Entry)"})
  void testAllowCIDToUnicodeRange_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(null, null));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCIDToUnicodeRange(Entry, Entry)"})
  void testAllowCIDToUnicodeRange_whenNull_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(new SimpleEntry<>(1, "foo"), null));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   *
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with minus one and {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}
   */
  @Test
  @DisplayName(
      "Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with minus one and 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCIDToUnicodeRange(Entry, Entry)"})
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithMinusOneAndFoo_thenReturnFalse() {
    // Arrange
    SimpleEntry<Integer, String> prev = new SimpleEntry<>(-1, "foo");

    // Act
    boolean actualAllowCIDToUnicodeRangeResult =
        ToUnicodeWriter.allowCIDToUnicodeRange(prev, new SimpleEntry<>(0, "foo"));

    // Assert
    assertFalse(actualAllowCIDToUnicodeRangeResult);
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   *
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with one and empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}
   */
  @Test
  @DisplayName(
      "Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with one and empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCIDToUnicodeRange(Entry, Entry)"})
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithOneAndEmptyString_thenReturnFalse() {
    // Arrange
    SimpleEntry<Integer, String> prev = new SimpleEntry<>(0, "foo");

    // Act
    boolean actualAllowCIDToUnicodeRangeResult =
        ToUnicodeWriter.allowCIDToUnicodeRange(prev, new SimpleEntry<>(1, ""));

    // Assert
    assertFalse(actualAllowCIDToUnicodeRangeResult);
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   *
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with one and {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}
   */
  @Test
  @DisplayName(
      "Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with one and 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCIDToUnicodeRange(Entry, Entry)"})
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithOneAndFoo_thenReturnFalse() {
    // Arrange
    SimpleEntry<Integer, String> prev = new SimpleEntry<>(1, "foo");

    // Act
    boolean actualAllowCIDToUnicodeRangeResult =
        ToUnicodeWriter.allowCIDToUnicodeRange(prev, new SimpleEntry<>(1, "foo"));

    // Assert
    assertFalse(actualAllowCIDToUnicodeRangeResult);
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   *
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with zero and empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}
   */
  @Test
  @DisplayName(
      "Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with zero and empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCIDToUnicodeRange(Entry, Entry)"})
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithZeroAndEmptyString_thenReturnFalse() {
    // Arrange
    SimpleEntry<Integer, String> prev = new SimpleEntry<>(0, "");

    // Act
    boolean actualAllowCIDToUnicodeRangeResult =
        ToUnicodeWriter.allowCIDToUnicodeRange(prev, new SimpleEntry<>(1, "foo"));

    // Assert
    assertFalse(actualAllowCIDToUnicodeRangeResult);
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   *
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with zero and {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}
   */
  @Test
  @DisplayName(
      "Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with zero and 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCIDToUnicodeRange(Entry, Entry)"})
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithZeroAndFoo_thenReturnFalse() {
    // Arrange
    SimpleEntry<Integer, String> prev = new SimpleEntry<>(0, "foo");

    // Act
    boolean actualAllowCIDToUnicodeRangeResult =
        ToUnicodeWriter.allowCIDToUnicodeRange(prev, new SimpleEntry<>(1, "foo"));

    // Assert
    assertFalse(actualAllowCIDToUnicodeRangeResult);
  }

  /**
   * Test {@link ToUnicodeWriter#allowCodeRange(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCodeRange(int, int)}
   */
  @Test
  @DisplayName("Test allowCodeRange(int, int); when minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCodeRange(int, int)"})
  void testAllowCodeRange_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCodeRange(-1, 0));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCodeRange(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCodeRange(int, int)}
   */
  @Test
  @DisplayName("Test allowCodeRange(int, int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCodeRange(int, int)"})
  void testAllowCodeRange_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCodeRange(1, 1));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCodeRange(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowCodeRange(int, int)}
   */
  @Test
  @DisplayName("Test allowCodeRange(int, int); when zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowCodeRange(int, int)"})
  void testAllowCodeRange_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ToUnicodeWriter.allowCodeRange(0, 1));
  }

  /**
   * Test {@link ToUnicodeWriter#allowDestinationRange(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowDestinationRange(String, String)}
   */
  @Test
  @DisplayName("Test allowDestinationRange(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowDestinationRange(String, String)"})
  void testAllowDestinationRange_whenEmptyString() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowDestinationRange("", ""));
  }

  /**
   * Test {@link ToUnicodeWriter#allowDestinationRange(String, String)}.
   *
   * <ul>
   *   <li>When {@code Next}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowDestinationRange(String, String)}
   */
  @Test
  @DisplayName("Test allowDestinationRange(String, String); when 'Next'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowDestinationRange(String, String)"})
  void testAllowDestinationRange_whenNext() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowDestinationRange("Prev", "Next"));
  }

  /**
   * Test {@link ToUnicodeWriter#allowDestinationRange(String, String)}.
   *
   * <ul>
   *   <li>When {@code Prev}.
   * </ul>
   *
   * <p>Method under test: {@link ToUnicodeWriter#allowDestinationRange(String, String)}
   */
  @Test
  @DisplayName("Test allowDestinationRange(String, String); when 'Prev'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ToUnicodeWriter.allowDestinationRange(String, String)"})
  void testAllowDestinationRange_whenPrev() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowDestinationRange("Prev", ""));
  }
}
