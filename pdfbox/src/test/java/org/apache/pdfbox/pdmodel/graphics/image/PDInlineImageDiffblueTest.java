package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_ProfileRGB;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.Test;

class PDInlineImageDiffblueTest {
  /**
   * Method under test: {@link PDInlineImage#getCOSObject()}
   */
  @Test
  void testGetCOSObject() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(parameters, (new PDInlineImage(parameters, data, new PDResources())).getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  void testGetBitsPerComponent() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getBitsPerComponent());
  }

  /**
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  void testGetBitsPerComponent2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setBitsPerComponent(7);

    // Act and Assert
    assertEquals(7, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  void testGetBitsPerComponent3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(true);

    // Act and Assert
    assertEquals(1, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  void testGetBitsPerComponent4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertEquals(-1, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Method under test: {@link PDInlineImage#setBitsPerComponent(int)}
   */
  @Test
  void testSetBitsPerComponent() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setBitsPerComponent(1);

    // Assert
    assertEquals(1, pdInlineImage.getBitsPerComponent());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setBitsPerComponent(int)}
   */
  @Test
  void testSetBitsPerComponent2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setBitsPerComponent(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdInlineImage.getBitsPerComponent());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getColorSpace());
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdInlineImage.getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(true);

    // Act
    PDColorSpace actualColorSpace = pdInlineImage.getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, "AXAXAXAX".getBytes("UTF-8"), null);
    pdInlineImage.setColorSpace(PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdInlineImage.getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace5() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(PDDeviceGray.INSTANCE);
    COSDictionary parameters = new COSDictionary();

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, "AXAXAXAX".getBytes("UTF-8"), resources);
    pdInlineImage.setColorSpace(PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdInlineImage.getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace6() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(PDDeviceRGB.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdInlineImage.getColorSpace();

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace7() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getColorSpace());
  }

  /**
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  void testGetColorSpace8() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getColorSpace());
  }

  /**
   * Method under test: {@link PDInlineImage#setColorSpace(PDColorSpace)}
   */
  @Test
  void testSetColorSpace() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    pdInlineImage.setColorSpace(colorSpace);

    // Assert
    assertSame(parameters, pdInlineImage.getCOSObject());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, pdInlineImage.getColorSpace());
  }

  /**
   * Method under test: {@link PDInlineImage#setColorSpace(PDColorSpace)}
   */
  @Test
  void testSetColorSpace2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setColorSpace(new PDCalGray());

    // Assert
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setColorSpace(PDColorSpace)}
   */
  @Test
  void testSetColorSpace3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setColorSpace(null);

    // Assert
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#getHeight()}
   */
  @Test
  void testGetHeight() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getHeight());
  }

  /**
   * Method under test: {@link PDInlineImage#getHeight()}
   */
  @Test
  void testGetHeight2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setHeight(-1);

    // Act and Assert
    assertEquals(-1, pdInlineImage.getHeight());
  }

  /**
   * Method under test: {@link PDInlineImage#setHeight(int)}
   */
  @Test
  void testSetHeight() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setHeight(1);

    // Assert
    assertEquals(1, pdInlineImage.getHeight());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setHeight(int)}
   */
  @Test
  void testSetHeight2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setHeight(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdInlineImage.getHeight());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#getWidth()}
   */
  @Test
  void testGetWidth() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getWidth());
  }

  /**
   * Method under test: {@link PDInlineImage#getWidth()}
   */
  @Test
  void testGetWidth2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setWidth(1);

    // Act and Assert
    assertEquals(1, pdInlineImage.getWidth());
  }

  /**
   * Method under test: {@link PDInlineImage#setWidth(int)}
   */
  @Test
  void testSetWidth() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setWidth(1);

    // Assert
    assertEquals(1, pdInlineImage.getWidth());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setWidth(int)}
   */
  @Test
  void testSetWidth2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setWidth(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdInlineImage.getWidth());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#getInterpolate()}
   */
  @Test
  void testGetInterpolate() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).getInterpolate());
  }

  /**
   * Method under test: {@link PDInlineImage#getInterpolate()}
   */
  @Test
  void testGetInterpolate2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setInterpolate(true);

    // Act and Assert
    assertTrue(pdInlineImage.getInterpolate());
  }

  /**
   * Method under test: {@link PDInlineImage#getInterpolate()}
   */
  @Test
  void testGetInterpolate3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setInterpolate(false);

    // Act and Assert
    assertFalse(pdInlineImage.getInterpolate());
  }

  /**
   * Method under test: {@link PDInlineImage#setInterpolate(boolean)}
   */
  @Test
  void testSetInterpolate() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setInterpolate(true);

    // Assert
    assertTrue(pdInlineImage.getInterpolate());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setInterpolate(boolean)}
   */
  @Test
  void testSetInterpolate2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setInterpolate(false);

    // Assert
    assertFalse(pdInlineImage.getInterpolate());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  void testGetFilters() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new PDInlineImage(parameters, data, new PDResources())).getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  void testGetFilters2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(new ArrayList<>());

    // Act and Assert
    assertTrue(pdInlineImage.getFilters().isEmpty());
  }

  /**
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  void testGetFilters3() throws IOException {
    // Arrange
    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(filters);

    // Act
    List<String> actualFilters = pdInlineImage.getFilters();

    // Assert
    assertEquals(1, actualFilters.size());
    assertEquals("foo", actualFilters.get(0));
  }

  /**
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  void testGetFilters4() throws IOException {
    // Arrange
    ArrayList<String> filters = new ArrayList<>();
    filters.add("42");
    filters.add("foo");
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(filters);

    // Act and Assert
    assertEquals(filters, pdInlineImage.getFilters());
  }

  /**
   * Method under test: {@link PDInlineImage#setFilters(List)}
   */
  @Test
  void testSetFilters() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setFilters(new ArrayList<>());

    // Assert
    assertTrue(pdInlineImage.getFilters().isEmpty());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setFilters(List)}
   */
  @Test
  void testSetFilters2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");

    // Act
    pdInlineImage.setFilters(filters);

    // Assert
    List<String> filters2 = pdInlineImage.getFilters();
    assertEquals(1, filters2.size());
    assertEquals("foo", filters2.get(0));
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setFilters(List)}
   */
  @Test
  void testSetFilters3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    ArrayList<String> filters = new ArrayList<>();
    filters.add("42");
    filters.add("foo");

    // Act
    pdInlineImage.setFilters(filters);

    // Assert
    assertEquals(filters, pdInlineImage.getFilters());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setDecode(COSArray)}
   */
  @Test
  void testSetDecode() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    COSArray decode = new COSArray();

    // Act
    pdInlineImage.setDecode(decode);

    // Assert
    assertSame(decode, pdInlineImage.getDecode());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setDecode(COSArray)}
   */
  @Test
  void testSetDecode2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setDecode(null);

    // Assert
    assertNull(pdInlineImage.getDecode());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#setDecode(COSArray)}
   */
  @Test
  void testSetDecode3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray decode = new COSArray();
    decode.add(object);

    // Act
    pdInlineImage.setDecode(decode);

    // Assert
    verify(object).getCOSObject();
    assertSame(decode, pdInlineImage.getDecode());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#getDecode()}
   */
  @Test
  void testGetDecode() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new PDInlineImage(parameters, data, new PDResources())).getDecode());
  }

  /**
   * Method under test: {@link PDInlineImage#getDecode()}
   */
  @Test
  void testGetDecode2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    COSArray decode = new COSArray();
    pdInlineImage.setDecode(decode);

    // Act
    COSArray actualDecode = pdInlineImage.getDecode();

    // Assert
    assertTrue(actualDecode.toList().isEmpty());
    assertSame(decode, actualDecode);
  }

  /**
   * Method under test: {@link PDInlineImage#getDecode()}
   */
  @Test
  void testGetDecode3() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray decode = new COSArray();
    decode.add(object);
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setDecode(decode);

    // Act
    COSArray actualDecode = pdInlineImage.getDecode();

    // Assert
    verify(object).getCOSObject();
    assertSame(decode, actualDecode);
  }

  /**
   * Method under test: {@link PDInlineImage#isStencil()}
   */
  @Test
  void testIsStencil() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).isStencil());
  }

  /**
   * Method under test: {@link PDInlineImage#isStencil()}
   */
  @Test
  void testIsStencil2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(true);

    // Act and Assert
    assertTrue(pdInlineImage.isStencil());
  }

  /**
   * Method under test: {@link PDInlineImage#isStencil()}
   */
  @Test
  void testIsStencil3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertFalse(pdInlineImage.isStencil());
  }

  /**
   * Method under test: {@link PDInlineImage#setStencil(boolean)}
   */
  @Test
  void testSetStencil() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setStencil(false);

    // Assert
    assertEquals(-1, pdInlineImage.getBitsPerComponent());
    assertFalse(pdInlineImage.isStencil());
    assertSame(parameters, pdInlineImage.getCOSObject());
  }

  /**
   * Method under test: {@link PDInlineImage#createInputStream()}
   */
  @Test
  void testCreateInputStream() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, (new PDInlineImage(parameters, data, new PDResources())).createInputStream().read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  void testCreateInputStream2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdInlineImage.createInputStream(new ArrayList<>()).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  void testCreateInputStream3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    ArrayList<String> stopFilters = new ArrayList<>();
    stopFilters.add("foo");

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdInlineImage.createInputStream(stopFilters).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  void testCreateInputStream4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    ArrayList<String> stopFilters = new ArrayList<>();
    stopFilters.add("42");
    stopFilters.add("foo");

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdInlineImage.createInputStream(stopFilters).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  void testCreateInputStream5() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(new ArrayList<>());

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdInlineImage.createInputStream(new ArrayList<>()).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  void testCreateInputStream6() throws IOException {
    // Arrange
    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(filters);

    ArrayList<String> stopFilters = new ArrayList<>();
    stopFilters.add("foo");

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdInlineImage.createInputStream(stopFilters).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDInlineImage#createInputStream(DecodeOptions)}
   */
  @Test
  void testCreateInputStream7() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, (new PDInlineImage(parameters, data, new PDResources())).createInputStream(DecodeOptions.DEFAULT)
        .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link PDInlineImage#isEmpty()}
   */
  @Test
  void testIsEmpty() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).isEmpty());
  }

  /**
   * Method under test: {@link PDInlineImage#isEmpty()}
   */
  @Test
  void testIsEmpty2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    // Act and Assert
    assertTrue((new PDInlineImage(parameters, new byte[]{}, new PDResources())).isEmpty());
  }

  /**
   * Method under test: {@link PDInlineImage#getData()}
   */
  @Test
  void testGetData() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new PDInlineImage(parameters, data, new PDResources())).getData();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  void testGetImage() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getImage());
  }

  /**
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  void testGetImage2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setHeight(1);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage());
  }

  /**
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  void testGetImage3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage());
  }

  /**
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  void testGetImage4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage());
  }

  /**
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  void testGetImage5() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  void testGetImage6() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getImage(null, 1));
  }

  /**
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  void testGetImage7() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setHeight(8);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  void testGetImage8() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  void testGetImage9() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  void testGetRawRaster() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getRawRaster());
  }

  /**
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  void testGetRawRaster2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawRaster());
  }

  /**
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  void testGetRawRaster3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawRaster());
  }

  /**
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  void testGetRawImage() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getRawImage());
  }

  /**
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  void testGetRawImage2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawImage());
  }

  /**
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  void testGetRawImage3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawImage());
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdInlineImage.getStencilImage(Color.decode("42")));
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage2() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdInlineImage.getStencilImage(Color.decode("42")));
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage3() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setWidth(1);
    pdInlineImage.setHeight(1);
    pdInlineImage.setStencil(true);

    // Act
    BufferedImage actualStencilImage = pdInlineImage.getStencilImage(Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualStencilImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data2 = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualStencilImage.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualStencilImage.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data2.getParent());
    WritableRaster raster = actualStencilImage.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualStencilImage.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualStencilImage.getMinTileX());
    assertEquals(0, actualStencilImage.getMinTileY());
    assertEquals(0, actualStencilImage.getMinX());
    assertEquals(0, actualStencilImage.getMinY());
    assertEquals(0, actualStencilImage.getTileGridXOffset());
    assertEquals(0, actualStencilImage.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, alphaRaster.getMinX());
    assertEquals(0, data2.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, alphaRaster.getMinY());
    assertEquals(0, data2.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, alphaRaster.getSampleModelTranslateX());
    assertEquals(0, data2.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, alphaRaster.getSampleModelTranslateY());
    assertEquals(0, data2.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX());
    assertEquals(0.0d, point.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(0.5f, actualStencilImage.getAccelerationPriority());
    assertEquals(1, actualStencilImage.getHeight());
    assertEquals(1, actualStencilImage.getNumXTiles());
    assertEquals(1, actualStencilImage.getNumYTiles());
    assertEquals(1, actualStencilImage.getTileHeight());
    assertEquals(1, actualStencilImage.getTileWidth());
    assertEquals(1, actualStencilImage.getWidth());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data2.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data2.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, alphaRaster.getWidth());
    assertEquals(1, data2.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, sampleModel2.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualStencilImage.getType());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualStencilImage.getTransparency());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, alphaRaster.getTransferType());
    assertEquals(3, data2.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, sampleModel2.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(4, data2.getNumBands());
    assertEquals(4, raster.getNumBands());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(5, colorSpace.getType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[Short.SIZE]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
    assertEquals(8, widths[254]);
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(fontMetrics.hasUniformLineMetrics());
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualStencilImage.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualStencilImage.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data3 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    int[] data4 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{-16777174}, data3);
    assertArrayEquals(new int[]{-16777174}, data4);
    assertArrayEquals(new int[]{-16777216}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage4() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new PDResources());
    pdInlineImage.setWidth(1);
    pdInlineImage.setHeight(1);
    pdInlineImage.setStencil(true);

    // Act
    BufferedImage actualStencilImage = pdInlineImage.getStencilImage(Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualStencilImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualStencilImage.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualStencilImage.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    WritableRaster raster = actualStencilImage.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualStencilImage.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualStencilImage.getMinTileX());
    assertEquals(0, actualStencilImage.getMinTileY());
    assertEquals(0, actualStencilImage.getMinX());
    assertEquals(0, actualStencilImage.getMinY());
    assertEquals(0, actualStencilImage.getTileGridXOffset());
    assertEquals(0, actualStencilImage.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, alphaRaster.getMinX());
    assertEquals(0, data.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, alphaRaster.getMinY());
    assertEquals(0, data.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, alphaRaster.getSampleModelTranslateX());
    assertEquals(0, data.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, alphaRaster.getSampleModelTranslateY());
    assertEquals(0, data.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX());
    assertEquals(0.0d, point.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(0.5f, actualStencilImage.getAccelerationPriority());
    assertEquals(1, actualStencilImage.getHeight());
    assertEquals(1, actualStencilImage.getNumXTiles());
    assertEquals(1, actualStencilImage.getNumYTiles());
    assertEquals(1, actualStencilImage.getTileHeight());
    assertEquals(1, actualStencilImage.getTileWidth());
    assertEquals(1, actualStencilImage.getWidth());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, alphaRaster.getWidth());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, sampleModel2.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualStencilImage.getType());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualStencilImage.getTransparency());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, alphaRaster.getTransferType());
    assertEquals(3, data.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, sampleModel2.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(4, data.getNumBands());
    assertEquals(4, raster.getNumBands());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(5, colorSpace.getType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[Short.SIZE]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
    assertEquals(8, widths[254]);
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(fontMetrics.hasUniformLineMetrics());
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualStencilImage.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualStencilImage.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{-16777216}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{0}, data2);
    assertArrayEquals(new int[]{0}, data3);
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage5() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, new byte[]{}, new PDResources());
    pdInlineImage.setWidth(1);
    pdInlineImage.setHeight(1);
    pdInlineImage.setStencil(true);

    // Act
    BufferedImage actualStencilImage = pdInlineImage.getStencilImage(Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualStencilImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualStencilImage.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualStencilImage.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    WritableRaster raster = actualStencilImage.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualStencilImage.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualStencilImage.getMinTileX());
    assertEquals(0, actualStencilImage.getMinTileY());
    assertEquals(0, actualStencilImage.getMinX());
    assertEquals(0, actualStencilImage.getMinY());
    assertEquals(0, actualStencilImage.getTileGridXOffset());
    assertEquals(0, actualStencilImage.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, alphaRaster.getMinX());
    assertEquals(0, data.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, alphaRaster.getMinY());
    assertEquals(0, data.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, alphaRaster.getSampleModelTranslateX());
    assertEquals(0, data.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, alphaRaster.getSampleModelTranslateY());
    assertEquals(0, data.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX());
    assertEquals(0.0d, point.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(0.5f, actualStencilImage.getAccelerationPriority());
    assertEquals(1, actualStencilImage.getHeight());
    assertEquals(1, actualStencilImage.getNumXTiles());
    assertEquals(1, actualStencilImage.getNumYTiles());
    assertEquals(1, actualStencilImage.getTileHeight());
    assertEquals(1, actualStencilImage.getTileWidth());
    assertEquals(1, actualStencilImage.getWidth());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, alphaRaster.getWidth());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, sampleModel2.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualStencilImage.getType());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualStencilImage.getTransparency());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, alphaRaster.getTransferType());
    assertEquals(3, data.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, sampleModel2.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(4, data.getNumBands());
    assertEquals(4, raster.getNumBands());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(5, colorSpace.getType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[Short.SIZE]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
    assertEquals(8, widths[254]);
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(fontMetrics.hasUniformLineMetrics());
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualStencilImage.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualStencilImage.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{-16777174}, data2);
    assertArrayEquals(new int[]{-16777174}, data3);
    assertArrayEquals(new int[]{-16777216}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage6() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setWidth(2);
    pdInlineImage.setHeight(1);
    pdInlineImage.setStencil(true);

    // Act
    BufferedImage actualStencilImage = pdInlineImage.getStencilImage(Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualStencilImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data2 = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualStencilImage.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualStencilImage.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data2.getParent());
    WritableRaster raster = actualStencilImage.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualStencilImage.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualStencilImage.getMinTileX());
    assertEquals(0, actualStencilImage.getMinTileY());
    assertEquals(0, actualStencilImage.getMinX());
    assertEquals(0, actualStencilImage.getMinY());
    assertEquals(0, actualStencilImage.getTileGridXOffset());
    assertEquals(0, actualStencilImage.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, alphaRaster.getMinX());
    assertEquals(0, data2.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, alphaRaster.getMinY());
    assertEquals(0, data2.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, alphaRaster.getSampleModelTranslateX());
    assertEquals(0, data2.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, alphaRaster.getSampleModelTranslateY());
    assertEquals(0, data2.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX());
    assertEquals(0.0d, point.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(0.5f, actualStencilImage.getAccelerationPriority());
    assertEquals(1, actualStencilImage.getHeight());
    assertEquals(1, actualStencilImage.getNumXTiles());
    assertEquals(1, actualStencilImage.getNumYTiles());
    assertEquals(1, actualStencilImage.getTileHeight());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data2.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data2.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, bounds.height);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualStencilImage.getTileWidth());
    assertEquals(2, actualStencilImage.getType());
    assertEquals(2, actualStencilImage.getWidth());
    assertEquals(2, dataBuffer.getSize());
    assertEquals(2, dataBuffer2.getSize());
    assertEquals(2, alphaRaster.getWidth());
    assertEquals(2, data2.getWidth());
    assertEquals(2, raster.getWidth());
    assertEquals(2, sampleModel.getWidth());
    assertEquals(2, sampleModel2.getWidth());
    assertEquals(2, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(2, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(2, size.width);
    assertEquals(2, bounds.width);
    assertEquals(2.0d, size.getWidth());
    assertEquals(2.0d, bounds.getWidth());
    assertEquals(2.0d, bounds.getMaxX());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualStencilImage.getTransparency());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, alphaRaster.getTransferType());
    assertEquals(3, data2.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, sampleModel2.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(4, data2.getNumBands());
    assertEquals(4, raster.getNumBands());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(5, colorSpace.getType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[Short.SIZE]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
    assertEquals(8, widths[254]);
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(fontMetrics.hasUniformLineMetrics());
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualStencilImage.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualStencilImage.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data3 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    int[] data4 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{-16777216}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{-16777174, 0}, data3);
    assertArrayEquals(new int[]{-16777174, 0}, data4);
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage7() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setWidth(8);
    pdInlineImage.setHeight(1);
    pdInlineImage.setStencil(true);

    // Act
    BufferedImage actualStencilImage = pdInlineImage.getStencilImage(Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualStencilImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data2 = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualStencilImage.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualStencilImage.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data2.getParent());
    WritableRaster raster = actualStencilImage.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualStencilImage.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualStencilImage.getMinTileX());
    assertEquals(0, actualStencilImage.getMinTileY());
    assertEquals(0, actualStencilImage.getMinX());
    assertEquals(0, actualStencilImage.getMinY());
    assertEquals(0, actualStencilImage.getTileGridXOffset());
    assertEquals(0, actualStencilImage.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, alphaRaster.getMinX());
    assertEquals(0, data2.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, alphaRaster.getMinY());
    assertEquals(0, data2.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, alphaRaster.getSampleModelTranslateX());
    assertEquals(0, data2.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, alphaRaster.getSampleModelTranslateY());
    assertEquals(0, data2.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX());
    assertEquals(0.0d, point.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(0.5f, actualStencilImage.getAccelerationPriority());
    assertEquals(1, actualStencilImage.getHeight());
    assertEquals(1, actualStencilImage.getNumXTiles());
    assertEquals(1, actualStencilImage.getNumYTiles());
    assertEquals(1, actualStencilImage.getTileHeight());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data2.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data2.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, bounds.height);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualStencilImage.getType());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualStencilImage.getTransparency());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, alphaRaster.getTransferType());
    assertEquals(3, data2.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, sampleModel2.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(4, data2.getNumBands());
    assertEquals(4, raster.getNumBands());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4.0d, bounds.getCenterX());
    assertEquals(5, colorSpace.getType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[Short.SIZE]);
    assertEquals(8, actualStencilImage.getTileWidth());
    assertEquals(8, actualStencilImage.getWidth());
    assertEquals(8, dataBuffer.getSize());
    assertEquals(8, dataBuffer2.getSize());
    assertEquals(8, alphaRaster.getWidth());
    assertEquals(8, data2.getWidth());
    assertEquals(8, raster.getWidth());
    assertEquals(8, sampleModel.getWidth());
    assertEquals(8, sampleModel2.getWidth());
    assertEquals(8, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(8, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
    assertEquals(8, widths[254]);
    assertEquals(8, size.width);
    assertEquals(8, bounds.width);
    assertEquals(8.0d, size.getWidth());
    assertEquals(8.0d, bounds.getWidth());
    assertEquals(8.0d, bounds.getMaxX());
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(fontMetrics.hasUniformLineMetrics());
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualStencilImage.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualStencilImage.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data3 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    int[] data4 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{-16777216}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
    assertArrayEquals(new int[]{-16777174, 0, -16777174, -16777174, -16777174, -16777174, -16777174, 0}, data3);
    assertArrayEquals(new int[]{-16777174, 0, -16777174, -16777174, -16777174, -16777174, -16777174, 0}, data4);
  }

  /**
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  void testGetStencilImage8() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setWidth(9);
    pdInlineImage.setHeight(1);
    pdInlineImage.setStencil(true);

    // Act
    BufferedImage actualStencilImage = pdInlineImage.getStencilImage(Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualStencilImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data2 = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualStencilImage.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualStencilImage.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data2.getParent());
    WritableRaster raster = actualStencilImage.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualStencilImage.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualStencilImage.getMinTileX());
    assertEquals(0, actualStencilImage.getMinTileY());
    assertEquals(0, actualStencilImage.getMinX());
    assertEquals(0, actualStencilImage.getMinY());
    assertEquals(0, actualStencilImage.getTileGridXOffset());
    assertEquals(0, actualStencilImage.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, alphaRaster.getMinX());
    assertEquals(0, data2.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, alphaRaster.getMinY());
    assertEquals(0, data2.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, alphaRaster.getSampleModelTranslateX());
    assertEquals(0, data2.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, alphaRaster.getSampleModelTranslateY());
    assertEquals(0, data2.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX());
    assertEquals(0.0d, point.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(0.5f, actualStencilImage.getAccelerationPriority());
    assertEquals(1, actualStencilImage.getHeight());
    assertEquals(1, actualStencilImage.getNumXTiles());
    assertEquals(1, actualStencilImage.getNumYTiles());
    assertEquals(1, actualStencilImage.getTileHeight());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data2.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data2.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, bounds.height);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualStencilImage.getType());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualStencilImage.getTransparency());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, alphaRaster.getTransferType());
    assertEquals(3, data2.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, sampleModel2.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(4, data2.getNumBands());
    assertEquals(4, raster.getNumBands());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4.5d, bounds.getCenterX());
    assertEquals(5, colorSpace.getType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[Short.SIZE]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
    assertEquals(8, widths[254]);
    assertEquals(9, actualStencilImage.getTileWidth());
    assertEquals(9, actualStencilImage.getWidth());
    assertEquals(9, dataBuffer.getSize());
    assertEquals(9, dataBuffer2.getSize());
    assertEquals(9, alphaRaster.getWidth());
    assertEquals(9, data2.getWidth());
    assertEquals(9, raster.getWidth());
    assertEquals(9, sampleModel.getWidth());
    assertEquals(9, sampleModel2.getWidth());
    assertEquals(9, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(9, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(9, size.width);
    assertEquals(9, bounds.width);
    assertEquals(9.0d, size.getWidth());
    assertEquals(9.0d, bounds.getWidth());
    assertEquals(9.0d, bounds.getMaxX());
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(fontMetrics.hasUniformLineMetrics());
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualStencilImage.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualStencilImage.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data3 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    int[] data4 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{-16777216}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
    assertArrayEquals(new int[]{-16777174, 0, -16777174, -16777174, -16777174, -16777174, -16777174, 0, -16777174},
        data3);
    assertArrayEquals(new int[]{-16777174, 0, -16777174, -16777174, -16777174, -16777174, -16777174, 0, -16777174},
        data4);
  }

  /**
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  void testGetSuffix() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("png", (new PDInlineImage(parameters, data, new PDResources())).getSuffix());
  }

  /**
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  void testGetSuffix2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(new ArrayList<>());

    // Act and Assert
    assertEquals("png", pdInlineImage.getSuffix());
  }

  /**
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  void testGetSuffix3() throws IOException {
    // Arrange
    ArrayList<String> filters = new ArrayList<>();
    filters.add("png");
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(filters);

    // Act and Assert
    assertEquals("png", pdInlineImage.getSuffix());
  }

  /**
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  void testGetSuffix4() throws IOException {
    // Arrange
    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");
    filters.add("png");
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(filters);

    // Act and Assert
    assertEquals("png", pdInlineImage.getSuffix());
  }

  /**
   * Method under test:
   * {@link PDInlineImage#PDInlineImage(COSDictionary, byte[], PDResources)}
   */
  @Test
  void testNewPDInlineImage() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    PDInlineImage actualPdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Assert
    assertEquals("png", actualPdInlineImage.getSuffix());
    assertNull(actualPdInlineImage.getDecode());
    assertEquals(-1, actualPdInlineImage.getBitsPerComponent());
    assertEquals(-1, actualPdInlineImage.getHeight());
    assertEquals(-1, actualPdInlineImage.getWidth());
    assertFalse(actualPdInlineImage.getInterpolate());
    assertFalse(actualPdInlineImage.isEmpty());
    assertFalse(actualPdInlineImage.isStencil());
    assertTrue(actualPdInlineImage.getFilters().isEmpty());
    assertSame(parameters, actualPdInlineImage.getCOSObject());
    assertSame(data, actualPdInlineImage.getData());
  }
}
