package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationCaretDiffblueTest {
  /**
   * Test {@link PDAnnotationCaret#PDAnnotationCaret()}.
   * <p>
   * Method under test: {@link PDAnnotationCaret#PDAnnotationCaret()}
   */
  @Test
  @DisplayName("Test new PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.<init>()"})
  void testNewPDAnnotationCaret() throws IOException {
    // Arrange and Act
    PDAnnotationCaret actualPdAnnotationCaret = new PDAnnotationCaret();

    // Assert
    assertNull(actualPdAnnotationCaret.getAnnotationName());
    assertNull(actualPdAnnotationCaret.getContents());
    assertNull(actualPdAnnotationCaret.getModifiedDate());
    assertNull(actualPdAnnotationCaret.getIntent());
    assertNull(actualPdAnnotationCaret.getRichContents());
    assertNull(actualPdAnnotationCaret.getSubject());
    assertNull(actualPdAnnotationCaret.getTitlePopup());
    assertNull(actualPdAnnotationCaret.getCreationDate());
    assertNull(actualPdAnnotationCaret.getAppearanceState());
    assertNull(actualPdAnnotationCaret.getPage());
    assertNull(actualPdAnnotationCaret.getRectangle());
    assertNull(actualPdAnnotationCaret.getOptionalContent());
    assertNull(actualPdAnnotationCaret.getColor());
    assertNull(actualPdAnnotationCaret.getInReplyTo());
    assertNull(actualPdAnnotationCaret.getPopup());
    assertNull(actualPdAnnotationCaret.getAppearance());
    assertNull(actualPdAnnotationCaret.getNormalAppearanceStream());
    assertNull(actualPdAnnotationCaret.getBorderStyle());
    assertNull(actualPdAnnotationCaret.getExternalData());
    assertEquals(-1, actualPdAnnotationCaret.getStructParent());
    assertEquals(0, actualPdAnnotationCaret.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationCaret.getConstantOpacity());
    assertFalse(actualPdAnnotationCaret.isHidden());
    assertFalse(actualPdAnnotationCaret.isInvisible());
    assertFalse(actualPdAnnotationCaret.isLocked());
    assertFalse(actualPdAnnotationCaret.isLockedContents());
    assertFalse(actualPdAnnotationCaret.isNoRotate());
    assertFalse(actualPdAnnotationCaret.isNoView());
    assertFalse(actualPdAnnotationCaret.isNoZoom());
    assertFalse(actualPdAnnotationCaret.isPrinted());
    assertFalse(actualPdAnnotationCaret.isReadOnly());
    assertFalse(actualPdAnnotationCaret.isToggleNoView());
    assertEquals(PDAnnotationCaret.SUB_TYPE, actualPdAnnotationCaret.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCaret.getReplyType());
    assertArrayEquals(new float[]{}, actualPdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return AnnotationName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationCaret(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.<init>(COSDictionary)"})
  void testNewPDAnnotationCaret_whenCOSDictionary_thenReturnAnnotationNameIsNull() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationCaret actualPdAnnotationCaret = new PDAnnotationCaret(field);

    // Assert
    assertNull(actualPdAnnotationCaret.getAnnotationName());
    assertNull(actualPdAnnotationCaret.getContents());
    assertNull(actualPdAnnotationCaret.getModifiedDate());
    assertNull(actualPdAnnotationCaret.getSubtype());
    assertNull(actualPdAnnotationCaret.getIntent());
    assertNull(actualPdAnnotationCaret.getRichContents());
    assertNull(actualPdAnnotationCaret.getSubject());
    assertNull(actualPdAnnotationCaret.getTitlePopup());
    assertNull(actualPdAnnotationCaret.getCreationDate());
    assertNull(actualPdAnnotationCaret.getAppearanceState());
    assertNull(actualPdAnnotationCaret.getPage());
    assertNull(actualPdAnnotationCaret.getRectangle());
    assertNull(actualPdAnnotationCaret.getOptionalContent());
    assertNull(actualPdAnnotationCaret.getColor());
    assertNull(actualPdAnnotationCaret.getInReplyTo());
    assertNull(actualPdAnnotationCaret.getPopup());
    assertNull(actualPdAnnotationCaret.getAppearance());
    assertNull(actualPdAnnotationCaret.getNormalAppearanceStream());
    assertNull(actualPdAnnotationCaret.getBorderStyle());
    assertNull(actualPdAnnotationCaret.getExternalData());
    assertEquals(-1, actualPdAnnotationCaret.getStructParent());
    assertEquals(0, actualPdAnnotationCaret.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationCaret.getConstantOpacity());
    assertFalse(actualPdAnnotationCaret.isHidden());
    assertFalse(actualPdAnnotationCaret.isInvisible());
    assertFalse(actualPdAnnotationCaret.isLocked());
    assertFalse(actualPdAnnotationCaret.isLockedContents());
    assertFalse(actualPdAnnotationCaret.isNoRotate());
    assertFalse(actualPdAnnotationCaret.isNoView());
    assertFalse(actualPdAnnotationCaret.isNoZoom());
    assertFalse(actualPdAnnotationCaret.isPrinted());
    assertFalse(actualPdAnnotationCaret.isReadOnly());
    assertFalse(actualPdAnnotationCaret.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationCaret.getReplyType());
    assertSame(field, actualPdAnnotationCaret.getCOSObject());
    assertArrayEquals(new float[]{}, actualPdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#setRectDifferences(float)} with {@code difference}.
   * <p>
   * Method under test: {@link PDAnnotationCaret#setRectDifferences(float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float) with 'difference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.setRectDifferences(float)"})
  void testSetRectDifferencesWithDifference() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setRectDifferences(10.0f);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#setRectDifferences(float, float, float, float)} with {@code differenceLeft}, {@code differenceTop}, {@code differenceRight}, {@code differenceBottom}.
   * <p>
   * Method under test: {@link PDAnnotationCaret#setRectDifferences(float, float, float, float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float, float, float, float) with 'differenceLeft', 'differenceTop', 'differenceRight', 'differenceBottom'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.setRectDifferences(float, float, float, float)"})
  void testSetRectDifferencesWithDifferenceLeftDifferenceTopDifferenceRightDifferenceBottom() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setRectDifferences(10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationCaret.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#getRectDifferences()}.
   * <p>
   * Method under test: {@link PDAnnotationCaret#getRectDifferences()}
   */
  @Test
  @DisplayName("Test getRectDifferences()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDAnnotationCaret.getRectDifferences()"})
  void testGetRectDifferences() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{}, (new PDAnnotationCaret()).getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationCaret#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationCaret#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    PDAnnotationCircle annotation = mock(PDAnnotationCircle.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationCaret.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getRectDifferences();
  }

  /**
   * Test {@link PDAnnotationCaret#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationCaret#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDAnnotationCircle annotation = mock(PDAnnotationCircle.class);
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationCaret.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getRectDifferences();
  }

  /**
   * Test {@link PDAnnotationCaret#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationCaret#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument3() {
    // Arrange
    PDAnnotationCircle annotation = mock(PDAnnotationCircle.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationCaret.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getRectDifferences();
  }

  /**
   * Test {@link PDAnnotationCaret#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationCaret#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDRectangle getCOSArray() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDRectangleGetCOSArrayReturnNull() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    PDAnnotationCircle annotation = mock(PDAnnotationCircle.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationCaret.constructAppearances(new PDDocument());

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getRectDifferences();
  }

  /**
   * Test {@link PDAnnotationCaret#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link COSArray#getUpdateState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationCaret#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getUpdateState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationCaret.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    PDAnnotationCircle annotation = mock(PDAnnotationCircle.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationCaret.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getRectDifferences();
  }
}
