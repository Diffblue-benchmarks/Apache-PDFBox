package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationCircleDiffblueTest {
  /**
   * Test {@link PDAnnotationCircle#PDAnnotationCircle()}.
   * <p>
   * Method under test: {@link PDAnnotationCircle#PDAnnotationCircle()}
   */
  @Test
  @DisplayName("Test new PDAnnotationCircle()")
  void testNewPDAnnotationCircle() throws IOException {
    // Arrange and Act
    PDAnnotationCircle actualPdAnnotationCircle = new PDAnnotationCircle();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationCircle.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationCircle.getAnnotationName());
    assertNull(actualPdAnnotationCircle.getContents());
    assertNull(actualPdAnnotationCircle.getModifiedDate());
    assertNull(actualPdAnnotationCircle.getIntent());
    assertNull(actualPdAnnotationCircle.getRichContents());
    assertNull(actualPdAnnotationCircle.getSubject());
    assertNull(actualPdAnnotationCircle.getTitlePopup());
    assertNull(actualPdAnnotationCircle.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationCircle.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationCircle.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
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
    assertEquals(0, actualPdAnnotationCircle.getRectDifferences().length);
    assertEquals(1.0f, actualPdAnnotationCircle.getConstantOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
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
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationCircle.SUB_TYPE, actualPdAnnotationCircle.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCircle.getReplyType());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationCircle#PDAnnotationCircle(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationCircle#PDAnnotationCircle(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationCircle(COSDictionary)")
  void testNewPDAnnotationCircle2() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationCircle actualPdAnnotationCircle = new PDAnnotationCircle(field);

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationCircle.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
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
    assertEquals(0, actualPdAnnotationCircle.getRectDifferences().length);
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationCircle.getConstantOpacity());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
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
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCircle.getReplyType());
    assertSame(field, actualPdAnnotationCircle.getCOSObject());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationCircle#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-0.5f, bBox4.getLowerLeftX());
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, bBox.getLowerLeftY());
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(-0.5f, bBox3.getLowerLeftY());
    assertEquals(-0.5f, bBox4.getLowerLeftY());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(0.5f, matrix.getTranslateX());
    assertEquals(0.5f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.5f, floatArray[0]);
    assertEquals(0.5f, floatArray[1]);
    assertEquals(231, contentsForStreamParsing.available());
    assertEquals(231, contentsForStreamParsing2.available());
    assertEquals(231, contentsForStreamParsing3.available());
    assertEquals(231, contentsForStreamParsing4.available());
    assertEquals(231, contentsForRandomAccess.available());
    assertEquals(231, contentsForRandomAccess2.available());
    assertEquals(231, contentsForRandomAccess3.available());
    assertEquals(231, contentsForRandomAccess4.available());
    assertEquals(231, normalAppearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream2.getStream().getLength());
    assertEquals(231, appearanceStream3.getStream().getLength());
    assertEquals(231, normalAppearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream2.getContentStream().getLength());
    assertEquals(231, appearanceStream3.getContentStream().getLength());
    assertEquals(231L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(2384.437f, bBox.getUpperRightX());
    assertEquals(2384.437f, bBox2.getUpperRightX());
    assertEquals(2384.437f, bBox3.getUpperRightX());
    assertEquals(2384.437f, bBox4.getUpperRightX());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, bBox.getWidth());
    assertEquals(2384.937f, bBox2.getWidth());
    assertEquals(2384.937f, bBox3.getWidth());
    assertEquals(2384.937f, bBox4.getWidth());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.8938f, bBox.getUpperRightY());
    assertEquals(3370.8938f, bBox2.getUpperRightY());
    assertEquals(3370.8938f, bBox3.getUpperRightY());
    assertEquals(3370.8938f, bBox4.getUpperRightY());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, bBox.getHeight());
    assertEquals(3371.3938f, bBox2.getHeight());
    assertEquals(3371.3938f, bBox3.getHeight());
    assertEquals(3371.3938f, bBox4.getHeight());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    COSIncrement toIncrementResult = pdAnnotationCircle.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationCircle#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(-2.14748365E9f, floatArray[1]);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
    assertEquals(0.0f, rectangle.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    assertEquals(2.14748365E9f, rectangle.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(300, contentsForStreamParsing.available());
    assertEquals(300, contentsForStreamParsing2.available());
    assertEquals(300, contentsForStreamParsing3.available());
    assertEquals(300, contentsForStreamParsing4.available());
    assertEquals(300, contentsForRandomAccess.available());
    assertEquals(300, contentsForRandomAccess2.available());
    assertEquals(300, contentsForRandomAccess3.available());
    assertEquals(300, contentsForRandomAccess4.available());
    assertEquals(300, normalAppearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream2.getStream().getLength());
    assertEquals(300, appearanceStream3.getStream().getLength());
    assertEquals(300, normalAppearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream2.getContentStream().getLength());
    assertEquals(300, appearanceStream3.getContentStream().getLength());
    assertEquals(300L, normalAppearanceStream.getCOSObject().getLength());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    COSIncrement toIncrementResult = pdAnnotationCircle.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationCircle#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-0.5f, bBox4.getLowerLeftX());
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, bBox.getLowerLeftY());
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(-0.5f, bBox3.getLowerLeftY());
    assertEquals(-0.5f, bBox4.getLowerLeftY());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(0.5f, matrix.getTranslateX());
    assertEquals(0.5f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.5f, floatArray[0]);
    assertEquals(0.5f, floatArray[1]);
    assertEquals(231, contentsForStreamParsing.available());
    assertEquals(231, contentsForStreamParsing2.available());
    assertEquals(231, contentsForStreamParsing3.available());
    assertEquals(231, contentsForStreamParsing4.available());
    assertEquals(231, contentsForRandomAccess.available());
    assertEquals(231, contentsForRandomAccess2.available());
    assertEquals(231, contentsForRandomAccess3.available());
    assertEquals(231, contentsForRandomAccess4.available());
    assertEquals(231, normalAppearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream.getStream().getLength());
    assertEquals(231, appearanceStream2.getStream().getLength());
    assertEquals(231, appearanceStream3.getStream().getLength());
    assertEquals(231, normalAppearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream.getContentStream().getLength());
    assertEquals(231, appearanceStream2.getContentStream().getLength());
    assertEquals(231, appearanceStream3.getContentStream().getLength());
    assertEquals(231L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(2384.437f, bBox.getUpperRightX());
    assertEquals(2384.437f, bBox2.getUpperRightX());
    assertEquals(2384.437f, bBox3.getUpperRightX());
    assertEquals(2384.437f, bBox4.getUpperRightX());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, bBox.getWidth());
    assertEquals(2384.937f, bBox2.getWidth());
    assertEquals(2384.937f, bBox3.getWidth());
    assertEquals(2384.937f, bBox4.getWidth());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.8938f, bBox.getUpperRightY());
    assertEquals(3370.8938f, bBox2.getUpperRightY());
    assertEquals(3370.8938f, bBox3.getUpperRightY());
    assertEquals(3370.8938f, bBox4.getUpperRightY());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, bBox.getHeight());
    assertEquals(3371.3938f, bBox2.getHeight());
    assertEquals(3371.3938f, bBox3.getHeight());
    assertEquals(3371.3938f, bBox4.getHeight());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    COSIncrement toIncrementResult = pdAnnotationCircle.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationCircle#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationCircle#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationCircle.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(-2.14748365E9f, floatArray[1]);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
    assertEquals(0.0f, rectangle.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    assertEquals(2.14748365E9f, rectangle.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(300, contentsForStreamParsing.available());
    assertEquals(300, contentsForStreamParsing2.available());
    assertEquals(300, contentsForStreamParsing3.available());
    assertEquals(300, contentsForStreamParsing4.available());
    assertEquals(300, contentsForRandomAccess.available());
    assertEquals(300, contentsForRandomAccess2.available());
    assertEquals(300, contentsForRandomAccess3.available());
    assertEquals(300, contentsForRandomAccess4.available());
    assertEquals(300, normalAppearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream.getStream().getLength());
    assertEquals(300, appearanceStream2.getStream().getLength());
    assertEquals(300, appearanceStream3.getStream().getLength());
    assertEquals(300, normalAppearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream.getContentStream().getLength());
    assertEquals(300, appearanceStream2.getContentStream().getLength());
    assertEquals(300, appearanceStream3.getContentStream().getLength());
    assertEquals(300L, normalAppearanceStream.getCOSObject().getLength());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    COSIncrement toIncrementResult = pdAnnotationCircle.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray);
  }
}
