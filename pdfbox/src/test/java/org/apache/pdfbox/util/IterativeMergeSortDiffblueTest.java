package org.apache.pdfbox.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IterativeMergeSortDiffblueTest {
  /**
   * Method under test: {@link IterativeMergeSort#sort(List, Comparator)}
   */
  @Test
  void testSort() {
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
   * Method under test: {@link IterativeMergeSort#sort(List, Comparator)}
   */
  @Test
  void testSort2() {
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

  /**
   * Method under test: {@link IterativeMergeSort#sort(List, Comparator)}
   */
  @Test
  void testSort3() {
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
}
