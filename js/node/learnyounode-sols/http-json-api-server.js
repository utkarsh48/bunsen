const http = require('http');
const url = require('url');

let parseTime=(d)=>{
    return {
        hour: d.getHours(),
        minute: d.getMinutes(),
        second: d.getSeconds()
    };
}

let unixTime=(d)=>{
    return {
        unixtime: d.getTime()
    };
}

http.createServer((req,res)=>{
    if(req.method==="GET"){
        let parsedUrl = url.parse(req.url,true);
        let d = new Date(parsedUrl.query.iso);
        let reg=[RegExp('^\/api\/parsetime'),RegExp('^\/api\/unixtime')];
        let results;
        if(reg[0].test(req.url)){
            results = parseTime(d);
        }
        else if(reg[1].test(req.url)){
            results = unixTime(d);
        }
        else{
            console.log(req.url);
        }
        res.end(JSON.stringify(results));
    }
    else{
        res.writeHead(404);
        res.end();
    }

}).listen(process.argv[2]);