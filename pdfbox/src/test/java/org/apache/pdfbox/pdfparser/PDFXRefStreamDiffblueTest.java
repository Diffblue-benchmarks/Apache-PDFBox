package org.apache.pdfbox.pdfparser;

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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.function.BiConsumer;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFXRefStreamDiffblueTest {
  /**
   * Test {@link PDFXRefStream#PDFXRefStream(COSDocument)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then calls {@link COSDocument#createCOSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#PDFXRefStream(COSDocument)}
   */
  @Test
  @DisplayName("Test new PDFXRefStream(COSDocument); given COSStream(); then calls createCOSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFXRefStream.<init>(COSDocument)"})
  void testNewPDFXRefStream_givenCOSStream_thenCallsCreateCOSStream() {
    // Arrange
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(new COSStream());

    // Act
    new PDFXRefStream(cosDocument);

    // Assert
    verify(cosDocument).createCOSStream();
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument is {@link COSDocument#COSDocument()} Size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument() Size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentSizeIsThree() throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFXRefStream(new COSDocument())).getStream());
  }

  /**
   * Test {@link PDFXRefStream#addTrailerInfo(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary} {@link COSDictionary#forEach(BiConsumer)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#forEach(BiConsumer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXRefStream#addTrailerInfo(COSDictionary)}
   */
  @Test
  @DisplayName("Test addTrailerInfo(COSDictionary); when COSDictionary forEach(BiConsumer) does nothing; then calls forEach(BiConsumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFXRefStream.addTrailerInfo(COSDictionary)"})
  void testAddTrailerInfo_whenCOSDictionaryForEachDoesNothing_thenCallsForEach() {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    COSDictionary trailerDict = mock(COSDictionary.class);
    doNothing().when(trailerDict).forEach(Mockito.<BiConsumer<COSName, COSBase>>any());

    // Act
    pdfxRefStream.addTrailerInfo(trailerDict);

    // Assert
    verify(trailerDict).forEach(isA(BiConsumer.class));
  }
}
