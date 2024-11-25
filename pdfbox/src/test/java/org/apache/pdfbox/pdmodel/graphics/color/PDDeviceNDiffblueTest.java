package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDDeviceNDiffblueTest {
  /**
   * Test {@link PDDeviceN#PDDeviceN()}.
   * <p>
   * Method under test: {@link PDDeviceN#PDDeviceN()}
   */
  @Test
  @DisplayName("Test new PDDeviceN()")
  void testNewPDDeviceN() {
    // Arrange and Act
    PDDeviceN actualPdDeviceN = new PDDeviceN();

    // Assert
    COSBase cOSObject = actualPdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSNull);
    assertEquals("DeviceN", ((COSName) getResult).getName());
    assertEquals("DeviceN", actualPdDeviceN.getName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(actualPdDeviceN.getInitialColor());
    assertNull(actualPdDeviceN.getAttributes());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
    assertFalse(actualPdDeviceN.isNChannel());
    assertSame(getResult2, toListResult.get(2));
    assertSame(getResult2, toListResult.get(3));
  }

  /**
   * Test {@link PDDeviceN#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDDeviceN#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
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
   * Test {@link PDDeviceN#setColorantNames(List)}.
   * <p>
   * Method under test: {@link PDDeviceN#setColorantNames(List)}
   */
  @Test
  @DisplayName("Test setColorantNames(List)")
  void testSetColorantNames() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    pdDeviceN.setColorantNames(new ArrayList<>());

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSNull);
    assertNull(getResult2.getKey());
    assertEquals(0, pdDeviceN.getNumberOfComponents());
    assertFalse(getResult2.isDirect());
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertTrue(pdDeviceN.getColorantNames().isEmpty());
    assertSame(getResult2, toListResult.get(3));
  }

  /**
   * Test {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}.
   * <p>
   * Method under test: {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}
   */
  @Test
  @DisplayName("Test setAttributes(PDDeviceNAttributes)")
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
