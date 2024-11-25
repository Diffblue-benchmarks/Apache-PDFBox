package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ToUnicodeWriterDiffblueTest {
  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   * <ul>
   *   <li>When {@code 65536}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when '65536'; then throw IllegalArgumentException")
  void testAdd_when65536_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(65536, null));
  }

  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when empty string; then throw IllegalArgumentException")
  void testAdd_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(0, ""));
  }

  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when minus one; then throw IllegalArgumentException")
  void testAdd_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(-1, null));
  }

  /**
   * Test {@link ToUnicodeWriter#add(int, String)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  @DisplayName("Test add(int, String); when zero; then throw IllegalArgumentException")
  void testAdd_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(0, null));
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor) add three and
   * {@code 9,9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test writeTo(OutputStream); given ToUnicodeWriter (default constructor) add three and '9,9'")
  void testWriteTo_givenToUnicodeWriterAddThreeAnd99() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(3, "9,9 ");
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(525, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[512]);
    assertEquals('\n', toByteArrayResult[516]);
    assertEquals('\n', toByteArrayResult[520]);
    assertEquals('\n', toByteArrayResult[524]);
    assertEquals('c', toByteArrayResult[510]);
    assertEquals('d', toByteArrayResult[519]);
    assertEquals('d', toByteArrayResult[523]);
    assertEquals('e', toByteArrayResult[505]);
    assertEquals('e', toByteArrayResult[511]);
    assertEquals('e', toByteArrayResult[517]);
    assertEquals('e', toByteArrayResult[521]);
    assertEquals('f', toByteArrayResult[500]);
    assertEquals('i', toByteArrayResult[501]);
    assertEquals('n', toByteArrayResult[502]);
    assertEquals('n', toByteArrayResult[518]);
    assertEquals('n', toByteArrayResult[522]);
    assertEquals('o', toByteArrayResult[507]);
    assertEquals('o', toByteArrayResult[514]);
    assertEquals('p', toByteArrayResult[513]);
    assertEquals('p', toByteArrayResult[515]);
    assertEquals('r', toByteArrayResult[504]);
    assertEquals('r', toByteArrayResult[509]);
    assertEquals('s', toByteArrayResult[506]);
    assertEquals('u', toByteArrayResult[508]);
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor) add two and
   * {@code 9,9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test writeTo(OutputStream); given ToUnicodeWriter (default constructor) add two and '9,9'")
  void testWriteTo_givenToUnicodeWriterAddTwoAnd99() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(2, "9,9 ");
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(525, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[512]);
    assertEquals('\n', toByteArrayResult[516]);
    assertEquals('\n', toByteArrayResult[520]);
    assertEquals('\n', toByteArrayResult[524]);
    assertEquals('c', toByteArrayResult[510]);
    assertEquals('d', toByteArrayResult[519]);
    assertEquals('d', toByteArrayResult[523]);
    assertEquals('e', toByteArrayResult[505]);
    assertEquals('e', toByteArrayResult[511]);
    assertEquals('e', toByteArrayResult[517]);
    assertEquals('e', toByteArrayResult[521]);
    assertEquals('f', toByteArrayResult[500]);
    assertEquals('i', toByteArrayResult[501]);
    assertEquals('n', toByteArrayResult[502]);
    assertEquals('n', toByteArrayResult[518]);
    assertEquals('n', toByteArrayResult[522]);
    assertEquals('o', toByteArrayResult[507]);
    assertEquals('o', toByteArrayResult[514]);
    assertEquals('p', toByteArrayResult[513]);
    assertEquals('p', toByteArrayResult[515]);
    assertEquals('r', toByteArrayResult[504]);
    assertEquals('r', toByteArrayResult[509]);
    assertEquals('s', toByteArrayResult[506]);
    assertEquals('u', toByteArrayResult[508]);
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor) WMode is
   * {@link PDPanoseClassification#LENGTH}.</li>
   *   <li>Then array length is five hundred seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test writeTo(OutputStream); given ToUnicodeWriter (default constructor) WMode is LENGTH; then array length is five hundred seven")
  void testWriteTo_givenToUnicodeWriterWModeIsLength_thenArrayLengthIsFiveHundredSeven() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.setWMode(PDPanoseClassification.LENGTH);
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(507, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[494]);
    assertEquals('\n', toByteArrayResult[498]);
    assertEquals('\n', toByteArrayResult[502]);
    assertEquals('\n', toByteArrayResult[506]);
    assertEquals('c', toByteArrayResult[492]);
    assertEquals('d', toByteArrayResult[501]);
    assertEquals('d', toByteArrayResult[505]);
    assertEquals('e', toByteArrayResult[485]);
    assertEquals('e', toByteArrayResult[487]);
    assertEquals('e', toByteArrayResult[493]);
    assertEquals('e', toByteArrayResult[499]);
    assertEquals('f', toByteArrayResult[482]);
    assertEquals('i', toByteArrayResult[483]);
    assertEquals('n', toByteArrayResult[484]);
    assertEquals('n', toByteArrayResult[500]);
    assertEquals('n', toByteArrayResult[504]);
    assertEquals('o', toByteArrayResult[489]);
    assertEquals('o', toByteArrayResult[496]);
    assertEquals('p', toByteArrayResult[495]);
    assertEquals('p', toByteArrayResult[497]);
    assertEquals('r', toByteArrayResult[486]);
    assertEquals('r', toByteArrayResult[491]);
    assertEquals('s', toByteArrayResult[488]);
    assertEquals('u', toByteArrayResult[490]);
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   * <ul>
   *   <li>Given {@link ToUnicodeWriter} (default constructor).</li>
   *   <li>Then array length is three hundred four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test writeTo(OutputStream); given ToUnicodeWriter (default constructor); then array length is three hundred four")
  void testWriteTo_givenToUnicodeWriter_thenArrayLengthIsThreeHundredFour() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert that nothing has changed
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(304, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[291]);
    assertEquals('\n', toByteArrayResult[295]);
    assertEquals('\n', toByteArrayResult[299]);
    assertEquals('\n', toByteArrayResult[303]);
    assertEquals('c', toByteArrayResult[289]);
    assertEquals('d', toByteArrayResult[298]);
    assertEquals('d', toByteArrayResult[302]);
    assertEquals('e', toByteArrayResult[282]);
    assertEquals('e', toByteArrayResult[284]);
    assertEquals('e', toByteArrayResult[290]);
    assertEquals('e', toByteArrayResult[296]);
    assertEquals('e', toByteArrayResult[300]);
    assertEquals('f', toByteArrayResult[279]);
    assertEquals('i', toByteArrayResult[280]);
    assertEquals('n', toByteArrayResult[281]);
    assertEquals('n', toByteArrayResult[297]);
    assertEquals('n', toByteArrayResult[301]);
    assertEquals('o', toByteArrayResult[286]);
    assertEquals('o', toByteArrayResult[293]);
    assertEquals('p', toByteArrayResult[292]);
    assertEquals('p', toByteArrayResult[294]);
    assertEquals('r', toByteArrayResult[283]);
    assertEquals('r', toByteArrayResult[288]);
    assertEquals('s', toByteArrayResult[285]);
    assertEquals('u', toByteArrayResult[287]);
  }

  /**
   * Test {@link ToUnicodeWriter#writeTo(OutputStream)}.
   * <ul>
   *   <li>Then array length is four hundred ninety-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test writeTo(OutputStream); then array length is four hundred ninety-two")
  void testWriteTo_thenArrayLengthIsFourHundredNinetyTwo() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(492, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[479]);
    assertEquals('\n', toByteArrayResult[483]);
    assertEquals('\n', toByteArrayResult[487]);
    assertEquals('\n', toByteArrayResult[491]);
    assertEquals('c', toByteArrayResult[477]);
    assertEquals('d', toByteArrayResult[486]);
    assertEquals('d', toByteArrayResult[490]);
    assertEquals('e', toByteArrayResult[470]);
    assertEquals('e', toByteArrayResult[472]);
    assertEquals('e', toByteArrayResult[478]);
    assertEquals('e', toByteArrayResult[484]);
    assertEquals('e', toByteArrayResult[488]);
    assertEquals('f', toByteArrayResult[467]);
    assertEquals('i', toByteArrayResult[468]);
    assertEquals('n', toByteArrayResult[469]);
    assertEquals('n', toByteArrayResult[485]);
    assertEquals('n', toByteArrayResult[489]);
    assertEquals('o', toByteArrayResult[474]);
    assertEquals('o', toByteArrayResult[481]);
    assertEquals('p', toByteArrayResult[480]);
    assertEquals('p', toByteArrayResult[482]);
    assertEquals('r', toByteArrayResult[471]);
    assertEquals('r', toByteArrayResult[476]);
    assertEquals('s', toByteArrayResult[473]);
    assertEquals('u', toByteArrayResult[475]);
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when 'null'; then return 'false'")
  void testAllowCIDToUnicodeRange_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(null, null));
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(new AbstractMap.SimpleEntry<>(1, "foo"), null));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with minus one and
   * {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with minus one and 'foo'; then return 'false'")
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithMinusOneAndFoo_thenReturnFalse() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(-1, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(0, "foo")));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with one and empty
   * string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with one and empty string; then return 'false'")
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithOneAndEmptyString_thenReturnFalse() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(0, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "")));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with one and
   * {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with one and 'foo'; then return 'false'")
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithOneAndFoo_thenReturnFalse() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(1, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "foo")));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with zero and empty
   * string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with zero and empty string; then return 'false'")
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithZeroAndEmptyString_thenReturnFalse() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(0, "");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "foo")));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCIDToUnicodeRange(Entry, Entry)}.
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with zero and
   * {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  @DisplayName("Test allowCIDToUnicodeRange(Entry, Entry); when SimpleEntry(Object, Object) with zero and 'foo'; then return 'false'")
  void testAllowCIDToUnicodeRange_whenSimpleEntryWithZeroAndFoo_thenReturnFalse() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(0, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "foo")));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCodeRange(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#allowCodeRange(int, int)}
   */
  @Test
  @DisplayName("Test allowCodeRange(int, int); when minus one; then return 'false'")
  void testAllowCodeRange_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCodeRange(-1, 0));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCodeRange(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#allowCodeRange(int, int)}
   */
  @Test
  @DisplayName("Test allowCodeRange(int, int); when one; then return 'false'")
  void testAllowCodeRange_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCodeRange(1, 1));
  }

  /**
   * Test {@link ToUnicodeWriter#allowCodeRange(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToUnicodeWriter#allowCodeRange(int, int)}
   */
  @Test
  @DisplayName("Test allowCodeRange(int, int); when zero; then return 'true'")
  void testAllowCodeRange_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ToUnicodeWriter.allowCodeRange(0, 1));
  }

  /**
   * Test {@link ToUnicodeWriter#allowDestinationRange(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowDestinationRange(String, String)}
   */
  @Test
  @DisplayName("Test allowDestinationRange(String, String); when empty string")
  void testAllowDestinationRange_whenEmptyString() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowDestinationRange("", ""));
  }

  /**
   * Test {@link ToUnicodeWriter#allowDestinationRange(String, String)}.
   * <ul>
   *   <li>When {@code Next}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowDestinationRange(String, String)}
   */
  @Test
  @DisplayName("Test allowDestinationRange(String, String); when 'Next'")
  void testAllowDestinationRange_whenNext() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowDestinationRange("Prev", "Next"));
  }

  /**
   * Test {@link ToUnicodeWriter#allowDestinationRange(String, String)}.
   * <ul>
   *   <li>When {@code Prev}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToUnicodeWriter#allowDestinationRange(String, String)}
   */
  @Test
  @DisplayName("Test allowDestinationRange(String, String); when 'Prev'")
  void testAllowDestinationRange_whenPrev() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowDestinationRange("Prev", ""));
  }
}
