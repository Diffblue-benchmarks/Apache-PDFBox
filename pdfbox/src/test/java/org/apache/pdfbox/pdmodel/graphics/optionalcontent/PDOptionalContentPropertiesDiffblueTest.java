package org.apache.pdfbox.pdmodel.graphics.optionalcontent;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties.BaseState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOptionalContentPropertiesDiffblueTest {
  /**
   * Test BaseState {@link BaseState#getName()}.
   *
   * <p>Method under test: {@link BaseState#getName()}
   */
  @Test
  @DisplayName("Test BaseState getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName BaseState.getName()"})
  void testBaseStateGetName() {
    // Arrange, Act and Assert
    assertSame(COSName.ON, BaseState.valueOf("ON").getName());
  }

  /**
   * Test BaseState {@link BaseState#valueOf(COSName)} with {@code state}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseState#valueOf(COSName)}
   */
  @Test
  @DisplayName(
      "Test BaseState valueOf(COSName) with 'state'; when A; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseState BaseState.valueOf(COSName)"})
  void testBaseStateValueOfWithState_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> BaseState.valueOf(COSName.A));
  }

  /**
   * Test BaseState {@link BaseState#valueOf(COSName)} with {@code state}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code ON}.
   * </ul>
   *
   * <p>Method under test: {@link BaseState#valueOf(COSName)}
   */
  @Test
  @DisplayName("Test BaseState valueOf(COSName) with 'state'; when 'null'; then return 'ON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseState BaseState.valueOf(COSName)"})
  void testBaseStateValueOfWithState_whenNull_thenReturnOn() {
    // Arrange, Act and Assert
    assertEquals(BaseState.ON, BaseState.valueOf((COSName) null));
  }

  /**
   * Test {@link PDOptionalContentProperties#PDOptionalContentProperties(COSDictionary)}.
   *
   * <p>Method under test: {@link
   * PDOptionalContentProperties#PDOptionalContentProperties(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOptionalContentProperties(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.<init>(COSDictionary)"})
  void testNewPDOptionalContentProperties() {
    // Arrange
    COSDictionary props = new COSDictionary();

    // Act and Assert
    assertSame(props, new PDOptionalContentProperties(props).getCOSObject());
  }

  /**
   * Test {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#PDOptionalContentProperties()}
   */
  @Test
  @DisplayName("Test new PDOptionalContentProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.<init>()"})
  void testNewPDOptionalContentProperties2() {
    // Arrange and Act
    PDOptionalContentProperties actualPdOptionalContentProperties =
        new PDOptionalContentProperties();

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups =
        actualPdOptionalContentProperties.getOptionalContentGroups();
    assertTrue(optionalContentGroups instanceof List);
    COSDictionary cOSObject = actualPdOptionalContentProperties.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdOptionalContentProperties.getGroupNames().length);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(BaseState.ON, actualPdOptionalContentProperties.getBaseState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(optionalContentGroups.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentProperties#getCOSObject()}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDOptionalContentProperties.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDOptionalContentProperties().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroup(String)}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  @DisplayName("Test getGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOptionalContentGroup PDOptionalContentProperties.getGroup(String)"})
  void testGetGroup() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("OCG"));

    // Act and Assert
    assertNull(pdOptionalContentProperties.getGroup("Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroup(String)}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  @DisplayName("Test getGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOptionalContentGroup PDOptionalContentProperties.getGroup(String)"})
  void testGetGroup2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertNull(pdOptionalContentProperties.getGroup("Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties(COSDictionary)} with
   *       props is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  @DisplayName(
      "Test getGroup(String); given PDOptionalContentProperties(COSDictionary) with props is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOptionalContentGroup PDOptionalContentProperties.getGroup(String)"})
  void testGetGroup_givenPDOptionalContentPropertiesWithPropsIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDOptionalContentProperties(new COSDictionary()).getGroup("Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  @DisplayName("Test getGroup(String); given PDOptionalContentProperties(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOptionalContentGroup PDOptionalContentProperties.getGroup(String)"})
  void testGetGroup_givenPDOptionalContentProperties_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOptionalContentProperties().getGroup("Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroup(String)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  @DisplayName("Test getGroup(String); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOptionalContentGroup PDOptionalContentProperties.getGroup(String)"})
  void testGetGroup_thenReturnName() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act
    PDOptionalContentGroup actualGroup = pdOptionalContentProperties.getGroup("Name");

    // Assert
    assertEquals("Name", actualGroup.getName());
    COSDictionary cOSObject = actualGroup.getCOSObject();
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
   * Test {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName("Test addGroup(PDOptionalContentGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.addGroup(PDOptionalContentGroup)"})
  void testAddGroup() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties =
        new PDOptionalContentProperties(new COSDictionary());

    // Act
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups =
        pdOptionalContentProperties.getOptionalContentGroups();
    assertEquals(1, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(0).getName());
    assertArrayEquals(new String[] {"Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Test {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}.
   *
   * <ul>
   *   <li>Then {@link PDOptionalContentProperties#PDOptionalContentProperties()}
   *       OptionalContentGroups size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName(
      "Test addGroup(PDOptionalContentGroup); then PDOptionalContentProperties() OptionalContentGroups size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.addGroup(PDOptionalContentGroup)"})
  void testAddGroup_thenPDOptionalContentPropertiesOptionalContentGroupsSizeIsOne() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups =
        pdOptionalContentProperties.getOptionalContentGroups();
    assertEquals(1, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(0).getName());
    assertArrayEquals(new String[] {"Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Test {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}.
   *
   * <ul>
   *   <li>Then {@link PDOptionalContentProperties#PDOptionalContentProperties()}
   *       OptionalContentGroups size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName(
      "Test addGroup(PDOptionalContentGroup); then PDOptionalContentProperties() OptionalContentGroups size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.addGroup(PDOptionalContentGroup)"})
  void testAddGroup_thenPDOptionalContentPropertiesOptionalContentGroupsSizeIsTwo() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups =
        pdOptionalContentProperties.getOptionalContentGroups();
    assertEquals(2, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(0).getName());
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(1).getName());
    assertArrayEquals(new String[] {"Name", "Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Test {@link PDOptionalContentProperties#getOptionalContentGroups()}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getOptionalContentGroups()}
   */
  @Test
  @DisplayName("Test getOptionalContentGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PDOptionalContentProperties.getOptionalContentGroups()"})
  void testGetOptionalContentGroups() {
    // Arrange and Act
    Collection<PDOptionalContentGroup> actualOptionalContentGroups =
        new PDOptionalContentProperties(new COSDictionary()).getOptionalContentGroups();

    // Assert
    assertTrue(actualOptionalContentGroups instanceof List);
    assertTrue(actualOptionalContentGroups.isEmpty());
  }

  /**
   * Test {@link PDOptionalContentProperties#getOptionalContentGroups()}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getOptionalContentGroups()}
   */
  @Test
  @DisplayName(
      "Test getOptionalContentGroups(); given PDOptionalContentProperties(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PDOptionalContentProperties.getOptionalContentGroups()"})
  void testGetOptionalContentGroups_givenPDOptionalContentProperties_thenReturnEmpty() {
    // Arrange and Act
    Collection<PDOptionalContentGroup> actualOptionalContentGroups =
        new PDOptionalContentProperties().getOptionalContentGroups();

    // Assert
    assertTrue(actualOptionalContentGroups instanceof List);
    assertTrue(actualOptionalContentGroups.isEmpty());
  }

  /**
   * Test {@link PDOptionalContentProperties#getOptionalContentGroups()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getOptionalContentGroups()}
   */
  @Test
  @DisplayName("Test getOptionalContentGroups(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PDOptionalContentProperties.getOptionalContentGroups()"})
  void testGetOptionalContentGroups_thenReturnSizeIsOne() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act
    Collection<PDOptionalContentGroup> actualOptionalContentGroups =
        pdOptionalContentProperties.getOptionalContentGroups();

    // Assert
    assertTrue(actualOptionalContentGroups instanceof List);
    assertEquals(1, actualOptionalContentGroups.size());
    PDOptionalContentGroup getResult =
        ((List<PDOptionalContentGroup>) actualOptionalContentGroups).get(0);
    assertEquals("Name", getResult.getName());
    COSDictionary cOSObject = getResult.getCOSObject();
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
   * Test {@link PDOptionalContentProperties#getBaseState()}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties(COSDictionary)} with
   *       props is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getBaseState()}
   */
  @Test
  @DisplayName(
      "Test getBaseState(); given PDOptionalContentProperties(COSDictionary) with props is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseState PDOptionalContentProperties.getBaseState()"})
  void testGetBaseState_givenPDOptionalContentPropertiesWithPropsIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(BaseState.ON, new PDOptionalContentProperties(new COSDictionary()).getBaseState());
  }

  /**
   * Test {@link PDOptionalContentProperties#getBaseState()}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>Then return {@code ON}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getBaseState()}
   */
  @Test
  @DisplayName("Test getBaseState(); given PDOptionalContentProperties(); then return 'ON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseState PDOptionalContentProperties.getBaseState()"})
  void testGetBaseState_givenPDOptionalContentProperties_thenReturnOn() {
    // Arrange, Act and Assert
    assertEquals(BaseState.ON, new PDOptionalContentProperties().getBaseState());
  }

  /**
   * Test {@link PDOptionalContentProperties#setBaseState(BaseState)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setBaseState(BaseState)}
   */
  @Test
  @DisplayName(
      "Test setBaseState(BaseState); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.setBaseState(BaseState)"})
  void testSetBaseState_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    COSDictionary props = mock(COSDictionary.class);
    when(props.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    new PDOptionalContentProperties(props).setBaseState(BaseState.ON);

    // Assert
    verify(props).getCOSDictionary(isA(COSName.class));
  }

  /**
   * Test {@link PDOptionalContentProperties#setBaseState(BaseState)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setBaseState(BaseState)}
   */
  @Test
  @DisplayName(
      "Test setBaseState(BaseState); given COSDictionary getCOSDictionary(COSName) return COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.setBaseState(BaseState)"})
  void testSetBaseState_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary2() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    COSDictionary props = mock(COSDictionary.class);
    when(props.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    new PDOptionalContentProperties(props).setBaseState(BaseState.ON);

    // Assert
    verify(props).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDOptionalContentProperties#setBaseState(BaseState)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setBaseState(BaseState)}
   */
  @Test
  @DisplayName(
      "Test setBaseState(BaseState); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOptionalContentProperties.setBaseState(BaseState)"})
  void testSetBaseState_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() {
    // Arrange
    COSDictionary props = mock(COSDictionary.class);
    when(props.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(props).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    new PDOptionalContentProperties(props).setBaseState(BaseState.ON);

    // Assert
    verify(props).getCOSDictionary(isA(COSName.class));
    verify(props).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroupNames()}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties(COSDictionary)} with
   *       props is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  @DisplayName(
      "Test getGroupNames(); given PDOptionalContentProperties(COSDictionary) with props is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDOptionalContentProperties.getGroupNames()"})
  void testGetGroupNames_givenPDOptionalContentPropertiesWithPropsIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, new PDOptionalContentProperties(new COSDictionary()).getGroupNames().length);
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroupNames()}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  @DisplayName(
      "Test getGroupNames(); given PDOptionalContentProperties(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDOptionalContentProperties.getGroupNames()"})
  void testGetGroupNames_givenPDOptionalContentProperties_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDOptionalContentProperties().getGroupNames().length);
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroupNames()}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  @DisplayName("Test getGroupNames(); then return array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDOptionalContentProperties.getGroupNames()"})
  void testGetGroupNames_thenReturnArrayOfStringWithEmptyString() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertArrayEquals(new String[] {""}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroupNames()}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  @DisplayName("Test getGroupNames(); then return array of String with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDOptionalContentProperties.getGroupNames()"})
  void testGetGroupNames_thenReturnArrayOfStringWithName() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertArrayEquals(new String[] {"Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Test {@link PDOptionalContentProperties#getGroupNames()}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  @DisplayName("Test getGroupNames(); then return array of String with 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PDOptionalContentProperties.getGroupNames()"})
  void testGetGroupNames_thenReturnArrayOfStringWithNull() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup((String) null));

    // Act and Assert
    assertArrayEquals(new String[] {null}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Test {@link PDOptionalContentProperties#hasGroup(String)}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  @DisplayName("Test hasGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.hasGroup(String)"})
  void testHasGroup() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.hasGroup("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#hasGroup(String)}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  @DisplayName("Test hasGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.hasGroup(String)"})
  void testHasGroup2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.hasGroup("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#hasGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties(COSDictionary)} with
   *       props is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  @DisplayName(
      "Test hasGroup(String); given PDOptionalContentProperties(COSDictionary) with props is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.hasGroup(String)"})
  void testHasGroup_givenPDOptionalContentPropertiesWithPropsIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDOptionalContentProperties(new COSDictionary()).hasGroup("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#hasGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  @DisplayName("Test hasGroup(String); given PDOptionalContentProperties(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.hasGroup(String)"})
  void testHasGroup_givenPDOptionalContentProperties_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDOptionalContentProperties().hasGroup("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#hasGroup(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  @DisplayName("Test hasGroup(String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.hasGroup(String)"})
  void testHasGroup_thenReturnTrue() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));

    // Act and Assert
    assertTrue(pdOptionalContentProperties.hasGroup("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#hasGroup(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  @DisplayName("Test hasGroup(String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.hasGroup(String)"})
  void testHasGroup_thenReturnTrue2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup((String) null));

    // Act and Assert
    assertTrue(pdOptionalContentProperties.hasGroup("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)} with {@code
   * group}.
   *
   * <p>Method under test: {@link
   * PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(PDOptionalContentGroup) with 'group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(PDOptionalContentGroup)"})
  void testIsGroupEnabledWithGroup() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties =
        new PDOptionalContentProperties(new COSDictionary());

    // Act
    boolean actualIsGroupEnabledResult =
        pdOptionalContentProperties.isGroupEnabled(new PDOptionalContentGroup("Name"));

    // Assert
    assertTrue(actualIsGroupEnabledResult);
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(String)} with {@code groupName}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(String) with 'groupName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(String)"})
  void testIsGroupEnabledWithGroupName() {
    // Arrange, Act and Assert
    assertFalse(new PDOptionalContentProperties(new COSDictionary()).isGroupEnabled("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(String)} with {@code groupName}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(String) with 'groupName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(String)"})
  void testIsGroupEnabledWithGroupName2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(String)} with {@code groupName}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(String) with 'groupName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(String)"})
  void testIsGroupEnabledWithGroupName3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup((String) null));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(String)} with {@code groupName}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(String) with 'groupName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(String)"})
  void testIsGroupEnabledWithGroupName4() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(String)} with {@code groupName}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  @DisplayName(
      "Test isGroupEnabled(String) with 'groupName'; given PDOptionalContentProperties(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(String)"})
  void testIsGroupEnabledWithGroupName_givenPDOptionalContentProperties_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDOptionalContentProperties().isGroupEnabled("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(String)} with {@code groupName}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(String) with 'groupName'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(String)"})
  void testIsGroupEnabledWithGroupName_thenReturnTrue() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertTrue(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)} with {@code
   * group}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName(
      "Test isGroupEnabled(PDOptionalContentGroup) with 'group'; given PDOptionalContentProperties(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(PDOptionalContentGroup)"})
  void testIsGroupEnabledWithGroup_givenPDOptionalContentProperties_thenReturnTrue() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act
    boolean actualIsGroupEnabledResult =
        pdOptionalContentProperties.isGroupEnabled(new PDOptionalContentGroup("Name"));

    // Assert
    assertTrue(actualIsGroupEnabledResult);
  }

  /**
   * Test {@link PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)} with {@code
   * group}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName(
      "Test isGroupEnabled(PDOptionalContentGroup) with 'group'; given PDOptionalContentProperties(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.isGroupEnabled(PDOptionalContentGroup)"})
  void testIsGroupEnabledWithGroup_givenPDOptionalContentProperties_whenNull() {
    // Arrange, Act and Assert
    assertTrue(new PDOptionalContentProperties().isGroupEnabled((PDOptionalContentGroup) null));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)} with
   * {@code group}, {@code enable}.
   *
   * <p>Method under test: {@link
   * PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(PDOptionalContentGroup, boolean) with 'group', 'enable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PDOptionalContentProperties.setGroupEnabled(PDOptionalContentGroup, boolean)"
  })
  void testSetGroupEnabledWithGroupEnable() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties =
        new PDOptionalContentProperties(new COSDictionary());

    // Act and Assert
    assertFalse(
        pdOptionalContentProperties.setGroupEnabled(new PDOptionalContentGroup("Name"), true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)} with
   * {@code group}, {@code enable}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)}
   */
  @Test
  @DisplayName(
      "Test setGroupEnabled(PDOptionalContentGroup, boolean) with 'group', 'enable'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PDOptionalContentProperties.setGroupEnabled(PDOptionalContentGroup, boolean)"
  })
  void testSetGroupEnabledWithGroupEnable_thenReturnFalse() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act and Assert
    assertFalse(
        pdOptionalContentProperties.setGroupEnabled(new PDOptionalContentGroup("Name"), true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)} with
   * {@code group}, {@code enable}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)}
   */
  @Test
  @DisplayName(
      "Test setGroupEnabled(PDOptionalContentGroup, boolean) with 'group', 'enable'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PDOptionalContentProperties.setGroupEnabled(PDOptionalContentGroup, boolean)"
  })
  void testSetGroupEnabledWithGroupEnable_whenFalse_thenReturnFalse() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act and Assert
    assertFalse(
        pdOptionalContentProperties.setGroupEnabled(new PDOptionalContentGroup("Name"), false));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(String, boolean) with 'groupName', 'enable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable() {
    // Arrange, Act and Assert
    assertFalse(
        new PDOptionalContentProperties(new COSDictionary()).setGroupEnabled("Group Name", true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(String, boolean) with 'groupName', 'enable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(String, boolean) with 'groupName', 'enable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(String, boolean) with 'groupName', 'enable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable4() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(String, boolean) with 'groupName', 'enable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable5() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup((String) null));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(String, boolean) with 'groupName', 'enable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable6() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <ul>
   *   <li>Given {@link PDOptionalContentProperties#PDOptionalContentProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setGroupEnabled(String, boolean) with 'groupName', 'enable'; given PDOptionalContentProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable_givenPDOptionalContentProperties() {
    // Arrange, Act and Assert
    assertFalse(new PDOptionalContentProperties().setGroupEnabled("Group Name", true));
  }

  /**
   * Test {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)} with {@code
   * groupName}, {@code enable}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  @DisplayName("Test setGroupEnabled(String, boolean) with 'groupName', 'enable'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOptionalContentProperties.setGroupEnabled(String, boolean)"})
  void testSetGroupEnabledWithGroupNameEnable_whenFalse() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", false));
  }
}
