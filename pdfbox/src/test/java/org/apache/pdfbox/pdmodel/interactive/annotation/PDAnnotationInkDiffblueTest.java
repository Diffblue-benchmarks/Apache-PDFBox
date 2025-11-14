package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
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

class PDAnnotationInkDiffblueTest {
  /**
   * Test {@link PDAnnotationInk#PDAnnotationInk()}.
   *
   * <p>Method under test: {@link PDAnnotationInk#PDAnnotationInk()}
   */
  @Test
  @DisplayName("Test new PDAnnotationInk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.<init>()"})
  void testNewPDAnnotationInk() throws IOException {
    // Arrange and Act
    PDAnnotationInk actualPdAnnotationInk = new PDAnnotationInk();

    // Assert
    assertNull(actualPdAnnotationInk.getAnnotationName());
    assertNull(actualPdAnnotationInk.getContents());
    assertNull(actualPdAnnotationInk.getModifiedDate());
    assertNull(actualPdAnnotationInk.getIntent());
    assertNull(actualPdAnnotationInk.getRichContents());
    assertNull(actualPdAnnotationInk.getSubject());
    assertNull(actualPdAnnotationInk.getTitlePopup());
    assertNull(actualPdAnnotationInk.getCreationDate());
    assertNull(actualPdAnnotationInk.getAppearanceState());
    assertNull(actualPdAnnotationInk.getPage());
    assertNull(actualPdAnnotationInk.getRectangle());
    assertNull(actualPdAnnotationInk.getOptionalContent());
    assertNull(actualPdAnnotationInk.getColor());
    assertNull(actualPdAnnotationInk.getInReplyTo());
    assertNull(actualPdAnnotationInk.getPopup());
    assertNull(actualPdAnnotationInk.getAppearance());
    assertNull(actualPdAnnotationInk.getNormalAppearanceStream());
    assertNull(actualPdAnnotationInk.getBorderStyle());
    assertNull(actualPdAnnotationInk.getExternalData());
    assertEquals(-1, actualPdAnnotationInk.getStructParent());
    assertEquals(0, actualPdAnnotationInk.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationInk.getInkList().length);
    assertEquals(1.0f, actualPdAnnotationInk.getConstantOpacity());
    assertFalse(actualPdAnnotationInk.isHidden());
    assertFalse(actualPdAnnotationInk.isInvisible());
    assertFalse(actualPdAnnotationInk.isLocked());
    assertFalse(actualPdAnnotationInk.isLockedContents());
    assertFalse(actualPdAnnotationInk.isNoRotate());
    assertFalse(actualPdAnnotationInk.isNoView());
    assertFalse(actualPdAnnotationInk.isNoZoom());
    assertFalse(actualPdAnnotationInk.isPrinted());
    assertFalse(actualPdAnnotationInk.isReadOnly());
    assertFalse(actualPdAnnotationInk.isToggleNoView());
    assertEquals(PDAnnotationInk.SUB_TYPE, actualPdAnnotationInk.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationInk.getReplyType());
  }

  /**
   * Test {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationInk(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.<init>(COSDictionary)"})
  void testNewPDAnnotationInk_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationInk actualPdAnnotationInk = new PDAnnotationInk(dict);

    // Assert
    assertEquals(1, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationInk.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationInk.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationInk(COSDictionary); when COSStream(); then COSStream() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.<init>(COSDictionary)"})
  void testNewPDAnnotationInk_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream dict = new COSStream();

    // Act
    PDAnnotationInk actualPdAnnotationInk = new PDAnnotationInk(dict);

    // Assert
    assertEquals(2, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationInk.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationInk.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationInk#setInkList(float[][])}.
   *
   * <ul>
   *   <li>When array of {@code float} with ten and {@code 0.5}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#setInkList(float[][])}
   */
  @Test
  @DisplayName(
      "Test setInkList(float[][]); when array of float with ten and '0.5'; then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.setInkList(float[][])"})
  void testSetInkList_whenArrayOfFloatWithTenAnd05_thenArrayLengthIsOne() {
    // Arrange
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();

    // Act
    pdAnnotationInk.setInkList(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    float[][] inkList = pdAnnotationInk.getInkList();
    assertEquals(1, inkList.length);
    COSDictionary cOSObject = pdAnnotationInk.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, inkList[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationInk#setInkList(float[][])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#setInkList(float[][])}
   */
  @Test
  @DisplayName("Test setInkList(float[][]); when 'null'; then array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.setInkList(float[][])"})
  void testSetInkList_whenNull_thenArrayLengthIsZero() {
    // Arrange
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();

    // Act
    pdAnnotationInk.setInkList(null);

    // Assert that nothing has changed
    assertEquals(0, pdAnnotationInk.getInkList().length);
    COSDictionary cOSObject = pdAnnotationInk.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationInk#getInkList()}.
   *
   * <p>Method under test: {@link PDAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName("Test getInkList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] PDAnnotationInk.getInkList()"})
  void testGetInkList() {
    // Arrange, Act and Assert
    assertEquals(0, new PDAnnotationInk().getInkList().length);
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument4() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument5() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument6() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument7() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn("Name As String");
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument8() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn(PDBorderStyleDictionary.STYLE_DASHED);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add FALSE; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddFalse_thenCallsAdd() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = new COSArray();
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn(PDBorderStyleDictionary.STYLE_DASHED);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDCalGray#getNumberOfComponents()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls getNumberOfComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsSetItem() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn(PDBorderStyleDictionary.STYLE_DASHED);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setRectangle(PDRectangle)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls setRectangle(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances(PDDocument)"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray() add FALSE; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsAdd() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = new COSArray();
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn(PDBorderStyleDictionary.STYLE_DASHED);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnNull() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getNameAsString(COSName, String)} return
   *       {@code Name As String}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getNameAsString(COSName, String) return 'Name As String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetNameAsStringReturnNameAsString() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn("Name As String");
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getNameAsString(COSName, String)} return
   *       {@link PDBorderStyleDictionary#STYLE_DASHED}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getNameAsString(COSName, String) return STYLE_DASHED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetNameAsStringReturnStyle_dashed() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn(PDBorderStyleDictionary.STYLE_DASHED);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDColor#getColorSpace()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls getColorSpace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_thenCallsGetColorSpace() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCalGray#getNumberOfComponents()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls getNumberOfComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_thenCallsSetItem() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any(), Mockito.<String>any()))
        .thenReturn(PDBorderStyleDictionary.STYLE_DASHED);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(dict);
    pdAnnotationInk.setCustomAppearanceHandler(null);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getFloat(isA(COSName.class), eq(1.0f));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class), eq("S"));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
  void testConstructAppearances_thenCallsSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setRectangle(PDRectangle)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setRectangle(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationInk.constructAppearances()"})
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk(new COSDictionary());
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
