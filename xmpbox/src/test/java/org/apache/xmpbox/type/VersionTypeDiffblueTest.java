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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VersionTypeDiffblueTest {
  /**
   * Test {@link VersionType#VersionType(XMPMetadata)}.
   * <p>
   * Method under test: {@link VersionType#VersionType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new VersionType(XMPMetadata)")
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

  /**
   * Test {@link VersionType#getComments()}.
   * <ul>
   *   <li>Given {@link VersionType#VersionType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getComments()}
   */
  @Test
  @DisplayName("Test getComments(); given VersionType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetComments_givenVersionTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getComments());
  }

  /**
   * Test {@link VersionType#getComments()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getComments()}
   */
  @Test
  @DisplayName("Test getComments(); then return 'Value'")
  void testGetComments_thenReturnValue() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.COMMENTS, "Value");

    // Act and Assert
    assertEquals("Value", versionType.getComments());
  }

  /**
   * Test {@link VersionType#setComments(String)}.
   * <p>
   * Method under test: {@link VersionType#setComments(String)}
   */
  @Test
  @DisplayName("Test setComments(String)")
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
   * Test {@link VersionType#getEvent()}.
   * <ul>
   *   <li>Given {@link VersionType#VersionType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getEvent()}
   */
  @Test
  @DisplayName("Test getEvent(); given VersionType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetEvent_givenVersionTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getEvent());
  }

  /**
   * Test {@link VersionType#setEvent(ResourceEventType)}.
   * <p>
   * Method under test: {@link VersionType#setEvent(ResourceEventType)}
   */
  @Test
  @DisplayName("Test setEvent(ResourceEventType)")
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
   * Test {@link VersionType#getModifyDate()}.
   * <p>
   * Method under test: {@link VersionType#getModifyDate()}
   */
  @Test
  @DisplayName("Test getModifyDate()")
  void testGetModifyDate() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.MODIFY_DATE, "");

    // Act and Assert
    assertNull(versionType.getModifyDate());
  }

  /**
   * Test {@link VersionType#getModifyDate()}.
   * <ul>
   *   <li>Given {@link VersionType#VersionType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getModifyDate()}
   */
  @Test
  @DisplayName("Test getModifyDate(); given VersionType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetModifyDate_givenVersionTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getModifyDate());
  }

  /**
   * Test {@link VersionType#setModifyDate(Calendar)}.
   * <p>
   * Method under test: {@link VersionType#setModifyDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModifyDate(Calendar)")
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
   * Test {@link VersionType#getVersion()}.
   * <ul>
   *   <li>Given {@link VersionType#VersionType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); given VersionType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetVersion_givenVersionTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getVersion());
  }

  /**
   * Test {@link VersionType#getVersion()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion(); then return 'Value'")
  void testGetVersion_thenReturnValue() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.VERSION, "Value");

    // Act and Assert
    assertEquals("Value", versionType.getVersion());
  }

  /**
   * Test {@link VersionType#setVersion(String)}.
   * <p>
   * Method under test: {@link VersionType#setVersion(String)}
   */
  @Test
  @DisplayName("Test setVersion(String)")
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
   * Test {@link VersionType#getModifier()}.
   * <ul>
   *   <li>Given {@link VersionType#VersionType(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getModifier()}
   */
  @Test
  @DisplayName("Test getModifier(); given VersionType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetModifier_givenVersionTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new VersionType(XMPMetadata.createXMPMetadata())).getModifier());
  }

  /**
   * Test {@link VersionType#getModifier()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionType#getModifier()}
   */
  @Test
  @DisplayName("Test getModifier(); then return 'Value'")
  void testGetModifier_thenReturnValue() {
    // Arrange
    VersionType versionType = new VersionType(XMPMetadata.createXMPMetadata());
    versionType.addSimpleProperty(VersionType.MODIFIER, "Value");

    // Act and Assert
    assertEquals("Value", versionType.getModifier());
  }

  /**
   * Test {@link VersionType#setModifier(String)}.
   * <p>
   * Method under test: {@link VersionType#setModifier(String)}
   */
  @Test
  @DisplayName("Test setModifier(String)")
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
}
