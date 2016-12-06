import {expect} from 'chai';
import {calculateInversions} from '../assignments/assignment1';
import {parseLargeIntegerSetFromDataFile} from './test_helper';

describe('compute inversions', () => {

  it('in small sample of 10 ints', () => {
    const sample = [5, 6, 7, 8, 9, 0, 1, 2, 3, 4];
    const numInversions = calculateInversions(sample);
    expect(numInversions).to.equal(25);
  });

  it('in small sample of 10 ints 0 inversions expected', () => {
    const sample = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    const numInversions = calculateInversions(sample);
    expect(numInversions).to.equal(0);
  });

  it('in small sample of 5 ints 6 inversions expected', () => {
    const sample = [54044,14108,79294,29649,25260];
    const numInversions = calculateInversions(sample);
    expect(numInversions).to.equal(6);
  });

  it('in2 small sample of 5 ints 6 inversions expected', () => {
    const sample = [25260,60660,2995,53777,49689,9083];
    const numInversions = calculateInversions(sample);
    expect(numInversions).to.equal(9);
  });


  it('in small sample of 7 ints 13 inversions expected', () => {
    const sample = [54044,14108,79294,29649,25260,60660,2995];
    const numInversions = calculateInversions(sample);
    expect(numInversions).to.equal(13);
  });

  it('in small sample of 10 ints  inversions expected', () => {
    const sample = [54044,14108,79294,29649,25260,60660,2995,53777,49689,9083];
    const numInversions = calculateInversions(sample);
    expect(numInversions).to.equal(28);
  });

  it('in large file of 100,000 ints', () => {
    // const fileData = fs.readFileSync('./test/assignment1testData.txt', 'utf8');
    // const fullDataArray = fileData.split('\r\n');
    const fullDataArray = parseLargeIntegerSetFromDataFile('./test/assignment1testData.txt');
    const numInversions = calculateInversions(fullDataArray);
    expect(numInversions).to.equal(2407905288);
  });
});