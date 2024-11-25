package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDInlineImageDiffblueTest {
  /**
   * Test {@link PDInlineImage#PDInlineImage(COSDictionary, byte[], PDResources)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Suffix is {@code png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDInlineImage#PDInlineImage(COSDictionary, byte[], PDResources)}
   */
  @Test
  @DisplayName("Test new PDInlineImage(COSDictionary, byte[], PDResources); when COSDictionary(); then return Suffix is 'png'")
  void testNewPDInlineImage_whenCOSDictionary_thenReturnSuffixIsPng() throws IOException {
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

  /**
   * Test {@link PDInlineImage#PDInlineImage(COSDictionary, byte[], PDResources)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDInlineImage#PDInlineImage(COSDictionary, byte[], PDResources)}
   */
  @Test
  @DisplayName("Test new PDInlineImage(COSDictionary, byte[], PDResources); when COSStream(); then return COSObject is COSStream()")
  void testNewPDInlineImage_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(parameters, (new PDInlineImage(parameters, data, new PDResources())).getCOSObject());
  }

  /**
   * Test {@link PDInlineImage#getCOSObject()}.
   * <p>
   * Method under test: {@link PDInlineImage#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(parameters, (new PDInlineImage(parameters, data, new PDResources())).getCOSObject());
  }

  /**
   * Test {@link PDInlineImage#getBitsPerComponent()}.
   * <p>
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent()")
  void testGetBitsPerComponent() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getBitsPerComponent());
  }

  /**
   * Test {@link PDInlineImage#getBitsPerComponent()}.
   * <p>
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent()")
  void testGetBitsPerComponent2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getBitsPerComponent());
  }

  /**
   * Test {@link PDInlineImage#getBitsPerComponent()}.
   * <p>
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent()")
  void testGetBitsPerComponent3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertEquals(-1, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Test {@link PDInlineImage#getBitsPerComponent()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent(); then return one")
  void testGetBitsPerComponent_thenReturnOne() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(true);

    // Act and Assert
    assertEquals(1, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Test {@link PDInlineImage#getBitsPerComponent()}.
   * <ul>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent(); then return seven")
  void testGetBitsPerComponent_thenReturnSeven() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setBitsPerComponent(7);

    // Act and Assert
    assertEquals(7, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Test {@link PDInlineImage#setBitsPerComponent(int)}.
   * <p>
   * Method under test: {@link PDInlineImage#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int)")
  void testSetBitsPerComponent() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setBitsPerComponent(1);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Test {@link PDInlineImage#setBitsPerComponent(int)}.
   * <p>
   * Method under test: {@link PDInlineImage#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int)")
  void testSetBitsPerComponent2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setBitsPerComponent(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdInlineImage.getBitsPerComponent());
  }

  /**
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  void testGetColorSpace() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getColorSpace());
  }

  /**
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  void testGetColorSpace2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getColorSpace());
  }

  /**
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  void testGetColorSpace3() throws IOException {
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
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  void testGetColorSpace4() throws IOException {
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
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  void testGetColorSpace5() throws IOException {
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
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  void testGetColorSpace6() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getColorSpace());
  }

  /**
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  void testGetColorSpace7() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getColorSpace());
  }

  /**
   * Test {@link PDInlineImage#getColorSpace()}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDResources() add INSTANCE; then return INSTANCE")
  void testGetColorSpace_givenPDResourcesAddInstance_thenReturnInstance() throws IOException {
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
   * Test {@link PDInlineImage#getColorSpace()}.
   * <ul>
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return INSTANCE")
  void testGetColorSpace_thenReturnInstance() throws IOException {
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
   * Test {@link PDInlineImage#setColorSpace(PDColorSpace)}.
   * <p>
   * Method under test: {@link PDInlineImage#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  void testSetColorSpace() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    pdInlineImage.setColorSpace(colorSpace);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, pdInlineImage.getColorSpace());
  }

  /**
   * Test {@link PDInlineImage#setColorSpace(PDColorSpace)}.
   * <p>
   * Method under test: {@link PDInlineImage#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  void testSetColorSpace2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setColorSpace(null);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDInlineImage#setColorSpace(PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace); when PDCalGray()")
  void testSetColorSpace_whenPDCalGray() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setColorSpace(new PDCalGray());

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDInlineImage#getHeight()}.
   * <p>
   * Method under test: {@link PDInlineImage#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight()")
  void testGetHeight() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getHeight());
  }

  /**
   * Test {@link PDInlineImage#getHeight()}.
   * <p>
   * Method under test: {@link PDInlineImage#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight()")
  void testGetHeight2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getHeight());
  }

  /**
   * Test {@link PDInlineImage#getHeight()}.
   * <p>
   * Method under test: {@link PDInlineImage#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight()")
  void testGetHeight3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setHeight(-1);

    // Act and Assert
    assertEquals(-1, pdInlineImage.getHeight());
  }

  /**
   * Test {@link PDInlineImage#setHeight(int)}.
   * <p>
   * Method under test: {@link PDInlineImage#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int)")
  void testSetHeight() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setHeight(1);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdInlineImage.getHeight());
  }

  /**
   * Test {@link PDInlineImage#setHeight(int)}.
   * <p>
   * Method under test: {@link PDInlineImage#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int)")
  void testSetHeight2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setHeight(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdInlineImage.getHeight());
  }

  /**
   * Test {@link PDInlineImage#getWidth()}.
   * <p>
   * Method under test: {@link PDInlineImage#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  void testGetWidth() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getWidth());
  }

  /**
   * Test {@link PDInlineImage#getWidth()}.
   * <p>
   * Method under test: {@link PDInlineImage#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  void testGetWidth2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, (new PDInlineImage(parameters, data, new PDResources())).getWidth());
  }

  /**
   * Test {@link PDInlineImage#getWidth()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); then return one")
  void testGetWidth_thenReturnOne() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setWidth(1);

    // Act and Assert
    assertEquals(1, pdInlineImage.getWidth());
  }

  /**
   * Test {@link PDInlineImage#setWidth(int)}.
   * <p>
   * Method under test: {@link PDInlineImage#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int)")
  void testSetWidth() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setWidth(1);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdInlineImage.getWidth());
  }

  /**
   * Test {@link PDInlineImage#setWidth(int)}.
   * <p>
   * Method under test: {@link PDInlineImage#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int)")
  void testSetWidth2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setWidth(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdInlineImage.getWidth());
  }

  /**
   * Test {@link PDInlineImage#getInterpolate()}.
   * <p>
   * Method under test: {@link PDInlineImage#getInterpolate()}
   */
  @Test
  @DisplayName("Test getInterpolate()")
  void testGetInterpolate() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).getInterpolate());
  }

  /**
   * Test {@link PDInlineImage#getInterpolate()}.
   * <p>
   * Method under test: {@link PDInlineImage#getInterpolate()}
   */
  @Test
  @DisplayName("Test getInterpolate()")
  void testGetInterpolate2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).getInterpolate());
  }

  /**
   * Test {@link PDInlineImage#getInterpolate()}.
   * <p>
   * Method under test: {@link PDInlineImage#getInterpolate()}
   */
  @Test
  @DisplayName("Test getInterpolate()")
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
   * Test {@link PDInlineImage#getInterpolate()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getInterpolate()}
   */
  @Test
  @DisplayName("Test getInterpolate(); then return 'true'")
  void testGetInterpolate_thenReturnTrue() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setInterpolate(true);

    // Act and Assert
    assertTrue(pdInlineImage.getInterpolate());
  }

  /**
   * Test {@link PDInlineImage#setInterpolate(boolean)}.
   * <p>
   * Method under test: {@link PDInlineImage#setInterpolate(boolean)}
   */
  @Test
  @DisplayName("Test setInterpolate(boolean)")
  void testSetInterpolate() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setInterpolate(true);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdInlineImage.getInterpolate());
  }

  /**
   * Test {@link PDInlineImage#setInterpolate(boolean)}.
   * <p>
   * Method under test: {@link PDInlineImage#setInterpolate(boolean)}
   */
  @Test
  @DisplayName("Test setInterpolate(boolean)")
  void testSetInterpolate2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setInterpolate(false);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdInlineImage.getInterpolate());
  }

  /**
   * Test {@link PDInlineImage#getFilters()}.
   * <p>
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  @DisplayName("Test getFilters()")
  void testGetFilters() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new PDInlineImage(parameters, data, new PDResources())).getFilters().isEmpty());
  }

  /**
   * Test {@link PDInlineImage#getFilters()}.
   * <p>
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  @DisplayName("Test getFilters()")
  void testGetFilters2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new PDInlineImage(parameters, data, new PDResources())).getFilters().isEmpty());
  }

  /**
   * Test {@link PDInlineImage#getFilters()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  @DisplayName("Test getFilters(); given ArrayList() add '42'; then return ArrayList()")
  void testGetFilters_givenArrayListAdd42_thenReturnArrayList() throws IOException {
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
   * Test {@link PDInlineImage#getFilters()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  @DisplayName("Test getFilters(); given ArrayList() add 'foo'; then return size is one")
  void testGetFilters_givenArrayListAddFoo_thenReturnSizeIsOne() throws IOException {
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
   * Test {@link PDInlineImage#getFilters()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getFilters()}
   */
  @Test
  @DisplayName("Test getFilters(); then return Empty")
  void testGetFilters_thenReturnEmpty() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(new ArrayList<>());

    // Act and Assert
    assertTrue(pdInlineImage.getFilters().isEmpty());
  }

  /**
   * Test {@link PDInlineImage#setFilters(List)}.
   * <p>
   * Method under test: {@link PDInlineImage#setFilters(List)}
   */
  @Test
  @DisplayName("Test setFilters(List)")
  void testSetFilters() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setFilters(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdInlineImage.getFilters().isEmpty());
  }

  /**
   * Test {@link PDInlineImage#setFilters(List)}.
   * <p>
   * Method under test: {@link PDInlineImage#setFilters(List)}
   */
  @Test
  @DisplayName("Test setFilters(List)")
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
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(filters, pdInlineImage.getFilters());
  }

  /**
   * Test {@link PDInlineImage#setFilters(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#setFilters(List)}
   */
  @Test
  @DisplayName("Test setFilters(List); given '42'; when ArrayList() add '42'")
  void testSetFilters_given42_whenArrayListAdd42() throws IOException {
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
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(filters, pdInlineImage.getFilters());
  }

  /**
   * Test {@link PDInlineImage#setDecode(COSArray)}.
   * <p>
   * Method under test: {@link PDInlineImage#setDecode(COSArray)}
   */
  @Test
  @DisplayName("Test setDecode(COSArray)")
  void testSetDecode() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    COSArray decode = new COSArray();

    // Act
    pdInlineImage.setDecode(decode);

    // Assert
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(decode, pdInlineImage.getDecode());
  }

  /**
   * Test {@link PDInlineImage#setDecode(COSArray)}.
   * <p>
   * Method under test: {@link PDInlineImage#setDecode(COSArray)}
   */
  @Test
  @DisplayName("Test setDecode(COSArray)")
  void testSetDecode2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setDecode(null);

    // Assert
    assertNull(pdInlineImage.getDecode());
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDInlineImage#getDecode()}.
   * <p>
   * Method under test: {@link PDInlineImage#getDecode()}
   */
  @Test
  @DisplayName("Test getDecode()")
  void testGetDecode() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new PDInlineImage(parameters, data, new PDResources())).getDecode());
  }

  /**
   * Test {@link PDInlineImage#getDecode()}.
   * <p>
   * Method under test: {@link PDInlineImage#getDecode()}
   */
  @Test
  @DisplayName("Test getDecode()")
  void testGetDecode2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new PDInlineImage(parameters, data, new PDResources())).getDecode());
  }

  /**
   * Test {@link PDInlineImage#getDecode()}.
   * <ul>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getDecode()}
   */
  @Test
  @DisplayName("Test getDecode(); then return toList Empty")
  void testGetDecode_thenReturnToListEmpty() throws IOException {
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
   * Test {@link PDInlineImage#isStencil()}.
   * <p>
   * Method under test: {@link PDInlineImage#isStencil()}
   */
  @Test
  @DisplayName("Test isStencil()")
  void testIsStencil() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).isStencil());
  }

  /**
   * Test {@link PDInlineImage#isStencil()}.
   * <p>
   * Method under test: {@link PDInlineImage#isStencil()}
   */
  @Test
  @DisplayName("Test isStencil()")
  void testIsStencil2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).isStencil());
  }

  /**
   * Test {@link PDInlineImage#isStencil()}.
   * <p>
   * Method under test: {@link PDInlineImage#isStencil()}
   */
  @Test
  @DisplayName("Test isStencil()")
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
   * Test {@link PDInlineImage#isStencil()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#isStencil()}
   */
  @Test
  @DisplayName("Test isStencil(); then return 'true'")
  void testIsStencil_thenReturnTrue() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(true);

    // Act and Assert
    assertTrue(pdInlineImage.isStencil());
  }

  /**
   * Test {@link PDInlineImage#setStencil(boolean)}.
   * <p>
   * Method under test: {@link PDInlineImage#setStencil(boolean)}
   */
  @Test
  @DisplayName("Test setStencil(boolean)")
  void testSetStencil() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setStencil(true);

    // Assert
    PDColorSpace colorSpace = pdInlineImage.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", colorSpace.getName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(1, colorSpace.getNumberOfComponents());
    assertEquals(1, pdInlineImage.getBitsPerComponent());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertTrue(pdInlineImage.isStencil());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDInlineImage#setStencil(boolean)}.
   * <p>
   * Method under test: {@link PDInlineImage#setStencil(boolean)}
   */
  @Test
  @DisplayName("Test setStencil(boolean)")
  void testSetStencil2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setStencil(false);

    // Assert
    assertEquals(-1, pdInlineImage.getBitsPerComponent());
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdInlineImage.isStencil());
  }

  /**
   * Test {@link PDInlineImage#createInputStream()}.
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream()}
   */
  @Test
  @DisplayName("Test createInputStream()")
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
   * Test {@link PDInlineImage#createInputStream(DecodeOptions)} with
   * {@code options}.
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'options'")
  void testCreateInputStreamWithOptions() throws IOException {
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
   * Test {@link PDInlineImage#createInputStream(List)} with {@code stopFilters}.
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'")
  void testCreateInputStreamWithStopFilters() throws IOException {
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
   * Test {@link PDInlineImage#createInputStream(List)} with {@code stopFilters}.
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'")
  void testCreateInputStreamWithStopFilters2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdInlineImage.createInputStream(new ArrayList<>()).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDInlineImage#createInputStream(List)} with {@code stopFilters}.
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'")
  void testCreateInputStreamWithStopFilters3() throws IOException {
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
   * Test {@link PDInlineImage#createInputStream(List)} with {@code stopFilters}.
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'")
  void testCreateInputStreamWithStopFilters4() throws IOException {
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
   * Test {@link PDInlineImage#createInputStream(List)} with {@code stopFilters}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'; given '42'; when ArrayList() add '42'")
  void testCreateInputStreamWithStopFilters_given42_whenArrayListAdd42() throws IOException {
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
   * Test {@link PDInlineImage#createInputStream(List)} with {@code stopFilters}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'; given ArrayList() add 'foo'; when ArrayList() add 'foo'")
  void testCreateInputStreamWithStopFilters_givenArrayListAddFoo_whenArrayListAddFoo() throws IOException {
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
   * Test {@link PDInlineImage#isEmpty()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  void testIsEmpty_thenReturnFalse() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new PDInlineImage(parameters, data, new PDResources())).isEmpty());
  }

  /**
   * Test {@link PDInlineImage#isEmpty()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  void testIsEmpty_thenReturnTrue() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    // Act and Assert
    assertTrue((new PDInlineImage(parameters, new byte[]{}, new PDResources())).isEmpty());
  }

  /**
   * Test {@link PDInlineImage#getData()}.
   * <p>
   * Method under test: {@link PDInlineImage#getData()}
   */
  @Test
  @DisplayName("Test getData()")
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
   * Test {@link PDInlineImage#getImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getImage());
  }

  /**
   * Test {@link PDInlineImage#getImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getImage());
  }

  /**
   * Test {@link PDInlineImage#getImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setHeight(1);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage());
  }

  /**
   * Test {@link PDInlineImage#getImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage());
  }

  /**
   * Test {@link PDInlineImage#getImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage5() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage());
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setHeight(8);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'; when 'null'")
  void testGetImageWithRectangleInt_whenNull() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getImage(null, 1));
  }

  /**
   * Test {@link PDInlineImage#getRawRaster()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getRawRaster());
  }

  /**
   * Test {@link PDInlineImage#getRawRaster()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getRawRaster());
  }

  /**
   * Test {@link PDInlineImage#getRawRaster()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawRaster());
  }

  /**
   * Test {@link PDInlineImage#getRawRaster()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawRaster());
  }

  /**
   * Test {@link PDInlineImage#getRawImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  void testGetRawImage() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getRawImage());
  }

  /**
   * Test {@link PDInlineImage#getRawImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  void testGetRawImage2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDInlineImage(parameters, data, new PDResources())).getRawImage());
  }

  /**
   * Test {@link PDInlineImage#getRawImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  void testGetRawImage3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawImage());
  }

  /**
   * Test {@link PDInlineImage#getRawImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  void testGetRawImage4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getRawImage());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
  void testGetStencilImage() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdInlineImage.getStencilImage(Color.decode("42")));
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
  void testGetStencilImage2() throws IOException, NumberFormatException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdInlineImage.getStencilImage(Color.decode("42")));
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
  void testGetStencilImage3() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdInlineImage.getStencilImage(Color.decode("42")));
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
  void testGetStencilImage4() throws IOException, NumberFormatException {
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle2D bounds2D = bounds5.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds4.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Raster data2 = actualStencilImage.getData();
    Rectangle bounds6 = data2.getBounds();
    Rectangle bounds7 = bounds6.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D3 = bounds9.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    WritableRaster raster = actualStencilImage.getRaster();
    Rectangle bounds10 = raster.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle bounds13 = bounds12.getBounds();
    Rectangle2D bounds2D4 = bounds13.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds3.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds8.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds.getBounds2D();
    Rectangle bounds14 = bounds2D8.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D9 = bounds15.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds16 = frame.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D10 = bounds17.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds2.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds7.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D bounds2D13 = bounds11.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle bounds18 = bounds2D11.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds14.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds6.getBounds2D();
    Rectangle bounds19 = bounds2D16.getBounds();
    Rectangle2D bounds2D17 = bounds19.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    Rectangle bounds20 = bounds2D18.getBounds();
    Rectangle2D bounds2D19 = bounds20.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds21 = frame2.getBounds();
    Rectangle2D bounds2D20 = bounds21.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D21 = bounds16.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame3 = bounds6.getFrame();
    Rectangle bounds22 = frame3.getBounds();
    Rectangle2D bounds2D22 = bounds22.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D frame4 = bounds10.getFrame();
    Rectangle bounds23 = frame4.getBounds();
    Rectangle2D bounds2D23 = bounds23.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    assertTrue(bounds2D8 instanceof Rectangle);
    assertTrue(bounds2D16 instanceof Rectangle);
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D24 = bounds2D5.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D11.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D12.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D13.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D8.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D16.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D18.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds3.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds11.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds2D8.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    assertEquals(0.5d, bounds5.getCenterX());
    assertEquals(0.5d, bounds4.getCenterX());
    assertEquals(0.5d, bounds9.getCenterX());
    assertEquals(0.5d, bounds13.getCenterX());
    assertEquals(0.5d, bounds3.getCenterX());
    assertEquals(0.5d, bounds8.getCenterX());
    assertEquals(0.5d, bounds12.getCenterX());
    assertEquals(0.5d, bounds15.getCenterX());
    assertEquals(0.5d, bounds17.getCenterX());
    assertEquals(0.5d, bounds2.getCenterX());
    assertEquals(0.5d, bounds7.getCenterX());
    assertEquals(0.5d, bounds11.getCenterX());
    assertEquals(0.5d, bounds2D5.getCenterX());
    assertEquals(0.5d, bounds2D11.getCenterX());
    assertEquals(0.5d, bounds2D12.getCenterX());
    assertEquals(0.5d, bounds2D13.getCenterX());
    assertEquals(0.5d, bounds2D8.getCenterX());
    assertEquals(0.5d, bounds2D16.getCenterX());
    assertEquals(0.5d, bounds2D18.getCenterX());
    assertEquals(0.5d, bounds2D28.getCenterX());
    assertEquals(0.5d, bounds2D32.getCenterX());
    assertEquals(0.5d, bounds18.getCenterX());
    assertEquals(0.5d, bounds14.getCenterX());
    assertEquals(0.5d, bounds19.getCenterX());
    assertEquals(0.5d, bounds20.getCenterX());
    assertEquals(0.5d, bounds21.getCenterX());
    assertEquals(0.5d, bounds16.getCenterX());
    assertEquals(0.5d, bounds22.getCenterX());
    assertEquals(0.5d, bounds23.getCenterX());
    assertEquals(0.5d, frame5.getCenterX());
    assertEquals(0.5d, frame2.getCenterX());
    assertEquals(0.5d, frame6.getCenterX());
    assertEquals(0.5d, frame7.getCenterX());
    assertEquals(0.5d, frame8.getCenterX());
    assertEquals(0.5d, frame9.getCenterX());
    assertEquals(0.5d, frame.getCenterX());
    assertEquals(0.5d, frame3.getCenterX());
    assertEquals(0.5d, frame4.getCenterX());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds6.getCenterX());
    assertEquals(0.5d, bounds10.getCenterX());
    assertEquals(1, actualStencilImage.getTileWidth());
    assertEquals(1, actualStencilImage.getWidth());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, alphaRaster.getWidth());
    assertEquals(1, data2.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, sampleModel2.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(1, size4.getSize().width);
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(1, size7.getSize().width);
    assertEquals(1, size4.width);
    Dimension size8 = bounds6.getSize();
    Dimension size9 = size8.getSize();
    Dimension size10 = size9.getSize();
    assertEquals(1, size10.getSize().width);
    Dimension size11 = bounds10.getSize();
    Dimension size12 = size11.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(1, size13.getSize().width);
    Dimension size14 = bounds3.getSize();
    Dimension size15 = size14.getSize();
    assertEquals(1, size15.getSize().width);
    assertEquals(1, size7.width);
    Dimension size16 = bounds7.getSize();
    Dimension size17 = size16.getSize();
    assertEquals(1, size17.getSize().width);
    Dimension size18 = bounds11.getSize();
    Dimension size19 = size18.getSize();
    assertEquals(1, size19.getSize().width);
    assertEquals(1, size3.width);
    assertEquals(1, size10.width);
    assertEquals(1, size13.width);
    Dimension size20 = ((Rectangle) bounds2D8).getSize();
    Dimension size21 = size20.getSize();
    assertEquals(1, size21.getSize().width);
    Dimension size22 = bounds4.getSize();
    assertEquals(1, size22.getSize().width);
    assertEquals(1, size15.width);
    Dimension size23 = bounds8.getSize();
    assertEquals(1, size23.getSize().width);
    Dimension size24 = bounds12.getSize();
    assertEquals(1, size24.getSize().width);
    assertEquals(1, size6.width);
    assertEquals(1, size17.width);
    assertEquals(1, size19.width);
    Dimension size25 = bounds14.getSize();
    assertEquals(1, size25.getSize().width);
    Dimension size26 = bounds16.getSize();
    assertEquals(1, size26.getSize().width);
    assertEquals(1, size2.width);
    assertEquals(1, size9.width);
    assertEquals(1, size12.width);
    Dimension size27 = ((Rectangle) bounds2D11).getSize();
    assertEquals(1, size27.getSize().width);
    assertEquals(1, size21.width);
    Dimension size28 = ((Rectangle) bounds2D16).getSize();
    assertEquals(1, size28.getSize().width);
    Dimension size29 = ((Rectangle) bounds2D18).getSize();
    assertEquals(1, size29.getSize().width);
    assertEquals(1, bounds5.getSize().width);
    assertEquals(1, size22.width);
    assertEquals(1, bounds9.getSize().width);
    assertEquals(1, bounds13.getSize().width);
    assertEquals(1, size14.width);
    assertEquals(1, size23.width);
    assertEquals(1, size24.width);
    assertEquals(1, bounds15.getSize().width);
    assertEquals(1, bounds17.getSize().width);
    assertEquals(1, size5.width);
    assertEquals(1, size16.width);
    assertEquals(1, size18.width);
    assertEquals(1, bounds18.getSize().width);
    assertEquals(1, size25.width);
    assertEquals(1, bounds19.getSize().width);
    assertEquals(1, bounds20.getSize().width);
    assertEquals(1, bounds21.getSize().width);
    assertEquals(1, size26.width);
    assertEquals(1, bounds22.getSize().width);
    assertEquals(1, bounds23.getSize().width);
    assertEquals(1, size.width);
    assertEquals(1, size8.width);
    assertEquals(1, size11.width);
    assertEquals(1, ((Rectangle) bounds2D5).getSize().width);
    assertEquals(1, size27.width);
    assertEquals(1, ((Rectangle) bounds2D12).getSize().width);
    assertEquals(1, ((Rectangle) bounds2D13).getSize().width);
    assertEquals(1, size20.width);
    assertEquals(1, size28.width);
    assertEquals(1, size29.width);
    assertEquals(1, ((Rectangle) bounds2D28).getSize().width);
    assertEquals(1, bounds5.getBounds().width);
    assertEquals(1, bounds5.width);
    assertEquals(1, bounds9.getBounds().width);
    assertEquals(1, bounds13.getBounds().width);
    assertEquals(1, bounds4.width);
    assertEquals(1, bounds9.width);
    assertEquals(1, bounds13.width);
    assertEquals(1, bounds15.getBounds().width);
    assertEquals(1, bounds17.getBounds().width);
    assertEquals(1, bounds3.width);
    assertEquals(1, bounds8.width);
    assertEquals(1, bounds12.width);
    assertEquals(1, bounds18.getBounds().width);
    assertEquals(1, bounds15.width);
    assertEquals(1, bounds19.getBounds().width);
    assertEquals(1, bounds20.getBounds().width);
    assertEquals(1, bounds21.getBounds().width);
    assertEquals(1, bounds17.width);
    assertEquals(1, bounds22.getBounds().width);
    assertEquals(1, bounds23.getBounds().width);
    assertEquals(1, bounds2.width);
    assertEquals(1, bounds7.width);
    assertEquals(1, bounds11.width);
    assertEquals(1, bounds2D5.getBounds().width);
    assertEquals(1, bounds18.width);
    assertEquals(1, bounds2D12.getBounds().width);
    assertEquals(1, bounds2D13.getBounds().width);
    assertEquals(1, bounds14.width);
    assertEquals(1, bounds19.width);
    assertEquals(1, bounds20.width);
    assertEquals(1, bounds2D28.getBounds().width);
    assertEquals(1, bounds2D32.getBounds().width);
    assertEquals(1, frame5.getBounds().width);
    assertEquals(1, bounds21.width);
    assertEquals(1, frame6.getBounds().width);
    assertEquals(1, frame7.getBounds().width);
    assertEquals(1, frame8.getBounds().width);
    assertEquals(1, frame9.getBounds().width);
    assertEquals(1, bounds16.width);
    assertEquals(1, bounds22.width);
    assertEquals(1, bounds23.width);
    assertEquals(1, bounds.width);
    assertEquals(1, bounds6.width);
    assertEquals(1, bounds10.width);
    assertEquals(1, ((Rectangle) bounds2D).width);
    assertEquals(1, ((Rectangle) bounds2D2).width);
    assertEquals(1, ((Rectangle) bounds2D3).width);
    assertEquals(1, ((Rectangle) bounds2D4).width);
    assertEquals(1, ((Rectangle) bounds2D5).width);
    assertEquals(1, ((Rectangle) bounds2D6).width);
    assertEquals(1, ((Rectangle) bounds2D7).width);
    assertEquals(1, ((Rectangle) bounds2D9).width);
    assertEquals(1, ((Rectangle) bounds2D10).width);
    assertEquals(1, ((Rectangle) bounds2D11).width);
    assertEquals(1, ((Rectangle) bounds2D12).width);
    assertEquals(1, ((Rectangle) bounds2D13).width);
    assertEquals(1, ((Rectangle) bounds2D14).width);
    assertEquals(1, ((Rectangle) bounds2D15).width);
    assertEquals(1, ((Rectangle) bounds2D17).width);
    assertEquals(1, ((Rectangle) bounds2D19).width);
    assertEquals(1, ((Rectangle) bounds2D20).width);
    assertEquals(1, ((Rectangle) bounds2D21).width);
    assertEquals(1, ((Rectangle) bounds2D22).width);
    assertEquals(1, ((Rectangle) bounds2D23).width);
    assertEquals(1, ((Rectangle) bounds2D8).width);
    assertEquals(1, ((Rectangle) bounds2D16).width);
    assertEquals(1, ((Rectangle) bounds2D18).width);
    assertEquals(1, ((Rectangle) bounds2D24).width);
    assertEquals(1, ((Rectangle) bounds2D25).width);
    assertEquals(1, ((Rectangle) bounds2D26).width);
    assertEquals(1, ((Rectangle) bounds2D27).width);
    assertEquals(1, ((Rectangle) bounds2D28).width);
    assertEquals(1, ((Rectangle) bounds2D29).width);
    assertEquals(1, ((Rectangle) bounds2D30).width);
    assertEquals(1, ((Rectangle) bounds2D31).width);
    assertEquals(1.0d, size4.getWidth());
    assertEquals(1.0d, size7.getWidth());
    assertEquals(1.0d, size3.getWidth());
    assertEquals(1.0d, size10.getWidth());
    assertEquals(1.0d, size13.getWidth());
    assertEquals(1.0d, size15.getWidth());
    assertEquals(1.0d, size6.getWidth());
    assertEquals(1.0d, size17.getWidth());
    assertEquals(1.0d, size19.getWidth());
    assertEquals(1.0d, size2.getWidth());
    assertEquals(1.0d, size9.getWidth());
    assertEquals(1.0d, size12.getWidth());
    assertEquals(1.0d, size21.getWidth());
    assertEquals(1.0d, size22.getWidth());
    assertEquals(1.0d, size14.getWidth());
    assertEquals(1.0d, size23.getWidth());
    assertEquals(1.0d, size24.getWidth());
    assertEquals(1.0d, size5.getWidth());
    assertEquals(1.0d, size16.getWidth());
    assertEquals(1.0d, size18.getWidth());
    assertEquals(1.0d, size25.getWidth());
    assertEquals(1.0d, size26.getWidth());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, size8.getWidth());
    assertEquals(1.0d, size11.getWidth());
    assertEquals(1.0d, size27.getWidth());
    assertEquals(1.0d, size20.getWidth());
    assertEquals(1.0d, size28.getWidth());
    assertEquals(1.0d, size29.getWidth());
    assertEquals(1.0d, bounds5.getWidth());
    assertEquals(1.0d, bounds4.getWidth());
    assertEquals(1.0d, bounds9.getWidth());
    assertEquals(1.0d, bounds13.getWidth());
    assertEquals(1.0d, bounds3.getWidth());
    assertEquals(1.0d, bounds8.getWidth());
    assertEquals(1.0d, bounds12.getWidth());
    assertEquals(1.0d, bounds15.getWidth());
    assertEquals(1.0d, bounds17.getWidth());
    assertEquals(1.0d, bounds2.getWidth());
    assertEquals(1.0d, bounds7.getWidth());
    assertEquals(1.0d, bounds11.getWidth());
    assertEquals(1.0d, bounds18.getWidth());
    assertEquals(1.0d, bounds14.getWidth());
    assertEquals(1.0d, bounds19.getWidth());
    assertEquals(1.0d, bounds20.getWidth());
    assertEquals(1.0d, bounds21.getWidth());
    assertEquals(1.0d, bounds16.getWidth());
    assertEquals(1.0d, bounds22.getWidth());
    assertEquals(1.0d, bounds23.getWidth());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds6.getWidth());
    assertEquals(1.0d, bounds10.getWidth());
    assertEquals(1.0d, bounds5.getMaxX());
    assertEquals(1.0d, bounds4.getMaxX());
    assertEquals(1.0d, bounds9.getMaxX());
    assertEquals(1.0d, bounds13.getMaxX());
    assertEquals(1.0d, bounds3.getMaxX());
    assertEquals(1.0d, bounds8.getMaxX());
    assertEquals(1.0d, bounds12.getMaxX());
    assertEquals(1.0d, bounds15.getMaxX());
    assertEquals(1.0d, bounds17.getMaxX());
    assertEquals(1.0d, bounds2.getMaxX());
    assertEquals(1.0d, bounds7.getMaxX());
    assertEquals(1.0d, bounds11.getMaxX());
    assertEquals(1.0d, bounds2D5.getMaxX());
    assertEquals(1.0d, bounds2D11.getMaxX());
    assertEquals(1.0d, bounds2D12.getMaxX());
    assertEquals(1.0d, bounds2D13.getMaxX());
    assertEquals(1.0d, bounds2D8.getMaxX());
    assertEquals(1.0d, bounds2D16.getMaxX());
    assertEquals(1.0d, bounds2D18.getMaxX());
    assertEquals(1.0d, bounds2D28.getMaxX());
    assertEquals(1.0d, bounds2D32.getMaxX());
    assertEquals(1.0d, bounds18.getMaxX());
    assertEquals(1.0d, bounds14.getMaxX());
    assertEquals(1.0d, bounds19.getMaxX());
    assertEquals(1.0d, bounds20.getMaxX());
    assertEquals(1.0d, bounds21.getMaxX());
    assertEquals(1.0d, bounds16.getMaxX());
    assertEquals(1.0d, bounds22.getMaxX());
    assertEquals(1.0d, bounds23.getMaxX());
    assertEquals(1.0d, frame5.getMaxX());
    assertEquals(1.0d, frame2.getMaxX());
    assertEquals(1.0d, frame6.getMaxX());
    assertEquals(1.0d, frame7.getMaxX());
    assertEquals(1.0d, frame8.getMaxX());
    assertEquals(1.0d, frame9.getMaxX());
    assertEquals(1.0d, frame.getMaxX());
    assertEquals(1.0d, frame3.getMaxX());
    assertEquals(1.0d, frame4.getMaxX());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds6.getMaxX());
    assertEquals(1.0d, bounds10.getMaxX());
    assertEquals(1.0d, bounds2D5.getWidth());
    assertEquals(1.0d, bounds2D11.getWidth());
    assertEquals(1.0d, bounds2D12.getWidth());
    assertEquals(1.0d, bounds2D13.getWidth());
    assertEquals(1.0d, bounds2D8.getWidth());
    assertEquals(1.0d, bounds2D16.getWidth());
    assertEquals(1.0d, bounds2D18.getWidth());
    assertEquals(1.0d, bounds2D28.getWidth());
    assertEquals(1.0d, bounds2D32.getWidth());
    assertEquals(1.0d, frame5.getWidth());
    assertEquals(1.0d, frame2.getWidth());
    assertEquals(1.0d, frame6.getWidth());
    assertEquals(1.0d, frame7.getWidth());
    assertEquals(1.0d, frame8.getWidth());
    assertEquals(1.0d, frame9.getWidth());
    assertEquals(1.0d, frame.getWidth());
    assertEquals(1.0d, frame3.getWidth());
    assertEquals(1.0d, frame4.getWidth());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle2D bounds2D = bounds5.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds4.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Raster data = actualStencilImage.getData();
    Rectangle bounds6 = data.getBounds();
    Rectangle bounds7 = bounds6.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D3 = bounds9.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    WritableRaster raster = actualStencilImage.getRaster();
    Rectangle bounds10 = raster.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle bounds13 = bounds12.getBounds();
    Rectangle2D bounds2D4 = bounds13.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds3.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds8.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds.getBounds2D();
    Rectangle bounds14 = bounds2D8.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D9 = bounds15.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds16 = frame.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D10 = bounds17.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds2.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds7.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D bounds2D13 = bounds11.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle bounds18 = bounds2D11.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds14.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds6.getBounds2D();
    Rectangle bounds19 = bounds2D16.getBounds();
    Rectangle2D bounds2D17 = bounds19.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    Rectangle bounds20 = bounds2D18.getBounds();
    Rectangle2D bounds2D19 = bounds20.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds21 = frame2.getBounds();
    Rectangle2D bounds2D20 = bounds21.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D21 = bounds16.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame3 = bounds6.getFrame();
    Rectangle bounds22 = frame3.getBounds();
    Rectangle2D bounds2D22 = bounds22.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D frame4 = bounds10.getFrame();
    Rectangle bounds23 = frame4.getBounds();
    Rectangle2D bounds2D23 = bounds23.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    assertTrue(bounds2D8 instanceof Rectangle);
    assertTrue(bounds2D16 instanceof Rectangle);
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D24 = bounds2D5.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D11.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D12.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D13.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D8.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D16.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D18.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds3.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds11.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds2D8.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    assertEquals(0.5d, bounds5.getCenterX());
    assertEquals(0.5d, bounds4.getCenterX());
    assertEquals(0.5d, bounds9.getCenterX());
    assertEquals(0.5d, bounds13.getCenterX());
    assertEquals(0.5d, bounds3.getCenterX());
    assertEquals(0.5d, bounds8.getCenterX());
    assertEquals(0.5d, bounds12.getCenterX());
    assertEquals(0.5d, bounds15.getCenterX());
    assertEquals(0.5d, bounds17.getCenterX());
    assertEquals(0.5d, bounds2.getCenterX());
    assertEquals(0.5d, bounds7.getCenterX());
    assertEquals(0.5d, bounds11.getCenterX());
    assertEquals(0.5d, bounds2D5.getCenterX());
    assertEquals(0.5d, bounds2D11.getCenterX());
    assertEquals(0.5d, bounds2D12.getCenterX());
    assertEquals(0.5d, bounds2D13.getCenterX());
    assertEquals(0.5d, bounds2D8.getCenterX());
    assertEquals(0.5d, bounds2D16.getCenterX());
    assertEquals(0.5d, bounds2D18.getCenterX());
    assertEquals(0.5d, bounds2D28.getCenterX());
    assertEquals(0.5d, bounds2D32.getCenterX());
    assertEquals(0.5d, bounds18.getCenterX());
    assertEquals(0.5d, bounds14.getCenterX());
    assertEquals(0.5d, bounds19.getCenterX());
    assertEquals(0.5d, bounds20.getCenterX());
    assertEquals(0.5d, bounds21.getCenterX());
    assertEquals(0.5d, bounds16.getCenterX());
    assertEquals(0.5d, bounds22.getCenterX());
    assertEquals(0.5d, bounds23.getCenterX());
    assertEquals(0.5d, frame5.getCenterX());
    assertEquals(0.5d, frame2.getCenterX());
    assertEquals(0.5d, frame6.getCenterX());
    assertEquals(0.5d, frame7.getCenterX());
    assertEquals(0.5d, frame8.getCenterX());
    assertEquals(0.5d, frame9.getCenterX());
    assertEquals(0.5d, frame.getCenterX());
    assertEquals(0.5d, frame3.getCenterX());
    assertEquals(0.5d, frame4.getCenterX());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds6.getCenterX());
    assertEquals(0.5d, bounds10.getCenterX());
    assertEquals(1, actualStencilImage.getTileWidth());
    assertEquals(1, actualStencilImage.getWidth());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, alphaRaster.getWidth());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, sampleModel2.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(1, size4.getSize().width);
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(1, size7.getSize().width);
    assertEquals(1, size4.width);
    Dimension size8 = bounds6.getSize();
    Dimension size9 = size8.getSize();
    Dimension size10 = size9.getSize();
    assertEquals(1, size10.getSize().width);
    Dimension size11 = bounds10.getSize();
    Dimension size12 = size11.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(1, size13.getSize().width);
    Dimension size14 = bounds3.getSize();
    Dimension size15 = size14.getSize();
    assertEquals(1, size15.getSize().width);
    assertEquals(1, size7.width);
    Dimension size16 = bounds7.getSize();
    Dimension size17 = size16.getSize();
    assertEquals(1, size17.getSize().width);
    Dimension size18 = bounds11.getSize();
    Dimension size19 = size18.getSize();
    assertEquals(1, size19.getSize().width);
    assertEquals(1, size3.width);
    assertEquals(1, size10.width);
    assertEquals(1, size13.width);
    Dimension size20 = ((Rectangle) bounds2D8).getSize();
    Dimension size21 = size20.getSize();
    assertEquals(1, size21.getSize().width);
    Dimension size22 = bounds4.getSize();
    assertEquals(1, size22.getSize().width);
    assertEquals(1, size15.width);
    Dimension size23 = bounds8.getSize();
    assertEquals(1, size23.getSize().width);
    Dimension size24 = bounds12.getSize();
    assertEquals(1, size24.getSize().width);
    assertEquals(1, size6.width);
    assertEquals(1, size17.width);
    assertEquals(1, size19.width);
    Dimension size25 = bounds14.getSize();
    assertEquals(1, size25.getSize().width);
    Dimension size26 = bounds16.getSize();
    assertEquals(1, size26.getSize().width);
    assertEquals(1, size2.width);
    assertEquals(1, size9.width);
    assertEquals(1, size12.width);
    Dimension size27 = ((Rectangle) bounds2D11).getSize();
    assertEquals(1, size27.getSize().width);
    assertEquals(1, size21.width);
    Dimension size28 = ((Rectangle) bounds2D16).getSize();
    assertEquals(1, size28.getSize().width);
    Dimension size29 = ((Rectangle) bounds2D18).getSize();
    assertEquals(1, size29.getSize().width);
    assertEquals(1, bounds5.getSize().width);
    assertEquals(1, size22.width);
    assertEquals(1, bounds9.getSize().width);
    assertEquals(1, bounds13.getSize().width);
    assertEquals(1, size14.width);
    assertEquals(1, size23.width);
    assertEquals(1, size24.width);
    assertEquals(1, bounds15.getSize().width);
    assertEquals(1, bounds17.getSize().width);
    assertEquals(1, size5.width);
    assertEquals(1, size16.width);
    assertEquals(1, size18.width);
    assertEquals(1, bounds18.getSize().width);
    assertEquals(1, size25.width);
    assertEquals(1, bounds19.getSize().width);
    assertEquals(1, bounds20.getSize().width);
    assertEquals(1, bounds21.getSize().width);
    assertEquals(1, size26.width);
    assertEquals(1, bounds22.getSize().width);
    assertEquals(1, bounds23.getSize().width);
    assertEquals(1, size.width);
    assertEquals(1, size8.width);
    assertEquals(1, size11.width);
    assertEquals(1, ((Rectangle) bounds2D5).getSize().width);
    assertEquals(1, size27.width);
    assertEquals(1, ((Rectangle) bounds2D12).getSize().width);
    assertEquals(1, ((Rectangle) bounds2D13).getSize().width);
    assertEquals(1, size20.width);
    assertEquals(1, size28.width);
    assertEquals(1, size29.width);
    assertEquals(1, ((Rectangle) bounds2D28).getSize().width);
    assertEquals(1, bounds5.getBounds().width);
    assertEquals(1, bounds5.width);
    assertEquals(1, bounds9.getBounds().width);
    assertEquals(1, bounds13.getBounds().width);
    assertEquals(1, bounds4.width);
    assertEquals(1, bounds9.width);
    assertEquals(1, bounds13.width);
    assertEquals(1, bounds15.getBounds().width);
    assertEquals(1, bounds17.getBounds().width);
    assertEquals(1, bounds3.width);
    assertEquals(1, bounds8.width);
    assertEquals(1, bounds12.width);
    assertEquals(1, bounds18.getBounds().width);
    assertEquals(1, bounds15.width);
    assertEquals(1, bounds19.getBounds().width);
    assertEquals(1, bounds20.getBounds().width);
    assertEquals(1, bounds21.getBounds().width);
    assertEquals(1, bounds17.width);
    assertEquals(1, bounds22.getBounds().width);
    assertEquals(1, bounds23.getBounds().width);
    assertEquals(1, bounds2.width);
    assertEquals(1, bounds7.width);
    assertEquals(1, bounds11.width);
    assertEquals(1, bounds2D5.getBounds().width);
    assertEquals(1, bounds18.width);
    assertEquals(1, bounds2D12.getBounds().width);
    assertEquals(1, bounds2D13.getBounds().width);
    assertEquals(1, bounds14.width);
    assertEquals(1, bounds19.width);
    assertEquals(1, bounds20.width);
    assertEquals(1, bounds2D28.getBounds().width);
    assertEquals(1, bounds2D32.getBounds().width);
    assertEquals(1, frame5.getBounds().width);
    assertEquals(1, bounds21.width);
    assertEquals(1, frame6.getBounds().width);
    assertEquals(1, frame7.getBounds().width);
    assertEquals(1, frame8.getBounds().width);
    assertEquals(1, frame9.getBounds().width);
    assertEquals(1, bounds16.width);
    assertEquals(1, bounds22.width);
    assertEquals(1, bounds23.width);
    assertEquals(1, bounds.width);
    assertEquals(1, bounds6.width);
    assertEquals(1, bounds10.width);
    assertEquals(1, ((Rectangle) bounds2D).width);
    assertEquals(1, ((Rectangle) bounds2D2).width);
    assertEquals(1, ((Rectangle) bounds2D3).width);
    assertEquals(1, ((Rectangle) bounds2D4).width);
    assertEquals(1, ((Rectangle) bounds2D5).width);
    assertEquals(1, ((Rectangle) bounds2D6).width);
    assertEquals(1, ((Rectangle) bounds2D7).width);
    assertEquals(1, ((Rectangle) bounds2D9).width);
    assertEquals(1, ((Rectangle) bounds2D10).width);
    assertEquals(1, ((Rectangle) bounds2D11).width);
    assertEquals(1, ((Rectangle) bounds2D12).width);
    assertEquals(1, ((Rectangle) bounds2D13).width);
    assertEquals(1, ((Rectangle) bounds2D14).width);
    assertEquals(1, ((Rectangle) bounds2D15).width);
    assertEquals(1, ((Rectangle) bounds2D17).width);
    assertEquals(1, ((Rectangle) bounds2D19).width);
    assertEquals(1, ((Rectangle) bounds2D20).width);
    assertEquals(1, ((Rectangle) bounds2D21).width);
    assertEquals(1, ((Rectangle) bounds2D22).width);
    assertEquals(1, ((Rectangle) bounds2D23).width);
    assertEquals(1, ((Rectangle) bounds2D8).width);
    assertEquals(1, ((Rectangle) bounds2D16).width);
    assertEquals(1, ((Rectangle) bounds2D18).width);
    assertEquals(1, ((Rectangle) bounds2D24).width);
    assertEquals(1, ((Rectangle) bounds2D25).width);
    assertEquals(1, ((Rectangle) bounds2D26).width);
    assertEquals(1, ((Rectangle) bounds2D27).width);
    assertEquals(1, ((Rectangle) bounds2D28).width);
    assertEquals(1, ((Rectangle) bounds2D29).width);
    assertEquals(1, ((Rectangle) bounds2D30).width);
    assertEquals(1, ((Rectangle) bounds2D31).width);
    assertEquals(1.0d, size4.getWidth());
    assertEquals(1.0d, size7.getWidth());
    assertEquals(1.0d, size3.getWidth());
    assertEquals(1.0d, size10.getWidth());
    assertEquals(1.0d, size13.getWidth());
    assertEquals(1.0d, size15.getWidth());
    assertEquals(1.0d, size6.getWidth());
    assertEquals(1.0d, size17.getWidth());
    assertEquals(1.0d, size19.getWidth());
    assertEquals(1.0d, size2.getWidth());
    assertEquals(1.0d, size9.getWidth());
    assertEquals(1.0d, size12.getWidth());
    assertEquals(1.0d, size21.getWidth());
    assertEquals(1.0d, size22.getWidth());
    assertEquals(1.0d, size14.getWidth());
    assertEquals(1.0d, size23.getWidth());
    assertEquals(1.0d, size24.getWidth());
    assertEquals(1.0d, size5.getWidth());
    assertEquals(1.0d, size16.getWidth());
    assertEquals(1.0d, size18.getWidth());
    assertEquals(1.0d, size25.getWidth());
    assertEquals(1.0d, size26.getWidth());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, size8.getWidth());
    assertEquals(1.0d, size11.getWidth());
    assertEquals(1.0d, size27.getWidth());
    assertEquals(1.0d, size20.getWidth());
    assertEquals(1.0d, size28.getWidth());
    assertEquals(1.0d, size29.getWidth());
    assertEquals(1.0d, bounds5.getWidth());
    assertEquals(1.0d, bounds4.getWidth());
    assertEquals(1.0d, bounds9.getWidth());
    assertEquals(1.0d, bounds13.getWidth());
    assertEquals(1.0d, bounds3.getWidth());
    assertEquals(1.0d, bounds8.getWidth());
    assertEquals(1.0d, bounds12.getWidth());
    assertEquals(1.0d, bounds15.getWidth());
    assertEquals(1.0d, bounds17.getWidth());
    assertEquals(1.0d, bounds2.getWidth());
    assertEquals(1.0d, bounds7.getWidth());
    assertEquals(1.0d, bounds11.getWidth());
    assertEquals(1.0d, bounds18.getWidth());
    assertEquals(1.0d, bounds14.getWidth());
    assertEquals(1.0d, bounds19.getWidth());
    assertEquals(1.0d, bounds20.getWidth());
    assertEquals(1.0d, bounds21.getWidth());
    assertEquals(1.0d, bounds16.getWidth());
    assertEquals(1.0d, bounds22.getWidth());
    assertEquals(1.0d, bounds23.getWidth());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds6.getWidth());
    assertEquals(1.0d, bounds10.getWidth());
    assertEquals(1.0d, bounds5.getMaxX());
    assertEquals(1.0d, bounds4.getMaxX());
    assertEquals(1.0d, bounds9.getMaxX());
    assertEquals(1.0d, bounds13.getMaxX());
    assertEquals(1.0d, bounds3.getMaxX());
    assertEquals(1.0d, bounds8.getMaxX());
    assertEquals(1.0d, bounds12.getMaxX());
    assertEquals(1.0d, bounds15.getMaxX());
    assertEquals(1.0d, bounds17.getMaxX());
    assertEquals(1.0d, bounds2.getMaxX());
    assertEquals(1.0d, bounds7.getMaxX());
    assertEquals(1.0d, bounds11.getMaxX());
    assertEquals(1.0d, bounds2D5.getMaxX());
    assertEquals(1.0d, bounds2D11.getMaxX());
    assertEquals(1.0d, bounds2D12.getMaxX());
    assertEquals(1.0d, bounds2D13.getMaxX());
    assertEquals(1.0d, bounds2D8.getMaxX());
    assertEquals(1.0d, bounds2D16.getMaxX());
    assertEquals(1.0d, bounds2D18.getMaxX());
    assertEquals(1.0d, bounds2D28.getMaxX());
    assertEquals(1.0d, bounds2D32.getMaxX());
    assertEquals(1.0d, bounds18.getMaxX());
    assertEquals(1.0d, bounds14.getMaxX());
    assertEquals(1.0d, bounds19.getMaxX());
    assertEquals(1.0d, bounds20.getMaxX());
    assertEquals(1.0d, bounds21.getMaxX());
    assertEquals(1.0d, bounds16.getMaxX());
    assertEquals(1.0d, bounds22.getMaxX());
    assertEquals(1.0d, bounds23.getMaxX());
    assertEquals(1.0d, frame5.getMaxX());
    assertEquals(1.0d, frame2.getMaxX());
    assertEquals(1.0d, frame6.getMaxX());
    assertEquals(1.0d, frame7.getMaxX());
    assertEquals(1.0d, frame8.getMaxX());
    assertEquals(1.0d, frame9.getMaxX());
    assertEquals(1.0d, frame.getMaxX());
    assertEquals(1.0d, frame3.getMaxX());
    assertEquals(1.0d, frame4.getMaxX());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds6.getMaxX());
    assertEquals(1.0d, bounds10.getMaxX());
    assertEquals(1.0d, bounds2D5.getWidth());
    assertEquals(1.0d, bounds2D11.getWidth());
    assertEquals(1.0d, bounds2D12.getWidth());
    assertEquals(1.0d, bounds2D13.getWidth());
    assertEquals(1.0d, bounds2D8.getWidth());
    assertEquals(1.0d, bounds2D16.getWidth());
    assertEquals(1.0d, bounds2D18.getWidth());
    assertEquals(1.0d, bounds2D28.getWidth());
    assertEquals(1.0d, bounds2D32.getWidth());
    assertEquals(1.0d, frame5.getWidth());
    assertEquals(1.0d, frame2.getWidth());
    assertEquals(1.0d, frame6.getWidth());
    assertEquals(1.0d, frame7.getWidth());
    assertEquals(1.0d, frame8.getWidth());
    assertEquals(1.0d, frame9.getWidth());
    assertEquals(1.0d, frame.getWidth());
    assertEquals(1.0d, frame3.getWidth());
    assertEquals(1.0d, frame4.getWidth());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle2D bounds2D = bounds5.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds4.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Raster data2 = actualStencilImage.getData();
    Rectangle bounds6 = data2.getBounds();
    Rectangle bounds7 = bounds6.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D3 = bounds9.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    WritableRaster raster = actualStencilImage.getRaster();
    Rectangle bounds10 = raster.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle bounds13 = bounds12.getBounds();
    Rectangle2D bounds2D4 = bounds13.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds3.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds8.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds.getBounds2D();
    Rectangle bounds14 = bounds2D8.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D9 = bounds15.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds16 = frame.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D10 = bounds17.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds2.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds7.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D bounds2D13 = bounds11.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle bounds18 = bounds2D11.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds14.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds6.getBounds2D();
    Rectangle bounds19 = bounds2D16.getBounds();
    Rectangle2D bounds2D17 = bounds19.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    Rectangle bounds20 = bounds2D18.getBounds();
    Rectangle2D bounds2D19 = bounds20.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds21 = frame2.getBounds();
    Rectangle2D bounds2D20 = bounds21.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D21 = bounds16.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame3 = bounds6.getFrame();
    Rectangle bounds22 = frame3.getBounds();
    Rectangle2D bounds2D22 = bounds22.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D frame4 = bounds10.getFrame();
    Rectangle bounds23 = frame4.getBounds();
    Rectangle2D bounds2D23 = bounds23.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    assertTrue(bounds2D8 instanceof Rectangle);
    assertTrue(bounds2D16 instanceof Rectangle);
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D24 = bounds2D5.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D11.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D12.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D13.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D8.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D16.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D18.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds3.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds11.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds2D8.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    assertEquals(1.0d, bounds5.getCenterX());
    assertEquals(1.0d, bounds4.getCenterX());
    assertEquals(1.0d, bounds9.getCenterX());
    assertEquals(1.0d, bounds13.getCenterX());
    assertEquals(1.0d, bounds3.getCenterX());
    assertEquals(1.0d, bounds8.getCenterX());
    assertEquals(1.0d, bounds12.getCenterX());
    assertEquals(1.0d, bounds15.getCenterX());
    assertEquals(1.0d, bounds17.getCenterX());
    assertEquals(1.0d, bounds2.getCenterX());
    assertEquals(1.0d, bounds7.getCenterX());
    assertEquals(1.0d, bounds11.getCenterX());
    assertEquals(1.0d, bounds2D5.getCenterX());
    assertEquals(1.0d, bounds2D11.getCenterX());
    assertEquals(1.0d, bounds2D12.getCenterX());
    assertEquals(1.0d, bounds2D13.getCenterX());
    assertEquals(1.0d, bounds2D8.getCenterX());
    assertEquals(1.0d, bounds2D16.getCenterX());
    assertEquals(1.0d, bounds2D18.getCenterX());
    assertEquals(1.0d, bounds2D28.getCenterX());
    assertEquals(1.0d, bounds2D32.getCenterX());
    assertEquals(1.0d, bounds18.getCenterX());
    assertEquals(1.0d, bounds14.getCenterX());
    assertEquals(1.0d, bounds19.getCenterX());
    assertEquals(1.0d, bounds20.getCenterX());
    assertEquals(1.0d, bounds21.getCenterX());
    assertEquals(1.0d, bounds16.getCenterX());
    assertEquals(1.0d, bounds22.getCenterX());
    assertEquals(1.0d, bounds23.getCenterX());
    assertEquals(1.0d, frame5.getCenterX());
    assertEquals(1.0d, frame2.getCenterX());
    assertEquals(1.0d, frame6.getCenterX());
    assertEquals(1.0d, frame7.getCenterX());
    assertEquals(1.0d, frame8.getCenterX());
    assertEquals(1.0d, frame9.getCenterX());
    assertEquals(1.0d, frame.getCenterX());
    assertEquals(1.0d, frame3.getCenterX());
    assertEquals(1.0d, frame4.getCenterX());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds6.getCenterX());
    assertEquals(1.0d, bounds10.getCenterX());
    assertEquals(2, actualStencilImage.getTileWidth());
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
    assertEquals(2, ((DataBufferInt) dataBuffer).getData().length);
    assertEquals(2, ((DataBufferInt) dataBuffer2).getData().length);
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(2, size4.getSize().width);
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(2, size7.getSize().width);
    assertEquals(2, size4.width);
    Dimension size8 = bounds6.getSize();
    Dimension size9 = size8.getSize();
    Dimension size10 = size9.getSize();
    assertEquals(2, size10.getSize().width);
    Dimension size11 = bounds10.getSize();
    Dimension size12 = size11.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(2, size13.getSize().width);
    Dimension size14 = bounds3.getSize();
    Dimension size15 = size14.getSize();
    assertEquals(2, size15.getSize().width);
    assertEquals(2, size7.width);
    Dimension size16 = bounds7.getSize();
    Dimension size17 = size16.getSize();
    assertEquals(2, size17.getSize().width);
    Dimension size18 = bounds11.getSize();
    Dimension size19 = size18.getSize();
    assertEquals(2, size19.getSize().width);
    assertEquals(2, size3.width);
    assertEquals(2, size10.width);
    assertEquals(2, size13.width);
    Dimension size20 = ((Rectangle) bounds2D8).getSize();
    Dimension size21 = size20.getSize();
    assertEquals(2, size21.getSize().width);
    Dimension size22 = bounds4.getSize();
    assertEquals(2, size22.getSize().width);
    assertEquals(2, size15.width);
    Dimension size23 = bounds8.getSize();
    assertEquals(2, size23.getSize().width);
    Dimension size24 = bounds12.getSize();
    assertEquals(2, size24.getSize().width);
    assertEquals(2, size6.width);
    assertEquals(2, size17.width);
    assertEquals(2, size19.width);
    Dimension size25 = bounds14.getSize();
    assertEquals(2, size25.getSize().width);
    Dimension size26 = bounds16.getSize();
    assertEquals(2, size26.getSize().width);
    assertEquals(2, size2.width);
    assertEquals(2, size9.width);
    assertEquals(2, size12.width);
    Dimension size27 = ((Rectangle) bounds2D11).getSize();
    assertEquals(2, size27.getSize().width);
    assertEquals(2, size21.width);
    Dimension size28 = ((Rectangle) bounds2D16).getSize();
    assertEquals(2, size28.getSize().width);
    Dimension size29 = ((Rectangle) bounds2D18).getSize();
    assertEquals(2, size29.getSize().width);
    assertEquals(2, bounds5.getSize().width);
    assertEquals(2, size22.width);
    assertEquals(2, bounds9.getSize().width);
    assertEquals(2, bounds13.getSize().width);
    assertEquals(2, size14.width);
    assertEquals(2, size23.width);
    assertEquals(2, size24.width);
    assertEquals(2, bounds15.getSize().width);
    assertEquals(2, bounds17.getSize().width);
    assertEquals(2, size5.width);
    assertEquals(2, size16.width);
    assertEquals(2, size18.width);
    assertEquals(2, bounds18.getSize().width);
    assertEquals(2, size25.width);
    assertEquals(2, bounds19.getSize().width);
    assertEquals(2, bounds20.getSize().width);
    assertEquals(2, bounds21.getSize().width);
    assertEquals(2, size26.width);
    assertEquals(2, bounds22.getSize().width);
    assertEquals(2, bounds23.getSize().width);
    assertEquals(2, size.width);
    assertEquals(2, size8.width);
    assertEquals(2, size11.width);
    assertEquals(2, ((Rectangle) bounds2D5).getSize().width);
    assertEquals(2, size27.width);
    assertEquals(2, ((Rectangle) bounds2D12).getSize().width);
    assertEquals(2, ((Rectangle) bounds2D13).getSize().width);
    assertEquals(2, size20.width);
    assertEquals(2, size28.width);
    assertEquals(2, size29.width);
    assertEquals(2, ((Rectangle) bounds2D28).getSize().width);
    assertEquals(2, bounds5.getBounds().width);
    assertEquals(2, bounds5.width);
    assertEquals(2, bounds9.getBounds().width);
    assertEquals(2, bounds13.getBounds().width);
    assertEquals(2, bounds4.width);
    assertEquals(2, bounds9.width);
    assertEquals(2, bounds13.width);
    assertEquals(2, bounds15.getBounds().width);
    assertEquals(2, bounds17.getBounds().width);
    assertEquals(2, bounds3.width);
    assertEquals(2, bounds8.width);
    assertEquals(2, bounds12.width);
    assertEquals(2, bounds18.getBounds().width);
    assertEquals(2, bounds15.width);
    assertEquals(2, bounds19.getBounds().width);
    assertEquals(2, bounds20.getBounds().width);
    assertEquals(2, bounds21.getBounds().width);
    assertEquals(2, bounds17.width);
    assertEquals(2, bounds22.getBounds().width);
    assertEquals(2, bounds23.getBounds().width);
    assertEquals(2, bounds2.width);
    assertEquals(2, bounds7.width);
    assertEquals(2, bounds11.width);
    assertEquals(2, bounds2D5.getBounds().width);
    assertEquals(2, bounds18.width);
    assertEquals(2, bounds2D12.getBounds().width);
    assertEquals(2, bounds2D13.getBounds().width);
    assertEquals(2, bounds14.width);
    assertEquals(2, bounds19.width);
    assertEquals(2, bounds20.width);
    assertEquals(2, bounds2D28.getBounds().width);
    assertEquals(2, bounds2D32.getBounds().width);
    assertEquals(2, frame5.getBounds().width);
    assertEquals(2, bounds21.width);
    assertEquals(2, frame6.getBounds().width);
    assertEquals(2, frame7.getBounds().width);
    assertEquals(2, frame8.getBounds().width);
    assertEquals(2, frame9.getBounds().width);
    assertEquals(2, bounds16.width);
    assertEquals(2, bounds22.width);
    assertEquals(2, bounds23.width);
    assertEquals(2, bounds.width);
    assertEquals(2, bounds6.width);
    assertEquals(2, bounds10.width);
    assertEquals(2, ((Rectangle) bounds2D).width);
    assertEquals(2, ((Rectangle) bounds2D2).width);
    assertEquals(2, ((Rectangle) bounds2D3).width);
    assertEquals(2, ((Rectangle) bounds2D4).width);
    assertEquals(2, ((Rectangle) bounds2D5).width);
    assertEquals(2, ((Rectangle) bounds2D6).width);
    assertEquals(2, ((Rectangle) bounds2D7).width);
    assertEquals(2, ((Rectangle) bounds2D9).width);
    assertEquals(2, ((Rectangle) bounds2D10).width);
    assertEquals(2, ((Rectangle) bounds2D11).width);
    assertEquals(2, ((Rectangle) bounds2D12).width);
    assertEquals(2, ((Rectangle) bounds2D13).width);
    assertEquals(2, ((Rectangle) bounds2D14).width);
    assertEquals(2, ((Rectangle) bounds2D15).width);
    assertEquals(2, ((Rectangle) bounds2D17).width);
    assertEquals(2, ((Rectangle) bounds2D19).width);
    assertEquals(2, ((Rectangle) bounds2D20).width);
    assertEquals(2, ((Rectangle) bounds2D21).width);
    assertEquals(2, ((Rectangle) bounds2D22).width);
    assertEquals(2, ((Rectangle) bounds2D23).width);
    assertEquals(2, ((Rectangle) bounds2D8).width);
    assertEquals(2, ((Rectangle) bounds2D16).width);
    assertEquals(2, ((Rectangle) bounds2D18).width);
    assertEquals(2, ((Rectangle) bounds2D24).width);
    assertEquals(2, ((Rectangle) bounds2D25).width);
    assertEquals(2, ((Rectangle) bounds2D26).width);
    assertEquals(2, ((Rectangle) bounds2D27).width);
    assertEquals(2, ((Rectangle) bounds2D28).width);
    assertEquals(2, ((Rectangle) bounds2D29).width);
    assertEquals(2, ((Rectangle) bounds2D30).width);
    assertEquals(2, ((Rectangle) bounds2D31).width);
    assertEquals(2.0d, size4.getWidth());
    assertEquals(2.0d, size7.getWidth());
    assertEquals(2.0d, size3.getWidth());
    assertEquals(2.0d, size10.getWidth());
    assertEquals(2.0d, size13.getWidth());
    assertEquals(2.0d, size15.getWidth());
    assertEquals(2.0d, size6.getWidth());
    assertEquals(2.0d, size17.getWidth());
    assertEquals(2.0d, size19.getWidth());
    assertEquals(2.0d, size2.getWidth());
    assertEquals(2.0d, size9.getWidth());
    assertEquals(2.0d, size12.getWidth());
    assertEquals(2.0d, size21.getWidth());
    assertEquals(2.0d, size22.getWidth());
    assertEquals(2.0d, size14.getWidth());
    assertEquals(2.0d, size23.getWidth());
    assertEquals(2.0d, size24.getWidth());
    assertEquals(2.0d, size5.getWidth());
    assertEquals(2.0d, size16.getWidth());
    assertEquals(2.0d, size18.getWidth());
    assertEquals(2.0d, size25.getWidth());
    assertEquals(2.0d, size26.getWidth());
    assertEquals(2.0d, size.getWidth());
    assertEquals(2.0d, size8.getWidth());
    assertEquals(2.0d, size11.getWidth());
    assertEquals(2.0d, size27.getWidth());
    assertEquals(2.0d, size20.getWidth());
    assertEquals(2.0d, size28.getWidth());
    assertEquals(2.0d, size29.getWidth());
    assertEquals(2.0d, bounds5.getWidth());
    assertEquals(2.0d, bounds4.getWidth());
    assertEquals(2.0d, bounds9.getWidth());
    assertEquals(2.0d, bounds13.getWidth());
    assertEquals(2.0d, bounds3.getWidth());
    assertEquals(2.0d, bounds8.getWidth());
    assertEquals(2.0d, bounds12.getWidth());
    assertEquals(2.0d, bounds15.getWidth());
    assertEquals(2.0d, bounds17.getWidth());
    assertEquals(2.0d, bounds2.getWidth());
    assertEquals(2.0d, bounds7.getWidth());
    assertEquals(2.0d, bounds11.getWidth());
    assertEquals(2.0d, bounds18.getWidth());
    assertEquals(2.0d, bounds14.getWidth());
    assertEquals(2.0d, bounds19.getWidth());
    assertEquals(2.0d, bounds20.getWidth());
    assertEquals(2.0d, bounds21.getWidth());
    assertEquals(2.0d, bounds16.getWidth());
    assertEquals(2.0d, bounds22.getWidth());
    assertEquals(2.0d, bounds23.getWidth());
    assertEquals(2.0d, bounds.getWidth());
    assertEquals(2.0d, bounds6.getWidth());
    assertEquals(2.0d, bounds10.getWidth());
    assertEquals(2.0d, bounds5.getMaxX());
    assertEquals(2.0d, bounds4.getMaxX());
    assertEquals(2.0d, bounds9.getMaxX());
    assertEquals(2.0d, bounds13.getMaxX());
    assertEquals(2.0d, bounds3.getMaxX());
    assertEquals(2.0d, bounds8.getMaxX());
    assertEquals(2.0d, bounds12.getMaxX());
    assertEquals(2.0d, bounds15.getMaxX());
    assertEquals(2.0d, bounds17.getMaxX());
    assertEquals(2.0d, bounds2.getMaxX());
    assertEquals(2.0d, bounds7.getMaxX());
    assertEquals(2.0d, bounds11.getMaxX());
    assertEquals(2.0d, bounds2D5.getMaxX());
    assertEquals(2.0d, bounds2D11.getMaxX());
    assertEquals(2.0d, bounds2D12.getMaxX());
    assertEquals(2.0d, bounds2D13.getMaxX());
    assertEquals(2.0d, bounds2D8.getMaxX());
    assertEquals(2.0d, bounds2D16.getMaxX());
    assertEquals(2.0d, bounds2D18.getMaxX());
    assertEquals(2.0d, bounds2D28.getMaxX());
    assertEquals(2.0d, bounds2D32.getMaxX());
    assertEquals(2.0d, bounds18.getMaxX());
    assertEquals(2.0d, bounds14.getMaxX());
    assertEquals(2.0d, bounds19.getMaxX());
    assertEquals(2.0d, bounds20.getMaxX());
    assertEquals(2.0d, bounds21.getMaxX());
    assertEquals(2.0d, bounds16.getMaxX());
    assertEquals(2.0d, bounds22.getMaxX());
    assertEquals(2.0d, bounds23.getMaxX());
    assertEquals(2.0d, frame5.getMaxX());
    assertEquals(2.0d, frame2.getMaxX());
    assertEquals(2.0d, frame6.getMaxX());
    assertEquals(2.0d, frame7.getMaxX());
    assertEquals(2.0d, frame8.getMaxX());
    assertEquals(2.0d, frame9.getMaxX());
    assertEquals(2.0d, frame.getMaxX());
    assertEquals(2.0d, frame3.getMaxX());
    assertEquals(2.0d, frame4.getMaxX());
    assertEquals(2.0d, bounds.getMaxX());
    assertEquals(2.0d, bounds6.getMaxX());
    assertEquals(2.0d, bounds10.getMaxX());
    assertEquals(2.0d, bounds2D5.getWidth());
    assertEquals(2.0d, bounds2D11.getWidth());
    assertEquals(2.0d, bounds2D12.getWidth());
    assertEquals(2.0d, bounds2D13.getWidth());
    assertEquals(2.0d, bounds2D8.getWidth());
    assertEquals(2.0d, bounds2D16.getWidth());
    assertEquals(2.0d, bounds2D18.getWidth());
    assertEquals(2.0d, bounds2D28.getWidth());
    assertEquals(2.0d, bounds2D32.getWidth());
    assertEquals(2.0d, frame5.getWidth());
    assertEquals(2.0d, frame2.getWidth());
    assertEquals(2.0d, frame6.getWidth());
    assertEquals(2.0d, frame7.getWidth());
    assertEquals(2.0d, frame8.getWidth());
    assertEquals(2.0d, frame9.getWidth());
    assertEquals(2.0d, frame.getWidth());
    assertEquals(2.0d, frame3.getWidth());
    assertEquals(2.0d, frame4.getWidth());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle2D bounds2D = bounds5.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds4.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Raster data2 = actualStencilImage.getData();
    Rectangle bounds6 = data2.getBounds();
    Rectangle bounds7 = bounds6.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D3 = bounds9.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    WritableRaster raster = actualStencilImage.getRaster();
    Rectangle bounds10 = raster.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle bounds13 = bounds12.getBounds();
    Rectangle2D bounds2D4 = bounds13.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds3.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds8.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds.getBounds2D();
    Rectangle bounds14 = bounds2D8.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D9 = bounds15.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds16 = frame.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D10 = bounds17.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds2.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds7.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D bounds2D13 = bounds11.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle bounds18 = bounds2D11.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds14.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds6.getBounds2D();
    Rectangle bounds19 = bounds2D16.getBounds();
    Rectangle2D bounds2D17 = bounds19.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    Rectangle bounds20 = bounds2D18.getBounds();
    Rectangle2D bounds2D19 = bounds20.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds21 = frame2.getBounds();
    Rectangle2D bounds2D20 = bounds21.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D21 = bounds16.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame3 = bounds6.getFrame();
    Rectangle bounds22 = frame3.getBounds();
    Rectangle2D bounds2D22 = bounds22.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D frame4 = bounds10.getFrame();
    Rectangle bounds23 = frame4.getBounds();
    Rectangle2D bounds2D23 = bounds23.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    assertTrue(bounds2D8 instanceof Rectangle);
    assertTrue(bounds2D16 instanceof Rectangle);
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D24 = bounds2D5.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D11.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D12.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D13.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D8.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D16.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D18.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds3.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds11.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds2D8.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    assertEquals(4.0d, bounds5.getCenterX());
    assertEquals(4.0d, bounds4.getCenterX());
    assertEquals(4.0d, bounds9.getCenterX());
    assertEquals(4.0d, bounds13.getCenterX());
    assertEquals(4.0d, bounds3.getCenterX());
    assertEquals(4.0d, bounds8.getCenterX());
    assertEquals(4.0d, bounds12.getCenterX());
    assertEquals(4.0d, bounds15.getCenterX());
    assertEquals(4.0d, bounds17.getCenterX());
    assertEquals(4.0d, bounds2.getCenterX());
    assertEquals(4.0d, bounds7.getCenterX());
    assertEquals(4.0d, bounds11.getCenterX());
    assertEquals(4.0d, bounds2D5.getCenterX());
    assertEquals(4.0d, bounds2D11.getCenterX());
    assertEquals(4.0d, bounds2D12.getCenterX());
    assertEquals(4.0d, bounds2D13.getCenterX());
    assertEquals(4.0d, bounds2D8.getCenterX());
    assertEquals(4.0d, bounds2D16.getCenterX());
    assertEquals(4.0d, bounds2D18.getCenterX());
    assertEquals(4.0d, bounds2D28.getCenterX());
    assertEquals(4.0d, bounds2D32.getCenterX());
    assertEquals(4.0d, bounds18.getCenterX());
    assertEquals(4.0d, bounds14.getCenterX());
    assertEquals(4.0d, bounds19.getCenterX());
    assertEquals(4.0d, bounds20.getCenterX());
    assertEquals(4.0d, bounds21.getCenterX());
    assertEquals(4.0d, bounds16.getCenterX());
    assertEquals(4.0d, bounds22.getCenterX());
    assertEquals(4.0d, bounds23.getCenterX());
    assertEquals(4.0d, frame5.getCenterX());
    assertEquals(4.0d, frame2.getCenterX());
    assertEquals(4.0d, frame6.getCenterX());
    assertEquals(4.0d, frame7.getCenterX());
    assertEquals(4.0d, frame8.getCenterX());
    assertEquals(4.0d, frame9.getCenterX());
    assertEquals(4.0d, frame.getCenterX());
    assertEquals(4.0d, frame3.getCenterX());
    assertEquals(4.0d, frame4.getCenterX());
    assertEquals(4.0d, bounds.getCenterX());
    assertEquals(4.0d, bounds6.getCenterX());
    assertEquals(4.0d, bounds10.getCenterX());
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
    assertEquals(8, ((DataBufferInt) dataBuffer).getData().length);
    assertEquals(8, ((DataBufferInt) dataBuffer2).getData().length);
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(8, size4.getSize().width);
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(8, size7.getSize().width);
    assertEquals(8, size4.width);
    Dimension size8 = bounds6.getSize();
    Dimension size9 = size8.getSize();
    Dimension size10 = size9.getSize();
    assertEquals(8, size10.getSize().width);
    Dimension size11 = bounds10.getSize();
    Dimension size12 = size11.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(8, size13.getSize().width);
    Dimension size14 = bounds3.getSize();
    Dimension size15 = size14.getSize();
    assertEquals(8, size15.getSize().width);
    assertEquals(8, size7.width);
    Dimension size16 = bounds7.getSize();
    Dimension size17 = size16.getSize();
    assertEquals(8, size17.getSize().width);
    Dimension size18 = bounds11.getSize();
    Dimension size19 = size18.getSize();
    assertEquals(8, size19.getSize().width);
    assertEquals(8, size3.width);
    assertEquals(8, size10.width);
    assertEquals(8, size13.width);
    Dimension size20 = ((Rectangle) bounds2D8).getSize();
    Dimension size21 = size20.getSize();
    assertEquals(8, size21.getSize().width);
    Dimension size22 = bounds4.getSize();
    assertEquals(8, size22.getSize().width);
    assertEquals(8, size15.width);
    Dimension size23 = bounds8.getSize();
    assertEquals(8, size23.getSize().width);
    Dimension size24 = bounds12.getSize();
    assertEquals(8, size24.getSize().width);
    assertEquals(8, size6.width);
    assertEquals(8, size17.width);
    assertEquals(8, size19.width);
    Dimension size25 = bounds14.getSize();
    assertEquals(8, size25.getSize().width);
    Dimension size26 = bounds16.getSize();
    assertEquals(8, size26.getSize().width);
    assertEquals(8, size2.width);
    assertEquals(8, size9.width);
    assertEquals(8, size12.width);
    Dimension size27 = ((Rectangle) bounds2D11).getSize();
    assertEquals(8, size27.getSize().width);
    assertEquals(8, size21.width);
    Dimension size28 = ((Rectangle) bounds2D16).getSize();
    assertEquals(8, size28.getSize().width);
    Dimension size29 = ((Rectangle) bounds2D18).getSize();
    assertEquals(8, size29.getSize().width);
    assertEquals(8, bounds5.getSize().width);
    assertEquals(8, size22.width);
    assertEquals(8, bounds9.getSize().width);
    assertEquals(8, bounds13.getSize().width);
    assertEquals(8, size14.width);
    assertEquals(8, size23.width);
    assertEquals(8, size24.width);
    assertEquals(8, bounds15.getSize().width);
    assertEquals(8, bounds17.getSize().width);
    assertEquals(8, size5.width);
    assertEquals(8, size16.width);
    assertEquals(8, size18.width);
    assertEquals(8, bounds18.getSize().width);
    assertEquals(8, size25.width);
    assertEquals(8, bounds19.getSize().width);
    assertEquals(8, bounds20.getSize().width);
    assertEquals(8, bounds21.getSize().width);
    assertEquals(8, size26.width);
    assertEquals(8, bounds22.getSize().width);
    assertEquals(8, bounds23.getSize().width);
    assertEquals(8, size.width);
    assertEquals(8, size8.width);
    assertEquals(8, size11.width);
    assertEquals(8, ((Rectangle) bounds2D5).getSize().width);
    assertEquals(8, size27.width);
    assertEquals(8, ((Rectangle) bounds2D12).getSize().width);
    assertEquals(8, ((Rectangle) bounds2D13).getSize().width);
    assertEquals(8, size20.width);
    assertEquals(8, size28.width);
    assertEquals(8, size29.width);
    assertEquals(8, ((Rectangle) bounds2D28).getSize().width);
    assertEquals(8, bounds5.getBounds().width);
    assertEquals(8, bounds5.width);
    assertEquals(8, bounds9.getBounds().width);
    assertEquals(8, bounds13.getBounds().width);
    assertEquals(8, bounds4.width);
    assertEquals(8, bounds9.width);
    assertEquals(8, bounds13.width);
    assertEquals(8, bounds15.getBounds().width);
    assertEquals(8, bounds17.getBounds().width);
    assertEquals(8, bounds3.width);
    assertEquals(8, bounds8.width);
    assertEquals(8, bounds12.width);
    assertEquals(8, bounds18.getBounds().width);
    assertEquals(8, bounds15.width);
    assertEquals(8, bounds19.getBounds().width);
    assertEquals(8, bounds20.getBounds().width);
    assertEquals(8, bounds21.getBounds().width);
    assertEquals(8, bounds17.width);
    assertEquals(8, bounds22.getBounds().width);
    assertEquals(8, bounds23.getBounds().width);
    assertEquals(8, bounds2.width);
    assertEquals(8, bounds7.width);
    assertEquals(8, bounds11.width);
    assertEquals(8, bounds2D5.getBounds().width);
    assertEquals(8, bounds18.width);
    assertEquals(8, bounds2D12.getBounds().width);
    assertEquals(8, bounds2D13.getBounds().width);
    assertEquals(8, bounds14.width);
    assertEquals(8, bounds19.width);
    assertEquals(8, bounds20.width);
    assertEquals(8, bounds2D28.getBounds().width);
    assertEquals(8, bounds2D32.getBounds().width);
    assertEquals(8, frame5.getBounds().width);
    assertEquals(8, bounds21.width);
    assertEquals(8, frame6.getBounds().width);
    assertEquals(8, frame7.getBounds().width);
    assertEquals(8, frame8.getBounds().width);
    assertEquals(8, frame9.getBounds().width);
    assertEquals(8, bounds16.width);
    assertEquals(8, bounds22.width);
    assertEquals(8, bounds23.width);
    assertEquals(8, bounds.width);
    assertEquals(8, bounds6.width);
    assertEquals(8, bounds10.width);
    assertEquals(8, ((Rectangle) bounds2D).width);
    assertEquals(8, ((Rectangle) bounds2D2).width);
    assertEquals(8, ((Rectangle) bounds2D3).width);
    assertEquals(8, ((Rectangle) bounds2D4).width);
    assertEquals(8, ((Rectangle) bounds2D5).width);
    assertEquals(8, ((Rectangle) bounds2D6).width);
    assertEquals(8, ((Rectangle) bounds2D7).width);
    assertEquals(8, ((Rectangle) bounds2D9).width);
    assertEquals(8, ((Rectangle) bounds2D10).width);
    assertEquals(8, ((Rectangle) bounds2D11).width);
    assertEquals(8, ((Rectangle) bounds2D12).width);
    assertEquals(8, ((Rectangle) bounds2D13).width);
    assertEquals(8, ((Rectangle) bounds2D14).width);
    assertEquals(8, ((Rectangle) bounds2D15).width);
    assertEquals(8, ((Rectangle) bounds2D17).width);
    assertEquals(8, ((Rectangle) bounds2D19).width);
    assertEquals(8, ((Rectangle) bounds2D20).width);
    assertEquals(8, ((Rectangle) bounds2D21).width);
    assertEquals(8, ((Rectangle) bounds2D22).width);
    assertEquals(8, ((Rectangle) bounds2D23).width);
    assertEquals(8, ((Rectangle) bounds2D8).width);
    assertEquals(8, ((Rectangle) bounds2D16).width);
    assertEquals(8, ((Rectangle) bounds2D18).width);
    assertEquals(8, ((Rectangle) bounds2D24).width);
    assertEquals(8, ((Rectangle) bounds2D25).width);
    assertEquals(8, ((Rectangle) bounds2D26).width);
    assertEquals(8, ((Rectangle) bounds2D27).width);
    assertEquals(8, ((Rectangle) bounds2D28).width);
    assertEquals(8, ((Rectangle) bounds2D29).width);
    assertEquals(8, ((Rectangle) bounds2D30).width);
    assertEquals(8, ((Rectangle) bounds2D31).width);
    assertEquals(8.0d, size4.getWidth());
    assertEquals(8.0d, size7.getWidth());
    assertEquals(8.0d, size3.getWidth());
    assertEquals(8.0d, size10.getWidth());
    assertEquals(8.0d, size13.getWidth());
    assertEquals(8.0d, size15.getWidth());
    assertEquals(8.0d, size6.getWidth());
    assertEquals(8.0d, size17.getWidth());
    assertEquals(8.0d, size19.getWidth());
    assertEquals(8.0d, size2.getWidth());
    assertEquals(8.0d, size9.getWidth());
    assertEquals(8.0d, size12.getWidth());
    assertEquals(8.0d, size21.getWidth());
    assertEquals(8.0d, size22.getWidth());
    assertEquals(8.0d, size14.getWidth());
    assertEquals(8.0d, size23.getWidth());
    assertEquals(8.0d, size24.getWidth());
    assertEquals(8.0d, size5.getWidth());
    assertEquals(8.0d, size16.getWidth());
    assertEquals(8.0d, size18.getWidth());
    assertEquals(8.0d, size25.getWidth());
    assertEquals(8.0d, size26.getWidth());
    assertEquals(8.0d, size.getWidth());
    assertEquals(8.0d, size8.getWidth());
    assertEquals(8.0d, size11.getWidth());
    assertEquals(8.0d, size27.getWidth());
    assertEquals(8.0d, size20.getWidth());
    assertEquals(8.0d, size28.getWidth());
    assertEquals(8.0d, size29.getWidth());
    assertEquals(8.0d, bounds5.getWidth());
    assertEquals(8.0d, bounds4.getWidth());
    assertEquals(8.0d, bounds9.getWidth());
    assertEquals(8.0d, bounds13.getWidth());
    assertEquals(8.0d, bounds3.getWidth());
    assertEquals(8.0d, bounds8.getWidth());
    assertEquals(8.0d, bounds12.getWidth());
    assertEquals(8.0d, bounds15.getWidth());
    assertEquals(8.0d, bounds17.getWidth());
    assertEquals(8.0d, bounds2.getWidth());
    assertEquals(8.0d, bounds7.getWidth());
    assertEquals(8.0d, bounds11.getWidth());
    assertEquals(8.0d, bounds18.getWidth());
    assertEquals(8.0d, bounds14.getWidth());
    assertEquals(8.0d, bounds19.getWidth());
    assertEquals(8.0d, bounds20.getWidth());
    assertEquals(8.0d, bounds21.getWidth());
    assertEquals(8.0d, bounds16.getWidth());
    assertEquals(8.0d, bounds22.getWidth());
    assertEquals(8.0d, bounds23.getWidth());
    assertEquals(8.0d, bounds.getWidth());
    assertEquals(8.0d, bounds6.getWidth());
    assertEquals(8.0d, bounds10.getWidth());
    assertEquals(8.0d, bounds5.getMaxX());
    assertEquals(8.0d, bounds4.getMaxX());
    assertEquals(8.0d, bounds9.getMaxX());
    assertEquals(8.0d, bounds13.getMaxX());
    assertEquals(8.0d, bounds3.getMaxX());
    assertEquals(8.0d, bounds8.getMaxX());
    assertEquals(8.0d, bounds12.getMaxX());
    assertEquals(8.0d, bounds15.getMaxX());
    assertEquals(8.0d, bounds17.getMaxX());
    assertEquals(8.0d, bounds2.getMaxX());
    assertEquals(8.0d, bounds7.getMaxX());
    assertEquals(8.0d, bounds11.getMaxX());
    assertEquals(8.0d, bounds2D5.getMaxX());
    assertEquals(8.0d, bounds2D11.getMaxX());
    assertEquals(8.0d, bounds2D12.getMaxX());
    assertEquals(8.0d, bounds2D13.getMaxX());
    assertEquals(8.0d, bounds2D8.getMaxX());
    assertEquals(8.0d, bounds2D16.getMaxX());
    assertEquals(8.0d, bounds2D18.getMaxX());
    assertEquals(8.0d, bounds2D28.getMaxX());
    assertEquals(8.0d, bounds2D32.getMaxX());
    assertEquals(8.0d, bounds18.getMaxX());
    assertEquals(8.0d, bounds14.getMaxX());
    assertEquals(8.0d, bounds19.getMaxX());
    assertEquals(8.0d, bounds20.getMaxX());
    assertEquals(8.0d, bounds21.getMaxX());
    assertEquals(8.0d, bounds16.getMaxX());
    assertEquals(8.0d, bounds22.getMaxX());
    assertEquals(8.0d, bounds23.getMaxX());
    assertEquals(8.0d, frame5.getMaxX());
    assertEquals(8.0d, frame2.getMaxX());
    assertEquals(8.0d, frame6.getMaxX());
    assertEquals(8.0d, frame7.getMaxX());
    assertEquals(8.0d, frame8.getMaxX());
    assertEquals(8.0d, frame9.getMaxX());
    assertEquals(8.0d, frame.getMaxX());
    assertEquals(8.0d, frame3.getMaxX());
    assertEquals(8.0d, frame4.getMaxX());
    assertEquals(8.0d, bounds.getMaxX());
    assertEquals(8.0d, bounds6.getMaxX());
    assertEquals(8.0d, bounds10.getMaxX());
    assertEquals(8.0d, bounds2D5.getWidth());
    assertEquals(8.0d, bounds2D11.getWidth());
    assertEquals(8.0d, bounds2D12.getWidth());
    assertEquals(8.0d, bounds2D13.getWidth());
    assertEquals(8.0d, bounds2D8.getWidth());
    assertEquals(8.0d, bounds2D16.getWidth());
    assertEquals(8.0d, bounds2D18.getWidth());
    assertEquals(8.0d, bounds2D28.getWidth());
    assertEquals(8.0d, bounds2D32.getWidth());
    assertEquals(8.0d, frame5.getWidth());
    assertEquals(8.0d, frame2.getWidth());
    assertEquals(8.0d, frame6.getWidth());
    assertEquals(8.0d, frame7.getWidth());
    assertEquals(8.0d, frame8.getWidth());
    assertEquals(8.0d, frame9.getWidth());
    assertEquals(8.0d, frame.getWidth());
    assertEquals(8.0d, frame3.getWidth());
    assertEquals(8.0d, frame4.getWidth());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When decode {@code 42}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); given 'A'; when decode '42'; then return array length is one")
  void testGetStencilImage_givenA_whenDecode42_thenReturnArrayLengthIsOne() throws IOException, NumberFormatException {
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
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertArrayEquals(new int[]{0}, data2);
    assertArrayEquals(new int[]{0}, data3);
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <ul>
   *   <li>Then return ninth element is {@code -16777174}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); then return ninth element is '-16777174'")
  void testGetStencilImage_thenReturnNinthElementIs16777174() throws IOException, NumberFormatException {
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
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle2D bounds2D = bounds5.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds4.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Raster data2 = actualStencilImage.getData();
    Rectangle bounds6 = data2.getBounds();
    Rectangle bounds7 = bounds6.getBounds();
    Rectangle bounds8 = bounds7.getBounds();
    Rectangle bounds9 = bounds8.getBounds();
    Rectangle2D bounds2D3 = bounds9.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    WritableRaster raster = actualStencilImage.getRaster();
    Rectangle bounds10 = raster.getBounds();
    Rectangle bounds11 = bounds10.getBounds();
    Rectangle bounds12 = bounds11.getBounds();
    Rectangle bounds13 = bounds12.getBounds();
    Rectangle2D bounds2D4 = bounds13.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds3.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds8.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds12.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds.getBounds2D();
    Rectangle bounds14 = bounds2D8.getBounds();
    Rectangle bounds15 = bounds14.getBounds();
    Rectangle2D bounds2D9 = bounds15.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds16 = frame.getBounds();
    Rectangle bounds17 = bounds16.getBounds();
    Rectangle2D bounds2D10 = bounds17.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = bounds2.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle);
    Rectangle2D bounds2D12 = bounds7.getBounds2D();
    assertTrue(bounds2D12 instanceof Rectangle);
    Rectangle2D bounds2D13 = bounds11.getBounds2D();
    assertTrue(bounds2D13 instanceof Rectangle);
    Rectangle bounds18 = bounds2D11.getBounds();
    Rectangle2D bounds2D14 = bounds18.getBounds2D();
    assertTrue(bounds2D14 instanceof Rectangle);
    Rectangle2D bounds2D15 = bounds14.getBounds2D();
    assertTrue(bounds2D15 instanceof Rectangle);
    Rectangle2D bounds2D16 = bounds6.getBounds2D();
    Rectangle bounds19 = bounds2D16.getBounds();
    Rectangle2D bounds2D17 = bounds19.getBounds2D();
    assertTrue(bounds2D17 instanceof Rectangle);
    Rectangle2D bounds2D18 = bounds10.getBounds2D();
    Rectangle bounds20 = bounds2D18.getBounds();
    Rectangle2D bounds2D19 = bounds20.getBounds2D();
    assertTrue(bounds2D19 instanceof Rectangle);
    Rectangle2D frame2 = bounds2.getFrame();
    Rectangle bounds21 = frame2.getBounds();
    Rectangle2D bounds2D20 = bounds21.getBounds2D();
    assertTrue(bounds2D20 instanceof Rectangle);
    Rectangle2D bounds2D21 = bounds16.getBounds2D();
    assertTrue(bounds2D21 instanceof Rectangle);
    Rectangle2D frame3 = bounds6.getFrame();
    Rectangle bounds22 = frame3.getBounds();
    Rectangle2D bounds2D22 = bounds22.getBounds2D();
    assertTrue(bounds2D22 instanceof Rectangle);
    Rectangle2D frame4 = bounds10.getFrame();
    Rectangle bounds23 = frame4.getBounds();
    Rectangle2D bounds2D23 = bounds23.getBounds2D();
    assertTrue(bounds2D23 instanceof Rectangle);
    assertTrue(bounds2D8 instanceof Rectangle);
    assertTrue(bounds2D16 instanceof Rectangle);
    assertTrue(bounds2D18 instanceof Rectangle);
    Rectangle2D bounds2D24 = bounds2D5.getBounds2D();
    assertTrue(bounds2D24 instanceof Rectangle);
    Rectangle2D bounds2D25 = bounds2D11.getBounds2D();
    assertTrue(bounds2D25 instanceof Rectangle);
    Rectangle2D bounds2D26 = bounds2D12.getBounds2D();
    assertTrue(bounds2D26 instanceof Rectangle);
    Rectangle2D bounds2D27 = bounds2D13.getBounds2D();
    assertTrue(bounds2D27 instanceof Rectangle);
    Rectangle2D bounds2D28 = bounds2D8.getBounds2D();
    assertTrue(bounds2D28 instanceof Rectangle);
    Rectangle2D bounds2D29 = bounds2D16.getBounds2D();
    assertTrue(bounds2D29 instanceof Rectangle);
    Rectangle2D bounds2D30 = bounds2D18.getBounds2D();
    assertTrue(bounds2D30 instanceof Rectangle);
    Rectangle2D bounds2D31 = bounds2D28.getBounds2D();
    assertTrue(bounds2D31 instanceof Rectangle);
    Rectangle2D bounds2D32 = frame.getBounds2D();
    assertTrue(bounds2D32 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds3.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = bounds7.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    Rectangle2D frame7 = bounds11.getFrame();
    assertTrue(frame7 instanceof Rectangle2D.Double);
    Rectangle2D frame8 = bounds2D8.getFrame();
    assertTrue(frame8 instanceof Rectangle2D.Double);
    Rectangle2D frame9 = frame.getFrame();
    assertTrue(frame9 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    assertTrue(frame3 instanceof Rectangle2D.Double);
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    int[] data3 = ((DataBufferInt) dataBuffer).getData();
    assertEquals(-16777174, data3[8]);
    int[] data4 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(-16777174, data4[8]);
    assertEquals(4.5d, bounds5.getCenterX());
    assertEquals(4.5d, bounds4.getCenterX());
    assertEquals(4.5d, bounds9.getCenterX());
    assertEquals(4.5d, bounds13.getCenterX());
    assertEquals(4.5d, bounds3.getCenterX());
    assertEquals(4.5d, bounds8.getCenterX());
    assertEquals(4.5d, bounds12.getCenterX());
    assertEquals(4.5d, bounds15.getCenterX());
    assertEquals(4.5d, bounds17.getCenterX());
    assertEquals(4.5d, bounds2.getCenterX());
    assertEquals(4.5d, bounds7.getCenterX());
    assertEquals(4.5d, bounds11.getCenterX());
    assertEquals(4.5d, bounds2D5.getCenterX());
    assertEquals(4.5d, bounds2D11.getCenterX());
    assertEquals(4.5d, bounds2D12.getCenterX());
    assertEquals(4.5d, bounds2D13.getCenterX());
    assertEquals(4.5d, bounds2D8.getCenterX());
    assertEquals(4.5d, bounds2D16.getCenterX());
    assertEquals(4.5d, bounds2D18.getCenterX());
    assertEquals(4.5d, bounds2D28.getCenterX());
    assertEquals(4.5d, bounds2D32.getCenterX());
    assertEquals(4.5d, bounds18.getCenterX());
    assertEquals(4.5d, bounds14.getCenterX());
    assertEquals(4.5d, bounds19.getCenterX());
    assertEquals(4.5d, bounds20.getCenterX());
    assertEquals(4.5d, bounds21.getCenterX());
    assertEquals(4.5d, bounds16.getCenterX());
    assertEquals(4.5d, bounds22.getCenterX());
    assertEquals(4.5d, bounds23.getCenterX());
    assertEquals(4.5d, frame5.getCenterX());
    assertEquals(4.5d, frame2.getCenterX());
    assertEquals(4.5d, frame6.getCenterX());
    assertEquals(4.5d, frame7.getCenterX());
    assertEquals(4.5d, frame8.getCenterX());
    assertEquals(4.5d, frame9.getCenterX());
    assertEquals(4.5d, frame.getCenterX());
    assertEquals(4.5d, frame3.getCenterX());
    assertEquals(4.5d, frame4.getCenterX());
    assertEquals(4.5d, bounds.getCenterX());
    assertEquals(4.5d, bounds6.getCenterX());
    assertEquals(4.5d, bounds10.getCenterX());
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
    assertEquals(9, data3.length);
    assertEquals(9, data4.length);
    Dimension size = bounds.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    Dimension size4 = size3.getSize();
    assertEquals(9, size4.getSize().width);
    Dimension size5 = bounds2.getSize();
    Dimension size6 = size5.getSize();
    Dimension size7 = size6.getSize();
    assertEquals(9, size7.getSize().width);
    assertEquals(9, size4.width);
    Dimension size8 = bounds6.getSize();
    Dimension size9 = size8.getSize();
    Dimension size10 = size9.getSize();
    assertEquals(9, size10.getSize().width);
    Dimension size11 = bounds10.getSize();
    Dimension size12 = size11.getSize();
    Dimension size13 = size12.getSize();
    assertEquals(9, size13.getSize().width);
    Dimension size14 = bounds3.getSize();
    Dimension size15 = size14.getSize();
    assertEquals(9, size15.getSize().width);
    assertEquals(9, size7.width);
    Dimension size16 = bounds7.getSize();
    Dimension size17 = size16.getSize();
    assertEquals(9, size17.getSize().width);
    Dimension size18 = bounds11.getSize();
    Dimension size19 = size18.getSize();
    assertEquals(9, size19.getSize().width);
    assertEquals(9, size3.width);
    assertEquals(9, size10.width);
    assertEquals(9, size13.width);
    Dimension size20 = ((Rectangle) bounds2D8).getSize();
    Dimension size21 = size20.getSize();
    assertEquals(9, size21.getSize().width);
    Dimension size22 = bounds4.getSize();
    assertEquals(9, size22.getSize().width);
    assertEquals(9, size15.width);
    Dimension size23 = bounds8.getSize();
    assertEquals(9, size23.getSize().width);
    Dimension size24 = bounds12.getSize();
    assertEquals(9, size24.getSize().width);
    assertEquals(9, size6.width);
    assertEquals(9, size17.width);
    assertEquals(9, size19.width);
    Dimension size25 = bounds14.getSize();
    assertEquals(9, size25.getSize().width);
    Dimension size26 = bounds16.getSize();
    assertEquals(9, size26.getSize().width);
    assertEquals(9, size2.width);
    assertEquals(9, size9.width);
    assertEquals(9, size12.width);
    Dimension size27 = ((Rectangle) bounds2D11).getSize();
    assertEquals(9, size27.getSize().width);
    assertEquals(9, size21.width);
    Dimension size28 = ((Rectangle) bounds2D16).getSize();
    assertEquals(9, size28.getSize().width);
    Dimension size29 = ((Rectangle) bounds2D18).getSize();
    assertEquals(9, size29.getSize().width);
    assertEquals(9, bounds5.getSize().width);
    assertEquals(9, size22.width);
    assertEquals(9, bounds9.getSize().width);
    assertEquals(9, bounds13.getSize().width);
    assertEquals(9, size14.width);
    assertEquals(9, size23.width);
    assertEquals(9, size24.width);
    assertEquals(9, bounds15.getSize().width);
    assertEquals(9, bounds17.getSize().width);
    assertEquals(9, size5.width);
    assertEquals(9, size16.width);
    assertEquals(9, size18.width);
    assertEquals(9, bounds18.getSize().width);
    assertEquals(9, size25.width);
    assertEquals(9, bounds19.getSize().width);
    assertEquals(9, bounds20.getSize().width);
    assertEquals(9, bounds21.getSize().width);
    assertEquals(9, size26.width);
    assertEquals(9, bounds22.getSize().width);
    assertEquals(9, bounds23.getSize().width);
    assertEquals(9, size.width);
    assertEquals(9, size8.width);
    assertEquals(9, size11.width);
    assertEquals(9, ((Rectangle) bounds2D5).getSize().width);
    assertEquals(9, size27.width);
    assertEquals(9, ((Rectangle) bounds2D12).getSize().width);
    assertEquals(9, ((Rectangle) bounds2D13).getSize().width);
    assertEquals(9, size20.width);
    assertEquals(9, size28.width);
    assertEquals(9, size29.width);
    assertEquals(9, ((Rectangle) bounds2D28).getSize().width);
    assertEquals(9, bounds5.getBounds().width);
    assertEquals(9, bounds5.width);
    assertEquals(9, bounds9.getBounds().width);
    assertEquals(9, bounds13.getBounds().width);
    assertEquals(9, bounds4.width);
    assertEquals(9, bounds9.width);
    assertEquals(9, bounds13.width);
    assertEquals(9, bounds15.getBounds().width);
    assertEquals(9, bounds17.getBounds().width);
    assertEquals(9, bounds3.width);
    assertEquals(9, bounds8.width);
    assertEquals(9, bounds12.width);
    assertEquals(9, bounds18.getBounds().width);
    assertEquals(9, bounds15.width);
    assertEquals(9, bounds19.getBounds().width);
    assertEquals(9, bounds20.getBounds().width);
    assertEquals(9, bounds21.getBounds().width);
    assertEquals(9, bounds17.width);
    assertEquals(9, bounds22.getBounds().width);
    assertEquals(9, bounds23.getBounds().width);
    assertEquals(9, bounds2.width);
    assertEquals(9, bounds7.width);
    assertEquals(9, bounds11.width);
    assertEquals(9, bounds2D5.getBounds().width);
    assertEquals(9, bounds18.width);
    assertEquals(9, bounds2D12.getBounds().width);
    assertEquals(9, bounds2D13.getBounds().width);
    assertEquals(9, bounds14.width);
    assertEquals(9, bounds19.width);
    assertEquals(9, bounds20.width);
    assertEquals(9, bounds2D28.getBounds().width);
    assertEquals(9, bounds2D32.getBounds().width);
    assertEquals(9, frame5.getBounds().width);
    assertEquals(9, bounds21.width);
    assertEquals(9, frame6.getBounds().width);
    assertEquals(9, frame7.getBounds().width);
    assertEquals(9, frame8.getBounds().width);
    assertEquals(9, frame9.getBounds().width);
    assertEquals(9, bounds16.width);
    assertEquals(9, bounds22.width);
    assertEquals(9, bounds23.width);
    assertEquals(9, bounds.width);
    assertEquals(9, bounds6.width);
    assertEquals(9, bounds10.width);
    assertEquals(9, ((Rectangle) bounds2D).width);
    assertEquals(9, ((Rectangle) bounds2D2).width);
    assertEquals(9, ((Rectangle) bounds2D3).width);
    assertEquals(9, ((Rectangle) bounds2D4).width);
    assertEquals(9, ((Rectangle) bounds2D5).width);
    assertEquals(9, ((Rectangle) bounds2D6).width);
    assertEquals(9, ((Rectangle) bounds2D7).width);
    assertEquals(9, ((Rectangle) bounds2D9).width);
    assertEquals(9, ((Rectangle) bounds2D10).width);
    assertEquals(9, ((Rectangle) bounds2D11).width);
    assertEquals(9, ((Rectangle) bounds2D12).width);
    assertEquals(9, ((Rectangle) bounds2D13).width);
    assertEquals(9, ((Rectangle) bounds2D14).width);
    assertEquals(9, ((Rectangle) bounds2D15).width);
    assertEquals(9, ((Rectangle) bounds2D17).width);
    assertEquals(9, ((Rectangle) bounds2D19).width);
    assertEquals(9, ((Rectangle) bounds2D20).width);
    assertEquals(9, ((Rectangle) bounds2D21).width);
    assertEquals(9, ((Rectangle) bounds2D22).width);
    assertEquals(9, ((Rectangle) bounds2D23).width);
    assertEquals(9, ((Rectangle) bounds2D8).width);
    assertEquals(9, ((Rectangle) bounds2D16).width);
    assertEquals(9, ((Rectangle) bounds2D18).width);
    assertEquals(9, ((Rectangle) bounds2D24).width);
    assertEquals(9, ((Rectangle) bounds2D25).width);
    assertEquals(9, ((Rectangle) bounds2D26).width);
    assertEquals(9, ((Rectangle) bounds2D27).width);
    assertEquals(9, ((Rectangle) bounds2D28).width);
    assertEquals(9, ((Rectangle) bounds2D29).width);
    assertEquals(9, ((Rectangle) bounds2D30).width);
    assertEquals(9, ((Rectangle) bounds2D31).width);
    assertEquals(9.0d, size4.getWidth());
    assertEquals(9.0d, size7.getWidth());
    assertEquals(9.0d, size3.getWidth());
    assertEquals(9.0d, size10.getWidth());
    assertEquals(9.0d, size13.getWidth());
    assertEquals(9.0d, size15.getWidth());
    assertEquals(9.0d, size6.getWidth());
    assertEquals(9.0d, size17.getWidth());
    assertEquals(9.0d, size19.getWidth());
    assertEquals(9.0d, size2.getWidth());
    assertEquals(9.0d, size9.getWidth());
    assertEquals(9.0d, size12.getWidth());
    assertEquals(9.0d, size21.getWidth());
    assertEquals(9.0d, size22.getWidth());
    assertEquals(9.0d, size14.getWidth());
    assertEquals(9.0d, size23.getWidth());
    assertEquals(9.0d, size24.getWidth());
    assertEquals(9.0d, size5.getWidth());
    assertEquals(9.0d, size16.getWidth());
    assertEquals(9.0d, size18.getWidth());
    assertEquals(9.0d, size25.getWidth());
    assertEquals(9.0d, size26.getWidth());
    assertEquals(9.0d, size.getWidth());
    assertEquals(9.0d, size8.getWidth());
    assertEquals(9.0d, size11.getWidth());
    assertEquals(9.0d, size27.getWidth());
    assertEquals(9.0d, size20.getWidth());
    assertEquals(9.0d, size28.getWidth());
    assertEquals(9.0d, size29.getWidth());
    assertEquals(9.0d, bounds5.getWidth());
    assertEquals(9.0d, bounds4.getWidth());
    assertEquals(9.0d, bounds9.getWidth());
    assertEquals(9.0d, bounds13.getWidth());
    assertEquals(9.0d, bounds3.getWidth());
    assertEquals(9.0d, bounds8.getWidth());
    assertEquals(9.0d, bounds12.getWidth());
    assertEquals(9.0d, bounds15.getWidth());
    assertEquals(9.0d, bounds17.getWidth());
    assertEquals(9.0d, bounds2.getWidth());
    assertEquals(9.0d, bounds7.getWidth());
    assertEquals(9.0d, bounds11.getWidth());
    assertEquals(9.0d, bounds18.getWidth());
    assertEquals(9.0d, bounds14.getWidth());
    assertEquals(9.0d, bounds19.getWidth());
    assertEquals(9.0d, bounds20.getWidth());
    assertEquals(9.0d, bounds21.getWidth());
    assertEquals(9.0d, bounds16.getWidth());
    assertEquals(9.0d, bounds22.getWidth());
    assertEquals(9.0d, bounds23.getWidth());
    assertEquals(9.0d, bounds.getWidth());
    assertEquals(9.0d, bounds6.getWidth());
    assertEquals(9.0d, bounds10.getWidth());
    assertEquals(9.0d, bounds5.getMaxX());
    assertEquals(9.0d, bounds4.getMaxX());
    assertEquals(9.0d, bounds9.getMaxX());
    assertEquals(9.0d, bounds13.getMaxX());
    assertEquals(9.0d, bounds3.getMaxX());
    assertEquals(9.0d, bounds8.getMaxX());
    assertEquals(9.0d, bounds12.getMaxX());
    assertEquals(9.0d, bounds15.getMaxX());
    assertEquals(9.0d, bounds17.getMaxX());
    assertEquals(9.0d, bounds2.getMaxX());
    assertEquals(9.0d, bounds7.getMaxX());
    assertEquals(9.0d, bounds11.getMaxX());
    assertEquals(9.0d, bounds2D5.getMaxX());
    assertEquals(9.0d, bounds2D11.getMaxX());
    assertEquals(9.0d, bounds2D12.getMaxX());
    assertEquals(9.0d, bounds2D13.getMaxX());
    assertEquals(9.0d, bounds2D8.getMaxX());
    assertEquals(9.0d, bounds2D16.getMaxX());
    assertEquals(9.0d, bounds2D18.getMaxX());
    assertEquals(9.0d, bounds2D28.getMaxX());
    assertEquals(9.0d, bounds2D32.getMaxX());
    assertEquals(9.0d, bounds18.getMaxX());
    assertEquals(9.0d, bounds14.getMaxX());
    assertEquals(9.0d, bounds19.getMaxX());
    assertEquals(9.0d, bounds20.getMaxX());
    assertEquals(9.0d, bounds21.getMaxX());
    assertEquals(9.0d, bounds16.getMaxX());
    assertEquals(9.0d, bounds22.getMaxX());
    assertEquals(9.0d, bounds23.getMaxX());
    assertEquals(9.0d, frame5.getMaxX());
    assertEquals(9.0d, frame2.getMaxX());
    assertEquals(9.0d, frame6.getMaxX());
    assertEquals(9.0d, frame7.getMaxX());
    assertEquals(9.0d, frame8.getMaxX());
    assertEquals(9.0d, frame9.getMaxX());
    assertEquals(9.0d, frame.getMaxX());
    assertEquals(9.0d, frame3.getMaxX());
    assertEquals(9.0d, frame4.getMaxX());
    assertEquals(9.0d, bounds.getMaxX());
    assertEquals(9.0d, bounds6.getMaxX());
    assertEquals(9.0d, bounds10.getMaxX());
    assertEquals(9.0d, bounds2D5.getWidth());
    assertEquals(9.0d, bounds2D11.getWidth());
    assertEquals(9.0d, bounds2D12.getWidth());
    assertEquals(9.0d, bounds2D13.getWidth());
    assertEquals(9.0d, bounds2D8.getWidth());
    assertEquals(9.0d, bounds2D16.getWidth());
    assertEquals(9.0d, bounds2D18.getWidth());
    assertEquals(9.0d, bounds2D28.getWidth());
    assertEquals(9.0d, bounds2D32.getWidth());
    assertEquals(9.0d, frame5.getWidth());
    assertEquals(9.0d, frame2.getWidth());
    assertEquals(9.0d, frame6.getWidth());
    assertEquals(9.0d, frame7.getWidth());
    assertEquals(9.0d, frame8.getWidth());
    assertEquals(9.0d, frame9.getWidth());
    assertEquals(9.0d, frame.getWidth());
    assertEquals(9.0d, frame3.getWidth());
    assertEquals(9.0d, frame4.getWidth());
  }

  /**
   * Test {@link PDInlineImage#getSuffix()}.
   * <p>
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix()")
  void testGetSuffix() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("png", (new PDInlineImage(parameters, data, new PDResources())).getSuffix());
  }

  /**
   * Test {@link PDInlineImage#getSuffix()}.
   * <p>
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix()")
  void testGetSuffix2() throws IOException {
    // Arrange
    COSStream parameters = new COSStream();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("png", (new PDInlineImage(parameters, data, new PDResources())).getSuffix());
  }

  /**
   * Test {@link PDInlineImage#getSuffix()}.
   * <p>
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix()")
  void testGetSuffix3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setFilters(new ArrayList<>());

    // Act and Assert
    assertEquals("png", pdInlineImage.getSuffix());
  }

  /**
   * Test {@link PDInlineImage#getSuffix()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix(); given ArrayList() add 'foo'")
  void testGetSuffix_givenArrayListAddFoo() throws IOException {
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
   * Test {@link PDInlineImage#getSuffix()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix(); given ArrayList() add 'png'")
  void testGetSuffix_givenArrayListAddPng() throws IOException {
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
}
