const http = require('http');
const map = require('through2-map');

http.createServer((req,res)=>{
    if(req.method==="POST"){
        res.writeHead(200,{'Content-type': 'text/plain'});

        req.pipe(map((chunk)=>{
            return chunk.toString().toUpperCase();
        })).pipe(res);
    }
    else{
        console.log("method not post");
    }
}).listen(process.argv[2]);