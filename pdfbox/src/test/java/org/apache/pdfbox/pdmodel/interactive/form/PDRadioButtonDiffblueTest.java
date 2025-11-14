package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDRadioButtonDiffblueTest {
  /**
   * Test {@link PDRadioButton#PDRadioButton(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <p>Method under test: {@link PDRadioButton#PDRadioButton(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDRadioButton(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRadioButton.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
  void testNewPDRadioButton() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDRadioButton actualPdRadioButton = new PDRadioButton(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdRadioButton.getCOSObject());
    assertSame(acroForm, actualPdRadioButton.getAcroForm());
    assertSame(parent, actualPdRadioButton.getParent());
  }

  /**
   * Test {@link PDRadioButton#PDRadioButton(PDAcroForm)}.
   *
   * <p>Method under test: {@link PDRadioButton#PDRadioButton(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDRadioButton(PDAcroForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRadioButton.<init>(PDAcroForm)"})
  void testNewPDRadioButton2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDRadioButton actualPdRadioButton = new PDRadioButton(acroForm);

    // Assert
    assertEquals("", actualPdRadioButton.getDefaultValue());
    assertEquals("Btn", actualPdRadioButton.getFieldType());
    assertEquals("Off", actualPdRadioButton.getValue());
    assertEquals("Off", actualPdRadioButton.getValueAsString());
    assertNull(actualPdRadioButton.getAlternateFieldName());
    assertNull(actualPdRadioButton.getFullyQualifiedName());
    assertNull(actualPdRadioButton.getMappingName());
    assertNull(actualPdRadioButton.getPartialName());
    assertNull(actualPdRadioButton.getActions());
    assertNull(actualPdRadioButton.getParent());
    assertEquals(0, actualPdRadioButton.getSelectedIndex());
    assertEquals(1, actualPdRadioButton.getSelectedExportValues().size());
    assertEquals(1, actualPdRadioButton.getWidgets().size());
    assertEquals(1, actualPdRadioButton.getOnValues().size());
    assertEquals(32768, actualPdRadioButton.getFieldFlags());
    assertFalse(actualPdRadioButton.isPushButton());
    assertFalse(actualPdRadioButton.isNoExport());
    assertFalse(actualPdRadioButton.isReadOnly());
    assertFalse(actualPdRadioButton.isRequired());
    assertFalse(actualPdRadioButton.isRadiosInUnison());
    assertTrue(actualPdRadioButton.getExportValues().isEmpty());
    assertTrue(actualPdRadioButton.isRadioButton());
    assertSame(acroForm, actualPdRadioButton.getAcroForm());
  }

  /**
   * Test {@link PDRadioButton#setRadiosInUnison(boolean)}.
   *
   * <p>Method under test: {@link PDRadioButton#setRadiosInUnison(boolean)}
   */
  @Test
  @DisplayName("Test setRadiosInUnison(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRadioButton.setRadiosInUnison(boolean)"})
  void testSetRadiosInUnison() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDRadioButton pdRadioButton = new PDRadioButton(acroForm, field, parent);

    // Act
    pdRadioButton.setRadiosInUnison(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(33554432), eq(true));
    assertEquals(0, pdRadioButton.getFieldFlags());
    assertFalse(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#isRadiosInUnison()}.
   *
   * <p>Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  @DisplayName("Test isRadiosInUnison()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRadioButton.isRadiosInUnison()"})
  void testIsRadiosInUnison() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDRadioButton pdRadioButton = new PDRadioButton(acroForm, field, parent);

    // Act and Assert
    assertFalse(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#isRadiosInUnison()}.
   *
   * <ul>
   *   <li>Given {@link PDRadioButton#PDRadioButton(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  @DisplayName(
      "Test isRadiosInUnison(); given PDRadioButton(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRadioButton.isRadiosInUnison()"})
  void testIsRadiosInUnison_givenPDRadioButtonWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDRadioButton(new PDAcroForm(new PDDocument())).isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#isRadiosInUnison()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  @DisplayName("Test isRadiosInUnison(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDRadioButton.isRadiosInUnison()"})
  void testIsRadiosInUnison_thenReturnTrue() {
    // Arrange
    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument()));
    pdRadioButton.setFieldFlags(33554432);

    // Act and Assert
    assertTrue(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#getSelectedIndex()}.
   *
   * <p>Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  @DisplayName("Test getSelectedIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDRadioButton.getSelectedIndex()"})
  void testGetSelectedIndex() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDRadioButton pdRadioButton = new PDRadioButton(acroForm, field, parent);

    // Act and Assert
    assertEquals(0, pdRadioButton.getSelectedIndex());
  }

  /**
   * Test {@link PDRadioButton#getSelectedIndex()}.
   *
   * <ul>
   *   <li>Given {@link PDRadioButton#PDRadioButton(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  @DisplayName(
      "Test getSelectedIndex(); given PDRadioButton(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDRadioButton.getSelectedIndex()"})
  void testGetSelectedIndex_givenPDRadioButtonWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDRadioButton(new PDAcroForm(new PDDocument())).getSelectedIndex());
  }

  /**
   * Test {@link PDRadioButton#getSelectedExportValues()}.
   *
   * <p>Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  @DisplayName("Test getSelectedExportValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDRadioButton.getSelectedExportValues()"})
  void testGetSelectedExportValues() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act
    List<String> actualSelectedExportValues = new PDRadioButton(acroForm).getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }

  /**
   * Test {@link PDRadioButton#getSelectedExportValues()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  @DisplayName(
      "Test getSelectedExportValues(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDRadioButton.getSelectedExportValues()"})
  void testGetSelectedExportValues_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    PDRadioButton pdRadioButton = new PDRadioButton(acroForm, field, parent);

    // Act
    List<String> actualSelectedExportValues = pdRadioButton.getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }

  /**
   * Test {@link PDRadioButton#getSelectedExportValues()}.
   *
   * <ul>
   *   <li>Given {@link PDRadioButton#PDRadioButton(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  @DisplayName(
      "Test getSelectedExportValues(); given PDRadioButton(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDRadioButton.getSelectedExportValues()"})
  void testGetSelectedExportValues_givenPDRadioButtonWithAcroFormIsPDAcroForm() {
    // Arrange and Act
    List<String> actualSelectedExportValues =
        new PDRadioButton(new PDAcroForm(new PDDocument())).getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }
}
