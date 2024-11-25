package org.apache.pdfbox.pdmodel.interactive.annotation;

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

class PDAnnotationRubberStampDiffblueTest {
  /**
   * Test {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()}.
   * <p>
   * Method under test: {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()}
   */
  @Test
  @DisplayName("Test new PDAnnotationRubberStamp()")
  void testNewPDAnnotationRubberStamp() throws IOException {
    // Arrange and Act
    PDAnnotationRubberStamp actualPdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationRubberStamp.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationRubberStamp.getAnnotationName());
    assertNull(actualPdAnnotationRubberStamp.getContents());
    assertNull(actualPdAnnotationRubberStamp.getModifiedDate());
    assertNull(actualPdAnnotationRubberStamp.getIntent());
    assertNull(actualPdAnnotationRubberStamp.getRichContents());
    assertNull(actualPdAnnotationRubberStamp.getSubject());
    assertNull(actualPdAnnotationRubberStamp.getTitlePopup());
    assertNull(actualPdAnnotationRubberStamp.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationRubberStamp.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationRubberStamp.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationRubberStamp.getPage());
    assertNull(actualPdAnnotationRubberStamp.getRectangle());
    assertNull(actualPdAnnotationRubberStamp.getOptionalContent());
    assertNull(actualPdAnnotationRubberStamp.getColor());
    assertNull(actualPdAnnotationRubberStamp.getInReplyTo());
    assertNull(actualPdAnnotationRubberStamp.getPopup());
    assertNull(actualPdAnnotationRubberStamp.getAppearance());
    assertNull(actualPdAnnotationRubberStamp.getNormalAppearanceStream());
    assertNull(actualPdAnnotationRubberStamp.getBorderStyle());
    assertNull(actualPdAnnotationRubberStamp.getExternalData());
    assertEquals(-1, actualPdAnnotationRubberStamp.getStructParent());
    assertEquals(0, actualPdAnnotationRubberStamp.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationRubberStamp.getConstantOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationRubberStamp.isHidden());
    assertFalse(actualPdAnnotationRubberStamp.isInvisible());
    assertFalse(actualPdAnnotationRubberStamp.isLocked());
    assertFalse(actualPdAnnotationRubberStamp.isLockedContents());
    assertFalse(actualPdAnnotationRubberStamp.isNoRotate());
    assertFalse(actualPdAnnotationRubberStamp.isNoView());
    assertFalse(actualPdAnnotationRubberStamp.isNoZoom());
    assertFalse(actualPdAnnotationRubberStamp.isPrinted());
    assertFalse(actualPdAnnotationRubberStamp.isReadOnly());
    assertFalse(actualPdAnnotationRubberStamp.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationRubberStamp.getReplyType());
    assertEquals(PDAnnotationRubberStamp.NAME_DRAFT, actualPdAnnotationRubberStamp.getName());
    assertEquals(PDAnnotationRubberStamp.SUB_TYPE, actualPdAnnotationRubberStamp.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationRubberStamp(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  void testNewPDAnnotationRubberStamp_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationRubberStamp actualPdAnnotationRubberStamp = new PDAnnotationRubberStamp(field);

    // Assert
    assertEquals(1, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationRubberStamp.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationRubberStamp.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationRubberStamp(COSDictionary); when COSStream(); then COSStream() size is two")
  void testNewPDAnnotationRubberStamp_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationRubberStamp actualPdAnnotationRubberStamp = new PDAnnotationRubberStamp(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationRubberStamp.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationRubberStamp.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationRubberStamp#setName(String)}.
   * <ul>
   *   <li>When {@code NameName}.</li>
   *   <li>Then {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()} Name is
   * {@code NameName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationRubberStamp#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'NameName'; then PDAnnotationRubberStamp() Name is 'NameName'")
  void testSetName_whenNameName_thenPDAnnotationRubberStampNameIsNameName() {
    // Arrange
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Act
    pdAnnotationRubberStamp.setName("NameName");

    // Assert
    assertEquals("NameName", pdAnnotationRubberStamp.getName());
    COSDictionary cOSObject = pdAnnotationRubberStamp.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationRubberStamp#setName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDAnnotationRubberStamp#PDAnnotationRubberStamp()} Name is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationRubberStamp#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then PDAnnotationRubberStamp() Name is 'Name'")
  void testSetName_whenName_thenPDAnnotationRubberStampNameIsName() {
    // Arrange
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Act
    pdAnnotationRubberStamp.setName("Name");

    // Assert
    assertEquals("Name", pdAnnotationRubberStamp.getName());
    COSDictionary cOSObject = pdAnnotationRubberStamp.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationRubberStamp#getName()}.
   * <p>
   * Method under test: {@link PDAnnotationRubberStamp#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationRubberStamp.NAME_DRAFT, (new PDAnnotationRubberStamp()).getName());
  }
}
