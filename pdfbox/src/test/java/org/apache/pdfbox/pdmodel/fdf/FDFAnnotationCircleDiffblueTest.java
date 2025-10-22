package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FDFAnnotationCircleDiffblueTest {
  /**
   * Test {@link FDFAnnotationCircle#FDFAnnotationCircle(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationCircle#FDFAnnotationCircle(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationCircle(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationCircle.<init>(COSDictionary)"})
  void testNewFDFAnnotationCircle() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationCircle(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationCircle#FDFAnnotationCircle()}.
   * <p>
   * Method under test: {@link FDFAnnotationCircle#FDFAnnotationCircle()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationCircle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationCircle.<init>()"})
  void testNewFDFAnnotationCircle2() throws IOException {
    // Arrange and Act
    FDFAnnotationCircle actualFdfAnnotationCircle = new FDFAnnotationCircle();

    // Assert
    assertEquals("", actualFdfAnnotationCircle.getRichContents());
    assertNull(actualFdfAnnotationCircle.getColor());
    assertNull(actualFdfAnnotationCircle.getInteriorColor());
    assertNull(actualFdfAnnotationCircle.getPage());
    assertNull(actualFdfAnnotationCircle.getContents());
    assertNull(actualFdfAnnotationCircle.getDate());
    assertNull(actualFdfAnnotationCircle.getIntent());
    assertNull(actualFdfAnnotationCircle.getName());
    assertNull(actualFdfAnnotationCircle.getSubject());
    assertNull(actualFdfAnnotationCircle.getTitle());
    assertNull(actualFdfAnnotationCircle.getCreationDate());
    assertNull(actualFdfAnnotationCircle.getRectangle());
    assertNull(actualFdfAnnotationCircle.getFringe());
    assertNull(actualFdfAnnotationCircle.getBorderEffect());
    assertNull(actualFdfAnnotationCircle.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationCircle.getOpacity());
    assertFalse(actualFdfAnnotationCircle.isHidden());
    assertFalse(actualFdfAnnotationCircle.isInvisible());
    assertFalse(actualFdfAnnotationCircle.isLocked());
    assertFalse(actualFdfAnnotationCircle.isLockedContents());
    assertFalse(actualFdfAnnotationCircle.isNoRotate());
    assertFalse(actualFdfAnnotationCircle.isNoView());
    assertFalse(actualFdfAnnotationCircle.isNoZoom());
    assertFalse(actualFdfAnnotationCircle.isPrinted());
    assertFalse(actualFdfAnnotationCircle.isReadOnly());
    assertFalse(actualFdfAnnotationCircle.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationCircle#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationCircle#FDFAnnotationCircle()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationCircle#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationCircle(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Color FDFAnnotationCircle.getInteriorColor()"})
  void testGetInteriorColor_givenFDFAnnotationCircle_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCircle()).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationCircle#getInteriorColor()}.
   * <ul>
   *   <li>Then return decode {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationCircle#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); then return decode '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Color FDFAnnotationCircle.getInteriorColor()"})
  void testGetInteriorColor_thenReturnDecode42() throws NumberFormatException {
    // Arrange
    FDFAnnotationCircle fdfAnnotationCircle = new FDFAnnotationCircle();
    Color color = Color.decode("42");
    fdfAnnotationCircle.setInteriorColor(color);

    // Act and Assert
    assertEquals(color, fdfAnnotationCircle.getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationCircle#setFringe(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link FDFAnnotationCircle#FDFAnnotationCircle()} Fringe UpperRightX is {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationCircle#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName("Test setFringe(PDRectangle); when A0; then FDFAnnotationCircle() Fringe UpperRightX is '2383.937'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationCircle.setFringe(PDRectangle)"})
  void testSetFringe_whenA0_thenFDFAnnotationCircleFringeUpperRightXIs2383937() {
    // Arrange
    FDFAnnotationCircle fdfAnnotationCircle = new FDFAnnotationCircle();

    // Act
    fdfAnnotationCircle.setFringe(PDRectangle.A0);

    // Assert
    PDRectangle fringe = fdfAnnotationCircle.getFringe();
    assertEquals(2383.937f, fringe.getUpperRightX());
    assertEquals(2383.937f, fringe.getWidth());
    assertEquals(3370.3938f, fringe.getHeight());
    assertEquals(3370.3938f, fringe.getUpperRightY());
  }

  /**
   * Test {@link FDFAnnotationCircle#setFringe(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFAnnotationCircle#FDFAnnotationCircle()} COSObject toIncrement Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationCircle#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName("Test setFringe(PDRectangle); when 'null'; then FDFAnnotationCircle() COSObject toIncrement Objects Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationCircle.setFringe(PDRectangle)"})
  void testSetFringe_whenNull_thenFDFAnnotationCircleCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    FDFAnnotationCircle fdfAnnotationCircle = new FDFAnnotationCircle();

    // Act
    fdfAnnotationCircle.setFringe(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = fdfAnnotationCircle.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationCircle#getFringe()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationCircle#FDFAnnotationCircle()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationCircle#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationCircle(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle FDFAnnotationCircle.getFringe()"})
  void testGetFringe_givenFDFAnnotationCircle_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCircle()).getFringe());
  }

  /**
   * Test {@link FDFAnnotationCircle#getFringe()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationCircle#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return COSArray toList third Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle FDFAnnotationCircle.getFringe()"})
  void testGetFringe_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    FDFAnnotationCircle fdfAnnotationCircle = new FDFAnnotationCircle();
    fdfAnnotationCircle.setFringe(PDRectangle.A0);

    // Act
    PDRectangle actualFringe = fdfAnnotationCircle.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualFringe.getLowerLeftX());
    assertEquals(0.0f, actualFringe.getLowerLeftY());
    assertEquals(2383.937f, actualFringe.getUpperRightX());
    assertEquals(2383.937f, actualFringe.getWidth());
    assertEquals(3370.3938f, actualFringe.getHeight());
    assertEquals(3370.3938f, actualFringe.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link FDFAnnotationCircle#getFringe()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationCircle#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return Height is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle FDFAnnotationCircle.getFringe()"})
  void testGetFringe_thenReturnHeightIsZero() {
    // Arrange
    FDFAnnotationCircle fdfAnnotationCircle = new FDFAnnotationCircle();
    fdfAnnotationCircle.setFringe(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualFringe = fdfAnnotationCircle.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFringe.getHeight());
    assertEquals(0.0f, actualFringe.getWidth());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftX());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftY());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightX());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }
}
