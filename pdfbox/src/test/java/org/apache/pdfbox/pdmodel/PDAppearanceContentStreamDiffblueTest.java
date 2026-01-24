package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceN;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAppearanceContentStreamDiffblueTest {
  /**
   * Test {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream,
   * OutputStream)}.
   *
   * <p>Method under test: {@link
   * PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, OutputStream)}
   */
  @Test
  @DisplayName("Test new PDAppearanceContentStream(PDAppearanceStream, OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.<init>(PDAppearanceStream, OutputStream)"})
  void testNewPDAppearanceContentStream() {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    PDAppearanceContentStream actualPdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Assert
    assertNull(actualPdAppearanceContentStream.document);
    assertNull(actualPdAppearanceContentStream.resources);
    assertFalse(actualPdAppearanceContentStream.inTextMode);
    assertTrue(actualPdAppearanceContentStream.fontStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.strokingColorSpaceStack.isEmpty());
    assertArrayEquals(
        new byte[] {},
        ((ByteArrayOutputStream) actualPdAppearanceContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}.
   *
   * <p>Method under test: {@link
   * PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}
   */
  @Test
  @DisplayName("Test new PDAppearanceContentStream(PDAppearanceStream, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.<init>(PDAppearanceStream, boolean)"})
  void testNewPDAppearanceContentStream2() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    new PDAppearanceContentStream(appearance, true);

    // Assert
    COSStream cOSObject = appearance.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertNull(filters.getKey());
    List<COSName> filters2 = appearance.getContentStream().getFilters();
    assertEquals(1, filters2.size());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(((COSName) filters).isEmpty());
    assertTrue(filters.isDirect());
    assertEquals(filters2, appearance.getStream().getFilters());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Test {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}.
   *
   * <p>Method under test: {@link
   * PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream, boolean)}
   */
  @Test
  @DisplayName("Test new PDAppearanceContentStream(PDAppearanceStream, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.<init>(PDAppearanceStream, boolean)"})
  void testNewPDAppearanceContentStream3() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    new PDAppearanceContentStream(appearance, false);

    // Assert that nothing has changed
    COSStream cOSObject = appearance.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)}.
   *
   * <ul>
   *   <li>Then return {@link PDAbstractContentStream#document} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test new PDAppearanceContentStream(PDAppearanceStream); then return document is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.<init>(PDAppearanceStream)"})
  void testNewPDAppearanceContentStream_thenReturnDocumentIsNull() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());

    // Act
    PDAppearanceContentStream actualPdAppearanceContentStream =
        new PDAppearanceContentStream(appearance);

    // Assert
    assertNull(actualPdAppearanceContentStream.document);
    assertNull(actualPdAppearanceContentStream.resources);
    assertFalse(actualPdAppearanceContentStream.inTextMode);
    assertTrue(actualPdAppearanceContentStream.fontStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdAppearanceContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(appearance.getCOSObject().hasData());
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand2() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
    byte[] expectedToByteArrayResult = "0 G\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdAppearanceContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand3() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand4() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {9.223372E18f, -9.223372E18f, 9.223372E18f, -9.223372E18f},
            PDDeviceGray.INSTANCE);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand5() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    pdAppearanceContentStream.setMaximumFractionDigits(10);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand6() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {9.223372E18f, -9.223372E18f, 9.223372E18f, -9.223372E18f},
            PDDeviceRGB.INSTANCE);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand7() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(new float[] {9.223372E18f, -9.223372E18f, 9.223372E18f, -9.223372E18f}, null);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand8() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {0.5f, -9.223372E18f, 9.223372E18f, -9.223372E18f}, PDDeviceGray.INSTANCE);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand9() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {-0.5f, -9.223372E18f, 9.223372E18f, -9.223372E18f}, PDDeviceGray.INSTANCE);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand_givenArrayList() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(new ArrayList<>());
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertFalse(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor); given ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand_givenArrayListAddFoo() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    ArrayList<String> names = new ArrayList<>();
    names.add("foo");

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(names);
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor); given ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand_givenArrayListAddFoo2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    ArrayList<String> names = new ArrayList<>();
    names.add("foo");
    names.add("foo");

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(names);
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {Float.NaN, -9.223372E18f, 9.223372E18f, -9.223372E18f},
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdAppearanceContentStream.setStrokingColorOnDemand(color));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setStrokingColorOnDemand(PDColor); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand_whenNull_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
            .setStrokingColorOnDemand(null));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setStrokingColorOnDemand(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsNull()
      throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color = new PDColor(new COSArray(), null);

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertFalse(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDPattern#PDPattern(PDResources)} with resources is {@link
   *       PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setStrokingColorOnDemand(PDColor); when PDPattern(PDResources) with resources is PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setStrokingColorOnDemand(PDColor)"})
  void testSetStrokingColorOnDemand_whenPDPatternWithResourcesIsPDResources() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    COSArray array = new COSArray();
    PDColor color = new PDColor(array, new PDPattern(new PDResources()));

    // Act
    boolean actualSetStrokingColorOnDemandResult =
        pdAppearanceContentStream.setStrokingColorOnDemand(color);

    // Assert
    assertFalse(actualSetStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName("Test setStrokingColor(float[]) with 'float[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act
    pdAppearanceContentStream.setStrokingColor(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    byte[] expectedToByteArrayResult = "10 0 10 0 K\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdAppearanceContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName("Test setStrokingColor(float[]) with 'float[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    pdAppearanceContentStream.setMaximumFractionDigits(10);

    // Act and Assert
    assertDoesNotThrow(
        () -> pdAppearanceContentStream.setStrokingColor(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName("Test setStrokingColor(float[]) with 'float[]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setStrokingColor(new float[] {Float.NaN, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code 0.5} and zero.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setStrokingColor(float[]) with 'float[]'; when array of float with '0.5' and zero; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat_whenArrayOfFloatWith05AndZero_thenDoesNotThrow()
      throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setStrokingColor(new float[] {0.5f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code -0.5} and zero.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setStrokingColor(float[]) with 'float[]'; when array of float with '-0.5' and zero; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat_whenArrayOfFloatWith05AndZero_thenDoesNotThrow2()
      throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setStrokingColor(new float[] {-0.5f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code 9.223372E18} and ten.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setStrokingColor(float[]) with 'float[]'; when array of float with '9.223372E18' and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat_whenArrayOfFloatWith9223372e18AndTen() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setStrokingColor(
                    new float[] {
                      9.223372E18f,
                      10.0f,
                      9.223372E18f,
                      10.0f,
                      9.223372E18f,
                      10.0f,
                      9.223372E18f,
                      10.0f
                    }));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code -9.223372E18} and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setStrokingColor(float[]) with 'float[]'; when array of float with '-9.223372E18' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat_whenArrayOfFloatWith9223372e18AndZero() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setStrokingColor(new float[] {-9.223372E18f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with ten and zero.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setStrokingColor(float[]) with 'float[]'; when array of float with ten and zero; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat_whenArrayOfFloatWithTenAndZero_thenDoesNotThrow()
      throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setStrokingColor(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When empty array of {@code float}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setStrokingColor(float[]) with 'float[]'; when empty array of float; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setStrokingColor(float[])"})
  void testSetStrokingColorWithFloat_whenEmptyArrayOfFloat_thenDoesNotThrow() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setStrokingColor(new float[] {}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color = new PDColor(new COSArray(), null);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertFalse(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand3() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
    byte[] expectedToByteArrayResult = "0 g\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdAppearanceContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand4() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand5() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {9.223372E18f, -9.223372E18f, 9.223372E18f, -9.223372E18f},
            PDDeviceGray.INSTANCE);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand6() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    pdAppearanceContentStream.setMaximumFractionDigits(10);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(
            new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand7() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {9.223372E18f, -9.223372E18f, 9.223372E18f, -9.223372E18f},
            PDDeviceRGB.INSTANCE);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand8() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(new float[] {9.223372E18f, -9.223372E18f, 9.223372E18f, -9.223372E18f}, null);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand9() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {0.5f, -9.223372E18f, 9.223372E18f, -9.223372E18f}, PDDeviceGray.INSTANCE);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand10() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {-0.5f, -9.223372E18f, 9.223372E18f, -9.223372E18f}, PDDeviceGray.INSTANCE);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand_givenArrayList() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(new ArrayList<>());
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertFalse(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor); given ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand_givenArrayListAddFoo() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    ArrayList<String> names = new ArrayList<>();
    names.add("foo");

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(names);
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor); given ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand_givenArrayListAddFoo2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    ArrayList<String> names = new ArrayList<>();
    names.add("foo");
    names.add("foo");

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(names);
    PDColor color = new PDColor(new COSArray(), colorSpace);

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertTrue(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDColor color =
        new PDColor(
            new float[] {Float.NaN, -9.223372E18f, 9.223372E18f, -9.223372E18f},
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdAppearanceContentStream.setNonStrokingColorOnDemand(color));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorOnDemand(PDColor); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand_whenNull_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
            .setNonStrokingColorOnDemand(null));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDPattern#PDPattern(PDResources)} with resources is {@link
   *       PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColorOnDemand(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColorOnDemand(PDColor); when PDPattern(PDResources) with resources is PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAppearanceContentStream.setNonStrokingColorOnDemand(PDColor)"})
  void testSetNonStrokingColorOnDemand_whenPDPatternWithResourcesIsPDResources()
      throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    COSArray array = new COSArray();
    PDColor color = new PDColor(array, new PDPattern(new PDResources()));

    // Act
    boolean actualSetNonStrokingColorOnDemandResult =
        pdAppearanceContentStream.setNonStrokingColorOnDemand(color);

    // Assert
    assertFalse(actualSetNonStrokingColorOnDemandResult);
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName("Test setNonStrokingColor(float[]) with 'float[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act
    pdAppearanceContentStream.setNonStrokingColor(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    byte[] expectedToByteArrayResult = "10 0 10 0 k\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdAppearanceContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName("Test setNonStrokingColor(float[]) with 'float[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    pdAppearanceContentStream.setMaximumFractionDigits(10);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdAppearanceContentStream.setNonStrokingColor(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColor(float[]) with 'float[]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setNonStrokingColor(new float[] {Float.NaN, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code 0.5} and zero.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColor(float[]) with 'float[]'; when array of float with '0.5' and zero; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat_whenArrayOfFloatWith05AndZero_thenDoesNotThrow()
      throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setNonStrokingColor(new float[] {0.5f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code -0.5} and zero.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColor(float[]) with 'float[]'; when array of float with '-0.5' and zero; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat_whenArrayOfFloatWith05AndZero_thenDoesNotThrow2()
      throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setNonStrokingColor(new float[] {-0.5f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code 9.223372E18} and ten.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColor(float[]) with 'float[]'; when array of float with '9.223372E18' and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat_whenArrayOfFloatWith9223372e18AndTen() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setNonStrokingColor(
                    new float[] {
                      9.223372E18f,
                      10.0f,
                      9.223372E18f,
                      10.0f,
                      9.223372E18f,
                      10.0f,
                      9.223372E18f,
                      10.0f
                    }));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with {@code -9.223372E18} and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColor(float[]) with 'float[]'; when array of float with '-9.223372E18' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat_whenArrayOfFloatWith9223372e18AndZero() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setNonStrokingColor(new float[] {-9.223372E18f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When array of {@code float} with ten and zero.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColor(float[]) with 'float[]'; when array of float with ten and zero; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat_whenArrayOfFloatWithTenAndZero_thenDoesNotThrow()
      throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setNonStrokingColor(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setNonStrokingColor(float[])} with {@code float[]}.
   *
   * <ul>
   *   <li>When empty array of {@code float}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setNonStrokingColor(float[])}
   */
  @Test
  @DisplayName(
      "Test setNonStrokingColor(float[]) with 'float[]'; when empty array of float; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setNonStrokingColor(float[])"})
  void testSetNonStrokingColorWithFloat_whenEmptyArrayOfFloat_thenDoesNotThrow()
      throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setNonStrokingColor(new float[] {}));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName("Test setBorderLine(float, PDBorderStyleDictionary, COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act
    pdAppearanceContentStream.setBorderLine(10.0f, bs, new COSArray());

    // Assert
    byte[] expectedToByteArrayResult = "10 w\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdAppearanceContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName("Test setBorderLine(float, PDBorderStyleDictionary, COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    pdAppearanceContentStream.setMaximumFractionDigits(10);
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setBorderLine(10.0f, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when '0.5'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_when05_thenDoesNotThrow() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setBorderLine(0.5f, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when '-0.5'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_when05_thenDoesNotThrow2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setBorderLine(-0.5f, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When {@code 9.223372E18}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when '9.223372E18'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_when9223372e18_thenDoesNotThrow() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertDoesNotThrow(
        () -> pdAppearanceContentStream.setBorderLine(9.223372E18f, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When {@code -9.223372E18}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when '-9.223372E18'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_when9223372e18_thenDoesNotThrow2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertDoesNotThrow(
        () -> pdAppearanceContentStream.setBorderLine(-9.223372E18f, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_whenNaN_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdAppearanceContentStream.setBorderLine(Float.NaN, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_whenNull_thenDoesNotThrow() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setBorderLine(10.0f, null, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_whenOne_thenDoesNotThrow() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setBorderLine(1.0f, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setBorderLine(float, PDBorderStyleDictionary, COSArray)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setBorderLine(float,
   * PDBorderStyleDictionary, COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorderLine(float, PDBorderStyleDictionary, COSArray); when ten; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAppearanceContentStream.setBorderLine(float, PDBorderStyleDictionary, COSArray)"
  })
  void testSetBorderLine_whenTen_thenDoesNotThrow() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    PDBorderStyleDictionary bs = new PDBorderStyleDictionary();

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setBorderLine(10.0f, bs, new COSArray()));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act
    pdAppearanceContentStream.setLineWidthOnDemand(10.0f);

    // Assert
    byte[] expectedToByteArrayResult = "10 w\n".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult,
        ((ByteArrayOutputStream) pdAppearanceContentStream.outputStream).toByteArray());
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand2() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    pdAppearanceContentStream.setMaximumFractionDigits(10);

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setLineWidthOnDemand(10.0f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand3() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    pdAppearanceContentStream.setMaximumFractionDigits(-1);

    // Act and Assert
    assertDoesNotThrow(() -> pdAppearanceContentStream.setLineWidthOnDemand(0.5f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_when05() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(0.5f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When {@code 9.223372E18}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when '9.223372E18'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_when9223372e18() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(9.223372E18f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When {@code -9.223372E18}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when '-9.223372E18'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_when9223372e182() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(-9.223372E18f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When {@code 9.223373E18}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when '9.223373E18'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_when9223373e18() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(9.223373E18f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When {@code -9.2233715E18}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when '-9.2233715E18'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_when92233715e18() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(-9.2233715E18f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_whenNaN_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(Float.NaN));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(1.0f));
  }

  /**
   * Test {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceContentStream#setLineWidthOnDemand(float)}
   */
  @Test
  @DisplayName("Test setLineWidthOnDemand(float); when ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.setLineWidthOnDemand(float)"})
  void testSetLineWidthOnDemand_whenTen() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .setLineWidthOnDemand(10.0f));
  }

  /**
   * Test {@link PDAppearanceContentStream#drawShape(float, boolean, boolean)}.
   *
   * <p>Method under test: {@link PDAppearanceContentStream#drawShape(float, boolean, boolean)}
   */
  @Test
  @DisplayName("Test drawShape(float, boolean, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceContentStream.drawShape(float, boolean, boolean)"})
  void testDrawShape() throws IOException {
    // Arrange
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act
    pdAppearanceContentStream.drawShape(10.0f, true, true);

    // Assert
    assertArrayEquals(
        new byte[] {'B', '\n'},
        ((ByteArrayOutputStream) pdAppearanceContentStream.outputStream).toByteArray());
  }
}
