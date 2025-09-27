package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AppearanceGeneratorHelperDiffblueTest {
  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   *
   * <p>Method under test: {@link
   * AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(field).getAcroForm();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   *
   * <p>Method under test: {@link
   * AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper2() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    when(field.getDefaultAppearance()).thenThrow(new IllegalArgumentException());
    when(field.getDefaultAppearanceString()).thenThrow(new IOException());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   *
   * <p>Method under test: {@link
   * AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper3() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    PDVariableText field = mock(PDVariableText.class);
    when(field.getWidgets()).thenThrow(new IllegalArgumentException());
    when(field.getAcroForm()).thenReturn(pdAcroForm);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getWidgets();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper_givenArrayList() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    PDVariableText field = mock(PDVariableText.class);
    when(field.getWidgets()).thenReturn(new ArrayList<>());
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearance()).thenReturn("Default Appearance");
    when(field.getDefaultAppearanceString()).thenThrow(new IOException());
    when(field.getAcroForm()).thenReturn(pdAcroForm);

    // Act and Assert
    assertThrows(IOException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   *
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName(
      "Test new AppearanceGeneratorHelper(PDVariableText); given 'Dr Jane Doe'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper_givenDrJaneDoe_thenThrowIOException() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearance()).thenReturn("Default Appearance");
    when(field.getDefaultAppearanceString()).thenThrow(new IOException());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IOException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getFullyQualifiedName();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PDComboBox#getAcroForm()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then calls getAcroForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenCallsGetAcroForm() throws IOException {
    // Arrange
    PDComboBox field = mock(PDComboBox.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(new ArrayList<>());
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }
}
