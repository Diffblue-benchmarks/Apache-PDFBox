package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class GPSCoordinateTypeDiffblueTest {
  /**
   * Method under test:
   * {@link GPSCoordinateType#GPSCoordinateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewGPSCoordinateType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    GPSCoordinateType actualGpsCoordinateType = new GPSCoordinateType(metadata, "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualGpsCoordinateType.getNamespace());
    assertEquals("Prefix", actualGpsCoordinateType.getPrefix());
    assertEquals("Property Name", actualGpsCoordinateType.getPropertyName());
    assertEquals("Value", actualGpsCoordinateType.getStringValue());
    assertEquals("Value", actualGpsCoordinateType.getRawValue());
    assertEquals("Value", actualGpsCoordinateType.getValue());
    assertTrue(actualGpsCoordinateType.getAllAttributes().isEmpty());
    assertSame(metadata, actualGpsCoordinateType.getMetadata());
  }
}
