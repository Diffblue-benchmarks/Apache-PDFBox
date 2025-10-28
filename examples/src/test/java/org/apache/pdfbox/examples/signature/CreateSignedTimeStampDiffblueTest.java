package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.nio.file.Paths;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CreateSignedTimeStampDiffblueTest {
  /**
   * Method under test: {@link CreateSignedTimeStamp#signDetached(File)}
   */
  @Test
  void testSignDetached() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");

    // Act and Assert
    assertThrows(FileNotFoundException.class,
        () -> createSignedTimeStamp.signDetached(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile()));
  }

  /**
   * Method under test: {@link CreateSignedTimeStamp#signDetached(File, File)}
   */
  @Test
  void testSignDetached2() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    File inFile = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> createSignedTimeStamp.signDetached(inFile,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached3() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getCOSObject()).thenReturn(new COSDictionary());
    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addSignature(Mockito.<PDSignature>any(), Mockito.<SignatureInterface>any());
    doNothing().when(document).saveIncremental(Mockito.<OutputStream>any());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached4() throws IOException {
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

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached5() throws IOException {
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

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached6() throws IOException {
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

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached7() throws IOException {
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

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached8() throws IOException {
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

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached9() throws IOException {
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

    // Act
    createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1));

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(document).addSignature(isA(PDSignature.class), isA(SignatureInterface.class));
    verify(document).getDocumentCatalog();
    verify(document).saveIncremental(isA(OutputStream.class));
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test:
   * {@link CreateSignedTimeStamp#signDetached(PDDocument, OutputStream)}
   */
  @Test
  void testSignDetached10() throws IOException {
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

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> createSignedTimeStamp.signDetached(document, new ByteArrayOutputStream(1)));
    verify(cosArray).getObject(eq(0));
    verify(cosArray).size();
    verify(cosDictionary2).getCOSArray(isA(COSName.class));
    verify(cosDictionary4).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getCOSObject();
  }

  /**
   * Method under test: {@link CreateSignedTimeStamp#sign(InputStream)}
   */
  @Test
  void testSign() throws IOException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));
      CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("Opening connection to TSA server");

      // Act and Assert
      assertEquals(0, createSignedTimeStamp.sign(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).length);
    }
  }
}
