package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDRectangleDiffblueTest {
  /**
   * Test {@link PDRectangle#PDRectangle()}.
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle()}
   */
  @Test
  @DisplayName("Test new PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>()"})
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
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(float, float)}.
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(float, float)}
   */
  @Test
  @DisplayName("Test new PDRectangle(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(float, float)"})
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
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(10.0f, actualPdRectangle.getHeight());
    assertEquals(10.0f, actualPdRectangle.getUpperRightX());
    assertEquals(10.0f, actualPdRectangle.getUpperRightY());
    assertEquals(10.0f, actualPdRectangle.getWidth());
    assertEquals(getResult, getResult2);
    assertEquals(getResult3, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(float, float, float, float)}.
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(float, float, float, float)}
   */
  @Test
  @DisplayName("Test new PDRectangle(float, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(float, float, float, float)"})
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
    assertEquals(10.0f, actualPdRectangle.getHeight());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(10.0f, actualPdRectangle.getWidth());
    assertEquals(20.0f, actualPdRectangle.getUpperRightX());
    assertEquals(20.0f, actualPdRectangle.getUpperRightY());
    assertEquals(getResult, getResult2);
    assertEquals(getResult3, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDRectangle(COSArray); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(COSArray)"})
  void testNewPDRectangle_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSArray array = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    array.add((COSBase) object);

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
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); given FALSE; when COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(COSArray)"})
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
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); given ONE; when COSArray() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(COSArray)"})
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
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName("Test new PDRectangle(COSArray); given ONE; when COSArray() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(COSArray)"})
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
   *
   * <ul>
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(BoundingBox)}
   */
  @Test
  @DisplayName("Test new PDRectangle(BoundingBox); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(BoundingBox)"})
  void testNewPDRectangle_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange
    BoundingBox box = new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    PDRectangle actualPdRectangle = new PDRectangle(box);

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
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(10.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(10.0f, actualPdRectangle.getUpperRightX());
    assertEquals(10.0f, actualPdRectangle.getUpperRightY());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Test {@link PDRectangle#PDRectangle(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then COSArray toList first return {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#PDRectangle(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDRectangle(COSArray); when COSArray(); then COSArray toList first return COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.<init>(COSArray)"})
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
    assertEquals(0.0f, actualPdRectangle.getHeight());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdRectangle.getLowerLeftY());
    assertEquals(0.0f, actualPdRectangle.getUpperRightX());
    assertEquals(0.0f, actualPdRectangle.getUpperRightY());
    assertEquals(0.0f, actualPdRectangle.getWidth());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualPdRectangle.getCOSObject());
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given A0; when '-0.5'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRectangle.contains(float, float)"})
  void testContains_givenA0_when05_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PDRectangle.A0.contains(-0.5f, 10.0f));
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given A0; when '-0.5'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRectangle.contains(float, float)"})
  void testContains_givenA0_when05_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(PDRectangle.A0.contains(10.0f, -0.5f));
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given A0; when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRectangle.contains(float, float)"})
  void testContains_givenA0_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PDRectangle.A0.contains(10.0f, 10.0f));
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()} UpperRightX is ten.
   *   <li>When ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName(
      "Test contains(float, float); given PDRectangle() UpperRightX is ten; when ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRectangle.contains(float, float)"})
  void testContains_givenPDRectangleUpperRightXIsTen_whenTen_thenReturnFalse() {
    // Arrange
    PDRectangle pdRectangle = new PDRectangle();
    pdRectangle.setUpperRightX(10.0f);

    // Act and Assert
    assertFalse(pdRectangle.contains(10.0f, 10.0f));
  }

  /**
   * Test {@link PDRectangle#contains(float, float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   *   <li>When ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given PDRectangle(); when ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRectangle.contains(float, float)"})
  void testContains_givenPDRectangle_whenTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDRectangle().contains(10.0f, 10.0f));
  }

  /**
   * Test {@link PDRectangle#createRetranslatedRectangle()}.
   *
   * <p>Method under test: {@link PDRectangle#createRetranslatedRectangle()}
   */
  @Test
  @DisplayName("Test createRetranslatedRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDRectangle.createRetranslatedRectangle()"})
  void testCreateRetranslatedRectangle() {
    // Arrange and Act
    PDRectangle actualCreateRetranslatedRectangleResult =
        PDRectangle.A0.createRetranslatedRectangle();

    // Assert
    COSArray cOSArray = actualCreateRetranslatedRectangleResult.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertEquals(0.0f, actualCreateRetranslatedRectangleResult.getLowerLeftX());
    assertEquals(0.0f, actualCreateRetranslatedRectangleResult.getLowerLeftY());
    assertEquals(2383.937f, actualCreateRetranslatedRectangleResult.getUpperRightX());
    assertEquals(2383.937f, actualCreateRetranslatedRectangleResult.getWidth());
    assertEquals(3370.3938f, actualCreateRetranslatedRectangleResult.getHeight());
    assertEquals(3370.3938f, actualCreateRetranslatedRectangleResult.getUpperRightY());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualCreateRetranslatedRectangleResult.getCOSObject());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDRectangle#toString()}
   *   <li>{@link PDRectangle#getCOSArray()}
   *   <li>{@link PDRectangle#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSArray PDRectangle.getCOSArray()",
    "COSBase PDRectangle.getCOSObject()",
    "String PDRectangle.toString()"
  })
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
   *
   * <p>Method under test: {@link PDRectangle#getLowerLeftX()}
   */
  @Test
  @DisplayName("Test getLowerLeftX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRectangle.getLowerLeftX()"})
  void testGetLowerLeftX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, PDRectangle.A0.getLowerLeftX());
  }

  /**
   * Test {@link PDRectangle#setLowerLeftX(float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   *   <li>Then {@link PDRectangle#PDRectangle()} COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#setLowerLeftX(float)}
   */
  @Test
  @DisplayName(
      "Test setLowerLeftX(float); given PDRectangle(); then PDRectangle() COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.setLowerLeftX(float)"})
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
   *
   * <p>Method under test: {@link PDRectangle#getLowerLeftY()}
   */
  @Test
  @DisplayName("Test getLowerLeftY()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRectangle.getLowerLeftY()"})
  void testGetLowerLeftY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, PDRectangle.A0.getLowerLeftY());
  }

  /**
   * Test {@link PDRectangle#setLowerLeftY(float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   *   <li>Then {@link PDRectangle#PDRectangle()} Height is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#setLowerLeftY(float)}
   */
  @Test
  @DisplayName(
      "Test setLowerLeftY(float); given PDRectangle(); then PDRectangle() Height is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.setLowerLeftY(float)"})
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
   *
   * <p>Method under test: {@link PDRectangle#getUpperRightX()}
   */
  @Test
  @DisplayName("Test getUpperRightX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRectangle.getUpperRightX()"})
  void testGetUpperRightX() {
    // Arrange, Act and Assert
    assertEquals(2383.937f, PDRectangle.A0.getUpperRightX());
  }

  /**
   * Test {@link PDRectangle#setUpperRightX(float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   *   <li>Then {@link PDRectangle#PDRectangle()} UpperRightX is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#setUpperRightX(float)}
   */
  @Test
  @DisplayName(
      "Test setUpperRightX(float); given PDRectangle(); then PDRectangle() UpperRightX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.setUpperRightX(float)"})
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
   *
   * <p>Method under test: {@link PDRectangle#getUpperRightY()}
   */
  @Test
  @DisplayName("Test getUpperRightY()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRectangle.getUpperRightY()"})
  void testGetUpperRightY() {
    // Arrange, Act and Assert
    assertEquals(3370.3938f, PDRectangle.A0.getUpperRightY());
  }

  /**
   * Test {@link PDRectangle#setUpperRightY(float)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#PDRectangle()}.
   *   <li>Then {@link PDRectangle#PDRectangle()} Height is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#setUpperRightY(float)}
   */
  @Test
  @DisplayName("Test setUpperRightY(float); given PDRectangle(); then PDRectangle() Height is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRectangle.setUpperRightY(float)"})
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
   *
   * <p>Method under test: {@link PDRectangle#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRectangle.getWidth()"})
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(2383.937f, PDRectangle.A0.getWidth());
  }

  /**
   * Test {@link PDRectangle#getHeight()}.
   *
   * <p>Method under test: {@link PDRectangle#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRectangle.getHeight()"})
  void testGetHeight() {
    // Arrange, Act and Assert
    assertEquals(3370.3938f, PDRectangle.A0.getHeight());
  }

  /**
   * Test {@link PDRectangle#transform(Matrix)}.
   *
   * <ul>
   *   <li>When {@link Matrix#Matrix()}.
   *   <li>Then CurrentPoint return {@link Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDRectangle#transform(Matrix)}
   */
  @Test
  @DisplayName("Test transform(Matrix); when Matrix(); then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDRectangle.transform(Matrix)"})
  void testTransform_whenMatrix_thenCurrentPointReturnFloat() {
    // Arrange and Act
    GeneralPath actualTransformResult = PDRectangle.A0.transform(new Matrix());

    // Assert
    assertTrue(actualTransformResult.getCurrentPoint() instanceof Float);
    assertTrue(actualTransformResult.getBounds2D() instanceof Rectangle2D.Float);
    assertEquals(1, actualTransformResult.getWindingRule());
  }

  /**
   * Test {@link PDRectangle#toGeneralPath()}.
   *
   * <p>Method under test: {@link PDRectangle#toGeneralPath()}
   */
  @Test
  @DisplayName("Test toGeneralPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDRectangle.toGeneralPath()"})
  void testToGeneralPath() {
    // Arrange and Act
    GeneralPath actualToGeneralPathResult = PDRectangle.A0.toGeneralPath();

    // Assert
    assertTrue(actualToGeneralPathResult.getCurrentPoint() instanceof Float);
    assertTrue(actualToGeneralPathResult.getBounds2D() instanceof Rectangle2D.Float);
    assertEquals(1, actualToGeneralPathResult.getWindingRule());
  }
}
