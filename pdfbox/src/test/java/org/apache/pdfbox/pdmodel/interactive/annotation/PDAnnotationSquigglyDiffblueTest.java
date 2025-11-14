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

class PDAnnotationSquigglyDiffblueTest {
  /**
   * Test {@link PDAnnotationSquiggly#PDAnnotationSquiggly()}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#PDAnnotationSquiggly()}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquiggly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.<init>()"})
  void testNewPDAnnotationSquiggly() throws IOException {
    // Arrange and Act
    PDAnnotationSquiggly actualPdAnnotationSquiggly = new PDAnnotationSquiggly();

    // Assert
    assertNull(actualPdAnnotationSquiggly.getAnnotationName());
    assertNull(actualPdAnnotationSquiggly.getContents());
    assertNull(actualPdAnnotationSquiggly.getModifiedDate());
    assertNull(actualPdAnnotationSquiggly.getIntent());
    assertNull(actualPdAnnotationSquiggly.getRichContents());
    assertNull(actualPdAnnotationSquiggly.getSubject());
    assertNull(actualPdAnnotationSquiggly.getTitlePopup());
    assertNull(actualPdAnnotationSquiggly.getCreationDate());
    assertNull(actualPdAnnotationSquiggly.getAppearanceState());
    assertNull(actualPdAnnotationSquiggly.getPage());
    assertNull(actualPdAnnotationSquiggly.getRectangle());
    assertNull(actualPdAnnotationSquiggly.getOptionalContent());
    assertNull(actualPdAnnotationSquiggly.getColor());
    assertNull(actualPdAnnotationSquiggly.getInReplyTo());
    assertNull(actualPdAnnotationSquiggly.getPopup());
    assertNull(actualPdAnnotationSquiggly.getAppearance());
    assertNull(actualPdAnnotationSquiggly.getNormalAppearanceStream());
    assertNull(actualPdAnnotationSquiggly.getBorderStyle());
    assertNull(actualPdAnnotationSquiggly.getExternalData());
    assertEquals(-1, actualPdAnnotationSquiggly.getStructParent());
    assertEquals(0, actualPdAnnotationSquiggly.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationSquiggly.getConstantOpacity());
    assertFalse(actualPdAnnotationSquiggly.isHidden());
    assertFalse(actualPdAnnotationSquiggly.isInvisible());
    assertFalse(actualPdAnnotationSquiggly.isLocked());
    assertFalse(actualPdAnnotationSquiggly.isLockedContents());
    assertFalse(actualPdAnnotationSquiggly.isNoRotate());
    assertFalse(actualPdAnnotationSquiggly.isNoView());
    assertFalse(actualPdAnnotationSquiggly.isNoZoom());
    assertFalse(actualPdAnnotationSquiggly.isPrinted());
    assertFalse(actualPdAnnotationSquiggly.isReadOnly());
    assertFalse(actualPdAnnotationSquiggly.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquiggly.getReplyType());
    assertEquals(PDAnnotationSquiggly.SUB_TYPE, actualPdAnnotationSquiggly.getSubtype());
    assertArrayEquals(new float[] {}, actualPdAnnotationSquiggly.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationSquiggly#PDAnnotationSquiggly(COSDictionary)}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#PDAnnotationSquiggly(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquiggly(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.<init>(COSDictionary)"})
  void testNewPDAnnotationSquiggly2() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationSquiggly actualPdAnnotationSquiggly = new PDAnnotationSquiggly(dict);

    // Assert
    assertNull(actualPdAnnotationSquiggly.getQuadPoints());
    assertNull(actualPdAnnotationSquiggly.getAnnotationName());
    assertNull(actualPdAnnotationSquiggly.getContents());
    assertNull(actualPdAnnotationSquiggly.getModifiedDate());
    assertNull(actualPdAnnotationSquiggly.getSubtype());
    assertNull(actualPdAnnotationSquiggly.getIntent());
    assertNull(actualPdAnnotationSquiggly.getRichContents());
    assertNull(actualPdAnnotationSquiggly.getSubject());
    assertNull(actualPdAnnotationSquiggly.getTitlePopup());
    assertNull(actualPdAnnotationSquiggly.getCreationDate());
    assertNull(actualPdAnnotationSquiggly.getAppearanceState());
    assertNull(actualPdAnnotationSquiggly.getPage());
    assertNull(actualPdAnnotationSquiggly.getRectangle());
    assertNull(actualPdAnnotationSquiggly.getOptionalContent());
    assertNull(actualPdAnnotationSquiggly.getColor());
    assertNull(actualPdAnnotationSquiggly.getInReplyTo());
    assertNull(actualPdAnnotationSquiggly.getPopup());
    assertNull(actualPdAnnotationSquiggly.getAppearance());
    assertNull(actualPdAnnotationSquiggly.getNormalAppearanceStream());
    assertNull(actualPdAnnotationSquiggly.getBorderStyle());
    assertNull(actualPdAnnotationSquiggly.getExternalData());
    assertEquals(-1, actualPdAnnotationSquiggly.getStructParent());
    assertEquals(0, actualPdAnnotationSquiggly.getAnnotationFlags());
    assertEquals(1, dict.size());
    assertEquals(1.0f, actualPdAnnotationSquiggly.getConstantOpacity());
    assertFalse(actualPdAnnotationSquiggly.isHidden());
    assertFalse(actualPdAnnotationSquiggly.isInvisible());
    assertFalse(actualPdAnnotationSquiggly.isLocked());
    assertFalse(actualPdAnnotationSquiggly.isLockedContents());
    assertFalse(actualPdAnnotationSquiggly.isNoRotate());
    assertFalse(actualPdAnnotationSquiggly.isNoView());
    assertFalse(actualPdAnnotationSquiggly.isNoZoom());
    assertFalse(actualPdAnnotationSquiggly.isPrinted());
    assertFalse(actualPdAnnotationSquiggly.isReadOnly());
    assertFalse(actualPdAnnotationSquiggly.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquiggly.getReplyType());
    assertSame(dict, actualPdAnnotationSquiggly.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
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

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

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
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
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

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

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
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances(PDDocument)"})
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

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances(PDDocument)"})
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

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSDictionary getCOSArray(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSDictionaryGetCOSArrayReturnNull() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances(PDDocument)"})
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

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
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

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSArray(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnNull() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationSquiggly#PDAnnotationSquiggly()} Rectangle is {@link
   *       PDRectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationSquiggly() Rectangle is PDRectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
  void testConstructAppearances_givenPDAnnotationSquigglyRectangleIsPDRectangle() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSquiggly.constructAppearances()"})
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

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(new COSDictionary());
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

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
