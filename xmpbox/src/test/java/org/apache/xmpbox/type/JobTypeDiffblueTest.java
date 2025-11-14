package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobTypeDiffblueTest {
  /**
   * Test {@link JobType#JobType(XMPMetadata)}.
   *
   * <p>Method under test: {@link JobType#JobType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new JobType(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobType.<init>(XMPMetadata)"})
  void testNewJobType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    JobType actualJobType = new JobType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", actualJobType.getNamespace());
    assertEquals("stJob", actualJobType.getPreferedPrefix());
    assertEquals("stJob", actualJobType.getPrefix());
    assertNull(actualJobType.getPropertyName());
    assertNull(actualJobType.getId());
    assertNull(actualJobType.getName());
    assertNull(actualJobType.getUrl());
    Map<String, String> allNamespacesWithPrefix = actualJobType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualJobType.getAllProperties().isEmpty());
    assertTrue(actualJobType.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertSame(metadata, actualJobType.getMetadata());
  }

  /**
   * Test {@link JobType#JobType(XMPMetadata, String)}.
   *
   * <p>Method under test: {@link JobType#JobType(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new JobType(XMPMetadata, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobType.<init>(XMPMetadata, String)"})
  void testNewJobType2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    JobType actualJobType = new JobType(metadata, "Field Prefix");

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Job#", actualJobType.getNamespace());
    assertEquals("stJob", actualJobType.getPreferedPrefix());
    assertEquals("stJob", actualJobType.getPrefix());
    assertNull(actualJobType.getPropertyName());
    assertNull(actualJobType.getId());
    assertNull(actualJobType.getName());
    assertNull(actualJobType.getUrl());
    Map<String, String> allNamespacesWithPrefix = actualJobType.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualJobType.getAllProperties().isEmpty());
    assertTrue(actualJobType.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/sType/Job#"));
    assertSame(metadata, actualJobType.getMetadata());
  }

  /**
   * Test {@link JobType#setId(String)}.
   *
   * <ul>
   *   <li>Then {@link JobType#JobType(XMPMetadata)} with metadata is createXMPMetadata
   *       AllProperties size is one.
   * </ul>
   *
   * <p>Method under test: {@link JobType#setId(String)}
   */
  @Test
  @DisplayName(
      "Test setId(String); then JobType(XMPMetadata) with metadata is createXMPMetadata AllProperties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobType.setId(String)"})
  void testSetId_thenJobTypeWithMetadataIsCreateXMPMetadataAllPropertiesSizeIsOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    JobType jobType = new JobType(metadata);

    // Act
    jobType.setId("42");

    // Assert
    List<AbstractField> allProperties = jobType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", jobType.getId());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(JobType.ID, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link JobType#setName(String)}.
   *
   * <ul>
   *   <li>Then {@link JobType#JobType(XMPMetadata)} with metadata is createXMPMetadata
   *       AllProperties size is one.
   * </ul>
   *
   * <p>Method under test: {@link JobType#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); then JobType(XMPMetadata) with metadata is createXMPMetadata AllProperties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobType.setName(String)"})
  void testSetName_thenJobTypeWithMetadataIsCreateXMPMetadataAllPropertiesSizeIsOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    JobType jobType = new JobType(metadata);

    // Act
    jobType.setName("Name");

    // Assert
    List<AbstractField> allProperties = jobType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Name", jobType.getName());
    assertEquals("Name", ((TextType) getResult).getStringValue());
    assertEquals("Name", ((TextType) getResult).getRawValue());
    assertEquals("Name", ((TextType) getResult).getValue());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(JobType.NAME, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link JobType#setUrl(String)}.
   *
   * <ul>
   *   <li>Then {@link JobType#JobType(XMPMetadata)} with metadata is createXMPMetadata
   *       AllProperties size is one.
   * </ul>
   *
   * <p>Method under test: {@link JobType#setUrl(String)}
   */
  @Test
  @DisplayName(
      "Test setUrl(String); then JobType(XMPMetadata) with metadata is createXMPMetadata AllProperties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobType.setUrl(String)"})
  void testSetUrl_thenJobTypeWithMetadataIsCreateXMPMetadataAllPropertiesSizeIsOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    JobType jobType = new JobType(metadata);

    // Act
    jobType.setUrl("https://example.org/example");

    // Assert
    List<AbstractField> allProperties = jobType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof URLType);
    assertEquals("https://example.org/example", jobType.getUrl());
    assertEquals("https://example.org/example", ((URLType) getResult).getStringValue());
    assertEquals("https://example.org/example", ((URLType) getResult).getRawValue());
    assertEquals("https://example.org/example", ((URLType) getResult).getValue());
    assertEquals("stJob", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(JobType.URL, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link JobType#getId()}.
   *
   * <ul>
   *   <li>Given {@link JobType#JobType(XMPMetadata)} with metadata is createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobType#getId()}
   */
  @Test
  @DisplayName(
      "Test getId(); given JobType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobType.getId()"})
  void testGetId_givenJobTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JobType(XMPMetadata.createXMPMetadata()).getId());
  }

  /**
   * Test {@link JobType#getId()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JobType#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobType.getId()"})
  void testGetId_thenReturnValue() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.ID, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getId());
  }

  /**
   * Test {@link JobType#getName()}.
   *
   * <ul>
   *   <li>Given {@link JobType#JobType(XMPMetadata)} with metadata is createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobType#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given JobType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobType.getName()"})
  void testGetName_givenJobTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JobType(XMPMetadata.createXMPMetadata()).getName());
  }

  /**
   * Test {@link JobType#getName()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JobType#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobType.getName()"})
  void testGetName_thenReturnValue() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.NAME, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getName());
  }

  /**
   * Test {@link JobType#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link JobType#JobType(XMPMetadata)} with metadata is createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobType#getUrl()}
   */
  @Test
  @DisplayName(
      "Test getUrl(); given JobType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobType.getUrl()"})
  void testGetUrl_givenJobTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JobType(XMPMetadata.createXMPMetadata()).getUrl());
  }

  /**
   * Test {@link JobType#getUrl()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JobType#getUrl()}
   */
  @Test
  @DisplayName("Test getUrl(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobType.getUrl()"})
  void testGetUrl_thenReturnValue() {
    // Arrange
    JobType jobType = new JobType(XMPMetadata.createXMPMetadata());
    jobType.addSimpleProperty(JobType.URL, "Value");

    // Act and Assert
    assertEquals("Value", jobType.getUrl());
  }
}
