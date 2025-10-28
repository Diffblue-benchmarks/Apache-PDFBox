package org.apache.pdfbox.pdmodel.graphics.optionalcontent;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOptionalContentPropertiesDiffblueTest {
  /**
   * Method under test: {@link PDOptionalContentProperties.BaseState#getName()}
   */
  @Test
  void testBaseStateGetName() {
    // Arrange and Act
    COSName actualName = PDOptionalContentProperties.BaseState.valueOf("ON").getName();

    // Assert
    assertSame(actualName.ON, actualName);
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties.BaseState#valueOf(COSName)}
   */
  @Test
  void testBaseStateValueOf() {
    // Arrange, Act and Assert
    assertEquals(PDOptionalContentProperties.BaseState.ON,
        PDOptionalContentProperties.BaseState.valueOf((COSName) null));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDOptionalContentProperties()).getCOSObject();

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
   * Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  void testGetGroup() {
    // Arrange, Act and Assert
    assertNull((new PDOptionalContentProperties()).getGroup("Name"));
    assertNull((new PDOptionalContentProperties(new COSDictionary())).getGroup("Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  void testGetGroup2() {
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
   * Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  void testGetGroup3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("OCG"));

    // Act and Assert
    assertNull(pdOptionalContentProperties.getGroup("Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#getGroup(String)}
   */
  @Test
  void testGetGroup4() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertNull(pdOptionalContentProperties.getGroup("Name"));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}
   */
  @Test
  void testAddGroup() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups = pdOptionalContentProperties.getOptionalContentGroups();
    assertEquals(1, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(0).getName());
    assertArrayEquals(new String[]{"Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}
   */
  @Test
  void testAddGroup2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties(new COSDictionary());

    // Act
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups = pdOptionalContentProperties.getOptionalContentGroups();
    assertEquals(1, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(0).getName());
    assertArrayEquals(new String[]{"Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#addGroup(PDOptionalContentGroup)}
   */
  @Test
  void testAddGroup3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups = pdOptionalContentProperties.getOptionalContentGroups();
    assertEquals(2, optionalContentGroups.size());
    assertTrue(optionalContentGroups instanceof List);
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(0).getName());
    assertEquals("Name", ((List<PDOptionalContentGroup>) optionalContentGroups).get(1).getName());
    assertArrayEquals(new String[]{"Name", "Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#getOptionalContentGroups()}
   */
  @Test
  void testGetOptionalContentGroups() {
    // Arrange and Act
    Collection<PDOptionalContentGroup> actualOptionalContentGroups = (new PDOptionalContentProperties())
        .getOptionalContentGroups();

    // Assert
    assertTrue(actualOptionalContentGroups instanceof List);
    assertTrue(actualOptionalContentGroups.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#getOptionalContentGroups()}
   */
  @Test
  void testGetOptionalContentGroups2() {
    // Arrange and Act
    Collection<PDOptionalContentGroup> actualOptionalContentGroups = (new PDOptionalContentProperties(
        new COSDictionary())).getOptionalContentGroups();

    // Assert
    assertTrue(actualOptionalContentGroups instanceof List);
    assertTrue(actualOptionalContentGroups.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#getOptionalContentGroups()}
   */
  @Test
  void testGetOptionalContentGroups3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act
    Collection<PDOptionalContentGroup> actualOptionalContentGroups = pdOptionalContentProperties
        .getOptionalContentGroups();

    // Assert
    assertTrue(actualOptionalContentGroups instanceof List);
    assertEquals(1, actualOptionalContentGroups.size());
    PDOptionalContentGroup getResult = ((List<PDOptionalContentGroup>) actualOptionalContentGroups).get(0);
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
   * Method under test: {@link PDOptionalContentProperties#getBaseState()}
   */
  @Test
  void testGetBaseState() {
    // Arrange, Act and Assert
    assertEquals(PDOptionalContentProperties.BaseState.ON, (new PDOptionalContentProperties()).getBaseState());
    assertEquals(PDOptionalContentProperties.BaseState.ON,
        (new PDOptionalContentProperties(new COSDictionary())).getBaseState());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setBaseState(PDOptionalContentProperties.BaseState)}
   */
  @Test
  void testSetBaseState() {
    // Arrange
    COSDictionary props = mock(COSDictionary.class);
    when(props.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDOptionalContentProperties(props)).setBaseState(PDOptionalContentProperties.BaseState.ON);

    // Assert
    verify(props).getCOSDictionary(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setBaseState(PDOptionalContentProperties.BaseState)}
   */
  @Test
  void testSetBaseState2() {
    // Arrange
    COSDictionary props = mock(COSDictionary.class);
    when(props.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(props).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    (new PDOptionalContentProperties(props)).setBaseState(PDOptionalContentProperties.BaseState.ON);

    // Assert
    verify(props).getCOSDictionary(isA(COSName.class));
    verify(props).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setBaseState(PDOptionalContentProperties.BaseState)}
   */
  @Test
  void testSetBaseState3() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSDictionary props = mock(COSDictionary.class);
    when(props.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(props).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    (new PDOptionalContentProperties(props)).setBaseState(PDOptionalContentProperties.BaseState.ON);

    // Assert that nothing has changed
    verify(props).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  void testGetGroupNames() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDOptionalContentProperties()).getGroupNames().length);
    assertEquals(0, (new PDOptionalContentProperties(new COSDictionary())).getGroupNames().length);
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  void testGetGroupNames2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertArrayEquals(new String[]{"Name"}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  void testGetGroupNames3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup((String) null));

    // Act and Assert
    assertArrayEquals(new String[]{null}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#getGroupNames()}
   */
  @Test
  void testGetGroupNames4() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertArrayEquals(new String[]{""}, pdOptionalContentProperties.getGroupNames());
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  void testHasGroup() {
    // Arrange, Act and Assert
    assertFalse((new PDOptionalContentProperties()).hasGroup("Group Name"));
    assertFalse((new PDOptionalContentProperties(new COSDictionary())).hasGroup("Group Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  void testHasGroup2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.hasGroup("Group Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  void testHasGroup3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));

    // Act and Assert
    assertTrue(pdOptionalContentProperties.hasGroup("Group Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#hasGroup(String)}
   */
  @Test
  void testHasGroup4() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.hasGroup("Group Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  void testIsGroupEnabled() {
    // Arrange, Act and Assert
    assertFalse((new PDOptionalContentProperties()).isGroupEnabled("Group Name"));
    assertFalse((new PDOptionalContentProperties(new COSDictionary())).isGroupEnabled("Group Name"));
    assertTrue((new PDOptionalContentProperties()).isGroupEnabled((PDOptionalContentGroup) null));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  void testIsGroupEnabled2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  void testIsGroupEnabled3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertTrue(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  void testIsGroupEnabled4() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup((String) null));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Method under test: {@link PDOptionalContentProperties#isGroupEnabled(String)}
   */
  @Test
  void testIsGroupEnabled5() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.isGroupEnabled("Group Name"));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)}
   */
  @Test
  void testIsGroupEnabled6() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act and Assert
    assertTrue(pdOptionalContentProperties.isGroupEnabled(new PDOptionalContentGroup("Name")));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#isGroupEnabled(PDOptionalContentGroup)}
   */
  @Test
  void testIsGroupEnabled7() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties(new COSDictionary());

    // Act and Assert
    assertTrue(pdOptionalContentProperties.isGroupEnabled(new PDOptionalContentGroup("Name")));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  void testSetGroupEnabled() {
    // Arrange, Act and Assert
    assertFalse((new PDOptionalContentProperties()).setGroupEnabled("Group Name", true));
    assertFalse((new PDOptionalContentProperties(new COSDictionary())).setGroupEnabled("Group Name", true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  void testSetGroupEnabled2() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  void testSetGroupEnabled3() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  void testSetGroupEnabled4() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup((String) null));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  void testSetGroupEnabled5() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup(""));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  void testSetGroupEnabled6() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(String, boolean)}
   */
  @Test
  void testSetGroupEnabled7() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Group Name"));
    pdOptionalContentProperties.addGroup(new PDOptionalContentGroup("Name"));

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled("Group Name", false));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)}
   */
  @Test
  void testSetGroupEnabled8() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled(new PDOptionalContentGroup("Name"), true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)}
   */
  @Test
  void testSetGroupEnabled9() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties(new COSDictionary());

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled(new PDOptionalContentGroup("Name"), true));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#setGroupEnabled(PDOptionalContentGroup, boolean)}
   */
  @Test
  void testSetGroupEnabled10() {
    // Arrange
    PDOptionalContentProperties pdOptionalContentProperties = new PDOptionalContentProperties();

    // Act and Assert
    assertFalse(pdOptionalContentProperties.setGroupEnabled(new PDOptionalContentGroup("Name"), false));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#PDOptionalContentProperties(COSDictionary)}
   */
  @Test
  void testNewPDOptionalContentProperties() {
    // Arrange
    COSDictionary props = new COSDictionary();

    // Act and Assert
    assertSame(props, (new PDOptionalContentProperties(props)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentProperties#PDOptionalContentProperties()}
   */
  @Test
  void testNewPDOptionalContentProperties2() {
    // Arrange and Act
    PDOptionalContentProperties actualPdOptionalContentProperties = new PDOptionalContentProperties();

    // Assert
    Collection<PDOptionalContentGroup> optionalContentGroups = actualPdOptionalContentProperties
        .getOptionalContentGroups();
    assertTrue(optionalContentGroups instanceof List);
    COSDictionary cOSObject = actualPdOptionalContentProperties.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdOptionalContentProperties.getGroupNames().length);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(PDOptionalContentProperties.BaseState.ON, actualPdOptionalContentProperties.getBaseState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(optionalContentGroups.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
