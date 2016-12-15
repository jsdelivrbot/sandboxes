import fs from 'fs';

export const parseLargeIntegerSetFromDataFile = function(filename) {
  const fileData = fs.readFileSync(filename, 'utf8');
  const fullDataArray = fileData.split('\r\n');

  for (let i = 0; i < fullDataArray.length; i++) {
    if (!fullDataArray[i] || fullDataArray[i].length == 0 || isNaN(fullDataArray[i])) {
      fullDataArray.splice(i, 1);
    } else {
      fullDataArray[i] = parseInt(fullDataArray[i]);
    }
  }

  return fullDataArray;
};

export const parseGraphDataFromFile = function(filename) {
  const fileData = fs.readFileSync(filename, 'utf8');
  const fullDataArray = fileData.split('\r\n');

  for (let i = 0; i < fullDataArray.length; i++) {
    if (!fullDataArray[i] || fullDataArray[i].length == 0 || isNaN(fullDataArray[i])) {
      //TODO: implement parsing of each row of graph data
      //fullDataArray.splice(i, 1);
    } else {
      //fullDataArray[i] = parseInt(fullDataArray[i]);
    }
  }

  return fullDataArray;
};