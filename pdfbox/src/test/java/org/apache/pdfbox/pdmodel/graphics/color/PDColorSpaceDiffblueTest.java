package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
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
import org.apache.pdfbox.pdmodel.MissingResourceException;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDColorSpaceDiffblueTest {
  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with
   * {@code colorSpace}, {@code resources}, {@code wasDefault}.
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'")
  void testCreateWithColorSpaceResourcesWasDefault() throws IOException {
    // Arrange
    COSObject colorSpace = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with
   * {@code colorSpace}, {@code resources}, {@code wasDefault}.
   * <ul>
   *   <li>Then throw {@link MissingResourceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; then throw MissingResourceException")
  void testCreateWithColorSpaceResourcesWasDefault_thenThrowMissingResourceException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(MissingResourceException.class, () -> PDColorSpace.create(COSName.A, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with
   * {@code colorSpace}, {@code resources}, {@code wasDefault}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when COSArray(); then throw IOException")
  void testCreateWithColorSpaceResourcesWasDefault_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with
   * {@code colorSpace}, {@code resources}, {@code wasDefault}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when COSDictionary()")
  void testCreateWithColorSpaceResourcesWasDefault_whenCOSDictionary() throws IOException {
    // Arrange
    COSDictionary colorSpace = new COSDictionary();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with
   * {@code colorSpace}, {@code resources}, {@code wasDefault}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when COSStream(); then throw IOException")
  void testCreateWithColorSpaceResourcesWasDefault_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    COSStream colorSpace = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with
   * {@code colorSpace}, {@code resources}, {@code wasDefault}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when FALSE; then throw IOException")
  void testCreateWithColorSpaceResourcesWasDefault_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources, boolean)} with
   * {@code colorSpace}, {@code resources}, {@code wasDefault}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources, boolean) with 'colorSpace', 'resources', 'wasDefault'; when ONE; then throw IOException")
  void testCreateWithColorSpaceResourcesWasDefault_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE, new PDResources(), true));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE, new PDResources(), true));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with
   * {@code colorSpace}, {@code resources}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then throw {@link MissingResourceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when A; then throw MissingResourceException")
  void testCreateWithColorSpaceResources_whenA_thenThrowMissingResourceException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(MissingResourceException.class, () -> PDColorSpace.create(COSName.A, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with
   * {@code colorSpace}, {@code resources}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when COSArray(); then throw IOException")
  void testCreateWithColorSpaceResources_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with
   * {@code colorSpace}, {@code resources}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when COSDictionary(); then throw IOException")
  void testCreateWithColorSpaceResources_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    COSDictionary colorSpace = new COSDictionary();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with
   * {@code colorSpace}, {@code resources}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when COSObjectKey(long, int) with num is one and gen is one")
  void testCreateWithColorSpaceResources_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSObject colorSpace = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with
   * {@code colorSpace}, {@code resources}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when COSStream(); then throw IOException")
  void testCreateWithColorSpaceResources_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    COSStream colorSpace = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with
   * {@code colorSpace}, {@code resources}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when FALSE; then throw IOException")
  void testCreateWithColorSpaceResources_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase, PDResources)} with
   * {@code colorSpace}, {@code resources}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSBase, PDResources) with 'colorSpace', 'resources'; when ONE; then throw IOException")
  void testCreateWithColorSpaceResources_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE, new PDResources()));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE, new PDResources()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; given FALSE; when COSArray() add FALSE; then throw IOException")
  void testCreateWithColorSpace_givenFalse_whenCOSArrayAddFalse_thenThrowIOException() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then throw {@link MissingResourceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when A; then throw MissingResourceException")
  void testCreateWithColorSpace_whenA_thenThrowMissingResourceException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(MissingResourceException.class, () -> PDColorSpace.create(COSName.A));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when COSArray(); then throw IOException")
  void testCreateWithColorSpace_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSArray()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when COSDictionary(); then throw IOException")
  void testCreateWithColorSpace_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSDictionary()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when COSObjectKey(long, int) with num is one and gen is one")
  void testCreateWithColorSpace_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> PDColorSpace.create(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when COSStream(); then throw IOException")
  void testCreateWithColorSpace_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSStream()));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when FALSE; then throw IOException")
  void testCreateWithColorSpace_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDColorSpace#create(COSBase)} with {@code colorSpace}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase) with 'colorSpace'; when ONE; then throw IOException")
  void testCreateWithColorSpace_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE));
  }

  /**
   * Test {@link PDColorSpace#getCOSObject()}.
   * <ul>
   *   <li>Given {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return {@link COSName#DEVICEGRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject(); given INSTANCE; then return DEVICEGRAY")
  void testGetCOSObject_givenInstance_thenReturnDevicegray() {
    // Arrange
    PDDeviceGray pdDeviceGray = PDDeviceGray.INSTANCE;

    // Act
    COSBase actualCOSObject = pdDeviceGray.getCOSObject();

    // Assert
    COSName cosName = ((COSName) actualCOSObject).DEVICEGRAY;
    assertSame(cosName, actualCOSObject);
    assertSame(cosName, pdDeviceGray.getCOSObject());
  }

  /**
   * Test {@link PDColorSpace#getCOSObject()}.
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return {@link PDCalGray#PDCalGray()}
   * {@link PDColorSpace#array}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColorSpace#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject(); given PDCalGray(); then return PDCalGray() array")
  void testGetCOSObject_givenPDCalGray_thenReturnPDCalGrayArray() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act and Assert
    assertSame(pdCalGray.array, pdCalGray.getCOSObject());
  }
}
