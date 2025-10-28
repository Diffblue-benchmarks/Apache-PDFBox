package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.filter.DecodeResult;
import org.apache.pdfbox.filter.Filter;
import org.apache.pdfbox.filter.LZWFilter;
import org.junit.jupiter.api.Test;

class COSInputStreamDiffblueTest {
  /**
   * Method under test:
   * {@link COSInputStream#create(List, COSDictionary, InputStream)}
   */
  @Test
  void testCreate() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filters = new ArrayList<>();

    // Act and Assert
    byte[] byteArray = new byte[8];
    int actualReadResult = COSInputStream.create(filters, new COSDictionary(), in).read(byteArray);
    assertEquals(-1, in.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link COSInputStream#create(List, COSDictionary, InputStream, DecodeOptions)}
   */
  @Test
  void testCreate2() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filters = new ArrayList<>();

    // Act and Assert
    byte[] byteArray = new byte[8];
    int actualReadResult = COSInputStream.create(filters, new COSDictionary(), in, DecodeOptions.DEFAULT)
        .read(byteArray);
    assertEquals(-1, in.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link COSInputStream#create(List, COSDictionary, InputStream, DecodeOptions)}
   */
  @Test
  void testCreate3() throws IOException {
    // Arrange
    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(new LZWFilter());
    COSDictionary parameters = new COSDictionary();
    ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertEquals(-1, COSInputStream.create(filters, parameters, in, DecodeOptions.DEFAULT).read(new byte[]{}));
    assertEquals(-1, in.read(new byte[]{}));
  }

  /**
   * Method under test: {@link COSInputStream#getDecodeResult()}
   */
  @Test
  void testGetDecodeResult() throws IOException {
    // Arrange
    ArrayList<Filter> filters = new ArrayList<>();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = COSInputStream
        .create(filters, parameters, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), DecodeOptions.DEFAULT)
        .getDecodeResult();

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    COSDictionary parameters2 = actualDecodeResult.getParameters();
    COSUpdateState updateState = parameters2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(parameters2.getKey());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(0, parameters2.size());
    COSIncrement toIncrementResult = parameters2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(parameters2.isDirect());
    assertFalse(parameters2.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(parameters2.getValues().isEmpty());
    assertTrue(parameters2.items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }
}
