package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationSquareDiffblueTest {
  /**
   * Test {@link PDAnnotationSquare#PDAnnotationSquare()}.
   * <p>
   * Method under test: {@link PDAnnotationSquare#PDAnnotationSquare()}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquare()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquare.<init>()"})
  void testNewPDAnnotationSquare() throws IOException {
    // Arrange and Act
    PDAnnotationSquare actualPdAnnotationSquare = new PDAnnotationSquare();

    // Assert
    assertNull(actualPdAnnotationSquare.getAnnotationName());
    assertNull(actualPdAnnotationSquare.getContents());
    assertNull(actualPdAnnotationSquare.getModifiedDate());
    assertNull(actualPdAnnotationSquare.getIntent());
    assertNull(actualPdAnnotationSquare.getRichContents());
    assertNull(actualPdAnnotationSquare.getSubject());
    assertNull(actualPdAnnotationSquare.getTitlePopup());
    assertNull(actualPdAnnotationSquare.getCreationDate());
    assertNull(actualPdAnnotationSquare.getAppearanceState());
    assertNull(actualPdAnnotationSquare.getPage());
    assertNull(actualPdAnnotationSquare.getRectangle());
    assertNull(actualPdAnnotationSquare.getRectDifference());
    assertNull(actualPdAnnotationSquare.getOptionalContent());
    assertNull(actualPdAnnotationSquare.getColor());
    assertNull(actualPdAnnotationSquare.getInteriorColor());
    assertNull(actualPdAnnotationSquare.getInReplyTo());
    assertNull(actualPdAnnotationSquare.getPopup());
    assertNull(actualPdAnnotationSquare.getAppearance());
    assertNull(actualPdAnnotationSquare.getNormalAppearanceStream());
    assertNull(actualPdAnnotationSquare.getBorderEffect());
    assertNull(actualPdAnnotationSquare.getBorderStyle());
    assertNull(actualPdAnnotationSquare.getExternalData());
    assertEquals(-1, actualPdAnnotationSquare.getStructParent());
    assertEquals(0, actualPdAnnotationSquare.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationSquare.getConstantOpacity());
    assertFalse(actualPdAnnotationSquare.isHidden());
    assertFalse(actualPdAnnotationSquare.isInvisible());
    assertFalse(actualPdAnnotationSquare.isLocked());
    assertFalse(actualPdAnnotationSquare.isLockedContents());
    assertFalse(actualPdAnnotationSquare.isNoRotate());
    assertFalse(actualPdAnnotationSquare.isNoView());
    assertFalse(actualPdAnnotationSquare.isNoZoom());
    assertFalse(actualPdAnnotationSquare.isPrinted());
    assertFalse(actualPdAnnotationSquare.isReadOnly());
    assertFalse(actualPdAnnotationSquare.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquare.getReplyType());
    assertEquals(PDAnnotationSquare.SUB_TYPE, actualPdAnnotationSquare.getSubtype());
    assertArrayEquals(new float[]{}, actualPdAnnotationSquare.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquare#PDAnnotationSquare(COSDictionary)}.
   * <p>
   * Method under test: {@link PDAnnotationSquare#PDAnnotationSquare(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquare(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquare.<init>(COSDictionary)"})
  void testNewPDAnnotationSquare2() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationSquare actualPdAnnotationSquare = new PDAnnotationSquare(field);

    // Assert
    assertNull(actualPdAnnotationSquare.getAnnotationName());
    assertNull(actualPdAnnotationSquare.getContents());
    assertNull(actualPdAnnotationSquare.getModifiedDate());
    assertNull(actualPdAnnotationSquare.getSubtype());
    assertNull(actualPdAnnotationSquare.getIntent());
    assertNull(actualPdAnnotationSquare.getRichContents());
    assertNull(actualPdAnnotationSquare.getSubject());
    assertNull(actualPdAnnotationSquare.getTitlePopup());
    assertNull(actualPdAnnotationSquare.getCreationDate());
    assertNull(actualPdAnnotationSquare.getAppearanceState());
    assertNull(actualPdAnnotationSquare.getPage());
    assertNull(actualPdAnnotationSquare.getRectangle());
    assertNull(actualPdAnnotationSquare.getRectDifference());
    assertNull(actualPdAnnotationSquare.getOptionalContent());
    assertNull(actualPdAnnotationSquare.getColor());
    assertNull(actualPdAnnotationSquare.getInteriorColor());
    assertNull(actualPdAnnotationSquare.getInReplyTo());
    assertNull(actualPdAnnotationSquare.getPopup());
    assertNull(actualPdAnnotationSquare.getAppearance());
    assertNull(actualPdAnnotationSquare.getNormalAppearanceStream());
    assertNull(actualPdAnnotationSquare.getBorderEffect());
    assertNull(actualPdAnnotationSquare.getBorderStyle());
    assertNull(actualPdAnnotationSquare.getExternalData());
    assertEquals(-1, actualPdAnnotationSquare.getStructParent());
    assertEquals(0, actualPdAnnotationSquare.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationSquare.getConstantOpacity());
    assertFalse(actualPdAnnotationSquare.isHidden());
    assertFalse(actualPdAnnotationSquare.isInvisible());
    assertFalse(actualPdAnnotationSquare.isLocked());
    assertFalse(actualPdAnnotationSquare.isLockedContents());
    assertFalse(actualPdAnnotationSquare.isNoRotate());
    assertFalse(actualPdAnnotationSquare.isNoView());
    assertFalse(actualPdAnnotationSquare.isNoZoom());
    assertFalse(actualPdAnnotationSquare.isPrinted());
    assertFalse(actualPdAnnotationSquare.isReadOnly());
    assertFalse(actualPdAnnotationSquare.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquare.getReplyType());
    assertSame(field, actualPdAnnotationSquare.getCOSObject());
    assertArrayEquals(new float[]{}, actualPdAnnotationSquare.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationSquare#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquare.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationSquare.constructAppearances(new PDDocument());

    // Assert
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, pdAnnotationSquare.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationSquare.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationSquare#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquare.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationSquare.constructAppearances(new PDDocument());

    // Assert
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    assertEquals(0.0f, rectangle.getWidth());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle.getUpperRightY());
    byte[] byteArray = new byte[31];
    assertEquals(31, pdAnnotationSquare.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationSquare.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances()}.
   * <ul>
   *   <li>Then {@link PDAnnotationSquare#PDAnnotationSquare()} Rectangle Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquare#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then PDAnnotationSquare() Rectangle Height is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquare.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationSquareRectangleHeightIsZero() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationSquare.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    assertEquals(0.0f, rectangle.getWidth());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle.getUpperRightY());
    byte[] byteArray = new byte[31];
    assertEquals(31, pdAnnotationSquare.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationSquare.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances()}.
   * <ul>
   *   <li>Then {@link PDAnnotationSquare#PDAnnotationSquare()} Rectangle LowerLeftX is {@code -0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquare#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then PDAnnotationSquare() Rectangle LowerLeftX is '-0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationSquare.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationSquareRectangleLowerLeftXIs05() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationSquare.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, pdAnnotationSquare.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationSquare.getRectDifferences(), 0.0f);
  }
}
