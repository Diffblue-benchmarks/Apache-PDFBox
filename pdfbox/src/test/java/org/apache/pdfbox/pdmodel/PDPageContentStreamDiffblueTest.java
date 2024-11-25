package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPageContentStreamDiffblueTest {
  /**
   * Test AppendMode {@link AppendMode#isOverwrite()}.
   * <ul>
   *   <li>Given {@code APPEND}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageContentStream.AppendMode#isOverwrite()}
   */
  @Test
  @DisplayName("Test AppendMode isOverwrite(); given 'APPEND'; then return 'false'")
  void testAppendModeIsOverwrite_givenAppend_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PDPageContentStream.AppendMode.APPEND.isOverwrite());
  }

  /**
   * Test AppendMode {@link AppendMode#isOverwrite()}.
   * <ul>
   *   <li>Given {@code OVERWRITE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageContentStream.AppendMode#isOverwrite()}
   */
  @Test
  @DisplayName("Test AppendMode isOverwrite(); given 'OVERWRITE'; then return 'true'")
  void testAppendModeIsOverwrite_givenOverwrite_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PDPageContentStream.AppendMode.OVERWRITE.isOverwrite());
  }

  /**
   * Test AppendMode {@link AppendMode#isPrepend()}.
   * <ul>
   *   <li>Given {@code OVERWRITE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageContentStream.AppendMode#isPrepend()}
   */
  @Test
  @DisplayName("Test AppendMode isPrepend(); given 'OVERWRITE'; then return 'false'")
  void testAppendModeIsPrepend_givenOverwrite_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PDPageContentStream.AppendMode.OVERWRITE.isPrepend());
  }

  /**
   * Test AppendMode {@link AppendMode#isPrepend()}.
   * <ul>
   *   <li>Given {@link AppendMode#PREPEND}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageContentStream.AppendMode#isPrepend()}
   */
  @Test
  @DisplayName("Test AppendMode isPrepend(); given PREPEND; then return 'true'")
  void testAppendModeIsPrepend_givenPrepend_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PDPageContentStream.AppendMode.PREPEND.isPrepend());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)")
  void testNewPDPageContentStream() throws IOException {
    // Arrange
    COSDocument cosDocument = mock(COSDocument.class);
    COSStream cosStream = new COSStream();
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(document).getDocument();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(1, nextResult.getFilters().size());
    assertFalse(contentStreams.hasNext());
    assertTrue(sourcePage.hasContents());
    assertSame(cosStream, nextResult.getCOSObject());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)")
  void testNewPDPageContentStream2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    assertNull(sourcePage.getContentsForRandomAccess());
    assertNull(sourcePage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)")
  void testNewPDPageContentStream3() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosStream).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)")
  void testNewPDPageContentStream4() throws IOException {
    // Arrange
    COSDocument cosDocument = mock(COSDocument.class);
    COSStream cosStream = new COSStream();
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(document).getDocument();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(1, nextResult.getFilters().size());
    assertFalse(contentStreams.hasNext());
    assertTrue(sourcePage.hasContents());
    assertSame(cosStream, nextResult.getCOSObject());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)")
  void testNewPDPageContentStream5() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    assertNull(sourcePage.getContentsForRandomAccess());
    assertNull(sourcePage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)")
  void testNewPDPageContentStream6() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true);

    // Assert
    verify(cosStream, atLeast(1)).isDirect();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosStream, atLeast(1)).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage); given ArrayList() add PDStream(COSDocument) with document is COSDocument()")
  void testNewPDPageContentStream_givenArrayListAddPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    ArrayList<PDStream> contents = new ArrayList<>();
    contents.add(new PDStream(new COSDocument()));

    PDPage sourcePage = new PDPage();
    sourcePage.setContents(contents);

    // Act
    new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(nextResult.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(sourcePage.hasContents());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(COSObjectable)} does
   * nothing.</li>
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSArray add(COSObjectable) does nothing; then calls add(COSObjectable)")
  void testNewPDPageContentStream_givenCOSArrayAddDoesNothing_thenCallsAdd() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true);

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(int, COSBase)} does
   * nothing.</li>
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSArray add(int, COSBase) does nothing; then calls add(COSObjectable)")
  void testNewPDPageContentStream_givenCOSArrayAddDoesNothing_thenCallsAdd2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(anyInt(), Mockito.<COSBase>any());
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true);

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray).add(eq(0), isA(COSBase.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(int, COSBase)} does
   * nothing.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link COSArray#add(int, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSArray add(int, COSBase) does nothing; when 'false'; then calls add(int, COSBase)")
  void testNewPDPageContentStream_givenCOSArrayAddDoesNothing_whenFalse_thenCallsAdd() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(anyInt(), Mockito.<COSBase>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.PREPEND, false);

    // Assert
    verify(cosArray).add(eq(0), isA(COSBase.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isNull());
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(int, COSBase)} does
   * nothing.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSArray add(int, COSBase) does nothing; when 'false'; then calls add(COSObjectable)")
  void testNewPDPageContentStream_givenCOSArrayAddDoesNothing_whenFalse_thenCallsAdd2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(anyInt(), Mockito.<COSBase>any());
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, false, true);

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray).add(eq(0), isA(COSBase.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isNull());
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(COSObjectable)} does
   * nothing.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link COSArray#add(COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSArray add(COSObjectable) does nothing; when 'false'; then calls add(COSObjectable)")
  void testNewPDPageContentStream_givenCOSArrayAddDoesNothing_whenFalse_thenCallsAdd3() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, false);

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(int, COSBase)} does
   * nothing.</li>
   *   <li>When {@code PREPEND}.</li>
   *   <li>Then calls {@link COSArray#add(int, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSArray add(int, COSBase) does nothing; when 'PREPEND'; then calls add(int, COSBase)")
  void testNewPDPageContentStream_givenCOSArrayAddDoesNothing_whenPrepend_thenCallsAdd() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(anyInt(), Mockito.<COSBase>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.PREPEND, true);

    // Assert
    verify(cosArray).add(eq(0), isA(COSBase.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#add(int, COSBase)} does
   * nothing.</li>
   *   <li>When {@code PREPEND}.</li>
   *   <li>Then calls {@link COSArray#add(int, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSArray add(int, COSBase) does nothing; when 'PREPEND'; then calls add(int, COSBase)")
  void testNewPDPageContentStream_givenCOSArrayAddDoesNothing_whenPrepend_thenCallsAdd2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(anyInt(), Mockito.<COSBase>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.PREPEND, true, true);

    // Assert
    verify(cosArray, atLeast(1)).add(eq(0), isA(COSBase.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSDictionary()")
  void testNewPDPageContentStream_givenCOSDictionary() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(new COSDictionary());
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSDictionary()")
  void testNewPDPageContentStream_givenCOSDictionary2() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(new COSDictionary());
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true);

    // Assert
    verify(cosStream, atLeast(1)).isDirect();
    verify(cosStream, atLeast(1)).getUpdateState();
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  void testNewPDPageContentStream_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosStream).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  void testNewPDPageContentStream_givenCOSDictionaryGetDictionaryObjectReturnCOSArray2() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true);

    // Assert
    verify(cosStream, atLeast(1)).isDirect();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosStream, atLeast(1)).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSDictionary getDictionaryObject(COSName) return FALSE")
  void testNewPDPageContentStream_givenCOSDictionaryGetDictionaryObjectReturnFalse() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosStream).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSDictionary getDictionaryObject(COSName) return FALSE")
  void testNewPDPageContentStream_givenCOSDictionaryGetDictionaryObjectReturnFalse2() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(cosDictionary);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true);

    // Assert
    verify(cosStream, atLeast(1)).isDirect();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosStream, atLeast(1)).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSStream isDirect() return 'false'; then calls getKey()")
  void testNewPDPageContentStream_givenCOSStreamIsDirectReturnFalse_thenCallsGetKey() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(false);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getKey()).thenReturn(new COSObjectKey(1L, 1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true);

    // Assert
    verify(cosStream, atLeast(1)).getKey();
    verify(cosStream).isDirect();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    assertNull(sourcePage.getContentsForRandomAccess());
    assertNull(sourcePage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given COSStream isDirect() return 'false'; then calls getKey()")
  void testNewPDPageContentStream_givenCOSStreamIsDirectReturnFalse_thenCallsGetKey2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(false);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getKey()).thenReturn(new COSObjectKey(1L, 1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(new COSDictionary());
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true);

    // Assert
    verify(cosStream, atLeast(1)).getKey();
    verify(cosStream).isDirect();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSStream isDirect() return 'false'; then calls getKey()")
  void testNewPDPageContentStream_givenCOSStreamIsDirectReturnFalse_thenCallsGetKey3() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(false);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getKey()).thenReturn(new COSObjectKey(1L, 1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true, true);

    // Assert
    verify(cosStream, atLeast(1)).getKey();
    verify(cosStream).isDirect();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    assertNull(sourcePage.getContentsForRandomAccess());
    assertNull(sourcePage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given COSStream isDirect() return 'false'; then calls getKey()")
  void testNewPDPageContentStream_givenCOSStreamIsDirectReturnFalse_thenCallsGetKey4() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.isDirect()).thenReturn(false);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getKey()).thenReturn(new COSObjectKey(1L, 1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(new COSDictionary());
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true);

    // Assert
    verify(cosStream, atLeast(1)).getKey();
    verify(cosStream, atLeast(1)).isDirect();
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage, atLeast(1)).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PDPage} {@link PDPage#hasContents()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); given 'false'; when PDPage hasContents() return 'false'")
  void testNewPDPageContentStream_givenFalse_whenPDPageHasContentsReturnFalse() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.hasContents()).thenReturn(false);
    when(sourcePage.getResources()).thenReturn(new PDResources());
    doNothing().when(sourcePage).setContents(Mockito.<PDStream>any());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage, atLeast(1)).hasContents();
    verify(sourcePage).setContents(isA(PDStream.class));
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PDPage} {@link PDPage#hasContents()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); given 'false'; when PDPage hasContents() return 'false'")
  void testNewPDPageContentStream_givenFalse_whenPDPageHasContentsReturnFalse2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.hasContents()).thenReturn(false);
    when(sourcePage.getResources()).thenReturn(new PDResources());
    doNothing().when(sourcePage).setContents(Mockito.<PDStream>any());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage, atLeast(1)).hasContents();
    verify(sourcePage).setContents(isA(PDStream.class));
  }

  /**
   * Test {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}.
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage); given PDStream(COSDocument) with document is COSDocument()")
  void testNewPDPageContentStream_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    PDPage sourcePage = new PDPage();
    sourcePage.setContents(new PDStream(new COSDocument()));

    // Act
    new PDPageContentStream(document, sourcePage);

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    PDStream nextResult = contentStreams.next();
    assertNull(nextResult.getDecodeParms());
    assertNull(nextResult.getFileDecodeParams());
    COSStream cOSObject = nextResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(nextResult.getMetadata());
    assertNull(nextResult.getFile());
    assertEquals(-1, nextResult.getDecodedStreamLength());
    assertEquals(0, nextResult.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(contentStreams.hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(nextResult.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(sourcePage.hasContents());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Then calls {@link PDPage#setResources(PDResources)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); then calls setResources(PDResources)")
  void testNewPDPageContentStream_thenCallsSetResources() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(null);
    doNothing().when(sourcePage).setContents(Mockito.<PDStream>any());
    doNothing().when(sourcePage).setResources(Mockito.<PDResources>any());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
    verify(sourcePage).setContents(isA(PDStream.class));
    verify(sourcePage).setResources(isA(PDResources.class));
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Then calls {@link PDPage#setResources(PDResources)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); then calls setResources(PDResources)")
  void testNewPDPageContentStream_thenCallsSetResources2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(null);
    doNothing().when(sourcePage).setContents(Mockito.<PDStream>any());
    doNothing().when(sourcePage).setResources(Mockito.<PDResources>any());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
    verify(sourcePage).setContents(isA(PDStream.class));
    verify(sourcePage).setResources(isA(PDResources.class));
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} ContentsForRandomAccess is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); then PDPage() ContentsForRandomAccess is 'null'")
  void testNewPDPageContentStream_thenPDPageContentsForRandomAccessIsNull() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(document).getDocument();
    assertNull(sourcePage.getContentsForRandomAccess());
    assertNull(sourcePage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} ContentsForRandomAccess is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); then PDPage() ContentsForRandomAccess is 'null'")
  void testNewPDPageContentStream_thenPDPageContentsForRandomAccessIsNull2() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = new PDPage();

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true, true);

    // Assert
    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(document).getDocument();
    assertNull(sourcePage.getContentsForRandomAccess());
    assertNull(sourcePage.getContentsForStreamParsing());
    Iterator<PDStream> contentStreams = sourcePage.getContentStreams();
    assertEquals(0, contentStreams.next().getDecodedStreamLength());
    assertFalse(contentStreams.hasNext());
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); then throw IOException")
  void testNewPDPageContentStream_thenThrowIOException() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream()).thenThrow(new IOException("q"));
    when(cosStream.isDirect()).thenReturn(true);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(cosStream.getUpdateState()).thenReturn(cosUpdateState);
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.getCOSObject()).thenReturn(new COSDictionary());
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());

    // Act and Assert
    assertThrows(IOException.class,
        () -> new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.APPEND, true, true));

    verify(cosStream).isDirect();
    verify(cosStream).getUpdateState();
    verify(cosDocument, atLeast(1)).createCOSStream();
    verify(cosStream).createOutputStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(document, atLeast(1)).getDocument();
    verify(sourcePage).getCOSObject();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean)}.
   * <ul>
   *   <li>When {@link PDPage} {@link PDPage#setContents(PDStream)} does
   * nothing.</li>
   *   <li>Then calls {@link PDPage#setContents(PDStream)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean); when PDPage setContents(PDStream) does nothing; then calls setContents(PDStream)")
  void testNewPDPageContentStream_whenPDPageSetContentsDoesNothing_thenCallsSetContents() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());
    doNothing().when(sourcePage).setContents(Mockito.<PDStream>any());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
    verify(sourcePage).setContents(isA(PDStream.class));
  }

  /**
   * Test
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean)}.
   * <ul>
   *   <li>When {@link PDPage} {@link PDPage#setContents(PDStream)} does
   * nothing.</li>
   *   <li>Then calls {@link PDPage#setContents(PDStream)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageContentStream#PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new PDPageContentStream(PDDocument, PDPage, AppendMode, boolean, boolean); when PDPage setContents(PDStream) does nothing; then calls setContents(PDStream)")
  void testNewPDPageContentStream_whenPDPageSetContentsDoesNothing_thenCallsSetContents2() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(cosStream);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocument()).thenReturn(cosDocument);
    PDPage sourcePage = mock(PDPage.class);
    when(sourcePage.hasContents()).thenReturn(true);
    when(sourcePage.getResources()).thenReturn(new PDResources());
    doNothing().when(sourcePage).setContents(Mockito.<PDStream>any());

    // Act
    new PDPageContentStream(document, sourcePage, PDPageContentStream.AppendMode.OVERWRITE, true, true);

    // Assert
    verify(cosDocument).createCOSStream();
    verify(cosStream).createOutputStream(isA(COSBase.class));
    verify(document).getDocument();
    verify(sourcePage, atLeast(1)).getResources();
    verify(sourcePage).hasContents();
    verify(sourcePage).setContents(isA(PDStream.class));
  }
}
