const http = require('http');//importing http module
var server = http.createServer(function (request, response) {//function of http to create a server > function with req and res as arguments
    response.writeHead(200, {"Content-Type": "text/plain"});//writehead 1st parameter is http code like 404 2nd is optional response header
    response.end("Hello World\n"); //ends response same as response.write and after that reponse.end
});
server.listen(4000);//starts