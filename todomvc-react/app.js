var express = require('express');
var port = process.env.PORT || 3000;

var app = express();

app.set("view options", {layout: false});
app.use('/', express.static(__dirname));
app.use('/bower_components',  express.static(__dirname + '/bower_components'));
app.engine('.htm', require('ejs').renderFile);

app.get('/', function(req, res) {
    res.render('index.htm');
});

app.listen(port, function() {
    console.log('Express server listening on port ' + port);
});