package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class ChoiceTypeDiffblueTest {
  /**
   * Method under test:
   * {@link ChoiceType#ChoiceType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewChoiceType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ChoiceType actualChoiceType = new ChoiceType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualChoiceType.getNamespace());
    assertEquals("Prefix", actualChoiceType.getPrefix());
    assertEquals("Property Name", actualChoiceType.getPropertyName());
    assertEquals("Value", actualChoiceType.getStringValue());
    assertEquals("Value", actualChoiceType.getRawValue());
    assertEquals("Value", actualChoiceType.getValue());
    assertTrue(actualChoiceType.getAllAttributes().isEmpty());
    assertSame(metadata, actualChoiceType.getMetadata());
  }
}
