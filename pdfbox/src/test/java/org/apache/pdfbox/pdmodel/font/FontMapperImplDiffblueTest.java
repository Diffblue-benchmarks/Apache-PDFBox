package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.CmapTable;
import org.apache.fontbox.ttf.DigitalSignatureTable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.GlyphTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.IndexToLocationTable;
import org.apache.fontbox.ttf.KerningTable;
import org.apache.fontbox.ttf.MaximumProfileTable;
import org.apache.fontbox.ttf.NameRecord;
import org.apache.fontbox.ttf.NamingTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FontMapperImplDiffblueTest {
  /**
   * Test {@link FontMapperImpl#setProvider(FontProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FontMapperImpl} (default constructor) Provider is
   * {@link FontProvider}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#setProvider(FontProvider)}
   */
  @Test
  @DisplayName("Test setProvider(FontProvider); given ArrayList(); then FontMapperImpl (default constructor) Provider is FontProvider")
  void testSetProvider_givenArrayList_thenFontMapperImplProviderIsFontProvider() {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    FontProvider fontProvider = mock(FontProvider.class);
    Mockito.<List<? extends FontInfo>>when(fontProvider.getFontInfo()).thenReturn(new ArrayList<>());

    // Act
    fontMapperImpl.setProvider(fontProvider);

    // Assert
    verify(fontProvider).getFontInfo();
    assertSame(fontProvider, fontMapperImpl.getProvider());
  }

  /**
   * Test {@link FontMapperImpl#setProvider(FontProvider)}.
   * <ul>
   *   <li>Then calls {@link FontInfo#getPostScriptName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#setProvider(FontProvider)}
   */
  @Test
  @DisplayName("Test setProvider(FontProvider); then calls getPostScriptName()")
  void testSetProvider_thenCallsGetPostScriptName() {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getPostScriptName()).thenReturn("Post Script Name");

    ArrayList<FontInfo> fontInfoList = new ArrayList<>();
    fontInfoList.add(fontInfo);
    FontProvider fontProvider = mock(FontProvider.class);
    Mockito.<List<? extends FontInfo>>when(fontProvider.getFontInfo()).thenReturn(fontInfoList);

    // Act
    fontMapperImpl.setProvider(fontProvider);

    // Assert
    verify(fontInfo).getPostScriptName();
    verify(fontProvider).getFontInfo();
    assertSame(fontProvider, fontMapperImpl.getProvider());
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code black}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code black}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given 'black'; when PDFontDescriptor() FontName is 'black'")
  void testGetTrueTypeFont_givenBlack_whenPDFontDescriptorFontNameIsBlack() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("black");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(83, nameRecords.size());
    NameRecord getResult2 = nameRecords.get(82);
    assertEquals("Arial Gras", getResult2.getString());
    assertEquals("Arial-BoldMT", naming.getPostScriptName());
    assertEquals("Arial-BoldMT", font.getName());
    assertEquals("Bold", naming.getFontSubFamily());
    NameRecord getResult3 = nameRecords.get(81);
    assertEquals("Gras", getResult3.getString());
    assertEquals((short) -1286, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1286, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-376.46484f, fontBBox.getLowerLeftY());
    assertEquals(-627.9297f, fontBBox.getLowerLeftX());
    assertEquals((short) -771, header.getYMin());
    assertEquals(1, header.getMacStyle());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult2.getPlatformEncodingId());
    assertEquals(1055.6641f, fontBBox.getUpperRightY());
    KerningTable kerning = font.getKerning();
    assertEquals(1095716573L, kerning.getCheckSum());
    TTFTable getResult4 = tableMap.get("gasp");
    assertEquals(1114121L, getResult4.getCheckSum());
    assertEquals(11229, getResult3.getStringOffset());
    assertEquals(11237, getResult2.getStringOffset());
    assertEquals(12719L, naming.getLength());
    assertEquals(1382640652L, getResult.getCheckSum());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(1425008538L, indexToLocation.getCheckSum());
    assertEquals(1432.1289f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1466, oS2Windows.getCapHeight());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(148, maximumProfile.getMaxCompositePoints());
    assertEquals(155664L, indexToLocation.getOffset());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1584L, offsets[8]);
    TTFTable getResult5 = tableMap.get("fpgm");
    assertEquals(1598L, getResult5.getLength());
    assertEquals(1636646396000L, modified.getTimeInMillis());
    GlyphTable glyph = font.getGlyph();
    assertEquals(173856L, glyph.getOffset());
    assertEquals(1867, maximumProfile.getMaxStackElements());
    assertEquals(1942L, offsets[9]);
    assertEquals(2, getResult3.getNameId());
    assertEquals(20, getResult2.getStringLength());
    assertEquals(2126814685L, glyph.getCheckSum());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 215, postScript.getUnderlineThickness());
    assertEquals((short) 2162, header.getYMax());
    assertEquals(2376L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2472L, offsets[11]);
    assertEquals(2610L, offsets[PDPanose.LENGTH]);
    assertEquals(2627.9297f, fontBBox.getWidth());
    assertEquals(2748L, offsets[13]);
    assertEquals(282L, offsets[5]);
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3056L, offsets[14]);
    assertEquals(3084, getResult3.getLanguageId());
    assertEquals(3084, getResult2.getLanguageId());
    assertEquals(310254220L, horizontalHeader.getCheckSum());
    assertEquals(3123122598L, getResult5.getCheckSum());
    assertEquals(3180L, offsets[15]);
    assertEquals(3292L, offsets[Short.SIZE]);
    assertEquals(3370L, offsets[17]);
    assertEquals(3432L, offsets[18]);
    assertEquals(3443287835L, font.getCmap().getCheckSum());
    assertEquals(3518L, offsets[19]);
    assertEquals(360013488L, oS2Windows.getCheckSum());
    assertEquals(3683418909L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(3778L, offsets[20]);
    assertEquals(3908L, offsets[21]);
    assertEquals(4, getResult2.getNameId());
    assertEquals(4072896406L, header.getCheckSum());
    assertEquals(4280942807L, postScript.getCheckSum());
    assertEquals(431756686L, maximumProfile.getCheckSum());
    assertEquals(4330L, offsets[22]);
    assertEquals(442L, offsets[6]);
    assertEquals(4548, offsets.length);
    assertEquals(456709493L, naming.getCheckSum());
    assertEquals(4597, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(4674L, offsets[23]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4956L, offsets[24]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertEquals(5466L, kerning.getLength());
    assertEquals(6, maximumProfile.getMaxCompositeContours());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(610281544L, gsub.getCheckSum());
    assertEquals(619938L, offsets[4523]);
    assertEquals(620100L, offsets[4524]);
    assertEquals(620274L, offsets[4525]);
    assertEquals(620508L, offsets[4526]);
    assertEquals(620724L, offsets[4527]);
    assertEquals(620990L, offsets[4528]);
    assertEquals(621258L, offsets[4529]);
    assertEquals(621488L, offsets[4530]);
    assertEquals(621710L, offsets[4531]);
    assertEquals(621902L, offsets[4532]);
    assertEquals(622116L, offsets[4533]);
    assertEquals(622354L, offsets[4534]);
    assertEquals(622584L, offsets[4535]);
    assertEquals(622734L, offsets[4536]);
    assertEquals(622806L, offsets[4537]);
    assertEquals(623000L, offsets[4538]);
    assertEquals(623060L, offsets[4539]);
    assertEquals(623122L, offsets[4540]);
    assertEquals(623368L, offsets[4541]);
    assertEquals(623728L, offsets[4542]);
    assertEquals(623886L, offsets[4543]);
    assertEquals(623966L, offsets[4544]);
    assertEquals(624012L, offsets[4545]);
    assertEquals(624056L, offsets[4546]);
    assertEquals(624130L, glyph.getLength());
    assertEquals(624130L, offsets[4547]);
    assertEquals(649956253000L, created.getTimeInMillis());
    assertEquals(700, oS2Windows.getWeightClass());
    assertEquals(722, maximumProfile.getMaxPoints());
    assertEquals(797988L, kerning.getOffset());
    byte[] panose = oS2Windows.getPanose();
    assertEquals((byte) 7, panose[2]);
    assertEquals(8, getResult3.getStringLength());
    assertEquals(803456L, naming.getOffset());
    assertEquals(816176L, postScript.getOffset());
    assertEquals(816208L, getResult4.getOffset());
    assertEquals(86, maximumProfile.getMaxFunctionDefs());
    assertEquals(904L, offsets[7]);
    assertEquals(938983416L, header.getCheckSumAdjustment());
    assertEquals(947748L, gsub.getOffset());
    assertEquals((short) 980, oS2Windows.getAverageCharWidth());
    assertEquals(981628L, getResult.getOffset());
    assertEquals(990208L, font.getOriginalDataSize());
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Integer.SIZE, oS2Windows.getFsSelection());
    assertEquals(PDPanoseClassification.LENGTH, panose.length);
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', 'R', 'i', 'l', '\f', 0, 14,
        -6, '|', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\f', 't', -104, 0, 0, 3, 'X', 'G', 'P', 'O',
        'S', -67, -15, -101}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code bold}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code bold}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given 'bold'; when PDFontDescriptor() FontName is 'bold'")
  void testGetTrueTypeFont_givenBold_whenPDFontDescriptorFontNameIsBold() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("bold");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(83, nameRecords.size());
    NameRecord getResult2 = nameRecords.get(82);
    assertEquals("Arial Gras", getResult2.getString());
    assertEquals("Arial-BoldMT", naming.getPostScriptName());
    assertEquals("Arial-BoldMT", font.getName());
    assertEquals("Bold", naming.getFontSubFamily());
    NameRecord getResult3 = nameRecords.get(81);
    assertEquals("Gras", getResult3.getString());
    assertEquals((short) -1286, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1286, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-376.46484f, fontBBox.getLowerLeftY());
    assertEquals(-627.9297f, fontBBox.getLowerLeftX());
    assertEquals((short) -771, header.getYMin());
    assertEquals(1, header.getMacStyle());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult2.getPlatformEncodingId());
    assertEquals(1055.6641f, fontBBox.getUpperRightY());
    KerningTable kerning = font.getKerning();
    assertEquals(1095716573L, kerning.getCheckSum());
    TTFTable getResult4 = tableMap.get("gasp");
    assertEquals(1114121L, getResult4.getCheckSum());
    assertEquals(11229, getResult3.getStringOffset());
    assertEquals(11237, getResult2.getStringOffset());
    assertEquals(12719L, naming.getLength());
    assertEquals(1382640652L, getResult.getCheckSum());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(1425008538L, indexToLocation.getCheckSum());
    assertEquals(1432.1289f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1466, oS2Windows.getCapHeight());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(148, maximumProfile.getMaxCompositePoints());
    assertEquals(155664L, indexToLocation.getOffset());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1584L, offsets[8]);
    TTFTable getResult5 = tableMap.get("fpgm");
    assertEquals(1598L, getResult5.getLength());
    assertEquals(1636646396000L, modified.getTimeInMillis());
    GlyphTable glyph = font.getGlyph();
    assertEquals(173856L, glyph.getOffset());
    assertEquals(1867, maximumProfile.getMaxStackElements());
    assertEquals(1942L, offsets[9]);
    assertEquals(2, getResult3.getNameId());
    assertEquals(20, getResult2.getStringLength());
    assertEquals(2126814685L, glyph.getCheckSum());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 215, postScript.getUnderlineThickness());
    assertEquals((short) 2162, header.getYMax());
    assertEquals(2376L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2472L, offsets[11]);
    assertEquals(2610L, offsets[PDPanose.LENGTH]);
    assertEquals(2627.9297f, fontBBox.getWidth());
    assertEquals(2748L, offsets[13]);
    assertEquals(282L, offsets[5]);
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3056L, offsets[14]);
    assertEquals(3084, getResult3.getLanguageId());
    assertEquals(3084, getResult2.getLanguageId());
    assertEquals(310254220L, horizontalHeader.getCheckSum());
    assertEquals(3123122598L, getResult5.getCheckSum());
    assertEquals(3180L, offsets[15]);
    assertEquals(3292L, offsets[Short.SIZE]);
    assertEquals(3370L, offsets[17]);
    assertEquals(3432L, offsets[18]);
    assertEquals(3443287835L, font.getCmap().getCheckSum());
    assertEquals(3518L, offsets[19]);
    assertEquals(360013488L, oS2Windows.getCheckSum());
    assertEquals(3683418909L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(3778L, offsets[20]);
    assertEquals(3908L, offsets[21]);
    assertEquals(4, getResult2.getNameId());
    assertEquals(4072896406L, header.getCheckSum());
    assertEquals(4280942807L, postScript.getCheckSum());
    assertEquals(431756686L, maximumProfile.getCheckSum());
    assertEquals(4330L, offsets[22]);
    assertEquals(442L, offsets[6]);
    assertEquals(4548, offsets.length);
    assertEquals(456709493L, naming.getCheckSum());
    assertEquals(4597, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(4674L, offsets[23]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4956L, offsets[24]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertEquals(5466L, kerning.getLength());
    assertEquals(6, maximumProfile.getMaxCompositeContours());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(610281544L, gsub.getCheckSum());
    assertEquals(619938L, offsets[4523]);
    assertEquals(620100L, offsets[4524]);
    assertEquals(620274L, offsets[4525]);
    assertEquals(620508L, offsets[4526]);
    assertEquals(620724L, offsets[4527]);
    assertEquals(620990L, offsets[4528]);
    assertEquals(621258L, offsets[4529]);
    assertEquals(621488L, offsets[4530]);
    assertEquals(621710L, offsets[4531]);
    assertEquals(621902L, offsets[4532]);
    assertEquals(622116L, offsets[4533]);
    assertEquals(622354L, offsets[4534]);
    assertEquals(622584L, offsets[4535]);
    assertEquals(622734L, offsets[4536]);
    assertEquals(622806L, offsets[4537]);
    assertEquals(623000L, offsets[4538]);
    assertEquals(623060L, offsets[4539]);
    assertEquals(623122L, offsets[4540]);
    assertEquals(623368L, offsets[4541]);
    assertEquals(623728L, offsets[4542]);
    assertEquals(623886L, offsets[4543]);
    assertEquals(623966L, offsets[4544]);
    assertEquals(624012L, offsets[4545]);
    assertEquals(624056L, offsets[4546]);
    assertEquals(624130L, glyph.getLength());
    assertEquals(624130L, offsets[4547]);
    assertEquals(649956253000L, created.getTimeInMillis());
    assertEquals(700, oS2Windows.getWeightClass());
    assertEquals(722, maximumProfile.getMaxPoints());
    assertEquals(797988L, kerning.getOffset());
    byte[] panose = oS2Windows.getPanose();
    assertEquals((byte) 7, panose[2]);
    assertEquals(8, getResult3.getStringLength());
    assertEquals(803456L, naming.getOffset());
    assertEquals(816176L, postScript.getOffset());
    assertEquals(816208L, getResult4.getOffset());
    assertEquals(86, maximumProfile.getMaxFunctionDefs());
    assertEquals(904L, offsets[7]);
    assertEquals(938983416L, header.getCheckSumAdjustment());
    assertEquals(947748L, gsub.getOffset());
    assertEquals((short) 980, oS2Windows.getAverageCharWidth());
    assertEquals(981628L, getResult.getOffset());
    assertEquals(990208L, font.getOriginalDataSize());
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Integer.SIZE, oS2Windows.getFsSelection());
    assertEquals(PDPanoseClassification.LENGTH, panose.length);
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', 'R', 'i', 'l', '\f', 0, 14,
        -6, '|', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\f', 't', -104, 0, 0, 3, 'X', 'G', 'P', 'O',
        'S', -67, -15, -101}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code -}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code -}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given '-'; when PDFontDescriptor() FontName is '-'")
  void testGetTrueTypeFont_givenDash_whenPDFontDescriptorFontNameIsDash() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("-");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals("ArialMT", font.getName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, font.getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = font.getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = font.getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    KerningTable kerning = font.getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute
   * {@code +} and {@code +}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given FontMapperImpl (default constructor) addSubstitute '+' and '+'")
  void testGetTrueTypeFont_givenFontMapperImplAddSubstitutePlusSignAndPlusSign() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute("+", "+");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("+", new PDFontDescriptor()).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals("ArialMT", font.getName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, font.getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = font.getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = font.getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    KerningTable kerning = font.getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code Helvetica}.</li>
   *   <li>Then return not Fallback.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when 'Helvetica'; then return not Fallback")
  void testGetTrueTypeFont_givenFontMapperImpl_whenHelvetica_thenReturnNotFallback() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act
    FontMapping<TrueTypeFont> actualTrueTypeFont = fontMapperImpl.getTrueTypeFont("Helvetica", new PDFontDescriptor());

    // Assert
    TrueTypeFont font = actualTrueTypeFont.getFont();
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertFalse(actualTrueTypeFont.isFallback());
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code heavy}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code heavy}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given 'heavy'; when PDFontDescriptor() FontName is 'heavy'")
  void testGetTrueTypeFont_givenHeavy_whenPDFontDescriptorFontNameIsHeavy() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("heavy");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(83, nameRecords.size());
    NameRecord getResult2 = nameRecords.get(82);
    assertEquals("Arial Gras", getResult2.getString());
    assertEquals("Arial-BoldMT", naming.getPostScriptName());
    assertEquals("Arial-BoldMT", font.getName());
    assertEquals("Bold", naming.getFontSubFamily());
    NameRecord getResult3 = nameRecords.get(81);
    assertEquals("Gras", getResult3.getString());
    assertEquals((short) -1286, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1286, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-376.46484f, fontBBox.getLowerLeftY());
    assertEquals(-627.9297f, fontBBox.getLowerLeftX());
    assertEquals((short) -771, header.getYMin());
    assertEquals(1, header.getMacStyle());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult2.getPlatformEncodingId());
    assertEquals(1055.6641f, fontBBox.getUpperRightY());
    KerningTable kerning = font.getKerning();
    assertEquals(1095716573L, kerning.getCheckSum());
    TTFTable getResult4 = tableMap.get("gasp");
    assertEquals(1114121L, getResult4.getCheckSum());
    assertEquals(11229, getResult3.getStringOffset());
    assertEquals(11237, getResult2.getStringOffset());
    assertEquals(12719L, naming.getLength());
    assertEquals(1382640652L, getResult.getCheckSum());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(1425008538L, indexToLocation.getCheckSum());
    assertEquals(1432.1289f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1466, oS2Windows.getCapHeight());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(148, maximumProfile.getMaxCompositePoints());
    assertEquals(155664L, indexToLocation.getOffset());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1584L, offsets[8]);
    TTFTable getResult5 = tableMap.get("fpgm");
    assertEquals(1598L, getResult5.getLength());
    assertEquals(1636646396000L, modified.getTimeInMillis());
    GlyphTable glyph = font.getGlyph();
    assertEquals(173856L, glyph.getOffset());
    assertEquals(1867, maximumProfile.getMaxStackElements());
    assertEquals(1942L, offsets[9]);
    assertEquals(2, getResult3.getNameId());
    assertEquals(20, getResult2.getStringLength());
    assertEquals(2126814685L, glyph.getCheckSum());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 215, postScript.getUnderlineThickness());
    assertEquals((short) 2162, header.getYMax());
    assertEquals(2376L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2472L, offsets[11]);
    assertEquals(2610L, offsets[PDPanose.LENGTH]);
    assertEquals(2627.9297f, fontBBox.getWidth());
    assertEquals(2748L, offsets[13]);
    assertEquals(282L, offsets[5]);
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3056L, offsets[14]);
    assertEquals(3084, getResult3.getLanguageId());
    assertEquals(3084, getResult2.getLanguageId());
    assertEquals(310254220L, horizontalHeader.getCheckSum());
    assertEquals(3123122598L, getResult5.getCheckSum());
    assertEquals(3180L, offsets[15]);
    assertEquals(3292L, offsets[Short.SIZE]);
    assertEquals(3370L, offsets[17]);
    assertEquals(3432L, offsets[18]);
    assertEquals(3443287835L, font.getCmap().getCheckSum());
    assertEquals(3518L, offsets[19]);
    assertEquals(360013488L, oS2Windows.getCheckSum());
    assertEquals(3683418909L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(3778L, offsets[20]);
    assertEquals(3908L, offsets[21]);
    assertEquals(4, getResult2.getNameId());
    assertEquals(4072896406L, header.getCheckSum());
    assertEquals(4280942807L, postScript.getCheckSum());
    assertEquals(431756686L, maximumProfile.getCheckSum());
    assertEquals(4330L, offsets[22]);
    assertEquals(442L, offsets[6]);
    assertEquals(4548, offsets.length);
    assertEquals(456709493L, naming.getCheckSum());
    assertEquals(4597, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(4674L, offsets[23]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4956L, offsets[24]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertEquals(5466L, kerning.getLength());
    assertEquals(6, maximumProfile.getMaxCompositeContours());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(610281544L, gsub.getCheckSum());
    assertEquals(619938L, offsets[4523]);
    assertEquals(620100L, offsets[4524]);
    assertEquals(620274L, offsets[4525]);
    assertEquals(620508L, offsets[4526]);
    assertEquals(620724L, offsets[4527]);
    assertEquals(620990L, offsets[4528]);
    assertEquals(621258L, offsets[4529]);
    assertEquals(621488L, offsets[4530]);
    assertEquals(621710L, offsets[4531]);
    assertEquals(621902L, offsets[4532]);
    assertEquals(622116L, offsets[4533]);
    assertEquals(622354L, offsets[4534]);
    assertEquals(622584L, offsets[4535]);
    assertEquals(622734L, offsets[4536]);
    assertEquals(622806L, offsets[4537]);
    assertEquals(623000L, offsets[4538]);
    assertEquals(623060L, offsets[4539]);
    assertEquals(623122L, offsets[4540]);
    assertEquals(623368L, offsets[4541]);
    assertEquals(623728L, offsets[4542]);
    assertEquals(623886L, offsets[4543]);
    assertEquals(623966L, offsets[4544]);
    assertEquals(624012L, offsets[4545]);
    assertEquals(624056L, offsets[4546]);
    assertEquals(624130L, glyph.getLength());
    assertEquals(624130L, offsets[4547]);
    assertEquals(649956253000L, created.getTimeInMillis());
    assertEquals(700, oS2Windows.getWeightClass());
    assertEquals(722, maximumProfile.getMaxPoints());
    assertEquals(797988L, kerning.getOffset());
    byte[] panose = oS2Windows.getPanose();
    assertEquals((byte) 7, panose[2]);
    assertEquals(8, getResult3.getStringLength());
    assertEquals(803456L, naming.getOffset());
    assertEquals(816176L, postScript.getOffset());
    assertEquals(816208L, getResult4.getOffset());
    assertEquals(86, maximumProfile.getMaxFunctionDefs());
    assertEquals(904L, offsets[7]);
    assertEquals(938983416L, header.getCheckSumAdjustment());
    assertEquals(947748L, gsub.getOffset());
    assertEquals((short) 980, oS2Windows.getAverageCharWidth());
    assertEquals(981628L, getResult.getOffset());
    assertEquals(990208L, font.getOriginalDataSize());
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Integer.SIZE, oS2Windows.getFsSelection());
    assertEquals(PDPanoseClassification.LENGTH, panose.length);
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', 'R', 'i', 'l', '\f', 0, 14,
        -6, '|', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\f', 't', -104, 0, 0, 3, 'X', 'G', 'P', 'O',
        'S', -67, -15, -101}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code Base Font}.</li>
   *   <li>Then return Font Naming PostScriptName is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when 'Base Font'; then return Font Naming PostScriptName is 'ArialMT'")
  void testGetTrueTypeFont_whenBaseFont_thenReturnFontNamingPostScriptNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor()).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals("ArialMT", font.getName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, font.getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = font.getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = font.getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    KerningTable kerning = font.getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return Font Naming PostScriptName is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when ','; then return Font Naming PostScriptName is 'ArialMT'")
  void testGetTrueTypeFont_whenComma_thenReturnFontNamingPostScriptNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont(",", new PDFontDescriptor()).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals("ArialMT", font.getName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, font.getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = font.getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = font.getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    KerningTable kerning = font.getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Font Naming PostScriptName is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when 'null'; then return Font Naming PostScriptName is 'ArialMT'")
  void testGetTrueTypeFont_whenNull_thenReturnFontNamingPostScriptNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont(null, new PDFontDescriptor()).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals("ArialMT", font.getName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, font.getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = font.getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = font.getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    KerningTable kerning = font.getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then return Font Naming PostScriptName is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when '+'; then return Font Naming PostScriptName is 'ArialMT'")
  void testGetTrueTypeFont_whenPlusSign_thenReturnFontNamingPostScriptNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("+", new PDFontDescriptor()).getFont();
    HeaderTable header = font.getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    NamingTable naming = font.getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals("ArialMT", font.getName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = font.getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = font.getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, font.getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = font.getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = font.getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = font.getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = font.getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = font.getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    KerningTable kerning = font.getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, font.getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code black}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code black}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given 'black'; when PDFontDescriptor() FontName is 'black'")
  void testGetFontBoxFont_givenBlack_whenPDFontDescriptorFontNameIsBlack() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("black");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(83, nameRecords.size());
    NameRecord getResult2 = nameRecords.get(82);
    assertEquals("Arial Gras", getResult2.getString());
    assertEquals("Arial-BoldMT", font.getName());
    assertEquals("Arial-BoldMT", naming.getPostScriptName());
    assertEquals("Bold", naming.getFontSubFamily());
    NameRecord getResult3 = nameRecords.get(81);
    assertEquals("Gras", getResult3.getString());
    assertEquals((short) -1286, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1286, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-376.46484f, fontBBox.getLowerLeftY());
    assertEquals(-627.9297f, fontBBox.getLowerLeftX());
    assertEquals((short) -771, header.getYMin());
    assertEquals(1, header.getMacStyle());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult2.getPlatformEncodingId());
    assertEquals(1055.6641f, fontBBox.getUpperRightY());
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(1095716573L, kerning.getCheckSum());
    TTFTable getResult4 = tableMap.get("gasp");
    assertEquals(1114121L, getResult4.getCheckSum());
    assertEquals(11229, getResult3.getStringOffset());
    assertEquals(11237, getResult2.getStringOffset());
    assertEquals(12719L, naming.getLength());
    assertEquals(1382640652L, getResult.getCheckSum());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(1425008538L, indexToLocation.getCheckSum());
    assertEquals(1432.1289f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1466, oS2Windows.getCapHeight());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(148, maximumProfile.getMaxCompositePoints());
    assertEquals(155664L, indexToLocation.getOffset());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1584L, offsets[8]);
    TTFTable getResult5 = tableMap.get("fpgm");
    assertEquals(1598L, getResult5.getLength());
    assertEquals(1636646396000L, modified.getTimeInMillis());
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173856L, glyph.getOffset());
    assertEquals(1867, maximumProfile.getMaxStackElements());
    assertEquals(1942L, offsets[9]);
    assertEquals(2, getResult3.getNameId());
    assertEquals(20, getResult2.getStringLength());
    assertEquals(2126814685L, glyph.getCheckSum());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 215, postScript.getUnderlineThickness());
    assertEquals((short) 2162, header.getYMax());
    assertEquals(2376L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2472L, offsets[11]);
    assertEquals(2610L, offsets[PDPanose.LENGTH]);
    assertEquals(2627.9297f, fontBBox.getWidth());
    assertEquals(2748L, offsets[13]);
    assertEquals(282L, offsets[5]);
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3056L, offsets[14]);
    assertEquals(3084, getResult3.getLanguageId());
    assertEquals(3084, getResult2.getLanguageId());
    assertEquals(310254220L, horizontalHeader.getCheckSum());
    assertEquals(3123122598L, getResult5.getCheckSum());
    assertEquals(3180L, offsets[15]);
    assertEquals(3292L, offsets[Short.SIZE]);
    assertEquals(3370L, offsets[17]);
    assertEquals(3432L, offsets[18]);
    assertEquals(3443287835L, ((TrueTypeFont) font).getCmap().getCheckSum());
    assertEquals(3518L, offsets[19]);
    assertEquals(360013488L, oS2Windows.getCheckSum());
    assertEquals(3683418909L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(3778L, offsets[20]);
    assertEquals(3908L, offsets[21]);
    assertEquals(4, getResult2.getNameId());
    assertEquals(4072896406L, header.getCheckSum());
    assertEquals(4280942807L, postScript.getCheckSum());
    assertEquals(431756686L, maximumProfile.getCheckSum());
    assertEquals(4330L, offsets[22]);
    assertEquals(442L, offsets[6]);
    assertEquals(4548, offsets.length);
    assertEquals(456709493L, naming.getCheckSum());
    assertEquals(4597, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(4674L, offsets[23]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4956L, offsets[24]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertEquals(5466L, kerning.getLength());
    assertEquals(6, maximumProfile.getMaxCompositeContours());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(610281544L, gsub.getCheckSum());
    assertEquals(619938L, offsets[4523]);
    assertEquals(620100L, offsets[4524]);
    assertEquals(620274L, offsets[4525]);
    assertEquals(620508L, offsets[4526]);
    assertEquals(620724L, offsets[4527]);
    assertEquals(620990L, offsets[4528]);
    assertEquals(621258L, offsets[4529]);
    assertEquals(621488L, offsets[4530]);
    assertEquals(621710L, offsets[4531]);
    assertEquals(621902L, offsets[4532]);
    assertEquals(622116L, offsets[4533]);
    assertEquals(622354L, offsets[4534]);
    assertEquals(622584L, offsets[4535]);
    assertEquals(622734L, offsets[4536]);
    assertEquals(622806L, offsets[4537]);
    assertEquals(623000L, offsets[4538]);
    assertEquals(623060L, offsets[4539]);
    assertEquals(623122L, offsets[4540]);
    assertEquals(623368L, offsets[4541]);
    assertEquals(623728L, offsets[4542]);
    assertEquals(623886L, offsets[4543]);
    assertEquals(623966L, offsets[4544]);
    assertEquals(624012L, offsets[4545]);
    assertEquals(624056L, offsets[4546]);
    assertEquals(624130L, glyph.getLength());
    assertEquals(624130L, offsets[4547]);
    assertEquals(649956253000L, created.getTimeInMillis());
    assertEquals(700, oS2Windows.getWeightClass());
    assertEquals(722, maximumProfile.getMaxPoints());
    assertEquals(797988L, kerning.getOffset());
    byte[] panose = oS2Windows.getPanose();
    assertEquals((byte) 7, panose[2]);
    assertEquals(8, getResult3.getStringLength());
    assertEquals(803456L, naming.getOffset());
    assertEquals(816176L, postScript.getOffset());
    assertEquals(816208L, getResult4.getOffset());
    assertEquals(86, maximumProfile.getMaxFunctionDefs());
    assertEquals(904L, offsets[7]);
    assertEquals(938983416L, header.getCheckSumAdjustment());
    assertEquals(947748L, gsub.getOffset());
    assertEquals((short) 980, oS2Windows.getAverageCharWidth());
    assertEquals(981628L, getResult.getOffset());
    assertEquals(990208L, ((TrueTypeFont) font).getOriginalDataSize());
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Integer.SIZE, oS2Windows.getFsSelection());
    assertEquals(PDPanoseClassification.LENGTH, panose.length);
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', 'R', 'i', 'l', '\f', 0, 14,
        -6, '|', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\f', 't', -104, 0, 0, 3, 'X', 'G', 'P', 'O',
        'S', -67, -15, -101}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code bold}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code bold}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given 'bold'; when PDFontDescriptor() FontName is 'bold'")
  void testGetFontBoxFont_givenBold_whenPDFontDescriptorFontNameIsBold() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("bold");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(83, nameRecords.size());
    NameRecord getResult2 = nameRecords.get(82);
    assertEquals("Arial Gras", getResult2.getString());
    assertEquals("Arial-BoldMT", font.getName());
    assertEquals("Arial-BoldMT", naming.getPostScriptName());
    assertEquals("Bold", naming.getFontSubFamily());
    NameRecord getResult3 = nameRecords.get(81);
    assertEquals("Gras", getResult3.getString());
    assertEquals((short) -1286, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1286, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-376.46484f, fontBBox.getLowerLeftY());
    assertEquals(-627.9297f, fontBBox.getLowerLeftX());
    assertEquals((short) -771, header.getYMin());
    assertEquals(1, header.getMacStyle());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult2.getPlatformEncodingId());
    assertEquals(1055.6641f, fontBBox.getUpperRightY());
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(1095716573L, kerning.getCheckSum());
    TTFTable getResult4 = tableMap.get("gasp");
    assertEquals(1114121L, getResult4.getCheckSum());
    assertEquals(11229, getResult3.getStringOffset());
    assertEquals(11237, getResult2.getStringOffset());
    assertEquals(12719L, naming.getLength());
    assertEquals(1382640652L, getResult.getCheckSum());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(1425008538L, indexToLocation.getCheckSum());
    assertEquals(1432.1289f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1466, oS2Windows.getCapHeight());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(148, maximumProfile.getMaxCompositePoints());
    assertEquals(155664L, indexToLocation.getOffset());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1584L, offsets[8]);
    TTFTable getResult5 = tableMap.get("fpgm");
    assertEquals(1598L, getResult5.getLength());
    assertEquals(1636646396000L, modified.getTimeInMillis());
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173856L, glyph.getOffset());
    assertEquals(1867, maximumProfile.getMaxStackElements());
    assertEquals(1942L, offsets[9]);
    assertEquals(2, getResult3.getNameId());
    assertEquals(20, getResult2.getStringLength());
    assertEquals(2126814685L, glyph.getCheckSum());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 215, postScript.getUnderlineThickness());
    assertEquals((short) 2162, header.getYMax());
    assertEquals(2376L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2472L, offsets[11]);
    assertEquals(2610L, offsets[PDPanose.LENGTH]);
    assertEquals(2627.9297f, fontBBox.getWidth());
    assertEquals(2748L, offsets[13]);
    assertEquals(282L, offsets[5]);
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3056L, offsets[14]);
    assertEquals(3084, getResult3.getLanguageId());
    assertEquals(3084, getResult2.getLanguageId());
    assertEquals(310254220L, horizontalHeader.getCheckSum());
    assertEquals(3123122598L, getResult5.getCheckSum());
    assertEquals(3180L, offsets[15]);
    assertEquals(3292L, offsets[Short.SIZE]);
    assertEquals(3370L, offsets[17]);
    assertEquals(3432L, offsets[18]);
    assertEquals(3443287835L, ((TrueTypeFont) font).getCmap().getCheckSum());
    assertEquals(3518L, offsets[19]);
    assertEquals(360013488L, oS2Windows.getCheckSum());
    assertEquals(3683418909L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(3778L, offsets[20]);
    assertEquals(3908L, offsets[21]);
    assertEquals(4, getResult2.getNameId());
    assertEquals(4072896406L, header.getCheckSum());
    assertEquals(4280942807L, postScript.getCheckSum());
    assertEquals(431756686L, maximumProfile.getCheckSum());
    assertEquals(4330L, offsets[22]);
    assertEquals(442L, offsets[6]);
    assertEquals(4548, offsets.length);
    assertEquals(456709493L, naming.getCheckSum());
    assertEquals(4597, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(4674L, offsets[23]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4956L, offsets[24]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertEquals(5466L, kerning.getLength());
    assertEquals(6, maximumProfile.getMaxCompositeContours());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(610281544L, gsub.getCheckSum());
    assertEquals(619938L, offsets[4523]);
    assertEquals(620100L, offsets[4524]);
    assertEquals(620274L, offsets[4525]);
    assertEquals(620508L, offsets[4526]);
    assertEquals(620724L, offsets[4527]);
    assertEquals(620990L, offsets[4528]);
    assertEquals(621258L, offsets[4529]);
    assertEquals(621488L, offsets[4530]);
    assertEquals(621710L, offsets[4531]);
    assertEquals(621902L, offsets[4532]);
    assertEquals(622116L, offsets[4533]);
    assertEquals(622354L, offsets[4534]);
    assertEquals(622584L, offsets[4535]);
    assertEquals(622734L, offsets[4536]);
    assertEquals(622806L, offsets[4537]);
    assertEquals(623000L, offsets[4538]);
    assertEquals(623060L, offsets[4539]);
    assertEquals(623122L, offsets[4540]);
    assertEquals(623368L, offsets[4541]);
    assertEquals(623728L, offsets[4542]);
    assertEquals(623886L, offsets[4543]);
    assertEquals(623966L, offsets[4544]);
    assertEquals(624012L, offsets[4545]);
    assertEquals(624056L, offsets[4546]);
    assertEquals(624130L, glyph.getLength());
    assertEquals(624130L, offsets[4547]);
    assertEquals(649956253000L, created.getTimeInMillis());
    assertEquals(700, oS2Windows.getWeightClass());
    assertEquals(722, maximumProfile.getMaxPoints());
    assertEquals(797988L, kerning.getOffset());
    byte[] panose = oS2Windows.getPanose();
    assertEquals((byte) 7, panose[2]);
    assertEquals(8, getResult3.getStringLength());
    assertEquals(803456L, naming.getOffset());
    assertEquals(816176L, postScript.getOffset());
    assertEquals(816208L, getResult4.getOffset());
    assertEquals(86, maximumProfile.getMaxFunctionDefs());
    assertEquals(904L, offsets[7]);
    assertEquals(938983416L, header.getCheckSumAdjustment());
    assertEquals(947748L, gsub.getOffset());
    assertEquals((short) 980, oS2Windows.getAverageCharWidth());
    assertEquals(981628L, getResult.getOffset());
    assertEquals(990208L, ((TrueTypeFont) font).getOriginalDataSize());
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Integer.SIZE, oS2Windows.getFsSelection());
    assertEquals(PDPanoseClassification.LENGTH, panose.length);
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', 'R', 'i', 'l', '\f', 0, 14,
        -6, '|', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\f', 't', -104, 0, 0, 3, 'X', 'G', 'P', 'O',
        'S', -67, -15, -101}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code -}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code -}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given '-'; when PDFontDescriptor() FontName is '-'")
  void testGetFontBoxFont_givenDash_whenPDFontDescriptorFontNameIsDash() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("-");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("ArialMT", font.getName());
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, ((TrueTypeFont) font).getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = ((TrueTypeFont) font).getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code heavy}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is
   * {@code heavy}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given 'heavy'; when PDFontDescriptor() FontName is 'heavy'")
  void testGetFontBoxFont_givenHeavy_whenPDFontDescriptorFontNameIsHeavy() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("heavy");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(83, nameRecords.size());
    NameRecord getResult2 = nameRecords.get(82);
    assertEquals("Arial Gras", getResult2.getString());
    assertEquals("Arial-BoldMT", font.getName());
    assertEquals("Arial-BoldMT", naming.getPostScriptName());
    assertEquals("Bold", naming.getFontSubFamily());
    NameRecord getResult3 = nameRecords.get(81);
    assertEquals("Gras", getResult3.getString());
    assertEquals((short) -1286, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1286, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-376.46484f, fontBBox.getLowerLeftY());
    assertEquals(-627.9297f, fontBBox.getLowerLeftX());
    assertEquals((short) -771, header.getYMin());
    assertEquals(1, header.getMacStyle());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult2.getPlatformEncodingId());
    assertEquals(1055.6641f, fontBBox.getUpperRightY());
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(1095716573L, kerning.getCheckSum());
    TTFTable getResult4 = tableMap.get("gasp");
    assertEquals(1114121L, getResult4.getCheckSum());
    assertEquals(11229, getResult3.getStringOffset());
    assertEquals(11237, getResult2.getStringOffset());
    assertEquals(12719L, naming.getLength());
    assertEquals(1382640652L, getResult.getCheckSum());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(1425008538L, indexToLocation.getCheckSum());
    assertEquals(1432.1289f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1466, oS2Windows.getCapHeight());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(148, maximumProfile.getMaxCompositePoints());
    assertEquals(155664L, indexToLocation.getOffset());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1584L, offsets[8]);
    TTFTable getResult5 = tableMap.get("fpgm");
    assertEquals(1598L, getResult5.getLength());
    assertEquals(1636646396000L, modified.getTimeInMillis());
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173856L, glyph.getOffset());
    assertEquals(1867, maximumProfile.getMaxStackElements());
    assertEquals(1942L, offsets[9]);
    assertEquals(2, getResult3.getNameId());
    assertEquals(20, getResult2.getStringLength());
    assertEquals(2126814685L, glyph.getCheckSum());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 215, postScript.getUnderlineThickness());
    assertEquals((short) 2162, header.getYMax());
    assertEquals(2376L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2472L, offsets[11]);
    assertEquals(2610L, offsets[PDPanose.LENGTH]);
    assertEquals(2627.9297f, fontBBox.getWidth());
    assertEquals(2748L, offsets[13]);
    assertEquals(282L, offsets[5]);
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3056L, offsets[14]);
    assertEquals(3084, getResult3.getLanguageId());
    assertEquals(3084, getResult2.getLanguageId());
    assertEquals(310254220L, horizontalHeader.getCheckSum());
    assertEquals(3123122598L, getResult5.getCheckSum());
    assertEquals(3180L, offsets[15]);
    assertEquals(3292L, offsets[Short.SIZE]);
    assertEquals(3370L, offsets[17]);
    assertEquals(3432L, offsets[18]);
    assertEquals(3443287835L, ((TrueTypeFont) font).getCmap().getCheckSum());
    assertEquals(3518L, offsets[19]);
    assertEquals(360013488L, oS2Windows.getCheckSum());
    assertEquals(3683418909L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(3778L, offsets[20]);
    assertEquals(3908L, offsets[21]);
    assertEquals(4, getResult2.getNameId());
    assertEquals(4072896406L, header.getCheckSum());
    assertEquals(4280942807L, postScript.getCheckSum());
    assertEquals(431756686L, maximumProfile.getCheckSum());
    assertEquals(4330L, offsets[22]);
    assertEquals(442L, offsets[6]);
    assertEquals(4548, offsets.length);
    assertEquals(456709493L, naming.getCheckSum());
    assertEquals(4597, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(4674L, offsets[23]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4956L, offsets[24]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertEquals(5466L, kerning.getLength());
    assertEquals(6, maximumProfile.getMaxCompositeContours());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(610281544L, gsub.getCheckSum());
    assertEquals(619938L, offsets[4523]);
    assertEquals(620100L, offsets[4524]);
    assertEquals(620274L, offsets[4525]);
    assertEquals(620508L, offsets[4526]);
    assertEquals(620724L, offsets[4527]);
    assertEquals(620990L, offsets[4528]);
    assertEquals(621258L, offsets[4529]);
    assertEquals(621488L, offsets[4530]);
    assertEquals(621710L, offsets[4531]);
    assertEquals(621902L, offsets[4532]);
    assertEquals(622116L, offsets[4533]);
    assertEquals(622354L, offsets[4534]);
    assertEquals(622584L, offsets[4535]);
    assertEquals(622734L, offsets[4536]);
    assertEquals(622806L, offsets[4537]);
    assertEquals(623000L, offsets[4538]);
    assertEquals(623060L, offsets[4539]);
    assertEquals(623122L, offsets[4540]);
    assertEquals(623368L, offsets[4541]);
    assertEquals(623728L, offsets[4542]);
    assertEquals(623886L, offsets[4543]);
    assertEquals(623966L, offsets[4544]);
    assertEquals(624012L, offsets[4545]);
    assertEquals(624056L, offsets[4546]);
    assertEquals(624130L, glyph.getLength());
    assertEquals(624130L, offsets[4547]);
    assertEquals(649956253000L, created.getTimeInMillis());
    assertEquals(700, oS2Windows.getWeightClass());
    assertEquals(722, maximumProfile.getMaxPoints());
    assertEquals(797988L, kerning.getOffset());
    byte[] panose = oS2Windows.getPanose();
    assertEquals((byte) 7, panose[2]);
    assertEquals(8, getResult3.getStringLength());
    assertEquals(803456L, naming.getOffset());
    assertEquals(816176L, postScript.getOffset());
    assertEquals(816208L, getResult4.getOffset());
    assertEquals(86, maximumProfile.getMaxFunctionDefs());
    assertEquals(904L, offsets[7]);
    assertEquals(938983416L, header.getCheckSumAdjustment());
    assertEquals(947748L, gsub.getOffset());
    assertEquals((short) 980, oS2Windows.getAverageCharWidth());
    assertEquals(981628L, getResult.getOffset());
    assertEquals(990208L, ((TrueTypeFont) font).getOriginalDataSize());
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Integer.SIZE, oS2Windows.getFsSelection());
    assertEquals(PDPanoseClassification.LENGTH, panose.length);
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', 'R', 'i', 'l', '\f', 0, 14,
        -6, '|', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\f', 't', -104, 0, 0, 3, 'X', 'G', 'P', 'O',
        'S', -67, -15, -101}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return Font Name is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when ','; then return Font Name is 'ArialMT'")
  void testGetFontBoxFont_whenComma_thenReturnFontNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(",", new PDFontDescriptor()).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("ArialMT", font.getName());
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, ((TrueTypeFont) font).getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = ((TrueTypeFont) font).getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code Helvetica}.</li>
   *   <li>Then return not Fallback.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when 'Helvetica'; then return not Fallback")
  void testGetFontBoxFont_whenHelvetica_thenReturnNotFallback() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act
    FontMapping<FontBoxFont> actualFontBoxFont = fontMapperImpl.getFontBoxFont("Helvetica", new PDFontDescriptor());

    // Assert
    FontBoxFont font = actualFontBoxFont.getFont();
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertFalse(actualFontBoxFont.isFallback());
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Font Name is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when 'null'; then return Font Name is 'ArialMT'")
  void testGetFontBoxFont_whenNull_thenReturnFontNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(null, new PDFontDescriptor()).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("ArialMT", font.getName());
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, ((TrueTypeFont) font).getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = ((TrueTypeFont) font).getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()}.</li>
   *   <li>Then return Font Name is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when PDFontDescriptor(); then return Font Name is 'ArialMT'")
  void testGetFontBoxFont_whenPDFontDescriptor_thenReturnFontNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", new PDFontDescriptor()).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("ArialMT", font.getName());
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, ((TrueTypeFont) font).getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = ((TrueTypeFont) font).getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then return Font Name is {@code ArialMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when '+'; then return Font Name is 'ArialMT'")
  void testGetFontBoxFont_whenPlusSign_thenReturnFontNameIsArialMT() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("+", new PDFontDescriptor()).getFont();
    HeaderTable header = ((TrueTypeFont) font).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(25, tableMap.size());
    TTFTable getResult = tableMap.get("DSIG");
    assertTrue(getResult instanceof DigitalSignatureTable);
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("ArialMT", font.getName());
    NamingTable naming = ((TrueTypeFont) font).getNaming();
    assertEquals("ArialMT", naming.getPostScriptName());
    assertEquals((short) -1361, header.getXMin());
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) font).getHorizontalHeader();
    assertEquals((short) -1361, horizontalHeader.getMinLeftSideBearing());
    BoundingBox fontBBox = font.getFontBBox();
    assertEquals(-324.70703f, fontBBox.getLowerLeftY());
    assertEquals(-664.5508f, fontBBox.getLowerLeftX());
    assertEquals((short) -665, header.getYMin());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) font).getGsub();
    assertEquals(1003500L, gsub.getOffset());
    assertEquals(1037380L, getResult.getOffset());
    assertEquals(1045960L, ((TrueTypeFont) font).getOriginalDataSize());
    assertEquals(11906L, naming.getLength());
    MaximumProfileTable maximumProfile = ((TrueTypeFont) font).getMaximumProfile();
    assertEquals(1303, maximumProfile.getMaxStackElements());
    assertEquals(1364.2578f, fontBBox.getHeight());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertEquals(1467, oS2Windows.getCapHeight());
    PostScriptTable postScript = ((TrueTypeFont) font).getPostScript();
    assertEquals((short) 150, postScript.getUnderlineThickness());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) font).getIndexToLocation();
    assertEquals(155336L, indexToLocation.getOffset());
    assertEquals(1613539914L, indexToLocation.getCheckSum());
    assertEquals(1636646406000L, modified.getTimeInMillis());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(1730L, offsets[8]);
    GlyphTable glyph = ((TrueTypeFont) font).getGlyph();
    assertEquals(173528L, glyph.getOffset());
    assertEquals(202, maximumProfile.getMaxCompositePoints());
    assertEquals(2075, header.getFlags());
    assertEquals(2204L, offsets[9]);
    assertEquals(221240180L, glyph.getCheckSum());
    assertEquals(2664.5508f, fontBBox.getWidth());
    assertEquals(2784L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(2876L, offsets[11]);
    TTFTable getResult2 = tableMap.get("fpgm");
    assertEquals(2992L, getResult2.getLength());
    assertEquals(2995022776L, gsub.getCheckSum());
    CmapTable cmap = ((TrueTypeFont) font).getCmap();
    assertEquals(3, cmap.getCmaps().length);
    assertEquals(3022L, offsets[PDPanose.LENGTH]);
    assertEquals(304L, offsets[5]);
    assertEquals(305339020L, horizontalHeader.getCheckSum());
    assertEquals(3119, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(3206L, offsets[13]);
    assertEquals(3297824582L, getResult.getCheckSum());
    assertEquals(340417924L, oS2Windows.getCheckSum());
    assertEquals(3443681063L, cmap.getCheckSum());
    assertEquals(3496L, offsets[14]);
    assertEquals(3634L, offsets[15]);
    assertEquals(3650344429L, header.getCheckSumAdjustment());
    assertEquals(3776L, offsets[Short.SIZE]);
    assertEquals(3862L, offsets[17]);
    assertEquals(3940L, offsets[18]);
    assertEquals(398004210L, maximumProfile.getCheckSum());
    assertEquals(4068041462L, header.getCheckSum());
    assertEquals(4068L, offsets[19]);
    assertEquals(4280942742L, postScript.getCheckSum());
    assertEquals(4548, offsets.length);
    assertEquals(4680L, offsets[20]);
    assertEquals(4994L, offsets[21]);
    assertEquals(502L, offsets[6]);
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    KerningTable kerning = ((TrueTypeFont) font).getKerning();
    assertEquals(5472L, kerning.getLength());
    assertEquals(5644L, offsets[22]);
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(58, nameRecords.size());
    assertEquals(6276L, offsets[23]);
    assertEquals(634177065L, ((TrueTypeFont) font).getHorizontalMetrics().getCheckSum());
    assertEquals(649950890000L, created.getTimeInMillis());
    assertEquals(670258L, offsets[4523]);
    assertEquals(670414L, offsets[4524]);
    assertEquals(670580L, offsets[4525]);
    assertEquals(670832L, offsets[4526]);
    assertEquals(671054L, offsets[4527]);
    assertEquals(671322L, offsets[4528]);
    assertEquals(671576L, offsets[4529]);
    assertEquals(671798L, offsets[4530]);
    assertEquals(672022L, offsets[4531]);
    assertEquals(672208L, offsets[4532]);
    assertEquals(672402L, offsets[4533]);
    assertEquals(672638L, offsets[4534]);
    assertEquals(672870L, offsets[4535]);
    assertEquals(673032L, offsets[4536]);
    assertEquals(673102L, offsets[4537]);
    assertEquals(673308L, offsets[4538]);
    assertEquals(673366L, offsets[4539]);
    assertEquals(673424L, offsets[4540]);
    assertEquals(673668L, offsets[4541]);
    assertEquals(673994L, offsets[4542]);
    assertEquals(6740, nameRecords.get(56).getStringOffset());
    assertEquals(6740, nameRecords.get(57).getStringOffset());
    assertEquals(674150L, offsets[4543]);
    assertEquals(674240L, offsets[4544]);
    assertEquals(674286L, offsets[4545]);
    assertEquals(674330L, offsets[4546]);
    assertEquals(674394L, glyph.getLength());
    assertEquals(674394L, offsets[4547]);
    assertEquals(6874L, offsets[24]);
    assertEquals(758245357L, naming.getCheckSum());
    assertEquals(847924L, kerning.getOffset());
    assertEquals(853396L, naming.getOffset());
    assertEquals(865304L, postScript.getOffset());
    assertEquals(865336L, tableMap.get("gasp").getOffset());
    assertEquals((short) 904, oS2Windows.getAverageCharWidth());
    assertEquals(929118518L, kerning.getCheckSum());
    assertEquals(950343211L, getResult2.getCheckSum());
    assertEquals(990L, offsets[7]);
    assertSame(glyph, tableMap.get("glyf"));
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 25, 1, 0, 0, 4, 0, -112, 'D', 'S', 'I', 'G', -60, -112, -49, 'F', 0, 15,
        -44, 'D', 0, 0, '!', -124, 'G', 'D', 'E', 'F', 24, -26, 28, 'f', 0, '\r', '4', Byte.MIN_VALUE, 0, 0, 3, 'X',
        'G', 'P', 'O', 'S', '2', 17, 23}, byteArray);
  }

  /**
   * Test
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute
   * {@code +} and {@code +}.</li>
   *   <li>When {@code +}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor) addSubstitute '+' and '+'; when '+'")
  void testGetCIDFont_givenFontMapperImplAddSubstitutePlusSignAndPlusSign_whenPlusSign() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute("+", "+");
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont("+", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code Base Font}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'Base Font'")
  void testGetCIDFont_givenFontMapperImpl_whenBaseFont() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont("Base Font", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code Base Font}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'Base Font'")
  void testGetCIDFont_givenFontMapperImpl_whenBaseFont2() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl.getCIDFont("Base Font", new PDFontDescriptor(), null).getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code ,}.</li>
   *   <li>Then TrueTypeFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when ','; then TrueTypeFont return TrueTypeFont")
  void testGetCIDFont_givenFontMapperImpl_whenComma_thenTrueTypeFontReturnTrueTypeFont() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont(",", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then TrueTypeFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'null'; then TrueTypeFont return TrueTypeFont")
  void testGetCIDFont_givenFontMapperImpl_whenNull_thenTrueTypeFontReturnTrueTypeFont() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont(null, fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code +}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when '+'")
  void testGetCIDFont_givenFontMapperImpl_whenPlusSign() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont("+", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }
}
