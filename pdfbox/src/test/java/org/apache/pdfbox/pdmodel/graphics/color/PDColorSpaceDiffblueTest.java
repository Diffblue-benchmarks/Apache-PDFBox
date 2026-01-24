package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.color.ICC_Profile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.MissingResourceException;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDColorSpaceDiffblueTest {
  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    colorSpace.add((COSBase) object);
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream colorSpace =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources() throws IOException {
    // Arrange
    COSObject colorSpace = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources2() throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject colorSpace = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources3() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream colorSpace =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault() throws IOException {
    // Arrange
    COSObject colorSpace = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault2() throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject colorSpace = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault3() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream colorSpace =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; then COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_thenCOSObjectReturnCOSArray()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult =
        PDColorSpace.create(COSName.PATTERN, new PDResources(), false);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualCreateResult instanceof PDPattern);
    assertEquals("Pattern", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(((PDPattern) actualCreateResult).getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(COSName.PATTERN, getResult);
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Then return {@link PDDeviceCMYK}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; then return PDDeviceCMYK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_thenReturnPDDeviceCMYK() throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult =
        PDColorSpace.create(COSName.DEVICECMYK, new PDResources(), false);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceCMYK);
    assertEquals("DeviceCMYK", ((COSName) cOSObject).getName());
    assertEquals("DeviceCMYK", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    ICC_Profile iCCProfile = ((PDDeviceCMYK) actualCreateResult).getICCProfile();
    assertEquals(0, iCCProfile.getProfileClass());
    assertEquals(1, iCCProfile.getPCSType());
    assertEquals(2, iCCProfile.getMajorVersion());
    assertEquals(4, iCCProfile.getNumComponents());
    assertEquals(4, actualCreateResult.getNumberOfComponents());
    assertEquals(8532, iCCProfile.getData().length);
    assertEquals(9, iCCProfile.getColorSpaceType());
    assertFalse(initialColor.isPattern());
    assertEquals(Short.SIZE, iCCProfile.getMinorVersion());
    assertSame(((PDDeviceCMYK) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICECMYK, cOSObject);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Then return {@link PDDeviceGray}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; then return PDDeviceGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_thenReturnPDDeviceGray() throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult =
        PDColorSpace.create(COSName.DEVICEGRAY, new PDResources(), false);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(((PDDeviceGray) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICEGRAY, cOSObject);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_thenThrowMissingResourceException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        MissingResourceException.class,
        () -> PDColorSpace.create(COSName.A, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when COSArray(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenCOSArray_thenThrowIOException()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenCOSDictionary() throws IOException {
    // Arrange
    COSDictionary colorSpace = new COSDictionary();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenCOSStream_thenThrowIOException()
      throws IOException {
    // Arrange
    COSStream colorSpace = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICERGB}.
   *   <li>Then return {@link PDDeviceRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when DEVICERGB; then return PDDeviceRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenDevicergb_thenReturnPDDeviceRGB()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult =
        PDColorSpace.create(COSName.DEVICERGB, new PDResources(), false);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(3, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(((PDDeviceRGB) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICERGB, cOSObject);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenFalse_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link PDDeviceCMYK}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when 'null'; then return PDDeviceCMYK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenNull_thenReturnPDDeviceCMYK()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICECMYK, null, false);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceCMYK);
    assertEquals("DeviceCMYK", ((COSName) cOSObject).getName());
    assertEquals("DeviceCMYK", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    ICC_Profile iCCProfile = ((PDDeviceCMYK) actualCreateResult).getICCProfile();
    assertEquals(0, iCCProfile.getProfileClass());
    assertEquals(1, iCCProfile.getPCSType());
    assertEquals(2, iCCProfile.getMajorVersion());
    assertEquals(4, iCCProfile.getNumComponents());
    assertEquals(4, actualCreateResult.getNumberOfComponents());
    assertEquals(8532, iCCProfile.getData().length);
    assertEquals(9, iCCProfile.getColorSpaceType());
    assertFalse(initialColor.isPattern());
    assertEquals(Short.SIZE, iCCProfile.getMinorVersion());
    assertSame(((PDDeviceCMYK) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICECMYK, cOSObject);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenOne_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> PDColorSpace.create(COSFloat.ONE, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with {@code colorSpace}, {@code
   * resources}, {@code wasDefault}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources, boolean)"})
  void testCreateWithColorSpaceResourcesWasDefault_whenOne_thenThrowIOException2()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> PDColorSpace.create(COSInteger.ONE, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; given FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_givenFalse() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when A; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenA_thenThrowMissingResourceException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        MissingResourceException.class, () -> PDColorSpace.create(COSName.A, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when COSArray(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when COSDictionary(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenCOSDictionary_thenThrowIOException()
      throws IOException {
    // Arrange
    COSDictionary colorSpace = new COSDictionary();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    COSStream colorSpace = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICECMYK}.
   *   <li>Then return {@link PDDeviceCMYK}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when DEVICECMYK; then return PDDeviceCMYK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenDevicecmyk_thenReturnPDDeviceCMYK()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICECMYK, new PDResources());

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceCMYK);
    assertEquals("DeviceCMYK", ((COSName) cOSObject).getName());
    assertEquals("DeviceCMYK", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    ICC_Profile iCCProfile = ((PDDeviceCMYK) actualCreateResult).getICCProfile();
    assertEquals(0, iCCProfile.getProfileClass());
    assertEquals(1, iCCProfile.getPCSType());
    assertEquals(2, iCCProfile.getMajorVersion());
    assertEquals(4, iCCProfile.getNumComponents());
    assertEquals(4, actualCreateResult.getNumberOfComponents());
    assertEquals(8532, iCCProfile.getData().length);
    assertEquals(9, iCCProfile.getColorSpaceType());
    assertFalse(initialColor.isPattern());
    assertEquals(Short.SIZE, iCCProfile.getMinorVersion());
    assertSame(((PDDeviceCMYK) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICECMYK, cOSObject);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICEGRAY}.
   *   <li>Then return {@link PDDeviceGray}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when DEVICEGRAY; then return PDDeviceGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenDevicegray_thenReturnPDDeviceGray()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICEGRAY, new PDResources());

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(((PDDeviceGray) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICEGRAY, cOSObject);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICERGB}.
   *   <li>Then return {@link PDDeviceRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when DEVICERGB; then return PDDeviceRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenDevicergb_thenReturnPDDeviceRGB() throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICERGB, new PDResources());

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(3, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(((PDDeviceRGB) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICERGB, cOSObject);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link PDDeviceCMYK}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when 'null'; then return PDDeviceCMYK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenNull_thenReturnPDDeviceCMYK() throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICECMYK, null);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceCMYK);
    assertEquals("DeviceCMYK", ((COSName) cOSObject).getName());
    assertEquals("DeviceCMYK", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    ICC_Profile iCCProfile = ((PDDeviceCMYK) actualCreateResult).getICCProfile();
    assertEquals(0, iCCProfile.getProfileClass());
    assertEquals(1, iCCProfile.getPCSType());
    assertEquals(2, iCCProfile.getMajorVersion());
    assertEquals(4, iCCProfile.getNumComponents());
    assertEquals(4, actualCreateResult.getNumberOfComponents());
    assertEquals(8532, iCCProfile.getData().length);
    assertEquals(9, iCCProfile.getColorSpaceType());
    assertFalse(initialColor.isPattern());
    assertEquals(Short.SIZE, iCCProfile.getMinorVersion());
    assertSame(((PDDeviceCMYK) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICECMYK, cOSObject);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenOne_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with {@code colorSpace}, {@code
   * resources}.
   *
   * <ul>
   *   <li>When {@link COSName#PATTERN}.
   *   <li>Then COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when PATTERN; then COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase, PDResources)"})
  void testCreateWithColorSpaceResources_whenPattern_thenCOSObjectReturnCOSArray()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.PATTERN, new PDResources());

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualCreateResult instanceof PDPattern);
    assertEquals("Pattern", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(((PDPattern) actualCreateResult).getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(COSName.PATTERN, getResult);
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       add {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; given A; when COSArray(List) with cosObjectables is ArrayList() add A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenA_whenCOSArrayWithCosObjectablesIsArrayListAddA()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.A);
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    colorSpace.add((COSBase) object);
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#CALGRAY}.
   *   <li>Then return COSObject toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; given CALGRAY; then return COSObject toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenCalgray_thenReturnCOSObjectToListSizeIsTwo()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.CALGRAY);
    colorSpace.add((COSBase) new COSDictionary());

    // Act
    PDColorSpace actualCreateResult = PDColorSpace.create(colorSpace);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualCreateResult instanceof PDCalGray);
    assertEquals("CalGray", ((COSName) getResult).getName());
    assertEquals("CalGray", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualCreateResult.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualCreateResult).getGamma());
    assertFalse(initialColor.isPattern());
    assertSame(actualCreateResult, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#CALRGB}.
   *   <li>Then BlackPoint COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; given CALRGB; then BlackPoint COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenCalrgb_thenBlackPointCOSObjectReturnCOSArray()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.CALRGB);
    colorSpace.add((COSBase) new COSDictionary());

    // Act
    PDColorSpace actualCreateResult = PDColorSpace.create(colorSpace);

    // Assert
    assertTrue(((PDCalRGB) actualCreateResult).getBlackPoint().getCOSObject() instanceof COSArray);
    assertTrue(((PDCalRGB) actualCreateResult).getWhitepoint().getCOSObject() instanceof COSArray);
    assertTrue(actualCreateResult instanceof PDCalRGB);
    assertEquals("CalRGB", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDGamma gamma = ((PDCalRGB) actualCreateResult).getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(3, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(actualCreateResult, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualCreateResult).getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#DEVICECMYK}.
   *   <li>Then return COSObject Name is {@code DeviceCMYK}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; given DEVICECMYK; then return COSObject Name is 'DeviceCMYK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenDevicecmyk_thenReturnCOSObjectNameIsDeviceCMYK()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.DEVICECMYK);
    colorSpace.add(COSBoolean.FALSE);

    // Act
    PDColorSpace actualCreateResult = PDColorSpace.create(colorSpace);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceCMYK);
    assertEquals("DeviceCMYK", ((COSName) cOSObject).getName());
    assertEquals("DeviceCMYK", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    ICC_Profile iCCProfile = ((PDDeviceCMYK) actualCreateResult).getICCProfile();
    assertEquals(0, iCCProfile.getProfileClass());
    assertEquals(1, iCCProfile.getPCSType());
    assertEquals(2, iCCProfile.getMajorVersion());
    assertEquals(4, iCCProfile.getNumComponents());
    assertEquals(4, actualCreateResult.getNumberOfComponents());
    assertEquals(8532, iCCProfile.getData().length);
    assertEquals(9, iCCProfile.getColorSpaceType());
    assertFalse(initialColor.isPattern());
    assertEquals(Short.SIZE, iCCProfile.getMinorVersion());
    assertSame(((PDDeviceCMYK) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#DEVICEGRAY}.
   *   <li>Then return COSObject Name is {@code DeviceGray}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; given DEVICEGRAY; then return COSObject Name is 'DeviceGray'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenDevicegray_thenReturnCOSObjectNameIsDeviceGray()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.DEVICEGRAY);
    colorSpace.add(COSBoolean.FALSE);

    // Act
    PDColorSpace actualCreateResult = PDColorSpace.create(colorSpace);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(((PDDeviceGray) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#DEVICERGB}.
   *   <li>Then return COSObject Name is {@code DeviceRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; given DEVICERGB; then return COSObject Name is 'DeviceRGB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenDevicergb_thenReturnCOSObjectNameIsDeviceRGB()
      throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.DEVICERGB);
    colorSpace.add(COSBoolean.FALSE);

    // Act
    PDColorSpace actualCreateResult = PDColorSpace.create(colorSpace);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(actualCreateResult instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(3, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(((PDDeviceRGB) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; given FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenFalse() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#INDEXED}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; given INDEXED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenIndexed() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.INDEXED);
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#LAB}.
   *   <li>Then return {@link PDLab}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; given LAB; then return PDLab")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenLab_thenReturnPDLab() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.LAB);
    colorSpace.add((COSBase) new COSDictionary());

    // Act
    PDColorSpace actualCreateResult = PDColorSpace.create(colorSpace);

    // Assert
    assertTrue(actualCreateResult instanceof PDLab);
    assertEquals("Lab", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDRange aRange = ((PDLab) actualCreateResult).getARange();
    assertEquals(-100.0f, aRange.getMin());
    PDRange bRange = ((PDLab) actualCreateResult).getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(100.0f, aRange.getMax());
    assertEquals(100.0f, bRange.getMax());
    assertEquals(3, actualCreateResult.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(actualCreateResult, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>Given {@link COSName#PATTERN}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; given PATTERN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_givenPattern() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray(new ArrayList<>());
    colorSpace.add(COSName.PATTERN);
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; when A; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenA_thenThrowMissingResourceException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(MissingResourceException.class, () -> PDColorSpace.create(COSName.A));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when COSArray(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSArray()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; when COSDictionary(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSDictionary()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSObject colorSpace = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSStream()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICECMYK}.
   *   <li>Then return COSObject is {@link COSName#DEVICECMYK}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; when DEVICECMYK; then return COSObject is DEVICECMYK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenDevicecmyk_thenReturnCOSObjectIsDevicecmyk()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICECMYK);

    // Assert
    assertTrue(actualCreateResult instanceof PDDeviceCMYK);
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertSame(((PDDeviceCMYK) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICECMYK, actualCreateResult.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICEGRAY}.
   *   <li>Then return COSObject is {@link COSName#DEVICEGRAY}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; when DEVICEGRAY; then return COSObject is DEVICEGRAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenDevicegray_thenReturnCOSObjectIsDevicegray()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICEGRAY);

    // Assert
    assertTrue(actualCreateResult instanceof PDDeviceGray);
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertSame(((PDDeviceGray) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICEGRAY, actualCreateResult.getCOSObject());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSName#DEVICERGB}.
   *   <li>Then return COSObject is {@link COSName#DEVICERGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; when DEVICERGB; then return COSObject is DEVICERGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenDevicergb_thenReturnCOSObjectIsDevicergb() throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.DEVICERGB);

    // Assert
    assertTrue(actualCreateResult instanceof PDDeviceRGB);
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertSame(((PDDeviceRGB) actualCreateResult).INSTANCE, initialColor.getColorSpace());
    assertSame(COSName.DEVICERGB, actualCreateResult.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenOne_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   *
   * <ul>
   *   <li>When {@link COSName#PATTERN}.
   *   <li>Then return COSObject toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase) with 'colorSpace'; when PATTERN; then return COSObject toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDColorSpace.create(COSBase)"})
  void testCreateWithColorSpace_whenPattern_thenReturnCOSObjectToListSizeIsOne()
      throws IOException {
    // Arrange and Act
    PDColorSpace actualCreateResult = PDColorSpace.create(COSName.PATTERN);

    // Assert
    COSBase cOSObject = actualCreateResult.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualCreateResult instanceof PDPattern);
    assertEquals("Pattern", ((COSName) getResult).getName());
    assertEquals("Pattern", actualCreateResult.getName());
    PDColor initialColor = actualCreateResult.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(((PDPattern) actualCreateResult).getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(COSName.PATTERN, getResult);
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColorSpace#getCOSObject()}.
   *
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.
   *   <li>Then return {@link PDCalGray#PDCalGray()} {@link PDColorSpace#array}.
   * </ul>
   *
   * <p>Method under test: {@link PDColorSpace#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject(); given PDCalGray(); then return PDCalGray() array")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDColorSpace.getCOSObject()"})
  void testGetCOSObject_givenPDCalGray_thenReturnPDCalGrayArray() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    COSBase actualCOSObject = pdCalGray.getCOSObject();

    // Assert
    assertSame(pdCalGray.array, actualCOSObject);
  }
}
