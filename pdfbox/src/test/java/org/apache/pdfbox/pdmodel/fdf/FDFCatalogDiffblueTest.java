package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Element;

class FDFCatalogDiffblueTest {
  /**
   * Method under test: {@link FDFCatalog#writeXML(Writer)}
   */
  @Test
  void testWriteXML() throws IOException {
    // Arrange
    Element element = mock(Element.class);
    when(element.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    FDFCatalog fdfCatalog = new FDFCatalog(element);

    // Act
    fdfCatalog.writeXML(new StringWriter());

    // Assert
    verify(element).getChildNodes();
  }

  /**
   * Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  void testGetVersion() {
    // Arrange, Act and Assert
    assertNull((new FDFCatalog()).getVersion());
  }

  /**
   * Method under test: {@link FDFCatalog#getVersion()}
   */
  @Test
  void testGetVersion2() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setVersion("1.0.2");

    // Act and Assert
    assertEquals("1.0.2", fdfCatalog.getVersion());
  }

  /**
   * Method under test: {@link FDFCatalog#setVersion(String)}
   */
  @Test
  void testSetVersion() {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    doNothing().when(cat).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new FDFCatalog(cat)).setVersion("1.0.2");

    // Assert that nothing has changed
    verify(cat).setName(isA(COSName.class), eq("1.0.2"));
  }

  /**
   * Method under test: {@link FDFCatalog#getFDF()}
   */
  @Test
  void testGetFDF() throws IOException {
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
   * Method under test: {@link FDFCatalog#getFDF()}
   */
  @Test
  void testGetFDF2() throws IOException {
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
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  void testSetFDF() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();

    // Act
    fdfCatalog.setFDF(new FDFDictionary());

    // Assert
    assertNull(fdfCatalog.getFDF().getID());
  }

  /**
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  void testSetFDF2() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();

    // Act
    fdfCatalog.setFDF(null);

    // Assert
    assertNull(fdfCatalog.getFDF().getID());
  }

  /**
   * Method under test: {@link FDFCatalog#setFDF(FDFDictionary)}
   */
  @Test
  void testSetFDF3() {
    // Arrange
    FDFCatalog fdfCatalog = new FDFCatalog();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray id = new COSArray();
    id.add(object);

    FDFDictionary fdf = new FDFDictionary();
    fdf.setID(id);

    // Act
    fdfCatalog.setFDF(fdf);

    // Assert
    verify(object).getCOSObject();
    assertSame(id, fdfCatalog.getFDF().getID());
  }

  /**
   * Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  void testGetSignature() {
    // Arrange, Act and Assert
    assertNull((new FDFCatalog()).getSignature());
  }

  /**
   * Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  void testGetSignature2() {
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
   * Method under test: {@link FDFCatalog#getSignature()}
   */
  @Test
  void testGetSignature3() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDSignature sig = new PDSignature(dict);

    FDFCatalog fdfCatalog = new FDFCatalog();
    fdfCatalog.setSignature(sig);

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
    assertEquals(0, actualSignature.getByteRange().length);
    assertEquals(0, actualSignature.getContents().length);
    assertSame(dict, actualSignature.getCOSObject());
  }

  /**
   * Method under test: {@link FDFCatalog#setSignature(PDSignature)}
   */
  @Test
  void testSetSignature() {
    // Arrange
    COSDictionary cat = mock(COSDictionary.class);
    doNothing().when(cat).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new FDFCatalog(cat)).setSignature(mock(PDSignature.class));

    // Assert that nothing has changed
    verify(cat).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link FDFCatalog#FDFCatalog(COSDictionary)}
   */
  @Test
  void testNewFDFCatalog() {
    // Arrange
    COSDictionary cat = new COSDictionary();

    // Act and Assert
    assertSame(cat, (new FDFCatalog(cat)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFCatalog#FDFCatalog()}
   */
  @Test
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
   * Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  void testNewFDFCatalog3() throws IOException {
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
   * Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  void testNewFDFCatalog4() throws IOException {
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
   * Method under test: {@link FDFCatalog#FDFCatalog(Element)}
   */
  @Test
  void testNewFDFCatalog5() throws IOException {
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
}
