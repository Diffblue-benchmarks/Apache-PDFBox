package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPushButtonDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPushButton#PDPushButton(PDAcroForm, COSDictionary, PDNonTerminalField)}
   *   <li>{@link PDPushButton#constructAppearances()}
   *   <li>{@link PDPushButton#getDefaultValue()}
   *   <li>{@link PDPushButton#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPushButton.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)",
      "void PDPushButton.constructAppearances()", "String PDPushButton.getDefaultValue()",
      "String PDPushButton.getValue()"})
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDPushButton actualPdPushButton = new PDPushButton(acroForm, field, parent);
    actualPdPushButton.constructAppearances();
    String actualDefaultValue = actualPdPushButton.getDefaultValue();

    // Assert
    assertEquals("", actualDefaultValue);
    assertEquals("", actualPdPushButton.getValue());
    assertSame(field, actualPdPushButton.getCOSObject());
    assertSame(acroForm, actualPdPushButton.getAcroForm());
    assertSame(parent, actualPdPushButton.getParent());
  }

  /**
   * Test {@link PDPushButton#PDPushButton(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDPushButton#PDPushButton(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDPushButton(PDAcroForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPushButton.<init>(PDAcroForm)"})
  void testNewPDPushButton() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDPushButton actualPdPushButton = new PDPushButton(acroForm);

    // Assert
    assertEquals("", actualPdPushButton.getDefaultValue());
    assertEquals("", actualPdPushButton.getValue());
    assertEquals("", actualPdPushButton.getValueAsString());
    assertEquals("Btn", actualPdPushButton.getFieldType());
    assertNull(actualPdPushButton.getAlternateFieldName());
    assertNull(actualPdPushButton.getFullyQualifiedName());
    assertNull(actualPdPushButton.getMappingName());
    assertNull(actualPdPushButton.getPartialName());
    assertNull(actualPdPushButton.getActions());
    assertNull(actualPdPushButton.getParent());
    assertEquals(1, actualPdPushButton.getWidgets().size());
    assertEquals(65536, actualPdPushButton.getFieldFlags());
    assertFalse(actualPdPushButton.isRadioButton());
    assertFalse(actualPdPushButton.isNoExport());
    assertFalse(actualPdPushButton.isReadOnly());
    assertFalse(actualPdPushButton.isRequired());
    assertTrue(actualPdPushButton.getExportValues().isEmpty());
    assertTrue(actualPdPushButton.getOnValues().isEmpty());
    assertTrue(actualPdPushButton.isPushButton());
    assertSame(acroForm, actualPdPushButton.getAcroForm());
  }

  /**
   * Test {@link PDPushButton#getExportValues()}.
   * <p>
   * Method under test: {@link PDPushButton#getExportValues()}
   */
  @Test
  @DisplayName("Test getExportValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDPushButton.getExportValues()"})
  void testGetExportValues() {
    // Arrange, Act and Assert
    assertTrue((new PDPushButton(new PDAcroForm(new PDDocument()))).getExportValues().isEmpty());
  }

  /**
   * Test {@link PDPushButton#setExportValues(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPushButton#setExportValues(List)}
   */
  @Test
  @DisplayName("Test setExportValues(List); given 'foo'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPushButton.setExportValues(List)"})
  void testSetExportValues_givenFoo_thenThrowIllegalArgumentException() {
    // Arrange
    PDPushButton pdPushButton = new PDPushButton(new PDAcroForm(new PDDocument()));

    ArrayList<String> values = new ArrayList<>();
    values.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPushButton.setExportValues(values));
  }

  /**
   * Test {@link PDPushButton#setExportValues(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPushButton#setExportValues(List)}
   */
  @Test
  @DisplayName("Test setExportValues(List); given 'foo'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPushButton.setExportValues(List)"})
  void testSetExportValues_givenFoo_thenThrowIllegalArgumentException2() {
    // Arrange
    PDPushButton pdPushButton = new PDPushButton(new PDAcroForm(new PDDocument()));

    ArrayList<String> values = new ArrayList<>();
    values.add("foo");
    values.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPushButton.setExportValues(values));
  }

  /**
   * Test {@link PDPushButton#getValueAsString()}.
   * <p>
   * Method under test: {@link PDPushButton#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDPushButton.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDPushButton(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Test {@link PDPushButton#getOnValues()}.
   * <p>
   * Method under test: {@link PDPushButton#getOnValues()}
   */
  @Test
  @DisplayName("Test getOnValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set PDPushButton.getOnValues()"})
  void testGetOnValues() {
    // Arrange, Act and Assert
    assertTrue((new PDPushButton(new PDAcroForm(new PDDocument()))).getOnValues().isEmpty());
  }
}
