package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDeviceColorSpaceDiffblueTest {
  /**
   * Test {@link PDDeviceColorSpace#toString()}.
   * <p>
   * Method under test: {@link PDDeviceColorSpace#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDDeviceColorSpace.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("DeviceCMYK", (new PDDeviceCMYK()).toString());
  }

  /**
   * Test {@link PDDeviceColorSpace#getCOSObject()}.
   * <p>
   * Method under test: {@link PDDeviceColorSpace#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDDeviceColorSpace.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDDeviceCMYK()).getCOSObject();

    // Assert
    assertSame(((COSName) actualCOSObject).DEVICECMYK, actualCOSObject);
  }
}
