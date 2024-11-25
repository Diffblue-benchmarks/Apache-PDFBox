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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationTextMarkupDiffblueTest {
  /**
   * Test {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Subtype is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}
   */
  @Test
  @DisplayName("Test new PDAnnotationTextMarkup(String); when '42'; then return Subtype is '42'")
  void testNewPDAnnotationTextMarkup_when42_thenReturnSubtypeIs42() throws IOException {
    // Arrange and Act
    PDAnnotationTextMarkup actualPdAnnotationTextMarkup = new PDAnnotationTextMarkup("42");

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationTextMarkup.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertEquals("42", actualPdAnnotationTextMarkup.getSubtype());
    assertNull(actualPdAnnotationTextMarkup.getAnnotationName());
    assertNull(actualPdAnnotationTextMarkup.getContents());
    assertNull(actualPdAnnotationTextMarkup.getModifiedDate());
    assertNull(actualPdAnnotationTextMarkup.getIntent());
    assertNull(actualPdAnnotationTextMarkup.getRichContents());
    assertNull(actualPdAnnotationTextMarkup.getSubject());
    assertNull(actualPdAnnotationTextMarkup.getTitlePopup());
    assertNull(actualPdAnnotationTextMarkup.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationTextMarkup.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationTextMarkup.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationTextMarkup.getPage());
    assertNull(actualPdAnnotationTextMarkup.getRectangle());
    assertNull(actualPdAnnotationTextMarkup.getOptionalContent());
    assertNull(actualPdAnnotationTextMarkup.getColor());
    assertNull(actualPdAnnotationTextMarkup.getInReplyTo());
    assertNull(actualPdAnnotationTextMarkup.getPopup());
    assertNull(actualPdAnnotationTextMarkup.getAppearance());
    assertNull(actualPdAnnotationTextMarkup.getNormalAppearanceStream());
    assertNull(actualPdAnnotationTextMarkup.getBorderStyle());
    assertNull(actualPdAnnotationTextMarkup.getExternalData());
    assertEquals(-1, actualPdAnnotationTextMarkup.getStructParent());
    assertEquals(0, actualPdAnnotationTextMarkup.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationTextMarkup.getQuadPoints().length);
    assertEquals(1.0f, actualPdAnnotationTextMarkup.getConstantOpacity());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationTextMarkup.isHidden());
    assertFalse(actualPdAnnotationTextMarkup.isInvisible());
    assertFalse(actualPdAnnotationTextMarkup.isLocked());
    assertFalse(actualPdAnnotationTextMarkup.isLockedContents());
    assertFalse(actualPdAnnotationTextMarkup.isNoRotate());
    assertFalse(actualPdAnnotationTextMarkup.isNoView());
    assertFalse(actualPdAnnotationTextMarkup.isNoZoom());
    assertFalse(actualPdAnnotationTextMarkup.isPrinted());
    assertFalse(actualPdAnnotationTextMarkup.isReadOnly());
    assertFalse(actualPdAnnotationTextMarkup.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationTextMarkup.getReplyType());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationTextMarkup(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  void testNewPDAnnotationTextMarkup_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationTextMarkup actualPdAnnotationTextMarkup = new PDAnnotationTextMarkup(field);

    // Assert
    assertEquals(1, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationTextMarkup.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationTextMarkup.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationTextMarkup(COSDictionary); when COSStream(); then COSStream() size is two")
  void testNewPDAnnotationTextMarkup_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationTextMarkup actualPdAnnotationTextMarkup = new PDAnnotationTextMarkup(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationTextMarkup.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationTextMarkup.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}.
   * <ul>
   *   <li>When {@code Sub Type}.</li>
   *   <li>Then return {@code Sub Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationTextMarkup#PDAnnotationTextMarkup(String)}
   */
  @Test
  @DisplayName("Test new PDAnnotationTextMarkup(String); when 'Sub Type'; then return 'Sub Type'")
  void testNewPDAnnotationTextMarkup_whenSubType_thenReturnSubType() throws IOException {
    // Arrange and Act
    PDAnnotationTextMarkup actualPdAnnotationTextMarkup = new PDAnnotationTextMarkup("Sub Type");

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationTextMarkup.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertEquals("Sub Type", actualPdAnnotationTextMarkup.getSubtype());
    assertNull(actualPdAnnotationTextMarkup.getAnnotationName());
    assertNull(actualPdAnnotationTextMarkup.getContents());
    assertNull(actualPdAnnotationTextMarkup.getModifiedDate());
    assertNull(actualPdAnnotationTextMarkup.getIntent());
    assertNull(actualPdAnnotationTextMarkup.getRichContents());
    assertNull(actualPdAnnotationTextMarkup.getSubject());
    assertNull(actualPdAnnotationTextMarkup.getTitlePopup());
    assertNull(actualPdAnnotationTextMarkup.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationTextMarkup.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationTextMarkup.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationTextMarkup.getPage());
    assertNull(actualPdAnnotationTextMarkup.getRectangle());
    assertNull(actualPdAnnotationTextMarkup.getOptionalContent());
    assertNull(actualPdAnnotationTextMarkup.getColor());
    assertNull(actualPdAnnotationTextMarkup.getInReplyTo());
    assertNull(actualPdAnnotationTextMarkup.getPopup());
    assertNull(actualPdAnnotationTextMarkup.getAppearance());
    assertNull(actualPdAnnotationTextMarkup.getNormalAppearanceStream());
    assertNull(actualPdAnnotationTextMarkup.getBorderStyle());
    assertNull(actualPdAnnotationTextMarkup.getExternalData());
    assertEquals(-1, actualPdAnnotationTextMarkup.getStructParent());
    assertEquals(0, actualPdAnnotationTextMarkup.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationTextMarkup.getQuadPoints().length);
    assertEquals(1.0f, actualPdAnnotationTextMarkup.getConstantOpacity());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationTextMarkup.isHidden());
    assertFalse(actualPdAnnotationTextMarkup.isInvisible());
    assertFalse(actualPdAnnotationTextMarkup.isLocked());
    assertFalse(actualPdAnnotationTextMarkup.isLockedContents());
    assertFalse(actualPdAnnotationTextMarkup.isNoRotate());
    assertFalse(actualPdAnnotationTextMarkup.isNoView());
    assertFalse(actualPdAnnotationTextMarkup.isNoZoom());
    assertFalse(actualPdAnnotationTextMarkup.isPrinted());
    assertFalse(actualPdAnnotationTextMarkup.isReadOnly());
    assertFalse(actualPdAnnotationTextMarkup.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationTextMarkup.getReplyType());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationTextMarkup#setQuadPoints(float[])}.
   * <p>
   * Method under test: {@link PDAnnotationTextMarkup#setQuadPoints(float[])}
   */
  @Test
  @DisplayName("Test setQuadPoints(float[])")
  void testSetQuadPoints() {
    // Arrange
    PDAnnotationTextMarkup pdAnnotationTextMarkup = new PDAnnotationTextMarkup("Sub Type");

    // Act
    pdAnnotationTextMarkup.setQuadPoints(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationTextMarkup.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationTextMarkup#getQuadPoints()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationTextMarkup#getQuadPoints()}
   */
  @Test
  @DisplayName("Test getQuadPoints(); then return array length is zero")
  void testGetQuadPoints_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationTextMarkup("Sub Type")).getQuadPoints().length);
  }

  /**
   * Test {@link PDAnnotationTextMarkup#getQuadPoints()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationTextMarkup#getQuadPoints()}
   */
  @Test
  @DisplayName("Test getQuadPoints(); then return 'null'")
  void testGetQuadPoints_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationTextMarkup(new COSDictionary())).getQuadPoints());
  }
}
