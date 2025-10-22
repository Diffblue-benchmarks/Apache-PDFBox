package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DimensionsTypeDiffblueTest {
  /**
   * Test {@link DimensionsType#DimensionsType(XMPMetadata)}.
   * <p>
   * Method under test: {@link DimensionsType#DimensionsType(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new DimensionsType(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DimensionsType.<init>(XMPMetadata)"})
  void testNewDimensionsType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DimensionsType actualDimensionsType = new DimensionsType(metadata);

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/sType/Dimensions#", actualDimensionsType.getNamespace());
    assertEquals("stDim", actualDimensionsType.getPreferedPrefix());
    assertEquals("stDim", actualDimensionsType.getPrefix());
    assertNull(actualDimensionsType.getPropertyName());
    assertTrue(actualDimensionsType.getAllProperties().isEmpty());
    assertTrue(actualDimensionsType.getAllAttributes().isEmpty());
    assertTrue(actualDimensionsType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualDimensionsType.getMetadata());
  }
}
