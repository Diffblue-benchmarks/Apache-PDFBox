package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class DimensionsTypeDiffblueTest {
  /**
   * Method under test: {@link DimensionsType#DimensionsType(XMPMetadata)}
   */
  @Test
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
    List<AbstractField> allProperties = actualDimensionsType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualDimensionsType.getAllAttributes().isEmpty());
    assertTrue(actualDimensionsType.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualDimensionsType.getContainer().getAllProperties());
    assertSame(metadata, actualDimensionsType.getMetadata());
  }
}
