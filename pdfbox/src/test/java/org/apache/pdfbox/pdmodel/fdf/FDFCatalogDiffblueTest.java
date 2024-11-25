package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Element;

class FDFCatalogDiffblueTest {
  /**
   * Test {@link FDFCatalog#FDFCatalog(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFCatalog#FDFCatalog(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFCatalog(COSDictionary)")
  void testNewFDFCatalog() {
    // Arrange
    COSDictionary cat = new COSDictionary();

    // Act and Assert
    assertSame(cat, (new FDFCatalog(cat)).getCOSObject());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog()}.
   * <p>
   * Method under test: {@link FDFCatalog#FDFCatalog()}
   */
  @Test
  @DisplayName("Test new FDFCatalog()")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog(Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  @DisplayName("Test new FDFCatalog(Element); given IIOMetadataNode(String) with 'foo'")
  void testNewFDFCatalog_givenIIOMetadataNodeWithFoo() throws IOException {
    // Arrange
    IIOMetadataNode element = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    element.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  @DisplayName("Test new FDFCatalog(Element); when IIOMetadataNode(String) with 'foo'")
  void testNewFDFCatalog_whenIIOMetadataNodeWithFoo() throws IOException {
    // Arrange and Act
    FDFCatalog actualFdfCatalog = new FDFCatalog(new IIOMetadataNode("foo"));

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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFCatalog#FDFCatalog(Element)}.
   * <ul>
   *   <li>When {@link TIFFTag#TIFFTag(String, int, int)} with {@code Name} and
   * number is {@link TIFFTag#TIFF_SRATIONAL} and dataTypes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  @DisplayName("Test new FDFCatalog(Element); when TIFFTag(String, int, int) with 'Name' and number is TIFF_SRATIONAL and dataTypes is one")
  void testNewFDFCatalog_whenTIFFTagWithNameAndNumberIsTiff_srationalAndDataTypesIsOne() throws IOException {
    // Arrange and Act
    FDFCatalog actualFdfCatalog = new FDFCatalog(
        new TIFFFieldNode(new TIFFField(new TIFFTag("Name", TIFFTag.TIFF_SRATIONAL, 1), 42)));

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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = fDF.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualFdfCatalog.getSignature());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  void testWriteXML_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() throws IOException {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    when(cat.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    FDFCatalog fdfCatalog = new FDFCatalog(cat);
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    verify(cat).getCOSDictionary(isA(COSName.class));
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSObjectable)")
  void testWriteXML_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() throws IOException {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    when(cat.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cat).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    FDFCatalog fdfCatalog = new FDFCatalog(cat);
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    verify(cat).getCOSDictionary(isA(COSName.class));
    verify(cat).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFCatalog(); then StringWriter() toString is empty string")
  void testWriteXML_givenFDFCatalog_thenStringWriterToStringIsEmptyString() throws IOException {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given IIOMetadataNode(String) with 'foo'; then StringWriter() toString is empty string")
  void testWriteXML_givenIIOMetadataNodeWithFoo_thenStringWriterToStringIsEmptyString() throws IOException {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog(new IIOMetadataNode("foo"));
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    assertEquals("", output.toString());
  }

  /**
   * Test {@link FDFCatalog#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <f href="String" />}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<f href=\"String\" />'")
  void testWriteXML_thenStringWriterToStringIsFHrefString() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cat = mock(COSDictionary.class);
    when(cat.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    FDFCatalog fdfCatalog = new FDFCatalog(cat);
    StringWriter output = new StringWriter();

    // Act
    fdfCatalog.writeXML(output);

    // Assert
    verify(cosDictionary2, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cat).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getString(isA(COSName.class));
    assertEquals("<f href=\"String\" />\n", output.toString());
  }

  /**
   * Test {@link FDFCatalog#getVersion()}.
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()} Version is {@code 1.0.2}.</li>
   *   <li>Then return {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given FDFCatalog() Version is '1.0.2'; then return '1.0.2'")
  void testGetVersion_givenFDFCatalogVersionIs102_thenReturn102() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setVersion("1.0.2");

    // Act and Assert
    assertEquals("1.0.2", fdfCatalog.getVersion());
  }

  /**
   * Test {@link FDFCatalog#getVersion()}.
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given FDFCatalog(); then return 'null'")
  void testGetVersion_givenFDFCatalog_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFCatalog()).getVersion());
  }

  /**
   * Test {@link FDFCatalog#getVersion()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetVersion_givenIIOMetadataNodeWithFoo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFCatalog(new IIOMetadataNode("foo"))).getVersion());
  }

  /**
   * Test {@link FDFCatalog#setVersion(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>When {@code 1.0.2}.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#setVersion(String)}
   */
  @Test
  @DisplayName("Test setVersion(String); given COSDictionary setName(COSName, String) does nothing; when '1.0.2'; then calls setName(COSName, String)")
  void testSetVersion_givenCOSDictionarySetNameDoesNothing_when102_thenCallsSetName() {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    doNothing().when(cat).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new FDFCatalog(cat)).setVersion("1.0.2");

    // Assert that nothing has changed
    verify(cat).setName(isA(COSName.class), eq("1.0.2"));
  }

  /**
   * Test {@link FDFCatalog#getFDF()}.
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.</li>
   *   <li>Then return Encoding is {@code PDFDocEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getFDF()}
   */
  @Test
  @DisplayName("Test getFDF(); given FDFCatalog(); then return Encoding is 'PDFDocEncoding'")
  void testGetFDF_givenFDFCatalog_thenReturnEncodingIsPDFDocEncoding() throws IOException {
    // Arrange and Act
    FDFDictionary actualFDF = (new FDFCatalog()).getFDF();

    // Assert
    assertEquals("PDFDocEncoding", actualFDF.getEncoding());
    assertNull(actualFDF.getStatus());
    assertNull(actualFDF.getTarget());
    assertNull(actualFDF.getEmbeddedFDFs());
    assertNull(actualFDF.getAnnotations());
    assertNull(actualFDF.getFields());
    assertNull(actualFDF.getPages());
    assertNull(actualFDF.getID());
    COSDictionary cOSObject = actualFDF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFDF.getDifferences());
    assertNull(actualFDF.getFile());
    assertNull(actualFDF.getJavaScript());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFCatalog#getFDF()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return Encoding is {@code PDFDocEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getFDF()}
   */
  @Test
  @DisplayName("Test getFDF(); given IIOMetadataNode(String) with 'foo'; then return Encoding is 'PDFDocEncoding'")
  void testGetFDF_givenIIOMetadataNodeWithFoo_thenReturnEncodingIsPDFDocEncoding() throws IOException {
    // Arrange and Act
    FDFDictionary actualFDF = (new FDFCatalog(new IIOMetadataNode("foo"))).getFDF();

    // Assert
    assertEquals("PDFDocEncoding", actualFDF.getEncoding());
    assertNull(actualFDF.getStatus());
    assertNull(actualFDF.getTarget());
    assertNull(actualFDF.getEmbeddedFDFs());
    assertNull(actualFDF.getAnnotations());
    assertNull(actualFDF.getFields());
    assertNull(actualFDF.getPages());
    assertNull(actualFDF.getID());
    COSDictionary cOSObject = actualFDF.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFDF.getDifferences());
    assertNull(actualFDF.getFile());
    assertNull(actualFDF.getJavaScript());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   * <p>
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary)")
  void testSetFDF() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    FDFDictionary fdf = mock(FDFDictionary.class);
    when(fdf.getCOSObject()).thenReturn(cosDictionary);

    // Act
    fdfCatalog.setFDF(fdf);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(fdf).getCOSObject();
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary); given COSDictionary isDirect() return 'false'; then calls getKey()")
  void testSetFDF_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    FDFDictionary fdf = mock(FDFDictionary.class);
    when(fdf.getCOSObject()).thenReturn(cosDictionary);

    // Act
    fdfCatalog.setFDF(fdf);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(fdf).getCOSObject();
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary); given COSDictionary isDirect() return 'false'; then calls getKey()")
  void testSetFDF_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey2() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    FDFDictionary fdf = mock(FDFDictionary.class);
    when(fdf.getCOSObject()).thenReturn(cosDictionary);

    // Act
    fdfCatalog.setFDF(fdf);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(fdf).getCOSObject();
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetFDF_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    doNothing().when(cat).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new FDFCatalog(cat)).setFDF(mock(FDFDictionary.class));

    // Assert that nothing has changed
    verify(cat).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link FDFCatalog#FDFCatalog()} FDF COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary); given COSDictionary(); then FDFCatalog() FDF COSObject is COSDictionary()")
  void testSetFDF_givenCOSDictionary_thenFDFCatalogFdfCOSObjectIsCOSDictionary() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    FDFDictionary fdf = mock(FDFDictionary.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(fdf.getCOSObject()).thenReturn(cosDictionary);

    // Act
    fdfCatalog.setFDF(fdf);

    // Assert
    verify(fdf).getCOSObject();
    assertSame(cosDictionary, fdfCatalog.getFDF().getCOSObject());
  }

  /**
   * Test {@link FDFCatalog#setFDF(FDFDictionary)}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  @DisplayName("Test setFDF(FDFDictionary); then calls setOriginDocumentState(COSDocumentState)")
  void testSetFDF_thenCallsSetOriginDocumentState() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    FDFDictionary fdf = mock(FDFDictionary.class);
    when(fdf.getCOSObject()).thenReturn(cosDictionary);

    // Act
    fdfCatalog.setFDF(fdf);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(fdf).getCOSObject();
  }

  /**
   * Test {@link FDFCatalog#getSignature()}.
   * <ul>
   *   <li>Given {@link FDFCatalog#FDFCatalog()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); given FDFCatalog(); then return 'null'")
  void testGetSignature_givenFDFCatalog_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFCatalog()).getSignature());
  }

  /**
   * Test {@link FDFCatalog#getSignature()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetSignature_givenIIOMetadataNodeWithFoo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFCatalog(new IIOMetadataNode("foo"))).getSignature());
  }

  /**
   * Test {@link FDFCatalog#getSignature()}.
   * <ul>
   *   <li>Then return ContactInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); then return ContactInfo is 'null'")
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
    COSDictionary cOSObject = actualSignature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualSignature.getPropBuild());
    assertEquals(0, actualSignature.getByteRange().length);
    assertEquals(0, actualSignature.getContents().length);
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFCatalog#setSignature(PDSignature)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFCatalog#setSignature(PDSignature)}
   */
  @Test
  @DisplayName("Test setSignature(PDSignature); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetSignature_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    doNothing().when(cat).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    FDFCatalog fdfCatalog = new FDFCatalog(cat);

    // Act
    fdfCatalog.setSignature(new PDSignature());

    // Assert that nothing has changed
    verify(cat).setItem(isA(COSName.class), isA(COSObjectable.class));
  }
}
