package org.apache.pdfbox.pdmodel.interactive.form;

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
