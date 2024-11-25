package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFXrefStreamParserDiffblueTest {
  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getInt(int, int)} return minus
   * one.</li>
   *   <li>Then calls {@link COSArray#getInt(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFXrefStreamParser(COSStream); given COSArray getInt(int, int) return minus one; then calls getInt(int, int)")
  void testNewPDFXrefStreamParser_givenCOSArrayGetIntReturnMinusOne_thenCallsGetInt() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt(), anyInt())).thenReturn(-1);
    when(cosArray.size()).thenReturn(3);
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
    verify(cosArray, atLeast(1)).getInt(anyInt(), eq(0));
    verify(cosArray).size();
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream).createView();
  }

  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSArray#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFXrefStreamParser(COSStream); given COSArray isEmpty() return 'false'; then calls isEmpty()")
  void testNewPDFXrefStreamParser_givenCOSArrayIsEmptyReturnFalse_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.getInt(anyInt(), anyInt())).thenReturn(1);
    when(cosArray.size()).thenReturn(3);
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
    verify(cosArray, atLeast(1)).getInt(anyInt(), eq(0));
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(stream, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(stream).createView();
  }

  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return
   * {@code true}.</li>
   *   <li>Then calls {@link COSArray#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFXrefStreamParser(COSStream); given COSArray isEmpty() return 'true'; then calls isEmpty()")
  void testNewPDFXrefStreamParser_givenCOSArrayIsEmptyReturnTrue_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.getInt(anyInt(), anyInt())).thenReturn(1);
    when(cosArray.size()).thenReturn(3);
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
    verify(cosArray, atLeast(1)).getInt(anyInt(), eq(0));
    verify(cosArray).isEmpty();
    verify(cosArray).size();
    verify(stream, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(stream).createView();
  }

  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSStream} {@link COSDictionary#getCOSArray(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFXrefStreamParser(COSStream); given COSArray(); when COSStream getCOSArray(COSName) return COSArray()")
  void testNewPDFXrefStreamParser_givenCOSArray_whenCOSStreamGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream).createView();
  }

  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSStream} {@link COSDictionary#getCOSArray(COSName)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFXrefStreamParser(COSStream); given 'null'; when COSStream getCOSArray(COSName) return 'null'")
  void testNewPDFXrefStreamParser_givenNull_whenCOSStreamGetCOSArrayReturnNull() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(stream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
    verify(stream).getCOSArray(isA(COSName.class));
    verify(stream).createView();
  }
}
