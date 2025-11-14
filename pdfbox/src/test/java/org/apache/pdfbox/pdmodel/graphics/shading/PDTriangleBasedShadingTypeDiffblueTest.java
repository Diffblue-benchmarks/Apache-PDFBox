package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTriangleBasedShadingTypeDiffblueTest {
  /**
   * Test {@link PDTriangleBasedShadingType#getBitsPerComponent()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getBitsPerComponent()}
   */
  @Test
  @DisplayName(
      "Test getBitsPerComponent(); given PDShadingType4(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getBitsPerComponent()"})
  void testGetBitsPerComponent_givenPDShadingType4WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDShadingType4(new COSDictionary()).getBitsPerComponent());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBitsPerComponent()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getBitsPerComponent()}
   */
  @Test
  @DisplayName(
      "Test getBitsPerComponent(); given PDShadingType4(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getBitsPerComponent()"})
  void testGetBitsPerComponent_givenPDShadingType4WithShadingDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDShadingType4(new COSStream()).getBitsPerComponent());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}.
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerComponent(int)"})
  void testSetBitsPerComponent() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerComponent(1);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdShadingType4.getBitsPerComponent());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}.
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerComponent(int)"})
  void testSetBitsPerComponent2() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerComponent(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdShadingType4.getBitsPerComponent());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}.
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerComponent(int)"})
  void testSetBitsPerComponent3() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerComponent(8);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(8, pdShadingType4.getBitsPerComponent());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBitsPerCoordinate()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getBitsPerCoordinate()}
   */
  @Test
  @DisplayName(
      "Test getBitsPerCoordinate(); given PDShadingType4(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getBitsPerCoordinate()"})
  void testGetBitsPerCoordinate_givenPDShadingType4WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDShadingType4(new COSDictionary()).getBitsPerCoordinate());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBitsPerCoordinate()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getBitsPerCoordinate()}
   */
  @Test
  @DisplayName(
      "Test getBitsPerCoordinate(); given PDShadingType4(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getBitsPerCoordinate()"})
  void testGetBitsPerCoordinate_givenPDShadingType4WithShadingDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDShadingType4(new COSStream()).getBitsPerCoordinate());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}.
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}
   */
  @Test
  @DisplayName("Test setBitsPerCoordinate(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerCoordinate(int)"})
  void testSetBitsPerCoordinate() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerCoordinate(1);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdShadingType4.getBitsPerCoordinate());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}.
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}
   */
  @Test
  @DisplayName("Test setBitsPerCoordinate(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerCoordinate(int)"})
  void testSetBitsPerCoordinate2() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerCoordinate(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdShadingType4.getBitsPerCoordinate());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getNumberOfColorComponents()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} return zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getNumberOfColorComponents()}
   */
  @Test
  @DisplayName(
      "Test getNumberOfColorComponents(); given COSDictionary getInt(COSName) return zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getNumberOfColorComponents()"})
  void testGetNumberOfColorComponents_givenCOSDictionaryGetIntReturnZero_thenReturnOne()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(0);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    int actualNumberOfColorComponents =
        new PDShadingType4(shadingDictionary).getNumberOfColorComponents();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    assertEquals(1, actualNumberOfColorComponents);
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}.
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setDecodeValues(COSArray)"})
  void testSetDecodeValues() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setDecodeValues(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDecodeValues(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setDecodeValues(COSArray)"})
  void testSetDecodeValues_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(new COSObjectKey(1L, 1));

    // Act
    pdShadingType4.setDecodeValues(cosArray);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDecodeValues(COSArray); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setDecodeValues(COSArray)"})
  void testSetDecodeValues_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    // Act
    pdShadingType4.setDecodeValues(cosArray);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray); when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setDecodeValues(COSArray)"})
  void testSetDecodeValues_whenCOSArray() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setDecodeValues(new COSArray());

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}.
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.PDRange PDTriangleBasedShadingType.getDecodeForParameter(int)"
  })
  void testGetDecodeForParameter() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType4(new COSDictionary()).getDecodeForParameter(10));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName(
      "Test getDecodeForParameter(int); given PDShadingType4(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.PDRange PDTriangleBasedShadingType.getDecodeForParameter(int)"
  })
  void testGetDecodeForParameter_givenPDShadingType4WithShadingDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType4(new COSStream()).getDecodeForParameter(10));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_when05() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f, new PDShadingType4(new COSDictionary()).interpolate(0.5f, 5L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_when052() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f, new PDShadingType4(new COSDictionary()).interpolate(-0.5f, 5L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_whenFive() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f, new PDShadingType4(new COSDictionary()).interpolate(10.0f, 5L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_whenOne() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f, new PDShadingType4(new COSDictionary()).interpolate(10.0f, 1L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test getBounds(AffineTransform, Matrix); given PDShadingType4(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D PDTriangleBasedShadingType.getBounds(AffineTransform, Matrix)"})
  void testGetBounds_givenPDShadingType4WithShadingDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    AffineTransform affineTransform = new AffineTransform();

    // Act
    Rectangle2D actualBounds = pdShadingType4.getBounds(affineTransform, new Matrix());

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    Rectangle actualBounds2 = actualBounds.getBounds();
    assertEquals(actualBounds, actualBounds2);
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test getBounds(AffineTransform, Matrix); given PDShadingType4(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D PDTriangleBasedShadingType.getBounds(AffineTransform, Matrix)"})
  void testGetBounds_givenPDShadingType4WithShadingDictionaryIsCOSStream() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSStream());
    AffineTransform affineTransform = new AffineTransform();

    // Act
    Rectangle2D actualBounds = pdShadingType4.getBounds(affineTransform, new Matrix());

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    Rectangle actualBounds2 = actualBounds.getBounds();
    assertEquals(actualBounds, actualBounds2);
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType6#PDShadingType6(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test getBounds(AffineTransform, Matrix); given PDShadingType6(COSDictionary) with shadingDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D PDTriangleBasedShadingType.getBounds(AffineTransform, Matrix)"})
  void testGetBounds_givenPDShadingType6WithShadingDictionaryIsCOSStream_thenReturnNull()
      throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType6.getBounds(xform, new Matrix()));
  }
}
