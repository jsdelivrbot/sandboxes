

export const test = function() {
  let test2 = 5;
};

const partition = function(A, l, r) {
  const p = A[l];
  let i = l + 1;
  for (let j = l + 1; j < r; j++) {
    if (A[j] < p) {
      //if A[j] > p, do nothing.  (If new element is greater than pivot)
      //Swap A[j] and A[i]
    }
  }

  i = i + 1;
  //TODO: Swap A[l] and A[i - 1]
};