const Mongoose = require("mongoose");
Mongoose.set('useNewUrlParser',true);
Mongoose.set('useUnifiedTopology',true);

Mongoose.connect("mongodb://localhost/mongo-exercises")
    .then(()=>console.log("connected to database"))
    .catch((e)=>console.error(e));

const schema = new Mongoose.Schema({
    tags:[String],
    date:Date,
    name:String,
    author:String,
    isPublished:Boolean,
    price:Number
});

const course = Mongoose.model("courses",schema);

// async function getResult(){
//     let result = await course
//         .find({isPublished: true, tags: 'backend'})
//         .sort({name: 1})
//         .select({name: 1, author: 1});
//     console.log(result);
// }

// async function getResults(){
//     let results = await course
//     .find({tags: { $in: ["frontend", "backend"]}, isPublished: true})
//     .sort({price: -1})
//     .select({name: 1, author: 1})
//     console.log(results);
// }

async function getResults(){
    let results = await course
    .find()
    .or([{name: /.*by.*/}, {isPublished: true, price: {$gte: 15}}]);
    console.log(results);
}

getResults();