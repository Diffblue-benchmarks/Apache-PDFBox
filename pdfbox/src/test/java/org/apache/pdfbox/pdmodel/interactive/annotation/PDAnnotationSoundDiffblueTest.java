package org.apache.pdfbox.pdmodel.interactive.annotation;

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
import java.util.List;
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

class PDAnnotationSoundDiffblueTest {
  /**
   * Test {@link PDAnnotationSound#PDAnnotationSound()}.
   *
   * <p>Method under test: {@link PDAnnotationSound#PDAnnotationSound()}
   */
  @Test
  @DisplayName("Test new PDAnnotationSound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.<init>()"})
  void testNewPDAnnotationSound() throws IOException {
    // Arrange and Act
    PDAnnotationSound actualPdAnnotationSound = new PDAnnotationSound();

    // Assert
    assertNull(actualPdAnnotationSound.getAnnotationName());
    assertNull(actualPdAnnotationSound.getContents());
    assertNull(actualPdAnnotationSound.getModifiedDate());
    assertNull(actualPdAnnotationSound.getIntent());
    assertNull(actualPdAnnotationSound.getRichContents());
    assertNull(actualPdAnnotationSound.getSubject());
    assertNull(actualPdAnnotationSound.getTitlePopup());
    assertNull(actualPdAnnotationSound.getCreationDate());
    assertNull(actualPdAnnotationSound.getAppearanceState());
    assertNull(actualPdAnnotationSound.getPage());
    assertNull(actualPdAnnotationSound.getRectangle());
    assertNull(actualPdAnnotationSound.getOptionalContent());
    assertNull(actualPdAnnotationSound.getColor());
    assertNull(actualPdAnnotationSound.getInReplyTo());
    assertNull(actualPdAnnotationSound.getPopup());
    assertNull(actualPdAnnotationSound.getAppearance());
    assertNull(actualPdAnnotationSound.getNormalAppearanceStream());
    assertNull(actualPdAnnotationSound.getBorderStyle());
    assertNull(actualPdAnnotationSound.getExternalData());
    assertEquals(-1, actualPdAnnotationSound.getStructParent());
    assertEquals(0, actualPdAnnotationSound.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationSound.getConstantOpacity());
    assertFalse(actualPdAnnotationSound.isHidden());
    assertFalse(actualPdAnnotationSound.isInvisible());
    assertFalse(actualPdAnnotationSound.isLocked());
    assertFalse(actualPdAnnotationSound.isLockedContents());
    assertFalse(actualPdAnnotationSound.isNoRotate());
    assertFalse(actualPdAnnotationSound.isNoView());
    assertFalse(actualPdAnnotationSound.isNoZoom());
    assertFalse(actualPdAnnotationSound.isPrinted());
    assertFalse(actualPdAnnotationSound.isReadOnly());
    assertFalse(actualPdAnnotationSound.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSound.getReplyType());
    assertEquals(PDAnnotationSound.SUB_TYPE, actualPdAnnotationSound.getSubtype());
  }

  /**
   * Test {@link PDAnnotationSound#PDAnnotationSound(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#PDAnnotationSound(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationSound(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.<init>(COSDictionary)"})
  void testNewPDAnnotationSound_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationSound actualPdAnnotationSound = new PDAnnotationSound(field);

    // Assert
    assertEquals(1, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationSound.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationSound.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationSound#PDAnnotationSound(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#PDAnnotationSound(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationSound(COSDictionary); when COSStream(); then COSStream() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.<init>(COSDictionary)"})
  void testNewPDAnnotationSound_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationSound actualPdAnnotationSound = new PDAnnotationSound(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationSound.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationSound.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances2() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(new PDRectangle(9.223372E18f, 9.223372E18f));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(new PDRectangle(9.223372E18f, 9.223372E18f));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDCalGray#getNumberOfComponents()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls getNumberOfComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetNumberOfComponents() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsSetAppearance() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setRectangle(PDRectangle)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setRectangle(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsSetRectangle() {
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

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCalGray#getNumberOfComponents()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls getNumberOfComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_thenCallsGetNumberOfComponents() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_thenCallsSetAppearance() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_thenCallsSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setRectangle(PDRectangle)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setRectangle(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_thenCallsSetRectangle() {
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

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

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
}
