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

class PDAnnotationSquareDiffblueTest {
  /**
   * Test {@link PDAnnotationSquare#PDAnnotationSquare()}.
   * <p>
   * Method under test: {@link PDAnnotationSquare#PDAnnotationSquare()}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquare()")
  void testNewPDAnnotationSquare() throws IOException {
    // Arrange and Act
    PDAnnotationSquare actualPdAnnotationSquare = new PDAnnotationSquare();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationSquare.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationSquare.getAnnotationName());
    assertNull(actualPdAnnotationSquare.getContents());
    assertNull(actualPdAnnotationSquare.getModifiedDate());
    assertNull(actualPdAnnotationSquare.getIntent());
    assertNull(actualPdAnnotationSquare.getRichContents());
    assertNull(actualPdAnnotationSquare.getSubject());
    assertNull(actualPdAnnotationSquare.getTitlePopup());
    assertNull(actualPdAnnotationSquare.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationSquare.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationSquare.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
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
    assertEquals(0, actualPdAnnotationSquare.getRectDifferences().length);
    assertEquals(1.0f, actualPdAnnotationSquare.getConstantOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
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
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquare.getReplyType());
    assertEquals(PDAnnotationSquare.SUB_TYPE, actualPdAnnotationSquare.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationSquare#PDAnnotationSquare(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquare#PDAnnotationSquare(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquare(COSDictionary)")
  void testNewPDAnnotationSquare2() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationSquare actualPdAnnotationSquare = new PDAnnotationSquare(field);

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationSquare.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
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
    assertEquals(0, actualPdAnnotationSquare.getRectDifferences().length);
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationSquare.getConstantOpacity());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
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
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquare.getReplyType());
    assertSame(field, actualPdAnnotationSquare.getCOSObject());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationSquare#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationSquare.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationSquare.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationSquare.getAppearance();
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
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
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
    assertEquals(32L, normalAppearanceStream.getCOSObject().getLength());
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
    COSIncrement toIncrementResult = pdAnnotationSquare.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    byte[] byteArray = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, appearanceStream3.getContents().read(byteArray4));
    assertEquals(Integer.SIZE, contentsForStreamParsing.available());
    assertEquals(Integer.SIZE, contentsForStreamParsing2.available());
    assertEquals(Integer.SIZE, contentsForStreamParsing3.available());
    assertEquals(Integer.SIZE, contentsForStreamParsing4.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess2.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess3.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess4.available());
    assertEquals(Integer.SIZE, normalAppearanceStream.getStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream.getStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream2.getStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream3.getStream().getLength());
    assertEquals(Integer.SIZE, normalAppearanceStream.getContentStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream.getContentStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream2.getContentStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream3.getContentStream().getLength());
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationSquare#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationSquare.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationSquare.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationSquare.getAppearance();
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
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
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
    byte[] byteArray = new byte[31];
    assertEquals(31, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[31];
    assertEquals(31, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[31];
    assertEquals(31, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[31];
    assertEquals(31, appearanceStream3.getContents().read(byteArray4));
    assertEquals(31, contentsForStreamParsing.available());
    assertEquals(31, contentsForStreamParsing2.available());
    assertEquals(31, contentsForStreamParsing3.available());
    assertEquals(31, contentsForStreamParsing4.available());
    assertEquals(31, contentsForRandomAccess.available());
    assertEquals(31, contentsForRandomAccess2.available());
    assertEquals(31, contentsForRandomAccess3.available());
    assertEquals(31, contentsForRandomAccess4.available());
    assertEquals(31, normalAppearanceStream.getStream().getLength());
    assertEquals(31, appearanceStream.getStream().getLength());
    assertEquals(31, appearanceStream2.getStream().getLength());
    assertEquals(31, appearanceStream3.getStream().getLength());
    assertEquals(31, normalAppearanceStream.getContentStream().getLength());
    assertEquals(31, appearanceStream.getContentStream().getLength());
    assertEquals(31, appearanceStream2.getContentStream().getLength());
    assertEquals(31, appearanceStream3.getContentStream().getLength());
    assertEquals(31L, normalAppearanceStream.getCOSObject().getLength());
    COSIncrement toIncrementResult = pdAnnotationSquare.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquare#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationSquare.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationSquare.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationSquare.getAppearance();
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
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
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
    assertEquals(32L, normalAppearanceStream.getCOSObject().getLength());
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
    COSIncrement toIncrementResult = pdAnnotationSquare.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    byte[] byteArray = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[Integer.SIZE];
    assertEquals(Integer.SIZE, appearanceStream3.getContents().read(byteArray4));
    assertEquals(Integer.SIZE, contentsForStreamParsing.available());
    assertEquals(Integer.SIZE, contentsForStreamParsing2.available());
    assertEquals(Integer.SIZE, contentsForStreamParsing3.available());
    assertEquals(Integer.SIZE, contentsForStreamParsing4.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess2.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess3.available());
    assertEquals(Integer.SIZE, contentsForRandomAccess4.available());
    assertEquals(Integer.SIZE, normalAppearanceStream.getStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream.getStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream2.getStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream3.getStream().getLength());
    assertEquals(Integer.SIZE, normalAppearanceStream.getContentStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream.getContentStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream2.getContentStream().getLength());
    assertEquals(Integer.SIZE, appearanceStream3.getContentStream().getLength());
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0.5 0.5 2382.937 3369.3938 re\nn\n".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationSquare#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquare#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() throws IOException {
    // Arrange
    PDAnnotationSquare pdAnnotationSquare = new PDAnnotationSquare();
    pdAnnotationSquare.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationSquare.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationSquare.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationSquare.getAppearance();
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
    PDRectangle rectangle = pdAnnotationSquare.getRectangle();
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
    byte[] byteArray = new byte[31];
    assertEquals(31, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[31];
    assertEquals(31, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[31];
    assertEquals(31, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[31];
    assertEquals(31, appearanceStream3.getContents().read(byteArray4));
    assertEquals(31, contentsForStreamParsing.available());
    assertEquals(31, contentsForStreamParsing2.available());
    assertEquals(31, contentsForStreamParsing3.available());
    assertEquals(31, contentsForStreamParsing4.available());
    assertEquals(31, contentsForRandomAccess.available());
    assertEquals(31, contentsForRandomAccess2.available());
    assertEquals(31, contentsForRandomAccess3.available());
    assertEquals(31, contentsForRandomAccess4.available());
    assertEquals(31, normalAppearanceStream.getStream().getLength());
    assertEquals(31, appearanceStream.getStream().getLength());
    assertEquals(31, appearanceStream2.getStream().getLength());
    assertEquals(31, appearanceStream3.getStream().getLength());
    assertEquals(31, normalAppearanceStream.getContentStream().getLength());
    assertEquals(31, appearanceStream.getContentStream().getLength());
    assertEquals(31, appearanceStream2.getContentStream().getLength());
    assertEquals(31, appearanceStream3.getContentStream().getLength());
    assertEquals(31L, normalAppearanceStream.getCOSObject().getLength());
    COSIncrement toIncrementResult = pdAnnotationSquare.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("2147483648 2147483648 0 0 re\nn\n".getBytes("UTF-8"), byteArray);
  }
}
