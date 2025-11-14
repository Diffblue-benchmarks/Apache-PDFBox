package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocaleTypeDiffblueTest {
  /**
   * Test {@link LocaleType#LocaleType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleType#LocaleType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new LocaleType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocaleType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewLocaleType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new LocaleType(XMPMetadata.createXMPMetadata(), "en", "en", "en", 42));
  }

  /**
   * Test {@link LocaleType#LocaleType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return StringValue is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleType#LocaleType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new LocaleType(XMPMetadata, String, String, String, Object); when 'Value'; then return StringValue is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocaleType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewLocaleType_whenValue_thenReturnStringValueIsValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    LocaleType actualLocaleType = new LocaleType(metadata, "en", "en", "en", "Value");

    // Assert
    assertEquals("Value", actualLocaleType.getStringValue());
    assertEquals("Value", actualLocaleType.getRawValue());
    assertEquals("Value", actualLocaleType.getValue());
    assertEquals("en", actualLocaleType.getPropertyName());
    assertEquals("en", actualLocaleType.getNamespace());
    assertEquals("en", actualLocaleType.getPrefix());
    assertTrue(actualLocaleType.getAllAttributes().isEmpty());
    assertSame(metadata, actualLocaleType.getMetadata());
  }
}
