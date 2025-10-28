package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DeviceNColorantDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceNColorant}
   *   <li>{@link DeviceNColorant#setName(String)}
   *   <li>{@link DeviceNColorant#getMaximum()}
   *   <li>{@link DeviceNColorant#getMinimum()}
   *   <li>{@link DeviceNColorant#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceNColorant actualDeviceNColorant = new DeviceNColorant();
    actualDeviceNColorant.setName("Name");
    actualDeviceNColorant.getMaximum();
    actualDeviceNColorant.getMinimum();

    // Assert that nothing has changed
    assertEquals("Name", actualDeviceNColorant.getName());
  }
}
