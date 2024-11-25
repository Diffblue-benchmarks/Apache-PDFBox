package org.apache.pdfbox.cos;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.filter.Filter;
import org.apache.pdfbox.filter.JPXFilter;
import org.apache.pdfbox.filter.LZWFilter;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSOutputStreamDiffblueTest {
  /**
   * Test
   * {@link COSOutputStream#COSOutputStream(List, COSDictionary, OutputStream, RandomAccessStreamCache)}.
   * <ul>
   *   <li>Given
   * {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.</li>
   *   <li>Then calls {@link RandomAccessStreamCacheImpl#createBuffer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSOutputStream#COSOutputStream(List, COSDictionary, OutputStream, RandomAccessStreamCache)}
   */
  @Test
  @DisplayName("Test new COSOutputStream(List, COSDictionary, OutputStream, RandomAccessStreamCache); given RandomAccessReadWriteBuffer(); then calls createBuffer()")
  void testNewCOSOutputStream_givenRandomAccessReadWriteBuffer_thenCallsCreateBuffer() throws IOException {
    // Arrange
    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(new JPXFilter());
    COSDictionary parameters = new COSDictionary();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);
    RandomAccessStreamCacheImpl streamCache = mock(RandomAccessStreamCacheImpl.class);
    when(streamCache.createBuffer()).thenReturn(new RandomAccessReadWriteBuffer());

    // Act
    new COSOutputStream(filters, parameters, output, streamCache);

    // Assert
    verify(streamCache).createBuffer();
  }

  /**
   * Test {@link COSOutputStream#close()}.
   * <ul>
   *   <li>Given {@link LZWFilter}
   * {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSOutputStream#close()}
   */
  @Test
  @DisplayName("Test close(); given LZWFilter encode(InputStream, OutputStream, COSDictionary, int) does nothing; then calls encode(InputStream, OutputStream, COSDictionary, int)")
  void testClose_givenLZWFilterEncodeDoesNothing_thenCallsEncode() throws IOException {
    // Arrange
    LZWFilter lzwFilter = mock(LZWFilter.class);
    doNothing().when(lzwFilter)
        .encode(Mockito.<InputStream>any(), Mockito.<OutputStream>any(), Mockito.<COSDictionary>any(), anyInt());

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(lzwFilter);
    COSDictionary parameters = new COSDictionary();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    (new COSOutputStream(filters, parameters, output, new RandomAccessStreamCacheImpl())).close();

    // Assert
    verify(lzwFilter).encode(isA(InputStream.class), isA(OutputStream.class), isA(COSDictionary.class), eq(0));
  }
}
