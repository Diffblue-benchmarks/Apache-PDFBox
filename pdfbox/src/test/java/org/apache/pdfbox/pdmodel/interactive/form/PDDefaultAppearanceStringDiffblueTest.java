package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontLike;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDefaultAppearanceStringDiffblueTest {
  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("org.apache.pdfbox.cos.COSString");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDDefaultAppearanceString(COSString.parseHex("0123456789ABCDEF"), null));

  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources); when COSString(String) with text is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenCOSStringWithTextIs42() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("42");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources); when COSString(String) with text is 'ID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenCOSStringWithTextIsId() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("ID");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources); when COSString(String) with text is '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenCOSStringWithTextIsSlash() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("/");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenNull_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDDefaultAppearanceString(null, null));

  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then return FontName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources); when parseHex '42'; then return FontName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenParseHex42_thenReturnFontNameIsNull() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("42");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources); when parseHex '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDDefaultAppearanceString#setFont(PDFont)}
   *   <li>{@link PDDefaultAppearanceString#setFontColor(PDColor)}
   *   <li>{@link PDDefaultAppearanceString#setFontName(COSName)}
   *   <li>{@link PDDefaultAppearanceString#setFontSize(float)}
   *   <li>{@link PDDefaultAppearanceString#getFont()}
   *   <li>{@link PDDefaultAppearanceString#getFontColor()}
   *   <li>{@link PDDefaultAppearanceString#getFontName()}
   *   <li>{@link PDDefaultAppearanceString#getFontSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFont PDDefaultAppearanceString.getFont()", "PDColor PDDefaultAppearanceString.getFontColor()",
      "COSName PDDefaultAppearanceString.getFontName()", "float PDDefaultAppearanceString.getFontSize()",
      "void PDDefaultAppearanceString.setFont(PDFont)", "void PDDefaultAppearanceString.setFontColor(PDColor)",
      "void PDDefaultAppearanceString.setFontName(COSName)", "void PDDefaultAppearanceString.setFontSize(float)"})
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());

    // Act
    pdDefaultAppearanceString.setFont(font);
    PDColor fontColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    pdDefaultAppearanceString.setFontColor(fontColor);
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFontSize(10.0f);
    PDFont actualFont = pdDefaultAppearanceString.getFont();
    PDColor actualFontColor = pdDefaultAppearanceString.getFontColor();
    COSName actualFontName = pdDefaultAppearanceString.getFontName();

    // Assert
    assertEquals(10.0f, pdDefaultAppearanceString.getFontSize());
    assertSame(font, actualFont);
    assertSame(fontColor, actualFontColor);
    assertSame(actualFontName.A, actualFontName);
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenThrow(new IllegalArgumentException(
        "Using the subsetted font '{}' without a PDDocument context; call subset() before saving"));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo3() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(mock(COSDictionary.class));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenThrow(new IllegalArgumentException(
        "Using the subsetted font '{}' without a PDDocument context; call subset() before saving"));
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f));
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary2).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#A}.</li>
   *   <li>Then calls {@link COSDictionary#containsValue(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return A; then calls containsValue(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenCOSDictionaryGetKeyForValueReturnA_thenCallsContainsValue() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(mock(COSDictionary.class));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#ABSOLUTE_COLORIMETRIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ABSOLUTE_COLORIMETRIC")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenCOSDictionaryGetKeyForValueReturnAbsolute_colorimetric() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(mock(COSDictionary.class));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ABSOLUTE_COLORIMETRIC);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#ADBE_PKCS7_DETACHED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_PKCS7_DETACHED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenCOSDictionaryGetKeyForValueReturnAdbe_pkcs7_detached() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(mock(COSDictionary.class));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#ADBE_X509_RSA_SHA1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_X509_RSA_SHA1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenCOSDictionaryGetKeyForValueReturnAdbe_x509_rsa_sha1() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(mock(COSDictionary.class));
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font, atLeast(1)).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given COSDictionary isDirect() return 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link PDFont} {@link PDFont#getCOSObject()} return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given PDFont getCOSObject() return COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenPDFontGetCOSObjectReturnCOSDictionary() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(new COSDictionary());
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link PDFont} {@link PDFont#getCOSObject()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given PDFont getCOSObject() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenPDFontGetCOSObjectReturnNull() throws IOException {
    // Arrange
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(null);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link PDFont} {@link PDFont#willBeSubset()} return {@code false}.</li>
   *   <li>Then calls {@link PDFontLike#isEmbedded()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); given PDFont willBeSubset() return 'false'; then calls isEmbedded()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenPDFontWillBeSubsetReturnFalse_thenCallsIsEmbedded() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(false);
    when(font.isEmbedded()).thenReturn(true);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).isEmbedded();
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_thenCallsSetOriginDocumentState() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDFont font = mock(PDFont.class);
    when(font.getCOSObject()).thenReturn(cosDictionary);
    when(font.willBeSubset()).thenReturn(true);
    when(font.getName()).thenReturn("Name");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdDefaultAppearanceString.writeTo(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f);

    // Assert
    verify(cosDictionary).isDirect();
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(font).getCOSObject();
    verify(font).willBeSubset();
    verify(font).getName();
  }

  /**
   * Test {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    PDAppearanceStream appearanceStream = new PDAppearanceStream(new COSStream());

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertNull(resources.getResourceCache());
    COSStream cOSObject = appearanceStream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertEquals(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Test {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo2() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    PDAppearanceStream appearanceStream = new PDAppearanceStream(new COSStream());

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertNull(resources.getResourceCache());
    COSStream cOSObject = appearanceStream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertEquals(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Test {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo3() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(new PDMMType1Font(new COSDictionary()));
    PDAppearanceStream appearanceStream = new PDAppearanceStream(new COSStream());

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertNull(resources.getResourceCache());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    COSStream cOSObject = appearanceStream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Test {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo4() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(5L, 5));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    PDAppearanceStream appearanceStream = new PDAppearanceStream(new COSStream());

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertNull(resources.getResourceCache());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    COSStream cOSObject = appearanceStream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Test {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}.
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo5() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(5L, 5));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    PDAppearanceStream appearanceStream = new PDAppearanceStream(new COSStream());

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertNull(resources.getResourceCache());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    COSStream cOSObject = appearanceStream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }

  /**
   * Test {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream); given COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo_givenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setDirect(true);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFont(font);
    PDAppearanceStream appearanceStream = new PDAppearanceStream(new COSStream());

    // Act
    pdDefaultAppearanceString.copyNeededResourcesTo(appearanceStream);

    // Assert
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertNull(resources.getResourceCache());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    COSStream cOSObject = appearanceStream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
  }
}
