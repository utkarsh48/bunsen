const net = require('net');

const presentTime=()=>{
    let date = new Date();
    let presentDate={
    YYYY : date.getFullYear(),
    MM : parseInt(date.getMonth())+1<10?'0'+eval(date.getMonth()+1):date.getMonth(),
    DD : date.getDate().toString().length<=1?'0'+date.getDate():date.getDate(),
    hh : date.getHours().toString().length<=1?'0'+date.getHours():date.getHours(),
    mm : date.getMinutes().toString().length<=1?'0'+date.getMinutes():date.getMinutes()
    };
    return `${presentDate.YYYY}-${presentDate.MM}-${presentDate.DD} ${presentDate.hh}:${presentDate.mm}\n`;
}


net.createServer((socket)=>{
    presentTime();
    socket.write(presentTime());
    socket.end("");
}).listen(process.argv[2]);
