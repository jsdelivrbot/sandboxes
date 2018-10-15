process.env.UV_THREADPOOL_SIZE = 2;
const cluster = require("cluster");

console.log("IsManager: " + cluster.isMaster);

// Is the file being executed in master mode?
if (cluster.isMaster) {
  const numChildren = 2;
  // Cause index.js to be executed *again* but in child mode
  console.log("Forking " + numChildren + " times: ");
  for (let i = 0; i < numChildren; i++) {
    cluster.fork();
  }
} else {
  // I'm a child, I'm going to act like a server and do nothing else
  const express = require("express");
  const crypto = require("crypto");
  const app = express();

  // /**
  //  * Does some busy work for the given duration in milliseconds.
  //  * @param {*} duration
  //  */
  // function doWork(duration) {
  //   const start = Date.now();
  //   while (Date.now() - start < duration) {}
  // }

  app.get('/', (req, res) => {
    crypto.pbkdf2('a', 'b', 100000, 512, 'sha512', () => {
      console.log("request completed");
      res.send('Hi there');
    });
  });

  app.get('/fast', (req, res) => {
    res.send('This was fast!');
  });

  app.listen(3000);
}

