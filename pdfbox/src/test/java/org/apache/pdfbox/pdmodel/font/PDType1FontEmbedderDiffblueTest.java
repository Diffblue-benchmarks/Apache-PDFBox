package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.encoding.BuiltInEncoding;
import org.apache.fontbox.encoding.StandardEncoding;
import org.apache.fontbox.type1.Type1Font;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.MacExpertEncoding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDType1FontEmbedderDiffblueTest {
  /**
   * Test {@link PDType1FontEmbedder#PDType1FontEmbedder(PDDocument, COSDictionary, InputStream,
   * Encoding)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#PDType1FontEmbedder(PDDocument, COSDictionary,
   * InputStream, Encoding)}
   */
  @Test
  @DisplayName(
      "Test new PDType1FontEmbedder(PDDocument, COSDictionary, InputStream, Encoding); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDType1FontEmbedder.<init>(PDDocument, COSDictionary, InputStream, Encoding)"
  })
  void testNewPDType1FontEmbedder_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    COSDictionary dict = mock(COSDictionary.class);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    DataInputStream pfbStream = mock(DataInputStream.class);
    when(pfbStream.readAllBytes()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new PDType1FontEmbedder(doc, dict, pfbStream, MacExpertEncoding.INSTANCE));
    verify(pfbStream).readAllBytes();
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)} with {@code metrics}.
   *
   * <ul>
   *   <li>Given {@code UTF-8}.
   *   <li>Then return not Symbolic.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  @DisplayName(
      "Test buildFontDescriptor(FontMetrics) with 'metrics'; given 'UTF-8'; then return not Symbolic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(FontMetrics)"})
  void testBuildFontDescriptorWithMetrics_givenUtf8_thenReturnNotSymbolic() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setFontBBox(new BoundingBox());
    metrics.setEncodingScheme("UTF-8");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    assertFalse(actualBuildFontDescriptorResult.isSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isNonSymbolic());
    assertEquals(Integer.SIZE, actualBuildFontDescriptorResult.getFlags());
    COSDictionary cOSObject = actualBuildFontDescriptorResult.getCOSObject();
    assertEquals(PDPanoseClassification.LENGTH, cOSObject.getValues().size());
    assertEquals(PDPanoseClassification.LENGTH, cOSObject.size());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)} with {@code metrics}.
   *
   * <ul>
   *   <li>Then return COSObject Values size is {@link PDPanoseClassification#LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  @DisplayName(
      "Test buildFontDescriptor(FontMetrics) with 'metrics'; then return COSObject Values size is LENGTH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(FontMetrics)"})
  void testBuildFontDescriptorWithMetrics_thenReturnCOSObjectValuesSizeIsLength() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setFontBBox(new BoundingBox());
    metrics.setEncodingScheme("FontSpecific");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    assertNull(actualBuildFontDescriptorResult.getCharSet());
    assertNull(actualBuildFontDescriptorResult.getFontFamily());
    assertNull(actualBuildFontDescriptorResult.getFontName());
    assertEquals(4, actualBuildFontDescriptorResult.getFlags());
    assertFalse(actualBuildFontDescriptorResult.isNonSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isSymbolic());
    COSDictionary cOSObject = actualBuildFontDescriptorResult.getCOSObject();
    assertEquals(PDPanoseClassification.LENGTH, cOSObject.getValues().size());
    assertEquals(PDPanoseClassification.LENGTH, cOSObject.size());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)} with {@code metrics}.
   *
   * <ul>
   *   <li>Then return CharSet is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  @DisplayName("Test buildFontDescriptor(FontMetrics) with 'metrics'; then return CharSet is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(FontMetrics)"})
  void testBuildFontDescriptorWithMetrics_thenReturnCharSetIs42() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setCharacterSet("42");
    metrics.setFontBBox(new BoundingBox());
    metrics.setEncodingScheme("FontSpecific");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    assertEquals("42", actualBuildFontDescriptorResult.getCharSet());
    assertNull(actualBuildFontDescriptorResult.getFontName());
    COSDictionary cOSObject = actualBuildFontDescriptorResult.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)} with {@code metrics}.
   *
   * <ul>
   *   <li>Then return FontFamily is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  @DisplayName(
      "Test buildFontDescriptor(FontMetrics) with 'metrics'; then return FontFamily is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(FontMetrics)"})
  void testBuildFontDescriptorWithMetrics_thenReturnFontFamilyIs42() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setFamilyName("42");
    metrics.setFontBBox(new BoundingBox());
    metrics.setEncodingScheme("FontSpecific");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    assertEquals("42", actualBuildFontDescriptorResult.getFontFamily());
    assertNull(actualBuildFontDescriptorResult.getFontName());
    COSDictionary cOSObject = actualBuildFontDescriptorResult.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)} with {@code metrics}.
   *
   * <ul>
   *   <li>Then return FontName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  @DisplayName("Test buildFontDescriptor(FontMetrics) with 'metrics'; then return FontName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(FontMetrics)"})
  void testBuildFontDescriptorWithMetrics_thenReturnFontNameIs42() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setFontName("42");
    metrics.setFontBBox(new BoundingBox());
    metrics.setEncodingScheme("FontSpecific");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    assertEquals("42", actualBuildFontDescriptorResult.getFontName());
    assertNull(actualBuildFontDescriptorResult.getCharSet());
    assertNull(actualBuildFontDescriptorResult.getFontFamily());
    assertEquals(4, actualBuildFontDescriptorResult.getFlags());
    assertFalse(actualBuildFontDescriptorResult.isNonSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isSymbolic());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)} with {@code metrics}.
   *
   * <ul>
   *   <li>Then return FontName is {@code FontSpecific}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(FontMetrics)}
   */
  @Test
  @DisplayName(
      "Test buildFontDescriptor(FontMetrics) with 'metrics'; then return FontName is 'FontSpecific'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(FontMetrics)"})
  void testBuildFontDescriptorWithMetrics_thenReturnFontNameIsFontSpecific() {
    // Arrange
    FontMetrics metrics = new FontMetrics();
    metrics.setFontName("FontSpecific");
    metrics.setFontBBox(new BoundingBox());
    metrics.setEncodingScheme("FontSpecific");

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(metrics);

    // Assert
    assertEquals("FontSpecific", actualBuildFontDescriptorResult.getFontName());
    assertNull(actualBuildFontDescriptorResult.getCharSet());
    assertNull(actualBuildFontDescriptorResult.getFontFamily());
    assertEquals(4, actualBuildFontDescriptorResult.getFlags());
    assertFalse(actualBuildFontDescriptorResult.isNonSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isSymbolic());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)} with {@code type1}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return FontName is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)}
   */
  @Test
  @DisplayName(
      "Test buildFontDescriptor(Type1Font) with 'type1'; given 'foo'; then return FontName is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(Type1Font)"})
  void testBuildFontDescriptorWithType1_givenFoo_thenReturnFontNameIsFoo() throws IOException {
    // Arrange
    ArrayList<Number> numberList = new ArrayList<>();
    numberList.add(Integer.valueOf(1));
    numberList.add(Integer.valueOf(1));
    numberList.add(Integer.valueOf(1));

    Type1Font type1 = mock(Type1Font.class);
    when(type1.getBlueValues()).thenReturn(numberList);
    when(type1.getItalicAngle()).thenReturn(10.0f);
    when(type1.getEncoding()).thenReturn(new BuiltInEncoding(new HashMap<>()));
    when(type1.getFamilyName()).thenReturn("Family Name");
    when(type1.getName()).thenReturn("foo");
    when(type1.getFontBBox()).thenReturn(new BoundingBox());

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(type1);

    // Assert
    verify(type1).getBlueValues();
    verify(type1).getEncoding();
    verify(type1).getFamilyName();
    verify(type1).getFontBBox();
    verify(type1).getItalicAngle();
    verify(type1).getName();
    assertEquals("foo", actualBuildFontDescriptorResult.getFontName());
    assertEquals(4, actualBuildFontDescriptorResult.getFlags());
    assertFalse(actualBuildFontDescriptorResult.isNonSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isSymbolic());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)} with {@code type1}.
   *
   * <ul>
   *   <li>Given {@link StandardEncoding} (default constructor).
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)}
   */
  @Test
  @DisplayName(
      "Test buildFontDescriptor(Type1Font) with 'type1'; given StandardEncoding (default constructor); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(Type1Font)"})
  void testBuildFontDescriptorWithType1_givenStandardEncoding_thenThrowIOException()
      throws IOException {
    // Arrange
    Type1Font type1 = mock(Type1Font.class);
    when(type1.getEncoding()).thenReturn(new StandardEncoding());
    when(type1.getFontBBox()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> PDType1FontEmbedder.buildFontDescriptor(type1));
    verify(type1).getEncoding();
    verify(type1).getFontBBox();
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)} with {@code type1}.
   *
   * <ul>
   *   <li>Then return FontName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)}
   */
  @Test
  @DisplayName("Test buildFontDescriptor(Type1Font) with 'type1'; then return FontName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(Type1Font)"})
  void testBuildFontDescriptorWithType1_thenReturnFontNameIsName() throws IOException {
    // Arrange
    ArrayList<Number> numberList = new ArrayList<>();
    numberList.add(Integer.valueOf(1));
    numberList.add(Integer.valueOf(1));
    numberList.add(Integer.valueOf(1));

    Type1Font type1 = mock(Type1Font.class);
    when(type1.getBlueValues()).thenReturn(numberList);
    when(type1.getItalicAngle()).thenReturn(10.0f);
    when(type1.getEncoding()).thenReturn(new BuiltInEncoding(new HashMap<>()));
    when(type1.getFamilyName()).thenReturn("Family Name");
    when(type1.getName()).thenReturn("Name");
    when(type1.getFontBBox()).thenReturn(new BoundingBox());

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(type1);

    // Assert
    verify(type1).getBlueValues();
    verify(type1).getEncoding();
    verify(type1).getFamilyName();
    verify(type1).getFontBBox();
    verify(type1).getItalicAngle();
    verify(type1).getName();
    assertEquals("Name", actualBuildFontDescriptorResult.getFontName());
    assertEquals(4, actualBuildFontDescriptorResult.getFlags());
    assertFalse(actualBuildFontDescriptorResult.isNonSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isSymbolic());
  }

  /**
   * Test {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)} with {@code type1}.
   *
   * <ul>
   *   <li>Then return not Symbolic.
   * </ul>
   *
   * <p>Method under test: {@link PDType1FontEmbedder#buildFontDescriptor(Type1Font)}
   */
  @Test
  @DisplayName("Test buildFontDescriptor(Type1Font) with 'type1'; then return not Symbolic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDType1FontEmbedder.buildFontDescriptor(Type1Font)"})
  void testBuildFontDescriptorWithType1_thenReturnNotSymbolic() throws IOException {
    // Arrange
    ArrayList<Number> numberList = new ArrayList<>();
    numberList.add(Integer.valueOf(1));
    numberList.add(Integer.valueOf(1));
    numberList.add(Integer.valueOf(1));

    Type1Font type1 = mock(Type1Font.class);
    when(type1.getBlueValues()).thenReturn(numberList);
    when(type1.getItalicAngle()).thenReturn(10.0f);
    when(type1.getEncoding()).thenReturn(null);
    when(type1.getFamilyName()).thenReturn("Family Name");
    when(type1.getName()).thenReturn("Name");
    when(type1.getFontBBox()).thenReturn(new BoundingBox());

    // Act
    PDFontDescriptor actualBuildFontDescriptorResult =
        PDType1FontEmbedder.buildFontDescriptor(type1);

    // Assert
    verify(type1).getBlueValues();
    verify(type1).getEncoding();
    verify(type1).getFamilyName();
    verify(type1).getFontBBox();
    verify(type1).getItalicAngle();
    verify(type1).getName();
    assertEquals("Name", actualBuildFontDescriptorResult.getFontName());
    assertFalse(actualBuildFontDescriptorResult.isSymbolic());
    assertTrue(actualBuildFontDescriptorResult.isNonSymbolic());
    assertEquals(Integer.SIZE, actualBuildFontDescriptorResult.getFlags());
  }
}
