const fs = require('fs');
const path = require('path');

const reg = new RegExp(`${process.argv[3]}$`,"i");

fs.readdir(process.argv[2],(err,contents)=>{
    if (err) console.log("erroe occured");
    callback(contents);
})
let callback = (c)=>{
    for( let i of c){
        if(reg.test(path.extname(i))){
            console.log(i);
        }
    }
}