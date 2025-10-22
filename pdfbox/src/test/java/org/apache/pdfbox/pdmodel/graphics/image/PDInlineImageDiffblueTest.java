package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDInlineImageDiffblueTest {
  /**
   * Test {@link PDInlineImage#PDInlineImage(COSDictionary, byte[], PDResources)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Suffix is {@code png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#PDInlineImage(COSDictionary, byte[], PDResources)}
   */
  @Test
  @DisplayName("Test new PDInlineImage(COSDictionary, byte[], PDResources); when COSDictionary(); then return Suffix is 'png'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.<init>(COSDictionary, byte[], PDResources)"})
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
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualPdInlineImage.getData());
  }

  /**
   * Test {@link PDInlineImage#getCOSObject()}.
   * <p>
   * Method under test: {@link PDInlineImage#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDInlineImage.getCOSObject()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getBitsPerComponent()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getBitsPerComponent()"})
  void testGetBitsPerComponent2() throws IOException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getBitsPerComponent()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getBitsPerComponent()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setBitsPerComponent(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setBitsPerComponent(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
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
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
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
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
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
   * Test {@link PDInlineImage#getColorSpace()}.
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
  void testGetColorSpace5() throws IOException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
  void testGetColorSpace6() throws IOException {
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
   *   <li>Given {@link PDResources#PDResources()} add {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDResources() add INSTANCE; then return INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDInlineImage.getColorSpace()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setColorSpace(PDColorSpace)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setColorSpace(PDColorSpace)"})
  void testSetColorSpace2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setColorSpace(null);

    // Assert that nothing has changed
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setColorSpace(PDColorSpace)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getHeight()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getHeight()"})
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
   * Test {@link PDInlineImage#setHeight(int)}.
   * <p>
   * Method under test: {@link PDInlineImage#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setHeight(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setHeight(int)"})
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
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getWidth()"})
  void testGetWidth_thenReturnMinusOne() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDInlineImage.getWidth()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setWidth(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setWidth(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.getInterpolate()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.getInterpolate()"})
  void testGetInterpolate2() throws IOException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.getInterpolate()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setInterpolate(boolean)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setInterpolate(boolean)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDInlineImage.getFilters()"})
  void testGetFilters() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDInlineImage.getFilters()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDInlineImage.getFilters()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDInlineImage.getFilters()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setFilters(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setFilters(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setFilters(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setDecode(COSArray)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setDecode(COSArray)"})
  void testSetDecode2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act
    pdInlineImage.setDecode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdInlineImage.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDInlineImage#getDecode()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getDecode()}
   */
  @Test
  @DisplayName("Test getDecode(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDInlineImage.getDecode()"})
  void testGetDecode_thenReturnNull() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDInlineImage.getDecode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.isStencil()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.isStencil()"})
  void testIsStencil2() throws IOException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.isStencil()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInlineImage.setStencil(boolean)"})
  void testSetStencil() throws IOException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDInlineImage.createInputStream()"})
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
   * Test {@link PDInlineImage#createInputStream(DecodeOptions)} with {@code options}.
   * <p>
   * Method under test: {@link PDInlineImage#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDInlineImage.createInputStream(DecodeOptions)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDInlineImage.createInputStream(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDInlineImage.createInputStream(List)"})
  void testCreateInputStreamWithStopFilters2() throws IOException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDInlineImage.createInputStream(List)"})
  void testCreateInputStreamWithStopFilters3() throws IOException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDInlineImage.createInputStream(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDInlineImage.createInputStream(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.isEmpty()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDInlineImage.isEmpty()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDInlineImage.getData()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage()"})
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
   * Test {@link PDInlineImage#getImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage()"})
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
   * Test {@link PDInlineImage#getImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage()"})
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
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt2() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setHeight(8);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt3() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setColorSpace(new PDCalGray());

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt4() throws IOException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());
    pdInlineImage.setStencil(false);

    // Act and Assert
    assertThrows(IOException.class, () -> pdInlineImage.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDInlineImage#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getImage(Rectangle, int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.WritableRaster PDInlineImage.getRawRaster()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.WritableRaster PDInlineImage.getRawRaster()"})
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
   * Test {@link PDInlineImage#getRawRaster()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.WritableRaster PDInlineImage.getRawRaster()"})
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
   * Test {@link PDInlineImage#getRawImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getRawImage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getRawImage()"})
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
   * Test {@link PDInlineImage#getRawImage()}.
   * <p>
   * Method under test: {@link PDInlineImage#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getRawImage()"})
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
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage() throws IOException, NumberFormatException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage2() throws IOException, NumberFormatException {
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
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage3() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    PDInlineImage pdInlineImage = new PDInlineImage(parameters, new byte[]{}, new PDResources());
    pdInlineImage.setWidth(1);
    pdInlineImage.setHeight(1);
    pdInlineImage.setStencil(true);

    // Act
    BufferedImage actualStencilImage = pdInlineImage.getStencilImage(Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When decode {@code 42}.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); given 'A'; when decode '42'; then ColorModel return DirectColorModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage_givenA_whenDecode42_thenColorModelReturnDirectColorModel()
      throws IOException, NumberFormatException {
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
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <ul>
   *   <li>Then return TileWidth is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); then return TileWidth is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsEight() throws IOException, NumberFormatException {
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
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertEquals(8, actualStencilImage.getTileWidth());
    assertEquals(8, actualStencilImage.getWidth());
    assertEquals(8, actualStencilImage.getAlphaRaster().getWidth());
    assertEquals(8, actualStencilImage.getData().getWidth());
    assertEquals(8, actualStencilImage.getRaster().getWidth());
    assertEquals(8, sampleModel.getWidth());
    assertEquals(8, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <ul>
   *   <li>Then return TileWidth is nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); then return TileWidth is nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsNine() throws IOException, NumberFormatException {
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
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertEquals(9, actualStencilImage.getTileWidth());
    assertEquals(9, actualStencilImage.getWidth());
    assertEquals(9, actualStencilImage.getAlphaRaster().getWidth());
    assertEquals(9, actualStencilImage.getData().getWidth());
    assertEquals(9, actualStencilImage.getRaster().getWidth());
    assertEquals(9, sampleModel.getWidth());
    assertEquals(9, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <ul>
   *   <li>Then return TileWidth is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); then return TileWidth is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsTwo() throws IOException, NumberFormatException {
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
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertEquals(2, actualStencilImage.getTileWidth());
    assertEquals(2, actualStencilImage.getWidth());
    assertEquals(2, actualStencilImage.getAlphaRaster().getWidth());
    assertEquals(2, actualStencilImage.getData().getWidth());
    assertEquals(2, actualStencilImage.getRaster().getWidth());
    assertEquals(2, sampleModel.getWidth());
    assertEquals(2, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDInlineImage#getStencilImage(Paint)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDInlineImage.getStencilImage(Paint)"})
  void testGetStencilImage_thenThrowIllegalStateException() throws IOException, NumberFormatException {
    // Arrange
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    PDInlineImage pdInlineImage = new PDInlineImage(parameters, data, new PDResources());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdInlineImage.getStencilImage(Color.decode("42")));
  }

  /**
   * Test {@link PDInlineImage#getSuffix()}.
   * <p>
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDInlineImage.getSuffix()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDInlineImage.getSuffix()"})
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
   * Test {@link PDInlineImage#getSuffix()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInlineImage#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix(); given ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDInlineImage.getSuffix()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDInlineImage.getSuffix()"})
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
