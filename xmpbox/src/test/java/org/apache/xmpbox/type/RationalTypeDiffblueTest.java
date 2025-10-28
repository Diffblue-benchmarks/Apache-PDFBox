package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class RationalTypeDiffblueTest {
  /**
   * Method under test:
   * {@link RationalType#RationalType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewRationalType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RationalType actualRationalType = new RationalType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualRationalType.getNamespace());
    assertEquals("Prefix", actualRationalType.getPrefix());
    assertEquals("Property Name", actualRationalType.getPropertyName());
    assertEquals("Value", actualRationalType.getStringValue());
    assertEquals("Value", actualRationalType.getRawValue());
    assertEquals("Value", actualRationalType.getValue());
    assertTrue(actualRationalType.getAllAttributes().isEmpty());
    assertSame(metadata, actualRationalType.getMetadata());
  }
}
