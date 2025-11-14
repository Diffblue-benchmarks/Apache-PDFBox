package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceRefTypeDiffblueTest {
  /**
   * Test {@link ResourceRefType#ResourceRefType(XMPMetadata)}.
   *
   * <p>Method under test: {@link ResourceRefType#ResourceRefType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new ResourceRefType(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.<init>(XMPMetadata)"})
  void testNewResourceRefType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ResourceRefType actualResourceRefType = new ResourceRefType(metadata);

    // Assert
    assertEquals(
        "http://ns.adobe.com/xap/1.0/sType/ResourceRef#", actualResourceRefType.getNamespace());
    assertEquals("stRef", actualResourceRefType.getPreferedPrefix());
    assertEquals("stRef", actualResourceRefType.getPrefix());
    assertNull(actualResourceRefType.getPropertyName());
    assertNull(actualResourceRefType.getDocumentID());
    assertNull(actualResourceRefType.getFilePath());
    assertNull(actualResourceRefType.getFromPart());
    assertNull(actualResourceRefType.getInstanceID());
    assertNull(actualResourceRefType.getManageTo());
    assertNull(actualResourceRefType.getManageUI());
    assertNull(actualResourceRefType.getManager());
    assertNull(actualResourceRefType.getManagerVariant());
    assertNull(actualResourceRefType.getMaskMarkers());
    assertNull(actualResourceRefType.getPartMapping());
    assertNull(actualResourceRefType.getRenditionClass());
    assertNull(actualResourceRefType.getRenditionParams());
    assertNull(actualResourceRefType.getToPart());
    assertNull(actualResourceRefType.getVersionID());
    assertNull(actualResourceRefType.getLastModifyDate());
    assertNull(actualResourceRefType.getAlternatePaths());
    assertNull(actualResourceRefType.getAlternatePathsProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualResourceRefType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualResourceRefType.getAllProperties().isEmpty());
    assertTrue(actualResourceRefType.getAllAttributes().isEmpty());
    assertTrue(
        allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/sType/ResourceRef#"));
    assertSame(metadata, actualResourceRefType.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getDocumentID()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getDocumentID()}
   */
  @Test
  @DisplayName("Test getDocumentID(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getDocumentID()"})
  void testGetDocumentID_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getDocumentID());
  }

  /**
   * Test {@link ResourceRefType#getDocumentID()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getDocumentID()}
   */
  @Test
  @DisplayName("Test getDocumentID(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getDocumentID()"})
  void testGetDocumentID_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.DOCUMENT_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getDocumentID());
  }

  /**
   * Test {@link ResourceRefType#setDocumentID(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setDocumentID(String)}
   */
  @Test
  @DisplayName("Test setDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setDocumentID(String)"})
  void testSetDocumentID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setDocumentID("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getDocumentID());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.DOCUMENT_ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getFilePath()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getFilePath()}
   */
  @Test
  @DisplayName("Test getFilePath(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getFilePath()"})
  void testGetFilePath_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getFilePath());
  }

  /**
   * Test {@link ResourceRefType#getFilePath()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getFilePath()}
   */
  @Test
  @DisplayName("Test getFilePath(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getFilePath()"})
  void testGetFilePath_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.FILE_PATH, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getFilePath());
  }

  /**
   * Test {@link ResourceRefType#setFilePath(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setFilePath(String)}
   */
  @Test
  @DisplayName("Test setFilePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setFilePath(String)"})
  void testSetFilePath() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setFilePath("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getFilePath());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.FILE_PATH, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getInstanceID()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getInstanceID()}
   */
  @Test
  @DisplayName("Test getInstanceID(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getInstanceID()"})
  void testGetInstanceID_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getInstanceID());
  }

  /**
   * Test {@link ResourceRefType#getInstanceID()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getInstanceID()}
   */
  @Test
  @DisplayName("Test getInstanceID(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getInstanceID()"})
  void testGetInstanceID_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.INSTANCE_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getInstanceID());
  }

  /**
   * Test {@link ResourceRefType#setInstanceID(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setInstanceID(String)}
   */
  @Test
  @DisplayName("Test setInstanceID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setInstanceID(String)"})
  void testSetInstanceID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setInstanceID("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getInstanceID());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.INSTANCE_ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getLastModifyDate()}.
   *
   * <p>Method under test: {@link ResourceRefType#getLastModifyDate()}
   */
  @Test
  @DisplayName("Test getLastModifyDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar ResourceRefType.getLastModifyDate()"})
  void testGetLastModifyDate() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.LAST_MODIFY_DATE, "");

    // Act and Assert
    assertNull(resourceRefType.getLastModifyDate());
  }

  /**
   * Test {@link ResourceRefType#getLastModifyDate()}.
   *
   * <ul>
   *   <li>Given {@link ResourceRefType#ResourceRefType(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getLastModifyDate()}
   */
  @Test
  @DisplayName(
      "Test getLastModifyDate(); given ResourceRefType(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar ResourceRefType.getLastModifyDate()"})
  void testGetLastModifyDate_givenResourceRefTypeWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getLastModifyDate());
  }

  /**
   * Test {@link ResourceRefType#setLastModifyDate(Calendar)}.
   *
   * <p>Method under test: {@link ResourceRefType#setLastModifyDate(Calendar)}
   */
  @Test
  @DisplayName("Test setLastModifyDate(Calendar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setLastModifyDate(Calendar)"})
  void testSetLastModifyDate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);
    GregorianCalendar value = new GregorianCalendar(1, 1, 1);

    // Act
    resourceRefType.setLastModifyDate(value);

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.LAST_MODIFY_DATE, getResult.getPropertyName());
    assertSame(value, ((DateType) getResult).getRawValue());
    assertSame(value, ((DateType) getResult).getValue());
    assertSame(value, resourceRefType.getLastModifyDate());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getManageUI()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManageUI()}
   */
  @Test
  @DisplayName("Test getManageUI(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManageUI()"})
  void testGetManageUI_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getManageUI());
  }

  /**
   * Test {@link ResourceRefType#getManageUI()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManageUI()}
   */
  @Test
  @DisplayName("Test getManageUI(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManageUI()"})
  void testGetManageUI_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGE_UI, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManageUI());
  }

  /**
   * Test {@link ResourceRefType#setManageUI(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setManageUI(String)}
   */
  @Test
  @DisplayName("Test setManageUI(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setManageUI(String)"})
  void testSetManageUI() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManageUI("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getManageUI());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGE_UI, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getManageTo()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManageTo()}
   */
  @Test
  @DisplayName("Test getManageTo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManageTo()"})
  void testGetManageTo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getManageTo());
  }

  /**
   * Test {@link ResourceRefType#getManageTo()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManageTo()}
   */
  @Test
  @DisplayName("Test getManageTo(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManageTo()"})
  void testGetManageTo_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGE_TO, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManageTo());
  }

  /**
   * Test {@link ResourceRefType#setManageTo(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setManageTo(String)}
   */
  @Test
  @DisplayName("Test setManageTo(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setManageTo(String)"})
  void testSetManageTo() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManageTo("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URIType);
    assertEquals("42", resourceRefType.getManageTo());
    assertEquals("42", ((URIType) getResult).getStringValue());
    assertEquals("42", ((URIType) getResult).getRawValue());
    assertEquals("42", ((URIType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGE_TO, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getManager()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManager()}
   */
  @Test
  @DisplayName("Test getManager(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManager()"})
  void testGetManager_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getManager());
  }

  /**
   * Test {@link ResourceRefType#getManager()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManager()}
   */
  @Test
  @DisplayName("Test getManager(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManager()"})
  void testGetManager_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGER, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManager());
  }

  /**
   * Test {@link ResourceRefType#setManager(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setManager(String)}
   */
  @Test
  @DisplayName("Test setManager(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setManager(String)"})
  void testSetManager() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManager("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertEquals("42", resourceRefType.getManager());
    assertEquals("42", ((AgentNameType) getResult).getStringValue());
    assertEquals("42", ((AgentNameType) getResult).getRawValue());
    assertEquals("42", ((AgentNameType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGER, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getManagerVariant()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManagerVariant()}
   */
  @Test
  @DisplayName("Test getManagerVariant(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManagerVariant()"})
  void testGetManagerVariant_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getManagerVariant());
  }

  /**
   * Test {@link ResourceRefType#getManagerVariant()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getManagerVariant()}
   */
  @Test
  @DisplayName("Test getManagerVariant(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getManagerVariant()"})
  void testGetManagerVariant_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MANAGER_VARIANT, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getManagerVariant());
  }

  /**
   * Test {@link ResourceRefType#setManagerVariant(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setManagerVariant(String)}
   */
  @Test
  @DisplayName("Test setManagerVariant(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setManagerVariant(String)"})
  void testSetManagerVariant() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setManagerVariant("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getManagerVariant());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MANAGER_VARIANT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getPartMapping()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getPartMapping()}
   */
  @Test
  @DisplayName("Test getPartMapping(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getPartMapping()"})
  void testGetPartMapping_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getPartMapping());
  }

  /**
   * Test {@link ResourceRefType#getPartMapping()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getPartMapping()}
   */
  @Test
  @DisplayName("Test getPartMapping(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getPartMapping()"})
  void testGetPartMapping_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.PART_MAPPING, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getPartMapping());
  }

  /**
   * Test {@link ResourceRefType#setPartMapping(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setPartMapping(String)}
   */
  @Test
  @DisplayName("Test setPartMapping(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setPartMapping(String)"})
  void testSetPartMapping() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setPartMapping("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getPartMapping());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.PART_MAPPING, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getRenditionParams()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getRenditionParams()}
   */
  @Test
  @DisplayName("Test getRenditionParams(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getRenditionParams()"})
  void testGetRenditionParams_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getRenditionParams());
  }

  /**
   * Test {@link ResourceRefType#getRenditionParams()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getRenditionParams()}
   */
  @Test
  @DisplayName("Test getRenditionParams(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getRenditionParams()"})
  void testGetRenditionParams_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.RENDITION_PARAMS, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getRenditionParams());
  }

  /**
   * Test {@link ResourceRefType#setRenditionParams(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setRenditionParams(String)}
   */
  @Test
  @DisplayName("Test setRenditionParams(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setRenditionParams(String)"})
  void testSetRenditionParams() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setRenditionParams("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getRenditionParams());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.RENDITION_PARAMS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getVersionID()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getVersionID()}
   */
  @Test
  @DisplayName("Test getVersionID(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getVersionID()"})
  void testGetVersionID_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getVersionID());
  }

  /**
   * Test {@link ResourceRefType#getVersionID()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getVersionID()}
   */
  @Test
  @DisplayName("Test getVersionID(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getVersionID()"})
  void testGetVersionID_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.VERSION_ID, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getVersionID());
  }

  /**
   * Test {@link ResourceRefType#setVersionID(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setVersionID(String)}
   */
  @Test
  @DisplayName("Test setVersionID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setVersionID(String)"})
  void testSetVersionID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setVersionID("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", resourceRefType.getVersionID());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.VERSION_ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getMaskMarkers()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getMaskMarkers()}
   */
  @Test
  @DisplayName("Test getMaskMarkers(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getMaskMarkers()"})
  void testGetMaskMarkers_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getMaskMarkers());
  }

  /**
   * Test {@link ResourceRefType#getMaskMarkers()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getMaskMarkers()}
   */
  @Test
  @DisplayName("Test getMaskMarkers(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getMaskMarkers()"})
  void testGetMaskMarkers_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.MASK_MARKERS, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getMaskMarkers());
  }

  /**
   * Test {@link ResourceRefType#setMaskMarkers(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setMaskMarkers(String)}
   */
  @Test
  @DisplayName("Test setMaskMarkers(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setMaskMarkers(String)"})
  void testSetMaskMarkers() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setMaskMarkers("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ChoiceType);
    assertEquals("42", resourceRefType.getMaskMarkers());
    assertEquals("42", ((ChoiceType) getResult).getStringValue());
    assertEquals("42", ((ChoiceType) getResult).getRawValue());
    assertEquals("42", ((ChoiceType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.MASK_MARKERS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getRenditionClass()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getRenditionClass()}
   */
  @Test
  @DisplayName("Test getRenditionClass(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getRenditionClass()"})
  void testGetRenditionClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getRenditionClass());
  }

  /**
   * Test {@link ResourceRefType#getRenditionClass()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getRenditionClass()}
   */
  @Test
  @DisplayName("Test getRenditionClass(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getRenditionClass()"})
  void testGetRenditionClass_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.RENDITION_CLASS, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getRenditionClass());
  }

  /**
   * Test {@link ResourceRefType#setRenditionClass(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setRenditionClass(String)}
   */
  @Test
  @DisplayName("Test setRenditionClass(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setRenditionClass(String)"})
  void testSetRenditionClass() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setRenditionClass("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof RenditionClassType);
    assertEquals("42", resourceRefType.getRenditionClass());
    assertEquals("42", ((RenditionClassType) getResult).getStringValue());
    assertEquals("42", ((RenditionClassType) getResult).getRawValue());
    assertEquals("42", ((RenditionClassType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.RENDITION_CLASS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getFromPart()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getFromPart()}
   */
  @Test
  @DisplayName("Test getFromPart(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getFromPart()"})
  void testGetFromPart_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getFromPart());
  }

  /**
   * Test {@link ResourceRefType#getFromPart()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getFromPart()}
   */
  @Test
  @DisplayName("Test getFromPart(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getFromPart()"})
  void testGetFromPart_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.FROM_PART, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getFromPart());
  }

  /**
   * Test {@link ResourceRefType#setFromPart(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setFromPart(String)}
   */
  @Test
  @DisplayName("Test setFromPart(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setFromPart(String)"})
  void testSetFromPart() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setFromPart("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof PartType);
    assertEquals("42", resourceRefType.getFromPart());
    assertEquals("42", ((PartType) getResult).getStringValue());
    assertEquals("42", ((PartType) getResult).getRawValue());
    assertEquals("42", ((PartType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.FROM_PART, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getToPart()}.
   *
   * <ul>
   *   <li>Given {@link ResourceRefType#ResourceRefType(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getToPart()}
   */
  @Test
  @DisplayName(
      "Test getToPart(); given ResourceRefType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getToPart()"})
  void testGetToPart_givenResourceRefTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getToPart());
  }

  /**
   * Test {@link ResourceRefType#getToPart()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getToPart()}
   */
  @Test
  @DisplayName("Test getToPart(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceRefType.getToPart()"})
  void testGetToPart_thenReturnValue() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addSimpleProperty(ResourceRefType.TO_PART, "Value");

    // Act and Assert
    assertEquals("Value", resourceRefType.getToPart());
  }

  /**
   * Test {@link ResourceRefType#setToPart(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#setToPart(String)}
   */
  @Test
  @DisplayName("Test setToPart(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.setToPart(String)"})
  void testSetToPart() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.setToPart("42");

    // Assert
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof PartType);
    assertEquals("42", resourceRefType.getToPart());
    assertEquals("42", ((PartType) getResult).getStringValue());
    assertEquals("42", ((PartType) getResult).getRawValue());
    assertEquals("42", ((PartType) getResult).getValue());
    assertEquals("stRef", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ResourceRefType.TO_PART, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#addAlternatePath(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#addAlternatePath(String)}
   */
  @Test
  @DisplayName("Test addAlternatePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.addAlternatePath(String)"})
  void testAddAlternatePath() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ResourceRefType resourceRefType = new ResourceRefType(metadata);

    // Act
    resourceRefType.addAlternatePath("42");

    // Assert
    List<String> alternatePaths = resourceRefType.getAlternatePaths();
    assertEquals(1, alternatePaths.size());
    assertEquals("42", alternatePaths.get(0));
    ArrayProperty alternatePathsProperty = resourceRefType.getAlternatePathsProperty();
    assertEquals("stRef", alternatePathsProperty.getPrefix());
    assertNull(alternatePathsProperty.getNamespace());
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, alternatePathsProperty.getAllProperties().size());
    assertEquals(Cardinality.Seq, alternatePathsProperty.getArrayType());
    assertTrue(alternatePathsProperty.getAllAttributes().isEmpty());
    assertTrue(alternatePathsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(alternatePaths, alternatePathsProperty.getElementsAsString());
    assertEquals(ResourceRefType.ALTERNATE_PATHS, alternatePathsProperty.getPropertyName());
    assertSame(alternatePathsProperty, allProperties.get(0));
    assertSame(metadata, alternatePathsProperty.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#addAlternatePath(String)}.
   *
   * <p>Method under test: {@link ResourceRefType#addAlternatePath(String)}
   */
  @Test
  @DisplayName("Test addAlternatePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceRefType.addAlternatePath(String)"})
  void testAddAlternatePath2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    ResourceRefType resourceRefType = new ResourceRefType(metadata);
    resourceRefType.addAlternatePath("42");

    // Act
    resourceRefType.addAlternatePath("42");

    // Assert
    List<String> alternatePaths = resourceRefType.getAlternatePaths();
    assertEquals(2, alternatePaths.size());
    assertEquals("42", alternatePaths.get(0));
    assertEquals("42", alternatePaths.get(1));
    ArrayProperty alternatePathsProperty = resourceRefType.getAlternatePathsProperty();
    assertEquals("stRef", alternatePathsProperty.getPrefix());
    assertNull(alternatePathsProperty.getNamespace());
    List<AbstractField> allProperties = resourceRefType.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(2, alternatePathsProperty.getAllProperties().size());
    assertEquals(Cardinality.Seq, alternatePathsProperty.getArrayType());
    assertTrue(alternatePathsProperty.getAllAttributes().isEmpty());
    assertTrue(alternatePathsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(alternatePaths, alternatePathsProperty.getElementsAsString());
    assertEquals(ResourceRefType.ALTERNATE_PATHS, alternatePathsProperty.getPropertyName());
    assertSame(alternatePathsProperty, allProperties.get(0));
    assertSame(metadata, alternatePathsProperty.getMetadata());
  }

  /**
   * Test {@link ResourceRefType#getAlternatePathsProperty()}.
   *
   * <p>Method under test: {@link ResourceRefType#getAlternatePathsProperty()}
   */
  @Test
  @DisplayName("Test getAlternatePathsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty ResourceRefType.getAlternatePathsProperty()"})
  void testGetAlternatePathsProperty() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getAlternatePathsProperty());
  }

  /**
   * Test {@link ResourceRefType#getAlternatePaths()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  @DisplayName("Test getAlternatePaths(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ResourceRefType.getAlternatePaths()"})
  void testGetAlternatePaths_thenReturnEmpty() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    ArrayProperty obj =
        new ArrayProperty(
            XMPMetadata.createXMPMetadata(),
            ResourceRefType.ALTERNATE_PATHS,
            ResourceRefType.ALTERNATE_PATHS,
            ResourceRefType.ALTERNATE_PATHS,
            Cardinality.Simple);
    resourceRefType.addProperty(obj);

    // Act and Assert
    assertTrue(resourceRefType.getAlternatePaths().isEmpty());
  }

  /**
   * Test {@link ResourceRefType#getAlternatePaths()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  @DisplayName("Test getAlternatePaths(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ResourceRefType.getAlternatePaths()"})
  void testGetAlternatePaths_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceRefType(XMPMetadata.createXMPMetadata()).getAlternatePaths());
  }

  /**
   * Test {@link ResourceRefType#getAlternatePaths()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  @DisplayName("Test getAlternatePaths(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ResourceRefType.getAlternatePaths()"})
  void testGetAlternatePaths_thenReturnSizeIsOne() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addAlternatePath("42");

    // Act
    List<String> actualAlternatePaths = resourceRefType.getAlternatePaths();

    // Assert
    assertEquals(1, actualAlternatePaths.size());
    assertEquals("42", actualAlternatePaths.get(0));
  }

  /**
   * Test {@link ResourceRefType#getAlternatePaths()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ResourceRefType#getAlternatePaths()}
   */
  @Test
  @DisplayName("Test getAlternatePaths(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ResourceRefType.getAlternatePaths()"})
  void testGetAlternatePaths_thenReturnSizeIsTwo() {
    // Arrange
    ResourceRefType resourceRefType = new ResourceRefType(XMPMetadata.createXMPMetadata());
    resourceRefType.addAlternatePath(ResourceRefType.ALTERNATE_PATHS);
    resourceRefType.addAlternatePath("42");

    // Act
    List<String> actualAlternatePaths = resourceRefType.getAlternatePaths();

    // Assert
    assertEquals(2, actualAlternatePaths.size());
    assertEquals("42", actualAlternatePaths.get(1));
    assertEquals(ResourceRefType.ALTERNATE_PATHS, actualAlternatePaths.get(0));
  }
}
