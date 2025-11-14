package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Element;

class FDFCatalogDiffblueTest {
  /**
   * Test {@link FDFCatalog#FDFCatalog(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFCatalog#FDFCatalog(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFCatalog(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.<init>(COSDictionary)"})
  void testNewFDFCatalog() {
    // Arrange
    COSDictionary cat = new COSDictionary();

    // Act and Assert
    assertSame(cat, new FDFCatalog(cat).getCOSObject());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog()}.
   *
   * <p>Method under test: {@link FDFCatalog#FDFCatalog()}
   */
  @Test
  @DisplayName("Test new FDFCatalog()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.<init>()"})
  void testNewFDFCatalog2() throws IOException {
    // Arrange and Act
    FDFCatalog actualFdfCatalog = new FDFCatalog();

    // Assert
    FDFDictionary fDF = actualFdfCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualFdfCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = actualFdfCatalog.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog(Element)}.
   *
   * <p>Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  @DisplayName("Test new FDFCatalog(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.<init>(Element)"})
  void testNewFDFCatalog3() throws IOException {
    // Arrange
    IIOMetadataNode element = new IIOMetadataNode();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    element.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act
    FDFCatalog actualFdfCatalog = new FDFCatalog(element);

    // Assert
    FDFDictionary fDF = actualFdfCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualFdfCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = actualFdfCatalog.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return FDF Encoding is {@code PDFDocEncoding}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFCatalog(Element); when IIOMetadataNode(); then return FDF Encoding is 'PDFDocEncoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.<init>(Element)"})
  void testNewFDFCatalog_whenIIOMetadataNode_thenReturnFdfEncodingIsPDFDocEncoding()
      throws IOException {
    // Arrange and Act
    FDFCatalog actualFdfCatalog = new FDFCatalog(new IIOMetadataNode());

    // Assert
    FDFDictionary fDF = actualFdfCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualFdfCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = actualFdfCatalog.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog(Element)}.
   *
   * <ul>
   *   <li>When {@link TIFFTag#TIFFTag(String, int, int)} with {@code Name} and number is {@link
   *       TIFFTag#TIFF_SRATIONAL} and dataTypes is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFCatalog(Element); when TIFFTag(String, int, int) with 'Name' and number is TIFF_SRATIONAL and dataTypes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.<init>(Element)"})
  void testNewFDFCatalog_whenTIFFTagWithNameAndNumberIsTiff_srationalAndDataTypesIsOne()
      throws IOException {
    // Arrange
    TIFFTag tag = new TIFFTag("Name", TIFFTag.TIFF_SRATIONAL, 1);

    TIFFFieldNode element = new TIFFFieldNode(new TIFFField(tag, 42));
    IIOMetadataNode newChild = new IIOMetadataNode();
    element.insertBefore(newChild, new IIOMetadataNode());

    // Act
    FDFCatalog actualFdfCatalog = new FDFCatalog(element);

    // Assert
    FDFDictionary fDF = actualFdfCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualFdfCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = actualFdfCatalog.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog(Element)} with element is {@link
   *       IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFCatalog(Element) with element is IIOMetadataNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.writeXML(Writer)"})
  void testWriteXML_givenFDFCatalogWithElementIsIIOMetadataNode() throws IOException {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog(new IIOMetadataNode());
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert that nothing has changed
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName(
      "Test writeXML(Writer); given FDFCatalog(); then StringWriter() toString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.writeXML(Writer)"})
  void testWriteXML_givenFDFCatalog_thenStringWriterToStringIsEmptyString() throws IOException {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert that nothing has changed
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Given {@link FDFDictionary#FDFDictionary()} Fields is {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code <f href="" />}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName(
      "Test writeXML(Writer); given FDFDictionary() Fields is ArrayList(); then StringWriter() toString is '<f href=\"\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.writeXML(Writer)"})
  void testWriteXML_givenFDFDictionaryFieldsIsArrayList_thenStringWriterToStringIsFHref()
      throws IOException {
    // Arrange
    FDFDictionary fdf = new FDFDictionary();
    fdf.setFields(new ArrayList<>());
    fdf.setFile(new PDSimpleFileSpecification());

    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setFDF(fdf);
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    assertEquals("<f href=\"\" />\n", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code <f href="" />}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<f href=\"\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.writeXML(Writer)"})
  void testWriteXML_thenStringWriterToStringIsFHref() throws IOException {
    // Arrange
    FDFDictionary fdf = new FDFDictionary();
    fdf.setFile(new PDSimpleFileSpecification());

    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setFDF(fdf);
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    assertEquals("<f href=\"\" />\n", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code <f href="null" />}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<f href=\"null\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.writeXML(Writer)"})
  void testWriteXML_thenStringWriterToStringIsFHrefNull() throws IOException {
    // Arrange
    FDFDictionary fdf = new FDFDictionary();
    fdf.setFile(new PDComplexFileSpecification());

    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setFDF(fdf);
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    assertEquals("<f href=\"null\" />\n", output.toString());
  }

  /**
   * Test {@link FDFCatalog#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()} Version is {@code 1.0.2}.
   *   <li>Then return {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given FDFCatalog() Version is '1.0.2'; then return '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFCatalog.getVersion()"})
  void testGetVersion_givenFDFCatalogVersionIs102_thenReturn102() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setVersion("1.0.2");

    // Act and Assert
    assertEquals("1.0.2", fdfCatalog.getVersion());
  }

  /**
   * Test {@link FDFCatalog#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog(Element)} with element is {@link
   *       IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  @DisplayName(
      "Test getVersion(); given FDFCatalog(Element) with element is IIOMetadataNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFCatalog.getVersion()"})
  void testGetVersion_givenFDFCatalogWithElementIsIIOMetadataNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFCatalog(new IIOMetadataNode()).getVersion());
  }

  /**
   * Test {@link FDFCatalog#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given FDFCatalog(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFCatalog.getVersion()"})
  void testGetVersion_givenFDFCatalog_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFCatalog().getVersion());
  }

  /**
   * Test {@link FDFCatalog#setVersion(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setName(COSName, String)} does nothing.
   *   <li>When {@code 1.0.2}.
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#setVersion(String)}
   */
  @Test
  @DisplayName(
      "Test setVersion(String); given COSDictionary setName(COSName, String) does nothing; when '1.0.2'; then calls setName(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.setVersion(String)"})
  void testSetVersion_givenCOSDictionarySetNameDoesNothing_when102_thenCallsSetName() {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    doNothing().when(cat).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    new FDFCatalog(cat).setVersion("1.0.2");

    // Assert that nothing has changed
    verify(cat).setName(isA(COSName.class), eq("1.0.2"));
  }

  /**
   * Test {@link FDFCatalog#getFDF()}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog(Element)} with element is {@link
   *       IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getFDF()}
   */
  @Test
  @DisplayName("Test getFDF(); given FDFCatalog(Element) with element is IIOMetadataNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFDictionary FDFCatalog.getFDF()"})
  void testGetFDF_givenFDFCatalogWithElementIsIIOMetadataNode() throws IOException {
    // Arrange and Act
    FDFDictionary actualFDF = new FDFCatalog(new IIOMetadataNode()).getFDF();

    // Assert
    assertEquals("PDFDocEncoding", actualFDF.getEncoding());
    assertNull(actualFDF.getStatus());
    assertNull(actualFDF.getTarget());
    assertNull(actualFDF.getEmbeddedFDFs());
    assertNull(actualFDF.getAnnotations());
    assertNull(actualFDF.getFields());
    assertNull(actualFDF.getPages());
    assertNull(actualFDF.getID());
    assertNull(actualFDF.getDifferences());
    assertNull(actualFDF.getFile());
    assertNull(actualFDF.getJavaScript());
  }

  /**
   * Test {@link FDFCatalog#getFDF()}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.
   *   <li>Then return Encoding is {@code PDFDocEncoding}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getFDF()}
   */
  @Test
  @DisplayName("Test getFDF(); given FDFCatalog(); then return Encoding is 'PDFDocEncoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFDictionary FDFCatalog.getFDF()"})
  void testGetFDF_givenFDFCatalog_thenReturnEncodingIsPDFDocEncoding() throws IOException {
    // Arrange and Act
    FDFDictionary actualFDF = new FDFCatalog().getFDF();

    // Assert
    assertEquals("PDFDocEncoding", actualFDF.getEncoding());
    assertNull(actualFDF.getStatus());
    assertNull(actualFDF.getTarget());
    assertNull(actualFDF.getEmbeddedFDFs());
    assertNull(actualFDF.getAnnotations());
    assertNull(actualFDF.getFields());
    assertNull(actualFDF.getPages());
    assertNull(actualFDF.getID());
    assertNull(actualFDF.getDifferences());
    assertNull(actualFDF.getFile());
    assertNull(actualFDF.getJavaScript());
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.setFDF(FDFDictionary)"})
  void testSetFDF_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();

    COSDictionary fdfDictionary = new COSDictionary();
    fdfDictionary.setDirect(true);

    // Act
    fdfCatalog.setFDF(new FDFDictionary(fdfDictionary));

    // Assert
    assertSame(fdfDictionary, fdfCatalog.getFDF().getCOSObject());
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   *
   * <ul>
   *   <li>Then {@link FDFCatalog#FDFCatalog()} FDF COSObject is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary); then FDFCatalog() FDF COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.setFDF(FDFDictionary)"})
  void testSetFDF_thenFDFCatalogFdfCOSObjectIsCOSDictionary() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();

    COSDictionary fdfDictionary = new COSDictionary();
    fdfDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfCatalog.setFDF(new FDFDictionary(fdfDictionary));

    // Assert
    assertSame(fdfDictionary, fdfCatalog.getFDF().getCOSObject());
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   *
   * <ul>
   *   <li>Then {@link FDFCatalog#FDFCatalog(COSDictionary)} with cat is {@link
   *       COSDictionary#COSDictionary()} FDF COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName(
      "Test setFDF(FDFDictionary); then FDFCatalog(COSDictionary) with cat is COSDictionary() FDF COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.setFDF(FDFDictionary)"})
  void testSetFDF_thenFDFCatalogWithCatIsCOSDictionaryFdfCOSObjectIsCOSDictionary() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog(new COSDictionary());

    COSDictionary fdfDictionary = new COSDictionary();
    fdfDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfCatalog.setFDF(new FDFDictionary(fdfDictionary));

    // Assert
    assertSame(fdfDictionary, fdfCatalog.getFDF().getCOSObject());
  }

  /**
   * Test {@link FDFCatalog#getSignature()}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog(Element)} with element is {@link
   *       IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  @DisplayName(
      "Test getSignature(); given FDFCatalog(Element) with element is IIOMetadataNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature FDFCatalog.getSignature()"})
  void testGetSignature_givenFDFCatalogWithElementIsIIOMetadataNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFCatalog(new IIOMetadataNode()).getSignature());
  }

  /**
   * Test {@link FDFCatalog#getSignature()}.
   *
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); given FDFCatalog(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature FDFCatalog.getSignature()"})
  void testGetSignature_givenFDFCatalog_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFCatalog().getSignature());
  }

  /**
   * Test {@link FDFCatalog#getSignature()}.
   *
   * <ul>
   *   <li>Then return ContactInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); then return ContactInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSignature FDFCatalog.getSignature()"})
  void testGetSignature_thenReturnContactInfoIsNull() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setSignature(new PDSignature());

    // Act
    PDSignature actualSignature = fdfCatalog.getSignature();

    // Assert
    assertNull(actualSignature.getContactInfo());
    assertNull(actualSignature.getFilter());
    assertNull(actualSignature.getLocation());
    assertNull(actualSignature.getName());
    assertNull(actualSignature.getReason());
    assertNull(actualSignature.getSubFilter());
    assertNull(actualSignature.getSignDate());
    assertNull(actualSignature.getPropBuild());
    assertArrayEquals(new byte[] {}, actualSignature.getContents());
    assertArrayEquals(new int[] {}, actualSignature.getByteRange());
  }

  /**
   * Test {@link FDFCatalog#setSignature(PDSignature)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#setSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test setSignature(PDSignature); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.setSignature(PDSignature)"})
  void testSetSignature_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfCatalog.setSignature(new PDSignature(dict));

    // Assert
    PDSignature signature = fdfCatalog.getSignature();
    assertSame(dict, signature.getCOSObject());
    assertArrayEquals(new byte[] {}, signature.getContents());
    assertArrayEquals(new int[] {}, signature.getByteRange());
  }

  /**
   * Test {@link FDFCatalog#setSignature(PDSignature)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFCatalog#setSignature(PDSignature)}
   */
  @Test
  @DisplayName(
      "Test setSignature(PDSignature); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFCatalog.setSignature(PDSignature)"})
  void testSetSignature_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    fdfCatalog.setSignature(new PDSignature(dict));

    // Assert
    PDSignature signature = fdfCatalog.getSignature();
    assertSame(dict, signature.getCOSObject());
    assertArrayEquals(new byte[] {}, signature.getContents());
    assertArrayEquals(new int[] {}, signature.getByteRange());
  }
}
