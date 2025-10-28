package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDRectangleDiffblueTest {
  /**
   * Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertTrue(PDRectangle.A0.contains(10.0f, 10.0f));
    assertFalse((new PDRectangle()).contains(10.0f, 10.0f));
    assertFalse(PDRectangle.A0.contains(-0.5f, 10.0f));
    assertFalse(PDRectangle.A0.contains(10.0f, -0.5f));
    assertFalse((new PDRectangle()).contains(0.0f, 10.0f));
  }

  /**
   * Method under test: {@link PDRectangle#createRetranslatedRectangle()}
   */
  @Test
  void testCreateRetranslatedRectangle() {
    // Arrange and Act
    PDRectangle actualCreateRetranslatedRectangleResult = PDRectangle.A0.createRetranslatedRectangle();

    // Assert
    COSArray cOSArray = actualCreateRetranslatedRectangleResult.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualCreateRetranslatedRectangleResult.getLowerLeftX());
    assertEquals(0.0f, actualCreateRetranslatedRectangleResult.getLowerLeftY());
    assertEquals(2383.937f, actualCreateRetranslatedRectangleResult.getUpperRightX());
    assertEquals(2383.937f, actualCreateRetranslatedRectangleResult.getWidth());
    assertEquals(3370.3938f, actualCreateRetranslatedRectangleResult.getHeight());
    assertEquals(3370.3938f, actualCreateRetranslatedRectangleResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualCreateRetranslatedRectangleResult.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#getLowerLeftX()}
   */
  @Test
  void testGetLowerLeftX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, PDRectangle.A0.getLowerLeftX());
  }

  /**
   * Method under test: {@link PDRectangle#setLowerLeftX(float)}
   */
  @Test
  void testSetLowerLeftX() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setLowerLeftX(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertEquals(-10.0f, pdRectangle.getWidth());
    assertEquals(10.0f, pdRectangle.getLowerLeftX());
  }

  /**
   * Method under test: {@link PDRectangle#getLowerLeftY()}
   */
  @Test
  void testGetLowerLeftY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, PDRectangle.A0.getLowerLeftY());
  }

  /**
   * Method under test: {@link PDRectangle#setLowerLeftY(float)}
   */
  @Test
  void testSetLowerLeftY() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setLowerLeftY(10.0f);

    // Assert
    assertEquals(-10.0f, pdRectangle.getHeight());
    assertEquals(10.0f, pdRectangle.getLowerLeftY());
  }

  /**
   * Method under test: {@link PDRectangle#getUpperRightX()}
   */
  @Test
  void testGetUpperRightX() {
    // Arrange, Act and Assert
    assertEquals(2383.937f, PDRectangle.A0.getUpperRightX());
  }

  /**
   * Method under test: {@link PDRectangle#setUpperRightX(float)}
   */
  @Test
  void testSetUpperRightX() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setUpperRightX(10.0f);

    // Assert
    assertEquals(10.0f, pdRectangle.getUpperRightX());
    assertEquals(10.0f, pdRectangle.getWidth());
  }

  /**
   * Method under test: {@link PDRectangle#getUpperRightY()}
   */
  @Test
  void testGetUpperRightY() {
    // Arrange, Act and Assert
    assertEquals(3370.3938f, PDRectangle.A0.getUpperRightY());
  }

  /**
   * Method under test: {@link PDRectangle#setUpperRightY(float)}
   */
  @Test
  void testSetUpperRightY() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setUpperRightY(10.0f);

    // Assert
    assertEquals(10.0f, pdRectangle.getHeight());
    assertEquals(10.0f, pdRectangle.getUpperRightY());
  }

  /**
   * Method under test: {@link PDRectangle#getWidth()}
   */
  @Test
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(2383.937f, PDRectangle.A0.getWidth());
  }

  /**
   * Method under test: {@link PDRectangle#getHeight()}
   */
  @Test
  void testGetHeight() {
    // Arrange, Act and Assert
    assertEquals(3370.3938f, PDRectangle.A0.getHeight());
  }

  /**
   * Method under test: {@link PDRectangle#transform(Matrix)}
   */
  @Test
  void testTransform() {
    // Arrange and Act
    GeneralPath actualTransformResult = PDRectangle.A0.transform(new Matrix());

    // Assert
    Rectangle bounds = actualTransformResult.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualTransformResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualTransformResult.getBounds2D();
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Float);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds2D2.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, bounds2D2.getMinY());
    assertEquals(0.0d, bounds2D2.getX());
    assertEquals(0.0d, bounds2D2.getY());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(0.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(0.0f, ((Rectangle2D.Float) bounds2D2).x);
    assertEquals(0.0f, ((Rectangle2D.Float) bounds2D2).y);
    assertEquals(1, actualTransformResult.getWindingRule());
    assertEquals(1191.968505859375d, bounds2D2.getCenterX());
    assertEquals(1192.0d, bounds.getCenterX());
    assertEquals(1685.1968994140625d, bounds2D2.getCenterY());
    assertEquals(1685.5d, bounds.getCenterY());
    assertEquals(2383.93701171875d, bounds2D2.getMaxX());
    assertEquals(2383.93701171875d, bounds2D2.getWidth());
    assertEquals(2383.937f, ((Rectangle2D.Float) bounds2D2).width);
    Dimension size = bounds.getSize();
    assertEquals(2384, size.width);
    assertEquals(2384, bounds.width);
    assertEquals(2384.0d, size.getWidth());
    assertEquals(2384.0d, bounds.getWidth());
    assertEquals(2384.0d, bounds.getMaxX());
    assertEquals(3370.393798828125d, bounds2D2.getHeight());
    assertEquals(3370.393798828125d, bounds2D2.getMaxY());
    assertEquals(3370.3938f, ((Rectangle2D.Float) bounds2D2).height);
    assertEquals(3371, size.height);
    assertEquals(3371, bounds.height);
    assertEquals(3371.0d, size.getHeight());
    assertEquals(3371.0d, bounds.getHeight());
    assertEquals(3371.0d, bounds.getMaxY());
    assertFalse(bounds.isEmpty());
    assertFalse(bounds2D2.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(currentPoint, bounds.getLocation());
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
  }

  /**
   * Method under test: {@link PDRectangle#toGeneralPath()}
   */
  @Test
  void testToGeneralPath() {
    // Arrange and Act
    GeneralPath actualToGeneralPathResult = PDRectangle.A0.toGeneralPath();

    // Assert
    Rectangle bounds = actualToGeneralPathResult.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualToGeneralPathResult.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualToGeneralPathResult.getBounds2D();
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Float);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds2D2.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, bounds2D2.getMinY());
    assertEquals(0.0d, bounds2D2.getX());
    assertEquals(0.0d, bounds2D2.getY());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(0.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(0.0f, ((Rectangle2D.Float) bounds2D2).x);
    assertEquals(0.0f, ((Rectangle2D.Float) bounds2D2).y);
    assertEquals(1, actualToGeneralPathResult.getWindingRule());
    assertEquals(1191.968505859375d, bounds2D2.getCenterX());
    assertEquals(1192.0d, bounds.getCenterX());
    assertEquals(1685.1968994140625d, bounds2D2.getCenterY());
    assertEquals(1685.5d, bounds.getCenterY());
    assertEquals(2383.93701171875d, bounds2D2.getMaxX());
    assertEquals(2383.93701171875d, bounds2D2.getWidth());
    assertEquals(2383.937f, ((Rectangle2D.Float) bounds2D2).width);
    Dimension size = bounds.getSize();
    assertEquals(2384, size.width);
    assertEquals(2384, bounds.width);
    assertEquals(2384.0d, size.getWidth());
    assertEquals(2384.0d, bounds.getWidth());
    assertEquals(2384.0d, bounds.getMaxX());
    assertEquals(3370.393798828125d, bounds2D2.getHeight());
    assertEquals(3370.393798828125d, bounds2D2.getMaxY());
    assertEquals(3370.3938f, ((Rectangle2D.Float) bounds2D2).height);
    assertEquals(3371, size.height);
    assertEquals(3371, bounds.height);
    assertEquals(3371.0d, size.getHeight());
    assertEquals(3371.0d, bounds.getHeight());
    assertEquals(3371.0d, bounds.getMaxY());
    assertFalse(bounds.isEmpty());
    assertFalse(bounds2D2.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(currentPoint, bounds.getLocation());
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDRectangle#toString()}
   *   <li>{@link PDRectangle#getCOSArray()}
   *   <li>{@link PDRectangle#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    String actualToStringResult = pdRectangle.toString();
    COSArray actualCOSArray = pdRectangle.getCOSArray();
    COSBase actualCOSObject = pdRectangle.getCOSObject();

    // Assert
    List<? extends COSBase> toListResult = actualCOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertEquals("[0.0,0.0,0.0,0.0]", actualToStringResult);
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(actualCOSArray, actualCOSObject);
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle()}
   */
  @Test
  void testNewPDRectangle() {
    // Arrange and Act
    PDRectangle actualPdRectangle = new PDRectangle();

    // Assert
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(float, float)}
   */
  @Test
  void testNewPDRectangle2() {
    // Arrange and Act
    PDRectangle actualPdRectangle = new PDRectangle(10.0f, 10.0f);

    // Assert
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(10.0f, actualPdRectangle.getHeight());
    assertEquals(10.0f, actualPdRectangle.getUpperRightX());
    assertEquals(10.0f, actualPdRectangle.getUpperRightY());
    assertEquals(10.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult3, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDRectangle#PDRectangle(float, float, float, float)}
   */
  @Test
  void testNewPDRectangle3() {
    // Arrange and Act
    PDRectangle actualPdRectangle = new PDRectangle(10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertEquals(10.0f, actualPdRectangle.getHeight());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(10.0f, actualPdRectangle.getWidth());
    assertEquals(20.0f, actualPdRectangle.getUpperRightX());
    assertEquals(20.0f, actualPdRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult3, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(BoundingBox)}
   */
  @Test
  void testNewPDRectangle4() {
    // Arrange and Act
    PDRectangle actualPdRectangle = new PDRectangle(new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f));

    // Assert
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(10.0f, actualPdRectangle.getUpperRightX());
    assertEquals(10.0f, actualPdRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  void testNewPDRectangle5() {
    // Arrange and Act
    PDRectangle actualPdRectangle = new PDRectangle(new COSArray());

    // Assert
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  void testNewPDRectangle6() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(array);

    // Assert
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  void testNewPDRectangle7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(array);

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  void testNewPDRectangle8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSFloat.ONE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(array);

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(1.0f, actualPdRectangle.getUpperRightX());
    assertEquals(1.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  void testNewPDRectangle9() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(array);

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(1.0f, actualPdRectangle.getUpperRightX());
    assertEquals(1.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  void testNewPDRectangle10() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(array);

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = actualPdRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }
}
