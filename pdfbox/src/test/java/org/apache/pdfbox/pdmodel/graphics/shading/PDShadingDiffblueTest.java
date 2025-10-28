package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDShadingDiffblueTest {
  /**
   * Method under test: {@link PDShading#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act and Assert
    assertSame(shadingDictionary, (new PDShadingType1(shadingDictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Shading", (new PDShadingType1(new COSDictionary())).getType());
  }

  /**
   * Method under test: {@link PDShading#setShadingType(int)}
   */
  @Test
  void testSetShadingType() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setShadingType(1);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setShadingType(int)}
   */
  @Test
  void testSetShadingType2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setShadingType(Integer.MIN_VALUE);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  void testSetBackground() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    COSArray newBackground = new COSArray();

    // Act
    pdShadingType1.setBackground(newBackground);

    // Assert
    assertSame(newBackground, pdShadingType1.getBackground());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  void testSetBackground2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setBackground(null);

    // Assert
    assertNull(pdShadingType1.getBackground());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  void testSetBackground3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newBackground = new COSArray();
    newBackground.add(object);

    // Act
    pdShadingType1.setBackground(newBackground);

    // Assert
    verify(object).getCOSObject();
    assertSame(newBackground, pdShadingType1.getBackground());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#getBackground()}
   */
  @Test
  void testGetBackground() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getBackground());
  }

  /**
   * Method under test: {@link PDShading#getBBox()}
   */
  @Test
  void testGetBBox() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getBBox());
  }

  /**
   * Method under test: {@link PDShading#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    PDRectangle newBBox = PDRectangle.A0;

    // Act
    pdShadingType1.setBBox(newBBox);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    PDRectangle expectedBBox = newBBox.A0;
    assertSame(expectedBBox, pdShadingType1.getBBox());
  }

  /**
   * Method under test: {@link PDShading#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    PDRectangle newBBox = PDRectangle.A1;

    // Act
    pdShadingType1.setBBox(newBBox);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    PDRectangle expectedBBox = newBBox.A1;
    assertSame(expectedBBox, pdShadingType1.getBBox());
  }

  /**
   * Method under test: {@link PDShading#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setBBox(null);

    // Assert
    assertNull(pdShadingType1.getBBox());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#getBounds(AffineTransform, Matrix)}
   */
  @Test
  void testGetBounds() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType1.getBounds(xform, new Matrix()));
  }

  /**
   * Method under test: {@link PDShading#setAntiAlias(boolean)}
   */
  @Test
  void testSetAntiAlias() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setAntiAlias(true);

    // Assert
    assertTrue(pdShadingType1.getAntiAlias());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setAntiAlias(boolean)}
   */
  @Test
  void testSetAntiAlias2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setAntiAlias(false);

    // Assert
    assertFalse(pdShadingType1.getAntiAlias());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  void testGetAntiAlias() {
    // Arrange, Act and Assert
    assertFalse((new PDShadingType1(new COSDictionary())).getAntiAlias());
  }

  /**
   * Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  void testGetAntiAlias2() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    pdShadingType1.setAntiAlias(true);

    // Act and Assert
    assertTrue(pdShadingType1.getAntiAlias());
  }

  /**
   * Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  void testGetAntiAlias3() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    pdShadingType1.setAntiAlias(false);

    // Act and Assert
    assertFalse(pdShadingType1.getAntiAlias());
  }

  /**
   * Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  void testSetColorSpace() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    pdShadingType1.setColorSpace(colorSpace);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, pdShadingType1.getColorSpace());
  }

  /**
   * Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  void testSetColorSpace2() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    PDCalGray colorSpace = new PDCalGray();

    // Act
    pdShadingType1.setColorSpace(colorSpace);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    assertSame(colorSpace, pdShadingType1.getColorSpace());
  }

  /**
   * Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  void testSetColorSpace3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setColorSpace(null);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#create(COSDictionary)}
   */
  @Test
  void testCreate() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDShading.create(new COSDictionary()));
  }

  /**
   * Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  void testSetFunction() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setFunction(new COSArray());

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  void testSetFunction2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setFunction((COSArray) null);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  void testSetFunction3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newFunctions = new COSArray();
    newFunctions.add(object);

    // Act
    pdShadingType1.setFunction(newFunctions);

    // Assert
    verify(object).getCOSObject();
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  void testSetFunction4() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    PDFunctionType0 newFunction = new PDFunctionType0(COSBoolean.FALSE);

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  void testSetFunction5() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    PDFunctionType0 newFunction = new PDFunctionType0(new COSDictionary());

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  void testSetFunction6() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFunctionType0 newFunction = new PDFunctionType0(new COSDocument(streamCacheCreateFunction));

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  void testSetFunction7() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setFunction((PDFunction) null);

    // Assert
    assertNull(pdShadingType1.getFunction());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  void testSetFunction8() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    PDFunctionType0 newFunction = new PDFunctionType0(new COSStream());

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  void testSetFunction9() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    COSStream function = new COSStream();
    function.setDirect(true);
    PDFunctionType0 newFunction = new PDFunctionType0(function);

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  void testSetFunction10() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    COSStream function = new COSStream();
    function.setKey(new COSObjectKey(1L, 1));
    PDFunctionType0 newFunction = new PDFunctionType0(function);

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Method under test: {@link PDShading#getFunction()}
   */
  @Test
  void testGetFunction() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getFunction());
  }

  /**
   * Method under test: {@link PDShading#evalFunction(float)}
   */
  @Test
  void testEvalFunction() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDShadingType1(new COSDictionary())).evalFunction(10.0f));
    assertThrows(IOException.class,
        () -> (new PDShadingType1(new COSDictionary())).evalFunction(new float[]{10.0f, 0.0f, 10.0f, 0.0f}));
  }
}
