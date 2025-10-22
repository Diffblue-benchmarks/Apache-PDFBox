package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceSettingsTypeDiffblueTest {
  /**
   * Test {@link DeviceSettingsType#DeviceSettingsType(XMPMetadata)}.
   * <p>
   * Method under test: {@link DeviceSettingsType#DeviceSettingsType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new DeviceSettingsType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSettingsType.<init>(XMPMetadata)"})
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
    assertTrue(actualDeviceSettingsType.getAllProperties().isEmpty());
    assertTrue(actualDeviceSettingsType.getAllAttributes().isEmpty());
    assertTrue(actualDeviceSettingsType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualDeviceSettingsType.getMetadata());
  }
}
