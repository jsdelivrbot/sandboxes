import {expect} from 'chai';
import fs from 'fs';
//import {testData} from './assignment2testData';

describe('compute number of comparisons', () => {

  it('in full sample', () => {
    const fileHandle = fs.readFileSync('./test/assignment2TestData.txt', 'utf8');
    const fullDataArray = fileHandle.split('\r\n');

    //TODO: trim last \r\n and convert to numbers
    expect(fullDataArray.length).to.equal(10000);
  });
});