package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class VersionTypeDiffblueTest {
  /**
   * Method under test: {@link VersionType#getComments()}
   */
  @Test
  void testGetComments() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getComments());
  }

  /**
   * Method under test: {@link VersionType#getComments()}
   */
  @Test
  void testGetComments2() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.COMMENTS, "Value");

    // Act and Assert
    assertEquals("Value", versionType.getComments());
  }

  /**
   * Method under test: {@link VersionType#setComments(String)}
   */
  @Test
  void testSetComments() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    VersionType versionType = new VersionType(metadata);

    // Act
    versionType.setComments("42");

    // Assert
    List<AbstractField> allProperties = versionType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", versionType.getComments());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stVer", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(VersionType.COMMENTS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link VersionType#getEvent()}
   */
  @Test
  void testGetEvent() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getEvent());
  }

  /**
   * Method under test: {@link VersionType#setEvent(ResourceEventType)}
   */
  @Test
  void testSetEvent() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    ResourceEventType value = new ResourceEventType(XMPMetadata.createXMPMetadata());

    // Act
    versionType.setEvent(value);

    // Assert
    List<AbstractField> allProperties = versionType.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(value, allProperties.get(0));
  }

  /**
   * Method under test: {@link VersionType#getModifyDate()}
   */
  @Test
  void testGetModifyDate() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getModifyDate());
  }

  /**
   * Method under test: {@link VersionType#getModifyDate()}
   */
  @Test
  void testGetModifyDate2() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.MODIFY_DATE, "");

    // Act and Assert
    assertNull(versionType.getModifyDate());
  }

  /**
   * Method under test: {@link VersionType#setModifyDate(Calendar)}
   */
  @Test
  void testSetModifyDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    VersionType versionType = new VersionType(metadata);
    GregorianCalendar value = new GregorianCalendar(1, 1, 1);

    // Act
    versionType.setModifyDate(value);

    // Assert
    List<AbstractField> allProperties = versionType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("stVer", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(VersionType.MODIFY_DATE, getResult.getPropertyName());
    assertSame(value, ((DateType) getResult).getRawValue());
    assertSame(value, ((DateType) getResult).getValue());
    assertSame(value, versionType.getModifyDate());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link VersionType#getVersion()}
   */
  @Test
  void testGetVersion() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getVersion());
  }

  /**
   * Method under test: {@link VersionType#getVersion()}
   */
  @Test
  void testGetVersion2() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.VERSION, "Value");

    // Act and Assert
    assertEquals("Value", versionType.getVersion());
  }

  /**
   * Method under test: {@link VersionType#setVersion(String)}
   */
  @Test
  void testSetVersion() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    VersionType versionType = new VersionType(metadata);

    // Act
    versionType.setVersion("42");

    // Assert
    List<AbstractField> allProperties = versionType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", versionType.getVersion());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stVer", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(VersionType.VERSION, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link VersionType#getModifier()}
   */
  @Test
  void testGetModifier() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getModifier());
  }

  /**
   * Method under test: {@link VersionType#getModifier()}
   */
  @Test
  void testGetModifier2() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.MODIFIER, "Value");

    // Act and Assert
    assertEquals("Value", versionType.getModifier());
  }

  /**
   * Method under test: {@link VersionType#setModifier(String)}
   */
  @Test
  void testSetModifier() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    VersionType versionType = new VersionType(metadata);

    // Act
    versionType.setModifier("42");

    // Assert
    List<AbstractField> allProperties = versionType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ProperNameType);
    assertEquals("42", ((ProperNameType) getResult).getStringValue());
    assertEquals("42", versionType.getModifier());
    assertEquals("42", ((ProperNameType) getResult).getRawValue());
    assertEquals("42", ((ProperNameType) getResult).getValue());
    assertEquals("stVer", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(VersionType.MODIFIER, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link VersionType#VersionType(XMPMetadata)}
   */
  @Test
  void testNewVersionType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    VersionType actualVersionType = new VersionType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Version#", actualVersionType.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualVersionType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("stVer", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/Version#"));
    assertEquals("stVer", actualVersionType.getPreferedPrefix());
    assertEquals("stVer", actualVersionType.getPrefix());
    assertNull(actualVersionType.getPropertyName());
    assertNull(actualVersionType.getComments());
    assertNull(actualVersionType.getModifier());
    assertNull(actualVersionType.getVersion());
    assertNull(actualVersionType.getModifyDate());
    assertNull(actualVersionType.getEvent());
    List<AbstractField> allProperties = actualVersionType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualVersionType.getAllAttributes().isEmpty());
    assertSame(allProperties, actualVersionType.getContainer().getAllProperties());
    assertSame(metadata, actualVersionType.getMetadata());
  }
}
