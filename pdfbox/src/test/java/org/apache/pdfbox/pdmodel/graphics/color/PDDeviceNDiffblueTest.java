package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.junit.jupiter.api.Test;

class PDDeviceNDiffblueTest {
  /**
   * Method under test: {@link PDDeviceN#toRawImage(WritableRaster)}
   */
  @Test
  void testToRawImage() {
    // Arrange, Act and Assert
    assertNull((new PDDeviceN()).toRawImage(null));
  }

  /**
   * Method under test: {@link PDDeviceN#isNChannel()}
   */
  @Test
  void testIsNChannel() {
    // Arrange, Act and Assert
    assertFalse((new PDDeviceN()).isNChannel());
  }

  /**
   * Method under test: {@link PDDeviceN#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceN", (new PDDeviceN()).getName());
  }

  /**
   * Method under test: {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}
   */
  @Test
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
   * Method under test: {@link PDDeviceN#setAlternateColorSpace(PDColorSpace)}
   */
  @Test
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
   * Method under test: {@link PDDeviceN#setTintTransform(PDFunction)}
   */
  @Test
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

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceN#getAttributes()}
   *   <li>{@link PDDeviceN#getInitialColor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    PDDeviceNAttributes actualAttributes = pdDeviceN.getAttributes();

    // Assert
    assertNull(pdDeviceN.getInitialColor());
    assertNull(actualAttributes);
  }
}
