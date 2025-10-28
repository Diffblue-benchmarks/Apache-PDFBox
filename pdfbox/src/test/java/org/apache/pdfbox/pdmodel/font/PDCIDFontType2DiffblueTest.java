package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.CmapTable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.GlyphTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.IndexToLocationTable;
import org.apache.fontbox.ttf.KerningTable;
import org.apache.fontbox.ttf.MaximumProfileTable;
import org.apache.fontbox.ttf.NameRecord;
import org.apache.fontbox.ttf.NamingTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDCIDFontType2DiffblueTest {
  /**
   * Method under test: {@link PDCIDFontType2#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDCIDFontType2(new COSDictionary(), null)).getFontMatrix();

    // Assert
    assertEquals(0.001f, actualFontMatrix.getScaleX());
    assertEquals(0.001f, actualFontMatrix.getScaleY());
    assertEquals(0.001f, actualFontMatrix.getScalingFactorX());
    assertEquals(0.001f, actualFontMatrix.getScalingFactorY());
    assertEquals(0.0f, actualFontMatrix.getShearX());
    assertEquals(0.0f, actualFontMatrix.getShearY());
    assertEquals(0.0f, actualFontMatrix.getTranslateX());
    assertEquals(0.0f, actualFontMatrix.getTranslateY());
    float[][] values = actualFontMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test: {@link PDCIDFontType2#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDCIDFontType2(new COSDictionary(), null)).getBoundingBox();

    // Assert
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(-543.9453f, actualBoundingBox.getLowerLeftX());
    assertEquals(1283.2031f, actualBoundingBox.getHeight());
    assertEquals(1301.7578f, actualBoundingBox.getUpperRightX());
    assertEquals(1845.7031f, actualBoundingBox.getWidth());
    assertEquals(979.98047f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Method under test: {@link PDCIDFontType2#getHeight(int)}
   */
  @Test
  void testGetHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDCIDFontType2(new COSDictionary(), null)).getHeight(1));
  }

  /**
   * Method under test: {@link PDCIDFontType2#encode(int)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDCIDFontType2(new COSDictionary(), null)).encode(1));
    assertArrayEquals(new byte[]{3, -103}, (new PDCIDFontType2(new COSDictionary(), null)).encode(1000));
  }

  /**
   * Method under test: {@link PDCIDFontType2#encodeGlyphId(int)}
   */
  @Test
  void testEncodeGlyphId() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 1}, (new PDCIDFontType2(new COSDictionary(), null)).encodeGlyphId(1));
  }

  /**
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}
   */
  @Test
  void testNewPDCIDFontType2() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null);

    // Assert
    TrueTypeFont trueTypeFont = actualPdcidFontType2.getTrueTypeFont();
    HeaderTable header = trueTypeFont.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    CmapLookup unicodeCmapLookup = trueTypeFont.getUnicodeCmapLookup();
    assertTrue(unicodeCmapLookup instanceof CmapSubtable);
    GsubData gsubData = trueTypeFont.getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    PostScriptTable postScript = trueTypeFont.getPostScript();
    String[] glyphNames = postScript.getGlyphNames();
    assertEquals(".notdef", glyphNames[0]);
    assertEquals(".null", glyphNames[1]);
    OS2WindowsMetricsTable oS2Windows = trueTypeFont.getOS2Windows();
    assertEquals("1ASC", oS2Windows.getAchVendId());
    TimeZone timeZone = created.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    NamingTable naming = trueTypeFont.getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(30, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals("Digitized data copyright (c) 2010 Google Corporation. \nCopyright (c) 2012 Red Hat, Inc.",
        getResult.getString());
    GlyphSubstitutionTable gsub = trueTypeFont.getGsub();
    assertEquals("GSUB", gsub.getTag());
    NameRecord getResult2 = nameRecords.get(1);
    assertEquals("Liberation Sans", getResult2.getString());
    assertEquals("Liberation Sans", naming.getFontFamily());
    assertEquals("LiberationSans", naming.getPostScriptName());
    assertEquals("LiberationSans", trueTypeFont.getName());
    NameRecord getResult3 = nameRecords.get(28);
    assertEquals("Licensed under the SIL Open Font License, Version 1.1", getResult3.getString());
    assertEquals("OS/2", oS2Windows.getTag());
    assertEquals("Regular", naming.getFontSubFamily());
    assertEquals("S_BE", glyphNames[2619]);
    assertEquals("UTC", timeZone.getID());
    assertEquals("alefdagesh", glyphNames[2615]);
    assertEquals("aleflamedhatafsegol", glyphNames[2611]);
    assertEquals("aleflamedsegol", glyphNames[2612]);
    assertEquals("aleflamedtsere", glyphNames[2613]);
    assertEquals("alternativelamed", glyphNames[2614]);
    assertEquals("ampersand", glyphNames[9]);
    assertEquals("asterisk", glyphNames[13]);
    assertEquals("breveacute.lc", glyphNames[2601]);
    assertEquals("brevegrave.lc", glyphNames[2602]);
    assertEquals("brevehook", glyphNames[2595]);
    assertEquals("brevehook.lc", glyphNames[2603]);
    assertEquals("brevetilde", glyphNames[2596]);
    assertEquals("brevetilde.lc", glyphNames[2604]);
    assertEquals("circumflexacute.lc", glyphNames[2597]);
    assertEquals("circumflexgrave.lc", glyphNames[2598]);
    assertEquals("circumflexhook.lc", glyphNames[2599]);
    assertEquals("circumflextilde.lc", glyphNames[2600]);
    CmapTable cmap = trueTypeFont.getCmap();
    assertEquals("cmap", cmap.getTag());
    assertEquals("comma", glyphNames[15]);
    assertEquals("dollar", glyphNames[7]);
    assertEquals("exclam", glyphNames[4]);
    assertEquals("finalkafqamats", glyphNames[2609]);
    assertEquals("finalkafsheva", glyphNames[2610]);
    assertEquals("five", glyphNames[24]);
    assertEquals("four", glyphNames[23]);
    Map<String, TTFTable> tableMap = trueTypeFont.getTableMap();
    assertEquals(19, tableMap.size());
    TTFTable getResult4 = tableMap.get("fpgm");
    assertEquals("fpgm", getResult4.getTag());
    GlyphTable glyph = trueTypeFont.getGlyph();
    assertEquals("glyf", glyph.getTag());
    assertEquals("gregory", created.getCalendarType());
    assertEquals("gregory", modified.getCalendarType());
    assertEquals("head", header.getTag());
    HorizontalHeaderTable horizontalHeader = trueTypeFont.getHorizontalHeader();
    assertEquals("hhea", horizontalHeader.getTag());
    HorizontalMetricsTable horizontalMetrics = trueTypeFont.getHorizontalMetrics();
    assertEquals("hmtx", horizontalMetrics.getTag());
    NameRecord getResult5 = nameRecords.get(29);
    assertEquals("http://scripts.sil.org/OFL", getResult5.getString());
    assertEquals("hyphen", glyphNames[Short.SIZE]);
    KerningTable kerning = trueTypeFont.getKerning();
    assertEquals("kern", kerning.getTag());
    assertEquals("lamedholam", glyphNames[2608]);
    assertEquals("lamedholamdagesh", glyphNames[2607]);
    assertEquals("latn", gsubData.getActiveScriptName());
    IndexToLocationTable indexToLocation = trueTypeFont.getIndexToLocation();
    assertEquals("loca", indexToLocation.getTag());
    MaximumProfileTable maximumProfile = trueTypeFont.getMaximumProfile();
    assertEquals("maxp", maximumProfile.getTag());
    assertEquals("name", naming.getTag());
    assertEquals("nonmarkingreturn", glyphNames[2]);
    assertEquals("numbersign", glyphNames[6]);
    assertEquals("one", glyphNames[20]);
    assertEquals("parenleft", glyphNames[11]);
    assertEquals("parenright", glyphNames[PDPanose.LENGTH]);
    assertEquals("percent", glyphNames[8]);
    assertEquals("period", glyphNames[17]);
    assertEquals("plus", glyphNames[14]);
    assertEquals("post", postScript.getTag());
    assertEquals("quotedbl", glyphNames[5]);
    assertEquals("quotesingle", glyphNames[PDPanoseClassification.LENGTH]);
    assertEquals("slash", glyphNames[18]);
    assertEquals("space", glyphNames[3]);
    assertEquals("three", glyphNames[22]);
    assertEquals("tonos.short", glyphNames[2606]);
    assertEquals("two", glyphNames[21]);
    assertEquals("uni05B105BD", glyphNames[2616]);
    assertEquals("uni05B205BD", glyphNames[2617]);
    assertEquals("uni05B305BD", glyphNames[2618]);
    assertEquals("uni1FEF.short", glyphNames[2605]);
    assertEquals("zero", glyphNames[19]);
    assertNull(actualPdcidFontType2.getBaseFont());
    assertNull(actualPdcidFontType2.getName());
    assertNull(trueTypeFont.getVerticalHeader());
    assertNull(trueTypeFont.getVerticalMetrics());
    assertNull(trueTypeFont.getVerticalOrigin());
    assertNull(actualPdcidFontType2.getCIDSystemInfo());
    assertNull(actualPdcidFontType2.getFontDescriptor());
    assertNull(actualPdcidFontType2.getParent());
    assertEquals((short) -1114, header.getXMin());
    assertEquals((short) -1114, horizontalHeader.getMinLeftSideBearing());
    assertEquals((short) -1414, horizontalHeader.getMinRightSideBearing());
    BoundingBox fontBBox = trueTypeFont.getFontBBox();
    assertEquals(-303.22266f, fontBBox.getLowerLeftY());
    BoundingBox boundingBox = actualPdcidFontType2.getBoundingBox();
    assertEquals(-303.22266f, boundingBox.getLowerLeftY());
    assertEquals(-431, oS2Windows.getTypoDescender());
    assertEquals((short) -434, horizontalHeader.getDescender());
    assertEquals(-543.9453f, fontBBox.getLowerLeftX());
    assertEquals(-543.9453f, boundingBox.getLowerLeftX());
    assertEquals((short) -621, header.getYMin());
    assertEquals((short) -67, postScript.getUnderlinePosition());
    assertEquals(0, timeZone.getDSTSavings());
    CmapSubtable[] cmaps = cmap.getCmaps();
    CmapSubtable cmapSubtable = cmaps[1];
    assertEquals(0, cmapSubtable.getPlatformEncodingId());
    assertEquals(0, ((CmapSubtable) unicodeCmapLookup).getPlatformId());
    assertEquals(0, header.getMacStyle());
    assertEquals(0, maximumProfile.getMaxInstructionDefs());
    assertEquals(0, getResult.getLanguageId());
    assertEquals(0, getResult2.getLanguageId());
    assertEquals(0, getResult.getNameId());
    assertEquals(0, getResult.getPlatformEncodingId());
    assertEquals(0, getResult2.getPlatformEncodingId());
    assertEquals(0, oS2Windows.getDefaultChar());
    Matrix fontMatrix = actualPdcidFontType2.getFontMatrix();
    assertEquals(0.001f, fontMatrix.getScaleX());
    assertEquals(0.001f, fontMatrix.getScaleY());
    assertEquals(0.001f, fontMatrix.getScalingFactorX());
    assertEquals(0.001f, fontMatrix.getScalingFactorY());
    assertEquals(0.0f, postScript.getItalicAngle());
    assertEquals(0.0f, fontMatrix.getShearX());
    assertEquals(0.0f, fontMatrix.getShearY());
    assertEquals(0.0f, fontMatrix.getTranslateX());
    assertEquals(0.0f, fontMatrix.getTranslateY());
    assertEquals(0L, oS2Windows.getUnicodeRange4());
    assertEquals(0L, postScript.getIsFixedPitch());
    assertEquals(0L, postScript.getMaxMemType1());
    assertEquals(0L, postScript.getMaxMemType42());
    assertEquals(0L, postScript.getMinMemType1());
    assertEquals(0L, postScript.getMinMemType42());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(0L, offsets[0]);
    assertEquals((short) 0, header.getGlyphDataFormat());
    assertEquals((short) 0, horizontalHeader.getCaretSlopeRun());
    assertEquals((short) 0, horizontalHeader.getMetricDataFormat());
    assertEquals((short) 0, horizontalHeader.getReserved1());
    assertEquals((short) 0, horizontalHeader.getReserved2());
    assertEquals((short) 0, horizontalHeader.getReserved3());
    assertEquals((short) 0, horizontalHeader.getReserved4());
    assertEquals((short) 0, horizontalHeader.getReserved5());
    assertEquals((short) 0, oS2Windows.getFsType());
    assertEquals((short) 0, oS2Windows.getSubscriptXOffset());
    assertEquals((short) 0, oS2Windows.getSuperscriptXOffset());
    assertEquals(1, created.getFirstDayOfWeek());
    assertEquals(1, modified.getFirstDayOfWeek());
    assertEquals(1, created.getMinimalDaysInFirstWeek());
    assertEquals(1, modified.getMinimalDaysInFirstWeek());
    CmapSubtable cmapSubtable2 = cmaps[2];
    assertEquals(1, cmapSubtable2.getPlatformEncodingId());
    assertEquals(1, cmapSubtable.getPlatformId());
    assertEquals(1, maximumProfile.getMaxComponentDepth());
    assertEquals(1, getResult2.getNameId());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult5.getPlatformEncodingId());
    assertEquals(1, getResult.getPlatformId());
    assertEquals(1, getResult2.getPlatformId());
    assertEquals(1.0f, header.getVersion());
    assertEquals(1.0f, horizontalHeader.getVersion());
    assertEquals(1.0f, maximumProfile.getVersion());
    assertEquals(1.0f, trueTypeFont.getVersion());
    assertEquals(1000.0f, actualPdcidFontType2.getAverageFontWidth());
    assertEquals((short) 102, oS2Windows.getStrikeoutSize());
    assertEquals(1033, getResult3.getLanguageId());
    assertEquals(1033, getResult5.getLanguageId());
    assertEquals(10480L, horizontalMetrics.getLength());
    assertEquals(10484L, indexToLocation.getLength());
    assertEquals(106, getResult3.getStringLength());
    assertEquals(1082, oS2Windows.getHeight());
    assertEquals(10931126L, oS2Windows.getCheckSum());
    assertEquals(11016L, cmap.getOffset());
    assertEquals(110741929L, gsub.getCheckSum());
    assertEquals((short) 1187, oS2Windows.getAverageCharWidth());
    assertEquals(12592L, getResult4.getOffset());
    assertEquals(1276856602000L, created.getTimeInMillis());
    assertEquals(1283.2031f, fontBBox.getHeight());
    assertEquals(1283.2031f, boundingBox.getHeight());
    assertEquals(13, getResult3.getNameId());
    assertEquals(1301.7578f, fontBBox.getUpperRightX());
    assertEquals(1301.7578f, boundingBox.getUpperRightX());
    assertEquals((short) 1331, oS2Windows.getSubscriptYSize());
    assertEquals((short) 1331, oS2Windows.getSuperscriptYSize());
    assertEquals(1342208255L, oS2Windows.getUnicodeRange2());
    assertEquals(1360L, offsets[8]);
    assertEquals(14, getResult5.getNameId());
    assertEquals(1409, oS2Windows.getCapHeight());
    assertEquals((short) 1434, oS2Windows.getSubscriptXSize());
    assertEquals((short) 1434, oS2Windows.getSuperscriptXSize());
    assertEquals(1486671388L, glyph.getCheckSum());
    assertEquals(1491, oS2Windows.getTypoAscender());
    assertEquals(15, getResult2.getStringLength());
    assertEquals((short) 150, postScript.getUnderlineThickness());
    assertEquals(1574L, cmap.getLength());
    assertEquals(1594834165L, header.getMagicNumber());
    assertEquals(16048L, indexToLocation.getOffset());
    assertEquals(1608L, offsets[9]);
    assertEquals(1610613183L, oS2Windows.getCodePageRange1());
    assertEquals(1632992662000L, modified.getTimeInMillis());
    assertEquals(176, getResult.getStringOffset());
    assertEquals(1845.7031f, fontBBox.getWidth());
    assertEquals(1845.7031f, boundingBox.getWidth());
    assertEquals(184585137L, header.getCheckSum());
    assertEquals(1854, oS2Windows.getWinAscent());
    assertEquals((short) 1854, horizontalHeader.getAscender());
    assertEquals(19, trueTypeFont.getTables().size());
    assertEquals(1900L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(1952L, offsets[11]);
    assertEquals(1972L, getResult4.getLength());
    assertEquals((short) 1, header.getIndexToLocFormat());
    assertEquals((short) 1, horizontalHeader.getCaretSlopeRise());
    assertEquals(2, maximumProfile.getMaxZones());
    assertEquals(2.0999908f, header.getFontRevision());
    assertEquals(2.0f, postScript.getFormatType());
    assertEquals((short) 2007, header.getYMax());
    assertEquals(2010, created.getWeekYear());
    assertEquals(2021, modified.getWeekYear());
    assertEquals(2048, header.getUnitsPerEm());
    assertEquals(2048, trueTypeFont.getUnitsPerEm());
    assertEquals(2048L, offsets[PDPanose.LENGTH]);
    assertEquals(2053, oS2Windows.getFamilyClass());
    assertEquals(2094322461L, horizontalMetrics.getCheckSum());
    assertEquals(2120332817L, getResult4.getCheckSum());
    assertEquals(2148L, offsets[13]);
    assertEquals(227806649L, horizontalHeader.getCheckSum());
    assertEquals(229311460L, maximumProfile.getCheckSum());
    assertEquals(2300L, offsets[14]);
    assertEquals(2343, getResult3.getStringOffset());
    assertEquals(2372L, gsub.getLength());
    assertEquals(2416L, offsets[15]);
    assertEquals(2492L, offsets[Short.SIZE]);
    assertEquals(2505, getResult5.getStringOffset());
    assertEquals(2548L, offsets[17]);
    assertEquals(2596L, offsets[18]);
    assertEquals(2620, horizontalHeader.getNumberOfHMetrics());
    assertEquals(2620, maximumProfile.getNumGlyphs());
    assertEquals(2620, trueTypeFont.getNumberOfGlyphs());
    assertEquals(2620, glyphNames.length);
    assertEquals(2621, offsets.length);
    assertEquals(2644L, offsets[19]);
    assertEquals(26532L, glyph.getOffset());
    assertEquals((short) 2666, header.getXMax());
    assertEquals((short) 2666, horizontalHeader.getXMaxExtent());
    assertEquals(267256L, offsets[2596]);
    assertEquals(267444L, offsets[2597]);
    assertEquals(267524L, offsets[2598]);
    assertEquals(267600L, offsets[2599]);
    assertEquals(267716L, offsets[2600]);
    assertEquals(267876L, offsets[2601]);
    assertEquals(267964L, offsets[2602]);
    assertEquals(268052L, offsets[2603]);
    assertEquals(268172L, offsets[2604]);
    assertEquals(268324L, offsets[2605]);
    assertEquals(268376L, offsets[2606]);
    assertEquals(268428L, offsets[2607]);
    assertEquals(268460L, offsets[2608]);
    assertEquals(268484L, offsets[2609]);
    assertEquals(268508L, offsets[2610]);
    assertEquals(268532L, offsets[2611]);
    assertEquals(268556L, offsets[2612]);
    assertEquals(268580L, offsets[2613]);
    assertEquals(268604L, offsets[2614]);
    assertEquals(268620L, offsets[2615]);
    assertEquals(268660L, offsets[2616]);
    assertEquals(268892L, offsets[2617]);
    assertEquals(269028L, offsets[2618]);
    assertEquals(269192L, offsets[2619]);
    assertEquals(269356L, glyph.getLength());
    assertEquals(269356L, offsets[2620]);
    assertEquals(27021L, postScript.getLength());
    assertEquals(2740, horizontalHeader.getAdvanceWidthMax());
    assertEquals(2776L, offsets[20]);
    assertEquals((short) 283, oS2Windows.getSubscriptYOffset());
    assertEquals(2864L, offsets[21]);
    assertEquals(2952L, naming.getLength());
    assertEquals(295888L, kerning.getOffset());
    assertEquals(296, getResult2.getStringOffset());
    assertEquals((short) 2, header.getFontDirectionHint());
    Set<String> supportedFeatures = gsubData.getSupportedFeatures();
    assertEquals(3, supportedFeatures.size());
    assertEquals(3, ((CmapSubtable) unicodeCmapLookup).getPlatformEncodingId());
    assertEquals(3, cmapSubtable2.getPlatformId());
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult5.getPlatformId());
    assertEquals(3, oS2Windows.getVersion());
    assertEquals(3, cmaps.length);
    float[][] values = fontMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(301356L, naming.getOffset());
    assertEquals(3020L, offsets[22]);
    assertEquals(304308L, postScript.getOffset());
    assertEquals(307, oS2Windows.getTypoLineGap());
    assertEquals(31, header.getFlags());
    assertEquals(316L, header.getOffset());
    assertEquals(3173227920L, header.getCheckSumAdjustment());
    assertEquals(3240L, offsets[23]);
    assertEquals(32L, maximumProfile.getLength());
    assertEquals(331648L, gsub.getOffset());
    assertEquals(3372L, offsets[24]);
    assertEquals(338, maximumProfile.getMaxPoints());
    assertEquals(33L, oS2Windows.getUnicodeRange3());
    assertEquals(3677516543L, naming.getCheckSum());
    assertEquals(36L, horizontalHeader.getLength());
    assertEquals(372L, horizontalHeader.getOffset());
    assertEquals(3757506560L, oS2Windows.getCodePageRange2());
    assertEquals(3758099199L, oS2Windows.getUnicodeRange1());
    assertEquals(378865164L, indexToLocation.getCheckSum());
    assertEquals(4, maximumProfile.getMaxComponentElements());
    List<Number> fontMatrix2 = trueTypeFont.getFontMatrix();
    assertEquals(6, fontMatrix2.size());
    assertEquals(4.8828125E-4f, fontMatrix2.get(0).floatValue());
    assertEquals(400, oS2Windows.getWeightClass());
    assertEquals(408L, maximumProfile.getOffset());
    assertEquals(410712L, trueTypeFont.getOriginalDataSize());
    assertEquals(4332866L, kerning.getCheckSum());
    assertEquals(434, oS2Windows.getWinDescent());
    assertEquals(438268511L, postScript.getCheckSum());
    assertEquals(44, oS2Windows.getMaxContext());
    assertEquals(440L, oS2Windows.getOffset());
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(5, oS2Windows.getWidthClass());
    byte[] byteArray = new byte[51];
    assertEquals(51, trueTypeFont.getOriginalData().read(byteArray));
    assertEquals(516, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(52, created.getWeeksInWeekYear());
    assertEquals(52, modified.getWeeksInWeekYear());
    assertEquals(52, getResult5.getStringLength());
    assertEquals((short) 530, oS2Windows.getStrikeoutPosition());
    assertEquals(536L, horizontalMetrics.getOffset());
    assertEquals(5466L, kerning.getLength());
    assertEquals(54L, header.getLength());
    assertEquals(6, maximumProfile.getMaxCompositeContours());
    assertEquals(600L, offsets[5]);
    assertEquals(65532, oS2Windows.getLastCharIndex());
    assertEquals(676, maximumProfile.getMaxStackElements());
    assertEquals((short) 67, horizontalHeader.getLineGap());
    assertEquals(680L, offsets[6]);
    Set<String> supportedScriptTags = gsub.getSupportedScriptTags();
    assertEquals(7, supportedScriptTags.size());
    assertEquals(76L, offsets[1]);
    assertEquals(76L, offsets[2]);
    assertEquals(76L, offsets[3]);
    assertEquals(76L, offsets[4]);
    assertEquals(8, header.getLowestRecPPEM());
    assertEquals(84, maximumProfile.getMaxContours());
    assertEquals(843059365L, cmap.getCheckSum());
    assertEquals(87, getResult.getStringLength());
    assertEquals(92, maximumProfile.getMaxCompositePoints());
    assertEquals(92, maximumProfile.getMaxFunctionDefs());
    assertEquals(96L, oS2Windows.getLength());
    assertEquals(976L, offsets[7]);
    assertEquals((short) 977, oS2Windows.getSuperscriptYOffset());
    assertEquals(979.98047f, fontBBox.getUpperRightY());
    assertEquals(979.98047f, boundingBox.getUpperRightY());
    assertEquals(Language.LATIN, gsubData.getLanguage());
    assertFalse(getResult4.getInitialized());
    assertFalse(actualPdcidFontType2.isDamaged());
    assertFalse(actualPdcidFontType2.isEmbedded());
    assertTrue(created.isLenient());
    assertTrue(modified.isLenient());
    assertTrue(created.isWeekDateSupported());
    assertTrue(modified.isWeekDateSupported());
    assertTrue(supportedScriptTags.contains("DFLT"));
    assertTrue(supportedScriptTags.contains("bopo"));
    assertTrue(supportedScriptTags.contains("copt"));
    assertTrue(supportedFeatures.contains("ccmp"));
    assertTrue(supportedFeatures.contains("subs"));
    assertTrue(supportedFeatures.contains("sups"));
    assertTrue(kerning.getHorizontalKerningSubtable().isHorizontalKerning());
    assertTrue(cmap.getInitialized());
    assertTrue(glyph.getInitialized());
    assertTrue(gsub.getInitialized());
    assertTrue(header.getInitialized());
    assertTrue(horizontalHeader.getInitialized());
    assertTrue(horizontalMetrics.getInitialized());
    assertTrue(indexToLocation.getInitialized());
    assertTrue(kerning.getInitialized());
    assertTrue(maximumProfile.getInitialized());
    assertTrue(naming.getInitialized());
    assertTrue(oS2Windows.getInitialized());
    assertTrue(postScript.getInitialized());
    assertTrue(trueTypeFont.isEnableGsub());
    assertEquals(timeZone, modified.getTimeZone());
    assertEquals(Double.SIZE, oS2Windows.getFsSelection());
    assertEquals(Integer.SIZE, oS2Windows.getBreakChar());
    assertEquals(Integer.SIZE, oS2Windows.getFirstCharIndex());
    assertEquals(Short.SIZE, maximumProfile.getMaxTwilightPoints());
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
    assertSame(glyph, tableMap.get("glyf"));
    assertSame(kerning, tableMap.get("kern"));
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertSame(unicodeCmapLookup, cmaps[0]);
    assertSame(gsubData, gsub.getGsubData());
    assertArrayEquals(new byte[]{2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', -127, -7, 28, -79, 0, 6,
        'D', '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', -30, '?', -20, 16, 0, 5, 14, 'T', 0, 0, 1, '*', 'G', 'P', 'O', 'S',
        -14, -32, 14}, byteArray);
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}
   */
  @Test
  void testNewPDCIDFontType22() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    TrueTypeFont trueTypeFont = mock(TrueTypeFont.class);
    when(trueTypeFont.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null, trueTypeFont);

    // Assert
    verify(trueTypeFont).getUnicodeCmapLookup(eq(false));
    assertNull(actualPdcidFontType2.getBaseFont());
    assertNull(actualPdcidFontType2.getName());
    assertNull(actualPdcidFontType2.getBoundingBox());
    assertNull(actualPdcidFontType2.getCIDSystemInfo());
    assertNull(actualPdcidFontType2.getFontDescriptor());
    assertNull(actualPdcidFontType2.getParent());
    Matrix fontMatrix = actualPdcidFontType2.getFontMatrix();
    assertEquals(0.001f, fontMatrix.getScaleX());
    assertEquals(0.001f, fontMatrix.getScaleY());
    assertEquals(0.001f, fontMatrix.getScalingFactorX());
    assertEquals(0.001f, fontMatrix.getScalingFactorY());
    assertEquals(0.0f, fontMatrix.getShearX());
    assertEquals(0.0f, fontMatrix.getShearY());
    assertEquals(0.0f, fontMatrix.getTranslateX());
    assertEquals(0.0f, fontMatrix.getTranslateY());
    assertEquals(1000.0f, actualPdcidFontType2.getAverageFontWidth());
    float[][] values = fontMatrix.getValues();
    assertEquals(3, values.length);
    assertFalse(actualPdcidFontType2.isDamaged());
    assertTrue(actualPdcidFontType2.isEmbedded());
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
    assertSame(trueTypeFont, actualPdcidFontType2.getTrueTypeFont());
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}
   */
  @Test
  void testNewPDCIDFontType23() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    TrueTypeFont trueTypeFont = mock(TrueTypeFont.class);
    when(trueTypeFont.getUnicodeCmapLookup(anyBoolean())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDCIDFontType2(fontDictionary, null, trueTypeFont));

    verify(trueTypeFont).getUnicodeCmapLookup(eq(false));
  }
}
