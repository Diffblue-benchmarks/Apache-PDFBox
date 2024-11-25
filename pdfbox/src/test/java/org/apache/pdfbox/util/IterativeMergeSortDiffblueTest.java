package org.apache.pdfbox.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IterativeMergeSortDiffblueTest {
  /**
   * Test {@link IterativeMergeSort#sort(List, Comparator)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>When {@link Comparator} {@link Comparator#compare(Object, Object)} return
   * minus one.</li>
   *   <li>Then calls {@link Comparator#compare(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IterativeMergeSort#sort(List, Comparator)}
   */
  @Test
  @DisplayName("Test sort(List, Comparator); given minus one; when Comparator compare(Object, Object) return minus one; then calls compare(Object, Object)")
  void testSort_givenMinusOne_whenComparatorCompareReturnMinusOne_thenCallsCompare() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");
    Comparator<Object> cmp = mock(Comparator.class);
    when(cmp.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(-1);

    // Act
    IterativeMergeSort.sort(list, cmp);

    // Assert
    verify(cmp).compare(isA(Object.class), isA(Object.class));
  }

  /**
   * Test {@link IterativeMergeSort#sort(List, Comparator)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Comparator} {@link Comparator#compare(Object, Object)} return
   * one.</li>
   *   <li>Then calls {@link Comparator#compare(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IterativeMergeSort#sort(List, Comparator)}
   */
  @Test
  @DisplayName("Test sort(List, Comparator); given one; when Comparator compare(Object, Object) return one; then calls compare(Object, Object)")
  void testSort_givenOne_whenComparatorCompareReturnOne_thenCallsCompare() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");
    Comparator<Object> cmp = mock(Comparator.class);
    when(cmp.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    // Act
    IterativeMergeSort.sort(list, cmp);

    // Assert
    verify(cmp).compare(isA(Object.class), isA(Object.class));
  }

  /**
   * Test {@link IterativeMergeSort#sort(List, Comparator)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Comparator} {@link Comparator#compare(Object, Object)} return
   * one.</li>
   *   <li>Then calls {@link Comparator#compare(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IterativeMergeSort#sort(List, Comparator)}
   */
  @Test
  @DisplayName("Test sort(List, Comparator); given one; when Comparator compare(Object, Object) return one; then calls compare(Object, Object)")
  void testSort_givenOne_whenComparatorCompareReturnOne_thenCallsCompare2() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");
    list.add("42");
    Comparator<Object> cmp = mock(Comparator.class);
    when(cmp.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    // Act
    IterativeMergeSort.sort(list, cmp);

    // Assert
    verify(cmp, atLeast(1)).compare(isA(Object.class), isA(Object.class));
  }
}
