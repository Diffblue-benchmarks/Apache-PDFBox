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

class MIMETypeDiffblueTest {
  /**
   * Test {@link MIMEType#MIMEType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MIMEType#MIMEType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new MIMEType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MIMEType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewMIMEType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new MIMEType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link MIMEType#MIMEType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return Namespace is {@code Namespace URI}.
   * </ul>
   *
   * <p>Method under test: {@link MIMEType#MIMEType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new MIMEType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MIMEType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewMIMEType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    MIMEType actualMimeType =
        new MIMEType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualMimeType.getNamespace());
    assertEquals("Prefix", actualMimeType.getPrefix());
    assertEquals("Property Name", actualMimeType.getPropertyName());
    assertEquals("Value", actualMimeType.getStringValue());
    assertEquals("Value", actualMimeType.getRawValue());
    assertEquals("Value", actualMimeType.getValue());
    assertTrue(actualMimeType.getAllAttributes().isEmpty());
    assertSame(metadata, actualMimeType.getMetadata());
  }
}
