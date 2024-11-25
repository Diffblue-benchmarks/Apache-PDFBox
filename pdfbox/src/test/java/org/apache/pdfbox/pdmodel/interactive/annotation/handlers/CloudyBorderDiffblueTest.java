package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CloudyBorderDiffblueTest {
  /**
   * Test
   * {@link CloudyBorder#CloudyBorder(PDAppearanceContentStream, double, double, PDRectangle)}.
   * <p>
   * Method under test:
   * {@link CloudyBorder#CloudyBorder(PDAppearanceContentStream, double, double, PDRectangle)}
   */
  @Test
  @DisplayName("Test new CloudyBorder(PDAppearanceContentStream, double, double, PDRectangle)")
  void testNewCloudyBorder() throws IOException {
    // Arrange and Act
    CloudyBorder actualCloudyBorder = new CloudyBorder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())), 10.0d, 10.0d, PDRectangle.A0);

    // Assert
    PDRectangle bBox = actualCloudyBorder.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
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
    PDRectangle rectDifference = actualCloudyBorder.getRectDifference();
    COSArray cOSArray2 = rectDifference.getCOSArray();
    List<? extends COSBase> toListResult2 = cOSArray2.toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult5 = toListResult2.get(0);
    assertTrue(getResult5 instanceof COSFloat);
    COSBase getResult6 = toListResult2.get(1);
    assertTrue(getResult6 instanceof COSFloat);
    COSBase getResult7 = toListResult2.get(2);
    assertTrue(getResult7 instanceof COSFloat);
    COSBase getResult8 = toListResult2.get(3);
    assertTrue(getResult8 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult7.getKey());
    assertNull(getResult8.getKey());
    AffineTransform matrix = actualCloudyBorder.getMatrix();
    assertEquals(-0.0d, matrix.getTranslateX());
    assertEquals(-0.0d, matrix.getTranslateY());
    assertEquals(-2383.937f, rectDifference.getUpperRightX());
    assertEquals(-2383.937f, rectDifference.getWidth());
    assertEquals(-3370.3938f, rectDifference.getHeight());
    assertEquals(-3370.3938f, rectDifference.getUpperRightY());
    assertEquals(0, matrix.getType());
    assertEquals(0.0d, matrix.getShearX());
    assertEquals(0.0d, matrix.getShearY());
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle rectangle = actualCloudyBorder.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, rectDifference.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, rectDifference.getLowerLeftY());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, rectangle.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, rectangle.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, rectangle.getWidth());
    assertEquals(1.0d, matrix.getDeterminant());
    assertEquals(1.0d, matrix.getScaleX());
    assertEquals(1.0d, matrix.getScaleY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult7.isDirect());
    assertFalse(getResult8.isDirect());
    assertTrue(matrix.isIdentity());
    COSArray cOSArray3 = rectangle.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertEquals(getResult, getResult5);
    assertEquals(getResult, getResult6);
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, rectDifference.getCOSObject());
    assertSame(cOSArray3, rectangle.getCOSObject());
  }

  /**
   * Test {@link CloudyBorder#createCloudyRectangle(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyRectangle(PDRectangle)")
  void testCreateCloudyRectangle() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    List<? extends COSBase> toListResult = bBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult2 = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult2 = toListResult2.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult2.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult2.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertEquals(-51.29814f, bBox.getLowerLeftX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-51.29814f, rectangle.getLowerLeftX());
    assertEquals(-56.29814f, bBox.getLowerLeftY());
    assertEquals(-56.29814f, rectangle.getLowerLeftY());
    assertEquals(112.59628f, bBox.getWidth());
    assertEquals(112.59628f, rectangle.getWidth());
    assertEquals(117.59628f, bBox.getHeight());
    assertEquals(117.59628f, rectangle.getHeight());
    assertEquals(5.0f, rectDifference.getWidth());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(51.29814266362127d, matrix.getTranslateX());
    assertEquals(56.29814266362127d, matrix.getTranslateY());
    assertEquals(56.29814f, rectDifference.getLowerLeftX());
    assertEquals(61.29814f, rectDifference.getLowerLeftY());
    assertEquals(61.29814f, bBox.getUpperRightX());
    assertEquals(61.29814f, rectDifference.getUpperRightX());
    assertEquals(61.29814f, rectangle.getUpperRightX());
    assertEquals(61.29814f, bBox.getUpperRightY());
    assertEquals(61.29814f, rectDifference.getUpperRightY());
    assertEquals(61.29814f, rectangle.getUpperRightY());
    COSBase getResult5 = toListResult.get(2);
    assertEquals(getResult5, getResult);
    assertEquals(getResult5, getResult2);
    assertEquals(getResult5, getResult3);
    assertEquals(getResult5, getResult4);
  }

  /**
   * Test {@link CloudyBorder#createCloudyRectangle(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyRectangle(PDRectangle)")
  void testCreateCloudyRectangle2() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        -5.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    List<? extends COSBase> toListResult = bBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult2 = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult2.get(1);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult2.get(2);
    assertTrue(getResult4 instanceof COSFloat);
    COSBase getResult5 = toListResult2.get(3);
    assertTrue(getResult5 instanceof COSFloat);
    assertEquals(5.0f, bBox.getHeight());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(5.0f, rectangle.getHeight());
    assertEquals(5.0f, bBox.getUpperRightX());
    assertEquals(5.0f, rectDifference.getUpperRightX());
    assertEquals(5.0f, rectangle.getUpperRightX());
    assertEquals(5.0f, bBox.getUpperRightY());
    assertEquals(5.0f, rectDifference.getUpperRightY());
    assertEquals(5.0f, rectangle.getUpperRightY());
    assertEquals(5.0f, bBox.getWidth());
    assertEquals(5.0f, rectangle.getWidth());
    COSBase getResult6 = toListResult.get(2);
    assertEquals(getResult6, getResult);
    assertEquals(getResult6, getResult2);
    assertEquals(getResult6, getResult3);
    assertEquals(getResult6, getResult4);
    assertEquals(getResult6, getResult5);
  }

  /**
   * Test {@link CloudyBorder#createCloudyRectangle(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyRectangle(PDRectangle)")
  void testCreateCloudyRectangle3() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, -5.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(0.0f, rectDifference.getLowerLeftX());
    assertEquals(0.0f, rectDifference.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, rectDifference.getUpperRightX());
    assertEquals(0.0f, rectangle.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, rectDifference.getUpperRightY());
    assertEquals(0.0f, rectangle.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, rectangle.getWidth());
  }

  /**
   * Test {@link CloudyBorder#createCloudyRectangle(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyRectangle(PDRectangle)")
  void testCreateCloudyRectangle4() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A1);

    // Act
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Assert
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-1040.6406f, bBox.getLowerLeftY());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-1040.6406f, rectangle.getLowerLeftY());
    assertEquals(-49.183834f, bBox.getLowerLeftX());
    assertEquals(-49.183834f, rectangle.getLowerLeftX());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(1040.6406196678627d, matrix.getTranslateY());
    assertEquals(1045.6406f, rectDifference.getLowerLeftY());
    assertEquals(1045.6406f, rectDifference.getUpperRightY());
    assertEquals(108.36767f, bBox.getWidth());
    assertEquals(108.36767f, rectangle.getWidth());
    assertEquals(1099.8245f, bBox.getHeight());
    assertEquals(1099.8245f, rectangle.getHeight());
    assertEquals(49.18383255848771d, matrix.getTranslateX());
    assertEquals(54.183834f, rectDifference.getLowerLeftX());
    assertEquals(59.183834f, bBox.getUpperRightX());
    assertEquals(59.183834f, rectangle.getUpperRightX());
    assertEquals(59.183838f, bBox.getUpperRightY());
    assertEquals(59.183838f, rectangle.getUpperRightY());
    assertEquals(705.1575f, rectDifference.getWidth());
    assertEquals(759.3413f, rectDifference.getUpperRightX());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link CloudyBorder#createCloudyRectangle(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyRectangle(PDRectangle)")
  void testCreateCloudyRectangle5() throws IOException {
    // Arrange
    PDAppearanceContentStream stream = new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    CloudyBorder cloudyBorder = new CloudyBorder(stream, 1.7014118346046923E38d, 10.0d,
        new PDRectangle(9.223372E18f, 9.223372E18f));

    // Act
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    List<? extends COSBase> toListResult = bBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult2 = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult2 = toListResult2.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult2.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(-9.223372E18f, rectDifference.getUpperRightX());
    assertEquals(-9.223372E18f, rectDifference.getUpperRightY());
    assertEquals(-9.223372E18f, rectDifference.getWidth());
    assertEquals(10.0f, bBox.getHeight());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(10.0f, rectangle.getHeight());
    assertEquals(10.0f, bBox.getUpperRightX());
    assertEquals(10.0f, rectangle.getUpperRightX());
    assertEquals(10.0f, bBox.getUpperRightY());
    assertEquals(10.0f, rectangle.getUpperRightY());
    assertEquals(10.0f, bBox.getWidth());
    assertEquals(10.0f, rectangle.getWidth());
    assertEquals(toListResult.get(2), getResult);
    assertEquals(toListResult2.get(0), getResult2);
    assertEquals(toListResult2.get(2), getResult3);
  }

  /**
   * Test {@link CloudyBorder#createCloudyPolygon(float[][])}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyPolygon(float[][])}
   */
  @Test
  @DisplayName("Test createCloudyPolygon(float[][])")
  void testCreateCloudyPolygon() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyPolygon(new float[][]{});

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    List<? extends COSBase> toListResult = bBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult2 = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult2.get(1);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(-2378.937f, rectDifference.getUpperRightX());
    assertEquals(-3365.3938f, rectDifference.getUpperRightY());
    assertEquals(-5.0f, bBox.getLowerLeftX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-5.0f, rectangle.getLowerLeftX());
    assertEquals(-5.0f, bBox.getLowerLeftY());
    assertEquals(-5.0f, rectangle.getLowerLeftY());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(1, matrix.getType());
    assertEquals(10.0f, bBox.getHeight());
    assertEquals(10.0f, rectangle.getHeight());
    assertEquals(10.0f, bBox.getWidth());
    assertEquals(10.0f, rectangle.getWidth());
    assertEquals(5.0d, matrix.getTranslateX());
    assertEquals(5.0d, matrix.getTranslateY());
    assertEquals(5.0f, rectDifference.getLowerLeftX());
    assertEquals(5.0f, rectDifference.getLowerLeftY());
    assertEquals(5.0f, bBox.getUpperRightX());
    assertEquals(5.0f, rectangle.getUpperRightX());
    assertEquals(5.0f, bBox.getUpperRightY());
    assertEquals(5.0f, rectangle.getUpperRightY());
    assertFalse(matrix.isIdentity());
    COSBase getResult4 = toListResult.get(2);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test {@link CloudyBorder#createCloudyPolygon(float[][])}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyPolygon(float[][])}
   */
  @Test
  @DisplayName("Test createCloudyPolygon(float[][])")
  void testCreateCloudyPolygon2() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 0.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyPolygon(new float[][]{});

    // Assert that nothing has changed
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(-0.0d, matrix.getTranslateX());
    assertEquals(-0.0d, matrix.getTranslateY());
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(-2383.937f, rectDifference.getUpperRightX());
    assertEquals(-3370.3938f, rectDifference.getUpperRightY());
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, rectDifference.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, rectDifference.getLowerLeftY());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, rectangle.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, rectangle.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, rectangle.getWidth());
  }

  /**
   * Test {@link CloudyBorder#createCloudyPolygon(float[][])}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyPolygon(float[][])}
   */
  @Test
  @DisplayName("Test createCloudyPolygon(float[][])")
  void testCreateCloudyPolygon3() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyPolygon(new float[][]{});

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-56.29814f, bBox.getLowerLeftX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-56.29814f, rectangle.getLowerLeftX());
    assertEquals(-61.29814f, bBox.getLowerLeftY());
    assertEquals(-61.29814f, rectangle.getLowerLeftY());
    assertEquals(122.59628f, bBox.getWidth());
    assertEquals(122.59628f, rectangle.getWidth());
    assertEquals(127.59628f, bBox.getHeight());
    assertEquals(127.59628f, rectangle.getHeight());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(56.29814266362127d, matrix.getTranslateX());
    assertEquals(61.29814266362127d, matrix.getTranslateY());
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(61.29814f, rectDifference.getLowerLeftX());
    assertEquals(66.29814f, rectDifference.getLowerLeftY());
    assertEquals(66.29814f, bBox.getUpperRightX());
    assertEquals(66.29814f, rectDifference.getUpperRightX());
    assertEquals(66.29814f, rectangle.getUpperRightX());
    assertEquals(66.29814f, bBox.getUpperRightY());
    assertEquals(66.29814f, rectDifference.getUpperRightY());
    assertEquals(66.29814f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A0);

    // Assert
    List<? extends COSBase> toListResult = cloudyBorder.getBBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    List<? extends COSBase> toListResult2 = cloudyBorder.getRectDifference().getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult2.get(1);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult2.get(2);
    assertTrue(getResult4 instanceof COSFloat);
    COSBase getResult5 = toListResult2.get(3);
    assertTrue(getResult5 instanceof COSFloat);
    COSBase getResult6 = toListResult.get(2);
    assertEquals(getResult6, getResult);
    assertEquals(getResult6, getResult2);
    assertEquals(getResult6, getResult3);
    assertEquals(getResult6, getResult4);
    assertEquals(getResult6, getResult5);
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse2() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        0.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A0);

    // Assert
    List<? extends COSBase> toListResult = cloudyBorder.getBBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = cloudyBorder.getRectDifference().getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult3 = toListResult2.get(0);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult2.get(1);
    assertTrue(getResult4 instanceof COSFloat);
    COSBase getResult5 = toListResult2.get(2);
    assertTrue(getResult5 instanceof COSFloat);
    COSBase getResult6 = toListResult2.get(3);
    assertTrue(getResult6 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    COSBase getResult7 = toListResult.get(2);
    assertEquals(getResult7, getResult2);
    assertEquals(getResult7, getResult3);
    assertEquals(getResult7, getResult4);
    assertEquals(getResult7, getResult5);
    assertEquals(getResult7, getResult6);
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse3() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        Double.NaN, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A0);

    // Assert
    List<? extends COSBase> toListResult = cloudyBorder.getBBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = cloudyBorder.getRectDifference().getCOSArray().toList();
    assertEquals(4, toListResult2.size());
    COSBase getResult3 = toListResult2.get(0);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult2.get(1);
    assertTrue(getResult4 instanceof COSFloat);
    COSBase getResult5 = toListResult2.get(2);
    assertTrue(getResult5 instanceof COSFloat);
    COSBase getResult6 = toListResult2.get(3);
    assertTrue(getResult6 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    COSBase getResult7 = toListResult.get(2);
    assertEquals(getResult7, getResult2);
    assertEquals(getResult7, getResult3);
    assertEquals(getResult7, getResult4);
    assertEquals(getResult7, getResult5);
    assertEquals(getResult7, getResult6);
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse4() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 0.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A0);

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(0.0f, rectDifference.getUpperRightX());
    assertEquals(0.0f, rectDifference.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, rectangle.getWidth());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse5() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A1);

    // Assert
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-49.057095f, bBox.getLowerLeftY());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-49.057095f, rectangle.getLowerLeftY());
    assertEquals(-51.716675f, bBox.getLowerLeftX());
    assertEquals(-51.716675f, rectangle.getLowerLeftX());
    assertEquals(1035.5138f, bBox.getUpperRightY());
    assertEquals(1035.5138f, rectangle.getUpperRightY());
    assertEquals(1084.5709f, bBox.getHeight());
    assertEquals(1084.5709f, rectangle.getHeight());
    assertEquals(3.4332275E-5f, rectDifference.getHeight());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(49.057093646708225d, matrix.getTranslateY());
    assertEquals(49.057095f, rectDifference.getLowerLeftY());
    assertEquals(49.05713f, rectDifference.getUpperRightY());
    assertEquals(51.716673776002644d, matrix.getTranslateX());
    assertEquals(51.716675f, rectDifference.getLowerLeftX());
    assertEquals(51.716675f, rectDifference.getUpperRightX());
    assertEquals(751.87415f, bBox.getUpperRightX());
    assertEquals(751.87415f, rectangle.getUpperRightX());
    assertEquals(803.5908f, bBox.getWidth());
    assertEquals(803.5908f, rectangle.getWidth());
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse6() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A2);

    // Assert
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(-0.04732895f, rectDifference.getWidth());
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-50.43016f, bBox.getLowerLeftY());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-50.43016f, rectangle.getLowerLeftY());
    assertEquals(-51.939175f, bBox.getLowerLeftX());
    assertEquals(-51.939175f, rectangle.getLowerLeftX());
    assertEquals(0.10462952f, rectDifference.getHeight());
    assertEquals(1245.2776f, bBox.getUpperRightX());
    assertEquals(1245.2776f, rectangle.getUpperRightX());
    assertEquals(1297.2168f, bBox.getWidth());
    assertEquals(1297.2168f, rectangle.getWidth());
    assertEquals(1737.149f, bBox.getUpperRightY());
    assertEquals(1737.149f, rectangle.getUpperRightY());
    assertEquals(1787.5792f, bBox.getHeight());
    assertEquals(1787.5792f, rectangle.getHeight());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(50.43015933122177d, matrix.getTranslateY());
    assertEquals(50.43016f, rectDifference.getLowerLeftY());
    assertEquals(50.53479f, rectDifference.getUpperRightY());
    assertEquals(51.891846f, rectDifference.getUpperRightX());
    assertEquals(51.93917457070154d, matrix.getTranslateX());
    assertEquals(51.939175f, rectDifference.getLowerLeftX());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse7() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(null);

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-51.913403f, bBox.getLowerLeftY());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-51.913403f, rectangle.getLowerLeftY());
    assertEquals(-52.585213f, bBox.getLowerLeftX());
    assertEquals(-52.585213f, rectangle.getLowerLeftX());
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(-7.247925E-5f, rectDifference.getHeight());
    assertEquals(-7.6293945E-6f, rectDifference.getWidth());
    assertEquals(2436.5222f, bBox.getUpperRightX());
    assertEquals(2436.5222f, rectangle.getUpperRightX());
    assertEquals(2489.1074f, bBox.getWidth());
    assertEquals(2489.1074f, rectangle.getWidth());
    assertEquals(3422.3074f, bBox.getUpperRightY());
    assertEquals(3422.3074f, rectangle.getUpperRightY());
    assertEquals(3474.2207f, bBox.getHeight());
    assertEquals(3474.2207f, rectangle.getHeight());
    assertEquals(51.91333f, rectDifference.getUpperRightY());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(51.913401507339174d, matrix.getTranslateY());
    assertEquals(51.913403f, rectDifference.getLowerLeftY());
    assertEquals(52.585205f, rectDifference.getUpperRightX());
    assertEquals(52.585213372216444d, matrix.getTranslateX());
    assertEquals(52.585213f, rectDifference.getLowerLeftX());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse8() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(new PDRectangle(9.223372E18f, 9.223372E18f));

    // Assert
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-9.223372E18f, bBox.getLowerLeftX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-9.223372E18f, rectangle.getLowerLeftX());
    assertEquals(-9.223372E18f, bBox.getLowerLeftY());
    assertEquals(-9.223372E18f, rectangle.getLowerLeftY());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(9.223372036854776E18d, matrix.getTranslateX());
    assertEquals(9.223372036854776E18d, matrix.getTranslateY());
    assertEquals(9.223372E18f, bBox.getHeight());
    assertEquals(9.223372E18f, rectangle.getHeight());
    assertEquals(9.223372E18f, rectDifference.getLowerLeftX());
    assertEquals(9.223372E18f, rectDifference.getLowerLeftY());
    assertEquals(9.223372E18f, rectDifference.getUpperRightX());
    assertEquals(9.223372E18f, bBox.getWidth());
    assertEquals(9.223372E18f, rectangle.getWidth());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse9() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 0.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A1);

    // Assert
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(-1.9073486E-5f, rectDifference.getWidth());
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-39.334812f, bBox.getLowerLeftY());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-39.334812f, rectangle.getLowerLeftY());
    assertEquals(-41.4186f, bBox.getLowerLeftX());
    assertEquals(-41.4186f, rectangle.getLowerLeftX());
    assertEquals(1025.7916f, bBox.getUpperRightY());
    assertEquals(1025.7916f, rectangle.getUpperRightY());
    assertEquals(1065.1265f, bBox.getHeight());
    assertEquals(1065.1265f, rectangle.getHeight());
    assertEquals(2.670288E-5f, rectDifference.getHeight());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(39.334811228227906d, matrix.getTranslateY());
    assertEquals(39.334812f, rectDifference.getLowerLeftY());
    assertEquals(39.33484f, rectDifference.getUpperRightY());
    assertEquals(41.41858f, rectDifference.getUpperRightX());
    assertEquals(41.41859826550544d, matrix.getTranslateX());
    assertEquals(41.4186f, rectDifference.getLowerLeftX());
    assertEquals(741.5761f, bBox.getUpperRightX());
    assertEquals(741.5761f, rectangle.getUpperRightX());
    assertEquals(782.9947f, bBox.getWidth());
    assertEquals(782.9947f, rectangle.getWidth());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse10() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A0);

    // Assert
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-56.29814f, bBox.getLowerLeftX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-56.29814f, rectangle.getLowerLeftX());
    assertEquals(-61.29814f, bBox.getLowerLeftY());
    assertEquals(-61.29814f, rectangle.getLowerLeftY());
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(10.0f, rectDifference.getWidth());
    assertEquals(122.59628f, bBox.getWidth());
    assertEquals(122.59628f, rectangle.getWidth());
    assertEquals(127.59628f, bBox.getHeight());
    assertEquals(127.59628f, rectangle.getHeight());
    assertEquals(5.0f, rectDifference.getHeight());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(56.29814266362127d, matrix.getTranslateX());
    assertEquals(61.29814266362127d, matrix.getTranslateY());
    assertEquals(66.29814f, bBox.getUpperRightX());
    assertEquals(66.29814f, rectDifference.getUpperRightX());
    assertEquals(66.29814f, rectangle.getUpperRightX());
    assertEquals(66.29814f, bBox.getUpperRightY());
    assertEquals(66.29814f, rectDifference.getUpperRightY());
    assertEquals(66.29814f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse11() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        0.5d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A1);

    // Assert
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    assertEquals(-0.030656815f, rectDifference.getWidth());
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-12.912676f, bBox.getLowerLeftX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-12.912676f, rectangle.getLowerLeftX());
    assertEquals(-12.929376f, bBox.getLowerLeftY());
    assertEquals(-12.929376f, rectangle.getLowerLeftY());
    assertEquals(1012.31555f, bBox.getHeight());
    assertEquals(1012.31555f, rectangle.getHeight());
    assertEquals(12.882019f, rectDifference.getUpperRightX());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(12.912675397425996d, matrix.getTranslateX());
    assertEquals(12.912676f, rectDifference.getLowerLeftX());
    assertEquals(12.929375987255222d, matrix.getTranslateY());
    assertEquals(12.929376f, rectDifference.getLowerLeftY());
    assertEquals(12.929382f, rectDifference.getUpperRightY());
    assertEquals(6.67572E-6f, rectDifference.getHeight());
    assertEquals(713.0395f, bBox.getUpperRightX());
    assertEquals(713.0395f, rectangle.getUpperRightX());
    assertEquals(725.95215f, bBox.getWidth());
    assertEquals(725.95215f, rectangle.getWidth());
    assertEquals(999.38617f, bBox.getUpperRightY());
    assertEquals(999.38617f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse12() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(new PDRectangle(-9.223372E18f, 9.223372E18f));

    // Assert
    PDRectangle rectDifference = cloudyBorder.getRectDifference();
    List<? extends COSBase> toListResult = rectDifference.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertEquals(-3.4332275E-5f, rectDifference.getWidth());
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(-62.381138f, bBox.getLowerLeftX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(-62.381138f, rectangle.getLowerLeftX());
    assertEquals(-62.381138f, bBox.getLowerLeftY());
    assertEquals(-62.381138f, rectangle.getLowerLeftY());
    assertEquals(124.762276f, bBox.getHeight());
    assertEquals(124.762276f, rectangle.getHeight());
    assertEquals(2446.318f, bBox.getUpperRightX());
    assertEquals(2446.318f, rectangle.getUpperRightX());
    assertEquals(2508.6992f, bBox.getWidth());
    assertEquals(2508.6992f, rectangle.getWidth());
    assertEquals(62.381104f, rectDifference.getUpperRightX());
    AffineTransform matrix = cloudyBorder.getMatrix();
    assertEquals(62.38113798490231d, matrix.getTranslateX());
    assertEquals(62.381137984902345d, matrix.getTranslateY());
    assertEquals(62.381138f, rectDifference.getLowerLeftX());
    assertEquals(62.381138f, rectDifference.getLowerLeftY());
    assertEquals(62.381138f, bBox.getUpperRightY());
    assertEquals(62.381138f, rectangle.getUpperRightY());
    assertEquals(9.223372E18f, rectDifference.getHeight());
  }

  /**
   * Test {@link CloudyBorder#createCloudyEllipse(PDRectangle)}.
   * <p>
   * Method under test: {@link CloudyBorder#createCloudyEllipse(PDRectangle)}
   */
  @Test
  @DisplayName("Test createCloudyEllipse(PDRectangle)")
  void testCreateCloudyEllipse13() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        0.5d, 0.0d, PDRectangle.A0);

    // Act
    cloudyBorder.createCloudyEllipse(PDRectangle.A1);

    // Assert
    List<? extends COSBase> toListResult = cloudyBorder.getRectDifference().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    PDRectangle bBox = cloudyBorder.getBBox();
    assertEquals(700.1575f, bBox.getUpperRightX());
    PDRectangle rectangle = cloudyBorder.getRectangle();
    assertEquals(700.1575f, rectangle.getUpperRightX());
    assertEquals(700.1575f, bBox.getWidth());
    assertEquals(700.1575f, rectangle.getWidth());
    assertEquals(986.4568f, bBox.getHeight());
    assertEquals(986.4568f, rectangle.getHeight());
    assertEquals(986.4568f, bBox.getUpperRightY());
    assertEquals(986.4568f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link CloudyBorder#getBBox()}.
   * <p>
   * Method under test: {@link CloudyBorder#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox()")
  void testGetBBox() throws IOException {
    // Arrange and Act
    PDRectangle actualBBox = (new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0)).getBBox();

    // Assert
    COSArray cOSArray = actualBBox.getCOSArray();
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
    assertEquals(0.0f, actualBBox.getHeight());
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(0.0f, actualBBox.getUpperRightX());
    assertEquals(0.0f, actualBBox.getUpperRightY());
    assertEquals(0.0f, actualBBox.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualBBox.getCOSObject());
  }

  /**
   * Test {@link CloudyBorder#getRectangle()}.
   * <p>
   * Method under test: {@link CloudyBorder#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle()")
  void testGetRectangle() throws IOException {
    // Arrange and Act
    PDRectangle actualRectangle = (new CloudyBorder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())), 10.0d, 10.0d, PDRectangle.A0))
        .getRectangle();

    // Assert
    COSArray cOSArray = actualRectangle.getCOSArray();
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
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(0.0f, actualRectangle.getUpperRightX());
    assertEquals(0.0f, actualRectangle.getUpperRightY());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualRectangle.getCOSObject());
  }

  /**
   * Test {@link CloudyBorder#getMatrix()}.
   * <p>
   * Method under test: {@link CloudyBorder#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  void testGetMatrix() throws IOException {
    // Arrange and Act
    AffineTransform actualMatrix = (new CloudyBorder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())), 10.0d, 10.0d, PDRectangle.A0))
        .getMatrix();

    // Assert
    assertEquals(-0.0d, actualMatrix.getTranslateX());
    assertEquals(-0.0d, actualMatrix.getTranslateY());
    assertEquals(0, actualMatrix.getType());
    assertEquals(0.0d, actualMatrix.getShearX());
    assertEquals(0.0d, actualMatrix.getShearY());
    assertEquals(1.0d, actualMatrix.getDeterminant());
    assertEquals(1.0d, actualMatrix.getScaleX());
    assertEquals(1.0d, actualMatrix.getScaleY());
    assertTrue(actualMatrix.isIdentity());
  }

  /**
   * Test {@link CloudyBorder#getRectDifference()}.
   * <ul>
   *   <li>Then COSArray toList third return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CloudyBorder#getRectDifference()}
   */
  @Test
  @DisplayName("Test getRectDifference(); then COSArray toList third return COSFloat")
  void testGetRectDifference_thenCOSArrayToListThirdReturnCOSFloat() throws IOException {
    // Arrange
    CloudyBorder cloudyBorder = new CloudyBorder(new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
        10.0d, 10.0d, PDRectangle.A0);
    cloudyBorder.createCloudyRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectDifference = cloudyBorder.getRectDifference();

    // Assert
    List<? extends COSBase> toListResult = actualRectDifference.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualRectDifference.getHeight());
    assertEquals(5.0f, actualRectDifference.getWidth());
    assertEquals(56.29814f, actualRectDifference.getLowerLeftX());
    assertEquals(61.29814f, actualRectDifference.getLowerLeftY());
    assertEquals(61.29814f, actualRectDifference.getUpperRightX());
    assertEquals(61.29814f, actualRectDifference.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
  }

  /**
   * Test {@link CloudyBorder#getRectDifference()}.
   * <ul>
   *   <li>Then return COSArray toList fourth Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CloudyBorder#getRectDifference()}
   */
  @Test
  @DisplayName("Test getRectDifference(); then return COSArray toList fourth Key is 'null'")
  void testGetRectDifference_thenReturnCOSArrayToListFourthKeyIsNull() throws IOException {
    // Arrange and Act
    PDRectangle actualRectDifference = (new CloudyBorder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())), 10.0d, 10.0d, PDRectangle.A0))
        .getRectDifference();

    // Assert
    List<? extends COSBase> toListResult = actualRectDifference.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult2.getKey());
    assertEquals(-2383.937f, actualRectDifference.getUpperRightX());
    assertEquals(-2383.937f, actualRectDifference.getWidth());
    assertEquals(-3370.3938f, actualRectDifference.getHeight());
    assertEquals(-3370.3938f, actualRectDifference.getUpperRightY());
    assertEquals(0.0f, actualRectDifference.getLowerLeftX());
    assertEquals(0.0f, actualRectDifference.getLowerLeftY());
    assertFalse(getResult2.isDirect());
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link CloudyBorder#getRectDifference()}.
   * <ul>
   *   <li>Then return Height is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link CloudyBorder#getRectDifference()}
   */
  @Test
  @DisplayName("Test getRectDifference(); then return Height is ten")
  void testGetRectDifference_thenReturnHeightIsTen() throws IOException {
    // Arrange and Act
    PDRectangle actualRectDifference = (new CloudyBorder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())), 10.0d, 10.0d, null))
        .getRectDifference();

    // Assert
    COSArray cOSArray = actualRectDifference.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(10.0f, actualRectDifference.getHeight());
    assertEquals(10.0f, actualRectDifference.getWidth());
    assertEquals(15.0f, actualRectDifference.getUpperRightX());
    assertEquals(15.0f, actualRectDifference.getUpperRightY());
    assertEquals(5.0f, actualRectDifference.getLowerLeftX());
    assertEquals(5.0f, actualRectDifference.getLowerLeftY());
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(2), getResult2);
    assertSame(cOSArray, actualRectDifference.getCOSObject());
  }
}
