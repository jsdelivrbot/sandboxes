

export const quickSort = function(dataToSort, pivotFunction) {
  let numComparisons = 0;
  if (dataToSort.length > 1) {
    const pivot = pivotFunction(dataToSort);
    //partition(dataToSort, pivot, dataToSort.length - 1);
    //quickSort(firstPartOfData, pivotFunction);
    //quickSort(secondPartOfData, pivotFunction);
  }

  return numComparisons;
};

export const pivotAroundFirstElement = function(dataToSort) {
  return 0;
};

export const pivotAroundLastElement = function(dataToSort) {
  return dataToSort.length - 1;
};

export const pivotMedianOfThree = function(dataToSort) {

};

const partition = function(dataToPartition, l, r) {
  const p = dataToPartition[l];
  let i = l + 1;
  for (let j = l + 1; j < r; j++) {
    if (dataToPartition[j] < p) {
      //if dataToPartition[j] > p, do nothing.  (If new element is greater than pivot)
      //Swap dataToPartition[j] and dataToPartition[i]
      const temp = dataToPartition[i];
      dataToPartition[j] = dataToPartition[j];
      dataToPartition[i] = temp;
      i = i + 1;
    }
  }

  const temp = dataToPartition[l];
  dataToPartition[l] = dataToPartition[i - 1];
  dataToPartition[i - 1] = temp;
};