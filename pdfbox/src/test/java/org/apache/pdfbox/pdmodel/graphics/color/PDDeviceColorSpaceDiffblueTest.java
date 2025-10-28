package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDDeviceColorSpaceDiffblueTest {
  /**
   * Method under test: {@link PDDeviceColorSpace#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("DeviceCMYK", (new PDDeviceCMYK()).toString());
  }

  /**
   * Method under test: {@link PDDeviceColorSpace#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDDeviceCMYK()).getCOSObject();

    // Assert
    assertSame(((COSName) actualCOSObject).DEVICECMYK, actualCOSObject);
  }
}
