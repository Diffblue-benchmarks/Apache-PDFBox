package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDShadingPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDefaultAppearanceStringDiffblueTest {
  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName("Test new PDDefaultAppearanceString(COSString, PDResources)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("org.apache.pdfbox.cos.COSString");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); given PDShadingPattern()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_givenPDShadingPattern() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDResources defaultResources = new PDResources();
    defaultResources.add(new PDShadingPattern());
    defaultResources.add(new PDImageXObject(new PDDocument()));

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, defaultResources);

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); when COSString(String) with text is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenCOSStringWithTextIs42() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("42");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code ID}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); when COSString(String) with text is 'ID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenCOSStringWithTextIsId() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("ID");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with text is {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); when COSString(String) with text is '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenCOSStringWithTextIsSlash() throws IOException {
    // Arrange
    COSString defaultAppearance = new COSString("/");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenNull_thenThrowIllegalArgumentException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDDefaultAppearanceString(null, null));
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenNull_thenThrowIllegalArgumentException2()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDDefaultAppearanceString(COSString.parseHex("0123456789ABCDEF"), null));
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>When parseHex {@code 42}.
   *   <li>Then return FontName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); when parseHex '42'; then return FontName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenParseHex42_thenReturnFontNameIsNull()
      throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("42");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString, PDResources)}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#PDDefaultAppearanceString(COSString,
   * PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDDefaultAppearanceString(COSString, PDResources); when parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.<init>(COSString, PDResources)"})
  void testNewPDDefaultAppearanceString_whenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    // Act
    PDDefaultAppearanceString actualPdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());

    // Assert
    assertNull(actualPdDefaultAppearanceString.getFontName());
    assertNull(actualPdDefaultAppearanceString.getFont());
    assertNull(actualPdDefaultAppearanceString.getFontColor());
    assertEquals(12.0f, actualPdDefaultAppearanceString.getFontSize());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDFont PDDefaultAppearanceString.getFont()",
    "PDColor PDDefaultAppearanceString.getFontColor()",
    "COSName PDDefaultAppearanceString.getFontName()",
    "float PDDefaultAppearanceString.getFontSize()",
    "void PDDefaultAppearanceString.setFont(PDFont)",
    "void PDDefaultAppearanceString.setFontColor(PDColor)",
    "void PDDefaultAppearanceString.setFontName(COSName)",
    "void PDDefaultAppearanceString.setFontSize(float)"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
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
    assertSame(COSName.A, actualFontName);
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName("Test writeTo(PDAppearanceContentStream, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());

    PDAppearanceContentStream contents = mock(PDAppearanceContentStream.class);
    doNothing().when(contents).setFont(Mockito.<PDFont>any(), anyFloat());

    // Act
    pdDefaultAppearanceString.writeTo(contents, 10.0f);

    // Assert
    verify(contents).setFont(isNull(), eq(12.0f));
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeTo(PDAppearanceContentStream, float); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    PDAppearanceContentStream contents = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(contents).setNonStrokingColor(Mockito.<PDColor>any());
    doNothing().when(contents).setFont(Mockito.<PDFont>any(), anyFloat());

    // Act and Assert
    assertThrows(IOException.class, () -> pdDefaultAppearanceString.writeTo(contents, 0.0f));
    verify(contents).setFont(isNull(), eq(12.0f));
    verify(contents).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeTo(PDAppearanceContentStream, float); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_givenIllegalArgumentException_thenThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    PDAppearanceContentStream contents = mock(PDAppearanceContentStream.class);
    doThrow(new IllegalArgumentException())
        .when(contents)
        .setNonStrokingColor(Mockito.<PDColor>any());
    doNothing().when(contents).setFont(Mockito.<PDFont>any(), anyFloat());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdDefaultAppearanceString.writeTo(contents, 10.0f));
    verify(contents).setFont(isNull(), eq(12.0f));
    verify(contents).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link
   *       PDAppearanceContentStream#setNonStrokingColor(PDColor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAppearanceString#writeTo(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeTo(PDAppearanceContentStream, float); when PDAppearanceContentStream setNonStrokingColor(PDColor) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.writeTo(PDAppearanceContentStream, float)"})
  void testWriteTo_whenPDAppearanceContentStreamSetNonStrokingColorDoesNothing()
      throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    PDAppearanceContentStream contents = mock(PDAppearanceContentStream.class);
    doNothing().when(contents).setNonStrokingColor(Mockito.<PDColor>any());
    doNothing().when(contents).setFont(Mockito.<PDFont>any(), anyFloat());

    // Act
    pdDefaultAppearanceString.writeTo(contents, 10.0f);

    // Assert
    verify(contents).setFont(isNull(), eq(12.0f));
    verify(contents).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}.
   *
   * <p>Method under test: {@link
   * PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
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
   *
   * <p>Method under test: {@link
   * PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo2() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
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
   *
   * <p>Method under test: {@link
   * PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo3() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
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
   *
   * <p>Method under test: {@link
   * PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo4() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(5L, 5));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
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
   *
   * <p>Method under test: {@link
   * PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test copyNeededResourcesTo(PDAppearanceStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo5() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(5L, 5));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDDefaultAppearanceString#copyNeededResourcesTo(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test copyNeededResourcesTo(PDAppearanceStream); given COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAppearanceString.copyNeededResourcesTo(PDAppearanceStream)"})
  void testCopyNeededResourcesTo_givenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setDirect(true);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
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
