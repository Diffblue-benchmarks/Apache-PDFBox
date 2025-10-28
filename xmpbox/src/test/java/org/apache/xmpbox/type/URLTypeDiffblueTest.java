package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class URLTypeDiffblueTest {
  /**
   * Method under test:
   * {@link URLType#URLType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewURLType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URLType actualUrlType = new URLType(metadata, "https://example.org/example", "https://example.org/example",
        "https://example.org/example", "Value");

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
