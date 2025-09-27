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

class URLTypeDiffblueTest {
  /**
   * Test {@link URLType#URLType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link URLType#URLType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new URLType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewURLType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new URLType(
                XMPMetadata.createXMPMetadata(),
                "https://example.org/example",
                "https://example.org/example",
                "https://example.org/example",
                42));
  }

  /**
   * Test {@link URLType#URLType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return StringValue is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link URLType#URLType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new URLType(XMPMetadata, String, String, String, Object); when 'Value'; then return StringValue is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewURLType_whenValue_thenReturnStringValueIsValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URLType actualUrlType =
        new URLType(
            metadata,
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Assert
    assertEquals("Value", actualUrlType.getStringValue());
    assertEquals("Value", actualUrlType.getRawValue());
    assertEquals("Value", actualUrlType.getValue());
    assertEquals("https://example.org/example", actualUrlType.getPropertyName());
    assertEquals("https://example.org/example", actualUrlType.getNamespace());
    assertEquals("https://example.org/example", actualUrlType.getPrefix());
    assertTrue(actualUrlType.getAllAttributes().isEmpty());
    assertSame(metadata, actualUrlType.getMetadata());
  }
}
