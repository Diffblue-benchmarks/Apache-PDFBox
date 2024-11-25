package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceSettingsTypeDiffblueTest {
  /**
   * Test {@link DeviceSettingsType#DeviceSettingsType(XMPMetadata)}.
   * <p>
   * Method under test: {@link DeviceSettingsType#DeviceSettingsType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new DeviceSettingsType(XMPMetadata)")
  void testNewDeviceSettingsType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DeviceSettingsType actualDeviceSettingsType = new DeviceSettingsType(metadata);

    // Assert
    assertEquals("exif", actualDeviceSettingsType.getPreferedPrefix());
    assertEquals("exif", actualDeviceSettingsType.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualDeviceSettingsType.getNamespace());
    assertNull(actualDeviceSettingsType.getPropertyName());
    List<AbstractField> allProperties = actualDeviceSettingsType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualDeviceSettingsType.getAllAttributes().isEmpty());
    assertTrue(actualDeviceSettingsType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualDeviceSettingsType.getContainer().getAllProperties());
    assertSame(metadata, actualDeviceSettingsType.getMetadata());
  }
}
