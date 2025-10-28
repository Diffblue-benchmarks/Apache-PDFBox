package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationDiffblueTest {
  /**
   * Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  void testCreateAnnotation() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSBoolean.FALSE));
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSFloat.ONE));
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSInteger.ONE));
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSName.A));
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(new COSArray()));
    assertThrows(IOException.class,
        () -> PDAnnotation.createAnnotation(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDAnnotation#equals(Object)}
   *   <li>{@link PDAnnotation#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act and Assert
    assertEquals(pdAnnotationCaret, pdAnnotationCaret);
    int expectedHashCodeResult = pdAnnotationCaret.hashCode();
    assertEquals(expectedHashCodeResult, pdAnnotationCaret.hashCode());
  }

  /**
   * Method under test: {@link PDAnnotation#setSubtype(String)}
   */
  @Test
  void testSetSubtype() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setSubtype("Sub Type");

    // Assert
    assertEquals("Sub Type", pdAnnotationCaret.getSubtype());
  }

  /**
   * Method under test: {@link PDAnnotation#setSubtype(String)}
   */
  @Test
  void testSetSubtype2() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(field);

    // Act
    pdAnnotationCaret.setSubtype("Sub Type");

    // Assert
    assertEquals("Sub Type", pdAnnotationCaret.getSubtype());
    assertSame(field, pdAnnotationCaret.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#getSubtype()}
   */
  @Test
  void testGetSubtype() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationCaret.SUB_TYPE, (new PDAnnotationCaret()).getSubtype());
    assertNull((new PDAnnotationCaret(new COSDictionary())).getSubtype());
  }

  /**
   * Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  void testGetRectangle() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getRectangle());
  }

  /**
   * Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  void testGetRectangle2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = pdAnnotationCaret.getRectangle();

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
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  void testGetRectangle3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = pdAnnotationCaret.getRectangle();

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
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#getAnnotationFlags()}
   */
  @Test
  void testGetAnnotationFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationCaret()).getAnnotationFlags());
  }

  /**
   * Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  void testSetAnnotationFlags() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(1);

    // Assert
    assertEquals(1, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isHidden());
    assertFalse(pdAnnotationCaret.isNoRotate());
    assertFalse(pdAnnotationCaret.isNoView());
    assertFalse(pdAnnotationCaret.isNoZoom());
    assertFalse(pdAnnotationCaret.isPrinted());
    assertFalse(pdAnnotationCaret.isToggleNoView());
    assertTrue(pdAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  void testSetAnnotationFlags2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(-1810807491);

    // Assert
    assertEquals(-1810807491, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isHidden());
    assertTrue(pdAnnotationCaret.isInvisible());
    assertTrue(pdAnnotationCaret.isNoRotate());
    assertTrue(pdAnnotationCaret.isNoView());
    assertTrue(pdAnnotationCaret.isNoZoom());
    assertTrue(pdAnnotationCaret.isPrinted());
    assertTrue(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  void testSetAnnotationFlags3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(7);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(7, pdAnnotationCaret.getAnnotationFlags());
    assertFalse(pdAnnotationCaret.isNoRotate());
    assertFalse(pdAnnotationCaret.isNoView());
    assertFalse(pdAnnotationCaret.isNoZoom());
    assertFalse(pdAnnotationCaret.isToggleNoView());
    assertTrue(pdAnnotationCaret.isHidden());
    assertTrue(pdAnnotationCaret.isInvisible());
    assertTrue(pdAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link PDAnnotation#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDAnnotationCaret()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAnnotation#getAppearanceState()}
   */
  @Test
  void testGetAppearanceState() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getAppearanceState());
  }

  /**
   * Method under test: {@link PDAnnotation#setAppearanceState(String)}
   */
  @Test
  void testSetAppearanceState() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearanceState("As");

    // Assert
    COSName appearanceState = pdAnnotationCaret.getAppearanceState();
    assertEquals("As", appearanceState.getName());
    assertNull(appearanceState.getKey());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(appearanceState.isDirect());
    assertFalse(appearanceState.isEmpty());
  }

  /**
   * Method under test: {@link PDAnnotation#setAppearanceState(String)}
   */
  @Test
  void testSetAppearanceState2() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(field);

    // Act
    pdAnnotationCaret.setAppearanceState("As");

    // Assert
    COSName appearanceState = pdAnnotationCaret.getAppearanceState();
    assertEquals("As", appearanceState.getName());
    assertNull(appearanceState.getKey());
    assertFalse(appearanceState.isDirect());
    assertFalse(appearanceState.isEmpty());
    assertSame(field, pdAnnotationCaret.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  void testGetAppearance() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getAppearance());
  }

  /**
   * Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  void testGetAppearance2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Act
    PDAppearanceDictionary actualAppearance = pdAnnotationCaret.getAppearance();

    // Assert
    COSDictionary cOSObject = actualAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDAppearanceEntry downAppearance = actualAppearance.getDownAppearance();
    COSDictionary cOSObject2 = downAppearance.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualAppearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualAppearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
    assertSame(cOSObject2, normalAppearance.getCOSObject());
    assertSame(cOSObject2, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  void testGetAppearance3() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act
    PDAppearanceDictionary actualAppearance = pdAnnotationCaret.getAppearance();

    // Assert
    assertNull(actualAppearance.getDownAppearance());
    assertNull(actualAppearance.getNormalAppearance());
    assertNull(actualAppearance.getRolloverAppearance());
    assertSame(dictionary, actualAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  void testSetAppearance() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  void testSetAppearance2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearance(null);

    // Assert
    assertNull(pdAnnotationCaret.getAppearance());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  void testSetAppearance3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(dictionary));

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    assertNull(appearance.getDownAppearance());
    assertNull(appearance.getNormalAppearance());
    assertNull(appearance.getRolloverAppearance());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(dictionary, appearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  void testSetAppearance4() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(dictionary));

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    assertNull(appearance.getDownAppearance());
    assertNull(appearance.getNormalAppearance());
    assertNull(appearance.getRolloverAppearance());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(dictionary, appearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  void testGetNormalAppearanceStream() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getNormalAppearanceStream());
  }

  /**
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  void testGetNormalAppearanceStream2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  void testGetNormalAppearanceStream3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  void testGetNormalAppearanceStream4() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act
    PDAppearanceStream actualNormalAppearanceStream = pdAnnotationCaret.getNormalAppearanceStream();

    // Assert
    PDStream stream2 = actualNormalAppearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = actualNormalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(actualNormalAppearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualNormalAppearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualNormalAppearanceStream.getOptionalContent());
    assertNull(actualNormalAppearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualNormalAppearanceStream.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualNormalAppearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualNormalAppearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, actualNormalAppearanceStream.getCOSObject());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  void testGetNormalAppearanceStream5() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Method under test: {@link PDAnnotation#isInvisible()}
   */
  @Test
  void testIsInvisible() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isInvisible());
  }

  /**
   * Method under test: {@link PDAnnotation#setInvisible(boolean)}
   */
  @Test
  void testSetInvisible() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setInvisible(true);

    // Assert
    assertEquals(1, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link PDAnnotation#setInvisible(boolean)}
   */
  @Test
  void testSetInvisible2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setInvisible(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link PDAnnotation#isHidden()}
   */
  @Test
  void testIsHidden() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isHidden());
  }

  /**
   * Method under test: {@link PDAnnotation#setHidden(boolean)}
   */
  @Test
  void testSetHidden() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setHidden(true);

    // Assert
    assertEquals(2, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link PDAnnotation#setHidden(boolean)}
   */
  @Test
  void testSetHidden2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setHidden(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link PDAnnotation#isPrinted()}
   */
  @Test
  void testIsPrinted() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isPrinted());
  }

  /**
   * Method under test: {@link PDAnnotation#setPrinted(boolean)}
   */
  @Test
  void testSetPrinted() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(4, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link PDAnnotation#setPrinted(boolean)}
   */
  @Test
  void testSetPrinted2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPrinted(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link PDAnnotation#isNoZoom()}
   */
  @Test
  void testIsNoZoom() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isNoZoom());
  }

  /**
   * Method under test: {@link PDAnnotation#setNoZoom(boolean)}
   */
  @Test
  void testSetNoZoom() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(8, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link PDAnnotation#setNoZoom(boolean)}
   */
  @Test
  void testSetNoZoom2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoZoom(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link PDAnnotation#isNoRotate()}
   */
  @Test
  void testIsNoRotate() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isNoRotate());
  }

  /**
   * Method under test: {@link PDAnnotation#setNoRotate(boolean)}
   */
  @Test
  void testSetNoRotate() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isNoRotate());
    assertEquals(Short.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Method under test: {@link PDAnnotation#setNoRotate(boolean)}
   */
  @Test
  void testSetNoRotate2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoRotate(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoRotate());
  }

  /**
   * Method under test: {@link PDAnnotation#isNoView()}
   */
  @Test
  void testIsNoView() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isNoView());
  }

  /**
   * Method under test: {@link PDAnnotation#setNoView(boolean)}
   */
  @Test
  void testSetNoView() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isNoView());
    assertEquals(Integer.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Method under test: {@link PDAnnotation#setNoView(boolean)}
   */
  @Test
  void testSetNoView2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoView(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link PDAnnotation#isReadOnly()}
   */
  @Test
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isReadOnly());
  }

  /**
   * Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  void testSetReadOnly() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isReadOnly());
    assertEquals(Double.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  void testSetReadOnly2() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(field);

    // Act
    pdAnnotationCaret.setReadOnly(true);

    // Assert
    assertTrue(pdAnnotationCaret.isReadOnly());
    assertEquals(Double.SIZE, pdAnnotationCaret.getAnnotationFlags());
    assertSame(field, pdAnnotationCaret.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  void testSetReadOnly3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setReadOnly(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isReadOnly());
  }

  /**
   * Method under test: {@link PDAnnotation#isLocked()}
   */
  @Test
  void testIsLocked() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isLocked());
  }

  /**
   * Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLocked(true);

    // Assert
    assertEquals(128, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked2() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(field);

    // Act
    pdAnnotationCaret.setLocked(true);

    // Assert
    assertEquals(128, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isLocked());
    assertSame(field, pdAnnotationCaret.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLocked(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link PDAnnotation#isToggleNoView()}
   */
  @Test
  void testIsToggleNoView() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isToggleNoView());
  }

  /**
   * Method under test: {@link PDAnnotation#setToggleNoView(boolean)}
   */
  @Test
  void testSetToggleNoView() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setToggleNoView(true);

    // Assert
    assertEquals(256, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link PDAnnotation#setToggleNoView(boolean)}
   */
  @Test
  void testSetToggleNoView2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setToggleNoView(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link PDAnnotation#isLockedContents()}
   */
  @Test
  void testIsLockedContents() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationCaret()).isLockedContents());
  }

  /**
   * Method under test: {@link PDAnnotation#setLockedContents(boolean)}
   */
  @Test
  void testSetLockedContents() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLockedContents(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(512, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isLockedContents());
  }

  /**
   * Method under test: {@link PDAnnotation#setLockedContents(boolean)}
   */
  @Test
  void testSetLockedContents2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLockedContents(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isLockedContents());
  }

  /**
   * Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  void testGetContents() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getContents());
  }

  /**
   * Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  void testGetContents2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setContents("42");

    // Act and Assert
    assertEquals("42", pdAnnotationCaret.getContents());
  }

  /**
   * Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  void testGetContents3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setContents("");

    // Act and Assert
    assertEquals("", pdAnnotationCaret.getContents());
  }

  /**
   * Method under test: {@link PDAnnotation#setContents(String)}
   */
  @Test
  void testSetContents() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setContents("42");

    // Assert
    assertEquals("42", pdAnnotationCaret.getContents());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#getModifiedDate()}
   */
  @Test
  void testGetModifiedDate() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getModifiedDate());
  }

  /**
   * Method under test: {@link PDAnnotation#setModifiedDate(String)}
   */
  @Test
  void testSetModifiedDate() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate("foo");

    // Assert
    assertEquals("foo", pdAnnotationCaret.getModifiedDate());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  void testSetModifiedDate2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate(new GregorianCalendar(1, 1, 1));

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  void testSetModifiedDate3() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(field);

    // Act
    pdAnnotationCaret.setModifiedDate(new GregorianCalendar(1, 1, 1));

    // Assert
    assertSame(field, pdAnnotationCaret.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  void testSetModifiedDate4() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate((Calendar) null);

    // Assert
    assertNull(pdAnnotationCaret.getModifiedDate());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#getAnnotationName()}
   */
  @Test
  void testGetAnnotationName() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getAnnotationName());
  }

  /**
   * Method under test: {@link PDAnnotation#setAnnotationName(String)}
   */
  @Test
  void testSetAnnotationName() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationName("Nm");

    // Assert
    assertEquals("Nm", pdAnnotationCaret.getAnnotationName());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#getStructParent()}
   */
  @Test
  void testGetStructParent() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDAnnotationCaret()).getStructParent());
  }

  /**
   * Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  void testSetStructParent() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(1);

    // Assert
    assertEquals(1, pdAnnotationCaret.getStructParent());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  void testSetStructParent2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(-1810807491);

    // Assert
    assertEquals(-1810807491, pdAnnotationCaret.getStructParent());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  void testSetStructParent3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(9);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(9, pdAnnotationCaret.getStructParent());
  }

  /**
   * Method under test: {@link PDAnnotation#getOptionalContent()}
   */
  @Test
  void testGetOptionalContent() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    COSDictionary cosDictionary = new COSDictionary();
    when(field.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    COSDictionary actualCOSObject = (new PDAnnotationCaret(field)).getOptionalContent().getCOSObject();

    // Assert
    verify(field).getCOSDictionary(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    assertSame(cosDictionary, actualCOSObject);
  }

  /**
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDPropertyList oc = mock(PDPropertyList.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSInteger);
    assertTrue(toListResult.get(2) instanceof COSInteger);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cosDictionary, pdAnnotationCaret.getOptionalContent().getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSInteger);
    assertTrue(toListResult.get(2) instanceof COSInteger);
    assertNull(pdAnnotationCaret.getOptionalContent());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSInteger);
    assertTrue(toListResult.get(2) instanceof COSInteger);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cosDictionary, pdAnnotationCaret.getOptionalContent().getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent4() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setKey(new COSObjectKey(1L, 1));
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSInteger);
    assertTrue(toListResult.get(2) instanceof COSInteger);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cosDictionary, pdAnnotationCaret.getOptionalContent().getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  void testSetBorder() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setBorder(new COSArray());

    // Assert
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  void testSetBorder2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setBorder(null);

    // Assert
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertTrue(toListResult.get(2) instanceof COSInteger);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  void testSetColor() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor color = pdAnnotationCaret.getColor();
    assertNull(color.getPatternName());
    assertNull(color.getColorSpace());
    assertEquals(0, color.getComponents().length);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(color.isPattern());
  }

  /**
   * Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  void testSetColor2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationCaret.setColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor color = pdAnnotationCaret.getColor();
    assertNull(color.getPatternName());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(color.isPattern());
    assertArrayEquals(new float[]{0.0f}, color.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  void testSetColor3() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationCaret.setColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor color = pdAnnotationCaret.getColor();
    assertNull(color.getPatternName());
    assertNull(color.getColorSpace());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(color.isPattern());
    assertArrayEquals(new float[]{0.0f, 0.0f}, color.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  void testSetColor4() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdAnnotationCaret.setColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor color = pdAnnotationCaret.getColor();
    assertNull(color.getColorSpace());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(color.isPattern());
    assertArrayEquals(new float[]{0.0f}, color.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#getColor()}
   */
  @Test
  void testGetColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getColor());
    assertNull((new PDAnnotationCaret()).getColor(COSName.A));
    assertNull((new PDAnnotationCaret()).getColor(null));
  }

  /**
   * Method under test: {@link PDAnnotation#setPage(PDPage)}
   */
  @Test
  void testSetPage() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPage(null);

    // Assert
    assertNull(pdAnnotationCaret.getPage());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAnnotation#getPage()}
   */
  @Test
  void testGetPage() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationCaret()).getPage());
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  void testConstructAppearances() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.constructAppearances();

    // Assert
    assertNull(pdAnnotationFileAttachment.getRectangle());
    assertNull(pdAnnotationFileAttachment.getAppearance());
    assertNull(pdAnnotationFileAttachment.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    COSArray cOSArray = rectDifference.getCOSArray();
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
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
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
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
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
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.5f, rectDifference.getLowerLeftX());
    assertEquals(0.5f, rectDifference.getLowerLeftY());
    assertEquals(0.5f, rectDifference.getUpperRightX());
    assertEquals(0.5f, rectDifference.getUpperRightY());
    assertEquals(0.5f, matrix.getTranslateX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(231, contentsForStreamParsing.available());
    assertEquals(231, contentsForStreamParsing2.available());
    assertEquals(231, contentsForStreamParsing3.available());
    assertEquals(231, contentsForStreamParsing4.available());
    assertEquals(231, contentsForRandomAccess.available());
    assertEquals(231, contentsForRandomAccess2.available());
    assertEquals(231, contentsForRandomAccess3.available());
    assertEquals(231, contentsForRandomAccess4.available());
    assertEquals(231, stream.getLength());
    assertEquals(231, stream2.getLength());
    assertEquals(231, stream3.getLength());
    assertEquals(231, stream4.getLength());
    assertEquals(231, contentStream.getLength());
    assertEquals(231, contentStream2.getLength());
    assertEquals(231, contentStream3.getLength());
    assertEquals(231, contentStream4.getLength());
    assertEquals(231L, cOSObject.getLength());
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
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
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
    COSDictionary cOSObject4 = pdAnnotationCircle.getCOSObject();
    assertEquals(5, cOSObject4.getValues().size());
    assertEquals(5, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFileAttachment.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFileAttachment.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
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
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(18.0f, bBox.getHeight());
    assertEquals(18.0f, bBox2.getHeight());
    assertEquals(18.0f, bBox3.getHeight());
    assertEquals(18.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getUpperRightY());
    assertEquals(18.0f, bBox2.getUpperRightY());
    assertEquals(18.0f, bBox3.getUpperRightY());
    assertEquals(18.0f, bBox4.getUpperRightY());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject4 = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(804, contentsForStreamParsing.available());
    assertEquals(804, contentsForStreamParsing2.available());
    assertEquals(804, contentsForStreamParsing3.available());
    assertEquals(804, contentsForStreamParsing4.available());
    assertEquals(804, contentsForRandomAccess.available());
    assertEquals(804, contentsForRandomAccess2.available());
    assertEquals(804, contentsForRandomAccess3.available());
    assertEquals(804, contentsForRandomAccess4.available());
    assertEquals(804, stream.getLength());
    assertEquals(804, stream2.getLength());
    assertEquals(804, stream3.getLength());
    assertEquals(804, stream4.getLength());
    assertEquals(804, contentStream.getLength());
    assertEquals(804, contentStream2.getLength());
    assertEquals(804, contentStream3.getLength());
    assertEquals(804, contentStream4.getLength());
    assertEquals(804L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadWriteBuffer);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    List<COSName> filters2 = stream.getFilters();
    assertEquals(1, filters2.size());
    List<COSName> filters3 = stream2.getFilters();
    assertEquals(1, filters3.size());
    List<COSName> filters4 = stream3.getFilters();
    assertEquals(1, filters4.size());
    List<COSName> filters5 = stream4.getFilters();
    assertEquals(1, filters5.size());
    List<COSName> filters6 = contentStream.getFilters();
    assertEquals(1, filters6.size());
    List<COSName> filters7 = contentStream2.getFilters();
    assertEquals(1, filters7.size());
    List<COSName> filters8 = contentStream3.getFilters();
    assertEquals(1, filters8.size());
    List<COSName> filters9 = contentStream4.getFilters();
    assertEquals(1, filters9.size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    COSDictionary cOSObject4 = pdAnnotationFreeText.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(69, stream.getLength());
    assertEquals(69, stream2.getLength());
    assertEquals(69, stream3.getLength());
    assertEquals(69, stream4.getLength());
    assertEquals(69, contentStream.getLength());
    assertEquals(69, contentStream2.getLength());
    assertEquals(69, contentStream3.getLength());
    assertEquals(69, contentStream4.getLength());
    assertEquals(69L, cOSObject.getLength());
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertSame(filters, filters2.get(0));
    assertSame(filters, filters3.get(0));
    assertSame(filters, filters4.get(0));
    assertSame(filters, filters5.get(0));
    assertSame(filters, filters6.get(0));
    assertSame(filters, filters7.get(0));
    assertSame(filters, filters8.get(0));
    assertSame(filters, filters9.get(0));
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  void testConstructAppearances5() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationCircle.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    COSArray cOSArray = rectDifference.getCOSArray();
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
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationCircle.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
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
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    assertEquals(0, cOSObject2.size());
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
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
    assertEquals(0.0f, rectangle.getWidth());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.5f, rectDifference.getLowerLeftX());
    assertEquals(0.5f, rectDifference.getLowerLeftY());
    assertEquals(0.5f, rectDifference.getUpperRightX());
    assertEquals(0.5f, rectDifference.getUpperRightY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
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
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(300, contentsForStreamParsing.available());
    assertEquals(300, contentsForStreamParsing2.available());
    assertEquals(300, contentsForStreamParsing3.available());
    assertEquals(300, contentsForStreamParsing4.available());
    assertEquals(300, contentsForRandomAccess.available());
    assertEquals(300, contentsForRandomAccess2.available());
    assertEquals(300, contentsForRandomAccess3.available());
    assertEquals(300, contentsForRandomAccess4.available());
    assertEquals(300, stream.getLength());
    assertEquals(300, stream2.getLength());
    assertEquals(300, stream3.getLength());
    assertEquals(300, stream4.getLength());
    assertEquals(300, contentStream.getLength());
    assertEquals(300, contentStream2.getLength());
    assertEquals(300, contentStream3.getLength());
    assertEquals(300, contentStream4.getLength());
    assertEquals(300L, cOSObject.getLength());
    COSDictionary cOSObject4 = pdAnnotationCircle.getCOSObject();
    assertEquals(5, cOSObject4.getValues().size());
    assertEquals(5, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("2147483648 2147483648 m\n2147483648 2147483648 21474".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-2.14748365E9f, -2.14748365E9f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances6() throws IOException {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationMarkup.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances7() throws IOException {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances8() throws IOException {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances9() throws IOException {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances10() throws IOException {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances11() throws IOException {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances12() throws IOException {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act and Assert
    assertNotEquals(pdAnnotationCaret, new PDAnnotationCaret());
  }

  /**
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDAnnotationCircle pdAnnotationCircle = mock(PDAnnotationCircle.class);
    when(pdAnnotationCircle.getCOSObject()).thenReturn(new COSDictionary());

    // Act and Assert
    assertNotEquals(pdAnnotationCaret, pdAnnotationCircle);
  }

  /**
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDAnnotationCaret(), null);
  }

  /**
   * Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDAnnotationCaret(), "Different type to PDAnnotation");
  }
}
