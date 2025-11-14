package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GlyphDataDiffblueTest {
  @Mock private GlyfDescript glyfDescript;

  @InjectMocks private GlyphData glyphData;

  /**
   * Test {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then {@link GlyphData} (default constructor) Description {@link GlyfCompositeDescript}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#initData(GlyphTable, TTFDataStream, int, int)}
   */
  @Test
  @DisplayName(
      "Test initData(GlyphTable, TTFDataStream, int, int); when 'A'; then GlyphData (default constructor) Description GlyfCompositeDescript")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initData(GlyphTable, TTFDataStream, int, int)"})
  void testInitData_whenA_thenGlyphDataDescriptionGlyfCompositeDescript() throws IOException {
    // Arrange
    GlyphData glyphData = new GlyphData();
    GlyphTable glyphTable = new GlyphTable();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(
            new byte[] {
              -1,
              '\b',
              'A',
              '\b',
              'A',
              '\b',
              'A',
              '\b',
              'A',
              '\b',
              GlyfDescript.X_DUAL,
              GlyfDescript.X_DUAL,
              'A',
              '\b',
              'A',
              '\b'
            });
    RandomAccessReadDataStream data = new RandomAccessReadDataStream(inputStream);

    // Act
    glyphData.initData(glyphTable, data, 1, 1);

    // Assert
    assertTrue(glyphData.getDescription() instanceof GlyfCompositeDescript);
    assertEquals((short) -248, glyphData.getNumberOfContours());
    assertEquals(-72340168543109377L, data.readLong());
    assertEquals((short) 16648, glyphData.getXMaximum());
    assertEquals((short) 16648, glyphData.getXMinimum());
    assertEquals((short) 16648, glyphData.getYMaximum());
    assertEquals((short) 16648, glyphData.getYMinimum());
    assertEquals(16L, data.getCurrentPosition());
  }

  /**
   * Test {@link GlyphData#initEmptyData()}.
   *
   * <p>Method under test: {@link GlyphData#initEmptyData()}
   */
  @Test
  @DisplayName("Test initEmptyData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphData.initEmptyData()"})
  void testInitEmptyData() {
    // Arrange
    GlyphData glyphData = new GlyphData();

    // Act
    glyphData.initEmptyData();

    // Assert
    GeneralPath path = glyphData.getPath();
    assertTrue(path.getBounds2D() instanceof Float);
    GlyphDescription description = glyphData.getDescription();
    assertTrue(description instanceof GlyfSimpleDescript);
    assertNull(((GlyfSimpleDescript) description).getInstructions());
    assertNull(path.getCurrentPoint());
    assertEquals(0, description.getContourCount());
    assertEquals(0, description.getPointCount());
    BoundingBox boundingBox = glyphData.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(1, path.getWindingRule());
    assertFalse(description.isComposite());
  }

  /**
   * Test {@link GlyphData#getPath()}.
   *
   * <ul>
   *   <li>Given {@link GlyfDescript} {@link GlyfDescript#getPointCount()} return three.
   *   <li>Then Bounds2D return {@link Rectangle2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphData#getPath()}
   */
  @Test
  @DisplayName(
      "Test getPath(); given GlyfDescript getPointCount() return three; then Bounds2D return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath GlyphData.getPath()"})
  void testGetPath_givenGlyfDescriptGetPointCountReturnThree_thenBounds2DReturnFloat() {
    // Arrange
    when(glyfDescript.getFlags(anyInt())).thenReturn((byte) 'A');
    when(glyfDescript.getEndPtOfContours(anyInt())).thenReturn(3);
    when(glyfDescript.getXCoordinate(anyInt())).thenReturn((short) 1);
    when(glyfDescript.getYCoordinate(anyInt())).thenReturn((short) 1);
    when(glyfDescript.getPointCount()).thenReturn(3);

    // Act
    GeneralPath actualPath = glyphData.getPath();

    // Assert
    verify(glyfDescript).getEndPtOfContours(0);
    verify(glyfDescript, atLeast(1)).getFlags(anyInt());
    verify(glyfDescript).getPointCount();
    verify(glyfDescript, atLeast(1)).getXCoordinate(anyInt());
    verify(glyfDescript, atLeast(1)).getYCoordinate(anyInt());
    assertTrue(actualPath.getBounds2D() instanceof Float);
    assertNull(actualPath.getCurrentPoint());
    assertEquals(1, actualPath.getWindingRule());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphData}
   *   <li>{@link GlyphData#getBoundingBox()}
   *   <li>{@link GlyphData#getDescription()}
   *   <li>{@link GlyphData#getNumberOfContours()}
   *   <li>{@link GlyphData#getXMaximum()}
   *   <li>{@link GlyphData#getXMinimum()}
   *   <li>{@link GlyphData#getYMaximum()}
   *   <li>{@link GlyphData#getYMinimum()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlyphData.<init>()",
    "BoundingBox GlyphData.getBoundingBox()",
    "GlyphDescription GlyphData.getDescription()",
    "short GlyphData.getNumberOfContours()",
    "short GlyphData.getXMaximum()",
    "short GlyphData.getXMinimum()",
    "short GlyphData.getYMaximum()",
    "short GlyphData.getYMinimum()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphData actualGlyphData = new GlyphData();
    BoundingBox actualBoundingBox = actualGlyphData.getBoundingBox();
    GlyphDescription actualDescription = actualGlyphData.getDescription();
    short actualNumberOfContours = actualGlyphData.getNumberOfContours();
    short actualXMaximum = actualGlyphData.getXMaximum();
    short actualXMinimum = actualGlyphData.getXMinimum();
    short actualYMaximum = actualGlyphData.getYMaximum();

    // Assert
    assertNull(actualDescription);
    assertNull(actualBoundingBox);
    assertEquals((short) 0, actualNumberOfContours);
    assertEquals((short) 0, actualXMaximum);
    assertEquals((short) 0, actualXMinimum);
    assertEquals((short) 0, actualYMaximum);
    assertEquals((short) 0, actualGlyphData.getYMinimum());
  }
}
