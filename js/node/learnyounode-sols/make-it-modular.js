const mymodule = require('./mymodule');
const dir = process.argv[2];
const ext = process.argv[3];

let callback = (err,data)=>{
    if(err) console.log("error");
    data.forEach(element => {
        console.log(element);
    });
}

mymodule(dir, ext, callback);