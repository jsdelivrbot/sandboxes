export const executeQuickSort = function(dataToSort, pivotFunction) {
  return quickSort(dataToSort, 0, dataToSort.length - 1, pivotFunction);
};

export const quickSort = function(dataToSort, l, r, choosePivotIndex) {
  let numComparisons = 0;
  if (dataToSort.length > 1) {
    const pivotIndex = choosePivotIndex(dataToSort, l, r);
    const partitionedPivotIndex = partition(dataToSort, pivotIndex, l, r);

    if (partitionedPivotIndex > l + 1) {
      quickSort(dataToSort, l, partitionedPivotIndex - 1, choosePivotIndex);
    }

    if (partitionedPivotIndex < r) {
      quickSort(dataToSort, partitionedPivotIndex + 1, r, choosePivotIndex);
    }
  }

  return numComparisons;
};

export const pivotAroundFirstElement = function(dataToSort, l, r) {
  return l;
};

export const pivotAroundLastElement = function(dataToSort, l, r) {
  return r;
};

export const pivotMedianOfThree = function(dataToSort, l, r) {

};

/**
 *
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
      //Swap dataToPartition[j] and dataToPartition[i]
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