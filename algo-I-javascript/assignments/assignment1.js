const mergeAndCountSplitInversions = function(firstHalfSorted, secondHalfSorted) {
    // console.log("enter mergeAndCountSplitInversions: firstHalfSorted = " + firstHalfSorted +
    //     " secondHalfSorted = " + secondHalfSorted);
    let sorted = [];
    let numInversions = 0;
    let i = 0;
    let j = 0;
    for (let k = 0; k < firstHalfSorted.length + secondHalfSorted.length; k++) {
        if (i >= firstHalfSorted.length) {
            sorted = sorted.concat(secondHalfSorted.slice(j));
            break;
        }
        if (j >= secondHalfSorted.length) {
            sorted = sorted.concat(firstHalfSorted.slice(i));
            break;
        }
        if (firstHalfSorted[i] < secondHalfSorted[j]) {
            sorted[k] = firstHalfSorted[i];
            i++;
        } else {
            sorted[k] = secondHalfSorted[j];
            numInversions += firstHalfSorted.length - i;
            j++;
        }
    }
    let retVal = { sortedValues: sorted, numInversions: numInversions };
    // console.log("exit mergeAndCountSplitInversions: returning sortedValues = " + retVal.sortedValues +
    //     " numInversions = " + retVal.numInversions);
    return retVal;
};

const sortAndCount = function(sourceArray) {
  // console.log("enter sourceAndCount: sourceArray = " + sourceArray);

  if (sourceArray.length <= 1) {
    return { sortedValues: sourceArray, numInversions: 0 };
  }
  let midpoint = Math.trunc(sourceArray.length / 2);
  let firstHalfSorted = sortAndCount(sourceArray.slice(0, midpoint));
  let secondHalfSorted = sortAndCount(sourceArray.slice(midpoint));
  let splitInversions = mergeAndCountSplitInversions(firstHalfSorted.sortedValues, secondHalfSorted.sortedValues);

  var retVal = { sortedValues: splitInversions.sortedValues,
    numInversions: firstHalfSorted.numInversions + secondHalfSorted.numInversions +
    splitInversions.numInversions };
  // console.log("exit sourceAndCount: returning sortedValues = " + retVal.sortedValues + " numInversions = " +
  //   retVal.numInversions);
  return retVal;
};

export const calculateInversions = function(sourceArray) {
  let result = sortAndCount(sourceArray);
  return result.numInversions;
};