package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class PartTypeDiffblueTest {
  /**
   * Method under test:
   * {@link PartType#PartType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewPartType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PartType actualPartType = new PartType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualPartType.getNamespace());
    assertEquals("Prefix", actualPartType.getPrefix());
    assertEquals("Property Name", actualPartType.getPropertyName());
    assertEquals("Value", actualPartType.getStringValue());
    assertEquals("Value", actualPartType.getRawValue());
    assertEquals("Value", actualPartType.getValue());
    assertTrue(actualPartType.getAllAttributes().isEmpty());
    assertSame(metadata, actualPartType.getMetadata());
  }
}
