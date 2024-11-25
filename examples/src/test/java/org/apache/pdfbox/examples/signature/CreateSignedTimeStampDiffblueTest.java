package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CreateSignedTimeStampDiffblueTest {
  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'")
  void testSignDetachedWithDocumentOutput() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(new COSDictionary());
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'")
  void testSignDetachedWithDocumentOutput2() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(cosDictionary);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'")
  void testSignDetachedWithDocumentOutput3() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(cosDictionary2);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'")
  void testSignDetachedWithDocumentOutput4() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary3);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(cosDictionary4);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'; given COSArray getObject(int) return COSArray()")
  void testSignDetachedWithDocumentOutput_givenCOSArrayGetObjectReturnCOSArray() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSArray());
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(cosDictionary3);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'; given COSArray getObject(int) return COSDictionary()")
  void testSignDetachedWithDocumentOutput_givenCOSArrayGetObjectReturnCOSDictionary() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(cosDictionary3);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'; given COSDictionary getCOSArray(COSName) return COSArray()")
  void testSignDetachedWithDocumentOutput_givenCOSDictionaryGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(cosDictionary3);
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   * with {@code document}, {@code output}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  @DisplayName("Test signDetached(PDDocument, OutputStream) with 'document', 'output'; then throw IllegalStateException")
  void testSignDetachedWithDocumentOutput_thenThrowIllegalStateException() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenThrow(new IllegalStateException("ETSI.RFC3161"));
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary3);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(cosDictionary4);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1)));
    verify(cosArray).getObject(eq(0));
    verify(cosArray).size();
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(File)} with {@code file}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSignedTimeStamp#signDetached(File)}
   */
  @Test
  @DisplayName("Test signDetached(File) with 'file'; then throw FileNotFoundException")
  void testSignDetachedWithFile_thenThrowFileNotFoundException() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> createSignedTimeStamp.signDetached(Paths
        .get(System.getProperty("java.io.tmpdir"), "org.apache.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange")
        .toFile()));
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(File, File)} with
   * {@code inFile}, {@code outFile}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSignedTimeStamp#signDetached(File, File)}
   */
  @Test
  @DisplayName("Test signDetached(File, File) with 'inFile', 'outFile'; then throw FileNotFoundException")
  void testSignDetachedWithInFileOutFile_thenThrowFileNotFoundException() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    File inFile = Paths
        .get(System.getProperty("java.io.tmpdir"), "org.apache.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange")
        .toFile();

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> createSignedTimeStamp.signDetached(inFile,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }
}
