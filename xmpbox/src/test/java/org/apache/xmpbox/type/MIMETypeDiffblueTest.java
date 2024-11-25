package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MIMETypeDiffblueTest {
  /**
   * Test {@link MIMEType#MIMEType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MIMEType#MIMEType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new MIMEType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  void testNewMIMEType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    MIMEType actualMimeType = new MIMEType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

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
