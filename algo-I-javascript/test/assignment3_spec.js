import {expect} from 'chai';
import {parseGraphDataFromFile} from './test_helper';
//import {executeQuickSort, pivotAroundFirstElement, pivotAroundLastElement, pivotMedianOfThree} from '../assignments/assignment2';

describe('compute number of comparisons', () => {

  it('pivot around median element using full sample', () => {
    const fullDataArray = parseGraphDataFromFile('./test/assignment3testData.txt');

    // const numberOfComparisons = executeQuickSort(fullDataArray, pivotMedianOfThree);
    // expect(numberOfComparisons).to.equal(138382);
    // console.log(" sortedData = " + fullDataArray);
    // console.log(" numberOfComparisons = " + numberOfComparisons);
  });

});