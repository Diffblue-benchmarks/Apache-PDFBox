package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCaretAppearanceHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationStrikeoutDiffblueTest {
  /**
   * Test {@link PDAnnotationStrikeout#PDAnnotationStrikeout()}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#PDAnnotationStrikeout()}
   */
  @Test
  @DisplayName("Test new PDAnnotationStrikeout()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.<init>()"})
  void testNewPDAnnotationStrikeout() throws IOException {
    // Arrange and Act
    PDAnnotationStrikeout actualPdAnnotationStrikeout = new PDAnnotationStrikeout();

    // Assert
    assertNull(actualPdAnnotationStrikeout.getAnnotationName());
    assertNull(actualPdAnnotationStrikeout.getContents());
    assertNull(actualPdAnnotationStrikeout.getModifiedDate());
    assertNull(actualPdAnnotationStrikeout.getIntent());
    assertNull(actualPdAnnotationStrikeout.getRichContents());
    assertNull(actualPdAnnotationStrikeout.getSubject());
    assertNull(actualPdAnnotationStrikeout.getTitlePopup());
    assertNull(actualPdAnnotationStrikeout.getCreationDate());
    assertNull(actualPdAnnotationStrikeout.getAppearanceState());
    assertNull(actualPdAnnotationStrikeout.getPage());
    assertNull(actualPdAnnotationStrikeout.getRectangle());
    assertNull(actualPdAnnotationStrikeout.getOptionalContent());
    assertNull(actualPdAnnotationStrikeout.getColor());
    assertNull(actualPdAnnotationStrikeout.getInReplyTo());
    assertNull(actualPdAnnotationStrikeout.getPopup());
    assertNull(actualPdAnnotationStrikeout.getAppearance());
    assertNull(actualPdAnnotationStrikeout.getNormalAppearanceStream());
    assertNull(actualPdAnnotationStrikeout.getBorderStyle());
    assertNull(actualPdAnnotationStrikeout.getExternalData());
    assertEquals(-1, actualPdAnnotationStrikeout.getStructParent());
    assertEquals(0, actualPdAnnotationStrikeout.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationStrikeout.getConstantOpacity());
    assertFalse(actualPdAnnotationStrikeout.isHidden());
    assertFalse(actualPdAnnotationStrikeout.isInvisible());
    assertFalse(actualPdAnnotationStrikeout.isLocked());
    assertFalse(actualPdAnnotationStrikeout.isLockedContents());
    assertFalse(actualPdAnnotationStrikeout.isNoRotate());
    assertFalse(actualPdAnnotationStrikeout.isNoView());
    assertFalse(actualPdAnnotationStrikeout.isNoZoom());
    assertFalse(actualPdAnnotationStrikeout.isPrinted());
    assertFalse(actualPdAnnotationStrikeout.isReadOnly());
    assertFalse(actualPdAnnotationStrikeout.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationStrikeout.getReplyType());
    assertEquals(PDAnnotationStrikeout.SUB_TYPE, actualPdAnnotationStrikeout.getSubtype());
    assertArrayEquals(new float[] {}, actualPdAnnotationStrikeout.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationStrikeout#PDAnnotationStrikeout(COSDictionary)}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#PDAnnotationStrikeout(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationStrikeout(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.<init>(COSDictionary)"})
  void testNewPDAnnotationStrikeout2() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationStrikeout actualPdAnnotationStrikeout = new PDAnnotationStrikeout(dict);

    // Assert
    assertNull(actualPdAnnotationStrikeout.getQuadPoints());
    assertNull(actualPdAnnotationStrikeout.getAnnotationName());
    assertNull(actualPdAnnotationStrikeout.getContents());
    assertNull(actualPdAnnotationStrikeout.getModifiedDate());
    assertNull(actualPdAnnotationStrikeout.getSubtype());
    assertNull(actualPdAnnotationStrikeout.getIntent());
    assertNull(actualPdAnnotationStrikeout.getRichContents());
    assertNull(actualPdAnnotationStrikeout.getSubject());
    assertNull(actualPdAnnotationStrikeout.getTitlePopup());
    assertNull(actualPdAnnotationStrikeout.getCreationDate());
    assertNull(actualPdAnnotationStrikeout.getAppearanceState());
    assertNull(actualPdAnnotationStrikeout.getPage());
    assertNull(actualPdAnnotationStrikeout.getRectangle());
    assertNull(actualPdAnnotationStrikeout.getOptionalContent());
    assertNull(actualPdAnnotationStrikeout.getColor());
    assertNull(actualPdAnnotationStrikeout.getInReplyTo());
    assertNull(actualPdAnnotationStrikeout.getPopup());
    assertNull(actualPdAnnotationStrikeout.getAppearance());
    assertNull(actualPdAnnotationStrikeout.getNormalAppearanceStream());
    assertNull(actualPdAnnotationStrikeout.getBorderStyle());
    assertNull(actualPdAnnotationStrikeout.getExternalData());
    assertEquals(-1, actualPdAnnotationStrikeout.getStructParent());
    assertEquals(0, actualPdAnnotationStrikeout.getAnnotationFlags());
    assertEquals(1, dict.size());
    assertEquals(1.0f, actualPdAnnotationStrikeout.getConstantOpacity());
    assertFalse(actualPdAnnotationStrikeout.isHidden());
    assertFalse(actualPdAnnotationStrikeout.isInvisible());
    assertFalse(actualPdAnnotationStrikeout.isLocked());
    assertFalse(actualPdAnnotationStrikeout.isLockedContents());
    assertFalse(actualPdAnnotationStrikeout.isNoRotate());
    assertFalse(actualPdAnnotationStrikeout.isNoView());
    assertFalse(actualPdAnnotationStrikeout.isNoZoom());
    assertFalse(actualPdAnnotationStrikeout.isPrinted());
    assertFalse(actualPdAnnotationStrikeout.isReadOnly());
    assertFalse(actualPdAnnotationStrikeout.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationStrikeout.getReplyType());
    assertSame(dict, actualPdAnnotationStrikeout.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances2() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout();
    pdAnnotationStrikeout.setRectangle(rectangle);

    // Act
    pdAnnotationStrikeout.constructAppearances(new PDDocument());

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(dict);
    pdAnnotationStrikeout.setRectangle(rectangle);

    // Act
    pdAnnotationStrikeout.constructAppearances(new PDDocument());

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument3() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument4() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSDictionary getCOSArray(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSDictionaryGetCOSArrayReturnNull() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(dict);
    pdAnnotationStrikeout.setRectangle(rectangle);

    // Act
    pdAnnotationStrikeout.constructAppearances(new PDDocument());

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances(new PDDocument());

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsSetAppearance() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSArray_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(dict);
    pdAnnotationStrikeout.setRectangle(rectangle);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(dict);
    pdAnnotationStrikeout.setRectangle(rectangle);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSArray(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnNull() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(dict);
    pdAnnotationStrikeout.setRectangle(rectangle);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationStrikeout#PDAnnotationStrikeout()} Rectangle is {@link
   *       PDRectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given PDAnnotationStrikeout() Rectangle is PDRectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances_givenPDAnnotationStrikeoutRectangleIsPDRectangle() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout();
    pdAnnotationStrikeout.setRectangle(rectangle);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationStrikeout#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationStrikeout#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationStrikeout.constructAppearances()"})
  void testConstructAppearances_thenCallsSetAppearance() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationStrikeout pdAnnotationStrikeout = new PDAnnotationStrikeout(new COSDictionary());
    pdAnnotationStrikeout.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationStrikeout.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }
}
