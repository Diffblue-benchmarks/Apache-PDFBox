package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.jaiimageio.impl.common.BogusColorSpace;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.color.PDJPXColorSpace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecodeResultDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link BogusColorSpace#BogusColorSpace(int)} with numComponents is
   * ten.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DecodeResult#DecodeResult(COSDictionary, PDJPXColorSpace)}
   *   <li>{@link DecodeResult#setColorSpace(PDJPXColorSpace)}
   *   <li>{@link DecodeResult#setJPXSMask(BufferedImage)}
   *   <li>{@link DecodeResult#getJPXColorSpace()}
   *   <li>{@link DecodeResult#getJPXSMask()}
   *   <li>{@link DecodeResult#getParameters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when BogusColorSpace(int) with numComponents is ten")
  void testGettersAndSetters_whenBogusColorSpaceWithNumComponentsIsTen() {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = new DecodeResult(parameters, new PDJPXColorSpace(new BogusColorSpace(10)));
    PDJPXColorSpace colorSpace = new PDJPXColorSpace(new BogusColorSpace(10));
    actualDecodeResult.setColorSpace(colorSpace);
    BufferedImage smask = new BufferedImage(1, 1, 1);

    actualDecodeResult.setJPXSMask(smask);
    PDJPXColorSpace actualJPXColorSpace = actualDecodeResult.getJPXColorSpace();
    BufferedImage actualJPXSMask = actualDecodeResult.getJPXSMask();

    // Assert that nothing has changed
    assertSame(smask, actualJPXSMask);
    assertSame(parameters, actualDecodeResult.getParameters());
    assertSame(colorSpace, actualJPXColorSpace);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DecodeResult#DecodeResult(COSDictionary)}
   *   <li>{@link DecodeResult#setColorSpace(PDJPXColorSpace)}
   *   <li>{@link DecodeResult#setJPXSMask(BufferedImage)}
   *   <li>{@link DecodeResult#getJPXColorSpace()}
   *   <li>{@link DecodeResult#getJPXSMask()}
   *   <li>{@link DecodeResult#getParameters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSDictionary()")
  void testGettersAndSetters_whenCOSDictionary() {
    // Arrange
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = new DecodeResult(parameters);
    PDJPXColorSpace colorSpace = new PDJPXColorSpace(new BogusColorSpace(10));
    actualDecodeResult.setColorSpace(colorSpace);
    BufferedImage smask = new BufferedImage(1, 1, 1);

    actualDecodeResult.setJPXSMask(smask);
    PDJPXColorSpace actualJPXColorSpace = actualDecodeResult.getJPXColorSpace();
    BufferedImage actualJPXSMask = actualDecodeResult.getJPXSMask();

    // Assert that nothing has changed
    assertSame(smask, actualJPXSMask);
    assertSame(parameters, actualDecodeResult.getParameters());
    assertSame(colorSpace, actualJPXColorSpace);
  }

  /**
   * Test {@link DecodeResult#createDefault()}.
   * <p>
   * Method under test: {@link DecodeResult#createDefault()}
   */
  @Test
  @DisplayName("Test createDefault()")
  void testCreateDefault() {
    // Arrange and Act
    DecodeResult actualCreateDefaultResult = DecodeResult.createDefault();

    // Assert
    assertNull(actualCreateDefaultResult.getJPXSMask());
    COSDictionary parameters = actualCreateDefaultResult.getParameters();
    COSUpdateState updateState = parameters.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(parameters.getKey());
    assertNull(actualCreateDefaultResult.getJPXColorSpace());
    assertEquals(0, parameters.size());
    COSIncrement toIncrementResult = parameters.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(parameters.isDirect());
    assertFalse(parameters.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(parameters.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
