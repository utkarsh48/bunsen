const config = require('config');

const mongoose = require('mongoose');
mongoose.connect(`mongodb://${config.get('Configuration.host')}/${config.get('Configuration.database')}`, { useNewUrlParser: true,useUnifiedTopology: true } )
    .then(()=>{
        console.log("connected to mongodb......");
    })
    .catch((err)=>{
        console.error(err);
    })

    const schema = {
        name:String,
        id: Number
    }

const Model = mongoose.model("test", schema);

const obj = new Model({
    name: "Ut",
    id: 01
});

async function saveObj(obj){
    const result = await obj.save(obj);
    console.log(result);
}
saveObj(obj);