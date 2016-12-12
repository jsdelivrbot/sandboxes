export const executeQuickSort = function(dataToSort, pivotFunction) {
  return quickSort(dataToSort, 0, dataToSort.length - 1, pivotFunction);
};

export const quickSort = function(dataToSort, l, r, choosePivotIndex) {
  let numComparisons = 0;
  let subArrayLength = r - l + 1;

  if (subArrayLength > 1 && l < r) {
    const pivotIndex = choosePivotIndex(dataToSort, l, r);
    const partitionedPivotIndex = partition(dataToSort, pivotIndex, l, r);
    numComparisons += (subArrayLength - 1);

    // if (partitionedPivotIndex > l + 1) {
    if (l < partitionedPivotIndex - 1) {
      numComparisons += quickSort(dataToSort, l, partitionedPivotIndex - 1, choosePivotIndex);
    }

    //if (partitionedPivotIndex < r - 1) {
    if (partitionedPivotIndex < r) {
      numComparisons += quickSort(dataToSort, partitionedPivotIndex + 1, r, choosePivotIndex);
    }

  }

  return numComparisons;
};

export const pivotAroundFirstElement = function(dataToSort, l, r) {
  return l;
};

export const pivotAroundLastElement = function(dataToSort, l, r) {
  //When pivoting around the last element, we need to swap here because of the way our
  //partition subroutine is implemented.  This is because
  swap(dataToSort, l, r);
  return l;
};

export const pivotMedianOfThree = function(dataToSort, l, r) {
  let middleIndex = 0;
  let subArrayLength = r - l + 1;

  if (subArrayLength > 2) {
    //
    if (subArrayLength % 2 == 0) {
      middleIndex = (subArrayLength / 2) - 1;
    } else {
      middleIndex = Math.trunc(subArrayLength / 2);
    }
    middleIndex += l;

    if (isMedian(dataToSort, middleIndex, l, r)) {
      swap(dataToSort, middleIndex, l);
    } else if (isMedian(dataToSort, r, l, middleIndex)) {
      swap(dataToSort, r, l);
    }
  }

  if (subArrayLength == 2) {
    if (dataToSort[r] < dataToSort[l]) {
      swap(dataToSort, r, l);
    }
  }

  return l;
};


const isMedian = function(dataToSort, indexToCheck, otherIndex1, otherIndex2) {
  if ((dataToSort[indexToCheck] < dataToSort[otherIndex1] &&
      dataToSort[indexToCheck] > dataToSort[otherIndex2]) ||
    (dataToSort[indexToCheck] > dataToSort[otherIndex1] &&
      dataToSort[indexToCheck] < dataToSort[otherIndex2])) {
    return true;
  }
  return false;
};

/**
 * This implementation of the pivot function assumes that the pivot index is l.
 * @param dataToPartition
 * @param p
 * @param l
 * @param r
 * @returns {number}
 */
const partition = function(dataToPartition, p, l, r) {
  const pivotValue = dataToPartition[p];
  let i = l + 1;
  for (let j = l + 1; j <= r; j++) {
    if (dataToPartition[j] < pivotValue) {
      //if dataToPartition[j] > pivotValue, do nothing.  (If new element is greater than pivot)
      swap(dataToPartition, i, j);
      i = i + 1;
    }
  }

  swap(dataToPartition, l, i - 1);
  return i - 1;
};

/**
 *
 * @param dataToSort
 * @param firstIndex
 * @param secondIndex
 */
const swap = function(dataToSort, firstIndex, secondIndex) {
  const temp = dataToSort[firstIndex];
  dataToSort[firstIndex] = dataToSort[secondIndex];
  dataToSort[secondIndex] = temp;
};