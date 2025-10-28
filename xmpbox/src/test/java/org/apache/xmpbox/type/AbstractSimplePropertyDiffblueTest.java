package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class AbstractSimplePropertyDiffblueTest {
  /**
   * Method under test: {@link AbstractSimpleProperty#getRawValue()}
   */
  @Test
  void testGetRawValue() {
    // Arrange, Act and Assert
    assertEquals("Value",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .getRawValue());
  }

  /**
   * Method under test: {@link AbstractSimpleProperty#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("[AgentNameType:Value]",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .toString());
  }

  /**
   * Method under test: {@link AbstractSimpleProperty#getNamespace()}
   */
  @Test
  void testGetNamespace() {
    // Arrange, Act and Assert
    assertEquals("Namespace URI",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .getNamespace());
  }

  /**
   * Method under test: {@link AbstractSimpleProperty#getPrefix()}
   */
  @Test
  void testGetPrefix() {
    // Arrange, Act and Assert
    assertEquals("Prefix",
        (new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"))
            .getPrefix());
  }
}
