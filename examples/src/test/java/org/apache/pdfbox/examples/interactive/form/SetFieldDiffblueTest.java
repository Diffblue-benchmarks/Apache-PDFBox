package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetFieldDiffblueTest {
  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue() throws IOException {
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

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue2() throws IOException {
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
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue3() throws IOException {
    // Arrange
    SetField setField = new SetField();

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());
    when(pdDocumentCatalog.getAcroForm()).thenReturn(pdAcroForm);

    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName("Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue4() throws IOException {
    // Arrange
    SetField setField = new SetField();

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getField(Mockito.<String>any()))
        .thenReturn(new PDCheckBox(new PDAcroForm(new PDDocument())));
    doNothing().when(pdAcroForm).setCacheFields(anyBoolean());
    pdAcroForm.setCacheFields(true);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(pdAcroForm);

    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
    verify(pdAcroForm).getField("Name");
    verify(pdAcroForm).setCacheFields(true);
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm} {@link PDAcroForm#getField(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName(
      "Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given PDAcroForm getField(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue_givenPDAcroFormGetFieldReturnNull() throws IOException {
    // Arrange
    SetField setField = new SetField();

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getField(Mockito.<String>any())).thenReturn(null);
    doNothing().when(pdAcroForm).setCacheFields(anyBoolean());
    pdAcroForm.setCacheFields(true);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(pdAcroForm);

    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
    verify(pdAcroForm).getField("Name");
    verify(pdAcroForm).setCacheFields(true);
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox} {@link PDCheckBox#unCheck()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName(
      "Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; given PDCheckBox unCheck() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue_givenPDCheckBoxUnCheckDoesNothing() throws IOException {
    // Arrange
    SetField setField = new SetField();

    PDCheckBox pdCheckBox = mock(PDCheckBox.class);
    doNothing().when(pdCheckBox).unCheck();

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getField(Mockito.<String>any())).thenReturn(pdCheckBox);
    doNothing().when(pdAcroForm).setCacheFields(anyBoolean());
    pdAcroForm.setCacheFields(true);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(pdAcroForm);

    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "");

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
    verify(pdAcroForm).getField("Name");
    verify(pdAcroForm).setCacheFields(true);
    verify(pdCheckBox).unCheck();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <ul>
   *   <li>Then calls {@link PDCheckBox#check()}.
   * </ul>
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName(
      "Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; then calls check()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue_thenCallsCheck() throws IOException {
    // Arrange
    SetField setField = new SetField();

    PDCheckBox pdCheckBox = mock(PDCheckBox.class);
    doNothing().when(pdCheckBox).check();

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getField(Mockito.<String>any())).thenReturn(pdCheckBox);
    doNothing().when(pdAcroForm).setCacheFields(anyBoolean());
    pdAcroForm.setCacheFields(true);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(pdAcroForm);

    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    setField.setField(pdfDocument, "Name", "42");

    // Assert
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
    verify(pdAcroForm).getField("Name");
    verify(pdAcroForm).setCacheFields(true);
    verify(pdCheckBox).check();
  }

  /**
   * Test {@link SetField#setField(PDDocument, String, String)} with {@code pdfDocument}, {@code
   * name}, {@code value}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SetField#setField(PDDocument, String, String)}
   */
  @Test
  @DisplayName(
      "Test setField(PDDocument, String, String) with 'pdfDocument', 'name', 'value'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetField.setField(PDDocument, String, String)"})
  void testSetFieldWithPdfDocumentNameValue_thenThrowIOException() throws IOException {
    // Arrange
    SetField setField = new SetField();

    PDCheckBox pdCheckBox = mock(PDCheckBox.class);
    doThrow(new IOException()).when(pdCheckBox).unCheck();

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getField(Mockito.<String>any())).thenReturn(pdCheckBox);
    doNothing().when(pdAcroForm).setCacheFields(anyBoolean());
    pdAcroForm.setCacheFields(true);

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm()).thenReturn(pdAcroForm);

    PDDocument pdfDocument = mock(PDDocument.class);
    when(pdfDocument.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act and Assert
    assertThrows(IOException.class, () -> setField.setField(pdfDocument, "Name", ""));
    verify(pdfDocument).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm();
    verify(pdAcroForm).getField("Name");
    verify(pdAcroForm).setCacheFields(true);
    verify(pdCheckBox).unCheck();
  }
}
