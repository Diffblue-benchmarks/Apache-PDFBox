package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationFreeTextDiffblueTest {
  /**
   * Test {@link PDAnnotationFreeText#PDAnnotationFreeText()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#PDAnnotationFreeText()}
   */
  @Test
  @DisplayName("Test new PDAnnotationFreeText()")
  void testNewPDAnnotationFreeText() throws IOException {
    // Arrange and Act
    PDAnnotationFreeText actualPdAnnotationFreeText = new PDAnnotationFreeText();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationFreeText.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationFreeText.getCallout());
    assertNull(actualPdAnnotationFreeText.getAnnotationName());
    assertNull(actualPdAnnotationFreeText.getContents());
    assertNull(actualPdAnnotationFreeText.getModifiedDate());
    assertNull(actualPdAnnotationFreeText.getDefaultAppearance());
    assertNull(actualPdAnnotationFreeText.getDefaultStyleString());
    assertNull(actualPdAnnotationFreeText.getIntent());
    assertNull(actualPdAnnotationFreeText.getRichContents());
    assertNull(actualPdAnnotationFreeText.getSubject());
    assertNull(actualPdAnnotationFreeText.getTitlePopup());
    assertNull(actualPdAnnotationFreeText.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationFreeText.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationFreeText.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationFreeText.getPage());
    assertNull(actualPdAnnotationFreeText.getRectangle());
    assertNull(actualPdAnnotationFreeText.getRectDifference());
    assertNull(actualPdAnnotationFreeText.getOptionalContent());
    assertNull(actualPdAnnotationFreeText.getColor());
    assertNull(actualPdAnnotationFreeText.getInReplyTo());
    assertNull(actualPdAnnotationFreeText.getPopup());
    assertNull(actualPdAnnotationFreeText.getAppearance());
    assertNull(actualPdAnnotationFreeText.getNormalAppearanceStream());
    assertNull(actualPdAnnotationFreeText.getBorderEffect());
    assertNull(actualPdAnnotationFreeText.getBorderStyle());
    assertNull(actualPdAnnotationFreeText.getExternalData());
    assertEquals(-1, actualPdAnnotationFreeText.getStructParent());
    assertEquals(0, actualPdAnnotationFreeText.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationFreeText.getQ());
    assertEquals(0, actualPdAnnotationFreeText.getRectDifferences().length);
    assertEquals(1.0f, actualPdAnnotationFreeText.getConstantOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationFreeText.isHidden());
    assertFalse(actualPdAnnotationFreeText.isInvisible());
    assertFalse(actualPdAnnotationFreeText.isLocked());
    assertFalse(actualPdAnnotationFreeText.isLockedContents());
    assertFalse(actualPdAnnotationFreeText.isNoRotate());
    assertFalse(actualPdAnnotationFreeText.isNoView());
    assertFalse(actualPdAnnotationFreeText.isNoZoom());
    assertFalse(actualPdAnnotationFreeText.isPrinted());
    assertFalse(actualPdAnnotationFreeText.isReadOnly());
    assertFalse(actualPdAnnotationFreeText.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationFreeText.IT_FREE_TEXT, actualPdAnnotationFreeText.getSubtype());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationFreeText.getLineEndingStyle());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationFreeText.getReplyType());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationFreeText#PDAnnotationFreeText(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#PDAnnotationFreeText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationFreeText(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  void testNewPDAnnotationFreeText_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationFreeText actualPdAnnotationFreeText = new PDAnnotationFreeText(field);

    // Assert
    assertEquals(1, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationFreeText.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationFreeText.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationFreeText#PDAnnotationFreeText(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#PDAnnotationFreeText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationFreeText(COSDictionary); when COSStream(); then COSStream() size is two")
  void testNewPDAnnotationFreeText_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationFreeText actualPdAnnotationFreeText = new PDAnnotationFreeText(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationFreeText.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationFreeText.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationFreeText#getDefaultAppearance()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance()")
  void testGetDefaultAppearance() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationFreeText()).getDefaultAppearance());
  }

  /**
   * Test {@link PDAnnotationFreeText#setDefaultAppearance(String)}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName("Test setDefaultAppearance(String)")
  void testSetDefaultAppearance() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setDefaultAppearance("42");

    // Assert
    assertEquals("42", pdAnnotationFreeText.getDefaultAppearance());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#getDefaultStyleString()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getDefaultStyleString()}
   */
  @Test
  @DisplayName("Test getDefaultStyleString()")
  void testGetDefaultStyleString() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationFreeText()).getDefaultStyleString());
  }

  /**
   * Test {@link PDAnnotationFreeText#setDefaultStyleString(String)}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setDefaultStyleString(String)}
   */
  @Test
  @DisplayName("Test setDefaultStyleString(String)")
  void testSetDefaultStyleString() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setDefaultStyleString("Default Style String");

    // Assert
    assertEquals("Default Style String", pdAnnotationFreeText.getDefaultStyleString());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#getQ()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getQ()}
   */
  @Test
  @DisplayName("Test getQ()")
  void testGetQ() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationFreeText()).getQ());
  }

  /**
   * Test {@link PDAnnotationFreeText#setQ(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} Q is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setQ(int)}
   */
  @Test
  @DisplayName("Test setQ(int); when MIN_VALUE; then PDAnnotationFreeText() Q is MIN_VALUE")
  void testSetQ_whenMin_value_thenPDAnnotationFreeTextQIsMin_value() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setQ(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdAnnotationFreeText.getQ());
  }

  /**
   * Test {@link PDAnnotationFreeText#setQ(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} Q is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setQ(int)}
   */
  @Test
  @DisplayName("Test setQ(int); when one; then PDAnnotationFreeText() Q is one")
  void testSetQ_whenOne_thenPDAnnotationFreeTextQIsOne() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setQ(1);

    // Assert
    assertEquals(1, pdAnnotationFreeText.getQ());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setRectDifferences(float)} with
   * {@code difference}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setRectDifferences(float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float) with 'difference'")
  void testSetRectDifferencesWithDifference() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifferences(10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationFreeText.getRectDifference();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationFreeText.getRectDifferences(), 0.0f);
  }

  /**
   * Test
   * {@link PDAnnotationFreeText#setRectDifferences(float, float, float, float)}
   * with {@code differenceLeft}, {@code differenceTop}, {@code differenceRight},
   * {@code differenceBottom}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#setRectDifferences(float, float, float, float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float, float, float, float) with 'differenceLeft', 'differenceTop', 'differenceRight', 'differenceBottom'")
  void testSetRectDifferencesWithDifferenceLeftDifferenceTopDifferenceRightDifferenceBottom() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifferences(10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationFreeText.getRectDifference();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationFreeText.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#getRectDifferences()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getRectDifferences()}
   */
  @Test
  @DisplayName("Test getRectDifferences()")
  void testGetRectDifferences() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationFreeText()).getRectDifferences().length);
  }

  /**
   * Test {@link PDAnnotationFreeText#setCallout(float[])}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setCallout(float[])}
   */
  @Test
  @DisplayName("Test setCallout(float[])")
  void testSetCallout() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setCallout(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationFreeText.getCallout(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#getCallout()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName("Test getCallout()")
  void testGetCallout() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationFreeText()).getCallout());
  }

  /**
   * Test {@link PDAnnotationFreeText#setLineEndingStyle(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} LineEndingStyle
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setLineEndingStyle(String); when '42'; then PDAnnotationFreeText() LineEndingStyle is '42'")
  void testSetLineEndingStyle_when42_thenPDAnnotationFreeTextLineEndingStyleIs42() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setLineEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setLineEndingStyle(String)}.
   * <ul>
   *   <li>When {@code Style}.</li>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} LineEndingStyle
   * is {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setLineEndingStyle(String); when 'Style'; then PDAnnotationFreeText() LineEndingStyle is 'Style'")
  void testSetLineEndingStyle_whenStyle_thenPDAnnotationFreeTextLineEndingStyleIsStyle() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setLineEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#getLineEndingStyle()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName("Test getLineEndingStyle()")
  void testGetLineEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, (new PDAnnotationFreeText()).getLineEndingStyle());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetBorderEffect_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationFreeText.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationFreeText.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetBorderEffect_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationFreeText.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationFreeText.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} COSObject Values
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when 'null'; then PDAnnotationFreeText() COSObject Values size is two")
  void testSetBorderEffect_whenNull_thenPDAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setBorderEffect(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>When {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when PDBorderEffectDictionary()")
  void testSetBorderEffect_whenPDBorderEffectDictionary() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setBorderEffect(new PDBorderEffectDictionary());

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationFreeText.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
  }

  /**
   * Test {@link PDAnnotationFreeText#getBorderEffect()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getBorderEffect()}
   */
  @Test
  @DisplayName("Test getBorderEffect()")
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationFreeText()).getBorderEffect());
  }

  /**
   * Test {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectDifference(PDRectangle)")
  void testSetRectDifference() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifference(PDRectangle.A1);

    // Assert
    PDRectangle rectDifference = pdAnnotationFreeText.getRectDifference();
    assertEquals(1683.7795f, rectDifference.getUpperRightX());
    assertEquals(1683.7795f, rectDifference.getWidth());
    float[] rectDifferences = pdAnnotationFreeText.getRectDifferences();
    assertEquals(1683.7795f, rectDifferences[2]);
    assertEquals(2383.937f, rectDifference.getHeight());
    assertEquals(2383.937f, rectDifference.getUpperRightY());
    assertEquals(2383.937f, rectDifferences[3]);
    assertEquals(4, rectDifferences.length);
  }

  /**
   * Test {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectDifference(PDRectangle); when 'null'; then array length is zero")
  void testSetRectDifference_whenNull_thenArrayLengthIsZero() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifference(null);

    // Assert
    assertEquals(0, pdAnnotationFreeText.getRectDifferences().length);
    COSIncrement toIncrementResult = pdAnnotationFreeText.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotationFreeText#getRectDifference()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#getRectDifference()}
   */
  @Test
  @DisplayName("Test getRectDifference()")
  void testGetRectDifference() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationFreeText()).getRectDifference());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(2383.937f, bBox.getUpperRightX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(2383.937f, bBox2.getUpperRightX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(2383.937f, bBox3.getUpperRightX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(49, normalAppearanceStream.getStream().getLength());
    assertEquals(49, appearanceStream.getStream().getLength());
    assertEquals(49, appearanceStream2.getStream().getLength());
    assertEquals(49, appearanceStream3.getStream().getLength());
    assertEquals(49, normalAppearanceStream.getContentStream().getLength());
    assertEquals(49, appearanceStream.getContentStream().getLength());
    assertEquals(49, appearanceStream2.getContentStream().getLength());
    assertEquals(49, appearanceStream3.getContentStream().getLength());
    assertEquals(49L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(55, contentsForStreamParsing.available());
    assertEquals(55, contentsForStreamParsing2.available());
    assertEquals(55, contentsForStreamParsing3.available());
    assertEquals(55, contentsForStreamParsing4.available());
    assertEquals(55, contentsForRandomAccess.available());
    assertEquals(55, contentsForRandomAccess2.available());
    assertEquals(55, contentsForRandomAccess3.available());
    assertEquals(55, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(new PDRectangle(9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(2.14748365E9f, normalAppearanceStream.getBBox().getUpperRightX());
    assertEquals(2.14748365E9f, appearanceStream.getBBox().getUpperRightX());
    assertEquals(2.14748365E9f, appearanceStream2.getBBox().getUpperRightX());
    assertEquals(2.14748365E9f, appearanceStream3.getBBox().getUpperRightX());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(59, normalAppearanceStream.getStream().getLength());
    assertEquals(59, appearanceStream.getStream().getLength());
    assertEquals(59, appearanceStream2.getStream().getLength());
    assertEquals(59, appearanceStream3.getStream().getLength());
    assertEquals(59, normalAppearanceStream.getContentStream().getLength());
    assertEquals(59, appearanceStream.getContentStream().getLength());
    assertEquals(59, appearanceStream2.getContentStream().getLength());
    assertEquals(59, appearanceStream3.getContentStream().getLength());
    assertEquals(59L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(73, contentsForStreamParsing.available());
    assertEquals(73, contentsForStreamParsing2.available());
    assertEquals(73, contentsForStreamParsing3.available());
    assertEquals(73, contentsForStreamParsing4.available());
    assertEquals(73, contentsForRandomAccess.available());
    assertEquals(73, contentsForRandomAccess2.available());
    assertEquals(73, contentsForRandomAccess3.available());
    assertEquals(73, contentsForRandomAccess4.available());
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(new PDRectangle(-9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox3.getUpperRightX());
    assertEquals(0.0f, bBox4.getUpperRightX());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(2.14748365E9f, floatArray[0]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(60, normalAppearanceStream.getStream().getLength());
    assertEquals(60, appearanceStream.getStream().getLength());
    assertEquals(60, appearanceStream2.getStream().getLength());
    assertEquals(60, appearanceStream3.getStream().getLength());
    assertEquals(60, normalAppearanceStream.getContentStream().getLength());
    assertEquals(60, appearanceStream.getContentStream().getLength());
    assertEquals(60, appearanceStream2.getContentStream().getLength());
    assertEquals(60, appearanceStream3.getContentStream().getLength());
    assertEquals(60L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(91, contentsForStreamParsing.available());
    assertEquals(91, contentsForStreamParsing2.available());
    assertEquals(91, contentsForStreamParsing3.available());
    assertEquals(91, contentsForStreamParsing4.available());
    assertEquals(91, contentsForRandomAccess.available());
    assertEquals(91, contentsForRandomAccess2.available());
    assertEquals(91, contentsForRandomAccess3.available());
    assertEquals(91, contentsForRandomAccess4.available());
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances5() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(109, contentsForStreamParsing.available());
    assertEquals(109, contentsForStreamParsing2.available());
    assertEquals(109, contentsForStreamParsing3.available());
    assertEquals(109, contentsForStreamParsing4.available());
    assertEquals(109, contentsForRandomAccess.available());
    assertEquals(109, contentsForRandomAccess2.available());
    assertEquals(109, contentsForRandomAccess3.available());
    assertEquals(109, contentsForRandomAccess4.available());
    assertEquals(93, normalAppearanceStream.getStream().getLength());
    assertEquals(93, appearanceStream.getStream().getLength());
    assertEquals(93, appearanceStream2.getStream().getLength());
    assertEquals(93, appearanceStream3.getStream().getLength());
    assertEquals(93, normalAppearanceStream.getContentStream().getLength());
    assertEquals(93, appearanceStream.getContentStream().getLength());
    assertEquals(93, appearanceStream2.getContentStream().getLength());
    assertEquals(93, appearanceStream3.getContentStream().getLength());
    assertEquals(93L, normalAppearanceStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances6() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(79, normalAppearanceStream.getStream().getLength());
    assertEquals(79, appearanceStream.getStream().getLength());
    assertEquals(79, appearanceStream2.getStream().getLength());
    assertEquals(79, appearanceStream3.getStream().getLength());
    assertEquals(79, normalAppearanceStream.getContentStream().getLength());
    assertEquals(79, appearanceStream.getContentStream().getLength());
    assertEquals(79, appearanceStream2.getContentStream().getLength());
    assertEquals(79, appearanceStream3.getContentStream().getLength());
    assertEquals(79L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(86, contentsForStreamParsing.available());
    assertEquals(86, contentsForStreamParsing2.available());
    assertEquals(86, contentsForStreamParsing3.available());
    assertEquals(86, contentsForStreamParsing4.available());
    assertEquals(86, contentsForRandomAccess.available());
    assertEquals(86, contentsForRandomAccess2.available());
    assertEquals(86, contentsForRandomAccess3.available());
    assertEquals(86, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    PDResources resources = normalAppearanceStream.getResources();
    COSDictionary cOSObject = resources.getCOSObject();
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAnnotationFreeText.getCOSObject();
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
    assertTrue(cOSObject.getValues().isEmpty());
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, appearanceStream.getResources().getFontNames());
    assertSame(colorSpaceNames, appearanceStream2.getResources().getFontNames());
    assertSame(colorSpaceNames, appearanceStream3.getResources().getFontNames());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    COSDictionary cOSObject = normalAppearanceStream.getResources().getCOSObject();
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAnnotationFreeText.getCOSObject();
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument3() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    pdAnnotationFreeText.constructAppearances(document);

    // Assert
    List<? extends COSBase> toListResult = pdAnnotationFreeText.getNormalAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    List<? extends COSBase> toListResult2 = appearance.getDownAppearance()
        .getAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult2.size());
    assertTrue(toListResult2.get(0) instanceof COSFloat);
    assertTrue(toListResult2.get(1) instanceof COSFloat);
    List<? extends COSBase> toListResult3 = appearance.getNormalAppearance()
        .getAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult3.size());
    assertTrue(toListResult3.get(0) instanceof COSFloat);
    assertTrue(toListResult3.get(1) instanceof COSFloat);
    List<? extends COSBase> toListResult4 = appearance.getRolloverAppearance()
        .getAppearanceStream()
        .getBBox()
        .getCOSArray()
        .toList();
    assertEquals(4, toListResult4.size());
    assertTrue(toListResult4.get(0) instanceof COSFloat);
    assertTrue(toListResult4.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument4() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(128, contentsForStreamParsing.available());
    assertEquals(128, contentsForStreamParsing2.available());
    assertEquals(128, contentsForStreamParsing3.available());
    assertEquals(128, contentsForStreamParsing4.available());
    assertEquals(128, contentsForRandomAccess.available());
    assertEquals(128, contentsForRandomAccess2.available());
    assertEquals(128, contentsForRandomAccess3.available());
    assertEquals(128, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument5() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing2.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing3.available());
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing4.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess2.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess3.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument6() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(100, normalAppearanceStream.getStream().getLength());
    assertEquals(100, appearanceStream.getStream().getLength());
    assertEquals(100, appearanceStream2.getStream().getLength());
    assertEquals(100, appearanceStream3.getStream().getLength());
    assertEquals(100, normalAppearanceStream.getContentStream().getLength());
    assertEquals(100, appearanceStream.getContentStream().getLength());
    assertEquals(100, appearanceStream2.getContentStream().getLength());
    assertEquals(100, appearanceStream3.getContentStream().getLength());
    assertEquals(100L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(120, contentsForStreamParsing.available());
    assertEquals(120, contentsForStreamParsing2.available());
    assertEquals(120, contentsForStreamParsing3.available());
    assertEquals(120, contentsForStreamParsing4.available());
    assertEquals(120, contentsForRandomAccess.available());
    assertEquals(120, contentsForRandomAccess2.available());
    assertEquals(120, contentsForRandomAccess3.available());
    assertEquals(120, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument7() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(109, contentsForStreamParsing.available());
    assertEquals(109, contentsForStreamParsing2.available());
    assertEquals(109, contentsForStreamParsing3.available());
    assertEquals(109, contentsForStreamParsing4.available());
    assertEquals(109, contentsForRandomAccess.available());
    assertEquals(109, contentsForRandomAccess2.available());
    assertEquals(109, contentsForRandomAccess3.available());
    assertEquals(109, contentsForRandomAccess4.available());
    assertEquals(93, normalAppearanceStream.getStream().getLength());
    assertEquals(93, appearanceStream.getStream().getLength());
    assertEquals(93, appearanceStream2.getStream().getLength());
    assertEquals(93, appearanceStream3.getStream().getLength());
    assertEquals(93, normalAppearanceStream.getContentStream().getLength());
    assertEquals(93, appearanceStream.getContentStream().getLength());
    assertEquals(93, appearanceStream2.getContentStream().getLength());
    assertEquals(93, appearanceStream3.getContentStream().getLength());
    assertEquals(93L, normalAppearanceStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument8() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(75, contentsForStreamParsing.available());
    assertEquals(75, contentsForStreamParsing2.available());
    assertEquals(75, contentsForStreamParsing3.available());
    assertEquals(75, contentsForStreamParsing4.available());
    assertEquals(75, contentsForRandomAccess.available());
    assertEquals(75, contentsForRandomAccess2.available());
    assertEquals(75, contentsForRandomAccess3.available());
    assertEquals(75, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument9() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(112, contentsForStreamParsing.available());
    assertEquals(112, contentsForStreamParsing2.available());
    assertEquals(112, contentsForStreamParsing3.available());
    assertEquals(112, contentsForStreamParsing4.available());
    assertEquals(112, contentsForRandomAccess.available());
    assertEquals(112, contentsForRandomAccess2.available());
    assertEquals(112, contentsForRandomAccess3.available());
    assertEquals(112, contentsForRandomAccess4.available());
    assertEquals(2.14748365E9f, normalAppearanceStream.getBBox().getUpperRightX());
    assertEquals(2.14748365E9f, appearanceStream.getBBox().getUpperRightX());
    assertEquals(2.14748365E9f, appearanceStream2.getBBox().getUpperRightX());
    assertEquals(2.14748365E9f, appearanceStream3.getBBox().getUpperRightX());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(97, normalAppearanceStream.getStream().getLength());
    assertEquals(97, appearanceStream.getStream().getLength());
    assertEquals(97, appearanceStream2.getStream().getLength());
    assertEquals(97, appearanceStream3.getStream().getLength());
    assertEquals(97, normalAppearanceStream.getContentStream().getLength());
    assertEquals(97, appearanceStream.getContentStream().getLength());
    assertEquals(97, appearanceStream2.getContentStream().getLength());
    assertEquals(97, appearanceStream3.getContentStream().getLength());
    assertEquals(97L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument10() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(-9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox3.getUpperRightX());
    assertEquals(0.0f, bBox4.getUpperRightX());
    assertEquals(140, contentsForStreamParsing.available());
    assertEquals(140, contentsForStreamParsing2.available());
    assertEquals(140, contentsForStreamParsing3.available());
    assertEquals(140, contentsForStreamParsing4.available());
    assertEquals(140, contentsForRandomAccess.available());
    assertEquals(140, contentsForRandomAccess2.available());
    assertEquals(140, contentsForRandomAccess3.available());
    assertEquals(140, contentsForRandomAccess4.available());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(2.14748365E9f, floatArray[0]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(96, normalAppearanceStream.getStream().getLength());
    assertEquals(96, appearanceStream.getStream().getLength());
    assertEquals(96, appearanceStream2.getStream().getLength());
    assertEquals(96, appearanceStream3.getStream().getLength());
    assertEquals(96, normalAppearanceStream.getContentStream().getLength());
    assertEquals(96, appearanceStream.getContentStream().getLength());
    assertEquals(96, appearanceStream2.getContentStream().getLength());
    assertEquals(96, appearanceStream3.getContentStream().getLength());
    assertEquals(96L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSDictionary()")
  void testConstructAppearancesWithPDDocument_givenCOSDictionary() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    pdAnnotationFreeText.constructAppearances(new PDDocument(doc));

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    PDResources resources = normalAppearanceStream.getResources();
    COSDictionary cOSObject = resources.getCOSObject();
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAnnotationFreeText.getCOSObject();
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForStreamParsing2.available());
    assertEquals(85, contentsForStreamParsing3.available());
    assertEquals(85, contentsForStreamParsing4.available());
    assertEquals(85, contentsForRandomAccess.available());
    assertEquals(85, contentsForRandomAccess2.available());
    assertEquals(85, contentsForRandomAccess3.available());
    assertEquals(85, contentsForRandomAccess4.available());
    assertTrue(cOSObject.getValues().isEmpty());
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, appearanceStream.getResources().getFontNames());
    assertSame(colorSpaceNames, appearanceStream2.getResources().getFontNames());
    assertSame(colorSpaceNames, appearanceStream3.getResources().getFontNames());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDAnnotationFreeText#PDAnnotationFreeText()} Contents is
   * {@code G}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationFreeText() Contents is 'G'")
  void testConstructAppearances_givenPDAnnotationFreeTextContentsIsG() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(75, contentsForStreamParsing.available());
    assertEquals(75, contentsForStreamParsing2.available());
    assertEquals(75, contentsForStreamParsing3.available());
    assertEquals(75, contentsForStreamParsing4.available());
    assertEquals(75, contentsForRandomAccess.available());
    assertEquals(75, contentsForRandomAccess2.available());
    assertEquals(75, contentsForRandomAccess3.available());
    assertEquals(75, contentsForRandomAccess4.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDAnnotationFreeText#PDAnnotationFreeText()} Contents is
   * {@link PDAnnotationFreeText#IT_FREE_TEXT_CALLOUT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationFreeText() Contents is IT_FREE_TEXT_CALLOUT")
  void testConstructAppearances_givenPDAnnotationFreeTextContentsIsIt_free_text_callout() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents(PDAnnotationFreeText.IT_FREE_TEXT_CALLOUT);
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadWriteBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(75, contentsForStreamParsing.available());
    assertEquals(75, contentsForStreamParsing2.available());
    assertEquals(75, contentsForStreamParsing3.available());
    assertEquals(75, contentsForStreamParsing4.available());
    assertEquals(75, contentsForRandomAccess.available());
    assertEquals(75, contentsForRandomAccess2.available());
    assertEquals(75, contentsForRandomAccess3.available());
    assertEquals(75, contentsForRandomAccess4.available());
  }
}
