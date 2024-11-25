package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDRectangleDiffblueTest {
  /**
   * Test {@link PDRectangle#PDRectangle()}.
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle()}
   */
  @Test
  @DisplayName("Test new PDRectangle()")
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
   * Test {@link PDRectangle#PDRectangle(float, float)}.
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle(float, float)}
   */
  @Test
  @DisplayName("Test new PDRectangle(float, float)")
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
   * Test {@link PDRectangle#PDRectangle(float, float, float, float)}.
   * <p>
   * Method under test:
   * {@link PDRectangle#PDRectangle(float, float, float, float)}
   */
  @Test
  @DisplayName("Test new PDRectangle(float, float, float, float)")
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
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  void testNewPDRectangle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArray array = new COSArray();
    array.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

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
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); given FALSE; when COSArray() add FALSE")
  void testNewPDRectangle_givenFalse_whenCOSArrayAddFalse() {
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
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); given ONE; when COSArray() add ONE")
  void testNewPDRectangle_givenOne_whenCOSArrayAddOne() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSFloat.ONE);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(array);

    // Assert
    List<? extends COSBase> toListResult = actualPdRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualPdRectangle.getUpperRightX());
    assertEquals(1.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); given ONE; when COSArray() add ONE")
  void testNewPDRectangle_givenOne_whenCOSArrayAddOne2() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSInteger.ONE);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(array);

    // Assert
    List<? extends COSBase> toListResult = actualPdRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualPdRectangle.getUpperRightX());
    assertEquals(1.0f, actualPdRectangle.getWidth());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(BoundingBox)}.
   * <ul>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle(BoundingBox)}
   */
  @Test
  @DisplayName("Test new PDRectangle(BoundingBox); then return COSArray toList size is four")
  void testNewPDRectangle_thenReturnCOSArrayToListSizeIsFour() {
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
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then COSArray toList first return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); when COSArray(); then COSArray toList first return COSFloat")
  void testNewPDRectangle_whenCOSArray_thenCOSArrayToListFirstReturnCOSFloat() {
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
   * Test {@link PDRectangle#contains(float, float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When {@code -0.5}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given A0; when '-0.5'; then return 'false'")
  void testContains_givenA0_when05_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PDRectangle.A0.contains(-0.5f, 10.0f));
    assertFalse(PDRectangle.A0.contains(10.0f, -0.5f));
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given A0; when ten; then return 'true'")
  void testContains_givenA0_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PDRectangle.A0.contains(10.0f, 10.0f));
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given PDRectangle(); when ten; then return 'false'")
  void testContains_givenPDRectangle_whenTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDRectangle()).contains(10.0f, 10.0f));
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given PDRectangle(); when zero; then return 'false'")
  void testContains_givenPDRectangle_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDRectangle()).contains(0.0f, 10.0f));
  }

  /**
   * Test {@link PDRectangle#createRetranslatedRectangle()}.
   * <p>
   * Method under test: {@link PDRectangle#createRetranslatedRectangle()}
   */
  @Test
  @DisplayName("Test createRetranslatedRectangle()")
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDRectangle#toString()}
   *   <li>{@link PDRectangle#getCOSArray()}
   *   <li>{@link PDRectangle#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test {@link PDRectangle#getLowerLeftX()}.
   * <p>
   * Method under test: {@link PDRectangle#getLowerLeftX()}
   */
  @Test
  @DisplayName("Test getLowerLeftX()")
  void testGetLowerLeftX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, PDRectangle.A0.getLowerLeftX());
  }

  /**
   * Test {@link PDRectangle#setLowerLeftX(float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDRectangle#PDRectangle()} COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#setLowerLeftX(float)}
   */
  @Test
  @DisplayName("Test setLowerLeftX(float); given PDRectangle(); then PDRectangle() COSArray toList size is four")
  void testSetLowerLeftX_givenPDRectangle_thenPDRectangleCOSArrayToListSizeIsFour() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setLowerLeftX(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(-10.0f, pdRectangle.getWidth());
    assertEquals(10.0f, pdRectangle.getLowerLeftX());
    COSBase getResult3 = toListResult.get(1);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDRectangle#getLowerLeftY()}.
   * <p>
   * Method under test: {@link PDRectangle#getLowerLeftY()}
   */
  @Test
  @DisplayName("Test getLowerLeftY()")
  void testGetLowerLeftY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, PDRectangle.A0.getLowerLeftY());
  }

  /**
   * Test {@link PDRectangle#setLowerLeftY(float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDRectangle#PDRectangle()} Height is minus ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#setLowerLeftY(float)}
   */
  @Test
  @DisplayName("Test setLowerLeftY(float); given PDRectangle(); then PDRectangle() Height is minus ten")
  void testSetLowerLeftY_givenPDRectangle_thenPDRectangleHeightIsMinusTen() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setLowerLeftY(10.0f);

    // Assert
    assertEquals(-10.0f, pdRectangle.getHeight());
    assertEquals(10.0f, pdRectangle.getLowerLeftY());
  }

  /**
   * Test {@link PDRectangle#getUpperRightX()}.
   * <p>
   * Method under test: {@link PDRectangle#getUpperRightX()}
   */
  @Test
  @DisplayName("Test getUpperRightX()")
  void testGetUpperRightX() {
    // Arrange, Act and Assert
    assertEquals(2383.937f, PDRectangle.A0.getUpperRightX());
  }

  /**
   * Test {@link PDRectangle#setUpperRightX(float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDRectangle#PDRectangle()} UpperRightX is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#setUpperRightX(float)}
   */
  @Test
  @DisplayName("Test setUpperRightX(float); given PDRectangle(); then PDRectangle() UpperRightX is ten")
  void testSetUpperRightX_givenPDRectangle_thenPDRectangleUpperRightXIsTen() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setUpperRightX(10.0f);

    // Assert
    assertEquals(10.0f, pdRectangle.getUpperRightX());
    assertEquals(10.0f, pdRectangle.getWidth());
  }

  /**
   * Test {@link PDRectangle#getUpperRightY()}.
   * <p>
   * Method under test: {@link PDRectangle#getUpperRightY()}
   */
  @Test
  @DisplayName("Test getUpperRightY()")
  void testGetUpperRightY() {
    // Arrange, Act and Assert
    assertEquals(3370.3938f, PDRectangle.A0.getUpperRightY());
  }

  /**
   * Test {@link PDRectangle#setUpperRightY(float)}.
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDRectangle#PDRectangle()} Height is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#setUpperRightY(float)}
   */
  @Test
  @DisplayName("Test setUpperRightY(float); given PDRectangle(); then PDRectangle() Height is ten")
  void testSetUpperRightY_givenPDRectangle_thenPDRectangleHeightIsTen() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();

    // Act
    pdRectangle.setUpperRightY(10.0f);

    // Assert
    assertEquals(10.0f, pdRectangle.getHeight());
    assertEquals(10.0f, pdRectangle.getUpperRightY());
  }

  /**
   * Test {@link PDRectangle#getWidth()}.
   * <p>
   * Method under test: {@link PDRectangle#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(2383.937f, PDRectangle.A0.getWidth());
  }

  /**
   * Test {@link PDRectangle#getHeight()}.
   * <p>
   * Method under test: {@link PDRectangle#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight()")
  void testGetHeight() {
    // Arrange, Act and Assert
    assertEquals(3370.3938f, PDRectangle.A0.getHeight());
  }

  /**
   * Test {@link PDRectangle#transform(Matrix)}.
   * <ul>
   *   <li>When {@link Matrix#Matrix()}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectangle#transform(Matrix)}
   */
  @Test
  @DisplayName("Test transform(Matrix); when Matrix(); then Bounds Bounds2D return Rectangle")
  void testTransform_whenMatrix_thenBoundsBounds2DReturnRectangle() {
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
   * Test {@link PDRectangle#toGeneralPath()}.
   * <p>
   * Method under test: {@link PDRectangle#toGeneralPath()}
   */
  @Test
  @DisplayName("Test toGeneralPath()")
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
}
