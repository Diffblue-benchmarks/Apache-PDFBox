package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.filter.DecodeResult;
import org.apache.pdfbox.filter.Filter;
import org.apache.pdfbox.filter.LZWFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSInputStreamDiffblueTest {
  /**
   * Test {@link COSInputStream#create(List, COSDictionary, InputStream)} with {@code filters},
   * {@code parameters}, {@code in}.
   *
   * <p>Method under test: {@link COSInputStream#create(List, COSDictionary, InputStream)}
   */
  @Test
  @DisplayName("Test create(List, COSDictionary, InputStream) with 'filters', 'parameters', 'in'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSInputStream COSInputStream.create(List, COSDictionary, InputStream)"})
  void testCreateWithFiltersParametersIn() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filters = new ArrayList<>();

    // Act
    COSInputStream actualCreateResult = COSInputStream.create(filters, new COSDictionary(), in);

    // Assert
    byte[] byteArray = new byte[8];
    int actualReadResult = actualCreateResult.read(byteArray);
    int actualReadResult2 = in.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link COSInputStream#create(List, COSDictionary, InputStream, DecodeOptions)} with {@code
   * filters}, {@code parameters}, {@code in}, {@code options}.
   *
   * <p>Method under test: {@link COSInputStream#create(List, COSDictionary, InputStream,
   * DecodeOptions)}
   */
  @Test
  @DisplayName(
      "Test create(List, COSDictionary, InputStream, DecodeOptions) with 'filters', 'parameters', 'in', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSInputStream COSInputStream.create(List, COSDictionary, InputStream, DecodeOptions)"
  })
  void testCreateWithFiltersParametersInOptions() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filters = new ArrayList<>();

    // Act
    COSInputStream actualCreateResult =
        COSInputStream.create(filters, new COSDictionary(), in, DecodeOptions.DEFAULT);

    // Assert
    byte[] byteArray = new byte[8];
    int actualReadResult = actualCreateResult.read(byteArray);
    int actualReadResult2 = in.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link COSInputStream#create(List, COSDictionary, InputStream, DecodeOptions)} with {@code
   * filters}, {@code parameters}, {@code in}, {@code options}.
   *
   * <ul>
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSInputStream#create(List, COSDictionary, InputStream,
   * DecodeOptions)}
   */
  @Test
  @DisplayName(
      "Test create(List, COSDictionary, InputStream, DecodeOptions) with 'filters', 'parameters', 'in', 'options'; then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSInputStream COSInputStream.create(List, COSDictionary, InputStream, DecodeOptions)"
  })
  void testCreateWithFiltersParametersInOptions_thenReturnReadIsMinusOne() throws IOException {
    // Arrange
    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(new LZWFilter());
    COSDictionary parameters = new COSDictionary();
    ByteArrayInputStream in = new ByteArrayInputStream(new byte[] {});

    // Act
    COSInputStream actualCreateResult =
        COSInputStream.create(filters, parameters, in, DecodeOptions.DEFAULT);

    // Assert
    int actualReadResult = actualCreateResult.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    int actualReadResult2 = in.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
  }

  /**
   * Test {@link COSInputStream#create(List, COSDictionary, InputStream)} with {@code filters},
   * {@code parameters}, {@code in}.
   *
   * <ul>
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSInputStream#create(List, COSDictionary, InputStream)}
   */
  @Test
  @DisplayName(
      "Test create(List, COSDictionary, InputStream) with 'filters', 'parameters', 'in'; then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSInputStream COSInputStream.create(List, COSDictionary, InputStream)"})
  void testCreateWithFiltersParametersIn_thenReturnReadIsMinusOne() throws IOException {
    // Arrange
    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(new LZWFilter());
    COSDictionary parameters = new COSDictionary();
    ByteArrayInputStream in = new ByteArrayInputStream(new byte[] {});

    // Act
    COSInputStream actualCreateResult = COSInputStream.create(filters, parameters, in);

    // Assert
    int actualReadResult = actualCreateResult.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    int actualReadResult2 = in.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
  }

  /**
   * Test {@link COSInputStream#getDecodeResult()}.
   *
   * <p>Method under test: {@link COSInputStream#getDecodeResult()}
   */
  @Test
  @DisplayName("Test getDecodeResult()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult COSInputStream.getDecodeResult()"})
  void testGetDecodeResult() throws IOException {
    // Arrange
    ArrayList<Filter> filters = new ArrayList<>();
    COSDictionary parameters = new COSDictionary();

    COSInputStream createResult =
        COSInputStream.create(
            filters,
            parameters,
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
            DecodeOptions.DEFAULT);

    // Act
    DecodeResult actualDecodeResult = createResult.getDecodeResult();

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
    assertFalse(parameters2.isDirect());
    assertFalse(parameters2.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(parameters2.getValues().isEmpty());
    assertTrue(parameters2.items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
