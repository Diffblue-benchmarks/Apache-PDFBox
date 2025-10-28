package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class URITypeDiffblueTest {
  /**
   * Method under test:
   * {@link URIType#URIType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewURIType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URIType actualUriType = new URIType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualUriType.getNamespace());
    assertEquals("Prefix", actualUriType.getPrefix());
    assertEquals("Property Name", actualUriType.getPropertyName());
    assertEquals("Value", actualUriType.getStringValue());
    assertEquals("Value", actualUriType.getRawValue());
    assertEquals("Value", actualUriType.getValue());
    assertTrue(actualUriType.getAllAttributes().isEmpty());
    assertSame(metadata, actualUriType.getMetadata());
  }
}
