package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDeviceNDiffblueTest {
  /**
   * Test {@link PDDeviceN#PDDeviceN()}.
   * <p>
   * Method under test: {@link PDDeviceN#PDDeviceN()}
   */
  @Test
  @DisplayName("Test new PDDeviceN()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDeviceN.<init>()"})
  void testNewPDDeviceN() {
    // Arrange and Act
    PDDeviceN actualPdDeviceN = new PDDeviceN();

    // Assert
    COSBase cOSObject = actualPdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSName);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSNull);
    assertEquals("DeviceN", actualPdDeviceN.getName());
    assertNull(actualPdDeviceN.getInitialColor());
    assertNull(actualPdDeviceN.getAttributes());
    assertFalse(actualPdDeviceN.isNChannel());
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Test {@link PDDeviceN#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDDeviceN#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.BufferedImage PDDeviceN.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() {
    // Arrange, Act and Assert
    assertNull((new PDDeviceN()).toRawImage(null));
  }

  /**
   * Test {@link PDDeviceN#isNChannel()}.
   * <p>
   * Method under test: {@link PDDeviceN#isNChannel()}
   */
  @Test
  @DisplayName("Test isNChannel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDDeviceN.isNChannel()"})
  void testIsNChannel() {
    // Arrange, Act and Assert
    assertFalse((new PDDeviceN()).isNChannel());
  }

  /**
   * Test {@link PDDeviceN#getName()}.
   * <p>
   * Method under test: {@link PDDeviceN#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDDeviceN.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceN", (new PDDeviceN()).getName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceN#getAttributes()}
   *   <li>{@link PDDeviceN#getInitialColor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDeviceNAttributes PDDeviceN.getAttributes()",
      "org.apache.pdfbox.pdmodel.graphics.color.PDColor PDDeviceN.getInitialColor()"})
  void testGettersAndSetters() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    PDDeviceNAttributes actualAttributes = pdDeviceN.getAttributes();

    // Assert
    assertNull(pdDeviceN.getInitialColor());
    assertNull(actualAttributes);
  }

  /**
   * Test {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}.
   * <p>
   * Method under test: {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}
   */
  @Test
  @DisplayName("Test setAttributes(PDDeviceNAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDeviceN.setAttributes(PDDeviceNAttributes)"})
  void testSetAttributes() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();
    PDDeviceNAttributes attributes = new PDDeviceNAttributes();

    // Act
    pdDeviceN.setAttributes(attributes);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(5, ((COSArray) cOSObject).toList().size());
    assertSame(attributes, pdDeviceN.getAttributes());
  }

  /**
   * Test {@link PDDeviceN#setAlternateColorSpace(PDColorSpace)}.
   * <p>
   * Method under test: {@link PDDeviceN#setAlternateColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setAlternateColorSpace(PDColorSpace)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDeviceN.setAlternateColorSpace(PDColorSpace)"})
  void testSetAlternateColorSpace() throws IOException {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();
    PDDeviceGray cs = PDDeviceGray.INSTANCE;

    // Act
    pdDeviceN.setAlternateColorSpace(cs);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(4, ((COSArray) cOSObject).toList().size());
    PDDeviceGray expectedAlternateColorSpace = cs.INSTANCE;
    assertSame(expectedAlternateColorSpace, pdDeviceN.getAlternateColorSpace());
  }

  /**
   * Test {@link PDDeviceN#setTintTransform(PDFunction)}.
   * <p>
   * Method under test: {@link PDDeviceN#setTintTransform(PDFunction)}
   */
  @Test
  @DisplayName("Test setTintTransform(PDFunction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDeviceN.setTintTransform(PDFunction)"})
  void testSetTintTransform() throws IOException {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();
    PDFunctionType0 tint = new PDFunctionType0(COSBoolean.FALSE);

    // Act
    pdDeviceN.setTintTransform(tint);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(3));
    assertSame(tint, pdDeviceN.getTintTransform());
  }
}
