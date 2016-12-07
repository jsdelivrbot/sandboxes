import {expect} from 'chai';
import {parseLargeIntegerSetFromDataFile} from './test_helper';
import {executeQuickSort, pivotAroundFirstElement, pivotAroundLastElement, pivotMedianOfThree} from '../assignments/assignment2';

describe('compute number of comparisons', () => {

  it('pivot around first element using full sample', () => {
    const fullDataArray = parseLargeIntegerSetFromDataFile('./test/assignment2testData.txt');

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotAroundFirstElement);
    console.log("sortedData = " + fullDataArray);
    //const numInversions = calculateInversions(fullDataArray);
  });

  it('pivot around first element using simple sample', () => {
    const fullDataArray = [4, 5, 3, 1, 2];

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotAroundFirstElement);
    console.log("sortedData = " + fullDataArray);
    //const numInversions = calculateInversions(fullDataArray);
  });
});