package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.GregorianCalendar;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DateTypeDiffblueTest {
  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>Then return RawValue is {@link GregorianCalendar#GregorianCalendar(int, int, int)} with
   *       one and one and one.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); then return RawValue is GregorianCalendar(int, int, int) with one and one and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_thenReturnRawValueIsGregorianCalendarWithOneAndOneAndOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    GregorianCalendar gregorianCalendar = new GregorianCalendar(1, 1, 1);

    // Act
    DateType actualDateType =
        new DateType(metadata, "Namespace URI", "Prefix", "Property Name", gregorianCalendar);

    // Assert
    assertSame(gregorianCalendar, actualDateType.getRawValue());
    assertSame(gregorianCalendar, actualDateType.getValue());
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42"));
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when '^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenD4D2D2T_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(),
                "Namespace URI",
                "Prefix",
                "Property Name",
                "^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code D:}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when 'D:'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenD_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "D:"));
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "-"));
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return RawValue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when empty string; then return RawValue is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenEmptyString_thenReturnRawValueIsEmptyString() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DateType actualDateType =
        new DateType(metadata, "Namespace URI", "Prefix", "Property Name", "");

    // Assert
    assertEquals("", actualDateType.getRawValue());
    assertEquals("Namespace URI", actualDateType.getNamespace());
    assertEquals("Prefix", actualDateType.getPrefix());
    assertEquals("Property Name", actualDateType.getPropertyName());
    assertNull(actualDateType.getValue());
    assertTrue(actualDateType.getAllAttributes().isEmpty());
    assertSame(metadata, actualDateType.getMetadata());
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", null));
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code [-:T]}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when '[-:T]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenT_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(),
                "Namespace URI",
                "Prefix",
                "Property Name",
                "[-:T]"));
  }

  /**
   * Test {@link DateType#DateType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new DateType(XMPMetadata, String, String, String, Object); when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewDateType_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new DateType(
                XMPMetadata.createXMPMetadata(),
                "Namespace URI",
                "Prefix",
                "Property Name",
                "Value"));
  }

  /**
   * Test {@link DateType#getValue()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Calendar DateType.getValue()"})
  void testGetValue_thenReturnNull() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act and Assert
    assertNull(dateType.getValue());
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");
    GregorianCalendar gregorianCalendar = new GregorianCalendar(1, 1, 1);

    // Act
    dateType.setValue(gregorianCalendar);

    // Assert
    assertSame(gregorianCalendar, dateType.getValue());
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue2() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    dateType.setValue("");

    // Assert that nothing has changed
    assertNull(dateType.getValue());
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue_when42_thenThrowIllegalArgumentException() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dateType.setValue("42"));
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code ^\d{4}-\d{2}-\d{2}T.*}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName(
      "Test setValue(Object); when '^\\d{4}-\\d{2}-\\d{2}T.*'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue_whenD4D2D2T_thenThrowIllegalArgumentException() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> dateType.setValue("^\\d{4}-\\d{2}-\\d{2}T.*"));
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code D:}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when 'D:'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue_whenD_thenThrowIllegalArgumentException() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dateType.setValue("D:"));
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue_whenDash_thenThrowIllegalArgumentException() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dateType.setValue("-"));
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code [-:T]}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when '[-:T]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue_whenT_thenThrowIllegalArgumentException() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dateType.setValue("[-:T]"));
  }

  /**
   * Test {@link DateType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateType.setValue(Object)"})
  void testSetValue_whenValue_thenThrowIllegalArgumentException() {
    // Arrange
    DateType dateType =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> dateType.setValue("Value"));
  }
}
