package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceNColorantDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
