package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationCircleDiffblueTest {
  /**
   * Test {@link PDAnnotationCircle#PDAnnotationCircle()}.
   *
   * <p>Method under test: {@link PDAnnotationCircle#PDAnnotationCircle()}
   */
  @Test
  @DisplayName("Test new PDAnnotationCircle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCircle.<init>()"})
  void testNewPDAnnotationCircle() throws IOException {
    // Arrange and Act
    PDAnnotationCircle actualPdAnnotationCircle = new PDAnnotationCircle();

    // Assert
    assertNull(actualPdAnnotationCircle.getAnnotationName());
    assertNull(actualPdAnnotationCircle.getContents());
    assertNull(actualPdAnnotationCircle.getModifiedDate());
    assertNull(actualPdAnnotationCircle.getIntent());
    assertNull(actualPdAnnotationCircle.getRichContents());
    assertNull(actualPdAnnotationCircle.getSubject());
    assertNull(actualPdAnnotationCircle.getTitlePopup());
    assertNull(actualPdAnnotationCircle.getCreationDate());
    assertNull(actualPdAnnotationCircle.getAppearanceState());
    assertNull(actualPdAnnotationCircle.getPage());
    assertNull(actualPdAnnotationCircle.getRectangle());
    assertNull(actualPdAnnotationCircle.getRectDifference());
    assertNull(actualPdAnnotationCircle.getOptionalContent());
    assertNull(actualPdAnnotationCircle.getColor());
    assertNull(actualPdAnnotationCircle.getInteriorColor());
    assertNull(actualPdAnnotationCircle.getInReplyTo());
    assertNull(actualPdAnnotationCircle.getPopup());
    assertNull(actualPdAnnotationCircle.getAppearance());
    assertNull(actualPdAnnotationCircle.getNormalAppearanceStream());
    assertNull(actualPdAnnotationCircle.getBorderEffect());
    assertNull(actualPdAnnotationCircle.getBorderStyle());
    assertNull(actualPdAnnotationCircle.getExternalData());
    assertEquals(-1, actualPdAnnotationCircle.getStructParent());
    assertEquals(0, actualPdAnnotationCircle.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationCircle.getConstantOpacity());
    assertFalse(actualPdAnnotationCircle.isHidden());
    assertFalse(actualPdAnnotationCircle.isInvisible());
    assertFalse(actualPdAnnotationCircle.isLocked());
    assertFalse(actualPdAnnotationCircle.isLockedContents());
    assertFalse(actualPdAnnotationCircle.isNoRotate());
    assertFalse(actualPdAnnotationCircle.isNoView());
    assertFalse(actualPdAnnotationCircle.isNoZoom());
    assertFalse(actualPdAnnotationCircle.isPrinted());
    assertFalse(actualPdAnnotationCircle.isReadOnly());
    assertFalse(actualPdAnnotationCircle.isToggleNoView());
    assertEquals(PDAnnotationCircle.SUB_TYPE, actualPdAnnotationCircle.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCircle.getReplyType());
    assertArrayEquals(new float[] {}, actualPdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCircle#PDAnnotationCircle(COSDictionary)}.
   *
   * <p>Method under test: {@link PDAnnotationCircle#PDAnnotationCircle(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationCircle(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCircle.<init>(COSDictionary)"})
  void testNewPDAnnotationCircle2() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationCircle actualPdAnnotationCircle = new PDAnnotationCircle(field);

    // Assert
    assertNull(actualPdAnnotationCircle.getAnnotationName());
    assertNull(actualPdAnnotationCircle.getContents());
    assertNull(actualPdAnnotationCircle.getModifiedDate());
    assertNull(actualPdAnnotationCircle.getSubtype());
    assertNull(actualPdAnnotationCircle.getIntent());
    assertNull(actualPdAnnotationCircle.getRichContents());
    assertNull(actualPdAnnotationCircle.getSubject());
    assertNull(actualPdAnnotationCircle.getTitlePopup());
    assertNull(actualPdAnnotationCircle.getCreationDate());
    assertNull(actualPdAnnotationCircle.getAppearanceState());
    assertNull(actualPdAnnotationCircle.getPage());
    assertNull(actualPdAnnotationCircle.getRectangle());
    assertNull(actualPdAnnotationCircle.getRectDifference());
    assertNull(actualPdAnnotationCircle.getOptionalContent());
    assertNull(actualPdAnnotationCircle.getColor());
    assertNull(actualPdAnnotationCircle.getInteriorColor());
    assertNull(actualPdAnnotationCircle.getInReplyTo());
    assertNull(actualPdAnnotationCircle.getPopup());
    assertNull(actualPdAnnotationCircle.getAppearance());
    assertNull(actualPdAnnotationCircle.getNormalAppearanceStream());
    assertNull(actualPdAnnotationCircle.getBorderEffect());
    assertNull(actualPdAnnotationCircle.getBorderStyle());
    assertNull(actualPdAnnotationCircle.getExternalData());
    assertEquals(-1, actualPdAnnotationCircle.getStructParent());
    assertEquals(0, actualPdAnnotationCircle.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationCircle.getConstantOpacity());
    assertFalse(actualPdAnnotationCircle.isHidden());
    assertFalse(actualPdAnnotationCircle.isInvisible());
    assertFalse(actualPdAnnotationCircle.isLocked());
    assertFalse(actualPdAnnotationCircle.isLockedContents());
    assertFalse(actualPdAnnotationCircle.isNoRotate());
    assertFalse(actualPdAnnotationCircle.isNoView());
    assertFalse(actualPdAnnotationCircle.isNoZoom());
    assertFalse(actualPdAnnotationCircle.isPrinted());
    assertFalse(actualPdAnnotationCircle.isReadOnly());
    assertFalse(actualPdAnnotationCircle.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCircle.getReplyType());
    assertSame(field, actualPdAnnotationCircle.getCOSObject());
    assertArrayEquals(new float[] {}, actualPdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationCircle#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCircle.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances(new PDDocument());

    // Assert
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, pdAnnotationCircle.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationCircle#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCircle.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdAnnotationCircle.setRectangle(rectangle);

    // Act
    pdAnnotationCircle.constructAppearances(new PDDocument());

    // Assert
    PDRectangle rectangle2 = pdAnnotationCircle.getRectangle();
    assertEquals(0.0f, rectangle2.getHeight());
    assertEquals(0.0f, rectangle2.getWidth());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, pdAnnotationCircle.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray);
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances()}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationCircle#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then PDAnnotationCircle() Rectangle Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCircle.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationCircleRectangleHeightIsZero() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdAnnotationCircle.setRectangle(rectangle);

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDRectangle rectangle2 = pdAnnotationCircle.getRectangle();
    assertEquals(0.0f, rectangle2.getHeight());
    assertEquals(0.0f, rectangle2.getWidth());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, pdAnnotationCircle.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray);
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances()}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle LowerLeftX is {@code
   *       -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationCircle#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); then PDAnnotationCircle() Rectangle LowerLeftX is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationCircle.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationCircleRectangleLowerLeftXIs05() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A1);

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    assertEquals(1684.2795f, rectangle.getUpperRightX());
    assertEquals(1684.7795f, rectangle.getWidth());
    assertEquals(2384.437f, rectangle.getUpperRightY());
    assertEquals(2384.937f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, pdAnnotationCircle.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "841.8898 2383.437 m\n1309.3274 2383.437 1683.2795 18".getBytes("UTF-8"), byteArray);
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }
}
