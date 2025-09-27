package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPrintFieldAttributeObjectDiffblueTest {
  /**
   * Test {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject(COSDictionary)}.
   *
   * <p>Method under test: {@link
   * PDPrintFieldAttributeObject#PDPrintFieldAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPrintFieldAttributeObject(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPrintFieldAttributeObject.<init>(COSDictionary)"})
  void testNewPDPrintFieldAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDPrintFieldAttributeObject(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()}.
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDPrintFieldAttributeObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPrintFieldAttributeObject.<init>()"})
  void testNewPDPrintFieldAttributeObject2() {
    // Arrange and Act
    PDPrintFieldAttributeObject actualPdPrintFieldAttributeObject =
        new PDPrintFieldAttributeObject();

    // Assert
    assertNull(actualPdPrintFieldAttributeObject.getAlternateName());
    assertNull(actualPdPrintFieldAttributeObject.getRole());
    COSDictionary cOSObject = actualPdPrintFieldAttributeObject.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(actualPdPrintFieldAttributeObject.isEmpty());
    assertEquals(
        PDPrintFieldAttributeObject.CHECKED_STATE_OFF,
        actualPdPrintFieldAttributeObject.getCheckedState());
    assertEquals(
        PDPrintFieldAttributeObject.OWNER_PRINT_FIELD,
        actualPdPrintFieldAttributeObject.getOwner());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#getRole()}.
   *
   * <ul>
   *   <li>Given {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#getRole()}
   */
  @Test
  @DisplayName("Test getRole(); given PDPrintFieldAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPrintFieldAttributeObject.getRole()"})
  void testGetRole_givenPDPrintFieldAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPrintFieldAttributeObject().getRole());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#setRole(String)}.
   *
   * <ul>
   *   <li>Then {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()} Role is {@code
   *       Role}.
   * </ul>
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#setRole(String)}
   */
  @Test
  @DisplayName("Test setRole(String); then PDPrintFieldAttributeObject() Role is 'Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPrintFieldAttributeObject.setRole(String)"})
  void testSetRole_thenPDPrintFieldAttributeObjectRoleIsRole() {
    // Arrange
    PDPrintFieldAttributeObject pdPrintFieldAttributeObject = new PDPrintFieldAttributeObject();

    // Act
    pdPrintFieldAttributeObject.setRole("Role");

    // Assert
    assertEquals("Role", pdPrintFieldAttributeObject.getRole());
    COSDictionary cOSObject = pdPrintFieldAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdPrintFieldAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#getCheckedState()}.
   *
   * <ul>
   *   <li>Given {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()}.
   *   <li>Then return {@link PDPrintFieldAttributeObject#CHECKED_STATE_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#getCheckedState()}
   */
  @Test
  @DisplayName(
      "Test getCheckedState(); given PDPrintFieldAttributeObject(); then return CHECKED_STATE_OFF")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPrintFieldAttributeObject.getCheckedState()"})
  void testGetCheckedState_givenPDPrintFieldAttributeObject_thenReturnChecked_state_off() {
    // Arrange, Act and Assert
    assertEquals(
        PDPrintFieldAttributeObject.CHECKED_STATE_OFF,
        new PDPrintFieldAttributeObject().getCheckedState());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#setCheckedState(String)}.
   *
   * <ul>
   *   <li>Then {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()} CheckedState is
   *       {@code Checked State}.
   * </ul>
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#setCheckedState(String)}
   */
  @Test
  @DisplayName(
      "Test setCheckedState(String); then PDPrintFieldAttributeObject() CheckedState is 'Checked State'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPrintFieldAttributeObject.setCheckedState(String)"})
  void testSetCheckedState_thenPDPrintFieldAttributeObjectCheckedStateIsCheckedState() {
    // Arrange
    PDPrintFieldAttributeObject pdPrintFieldAttributeObject = new PDPrintFieldAttributeObject();

    // Act
    pdPrintFieldAttributeObject.setCheckedState("Checked State");

    // Assert
    assertEquals("Checked State", pdPrintFieldAttributeObject.getCheckedState());
    COSDictionary cOSObject = pdPrintFieldAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdPrintFieldAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#getAlternateName()}.
   *
   * <ul>
   *   <li>Given {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#getAlternateName()}
   */
  @Test
  @DisplayName("Test getAlternateName(); given PDPrintFieldAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPrintFieldAttributeObject.getAlternateName()"})
  void testGetAlternateName_givenPDPrintFieldAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDPrintFieldAttributeObject().getAlternateName());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#setAlternateName(String)}.
   *
   * <ul>
   *   <li>Then {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()} AlternateName is
   *       {@code Alternate Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#setAlternateName(String)}
   */
  @Test
  @DisplayName(
      "Test setAlternateName(String); then PDPrintFieldAttributeObject() AlternateName is 'Alternate Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPrintFieldAttributeObject.setAlternateName(String)"})
  void testSetAlternateName_thenPDPrintFieldAttributeObjectAlternateNameIsAlternateName() {
    // Arrange
    PDPrintFieldAttributeObject pdPrintFieldAttributeObject = new PDPrintFieldAttributeObject();

    // Act
    pdPrintFieldAttributeObject.setAlternateName("Alternate Name");

    // Assert
    assertEquals("Alternate Name", pdPrintFieldAttributeObject.getAlternateName());
    COSDictionary cOSObject = pdPrintFieldAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdPrintFieldAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDPrintFieldAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDPrintFieldAttributeObject#PDPrintFieldAttributeObject()}.
   *   <li>Then return {@code O=PrintField}.
   * </ul>
   *
   * <p>Method under test: {@link PDPrintFieldAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDPrintFieldAttributeObject(); then return 'O=PrintField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDPrintFieldAttributeObject.toString()"})
  void testToString_givenPDPrintFieldAttributeObject_thenReturnOPrintField() {
    // Arrange, Act and Assert
    assertEquals("O=PrintField", new PDPrintFieldAttributeObject().toString());
  }
}
