package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class GUIDTypeDiffblueTest {
  /**
   * Method under test:
   * {@link GUIDType#GUIDType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewGUIDType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    GUIDType actualGuidType = new GUIDType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualGuidType.getNamespace());
    assertEquals("Prefix", actualGuidType.getPrefix());
    assertEquals("Property Name", actualGuidType.getPropertyName());
    assertEquals("Value", actualGuidType.getStringValue());
    assertEquals("Value", actualGuidType.getRawValue());
    assertEquals("Value", actualGuidType.getValue());
    assertTrue(actualGuidType.getAllAttributes().isEmpty());
    assertSame(metadata, actualGuidType.getMetadata());
  }
}
