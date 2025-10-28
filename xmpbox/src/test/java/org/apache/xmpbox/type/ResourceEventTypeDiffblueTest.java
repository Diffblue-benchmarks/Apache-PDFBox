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

class ResourceEventTypeDiffblueTest {
  /**
   * Method under test: {@link ResourceEventType#getInstanceID()}
   */
  @Test
  void testGetInstanceID() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getInstanceID());
  }

  /**
   * Method under test: {@link ResourceEventType#getInstanceID()}
   */
  @Test
  void testGetInstanceID2() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.INSTANCE_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getInstanceID());
  }

  /**
   * Method under test: {@link ResourceEventType#setInstanceID(String)}
   */
  @Test
  void testSetInstanceID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceEventType resourceEventType = new ResourceEventType(metadata);

    // Act
    resourceEventType.setInstanceID("42");

    // Assert
    List<AbstractField> allProperties = resourceEventType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof GUIDType);
    assertEquals("42", resourceEventType.getInstanceID());
    assertEquals("42", ((GUIDType) getResult).getStringValue());
    assertEquals("42", ((GUIDType) getResult).getRawValue());
    assertEquals("42", ((GUIDType) getResult).getValue());
    assertEquals("stEvt", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceEventType.INSTANCE_ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceEventType#getSoftwareAgent()}
   */
  @Test
  void testGetSoftwareAgent() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getSoftwareAgent());
  }

  /**
   * Method under test: {@link ResourceEventType#getSoftwareAgent()}
   */
  @Test
  void testGetSoftwareAgent2() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.SOFTWARE_AGENT, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getSoftwareAgent());
  }

  /**
   * Method under test: {@link ResourceEventType#setSoftwareAgent(String)}
   */
  @Test
  void testSetSoftwareAgent() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceEventType resourceEventType = new ResourceEventType(metadata);

    // Act
    resourceEventType.setSoftwareAgent("42");

    // Assert
    List<AbstractField> allProperties = resourceEventType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertEquals("42", resourceEventType.getSoftwareAgent());
    assertEquals("42", ((AgentNameType) getResult).getStringValue());
    assertEquals("42", ((AgentNameType) getResult).getRawValue());
    assertEquals("42", ((AgentNameType) getResult).getValue());
    assertEquals("stEvt", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceEventType.SOFTWARE_AGENT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceEventType#getWhen()}
   */
  @Test
  void testGetWhen() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getWhen());
  }

  /**
   * Method under test: {@link ResourceEventType#getWhen()}
   */
  @Test
  void testGetWhen2() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.WHEN, "");

    // Act and Assert
    assertNull(resourceEventType.getWhen());
  }

  /**
   * Method under test: {@link ResourceEventType#setWhen(Calendar)}
   */
  @Test
  void testSetWhen() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceEventType resourceEventType = new ResourceEventType(metadata);
    GregorianCalendar value = new GregorianCalendar(1, 1, 1);

    // Act
    resourceEventType.setWhen(value);

    // Assert
    List<AbstractField> allProperties = resourceEventType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("stEvt", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceEventType.WHEN, getResult.getPropertyName());
    assertSame(value, ((DateType) getResult).getRawValue());
    assertSame(value, ((DateType) getResult).getValue());
    assertSame(value, resourceEventType.getWhen());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceEventType#getAction()}
   */
  @Test
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getAction());
  }

  /**
   * Method under test: {@link ResourceEventType#getAction()}
   */
  @Test
  void testGetAction2() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.ACTION, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getAction());
  }

  /**
   * Method under test: {@link ResourceEventType#setAction(String)}
   */
  @Test
  void testSetAction() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceEventType resourceEventType = new ResourceEventType(metadata);

    // Act
    resourceEventType.setAction("42");

    // Assert
    List<AbstractField> allProperties = resourceEventType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ChoiceType);
    assertEquals("42", resourceEventType.getAction());
    assertEquals("42", ((ChoiceType) getResult).getStringValue());
    assertEquals("42", ((ChoiceType) getResult).getRawValue());
    assertEquals("42", ((ChoiceType) getResult).getValue());
    assertEquals("stEvt", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceEventType.ACTION, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceEventType#getChanged()}
   */
  @Test
  void testGetChanged() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getChanged());
  }

  /**
   * Method under test: {@link ResourceEventType#getChanged()}
   */
  @Test
  void testGetChanged2() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.CHANGED, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getChanged());
  }

  /**
   * Method under test: {@link ResourceEventType#setChanged(String)}
   */
  @Test
  void testSetChanged() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceEventType resourceEventType = new ResourceEventType(metadata);

    // Act
    resourceEventType.setChanged("42");

    // Assert
    List<AbstractField> allProperties = resourceEventType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceEventType.getChanged());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stEvt", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceEventType.CHANGED, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceEventType#getParameters()}
   */
  @Test
  void testGetParameters() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getParameters());
  }

  /**
   * Method under test: {@link ResourceEventType#getParameters()}
   */
  @Test
  void testGetParameters2() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.PARAMETERS, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getParameters());
  }

  /**
   * Method under test: {@link ResourceEventType#setParameters(String)}
   */
  @Test
  void testSetParameters() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceEventType resourceEventType = new ResourceEventType(metadata);

    // Act
    resourceEventType.setParameters("42");

    // Assert
    List<AbstractField> allProperties = resourceEventType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceEventType.getParameters());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stEvt", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceEventType.PARAMETERS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link ResourceEventType#ResourceEventType(XMPMetadata)}
   */
  @Test
  void testNewResourceEventType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ResourceEventType actualResourceEventType = new ResourceEventType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", actualResourceEventType.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualResourceEventType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("stEvt", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#"));
    assertEquals("stEvt", actualResourceEventType.getPreferedPrefix());
    assertEquals("stEvt", actualResourceEventType.getPrefix());
    assertNull(actualResourceEventType.getPropertyName());
    assertNull(actualResourceEventType.getAction());
    assertNull(actualResourceEventType.getChanged());
    assertNull(actualResourceEventType.getInstanceID());
    assertNull(actualResourceEventType.getParameters());
    assertNull(actualResourceEventType.getSoftwareAgent());
    assertNull(actualResourceEventType.getWhen());
    List<AbstractField> allProperties = actualResourceEventType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualResourceEventType.getAllAttributes().isEmpty());
    assertSame(allProperties, actualResourceEventType.getContainer().getAllProperties());
    assertSame(metadata, actualResourceEventType.getMetadata());
  }
}
