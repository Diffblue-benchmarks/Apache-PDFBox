package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DateConverterDiffblueTest {
  /**
   * Test {@link DateConverter#toString(Calendar)} with {@code Calendar}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toString(Calendar)}
   */
  @Test
  @DisplayName("Test toString(Calendar) with 'Calendar'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateConverter.toString(Calendar)"})
  void testToStringWithCalendar_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toString(null));
  }

  /**
   * Test {@link DateConverter#formatTZoffset(long, String)}.
   *
   * <ul>
   *   <li>When {@code 50400001}.
   *   <li>Then return {@code -09Sep59}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#formatTZoffset(long, String)}
   */
  @Test
  @DisplayName("Test formatTZoffset(long, String); when '50400001'; then return '-09Sep59'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateConverter.formatTZoffset(long, String)"})
  void testFormatTZoffset_when50400001_thenReturn09Sep59() {
    // Arrange, Act and Assert
    assertEquals("-09Sep59", DateConverter.formatTZoffset(50400001L, "Sep"));
  }

  /**
   * Test {@link DateConverter#formatTZoffset(long, String)}.
   *
   * <ul>
   *   <li>When {@code -50400001}.
   *   <li>Then return {@code +09Sep59}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#formatTZoffset(long, String)}
   */
  @Test
  @DisplayName("Test formatTZoffset(long, String); when '-50400001'; then return '+09Sep59'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateConverter.formatTZoffset(long, String)"})
  void testFormatTZoffset_when50400001_thenReturn09Sep592() {
    // Arrange, Act and Assert
    assertEquals("+09Sep59", DateConverter.formatTZoffset(-50400001L, "Sep"));
  }

  /**
   * Test {@link DateConverter#formatTZoffset(long, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code +00Sep00}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#formatTZoffset(long, String)}
   */
  @Test
  @DisplayName("Test formatTZoffset(long, String); when one; then return '+00Sep00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateConverter.formatTZoffset(long, String)"})
  void testFormatTZoffset_whenOne_thenReturn00Sep00() {
    // Arrange, Act and Assert
    assertEquals("+00Sep00", DateConverter.formatTZoffset(1L, "Sep"));
  }

  /**
   * Test {@link DateConverter#newGreg()}.
   *
   * <p>Method under test: {@link DateConverter#newGreg()}
   */
  @Test
  @DisplayName("Test newGreg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GregorianCalendar DateConverter.newGreg()"})
  void testNewGreg() {
    // Arrange and Act
    GregorianCalendar actualNewGregResult = DateConverter.newGreg();

    // Assert
    TimeZone timeZone = actualNewGregResult.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("UTC", timeZone.getID());
    assertEquals("gregory", actualNewGregResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualNewGregResult.getFirstDayOfWeek());
    assertEquals(1, actualNewGregResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualNewGregResult.getWeeksInWeekYear());
    assertFalse(actualNewGregResult.isLenient());
    assertTrue(actualNewGregResult.isWeekDateSupported());
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName("Test parseTZoffset(String, GregorianCalendar, ParsePosition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);

    // Act
    DateConverter.parseTZoffset("42", cal, new ParsePosition(1));

    // Assert
    String actualFormatResult = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    assertEquals("0001-01-31", actualFormatResult);
    TimeZone timeZone = cal.getTimeZone();
    assertEquals("GMT+02:00", timeZone.getDisplayName());
    assertEquals("GMT+02:00", timeZone.getID());
    assertEquals(-62133105600000L, cal.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName("Test parseTZoffset(String, GregorianCalendar, ParsePosition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset2() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);

    // Act
    DateConverter.parseTZoffset("42", cal, new ParsePosition(0));

    // Assert
    TimeZone timeZone = cal.getTimeZone();
    assertEquals("GMT-06:00", timeZone.getDisplayName());
    assertEquals("GMT-06:00", timeZone.getID());
    assertEquals(-62133048000000L, cal.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <ul>
   *   <li>When {@code ':}.
   *   <li>Then {@link ParsePosition#ParsePosition(int)} with zero Index is zero.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName(
      "Test parseTZoffset(String, GregorianCalendar, ParsePosition); when '':'; then ParsePosition(int) with zero Index is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset_whenApostropheColon_thenParsePositionWithZeroIndexIsZero() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
    ParsePosition initialWhere = new ParsePosition(0);

    // Act
    boolean actualParseTZoffsetResult = DateConverter.parseTZoffset("': ", cal, initialWhere);

    // Assert
    assertEquals(0, initialWhere.getIndex());
    assertFalse(actualParseTZoffsetResult);
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <ul>
   *   <li>When {@code GMT}.
   *   <li>Then {@link ParsePosition#ParsePosition(int)} with zero Index is three.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName(
      "Test parseTZoffset(String, GregorianCalendar, ParsePosition); when 'GMT'; then ParsePosition(int) with zero Index is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset_whenGmt_thenParsePositionWithZeroIndexIsThree() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
    ParsePosition initialWhere = new ParsePosition(0);

    // Act
    boolean actualParseTZoffsetResult = DateConverter.parseTZoffset("GMT", cal, initialWhere);

    // Assert
    TimeZone timeZone = cal.getTimeZone();
    assertEquals("GMT", timeZone.getID());
    assertEquals("Greenwich Mean Time", timeZone.getDisplayName());
    assertEquals(3, initialWhere.getIndex());
    assertTrue(actualParseTZoffsetResult);
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then {@link ParsePosition#ParsePosition(int)} with one Index is one.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName(
      "Test parseTZoffset(String, GregorianCalendar, ParsePosition); when 'Text'; then ParsePosition(int) with one Index is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset_whenText_thenParsePositionWithOneIndexIsOne() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
    ParsePosition initialWhere = new ParsePosition(1);

    // Act
    boolean actualParseTZoffsetResult = DateConverter.parseTZoffset("Text", cal, initialWhere);

    // Assert
    assertEquals(1, initialWhere.getIndex());
    assertFalse(actualParseTZoffsetResult);
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <ul>
   *   <li>When {@code UTC}.
   *   <li>Then {@link ParsePosition#ParsePosition(int)} with zero Index is three.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName(
      "Test parseTZoffset(String, GregorianCalendar, ParsePosition); when 'UTC'; then ParsePosition(int) with zero Index is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset_whenUtc_thenParsePositionWithZeroIndexIsThree() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
    ParsePosition initialWhere = new ParsePosition(0);

    // Act
    boolean actualParseTZoffsetResult = DateConverter.parseTZoffset("UTC", cal, initialWhere);

    // Assert
    TimeZone timeZone = cal.getTimeZone();
    assertEquals("GMT", timeZone.getID());
    assertEquals("Greenwich Mean Time", timeZone.getDisplayName());
    assertEquals(3, initialWhere.getIndex());
    assertTrue(actualParseTZoffsetResult);
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <ul>
   *   <li>When {@code Z+-}.
   *   <li>Then {@link ParsePosition#ParsePosition(int)} with one Index is one.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName(
      "Test parseTZoffset(String, GregorianCalendar, ParsePosition); when 'Z+-'; then ParsePosition(int) with one Index is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset_whenZ_thenParsePositionWithOneIndexIsOne() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
    ParsePosition initialWhere = new ParsePosition(1);

    // Act
    boolean actualParseTZoffsetResult = DateConverter.parseTZoffset("Z+- ", cal, initialWhere);

    // Assert
    assertEquals(1, initialWhere.getIndex());
    assertFalse(actualParseTZoffsetResult);
  }

  /**
   * Test {@link DateConverter#parseTZoffset(String, GregorianCalendar, ParsePosition)}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then {@link ParsePosition#ParsePosition(int)} with zero Index is one.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#parseTZoffset(String, GregorianCalendar,
   * ParsePosition)}
   */
  @Test
  @DisplayName(
      "Test parseTZoffset(String, GregorianCalendar, ParsePosition); when 'Z'; then ParsePosition(int) with zero Index is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DateConverter.parseTZoffset(String, GregorianCalendar, ParsePosition)"
  })
  void testParseTZoffset_whenZ_thenParsePositionWithZeroIndexIsOne() {
    // Arrange
    GregorianCalendar cal = new GregorianCalendar(1, 1, 1);
    ParsePosition initialWhere = new ParsePosition(0);

    // Act
    boolean actualParseTZoffsetResult = DateConverter.parseTZoffset("Z", cal, initialWhere);

    // Assert
    TimeZone timeZone = cal.getTimeZone();
    assertEquals("GMT", timeZone.getID());
    assertEquals("Greenwich Mean Time", timeZone.getDisplayName());
    assertEquals(1, initialWhere.getIndex());
    assertTrue(actualParseTZoffsetResult);
  }

  /**
   * Test {@link DateConverter#toCalendar(COSString)} with {@code COSString}.
   *
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(COSString)}
   */
  @Test
  @DisplayName("Test toCalendar(COSString) with 'COSString'; then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(COSString)"})
  void testToCalendarWithCOSString_thenReturnGregorianCalendar() {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar(new COSString("4242"));

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(4242, actualToCalendarResult.getWeekYear());
    assertEquals(53, actualToCalendarResult.getWeeksInWeekYear());
    assertEquals(71697398400000L, actualToCalendarResult.getTimeInMillis());
    assertFalse(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link DateConverter#toCalendar(COSString)} with {@code COSString}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(COSString)}
   */
  @Test
  @DisplayName(
      "Test toCalendar(COSString) with 'COSString'; when COSString(String) with text is '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(COSString)"})
  void testToCalendarWithCOSString_whenCOSStringWithTextIs42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(new COSString("42")));
  }

  /**
   * Test {@link DateConverter#toCalendar(COSString)} with {@code COSString}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is space.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(COSString)}
   */
  @Test
  @DisplayName(
      "Test toCalendar(COSString) with 'COSString'; when COSString(String) with text is space; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(COSString)"})
  void testToCalendarWithCOSString_whenCOSStringWithTextIsSpace_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(new COSString(" ")));
  }

  /**
   * Test {@link DateConverter#toCalendar(COSString)} with {@code COSString}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(COSString)}
   */
  @Test
  @DisplayName("Test toCalendar(COSString) with 'COSString'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(COSString)"})
  void testToCalendarWithCOSString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar((COSString) null));
  }

  /**
   * Test {@link DateConverter#toCalendar(COSString)} with {@code COSString}.
   *
   * <ul>
   *   <li>When parseHex {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(COSString)}
   */
  @Test
  @DisplayName(
      "Test toCalendar(COSString) with 'COSString'; when parseHex '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(COSString)"})
  void testToCalendarWithCOSString_whenParseHex42_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(COSString.parseHex("42")));
  }

  /**
   * Test {@link DateConverter#toCalendar(COSString)} with {@code COSString}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(COSString)}
   */
  @Test
  @DisplayName(
      "Test toCalendar(COSString) with 'COSString'; when parseHex '0123456789ABCDEF'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(COSString)"})
  void testToCalendarWithCOSString_whenParseHex0123456789abcdef_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar("42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 4242Text}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when '4242Text'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when4242Text_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar("4242Text"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when '4242'; then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when4242_thenReturnGregorianCalendar() {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("4242");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(4242, actualToCalendarResult.getWeekYear());
    assertEquals(53, actualToCalendarResult.getWeeksInWeekYear());
    assertEquals(71697398400000L, actualToCalendarResult.getTimeInMillis());
    assertFalse(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 4242.}.
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when '4242.'; then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when4242_thenReturnGregorianCalendar2() {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("4242.");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(4242, actualToCalendarResult.getWeekYear());
    assertEquals(53, actualToCalendarResult.getWeeksInWeekYear());
    assertEquals(71697398400000L, actualToCalendarResult.getTimeInMillis());
    assertFalse(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 4242GMT}.
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName(
      "Test toCalendar(String) with 'String'; when '4242GMT'; then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when4242gmt_thenReturnGregorianCalendar() {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("4242GMT");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(4242, actualToCalendarResult.getWeekYear());
    assertEquals(53, actualToCalendarResult.getWeeksInWeekYear());
    assertEquals(71697398400000L, actualToCalendarResult.getTimeInMillis());
    assertFalse(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 4242UTC}.
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName(
      "Test toCalendar(String) with 'String'; when '4242UTC'; then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when4242utc_thenReturnGregorianCalendar() {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("4242UTC");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(4242, actualToCalendarResult.getWeekYear());
    assertEquals(53, actualToCalendarResult.getWeeksInWeekYear());
    assertEquals(71697398400000L, actualToCalendarResult.getTimeInMillis());
    assertFalse(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 4242Z}.
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when '4242Z'; then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when4242z_thenReturnGregorianCalendar() {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("4242Z");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(4242, actualToCalendarResult.getWeekYear());
    assertEquals(53, actualToCalendarResult.getWeeksInWeekYear());
    assertEquals(71697398400000L, actualToCalendarResult.getTimeInMillis());
    assertFalse(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 424242}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when '424242'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_when424242_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar("424242"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code D:}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when 'D:'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_whenD_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar("D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code D:}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when 'D:'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_whenD_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(" D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when '.'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_whenDot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar("."));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(""));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar((String) null));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String) with 'String'; when 'Text'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar DateConverter.toCalendar(String)"})
  void testToCalendarWithString_whenText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar("Text"));
  }
}
