package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionResetFormDiffblueTest {
  /**
   * Test {@link PDActionResetForm#PDActionResetForm(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionResetForm#PDActionResetForm(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionResetForm(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.<init>(COSDictionary)"})
  void testNewPDActionResetForm() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionResetForm(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionResetForm#PDActionResetForm()}.
   * <p>
   * Method under test: {@link PDActionResetForm#PDActionResetForm()}
   */
  @Test
  @DisplayName("Test new PDActionResetForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.<init>()"})
  void testNewPDActionResetForm2() {
    // Arrange and Act
    PDActionResetForm actualPdActionResetForm = new PDActionResetForm();

    // Assert
    assertNull(actualPdActionResetForm.getNext());
    assertNull(actualPdActionResetForm.getFields());
    COSDictionary cOSObject = actualPdActionResetForm.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdActionResetForm.getFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualPdActionResetForm.getType());
    assertEquals(PDActionResetForm.SUB_TYPE, actualPdActionResetForm.getSubType());
  }

  /**
   * Test {@link PDActionResetForm#getFields()}.
   * <ul>
   *   <li>Given {@link PDActionResetForm#PDActionResetForm()} Fields is {@link COSArray#COSArray()}.</li>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given PDActionResetForm() Fields is COSArray(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDActionResetForm.getFields()"})
  void testGetFields_givenPDActionResetFormFieldsIsCOSArray_thenReturnToListEmpty() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();
    COSArray array = new COSArray();
    pdActionResetForm.setFields(array);

    // Act
    COSArray actualFields = pdActionResetForm.getFields();

    // Assert
    assertTrue(actualFields.toList().isEmpty());
    assertSame(array, actualFields);
  }

  /**
   * Test {@link PDActionResetForm#getFields()}.
   * <ul>
   *   <li>Given {@link PDActionResetForm#PDActionResetForm()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#getFields()}
   */
  @Test
  @DisplayName("Test getFields(); given PDActionResetForm(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDActionResetForm.getFields()"})
  void testGetFields_givenPDActionResetForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionResetForm()).getFields());
  }

  /**
   * Test {@link PDActionResetForm#setFields(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.setFields(COSArray)"})
  void testSetFields_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();

    COSArray array = new COSArray();
    array.setKey(new COSObjectKey(1L, 1));
    array.setDirect(false);

    // Act
    pdActionResetForm.setFields(array);

    // Assert
    COSDictionary cOSObject = pdActionResetForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(array, pdActionResetForm.getFields());
  }

  /**
   * Test {@link PDActionResetForm#setFields(COSArray)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link COSArray#COSArray()} Direct is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); given 'false'; when COSArray() Direct is 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.setFields(COSArray)"})
  void testSetFields_givenFalse_whenCOSArrayDirectIsFalse() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();

    COSArray array = new COSArray();
    array.setDirect(false);

    // Act
    pdActionResetForm.setFields(array);

    // Assert
    COSDictionary cOSObject = pdActionResetForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(array, pdActionResetForm.getFields());
  }

  /**
   * Test {@link PDActionResetForm#setFields(COSArray)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDActionResetForm#PDActionResetForm()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); when COSArray(); then PDActionResetForm() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.setFields(COSArray)"})
  void testSetFields_whenCOSArray_thenPDActionResetFormCOSObjectValuesSizeIsThree() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();
    COSArray array = new COSArray();

    // Act
    pdActionResetForm.setFields(array);

    // Assert
    COSDictionary cOSObject = pdActionResetForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(array, pdActionResetForm.getFields());
  }

  /**
   * Test {@link PDActionResetForm#setFields(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionResetForm#PDActionResetForm()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#setFields(COSArray)}
   */
  @Test
  @DisplayName("Test setFields(COSArray); when 'null'; then PDActionResetForm() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.setFields(COSArray)"})
  void testSetFields_whenNull_thenPDActionResetFormCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();

    // Act
    pdActionResetForm.setFields(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionResetForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionResetForm#getFlags()}.
   * <ul>
   *   <li>Given {@link PDActionResetForm#PDActionResetForm()} Flags is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#getFlags()}
   */
  @Test
  @DisplayName("Test getFlags(); given PDActionResetForm() Flags is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDActionResetForm.getFlags()"})
  void testGetFlags_givenPDActionResetFormFlagsIsOne_thenReturnOne() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();
    pdActionResetForm.setFlags(1);

    // Act and Assert
    assertEquals(1, pdActionResetForm.getFlags());
  }

  /**
   * Test {@link PDActionResetForm#getFlags()}.
   * <ul>
   *   <li>Given {@link PDActionResetForm#PDActionResetForm()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#getFlags()}
   */
  @Test
  @DisplayName("Test getFlags(); given PDActionResetForm(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDActionResetForm.getFlags()"})
  void testGetFlags_givenPDActionResetForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDActionResetForm()).getFlags());
  }

  /**
   * Test {@link PDActionResetForm#setFlags(int)}.
   * <ul>
   *   <li>Given {@link PDActionResetForm#PDActionResetForm()}.</li>
   *   <li>When one.</li>
   *   <li>Then {@link PDActionResetForm#PDActionResetForm()} Flags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#setFlags(int)}
   */
  @Test
  @DisplayName("Test setFlags(int); given PDActionResetForm(); when one; then PDActionResetForm() Flags is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.setFlags(int)"})
  void testSetFlags_givenPDActionResetForm_whenOne_thenPDActionResetFormFlagsIsOne() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();

    // Act
    pdActionResetForm.setFlags(1);

    // Assert
    assertEquals(1, pdActionResetForm.getFlags());
    COSDictionary cOSObject = pdActionResetForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionResetForm#setFlags(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDActionResetForm#PDActionResetForm()} Flags is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionResetForm#setFlags(int)}
   */
  @Test
  @DisplayName("Test setFlags(int); when MIN_VALUE; then PDActionResetForm() Flags is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionResetForm.setFlags(int)"})
  void testSetFlags_whenMin_value_thenPDActionResetFormFlagsIsMin_value() {
    // Arrange
    PDActionResetForm pdActionResetForm = new PDActionResetForm();

    // Act
    pdActionResetForm.setFlags(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdActionResetForm.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdActionResetForm.getFlags());
  }
}
