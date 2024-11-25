package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class URITypeDiffblueTest {
  /**
   * Test {@link URIType#URIType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URIType#URIType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new URIType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  void testNewURIType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    URIType actualUriType = new URIType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualUriType.getNamespace());
    assertEquals("Prefix", actualUriType.getPrefix());
    assertEquals("Property Name", actualUriType.getPropertyName());
    assertEquals("Value", actualUriType.getStringValue());
    assertEquals("Value", actualUriType.getRawValue());
    assertEquals("Value", actualUriType.getValue());
    assertTrue(actualUriType.getAllAttributes().isEmpty());
    assertSame(metadata, actualUriType.getMetadata());
  }
}
