package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceCMYK;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentMembershipDictionary;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDShadingPattern;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType1;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType2;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType3;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType4;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType5;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType6;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType7;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDResourcesDiffblueTest {
  /**
   * Test {@link PDResources#PDResources()}.
   *
   * <p>Method under test: {@link PDResources#PDResources()}
   */
  @Test
  @DisplayName("Test new PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>()"})
  void testNewPDResources() {
    // Arrange and Act
    PDResources actualPdResources = new PDResources();

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualPdResources.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then ColorSpaceNames return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#PDResources(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDResources(COSDictionary); when COSDictionary(); then ColorSpaceNames return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>(COSDictionary)"})
  void testNewPDResources_whenCOSDictionary_thenColorSpaceNamesReturnSet() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act
    PDResources actualPdResources = new PDResources(resourceDictionary);

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertNull(actualPdResources.getResourceCache());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, actualPdResources.getCOSObject());
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary, ResourceCache)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then ColorSpaceNames return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#PDResources(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName(
      "Test new PDResources(COSDictionary, ResourceCache); when COSDictionary(); then ColorSpaceNames return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>(COSDictionary, ResourceCache)"})
  void testNewPDResources_whenCOSDictionary_thenColorSpaceNamesReturnSet2() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act
    PDResources actualPdResources = new PDResources(resourceDictionary, resourceCache);

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    ResourceCache resourceCache2 = actualPdResources.getResourceCache();
    assertTrue(resourceCache2 instanceof DefaultResourceCache);
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, actualPdResources.getCOSObject());
    assertSame(resourceCache, resourceCache2);
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then ColorSpaceNames return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  @DisplayName(
      "Test new PDResources(COSDictionary, ResourceCache, Map); when COSDictionary(); then ColorSpaceNames return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>(COSDictionary, ResourceCache, Map)"})
  void testNewPDResources_whenCOSDictionary_thenColorSpaceNamesReturnSet3() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act
    PDResources actualPdResources =
        new PDResources(resourceDictionary, resourceCache, new HashMap<>());

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    ResourceCache resourceCache2 = actualPdResources.getResourceCache();
    assertTrue(resourceCache2 instanceof DefaultResourceCache);
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, actualPdResources.getCOSObject());
    assertSame(resourceCache, resourceCache2);
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  @DisplayName(
      "Test new PDResources(COSDictionary, ResourceCache, Map); when COSDictionary(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>(COSDictionary, ResourceCache, Map)"})
  void testNewPDResources_whenCOSDictionary_thenThrowIllegalArgumentException() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDResources(resourceDictionary, new DefaultResourceCache(), null));
  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#PDResources(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDResources(COSDictionary); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>(COSDictionary)"})
  void testNewPDResources_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDResources(null));
  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary, ResourceCache)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#PDResources(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName(
      "Test new PDResources(COSDictionary, ResourceCache); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>(COSDictionary, ResourceCache)"})
  void testNewPDResources_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDResources(null, new DefaultResourceCache()));
  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  @DisplayName(
      "Test new PDResources(COSDictionary, ResourceCache, Map); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.<init>(COSDictionary, ResourceCache, Map)"})
  void testNewPDResources_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDResources(null, resourceCache, new HashMap<>()));
  }

  /**
   * Test {@link PDResources#getCOSObject()}.
   *
   * <p>Method under test: {@link PDResources#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDResources.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDResources().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());

    // Act and Assert
    assertNull(pdResources.getFont(COSName.A));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link
   *       PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName(
      "Test getFont(COSName); given PDResources() add PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_givenPDResourcesAddPDMMType1FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getFont(COSName.A));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); given PDResources(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_givenPDResources_whenA_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDResources().getFont(COSName.A));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); given PDResources(); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_givenPDResources_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDResources().getFont(null));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>Then FontBoxFont Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); then FontBoxFont Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_thenFontBoxFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(1L, 1));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, font);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDFont actualFont = pdResources.getFont(COSName.A);

    // Assert
    FontBoxFont fontBoxFont = ((PDType1Font) actualFont).getFontBoxFont();
    assertTrue(((TrueTypeFont) fontBoxFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(actualFont instanceof PDType1Font);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    float[][] values = actualFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one
   *       and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName(
      "Test getFont(COSName); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    fontDictionary.setKey(key);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, font);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDFont actualFont = pdResources.getFont(COSName.A);

    // Assert
    assertTrue(actualFont instanceof PDType1Font);
    float[][] values = actualFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(key, actualFont.getCOSObject().getKey());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); then return COSObject Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_thenReturnCOSObjectKeyIsNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDMMType1Font(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDFont actualFont = pdResources.getFont(COSName.A);

    // Assert
    assertTrue(actualFont instanceof PDType1Font);
    assertNull(actualFont.getCOSObject().getKey());
    float[][] values = actualFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); then return COSObject Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_thenReturnCOSObjectKeyIsNull2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDMMType1Font(new COSDictionary()));

    // Act
    PDFont actualFont = pdResources.getFont(COSName.A);

    // Assert
    assertTrue(actualFont instanceof PDType1Font);
    assertNull(actualFont.getCOSObject().getKey());
    float[][] values = actualFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDResources.getFont(COSName)"})
  void testGetFont_whenNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getFont(null));
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link
   *       PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; given PDResources() A is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_givenPDResourcesAIsInstance() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link
   *       PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; given PDResources() A is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_givenPDResourcesAIsInstance2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@code null} is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; given PDResources() 'null' is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_givenPDResourcesNullIsInstance() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, false);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@code null} is {@link PDDeviceGray#INSTANCE}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; given PDResources() 'null' is INSTANCE; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_givenPDResourcesNullIsInstance_whenNull()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(null, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Then return {@link PDCalGray}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; then return PDCalGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_thenReturnPDCalGray() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalGray());

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertTrue(actualColorSpace instanceof PDCalGray);
    assertEquals("CalGray", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualColorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualColorSpace).getGamma());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Then return {@link PDCalRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; then return PDCalRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_thenReturnPDCalRGB() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalRGB());

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertTrue(actualColorSpace instanceof PDCalRGB);
    assertEquals("CalRGB", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDGamma gamma = ((PDCalRGB) actualColorSpace).getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualColorSpace).getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICECMYK}.
   *   <li>Then return {@link PDDeviceCMYK#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; when DEVICECMYK; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_whenDevicecmyk_thenReturnInstance() throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.DEVICECMYK, false);

    // Assert
    assertSame(((PDDeviceCMYK) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICEGRAY}.
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; when DEVICEGRAY; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_whenDevicegray_thenReturnInstance() throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.DEVICEGRAY, false);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICERGB}.
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; when DEVICERGB; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_whenDevicergb_thenReturnInstance() throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.DEVICERGB, false);

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSName#PATTERN}.
   *   <li>Then COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; when PATTERN; then COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName, boolean)"})
  void testGetColorSpaceWithNameWasDefault_whenPattern_thenCOSObjectReturnCOSArray()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.PATTERN, false);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualColorSpace instanceof PDPattern);
    assertEquals("Pattern", ((COSName) getResult).getName());
    assertEquals("Pattern", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(((PDPattern) actualColorSpace).getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(COSName.PATTERN, getResult);
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link
   *       PDDeviceGray#INSTANCE}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; given PDResources() A is INSTANCE; when A; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_givenPDResourcesAIsInstance_whenA_thenReturnInstance()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link
   *       PDCalGray#PDCalGray()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@link PDCalGray}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; given PDResources() A is PDCalGray(); when A; then return PDCalGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_givenPDResourcesAIsPDCalGray_whenA_thenReturnPDCalGray()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalGray());

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertTrue(actualColorSpace instanceof PDCalGray);
    assertEquals("CalGray", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualColorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualColorSpace).getGamma());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link PDCalRGB#PDCalRGB()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@link PDCalRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; given PDResources() A is PDCalRGB(); when A; then return PDCalRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_givenPDResourcesAIsPDCalRGB_whenA_thenReturnPDCalRGB()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalRGB());

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertTrue(actualColorSpace instanceof PDCalRGB);
    assertEquals("CalRGB", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDGamma gamma = ((PDCalRGB) actualColorSpace).getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualColorSpace).getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@code null} is {@link PDDeviceGray#INSTANCE}.
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; given PDResources() 'null' is INSTANCE; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_givenPDResourcesNullIsInstance_thenReturnInstance()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#DEVICECMYK}.
   *   <li>Then return {@link PDDeviceCMYK#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; given PDResources(); when DEVICECMYK; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_givenPDResources_whenDevicecmyk_thenReturnInstance()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.DEVICECMYK);

    // Assert
    assertSame(((PDDeviceCMYK) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#DEVICEGRAY}.
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; given PDResources(); when DEVICEGRAY; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_givenPDResources_whenDevicegray_thenReturnInstance()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.DEVICEGRAY);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#DEVICERGB}.
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; given PDResources(); when DEVICERGB; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_givenPDResources_whenDevicergb_thenReturnInstance()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.DEVICERGB);

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   *
   * <ul>
   *   <li>When {@link COSName#PATTERN}.
   *   <li>Then COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSName) with 'name'; when PATTERN; then COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDResources.getColorSpace(COSName)"})
  void testGetColorSpaceWithName_whenPattern_thenCOSObjectReturnCOSArray() throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = new PDResources().getColorSpace(COSName.PATTERN);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualColorSpace instanceof PDPattern);
    assertEquals("Pattern", ((COSName) getResult).getName());
    assertEquals("Pattern", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(((PDPattern) actualColorSpace).getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(COSName.PATTERN, getResult);
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link
   *       PDDeviceGray#INSTANCE}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test hasColorSpace(COSName); given PDResources() A is INSTANCE; when A; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDResources.hasColorSpace(COSName)"})
  void testHasColorSpace_givenPDResourcesAIsInstance_whenA_thenReturnTrue() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertTrue(pdResources.hasColorSpace(COSName.A));
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDDeviceGray#INSTANCE}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test hasColorSpace(COSName); given PDResources() add INSTANCE; when A; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDResources.hasColorSpace(COSName)"})
  void testHasColorSpace_givenPDResourcesAddInstance_whenA_thenReturnFalse() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    // Act and Assert
    assertFalse(pdResources.hasColorSpace(COSName.A));
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDDeviceGray#INSTANCE}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName(
      "Test hasColorSpace(COSName); given PDResources() add INSTANCE; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDResources.hasColorSpace(COSName)"})
  void testHasColorSpace_givenPDResourcesAddInstance_whenNull_thenReturnFalse() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    // Act and Assert
    assertFalse(pdResources.hasColorSpace(null));
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test hasColorSpace(COSName); given PDResources(); when A; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDResources.hasColorSpace(COSName)"})
  void testHasColorSpace_givenPDResources_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDResources().hasColorSpace(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDResources.getExtGState(COSName)"})
  void testGetExtGState() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());

    // Act and Assert
    assertNull(pdResources.getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link
   *       PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName(
      "Test getExtGState(COSName); given PDResources() add PDExtendedGraphicsState(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDResources.getExtGState(COSName)"})
  void testGetExtGState_givenPDResourcesAddPDExtendedGraphicsState_whenA_thenReturnNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act and Assert
    assertNull(pdResources.getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link
   *       PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName(
      "Test getExtGState(COSName); given PDResources() add PDExtendedGraphicsState(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDResources.getExtGState(COSName)"})
  void testGetExtGState_givenPDResourcesAddPDExtendedGraphicsState_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act and Assert
    assertNull(pdResources.getExtGState(null));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName); given PDResources(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDResources.getExtGState(COSName)"})
  void testGetExtGState_givenPDResources_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDResources().getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   *
   * <ul>
   *   <li>Then return FlatnessTolerance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName); then return FlatnessTolerance is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDResources.getExtGState(COSName)"})
  void testGetExtGState_thenReturnFlatnessToleranceIsNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDExtendedGraphicsState());

    // Act
    PDExtendedGraphicsState actualExtGState = pdResources.getExtGState(COSName.A);

    // Assert
    assertNull(actualExtGState.getFlatnessTolerance());
    assertNull(actualExtGState.getLineWidth());
    assertNull(actualExtGState.getMiterLimit());
    assertNull(actualExtGState.getNonStrokingAlphaConstant());
    assertNull(actualExtGState.getSmoothnessTolerance());
    assertNull(actualExtGState.getStrokingAlphaConstant());
    assertNull(actualExtGState.getOverprintMode());
    assertNull(actualExtGState.getTransfer());
    assertNull(actualExtGState.getTransfer2());
    assertNull(actualExtGState.getFontSetting());
    assertNull(actualExtGState.getLineDashPattern());
    assertNull(actualExtGState.getSoftMask());
    assertNull(actualExtGState.getRenderingIntent());
    assertEquals(-1, actualExtGState.getLineCapStyle());
    assertEquals(-1, actualExtGState.getLineJoinStyle());
    assertFalse(actualExtGState.getAlphaSourceFlag());
    assertFalse(actualExtGState.getAutomaticStrokeAdjustment());
    assertFalse(actualExtGState.getNonStrokingOverprintControl());
    assertFalse(actualExtGState.getStrokingOverprintControl());
    assertTrue(actualExtGState.getTextKnockoutFlag());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());

    // Act and Assert
    assertNull(pdResources.getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); given PDResources(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_givenPDResources_whenA_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDResources().getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnArrayLengthIsThree() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    shadingDictionary.setKey(key);

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(1);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType1);
    float[][] values = ((PDShadingType1) actualShading).getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(key, actualShading.getCOSObject().getKey());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnArrayLengthIsThree2() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    shadingDictionary.setKey(key);

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(1);
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType1);
    float[][] values = ((PDShadingType1) actualShading).getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(key, actualShading.getCOSObject().getKey());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return Matrix ShearX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return Matrix ShearX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnMatrixShearXIsZero() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(1);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType1);
    assertNull(((PDShadingType1) actualShading).getDomain());
    Matrix matrix = ((PDShadingType1) actualShading).getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualShading.getShadingType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDShadingType2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnPDShadingType2() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(2);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType2);
    assertNull(((PDShadingType2) actualShading).getCoords());
    assertNull(((PDShadingType2) actualShading).getDomain());
    assertNull(((PDShadingType2) actualShading).getExtend());
    assertEquals(2, actualShading.getShadingType());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDShadingType3}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType3")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnPDShadingType3() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(3);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType3);
    assertNull(((PDShadingType3) actualShading).getCoords());
    assertNull(((PDShadingType3) actualShading).getDomain());
    assertNull(((PDShadingType3) actualShading).getExtend());
    assertEquals(3, actualShading.getShadingType());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDShadingType4}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType4")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnPDShadingType4() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(4);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType4);
    assertEquals(-1, ((PDShadingType4) actualShading).getBitsPerComponent());
    assertEquals(-1, ((PDShadingType4) actualShading).getBitsPerCoordinate());
    assertEquals(-1, ((PDShadingType4) actualShading).getBitsPerFlag());
    assertEquals(4, actualShading.getShadingType());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDShadingType5}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType5")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnPDShadingType5() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(5);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType5);
    assertEquals(-1, ((PDShadingType5) actualShading).getBitsPerComponent());
    assertEquals(-1, ((PDShadingType5) actualShading).getBitsPerCoordinate());
    assertEquals(-1, ((PDShadingType5) actualShading).getVerticesPerRow());
    assertEquals(5, actualShading.getShadingType());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDShadingType6}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType6")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnPDShadingType6() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(6);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType6);
    assertEquals(-1, ((PDShadingType6) actualShading).getBitsPerComponent());
    assertEquals(-1, ((PDShadingType6) actualShading).getBitsPerCoordinate());
    assertEquals(-1, ((PDShadingType6) actualShading).getBitsPerFlag());
    assertEquals(6, actualShading.getShadingType());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDShadingType7}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType7")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_thenReturnPDShadingType7() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(7);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType7);
    assertEquals(-1, ((PDShadingType7) actualShading).getBitsPerComponent());
    assertEquals(-1, ((PDShadingType7) actualShading).getBitsPerCoordinate());
    assertEquals(-1, ((PDShadingType7) actualShading).getBitsPerFlag());
    assertEquals(7, actualShading.getShadingType());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDResources.getShading(COSName)"})
  void testGetShading_whenNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getShading(null));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());

    // Act and Assert
    assertNull(pdResources.getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link
   *       PDShadingPattern#PDShadingPattern()}.
   *   <li>Then return {@link PDShadingPattern}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName(
      "Test getPattern(COSName); given PDResources() A is PDShadingPattern(); then return PDShadingPattern")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern_givenPDResourcesAIsPDShadingPattern_thenReturnPDShadingPattern()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDShadingPattern());

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    assertTrue(actualPattern instanceof PDShadingPattern);
    assertNull(((PDShadingPattern) actualPattern).getShading());
    assertNull(((PDShadingPattern) actualPattern).getExtendedGraphicsState());
    COSDictionary cOSObject = actualPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, actualPattern.getPatternType());
    float[][] values = actualPattern.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link
   *       PDTilingPattern#PDTilingPattern()}.
   *   <li>Then COSObject return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName(
      "Test getPattern(COSName); given PDResources() A is PDTilingPattern(); then COSObject return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern_givenPDResourcesAIsPDTilingPattern_thenCOSObjectReturnCOSStream()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDTilingPattern());

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    assertTrue(actualPattern.getCOSObject() instanceof COSStream);
    assertTrue(actualPattern instanceof PDTilingPattern);
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDShadingPattern#PDShadingPattern()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName(
      "Test getPattern(COSName); given PDResources() add PDShadingPattern(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern_givenPDResourcesAddPDShadingPattern_whenA_thenReturnNull()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act and Assert
    assertNull(pdResources.getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDShadingPattern#PDShadingPattern()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName(
      "Test getPattern(COSName); given PDResources() add PDShadingPattern(); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern_givenPDResourcesAddPDShadingPattern_whenNull_thenReturnNull()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act and Assert
    assertNull(pdResources.getPattern(null));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); given PDResources(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern_givenPDResources_whenA_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDResources().getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <ul>
   *   <li>Then return Contents is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); then return Contents is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern_thenReturnContentsIsNull() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    resourceDictionary.setKey(new COSObjectKey(1L, 1));

    PDShadingPattern pattern = new PDShadingPattern(resourceDictionary);
    pattern.setPatternType(1);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, pattern);

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    assertTrue(actualPattern instanceof PDTilingPattern);
    assertNull(((PDTilingPattern) actualPattern).getContents());
    assertNull(((PDTilingPattern) actualPattern).getContentsForStreamParsing());
    assertNull(((PDTilingPattern) actualPattern).getContentsForRandomAccess());
    assertNull(((PDTilingPattern) actualPattern).getResources());
    assertSame(resourceDictionary, actualPattern.getCOSObject());
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   *
   * <ul>
   *   <li>Then return Contents is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); then return Contents is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern PDResources.getPattern(COSName)"})
  void testGetPattern_thenReturnContentsIsNull2() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    resourceDictionary.setKey(new COSObjectKey(1L, 1));

    PDShadingPattern pattern = new PDShadingPattern(resourceDictionary);
    pattern.setPatternType(1);
    COSDictionary resourceDictionary2 = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary2, new DefaultResourceCache());
    pdResources.put(COSName.A, pattern);

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    assertTrue(actualPattern instanceof PDTilingPattern);
    assertNull(((PDTilingPattern) actualPattern).getContents());
    assertNull(((PDTilingPattern) actualPattern).getContentsForStreamParsing());
    assertNull(((PDTilingPattern) actualPattern).getContentsForRandomAccess());
    assertNull(((PDTilingPattern) actualPattern).getResources());
    assertSame(resourceDictionary, actualPattern.getCOSObject());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName("Test getProperties(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    PDResources pdResources = new PDResources(resourceDictionary, resourceCache);
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    ResourceCache resourceCache2 = pdResources.getResourceCache();
    assertTrue(resourceCache2 instanceof DefaultResourceCache);
    assertEquals("A", name.getName());
    assertNull(actualProperties);
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, pdResources.getCOSObject());
    assertSame(resourceCache, resourceCache2);
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName("Test getProperties(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties2() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDPropertyList properties = PDPropertyList.create(dict);
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    PDResources pdResources = new PDResources(resourceDictionary, resourceCache);
    pdResources.put(COSName.A, properties);
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    ResourceCache resourceCache2 = pdResources.getResourceCache();
    assertTrue(resourceCache2 instanceof DefaultResourceCache);
    assertEquals("A", name.getName());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, pdResources.getCOSObject());
    assertSame(dict, actualProperties.getCOSObject());
    assertSame(resourceCache, resourceCache2);
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName(
      "Test getProperties(COSName); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDPropertyList properties = PDPropertyList.create(dict);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, properties);
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("A", name.getName());
    assertNull(pdResources.getResourceCache());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(dict, actualProperties.getCOSObject());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is create {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName("Test getProperties(COSName); given PDResources() A is create COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_givenPDResourcesAIsCreateCOSDictionary() {
    // Arrange
    PDResources pdResources = new PDResources();
    COSDictionary dict = new COSDictionary();
    pdResources.put(COSName.A, PDPropertyList.create(dict));
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("A", name.getName());
    assertNull(pdResources.getResourceCache());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(dict, actualProperties.getCOSObject());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is create {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName("Test getProperties(COSName); given PDResources() A is create COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_givenPDResourcesAIsCreateCOSDictionary2() {
    // Arrange
    PDResources pdResources = new PDResources();
    COSDictionary dict = new COSDictionary();
    pdResources.put(COSName.A, PDPropertyList.create(dict));
    COSName name = COSName.A;

    // Act
    COSDictionary actualCOSObject = pdResources.getProperties(name).getCOSObject();

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("A", name.getName());
    assertNull(pdResources.getResourceCache());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(dict, actualCOSObject);
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add create {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName(
      "Test getProperties(COSName); given PDResources() add create COSDictionary(); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_givenPDResourcesAddCreateCOSDictionary_whenA_thenReturnNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("A", name.getName());
    assertNull(pdResources.getResourceCache());
    assertNull(actualProperties);
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add create {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName(
      "Test getProperties(COSName); given PDResources() add create COSDictionary(); when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_givenPDResourcesAddCreateCOSDictionary_whenNull_thenNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(null);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertNull(null);
    assertNull(pdResources.getResourceCache());
    assertNull(actualProperties);
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} PropertiesNames is {@link
   *       PDResources#PDResources()} ColorSpaceNames.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName(
      "Test getProperties(COSName); then PDResources() PropertiesNames is PDResources() ColorSpaceNames")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_thenPDResourcesPropertiesNamesIsPDResourcesColorSpaceNames() {
    // Arrange
    PDResources pdResources = new PDResources();
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertEquals("A", name.getName());
    assertNull(pdResources.getResourceCache());
    assertNull(actualProperties);
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getPropertiesNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDOptionalContentGroup}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName("Test getProperties(COSName); then return PDOptionalContentGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_thenReturnPDOptionalContentGroup() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDOptionalContentGroup("Name"));
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);
    COSDictionary actualCOSObject = actualProperties.getCOSObject();

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertTrue(actualProperties instanceof PDOptionalContentGroup);
    assertEquals("A", name.getName());
    assertEquals("Name", ((PDOptionalContentGroup) actualProperties).getName());
    assertNull(actualCOSObject.getKey());
    assertNull(pdResources.getResourceCache());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   *
   * <ul>
   *   <li>Then return {@link PDOptionalContentMembershipDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName("Test getProperties(COSName); then return PDOptionalContentMembershipDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDResources.getProperties(COSName)"})
  void testGetProperties_thenReturnPDOptionalContentMembershipDictionary() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDOptionalContentMembershipDictionary());
    COSName name = COSName.A;

    // Act
    PDPropertyList actualProperties = pdResources.getProperties(name);
    COSDictionary actualCOSObject = actualProperties.getCOSObject();

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertTrue(actualProperties instanceof PDOptionalContentMembershipDictionary);
    assertEquals("A", name.getName());
    assertNull(actualCOSObject.getKey());
    assertNull(pdResources.getResourceCache());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, actualCOSObject.size());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(name.isDirect());
    assertFalse(name.isEmpty());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertTrue(((PDOptionalContentMembershipDictionary) actualProperties).getOCGs().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(
        COSName.ANY_ON,
        ((PDOptionalContentMembershipDictionary) actualProperties).getVisibilityPolicy());
    assertSame(colorSpaceNames, pdResources.getExtGStateNames());
    assertSame(colorSpaceNames, pdResources.getFontNames());
    assertSame(colorSpaceNames, pdResources.getPatternNames());
    assertSame(colorSpaceNames, pdResources.getShadingNames());
    assertSame(colorSpaceNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#isImageXObject(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail {@link
   *       COSStream#COSStream()}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  @DisplayName(
      "Test isImageXObject(COSName); given PDResources() add createThumbnail COSStream(); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDResources.isImageXObject(COSName)"})
  void testIsImageXObject_givenPDResourcesAddCreateThumbnailCOSStream_whenA() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertFalse(pdResources.isImageXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#isImageXObject(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail {@link
   *       COSStream#COSStream()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  @DisplayName(
      "Test isImageXObject(COSName); given PDResources() add createThumbnail COSStream(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDResources.isImageXObject(COSName)"})
  void testIsImageXObject_givenPDResourcesAddCreateThumbnailCOSStream_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertFalse(pdResources.isImageXObject(null));
  }

  /**
   * Test {@link PDResources#isImageXObject(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  @DisplayName("Test isImageXObject(COSName); given PDResources(); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDResources.isImageXObject(COSName)"})
  void testIsImageXObject_givenPDResources_whenA() {
    // Arrange, Act and Assert
    assertFalse(new PDResources().isImageXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   *
   * <p>Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName("Test getXObject(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDXObject PDResources.getXObject(COSName)"})
  void testGetXObject() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());

    // Act and Assert
    assertNull(pdResources.getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail {@link
   *       COSStream#COSStream()}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName(
      "Test getXObject(COSName); given PDResources() add createThumbnail COSStream(); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDXObject PDResources.getXObject(COSName)"})
  void testGetXObject_givenPDResourcesAddCreateThumbnailCOSStream_whenA() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertNull(pdResources.getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail {@link
   *       COSStream#COSStream()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName(
      "Test getXObject(COSName); given PDResources() add createThumbnail COSStream(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDXObject PDResources.getXObject(COSName)"})
  void testGetXObject_givenPDResourcesAddCreateThumbnailCOSStream_whenNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertNull(pdResources.getXObject(null));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName("Test getXObject(COSName); given PDResources(); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDXObject PDResources.getXObject(COSName)"})
  void testGetXObject_givenPDResources_whenA() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDResources().getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getColorSpaceNames()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpaceNames()}
   */
  @Test
  @DisplayName("Test getColorSpaceNames(); given PDResources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getColorSpaceNames()"})
  void testGetColorSpaceNames_givenPDResources_thenReturnEmpty() {
    // Arrange and Act
    Iterable<COSName> actualColorSpaceNames = new PDResources().getColorSpaceNames();
    Iterator<COSName> actualIteratorResult = actualColorSpaceNames.iterator();

    // Assert
    assertTrue(actualColorSpaceNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualColorSpaceNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getColorSpaceNames()}.
   *
   * <ul>
   *   <li>Then return iterator next Name is {@code cs1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getColorSpaceNames()}
   */
  @Test
  @DisplayName("Test getColorSpaceNames(); then return iterator next Name is 'cs1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getColorSpaceNames()"})
  void testGetColorSpaceNames_thenReturnIteratorNextNameIsCs1() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    // Act
    Iterable<COSName> actualColorSpaceNames = pdResources.getColorSpaceNames();
    Iterator<COSName> actualIteratorResult = actualColorSpaceNames.iterator();

    // Assert
    assertTrue(actualColorSpaceNames instanceof Set);
    COSName nextResult = actualIteratorResult.next();
    assertEquals("cs1", nextResult.getName());
    assertNull(nextResult.getKey());
    assertEquals(1, ((Set<COSName>) actualColorSpaceNames).size());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(nextResult.isDirect());
    assertFalse(nextResult.isEmpty());
  }

  /**
   * Test {@link PDResources#getXObjectNames()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getXObjectNames()}
   */
  @Test
  @DisplayName("Test getXObjectNames(); given PDResources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getXObjectNames()"})
  void testGetXObjectNames_givenPDResources_thenReturnEmpty() {
    // Arrange and Act
    Iterable<COSName> actualXObjectNames = new PDResources().getXObjectNames();
    Iterator<COSName> actualIteratorResult = actualXObjectNames.iterator();

    // Assert
    assertTrue(actualXObjectNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualXObjectNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getXObjectNames()}.
   *
   * <ul>
   *   <li>Then return iterator next Name is {@code Im1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getXObjectNames()}
   */
  @Test
  @DisplayName("Test getXObjectNames(); then return iterator next Name is 'Im1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getXObjectNames()"})
  void testGetXObjectNames_thenReturnIteratorNextNameIsIm1() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act
    Iterable<COSName> actualXObjectNames = pdResources.getXObjectNames();
    Iterator<COSName> actualIteratorResult = actualXObjectNames.iterator();

    // Assert
    assertTrue(actualXObjectNames instanceof Set);
    COSName nextResult = actualIteratorResult.next();
    assertEquals("Im1", nextResult.getName());
    assertNull(nextResult.getKey());
    assertEquals(1, ((Set<COSName>) actualXObjectNames).size());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(nextResult.isDirect());
    assertFalse(nextResult.isEmpty());
  }

  /**
   * Test {@link PDResources#getFontNames()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFontNames()}
   */
  @Test
  @DisplayName("Test getFontNames(); given PDResources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getFontNames()"})
  void testGetFontNames_givenPDResources_thenReturnEmpty() {
    // Arrange and Act
    Iterable<COSName> actualFontNames = new PDResources().getFontNames();
    Iterator<COSName> actualIteratorResult = actualFontNames.iterator();

    // Assert
    assertTrue(actualFontNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualFontNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getFontNames()}.
   *
   * <ul>
   *   <li>Then return iterator next Name is {@code F1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getFontNames()}
   */
  @Test
  @DisplayName("Test getFontNames(); then return iterator next Name is 'F1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getFontNames()"})
  void testGetFontNames_thenReturnIteratorNextNameIsF1() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    Iterable<COSName> actualFontNames = pdResources.getFontNames();
    Iterator<COSName> actualIteratorResult = actualFontNames.iterator();

    // Assert
    assertTrue(actualFontNames instanceof Set);
    COSName nextResult = actualIteratorResult.next();
    assertEquals("F1", nextResult.getName());
    assertNull(nextResult.getKey());
    assertEquals(1, ((Set<COSName>) actualFontNames).size());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(nextResult.isDirect());
    assertFalse(nextResult.isEmpty());
  }

  /**
   * Test {@link PDResources#getPropertiesNames()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPropertiesNames()}
   */
  @Test
  @DisplayName("Test getPropertiesNames(); given PDResources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getPropertiesNames()"})
  void testGetPropertiesNames_givenPDResources_thenReturnEmpty() {
    // Arrange and Act
    Iterable<COSName> actualPropertiesNames = new PDResources().getPropertiesNames();
    Iterator<COSName> actualIteratorResult = actualPropertiesNames.iterator();

    // Assert
    assertTrue(actualPropertiesNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualPropertiesNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getPropertiesNames()}.
   *
   * <ul>
   *   <li>Then return iterator next Name is {@code Prop1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPropertiesNames()}
   */
  @Test
  @DisplayName("Test getPropertiesNames(); then return iterator next Name is 'Prop1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getPropertiesNames()"})
  void testGetPropertiesNames_thenReturnIteratorNextNameIsProp1() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Act
    Iterable<COSName> actualPropertiesNames = pdResources.getPropertiesNames();
    Iterator<COSName> actualIteratorResult = actualPropertiesNames.iterator();

    // Assert
    assertTrue(actualPropertiesNames instanceof Set);
    COSName nextResult = actualIteratorResult.next();
    assertEquals("Prop1", nextResult.getName());
    assertNull(nextResult.getKey());
    assertEquals(1, ((Set<COSName>) actualPropertiesNames).size());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(nextResult.isDirect());
    assertFalse(nextResult.isEmpty());
  }

  /**
   * Test {@link PDResources#getShadingNames()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShadingNames()}
   */
  @Test
  @DisplayName("Test getShadingNames(); given PDResources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getShadingNames()"})
  void testGetShadingNames_givenPDResources_thenReturnEmpty() {
    // Arrange and Act
    Iterable<COSName> actualShadingNames = new PDResources().getShadingNames();
    Iterator<COSName> actualIteratorResult = actualShadingNames.iterator();

    // Assert
    assertTrue(actualShadingNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualShadingNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getShadingNames()}.
   *
   * <ul>
   *   <li>Then return iterator next Name is {@code sh1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getShadingNames()}
   */
  @Test
  @DisplayName("Test getShadingNames(); then return iterator next Name is 'sh1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getShadingNames()"})
  void testGetShadingNames_thenReturnIteratorNextNameIsSh1() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act
    Iterable<COSName> actualShadingNames = pdResources.getShadingNames();
    Iterator<COSName> actualIteratorResult = actualShadingNames.iterator();

    // Assert
    assertTrue(actualShadingNames instanceof Set);
    COSName nextResult = actualIteratorResult.next();
    assertEquals("sh1", nextResult.getName());
    assertNull(nextResult.getKey());
    assertEquals(1, ((Set<COSName>) actualShadingNames).size());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(nextResult.isDirect());
    assertFalse(nextResult.isEmpty());
  }

  /**
   * Test {@link PDResources#getPatternNames()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPatternNames()}
   */
  @Test
  @DisplayName("Test getPatternNames(); given PDResources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getPatternNames()"})
  void testGetPatternNames_givenPDResources_thenReturnEmpty() {
    // Arrange and Act
    Iterable<COSName> actualPatternNames = new PDResources().getPatternNames();
    Iterator<COSName> actualIteratorResult = actualPatternNames.iterator();

    // Assert
    assertTrue(actualPatternNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualPatternNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getPatternNames()}.
   *
   * <ul>
   *   <li>Then return iterator next Name is {@code p1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getPatternNames()}
   */
  @Test
  @DisplayName("Test getPatternNames(); then return iterator next Name is 'p1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getPatternNames()"})
  void testGetPatternNames_thenReturnIteratorNextNameIsP1() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act
    Iterable<COSName> actualPatternNames = pdResources.getPatternNames();
    Iterator<COSName> actualIteratorResult = actualPatternNames.iterator();

    // Assert
    assertTrue(actualPatternNames instanceof Set);
    COSName nextResult = actualIteratorResult.next();
    assertEquals("p1", nextResult.getName());
    assertNull(nextResult.getKey());
    assertEquals(1, ((Set<COSName>) actualPatternNames).size());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(nextResult.isDirect());
    assertFalse(nextResult.isEmpty());
  }

  /**
   * Test {@link PDResources#getExtGStateNames()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getExtGStateNames()}
   */
  @Test
  @DisplayName("Test getExtGStateNames(); given PDResources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getExtGStateNames()"})
  void testGetExtGStateNames_givenPDResources_thenReturnEmpty() {
    // Arrange and Act
    Iterable<COSName> actualExtGStateNames = new PDResources().getExtGStateNames();
    Iterator<COSName> actualIteratorResult = actualExtGStateNames.iterator();

    // Assert
    assertTrue(actualExtGStateNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualExtGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getExtGStateNames()}.
   *
   * <ul>
   *   <li>Then return iterator next Name is {@code gs1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#getExtGStateNames()}
   */
  @Test
  @DisplayName("Test getExtGStateNames(); then return iterator next Name is 'gs1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDResources.getExtGStateNames()"})
  void testGetExtGStateNames_thenReturnIteratorNextNameIsGs1() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act
    Iterable<COSName> actualExtGStateNames = pdResources.getExtGStateNames();
    Iterator<COSName> actualIteratorResult = actualExtGStateNames.iterator();

    // Assert
    assertTrue(actualExtGStateNames instanceof Set);
    COSName nextResult = actualIteratorResult.next();
    assertEquals("gs1", nextResult.getName());
    assertNull(nextResult.getKey());
    assertEquals(1, ((Set<COSName>) actualExtGStateNames).size());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(nextResult.isDirect());
    assertFalse(nextResult.isEmpty());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDCalGray#PDCalGray()}.
   *   <li>Then {@link PDDeviceGray#INSTANCE} COSObject {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test add(PDColorSpace) with 'colorSpace'; given PDResources() add PDCalGray(); then INSTANCE COSObject COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDColorSpace)"})
  void testAddWithColorSpace_givenPDResourcesAddPDCalGray_thenInstanceCOSObjectCOSName() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDCalGray());
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(COSName.DEVICEGRAY, cOSObject);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test add(PDColorSpace) with 'colorSpace'; given PDResources(); then PDResources() ColorSpaceNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDColorSpace)"})
  void testAddWithColorSpace_givenPDResources_thenPDResourcesColorSpaceNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.add(PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link PDDeviceRGB#INSTANCE}.
   *   <li>Then {@link PDDeviceRGB#INSTANCE} COSObject {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test add(PDColorSpace) with 'colorSpace'; when INSTANCE; then INSTANCE COSObject COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDColorSpace)"})
  void testAddWithColorSpace_whenInstance_thenInstanceCOSObjectCOSName() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    PDDeviceRGB colorSpace = PDDeviceRGB.INSTANCE;

    // Act
    pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(COSName.DEVICERGB, cOSObject);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.
   *   <li>Then return Name is {@code cs1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; when INSTANCE; then return Name is 'cs1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDColorSpace)"})
  void testAddWithColorSpace_whenInstance_thenReturnNameIsCs1() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertEquals("cs1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertSame(COSName.DEVICEGRAY, colorSpace.getCOSObject());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test add(PDColorSpace) with 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDColorSpace)"})
  void testAddWithColorSpace_whenNull_thenPDResourcesColorSpaceNamesEmpty() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.add((PDColorSpace) null);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertEquals(colorSpaceNames, extGStateNames);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.
   *   <li>Then {@link PDCalGray#PDCalGray()} COSObject {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test add(PDColorSpace) with 'colorSpace'; when PDCalGray(); then PDCalGray() COSObject COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDColorSpace)"})
  void testAddWithColorSpace_whenPDCalGray_thenPDCalGrayCOSObjectCOSArray() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDCalGray colorSpace = new PDCalGray();

    // Act
    pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(COSName.CALGRAY, getResult);
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.
   *   <li>Then return Name is {@code cs2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test add(PDColorSpace) with 'colorSpace'; when PDCalGray(); then return Name is 'cs2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDColorSpace)"})
  void testAddWithColorSpace_whenPDCalGray_thenReturnNameIsCs2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    PDCalGray colorSpace = new PDCalGray();

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("cs2", actualAddResult.getName());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertSame(COSName.CALGRAY, getResult);
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test add(PDExtendedGraphicsState) with 'extGState'; given PDResources(); then PDResources() ExtGStateNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDExtendedGraphicsState)"})
  void testAddWithExtGState_givenPDResources_thenPDResourcesExtGStateNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDExtendedGraphicsState extGState = new PDExtendedGraphicsState();

    // Act
    COSName actualAddResult = pdResources.add(extGState);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject.size());
    assertSame(COSName.NORMAL, extGState.getBlendMode().getCOSName());
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code gs1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test add(PDExtendedGraphicsState) with 'extGState'; given PDResources(); when 'null'; then return Name is 'gs1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDExtendedGraphicsState)"})
  void testAddWithExtGState_givenPDResources_whenNull_thenReturnNameIsGs1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("gs1", pdResources.add((PDExtendedGraphicsState) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   *
   * <ul>
   *   <li>Then return Name is {@code gs2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test add(PDExtendedGraphicsState) with 'extGState'; then return Name is 'gs2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDExtendedGraphicsState)"})
  void testAddWithExtGState_thenReturnNameIsGs2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act
    COSName actualAddResult = pdResources.add(new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) extGStateNames).size());
  }

  /**
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName(
      "Test add(PDFont) with 'font'; given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFont)"})
  void testAddWithFont_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(1L, 1));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    COSName actualAddResult = pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("F2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) fontNames).size());
  }

  /**
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName(
      "Test add(PDFont) with 'font'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFont)"})
  void testAddWithFont_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(new PDMMType1Font(fontDictionary));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("F1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then {@link PDResources#PDResources()} FontNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName(
      "Test add(PDFont) with 'font'; given PDResources(); then PDResources() FontNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFont)"})
  void testAddWithFont_givenPDResources_thenPDResourcesFontNamesSizeIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("F1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code F1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName(
      "Test add(PDFont) with 'font'; given PDResources(); when 'null'; then return Name is 'F1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFont)"})
  void testAddWithFont_givenPDResources_whenNull_thenReturnNameIsF1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("F1", pdResources.add((PDFont) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFont)"})
  void testAddWithFont_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(new PDMMType1Font(fontDictionary));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("F1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   *
   * <ul>
   *   <li>Then return Name is {@code F2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; then return Name is 'F2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFont)"})
  void testAddWithFont_thenReturnNameIsF2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("F2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) fontNames).size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDFormXObject) with 'form'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFormXObject)"})
  void testAddWithForm_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(stream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDFormXObject) with 'form'; given PDResources(); then PDResources() XObjectNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFormXObject)"})
  void testAddWithForm_givenPDResources_thenPDResourcesXObjectNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code Form1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDFormXObject) with 'form'; given PDResources(); when 'null'; then return Name is 'Form1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFormXObject)"})
  void testAddWithForm_givenPDResources_whenNull_thenReturnNameIsForm1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("Form1", pdResources.add((PDFormXObject) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDFormXObject) with 'form'; given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFormXObject)"})
  void testAddWithForm_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(stream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   *
   * <ul>
   *   <li>Then return Name is {@code Form2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; then return Name is 'Form2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDFormXObject)"})
  void testAddWithForm_thenReturnNameIsForm2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDImageXObject) with 'image'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDImageXObject)"})
  void testAddWithImage_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(cosStream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail {@link
   *       COSStream#COSStream()}.
   *   <li>Then return Name is {@code Im2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDImageXObject) with 'image'; given PDResources() add createThumbnail COSStream(); then return Name is 'Im2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDImageXObject)"})
  void testAddWithImage_givenPDResourcesAddCreateThumbnailCOSStream_thenReturnNameIsIm2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDImageXObject) with 'image'; given PDResources(); then PDResources() XObjectNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDImageXObject)"})
  void testAddWithImage_givenPDResources_thenPDResourcesXObjectNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code Im1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDImageXObject) with 'image'; given PDResources(); when 'null'; then return Name is 'Im1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDImageXObject)"})
  void testAddWithImage_givenPDResources_whenNull_thenReturnNameIsIm1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("Im1", pdResources.add((PDImageXObject) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName(
      "Test add(PDImageXObject) with 'image'; given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDImageXObject)"})
  void testAddWithImage_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(cosStream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   *
   * <p>Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test add(PDAbstractPattern) with 'pattern'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDAbstractPattern)"})
  void testAddWithPattern() {
    // Arrange
    PDResources pdResources = new PDResources(new COSDictionary());

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDShadingPattern#PDShadingPattern()}.
   *   <li>Then return Name is {@code p2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test add(PDAbstractPattern) with 'pattern'; given PDResources() add PDShadingPattern(); then return Name is 'p2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDAbstractPattern)"})
  void testAddWithPattern_givenPDResourcesAddPDShadingPattern_thenReturnNameIsP2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) patternNames).size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test add(PDAbstractPattern) with 'pattern'; given PDResources(); then PDResources() PatternNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDAbstractPattern)"})
  void testAddWithPattern_givenPDResources_thenPDResourcesPatternNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code p1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test add(PDAbstractPattern) with 'pattern'; given PDResources(); when 'null'; then return Name is 'p1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDAbstractPattern)"})
  void testAddWithPattern_givenPDResources_whenNull_thenReturnNameIsP1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("p1", pdResources.add((PDAbstractPattern) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test add(PDPropertyList) with 'properties'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDPropertyList)"})
  void testAddWithProperties_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code Prop1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test add(PDPropertyList) with 'properties'; given PDResources(); when 'null'; then return Name is 'Prop1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDPropertyList)"})
  void testAddWithProperties_givenPDResources_whenNull_thenReturnNameIsProp1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("Prop1", pdResources.add((PDPropertyList) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test add(PDPropertyList) with 'properties'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDPropertyList)"})
  void testAddWithProperties_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   *
   * <ul>
   *   <li>Then return Name is {@code Prop2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; then return Name is 'Prop2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDPropertyList)"})
  void testAddWithProperties_thenReturnNameIsProp2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) propertiesNames).size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   *
   * <ul>
   *   <li>When create {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Name is {@code Prop1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test add(PDPropertyList) with 'properties'; when create COSDictionary(); then return Name is 'Prop1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDPropertyList)"})
  void testAddWithProperties_whenCreateCOSDictionary_thenReturnNameIsProp1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   *
   * <ul>
   *   <li>When {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with {@code Name}.
   *   <li>Then return Name is {@code oc1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test add(PDPropertyList) with 'properties'; when PDOptionalContentGroup(String) with 'Name'; then return Name is 'oc1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDPropertyList)"})
  void testAddWithProperties_whenPDOptionalContentGroupWithName_thenReturnNameIsOc1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDOptionalContentGroup("Name"));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("oc1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName(
      "Test add(PDShading) with 'shading'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDShading)"})
  void testAddWithShading_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code sh1}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName(
      "Test add(PDShading) with 'shading'; given PDResources(); when 'null'; then return Name is 'sh1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDShading)"})
  void testAddWithShading_givenPDResources_whenNull_thenReturnNameIsSh1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("sh1", pdResources.add((PDShading) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName(
      "Test add(PDShading) with 'shading'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDShading)"})
  void testAddWithShading_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ShadingNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; then PDResources() ShadingNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDShading)"})
  void testAddWithShading_thenPDResourcesShadingNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   *
   * <ul>
   *   <li>Then return Name is {@code sh2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; then return Name is 'sh2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDShading)"})
  void testAddWithShading_thenReturnNameIsSh2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) shadingNames).size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   *
   * <ul>
   *   <li>When {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName(
      "Test add(PDShading) with 'shading'; when PDShadingType1(COSDictionary) with shadingDictionary is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDShading)"})
  void testAddWithShading_whenPDShadingType1WithShadingDictionaryIsNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("sh1", pdResources.add(new PDShadingType1(null)).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject}, {@code prefix}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName(
      "Test add(PDXObject, String) with 'xobject', 'prefix'; given COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDXObject, String)"})
  void testAddWithXobjectPrefix_givenCOSStreamDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setDirect(true);

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject}, {@code prefix}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is {@link COSObjectKey#COSObjectKey(long, int)}
   *       with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName(
      "Test add(PDXObject, String) with 'xobject', 'prefix'; given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDXObject, String)"})
  void testAddWithXobjectPrefix_givenCOSStreamKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject}, {@code prefix}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName(
      "Test add(PDXObject, String) with 'xobject', 'prefix'; given COSStream(); then PDResources() XObjectNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDXObject, String)"})
  void testAddWithXobjectPrefix_givenCOSStream_thenPDResourcesXObjectNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject}, {@code prefix}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDXObject} {@link PDXObject#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName(
      "Test add(PDXObject, String) with 'xobject', 'prefix'; given 'null'; when PDXObject getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDXObject, String)"})
  void testAddWithXobjectPrefix_givenNull_whenPDXObjectGetCOSObjectReturnNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    assertEquals("Prefix1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject}, {@code prefix}.
   *
   * <ul>
   *   <li>Then return Name is {@code Prefix2}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName(
      "Test add(PDXObject, String) with 'xobject', 'prefix'; then return Name is 'Prefix2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDXObject, String)"})
  void testAddWithXobjectPrefix_thenReturnNameIsPrefix2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject, atLeast(1)).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject}, {@code prefix}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName(
      "Test add(PDXObject, String) with 'xobject', 'prefix'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDXObject, String)"})
  void testAddWithXobjectPrefix_thenThrowIllegalArgumentException() {
    // Arrange
    PDResources pdResources = new PDResources();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.add(xobject, "Prefix"));
    verify(xobject).getCOSObject();
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject}, {@code prefix}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName(
      "Test add(PDXObject, String) with 'xobject', 'prefix'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDResources.add(PDXObject, String)"})
  void testAddWithXobjectPrefix_thenThrowIllegalArgumentException2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.add(xobject, "Prefix"));
    verify(xobject).getCOSObject();
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name}, {@code colorSpace}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; then PDResources() ColorSpaceNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDColorSpace)"})
  void testPutWithNameColorSpace_thenPDResourcesColorSpaceNamesSizeIsTwo() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    // Act
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name}, {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when INSTANCE; then PDResources() ColorSpaceNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDColorSpace)"})
  void testPutWithNameColorSpace_whenInstance_thenPDResourcesColorSpaceNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name}, {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDColorSpace)"})
  void testPutWithNameColorSpace_whenNull_thenPDResourcesColorSpaceNamesEmpty() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDColorSpace) null);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertEquals(colorSpaceNames, extGStateNames);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name}, {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDColorSpace)"})
  void testPutWithNameColorSpace_whenNull_thenPDResourcesColorSpaceNamesEmpty2() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDColorSpace) null);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertEquals(colorSpaceNames, extGStateNames);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name}, {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDColorSpace)"})
  void testPutWithNameColorSpace_whenNull_thenPDResourcesColorSpaceNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name}, {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when PDCalGray(); then PDResources() ColorSpaceNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDColorSpace)"})
  void testPutWithNameColorSpace_whenPDCalGray_thenPDResourcesColorSpaceNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDCalGray());

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with {@code name}, {@code
   * extGState}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; given PDResources(); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDExtendedGraphicsState)"})
  void testPutWithNameExtGState_givenPDResources_whenA() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDExtendedGraphicsState) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with {@code name}, {@code
   * extGState}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; given PDResources(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDExtendedGraphicsState)"})
  void testPutWithNameExtGState_givenPDResources_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDExtendedGraphicsState) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with {@code name}, {@code
   * extGState}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; then PDResources() ExtGStateNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDExtendedGraphicsState)"})
  void testPutWithNameExtGState_thenPDResourcesExtGStateNamesSizeIsTwo() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act
    pdResources.put(COSName.A, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) extGStateNames).size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with {@code name}, {@code
   * extGState}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; when A; then PDResources() ExtGStateNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDExtendedGraphicsState)"})
  void testPutWithNameExtGState_whenA_thenPDResourcesExtGStateNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with {@code name}, {@code
   * extGState}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; when 'null'; then PDResources() ExtGStateNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDExtendedGraphicsState)"})
  void testPutWithNameExtGState_whenNull_thenPDResourcesExtGStateNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDFont) with 'name', 'font'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(COSName.A, new PDMMType1Font(fontDictionary));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDFont) with 'name', 'font'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(null, new PDMMType1Font(fontDictionary));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link PDResources#PDResources()} FontNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when A; then PDResources() FontNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_givenPDResources_whenA_thenPDResourcesFontNamesSizeIsOne()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_givenPDResources_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDFont) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_givenPDResources_whenNull2() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDFont) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} FontNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when 'null'; then PDResources() FontNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_givenPDResources_whenNull_thenPDResourcesFontNamesSizeIsOne()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDFont) with 'name', 'font'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary fontDictionary = new COSDictionary();
    fontDictionary.setDirect(true);

    // Act
    pdResources.put(COSName.A, new PDMMType1Font(fontDictionary));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name}, {@code font}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} FontNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDFont) with 'name', 'font'; then PDResources() FontNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDFont)"})
  void testPutWithNameFont_thenPDResourcesFontNamesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) fontNames).size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name}, {@code pattern}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; given PDResources(); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDAbstractPattern)"})
  void testPutWithNamePattern_givenPDResources_whenA() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDAbstractPattern) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name}, {@code pattern}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; given PDResources(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDAbstractPattern)"})
  void testPutWithNamePattern_givenPDResources_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDAbstractPattern) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name}, {@code pattern}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; then PDResources() PatternNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDAbstractPattern)"})
  void testPutWithNamePattern_thenPDResourcesPatternNamesSizeIsTwo() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act
    pdResources.put(COSName.A, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) patternNames).size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name}, {@code pattern}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; when A; then PDResources() PatternNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDAbstractPattern)"})
  void testPutWithNamePattern_whenA_thenPDResourcesPatternNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name}, {@code pattern}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; when 'null'; then PDResources() PatternNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDAbstractPattern)"})
  void testPutWithNamePattern_whenNull_thenPDResourcesPatternNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(null, PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; given PDResources(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_givenPDResources_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDPropertyList) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; given PDResources(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_givenPDResources_whenNull2() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDPropertyList) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} PropertiesNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; then PDResources() PropertiesNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_thenPDResourcesPropertiesNamesSizeIsTwo() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) propertiesNames).size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link PDResources#PDResources()} PropertiesNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; when A; then PDResources() PropertiesNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_whenA_thenPDResourcesPropertiesNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name}, {@code properties}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} PropertiesNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDPropertyList) with 'name', 'properties'; when 'null'; then PDResources() PropertiesNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDPropertyList)"})
  void testPutWithNameProperties_whenNull_thenPDResourcesPropertiesNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(COSName.A, new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(null, new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; given PDResources(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_givenPDResources_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDShading) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setDirect(true);

    // Act
    pdResources.put(COSName.A, new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ShadingNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; then PDResources() ShadingNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_thenPDResourcesShadingNamesSizeIsTwo() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) shadingNames).size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link PDResources#PDResources()} ShadingNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; when A; then PDResources() ShadingNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_whenA_thenPDResourcesShadingNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} ShadingNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; when 'null'; then PDResources() ShadingNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_whenNull_thenPDResourcesShadingNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name}, {@code shading}.
   *
   * <ul>
   *   <li>When {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDShading) with 'name', 'shading'; when PDShadingType1(COSDictionary) with shadingDictionary is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDShading)"})
  void testPutWithNameShading_whenPDShadingType1WithShadingDictionaryIsNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDShadingType1(null));

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_givenCOSStreamDirectIsTrue() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setDirect(true);

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is {@link COSObjectKey#COSObjectKey(long, int)}
   *       with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_givenCOSStreamKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is {@link COSObjectKey#COSObjectKey(long, int)}
   *       with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_givenCOSStreamKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne2() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdResources.put(null, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream(); when A; then PDResources() XObjectNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_givenCOSStream_whenA_thenPDResourcesXObjectNamesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_givenCOSStream_whenNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdResources.put(null, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PDXObject} {@link PDXObject#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; given 'null'; when PDXObject getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_givenNull_whenPDXObjectGetCOSObjectReturnNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    pdResources.put(null, xobject);

    // Assert
    verify(xobject).getCOSObject();
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; then PDResources() XObjectNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_thenPDResourcesXObjectNamesSizeIsTwo() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_thenThrowIllegalArgumentException() {
    // Arrange
    PDResources pdResources = new PDResources();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.put(COSName.A, xobject));
    verify(xobject).getCOSObject();
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name}, {@code xobject}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName(
      "Test put(COSName, PDXObject) with 'name', 'xobject'; when 'null'; then PDResources() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDResources.put(COSName, PDXObject)"})
  void testPutWithNameXobject_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDXObject) null);

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#getResourceCache()}.
   *
   * <p>Method under test: {@link PDResources#getResourceCache()}
   */
  @Test
  @DisplayName("Test getResourceCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceCache PDResources.getResourceCache()"})
  void testGetResourceCache() {
    // Arrange, Act and Assert
    assertNull(new PDResources().getResourceCache());
  }
}
