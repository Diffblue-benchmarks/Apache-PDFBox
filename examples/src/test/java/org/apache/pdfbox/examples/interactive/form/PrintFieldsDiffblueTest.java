package org.apache.pdfbox.examples.interactive.form;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PrintFieldsDiffblueTest {
  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument)")
  void testPrintFields() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument)")
  void testPrintFields2() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    PDDocument doc = new PDDocument();
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, new COSDictionary()));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert that nothing has changed
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given COSArray getObject(int) return COSArray(); then calls getObject(int)")
  void testPrintFields_givenCOSArrayGetObjectReturnCOSArray_thenCallsGetObject() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSArray());
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  void testPrintFields_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsGetObject() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given COSArray getObject(int) return COSStream(); then calls getObject(int)")
  void testPrintFields_givenCOSArrayGetObjectReturnCOSStream_thenCallsGetObject() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSStream());
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given COSDictionary getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  void testPrintFields_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsGetCOSArray() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getNameAsString(COSName)} return
   * {@code Name As String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given COSDictionary getNameAsString(COSName) return 'Name As String'")
  void testPrintFields_givenCOSDictionaryGetNameAsStringReturnNameAsString() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given COSDictionary getString(COSName) return 'null'")
  void testPrintFields_givenCOSDictionaryGetStringReturnNull() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)}
   * return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given COSDictionary getString(COSName) return 'String'")
  void testPrintFields_givenCOSDictionaryGetStringReturnString() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }
}
