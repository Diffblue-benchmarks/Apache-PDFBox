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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
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
import org.junit.jupiter.api.Test;

class PDResourcesDiffblueTest {
  /**
   * Test {@link PDResources#PDResources()}.
   * <p>
   * Method under test: {@link PDResources#PDResources()}
   */
  @Test
  @DisplayName("Test new PDResources()")
  void testNewPDResources() {
    // Arrange and Act
    PDResources actualPdResources = new PDResources();

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualPdResources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then ColorSpaceNames return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#PDResources(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDResources(COSDictionary); when COSDictionary(); then ColorSpaceNames return Set")
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then ColorSpaceNames return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName("Test new PDResources(COSDictionary, ResourceCache); when COSDictionary(); then ColorSpaceNames return Set")
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  @DisplayName("Test new PDResources(COSDictionary, ResourceCache, Map); when COSDictionary(); then throw IllegalArgumentException")
  void testNewPDResources_whenCOSDictionary_thenThrowIllegalArgumentException() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDResources(resourceDictionary, new DefaultResourceCache(), null));

  }

  /**
   * Test {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then ColorSpaceNames return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  @DisplayName("Test new PDResources(COSDictionary, ResourceCache, Map); when HashMap(); then ColorSpaceNames return Set")
  void testNewPDResources_whenHashMap_thenColorSpaceNamesReturnSet() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act
    PDResources actualPdResources = new PDResources(resourceDictionary, resourceCache, new HashMap<>());

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
   * Test {@link PDResources#PDResources(COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#PDResources(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDResources(COSDictionary); when 'null'; then throw IllegalArgumentException")
  void testNewPDResources_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDResources(null));
    assertThrows(IllegalArgumentException.class, () -> new PDResources(null, new DefaultResourceCache()));
    assertThrows(IllegalArgumentException.class, () -> new PDResources(null, new DefaultResourceCache(), null));
  }

  /**
   * Test {@link PDResources#getCOSObject()}.
   * <p>
   * Method under test: {@link PDResources#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDResources()).getCOSObject();

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
   * <p>
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName)")
  void testGetFont() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getFont(COSName.A));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); given PDResources() add 'null'; when A; then return 'null'")
  void testGetFont_givenPDResourcesAddNull_whenA_thenReturnNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDFont) null);

    // Act and Assert
    assertNull(pdResources.getFont(COSName.A));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); given PDResources() add PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetFont_givenPDResourcesAddPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getFont(COSName.A));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); given PDResources(); when A; then return 'null'")
  void testGetFont_givenPDResources_whenA_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getFont(COSName.A));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); given PDResources(); when 'null'; then return 'null'")
  void testGetFont_givenPDResources_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getFont(null));
  }

  /**
   * Test {@link PDResources#getFont(COSName)}.
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)}
   * with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  @DisplayName("Test getFont(COSName); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetFont_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
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
    assertSame(key, actualFont.getCOSObject().getKey());
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'")
  void testGetColorSpaceWithName() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name},
   * {@code wasDefault}.
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'")
  void testGetColorSpaceWithNameWasDefault() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name},
   * {@code wasDefault}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is
   * {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; given PDResources() A is INSTANCE")
  void testGetColorSpaceWithNameWasDefault_givenPDResourcesAIsInstance() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name},
   * {@code wasDefault}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@code null} is
   * {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; given PDResources() 'null' is INSTANCE; when 'false'")
  void testGetColorSpaceWithNameWasDefault_givenPDResourcesNullIsInstance_whenFalse() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, false);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name},
   * {@code wasDefault}.
   * <ul>
   *   <li>Then return ARange COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; then return ARange COSArray toList size is four")
  void testGetColorSpaceWithNameWasDefault_thenReturnARangeCOSArrayToListSizeIsFour() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDLab());
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(name, true);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDRange aRange = ((PDLab) actualColorSpace).getARange();
    COSArray cOSArray = aRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult2.size());
    COSBase getResult5 = toListResult2.get(0);
    assertTrue(getResult5 instanceof COSName);
    assertTrue(actualColorSpace instanceof PDLab);
    assertEquals("Lab", ((COSName) getResult5).getName());
    assertEquals("Lab", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(-100.0f, aRange.getMin());
    PDRange bRange = ((PDLab) actualColorSpace).getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(100.0f, aRange.getMax());
    assertEquals(100.0f, bRange.getMax());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(initialColor.isPattern());
    COSArray cOSArray2 = bRange.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertSame(cOSArray, aRange.getCOSObject());
    assertSame(cOSArray2, bRange.getCOSObject());
    assertSame(name.LAB, getResult5);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name},
   * {@code wasDefault}.
   * <ul>
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; then return INSTANCE")
  void testGetColorSpaceWithNameWasDefault_thenReturnInstance() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceRGB.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name},
   * {@code wasDefault}.
   * <ul>
   *   <li>Then return {@link PDCalGray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; then return PDCalGray")
  void testGetColorSpaceWithNameWasDefault_thenReturnPDCalGray() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalGray());
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(name, true);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualColorSpace instanceof PDCalGray);
    assertEquals("CalGray", ((COSName) getResult).getName());
    assertEquals("CalGray", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualColorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualColorSpace).getGamma());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertSame(name.CALGRAY, getResult);
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName, boolean)} with {@code name},
   * {@code wasDefault}.
   * <ul>
   *   <li>Then Whitepoint COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName, boolean) with 'name', 'wasDefault'; then Whitepoint COSObject return COSArray")
  void testGetColorSpaceWithNameWasDefault_thenWhitepointCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalRGB());
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(name, true);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    COSBase cOSObject2 = ((PDCalRGB) actualColorSpace).getWhitepoint().getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    PDGamma gamma = ((PDCalRGB) actualColorSpace).getGamma();
    COSArray cOSArray = gamma.getCOSArray();
    List<? extends COSBase> toListResult2 = cOSArray.toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(0);
    assertTrue(getResult3 instanceof COSName);
    assertTrue(actualColorSpace instanceof PDCalRGB);
    assertEquals("CalRGB", ((COSName) getResult3).getName());
    assertEquals("CalRGB", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult2.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).size());
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(getResult2.isDirect());
    assertFalse(initialColor.isPattern());
    assertEquals(toListResult2, ((COSArray) cOSObject2).toList());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertSame(cOSArray, gamma.getCOSObject());
    assertSame(name.CALRGB, getResult3);
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualColorSpace).getMatrix(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is
   * {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'; given PDResources() A is INSTANCE; when A; then return INSTANCE")
  void testGetColorSpaceWithName_givenPDResourcesAIsInstance_whenA_thenReturnInstance() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is
   * {@link PDDeviceRGB#INSTANCE}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'; given PDResources() A is INSTANCE; when A; then return INSTANCE")
  void testGetColorSpaceWithName_givenPDResourcesAIsInstance_whenA_thenReturnInstance2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceRGB.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is
   * {@link PDCalGray#PDCalGray()}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return {@link PDCalGray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'; given PDResources() A is PDCalGray(); when A; then return PDCalGray")
  void testGetColorSpaceWithName_givenPDResourcesAIsPDCalGray_whenA_thenReturnPDCalGray() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalGray());
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(name);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualColorSpace instanceof PDCalGray);
    assertEquals("CalGray", ((COSName) getResult).getName());
    assertEquals("CalGray", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualColorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualColorSpace).getGamma());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertSame(name.CALGRAY, getResult);
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@code null} is
   * {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'; given PDResources() 'null' is INSTANCE; then return INSTANCE")
  void testGetColorSpaceWithName_givenPDResourcesNullIsInstance_thenReturnInstance() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   * <ul>
   *   <li>Then return ARange COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'; then return ARange COSArray toList size is four")
  void testGetColorSpaceWithName_thenReturnARangeCOSArrayToListSizeIsFour() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDLab());
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(name);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDRange aRange = ((PDLab) actualColorSpace).getARange();
    COSArray cOSArray = aRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult2.size());
    COSBase getResult5 = toListResult2.get(0);
    assertTrue(getResult5 instanceof COSName);
    assertTrue(actualColorSpace instanceof PDLab);
    assertEquals("Lab", ((COSName) getResult5).getName());
    assertEquals("Lab", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(-100.0f, aRange.getMin());
    PDRange bRange = ((PDLab) actualColorSpace).getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(100.0f, aRange.getMax());
    assertEquals(100.0f, bRange.getMax());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(initialColor.isPattern());
    COSArray cOSArray2 = bRange.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertSame(cOSArray, aRange.getCOSObject());
    assertSame(cOSArray2, bRange.getCOSObject());
    assertSame(name.LAB, getResult5);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDResources#getColorSpace(COSName)} with {@code name}.
   * <ul>
   *   <li>Then Whitepoint COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSName) with 'name'; then Whitepoint COSObject return COSArray")
  void testGetColorSpaceWithName_thenWhitepointCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalRGB());
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(name);

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    COSBase cOSObject2 = ((PDCalRGB) actualColorSpace).getWhitepoint().getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    PDGamma gamma = ((PDCalRGB) actualColorSpace).getGamma();
    COSArray cOSArray = gamma.getCOSArray();
    List<? extends COSBase> toListResult2 = cOSArray.toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(0);
    assertTrue(getResult3 instanceof COSName);
    assertTrue(actualColorSpace instanceof PDCalRGB);
    assertEquals("CalRGB", ((COSName) getResult3).getName());
    assertEquals("CalRGB", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult2.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).size());
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(getResult2.isDirect());
    assertFalse(initialColor.isPattern());
    assertEquals(toListResult2, ((COSArray) cOSObject2).toList());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertSame(cOSArray, gamma.getCOSObject());
    assertSame(name.CALRGB, getResult3);
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualColorSpace).getMatrix(), 0.0f);
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is
   * {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test hasColorSpace(COSName); given PDResources() A is INSTANCE; then return 'true'")
  void testHasColorSpace_givenPDResourcesAIsInstance_thenReturnTrue() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertTrue(pdResources.hasColorSpace(COSName.A));
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test hasColorSpace(COSName); given PDResources() add INSTANCE; then return 'false'")
  void testHasColorSpace_givenPDResourcesAddInstance_thenReturnFalse() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertFalse(pdResources.hasColorSpace(COSName.A));
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test hasColorSpace(COSName); given PDResources(); then return 'false'")
  void testHasColorSpace_givenPDResources_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDResources()).hasColorSpace(COSName.A));
  }

  /**
   * Test {@link PDResources#hasColorSpace(COSName)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  @DisplayName("Test hasColorSpace(COSName); then return 'false'")
  void testHasColorSpace_thenReturnFalse() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertFalse(pdResources.hasColorSpace(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   * <p>
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName)")
  void testGetExtGState() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   * <p>
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName)")
  void testGetExtGState2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName); given PDResources() add 'null'; then return 'null'")
  void testGetExtGState_givenPDResourcesAddNull_thenReturnNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDExtendedGraphicsState) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName); given PDResources() add PDExtendedGraphicsState(); then return 'null'")
  void testGetExtGState_givenPDResourcesAddPDExtendedGraphicsState_thenReturnNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName); given PDResources(); then return 'null'")
  void testGetExtGState_givenPDResources_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getExtGState(COSName.A));
  }

  /**
   * Test {@link PDResources#getExtGState(COSName)}.
   * <ul>
   *   <li>Then return FlatnessTolerance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  @DisplayName("Test getExtGState(COSName); then return FlatnessTolerance is 'null'")
  void testGetExtGState_thenReturnFlatnessToleranceIsNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDExtendedGraphicsState());
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    COSName name = COSName.A;

    // Act
    PDExtendedGraphicsState actualExtGState = pdResources.getExtGState(name);

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
    COSDictionary cOSObject = actualExtGState.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExtGState.getFontSetting());
    assertNull(actualExtGState.getLineDashPattern());
    BlendMode blendMode = actualExtGState.getBlendMode();
    assertNull(blendMode.getBlendFunction());
    assertNull(actualExtGState.getSoftMask());
    assertNull(actualExtGState.getRenderingIntent());
    assertEquals(-1, actualExtGState.getLineCapStyle());
    assertEquals(-1, actualExtGState.getLineJoinStyle());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualExtGState.getAlphaSourceFlag());
    assertFalse(actualExtGState.getAutomaticStrokeAdjustment());
    assertFalse(actualExtGState.getNonStrokingOverprintControl());
    assertFalse(actualExtGState.getStrokingOverprintControl());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(actualExtGState.getTextKnockoutFlag());
    COSName expectedCOSName = name.NORMAL;
    assertSame(expectedCOSName, blendMode.getCOSName());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName)")
  void testGetShading() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName)")
  void testGetShading2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); given PDResources() add PDShadingType1(COSDictionary) with shadingDictionary is 'null'")
  void testGetShading_givenPDResourcesAddPDShadingType1WithShadingDictionaryIsNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(null));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); given PDResources(); then return 'null'")
  void testGetShading_givenPDResources_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return 'null'")
  void testGetShading_thenReturnNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getShading(COSName.A));
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Then return {@link PDShadingType1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType1")
  void testGetShading_thenReturnPDShadingType1() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(1);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

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
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Then return {@link PDShadingType2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType2")
  void testGetShading_thenReturnPDShadingType2() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(2);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

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
   * <ul>
   *   <li>Then return {@link PDShadingType3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType3")
  void testGetShading_thenReturnPDShadingType3() throws IOException {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    shading.setShadingType(3);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

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
   * <ul>
   *   <li>Then return {@link PDShadingType4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType4")
  void testGetShading_thenReturnPDShadingType4() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(4);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType4);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType4) actualShading).getBitsPerFlag());
    assertEquals(4, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Then return {@link PDShadingType5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType5")
  void testGetShading_thenReturnPDShadingType5() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(5);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType5);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType5) actualShading).getVerticesPerRow());
    assertEquals(5, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Then return {@link PDShadingType6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType6")
  void testGetShading_thenReturnPDShadingType6() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(6);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType6);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType6) actualShading).getBitsPerFlag());
    assertEquals(6, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Test {@link PDResources#getShading(COSName)}.
   * <ul>
   *   <li>Then return {@link PDShadingType7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  @DisplayName("Test getShading(COSName); then return PDShadingType7")
  void testGetShading_thenReturnPDShadingType7() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(7);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType7);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType7) actualShading).getBitsPerFlag());
    assertEquals(7, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName)")
  void testGetPattern() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is
   * {@link PDShadingPattern#PDShadingPattern()}.</li>
   *   <li>Then return {@link PDShadingPattern}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); given PDResources() A is PDShadingPattern(); then return PDShadingPattern")
  void testGetPattern_givenPDResourcesAIsPDShadingPattern_thenReturnPDShadingPattern() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDShadingPattern());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

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
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); given PDResources() add 'null'; then return 'null'")
  void testGetPattern_givenPDResourcesAddNull_thenReturnNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDAbstractPattern) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDShadingPattern#PDShadingPattern()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); given PDResources() add PDShadingPattern(); then return 'null'")
  void testGetPattern_givenPDResourcesAddPDShadingPattern_thenReturnNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); given PDResources(); then return 'null'")
  void testGetPattern_givenPDResources_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   * <ul>
   *   <li>Then Resources ColorSpaceNames return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); then Resources ColorSpaceNames return Set")
  void testGetPattern_thenResourcesColorSpaceNamesReturnSet() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDTilingPattern());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    PDResources resources = ((PDTilingPattern) actualPattern).getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(actualPattern instanceof PDTilingPattern);
    PDStream contentStream = ((PDTilingPattern) actualPattern).getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream.getFile());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(0, cOSObject2.size());
    assertEquals(0, contentStream.getLength());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(cOSObject, contentStream.getCOSObject());
  }

  /**
   * Test {@link PDResources#getPattern(COSName)}.
   * <ul>
   *   <li>Then return Contents is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); then return Contents is 'null'")
  void testGetPattern_thenReturnContentsIsNull() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    resourceDictionary.setKey(new COSObjectKey(1L, 1));

    PDShadingPattern pattern = new PDShadingPattern(resourceDictionary);
    pattern.setPatternType(1);
    COSDictionary resourceDictionary2 = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary2, new DefaultResourceCache());
    pdResources.put(COSName.A, pattern);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  @DisplayName("Test getPattern(COSName); then return 'null'")
  void testGetPattern_thenReturnNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getPattern(COSName.A));
  }

  /**
   * Test {@link PDResources#getProperties(COSName)}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  @DisplayName("Test getProperties(COSName); then return COSObject is COSDictionary()")
  void testGetProperties_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    PDResources pdResources = new PDResources();
    COSDictionary dict = new COSDictionary();
    pdResources.put(COSName.A, PDPropertyList.create(dict));

    // Act and Assert
    assertSame(dict, pdResources.getProperties(COSName.A).getCOSObject());
  }

  /**
   * Test {@link PDResources#isImageXObject(COSName)}.
   * <p>
   * Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  @DisplayName("Test isImageXObject(COSName)")
  void testIsImageXObject() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertFalse(pdResources.isImageXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#isImageXObject(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  @DisplayName("Test isImageXObject(COSName); given PDResources()")
  void testIsImageXObject_givenPDResources() {
    // Arrange, Act and Assert
    assertFalse((new PDResources()).isImageXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#isImageXObject(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  @DisplayName("Test isImageXObject(COSName); given PDResources() add createThumbnail COSStream()")
  void testIsImageXObject_givenPDResourcesAddCreateThumbnailCOSStream() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertFalse(pdResources.isImageXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   * <p>
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName("Test getXObject(COSName)")
  void testGetXObject() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName("Test getXObject(COSName); given PDResources()")
  void testGetXObject_givenPDResources() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName("Test getXObject(COSName); given PDResources() add createThumbnail COSStream()")
  void testGetXObject_givenPDResourcesAddCreateThumbnailCOSStream() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName("Test getXObject(COSName); given PDResources() add 'null'")
  void testGetXObject_givenPDResourcesAddNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDImageXObject) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getXObject(COSName)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  @DisplayName("Test getXObject(COSName); given PDResources() add PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetXObject_givenPDResourcesAddPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getXObject(COSName.A));
  }

  /**
   * Test {@link PDResources#getColorSpaceNames()}.
   * <p>
   * Method under test: {@link PDResources#getColorSpaceNames()}
   */
  @Test
  @DisplayName("Test getColorSpaceNames()")
  void testGetColorSpaceNames() {
    // Arrange and Act
    Iterable<COSName> actualColorSpaceNames = (new PDResources()).getColorSpaceNames();

    // Assert
    assertTrue(actualColorSpaceNames instanceof Set);
    assertFalse(actualColorSpaceNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualColorSpaceNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getXObjectNames()}.
   * <p>
   * Method under test: {@link PDResources#getXObjectNames()}
   */
  @Test
  @DisplayName("Test getXObjectNames()")
  void testGetXObjectNames() {
    // Arrange and Act
    Iterable<COSName> actualXObjectNames = (new PDResources()).getXObjectNames();

    // Assert
    assertTrue(actualXObjectNames instanceof Set);
    assertFalse(actualXObjectNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualXObjectNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getFontNames()}.
   * <p>
   * Method under test: {@link PDResources#getFontNames()}
   */
  @Test
  @DisplayName("Test getFontNames()")
  void testGetFontNames() {
    // Arrange and Act
    Iterable<COSName> actualFontNames = (new PDResources()).getFontNames();

    // Assert
    assertTrue(actualFontNames instanceof Set);
    assertFalse(actualFontNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualFontNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getPropertiesNames()}.
   * <p>
   * Method under test: {@link PDResources#getPropertiesNames()}
   */
  @Test
  @DisplayName("Test getPropertiesNames()")
  void testGetPropertiesNames() {
    // Arrange and Act
    Iterable<COSName> actualPropertiesNames = (new PDResources()).getPropertiesNames();

    // Assert
    assertTrue(actualPropertiesNames instanceof Set);
    assertFalse(actualPropertiesNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualPropertiesNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getShadingNames()}.
   * <p>
   * Method under test: {@link PDResources#getShadingNames()}
   */
  @Test
  @DisplayName("Test getShadingNames()")
  void testGetShadingNames() {
    // Arrange and Act
    Iterable<COSName> actualShadingNames = (new PDResources()).getShadingNames();

    // Assert
    assertTrue(actualShadingNames instanceof Set);
    assertFalse(actualShadingNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualShadingNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getPatternNames()}.
   * <p>
   * Method under test: {@link PDResources#getPatternNames()}
   */
  @Test
  @DisplayName("Test getPatternNames()")
  void testGetPatternNames() {
    // Arrange and Act
    Iterable<COSName> actualPatternNames = (new PDResources()).getPatternNames();

    // Assert
    assertTrue(actualPatternNames instanceof Set);
    assertFalse(actualPatternNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualPatternNames).isEmpty());
  }

  /**
   * Test {@link PDResources#getExtGStateNames()}.
   * <p>
   * Method under test: {@link PDResources#getExtGStateNames()}
   */
  @Test
  @DisplayName("Test getExtGStateNames()")
  void testGetExtGStateNames() {
    // Arrange and Act
    Iterable<COSName> actualExtGStateNames = (new PDResources()).getExtGStateNames();

    // Assert
    assertTrue(actualExtGStateNames instanceof Set);
    assertFalse(actualExtGStateNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualExtGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDDeviceRGB#INSTANCE}.</li>
   *   <li>Then return Name is {@code cs2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; given PDResources() add INSTANCE; then return Name is 'cs2'")
  void testAddWithColorSpace_givenPDResourcesAddInstance_thenReturnNameIsCs2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceRGB.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("cs2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(2, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; given PDResources() add 'null'")
  void testAddWithColorSpace_givenPDResourcesAddNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDColorSpace) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.add(PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return Name is {@code cs2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; given PDResources() add PDCalGray(); then return Name is 'cs2'")
  void testAddWithColorSpace_givenPDResourcesAddPDCalGray_thenReturnNameIsCs2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDCalGray());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("cs2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(2, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithColorSpace_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.add(PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; then PDResources() ColorSpaceNames size is one")
  void testAddWithColorSpace_thenPDResourcesColorSpaceNamesSizeIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.add(PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; when INSTANCE; then PDResources() COSObject Values size is two")
  void testAddWithColorSpace_whenInstance_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.add(PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames Empty")
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
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then {@link PDCalGray#PDCalGray()} COSObject {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; when PDCalGray(); then PDCalGray() COSObject COSArray")
  void testAddWithColorSpace_whenPDCalGray_thenPDCalGrayCOSObjectCOSArray() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDCalGray colorSpace = new PDCalGray();

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(actualAddResult.CALGRAY, getResult);
    assertSame(extGStateNames, pdResources.getFontNames());
  }

  /**
   * Test {@link PDResources#add(PDColorSpace)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then {@link PDCalGray#PDCalGray()} COSObject {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  @DisplayName("Test add(PDColorSpace) with 'colorSpace'; when PDCalGray(); then PDCalGray() COSObject COSArray")
  void testAddWithColorSpace_whenPDCalGray_thenPDCalGrayCOSObjectCOSArray2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));
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
    assertSame(actualAddResult.CALGRAY, getResult);
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test add(PDExtendedGraphicsState) with 'extGState'; given PDResources() add 'null'")
  void testAddWithExtGState_givenPDResourcesAddNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDExtendedGraphicsState) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test add(PDExtendedGraphicsState) with 'extGState'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithExtGState_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test add(PDExtendedGraphicsState) with 'extGState'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithExtGState_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne2() {
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
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test add(PDExtendedGraphicsState) with 'extGState'; then PDResources() ExtGStateNames size is one")
  void testAddWithExtGState_thenPDResourcesExtGStateNamesSizeIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   * <ul>
   *   <li>Then return Name is {@code gs2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test add(PDExtendedGraphicsState) with 'extGState'; then return Name is 'gs2'")
  void testAddWithExtGState_thenReturnNameIsGs2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) extGStateNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDExtendedGraphicsState)} with {@code extGState}.
   * <ul>
   *   <li>Then return Name is {@code gs3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test add(PDExtendedGraphicsState) with 'extGState'; then return Name is 'gs3'")
  void testAddWithExtGState_thenReturnNameIsGs3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());
    pdResources.add(new PDExtendedGraphicsState());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs3", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, ((Set<COSName>) extGStateNames).size());
  }

  /**
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testAddWithFont_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
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
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} FontNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; given PDResources() add 'null'; then PDResources() FontNames size is one")
  void testAddWithFont_givenPDResourcesAddNull_thenPDResourcesFontNamesSizeIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDFont) null);

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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} FontNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; given PDResources(); then PDResources() FontNames size is one")
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code F1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; given PDResources(); when 'null'; then return Name is 'F1'")
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; given 'true'; when COSDictionary() Direct is 'true'")
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
   * <ul>
   *   <li>Then return Name is {@code F2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; then return Name is 'F2'")
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
   * Test {@link PDResources#add(PDFont)} with {@code font}.
   * <ul>
   *   <li>Then return Name is {@code F3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFont)}
   */
  @Test
  @DisplayName("Test add(PDFont) with 'font'; then return Name is 'F3'")
  void testAddWithFont_thenReturnNameIsF3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("F3", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, ((Set<COSName>) fontNames).size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; given PDResources() add 'null'; then PDResources() COSObject Values size is two")
  void testAddWithForm_givenPDResourcesAddNull_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDImageXObject) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithForm_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; given 'true'; when COSStream() Direct is 'true'")
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
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; then PDResources() COSObject Values size is two")
  void testAddWithForm_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   * <ul>
   *   <li>Then return Name is {@code Form2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; then return Name is 'Form2'")
  void testAddWithForm_thenReturnNameIsForm2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   * <ul>
   *   <li>Then return Name is {@code Form3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; then return Name is 'Form3'")
  void testAddWithForm_thenReturnNameIsForm3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form3", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, ((Set<COSName>) xObjectNames).size());
  }

  /**
   * Test {@link PDResources#add(PDFormXObject)} with {@code form}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  @DisplayName("Test add(PDFormXObject) with 'form'; when 'null'; then PDResources() COSObject Values size is one")
  void testAddWithForm_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("Form1", pdResources.add((PDFormXObject) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName("Test add(PDImageXObject) with 'image'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add createThumbnail
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return Name is {@code Im2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName("Test add(PDImageXObject) with 'image'; given PDResources() add createThumbnail COSStream(); then return Name is 'Im2'")
  void testAddWithImage_givenPDResourcesAddCreateThumbnailCOSStream_thenReturnNameIsIm2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName("Test add(PDImageXObject) with 'image'; given PDResources() add 'null'; then PDResources() COSObject Values size is two")
  void testAddWithImage_givenPDResourcesAddNull_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDImageXObject) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName("Test add(PDImageXObject) with 'image'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithImage_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName("Test add(PDImageXObject) with 'image'; given 'true'; when COSStream() Direct is 'true'")
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
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName("Test add(PDImageXObject) with 'image'; then PDResources() COSObject Values size is two")
  void testAddWithImage_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDImageXObject)} with {@code image}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  @DisplayName("Test add(PDImageXObject) with 'image'; when 'null'; then PDResources() COSObject Values size is one")
  void testAddWithImage_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("Im1", pdResources.add((PDImageXObject) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   * <p>
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test add(PDAbstractPattern) with 'pattern'")
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test add(PDAbstractPattern) with 'pattern'; given PDResources() add 'null'; then PDResources() PatternNames size is one")
  void testAddWithPattern_givenPDResourcesAddNull_thenPDResourcesPatternNamesSizeIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDAbstractPattern) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDShadingPattern#PDShadingPattern()}.</li>
   *   <li>Then return Name is {@code p2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test add(PDAbstractPattern) with 'pattern'; given PDResources() add PDShadingPattern(); then return Name is 'p2'")
  void testAddWithPattern_givenPDResourcesAddPDShadingPattern_thenReturnNameIsP2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) patternNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test add(PDAbstractPattern) with 'pattern'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithPattern_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test add(PDAbstractPattern) with 'pattern'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithPattern_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne2() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("p1", pdResources.add((PDAbstractPattern) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDAbstractPattern)} with {@code pattern}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test add(PDAbstractPattern) with 'pattern'; then PDResources() PatternNames size is one")
  void testAddWithPattern_thenPDResourcesPatternNamesSizeIsOne() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; given PDResources() add 'null'")
  void testAddWithProperties_givenPDResourcesAddNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDPropertyList) null);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithProperties_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; given 'true'; when COSDictionary() Direct is 'true'")
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
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; then PDResources() COSObject Values size is two")
  void testAddWithProperties_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   * <ul>
   *   <li>Then return Name is {@code oc1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; then return Name is 'oc1'")
  void testAddWithProperties_thenReturnNameIsOc1() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDOptionalContentGroup("Prop"));

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
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   * <ul>
   *   <li>Then return Name is {@code Prop2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; then return Name is 'Prop2'")
  void testAddWithProperties_thenReturnNameIsProp2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) propertiesNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   * <ul>
   *   <li>Then return Name is {@code Prop3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; then return Name is 'Prop3'")
  void testAddWithProperties_thenReturnNameIsProp3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));
    pdResources.add(PDPropertyList.create(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop3", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, ((Set<COSName>) propertiesNames).size());
  }

  /**
   * Test {@link PDResources#add(PDPropertyList)} with {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  @DisplayName("Test add(PDPropertyList) with 'properties'; when 'null'; then PDResources() COSObject Values size is one")
  void testAddWithProperties_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act and Assert
    assertEquals("Prop1", pdResources.add((PDPropertyList) null).getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add
   * {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; given PDResources() add PDShadingType1(COSDictionary) with shadingDictionary is 'null'")
  void testAddWithShading_givenPDResourcesAddPDShadingType1WithShadingDictionaryIsNull() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(null));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; given PDResources(); then PDResources() COSObject Values size is one")
  void testAddWithShading_givenPDResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; given 'true'; when COSDictionary() Direct is 'true'")
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
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; then PDResources() COSObject Values size is two")
  void testAddWithShading_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   * <ul>
   *   <li>Then return Name is {@code sh2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; then return Name is 'sh2'")
  void testAddWithShading_thenReturnNameIsSh2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh2", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) shadingNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   * <ul>
   *   <li>Then return Name is {@code sh3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; then return Name is 'sh3'")
  void testAddWithShading_thenReturnNameIsSh3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));
    pdResources.add(new PDShadingType1(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh3", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, ((Set<COSName>) shadingNames).size());
  }

  /**
   * Test {@link PDResources#add(PDShading)} with {@code shading}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; when 'null'; then PDResources() COSObject Values size is one")
  void testAddWithShading_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * <ul>
   *   <li>When {@link PDShadingType1#PDShadingType1(COSDictionary)} with
   * shadingDictionary is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  @DisplayName("Test add(PDShading) with 'shading'; when PDShadingType1(COSDictionary) with shadingDictionary is 'null'")
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
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; given COSStream() Direct is 'true'")
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
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; given COSStream(); then PDResources() XObjectNames size is one")
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
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PDXObject} {@link PDXObject#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; given 'null'; when PDXObject getCOSObject() return 'null'")
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
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; given PDResources() add 'null'")
  void testAddWithXobjectPrefix_givenPDResourcesAddNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add((PDImageXObject) null);
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject, atLeast(1)).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; then PDResources() COSObject Values size is two")
  void testAddWithXobjectPrefix_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Then return Name is {@code Prefix2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; then return Name is 'Prefix2'")
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
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; then throw IllegalArgumentException")
  void testAddWithXobjectPrefix_thenThrowIllegalArgumentException() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.add(xobject, "Prefix"));
    verify(xobject).getCOSObject();
  }

  /**
   * Test {@link PDResources#add(PDXObject, String)} with {@code xobject},
   * {@code prefix}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  @DisplayName("Test add(PDXObject, String) with 'xobject', 'prefix'; then throw IllegalArgumentException")
  void testAddWithXobjectPrefix_thenThrowIllegalArgumentException2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.add(xobject, "Prefix"));
    verify(xobject).getCOSObject();
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name},
   * {@code colorSpace}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; then PDResources() ColorSpaceNames size is two")
  void testPutWithNameColorSpace_thenPDResourcesColorSpaceNamesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(2, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name},
   * {@code colorSpace}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} FontNames {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; then PDResources() FontNames Set")
  void testPutWithNameColorSpace_thenPDResourcesFontNamesSet() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals(1, ((Set<COSName>) fontNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name},
   * {@code colorSpace}.
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when INSTANCE; then PDResources() ColorSpaceNames size is one")
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
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name},
   * {@code colorSpace}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames Empty")
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
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name},
   * {@code colorSpace}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames Empty")
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
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name},
   * {@code colorSpace}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when 'null'; then PDResources() ColorSpaceNames size is one")
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
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
  }

  /**
   * Test {@link PDResources#put(COSName, PDColorSpace)} with {@code name},
   * {@code colorSpace}.
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then {@link PDResources#PDResources()} ColorSpaceNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test put(COSName, PDColorSpace) with 'name', 'colorSpace'; when PDCalGray(); then PDResources() ColorSpaceNames size is one")
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
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with
   * {@code name}, {@code extGState}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; given PDResources(); then PDResources() ExtGStateNames size is one")
  void testPutWithNameExtGState_givenPDResources_thenPDResourcesExtGStateNamesSizeIsOne() {
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
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with
   * {@code name}, {@code extGState}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; then PDResources() COSObject Values size is two")
  void testPutWithNameExtGState_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with
   * {@code name}, {@code extGState}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; then PDResources() ExtGStateNames size is two")
  void testPutWithNameExtGState_thenPDResourcesExtGStateNamesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) extGStateNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with
   * {@code name}, {@code extGState}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; when 'null'; then PDResources() COSObject Values size is one")
  void testPutWithNameExtGState_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with
   * {@code name}, {@code extGState}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; when 'null'; then PDResources() COSObject Values size is one")
  void testPutWithNameExtGState_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne2() {
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
   * Test {@link PDResources#put(COSName, PDExtendedGraphicsState)} with
   * {@code name}, {@code extGState}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} ExtGStateNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test put(COSName, PDExtendedGraphicsState) with 'name', 'extGState'; when 'null'; then PDResources() ExtGStateNames size is one")
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link PDResources#PDResources()} FontNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when A; then PDResources() FontNames size is one")
  void testPutWithNameFont_givenPDResources_whenA_thenPDResourcesFontNamesSizeIsOne() throws IOException {
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when 'null'")
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when 'null'")
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} FontNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given PDResources(); when 'null'; then PDResources() FontNames size is one")
  void testPutWithNameFont_givenPDResources_whenNull_thenPDResourcesFontNamesSizeIsOne() throws IOException {
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; given 'true'; when COSDictionary() Direct is 'true'")
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
   * Test {@link PDResources#put(COSName, PDFont)} with {@code name},
   * {@code font}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} FontNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  @DisplayName("Test put(COSName, PDFont) with 'name', 'font'; then PDResources() FontNames size is two")
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
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name},
   * {@code pattern}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()}.</li>
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; given PDResources(); then PDResources() PatternNames size is one")
  void testPutWithNamePattern_givenPDResources_thenPDResourcesPatternNamesSizeIsOne() {
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
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name},
   * {@code pattern}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; then PDResources() COSObject Values size is two")
  void testPutWithNamePattern_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals(1, ((Set<COSName>) patternNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name},
   * {@code pattern}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; then PDResources() PatternNames size is two")
  void testPutWithNamePattern_thenPDResourcesPatternNamesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) patternNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name},
   * {@code pattern}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; when 'null'; then PDResources() COSObject Values size is one")
  void testPutWithNamePattern_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name},
   * {@code pattern}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; when 'null'; then PDResources() COSObject Values size is one")
  void testPutWithNamePattern_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne2() {
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
   * Test {@link PDResources#put(COSName, PDAbstractPattern)} with {@code name},
   * {@code pattern}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} PatternNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  @DisplayName("Test put(COSName, PDAbstractPattern) with 'name', 'pattern'; when 'null'; then PDResources() PatternNames size is one")
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
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; given 'true'; when COSDictionary() Direct is 'true'")
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
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; then PDResources() COSObject Values size is two")
  void testPutWithNameProperties_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} PropertiesNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; then PDResources() PropertiesNames size is two")
  void testPutWithNameProperties_thenPDResourcesPropertiesNamesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) propertiesNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link PDResources#PDResources()} PropertiesNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; when A; then PDResources() PropertiesNames size is one")
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
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; when 'null'; then PDResources() COSObject Values size is one")
  void testPutWithNameProperties_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; when 'null'; then PDResources() COSObject Values size is one")
  void testPutWithNameProperties_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne2() {
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
   * Test {@link PDResources#put(COSName, PDPropertyList)} with {@code name},
   * {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} PropertiesNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  @DisplayName("Test put(COSName, PDPropertyList) with 'name', 'properties'; when 'null'; then PDResources() PropertiesNames size is one")
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
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; given 'true'; when COSDictionary() Direct is 'true'")
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
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; then PDResources() COSObject Values size is two")
  void testPutWithNameShading_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} ShadingNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; then PDResources() ShadingNames size is two")
  void testPutWithNameShading_thenPDResourcesShadingNamesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) shadingNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link PDResources#PDResources()} ShadingNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; when A; then PDResources() ShadingNames size is one")
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
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; when 'null'; then PDResources() COSObject Values size is one")
  void testPutWithNameShading_whenNull_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} ShadingNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; when 'null'; then PDResources() ShadingNames size is one")
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
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>When {@link PDShadingType1#PDShadingType1(COSDictionary)} with
   * shadingDictionary is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; when PDShadingType1(COSDictionary) with shadingDictionary is 'null'")
  void testPutWithNameShading_whenPDShadingType1WithShadingDictionaryIsNull() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDShadingType1(null));

    // Assert
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDShading)} with {@code name},
   * {@code shading}.
   * <ul>
   *   <li>When {@link PDShadingType1#PDShadingType1(COSDictionary)} with
   * shadingDictionary is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  @DisplayName("Test put(COSName, PDShading) with 'name', 'shading'; when PDShadingType1(COSDictionary) with shadingDictionary is 'null'")
  void testPutWithNameShading_whenPDShadingType1WithShadingDictionaryIsNull2() {
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream() Direct is 'true'")
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream(); when A; then PDResources() XObjectNames size is one")
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; given COSStream(); when 'null'")
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PDXObject} {@link PDXObject#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; given 'null'; when PDXObject getCOSObject() return 'null'")
  void testPutWithNameXobject_givenNull_whenPDXObjectGetCOSObjectReturnNull() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PDXObject} {@link PDXObject#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; given 'null'; when PDXObject getCOSObject() return 'null'")
  void testPutWithNameXobject_givenNull_whenPDXObjectGetCOSObjectReturnNull2() {
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; then PDResources() COSObject Values size is two")
  void testPutWithNameXobject_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; then PDResources() XObjectNames size is two")
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
   * Test {@link PDResources#put(COSName, PDXObject)} with {@code name},
   * {@code xobject}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  @DisplayName("Test put(COSName, PDXObject) with 'name', 'xobject'; then throw IllegalArgumentException")
  void testPutWithNameXobject_thenThrowIllegalArgumentException() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.put(COSName.A, xobject));
    verify(xobject).getCOSObject();
  }

  /**
   * Test {@link PDResources#getResourceCache()}.
   * <p>
   * Method under test: {@link PDResources#getResourceCache()}
   */
  @Test
  @DisplayName("Test getResourceCache()")
  void testGetResourceCache() {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getResourceCache());
  }
}
