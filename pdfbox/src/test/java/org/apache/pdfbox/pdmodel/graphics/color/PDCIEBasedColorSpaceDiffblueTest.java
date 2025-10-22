package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCIEBasedColorSpaceDiffblueTest {
  /**
   * Test {@link PDCIEBasedColorSpace#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDCIEBasedColorSpace#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.BufferedImage PDCIEBasedColorSpace.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCalGray()).toRawImage(null));
  }

  /**
   * Test {@link PDCIEBasedColorSpace#toString()}.
   * <p>
   * Method under test: {@link PDCIEBasedColorSpace#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDCIEBasedColorSpace.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("CalGray", (new PDCalGray()).toString());
  }
}
