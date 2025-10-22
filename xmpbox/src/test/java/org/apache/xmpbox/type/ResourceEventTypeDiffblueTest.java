package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceEventTypeDiffblueTest {
  /**
   * Test {@link ResourceEventType#ResourceEventType(XMPMetadata)}.
   * <p>
   * Method under test: {@link ResourceEventType#ResourceEventType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new ResourceEventType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceEventType.<init>(XMPMetadata)"})
  void testNewResourceEventType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ResourceEventType actualResourceEventType = new ResourceEventType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", actualResourceEventType.getNamespace());
    assertEquals("stEvt", actualResourceEventType.getPreferedPrefix());
    assertEquals("stEvt", actualResourceEventType.getPrefix());
    assertNull(actualResourceEventType.getPropertyName());
    assertNull(actualResourceEventType.getAction());
    assertNull(actualResourceEventType.getChanged());
    assertNull(actualResourceEventType.getInstanceID());
    assertNull(actualResourceEventType.getParameters());
    assertNull(actualResourceEventType.getSoftwareAgent());
    assertNull(actualResourceEventType.getWhen());
    Map<String, String> allNamespacesWithPrefix = actualResourceEventType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualResourceEventType.getAllProperties().isEmpty());
    assertTrue(actualResourceEventType.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#"));
    assertSame(metadata, actualResourceEventType.getMetadata());
  }

  /**
   * Test {@link ResourceEventType#getInstanceID()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getInstanceID()}
   */
  @Test
  @DisplayName("Test getInstanceID(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getInstanceID()"})
  void testGetInstanceID_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getInstanceID());
  }

  /**
   * Test {@link ResourceEventType#getInstanceID()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getInstanceID()}
   */
  @Test
  @DisplayName("Test getInstanceID(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getInstanceID()"})
  void testGetInstanceID_thenReturnValue() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.INSTANCE_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getInstanceID());
  }

  /**
   * Test {@link ResourceEventType#setInstanceID(String)}.
   * <p>
   * Method under test: {@link ResourceEventType#setInstanceID(String)}
   */
  @Test
  @DisplayName("Test setInstanceID(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceEventType.setInstanceID(String)"})
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
   * Test {@link ResourceEventType#getSoftwareAgent()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getSoftwareAgent()}
   */
  @Test
  @DisplayName("Test getSoftwareAgent(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getSoftwareAgent()"})
  void testGetSoftwareAgent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getSoftwareAgent());
  }

  /**
   * Test {@link ResourceEventType#getSoftwareAgent()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getSoftwareAgent()}
   */
  @Test
  @DisplayName("Test getSoftwareAgent(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getSoftwareAgent()"})
  void testGetSoftwareAgent_thenReturnValue() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.SOFTWARE_AGENT, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getSoftwareAgent());
  }

  /**
   * Test {@link ResourceEventType#setSoftwareAgent(String)}.
   * <p>
   * Method under test: {@link ResourceEventType#setSoftwareAgent(String)}
   */
  @Test
  @DisplayName("Test setSoftwareAgent(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceEventType.setSoftwareAgent(String)"})
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
   * Test {@link ResourceEventType#getWhen()}.
   * <p>
   * Method under test: {@link ResourceEventType#getWhen()}
   */
  @Test
  @DisplayName("Test getWhen()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar ResourceEventType.getWhen()"})
  void testGetWhen() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.WHEN, "");

    // Act and Assert
    assertNull(resourceEventType.getWhen());
  }

  /**
   * Test {@link ResourceEventType#getWhen()}.
   * <ul>
   *   <li>Given {@link ResourceEventType#ResourceEventType(XMPMetadata)} with metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getWhen()}
   */
  @Test
  @DisplayName("Test getWhen(); given ResourceEventType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Calendar ResourceEventType.getWhen()"})
  void testGetWhen_givenResourceEventTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getWhen());
  }

  /**
   * Test {@link ResourceEventType#setWhen(Calendar)}.
   * <p>
   * Method under test: {@link ResourceEventType#setWhen(Calendar)}
   */
  @Test
  @DisplayName("Test setWhen(Calendar)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceEventType.setWhen(Calendar)"})
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
   * Test {@link ResourceEventType#getAction()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getAction()"})
  void testGetAction_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getAction());
  }

  /**
   * Test {@link ResourceEventType#getAction()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getAction()"})
  void testGetAction_thenReturnValue() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.ACTION, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getAction());
  }

  /**
   * Test {@link ResourceEventType#setAction(String)}.
   * <p>
   * Method under test: {@link ResourceEventType#setAction(String)}
   */
  @Test
  @DisplayName("Test setAction(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceEventType.setAction(String)"})
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
   * Test {@link ResourceEventType#getChanged()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getChanged()}
   */
  @Test
  @DisplayName("Test getChanged(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getChanged()"})
  void testGetChanged_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getChanged());
  }

  /**
   * Test {@link ResourceEventType#getChanged()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getChanged()}
   */
  @Test
  @DisplayName("Test getChanged(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getChanged()"})
  void testGetChanged_thenReturnValue() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.CHANGED, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getChanged());
  }

  /**
   * Test {@link ResourceEventType#setChanged(String)}.
   * <p>
   * Method under test: {@link ResourceEventType#setChanged(String)}
   */
  @Test
  @DisplayName("Test setChanged(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceEventType.setChanged(String)"})
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
   * Test {@link ResourceEventType#getParameters()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getParameters()}
   */
  @Test
  @DisplayName("Test getParameters(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getParameters()"})
  void testGetParameters_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ResourceEventType(XMPMetadata.createXMPMetadata())).getParameters());
  }

  /**
   * Test {@link ResourceEventType#getParameters()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceEventType#getParameters()}
   */
  @Test
  @DisplayName("Test getParameters(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceEventType.getParameters()"})
  void testGetParameters_thenReturnValue() {
    // Arrange
    ResourceEventType resourceEventType = new ResourceEventType(XMPMetadata.createXMPMetadata());
    resourceEventType.addSimpleProperty(ResourceEventType.PARAMETERS, "Value");

    // Act and Assert
    assertEquals("Value", resourceEventType.getParameters());
  }

  /**
   * Test {@link ResourceEventType#setParameters(String)}.
   * <p>
   * Method under test: {@link ResourceEventType#setParameters(String)}
   */
  @Test
  @DisplayName("Test setParameters(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceEventType.setParameters(String)"})
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
}
