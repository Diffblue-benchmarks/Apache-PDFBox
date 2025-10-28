package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PDCIEBasedColorSpaceDiffblueTest {
  /**
   * Method under test: {@link PDCIEBasedColorSpace#toRawImage(WritableRaster)}
   */
  @Test
  void testToRawImage() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCalGray()).toRawImage(null));
  }

  /**
   * Method under test: {@link PDCIEBasedColorSpace#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("CalGray", (new PDCalGray()).toString());
  }
}
