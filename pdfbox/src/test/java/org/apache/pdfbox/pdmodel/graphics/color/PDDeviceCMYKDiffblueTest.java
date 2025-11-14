package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.color.ICC_Profile;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDeviceCMYKDiffblueTest {
  /**
   * Test {@link PDDeviceCMYK#getICCProfile()}.
   *
   * <p>Method under test: {@link PDDeviceCMYK#getICCProfile()}
   */
  @Test
  @DisplayName("Test getICCProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ICC_Profile PDDeviceCMYK.getICCProfile()"})
  void testGetICCProfile() throws IOException {
    // Arrange and Act
    ICC_Profile actualICCProfile = new PDDeviceCMYK().getICCProfile();

    // Assert
    assertEquals(0, actualICCProfile.getProfileClass());
    assertEquals(1, actualICCProfile.getPCSType());
    assertEquals(2, actualICCProfile.getMajorVersion());
    assertEquals(4, actualICCProfile.getNumComponents());
    assertEquals(8532, actualICCProfile.getData().length);
    assertEquals(9, actualICCProfile.getColorSpaceType());
    assertEquals(Short.SIZE, actualICCProfile.getMinorVersion());
  }

  /**
   * Test {@link PDDeviceCMYK#getName()}.
   *
   * <p>Method under test: {@link PDDeviceCMYK#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDDeviceCMYK.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceCMYK", new PDDeviceCMYK().getName());
  }

  /**
   * Test {@link PDDeviceCMYK#getDefaultDecode(int)}.
   *
   * <p>Method under test: {@link PDDeviceCMYK#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDDeviceCMYK.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f},
        new PDDeviceCMYK().getDefaultDecode(1),
        0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDDeviceCMYK#getInitialColor()}
   *   <li>{@link PDDeviceCMYK#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDColor PDDeviceCMYK.getInitialColor()",
    "int PDDeviceCMYK.getNumberOfComponents()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDDeviceCMYK pdDeviceCMYK = new PDDeviceCMYK();

    // Act
    PDColor actualInitialColor = pdDeviceCMYK.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(4, pdDeviceCMYK.getNumberOfComponents());
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdDeviceCMYK, actualInitialColor.getColorSpace());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f, 1.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDDeviceCMYK#toRGB(float[])}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceCMYK#PDDeviceCMYK()}.
   *   <li>Then return array of {@code float} with zero and {@code 0.6499733}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceCMYK#toRGB(float[])}
   */
  @Test
  @DisplayName(
      "Test toRGB(float[]); given PDDeviceCMYK(); then return array of float with zero and '0.6499733'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDDeviceCMYK.toRGB(float[])"})
  void testToRGB_givenPDDeviceCMYK_thenReturnArrayOfFloatWithZeroAnd06499733() throws IOException {
    // Arrange and Act
    float[] actualToRGBResult = new PDDeviceCMYK().toRGB(new float[] {10.0f, -1.0f, 10.0f, -1.0f});

    // Assert
    assertArrayEquals(new float[] {0.0f, 0.6499733f, 0.31564814f}, actualToRGBResult, 0.0f);
  }

  /**
   * Test {@link PDDeviceCMYK#toRawImage(WritableRaster)} with {@code raster}.
   *
   * <p>Method under test: {@link PDDeviceCMYK#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDDeviceCMYK.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDDeviceCMYK().toRawImage(null));
  }
}
