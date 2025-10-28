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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFXrefStreamParserDiffblueTest {
  /**
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  void testNewPDFXrefStreamParser() throws IOException {
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
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  void testNewPDFXrefStreamParser2() throws IOException {
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

  /**
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  void testNewPDFXrefStreamParser3() throws IOException {
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
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  void testNewPDFXrefStreamParser4() throws IOException {
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
   * Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  void testNewPDFXrefStreamParser5() throws IOException {
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
}
