const fs = require('fs');
const http = require('http');

http.createServer((req,res)=>{
    let file = fs.createReadStream(process.argv[3]);
    file.pipe(res);
}).listen(process.argv[2]);