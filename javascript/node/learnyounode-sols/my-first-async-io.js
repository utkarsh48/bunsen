const fs = require('fs');

let data = fs.readFile(process.argv[2],(err,fileContents)=>{
    if(err) console.log("error");
    processing(fileContents);
})

const processing = (content)=>{
    
    console.log(content.toString().split('\n').length-1);
}