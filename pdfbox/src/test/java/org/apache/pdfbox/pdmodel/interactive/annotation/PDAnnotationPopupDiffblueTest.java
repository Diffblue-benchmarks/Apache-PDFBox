package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationPopupDiffblueTest {
  /**
   * Test {@link PDAnnotationPopup#PDAnnotationPopup()}.
   * <p>
   * Method under test: {@link PDAnnotationPopup#PDAnnotationPopup()}
   */
  @Test
  @DisplayName("Test new PDAnnotationPopup()")
  void testNewPDAnnotationPopup() {
    // Arrange and Act
    PDAnnotationPopup actualPdAnnotationPopup = new PDAnnotationPopup();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationPopup.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationPopup.getAnnotationName());
    assertNull(actualPdAnnotationPopup.getContents());
    assertNull(actualPdAnnotationPopup.getModifiedDate());
    COSDictionary cOSObject = actualPdAnnotationPopup.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationPopup.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationPopup.getPage());
    assertNull(actualPdAnnotationPopup.getRectangle());
    assertNull(actualPdAnnotationPopup.getOptionalContent());
    assertNull(actualPdAnnotationPopup.getColor());
    assertNull(actualPdAnnotationPopup.getParent());
    assertNull(actualPdAnnotationPopup.getAppearance());
    assertNull(actualPdAnnotationPopup.getNormalAppearanceStream());
    assertEquals(-1, actualPdAnnotationPopup.getStructParent());
    assertEquals(0, actualPdAnnotationPopup.getAnnotationFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationPopup.isHidden());
    assertFalse(actualPdAnnotationPopup.isInvisible());
    assertFalse(actualPdAnnotationPopup.isLocked());
    assertFalse(actualPdAnnotationPopup.isLockedContents());
    assertFalse(actualPdAnnotationPopup.isNoRotate());
    assertFalse(actualPdAnnotationPopup.isNoView());
    assertFalse(actualPdAnnotationPopup.isNoZoom());
    assertFalse(actualPdAnnotationPopup.isPrinted());
    assertFalse(actualPdAnnotationPopup.isReadOnly());
    assertFalse(actualPdAnnotationPopup.isToggleNoView());
    assertFalse(actualPdAnnotationPopup.getOpen());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationPopup.SUB_TYPE, actualPdAnnotationPopup.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationPopup#PDAnnotationPopup(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#PDAnnotationPopup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationPopup(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  void testNewPDAnnotationPopup_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationPopup actualPdAnnotationPopup = new PDAnnotationPopup(field);

    // Assert
    assertEquals(1, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationPopup.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationPopup.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationPopup#PDAnnotationPopup(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#PDAnnotationPopup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationPopup(COSDictionary); when COSStream(); then COSStream() size is two")
  void testNewPDAnnotationPopup_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationPopup actualPdAnnotationPopup = new PDAnnotationPopup(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationPopup.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationPopup.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationPopup#setOpen(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDAnnotationPopup#PDAnnotationPopup()} Open.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then not PDAnnotationPopup() Open")
  void testSetOpen_whenFalse_thenNotPDAnnotationPopupOpen() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setOpen(false);

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationPopup.getOpen());
  }

  /**
   * Test {@link PDAnnotationPopup#setOpen(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationPopup#PDAnnotationPopup()} Open.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then PDAnnotationPopup() Open")
  void testSetOpen_whenTrue_thenPDAnnotationPopupOpen() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setOpen(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationPopup.getOpen());
  }

  /**
   * Test {@link PDAnnotationPopup#getOpen()}.
   * <ul>
   *   <li>Given {@link PDAnnotationPopup#PDAnnotationPopup()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen(); given PDAnnotationPopup()")
  void testGetOpen_givenPDAnnotationPopup() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationPopup()).getOpen());
  }

  /**
   * Test {@link PDAnnotationPopup#getOpen()}.
   * <ul>
   *   <li>Given {@link PDAnnotationPopup#PDAnnotationPopup()} Rectangle is
   * {@link PDRectangle#A1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen(); given PDAnnotationPopup() Rectangle is A1")
  void testGetOpen_givenPDAnnotationPopupRectangleIsA1() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();
    pdAnnotationPopup.setRectangle(PDRectangle.A1);

    // Act and Assert
    assertFalse(pdAnnotationPopup.getOpen());
  }

  /**
   * Test {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  @DisplayName("Test setParent(PDAnnotationMarkup); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetParent_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup(dict));

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  @DisplayName("Test setParent(PDAnnotationMarkup); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetParent_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup(dict));

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}.
   * <ul>
   *   <li>When {@link PDAnnotationMarkup#PDAnnotationMarkup()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPopup#setParent(PDAnnotationMarkup)}
   */
  @Test
  @DisplayName("Test setParent(PDAnnotationMarkup); when PDAnnotationMarkup()")
  void testSetParent_whenPDAnnotationMarkup() {
    // Arrange
    PDAnnotationPopup pdAnnotationPopup = new PDAnnotationPopup();

    // Act
    pdAnnotationPopup.setParent(new PDAnnotationMarkup());

    // Assert
    COSDictionary cOSObject = pdAnnotationPopup.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPopup#getParent()}.
   * <p>
   * Method under test: {@link PDAnnotationPopup#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPopup()).getParent());
  }
}
