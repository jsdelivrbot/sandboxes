run npm install
run bower install 
    (if this doesn't show you any status you may need to remove bower "npm cache clean", "npm rm -g bower",  "npm install bower -g" and retry the command)
run node app.js
browse http://localhost:3000

I'd recommend installing nodemon which will monitor and restart for js changes to the app.
    npm install -g nodemon
    nodemon app.js