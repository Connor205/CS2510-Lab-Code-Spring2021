package student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Heap Sort implementation
 */
public class HeapSort<T> extends SortingHeapSort<T> {

  @Override
  /* Given a list and a comparator, sort the list using heap sort.
   *
   * Modify this method to implement the heapsort algorithm.
   * @param list the list to sort
   * @param comp the comparator
   * @return the sorted list
   */
  public List<T> heapsort(List<T> list, Comparator<T> comp) {
	List<T> copyList = new ArrayList<T>(list);
	System.out.println(copyList);
	
    int len = list.size();
    
    // We want to build the heap here so we can mutate the list in place
    for  (int i = len / 2 - 1; i >= 0; i--) {
    	heapify(copyList, len, i, comp);
    }
    
    for (int i = len - 1; i > 0; i--) {
    	// We want to perform a swap here
    	T temp = copyList.get(0);
    	copyList.set(0, copyList.get(i));
    	copyList.set(i, temp);
		
		// Then we want to heapify the remaining list
		heapify(copyList, i, 0, comp);
    }
    
    for (T t : copyList) {
    	System.out.println(t);
    }
    
    return copyList; 
  }
  
  private void heapify(List<T> list, int heapSize, int targetSubHeap, Comparator<T> comp) {
	  // Set up the left and the right 
	  int largest = targetSubHeap;
	  int l = 2 * targetSubHeap + 1;
	  int r = 2 * targetSubHeap + 2;
	  
	  if (l < heapSize && comp.compare(list.get(largest), list.get(l)) < 0) {
		  largest = l;
	  }
	  
	  if (r < heapSize && comp.compare(list.get(largest), list.get(r)) < 0) {
		  largest = r;
	  }
	  
	  if (largest != targetSubHeap) {
		  // We want to perform a swap here
		  T temp = list.get(largest);
		  list.set(targetSubHeap, list.get(largest));
		  list.set(largest, temp);
		  
		  // Now we want to recur on the affected subtree
		  heapify(list, heapSize, largest, comp); 
	  }
  }
}
