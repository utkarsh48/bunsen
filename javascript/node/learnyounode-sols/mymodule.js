const fs = require('fs');
const path = require("path");

module.exports = (dir, ext, cb)=>{
    fs.readdir(dir,(err,content)=>{
        if (err) cb(err,null);
        else{
            let reg = new RegExp(`${ext}$`,"i");
            cb(null,content.filter((c)=>{
                return reg.test(path.extname(c));
            }));
        }
    })
}