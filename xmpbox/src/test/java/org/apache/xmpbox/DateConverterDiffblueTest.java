package org.apache.xmpbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateConverterDiffblueTest {
  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy-MM-dd} format Time is {@code 2020-03-02}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); then return SimpleDateFormat(String) with 'yyyy-MM-dd' format Time is '2020-03-02'")
  void testToCalendar_thenReturnSimpleDateFormatWithYyyyMmDdFormatTimeIs20200302() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-0142");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-02", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy-MM-dd} format Time is {@code 4221-08-03}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); then return SimpleDateFormat(String) with 'yyyy-MM-dd' format Time is '4221-08-03'")
  void testToCalendar_thenReturnSimpleDateFormatWithYyyyMmDdFormatTimeIs42210803() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("422020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("4221-08-03", simpleDateFormat.format(actualToCalendarResult.getTime()));
    assertEquals(4221, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy-MM-dd} format Time is {@code 4242-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); then return SimpleDateFormat(String) with 'yyyy-MM-dd' format Time is '4242-01-01'")
  void testToCalendar_thenReturnSimpleDateFormatWithYyyyMmDdFormatTimeIs42420101() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("4242");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("4242-01-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    assertEquals(4241, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_when42D4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42[-:T]'; then throw IOException")
  void testToCalendar_when42T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code -42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '-42'; then throw IOException")
  void testToCalendar_when42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42D:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42D:'; then throw IOException")
  void testToCalendar_when42d_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42GMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42GMT'; then throw IOException")
  void testToCalendar_when42gmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42GMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42yyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42yyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_when42yyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42yyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42yyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_when42yyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42yyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42yyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_when42yyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 42yyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '42yyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_when42yyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01'")
  void testToCalendar_when20200301() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_when20200301D4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01Date}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01Date'; then throw IOException")
  void testToCalendar_when20200301Date_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01Date"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01[-:T]'; then throw IOException")
  void testToCalendar_when20200301T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01Unknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01Unknown'; then throw IOException")
  void testToCalendar_when20200301Unknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01Unknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020/03/01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020/03/01'; then throw IOException")
  void testToCalendar_when20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-2020/03/01"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01D:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01D:'")
  void testToCalendar_when20200301d() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-01D:");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 20200301D:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '20200301D:'")
  void testToCalendar_when20200301d2() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("20200301D:");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020/03/01D:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020/03/01D:'; then throw IOException")
  void testToCalendar_when20200301d_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01GMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01GMT'; then throw IOException")
  void testToCalendar_when20200301gmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301GMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01unknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01unknown'; then throw IOException")
  void testToCalendar_when20200301unknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01unknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01yyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01yyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_when20200301yyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01yyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01yyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_when20200301yyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01yyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01yyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_when20200301yyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01yyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01yyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_when20200301yyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01Z}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01Z'")
  void testToCalendar_when20200301z() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-01Z");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-01-'")
  void testToCalendar_when202003012() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-01-");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 20200301-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '20200301-'")
  void testToCalendar_when202003013() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("20200301-");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code -2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '-2020-03-01'")
  void testToCalendar_when202003014() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("-2020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code -20200301}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '-20200301'")
  void testToCalendar_when202003015() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("-20200301");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 422020/03/01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '422020/03/01'; then throw IOException")
  void testToCalendar_when4220200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("422020/03/01"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_when2020030120200301D4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01Date}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01Date'; then throw IOException")
  void testToCalendar_when2020030120200301Date_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01Date"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01[-:T]'; then throw IOException")
  void testToCalendar_when2020030120200301T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01Unknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01Unknown'; then throw IOException")
  void testToCalendar_when2020030120200301Unknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01Unknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01}.</li>
   *   <li>Then return TimeZone DisplayName is {@code GMT-02:59}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01'; then return TimeZone DisplayName is 'GMT-02:59'")
  void testToCalendar_when2020030120200301_thenReturnTimeZoneDisplayNameIsGmt0259() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-0120200301}.</li>
   *   <li>Then return TimeZone DisplayName is {@code GMT-02:59}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-0120200301'; then return TimeZone DisplayName is 'GMT-02:59'")
  void testToCalendar_when2020030120200301_thenReturnTimeZoneDisplayNameIsGmt02592() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-0120200301");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 202003012020-03-01}.</li>
   *   <li>Then return TimeZone DisplayName is {@code GMT-02:59}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '202003012020-03-01'; then return TimeZone DisplayName is 'GMT-02:59'")
  void testToCalendar_when2020030120200301_thenReturnTimeZoneDisplayNameIsGmt02593() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("202003012020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01-}.</li>
   *   <li>Then return TimeZone DisplayName is {@code GMT-02:59}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01-'; then return TimeZone DisplayName is 'GMT-02:59'")
  void testToCalendar_when2020030120200301_thenReturnTimeZoneDisplayNameIsGmt02594() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-01-");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020/03/01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020/03/01'; then throw IOException")
  void testToCalendar_when2020030120200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/012020-03-01"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01D:}.</li>
   *   <li>Then return TimeZone DisplayName is {@code GMT-02:59}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01D:'; then return TimeZone DisplayName is 'GMT-02:59'")
  void testToCalendar_when2020030120200301d_thenReturnTimeZoneDisplayNameIsGmt0259() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-01D:");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-01GMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-01GMT'; then throw IOException")
  void testToCalendar_when2020030120200301gmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01GMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-0142}.</li>
   *   <li>Then return TimeZone DisplayName is {@code GMT-00:18}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-0142'; then return TimeZone DisplayName is 'GMT-00:18'")
  void testToCalendar_when202003012020030142_thenReturnTimeZoneDisplayNameIsGmt0018() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-0142");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:18", timeZone.getDisplayName());
    assertEquals("GMT-00:18", timeZone.getID());
    assertEquals(1583095083000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-012020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-012020-03-01'")
  void testToCalendar_when202003012020030120200301() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-012020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:40", timeZone.getDisplayName());
    assertEquals("GMT-00:40", timeZone.getID());
    assertEquals(1583096403000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-012020/03/01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-012020/03/01'")
  void testToCalendar_when2020030120200301202003012() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-012020/03/01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:40", timeZone.getDisplayName());
    assertEquals("GMT-00:40", timeZone.getID());
    assertEquals(1583096403000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code 2020-03-012020-03-0120200301}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '2020-03-012020-03-0120200301'")
  void testToCalendar_when2020030120200301202003013() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-0120200301");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:40", timeZone.getDisplayName());
    assertEquals("GMT-00:40", timeZone.getID());
    assertEquals(1583096403000L, actualToCalendarResult.getTimeInMillis());
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*42'; then throw IOException")
  void testToCalendar_whenD4D2D2T42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*2020-03-01'; then throw IOException")
  void testToCalendar_whenD4D2D2T20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*20200301"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenD4D2D2TD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*D:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*D:'; then throw IOException")
  void testToCalendar_whenD4D2D2TD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*Date}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*Date'; then throw IOException")
  void testToCalendar_whenD4D2D2TDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*Date"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*GMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*GMT'; then throw IOException")
  void testToCalendar_whenD4D2D2TGmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*GMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*[-:T]'; then throw IOException")
  void testToCalendar_whenD4D2D2TT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*Unknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*Unknown'; then throw IOException")
  void testToCalendar_whenD4D2D2TUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*unknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*yyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenD4D2D2TYyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*yyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenD4D2D2TYyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*yyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenD4D2D2TYyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*yyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenD4D2D2TYyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*Z}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*Z'; then throw IOException")
  void testToCalendar_whenD4D2D2TZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*Z"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code D:D:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'D:D:'; then throw IOException")
  void testToCalendar_whenDD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("D:D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code D:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'D:'; then throw IOException")
  void testToCalendar_whenD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code --}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '--'; then throw IOException")
  void testToCalendar_whenDashDash_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("--"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '-'; then throw IOException")
  void testToCalendar_whenDash_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Date2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Date2020-03-01'; then throw IOException")
  void testToCalendar_whenDate20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date2020-03-01"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Date^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Date^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenDateD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code DateD:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'DateD:'; then throw IOException")
  void testToCalendar_whenDateD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("DateD:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code DateGMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'DateGMT'; then throw IOException")
  void testToCalendar_whenDateGMT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("DateGMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Date[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Date[-:T]'; then throw IOException")
  void testToCalendar_whenDateT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code -Date}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '-Date'; then throw IOException")
  void testToCalendar_whenDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-Date"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Dateyyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Dateyyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenDateyyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Dateyyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Dateyyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenDateyyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Dateyyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Dateyyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenDateyyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Dateyyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Dateyyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenDateyyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when empty string; then return 'null'")
  void testToCalendar_whenEmptyString_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(""));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTDate}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTDate'; then throw IOException")
  void testToCalendar_whenGMTDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTDate"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTUnknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTUnknown'; then throw IOException")
  void testToCalendar_whenGMTUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTUnknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTunknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTunknown'; then throw IOException")
  void testToCalendar_whenGMTunknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTunknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTyyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTyyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenGMTyyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTyyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTyyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenGMTyyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTyyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTyyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenGMTyyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTyyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTyyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenGMTyyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMT42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMT42'; then throw IOException")
  void testToCalendar_whenGmt42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMT2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMT2020-03-01'; then throw IOException")
  void testToCalendar_whenGmt20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT20200301"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMT^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMT^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenGmtD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMT[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMT[-:T]'; then throw IOException")
  void testToCalendar_whenGmtT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMT'; then throw IOException")
  void testToCalendar_whenGmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTD:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTD:'; then throw IOException")
  void testToCalendar_whenGmtd_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTD:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTGMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTGMT'; then throw IOException")
  void testToCalendar_whenGmtgmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTGMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code GMTZ}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'GMTZ'; then throw IOException")
  void testToCalendar_whenGmtz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTZ"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'null'; then return 'null'")
  void testToCalendar_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(DateConverter.toCalendar(null));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]42'; then throw IOException")
  void testToCalendar_whenT42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]2020-03-01'; then throw IOException")
  void testToCalendar_whenT20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]20200301"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenTD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]D:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]D:'; then throw IOException")
  void testToCalendar_whenTD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]Date}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]Date'; then throw IOException")
  void testToCalendar_whenTDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]Date"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]GMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]GMT'; then throw IOException")
  void testToCalendar_whenTGmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]GMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T][-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T][-:T]'; then throw IOException")
  void testToCalendar_whenTT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T][-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]Unknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]Unknown'; then throw IOException")
  void testToCalendar_whenTUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]unknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]yyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]yyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenTYyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]yyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]yyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenTYyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]yyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]yyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenTYyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]yyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]yyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenTYyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]Z}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]Z'; then throw IOException")
  void testToCalendar_whenTZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]Z"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code [-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '[-:T]'; then throw IOException")
  void testToCalendar_whenT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Unknown2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Unknown2020-03-01'; then throw IOException")
  void testToCalendar_whenUnknown20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown2020-03-01"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Unknown^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Unknown^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenUnknownD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code UnknownD:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'UnknownD:'; then throw IOException")
  void testToCalendar_whenUnknownD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("UnknownD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownD:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code UnknownGMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'UnknownGMT'; then throw IOException")
  void testToCalendar_whenUnknownGMT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("UnknownGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownGMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Unknown[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Unknown[-:T]'; then throw IOException")
  void testToCalendar_whenUnknownT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code -Unknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '-Unknown'; then throw IOException")
  void testToCalendar_whenUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Unknownyyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Unknownyyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenUnknownyyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Unknownyyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Unknownyyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenUnknownyyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Unknownyyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Unknownyyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenUnknownyyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Unknownyyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Unknownyyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenUnknownyyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss42'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSs42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss2020-03-01'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSs20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss20200301"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssD:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssD:'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssD:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssDate}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssDate'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssDate"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssGMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssGMT'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsGMT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssGMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.S42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.S42'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsS42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.S2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.S2020-03-01'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsS20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S20200301"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.S^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.S^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.SDate}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.SDate'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SDate"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.S[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.S[-:T]'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsST_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.SUnknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.SUnknown'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SUnknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.SD:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.SD:'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSd_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SD:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.SGMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.SGMT'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSgmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SGMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.Sunknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.Sunknown'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSunknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Sunknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSyyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSyyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSyyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSyyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss.SZ}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss.SZ'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsSz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SZ"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss[-:T]'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssUnknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssUnknown'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssUnknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'42'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZ42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'2020-03-01'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZ20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'20200301"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'D:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'D:'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'D:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'Date}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'Date'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'Date"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'GMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'GMT'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZGmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'GMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'[-:T]'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'Unknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'Unknown'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'unknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZYyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZYyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZYyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZYyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'Z}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z'Z'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'Z"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssZ"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssunknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssunknown'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsunknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssunknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsyyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsyyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsyyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsyyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssz42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssz42'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsz42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz42"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssz2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssz2020-03-01'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsz20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz20200301"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssz^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssz^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszD:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszD:'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszD_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszD:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszDate}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszDate'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszDate_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszDate"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszGMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszGMT'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszGMT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszGMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssz[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssz[-:T]'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszUnknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszUnknown'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszUnknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszUnknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszZ}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszZ'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszZ"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszunknown}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszunknown'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszunknown_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszunknown"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszyyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszyyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszyyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenYyyyMmDdTHhMmSszyyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ssz"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Z2020-03-01}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Z2020-03-01'; then throw IOException")
  void testToCalendar_whenZ20200301_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z2020-03-01"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Z^\d{4}-\d{2}-\d{2}T.*}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Z^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IOException")
  void testToCalendar_whenZD4D2D2T_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Z[-:T]}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Z[-:T]'; then throw IOException")
  void testToCalendar_whenZT_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z[-:T]"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code -Z}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when '-Z'; then throw IOException")
  void testToCalendar_whenZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-Z"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z-"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ZD:}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'ZD:'; then throw IOException")
  void testToCalendar_whenZd_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("ZD:"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code ZGMT}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'ZGMT'; then throw IOException")
  void testToCalendar_whenZgmt_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("ZGMT"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Zyyyy-MM-dd'T'HH:mm:ss.S}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Zyyyy-MM-dd'T'HH:mm:ss.S'; then throw IOException")
  void testToCalendar_whenZyyyyMmDdTHhMmSsS_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ss.S"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Zyyyy-MM-dd'T'HH:mm:ss'Z'}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Zyyyy-MM-dd'T'HH:mm:ss'Z''; then throw IOException")
  void testToCalendar_whenZyyyyMmDdTHhMmSsZ_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ss'Z'"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Zyyyy-MM-dd'T'HH:mm:ss}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Zyyyy-MM-dd'T'HH:mm:ss'; then throw IOException")
  void testToCalendar_whenZyyyyMmDdTHhMmSs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ss"));
  }

  /**
   * Test {@link DateConverter#toCalendar(String)}.
   * <ul>
   *   <li>When {@code Zyyyy-MM-dd'T'HH:mm:ssz}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  @DisplayName("Test toCalendar(String); when 'Zyyyy-MM-dd'T'HH:mm:ssz'; then throw IOException")
  void testToCalendar_whenZyyyyMmDdTHhMmSsz_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ssz"));
  }
}
