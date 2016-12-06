import {expect} from 'chai';
import {parseLargeIntegerSetFromDataFile} from './test_helper';
import {quickSort, pivotAroundFirstElement, pivotAroundLastElement, pivotMedianOfThree} from '../assignments/assignment2';

describe('compute number of comparisons', () => {

  it('pivot around first element using full sample', () => {
    const fullDataArray = parseLargeIntegerSetFromDataFile('./test/assignment2testData.txt');

    const numberOfComparisons = quickSort(fullDataArray, pivotAroundFirstElement);
    //const numInversions = calculateInversions(fullDataArray);
  });
});