package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class AgentNameTypeDiffblueTest {
  /**
   * Method under test:
   * {@link AgentNameType#AgentNameType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewAgentNameType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AgentNameType actualAgentNameType = new AgentNameType(metadata, "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Assert
    assertEquals("Namespace URI", actualAgentNameType.getNamespace());
    assertEquals("Prefix", actualAgentNameType.getPrefix());
    assertEquals("Property Name", actualAgentNameType.getPropertyName());
    assertEquals("Value", actualAgentNameType.getStringValue());
    assertEquals("Value", actualAgentNameType.getRawValue());
    assertEquals("Value", actualAgentNameType.getValue());
    assertTrue(actualAgentNameType.getAllAttributes().isEmpty());
    assertSame(metadata, actualAgentNameType.getMetadata());
  }
}
