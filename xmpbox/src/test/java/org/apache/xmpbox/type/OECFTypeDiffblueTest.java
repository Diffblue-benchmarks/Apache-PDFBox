package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OECFTypeDiffblueTest {
  /**
   * Test {@link OECFType#OECFType(XMPMetadata)}.
   * <p>
   * Method under test: {@link OECFType#OECFType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new OECFType(XMPMetadata)")
  void testNewOECFType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    OECFType actualOecfType = new OECFType(metadata);

    // Assert
    assertEquals("exif", actualOecfType.getPreferedPrefix());
    assertEquals("exif", actualOecfType.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualOecfType.getNamespace());
    assertNull(actualOecfType.getPropertyName());
    List<AbstractField> allProperties = actualOecfType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualOecfType.getAllAttributes().isEmpty());
    assertTrue(actualOecfType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualOecfType.getContainer().getAllProperties());
    assertSame(metadata, actualOecfType.getMetadata());
  }
}
