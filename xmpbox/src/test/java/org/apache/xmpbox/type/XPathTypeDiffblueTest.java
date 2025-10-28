package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class XPathTypeDiffblueTest {
  /**
   * Method under test:
   * {@link XPathType#XPathType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewXPathType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XPathType actualXPathType = new XPathType(metadata, "Namespace URI", "Prefix", "Property Name", "Value");

    // Assert
    assertEquals("Namespace URI", actualXPathType.getNamespace());
    assertEquals("Prefix", actualXPathType.getPrefix());
    assertEquals("Property Name", actualXPathType.getPropertyName());
    assertEquals("Value", actualXPathType.getStringValue());
    assertEquals("Value", actualXPathType.getRawValue());
    assertEquals("Value", actualXPathType.getValue());
    assertTrue(actualXPathType.getAllAttributes().isEmpty());
    assertSame(metadata, actualXPathType.getMetadata());
  }
}
