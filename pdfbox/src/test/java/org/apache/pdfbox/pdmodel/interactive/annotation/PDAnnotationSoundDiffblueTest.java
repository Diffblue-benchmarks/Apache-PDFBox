package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
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
   *   <li>Then return AnnotationName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#PDAnnotationSound(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationSound(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.<init>(COSDictionary)"})
  void testNewPDAnnotationSound_whenCOSDictionary_thenReturnAnnotationNameIsNull()
      throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationSound actualPdAnnotationSound = new PDAnnotationSound(field);

    // Assert
    assertNull(actualPdAnnotationSound.getAnnotationName());
    assertNull(actualPdAnnotationSound.getContents());
    assertNull(actualPdAnnotationSound.getModifiedDate());
    assertNull(actualPdAnnotationSound.getSubtype());
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
    assertEquals(1, field.size());
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
    assertSame(field, actualPdAnnotationSound.getCOSObject());
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
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
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
  void testConstructAppearances4() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(new PDRectangle(9.223372E18f, 9.223372E18f));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
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
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances5() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
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
  void testConstructAppearances6() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosStream);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
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
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.LETTER);
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
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument4() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(new PDRectangle(9.223372E18f, 9.223372E18f));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
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
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument5() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
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
  void testConstructAppearancesWithPDDocument6() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosStream);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(colorSpace.getCOSObject()).thenReturn(cosObject);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnA() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSName.A);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnFalse() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
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
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnFalse2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnNull() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(null);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link
   *       COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSInteger.ONE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.
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
    PDAppearanceHandler appearanceHandler = mock(PDAppearanceHandler.class);
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
   *   <li>Then calls {@link COSStream#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetKey() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(false);
    when(cosStream.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosStream);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosStream, atLeast(1)).getKey();
    verify(cosStream, atLeast(1)).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
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
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsSetOriginDocumentState() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosStream);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances(new PDDocument());

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(colorSpace.getCOSObject()).thenReturn(cosObject);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSStream#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSStream isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenCOSStreamIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(false);
    when(cosStream.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosStream);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosStream, atLeast(1)).getKey();
    verify(cosStream, atLeast(1)).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret} {@link PDAnnotationCaret#getRectangle()} return {@link
   *       PDRectangle#LETTER}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationCaret getRectangle() return LETTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenPDAnnotationCaretGetRectangleReturnLetter() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.LETTER);
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

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnA() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSName.A);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnFalse() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
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
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnFalse2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnNull() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(null);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return {@link
   *       COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSInteger.ONE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.
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
    PDAppearanceHandler appearanceHandler = mock(PDAppearanceHandler.class);
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
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSound#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationSound#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationSound.constructAppearances()"})
  void testConstructAppearances_thenCallsSetOriginDocumentState() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosStream);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSound pdAnnotationSound = new PDAnnotationSound(new COSDictionary());
    pdAnnotationSound.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSound.constructAppearances();

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }
}
