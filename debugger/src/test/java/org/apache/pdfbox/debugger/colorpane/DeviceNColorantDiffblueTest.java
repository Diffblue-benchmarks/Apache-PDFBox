package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceNColorant.<init>()", "Color DeviceNColorant.getMaximum()",
      "Color DeviceNColorant.getMinimum()", "String DeviceNColorant.getName()",
      "void DeviceNColorant.setMaximum(Color)", "void DeviceNColorant.setMinimum(Color)",
      "void DeviceNColorant.setName(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceNColorant actualDeviceNColorant = new DeviceNColorant();
    actualDeviceNColorant.setName("Name");
    Color actualMaximum = actualDeviceNColorant.getMaximum();
    Color actualMinimum = actualDeviceNColorant.getMinimum();

    // Assert
    assertEquals("Name", actualDeviceNColorant.getName());
    assertNull(actualMaximum);
    assertNull(actualMinimum);
  }
}
