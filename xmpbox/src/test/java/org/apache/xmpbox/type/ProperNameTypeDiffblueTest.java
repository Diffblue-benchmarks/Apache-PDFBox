package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class ProperNameTypeDiffblueTest {
  /**
   * Method under test:
   * {@link ProperNameType#ProperNameType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewProperNameType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ProperNameType actualProperNameType = new ProperNameType(metadata, "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Assert
    assertEquals("Namespace URI", actualProperNameType.getNamespace());
    assertEquals("Prefix", actualProperNameType.getPrefix());
    assertEquals("Property Name", actualProperNameType.getPropertyName());
    assertEquals("Value", actualProperNameType.getStringValue());
    assertEquals("Value", actualProperNameType.getRawValue());
    assertEquals("Value", actualProperNameType.getValue());
    assertTrue(actualProperNameType.getAllAttributes().isEmpty());
    assertSame(metadata, actualProperNameType.getMetadata());
  }
}
