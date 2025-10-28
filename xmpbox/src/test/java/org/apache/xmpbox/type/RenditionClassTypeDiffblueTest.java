package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class RenditionClassTypeDiffblueTest {
  /**
   * Method under test:
   * {@link RenditionClassType#RenditionClassType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewRenditionClassType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RenditionClassType actualRenditionClassType = new RenditionClassType(metadata, "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualRenditionClassType.getNamespace());
    assertEquals("Prefix", actualRenditionClassType.getPrefix());
    assertEquals("Property Name", actualRenditionClassType.getPropertyName());
    assertEquals("Value", actualRenditionClassType.getStringValue());
    assertEquals("Value", actualRenditionClassType.getRawValue());
    assertEquals("Value", actualRenditionClassType.getValue());
    assertTrue(actualRenditionClassType.getAllAttributes().isEmpty());
    assertSame(metadata, actualRenditionClassType.getMetadata());
  }
}
