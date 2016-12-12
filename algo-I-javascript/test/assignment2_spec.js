import {expect} from 'chai';
import {parseLargeIntegerSetFromDataFile} from './test_helper';
import {executeQuickSort, pivotAroundFirstElement, pivotAroundLastElement, pivotMedianOfThree} from '../assignments/assignment2';

describe('compute number of comparisons', () => {


  it('pivot around first element using simple sample', () => {
    const fullDataArray = [4, 5, 3, 1, 2];

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotAroundFirstElement);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

  it('pivot around first element using full sample', () => {
    const fullDataArray = parseLargeIntegerSetFromDataFile('./test/assignment2testData.txt');

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotAroundFirstElement);
    expect(numberOfComparisons).to.equal(162085);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

  it('pivot around last element using simple sample', () => {
    const fullDataArray = [4, 5, 3, 1, 2];

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotAroundLastElement);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

  it('pivot around last element using full sample', () => {
    const fullDataArray = parseLargeIntegerSetFromDataFile('./test/assignment2testData.txt');

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotAroundLastElement);
    expect(numberOfComparisons).to.equal(164123);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

  it('pivot around median element using simple sample', () => {
    const fullDataArray = [4, 5, 3, 1, 2];

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotMedianOfThree);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

  it('pivot around median element using medium sample', () => {
    const fullDataArray = [1, 11, 5, 15, 2, 12, 9, 99, 77, 0];

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotMedianOfThree);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

  it('pivot around median element using medium sample 2', () => {
    const fullDataArray = [1, 12, 9, 99, 0];

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotMedianOfThree);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

  it('pivot around median element using full sample', () => {
    const fullDataArray = parseLargeIntegerSetFromDataFile('./test/assignment2testData.txt');

    const numberOfComparisons = executeQuickSort(fullDataArray, pivotMedianOfThree);
    expect(numberOfComparisons).to.equal(138382);
    console.log(" sortedData = " + fullDataArray);
    console.log(" numberOfComparisons = " + numberOfComparisons);
  });

});