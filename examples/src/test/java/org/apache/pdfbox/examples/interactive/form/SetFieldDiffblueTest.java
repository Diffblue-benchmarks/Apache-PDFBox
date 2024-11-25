package org.apache.pdfbox.examples.interactive.form;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashSet;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetFieldDiffblueTest {
  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue2() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    PDDocument doc = new PDDocument();
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, new COSDictionary()));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue3() throws IOException {
    // Arrange
    SetField setField = new SetField();

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setCacheFields(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(pdAcroForm);
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert that nothing has changed
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue4() throws IOException {
    // Arrange
    SetField setField = new SetField();
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue5() throws IOException {
    // Arrange
    SetField setField = new SetField();
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
    setField.setField(pdfDocument, "Name", "42");

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
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue6() throws IOException {
    // Arrange
    SetField setField = new SetField();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
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
    setField.setField(pdfDocument, "Name", "42");

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
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue7() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary).getString(isA(COSName.class));
    verify(cosDictionary).removeItem(isA(COSName.class));
    verify(cosDictionary).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue8() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<String>any())).thenReturn(true);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary2).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary2).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2).containsKey(eq("PMD"));
    verify(cosDictionary2, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2).removeItem(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
    verify(cosDictionary2).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  void testSetFieldWithPdfDocumentNameValue9() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosStream.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosStream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosStream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<String>any())).thenReturn(true);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary2).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary2).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2).containsKey(eq("PMD"));
    verify(cosDictionary2, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosStream).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosStream).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2).removeItem(isA(COSName.class));
    verify(cosStream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosDictionary2, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
    verify(cosDictionary2).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given COSArray() add COSArray()")
  void testSetFieldWithPdfDocumentNameValue_givenCOSArrayAddCOSArray() throws IOException {
    // Arrange
    SetField setField = new SetField();

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument(), form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given COSArray getObject(int) return COSArray()")
  void testSetFieldWithPdfDocumentNameValue_givenCOSArrayGetObjectReturnCOSArray() throws IOException {
    // Arrange
    SetField setField = new SetField();
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
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given COSArray getObject(int) return COSDictionary()")
  void testSetFieldWithPdfDocumentNameValue_givenCOSArrayGetObjectReturnCOSDictionary() throws IOException {
    // Arrange
    SetField setField = new SetField();
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
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given COSArray getObject(int) return COSStream()")
  void testSetFieldWithPdfDocumentNameValue_givenCOSArrayGetObjectReturnCOSStream() throws IOException {
    // Arrange
    SetField setField = new SetField();
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
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return {@code 131072}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given COSDictionary getInt(COSName, int) return '131072'")
  void testSetFieldWithPdfDocumentNameValue_givenCOSDictionaryGetIntReturn131072() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(131072);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary).getString(isA(COSName.class));
    verify(cosDictionary).removeItem(isA(COSName.class));
    verify(cosDictionary).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)}
   * return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given COSDictionary getString(COSName) return 'String'")
  void testSetFieldWithPdfDocumentNameValue_givenCOSDictionaryGetStringReturnString() throws IOException {
    // Arrange
    SetField setField = new SetField();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
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
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSDictionary(COSName)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given COSStream getCOSDictionary(COSName) return 'null'")
  void testSetFieldWithPdfDocumentNameValue_givenCOSStreamGetCOSDictionaryReturnNull() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosStream.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosStream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosStream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<String>any())).thenReturn(true);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary2).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary2).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2).containsKey(eq("PMD"));
    verify(cosStream).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosStream).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosStream).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2).removeItem(isA(COSName.class));
    verify(cosStream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosDictionary2, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
    verify(cosDictionary2).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#containsKey(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; then calls containsKey(String)")
  void testSetFieldWithPdfDocumentNameValue_thenCallsContainsKey() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<String>any())).thenReturn(true);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).containsKey(eq("PMD"));
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary).removeItem(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
    verify(cosDictionary).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#containsKey(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; then calls containsKey(String)")
  void testSetFieldWithPdfDocumentNameValue_thenCallsContainsKey2() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosStream.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosStream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosStream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.containsKey(Mockito.<String>any())).thenReturn(true);
    doNothing().when(cosDictionary3).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary3).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary3).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary3.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary3.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary3).containsKey(eq("PMD"));
    verify(cosDictionary3, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosStream).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary3, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosStream).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary3).removeItem(isA(COSName.class));
    verify(cosStream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosDictionary3, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
    verify(cosDictionary3).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; then calls getCOSDictionary(COSName)")
  void testSetFieldWithPdfDocumentNameValue_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary).getString(isA(COSName.class));
    verify(cosDictionary).removeItem(isA(COSName.class));
    verify(cosDictionary).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSName(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; then calls getCOSName(COSName)")
  void testSetFieldWithPdfDocumentNameValue_thenCallsGetCOSName() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSName(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary2.containsKey(Mockito.<String>any())).thenReturn(true);
    doNothing().when(cosDictionary2).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary2).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary2).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2).containsKey(eq("PMD"));
    verify(cosDictionary2, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary2).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary2).removeItem(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
    verify(cosDictionary2).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with
   * {@code pdfDocument}, {@code name}, {@code value}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#keySet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; then calls keySet()")
  void testSetFieldWithPdfDocumentNameValue_thenCallsKeySet() throws IOException {
    // Arrange
    SetField setField = new SetField();
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosStream.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosStream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(cosStream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.containsKey(Mockito.<String>any())).thenReturn(true);
    doNothing().when(cosDictionary4).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary4.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary3);
    when(cosDictionary4.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    doNothing().when(cosDictionary4).removeItem(Mockito.<COSName>any());
    doNothing().when(cosDictionary4).setString(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary4.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary4.getString(Mockito.<COSName>any())).thenReturn("Name");
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary4.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary4.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary4);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(new PDAcroForm(doc, form));
    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary4).containsKey(eq("PMD"));
    verify(cosDictionary4, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosStream).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary3, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary4, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosStream).getNameAsString(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(cosDictionary4).removeItem(isA(COSName.class));
    verify(cosStream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosDictionary4, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
    verify(cosDictionary4).setString(isA(COSName.class), eq("42"));
    verify(pdfDocument).getDocumentCatalog();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog).getAcroForm();
  }
}
