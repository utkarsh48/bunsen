const fs = require('fs');

let buff = fs.readFileSync(process.argv[2]).toString();

let store = buff.split('\n');

console.log(store.length-1);