package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class MIMETypeDiffblueTest {
  /**
   * Method under test:
   * {@link MIMEType#MIMEType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewMIMEType() {
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
