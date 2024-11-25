package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RenditionClassTypeDiffblueTest {
  /**
   * Test
   * {@link RenditionClassType#RenditionClassType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RenditionClassType#RenditionClassType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new RenditionClassType(XMPMetadata, String, String, String, Object); when 'Value'; then return Namespace is 'Namespace URI'")
  void testNewRenditionClassType_whenValue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RenditionClassType actualRenditionClassType = new RenditionClassType(metadata, "Namespace URI", "Prefix",
        "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualRenditionClassType.getNamespace());
    assertEquals("Prefix", actualRenditionClassType.getPrefix());
    assertEquals("Property Name", actualRenditionClassType.getPropertyName());
    assertEquals("Value", actualRenditionClassType.getStringValue());
    assertEquals("Value", actualRenditionClassType.getRawValue());
    assertEquals("Value", actualRenditionClassType.getValue());
    assertTrue(actualRenditionClassType.getAllAttributes().isEmpty());
    assertSame(metadata, actualRenditionClassType.getMetadata());
  }
}
