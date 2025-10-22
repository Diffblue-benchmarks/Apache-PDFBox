package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GPSCoordinateTypeDiffblueTest {
  /**
   * Test {@link GPSCoordinateType#GPSCoordinateType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GPSCoordinateType#GPSCoordinateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new GPSCoordinateType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GPSCoordinateType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewGPSCoordinateType_whenValue_thenReturnNamespaceIsNamespaceUri() {
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
