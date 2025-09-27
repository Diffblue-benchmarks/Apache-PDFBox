package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThumbnailTypeDiffblueTest {
  /**
   * Test {@link ThumbnailType#ThumbnailType(XMPMetadata)}.
   *
   * <p>Method under test: {@link ThumbnailType#ThumbnailType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new ThumbnailType(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThumbnailType.<init>(XMPMetadata)"})
  void testNewThumbnailType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ThumbnailType actualThumbnailType = new ThumbnailType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/g/img/", actualThumbnailType.getNamespace());
    assertEquals("xmpGImg", actualThumbnailType.getPreferedPrefix());
    assertEquals("xmpGImg", actualThumbnailType.getPrefix());
    assertNull(actualThumbnailType.getHeight());
    assertNull(actualThumbnailType.getWidth());
    assertNull(actualThumbnailType.getPropertyName());
    assertNull(actualThumbnailType.getFormat());
    assertNull(actualThumbnailType.getImage());
    assertEquals(1, actualThumbnailType.getAllAttributes().size());
    assertTrue(actualThumbnailType.getAllProperties().isEmpty());
    assertTrue(actualThumbnailType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualThumbnailType.getMetadata());
  }

  /**
   * Test {@link ThumbnailType#getHeight()}.
   *
   * <ul>
   *   <li>Given {@link ThumbnailType#ThumbnailType(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getHeight()}
   */
  @Test
  @DisplayName(
      "Test getHeight(); given ThumbnailType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ThumbnailType.getHeight()"})
  void testGetHeight_givenThumbnailTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ThumbnailType(XMPMetadata.createXMPMetadata()).getHeight());
  }

  /**
   * Test {@link ThumbnailType#getHeight()}.
   *
   * <ul>
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight(); then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ThumbnailType.getHeight()"})
  void testGetHeight_thenReturnIntValueIsFortyTwo() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.HEIGHT, 42);

    // Act and Assert
    assertEquals(42, thumbnailType.getHeight().intValue());
  }

  /**
   * Test {@link ThumbnailType#setHeight(Integer)}.
   *
   * <p>Method under test: {@link ThumbnailType#setHeight(Integer)}
   */
  @Test
  @DisplayName("Test setHeight(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThumbnailType.setHeight(Integer)"})
  void testSetHeight() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setHeight(1);

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("1", ((IntegerType) getResult).getStringValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(1, ((IntegerType) getResult).getValue().intValue());
    assertEquals(1, thumbnailType.getHeight().intValue());
    assertEquals(1, ((Integer) ((IntegerType) getResult).getRawValue()).intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.HEIGHT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ThumbnailType#getWidth()}.
   *
   * <ul>
   *   <li>Given {@link ThumbnailType#ThumbnailType(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getWidth()}
   */
  @Test
  @DisplayName(
      "Test getWidth(); given ThumbnailType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ThumbnailType.getWidth()"})
  void testGetWidth_givenThumbnailTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ThumbnailType(XMPMetadata.createXMPMetadata()).getWidth());
  }

  /**
   * Test {@link ThumbnailType#getWidth()}.
   *
   * <ul>
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ThumbnailType.getWidth()"})
  void testGetWidth_thenReturnIntValueIsFortyTwo() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.WIDTH, 42);

    // Act and Assert
    assertEquals(42, thumbnailType.getWidth().intValue());
  }

  /**
   * Test {@link ThumbnailType#setWidth(Integer)}.
   *
   * <p>Method under test: {@link ThumbnailType#setWidth(Integer)}
   */
  @Test
  @DisplayName("Test setWidth(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThumbnailType.setWidth(Integer)"})
  void testSetWidth() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setWidth(1);

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("1", ((IntegerType) getResult).getStringValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(1, ((IntegerType) getResult).getValue().intValue());
    assertEquals(1, thumbnailType.getWidth().intValue());
    assertEquals(1, ((Integer) ((IntegerType) getResult).getRawValue()).intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.WIDTH, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ThumbnailType#getImage()}.
   *
   * <ul>
   *   <li>Given {@link ThumbnailType#ThumbnailType(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getImage()}
   */
  @Test
  @DisplayName(
      "Test getImage(); given ThumbnailType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThumbnailType.getImage()"})
  void testGetImage_givenThumbnailTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ThumbnailType(XMPMetadata.createXMPMetadata()).getImage());
  }

  /**
   * Test {@link ThumbnailType#getImage()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getImage()}
   */
  @Test
  @DisplayName("Test getImage(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThumbnailType.getImage()"})
  void testGetImage_thenReturnValue() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.IMAGE, "Value");

    // Act and Assert
    assertEquals("Value", thumbnailType.getImage());
  }

  /**
   * Test {@link ThumbnailType#setImage(String)}.
   *
   * <p>Method under test: {@link ThumbnailType#setImage(String)}
   */
  @Test
  @DisplayName("Test setImage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThumbnailType.setImage(String)"})
  void testSetImage() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setImage("Image");

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Image", ((TextType) getResult).getStringValue());
    assertEquals("Image", thumbnailType.getImage());
    assertEquals("Image", ((TextType) getResult).getRawValue());
    assertEquals("Image", ((TextType) getResult).getValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.IMAGE, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link ThumbnailType#getFormat()}.
   *
   * <ul>
   *   <li>Given {@link ThumbnailType#ThumbnailType(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getFormat()}
   */
  @Test
  @DisplayName(
      "Test getFormat(); given ThumbnailType(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThumbnailType.getFormat()"})
  void testGetFormat_givenThumbnailTypeWithMetadataIsCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ThumbnailType(XMPMetadata.createXMPMetadata()).getFormat());
  }

  /**
   * Test {@link ThumbnailType#getFormat()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailType#getFormat()}
   */
  @Test
  @DisplayName("Test getFormat(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThumbnailType.getFormat()"})
  void testGetFormat_thenReturnValue() {
    // Arrange
    ThumbnailType thumbnailType = new ThumbnailType(XMPMetadata.createXMPMetadata());
    thumbnailType.addSimpleProperty(ThumbnailType.FORMAT, "Value");

    // Act and Assert
    assertEquals("Value", thumbnailType.getFormat());
  }

  /**
   * Test {@link ThumbnailType#setFormat(String)}.
   *
   * <p>Method under test: {@link ThumbnailType#setFormat(String)}
   */
  @Test
  @DisplayName("Test setFormat(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThumbnailType.setFormat(String)"})
  void testSetFormat() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    ThumbnailType thumbnailType = new ThumbnailType(metadata);

    // Act
    thumbnailType.setFormat("Format");

    // Assert
    List<AbstractField> allProperties = thumbnailType.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ChoiceType);
    assertEquals("Format", ((ChoiceType) getResult).getStringValue());
    assertEquals("Format", thumbnailType.getFormat());
    assertEquals("Format", ((ChoiceType) getResult).getRawValue());
    assertEquals("Format", ((ChoiceType) getResult).getValue());
    assertEquals("xmpGImg", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(ThumbnailType.FORMAT, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }
}
