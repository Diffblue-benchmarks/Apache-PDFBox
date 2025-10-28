package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTriangleBasedShadingTypeDiffblueTest {
  /**
   * Method under test: {@link PDTriangleBasedShadingType#getBitsPerComponent()}
   */
  @Test
  void testGetBitsPerComponent() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDShadingType4(new COSDictionary())).getBitsPerComponent());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}
   */
  @Test
  void testSetBitsPerComponent() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setBitsPerComponent(1);

    // Assert
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}
   */
  @Test
  void testSetBitsPerComponent2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setBitsPerComponent(Integer.MIN_VALUE);

    // Assert
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test: {@link PDTriangleBasedShadingType#getBitsPerCoordinate()}
   */
  @Test
  void testGetBitsPerCoordinate() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDShadingType4(new COSDictionary())).getBitsPerCoordinate());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}
   */
  @Test
  void testSetBitsPerCoordinate() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setBitsPerCoordinate(1);

    // Assert
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}
   */
  @Test
  void testSetBitsPerCoordinate2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setBitsPerCoordinate(Integer.MIN_VALUE);

    // Assert
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#getNumberOfColorComponents()}
   */
  @Test
  void testGetNumberOfColorComponents() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(0);
    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    int actualNumberOfColorComponents = (new PDShadingType4(shadingDictionary)).getNumberOfColorComponents();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    assertEquals(1, actualNumberOfColorComponents);
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setDecodeValues(new COSArray());

    // Assert
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setDecodeValues(null);

    // Assert
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    pdShadingType4.setDecodeValues(cosArray);

    // Assert
    verify(object).getCOSObject();
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType4(new COSDictionary())).getDecodeForParameter(10));
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter2() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    pdShadingType4.setDecodeValues(new COSArray());

    // Act and Assert
    assertNull(pdShadingType4.getDecodeForParameter(10));
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    pdShadingType4.setDecodeValues(cosArray);

    // Act
    PDRange actualDecodeForParameter = pdShadingType4.getDecodeForParameter(10);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualDecodeForParameter);
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    pdShadingType4.setDecodeValues(cosArray);

    // Act
    PDRange actualDecodeForParameter = pdShadingType4.getDecodeForParameter(0);

    // Assert
    verify(object).getCOSObject();
    assertSame(cosArray, actualDecodeForParameter.getCOSArray());
    assertSame(cosArray, actualDecodeForParameter.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  void testInterpolate() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDShadingType4(new COSDictionary())).interpolate(10.0f, 5L, 10.0f, 10.0f));
    assertEquals(10.0f, (new PDShadingType4(new COSDictionary())).interpolate(0.5f, 5L, 10.0f, 10.0f));
    assertEquals(10.0f, (new PDShadingType4(new COSDictionary())).interpolate(-0.5f, 5L, 10.0f, 10.0f));
    assertEquals(Float.NaN, (new PDShadingType4(new COSDictionary())).interpolate(Float.NaN, 5L, 10.0f, 10.0f));
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}
   */
  @Test
  void testGetBounds() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    AffineTransform affineTransform = new AffineTransform();

    // Act
    Rectangle2D actualBounds = pdShadingType4.getBounds(affineTransform, new Matrix());

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test:
   * {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}
   */
  @Test
  void testGetBounds2() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSStream());
    AffineTransform affineTransform = new AffineTransform();

    // Act
    Rectangle2D actualBounds = pdShadingType4.getBounds(affineTransform, new Matrix());

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }
}
