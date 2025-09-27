package org.apache.pdfbox.pdmodel.graphics.optionalcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup.RenderState;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOptionalContentGroupDiffblueTest {
  /**
   * Test {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDOptionalContentGroup(COSDictionary); given A; when COSDictionary getDictionaryObject(COSName) return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.<init>(COSDictionary)"})
  void testNewPDOptionalContentGroup_givenA_whenCOSDictionaryGetDictionaryObjectReturnA() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentGroup(COSDictionary); given FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.<init>(COSDictionary)"})
  void testNewPDOptionalContentGroup_givenFalse() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentGroup(COSDictionary); given ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.<init>(COSDictionary)"})
  void testNewPDOptionalContentGroup_givenOne() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentGroup(COSDictionary); given ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.<init>(COSDictionary)"})
  void testNewPDOptionalContentGroup_givenOne2() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}.
   *
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentGroup(COSDictionary); given parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.<init>(COSDictionary)"})
  void testNewPDOptionalContentGroup_givenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentGroup#PDOptionalContentGroup(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#PDOptionalContentGroup(String)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentGroup(String); when 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.<init>(String)"})
  void testNewPDOptionalContentGroup_whenName_thenReturnName() {
    // Arrange and Act
    PDOptionalContentGroup actualPdOptionalContentGroup = new PDOptionalContentGroup("Name");

    // Assert
    assertEquals("Name", actualPdOptionalContentGroup.getName());
    COSDictionary cOSObject = actualPdOptionalContentGroup.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentGroup#PDOptionalContentGroup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#PDOptionalContentGroup(String)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentGroup(String); when 'null'; then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.<init>(String)"})
  void testNewPDOptionalContentGroup_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    PDOptionalContentGroup actualPdOptionalContentGroup = new PDOptionalContentGroup((String) null);

    // Assert
    assertNull(actualPdOptionalContentGroup.getName());
    COSDictionary cOSObject = actualPdOptionalContentGroup.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentGroup#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with {@code Name}
   *       Name is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDOptionalContentGroup(String) with 'Name' Name is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDOptionalContentGroup.getName()"})
  void testGetName_givenPDOptionalContentGroupWithNameNameIsNull_thenReturnNull() {
    // Arrange
    PDOptionalContentGroup pdOptionalContentGroup = new PDOptionalContentGroup("Name");
    pdOptionalContentGroup.setName(null);

    // Act and Assert
    assertNull(pdOptionalContentGroup.getName());
  }

  /**
   * Test {@link PDOptionalContentGroup#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDOptionalContentGroup(String) with 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDOptionalContentGroup.getName()"})
  void testGetName_givenPDOptionalContentGroupWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", new PDOptionalContentGroup("Name").getName());
  }

  /**
   * Test {@link PDOptionalContentGroup#getName()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDOptionalContentGroup.getName()"})
  void testGetName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new PDOptionalContentGroup("").getName());
  }

  /**
   * Test RenderState {@link RenderState#getName()}.
   *
   * <p>Method under test: {@link RenderState#getName()}
   */
  @Test
  @DisplayName("Test RenderState getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName RenderState.getName()"})
  void testRenderStateGetName() {
    // Arrange, Act and Assert
    assertSame(COSName.ON, RenderState.valueOf("ON").getName());
  }

  /**
   * Test RenderState {@link RenderState#valueOf(COSName)} with {@code state}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RenderState#valueOf(COSName)}
   */
  @Test
  @DisplayName(
      "Test RenderState valueOf(COSName) with 'state'; when A; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderState RenderState.valueOf(COSName)"})
  void testRenderStateValueOfWithState_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RenderState.valueOf(COSName.A));
  }

  /**
   * Test RenderState {@link RenderState#valueOf(COSName)} with {@code state}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RenderState#valueOf(COSName)}
   */
  @Test
  @DisplayName("Test RenderState valueOf(COSName) with 'state'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderState RenderState.valueOf(COSName)"})
  void testRenderStateValueOfWithState_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RenderState.valueOf((COSName) null));
  }

  /**
   * Test {@link PDOptionalContentGroup#setName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with {@code Name} Name
   *       is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when 'Name'; then PDOptionalContentGroup(String) with 'Name' Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.setName(String)"})
  void testSetName_whenName_thenPDOptionalContentGroupWithNameNameIsName() {
    // Arrange
    PDOptionalContentGroup pdOptionalContentGroup = new PDOptionalContentGroup("Name");

    // Act
    pdOptionalContentGroup.setName("Name");

    // Assert that nothing has changed
    assertEquals("Name", pdOptionalContentGroup.getName());
    COSDictionary cOSObject = pdOptionalContentGroup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDOptionalContentGroup#setName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDOptionalContentGroup#PDOptionalContentGroup(String)} with {@code Name} Name
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentGroup#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when 'null'; then PDOptionalContentGroup(String) with 'Name' Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentGroup.setName(String)"})
  void testSetName_whenNull_thenPDOptionalContentGroupWithNameNameIsNull() {
    // Arrange
    PDOptionalContentGroup pdOptionalContentGroup = new PDOptionalContentGroup("Name");

    // Act
    pdOptionalContentGroup.setName(null);

    // Assert
    assertNull(pdOptionalContentGroup.getName());
    COSDictionary cOSObject = pdOptionalContentGroup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOptionalContentGroup#getRenderState(RenderDestination)}.
   *
   * <p>Method under test: {@link PDOptionalContentGroup#getRenderState(RenderDestination)}
   */
  @Test
  @DisplayName("Test getRenderState(RenderDestination)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderState PDOptionalContentGroup.getRenderState(RenderDestination)"})
  void testGetRenderState() {
    // Arrange, Act and Assert
    assertNull(new PDOptionalContentGroup("Name").getRenderState(RenderDestination.EXPORT));
  }
}
