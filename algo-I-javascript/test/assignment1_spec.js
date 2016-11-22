import {expect} from 'chai';
import {sourceData} from '../assignments/assignment1testData'
import {calculateInversions} from '../assignments/assignment1';

describe('compute inversions', () => {

    it('in small sample of 10 ints', () => {
        let sample = [5, 6, 7, 8, 9, 0, 1, 2, 3, 4];
        var numInversions = calculateInversions(sample);
        expect(numInversions).to.equal(25);
    });

    it('in small sample of 10 ints 0 inversions expected', () => {
        let sample = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
        var numInversions = calculateInversions(sample);
        expect(numInversions).to.equal(0);
    });

    it('in small sample of 5 ints 6 inversions expected', () => {
        let sample = [54044,14108,79294,29649,25260];
        var numInversions = calculateInversions(sample);
        expect(numInversions).to.equal(6);
    });

    it('in2 small sample of 5 ints 6 inversions expected', () => {
        let sample = [25260,60660,2995,53777,49689,9083];
        var numInversions = calculateInversions(sample);
        expect(numInversions).to.equal(9);
    });


    it('in small sample of 7 ints 13 inversions expected', () => {
        let sample = [54044,14108,79294,29649,25260,60660,2995];
        var numInversions = calculateInversions(sample);
        expect(numInversions).to.equal(13);
    });

    it('in small sample of 10 ints  inversions expected', () => {
        let sample = [54044,14108,79294,29649,25260,60660,2995,53777,49689,9083];
        var numInversions = calculateInversions(sample);
        expect(numInversions).to.equal(28);
    });

    it('in large file of 100,000 ints', () => {
        var numInversions = calculateInversions(sourceData);
        console.log("numInversions: " + numInversions);
    });
});