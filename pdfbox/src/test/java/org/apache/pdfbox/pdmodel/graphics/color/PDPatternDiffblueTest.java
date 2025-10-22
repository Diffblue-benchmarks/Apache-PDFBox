package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDShadingPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPatternDiffblueTest {
  /**
   * Test {@link PDPattern#PDPattern(PDResources, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return UnderlyingColorSpace is {@link PDDeviceGray#INSTANCE} {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPattern#PDPattern(PDResources, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDPattern(PDResources, PDColorSpace); when INSTANCE; then return UnderlyingColorSpace is INSTANCE INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPattern.<init>(PDResources, PDColorSpace)"})
  void testNewPDPattern_whenInstance_thenReturnUnderlyingColorSpaceIsInstanceInstance() {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDPattern actualPdPattern = new PDPattern(new PDResources(), colorSpace);

    // Assert
    COSBase cOSObject = actualPdPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(2, ((COSArray) cOSObject).toList().size());
    PDDeviceGray expectedUnderlyingColorSpace = colorSpace.INSTANCE;
    assertSame(expectedUnderlyingColorSpace, actualPdPattern.getUnderlyingColorSpace());
    assertArrayEquals(new float[]{}, actualPdPattern.getInitialColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDPattern#PDPattern(PDResources, PDColorSpace)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then COSObject toList first return {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPattern#PDPattern(PDResources, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDPattern(PDResources, PDColorSpace); when 'null'; then COSObject toList first return COSName")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPattern.<init>(PDResources, PDColorSpace)"})
  void testNewPDPattern_whenNull_thenCOSObjectToListFirstReturnCOSName() {
    // Arrange and Act
    PDPattern actualPdPattern = new PDPattern(new PDResources(), null);

    // Assert
    COSBase cOSObject = actualPdPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSName);
    assertEquals("Pattern", actualPdPattern.getName());
    assertNull(toListResult.get(1));
    PDColor initialColor = actualPdPattern.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(actualPdPattern.getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertArrayEquals(new float[]{}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDPattern#PDPattern(PDResources, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return UnderlyingColorSpace is {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPattern#PDPattern(PDResources, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDPattern(PDResources, PDColorSpace); when PDCalGray(); then return UnderlyingColorSpace is PDCalGray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPattern.<init>(PDResources, PDColorSpace)"})
  void testNewPDPattern_whenPDCalGray_thenReturnUnderlyingColorSpaceIsPDCalGray() {
    // Arrange
    PDResources resources = new PDResources();
    PDCalGray colorSpace = new PDCalGray();

    // Act
    PDPattern actualPdPattern = new PDPattern(resources, colorSpace);

    // Assert
    assertSame(colorSpace, actualPdPattern.getUnderlyingColorSpace());
    assertArrayEquals(new float[]{}, actualPdPattern.getInitialColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDPattern#getName()}.
   * <p>
   * Method under test: {@link PDPattern#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDPattern.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Pattern", (new PDPattern(new PDResources())).getName());
  }

  /**
   * Test {@link PDPattern#getNumberOfComponents()}.
   * <p>
   * Method under test: {@link PDPattern#getNumberOfComponents()}
   */
  @Test
  @DisplayName("Test getNumberOfComponents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPattern.getNumberOfComponents()"})
  void testGetNumberOfComponents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).getNumberOfComponents());
  }

  /**
   * Test {@link PDPattern#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDPattern#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDPattern.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).getDefaultDecode(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPattern#toString()}
   *   <li>{@link PDPattern#getInitialColor()}
   *   <li>{@link PDPattern#getUnderlyingColorSpace()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColor PDPattern.getInitialColor()", "PDColorSpace PDPattern.getUnderlyingColorSpace()",
      "String PDPattern.toString()"})
  void testGettersAndSetters() {
    // Arrange
    PDPattern pdPattern = new PDPattern(new PDResources());

    // Act
    String actualToStringResult = pdPattern.toString();
    PDColor actualInitialColor = pdPattern.getInitialColor();
    PDColorSpace actualUnderlyingColorSpace = pdPattern.getUnderlyingColorSpace();

    // Assert
    assertEquals("Pattern", actualToStringResult);
    assertNull(actualInitialColor.getPatternName());
    assertNull(actualInitialColor.getColorSpace());
    assertNull(actualUnderlyingColorSpace);
    assertFalse(actualInitialColor.isPattern());
    assertArrayEquals(new float[]{}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDPattern#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDPattern#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDPattern.toRGB(float[])"})
  void testToRGB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDPattern(new PDResources())).toRGB(new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
  }

  /**
   * Test {@link PDPattern#toRGBImage(WritableRaster)}.
   * <p>
   * Method under test: {@link PDPattern#toRGBImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRGBImage(WritableRaster)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.BufferedImage PDPattern.toRGBImage(WritableRaster)"})
  void testToRGBImage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).toRGBImage(null));
  }

  /**
   * Test {@link PDPattern#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDPattern#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.BufferedImage PDPattern.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).toRawImage(null));
  }

  /**
   * Test {@link PDPattern#getPattern(PDColor)}.
   * <p>
   * Method under test: {@link PDPattern#getPattern(PDColor)}
   */
  @Test
  @DisplayName("Test getPattern(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern PDPattern.getPattern(PDColor)"})
  void testGetPattern() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDPattern pdPattern = new PDPattern(new PDResources(resourceDictionary, new DefaultResourceCache()));

    // Act and Assert
    assertThrows(IOException.class, () -> pdPattern.getPattern(new PDColor(new COSArray(), PDDeviceGray.INSTANCE)));
  }

  /**
   * Test {@link PDPattern#getPattern(PDColor)}.
   * <ul>
   *   <li>Given {@link PDPattern#PDPattern(PDResources)} with resources is {@link PDResources#PDResources()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPattern#getPattern(PDColor)}
   */
  @Test
  @DisplayName("Test getPattern(PDColor); given PDPattern(PDResources) with resources is PDResources(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern PDPattern.getPattern(PDColor)"})
  void testGetPattern_givenPDPatternWithResourcesIsPDResources_thenThrowIOException() throws IOException {
    // Arrange
    PDPattern pdPattern = new PDPattern(new PDResources());

    // Act and Assert
    assertThrows(IOException.class, () -> pdPattern.getPattern(new PDColor(new COSArray(), PDDeviceGray.INSTANCE)));
  }

  /**
   * Test {@link PDPattern#getPattern(PDColor)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDShadingPattern#PDShadingPattern()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPattern#getPattern(PDColor)}
   */
  @Test
  @DisplayName("Test getPattern(PDColor); given PDResources() add PDShadingPattern(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern PDPattern.getPattern(PDColor)"})
  void testGetPattern_givenPDResourcesAddPDShadingPattern_thenThrowIOException() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDShadingPattern());
    PDPattern pdPattern = new PDPattern(resources);

    // Act and Assert
    assertThrows(IOException.class, () -> pdPattern.getPattern(new PDColor(new COSArray(), PDDeviceGray.INSTANCE)));
  }
}
