package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationHighlightDiffblueTest {
  /**
   * Test {@link PDAnnotationHighlight#PDAnnotationHighlight()}.
   *
   * <p>Method under test: {@link PDAnnotationHighlight#PDAnnotationHighlight()}
   */
  @Test
  @DisplayName("Test new PDAnnotationHighlight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.<init>()"})
  void testNewPDAnnotationHighlight() throws IOException {
    // Arrange and Act
    PDAnnotationHighlight actualPdAnnotationHighlight = new PDAnnotationHighlight();

    // Assert
    assertNull(actualPdAnnotationHighlight.getAnnotationName());
    assertNull(actualPdAnnotationHighlight.getContents());
    assertNull(actualPdAnnotationHighlight.getModifiedDate());
    assertNull(actualPdAnnotationHighlight.getIntent());
    assertNull(actualPdAnnotationHighlight.getRichContents());
    assertNull(actualPdAnnotationHighlight.getSubject());
    assertNull(actualPdAnnotationHighlight.getTitlePopup());
    assertNull(actualPdAnnotationHighlight.getCreationDate());
    assertNull(actualPdAnnotationHighlight.getAppearanceState());
    assertNull(actualPdAnnotationHighlight.getPage());
    assertNull(actualPdAnnotationHighlight.getRectangle());
    assertNull(actualPdAnnotationHighlight.getOptionalContent());
    assertNull(actualPdAnnotationHighlight.getColor());
    assertNull(actualPdAnnotationHighlight.getInReplyTo());
    assertNull(actualPdAnnotationHighlight.getPopup());
    assertNull(actualPdAnnotationHighlight.getAppearance());
    assertNull(actualPdAnnotationHighlight.getNormalAppearanceStream());
    assertNull(actualPdAnnotationHighlight.getBorderStyle());
    assertNull(actualPdAnnotationHighlight.getExternalData());
    assertEquals(-1, actualPdAnnotationHighlight.getStructParent());
    assertEquals(0, actualPdAnnotationHighlight.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationHighlight.getConstantOpacity());
    assertFalse(actualPdAnnotationHighlight.isHidden());
    assertFalse(actualPdAnnotationHighlight.isInvisible());
    assertFalse(actualPdAnnotationHighlight.isLocked());
    assertFalse(actualPdAnnotationHighlight.isLockedContents());
    assertFalse(actualPdAnnotationHighlight.isNoRotate());
    assertFalse(actualPdAnnotationHighlight.isNoView());
    assertFalse(actualPdAnnotationHighlight.isNoZoom());
    assertFalse(actualPdAnnotationHighlight.isPrinted());
    assertFalse(actualPdAnnotationHighlight.isReadOnly());
    assertFalse(actualPdAnnotationHighlight.isToggleNoView());
    assertEquals(PDAnnotationHighlight.SUB_TYPE, actualPdAnnotationHighlight.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationHighlight.getReplyType());
    assertArrayEquals(new float[] {}, actualPdAnnotationHighlight.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationHighlight#PDAnnotationHighlight(COSDictionary)}.
   *
   * <p>Method under test: {@link PDAnnotationHighlight#PDAnnotationHighlight(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationHighlight(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.<init>(COSDictionary)"})
  void testNewPDAnnotationHighlight2() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationHighlight actualPdAnnotationHighlight = new PDAnnotationHighlight(dict);

    // Assert
    assertNull(actualPdAnnotationHighlight.getQuadPoints());
    assertNull(actualPdAnnotationHighlight.getAnnotationName());
    assertNull(actualPdAnnotationHighlight.getContents());
    assertNull(actualPdAnnotationHighlight.getModifiedDate());
    assertNull(actualPdAnnotationHighlight.getSubtype());
    assertNull(actualPdAnnotationHighlight.getIntent());
    assertNull(actualPdAnnotationHighlight.getRichContents());
    assertNull(actualPdAnnotationHighlight.getSubject());
    assertNull(actualPdAnnotationHighlight.getTitlePopup());
    assertNull(actualPdAnnotationHighlight.getCreationDate());
    assertNull(actualPdAnnotationHighlight.getAppearanceState());
    assertNull(actualPdAnnotationHighlight.getPage());
    assertNull(actualPdAnnotationHighlight.getRectangle());
    assertNull(actualPdAnnotationHighlight.getOptionalContent());
    assertNull(actualPdAnnotationHighlight.getColor());
    assertNull(actualPdAnnotationHighlight.getInReplyTo());
    assertNull(actualPdAnnotationHighlight.getPopup());
    assertNull(actualPdAnnotationHighlight.getAppearance());
    assertNull(actualPdAnnotationHighlight.getNormalAppearanceStream());
    assertNull(actualPdAnnotationHighlight.getBorderStyle());
    assertNull(actualPdAnnotationHighlight.getExternalData());
    assertEquals(-1, actualPdAnnotationHighlight.getStructParent());
    assertEquals(0, actualPdAnnotationHighlight.getAnnotationFlags());
    assertEquals(1, dict.size());
    assertEquals(1.0f, actualPdAnnotationHighlight.getConstantOpacity());
    assertFalse(actualPdAnnotationHighlight.isHidden());
    assertFalse(actualPdAnnotationHighlight.isInvisible());
    assertFalse(actualPdAnnotationHighlight.isLocked());
    assertFalse(actualPdAnnotationHighlight.isLockedContents());
    assertFalse(actualPdAnnotationHighlight.isNoRotate());
    assertFalse(actualPdAnnotationHighlight.isNoView());
    assertFalse(actualPdAnnotationHighlight.isNoZoom());
    assertFalse(actualPdAnnotationHighlight.isPrinted());
    assertFalse(actualPdAnnotationHighlight.isReadOnly());
    assertFalse(actualPdAnnotationHighlight.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationHighlight.getReplyType());
    assertSame(dict, actualPdAnnotationHighlight.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument());

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddFalse() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument());

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGenerateAppearanceStreams() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAppearanceHandler appearanceHandler = mock(PDAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#get(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls get(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGet() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosArray).toFloatArray();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsGetCOSArray() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationHighlight.constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return {@code true}.
   *   <li>Then calls {@link COSArray#get(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray isEmpty() return 'true'; then calls get(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayIsEmptyReturnTrue_thenCallsGet() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationHighlight.constructAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosArray).toFloatArray();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationHighlight.constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationHighlight.constructAppearances()"})
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAppearanceHandler appearanceHandler = mock(PDAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);
    pdAnnotationHighlight.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationHighlight.constructAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(appearanceHandler).generateAppearanceStreams();
  }
}
