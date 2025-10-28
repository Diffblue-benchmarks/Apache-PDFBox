package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class PDDocumentNameDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDDocumentNameDictionary#getDests()}
   */
  @Test
  void testGetDests() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()))).getDests());
  }

  /**
   * Method under test: {@link PDDocumentNameDictionary#getDests()}
   */
  @Test
  void testGetDests2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDDestinationNameTreeNode actualDests = (new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))).getDests();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDests);
  }

  /**
   * Method under test:
   * {@link PDDocumentNameDictionary#setDests(PDDestinationNameTreeNode)}
   */
  @Test
  void testSetDests() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(doc, new COSDictionary()));
    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();

    // Act
    pdDocumentNameDictionary.setDests(dests);

    // Assert
    PDDestinationNameTreeNode dests2 = pdDocumentNameDictionary.getDests();
    assertNull(dests2.getLowerLimit());
    assertNull(dests2.getUpperLimit());
    assertNull(dests2.getKids());
    assertNull(dests.getNames());
    assertNull(dests2.getNames());
    COSDictionary cOSObject = dests.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(dests2.getParent());
    COSDictionary cOSObject2 = pdDocumentNameDictionary.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(dests2.isRootNode());
    assertSame(cOSObject, dests2.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentNameDictionary#getEmbeddedFiles()}
   */
  @Test
  void testGetEmbeddedFiles() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()))).getEmbeddedFiles());
  }

  /**
   * Method under test: {@link PDDocumentNameDictionary#getEmbeddedFiles()}
   */
  @Test
  void testGetEmbeddedFiles2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDEmbeddedFilesNameTreeNode actualEmbeddedFiles = (new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))).getEmbeddedFiles();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualEmbeddedFiles);
  }

  /**
   * Method under test:
   * {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}
   */
  @Test
  void testSetEmbeddedFiles() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(doc, new COSDictionary()));
    PDEmbeddedFilesNameTreeNode ef = new PDEmbeddedFilesNameTreeNode();

    // Act
    pdDocumentNameDictionary.setEmbeddedFiles(ef);

    // Assert
    PDEmbeddedFilesNameTreeNode embeddedFiles = pdDocumentNameDictionary.getEmbeddedFiles();
    assertNull(embeddedFiles.getLowerLimit());
    assertNull(embeddedFiles.getUpperLimit());
    assertNull(embeddedFiles.getKids());
    assertNull(ef.getNames());
    assertNull(embeddedFiles.getNames());
    COSDictionary cOSObject = ef.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(embeddedFiles.getParent());
    COSDictionary cOSObject2 = pdDocumentNameDictionary.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(embeddedFiles.isRootNode());
    assertSame(cOSObject, embeddedFiles.getCOSObject());
  }

  /**
   * Method under test: {@link PDDocumentNameDictionary#getJavaScript()}
   */
  @Test
  void testGetJavaScript() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()))).getJavaScript());
  }

  /**
   * Method under test: {@link PDDocumentNameDictionary#getJavaScript()}
   */
  @Test
  void testGetJavaScript2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDJavascriptNameTreeNode actualJavaScript = (new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument(streamCacheCreateFunction)))).getJavaScript();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualJavaScript);
  }

  /**
   * Method under test:
   * {@link PDDocumentNameDictionary#setJavascript(PDJavascriptNameTreeNode)}
   */
  @Test
  void testSetJavascript() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(doc, new COSDictionary()));
    PDJavascriptNameTreeNode js = new PDJavascriptNameTreeNode();

    // Act
    pdDocumentNameDictionary.setJavascript(js);

    // Assert
    PDJavascriptNameTreeNode javaScript = pdDocumentNameDictionary.getJavaScript();
    assertNull(javaScript.getLowerLimit());
    assertNull(javaScript.getUpperLimit());
    assertNull(javaScript.getKids());
    assertNull(js.getNames());
    assertNull(javaScript.getNames());
    COSDictionary cOSObject = js.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(javaScript.getParent());
    COSDictionary cOSObject2 = pdDocumentNameDictionary.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(javaScript.isRootNode());
    assertSame(cOSObject, javaScript.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog, COSDictionary)}
   */
  @Test
  void testNewPDDocumentNameDictionary() {
    // Arrange
    PDDocumentCatalog cat = new PDDocumentCatalog(new PDDocument());
    COSDictionary names = new COSDictionary();

    // Act and Assert
    assertSame(names, (new PDDocumentNameDictionary(cat, names)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog)}
   */
  @Test
  void testNewPDDocumentNameDictionary2() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary rootDictionary = new COSDictionary();
    PDDocumentCatalog cat = new PDDocumentCatalog(doc, rootDictionary);

    // Act
    PDDocumentNameDictionary actualPdDocumentNameDictionary = new PDDocumentNameDictionary(cat);

    // Assert
    COSDictionary cOSObject = actualPdDocumentNameDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdDocumentNameDictionary.getDests());
    PDDocumentNameDictionary names = cat.getNames();
    assertNull(names.getDests());
    assertNull(actualPdDocumentNameDictionary.getEmbeddedFiles());
    assertNull(names.getEmbeddedFiles());
    assertNull(actualPdDocumentNameDictionary.getJavaScript());
    assertNull(names.getJavaScript());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(rootDictionary, cat.getCOSObject());
  }
}
